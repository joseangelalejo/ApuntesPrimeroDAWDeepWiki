# 📋 MySQL Cheatsheet - Referencia Rápida

---

## ⚙️ Configuración Básica

### Conectar a MySQL

```sql
mysql -u usuario -p
```

### Listar y seleccionar bases de datos

```sql
SHOW DATABASES;
USE nombre_base_datos;
```

---

## 🗄️ DDL - Data Definition Language

### CREATE DATABASE

```sql
CREATE DATABASE nombre_bd;
DROP DATABASE IF EXISTS nombre_bd;
```

---

## 📊 Tipos de Datos

### Numéricos

| Tipo         | Rango        | Bytes    | Uso                              |
|--------------|--------------|----------|----------------------------------|
| TINYINT      | -128 a 127   | 1        | Booleanos, valores pequeños      |
| SMALLINT     | -32K a 32K   | 2        | Contadores pequeños              |
| INT          | -2.1B a 2.1B | 4        | IDs, contadores (MÁS COMÚN)      |
| BIGINT       | -9.2Q a 9.2Q | 8        | Valores muy grandes              |
| FLOAT        | ±3.4E±38     | 4        | Decimales aproximados            |
| DECIMAL(m,d) | Exacto       | Variable | **Dinero, precios, porcentajes** |

**Opciones adicionales:**

- `UNSIGNED` → Solo positivos (duplica el rango)
- `ZEROFILL` → Rellena con ceros a la izquierda

### Texto

| Tipo              | Capacidad  | Uso                               |
|-------------------|------------|-----------------------------------|
| CHAR(n)           | Hasta 255  | Longitud fija (nombres cortos)    |
| VARCHAR(n)        | Hasta 65KB | **MÁS COMÚN** (longitud variable) |
| TEXT              | Hasta 65KB | Descripciones cortas              |
| MEDIUMTEXT        | Hasta 16MB | Artículos, blogs                  |
| LONGTEXT          | Hasta 4GB  | Documentos grandes                |
| ENUM('a','b','c') | 1 valor    | Selección única                   |
| SET('a','b','c')  | Múltiples  | Selección múltiple                |

### Fecha y Hora

| Tipo      | Formato             | Comportamiento                              |
|-----------|---------------------|---------------------------------------------|
| DATE      | YYYY-MM-DD          | Solo fecha                                  |
| TIME      | HH:MM:SS            | Solo hora                                   |
| DATETIME  | YYYY-MM-DD HH:MM:SS | Fecha + hora (sin cambios automáticos)      |
| TIMESTAMP | YYYY-MM-DD HH:MM:SS | Fecha + hora (se actualiza automáticamente) |
| YEAR      | YYYY                | Solo año                                    |

### Lógicos

```sql
BOOLEAN / BOOL    -- Alias de TINYINT(1)
                  -- 0 = FALSE
                  -- 1 = TRUE
```

### Binarios

```sql
BLOB              -- Hasta 65KB
MEDIUMBLOB        -- Hasta 16MB
LONGBLOB          -- Hasta 4GB
-- Uso: Imágenes, archivos, datos en bruto
```

### JSON

- Almacena objetos y arrais JSON válidos
- Permite búsquedas internas
- Validación automática

---

## 🔐 Restricciones de Columna

### PRIMARY KEY

```sql
-- Nivel de columna
CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100)
);
```

```sql
-- Nivel de tabla
CREATE TABLE empleados (
    id_empleado INT,
    nombre VARCHAR(100),
    PRIMARY KEY (id_empleado)
);
```

```sql
-- PRIMARY KEY compuesta (no recomendable)
CREATE TABLE asignaciones (
    id_empleado INT,
    id_proyecto INT,
    PRIMARY KEY (id_empleado, id_proyecto)
);
```

### NOT NULL

```sql
CREATE TABLE empleados (
    id_empleado INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15)  -- Permite NULL
);
```

### UNIQUE

```sql
CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    nombre VARCHAR(100) UNIQUE NOT NULL
);
```

**Nota:** Múltiples NULL pueden coexistir en columnas UNIQUE.

### FOREIGN KEY

```sql
CREATE TABLE productos (
    id_producto INT PRIMARY KEY,
    nombre VARCHAR(100),
    id_empleado INT,
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)
);
```

### CHECK

```sql
CREATE TABLE empleados (
    id_empleado INT,
    salario DECIMAL(8,2) CHECK (salario > 0),
    edad INT CHECK (edad >= 18 AND edad <= 65)
);
```

