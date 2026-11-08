# Unidad 5 - Programación de Bases de Datos
---

## 1. Introducción y contexto

SQL es un lenguaje **declarativo**: dices *qué* quieres, no *cómo* obtenerlo. Eso funciona bien para consultas simples, pero cuando necesitas lógica compleja (bucles, condiciones, variables) necesitas combinar SQL con un **lenguaje procedimental**.

| Generación | Ejemplo         | Características                               |
|------------|-----------------|-----------------------------------------------|
| 1ª         | Código máquina  | Binario, específico de hardware               |
| 2ª         | Ensamblador     | Mnemónicos, requiere ensamblador              |
| 3ª         | Java, C, Python | Abstracción, portable, estructuras de control |

MySQL usa **SQL/PSM** (SQL Persistent Stored Modules), su propia variante procedimental. Oracle usa PL/SQL, PostgreSQL usa PL/pgSQL.

> **Por qué usarlo:** almacenar la lógica de negocio en el motor evita tráfico de red repetitivo y centraliza las reglas en un solo sitio.

---

## 2. Fundamentos de sintaxis

### 2.1 DELIMITER

MySQL interpreta `;` como fin de sentencia. En bloques con múltiples instrucciones hay que cambiar el delimitador temporalmente para que el motor compile el bloque entero de una vez.

```sql
DELIMITER //

-- tu bloque aquí

//
DELIMITER ;
```

Puedes usar cualquier símbolo que no colisione: `//`, `$$`, `;;`...

### 2.2 BEGIN ... END

Agrupa múltiples instrucciones en un bloque. Obligatorio cuando el cuerpo del procedimiento/función/trigger tiene más de una sentencia. Se pueden anidar.

```sql
BEGIN
    -- instrucciones
    BEGIN
        -- bloque anidado
    END;
END
```

### 2.3 Variables

Hay dos tipos:

| Tipo           | Declaración                          | Ámbito                 |
|----------------|--------------------------------------|------------------------|
| **Local**      | `DECLARE nombre tipo DEFAULT valor;` | Solo dentro del bloque |
| **De usuario** | `SET @nombre = valor;`               | Sesión completa        |

```sql
-- Variable local (dentro de procedimiento/función)
DECLARE total DECIMAL(10,2) DEFAULT 0.0;
SET total = 150.25;
SELECT SUM(total) INTO total FROM pago WHERE codigo_cliente = 1;

-- Variable de usuario (fuera o dentro)
SET @resultado = 0;
CALL mi_procedimiento(@resultado);
SELECT @resultado;
```

> Las variables locales se declaran **siempre al principio** del bloque BEGIN...END, antes de cualquier otra instrucción.

---

## 3. Procedimientos almacenados

Un procedimiento es un **bloque de código nombrado** que se guarda en el servidor y se ejecuta con `CALL`. Útil para operaciones DML (INSERT, UPDATE, DELETE) y lógica de negocio compleja.

```sql
DELIMITER //
CREATE PROCEDURE nombre_procedimiento(parámetros)
BEGIN
    -- instrucciones
END //
DELIMITER ;

-- Llamada:
CALL nombre_procedimiento(valores);
```

### 3.1 Tipos de parámetros

| Tipo    | Descripción                                                | Equivalente         |
|---------|------------------------------------------------------------|---------------------|
| `IN`    | Recibe valor de entrada. Modificaciones internas no salen. | Paso por valor      |
| `OUT`   | No recibe datos. Solo devuelve un valor al final.          | Paso por referencia |
| `INOUT` | Recibe valor Y lo devuelve modificado.                     | Mixto               |

```sql
-- OUT: devuelve la edad en días
DELIMITER //
CREATE PROCEDURE calculadora_edad(IN fecha_nacimiento DATE, OUT edad INT)
BEGIN
    SET edad = TIMESTAMPDIFF(DAY, fecha_nacimiento, CURRENT_DATE());
END //
DELIMITER ;

CALL calculadora_edad('2002-04-10', @edad);
SELECT @edad;
```

