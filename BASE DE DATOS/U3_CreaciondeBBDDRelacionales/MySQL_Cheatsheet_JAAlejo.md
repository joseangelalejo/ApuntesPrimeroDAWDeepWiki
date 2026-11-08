# Cheatsheet MySQL - Mis Apuntes Prácticos

Mini referencia de MySQL basada en ejercicios y apuntes de clase. No es un documento oficial, es lo que **se recomienda usar** cuando se trabaja con bases de datos.

---

## Conectar y Usar Bases de Datos

```sql
mysql -u usuario -p          -- Conectar a MySQL
SHOW DATABASES;              -- Ver qué BBDDs existen
USE nombre_base_datos;       -- Seleccionar la BBDD a usar
SELECT DATABASE();           -- Verificar en qué BBDD se está
```

**Nota importante:** Se debe hacer `USE nombre_bbdd;` primero, porque si no, los comandos CREATE TABLE fallarán.

---

## Crear y Eliminar Bases de Datos

```sql
CREATE DATABASE nombre_bd;
DROP DATABASE IF EXISTS nombre_bd;  -- Siempre con IF EXISTS para no quebrar scripts
```

La segunda es la que se debe usar en scripts SQL porque permite ejecutarlos varias veces sin errores. Es la forma correcta de hacerlo.

---

## Los Tipos de Datos Más Utilizados

**Aquí van los que se ven frecuentemente:**

### Números enteros

- **INT** → La más utilizada. Para IDs, contadores, cantidades. Rango enormeeee, así que casi siempre alcanza.
- **TINYINT** → Para booleanos (0 o 1). También se ve en tablas de elfos (Polo Norte) para el campo `jefe`.
- **SMALLINT** → Raramente se utiliza, pero existe.
- **BIGINT** → Cuando INT no es suficiente (raro, pero sucede).

### Números con decimales

- **DECIMAL(m,d)** → **IMPORTANTE:** Para dinero, precios, porcentajes. Aquí `m` es el total de dígitos y `d` cuántos son decimales. Ejemplo: `DECIMAL(8,2)` = hasta 999999.99
- **FLOAT** → No se debe usar para dinero porque pierde precisión. Mala idea.

### Texto

- **VARCHAR(n)** → La estrella. Texto variable. Se recomienda `VARCHAR(100)` para nombres, `VARCHAR(50)` para títulos cortos.
- **CHAR(n)** → Texto de longitud fija (rellena con espacios). Raramente se utiliza.
- **TEXT** → Para descripciones largas. Se pueden tener descripciones de elfos en Polo Norte.
- **ENUM('valor1', 'valor2')** → Cuando la columna solo puede tener valores específicos. En Polo Norte: `ENUM('Envolvedor', 'Fabricante', 'Supervisor', 'Ayudante', 'Reparador')`. **Ventaja:** Ocupa poco espacio.
- **SET('valor1', 'valor2')** → Como ENUM pero permite múltiples valores. En Polo Norte: categoría de regalo con `SET('Acción', 'Educativos', 'Rol y Simulación'...)`.

### Fechas

- **DATE** → Solo la fecha (YYYY-MM-DD). Cuando necesito saber el día, nada más.
- **DATETIME** → Fecha y hora juntas. Para registros de cuándo se creó algo.
- **TIMESTAMP** → Igual que DATETIME pero **se actualiza automáticamente**. Perfecto para auditoría. Se utiliza así: `TIMESTAMP DEFAULT CURRENT_TIMESTAMP`
- **YEAR** → Solo el año. Raro usarla.

### Otros

- **BOOLEAN** → Alias de TINYINT(1). Valores 0 o 1.
- **BLOB** → Imágenes, archivos binarios. No se suele utilizar en este nivel.
- **JSON** → Desde MySQL 5.7. Puedo guardar objetos JSON completos. Útil pero requiere validaciones.

---

## Restricciones: Las Reglas de Oro

### PRIMARY KEY (La ID única de cada fila)

```sql
CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100)
);
```

O si prefiero ser explícito:

```sql
CREATE TABLE empleados (
    id_empleado INT,
    nombre VARCHAR(100),
    PRIMARY KEY (id_empleado)
);
```

**Lo que necesitas saber:**

