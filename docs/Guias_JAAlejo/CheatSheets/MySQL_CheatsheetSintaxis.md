# MySQL - Cheatsheet Sintaxis

## TIPOS DE SENTENCIAS

| Tipo       | Sentencias                     | Función                        |
|------------|--------------------------------|--------------------------------|
| **🗄️ DDL** | CREATE, ALTER, DROP            | Definir estructura             |
| **📥 DML** | INSERT, UPDATE, DELETE, SELECT | Manipular datos                |
| **👤 DCL** | GRANT, REVOKE                  | Control de permisos y usuarios |

---

## CONECTAR Y BBDD

```sql
mysql -u usuario -p
SHOW DATABASES;
USE nombre_bd;
SELECT DATABASE();
```

---

## TIPOS DE DATOS

| Tipo          | Uso                                      |
|---------------|------------------------------------------|
| INT           | IDs, contadores                          |
| TINYINT       | Booleanos (0/1)                          |
| VARCHAR(n)    | Texto variable (preferir a CHAR)         |
| DECIMAL(m,d)  | Dinero (m=total dígitos, d=decimales)    |
| DATE          | Solo fecha (YYYY-MM-DD)                  |
| DATETIME      | Fecha + hora (sin actualización auto)    |
| TIMESTAMP     | Fecha + hora (actualiza automáticamente) |
| ENUM('a','b') | Selección única de opciones              |
| BOOLEAN       | Alias de TINYINT(1)                      |
| BLOB          | Imágenes/archivos binarios               |

**Importante DECIMAL:** DECIMAL(5,2) = 999.99 máximo. UNSIGNED duplica rango positivo.

---

## 🗄️ DDL - CREAR

### Bases de Datos

```sql
CREATE DATABASE nombre;
DROP DATABASE IF EXISTS nombre;
```

### Tablas

```sql
CREATE TABLE tabla (
    columna TIPO restricciones,
    ...
    PRIMARY KEY (columna),
    FOREIGN KEY (columna) REFERENCES tabla_padre(columna)
);

DROP TABLE IF EXISTS tabla;
```

---

## RESTRICCIONES

```sql
-- PRIMARY KEY simple
id INT PRIMARY KEY AUTO_INCREMENT

-- PRIMARY KEY compuesta
PRIMARY KEY (col1, col2)

-- Básicas
nombre VARCHAR(100) NOT NULL
email VARCHAR(100) UNIQUE
edad INT CHECK (edad >= 18)
estado ENUM('Activo','Inactivo') DEFAULT 'Activo'

-- FOREIGN KEY
FOREIGN KEY (id_padre) REFERENCES tabla_padre(id)

-- FK con acciones
FOREIGN KEY (id) REFERENCES tabla(id) ON DELETE CASCADE
FOREIGN KEY (id) REFERENCES tabla(id) ON DELETE SET NULL
```

---

## ALTER TABLE

```sql
-- Añadir columna
ALTER TABLE tabla ADD COLUMN edad INT;
-- Eliminar columna
ALTER TABLE tabla DROP COLUMN edad;
-- Modificar tipo (sin cambiar nombre)
ALTER TABLE tabla MODIFY COLUMN nombre VARCHAR(200) NOT NULL;
-- Cambiar nombre y tipo (arriesgado)
ALTER TABLE tabla CHANGE COLUMN nombre_viejo nombre_nuevo VARCHAR(200);
-- Añadir restricción
ALTER TABLE tabla ADD CONSTRAINT nombre_restriccion CHECK (condicion);
ALTER TABLE tabla ADD UNIQUE (columna);
ALTER TABLE tabla ADD FOREIGN KEY (columna) REFERENCES tabla_padre(columna);
-- Eliminar restricción
ALTER TABLE tabla DROP CONSTRAINT nombre_restriccion;
ALTER TABLE tabla DROP INDEX nombre_indice;
```

---

## ÍNDICES

```sql
CREATE INDEX idx_nombre ON tabla(columna);
CREATE INDEX idx_compuesto ON tabla(col1, col2);
CREATE UNIQUE INDEX idx_unico ON tabla(columna);

SHOW INDEXES FROM tabla;
DROP INDEX idx_nombre ON tabla;
```

---

## VISTAS