### DEFAULT

```sql
CREATE TABLE elfos (
    id_elfo INT PRIMARY KEY AUTO_INCREMENT,
    puesto ENUM('Encargado', 'Ayudante') DEFAULT 'Ayudante',
    registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### AUTO_INCREMENT

```sql
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100)
);
-- Las IDs se asignan automáticamente: 1, 2, 3...
```

---

## 📝 CREATE TABLE Completa

```sql
DROP TABLE IF EXISTS productos;
CREATE TABLE productos (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    precio DECIMAL(8,2) CHECK (precio > 0),
    stock INT UNSIGNED DEFAULT 0,
    categoria ENUM('Electrónica', 'Ropa', 'Libros') NOT NULL,
    id_empleado INT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)
);
```

---

## 🔧 ALTER TABLE

### Añadir columnas

```sql
ALTER TABLE empleados ADD COLUMN edad INT;
ALTER TABLE empleados ADD COLUMN jefe BOOLEAN DEFAULT FALSE;
```

### Eliminar columnas

```sql
ALTER TABLE empleados DROP COLUMN edad;
```

### Modificar tipo de dato

```sql
-- MODIFY: Solo cambia el tipo
ALTER TABLE empleados MODIFY COLUMN nombre VARCHAR(200) NOT NULL;

-- CHANGE: Cambia nombre y tipo
ALTER TABLE empleados CHANGE COLUMN nombre nombre_completo VARCHAR(200);
```

### Añadir restricciones

```sql
ALTER TABLE empleados ADD CONSTRAINT chk_edad CHECK (edad >= 18);
ALTER TABLE empleados ADD UNIQUE (email);
ALTER TABLE productos ADD FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria);
```

### Eliminar restricciones

```sql
ALTER TABLE empleados DROP CONSTRAINT chk_edad;
ALTER TABLE empleados DROP INDEX email;
```

### Renombrar tabla

```sql
ALTER TABLE empleados RENAME TO personal;
```

---

## 🗑️ DROP

### Eliminar tabla

```sql
DROP TABLE empleados;
DROP TABLE IF EXISTS empleados;  -- Sin error si no existe
```

### Eliminar base de datos

```sql
DROP DATABASE tienda;
DROP DATABASE IF EXISTS tienda;
```

---

## 📇 ÍNDICES

### Crear índice

```sql
-- Índice simple
CREATE INDEX idx_email ON usuarios(email);

-- Índice compuesto
CREATE INDEX idx_apellido_nombre ON empleados(apellidos, nombre);

-- Índice UNIQUE
CREATE UNIQUE INDEX idx_dni ON empleados(dni);
```

### Listar índices

```sql
SHOW INDEXES FROM usuarios;
SHOW KEYS FROM usuarios;
```

### Eliminar índice

```sql
DROP INDEX idx_email ON usuarios;
```

---

## 👁️ VISTAS

### Crear vista

```sql
CREATE VIEW v_empleados_activos AS
SELECT id_empleado, nombre, departamento
FROM empleados
WHERE estado = 'Activo';
```

### Crear o reemplazar vista

```sql
CREATE OR REPLACE VIEW v_empleados_activos AS
SELECT id_empleado, nombre, departamento
FROM empleados
WHERE estado = 'Activo';
```

### Vista con JOIN

```sql
CREATE VIEW v_productos_empleado AS
SELECT 
    p.id_producto,
    p.nombre as producto,
    e.nombre as responsable,
    p.precio
FROM productos p
INNER JOIN empleados e ON p.id_empleado = e.id_empleado;
```

### Vista con agregación

```sql
CREATE VIEW v_ventas_por_empleado AS
SELECT 
    e.nombre,
    COUNT(v.id_venta) as total_ventas,
    SUM(v.monto) as monto_total
FROM empleados e
LEFT JOIN ventas v ON e.id_empleado = v.id_empleado
GROUP BY e.id_empleado, e.nombre;
```

### Listar vistas

```sql
SHOW FULL TABLES WHERE TABLE_TYPE = 'VIEW';
```

### Eliminar vista

```sql
DROP VIEW v_empleados_activos;
DROP VIEW IF EXISTS v_empleados_activos;
```

---

## 👤 DCL - Data Control Language

### Crear usuario

```sql
CREATE USER 'usuario'@'localhost' IDENTIFIED BY 'contraseña';
CREATE USER 'usuario'@'%' IDENTIFIED BY 'contraseña';  -- Acceso remoto
```

### Otorgar privilegios

```sql
-- Privilegios sobre base de datos
GRANT ALL ON base_datos.* TO 'usuario'@'localhost';
GRANT SELECT, INSERT, UPDATE ON base_datos.* TO 'usuario'@'localhost';