```sql
-- Procedimiento con lógica de negocio real (jardinería)
DELIMITER //
CREATE PROCEDURE actualizador(
    IN codigo INT,
    IN nuevo_nombre VARCHAR(30),
    IN apellido VARCHAR(40),
    IN tel VARCHAR(15),
    IN faxsito VARCHAR(15)
)
BEGIN
    UPDATE cliente
    SET nombre_contacto = nuevo_nombre,
        apellido_contacto = apellido,
        telefono = tel,
        fax = faxsito
    WHERE codigo_cliente = codigo;
END //
DELIMITER ;

CALL actualizador(1, 'Pepito', 'Ramírez', '955773321', 'jfhwjfvwf');
```

```sql
-- Descuento a la gama menos vendida
DELIMITER //
CREATE PROCEDURE descuento_gama()
BEGIN
    DECLARE gamita VARCHAR(50);
    SET gamita = (
        SELECT gama FROM producto
        JOIN detalle_pedido ON detalle_pedido.codigo_producto = producto.codigo_producto
        JOIN pedido ON pedido.codigo_pedido = detalle_pedido.codigo_pedido
        GROUP BY gama ORDER BY SUM(cantidad) LIMIT 1
    );
    UPDATE producto SET precio_venta = precio_venta * 0.85 WHERE gama = gamita;
END //
DELIMITER ;
```

---

## 4. Funciones almacenadas

Una función devuelve **siempre un único valor escalar** con `RETURN`. Se usa dentro de expresiones SQL (en `SELECT`, `WHERE`, etc.).

```sql
DELIMITER //
CREATE FUNCTION nombre_funcion(parámetros)
RETURNS tipo_dato DETERMINISTIC
BEGIN
    DECLARE variable tipo;
    -- lógica
    RETURN valor;
END //
DELIMITER ;

-- Uso:
SELECT nombre_funcion(valor);
SELECT columna, nombre_funcion(columna2) FROM tabla;
```

### 4.1 Características obligatorias

Hay que declarar al menos una de estas tres tras `RETURNS tipo`:

| Característica      | Significado                                          |
|---------------------|------------------------------------------------------|
| `DETERMINISTIC`     | Siempre devuelve lo mismo para los mismos parámetros |
| `NOT DETERMINISTIC` | Puede devolver resultados distintos (ej: usa NOW())  |
| `NO SQL`            | No contiene sentencias SQL                           |
| `READS SQL DATA`    | Solo lee, no modifica datos                          |
| `CONTAINS SQL`      | Contiene SQL pero no DML                             |
| `MODIFIES SQL DATA` | Modifica datos (INSERT/UPDATE/DELETE)                |

```sql
-- Función: evaluar nota
DELIMITER //
CREATE FUNCTION evaluacion(nota INT)
RETURNS VARCHAR(50) DETERMINISTIC
BEGIN
    DECLARE resultado VARCHAR(50);
    IF nota >= 5 THEN
        SET resultado = 'Aprobado';
    ELSEIF nota < 5 THEN
        SET resultado = 'Suspenso';
    ELSE
        SET resultado = 'Error en nota';
    END IF;
    RETURN resultado;
END //
DELIMITER ;
```

### 4.2 Funciones vs Procedimientos

|                      | Función                    | Procedimiento               |
|----------------------|----------------------------|-----------------------------|
| **Valor de retorno** | Sí, uno escalar (`RETURN`) | No directamente (usa `OUT`) |
| **Dónde se usa**     | Dentro de expresiones SQL  | Solo con `CALL`             |
| **Parámetros**       | Solo `IN` (implícito)      | `IN`, `OUT`, `INOUT`        |
| **Uso típico**       | Cálculos, transformaciones | DML, operaciones complejas  |

---

## 5. Estructuras de control

### 5.1 IF – THEN – ELSEIF – ELSE

```sql
IF condicion THEN
    -- instrucciones
ELSEIF otra_condicion THEN
    -- instrucciones
ELSE
    -- instrucciones
END IF;
```

### 5.2 CASE

Equivale a múltiples ELSEIF. Hay dos formas:

**CASE simple** (como switch de Java — compara un valor fijo):

```sql
CASE expresion
    WHEN valor1 THEN instrucciones;
    WHEN valor2 THEN instrucciones;
    ELSE instrucciones;
END CASE;
```