- Una tabla tiene **solo 1 PK** máximo.
- La PK es automáticamente **UNIQUE + NOT NULL**.
- `AUTO_INCREMENT` = la base de datos asigna IDs sola (1, 2, 3...). **Muy útil.**

**Trampa común:** Si se intenta hacer PK compuesta (dos columnas como clave), funciona pero es mala práctica. Se pueden tener FK compuestas en la tabla `fabricacion`, pero la PK es simple.

### NOT NULL (No puede estar vacío)

```sql
CREATE TABLE empleados (
    id_empleado INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15)  -- Este SÍ puede estar vacío
);
```

Si no especifico NOT NULL, MySQL permite NULL por defecto.

### UNIQUE (No se puede repetir, pero SÍ puede haber NULL)

```sql
CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    dni VARCHAR(9) UNIQUE NOT NULL
);
```

**Importante:** Puedo tener múltiples filas con NULL en una columna UNIQUE. MySQL no considera que dos NULLs sean iguales. Es raro pero pasa.

### FOREIGN KEY (Relaciones entre tablas)

```sql
CREATE TABLE productos (
    id_producto INT PRIMARY KEY,
    nombre VARCHAR(100),
    id_empleado INT,
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)
);
```

Esto obliga a que cualquier `id_empleado` en productos exista en empleados. **Integridad referencial.** Se debe usar en todas las relaciones.

### CHECK (Validaciones de rango)

```sql
CREATE TABLE empleados (
    salario DECIMAL(8,2) CHECK (salario > 0),
    edad INT CHECK (edad >= 18 AND edad <= 65)
);
```

**Se usa en examen:** Validar que un campo esté en cierto rango. Se ve en Pokédex (altura > 0, peso > 0).

### DEFAULT (Valor por defecto)

```sql
CREATE TABLE elfos (
    puesto ENUM('Encargado', 'Ayudante') DEFAULT 'Ayudante',
    activo BOOLEAN DEFAULT TRUE,
    registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

Si no especifico valor al insertar, MySQL usa el default. Con `CURRENT_TIMESTAMP`, guarda automáticamente la hora actual.

---

## Crear una Tabla Completa

Basándome en Polo Norte (mis elfos):

```sql
DROP TABLE IF EXISTS elfo;
CREATE TABLE elfo (
    id_elfo INT PRIMARY KEY AUTO_INCREMENT,      -- ID única, auto-incrementable
    nombre VARCHAR(75) NOT NULL,                 -- Nombre obligatorio
    puesto ENUM('Envolvedor', 'Fabricante', 'Supervisor', 'Ayudante', 'Reparador') 
           DEFAULT 'Ayudante',                   -- Selección de valores
    registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Auditoría: cuándo se creó
    jefe BOOLEAN DEFAULT FALSE                   -- Es jefe o no
);
```

**Por qué este orden:**

1. DROP IF EXISTS primero (limpia si existe)
2. CREATE TABLE
3. PK siempre en la primera columna
4. NOT NULL donde sea necesario
5. ENUM para opciones limitadas
6. TIMESTAMP para auditoría
7. DEFAULT para valores lógicos

---

## ALTER TABLE (Modificar Tablas Después de Crearlas)

Esto es lo que se hace cuando falta algo o se necesita cambiar de idea.

```sql
ALTER TABLE elfo ADD COLUMN edad INT;
ALTER TABLE elfo ADD COLUMN supervisor BOOLEAN DEFAULT FALSE;
```

**Eliminar una columna:**

```sql
ALTER TABLE elfo DROP COLUMN edad;
```

**Cambiar el tipo de dato:**

```sql
-- MODIFY: Solo cambias el tipo
ALTER TABLE elfo MODIFY COLUMN nombre VARCHAR(200) NOT NULL;