-- Privilegios sobre tabla específica
GRANT SELECT ON base_datos.tabla TO 'usuario'@'localhost';

-- Privilegios globales (solo admin)
GRANT ALL ON *.* TO 'admin'@'localhost';
```

### Revocar privilegios

```sql
REVOKE INSERT ON base_datos.* FROM 'usuario'@'localhost';
REVOKE ALL ON base_datos.* FROM 'usuario'@'localhost';
```

### Eliminar usuario

```sql
DROP USER 'usuario'@'localhost';
```

### Crear rol

```sql
CREATE ROLE 'rol_vendedor';
GRANT SELECT, INSERT, UPDATE ON tienda.* TO 'rol_vendedor';
GRANT 'rol_vendedor' TO 'usuario'@'localhost';
```

---

## 📥 DML - Data Manipulation Language

### INSERT - Insertar datos

**Insertar un registro:**

```sql
INSERT INTO empleados (nombre, cargo, salario)
VALUES ('Juan García', 'Vendedor', 2500.00);
```

**Insertar múltiples registros:**

```sql
INSERT INTO empleados (nombre, cargo, salario) VALUES
('Juan García', 'Vendedor', 2500.00),
('María López', 'Gerente', 3500.00),
('Pedro Ruiz', 'Almacenero', 2000.00);
```

**Insertar sin especificar columnas (todas obligatorias):**

```sql
INSERT INTO empleados VALUES (1, 'Carlos', 'Cajero', 2200.00, '123456789');
```

**Insertar desde SELECT:**

```sql
INSERT INTO empleados_backup
SELECT * FROM empleados WHERE salario > 2500;
```

**Insertar con AUTO_INCREMENT:**

```sql
-- La ID se asigna automáticamente
INSERT INTO empleados (nombre, cargo, salario)
VALUES ('Rosa Martín', 'Reponedor', 1800.00);
```

---

### UPDATE - Actualizar datos

**Actualizar todos los registros (¡CUIDADO!):**

```sql
UPDATE empleados SET salario = salario * 1.10;
```

**Actualizar registros con condición:**

```sql
UPDATE empleados 
SET salario = 2800.00 
WHERE nombre = 'Juan García';
```

**Actualizar múltiples columnas:**

```sql
UPDATE empleados 
SET salario = 3000.00, cargo = 'Supervisor' 
WHERE id_empleado = 5;
```

**Actualizar basado en otro valor:**

```sql
UPDATE productos 
SET stock = stock - 10 
WHERE id_producto = 3;
```

**Actualizar con JOIN:**

```sql
UPDATE productos p
INNER JOIN empleados e ON p.id_empleado = e.id_empleado
SET p.precio = p.precio * 1.05
WHERE e.cargo = 'Gerente';
```

---

### DELETE - Eliminar datos

**Eliminar todos los registros (¡MUY CUIDADO!):**

```sql
DELETE FROM empleados;
```

**Eliminar registros con condición:**

```sql
DELETE FROM empleados 
WHERE id_empleado = 10;
```

**Eliminar múltiples registros:**

```sql
DELETE FROM productos 
WHERE stock = 0 AND precio < 5.00;
```

**Eliminar con JOIN:**

```sql
DELETE e FROM empleados e
WHERE e.id_empleado NOT IN (
    SELECT id_empleado FROM productos
);
```

---

### SELECT - Consultar datos

**Seleccionar todas las columnas:**

```sql
SELECT * FROM empleados;
```

**Seleccionar columnas específicas:**

```sql
SELECT nombre, cargo, salario FROM empleados;
```

**Seleccionar con alias:**

```sql
SELECT 
    nombre AS nombre_empleado,
    cargo AS puesto,
    salario AS sueldo_mensual
