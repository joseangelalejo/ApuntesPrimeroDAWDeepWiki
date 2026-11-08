# **U3 - Creación de Bases de Datos Relacionales: Del Modelo Lógico a la Implementación Física con SQL**

- **Autor**: José Ángel Alejo Sillero
- **Centro**: Instituto Tecnológico Pablo de la Torre
- **Curso**: 2025/2026
- **Módulo**: Bases de Datos
- **Unidad**: 3 - Creación de Bases de Datos Relacionales

---
<div style="page-break-after: always;"></div>

> **Tabla de contenidos**

- [**U3 - Creación de Bases de Datos Relacionales: Del Modelo Lógico a la Implementación Física con SQL**](#u3---creación-de-bases-de-datos-relacionales-del-modelo-lógico-a-la-implementación-física-con-sql)
  - [**1. INTRODUCCIÓN**](#1-introducción)
  - [**2. SQL - STRUCTURE QUERY LANGUAGE**](#2-sql---structure-query-language)
    - [**2.1 Historia y Estandarización**](#21-historia-y-estandarización)
    - [**2.2 Clasificación de Operaciones SQL**](#22-clasificación-de-operaciones-sql)
  - [**3. DDL - DATA DEFINITION LANGUAGE**](#3-ddl---data-definition-language)
    - [**3.1 CREATE - Creación de Objetos**](#31-create---creación-de-objetos)
      - [**CREATE DATABASE**](#create-database)
      - [**CREATE TABLE**](#create-table)
      - [**Tipos de Datos en MySQL**](#tipos-de-datos-en-mysql)
        - [**Tipos Numéricos**](#tipos-numéricos)
        - [**Tipos de Texto y Cadenas**](#tipos-de-texto-y-cadenas)
        - [**Tipos de Fecha y Tiempo**](#tipos-de-fecha-y-tiempo)
        - [**Tipos Lógicos o Booleanos**](#tipos-lógicos-o-booleanos)
        - [**Tipos Binarios**](#tipos-binarios)
        - [**Tipos JSON**](#tipos-json)
        - [**Tipos Espaciales**](#tipos-espaciales)
      - [**Restricciones de Columna**](#restricciones-de-columna)
        - [**PRIMARY KEY**](#primary-key)
        - [**NOT NULL**](#not-null)
        - [**UNIQUE**](#unique)
        - [**FOREIGN KEY**](#foreign-key)
        - [**CHECK**](#check)
      - [**CONSTRAINT - Definición Explícita de Restricciones**](#constraint---definición-explícita-de-restricciones)
      - [**AUTO\_INCREMENT**](#auto_increment)
      - [**DEFAULT**](#default)
    - [**3.2 ALTER - Modificación de Objetos**](#32-alter---modificación-de-objetos)
      - [**ADD - Agregar Elementos**](#add---agregar-elementos)
      - [**DROP - Eliminar Elementos**](#drop---eliminar-elementos)
      - [**MODIFY y CHANGE - Modificar Elementos**](#modify-y-change---modificar-elementos)
    - [**3.3 DROP - Eliminación de Objetos**](#33-drop---eliminación-de-objetos)
  - [**4. ÍNDICES**](#4-índices)
    - [**4.1 Tipos de Índices**](#41-tipos-de-índices)
    - [**4.2 Creación de Índices**](#42-creación-de-índices)
    - [**4.3 Eliminación y Visualización de Índices**](#43-eliminación-y-visualización-de-índices)
    - [**4.4 Ejemplo Práctico**](#44-ejemplo-práctico)
  - [**5. VISTAS**](#5-vistas)
    - [**5.1 Definición y Características**](#51-definición-y-características)
    - [**5.2 Ventajas de las Vistas**](#52-ventajas-de-las-vistas)
    - [**5.3 Creación de Vistas**](#53-creación-de-vistas)
    - [**5.4 Índices vs Vistas**](#54-índices-vs-vistas)
  - [**6. DCL - DATA CONTROL LANGUAGE**](#6-dcl---data-control-language)
    - [**6.1 Usuarios**](#61-usuarios)
      - [**Creación de Usuarios**](#creación-de-usuarios)
      - [**Eliminación de Usuarios**](#eliminación-de-usuarios)
    - [**6.2 Roles**](#62-roles)
      - [**Ventajas de los Roles**](#ventajas-de-los-roles)
      - [**Creación de Roles**](#creación-de-roles)
      - [**Eliminación de Roles**](#eliminación-de-roles)
    - [**6.3 Privilegios**](#63-privilegios)
      - [**Niveles de Privilegios**](#niveles-de-privilegios)
      - [**GRANT - Otorgar Privilegios**](#grant---otorgar-privilegios)
      - [**Activación de Roles**](#activación-de-roles)
      - [**REVOKE - Revocar Privilegios**](#revoke---revocar-privilegios)
  - [**7. DML - DATA MANIPULATION LANGUAGE**](#7-dml---data-manipulation-language)

---
<div style="page-break-after: always;"></div>

## **1. INTRODUCCIÓN**

Tras finalizar el **diseño lógico** en forma de esquema relacional (tema anterior), el siguiente paso es **implementarlo en un SGBD** (Sistema Gestor de Bases de Datos).

Para realizar esta implementación utilizamos el **lenguaje que el SGBD soporte**. En nuestro caso trabajaremos con **MySQL**, un sistema gestor de bases de datos relacional, por lo que el lenguaje que emplearemos para crear y definir la base de datos será **SQL**.

Este tema cubre la transición crucial del **modelo lógico a la implementación física**, permitiéndote convertir tus diseños teóricos en bases de datos funcionales.

---

## **2. SQL - STRUCTURE QUERY LANGUAGE**

### **2.1 Historia y Estandarización**

El lenguaje **SQL (Structure Query Language)** es un **lenguaje declarativo de acceso a bases de datos relacionales** que permite especificar diversos tipos de operaciones en ellas.

**Contexto Histórico:**

- Durante los **años 80**, compañías como **IBM**, **Oracle** y **SyBase** comercializaron productos basados en esquemas relacionales que utilizaban SQL como lenguaje de definición y explotación.
- Esto provocó que **SQL se convirtiera en el estándar de la industria** de las bases de datos.
- En estos años fue **adoptado por ANSI e ISO** como un estándar para los lenguajes relacionales.

**Importancia:**

Por ser un estándar **ISO** y haber sido adoptado como lenguaje de los principales SGBD del mercado, se puede afirmar que **SQL es una de las razones que han conducido al éxito a las bases de datos relacionales**.

---

### **2.2 Clasificación de Operaciones SQL**

Las diferentes operaciones en SQL se clasifican en **tres sublenguajes principales**:

| **SUBLENGUAJE** | **DESCRIPCIÓN**                                 | **OPERACIONES**                                          |
|-----------------|-------------------------------------------------|----------------------------------------------------------|
| **DDL**         | Data Definition Language - Define la estructura | Creación, Modificación, Borrado de objetos               |
| **DML**         | Data Manipulation Language - Trabaja con datos  | Consulta, Inserción, Actualización, Eliminación de datos |
| **DCL**         | Data Control Language - Gestiona seguridad      | Otorgar, Revocar privilegios y permisos                  |

---
<div style="page-break-after: always;"></div>

## **3. DDL - DATA DEFINITION LANGUAGE**

El **DDL (Data Definition Language)** es el conjunto de **instrucciones de SQL destinadas a definir y gestionar la estructura de una base de datos**.

A través de este sublenguaje se **establecen todos los elementos que forman parte del diseño físico**. El DDL incluye operaciones orientadas a:

- **Creación** de objetos
- **Modificación** de objetos
- **Borrado** de objetos

**Importante:** Las operaciones DDL siempre se refieren a la **estructura de la base de datos, no a los datos en sí**. Para trabajar con los datos utilizamos DML.

---

### **3.1 CREATE - Creación de Objetos**

La sentencia **CREATE** constituye el **núcleo del DDL de SQL**. Permite crear cualquier objeto de la base de datos.

Los **objetos de la base de datos** son estructuras de datos que mantiene un SGBD y que son de interés para los usuarios. Algunos de los más destacados son:

- **Base de Datos (DATABASE)**
- **Tablas (TABLE)**
- **Vistas (VIEW)**
- **Índices (INDEX)**

---

#### **CREATE DATABASE**

El objeto **DATABASE** es el **principal para poder comenzar la creación de nuestra estructura**, ya que este objeto será el que contenga en su interior el resto de elementos.

**Sintaxis:**

```sql
CREATE DATABASE nombre_base_datos;
```

**Nota Importante:** Puesto que el resto de objetos se deben crear dentro de la base de datos, antes de poder seguir creando nuevos objetos es necesario **fijar la BD que utilizaremos**:

```sql
USE nombre_base_datos;
```

---
<div style="page-break-after: always;"></div>

#### **CREATE TABLE**

El objeto **TABLE** es el **objeto fundamental en una base de datos**, donde se almacena la información en **filas y columnas**.

**Sintaxis General:**

```sql
CREATE TABLE nombre_tabla (
    nombre_columna1 tipo_dato restricciones,
    nombre_columna2 tipo_dato restricciones,
    ...
);
```

**Nota:** MySQL no permite crear una tabla sin que contenga al menos una columna. La sintaxis anterior producirá error de sintaxis sin las columnas definidas.

---

#### **Tipos de Datos en MySQL**

En MySQL, las columnas se definen indicando un **nombre y un tipo de dato**, que determina **qué clase de información podrá almacenarse en ellas**.

**La elección del tipo de dato es fundamental** porque afecta al:

- Espacio ocupado en memoria
- Rendimiento de la base de datos
- Integridad de la información

MySQL ofrece una gran variedad de tipos, agrupados en varias categorías:

---

##### **Tipos Numéricos**

Permiten almacenar valores **enteros o con decimales**. Su elección depende del **rango necesario** y del **tamaño en memoria**.

**Enteros:**

- **TINYINT** – Rangos pequeños. Útil para valores tipo 0/1 o cantidades bajas.
- **SMALLINT** – Para cantidades moderadas.
- **MEDIUMINT** – Rangos intermedios.
- **INT / INTEGER** – El entero más utilizado. Perfecto para IDs o contadores.
- **BIGINT** – Para valores muy grandes (hasta 9×10¹⁸).

**Decimales:**

- **FLOAT** – Decimales de precisión aproximada.
- **DOUBLE** – Mayor precisión que FLOAT.
- **DECIMAL(m,d)** – Precisión exacta. **Recomendado para precios, dinero y porcentajes**.

**Opciones Adicionales para Enteros:**

- **UNSIGNED**: Por defecto, los tipos enteros admiten valores negativos y positivos. Al añadir UNSIGNED, el tipo pasa a admitir **solo valores positivos** (o cero), ampliando el rango positivo.
- **ZEROFILL**: Afecta a cómo se muestra el número, **no a cómo se almacena**. Rellena el valor con ceros a la izquierda hasta completar el ancho definido.

---

##### **Tipos de Texto y Cadenas**

Se utilizan para almacenar **nombres, descripciones, direcciones** y cualquier información basada en caracteres.

**Texto de Longitud Fija:**

- **CHAR(n)** – Longitud fija. Se rellena con espacios si es corto.

**Texto de Longitud Variable:**

- **VARCHAR(n)** – Longitud variable. **Es el tipo más común**.

**Textos Largos:**

- **TINYTEXT** – Hasta 255 caracteres.
- **TEXT** – Hasta 65 KB.
- **MEDIUMTEXT** – Hasta 16 MB.
- **LONGTEXT** – Hasta 4 GB.

**Tipos Enumerados:**

- **ENUM** – Selección de **un valor** dentro de una lista predefinida.
- **SET** – Selección de **uno o varios valores** dentro de una lista predefinida.

---

##### **Tipos de Fecha y Tiempo**

Permiten almacenar **fechas, horas o ambas combinadas**.

- **DATE** – Fecha en formato YYYY-MM-DD.
- **TIME** – Hora en formato HH:MM:SS.
- **DATETIME** – Fecha + hora sin conversión automática.
- **TIMESTAMP** – Fecha + hora con actualización automática (según configuración).
- **YEAR** – Año (2 o 4 dígitos).

---

##### **Tipos Lógicos o Booleanos**

Representan **valores binarios o de verdadero/falso**.

- **BOOLEAN / BOOL** – Alias de TINYINT(1).
  - 0 = falso
  - 1 = verdadero

Son utilizados para estados simples como: **activo/inactivo**, **sí/no**, **disponible/no disponible**.

---

##### **Tipos Binarios**

Ideales para almacenar **datos no textuales: imágenes, archivos, datos en bruto**.

- **TINYBLOB** – Hasta 255 bytes.
- **BLOB** – Hasta 65 KB.
- **MEDIUMBLOB** – Hasta 16 MB.
- **LONGBLOB** – Hasta 4 GB.

---

##### **Tipos JSON**

MySQL permite almacenar **datos semiestructurados en formato JSON**.

- **JSON** – Almacena objetos y arrays JSON válidos.
  - Permite búsquedas internas
  - Soporta índices parciales
  - Validación automática

**Muy útil para datos flexibles:** preferencias de usuario, configuraciones, listas dinámicas.

---

##### **Tipos Espaciales**

Se utilizan para representar **posiciones, rutas, polígonos** y otras estructuras geométricas.

- **GEOMETRY** – Tipo base de todos los objetos espaciales.
- **POINT** – Un punto (coordenadas).
- **LINESTRING** – Línea formada por varios puntos.
- **POLYGON** – Área cerrada.
- **MULTIPOINT** – Conjunto de puntos.
- **MULTILINESTRING** – Conjunto de líneas.
- **MULTIPOLYGON** – Conjunto de polígonos.
- **GEOMETRYCOLLECTION** – Colección de diferentes tipos geométricos.

**Uso:** Muy usado en sistemas de mapas, geolocalización y análisis espacial.

---
<div style="page-break-after: always;"></div>

#### **Restricciones de Columna**

Las columnas que componen las tablas pueden contener varias **restricciones que limitan los valores** que pueden adoptar los datos que contienen.

Las principales restricciones son:

| **RESTRICCIÓN** | **DESCRIPCIÓN**                     | **NIVEL**     |
|-----------------|-------------------------------------|---------------|
| **PRIMARY KEY** | Identifica de forma única cada fila | Columna/Tabla |
| **NOT NULL**    | Prohibe valores nulos               | Columna       |
| **UNIQUE**      | Garantiza valores únicos            | Columna/Tabla |
| **FOREIGN KEY** | Crea relación con otra tabla        | Tabla         |
| **CHECK**       | Limita el rango de valores          | Columna/Tabla |

---

##### **PRIMARY KEY**

La restricción **PRIMARY KEY** permite establecer **qué columna o conjunto de columnas identifica de forma única a cada fila de la tabla**.

**Características Especiales:**

- Por su propia definición contiene las restricciones **UNIQUE y NOT NULL** por defecto.
- **Un SGBD permite 1 PK por tabla como máximo**.

**Formas de Asignación:**

**Nivel de Columna:**

```sql
CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY,
    nombre VARCHAR(100)
);
```

**Nivel de Tabla:**

```sql
CREATE TABLE empleados (
    id_empleado INT,
    nombre VARCHAR(100),
    PRIMARY KEY (id_empleado)
);
```

**Para PK Compuestas (no recomendable ni común):**

Si queremos tener una **PK compuesta**, la única forma de definirla es a **nivel de tabla**:

```sql
CREATE TABLE asignaciones (
    id_empleado INT,
    id_proyecto INT,
    fecha_inicio DATE,
    PRIMARY KEY (id_empleado, id_proyecto)
);
```

---

##### **NOT NULL**

La restricción **NOT NULL** genera la **prohibición de introducir el valor NULL** en la columna que tenga esta restricción.

**Conceptos Importantes:**

- **NULL** es un valor especial en bases de datos que representa **la ausencia de valor o un dato desconocido**.
- Esta restricción **solo puede asignarse a nivel de columna**.

**Ejemplo:**

```sql
CREATE TABLE empleados (
    id_empleado INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15)
);
```

---

##### **UNIQUE**

La restricción **UNIQUE** sirve para especificar que **los valores de una columna o conjunto de columnas deben ser únicos**, es decir, no admiten repetición en las diferentes filas.

**Características:**

- Admite asignarse tanto a **nivel de columna** como a **nivel de tabla**.
- **Cuidado con NULL:** Pueden coexistir múltiples registros con valor NULL en una columna UNIQUE, porque no se contempla que dos valores NULL sean iguales.

**Ejemplos:**

```sql
-- Nivel de columna
CREATE TABLE usuarios (
    id INT PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    nombre VARCHAR(100)
);
```

```sql
-- Nivel de tabla (múltiples columnas)
CREATE TABLE usuarios (
    id INT PRIMARY KEY,
    email VARCHAR(100),
    nombre VARCHAR(100),
    UNIQUE (email, nombre)
);
```

---

##### **FOREIGN KEY**

La restricción **FOREIGN KEY** designa una columna o combinación de columnas como **clave externa** y establece una **relación con una clave primaria en otra tabla diferente**.

**Características:**

- Esta restricción **solo puede asignarse a nivel de tabla**.
- Crea lo que se conoce como **integridad referencial**.

**Opciones Adicionales:**

- **ON DELETE CASCADE**: Al eliminar una fila de la tabla principal, también eliminará las filas dependientes de la tabla secundaria.
- **ON DELETE SET NULL**: Al eliminar una fila de la tabla principal, los valores de la clave externa se definirán como nulos.

**Comportamiento por Defecto:**

Sin especificar estas opciones, el sistema adopta una actuación muy **restrictiva impidiendo la eliminación del dato original** mientras perduren sus referencias.

**Ejemplo:**

```sql
CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY,
    nombre VARCHAR(100),
    id_departamento INT,
    FOREIGN KEY (id_departamento) REFERENCES departamentos(id_departamento)
    ON DELETE CASCADE
);
```

**Integridad Referencial:**

Surge cuando se crea una vinculación entre dos tablas. El sistema debe saber cómo actuar con los datos vinculados (FK) en caso de eliminación del dato original (PK).

---

##### **CHECK**

La restricción **CHECK** se utiliza para **limitar el rango de valores** que se puede colocar en una columna.

**Funcionamiento:**

- Si se define en una columna, solo permitirá ciertos valores para esa columna.
- Si se define a nivel de tabla, puede limitar los valores en ciertas columnas en función de los valores en otras columnas de la fila.

**Ejemplo:**

```sql
CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY,
    nombre VARCHAR(100),
    edad INT CHECK (edad >= 18 AND edad <= 65),
    salario DECIMAL(10, 2) CHECK (salario > 0)
);
```

---

#### **CONSTRAINT - Definición Explícita de Restricciones**

La sentencia **CONSTRAINT** en SQL se usa para **definir restricciones o reglas en las columnas de una tabla** asignándoles un **nombre específico**.

Al usar CONSTRAINT, puedes asegurarte de que los datos cumplan con ciertas condiciones antes de ser ingresados, evitando errores y duplicidades.

**Características:**

- Las restricciones pueden aplicarse tanto en la **creación de la tabla** como al **modificarla posteriormente**.
- Si no utilizas CONSTRAINT, el sistema genera un nombre genérico a dicha restricción.
- Si quieres ponerle un nombre específico, debes utilizar esta sentencia.

**Ejemplo:**

```sql
CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    edad INT,
    id_departamento INT,
    
    CONSTRAINT uk_email UNIQUE (email),
    CONSTRAINT ck_edad CHECK (edad >= 18),
    CONSTRAINT fk_departamento FOREIGN KEY (id_departamento) 
        REFERENCES departamentos(id_departamento)
);
```

---

#### **AUTO_INCREMENT**

La propiedad **AUTO_INCREMENT** se utiliza para **auto-incrementar un campo al insertar nuevas filas** en una tabla.

**Características:**

- Este atributo se asocia comúnmente con la definición de una columna que actuará como **clave primaria**.
- Cuando insertas una nueva fila y no proporciona un valor para la columna que contiene AUTO_INCREMENT, **MySQL automáticamente asignará el siguiente número de secuencia disponible**.

**Ejemplo:**

```sql
CREATE TABLE empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100)
);

-- Al insertar sin especificar id_empleado:
INSERT INTO empleados (nombre, email) VALUES ('Juan Pérez', 'juan@example.com');
-- MySQL asignará automáticamente un id_empleado
```

---

#### **DEFAULT**

Al definir una tabla podemos **especificar que una columna tenga un valor por defecto** mediante la opción **DEFAULT**.

**Características:**

- Esta opción **evita que se introduzcan valores nulos** en las columnas.
- El valor puede ser:
  - Un **literal** (7, 3.5, 'Empleado', 53)
  - Una **función SQL** (CURRENT_DATE(), CURRENT_TIME(), etc.)

**Ejemplo:**

```sql
CREATE TABLE empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    estado VARCHAR(20) DEFAULT 'Activo',
    fecha_contratacion DATE DEFAULT CURRENT_DATE(),
    salario DECIMAL(10, 2) DEFAULT 2000.00
);
```

---
<div style="page-break-after: always;"></div>

### **3.2 ALTER - Modificación de Objetos**

La sentencia **ALTER** nos permite **modificar un objeto que ya haya sido creado** con anterioridad.

**Razones Comunes para Usar ALTER:**

- Se ha omitido una columna.
- Se debe cambiar la definición o nombre de una columna.
- Hay que eliminar una columna.
- Se necesitan ajustar restricciones.

**Estructura General:**

```sql
ALTER OBJETO Nombre_del_OBJETO Tipo_modificacion ...;
```

**Tipos de Modificaciones Disponibles:**

- **Agregar** elementos con ADD
- **Eliminar** elementos con DROP
- **Modificar** elementos con MODIFY o CHANGE

---

#### **ADD - Agregar Elementos**

Utilizamos la sentencia **ADD** seguida de lo que pretendamos agregar.

**Ejemplos:**

```sql
-- Agregar una nueva columna
ALTER TABLE empleados ADD telefono VARCHAR(15);

-- Agregar una columna con restricciones
ALTER TABLE empleados ADD edad INT CHECK (edad >= 0);

-- Agregar una restricción a una columna existente
ALTER TABLE empleados ADD CONSTRAINT uk_email UNIQUE (email);

-- Agregar una clave externa
ALTER TABLE empleados ADD CONSTRAINT fk_depto 
FOREIGN KEY (id_departamento) REFERENCES departamentos(id_departamento);
```

**Nota:** Aunque los ejemplos son con el objeto tabla, realmente podemos modificar cualquiera de los objetos existentes.

---

#### **DROP - Eliminar Elementos**

Utilizamos la sentencia **DROP** seguida de lo que pretendamos eliminar.

**Ejemplos:**

```sql
-- Eliminar una columna
ALTER TABLE empleados DROP COLUMN telefono;

-- Eliminar una restricción
ALTER TABLE empleados DROP CONSTRAINT uk_email;

-- Eliminar una clave externa
ALTER TABLE empleados DROP CONSTRAINT fk_depto;
```

**Nota:** Aunque los ejemplos son con el objeto tabla, realmente podemos modificar cualquiera de los objetos existentes.

---

#### **MODIFY y CHANGE - Modificar Elementos**

Existen **dos sentencias diferentes** para modificar elementos:

**MODIFY:**

- Se usa para **cambiar el tipo de dato y/o las restricciones de una columna sin renombrarla**.

```sql
-- Cambiar el tipo de dato
ALTER TABLE empleados MODIFY edad INT NOT NULL;

-- Cambiar a otro tipo de dato
ALTER TABLE empleados MODIFY nombre VARCHAR(200);
```

**CHANGE:**

- Se usa para **renombrar una columna y cambiar su tipo de dato y/o las restricciones** en una tabla.

```sql
-- Renombrar y cambiar tipo
ALTER TABLE empleados CHANGE COLUMN age edad INT NOT NULL;

-- Renombrar
ALTER TABLE empleados CHANGE COLUMN telefono phone VARCHAR(15);
```

---
<div style="page-break-after: always;"></div>

### **3.3 DROP - Eliminación de Objetos**

La sentencia **DROP** sirve para **borrar/eliminar un objeto de la base de datos** (incluso la base de datos en sí).

Ya hemos visto su funcionamiento dentro del ALTER, pero podemos utilizarlo como la **sentencia principal** en caso de querer eliminar un objeto en sí.

**Ejemplos:**

```sql
-- Eliminar una tabla
DROP TABLE empleados;

-- Eliminar una base de datos
DROP DATABASE mi_empresa;

-- Eliminar una vista
DROP VIEW vista_empleados;

-- Eliminar un índice
DROP INDEX idx_email ON usuarios;
```

---
<div style="page-break-after: always;"></div>

## **4. ÍNDICES**

Los índices en las bases de datos son como **atajos que se crean para hacer que ciertas consultas sean más rápidas**. Algunos de estos atajos se crean automáticamente al crear ciertas restricciones como las PK.

**Analogía útil:**

> Imagina una tabla de datos como una gran lista. Un índice actúa como una guía rápida que te dice exactamente dónde encontrar la información que estás buscando en esa lista.

**Características Importantes:**

- Los índices son como ayudantes que **trabajan por separado de la tabla principal**.
- Pueden ser **creados o eliminados sin afectar directamente a la tabla**.
- Consumen espacio adicional en memoria, pero mejoran significativamente el rendimiento de búsquedas.

---

### **4.1 Tipos de Índices**

Existen **dos formas de crear índices**:

**Automáticos:**

- Al definir una restricción **PRIMARY KEY o UNIQUE** en una tabla, se **crea un índice único de forma automática**.
- A estos tipos de índices se les denomina **índices únicos**.

**Manuales:**

- Los usuarios pueden **crear índices en las columnas** para acelerar el acceso a las filas.
- Estos índices reciben el nombre de **índices no únicos**.
- Permiten optimizar consultas específicas que se realizan frecuentemente.

---

### **4.2 Creación de Índices**

**Sintaxis para crear un índice manualmente:**

```sql
CREATE INDEX nombre_indice ON nombre_tabla (columna1, columna2, columna3...);
```

**Ejemplos:**

```sql
-- Índice simple en una columna
CREATE INDEX idx_email ON usuarios (email);

-- Índice compuesto en múltiples columnas
CREATE INDEX idx_nombre_apellido ON empleados (nombre, apellido);

-- Índice en columna de búsqueda frecuente
CREATE INDEX idx_salario ON empleados (salario);
```

---

### **4.3 Eliminación y Visualización de Índices**

**Sintaxis para borrar un índice:**

```sql
DROP INDEX nombre_indice ON nombre_tabla;
```

**Sintaxis para mostrar los índices de una tabla:**

```sql
SHOW INDEX FROM nombre_tabla;
```

**Ejemplos:**

```sql
-- Eliminar un índice
DROP INDEX idx_email ON usuarios;

-- Ver todos los índices de una tabla
SHOW INDEX FROM empleados;
```

---

### **4.4 Ejemplo Práctico**

**Escenario:**

Imaginemos una tabla llamada `empleados` con **millones de registros**, y frecuentemente consultamos información sobre empleados con un **salario específico**. Sin índices, la base de datos tendría que **recorrer toda la tabla** para encontrar los registros que cumplen con tu condición.

**¿Cómo funcionan los índices?**

Cuando se crea un índice en una columna específica (como `salario`), la base de datos crea una **estructura adicional que contiene**:

- Los **valores de esa columna**
- Las **direcciones de memoria de las filas** correspondientes en la tabla principal

**Ventaja del Índice:**

En lugar de consultar **todas las columnas de todas las filas** de la tabla, simplemente:

1. Compara los valores recogidos por el índice
2. Obtiene la dirección de memoria de los que necesita en la consulta
3. Accede directamente a esos registros

**Resultado:** Mejora significativa en el rendimiento de consultas frecuentes.

---
<div style="page-break-after: always;"></div>

## **5. VISTAS**

Una **vista** en una base de datos es como una **tabla virtual** que se construye utilizando información de una o más tablas existentes.

**Características Fundamentales:**

- Una vista **no almacena datos por sí misma**.
- Actúa como una **ventana que permite ver o modificar datos** de las tablas subyacentes.
- Las **tablas originales que contribuyen a la vista** se llaman **tablas base**.

**Analogía Útil:**

Son como un **informe personalizado** que presenta datos de diferentes tablas de manera organizada. Se usan para:

- **Simplificar las consultas**
- **Proporcionar una visión concreta de los datos**
- **Facilitar la manipulación de información** sin tener que modificar directamente las tablas originales

---

### **5.1 Definición y Características**

Las vistas son **objetos virtuales** que permiten:

- Consultar datos de múltiples tablas como si fuera una sola tabla
- Presentar datos en un formato específico
- Proporcionar una interfaz consistente a los usuarios

---

### **5.2 Ventajas de las Vistas**

Las vistas ofrecen ventajas significativas:

- **Restricción de acceso** mostrando solo columnas seleccionadas.
- **Recuperación de datos** desde múltiples tablas con filtros personalizados.
- **Facilitan la presentación clara** de información a usuarios no expertos.
- **Proporcionan independencia de datos**, adaptándose a cambios en la estructura o nombre de las tablas.
- **Simplificación de consultas complejas** mediante su reutilización.
- **Seguridad mejorada** al limitar lo que cada usuario puede ver.

---

### **5.3 Creación de Vistas**

**Sintaxis General:**

```sql
CREATE VIEW nombre_vista AS
SELECT columna1, columna2, ... 
FROM tabla_base
WHERE condiciones;
```

**Ejemplo de Vista Simple (Monotabla):**

```sql
CREATE VIEW empleados_activos AS
SELECT id_empleado, nombre, email, salario
FROM empleados
WHERE estado = 'Activo';
```

**Ejemplo de Vista con Múltiples Tablas:**

```sql
CREATE VIEW empleados_departamentos AS
SELECT e.id_empleado, e.nombre, d.nombre AS departamento, e.salario
FROM empleados e
JOIN departamentos d ON e.id_departamento = d.id_departamento;
```

**Nota:** Denominamos **vista simple o Monotabla** aquella que obtiene datos de una única tabla. Las **vistas Multitablas** las dejaremos para el tema de consultas cuando dominemos mejor las operaciones JOIN.

---

### **5.4 Índices vs Vistas**

Es importante entender las **diferencias fundamentales** entre índices y vistas:

| **ASPECTO**              | **ÍNDICES**                    | **VISTAS**                             |
|--------------------------|--------------------------------|----------------------------------------|
| **Estructura Física**    | Estructura física en disco     | Estructura virtual (no almacena datos) |
| **Objetivo Principal**   | Optimizar y agilizar búsquedas | Restringir información a mostrar       |
| **Almacenamiento**       | Almacenan datos ordenados      | No almacenan datos (son virtuales)     |
| **Impacto en Consultas** | Acelera búsquedas              | Simplifica acceso a datos complejos    |
| **Uso de Memoria**       | Requiere espacio adicional     | No requiere espacio significativo      |
| **Operaciones**          | Creación, Eliminación          | Creación, Modificación, Eliminación    |

**Conclusión:** Los índices sirven para **optimización de rendimiento**, mientras que las vistas sirven para **simplificación de acceso a datos y seguridad**.

---
<div style="page-break-after: always;"></div>

## **6. DCL - DATA CONTROL LANGUAGE**

El **DCL (Data Control Language)** es el conjunto de **instrucciones de SQL destinado a gestionar la seguridad y el control de acceso** dentro de una base de datos.

**Objetivos Principales:**

- **Determinar quién puede hacer qué** dentro del sistema
- **Garantizar que solo los usuarios autorizados** accedan o modifiquen la información
- **Establecer políticas de seguridad** precisas y controladas

Este sublenguaje permite realizar las siguientes operaciones principales:

- **Otorgar** privilegios (GRANT)
- **Revocar** privilegios (REVOKE)

---

### **6.1 Usuarios**

Cada cuenta de usuario está compuesta por los siguientes elementos:

| **ELEMENTO**                | **DESCRIPCIÓN**                   | **RESTRICCIONES**                                                                  |
|-----------------------------|-----------------------------------|------------------------------------------------------------------------------------|
| **Nombre de usuario único** | Identificador único del usuario   | Max 32 caracteres, sin caracteres especiales (excepto '_'), debe empezar por letra |
| **Método de autenticación** | Forma de verificar identidad      | La contraseña es el más común (basada en plugins como mysql_native_password o sha256_password) |
| **Ubicación de conexión**   | Desde dónde se puede conectar     | localhost, %, dirección IP, etc.                                                   |
| **Roles**                   | Conjunto de privilegios asignados | Se heredan los permisos del rol                                                    |

**Otros Métodos de Autenticación:**

Además de la contraseña tradicional, MySQL soporta otros métodos como:

- **sha256_password**: Utiliza hash SHA-256 para contraseñas, ofreciendo mayor seguridad. Se configura con `IDENTIFIED WITH sha256_password BY 'contraseña'`.

---

#### **Creación de Usuarios**

**Sintaxis:**

```sql
CREATE USER nombre_usuario IDENTIFIED BY 'Contraseña_a_usar';
```

**Con especificación de ubicación:**

```sql
CREATE USER 'nombre_usuario'@'localhost' IDENTIFIED BY 'contraseña';
CREATE USER 'nombre_usuario'@'%' IDENTIFIED BY 'contraseña';  -- Desde cualquier lugar
```

**Importante a Considerar:**

En MySQL, cuando creas un usuario, puedes especificar **desde qué ubicación este usuario tiene permitido conectarse**.

- Si utilizas **`@'localhost'`**, el usuario solo se puede conectar desde la máquina local.
- Si utilizas **`@'%'`**, el usuario puede conectarse desde cualquier ubicación.
- MySQL entiende que **`usuario` y `usuario@'localhost'` son usuarios completamente diferentes**.

**Ejemplo:**

```sql
-- Usuario que solo se conecta localmente
CREATE USER 'juan'@'localhost' IDENTIFIED BY 'contraseña123';

-- Usuario que se puede conectar desde cualquier lugar
CREATE USER 'juan'@'%' IDENTIFIED BY 'contraseña123';

-- Usuario con autenticación sha256_password
CREATE USER 'usuario_sha'@'localhost' IDENTIFIED WITH sha256_password BY 'contraseña_segura';
```

---

#### **Eliminación de Usuarios**

**Sintaxis:**

```sql
DROP USER nombre_usuario;
DROP USER 'nombre_usuario'@'localhost';
```

**Importante:**

Hay que tener mucho cuidado y ser exacto con la especificación. No es lo mismo:

- `usuario@'localhost'`
- `usuario@'%'`
- `usuario` (sin especificar ubicación)

Por lo que si creamos al usuario especificando el punto de acceso para eliminarlo **también deberemos especificarlo exactamente igual**.

**Ejemplo:**

```sql
-- Si creamos así:
CREATE USER 'juan'@'localhost' IDENTIFIED BY 'contraseña123';

-- Debemos eliminarlo así:
DROP USER 'juan'@'localhost';  -- ✓ Correcto

-- NO así:
DROP USER 'juan';  -- ✗ Error: usuario no encontrado
```

---

### **6.2 Roles**

Los **roles** son **grupos de privilegios relacionados** que se otorgan a los usuarios u otros roles. Los roles están diseñados para **facilitar la administración de privilegios** en la base de datos, mejorando la seguridad de la misma.

**Concepto Clave:**

Un rol es esencialmente un **contenedor de privilegios** que puede asignarse a múltiples usuarios, facilitando la gestión centralizada de permisos.

---

#### **Ventajas de los Roles**

Los roles proporcionan ventajas significativas en la administración de bases de datos:

- **Gestión de privilegios más sencilla**: En lugar de otorgar una gran cantidad de privilegios iguales a diferentes usuarios, estos se aplican a un rol y luego el rol se asigna a los usuarios.

- **Gestión de privilegios dinámica**: Si modificamos los privilegios asociados a un rol, **de forma automática se modificarán a todos los usuarios con dicho rol**.

- **Mayor Escalabilidad**: Puedes crear roles específicos para cada situación y contexto permitiendo una gran escalabilidad en caso de necesitar agregar más roles en el futuro.

**Ejemplo de Beneficio:**

```
Sin Roles: 
  Usuario1 → SELECT, INSERT, UPDATE  
  Usuario2 → SELECT, INSERT, UPDATE  
  Usuario3 → SELECT, INSERT, UPDATE  
  (Si necesito cambiar permisos, debo hacerlo en 3 usuarios)

Con Roles:
  Rol Empleado → SELECT, INSERT, UPDATE  
  Usuario1 → Rol Empleado  
  Usuario2 → Rol Empleado  
  Usuario3 → Rol Empleado  
  (Si necesito cambiar permisos, cambio el rol y afecta a todos)
```

---

#### **Creación de Roles**

**Sintaxis:**

```sql
CREATE ROLE nombre_rol;
```

**Ejemplo:**

```sql
CREATE ROLE admin;
CREATE ROLE empleado;
CREATE ROLE consultor;
```

**Importante a Recordar:**

Esto **solo creará el nombre del rol**. Inicialmente:

- El rol **no estará asignado a nadie**
- El rol **no tendrá ningún privilegio asignado**

Se necesitarán pasos adicionales (GRANT) para:

1. Asignar privilegios al rol
2. Asignar el rol a usuarios

---

#### **Eliminación de Roles**

**Sintaxis:**

```sql
DROP ROLE nombre_rol;
```

**Ejemplo:**

```sql
DROP ROLE consultor;
```

---

### **6.3 Privilegios**

Un **privilegio** es el **derecho a ejecutar un tipo concreto de sentencia SQL**, o para **acceder a un objeto de otro usuario**.

---

#### **Niveles de Privilegios**

En MySQL podemos encontrar varios **niveles de privilegios** que permiten un control granular:

| **NIVEL**            | **ALCANCE**                                                                                  | **EJEMPLO**                                 |
|----------------------|----------------------------------------------------------------------------------------------|---------------------------------------------|
| **Globales**         | Se aplican al conjunto de todas las bases de datos en un servidor                            | Crear base de datos, crear usuario          |
| **De base de datos** | Se refieren a bases de datos individuales, y por extensión, a todos los objetos que contiene | SELECT en toda la BD, CREATE TABLE en la BD |
| **De tabla**         | Se aplican a tablas individuales, y por lo tanto, a todas las columnas de esa tabla          | INSERT en tabla específica                  |
| **De columna**       | Se aplican a una columna en una tabla concreta                                               | UPDATE solo en columnas específicas         |

---

#### **GRANT - Otorgar Privilegios**

La sentencia **GRANT** se usa para **añadir privilegios a un usuario y roles existentes**.

**Principales Tipos de Permisos en MySQL:**

| **PRIVILEGIO**     | **DESCRIPCIÓN**                                            |
|--------------------|------------------------------------------------------------|
| **ALL PRIVILEGES** | Todos los privilegios                                      |
| **CREATE**         | Permite crear nuevas tablas o bases de datos               |
| **DROP**           | Permite eliminar tablas o bases de datos                   |
| **DELETE**         | Permite eliminar filas de las tablas                       |
| **INSERT**         | Permite insertar filas en las tablas                       |
| **SELECT**         | Permite consultar información de una base de datos o tabla |
| **UPDATE**         | Permite actualizar las filas de las tablas                 |
| **GRANT OPTION**   | Permite otorgar o eliminar privilegios a otros usuarios    |

**Sintaxis:**

```sql
GRANT Privilegio ON Nombre_BD.Nombre_tabla TO Usuario_o_rol;
```

**Ejemplos:**

```sql
-- Otorgar SELECT a un usuario
GRANT SELECT ON empresa.empleados TO 'juan'@'localhost';

-- Otorgar múltiples privilegios
GRANT SELECT, INSERT, UPDATE ON empresa.* TO 'empleado'@'%';

-- Otorgar todos los privilegios en toda la BD
GRANT ALL PRIVILEGES ON empresa.* TO 'administrador'@'localhost';

-- Otorgar privilegios en todas las bases de datos
GRANT SELECT ON *.* TO 'consultor'@'%';

-- Otorgar un rol a un usuario
GRANT admin TO 'juan'@'localhost';
```

**Nota:** GRANT puede asignar uno o varios privilegios a un usuario o un rol.

---

#### **Activación de Roles**

Los roles en MySQL **por defecto están desactivados** cuando son asignados. Por lo que al dar un rol a un usuario o varios, aunque tengan el rol, **este no tendrá funcionalidad ninguna**.

**Para poder activar un rol existen dos alternativas:**

**Opción 1 - Activación Manual por el Usuario:**

El usuario, al conectarse, ejecuta la activación del rol manualmente:

```sql
-- El usuario ejecuta al conectarse
SET ROLE 'nombre_rol';
```

**Opción 2 - Activación Automática (Recomendado):**

El 'root' tras asignar el rol al usuario, establece dicho rol como predeterminado. De esta forma, automáticamente al conectarse el usuario, su rol se activará:

```sql
-- El administrador establece el rol como predeterminado
SET DEFAULT ROLE 'nombre_rol' FOR 'nombre_usuario'@'localhost';
```

**Ejemplo Completo:**

```sql
-- 1. Crear el rol
CREATE ROLE empleado;

-- 2. Otorgar privilegios al rol
GRANT SELECT, INSERT, UPDATE ON empresa.* TO empleado;

-- 3. Crear usuario
CREATE USER 'juan'@'localhost' IDENTIFIED BY 'contraseña123';

-- 4. Asignar rol al usuario
GRANT empleado TO 'juan'@'localhost';

-- 5. Activar el rol automáticamente
SET DEFAULT ROLE empleado FOR 'juan'@'localhost';
```

---

#### **REVOKE - Revocar Privilegios**

La sentencia **REVOKE** se usa para **quitar privilegios previamente otorgados a un usuario o rol**.

**Sintaxis General:**

```sql
REVOKE Privilegio ON Nombre_BD.Nombre_tabla FROM Usuario_o_rol;
```

**Ejemplos:**

```sql
-- Revocar SELECT de un usuario en una tabla específica
REVOKE SELECT ON empresa.empleados FROM 'juan'@'localhost';

-- Revocar múltiples privilegios
REVOKE SELECT, INSERT, UPDATE ON empresa.* FROM 'empleado'@'%';

-- Revocar todos los privilegios en una base de datos
REVOKE ALL PRIVILEGES ON empresa.* FROM 'administrador'@'localhost';

-- Revocar un rol de un usuario
REVOKE admin FROM 'juan'@'localhost';
```

**Notas Importantes:**

- Para revocar un rol, se usa la misma sintaxis que para otorgarlo, pero con REVOKE en lugar de GRANT.
- Si se revoca un rol de un usuario, este perderá todos los privilegios asociados a ese rol.
- Para revocar privilegios específicos, se debe especificar exactamente los mismos privilegios y objetos que se otorgaron con GRANT.

---
<div style="page-break-after: always;"></div>

## **7. DML - DATA MANIPULATION LANGUAGE**

El **DML (Data Manipulation Language)** es el conjunto de **instrucciones de SQL diseñadas para trabajar con los datos** almacenados en una base de datos.

Mientras que el DDL define la **estructura**, el DML se encarga de **operar directamente sobre la información** que vive dentro de esa estructura.

Este sublenguaje permite realizar **acciones esenciales** dentro de cualquier sistema de información:

- **Consulta** (SELECT) - Recuperar datos
- **Inserción** (INSERT) - Agregar nuevos datos
- **Actualización** (UPDATE) - Modificar datos existentes
- **Eliminación** (DELETE) - Borrar datos

**Nota:** El desarrollo detallado de DML será tratado en temas posteriores dedicados a consultas y manipulación de datos.

---