-- CHANGE: Cambias el nombre Y el tipo (más arriesgado)
ALTER TABLE elfo CHANGE COLUMN nombre nombre_elfo VARCHAR(200);
```

**Diferencia MODIFY vs CHANGE:** MODIFY es más seguro porque solo cambia el tipo. CHANGE puede romper referencias si cambias el nombre.

**Añadir restricciones después:**

```sql
ALTER TABLE elfo ADD CONSTRAINT chk_edad CHECK (edad >= 0);
ALTER TABLE elfo ADD UNIQUE (nombre);
ALTER TABLE elfo ADD FOREIGN KEY (id_jefe) REFERENCES elfo(id_elfo);
```

---

## Índices (Para Búsquedas Rápidas)

No se usan todos los días/continuamente, pero sirven para optimizar.

```sql
CREATE INDEX idx_email ON usuarios(email);     -- Búsquedas por email más rápidas
CREATE INDEX idx_nombre_apellido ON empleados(apellido, nombre); -- Índice compuesto
CREATE UNIQUE INDEX idx_dni ON empleados(dni); -- Único + indexado
```

```sql
SHOW INDEXES FROM usuarios;                    -- Ver índices de una tabla
DROP INDEX idx_email ON usuarios;              -- Eliminar índice
```

Se debe usar cuando una columna se consulta mucho. En Polo Norte probablemente se indexaría el nombre del elfo.

---

## Vistas (Tablas Virtuales para Consultas Complejas)

Se deben crear vistas para no escribir la misma consulta 100 veces.

**Vista simple:**

```sql
CREATE VIEW v_elfos_activos AS
SELECT id_elfo, nombre, puesto
FROM elfo
WHERE puesto != 'Jubilado';
```

**Vista con JOIN (Ejemplo de Polo Norte):**

```sql
CREATE VIEW v_fabricacion_detallada AS
SELECT 
    f.id_elfo,
    e.nombre as elfo,
    e.puesto,
    f.id_regalo,
    r.nombre as regalo,
    f.etapa
FROM fabricacion f
INNER JOIN elfo e ON f.id_elfo = e.id_elfo
INNER JOIN regalo r ON f.id_regalo = r.id_regalo;
```

**Actualizar una vista (si cambio la consulta):**

```sql
CREATE OR REPLACE VIEW v_elfos_activos AS
SELECT id_elfo, nombre, puesto, registro
FROM elfo
WHERE activo = TRUE;
```

**Listar vistas:**

```sql
SHOW FULL TABLES WHERE TABLE_TYPE = 'VIEW';
```

**Eliminar:**

```sql
DROP VIEW v_elfos_activos;
DROP VIEW IF EXISTS v_elfos_activos;  -- Sin error si no existe
```

---

## Insertar Datos (INSERT)

**Un registro:**

```sql
INSERT INTO empleados (nombre, cargo, salario)
VALUES ('Juan García', 'Vendedor', 2500.00);
```

**Varios de una vez:**

```sql
INSERT INTO empleados (nombre, cargo, salario) VALUES
('Juan García', 'Vendedor', 2500.00),
('María López', 'Gerente', 3500.00),
('Pedro Ruiz', 'Almacenero', 2000.00);
```

**Con AUTO_INCREMENT (no especifico el ID):**

```sql
INSERT INTO empleados (nombre, cargo, salario)
VALUES ('Rosa Martín', 'Reponedor', 1800.00);
-- La ID se asigna automáticamente
```

**Insertar desde otra tabla (Backup):**

```sql
INSERT INTO empleados_backup
SELECT * FROM empleados WHERE salario > 2500;
```

---

## Actualizar Datos (UPDATE)

**Cuidado:** Si no se añade WHERE, **se actualiza TODO.** Es un error común.

```sql
-- ¡MAL! Esto actualiza TODOS los salarios
UPDATE empleados SET salario = 3000;

-- BIEN
UPDATE empleados SET salario = 3000 WHERE id_empleado = 5;
```

**Múltiples columnas:**

```sql
UPDATE empleados 
SET salario = 3000, cargo = 'Supervisor', activo = TRUE
WHERE id_empleado = 5;
```

**Incrementar/Decrementar:**

```sql
UPDATE productos SET stock = stock - 10 WHERE id_producto = 3;
UPDATE empleados SET salario = salario * 1.10;  -- Aumento del 10%
```

**Actualizar con JOIN (Como en Pokédex):**

```sql
UPDATE pokemon p
INNER JOIN tipo t ON p.primer_tipo = t.nombre
SET p.potencia_base = p.potencia_base * 1.05
WHERE t.nombre = 'Fuego';
```

---

## Eliminar Datos (DELETE)

**Igual que UPDATE: sin WHERE se borra TODO.**

```sql
-- MAL: Borro toda la tabla
DELETE FROM empleados;