FROM empleados;
```

**Seleccionar con WHERE (filtros):**

```sql
SELECT nombre, salario FROM empleados WHERE salario > 2500;
SELECT * FROM empleados WHERE cargo = 'Vendedor' AND salario > 2000;
SELECT * FROM empleados WHERE nombre LIKE 'J%';  -- Empieza con J
SELECT * FROM empleados WHERE salario BETWEEN 2000 AND 3000;
SELECT * FROM empleados WHERE id_empleado IN (1, 3, 5);
```

**Seleccionar con ORDER BY (ordenar):**

```sql
SELECT * FROM empleados ORDER BY salario DESC;
SELECT * FROM empleados ORDER BY nombre ASC;
SELECT * FROM empleados ORDER BY cargo, salario DESC;
```

**Seleccionar con DISTINCT (sin duplicados):**

```sql
SELECT DISTINCT cargo FROM empleados;
```

**Seleccionar con LIMIT (límite de resultados):**

```sql
SELECT * FROM empleados LIMIT 10;           -- Primeros 10
SELECT * FROM empleados LIMIT 5, 10;        -- Desde el 5 al 15
SELECT * FROM empleados LIMIT 10 OFFSET 5;  -- Desde el 5, 10 registros
```

---

### SELECT con JOIN

**INNER JOIN (solo coincidencias):**

```sql
SELECT 
    e.nombre as empleado,
    p.nombre as producto,
    p.precio
FROM empleados e
INNER JOIN productos p ON e.id_empleado = p.id_empleado;
```

**LEFT JOIN (todos de la izquierda + coincidencias):**

```sql
SELECT 
    e.nombre as empleado,
    COUNT(p.id_producto) as cantidad_productos
FROM empleados e
LEFT JOIN productos p ON e.id_empleado = p.id_empleado
GROUP BY e.id_empleado;
```

**RIGHT JOIN (todos de la derecha + coincidencias):**

```sql
SELECT 
    e.nombre,
    p.nombre as producto
FROM empleados e
RIGHT JOIN productos p ON e.id_empleado = p.id_empleado;
```

**FULL JOIN (todos de ambas tablas):**

```sql
SELECT 
    e.nombre as empleado,
    p.nombre as producto
FROM empleados e
FULL JOIN productos p ON e.id_empleado = p.id_empleado;
```

**Múltiples JOINs:**

```sql
SELECT 
    e.nombre as empleado,
    p.nombre as producto,
    c.nombre as cliente
FROM empleados e
INNER JOIN productos p ON e.id_empleado = p.id_empleado
INNER JOIN clientes c ON e.id_empleado = c.id_empleado;
```

---

### SELECT con Agregaciones

**COUNT - Contar registros:**

```sql
SELECT COUNT(*) FROM empleados;
SELECT COUNT(id_empleado) FROM empleados;
SELECT COUNT(DISTINCT cargo) FROM empleados;
```

**SUM - Sumar valores:**

```sql
SELECT SUM(salario) FROM empleados;
SELECT SUM(stock) FROM productos WHERE id_empleado = 3;
```

**AVG - Promedio:**

```sql
SELECT AVG(salario) FROM empleados;
SELECT AVG(precio) FROM productos;
```

**MIN/MAX - Mínimo y máximo:**

```sql
SELECT MIN(salario), MAX(salario) FROM empleados;
SELECT MIN(precio) as precio_mas_bajo FROM productos;
```

**GROUP BY - Agrupar:**

```sql
SELECT 
    cargo,
    COUNT(*) as cantidad,
    AVG(salario) as salario_promedio
FROM empleados
GROUP BY cargo;
```

**HAVING - Filtrar después de agrupar:**

```sql
SELECT 
    cargo,
    COUNT(*) as cantidad
FROM empleados
GROUP BY cargo
HAVING COUNT(*) > 2;
```

---

### SELECT Avanzado

**Subconsultas:**

```sql
SELECT * FROM empleados 
WHERE salario > (SELECT AVG(salario) FROM empleados);

SELECT * FROM productos 
WHERE id_empleado IN (
    SELECT id_empleado FROM empleados WHERE cargo = 'Gerente'
);
```

**UNION (combinar resultados de 2 SELECT):**

```sql
SELECT nombre FROM empleados
UNION
SELECT nombre FROM clientes;
```

**CASE (condicional):**

```sql
SELECT 
    nombre,
    salario,
    CASE 
        WHEN salario < 2000 THEN 'Bajo'
        WHEN salario BETWEEN 2000 AND 3000 THEN 'Medio'
        ELSE 'Alto'
    END as categoria_salario
