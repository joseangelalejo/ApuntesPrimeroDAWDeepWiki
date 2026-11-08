-- ===== EXAMEN UNIDAD 3 - BASE DE DATOS CINE =====
-- Autor: José Ángel Alejo Sillero
-- Descripción: Base de datos para gestión de cines, salas, películas y empleados

-- ===== DDL: CREACIÓN DE BASE DE DATOS Y TABLAS =====

DROP DATABASE IF EXISTS cine_joseangelalejo;
CREATE DATABASE cine_joseangelalejo;
USE cine_joseangelalejo;

-- ===== TABLA CINES =====
/*
   Almacena los datos de los cines de la cadena
   - ID: Identificador único, auto-incrementable
   - Ubicacion: Coordenada POINT para sistema de mapas
   - Telefono: Número con extensión, opcional y puede repetirse
   - Sede: Nombre del cine, único y obligatorio
*/
DROP TABLE IF EXISTS cines;
CREATE TABLE cines (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ubicacion POINT NULL,
    telefono VARCHAR(30) NULL,
    sede VARCHAR(50) UNIQUE
);

-- ===== TABLA SALAS =====
/*
   Gestiona las salas de proyección de cada cine
   - Codigo: Identificador de sala (PK), máximo 8 caracteres
   - Zona: Tipo de sala (3D, IMAX, ESTANDAR), obligatorio, por defecto ESTANDAR
   - Cine: FK a cines, obligatorio, CASCADE al eliminar
   - Capacidad: Entre 1 y 10 espectadores, obligatorio
*/
DROP TABLE IF EXISTS salas;
CREATE TABLE salas (
    codigo VARCHAR(8) PRIMARY KEY,
    zona ENUM('3D', 'IMAX', 'ESTANDAR') NOT NULL DEFAULT 'ESTANDAR',
    cine INT NOT NULL,
    capacidad TINYINT NOT NULL CHECK (capacidad BETWEEN 1 AND 10),
    FOREIGN KEY (cine) REFERENCES cines(id) ON DELETE CASCADE
);

-- ===== TABLA EMPLEADO =====
/*
   Información de empleados de los cines
   - DNI: Documento de identidad, PK y único
   - Sede: FK a cines (id), obligatorio, SET NULL al eliminar
   - Nombre: Nombre de pila, obligatorio
   - Puesto: SET de puestos (puede tener varios simultáneamente)
   - Sueldo: Decimal para dinero, entre 1200 y 5000, obligatorio
   - Alta: Timestamp de registro, obligatorio, por defecto fecha/hora actual
*/
DROP TABLE IF EXISTS empleado;
CREATE TABLE empleado (
    dni VARCHAR(9) PRIMARY KEY,
    sede INT,
    nombre VARCHAR(50) NOT NULL,
    puesto SET('Taquillero', 'Proyeccionista', 'Gerente', 'Tecnico', 'Contable') NOT NULL,
    sueldo DECIMAL(7,2) NOT NULL CHECK (sueldo BETWEEN 1200.00 AND 5000.00),
    alta DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sede) REFERENCES cines(id) ON DELETE SET NULL
);

-- ===== TABLA PELICULA =====
/*
   Catálogo de películas disponibles
   - ID: Identificador único, auto-incrementable
   - Disponible: Indicador de disponibilidad, obligatorio, por defecto no disponible
   - Precio: Valor decimal para dinero, puede ser nulo si descatalogada
   - Restricción: máximo 30 euros
*/
DROP TABLE IF EXISTS pelicula;
CREATE TABLE pelicula (
    id INT PRIMARY KEY AUTO_INCREMENT,
    disponible BOOLEAN NOT NULL DEFAULT FALSE,
    precio DECIMAL(5,2) NULL CHECK (precio <= 30.00)
);

-- ===== TABLA CARTELERA_CINE =====
/*
   Vincula películas con cines (relación N:M)
   - Pelicula: FK a pelicula(id), CASCADE al eliminar
   - Sede: FK a cines(id), CASCADE al eliminar
   - PK compuesta: combinación única de película y cine
*/
DROP TABLE IF EXISTS cartelera_cine;
CREATE TABLE cartelera_cine (
    pelicula INT NOT NULL,
    sede INT NOT NULL,
    PRIMARY KEY (pelicula, sede),
    FOREIGN KEY (pelicula) REFERENCES pelicula(id) ON DELETE CASCADE,
    FOREIGN KEY (sede) REFERENCES cines(id) ON DELETE CASCADE
);

-- ===== MODIFICACIONES CON ALTER TABLE =====