**CASE con condiciones** (más flexible — usa operadores lógicos):

```sql
CASE
    WHEN condicion1 THEN instrucciones;
    WHEN condicion2 THEN instrucciones;
    ELSE instrucciones;
END CASE;
```

### 5.3 Bucles

#### WHILE — evalúa condición ANTES

```sql
WHILE condicion DO
    -- instrucciones
END WHILE;
```

Si la condición es falsa desde el inicio, no se ejecuta nunca.

```sql
-- Ejemplo: contador con WHILE
DELIMITER //
CREATE PROCEDURE CONTADOR(IN numero INT)
BEGIN
    DECLARE contando INT DEFAULT 0;
    WHILE contando <= numero DO
        SELECT contando;
        SET contando = contando + 1;
    END WHILE;
END //
DELIMITER ;
```

#### REPEAT – evalúa condición DESPUÉS

```sql
REPEAT
    -- instrucciones
UNTIL condicion END REPEAT;
```

Se ejecuta **siempre al menos una vez**.

```sql
DELIMITER //
CREATE PROCEDURE CONTADOR2(IN numero INT)
BEGIN
    DECLARE contando INT DEFAULT 0;
    REPEAT
        SELECT contando;
        SET contando = contando + 1;
    UNTIL contando > numero END REPEAT;
END //
DELIMITER ;
```

#### LOOP + LEAVE — bucle infinito con salida manual

```sql
[etiqueta:] LOOP
    -- instrucciones
    IF condicion_salida THEN
        LEAVE etiqueta;
    END IF;
    -- más instrucciones
END LOOP [etiqueta];
```

```sql
DELIMITER //
CREATE PROCEDURE CONTADOR3(IN numero INT)
BEGIN
    DECLARE contando INT DEFAULT 0;
    pepito: LOOP
        SELECT contando;
        IF contando > numero THEN
            LEAVE pepito;
        END IF;
        SET contando = contando + 1;
    END LOOP pepito;
END //
DELIMITER ;
```

#### Comparativa de bucles

|                        | LOOP                        | REPEAT                  | WHILE                    |
|------------------------|-----------------------------|-------------------------|--------------------------|
| **Condición evaluada** | En cualquier punto (con IF) | Al **final** del bloque | Al **inicio** del bloque |
| **Ejecución mínima**   | Depende de dónde esté el IF | **Siempre 1 vez**       | Puede ser 0 veces        |
| **Salida**             | `LEAVE etiqueta`            | `UNTIL condición`       | Condición en `WHILE`     |

---

## 6. Manejo de errores — HANDLER

Permite capturar errores durante la ejecución y definir qué hacer con ellos.

```sql
DECLARE handler_action HANDLER FOR condition_value
BEGIN
    -- instrucciones ante el error
END;
```

- **`handler_action`:**
  - `CONTINUE` → el programa continúa tras ejecutar el handler
  - `EXIT` → el programa se detiene

- **`condition_value`:**
  - Código de error MySQL: `1062` (duplicate entry), `1451` (FK constraint fail)...
  - SQLSTATE: `'23000'` (violación clave única), `'42000'` (error sintaxis)...
  - Clases: `SQLWARNING` (01xxx), `NOT FOUND` (02xxx), `SQLEXCEPTION` (resto)

```sql
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
BEGIN
    SELECT 'Ha ocurrido un error';
END;
```

---

## 7. Cursores

Un cursor permite recorrer las filas de un `SELECT` **una a una**, en lugar de obtenerlas todas a la vez. Necesario cuando quieres procesar cada fila individualmente.

### Fases de un cursor

**1. Declaración** (después de las variables, antes de los handlers):

```sql
DECLARE nombre_cursor CURSOR FOR SELECT ...;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = TRUE;
```

**2. Apertura** (ejecuta la consulta y sitúa el puntero en la 1ª fila):

```sql
OPEN nombre_cursor;
```

**3. Lectura** (avanza el puntero y guarda los valores en variables):

```sql
FETCH nombre_cursor INTO variable1, variable2, ...;
```

**4. Cierre** (libera memoria):

```sql
CLOSE nombre_cursor;
```

