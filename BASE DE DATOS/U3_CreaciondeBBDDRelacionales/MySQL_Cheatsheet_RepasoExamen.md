# MySQL - REPASO EXAMEN (1 página)

> **TIPOS DE SENTENCIAS**

| Tipo    | Sentencias                     | Función                                                    |
|---------|--------------------------------|------------------------------------------------------------|
| **DDL** | CREATE, ALTER, DROP            | Definir estructura (bases de datos, tablas)                |
| **DML** | INSERT, UPDATE, DELETE, SELECT | Manipular datos (insertar, modificar, eliminar, consultar) |
| **DCL** | GRANT, REVOKE                  | Control de permisos y usuarios                             |

> **CONECTAR**

```sql
mysql -u usuario -p
SHOW DATABASES; USE nombre_bd; SELECT DATABASE();
```

> **TIPOS DE DATOS (LO ESENCIAL)**

| Tipo            | Uso                                     |
|-----------------|-----------------------------------------|
| INT             | IDs, números enteros                    |
| VARCHAR(n)      | Texto variable (nombres, descripciones) |
| DECIMAL(m,d)    | **Dinero/precios** (NUNCA FLOAT)        |
| DATE / DATETIME | Fechas / Fechas+hora                    |
| ENUM('a','b')   | Opciones limitadas                      |
| BOOLEAN         | 0 o 1                                   |

- Cuando se usa DECIMAL, m es el total y d los decimales, que se cuentan desde la derecha hacia la izquierda. Si se indica decimal sin d, se asume d=0 (números enteros), en el ejemplo DECIMAL(5) va de 0 a 99999.
  - Ej: DECIMAL(5,2) permite valores entre -999.99 y 999.99. Si a un decimal se le indica UNSIGNED, el rango será 0 a 999.99.

> **RESTRICCIONES CLAVE**

```sql
-- PRIMARY KEY simple
id INT PRIMARY KEY AUTO_INCREMENT      -- ID única, auto-número
-- PRIMARY KEY compuesta (dos o más columnas)
PRIMARY KEY (id_fabricante, id_regalo)
-- Restricciones básicas
nombre VARCHAR(100) NOT NULL            -- Obligatorio
email VARCHAR(100) UNIQUE               -- No repetido (permite NULL)
edad INT CHECK (edad >= 18)             -- Validación de rango
estado ENUM('Activo','Inactivo') DEFAULT 'Activo'
-- FOREIGN KEY simple
FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)
-- FOREIGN KEY con DELETE ON CASCADE (borra referencias automáticas)
FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado) ON DELETE CASCADE
-- FOREIGN KEY con ON DELETE SET NULL (pone NULL en FK al borrar padre)
FOREIGN KEY (id_jefe) REFERENCES empleados(id_empleado) ON DELETE SET NULL
```

> **CREAR / MODIFICAR / ELIMINAR**

```sql
CREATE DATABASE bd; DROP DATABASE IF EXISTS bd; USE bd;
CREATE TABLE tabla (id INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100));
ALTER TABLE tabla ADD COLUMN edad INT;
ALTER TABLE tabla DROP COLUMN edad;
ALTER TABLE tabla MODIFY nombre VARCHAR(200);
```

> **INSERTAR / ACTUALIZAR / ELIMINAR**

```sql
INSERT INTO tabla (col1, col2) VALUES ('valor1', 100);
INSERT INTO tabla VALUES ('v1', 100), ('v2', 200);   -- Múltiples
UPDATE tabla SET col1='nuevo' WHERE id=5;           -- SIEMPRE WHERE
DELETE FROM tabla WHERE id=5;                       -- SIEMPRE WHERE
```

> **SELECT (LO BÁSICO)**

```sql
SELECT * FROM tabla;                              -- Todo
SELECT col1, col2 FROM tabla WHERE condicion;     -- Filtrar
SELECT * FROM tabla ORDER BY col1 DESC LIMIT 10;  -- Ordenar + limitar
SELECT DISTINCT col1 FROM tabla;                  -- Sin duplicados
```