-- Añadir columna foto a películas para almacenar imágenes
ALTER TABLE pelicula ADD COLUMN foto LONGBLOB NULL;

-- Cambiar nombre de columna 'alta' por 'comienzo' y tipo a DATETIME con timestamp
ALTER TABLE empleado CHANGE COLUMN alta comienzo DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP;

-- Restricción compleja para zonas de salas: IMAX (1-3) vs resto (1-10)
ALTER TABLE salas ADD CONSTRAINT chk_capacidad_zona CHECK (
    (zona = 'IMAX' AND capacidad BETWEEN 1 AND 3) OR
    (zona != 'IMAX' AND capacidad BETWEEN 1 AND 10)
);

-- ===== ÍNDICES PARA OPTIMIZACIÓN =====

-- Índice simple en zona para consultas frecuentes de salas por zona
CREATE INDEX idx_salas_zona ON salas(zona);

-- Índice compuesto para consultas que combinen puesto y sueldo
CREATE INDEX idx_empleados_puesto_sueldo ON empleado(puesto, sueldo);

-- ===== VISTAS =====

/*
   Vista para gerentes: muestra empleados que NO son gerentes
   Columnas: Nombre, Puesto, Sede
   Permite a gerentes ver el resto del personal
*/
CREATE OR REPLACE VIEW v_empleados_no_gerentes AS
SELECT 
    nombre,
    puesto,
    sede
FROM empleado
WHERE FIND_IN_SET('Gerente', puesto) = 0
ORDER BY nombre;

/*
   Vista para consultas de salas grandes (excepto IMAX)
   Muestra todas las salas con capacidad superior a 5, excluyendo IMAX
   Muestra: Codigo, Zona, Cine, Capacidad
*/
CREATE OR REPLACE VIEW v_salas_grandes_no_imax AS
SELECT 
    codigo,
    zona,
    cine,
    capacidad
FROM salas
WHERE capacidad > 5 AND zona != 'IMAX'
ORDER BY codigo;

-- ===== DCL: CONTROL DE ACCESO (RBAC) =====

/*
   Sistema de Control de Acceso Basado en Roles (RBAC)
   Gestiona permisos granulares para diferentes tipos de usuarios
*/

-- ===== CREACIÓN DE ROLES =====

-- Rol para Administradores: acceso total a la base de datos
CREATE ROLE IF NOT EXISTS rol_administrador;

-- Rol para Gerentes: control de películas, salas y consulta de empleados
CREATE ROLE IF NOT EXISTS rol_gerente;

-- Rol para Taquilleros: consulta de películas y cartelera
CREATE ROLE IF NOT EXISTS rol_taquillero;

-- ===== ASIGNACIÓN DE PERMISOS AL ROL ADMINISTRADOR =====
/*
   Los administradores tienen acceso completo a toda la base de datos.
   Pueden realizar cualquier operación (SELECT, INSERT, UPDATE, DELETE, CREATE, DROP).
*/
GRANT ALL PRIVILEGES ON cine_joseangelalejo.* TO rol_administrador;

-- ===== ASIGNACIÓN DE PERMISOS AL ROL GERENTE =====
/*
   Los gerentes pueden:
   - Consultar, insertar y actualizar películas y salas
   - Consultar (solo lectura) la vista de empleados no gerentes
   - Ver información de cines
*/
GRANT SELECT, INSERT, UPDATE ON cine_joseangelalejo.pelicula TO rol_gerente;
GRANT SELECT, INSERT, UPDATE ON cine_joseangelalejo.salas TO rol_gerente;
GRANT SELECT ON cine_joseangelalejo.v_empleados_no_gerentes TO rol_gerente;
GRANT SELECT ON cine_joseangelalejo.cines TO rol_gerente;

-- ===== ASIGNACIÓN DE PERMISOS AL ROL TAQUILLERO =====
/*
   Los taquilleros pueden:
   - Consultar películas y cartelera (información de películas disponibles)
   - Consultar cines y salas (ubicaciones y horarios)
   - Consultar la vista de salas grandes
*/
GRANT SELECT ON cine_joseangelalejo.pelicula TO rol_taquillero;
GRANT SELECT ON cine_joseangelalejo.cartelera_cine TO rol_taquillero;
GRANT SELECT ON cine_joseangelalejo.cines TO rol_taquillero;
GRANT SELECT ON cine_joseangelalejo.salas TO rol_taquillero;
GRANT SELECT ON cine_joseangelalejo.v_salas_grandes_no_imax TO rol_taquillero;

-- ===== CREACIÓN DE USUARIOS ADMINISTRADOR =====

