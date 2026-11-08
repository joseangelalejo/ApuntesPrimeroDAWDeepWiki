-- == SIMULACRO PRÁCTICO 2 - EXAMEN TEMA 3 ==
-- Autor: José Ángel Alejo Sillero
-- Descripción: Base de datos para franquicia de restaurantes con gestión de mesas, empleados y cartas

/*
   PREMISA / REQUISITOS:
   
   Se requiere crear una base de datos de una franquicia de restaurantes con:
   - Gestión de locales/restaurantes con ubicación y teléfono
   - Mesas organizadas por zonas (Terraza, Sala, Barra) con capacidades limitadas
   - Empleados con múltiples puestos simultáneos
   - Platos con precio y disponibilidad
   - Cartas de restaurante vinculadas a platos
   
   Requisitos adicionales:
   - Índices para optimización de consultas
   - Vistas para encargados y clientes
   - Restricciones complejas según zona de mesa
   - Control de acceso basado en roles (Administrador, Gerente, Cliente)
*/

-- == DDL: CREACIÓN DE BASE DE DATOS Y TABLAS ==

DROP DATABASE IF EXISTS restaurantes_jaalejo;
CREATE DATABASE restaurantes_jaalejo;
USE restaurantes_jaalejo;

-- == TABLA RESTAURANTES ==
/* 
   Almacena los datos de los locales/restaurantes de la franquicia
   - ID: Identificador único, auto-incrementable
   - Local: Nombre del restaurante, único y obligatorio
   - Ubicación: Coordenada POINT para el sistema de mapas, única pero puede ser nula
   - Teléfono: Número con prefijo, opcional y puede repetirse
*/
DROP TABLE IF EXISTS restaurantes;
CREATE TABLE restaurantes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    local VARCHAR(100) NOT NULL UNIQUE,
    ubicacion POINT NULL UNIQUE,
    telefono VARCHAR(20) NULL
);

-- == TABLA MESAS ==
/*
   Gestiona las mesas de cada restaurante
   - Código: Identificador de mesa (ej: "A1", "B3")
   - Restaurante: FK a restaurantes, obligatorio, CASCADE al eliminar
   - Capacidad: Entre 1 y 10 personas, obligatorio
   - Zona: Enumeración de zonas posibles, por defecto Sala
*/
DROP TABLE IF EXISTS mesas;
CREATE TABLE mesas (
    codigo VARCHAR(20) PRIMARY KEY,
    restaurante INT NOT NULL,
    capacidad INT NOT NULL CHECK (capacidad BETWEEN 1 AND 10),
    zona ENUM('Terraza', 'Sala', 'Barra') NOT NULL DEFAULT 'Sala',
    FOREIGN KEY (restaurante) REFERENCES restaurantes(id) ON DELETE CASCADE
);

-- == TABLA EMPLEADOS ==
/*
   Información de empleados de los restaurantes
   - DNI: Documento de identidad, PK y único
   - Local: FK a restaurantes, obligatorio, SET NULL al eliminar restaurante
   - Nombre: Nombre de pila, obligatorio
   - Puesto: SET de puestos (puede tener varios simultáneamente)
   - Alta: Fecha de incorporación, obligatorio, por defecto fecha actual
   - Sueldo: Decimal para dinero, entre 1200 y 4000, obligatorio
*/
DROP TABLE IF EXISTS empleados;
CREATE TABLE empleados (
    dni VARCHAR(9) PRIMARY KEY,
    local INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    puesto SET('Camarero', 'Cocinero', 'Encargado', 'Chef', 'Contable') NOT NULL,
    alta DATE NOT NULL DEFAULT CURRENT_DATE,
    sueldo DECIMAL(6,2) NOT NULL CHECK (sueldo BETWEEN 1200 AND 4000),
    FOREIGN KEY (local) REFERENCES restaurantes(id) ON DELETE SET NULL
);