> **VISTAS**

```sql
CREATE VIEW v_nombre AS SELECT ... FROM tabla WHERE ...;
CREATE OR REPLACE VIEW v_nombre AS SELECT ... ;
DROP VIEW v_nombre;
```

> **ÍNDICES**

```sql
-- Crear índice simple (optimiza búsquedas)
CREATE INDEX idx_email ON usuarios(email);
-- Crear índice compuesto (en varias columnas)
CREATE INDEX idx_apellido_nombre ON empleados(apellidos, nombre);
-- Ver índices de una tabla
SHOW INDEXES FROM usuarios;
-- Eliminar índice
DROP INDEX idx_email ON usuarios;
```

> **DCL: USUARIOS, ROLES Y PERMISOS ⭐ IMPORTANTE**

```sql
-- CREAR ROLES
CREATE ROLE IF NOT EXISTS rol_alumno;
CREATE ROLE IF NOT EXISTS rol_profesor;
-- OTORGAR PERMISOS A ROLES (SELECT, INSERT, UPDATE, DELETE, ALL)
GRANT SELECT, INSERT, UPDATE ON pokedex.pokemon TO rol_profesor;
GRANT SELECT ON pokedex.v_pokemon_vistos TO rol_alumno;
GRANT ALL PRIVILEGES ON pokedex.* TO rol_supremo;
-- CREAR USUARIOS
CREATE USER IF NOT EXISTS 'usuario'@'localhost' IDENTIFIED BY 'contraseña';
CREATE USER IF NOT EXISTS 'alumno1'@'localhost' IDENTIFIED BY 'pass1';
-- ASIGNAR ROLES A USUARIOS
GRANT rol_profesor TO 'usuario'@'localhost';
GRANT rol_alumno TO 'alumno1'@'localhost';
-- ACTIVAR ROLES POR DEFECTO
ALTER USER 'usuario'@'localhost' DEFAULT ROLE rol_profesor;
ALTER USER 'alumno1'@'localhost' DEFAULT ROLE rol_alumno;
-- O también puedes usar:
SET DEFAULT ROLE rol_profesor TO 'usuario'@'localhost';
SET DEFAULT ROLE rol_alumno TO 'alumno1'@'localhost';
-- REVOCAR PERMISOS (quitar privilegios)
REVOKE INSERT ON pokedex.pokemon FROM rol_alumno;
REVOKE rol_alumno FROM 'alumno1'@'localhost';
-- ELIMINAR USUARIOS Y ROLES
DROP USER IF EXISTS 'usuario'@'localhost';
DROP ROLE IF EXISTS rol_alumno;
```

> **ERRORES FATALES**

1. **DELETE/UPDATE sin WHERE** → Borras/actualizas TODO
2. **FLOAT para dinero** → Pierdes precisión
3. **No poner IF EXISTS** → Script falla en segunda ejecución
4. **Olvidar FK en relaciones** → Integridad referencial rota
5. **Usar CHAR en lugar de VARCHAR** → Desperdicia espacio

> **ORDEN ENTREGA**

```sql
DROP DATABASE IF EXISTS bd;
CREATE DATABASE bd; USE bd;
DROP TABLE IF EXISTS tabla1;
CREATE TABLE tabla1 (...);
DROP TABLE IF EXISTS tabla2;
CREATE TABLE tabla2 (...);  -- FK después de tabla1
CREATE INDEX idx_email ON usuarios(email);
CREATE VIEW v_ejemplo AS ...;
INSERT INTO tabla1 VALUES (...);
```

> **CONSULTAS ÚTILES**

```sql
DESC tabla;                    -- Ver estructura
SHOW TABLES;                   -- Listar tablas
SHOW CREATE TABLE tabla;       -- Ver CREATE original
SHOW INDEXES FROM tabla;       -- Ver índices
SELECT DATABASE();             -- BD actual
```

> **Recuerda:** Siempre testa tus scripts ejecutándolos DOS VECES para asegurar que IF EXISTS funciona.