-- BIEN
DELETE FROM empleados WHERE id_empleado = 10;
```

**Eliminar múltiples:**

```sql
DELETE FROM productos 
WHERE stock = 0 AND precio < 5;
```

**Con NOT IN (elimino empleados sin productos):**

```sql
DELETE FROM empleados 
WHERE id_empleado NOT IN (SELECT id_empleado FROM productos);
```

---

## Consultar Datos (SELECT)

**Lo básico:**

```sql
SELECT * FROM empleados;                           -- Todo
SELECT nombre, salario FROM empleados;              -- Solo 2 columnas
SELECT nombre AS nombre_empleado FROM empleados;   -- Con alias
```

**Con WHERE (Filtrar):**

```sql
SELECT * FROM empleados WHERE salario > 2500;
SELECT * FROM empleados WHERE cargo = 'Vendedor' AND salario > 2000;
SELECT * FROM empleados WHERE nombre LIKE 'J%';         -- Empieza con J
SELECT * FROM empleados WHERE nombre LIKE '%García%';   -- Contiene García
SELECT * FROM empleados WHERE salario BETWEEN 2000 AND 3000;
SELECT * FROM empleados WHERE id_empleado IN (1, 3, 5);
```

**Ordenar (ORDER BY):**

```sql
SELECT * FROM empleados ORDER BY salario DESC;    -- Mayor a menor
SELECT * FROM empleados ORDER BY nombre ASC;      -- A-Z
SELECT * FROM empleados ORDER BY cargo, salario DESC;  -- Primero cargo, luego salario
```

**Sin duplicados (DISTINCT):**

```sql
SELECT DISTINCT cargo FROM empleados;   -- Solo los cargos únicos
```

**Limitado (LIMIT):**

```sql
SELECT * FROM empleados LIMIT 10;              -- Primeros 10
SELECT * FROM empleados LIMIT 5 OFFSET 10;     -- Desde el 11 al 15
SELECT * FROM empleados LIMIT 10, 5;           -- Igual que arriba (sintaxis antigua)
```

---

## JOINs (Combinar Tablas)

**INNER JOIN (solo lo que existe en ambas):**

```sql
SELECT 
    e.nombre as empleado,
    p.nombre as producto
FROM empleados e
INNER JOIN productos p ON e.id_empleado = p.id_empleado;
```

**LEFT JOIN (todos de la izquierda, aunque no tengan match):**

```sql
SELECT 
    e.nombre as empleado,
    COUNT(p.id_producto) as cantidad_productos
FROM empleados e
LEFT JOIN productos p ON e.id_empleado = p.id_empleado
GROUP BY e.id_empleado;
```

**RIGHT JOIN (todos de la derecha):**

```sql
SELECT e.nombre, p.nombre as producto
FROM empleados e
RIGHT JOIN productos p ON e.id_empleado = p.id_empleado;
```

**Múltiples JOINs (Como en Pokédex):**

```sql
SELECT 
    p.nombre as pokemon,
    t.nombre as tipo,
    m.nombre as movimiento,
    m.potencia
FROM pokemon p
INNER JOIN tipo t ON p.primer_tipo = t.nombre
INNER JOIN aprendizaje_movimiento am ON p.numero_pokedex = am.numero_pokemon
INNER JOIN movimiento m ON am.id_movimiento = m.id_movimiento;
```

---

## Agregaciones (Funciones de Grupo)

**COUNT - Contar:**

```sql
SELECT COUNT(*) FROM empleados;                      -- Total de empleados
SELECT COUNT(DISTINCT cargo) FROM empleados;         -- Cargos diferentes
SELECT COUNT(*) FROM empleados WHERE salario > 3000; -- Empleados ricos
```

**SUM - Sumar:**

```sql
SELECT SUM(salario) FROM empleados;      -- Nómina total
SELECT SUM(stock) FROM productos;        -- Inventario total
```

**AVG - Promedio:**

```sql
SELECT AVG(salario) FROM empleados;      -- Salario promedio
```

**MIN/MAX - Mínimo y máximo:**

```sql
SELECT MIN(salario), MAX(salario) FROM empleados;
SELECT MIN(precio) as mas_barato FROM productos;
```

**GROUP BY (Agrupar y contar):**

```sql
-- Cuántos empleados por cargo
SELECT cargo, COUNT(*) as cantidad
FROM empleados
GROUP BY cargo;

