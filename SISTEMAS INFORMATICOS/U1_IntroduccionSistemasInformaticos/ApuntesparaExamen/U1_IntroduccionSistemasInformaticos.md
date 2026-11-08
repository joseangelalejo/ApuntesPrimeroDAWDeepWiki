# **UNIDAD 1 - INTRODUCCIÓN A LOS SISTEMAS INFORMÁTICOS. COMPONENTES Y CARACTERÍSTICAS**

- [**UNIDAD 1 - INTRODUCCIÓN A LOS SISTEMAS INFORMÁTICOS. COMPONENTES Y CARACTERÍSTICAS**](#unidad-1---introducción-a-los-sistemas-informáticos-componentes-y-características)
  - [**1. INTRODUCCIÓN A CONCEPTOS BÁSICOS INFORMÁTICOS**](#1-introducción-a-conceptos-básicos-informáticos)
  - [**2. SISTEMAS DE NUMERACIÓN**](#2-sistemas-de-numeración)
    - [**Bits, Bytes y Equivalencias en los Sistemas de Numeración**](#bits-bytes-y-equivalencias-en-los-sistemas-de-numeración)
    - [**Tabla de Equivalencias (0-15)**](#tabla-de-equivalencias-0-15)
    - [**Conversión entre Sistemas de Numeración**](#conversión-entre-sistemas-de-numeración)
      - [**Ejemplos de Conversiones**](#ejemplos-de-conversiones)
  - [**3. ELEMENTOS FUNCIONALES DE UN ORDENADOR DIGITAL**](#3-elementos-funcionales-de-un-ordenador-digital)
    - [**ARQUITECTURA BÁSICA DE VON NEUMANN**](#arquitectura-básica-de-von-neumann)
      - [**Componentes de un ordenador Arquitectura de Von Neumann**](#componentes-de-un-ordenador-arquitectura-de-von-neumann)
  - [**4. TIPOS DE SOFTWARE**](#4-tipos-de-software)
    - [Software de Sistema](#software-de-sistema)
    - [Software de Aplicación](#software-de-aplicación)
    - [Software de Programación](#software-de-programación)
  - [**5. PROCESO DE ARANQUE DE UN ORDENADOR**](#5-proceso-de-aranque-de-un-ordenador)
  - [**6. COMPONENTES CRÍTICOS DE UN ORDENADOR**](#6-componentes-críticos-de-un-ordenador)
    - [**PLACA BASE**](#placa-base)
      - [**Partes principales de la Placa base:**](#partes-principales-de-la-placa-base)
      - [**Tipos de Placas Base:**](#tipos-de-placas-base)
    - [**BUSES**](#buses)
    - [**CPU y MICROPROCESADORES**](#cpu-y-microprocesadores)
      - [**Microprocesador**](#microprocesador)
      - [**Tipos de memoria en la CPU**](#tipos-de-memoria-en-la-cpu)
      - [Tecnología Hyper-Threading](#tecnología-hyper-threading)
      - [**Nomenclatura de las CPU**](#nomenclatura-de-las-cpu)
    - [**MEMORIAS PRINCIPALES, SECUNDARIAS Y ROM**](#memorias-principales-secundarias-y-rom)
      - [**Memorias Principales o Primarias**](#memorias-principales-o-primarias)
        - [**Tipos de Memoria RAM:**](#tipos-de-memoria-ram)
      - [**Memorias Secundarias**](#memorias-secundarias)
      - [**Memoria ROM y BIOS/UEFI**](#memoria-rom-y-biosuefi)
      - [**Memoria Virtual**](#memoria-virtual)
    - [**TARJETA GRÁFICA - GPU (Unidad de Procesamiento Gráfico)**](#tarjeta-gráfica---gpu-unidad-de-procesamiento-gráfico)
      - [Partes principales](#partes-principales)
      - [Tipos de tarjetas gráficas](#tipos-de-tarjetas-gráficas)
    - [**PERIFÉRICOS DE ENTRADA/SALIDA y HÍBRIDOS**](#periféricos-de-entradasalida-y-híbridos)
      - [**Tipos de periféricos**](#tipos-de-periféricos)

## **1. INTRODUCCIÓN A CONCEPTOS BÁSICOS INFORMÁTICOS**

>- **Informática**: Nace de la combinación de "información" y "automática". Conjunto de conocimientos científicos y técnicas que hacen posible el tratamiento automático de la información mediante dispositivos electrónicos.
>- **Ordenador**: Máquina que permite almacenar, transmitir y gestionar información a través de dispositivos electrónicos de entrada y salida.
>- **Sistema Informático**: Conjunto de elementos que se relacionan entre sí para procesar y almacenar información. Incluye:
>   - **Hardware**: Parte física del sistema informático (componentes electrónicos, eléctricos, mecánicos).
>   - **Software**: Conjunto de programas y aplicaciones que permiten el funcionamiento del hardware.

Algunas de las aplicaciones/software más significativas son:

>- **Comunicación:** Email, redes sociales y mensajería instantánea.
>- **Educación:** Herramientas de aprendizaje en línea, bibliotecas digitales y plataformas educativas.
>- **Economía:** Banca en línea, comercio electrónico y gestión financiera.
>- **Salud:** Gestión hospitalaria, telemedicina y análisis de datos médicos.
>- **Entretenimiento:** Videojuegos, streaming de video y música.

## **2. SISTEMAS DE NUMERACIÓN**

Los **Sistemas de Numeración** representan valores numéricos. Son el conjunto de reglas, convenios y símbolos que permiten expresar un número. Según el **teorema fundamental de la numeración**, cualquier número puede ser representado en diferentes bases, lo que permite la conversión de números representados en binario, octal o decimal.

- **Sistema Decimal (Base 10)**: Utiliza diez símbolos (0-9). Cada posición representa una potencia de 10.
- **Sistema Binario (Base 2)**: Utiliza dos símbolos (0 y 1). Cada posición representa una potencia de 2.
- **Sistema Octal (Base 8)**: Utiliza ocho símbolos (0-7). Cada posición representa una potencia de 8.
- **Sistema Hexadecimal (Base 16)**: Utiliza dieciséis símbolos (0-9 y A-F). Cada posición representa una potencia de 16.

El **Sistema binario** es el más extendido por su simplicidad y eficiencia para representar y procesar datos. Todos los lenguajes de programación (alto nivel) se traducen a binario para ser ejecutados por el hardware.

Los datos se expresan en **Hexadecimal** cuando hay una larga secuencia de bits, facilitando su lectura y escritura.

### **Bits, Bytes y Equivalencias en los Sistemas de Numeración**

- **Bit**: Unidad mínima de información en un sistema binario, puede tener dos valores (0 o 1).
- **Byte**: Conjunto de 8 bits. Representa un carácter (letra, número o símbolo) en la mayoría de los sistemas informáticos.

**Un byte en Binario son 8 bits, en Decimal serán 8 bits, en Octal son 10 bits y en Hexadecimal son 2 bits.**
Ejemplo: 01000001 en Binario es 65 en Decimal, 101 en Octal y 41 en Hexadecimal.

### **Tabla de Equivalencias (0-15)**

| **OCTAL** | **HEXADECIMAL** | **DECIMAL** | **BINARIO** |
|:-----:|:-----------:|:------:|:------:|
|  0    |      0      |   0    |  0000  |
|  1    |      1      |   1    |  0001  |
|  2    |      2      |   2    |  0010  |
|  3    |      3      |   3    |  0011  |
|  4    |      4      |   4    |  0100  |
|  5    |      5      |   5    |  0101  |
|  6    |      6      |   6    |  0110  |
|  7    |      7      |   7    |  0111  |
|   -   |      8      |   8    |  1000  |
|   -   |      9      |   9    |  1001  |
|   -   |      A      |   10   |  1010  |
|   -   |      B      |   11   |  1011  |
|   -   |      C      |   12   |  1100  |
|   -   |      D      |   13   |  1101  |
|   -   |      E      |   14   |  1110  |
|   -   |      F      |   15   |  1111  |

### **Conversión entre Sistemas de Numeración**

- **De `Binario` a `Decimal`**: Se multiplica cada bit por 2 elevado a la posición del bit (de derecha a izquierda, comenzando en 0) y se suman los resultados.
- **De `Decimal` a `Binario`**: Se divide el número decimal entre 2, anotando el residuo. Se repite el proceso con el cociente hasta que sea 0. Los residuos leídos en orden inverso forman el número binario.
- **De `Decimal` a `Octal/Hexadecimal`**: Similar al proceso de conversión a binario, pero dividiendo entre 8 para octal y 16 para hexadecimal.
- **De `Octal`/`Hexadecimal` a `Decimal`**: Se multiplica cada dígito por 8 (octal) o 16 (hexadecimal) elevado a la posición del dígito y se suman los resultados.
- **Entre `Binario`, `Octal` y `Hexadecimal`**: Se agrupan los bits en conjuntos de 3 (para octal) o 4 (para hexadecimal) y se convierten directamente a su equivalente en la base deseada.

#### **Ejemplos de Conversiones**

| Conversión | Ejemplo | Proceso | Resultado |
|------------|---------|---------|-----------|
| Binario a Decimal | 1011₂ | (1×2³) + (0×2²) + (1×2¹) + (1×2⁰) = 8 + 0 + 2 + 1 | 11₁₀ |
| Decimal a Binario | 13₁₀ | 13 ÷ 2 = 6 r1, 6 ÷ 2 = 3 r0, 3 ÷ 2 = 1 r1, 1 ÷ 2 = 0 r1 → 1101 | 1101₂ |
| Decimal a Octal | 42₁₀ | 42 ÷ 8 = 5 r2, 5 ÷ 8 = 0 r5 → 52 | 52₈ |
| Decimal a Hexadecimal | 255₁₀ | 255 ÷ 16 = 15 r15 (F), 15 ÷ 16 = 0 r15 (F) → FF | FF₁₆ |
| Octal a Decimal | 52₈ | (5×8¹) + (2×8⁰) = 40 + 2 | 42₁₀ |
| Hexadecimal a Decimal | FF₁₆ | (15×16¹) + (15×16⁰) = 240 + 15 | 255₁₀ |
| Binario a Octal | 101101₂ | Agrupar en 3 bits: 101 101 → 5₈ 5₈ | 55₈ |
| Binario a Hexadecimal | 11111111₂ | Agrupar en 4 bits: 1111 1111 → F₁₆ F₁₆ | FF₁₆ |
| Octal a Binario | 52₈ | 5₈ = 101₂, 2₈ = 010₂ | 101010₂ |
| Hexadecimal a Binario | FF₁₆ | F₁₆ = 1111₂, F₁₆ = 1111₂ | 11111111₂ |

---

## **3. ELEMENTOS FUNCIONALES DE UN ORDENADOR DIGITAL**

Se puede definir un **ordenador como un dispositivo electrónico capaz de recibir datos de entrada y procesarlos para generar información de salida útil**.

Un ordenador está compuesto por:

- **Elementos eléctricos**: Constituye la multitud de resistencias, transistores, condensadores, etc., que forman los circuitos electrónicos.
- **Puertas lógicas**: Pequeños circuitos que pueden estar abiertos con ausencia de voltaje o cerrados con el paso de corriente, están formados por elementos eléctricos.
- **Circuitos integrados**: Conjunto de puertas lógicas. Son los que reciben los datos de entrada y dan como resultado una salida concreta de combinación de puertas lógicas.
- **Sistema de numeración**: Formados por circuitos integrados, los datos de entrada son valores numéricos definidos en un sistema de numeración, en el caso de los ordenadores, el sistema binario.

---

### **ARQUITECTURA BÁSICA DE VON NEUMANN**

**La arquitectura de Von Neumann es un modelo de diseño para un sistema informático que describe una estructura básica y que define el comportamiento de un ordenador digital.**

Se basa en la idea de que un ordenador puede ser descrito en términos de sus componentes principales y sus interacciones. Imagina que el ordenador es una cocina en la que tienes un cocinero (la CPU), una lista de recetas (instrucciones en la memoria), ingredientes (datos en la memoria), y un camino entre la despensa y el cocinero (el bus de datos). Así es como se ve el proceso:

1. La **CPU** obtiene una instrucción de la memoria. (como buscar una receta).
2. La **UC (Unidad de Control)** interpreta la instrucción y decide qué hacer (como leer la receta para ver qué paso seguir).
3. Si necesita los datos, los **recoge de la memoria** (como tomar los ingredientes de la despensa).
4. La **ALU (Unidad Aritmético-Lógica)** realiza las operaciones necesarias (como mezclar ingredientes o cocinar).
5. **Guardar el resultado de vuelta en la memoria** (como poner el plato terminado en la mesa).
6. Los **BUS** (series de conexiones eléctricas que conectan la CPU, la memoria y los dispositivos de entrada/salida) conectan todos estos componentes, permitiendo que la información fluya entre ellos (como el camino entre la despensa y el cocinero).

#### **Componentes de un ordenador Arquitectura de Von Neumann**

- **Unidad de Entrada**: Dispositivos que permiten al usuario introducir datos e instrucciones en el sistema (teclado, ratón, escáner).
- **Unidad de Salida**: Dispositivos que muestran o transmiten los resultados del procesamiento al usuario (monitor, impresora, altavoces).
- **Unidad Central de Proceso (CPU)**: Es el cerebro del ordenador, encargado de ejecutar las instrucciones y procesar los datos. Está compuesta por:
  - **Unidad Aritmético-Lógica (ALU)**: Realiza operaciones matemáticas y lógicas.
  - **Unidad de Control (UC)**: Parte de la CPU que dirige el flujo de datos e instrucciones dentro del sistema.

---

## **4. TIPOS DE SOFTWARE**

### Software de Sistema

El **`Software de sistema` es el conjunto de programas y utilidades que gestionan los recursos del hardware y proporcionan una plataforma para ejecutar aplicaciones**. Incluye: Sistemas operativos, firmware, controladores de dispositivos y utilidades del sistema.

El **`Software de sistema`** se puede clasificar en Software embebido y Controladores (drivers).

- **`Software embebido`**: Programas integrados en dispositivos electrónicos que sin ser ordenadores los utilizan para controlar su funcionamiento. Como ejemplo tenemos el **Firmware**.
  - **`Firmware`**: Software permanente almacenado en memoria no volátil (ROM, EEPROM) que controla el hardware básico del dispositivo. Es esencial para el arranque y funcionamiento inicial del sistema. Como ejemplo tenemos la `BIOS` o `UEFI` de un ordenador.
- **`Controladores (drivers)`**: Programas que permiten la comunicación entre el sistema operativo y el hardware específico (impresoras, tarjetas gráficas).

### Software de Aplicación

El **`Software de aplicación` son programas diseñados para realizar tareas específicas para el usuario**, como procesadores de texto, hojas de cálculo, navegadores web y aplicaciones multimedia. Este software **se ejecuta sobre el `Software de sistema` y permite a los usuarios llevar a cabo actividades concretas en el ordenador**.

### Software de Programación

El **`Software de programación` incluye herramientas y entornos que facilitan el desarrollo de software**. Esto abarca compiladores, intérpretes, editores de código, entornos de desarrollo integrado (IDE) y depuradores. Estas herramientas permiten a los programadores escribir, probar y mantener código fuente de manera eficiente.

---

## **5. PROCESO DE ARANQUE DE UN ORDENADOR**

1. **ENCENDIDO**: Al encender el equipo, el **`procesador` busca el programa de arranque en una memoria no volátil (como la `ROM`) que contiene el `firmware (BIOS o UEFI)`.**
2. **FIRMWARE (BIOS/UEFI)**: El firmware realiza una serie de pruebas iniciales conocidas como `POST (Power-On Self Test)` para verificar que los componentes esenciales del hardware (memoria RAM, disco duro, teclado, etc.) están funcionando correctamente.
3. **CARGADOR DE ARRANQUE (`BOOTLOADER`)**: Una vez que las pruebas POST son exitosas, el firmware busca el cargador de arranque en el dispositivo de almacenamiento principal (como el disco duro o SSD). El **`bootloader` es responsable de cargar el sistema operativo en la memoria RAM.**
4. **INICIO DEL SISTEMA OPERATIVO**: El **bootloader carga el  `kernel`** (núcleo del sistema operativo) **en la memoria RAM y transfiere el control al sistema operativo**. El **`Sistema Operativo`** comienza a inicializar sus componentes y servicios, preparando el entorno para que el usuario pueda interactuar con el ordenador, actuando como intermediario entre el hardware y las aplicaciones del usuario.
5. **LISTO PARA EL USUARIO**: Una vez que el sistema operativo ha terminado de inicializar, presenta una interfaz de usuario (como un escritorio o una línea de comandos) y está listo para recibir comandos e instrucciones del usuario.

---

## **6. COMPONENTES CRÍTICOS DE UN ORDENADOR**

Los componentes críticos de un ordenador son aquellos que son esenciales para su funcionamiento y rendimiento. Estos incluyen:

- **Placa base (Motherboard)**: Conecta todos los componentes del ordenador, permitiendo la comunicación entre ellos.
- **Buses**: Series de conexiones eléctricas que conectan la CPU, la memoria y los dispositivos de entrada/salida, permitiendo que la información fluya entre ellos.
- **Procesador (CPU)**: Es el cerebro del ordenador, encargado de ejecutar instrucciones y procesar datos. Su velocidad y capacidad afectan directamente al rendimiento del sistema.
  - **Microprocesador**: Un solo chip que contiene la unidad de control y la unidad aritmético-lógica (ALU), responsable de ejecutar instrucciones y realizar cálculos.
- **Memorias principales y secundarias**: La memoria RAM es crucial para el rendimiento, ya que almacena datos e instrucciones que la CPU necesita acceder rápidamente. Las memorias secundarias (discos duros, SSDs) son vitales para el almacenamiento a largo plazo.
- **Tarjeta gráfica (GPU)**: Responsable del procesamiento de gráficos y visualización. Es especialmente importante para aplicaciones de diseño, juegos y edición de video.
- **Periféricos de entrada/salida**: Dispositivos que permiten la interacción del usuario con el ordenador, como teclados, ratones, monitores e impresoras.

### **PLACA BASE**

La **`Placa base`** o **`Motherboard`** es el componente principal de un ordenador que conecta y permite la comunicación entre todos los demás componentes del sistema. Actúa como una plataforma central donde se montan y conectan el procesador, la memoria RAM, las unidades de almacenamiento, las tarjetas de expansión y otros periféricos.

#### **Partes principales de la Placa base:**

- **Zócalo del procesador (CPU Socket)**: Donde se instala el microprocesador.
- **Ranuras de memoria (RAM Slots)**: Donde se insertan los módulos de memoria RAM.
- **Chipset**: Conjunto de circuitos integrados que gestionan la comunicación entre la CPU, la memoria y los dispositivos periféricos.
- **Conectores de alimentación**: Proveen energía eléctrica a la placa base y sus componentes.
- **Puertos de expansión**: Permiten la conexión de tarjetas adicionales, como tarjetas gráficas, de sonido o de red.
- **Conectores de almacenamiento**: Para conectar discos duros, SSDs y unidades ópticas.

#### **Tipos de Placas Base:**

- **ATX (Advanced Technology eXtended)**: Es el formato más común y estándar para placas base de ordenadores de escritorio. Ofrece una buena cantidad de ranuras de expansión y conectores.
- **MicroATX**: Una versión más pequeña del ATX, con menos ranuras de expansión, ideal para sistemas compactos.
- **Mini-ITX**: Aún más pequeña que la MicroATX, diseñada para sistemas de factor de forma reducido.

---

### **BUSES**

El **BUS (o Bus de datos)** es una serie de conexiones eléctricas que permiten la comunicación entre el microprocesador y otros componentes del sistema, como la memoria y los dispositivos de entrada/salida.

**Se compone de varios tipos**:

- **Bus de Sistema**: Conecta la CPU con la memoria principal y otros componentes del sistema, permitiendo la transferencia de datos e instrucciones.
- **Bus de Datos**: Transporta los datos entre la CPU, la memoria y los dispositivos periféricos. Su ancho (número de bits que puede transportar simultáneamente) afecta directamente al rendimiento del sistema.
- **Bus de Direcciones**: Transporta las direcciones de memoria donde se encuentran los datos que la CPU necesita leer o escribir. Su tamaño determina la cantidad máxima de memoria que el sistema puede direccionar.
- **Bus de Control**: Transporta señales de control que coordinan las operaciones del sistema, como señales de lectura/escritura y señales de interrupción.
- **Bus PCI (Peripheral Component Interconnect)**: Un estándar común para conectar tarjetas de expansión a la placa base.
- **Bus PCI Express (PCIe)**: Una versión más rápida y moderna del bus PCI, utilizada para tarjetas gráficas y otros dispositivos de alto rendimiento.
- **Bus USB (Universal Serial Bus)**: Un estándar para conectar dispositivos periféricos externos, como teclados, ratones y unidades de almacenamiento.
- **Bus de Expansión**: Permite la conexión de tarjetas adicionales y dispositivos periféricos, ampliando las capacidades del sistema.

---

### **CPU y MICROPROCESADORES**

La **`Unidad Central de Proceso (CPU)`** es el componente principal de un ordenador, encargado de ejecutar instrucciones y procesar datos. **Está compuesta por dos unidades principales**:

- **Unidad Aritmético-Lógica (`ALU`)**: Realiza operaciones matemáticas y lógicas.
- **Unidad de Control (`UC`)**: Dirige el flujo de datos e instrucciones dentro del sistema.

#### **Microprocesador**

El **`Microprocesador`** es un solo chip que contiene tanto la unidad de control como la unidad aritmético-lógica (ALU). Es responsable de ejecutar instrucciones y realizar cálculos. Los microprocesadores modernos pueden tener múltiples núcleos, lo que les permite ejecutar varias tareas simultáneamente, mejorando significativamente el rendimiento del sistema.

#### **Tipos de memoria en la CPU**

- **Memoria Caché**: Memoria de alta velocidad ubicada dentro de la CPU que almacena temporalmente datos e instrucciones frecuentemente utilizados para acelerar el acceso a ellos.
- **Registros**: Pequeñas unidades de almacenamiento dentro de la CPU que contienen datos e instrucciones que están siendo procesados en ese momento.

#### Tecnología Hyper-Threading

La **`tecnología Hyper-Threading`** es una característica de algunos procesadores Intel que permite que un solo núcleo físico actúe como dos núcleos lógicos. Esto significa que cada núcleo puede manejar dos hilos de ejecución simultáneamente, mejorando la eficiencia y el rendimiento en tareas multitarea y aplicaciones optimizadas para múltiples hilos.

#### **Nomenclatura de las CPU**

La **nomenclatura de las CPU** varía según el fabricante, pero generalmente incluye información sobre la serie, la generación, la velocidad del reloj y otras características clave. Por ejemplo, en un procesador Intel Core i7-10700K:

- **Core i7**: Indica la serie y el nivel de rendimiento del procesador
- **10700**: Indica la generación y el modelo específico del procesador
- **K**: Indica que el procesador está desbloqueado para overclocking.
- **Velocidad del reloj**: Medida en gigahercios (GHz), indica la velocidad a la que el procesador puede ejecutar instrucciones.
- **Número de núcleos**: Indica cuántos núcleos de procesamiento tiene la CPU, lo que afecta su capacidad para manejar múltiples tareas simultáneamente.
- **Número de hilos**: Indica cuántos hilos de ejecución puede manejar la CPU, lo que también afecta el rendimiento en tareas multitarea.
- **Caché**: Cantidad de memoria caché integrada en la CPU, que afecta la velocidad de acceso a los datos.
- **TDP (Thermal Design Power)**: Indica la cantidad máxima de calor que la CPU puede generar bajo carga máxima, lo que afecta las necesidades de refrigeración del sistema.
- **Tecnología de fabricación**: Indica el proceso de fabricación de la CPU, generalmente medido en nanómetros (nm). Un proceso más pequeño suele significar mayor eficiencia energética y rendimiento.

*Cuando un procesador no tiene letra adicional, generalmente indica que es un modelo estándar sin características especiales como overclocking o bajo consumo energético.*

---

### **MEMORIAS PRINCIPALES, SECUNDARIAS Y ROM**

#### **Memorias Principales o Primarias**

**Dentro de la CPU** existen varios tipos de memoria que juegan un papel crucial en el rendimiento del sistema:

- **Registros**: Pequeñas unidades de almacenamiento dentro de la CPU que contienen datos e instrucciones que están siendo procesados en ese momento.
- **Memoria Caché**: Memoria de alta velocidad ubicada dentro de la CPU que almacena temporalmente datos e instrucciones frecuentemente utilizados para acelerar el acceso a ellos.

**Fuera de la CPU**, la memoria principal se refiere principalmente a:

- **Memoria RAM (Random Access Memory)**: Memoria volátil que almacena datos e instrucciones que la CPU necesita acceder rápidamente durante el procesamiento. **Los datos en la RAM se pierden cuando el ordenador se apaga.**

##### **Tipos de Memoria RAM:**

- **DRAM (Dynamic RAM)**: Tipo de memoria RAM que necesita ser refrescada constantemente para mantener los datos almacenados. Es más lenta pero más económica que la SRAM.
- **SRAM (Static RAM)**: Tipo de memoria RAM que no necesita ser refrescada

#### **Memorias Secundarias**

Son dispositivos de almacenamiento a largo plazo, como discos duros (HDD), unidades de estado sólido (SSD) y unidades ópticas (CD/DVD). **Estos dispositivos retienen los datos incluso cuando el ordenador está apagado.**

- **Disco Duro (HDD)**: Dispositivo de almacenamiento magnético que utiliza platos giratorios para almacenar datos. Ofrece gran capacidad de almacenamiento a un costo relativamente bajo, pero es más lento en comparación con las SSD.
- **Unidad de Estado Sólido (SSD)**: Dispositivo de almacenamiento que utiliza memoria flash para almacenar datos. Es mucho más rápido que los discos duros tradicionales y no tiene partes móviles, lo que lo hace más resistente a golpes y vibraciones.
- **Unidades Ópticas**: Dispositivos que utilizan láseres para leer y escribir datos en discos ópticos, como CD, DVD y Blu-ray. Aunque su uso ha disminuido con la popularidad de las memorias USB y el almacenamiento en la nube, todavía se utilizan para ciertos fines, como la reproducción de medios y la instalación de software.

#### **Memoria ROM y BIOS/UEFI**

La **Memoria ROM (Read-Only Memory)**: Es una memoria no volátil de solo lectura que almacena datos e instrucciones permanentes, como el firmware del sistema. No se puede modificar fácilmente y conserva su contenido incluso cuando el ordenador está apagado.

- **BIOS/UEFI**: El firmware almacenado en la ROM que se encarga del proceso de arranque del ordenador y la inicialización del hardware.

#### **Memoria Virtual**

La `Memoria Virtual` es una técnica que utiliza espacio en el disco duro para simular memoria RAM adicional, permitiendo que el sistema operativo maneje más datos de los que físicamente caben en la RAM.

Esta técnica se divide en dos procesos: **paginación** y **segmentación**.

- **Paginación**: Divide la memoria virtual en bloques de tamaño fijo llamados páginas. Cuando la RAM está llena, las páginas menos utilizadas se trasladan al disco duro (archivo de paginación) para liberar espacio en la RAM.
- **Segmentación**: Divide la memoria virtual en segmentos de tamaño variable según las necesidades del programa. Cada segmento puede contener diferentes tipos de datos, como código, datos y pilas.

### **TARJETA GRÁFICA - GPU (Unidad de Procesamiento Gráfico)**

La **`GPU (Unidad de Procesamiento Gráfico)`** es un componente especializado en el procesamiento de gráficos y visualización. Originalmente diseñada para acelerar la renderización de imágenes y videos, las GPUs modernas también se utilizan para tareas de computación paralela debido a su capacidad para manejar múltiples operaciones simultáneamente.

#### Partes principales

- **GPU Core (equivalente a ALU de la CPU)**: El núcleo de procesamiento que realiza cálculos gráficos y de computación en paralelo de manera masiva.
- **Memoria de Video (VRAM)**: Memoria dedicada para almacenar texturas, modelos 3D y otros datos gráficos.
- **Sistema de refrigeración**: Ventiladores y disipadores de calor que mantienen la GPU a una temperatura operativa segura.
- **Interfaz de conexión**: Conecta la tarjeta gráfica a la placa base, generalmente a través de un puerto PCIe.
- **Salidas de video**: Puertos para conectar monitores, como HDMI, DisplayPort o DVI.

#### Tipos de tarjetas gráficas

- **Tarjetas Gráficas Integradas**: Integradas en la placa base o en el procesador, comparten la memoria del sistema y son adecuadas para tareas básicas como navegación web y aplicaciones de oficina.
- **Tarjetas Gráficas Dedicadas**: Componentes independientes con su propia memoria y potencia de procesamiento, diseñadas para tareas intensivas como juegos, edición de video y diseño gráfico profesional.

### **PERIFÉRICOS DE ENTRADA/SALIDA y HÍBRIDOS**

Los **`Periféricos de Entrada/Salida`** son dispositivos que permiten la interacción entre el usuario y el ordenador, facilitando la entrada de datos y la salida de información procesada.

#### **Tipos de periféricos**

- **Periféricos de Entrada**: Dispositivos que permiten al usuario introducir datos e instrucciones en el sistema. Ejemplos incluyen:
  - Teclado
  - Ratón
  - Escáner
  - Micrófono
  - Cámara web
- **Periféricos de Salida**: Dispositivos que muestran o transmiten los resultados del procesamiento al usuario. Ejemplos incluyen:
  - Monitor
  - Impresora
  - Altavoces
  - Proyector
- **Periféricos Híbridos**: Dispositivos que combinan funciones de entrada y salida. Ejemplos incluyen:
  - Pantallas táctiles.
  - Impresoras multifunción (que pueden escanear, copiar e imprimir).
  - Dispositivos de realidad virtual (VR) que permiten la interacción y visualización simultáneamente.
