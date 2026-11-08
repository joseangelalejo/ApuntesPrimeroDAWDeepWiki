# Apuntes básicos sobre Clases y Objetos en Java - José Ángel Alejo Sillero

- [Apuntes básicos sobre Clases y Objetos en Java - José Ángel Alejo Sillero](#apuntes-básicos-sobre-clases-y-objetos-en-java---josé-ángel-alejo-sillero)
  - [INTRODUCCIÓN - CONCEPTOS BÁSICOS DE POO EN JAVA](#introducción---conceptos-básicos-de-poo-en-java)
  - [Proyectos Java](#proyectos-java)
  - [Flujos de salida y entrada de datos en Java](#flujos-de-salida-y-entrada-de-datos-en-java)
    - [Flujos de salida](#flujos-de-salida)
    - [Flujos de entrada](#flujos-de-entrada)
      - [Métodos (System.in)](#métodos-systemin)
        - [**Método `.read()`**](#método-read)
        - [Método `bufferedReader` con `InputStreamReader`](#método-bufferedreader-con-inputstreamreader)
        - [**Clase `Scanner`**](#clase-scanner)
        - [`BufferedReader` VS `Scanner`](#bufferedreader-vs-scanner)

## INTRODUCCIÓN - CONCEPTOS BÁSICOS DE POO EN JAVA

Los lenguajes POO se basan en el concepto de **clases** y **objetos**, y tienen la **ventaja de permitir la reutilización del código y la modularidad**. Esto se debe a que el usuario puede crear nuevas clases basadas en clases existentes, nuevos objetos que comparten características y comportamientos comunes, y organizar el código en módulos independientes.

La **CLASE** es el "manual" o plantilla que utilizamos para crear objetos. Nos indica **las características y comportamientos que tendrán los objetos creados a partir de esa clase**.

Las **características** de una clase se llaman **atributos**, y los **comportamientos** se llaman **métodos**.

Los **métodos** de una clase son las acciones que pueden realizar los objetos de esa clase, y pueden ser establecidos dentro de la clase, de manera que todos los objetos de esa clase compartan esos métodos establecidos por defecto O por el usuario.

Los **objetos son instancias de una clase**. Cada objeto tiene sus propios valores para las características definidas en la clase. Si hemos creado una clase `Coche`, podemos crear varios objetos de esa clase, como `miCoche`, `tuCoche`, etc.

Respecto a los objetos, los **atributos son las propiedades o características que describen el estado de un objeto**. Por ejemplo, en una clase `Coche`, los atributos podrían ser `color`, `marca`, `modelo`, `año`, etc. Los atributos son a lo que en clases anteriores nos hemos referido como "variables de instancia".

En el caso de una clase `Triangulo`, los atributos podrían ser `base` y `altura`.

Por tanto, puede haber **varios objetos de una misma clase**, y aunque **todos tendrán los mismos atributos**, cada **objeto tendrá sus propios valores para los atributos definidos en la clase**.

Un **método es una acción que puede realizar un objeto**.

Todos los proyectos tendrán **una clase principal** `public class NombreClase { ... }` y sólo podré tener una **clase pública por archivo** `.java`. Además, la clase principal debe tener el mismo nombre que el archivo.

Dentro de la clase principal, tendremos el método `public static void main(String[] args) { ... }`, que es el punto de entrada del programa y donde se ejecuta el código.

En este ejemplo, `ProgramacionJava` es la clase principal que contiene dos atributos (`atributo1` y `atributo2`) y el método `main`, que imprime "Hola, Mundo!" en la consola.

```java
public class ProgramacionJava {
    // Atributos
    int atributo1;
    String atributo2;

    // Método principal
    public static void main(String[] args) {
        // Código de ejecución
        System.out.println("Hola, Mundo!");
    }
}
```

**Para definir o crear una clase en Java**, utilizamos la palabra clave `class`, seguida del nombre de la clase y un par de llaves `{}` que encierran el cuerpo de la clase. Dentro del cuerpo de la clase, podemos definir atributos y métodos.

Para poder crear objetos de una clase, necesitamos un **constructor**, que es un método especial que se utiliza para inicializar los atributos del objeto cuando se crea una instancia de la clase. El constructor tiene el mismo nombre que la clase y no tiene un tipo de retorno.

En este ejemplo, hemos **definido una clase** `Triangulo` con **dos atributos** (`base` y `altura`), un **constructor para inicializar estos atributos**, **y un método** `calcularArea()` que calcula el área del triángulo.

```java
public class Triangulo {
    class Triangulo {

        // Atributos
        float base;
        float altura;

        // Constructor. El constructor tiene el mismo nombre que la clase.
        public Triangulo(float base, float altura) {
            this.base = base;          // "this" se refiere al atributo de la clase.
            this.altura = altura;
        }

        // Método para calcular el área del triángulo
        public float calcularArea() {
            return (base * altura) / 2;
        }
    }
}
```

Si queremos utilizar la clase `Triangulo` en nuestro método `main`, podemos hacerlo de la siguiente manera:

```java
import java.util.Scanner;
public class ProgramaTriangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creamos un objeto Scanner para leer la entrada del usuario

        System.out.print("Introduce la base del triángulo: ");
        float base = scanner.nextFloat(); // Leer la base
        System.out.print("Introduce la altura del triángulo: ");
        float altura = scanner.nextFloat(); // Leer la altura

        // Crear un objeto miTriangulo de la clase Triangulo con los valores introducidos
        Triangulo miTriangulo = new Triangulo(base, altura);

        // Calcular y mostrar el área

        float area = miTriangulo.calcularArea();
        System.out.println("El área del triángulo es: " + area);

        // Creamos otro objeto Triangulo 
    }
}
```

## Proyectos Java

Un proyecto de Java es una colección organizada de archivos y recursos que conforman una aplicación o programa desarrollado en el lenguaje de programación Java. Un proyecto Java incluye paquetes, clases, bibliotecas y otros recursos necesarios para construir y ejecutar la aplicación.

Dentro de un proyecto Java, las clases se organizan en **paquetes** (packages) que ayudan a estructurar el código y evitar conflictos de nombres. Cada paquete puede contener múltiples clases relacionadas.

En los paquetes encontramos los archivos `.java`, que contienen el código fuente de las clases.

Por tanto, un archivo `.java` contiene la definición de una clase o varias clases (aunque sólo una puede ser pública y debe coincidir con el nombre del archivo).

Dentro del archivo `.java`, SÓLO puede haber UNA clase pública, y el nombre de esa clase siempre coincidirá con el nombre del archivo.

A continuación de la clase pública, se define la clase principal o MAIN, típicamente llamada `public static void main(String[] args) { ... }`, que es el punto de entrada del programa.

Por tanto, la estructura típica dentro de un archivo Java es el siguiente:

```java
// Declaración del paquete
package com.mycompany.myproject;    // Nombre por defecto para paquetes

public class MiClasePublica {      // Clase pública que coincide con el nombre del archivo
    // Atributos y métodos de la clase pública

    public static void main(String[] args) {   // Método principal (punto de entrada)
        // Sentencias de ejecución (bloque de código)
    }
}
```

## Flujos de salida y entrada de datos en Java

Los **flujos de salida** se utilizan para escribir datos hacia una fuente externa, como la consola, un archivo o una red. Típicamente con métodos `(System.out)`.
Los **flujos de entrada** se utilizan para leer datos desde una fuente externa, como el teclado, un archivo o una red. Típicamente con métodos `(System.in)`.

### Flujos de salida

Los **flujos de salida** se utilizan para escribir datos hacia una fuente externa, como la consola, un archivo o una red.
Normalmente, se utiliza la clase `System.out` para imprimir datos en la consola, pues es la salida estándar más simple y común.

- La clase `System.out` tiene varios métodos para imprimir datos:
  - `print("Datos")`: Imprime datos sin agregar un salto de línea.
  - `println("Datos")`: Imprime datos y agrega un salto de línea al final.
  - `printf()`: Permite formatear la salida de datos usando especificadores de formato.

En el uso de `System.out`, con el método `printf()`, la sintaxis es diferente a la de `print()` y `println()`, ya que `printf()` requiere una cadena de formato y los valores a imprimir.
Por ejemplo:

```java
public static void main(String[] args) {
    // Sentencias

    double marcos = 3.12792631263123186241; // Variable tipo double declarada y se le asigna un valor.
    String nombre="Miguel";

    System.out.println("Tienes que pagar: " + marcos + "€"); // Imprime el valor de marcos con println, pero la variable se imprimirá con muchos decimales.
    // Si queremos limitar los decimales, usamos printf:

    System.out.printf("\nTienes que pagar: %.2f €", marcos);
    // Donde:
    // %.2f indica que queremos imprimir un número de punto flotante (float o double) con 2 decimales.
        // El símbolo % indica el inicio de un especificador de formato.
        // .2 indica que queremos 2 dígitos después del punto decimal.
        // f indica que el valor es un número de punto flotante (float o double).
    // ", marcos" indica la variable cuyo valor queremos imprimir. Donde:
        // "," separa la cadena de formato del valor a imprimir.
        // "marcos" es la variable que contiene el valor a imprimir.

    // Si queremos imprimir más de una variable, podemos añadir más especificadores de formato en la cadena y separar los valores con comas. Los valores se asignan en el mismo orden que los especificadores de formato.

    System.out.printf("\nHola, %s. Tienes que pagar: %.2f €", nombre, marcos);
    // Donde:
        // %s indica que queremos imprimir una cadena de texto (String).
        // El resto es igual que antes, pero ahora añadimos el valor "nombre" para imprimir la cadena de texto.

    // Para indicar con printf que un valor es positivo o negativo
}
```

### Flujos de entrada

Los **flujos de entrada** se utilizan para leer datos desde una fuente externa, como el teclado, un archivo o una red.

En Java, la clase `Scanner` es comúnmente utilizada para leer datos desde la entrada estándar (teclado).

Ahora bien, para utilizar la clase `Scanner`, primero debemos importarla desde el paquete `java.util`, que es una biblioteca estándar de Java con las funcionalidades más comunes en Java.

La sintaxis para importar la clase es la siguiente: `import java.util.Scanner;`. Las clases importadas deben ir al principio del archivo Java, entre la declaración del paquete (si existe) y la definición de la clase pública.

Una vez importada la clase `Scanner`, podemos crear un objeto de esta clase para leer datos desde la entrada estándar (teclado).

La sintaxis para crear un objeto `Scanner` es la siguiente: `Scanner scanner = new Scanner(System.in);`. Donde:

- `Scanner` es el nombre de la clase.
- `scanner` es el nombre del objeto que estamos creando (puede ser cualquier nombre válido).
- `new Scanner(System.in)` es la instrucción que crea una nueva instancia de la clase `Scanner`, utilizando `System.in` como fuente de entrada (teclado).
  - `(System.in)` en el siguiente subapartado.

Por último, cuando acabamos de utilizar el objeto `Scanner`, es una buena práctica cerrarlo para liberar los recursos asociados. Esto se hace llamando al método `close()` del objeto `Scanner`: `scanner.close();` DENTRO del método `main`, una vez que ya no necesitemos leer más datos.

De esta manera, la estructura básica en un documento Java para utilizar la clase `Scanner` sería la siguiente:

```java
import java.util.Scanner;  // Importar la clase Scanner
public class MiPrograma {   // Definición de la clase pública
    public static void main(String[] args) {   // Método principal
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para leer datos desde el teclado

        // Aquí podemos utilizar el objeto scanner para leer datos

        scanner.close(); // Cerrar el objeto Scanner cuando ya no lo necesitemos
    }
}
```

#### Métodos (System.in)

`System.in` tiene distintos métodos. Los más comunes son:

- `.read()`
- `bufferedReader` junto a `InputStreamReader`
- `Scanner`

Para utilizar estos métodos, debemos entender que es el **`buffer` o búfer de entrada**, que es una zona de memoria temporal donde se almacenan los datos que se van a leer desde la entrada estándar (teclado) antes de ser procesados por el programa.

El buffer, **de manera estándar, puede almacenar hasta 8192 bytes de datos**, que se almacenarán temporalmente hasta que el programa los lea (utilice).

Es decir, almacenará bits hasta que se presione la tecla "Enter".

##### **Método `.read()`**

Uno de ellos es `System.in.read()`, que lee un solo byte de datos desde la entrada estándar (teclado) y devuelve su valor como un entero (código ASCII).

El problema es que interpreta e imprime los valores introducidos uno a uno, siendo poco efectivo.

##### Método `bufferedReader` con `InputStreamReader`

Por ello, lo que realmente se utiliza en su lugar es la clase **`BufferedReader`** junto con la clase **`InputStreamReader`** para leer líneas completas de texto desde la entrada estándar.

Es más eficiente y fácil de usar que `System.in.read()`.

SÍ es muy **útil para leer ficheros de texto o strings largos** desde la entrada estándar.

Para utilizar los distintos métodos de entrada y salida, **importamos `java.io.*`** al principio del archivo Java.

La sintaxis básica para utilizar `BufferedReader` es la siguiente:

```java
import java.io.*;

public class MiPrograma {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Crear un objeto BufferedReader para leer datos desde el teclado
        
        reader.readLine(); // Leer una línea completa de texto desde la entrada estándar

        reader.close(); // Cerrar el objeto BufferedReader cuando ya no lo necesitemos
    }
}
```

El problema de `BufferedReader` es que no va a comtemplar posibles excepciones que puedan surgir al leer datos. Se puede manejar utilizando `try-catch`, pero aún no lo contemplaremos.

Por ello, en la mayoría de casos utilizaremos la clase `Scanner`, que es más sencilla y manejable para la mayoría de casos.

##### **Clase `Scanner`**

La clase `Scanner` es una clase de Java que se utiliza para **leer datos desde diversas fuentes**, como la entrada estándar (teclado), archivos, cadenas de texto, etc.

Debe ser importada desde el paquete `java.util` al principio del archivo Java, utilizando la instrucción `import java.util.Scanner;`.

El objeto `Scanner` se crea utilizando la sintaxis `Scanner scanner = new Scanner(System.in);`, donde `System.in` indica que la fuente de datos es la entrada estándar (teclado).

Y se debe cerrar el objeto `Scanner` utilizando el método `close()` cuando ya no se necesite leer más datos.

Su sintaxis básica es:

```java
import java.util.Scanner;
public class MiPrograma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para leer datos desde el teclado
        
        scanner.nextLine(); // Leer una línea completa de texto desde la entrada estándar

        scanner.close(); // Cerrar el objeto Scanner cuando ya no lo necesitemos
    }
}
```

Cuando utilicemos la clase `Scanner`, los datos se almacenan en variables del tipo de dato correspondiente, como `int`, `float`, `double`, `String`, etc. Dentro del buffer de entrada del objeto `Scanner`.

Por ello, si utilizamos la clase `Scanner` con distintos tipos de datos, utilizando el método correspondiente al tipo, debemos tener en cuenta que el buffer de entrada puede contener datos residuales que podrían afectar la lectura de los siguientes datos.

Para evitar arrastrar datos residuales almacenados en el buffer, es recomendable "limpiarlo" utilizando el método `nextLine()` después de leer un dato numérico (como `nextInt()`, `nextFloat()`, etc.) antes de leer una cadena con `nextLine()`. Aunque en realidad, más que "limpiar", lo que hacemos es **consumir el salto de línea pendiente en el buffer**.

Por ejemplo:

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para leer datos desde el teclado
    
    System.out.print("Introduce un número entero: ");
    int numero = scanner.nextInt(); // Leer un número entero

    scanner.nextLine(); // Limpiar el buffer de entrada antes de leer una cadena

    System.out.print("Introduce una línea de texto: ");
    String texto = scanner.nextLine(); // Leer una línea completa de texto

    scanner.close(); // Cerrar el objeto Scanner cuando ya no lo necesitemos
}
```

El método `next();` lee el siguiente token (palabra o dato) del buffer de entrada, mientras que `nextLine();` lee toda la línea completa hasta el salto de línea.

##### `BufferedReader` VS `Scanner`

`BufferedReader`es **más eficiente para grandes cantidades de datos**, porque tiene un buffer propio y **lee líneas completas de texto** de una sola vez. Sin embargo, es más complejo de usar y requiere manejo de excepciones.

`Scanner`es **más fácil de usar y proporciona métodos convenientes** para leer diferentes tipos de datos (enteros, flotantes, cadenas, etc.). Sin embargo, es más lento, porque lee datos uno por uno y no tiene un buffer propio tan eficiente como `BufferedReader`.