```sql
CREATE VIEW v_nombre AS SELECT ... FROM tabla WHERE ...;
CREATE OR REPLACE VIEW v_nombre AS SELECT ...;
DROP VIEW IF EXISTS v_nombre;

SHOW FULL TABLES WHERE TABLE_TYPE = 'VIEW';
```

---

## 📥 DML - DATOS

### INSERT

```sql
INSERT INTO tabla (col1, col2) VALUES (valor1, valor2);
INSERT INTO tabla (col1, col2) VALUES (v1, v2), (v3, v4);
INSERT INTO tabla SELECT * FROM otra_tabla WHERE condicion;
```

### UPDATE

```sql
UPDATE tabla SET col1 = valor WHERE condicion;
UPDATE tabla SET col1 = valor, col2 = valor2 WHERE condicion;
UPDATE tabla SET col = col + 10 WHERE condicion;
UPDATE t1 INNER JOIN t2 ON t1.id = t2.id SET t1.col = valor WHERE condicion;
```

**CUIDADO:** Sin WHERE se actualiza TODO.

### DELETE

```sql
DELETE FROM tabla WHERE condicion;
DELETE FROM tabla WHERE id NOT IN (SELECT id FROM otra_tabla);
```

**CUIDADO:** Sin WHERE se borra TODO.

---

## SELECT

### Básico

```sql
SELECT * FROM tabla;
SELECT col1, col2 FROM tabla;
SELECT col AS alias FROM tabla;
SELECT DISTINCT columna FROM tabla;
```

### WHERE (Filtrar)

```sql
SELECT * FROM tabla WHERE condicion;
SELECT * FROM tabla WHERE col > valor;
SELECT * FROM tabla WHERE col LIKE 'patron%';
SELECT * FROM tabla WHERE col BETWEEN valor1 AND valor2;
SELECT * FROM tabla WHERE col IN (valor1, valor2, valor3);
```

### ORDER BY (Ordenar)

```sql
SELECT * FROM tabla ORDER BY columna ASC;
SELECT * FROM tabla ORDER BY columna DESC;
SELECT * FROM tabla ORDER BY col1, col2 DESC;
```

### LIMIT (Limitar)

```sql
SELECT * FROM tabla LIMIT 10;
SELECT * FROM tabla LIMIT 5 OFFSET 10;
SELECT * FROM tabla LIMIT 10, 5;
```

### Agregaciones

```sql
COUNT(*)
COUNT(DISTINCT columna)
SUM(columna)
AVG(columna)
MIN(columna)
MAX(columna)

GROUP BY columna
HAVING condicion_agregada
```

**Diferencia:** WHERE filtra ANTES de agrupar, HAVING filtra DESPUÉS.

---

## 👤 DCL - USUARIOS Y PERMISOS

### Roles

```sql
CREATE ROLE IF NOT EXISTS nombre_rol;
DROP ROLE IF EXISTS nombre_rol;
```

### Dar Permisos

```sql
GRANT SELECT, INSERT, UPDATE ON bbdd.tabla TO rol;
GRANT SELECT ON bbdd.vista TO rol;
GRANT ALL PRIVILEGES ON bbdd.* TO rol;
```

### Usuarios

```sql
CREATE USER IF NOT EXISTS 'usuario'@'localhost' IDENTIFIED BY 'password';
DROP USER IF EXISTS 'usuario'@'localhost';
ALTER USER 'usuario'@'localhost' IDENTIFIED BY 'new_password';
```

### Asignar Roles

```sql
GRANT nombre_rol TO 'usuario'@'localhost';
REVOKE nombre_rol FROM 'usuario'@'localhost';

ALTER USER 'usuario'@'localhost' DEFAULT ROLE nombre_rol;
SET DEFAULT ROLE nombre_rol TO 'usuario'@'localhost';
```

### Revocar Permisos

```sql
REVOKE SELECT ON bbdd.tabla FROM rol;
REVOKE ALL ON bbdd.* FROM rol;
```

---

## CONSULTAS ÚTILES

```sql
DESC tabla;                  -- Ver estructura
SHOW TABLES;                 -- Listar tablas
SHOW DATABASES;              -- Listar BBDDs
SHOW CREATE TABLE tabla;     -- Ver CREATE completo
SHOW INDEXES FROM tabla;     -- Ver índices
SELECT DATABASE();           -- BBDD actual
SELECT USER();               -- Usuario actual
SELECT User, Host FROM mysql.user;  -- Ver usuarios existentes
SHOW GRANTS FOR 'usuario'@'host';   -- Ver permisos de usuario
SHOW PROCESSLIST;            -- Ver procesos/usuarios activos actualmente
SHOW FULL PROCESSLIST;       -- Ver procesos activos con más detalle
```