-- == TABLA PLATOS ==
/*
   Catálogo de platos disponibles
   - ID: Identificador único, auto-incrementable
   - Precio: Valor decimal para dinero, puede ser nulo si descatalogado
   - Disponible: Indicador de disponibilidad, obligatorio, por defecto no disponible
*/
DROP TABLE IF EXISTS platos;
CREATE TABLE platos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    precio DECIMAL(8,2) NULL,
    disponible BOOLEAN NOT NULL DEFAULT FALSE
);

-- == TABLA CARTA_RESTAURANTE ==
/*
   Vincula platos con restaurantes (relación N:M)
   - Plato: FK a platos, CASCADE al eliminar
   - Local: FK a restaurantes, CASCADE al eliminar
   - PK compuesta: combinación única de plato y local
*/
DROP TABLE IF EXISTS carta_restaurante;
CREATE TABLE carta_restaurante (
    plato INT NOT NULL,
    local INT NOT NULL,
    FOREIGN KEY (plato) REFERENCES platos(id) ON DELETE CASCADE,
    FOREIGN KEY (local) REFERENCES restaurantes(id) ON DELETE CASCADE
);

-- == MODIFICACIONES CON ALTER TABLE ==

-- Añadir columna foto a platos para almacenar imágenes
ALTER TABLE platos ADD COLUMN foto LONGBLOB NULL;

-- Agregar PK compuesta a carta_restaurante (se olvidó en creación)
ALTER TABLE carta_restaurante ADD PRIMARY KEY (plato, local);

-- Cambiar nombre de columna Alta por Comienzo y cambiar tipo a DATETIME con timestamp
ALTER TABLE empleados CHANGE COLUMN alta comienzo DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP;

-- Restricción compleja para zonas de mesas: Barra (1-3) vs resto (1-10)
ALTER TABLE mesas ADD CONSTRAINT chk_capacidad_zona CHECK (
    (zona = 'Barra' AND capacidad BETWEEN 1 AND 3) OR
    (zona != 'Barra' AND capacidad BETWEEN 1 AND 10)
);

-- == ÍNDICES PARA OPTIMIZACIÓN ==

-- Índice simple en zona para consultas frecuentes de mesas por zona
CREATE INDEX idx_mesas_zona ON mesas(zona);

-- Índice compuesto para consultas que combinen puesto y sueldo
CREATE INDEX idx_empleados_puesto_sueldo ON empleados(puesto(10), sueldo);

-- == VISTAS ==

/*
   Vista para encargados: muestra empleados que NO son encargados
   Columnas: Nombre, Puesto, Local
*/
CREATE OR REPLACE VIEW v_empleados_no_encargados AS
SELECT 
    nombre,
    puesto,
    local
FROM empleados
WHERE FIND_IN_SET('Encargado', puesto) = 0
ORDER BY nombre;

/*
   Vista para clientes: mesas grandes (capacidad > 5) excepto barra
   Muestra al menos el código de mesa
*/
CREATE OR REPLACE VIEW v_mesas_grandes AS
SELECT 
    codigo,
    restaurante,
    capacidad,
    zona
FROM mesas
WHERE capacidad > 5 AND zona != 'Barra'
ORDER BY codigo;

-- == DCL: CONTROL DE ACCESO (USUARIOS Y ROLES) ==

-- == CREACIÓN DE ROLES ==

CREATE ROLE IF NOT EXISTS rol_administrador;
CREATE ROLE IF NOT EXISTS rol_gerente;
CREATE ROLE IF NOT EXISTS rol_cliente;

-- == ASIGNACIÓN DE PERMISOS AL ROL ADMINISTRADOR ==
/* 
   Administrador: acceso total a todas las tablas y vistas
   - Todos los privilegios (SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, etc.)
*/

GRANT ALL PRIVILEGES ON restaurantes_jaalejo.* TO rol_administrador;

-- == ASIGNACIÓN DE PERMISOS AL ROL GERENTE ==
/*
   Gerente: gestión de platos y mesas, solo consulta de empleados
   - SELECT, INSERT, UPDATE, DELETE en platos y mesas
   - SELECT en empleados (solo lectura)
*/