FROM empleados;
```

---

## 🔍 CONSULTAS ÚTILES

### Ver estructura de tabla

```sql
DESCRIBE empleados;
DESC empleados;
SHOW COLUMNS FROM empleados;
```

### Ver información de tabla

```sql
SHOW TABLES;
SHOW TABLE STATUS;
```

### Ver definición de tabla

```sql
SHOW CREATE TABLE empleados;
```

### Ver base de datos actual

```sql
SELECT DATABASE();
```

### Ver usuario actual

```sql
SELECT USER();
```

---

## 📊 Ejemplo Práctico Completo (Tienda)

```sql
DROP DATABASE IF EXISTS tienda;
CREATE DATABASE tienda;
USE tienda;

-- Tabla Empleados
CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    cargo ENUM('Gerente', 'Vendedor', 'Almacenero') NOT NULL,
    salario DECIMAL(8,2) CHECK (salario > 0),
    telefono VARCHAR(15) UNIQUE
);

-- Tabla Productos
CREATE TABLE productos (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(8,2) NOT NULL CHECK (precio > 0),
    stock INT UNSIGNED DEFAULT 0,
    id_empleado INT NOT NULL,
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)
);

-- Tabla Clientes
CREATE TABLE clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    telefono VARCHAR(15) UNIQUE,
    id_empleado INT,
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)
);

-- Vista de Productos con Responsable
CREATE VIEW v_productos_detalle AS
SELECT 
    p.id_producto,
    p.nombre,
    p.precio,
    p.stock,
    e.nombre as responsable
FROM productos p
INNER JOIN empleados e ON p.id_empleado = e.id_empleado;

-- Índice para búsquedas rápidas
CREATE INDEX idx_producto_nombre ON productos(nombre);
CREATE INDEX idx_cliente_email ON clientes(email);
```

---

## 🎯 Checklist DDL

- ✅ DROP IF EXISTS antes de CREATE
- ✅ PRIMARY KEY en cada tabla
- ✅ FOREIGN KEY para relaciones
- ✅ NOT NULL para datos obligatorios
- ✅ UNIQUE para datos únicos
- ✅ CHECK para validar valores
- ✅ DEFAULT para valores por defecto
- ✅ AUTO_INCREMENT para IDs
- ✅ DECIMAL para dinero (no FLOAT)
- ✅ VARCHAR para texto variable (no CHAR)
- ✅ TIMESTAMP para auditoría (registro de cambios)

---

## 📞 Resumen Rápido

### DDL (Estructura)

| Operación      | Comando                                           |
|----------------|---------------------------------------------------|
| Crear BD       | `CREATE DATABASE nombre;`                         |
| Usar BD        | `USE nombre;`                                     |
| Crear tabla    | `CREATE TABLE nombre (...)`                       |
| Ver tablas     | `SHOW TABLES;`                                    |
| Ver estructura | `DESC tabla;`                                     |
| Añadir columna | `ALTER TABLE tabla ADD COLUMN ...`                |
| Eliminar tabla | `DROP TABLE tabla;`                               |
| Crear vista    | `CREATE VIEW nombre AS SELECT ...`                |
| Crear índice   | `CREATE INDEX idx ON tabla(columna);`             |

### DML (Datos)

| Operación       | Comando                                           |
|-----------------|---------------------------------------------------|
| Insertar        | `INSERT INTO tabla VALUES (...);`                 |
| Actualizar      | `UPDATE tabla SET columna = valor WHERE ...;`     |
| Eliminar        | `DELETE FROM tabla WHERE ...;`                    |
| Consultar       | `SELECT * FROM tabla WHERE ...;`                  |
| Agrupar         | `SELECT col, COUNT(*) FROM tabla GROUP BY col;`   |
| Ordenar         | `SELECT * FROM tabla ORDER BY col ASC/DESC;`      |
| Unir tablas     | `SELECT * FROM t1 INNER JOIN t2 ON t1.id=t2.id;` |

### DCL (Seguridad)

| Operación       | Comando                                           |
|-----------------|---------------------------------------------------|
| Crear usuario   | `CREATE USER 'user'@'host' IDENTIFIED BY 'pass';` |
| Dar permisos    | `GRANT ... ON ... TO 'user'@'host';`              |
| Revocar permisos| `REVOKE ... ON ... FROM 'user'@'host';`           |
| Eliminar usuario| `DROP USER 'user'@'host';`                        |

---

**Guía original:** [U3_CreaciondeBBDDRelacionales_JAAlejo.md](APUNTES/U3_CreaciondeBBDDRelacionales_JAAlejo.md)  
*Cheatsheet creado a partir de apuntes y ejercicios prácticos*