-- Salario promedio por cargo
SELECT cargo, AVG(salario) as salario_medio
FROM empleados
GROUP BY cargo;
```

**HAVING (Filtrar después de agrupar):**

```sql
-- Cargos con más de 2 empleados
SELECT cargo, COUNT(*) as cantidad
FROM empleados
GROUP BY cargo
HAVING COUNT(*) > 2;
```

- **Diferencia: WHERE vs HAVING**
  - WHERE filtra ANTES de agrupar
  - HAVING filtra DESPUÉS de agrupar

---

## Subconsultas

```sql
-- Empleados con salario mayor al promedio
SELECT * FROM empleados 
WHERE salario > (SELECT AVG(salario) FROM empleados);

-- Productos de empleados con cargo 'Gerente'
SELECT * FROM productos 
WHERE id_empleado IN (
    SELECT id_empleado FROM empleados WHERE cargo = 'Gerente'
);
```

---

## Funciones de Fecha

MySQL proporciona varias funciones para trabajar con fechas. Son muy útiles para auditoría, cálculos de tiempo y comparaciones de fechas.

### Obtener la fecha actual

```sql
SELECT CURDATE();           -- Fecha actual (YYYY-MM-DD)
SELECT CURTIME();           -- Hora actual (HH:MM:SS)
SELECT NOW();               -- Fecha y hora actual
SELECT CURRENT_TIMESTAMP;   -- Igual que NOW()
```

### Sumar o restar días/meses/años

```sql
-- DATE_ADD: Sumar intervalos
SELECT DATE_ADD(CURDATE(), INTERVAL 7 DAY);     -- 7 días adelante
SELECT DATE_ADD(CURDATE(), INTERVAL 1 MONTH);  -- 1 mes adelante
SELECT DATE_ADD(CURDATE(), INTERVAL 1 YEAR);   -- 1 año adelante

-- DATE_SUB: Restar intervalos
SELECT DATE_SUB(CURDATE(), INTERVAL 30 DAY);    -- 30 días atrás
SELECT DATE_SUB(CURDATE(), INTERVAL 3 MONTH);  -- 3 meses atrás
```

### Calcular diferencias entre fechas

```sql
-- DATEDIFF: Diferencia en días entre dos fechas
SELECT DATEDIFF('2026-12-25', CURDATE());  -- Días hasta Navidad
SELECT DATEDIFF(fecha_fin, fecha_inicio) FROM contratos;  -- Duración en días

-- TIMEDIFF: Diferencia en horas, minutos, segundos
SELECT TIMEDIFF('2026-02-02 18:00:00', '2026-02-02 14:30:00');  -- Resultado: 03:30:00
```

### Formatear fechas para mostrar

```sql
-- DATE_FORMAT: Mostrar fecha en formato específico
SELECT DATE_FORMAT(CURDATE(), '%d/%m/%Y');  -- 02/02/2026
SELECT DATE_FORMAT(CURDATE(), '%Y-%m-%d');  -- 2026-02-02 (ISO)
SELECT DATE_FORMAT(NOW(), '%d/%m/%Y %H:%i:%s');  -- 02/02/2026 14:30:45

-- Formatos útiles:
-- %d = día (01-31)
-- %m = mes (01-12)
-- %Y = año (4 dígitos)
-- %y = año (2 dígitos)
-- %H = hora (00-23)
-- %i = minutos (00-59)
-- %s = segundos (00-59)
```

### Extraer partes de una fecha

```sql
SELECT YEAR(fecha_registro) FROM empleados;        -- Obtener el año
SELECT MONTH(fecha_registro) FROM empleados;       -- Obtener el mes (1-12)
SELECT DAY(fecha_registro) FROM empleados;         -- Obtener el día (1-31)
SELECT HOUR(fecha_registro) FROM empleados;        -- Obtener la hora (0-23)
SELECT QUARTER(fecha_registro) FROM empleados;     -- Obtener trimestre (1-4)
```

### Ejemplo práctico

```sql
-- Empleados que se registraron en los últimos 30 días
SELECT nombre, registro
FROM empleados
WHERE registro >= DATE_SUB(CURDATE(), INTERVAL 30 DAY);

