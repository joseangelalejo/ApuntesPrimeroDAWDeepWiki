# **UNIDAD 1 - ALMACENAMIENTO DE LA INFORMACIÓN**

- [**UNIDAD 1 - ALMACENAMIENTO DE LA INFORMACIÓN**](#unidad-1---almacenamiento-de-la-información)
  - [**INTRODUCCIÓN**](#introducción)
  - [**DATO - INFORMACIÓN**](#dato---información)
  - [**SISTEMAS LÓGICOS DE ALMACENAMIENTO**](#sistemas-lógicos-de-almacenamiento)
    - [**Clasificación de los Sistemas Lógicos de Almacenamiento**](#clasificación-de-los-sistemas-lógicos-de-almacenamiento)
      - [**Orientado a ficheros**](#orientado-a-ficheros)
      - [**Orientado a datos estructurados**](#orientado-a-datos-estructurados)
      - [**Orientado a objetos/contenido**](#orientado-a-objetoscontenido)
  - [**FICHEROS**](#ficheros)
    - [**Clasificación de ficheros según su función**](#clasificación-de-ficheros-según-su-función)
      - [**Ficheros permanentes**](#ficheros-permanentes)
      - [**Ficheros temporales**](#ficheros-temporales)
    - [**Soportes de información**](#soportes-de-información)
      - [**Métodos de acceso**](#métodos-de-acceso)
        - [**Acceso Secuencial**](#acceso-secuencial)
        - [**Acceso Directo o Aleatorio**](#acceso-directo-o-aleatorio)
        - [**Acceso Indexado**](#acceso-indexado)
    - [**Parámetros para determinar tipo de fichero a usar**](#parámetros-para-determinar-tipo-de-fichero-a-usar)
    - [**Clasificación de ficheros según su estructura**](#clasificación-de-ficheros-según-su-estructura)
      - [**Ficheros Planos**](#ficheros-planos)
      - [**Ficheros Binarios**](#ficheros-binarios)
  - [**BASES DE DATOS (BBDD)**](#bases-de-datos-bbdd)
    - [**Clasificación según la VARIABILIDAD de los datos**](#clasificación-según-la-variabilidad-de-los-datos)
    - [**Clasificación según la NATURALEZA de los datos**](#clasificación-según-la-naturaleza-de-los-datos)
    - [**Clasificación según el MODELO DE ORGANIZACIÓN**](#clasificación-según-el-modelo-de-organización)
    - [**Clasificación según la DISTRIBUCIÓN**](#clasificación-según-la-distribución)
  - [**SISTEMAS GESTORES DE BASES DE DATOS (SGBD)**](#sistemas-gestores-de-bases-de-datos-sgbd)
    - [**Modelo ACID - Propiedades ACID**](#modelo-acid---propiedades-acid)
    - [**Fragmentación**](#fragmentación)
      - [Reglas Esenciales de Fragmentación](#reglas-esenciales-de-fragmentación)
      - [Fragmentación Horizontal (Fh)](#fragmentación-horizontal-fh)
      - [Fragmentación Vertical (Fv)](#fragmentación-vertical-fv)
      - [Fragmentación Mixta (Fh-v y Fv-h)](#fragmentación-mixta-fh-v-y-fv-h)
      - [Ventajas e Inconvenientes de la Fragmentación](#ventajas-e-inconvenientes-de-la-fragmentación)
  - [**ERS - Especificación de Requisitos de Software**](#ers---especificación-de-requisitos-de-software)
    - [**Fases en el Desarrollo de Software**](#fases-en-el-desarrollo-de-software)
      - [**Fase de Análisis**](#fase-de-análisis)
      - [**Fase de Diseño**](#fase-de-diseño)
      - [**Fase de Implementación**](#fase-de-implementación)
      - [**Fase de Pruebas**](#fase-de-pruebas)
    - [**Estructura de un Documento ERS**](#estructura-de-un-documento-ers)
      - [**Introducción**](#introducción-1)
      - [**Descripción**](#descripción)
      - [**Requisitos Funcionales**](#requisitos-funcionales)

## **INTRODUCCIÓN**

En el mercado actual, la competitividad y la rapidez de maniobra de una empresa son imprescindibles para su éxito. Para conseguirlo existe cada vez una mayor cantidad de datos y, por tanto, más necesidad de gestionarlos.

Esta demanda siempre ha estado presente en empresas y sociedades, pero debido a la evolución de las tecnologías, tanto el volumen como la necesidad se han visto incrementadas.

Las empresas que pueden manejar y utilizar eficientemente la información tienen una ventaja competitiva significativa, ya que pueden responder más rápidamente a las necesidades del mercado y ofrecer experiencias más personalizadas a sus clientes.

En este contexto, las bases de datos y los sistemas de gestión de bases de datos (SGBD) juegan un papel crucial al permitir almacenar, organizar y acceder a grandes volúmenes de información de manera eficiente y segura.

---

## **DATO - INFORMACIÓN**

En informática, se conoce como **dato** a un elemento con relevancia para un usuario o sistema:

- Fecha de nacimiento
- DNI
- Nombre
- Nacionalidad

Pero la relevancia de un dato depende del contexto en el que se utilice. Es decir, para google puede ser muy relevante la nacionalidad de un usuario, mientras que para un taller de coches no lo es en absoluto.

---

En informática, se conoce como **información** al resultado de **procesar, organizar, estructurar y contextualizar datos** para que tengan un significado y utilidad para el receptor.

---

Por tanto, decimos que:

- **Dato** = Elemento bruto sin contexto.
- **Información** = Dato procesado y contextualizado.

---

## **SISTEMAS LÓGICOS DE ALMACENAMIENTO**

Cuando una empresa guarda datos sin usar ningún tipo de estructura o sistema, aparecen problemas: duplicidades, incoherencias, dificultad para buscar, errores por concurrencia, incumplimientos legales, y cero trazabilidad.

Los **Sistemas Lógicos de Almacenamiento** nacen para solucionar eso: Definen de forma abstracta cómo se **organizan, validan, acceden y conservan los datos** independientemente del soporte físico.

Por tanto, un **Sistema Lógico de Almacenamiento** es la **abstracción** que usamos para **organizar, nombrar y acceder a la información independientemente del soporte físico**. Es la "capa mental y de software" que convierte bits en unidades con significado (directorios, ficheros, registros, tablas, etc.).

Es decir, el **sistema físico guarda bloques**, mientras que el sistema lógico decide cómo esos bloques se combinan para que el usuario vea nombres, carpetas, tipos y estructuras.

Las **CARACTERÍSTICAS** que definen un Sistema Lógico de Almacenamiento son:

- **Independencia Lógica-Física**: Permite cambiar el hardware sin afectar al sistema lógico.
- **Estructuras de organización**: Define cómo se agrupan y relacionan los datos (ficheros, tablas, etc.).
- **Metadatos**: Información sobre los datos (tipos, tamaños, relaciones).
- **Unidades de acceso**: Define cómo se accede a los datos (secuencial, directo, indexado).
- **Mecanismos de acceso**: Protocolos y métodos para leer/escribir datos.
- **Políticas de control**: Reglas para gestionar acceso, seguridad e integridad.

### **Clasificación de los Sistemas Lógicos de Almacenamiento**

#### **Orientado a ficheros**

#### **Orientado a datos estructurados**

#### **Orientado a objetos/contenido**

## **FICHEROS**

### **Clasificación de ficheros según su función**

#### **Ficheros permanentes**

#### **Ficheros temporales**

### **Soportes de información**

#### **Métodos de acceso**

##### **Acceso Secuencial**

##### **Acceso Directo o Aleatorio**

##### **Acceso Indexado**

### **Parámetros para determinar tipo de fichero a usar**

### **Clasificación de ficheros según su estructura**

#### **Ficheros Planos**

#### **Ficheros Binarios**

## **BASES DE DATOS (BBDD)**

### **Clasificación según la VARIABILIDAD de los datos**

### **Clasificación según la NATURALEZA de los datos**

### **Clasificación según el MODELO DE ORGANIZACIÓN**

### **Clasificación según la DISTRIBUCIÓN**

## **SISTEMAS GESTORES DE BASES DE DATOS (SGBD)**

Un Sistema de Gestión de Bases de Datos (SGBD) es un software que proporciona las herramientas necesarias para la creación, gestión y manipulación de bases de datos.

El **SGBD** permite realizar operaciones como insertar, actualizar, eliminar y consultar datos, asegurando la integridad y seguridad de la información.

Las **funcionalidades principales de los SGBD** son:

- **Lenguajes de consulta** (como SQL) para interactuar con la base de datos
- **Procesamiento de consultas** y optimización
- **Gestión de almacenamiento** y recuperación de datos
- **Control de concurrencia** y transacciones
- **Transacciones y propiedades ACID**
- **Recuperación ante fallos** y copias de seguridad
- **Seguridad** y control de acceso
- **Administración** de la base de datos

### **Modelo ACID - Propiedades ACID**

El modelo ACID hace referencia a un conjunto de propiedades que garantizan la seguridad, integridad y confiabilidad de las operaciones en Bases de Datos. Estos principios son imprescindibles en sistemas donde los datos son valiosos y los errores, costosos.

Las **PROPIEDADES ACID** son:

- **Atomicidad (Atomicity)**: Garantiza el **todo o nada de una transacción**. Si una transacción no se completa en su totalidad, todos los cambios realizados durante la transacción se revierten, asegurando que la base de datos permanezca en un estado consistente.
- **Consistencia (Consistency)**: Asegura la **integridad de los datos**, garantizando que cualquier transacción lleve a la base de datos de un estado válido a otro estado válido, respetando todas las reglas y restricciones definidas.
- **Aislamiento (Isolation)**: Garantiza la **independencia de las transacciones concurrentes**, evitando que los cambios realizados por una transacción sean visibles para otras hasta que se complete.
- **Durabilidad (Durability)**: Asegura la **persistencia a largo plazo** de los cambios realizados por una transacción una vez que esta ha sido confirmada, incluso en caso de fallos del sistema.

### **Fragmentación**

En **bases de datos distribuidas**, los datos se reparten en distintos servidores y ubicaciones físicas. La fragmentación consiste en dividir tablas o relaciones en partes más pequeñas para distribuirlas en diferentes sitios. Esto se hace para mejorar la eficiencia en consultas, el rendimiento del sistema y la disponibilidad de los datos.

Es importante tener en cuenta el **grado de fragmentación** que se aplicará, ya que éste es un factor determinante a la hora de la ejecución de las consultas. Se puede fragmentar:

- **Fragmentación por tuplas (filas)**: Se reparten registros completos entre diferentes fragmentos.
- **Fragmentación por atributos (columnas)**: Se reparten campos específicos de la tabla.

Lo importante es encontrar un equilibrio entre la fragmentación y la eficiencia en las consultas. Si fragmentamos de forma excesiva, los datos de la reconstrucción de los mismos perdería eficiencia.

#### Reglas Esenciales de Fragmentación

- **Completitud**: Toda la información original debe estar presente en algún fragmento o combinación de fragmentos.
- **Reconstructibilidad**: Debe ser posible reconstruir la relación original a partir de los fragmentos sin pérdida de información.
- **Disyunción**: En fragmentación vertical, la clave primaria se repite en todos los fragmentos para asegurar la unión.

#### Fragmentación Horizontal (Fh)

Se realiza **sobre las tuplas de la relación**, dividiendo la relación en subrelaciones que contienen un subconjunto de las tuplas que alberga la relación original. Existen dos variantes de la fragmentación horizontal:

- **Primaria**: Según condiciones propias de la tabla.
- **Derivada**: Según condiciones basadas en otras tablas relacionadas.

#### Fragmentación Vertical (Fv)

Se basa en los **atributos de la relación para efectuar la división**. El objetivo de la fragmentación vertical es particionar una relación en un conjunto de relaciones más pequeñas de manera que varias de las aplicaciones de usuario se ejecutarán sobre un fragmento.

La fragmentación vertical es más complicada que la horizontal, ya que existe un gran número de alternativas para realizarla.

#### Fragmentación Mixta (Fh-v y Fv-h)

Podemos combinar ambas, utilizando para ello la denominada **fragmentación mixta**, que puede ser de dos tipos:

- **Horizontal-Vertical (Fh-v)**: Se fragmenta horizontalmente y luego cada fragmento se fragmenta verticalmente.
- **Vertical-Horizontal (Fv-h)**: Se fragmenta verticalmente y luego cada fragmento se fragmenta horizontalmente.

Para representar los dos tipos de fragmentación, se utilizan árboles, donde cada nivel muestra el tipo de división aplicada.

#### Ventajas e Inconvenientes de la Fragmentación

|             **Ventajas**              |                **Desventajas**                 |
|:-------------------------------------:|:----------------------------------------------:|
|   Mejora rendimiento en consultas.    |     Complejidad en el diseño del esquema.      |
|   Mayor seguridad y disponibilidad.   |  Dificultades en la gestión de transacciones.  |
| Consultas más rápidas en cada región. |      Costes de reconstrucción de tablas.       |
|        Aumenta el paralelismo.        | Posibles redundancias si no se planifica bien. |
|                                       |                                                |

## **ERS - Especificación de Requisitos de Software**

Para el desarrollo de cualquier software, incluso la creación de una BBDD, se pasan por una serie de etapas o fases durante el proceso. El ERS (Especificación de Requisitos de Software) es un documento que recoge todos los requisitos necesarios para el desarrollo del software, sirviendo como guía para los desarrolladores y como referencia para los interesados en el proyecto.

### **Fases en el Desarrollo de Software**

#### **Fase de Análisis**

En la fase de **Análisis** se busca analizar en profundidad el problema y extraer, además de recabar la mayor cantidad de información relevante posible. Lo más común es realizar en esta fase el documento ERS (Especificación de Requisitos de Software). Para obtener la información necesaria debemos:

- Entrevistar a los interesados (clientes, usuarios finales, etc.).
- Analizar el sistema actual (si existe).
- Desarrollar casos de uso para entender cómo interactuarán los usuarios con el sistema.

#### **Fase de Diseño**

Tras la fase de análisis,**los datos obtenidos se plasman en diagramas** que permiten entender fácilmente cómo se va a realizar el software e ir acercando el problema desde la parte más abstracta a la más cercana a la implementación real. Para ello se utilizan diferentes tipos de diagramas, entre los que destacan:

- **Modelo conceptual**: Representa las entidades principales y sus relaciones.
- **Modelo lógico**: Detalla la estructura de la base de datos, incluyendo tablas, campos y relaciones.
- **Modelo físico**: Describe cómo se implementará la base de datos en un SGBD específico, incluyendo índices, particiones y otros aspectos técnicos.

#### **Fase de Implementación**

Tras finalizar los modelos anteriores, estamos tan cerca de una BBDD real, que solo faltaría **pasar al lenguaje propio de BBDD en la que queramos implementarla** (SQL, NoSQL, etc.). Cada SGBD y BD tiene un lenguaje propio, pero realmente la gran mayoría parte del lenguaje conocido como **SQL (Structured Query Language)**. En esta fase se *crean las tablas, relaciones, índices y otros objetos* de la base de datos según lo definido en los modelos anteriores.

#### **Fase de Pruebas**

Se enfoca en verificar y validar que el software desarrollado cumple con los requisitos especificados y funciona correctamente. Es crucial para identificar y corregir errores. El orden y enfoque de la fase de pruebas pueden variar dependiendo de la metodología de desarrollo, pudiendo ser:

- **En Cascada**: Se realizan pruebas exhaustivas al final del desarrollo.
- **Ágil**: Se realizan pruebas continuas e iterativas a lo largo del desarrollo.
- **DevOps**: Se integran pruebas automatizadas en el proceso de desarrollo y despliegue continuo.

### **Estructura de un Documento ERS**

El ERS es el documento que actúa como un contrato detallado entre el equipo de desarrollo y los interesados en el software que se va a desarrollar, describiendo de manera clara y precisa las funcionalidades, características y restricciones que debe tener el sistema para cumplir con las expectativas del cliente y los usuarios finales.

#### **Introducción**

- **Propósito**: Breve texto que explica cual es la finalidad de realizar este documento. El estándar que se usa (IEEE Std. 830-1998) y para qué es el proyecto.
- **Alcance** Breve texto que explica cual es la finalidad del software que se va a desarrollar y que elementos del problema abarcara y cuales no.
- ***Definiciones, Acrónicos y Abreviaturas**: Aquí se exponen aquellas palabras más técnicas, acrónimos y/o abreviaturas que a lo largo del documento aparecen.

#### **Descripción**

- **Descripción del negocio**: Breve descripción del negocio, su modelo de operaciones y la necesidad de una base de datos.
- **Descripción del problema**: Identificación de problemas y limitaciones con el sistema actual (si existe) que la nueva base de datos pretende solucionar.
- **Objetivos del proyecto**: Definición de los objetivos específicos que la Base de Datos debe cumplir para satisfacer las necesidades del negocio.

#### **Requisitos Funcionales**

- **Requisitos de Almacenamiento de Datos**: Lista de las entidades principales y sus atributos, incluyendo tablas y relaciones entre ellas.
- **Requisitos de Integridad de Datos**: Requisitos para mantener la integridad de los datos, como restricciones de unicidad, claves primarias y claves foráneas.
- **Requisitos de Seguridad de Datos**: Políticas y medidas de seguridad para proteger los datos, incluyendo control de acceso y encriptación.
- **Requisitos de Mantenimiento de Datos**: Necesidades para la actualización, eliminación y archivo de datos, incluyendo políticas de backup y recuperación.