---

## ERRORES CRÍTICOS

1. **UPDATE/DELETE sin WHERE** → Modifica/borra TODO
2. **FLOAT para dinero** → Pierde precisión (usar DECIMAL)
3. **Olvidar IF EXISTS** → Script falla en ejecuciones siguientes
4. **Olvidar FK** → Integridad referencial rota
5. **PK compuesta innecesaria** → Mala diseño (usar PK simple + UNIQUE)

---

## 📊 DIFERENCIAS: 🗄️ DDL vs 📥 DML vs 👤 DCL

| Aspecto        | 🗄️ DDL                  | 📥 DML                 | 👤 DCL                     |
|----------------|-------------------------|------------------------|----------------------------|
| **Función**    | Definir estructura BBDD | Manipular datos        | Control de permisos        |
| **Sentencias** | CREATE, ALTER, DROP     | INSERT, UPDATE, DELETE | GRANT, REVOKE, CREATE ROLE |
| **Operación**  | Modifican esquema       | Modifican contenido    | Géstión de acceso          |
| **IF EXISTS**  | Sí (recomendado)        | Generalmente no        | No aplicable               |

---

## 📞 RESUMEN RÁPIDO

### 🗄️ DDL (Estructura) - Data Definition Language

| Operación        | Comando                                                     |
|------------------|-------------------------------------------------------------|
| Crear BD         | `CREATE DATABASE nombre;`                                   |
| Usar BD          | `USE nombre;`                                               |
| Crear tabla      | `CREATE TABLE nombre (...)`                                 |
| Ver tablas       | `SHOW TABLES;`                                              |
| Ver estructura   | `DESC tabla;`                                               |
| Añadir columna   | `ALTER TABLE tabla ADD COLUMN ...`                          |
| Eliminar tabla   | `DROP TABLE tabla;`                                         |
| PK simple        | `id INT PRIMARY KEY AUTO_INCREMENT`                         |
| PK compuesta     | `PRIMARY KEY (col1, col2)`                                  |
| FK básica        | `FOREIGN KEY (col) REFERENCES tabla(col)`                   |
| FK con ON DELETE | `FOREIGN KEY (col) REFERENCES tabla(col) ON DELETE CASCADE` |
| Crear vista      | `CREATE VIEW nombre AS SELECT ...`                          |
| Crear índice     | `CREATE INDEX idx ON tabla(columna);`                       |

### 📥 DML (Datos) - Data Manipulation Language

| Operación   | Comando                                          |
|-------------|--------------------------------------------------|
| Insertar    | `INSERT INTO tabla VALUES (...);`                |
| Actualizar  | `UPDATE tabla SET columna = valor WHERE ...;`    |
| Eliminar    | `DELETE FROM tabla WHERE ...;`                   |
| Consultar   | `SELECT * FROM tabla WHERE ...;`                 |
| Agrupar     | `SELECT col, COUNT(*) FROM tabla GROUP BY col;`  |
| Ordenar     | `SELECT * FROM tabla ORDER BY col ASC/DESC;`     |
| Unir tablas | `SELECT * FROM t1 INNER JOIN t2 ON t1.id=t2.id;` |

### 👤 DCL (Seguridad) - Data Control Language

| Operación        | Comando                                           |
|------------------|---------------------------------------------------|
| Crear rol        | `CREATE ROLE 'nombre_rol';`                       |
| Eliminar rol     | `DROP ROLE IF EXISTS 'nombre_rol';`               |
| Crear usuario    | `CREATE USER 'user'@'host' IDENTIFIED BY 'pass';` |
| Asignar rol      | `GRANT 'nombre_rol' TO 'usuario'@'host';`         |
| Remover rol      | `REVOKE 'nombre_rol' FROM 'usuario'@'host';`      |
| Dar permisos     | `GRANT ... ON ... TO 'user'@'host';`              |
| Revocar permisos | `REVOKE ... ON ... FROM 'user'@'host';`           |
| Rol por defecto  | `ALTER USER 'user'@'host' DEFAULT ROLE rol;`      |
| Eliminar usuario | `DROP USER 'user'@'host';`                        |