```sql
-- Estructura completa con cursor
DELIMITER //
CREATE PROCEDURE ejemplo_cursor()
BEGIN
    DECLARE v_codigo INT;
    DECLARE v_nombre VARCHAR(50);
    DECLARE fin BOOLEAN DEFAULT FALSE;
    
    DECLARE cur CURSOR FOR SELECT codigo_cliente, nombre_cliente FROM cliente;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = TRUE;
    
    OPEN cur;
    
    bucle: LOOP
        FETCH cur INTO v_codigo, v_nombre;
        IF fin THEN
            LEAVE bucle;
        END IF;
        SELECT v_codigo, v_nombre;
    END LOOP bucle;
    
    CLOSE cur;
END //
DELIMITER ;
```

> Cuando el cursor llega al final de los resultados, se lanza el error `NOT FOUND` (SQLSTATE `'02000'`). Por eso es **obligatorio** declarar un handler para ese error.

---

## 8. Triggers (Disparadores)

Un trigger está asociado a una tabla y se ejecuta **automáticamente** cuando ocurre un evento DML (`INSERT`, `UPDATE`, `DELETE`). No se llama con `CALL`.

```sql
CREATE TRIGGER nombre_trigger
BEFORE | AFTER  INSERT | UPDATE | DELETE
ON nombre_tabla FOR EACH ROW
BEGIN
    -- instrucciones
END;
```

### 8.1 BEFORE vs AFTER

|                         | BEFORE                                    | AFTER                           |
|-------------------------|-------------------------------------------|---------------------------------|
| **Cuándo**              | Antes de guardar el cambio                | Después de guardar              |
| **Uso típico**          | Validar/modificar datos antes de insertar | Auditoría, logs, sincronización |
| **Puede modificar NEW** | Sí                                        | No                              |

### 8.2 OLD y NEW

|       | INSERT         | UPDATE             | DELETE             |
|-------|----------------|--------------------|--------------------|
| `NEW` | Valores nuevos | Valores nuevos     |                    |
| `OLD` |                | Valores anteriores | Valores eliminados |

```sql
-- Evitar que se reduzca el límite de crédito
CREATE TRIGGER proteger_credito
BEFORE UPDATE ON cliente
FOR EACH ROW
BEGIN
    IF NEW.limite_credito < OLD.limite_credito THEN
        SET NEW.limite_credito = OLD.limite_credito;
    END IF;
END;
```

---

## 9. Eventos

Los eventos son **tareas programadas** que se ejecutan automáticamente en un momento concreto o de forma recurrente. Son independientes de las interacciones con los datos (a diferencia de los triggers).

### Activar el planificador

```sql
SET GLOBAL event_scheduler = ON;
```

### Sintaxis

```sql
CREATE EVENT nombre_evento
ON SCHEDULE AT | EVERY momento/frecuencia
[ON COMPLETION [NOT] PRESERVE]
[ENABLE | DISABLE]
DO
    codigo_sql;
```

### Tipos

**Evento único (`AT`)** — se ejecuta una sola vez:

```sql
CREATE EVENT limpieza_puntual
ON SCHEDULE AT '2026-06-01 03:00:00'
DO
    DELETE FROM logs_temporales WHERE fecha < NOW() - INTERVAL 30 DAY;
```

**Evento recurrente (`EVERY`)** — se repite periódicamente:

```sql
CREATE EVENT limpieza_diaria
ON SCHEDULE EVERY 1 DAY
STARTS '2026-05-20 02:00:00'
DO
    DELETE FROM sesiones_expiradas WHERE expiracion < NOW();
```

---

## 10. Resumen: ¿Cuándo usar qué?

| Situación                                       | Herramienta                     |
|-------------------------------------------------|---------------------------------|
| Calcular un valor para usar en un `SELECT`      | **Función**                     |
| Insertar/actualizar/borrar datos con lógica     | **Procedimiento**               |
| Devolver múltiples valores                      | **Procedimiento con OUT/INOUT** |
| Reaccionar automáticamente a un cambio en tabla | **Trigger**                     |
| Tarea programada periódica                      | **Evento**                      |
| Procesar resultados fila a fila                 | **Cursor**                      |
| Controlar errores en tiempo de ejecución        | **Handler**                     |