-- Contratos vencidos
SELECT nombre, fecha_fin
FROM contratos
WHERE fecha_fin < CURDATE();

-- Calcular años de antigüedad
SELECT nombre, DATE_FORMAT(registro, '%d/%m/%Y') as fecha_registro,
       FLOOR(DATEDIFF(CURDATE(), registro) / 365.25) as años_antigüedad
FROM empleados;
```

---

## CASE WHEN (Condicionales en SELECT)

**CASE WHEN** permite crear lógica condicional en tus consultas. Es útil para clasificar datos, crear categorías o asignar valores basados en condiciones.

### Sintaxis básica

```sql
SELECT 
    columna,
    CASE 
        WHEN condicion1 THEN resultado1
        WHEN condicion2 THEN resultado2
        ELSE resultado_por_defecto
    END AS alias
FROM tabla;
```

### Ejemplo simple: Categorizar salarios

```sql
SELECT nombre, salario,
    CASE 
        WHEN salario < 2000 THEN 'Bajo'
        WHEN salario >= 2000 AND salario < 3000 THEN 'Medio'
        WHEN salario >= 3000 THEN 'Alto'
    END AS categoria_salario
FROM empleados;
```

### Ejemplo con ENUM: Calificar comportamiento

```sql
SELECT nombre, comportamiento,
    CASE comportamiento
        WHEN 'Excelente' THEN 'Muy buena conducta'
        WHEN 'Bueno' THEN 'Buena conducta'
        WHEN 'Regular' THEN 'Conducta aceptable'
        WHEN 'Malo' THEN 'Problemas de conducta'
    END AS descripcion
FROM niños;
```

### Ejemplo avanzado: Contar con condicionales

```sql
-- Contar cuántos empleados hay en cada categoría
SELECT 
    COUNT(CASE WHEN salario < 2000 THEN 1 END) as empleados_bajo,
    COUNT(CASE WHEN salario >= 2000 AND salario < 3000 THEN 1 END) as empleados_medio,
    COUNT(CASE WHEN salario >= 3000 THEN 1 END) as empleados_alto
FROM empleados;
```

### Ejemplo con SUM y CASE: Calcular subtotales por categoría

```sql
-- Desglose de dinero por rango de precios
SELECT 
    SUM(CASE WHEN precio < 50 THEN precio ELSE 0 END) as total_baratos,
    SUM(CASE WHEN precio >= 50 AND precio < 100 THEN precio ELSE 0 END) as total_medios,
    SUM(CASE WHEN precio >= 100 THEN precio ELSE 0 END) as total_caros
FROM productos;
```

### Ejemplo práctico: Bonificaciones según rendimiento

```sql
SELECT nombre, salario,
    CASE 
        WHEN años_antigüedad >= 10 THEN salario * 0.20
        WHEN años_antigüedad >= 5 THEN salario * 0.10
        WHEN años_antigüedad >= 2 THEN salario * 0.05
        ELSE 0
    END AS bonificacion
FROM empleados;
```

### Diferencia entre CASE y IF (alternativa)

```sql
-- CASE WHEN (recomendado para múltiples condiciones)
SELECT CASE WHEN edad < 18 THEN 'Menor' ELSE 'Mayor' END FROM personas;

-- IF (más simple para condiciones simples)
SELECT IF(edad < 18, 'Menor', 'Mayor') FROM personas;
```

### Combinando CASE WHEN con GROUP BY

```sql
-- Agrupar por categoría de salario
SELECT 
    CASE 
        WHEN salario < 2000 THEN 'Bajo'
        WHEN salario < 3000 THEN 'Medio'
        ELSE 'Alto'
    END AS categoria,
    COUNT(*) as cantidad,
    AVG(salario) as promedio
FROM empleados
GROUP BY categoria;
```

---

## UNION (Combinar dos SELECTs)

```sql
-- Nombres de empleados Y clientes juntos
SELECT nombre FROM empleados
UNION
SELECT nombre FROM clientes;
```

Útil cuando necesito una lista única de nombres de dos tablas.

---

## Usuarios y Permisos (DCL)

**Crear usuario:**

```sql
CREATE USER 'jose'@'localhost' IDENTIFIED BY 'micontraseña';
CREATE USER 'maria'@'%' IDENTIFIED BY 'otracontraseña';  -- Acceso remoto
```

**Dar permisos:**

```sql
-- Todo sobre la BBDD tienda
GRANT ALL ON tienda.* TO 'jose'@'localhost';