-- Usuario Administrador 1
CREATE USER IF NOT EXISTS 'admin_sistemasI'@'localhost' IDENTIFIED BY 'admin_pass2026';
GRANT rol_administrador TO 'admin_sistemasI'@'localhost';
ALTER USER 'admin_sistemasI'@'localhost' DEFAULT ROLE rol_administrador;

-- Usuario Administrador 2
CREATE USER IF NOT EXISTS 'admin_sistemasII'@'localhost' IDENTIFIED BY 'admin_pass2026';
GRANT rol_administrador TO 'admin_sistemasII'@'localhost';
ALTER USER 'admin_sistemasII'@'localhost' DEFAULT ROLE rol_administrador;

-- ===== CREACIÓN DE USUARIOS GERENTE =====

-- Usuario Gerente 1
CREATE USER IF NOT EXISTS 'gerente_madrid'@'localhost' IDENTIFIED BY 'gerente_pass2026';
GRANT rol_gerente TO 'gerente_madrid'@'localhost';
-- ALTER USER 'gerente_madrid'@'localhost' DEFAULT ROLE rol_gerente;
SET DEFAULT ROLE rol_gerente TO 'gerente_madrid'@'localhost';

/* Anotación POST-EXAMEN
En clase al usar durante el examen SET DEFAULT para la activación de rol me estaba dando un error de sintaxis, y MySQL Workbench me indicaba
   que revisara la sintaxis de mi versión de mysql. AL probar con ALTER USER si funcionaba correctamente, así que lo dejé así en el examen.
   1. Ya en casa, al probar de nuevo con SET DEFAULT ROLE tanto en VSCode Studio como en MySQL Workbench, he comprobado que funciona correctamente.
   Algo está generando ese error en el entorno de examen que no he podido replicar fuera, a pesar de ser misma versión de IDEs y MySQL Workbench.
   Igualmente, la versión de los IDEs no debería afectar, ya que es un comando SQL del propio servidor MySQL, y todas las sentencias y scripts las ejecuto
      en mi servidor MySQL 8.0.33 que tengo en un contenedor docker con la imagen oficial de mysql para mysql 8.0.33 (estable) dentro de una máquina virtual de docker.
   2. Cabe destacar que durante la noche anterior al examen, practicando de cara al mismo no daba error ni con ALTER USER ni con SET DEFAULT ROLE, ambos funcionaban correctamente.
   3. Por tanto, dejo la anotación aquí para que se tenga en cuenta este detalle, ya que algo genera ese error, y queda pendiente de hacer pruebas y documentar la causa por mi parte.
   - DONE: Investigar causa del error de sintaxis con SET DEFAULT ROLE en entorno de examen.

   Tras hacer pruebas en otros dispositivos tanto el mismo día como al día siguiente de la realización del examen ya no se producen errores, ni en VSCode ni en MySQL Workbench
*/

-- Usuario Gerente 2
CREATE USER IF NOT EXISTS 'gerente_sevilla'@'localhost' IDENTIFIED BY 'gerente_pass2026';
GRANT rol_gerente TO 'gerente_sevilla'@'localhost';
ALTER USER 'gerente_sevilla'@'localhost' DEFAULT ROLE rol_gerente;

-- ===== CREACIÓN DE USUARIOS TAQUILLERO =====

-- Usuario Taquillero 1
CREATE USER IF NOT EXISTS 'taquillero_juan'@'localhost' IDENTIFIED BY 'taquillero_pass2026';
GRANT rol_taquillero TO 'taquillero_juan'@'localhost';
ALTER USER 'taquillero_juan'@'localhost' DEFAULT ROLE rol_taquillero;

-- Usuario Taquillero 2
CREATE USER IF NOT EXISTS 'taquillero_maria'@'localhost' IDENTIFIED BY 'taquillero_pass2026';
GRANT rol_taquillero TO 'taquillero_maria'@'localhost';
ALTER USER 'taquillero_maria'@'localhost' DEFAULT ROLE rol_taquillero;

-- Aplicar cambios inmediatos
FLUSH PRIVILEGES;

/*
   Comandos útiles para inspeccionar la base de datos después de ejecutar el script:
   
   DESC tabla;                    -- Ver estructura de una tabla
   SHOW TABLES;                   -- Listar todas las tablas
   SHOW CREATE TABLE tabla;       -- Ver el CREATE original
   SHOW INDEXES FROM tabla;       -- Ver todos los índices
   SELECT DATABASE();             -- Mostrar BD actual
   SHOW ROLES;                    -- Ver todos los roles creados
   SHOW GRANTS FOR 'usuario'@'localhost';  -- Ver permisos asignados a un usuario
*/

-- ===== FIN DEL SCRIPT =====