GRANT SELECT, INSERT, UPDATE, DELETE ON restaurantes_jaalejo.platos TO rol_gerente;
GRANT SELECT, INSERT, UPDATE, DELETE ON restaurantes_jaalejo.mesas TO rol_gerente;
GRANT SELECT ON restaurantes_jaalejo.empleados TO rol_gerente;

-- == ASIGNACIÓN DE PERMISOS AL ROL CLIENTE ==
/*
   Cliente: solo consultas de catálogo y consulta de mesas disponibles
   - SELECT en platos y restaurantes
   - SELECT en vista de mesas grandes
*/

GRANT SELECT ON restaurantes_jaalejo.platos TO rol_cliente;
GRANT SELECT ON restaurantes_jaalejo.restaurantes TO rol_cliente;
GRANT SELECT ON restaurantes_jaalejo.v_mesas_grandes TO rol_cliente;

-- == CREACIÓN DE USUARIOS ==

-- Usuarios con rol Administrador
CREATE USER IF NOT EXISTS 'admin_1'@'localhost' IDENTIFIED BY 'admin_pass_1_2024';
CREATE USER IF NOT EXISTS 'admin_2'@'localhost' IDENTIFIED BY 'admin_pass_2_2024';

-- Usuarios con rol Gerente
CREATE USER IF NOT EXISTS 'gerente_1'@'localhost' IDENTIFIED BY 'gerente_pass_1_2024';
CREATE USER IF NOT EXISTS 'gerente_2'@'localhost' IDENTIFIED BY 'gerente_pass_2_2024';

-- Usuarios con rol Cliente
CREATE USER IF NOT EXISTS 'cliente_1'@'localhost' IDENTIFIED BY 'cliente_pass_1_2024';
CREATE USER IF NOT EXISTS 'cliente_2'@'localhost' IDENTIFIED BY 'cliente_pass_2_2024';

-- == ASIGNACIÓN DE ROLES A USUARIOS ==

-- Asignar rol Administrador
GRANT rol_administrador TO 'admin_1'@'localhost';
GRANT rol_administrador TO 'admin_2'@'localhost';

-- Asignar rol Gerente
GRANT rol_gerente TO 'gerente_1'@'localhost';
GRANT rol_gerente TO 'gerente_2'@'localhost';

-- Asignar rol Cliente
GRANT rol_cliente TO 'cliente_1'@'localhost';
GRANT rol_cliente TO 'cliente_2'@'localhost';

-- == ACTIVACIÓN DE ROLES POR DEFECTO ==

ALTER USER 'admin_1'@'localhost' DEFAULT ROLE rol_administrador;
ALTER USER 'admin_2'@'localhost' DEFAULT ROLE rol_administrador;
ALTER USER 'gerente_1'@'localhost' DEFAULT ROLE rol_gerente;
ALTER USER 'gerente_2'@'localhost' DEFAULT ROLE rol_gerente;
ALTER USER 'cliente_1'@'localhost' DEFAULT ROLE rol_cliente;
ALTER USER 'cliente_2'@'localhost' DEFAULT ROLE rol_cliente;

-- == APLICAR CAMBIOS ==

FLUSH PRIVILEGES;

-- == COMANDOS ÚTILES PARA VERIFICACIÓN ==

/*
   Comandos útiles para inspeccionar la base de datos después de ejecutar el script:
   
   DESC tabla;                    -- Ver estructura de una tabla
   SHOW TABLES;                   -- Listar todas las tablas de la BD actual
   SHOW CREATE TABLE tabla;       -- Ver el CREATE original de una tabla
   SHOW INDEXES FROM tabla;       -- Ver todos los índices de una tabla
   SELECT DATABASE();             -- Mostrar la BD actual en uso
   
   Ejemplo de uso:
   - DESC restaurantes;
   - SHOW INDEXES FROM mesas;
   - SHOW CREATE TABLE empleados;
*/

-- == FIN DEL SCRIPT ==