-- Solo lectura
GRANT SELECT ON tienda.* TO 'maria'@'%';

-- Permisos específicos
GRANT SELECT, INSERT, UPDATE ON tienda.productos TO 'vendedor'@'localhost';
```

**Revocar permisos:**

```sql
REVOKE INSERT ON tienda.* FROM 'vendedor'@'localhost';
```

**Eliminar usuario:**

```sql
DROP USER 'jose'@'localhost';
```

---

## Comandos Útiles (Los Más Frecuentes)

```sql
SHOW DATABASES;                    -- ¿Qué BBDDs existen?
USE nombre;                        -- Entro en una BBDD
SHOW TABLES;                       -- ¿Qué tablas hay?
DESC tabla;                        -- Ver estructura de una tabla
SHOW CREATE TABLE tabla;           -- Ver el CREATE completo
SELECT DATABASE();                 -- ¿En qué BBDD estoy ahora?
SELECT USER();                     -- ¿Qué usuario soy?
```

---

## Ejemplo Completo: Base de Datos de Tienda

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
    telefono VARCHAR(15) UNIQUE,
    fecha_contratacion DATE DEFAULT CURDATE()
);

-- Tabla Productos
CREATE TABLE productos (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(8,2) NOT NULL CHECK (precio > 0),
    stock INT UNSIGNED DEFAULT 0,
    categoria ENUM('Electrónica', 'Ropa', 'Libros'),
    id_empleado INT NOT NULL,
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)
);

-- Tabla Clientes
CREATE TABLE clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(15),
    id_empleado INT,
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)
);

-- Vista útil
CREATE VIEW v_productos_disponibles AS
SELECT id_producto, nombre, precio, stock
FROM productos
WHERE stock > 0;

-- Índices para búsquedas
CREATE INDEX idx_cliente_email ON clientes(email);
CREATE INDEX idx_producto_categoria ON productos(categoria);
```

---

## Checklist: Lo que NO Olvido Nunca

- ✅ DROP IF EXISTS antes de CREATE (para poder ejecutar el script varias veces)
- ✅ PRIMARY KEY en cada tabla
- ✅ FOREIGN KEY para relaciones
- ✅ NOT NULL en datos obligatorios
- ✅ UNIQUE en campos como email, DNI
- ✅ CHECK para validar rangos
- ✅ DECIMAL para dinero (NUNCA FLOAT)
- ✅ VARCHAR para texto (no CHAR)
- ✅ AUTO_INCREMENT para IDs
- ✅ DEFAULT CURRENT_TIMESTAMP para auditoría
- ✅ ENUM para opciones limitadas
- ✅ WHERE en UPDATE y DELETE (sensei, ¡no olvides!)

---

## Errores Comunes a Evitar

1. **Olvidar WHERE en DELETE o UPDATE** → Se borra todo sin querer
2. **Usar FLOAT para dinero** → Se pierde precisión, es un error
3. **PRIMARY KEY compuesta** → Funciona pero es feo. Una columna ID es mejor
4. **No poner NOT NULL** → Aparecen NULLs inesperados
5. **Olvidar IF EXISTS** → El script falla si se ejecuta dos veces
6. **CHANGE en vez de MODIFY** → Se pueden romper FK sin querer

---

## Orden para Entregar

Cuando se entrega un ejercicio, se hace así:

1. DROP DATABASE IF EXISTS
2. CREATE DATABASE
3. USE database
4. DROP TABLE IF EXISTS (de cada tabla)
5. CREATE TABLE (primero tablas sin FK, luego las que dependen)
6. CREATE INDEX (opcional)
7. CREATE VIEW (opcional)
8. INSERT (si piden datos de ejemplo)

---

**Cheatsheet de Referencia**  
*Basado en apuntes, ejercicios y errores comunes de U3 Bases de Datos*  
*ITPFP Pablo de la Torre - 1º DAW - 2025/2026*
