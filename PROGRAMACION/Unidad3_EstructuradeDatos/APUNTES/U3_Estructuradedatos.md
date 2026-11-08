# **UNIDAD 3 - Estructura de datos en JAVA**

- **Autor**: José Ángel Alejo Sillero
- **Centro**: Instituto Tecnológico Pablo de la Torre
- **Curso**: 2025/2026
- **Módulo**: Programación
- **Unidad**: 3 - Estructura de datos en JAVA

---
<div style="page-break-after: always;"></div>

- [**UNIDAD 3 - Estructura de datos en JAVA**](#unidad-3---estructura-de-datos-en-java)
  - [**INTRODUCCIÓN A ESTRUCTURAS DE DATOS EN JAVA**](#introducción-a-estructuras-de-datos-en-java)
  - [**STRINGS**](#strings)
    - [**Métodos Básicos para Manipular Strings: `length()` y `charAt()`**](#métodos-básicos-para-manipular-strings-length-y-charat)
      - [`length()`](#length)
      - [`charAt()`](#charat)
    - [**Comparación de Strings: `equals()` y `equalsIgnoreCase()`**](#comparación-de-strings-equals-y-equalsignorecase)
    - [**Transformación de Strings: `toUpperCase()` y `toLowerCase()`**](#transformación-de-strings-touppercase-y-tolowercase)
    - [**Búsqueda en Strings: `indexOf()` y `lastIndexOf()`**](#búsqueda-en-strings-indexof-y-lastindexof)
      - [`indexOf()`](#indexof)
      - [`lastIndexOf()`](#lastindexof)
    - [**Extracción de Subcadenas: `substring()`**](#extracción-de-subcadenas-substring)
    - [**División de Cadenas: `split()`**](#división-de-cadenas-split)
    - [**Limpieza de Espacios: `trim()`**](#limpieza-de-espacios-trim)
    - [**Ejemplos Prácticos y Combinaciones de Métodos**](#ejemplos-prácticos-y-combinaciones-de-métodos)
    - [**Conclusión y Notas Adicionales**](#conclusión-y-notas-adicionales)
  - [**COLECCIONES**](#colecciones)
    - [**ARRAYS EN JAVA**](#arrays-en-java)
    - [**Declaración e Inicialización de Arrays**](#declaración-e-inicialización-de-arrays)
    - [**Manipulación de Arrays - Métodos de la Clase *Arrays***](#manipulación-de-arrays---métodos-de-la-clase-arrays)
      - [Arrays.copyOf](#arrayscopyof)
      - [Arrays.copyOfRange](#arrayscopyofrange)
      - [Arrays.fill](#arraysfill)
      - [Arrays.equals](#arraysequals)
      - [Arrays.toString](#arraystostring)
      - [Arrays.sort](#arrayssort)
    - [**Consideraciones sobre Referencias en Memoria**](#consideraciones-sobre-referencias-en-memoria)
    - [**Conclusión y Notas Adicionales (Arrays)**](#conclusión-y-notas-adicionales-arrays)
  - [**ARRAYS BIDIMENSIONALES (MATRICES)**](#arrays-bidimensionales-matrices)
    - [**Operaciones con Arrays 2D**](#operaciones-con-arrays-2d)
      - [**Obtener la longitud de un array 2D**](#obtener-la-longitud-de-un-array-2d)
      - [**Obtener/Imprimir todos los valores del Array 2D (filas y columnas)**](#obtenerimprimir-todos-los-valores-del-array-2d-filas-y-columnas)
      - [**Obtener/Imprimir todos los valores de una fila o columna**](#obtenerimprimir-todos-los-valores-de-una-fila-o-columna)
      - [**Rellenar o modificar valores en arrays 2D**](#rellenar-o-modificar-valores-en-arrays-2d)
    - [**Métodos con Arrays Bidimensionales**](#métodos-con-arrays-bidimensionales)
      - [**Arrays.deepEquals()**](#arraysdeepequals)
      - [**Arrays.deepToString()**](#arraysdeeptostring)
    - [**Ejemplos Prácticos con Arrays Bidimensionales**](#ejemplos-prácticos-con-arrays-bidimensionales)
  - [**Ejercicios Propuestos**](#ejercicios-propuestos)
    - [**Ejercicios de Strings**](#ejercicios-de-strings)
    - [**Ejercicios de Arrays Unidimensionales**](#ejercicios-de-arrays-unidimensionales)
    - [**Ejercicios de Arrays Bidimensionales**](#ejercicios-de-arrays-bidimensionales)
    - [**Ejercicios Avanzados (Combinados)**](#ejercicios-avanzados-combinados)

---
<div style="page-break-after: always;"></div>

## **INTRODUCCIÓN A ESTRUCTURAS DE DATOS EN JAVA**

La estructura de datos en Java se divide en dos grandes bloques:

- **Strings**: Para manipular cadenas de texto.
- **Colecciones** (Arrays y Listas/ArrayLists): Nos centraremos en los Arrays.

---

<div style="page-break-after: always;"></div>

## **STRINGS**

Hasta ahora, para concatenar cadenas hemos usado el símbolo `+`, pero Java nos ofrece la clase `String` específica para trabajar con texto. Por ejemplo, para unir "Pepe" y "Rodriguez": `"Pepe" + "Rodriguez"`.

Además, podemos usar `Scanner` para leer strings desde la entrada del usuario, como `scanner1.nextLine()`.

### **Métodos Básicos para Manipular Strings: `length()` y `charAt()`**

#### `length()`

Devuelve la longitud de la cadena (número de caracteres). Sintaxis: `nombrecadena.length();` o directamente en una literal: `"Pepe".length();` (devuelve 4).

**Ejemplo** (del código Java):

```java
String nombre = "Pepe";
int longitud = nombre.length(); // Almacena 4
System.out.println("Pepe".length()); // Imprime 4
```

#### `charAt()`

Obtiene el carácter en una posición específica (empezando desde 0). Sintaxis: `char caracter = nombrecadena.charAt(posicion);`.

**Ejemplo** (del código Java):

```java
String nombre2 = scanner1.nextLine(); // Lee entrada del usuario
System.out.println(nombre2.charAt(nombre2.length() - 1)); // Último carácter

// Imprimir todos los caracteres con un bucle:
for (int i = 0; i < nombre2.length(); i++) {
    System.out.println(nombre2.charAt(i));
}
```

### **Comparación de Strings: `equals()` y `equalsIgnoreCase()`**

En Java, las strings son objetos, por lo que no se comparan con `==` (compara referencias). Usamos `equals()` para comparación exacta (distingue mayúsculas/minúsculas) y `equalsIgnoreCase()` para ignorar mayúsculas.

**Ejemplo** (del código Java):

```java
String nombre = "Pepe";
String nombre2 = "pepe"; // O entrada del usuario
System.out.println(nombre.equals(nombre2)); // false (distingue mayúsculas)
System.out.println(nombre.equalsIgnoreCase(nombre2)); // true (ignora mayúsculas, pero no acentos)
```

### **Transformación de Strings: `toUpperCase()` y `toLowerCase()`**

Convierten la cadena a mayúsculas o minúsculas, útiles para normalizar texto.

**Ejemplo** (del código Java):

```java
String nombre2 = "Pepe";
System.out.println(nombre2.toUpperCase()); // "PEPE"
System.out.println(nombre2.toLowerCase()); // "pepe"

// Combinado con búsqueda:
String nombre3 = "Maria";
System.out.println(nombre3.toLowerCase().indexOf('m')); // Busca 'm' en minúsculas
```

### **Búsqueda en Strings: `indexOf()` y `lastIndexOf()`**

#### `indexOf()`

Busca la primera ocurrencia de un carácter o subcadena. Devuelve la posición (desde 0) o -1 si no se encuentra. Puede especificar una posición de inicio.

**Ejemplo** (del código Java):

```java
String nombreCompleto = "Margarita Rivas Cobo";
int espacio1 = nombreCompleto.indexOf(" "); // Primera posición de espacio (9)
int espacio2 = nombreCompleto.indexOf(" ", 10); // Desde posición 10 (15)

String nombre3 = "Maria";
System.out.println(nombre3.indexOf('a')); // 1 (primera 'a')
System.out.println(nombre3.toLowerCase().indexOf('m')); // 0 (después de convertir)
```

#### `lastIndexOf()`

Busca desde el final hacia el principio.

**Ejemplo** (del código Java):

```java
System.out.println(nombre3.lastIndexOf('a')); // 4 (última 'a' en "Maria")
```

### **Extracción de Subcadenas: `substring()`**

Extrae una parte de la cadena, indicando posición de inicio (incluida) y fin (no incluida).

**Ejemplo** (del código Java):

```java
String nombre4 = "Jose Angel Alejo";
System.out.println(nombre4.substring(0, 4)); // "Jose"
System.out.println(nombre4.substring(0, 10)); // "Jose Angel"
```

### **División de Cadenas: `split()`**

Divide una cadena en un array de substrings usando un delimitador (separador). Es especialmente útil para procesar datos separados por caracteres específicos.

**Sintaxis**: `String[] resultado = cadena.split(delimitador);`

También existe una sobrecarga que limita el número de divisiones: `String[] resultado = cadena.split(delimitador, límite);` El parámetro `límite` especifica el número **máximo** de partes en que se divide la cadena.

**Ejemplo** (del código Java):

```java
String nombres = "Pepe,Juan,Maria";
String[] arrayNombres = nombres.split(",");
System.out.println(Arrays.toString(arrayNombres)); // [Pepe, Juan, Maria]

// Con límite de divisiones:
String frase = "Uno-Dos-Tres-Cuatro";
String[] partes = frase.split("-", 2); // Divide en máximo 2 partes: [Uno, Dos-Tres-Cuatro]
System.out.println(Arrays.toString(partes)); // [Uno, Dos-Tres-Cuatro]

// Con espacios como delimitador:
String texto = "Hola mundo Java programación";
String[] palabras = texto.split(" ");
for (int i = 0; i < palabras.length; i++) {
    System.out.println("Palabra " + (i+1) + ": " + palabras[i]);
}
```

**Consideraciones**:

- Si no encuentra el delimitador, devuelve un array con la cadena completa.
- El delimitador puede ser un carácter simple (`","`, `" "`) o un patrón regex.
- Especificar un límite es útil cuando quieres dividir solo hasta cierto punto.
- Devuelve un **array de strings**, por lo que es perfecto combinarlo con bucles.

### **Limpieza de Espacios: `trim()`**

Elimina espacios en blanco al inicio y final de una cadena. Es útil para normalizar entrada de usuario.

**Sintaxis**: `String resultado = cadena.trim();`

**Ejemplo**:

```java
String entrada = "   Hola Mundo   ";
System.out.println(entrada.trim()); // "Hola Mundo" (sin espacios al inicio/final)

// Combinado con scanner:
Scanner scanner = new Scanner(System.in);
String nombre = scanner.nextLine().trim(); // Lee y elimina espacios extras
System.out.println("Nombre: " + nombre);
```

---
<div style="page-break-after: always;"></div>

### **Ejemplos Prácticos y Combinaciones de Métodos**

Aquí implementamos ejemplos prácticos combinando métodos para tareas reales.

> **Ejemplo 1: Separar nombre+apellido1+apellido2**

Usa `indexOf("+")` y `substring()` para dividir una cadena fija:

```java
String nombreCompleto1 = "Nombre+Apellido1+Apellido2";
int espacio1 = nombreCompleto1.indexOf("+");
int espacio2 = nombreCompleto1.indexOf("+", espacio1 + 1);
String nombre1 = nombreCompleto1.substring(0, espacio1);
String apellido1 = nombreCompleto1.substring(espacio1 + 1, espacio2);
String apellido2 = nombreCompleto1.substring(espacio2 + 1);
System.out.println(nombre1 + " " + apellido1 + " " + apellido2);
```

> **Ejemplo 2: Contar espacios en una frase**

Usa `Scanner`, `length()`, `charAt()` en bucle:

```java
Scanner scanner2 = new Scanner(System.in);
System.out.println("Introduce una frase: ");
String frase2 = scanner2.nextLine();
int contador2 = 0;
for (int i = 0; i < frase2.length(); i++) {
    if (frase2.charAt(i) == ' ') {
        contador2++;
    }
}
System.out.println("Hay " + contador2 + " espacios");
scanner2.close();
```

> **Ejemplo 3: Invertir una cadena**

Usa `length()`, `charAt()` en bucle descendente:

```java
String frase3 = "Holaa";
for (int i2 = frase3.length() - 1; i2 >= 0; i2--) {
    System.out.print(frase3.charAt(i2));
}
```

> **Ejemplo 4: Verificar si es palíndromo**

Usa `length()`, `charAt()` en bucle para invertir, luego `equalsIgnoreCase()`:

```java
String frase4 = "Adiooos";
String frase4reves = "";
for (int i3 = frase4.length() - 1; i3 >= 0; i3--) {
    frase4reves += frase4.charAt(i3);
}
if (frase4.equalsIgnoreCase(frase4reves)) {
    System.out.println("Son palíndromos");
} else {
    System.out.println("No son palíndromos");
}
```

> **Ejemplo 5: Reemplazar caracteres**

Usa `length()`, `charAt()` en bucle para reemplazar:

```java
String frase5 = "Fiuuuuumba";
char charAReemplazar = 'u';
char charReemplazo = 'o';
String frase5nueva = "";
for (int i4 = 0; i4 < frase5.length(); i4++) {
    if (frase5.charAt(i4) != charAReemplazar) {
        frase5nueva += frase5.charAt(i4);
    } else {
        frase5nueva += charReemplazo;
    }
}
System.out.println(frase5nueva);
```

**Alternativa más simple con `replace()`:**

```java
String frase5 = "Fiuuuuumba";
String frase5nueva = frase5.replace('u', 'o'); // Reemplaza todos los 'u' por 'o'
System.out.println(frase5nueva); // "Fioooooomba"

// Para reemplazar subcadenas:
String texto = "Hola mundo, mundo";
String textoNuevo = texto.replace("mundo", "Java");
System.out.println(textoNuevo); // "Hola Java, Java"
```

> **Ejemplo 6: Extraer subcadenas**

Usa `substring()` con índices:

```java
String frase6 = "ProgramacionJava";
String subcadena1 = frase6.substring(0, 12);
String subcadena2 = frase6.substring(12, 16);
System.out.println("Subcadena 1: " + subcadena1 + "\nSubcadena 2: " + subcadena2);
System.out.printf("Subcadena 1: %s%nSubcadena 2: %s%n", subcadena1, subcadena2);
```

Recuerda cerrar `Scanner` con `scanner.close()` para evitar leaks de recursos.

---
<div style="page-break-after: always;"></div>

### **Conclusión y Notas Adicionales**

- Usa `equals()` en lugar de `==` para strings, ya que compara contenido, no referencias.
- Métodos como `indexOf()` devuelven -1 si no encuentran nada; valida siempre antes de usar.
- Combina métodos en bucles para tareas complejas, como invertir, reemplazar o contar.
- Recuerda cerrar `Scanner` para evitar leaks de recursos.
- Próximamente: Colecciones (Arrays/ArrayLists) para estructuras más complejas.

---

<div style="page-break-after: always;"></div>

## **COLECCIONES**

Las colecciones son estructuras que almacenan múltiples elementos. En Java, las más comunes son los Arrays y las Listas (ArrayLists). Aquí nos centraremos en los Arrays.

### **ARRAYS EN JAVA**

Existen Arrays de infinitas dimensiones. Por ahora, cuando nos referimos a Arrays lo haremos de manera unidimensional, es decir "una sola fila de datos".

Un Array es un **objeto que representa un conjunto de datos del mismo TIPO**. Por tanto, al ser un objeto y declararse como clase implícita, *no tiene métodos propios* como `.charAt` o `.substring`.

El **único metodo** que podemos usar directamente es `length`.

Para poder usar un Array debemos saber el tamaño que tendrá. Nunca se modifica. Los índices de los Arrays SIEMPRE empezarán en 0.

A continuación un ejemplo de Array donde el índice y el valor será introducido por el usuario/profesor mediante scanner:

```java
import java.util.Scanner;
public class ArraysJAAlejo {
    public static void main(String[] args) {
        // Quiero almacenar el nombre de los alumnos para una cantidad N de alumnos.
        // N será indicado por el usuario/profesor.
        Scanner scanner1 = new Scanner(System.in);
        String nombres [];  // Declaramos el Array con el tipo de dato, el nombre de variable y [];

        System.out.println("Introduzca cuántos alumnos tiene en su clase");
        int nalumno = scanner1.nextInt();
        scanner1.nextLine();
        // En este caso para indicar la longitud del array le hemos asignado el entero introducido por el profesor.
        nombres = new String [nalumno];
        // El índice de los arrays siempre comenzará en 0.
        for (int i = 0; i<nalumno; i++) {
            System.out.println("Introduzca el nombre del alumno: " + (i+1));
            nombres[i] = scanner1.nextLine();
        }
        System.out.println("Los nombres de sus alumnos son:");
        for (int i = 0; i<nalumno; i++) {
            System.out.println("El nombre del alumno " + (i+1) + " es " + nombres[i]);
        }
        System.out.println("Ha registrado " + nombres.length + " alumnos");
        scanner1.close();
    }
}
```

**Alternativa con bucle for-each (solo lectura):**

```java
// Después de capturar los nombres...
System.out.println("Los nombres de sus alumnos son:");
int contador = 1;
for (String nombre : nombres) {
    System.out.println("El nombre del alumno " + contador + " es " + nombre);
    contador++;
}
```

Si ya sabemos el tamaño del Array y los valores que tendrá, lo declaramos directamente. ```String nombres[] = {"Pepe", "Juan", "Maria"}```

La **longitud de los arrays son un atributo**, no son métodos. Por tanto, para imprimir su longitud usaremos `System.out.println(nombrearray.length)`. Nos devolverá la cantidad de registros/instancias del array, no el índice.

### **Declaración e Inicialización de Arrays**

Los arrays se pueden declarar de dos formas principales:

1. **Declaración sin inicialización**: Se declara el tipo y nombre, pero se inicializa después con `new`.

   ```java
   String nombres[];  // Declaración
   nombres = new String[tamaño];  // Inicialización
   ```

2. **Declaración con inicialización directa**: Si se conocen los valores, se puede hacer en una sola línea.

   ```java
   String nombres[] = {"Pepe", "Juan", "Maria"};
   ```

El tamaño del array se fija en el momento de la inicialización y no puede cambiar. Los índices siempre empiezan en 0.

### **Manipulación de Arrays - Métodos de la Clase *Arrays***

La clase `Arrays` (del paquete `java.util`) proporciona métodos estáticos útiles para trabajar con arrays. A continuación, se detallan algunos métodos clave con ejemplos basados en código práctico.

#### Arrays.copyOf

Copia un array hasta una longitud especificada, empezando desde el índice 0.

**Sintaxis**: `tipoDato[] nuevoArray = Arrays.copyOf(arrayOriginal, longitud);`

**Ejemplo**:

```java
int numero[] = {15, 15, 6, 7, 9, 50};
int numero1[] = Arrays.copyOf(numero, 3);  // Copia los primeros 3 elementos: [15, 15, 6]
```

**Consideraciones**:

- Si la longitud deseada es mayor que el array original, solo copia los elementos existentes. Los elementos adicionales tendrán el valor por defecto (0 para int, false para boolean, null para objetos).
- Se comporta similar a un substring para arrays.

#### Arrays.copyOfRange

Copia un rango específico de un array, desde un índice inicial hasta uno final (exclusivo).

**Sintaxis**: `tipoDato[] nuevoArray = Arrays.copyOfRange(arrayFuente, desde, hasta);`

**Ejemplo**:

```java
int numero[] = {15, 15, 6, 7, 9, 50};
int arrayCopynumero[] = Arrays.copyOfRange(numero, 2, 4);  // Copia índices 2 y 3: [6, 7]
```

**Consideraciones**:

- Los índices se cuentan desde 0.
- Para copiar al revés, usar `Arrays.copyOfRange(array, array.length - n, array.length)`.
  - Donde n es la cantidad de elementos a copiar desde el final.

#### Arrays.fill

Rellena todo el array con un valor específico.

**Sintaxis**: `Arrays.fill(array, valor);`

También existe una sobrecarga para rellenar un rango específico: `Arrays.fill(array, fromIndex, toIndex, valor);`

**Ejemplo**:

```java
boolean bol[] = new boolean[8];  // Por defecto: [false, false, ..., false]
Arrays.fill(bol, true);  // Ahora: [true, true, ..., true]

// Ejemplo con rango:
boolean asientos[] = new boolean[15];
Arrays.fill(asientos, 5, 11, true);  // Rellena desde índice 5 hasta 10 con true
```

**Consideraciones**:

- Sustituye todos los valores existentes (o en el rango especificado).

#### Arrays.equals

Compara dos arrays para verificar si son iguales en longitud y contenido.

**Sintaxis**: `Arrays.equals(array1, array2)`

**Ejemplo**:

```java
int numero5[] = {1, 2, 3, 4, 5};
int numero6[] = {1, 2, 3, 4, 5};
if (Arrays.equals(numero5, numero6)) {
    System.out.println("Son iguales");
}
```

**Consideraciones**:

- Devuelve `true` solo si coinciden longitud y valores en cada posición.

#### Arrays.toString

Convierte un array a una cadena de texto para impresión fácil.

**Sintaxis**: `Arrays.toString(array)`

**Ejemplo**:

```java
int numero5[] = {1, 2, 3, 4, 5};
System.out.println(Arrays.toString(numero5));  // Imprime: [1, 2, 3, 4, 5]
```

#### Arrays.sort

Ordena los elementos de un array de forma ascendente (por defecto).

**Sintaxis**: `Arrays.sort(array)`

**Ejemplo**:

```java
int numero7[] = {1, 15, 100, 24, 7, 15};
Arrays.sort(numero7);  // Resultado: [1, 7, 15, 15, 24, 100]
System.out.println(Arrays.toString(numero7));
```

**Consideraciones**:

- Ordena in-place (modifica el array original).
- Para números, ordena de menor a mayor.
- Funciona con tipos primitivos y objetos comparables (implementando Comparable).
- Para orden descendente: `Collections.reverseOrder()` **solo funciona con arrays de objetos** (`Integer[]`, `String[]`, etc.), **no con tipos primitivos** (`int[]`, `double[]`). Para primitivos, debes invertir manualmente o usar bibliotecas adicionales.

### **Consideraciones sobre Referencias en Memoria**

Cuando asignamos un array a otro (ejemplo: `array1 = array2`), no se copia el contenido, sino que se crea una referencia a la misma ubicación en memoria. Por tanto, cambios en `array2` afectarán a `array1`.

**Ejemplo**:

```java
int[] array1 = {1, 2, 3};
int[] array2 = array1;  // array2 referencia a array1
array2[0] = 99;  // Cambia array1[0] también
System.out.println(Arrays.toString(array1));  // [99, 2, 3]
```

Para copiar realmente, usar métodos como `Arrays.copyOf`.

### **Conclusión y Notas Adicionales (Arrays)**

- Los arrays tienen tamaño fijo una vez inicializados; para estructuras dinámicas, considera usar `ArrayList` (colecciones).
- Los índices siempre empiezan en 0; valida límites para evitar `IndexOutOfBoundsException` (por ejemplo, con `if (i < array.length)`).
- Métodos como `Arrays.sort()` modifican el array original in-place; haz copias si necesitas preservar el orden inicial.
- Para copiar arrays, usa `Arrays.copyOf()` o `Arrays.copyOfRange()` en lugar de asignación directa (`array1 = array2`), que crea referencias.
- Recuerda cerrar `Scanner` con `scanner.close()` para evitar leaks de recursos.
- Combina métodos de `Arrays` con bucles para tareas complejas, como búsqueda o transformación.
- Para generar arrays con valores aleatorios en ejemplos, puedes usar `Random` de `java.util`: `Random rand = new Random(); int valor = rand.nextInt(51);`
- Para impresión avanzada, `System.out.printf` puede usarse con `Arrays.toString`: `System.out.printf("Array: %s", Arrays.toString(array));`
- Próximamente: Colecciones avanzadas (ArrayList, HashMap) para estructuras de datos más flexibles.

---

<div style="page-break-after: always;"></div>

## **ARRAYS BIDIMENSIONALES (MATRICES)**

Las matrices son **arrays de arrays**, donde cada elemento del array contiene la referencia de otro array. Se crea una matriz multidimensional al agregar un conjunto de corchetes ([]) por dimensión.

```java
Tipo_de_variable[][] nombre = new Tipo_de_variable[dim1][dim2];
```

**Ejemplo**:

```java
int[][] matriz = new int[3][2]; //es una matriz de 3x2, 3 filas, 2 columnas.
```

Para introducir los valores podemos cargarlos uno a uno:

```java
matriz[2][0] = 5; //2 indica el número de fila y 0 la columna.
```

También se pueden cargar directamente los elementos, durante la declaración de la matriz:

```java
int[][] numeros = {{1,2},{3,4},{5,6}};
```

**Matrices Irregulares:** Las filas (arrays) de las matrices no tienen porqué tener el mismo tamaño. En este caso definimos el número de filas y luego a cada fila le asignamos un tamaño:

```java
int[][] numeros = new int[2][];
numeros[0] = new int[]{1,2,3};
numeros[1] = new int[]{0,-1,2,3,-5};
```

Para conocer el número de filas usamos `nombre.length`, y para conocer el número de columnas de una fila específica usamos `nombre[i].length`.

**Recorrer arrays de dos dimensiones:**

```java
for (int i = 0; i < arr.length; i++) {
    for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
    }
    System.out.println(); // Salto de línea tras cada fila
}
```

**Alternativa con bucle for-each (solo lectura):**

```java
for (int[] fila : arr) {
    for (int valor : fila) {
        System.out.print(valor + " ");
    }
    System.out.println();
}
```

### **Operaciones con Arrays 2D**

#### **Obtener la longitud de un array 2D**

Para **saber la longitud (cantidad) de filas y columnas** del array usamos el método `.length`:

```java
System.out.println(matriz.length);    // Cantidad de filas
System.out.println(matriz[0].length); // Cantidad de columnas
```

- **Donde**:
  - `matriz.length` nos da la cantidad de filas.
  - `matriz[0].length` nos da la cantidad de columnas.

Al ser un array regular, todas las filas tienen la misma cantidad de columnas, por lo que podemos usar cualquier fila (como la fila 0) para obtener la cantidad de columnas.

#### **Obtener/Imprimir todos los valores del Array 2D (filas y columnas)**

Si quisieramos **imprimir todos los valores del array**, recorreríamos todas las filas y columnas con bucles `for` anidados:

```java
for (int i = 0; i < matriz.length; i++) {
  for (int j = 0; j < matriz[i].length; j++) {
    System.out.print(matriz[i][j] + " "); // Imprime cada elemento en la fila i
  }
  System.out.println(); // Salto de línea al terminar la fila
}
```

#### **Obtener/Imprimir todos los valores de una fila o columna**

Para **imprimir todos los valores de una fila**, recorreríamos las columnas de esa fila:

```java
for (int j = 0; j < matriz[i].length; j++) {
    System.out.println(matriz[i][j]); // Imprime cada elemento de la fila i
}
```

Para **imprimir todos los valores de una columna**, recorrer todas las filas:

```java
for (int i = 0; i < matriz.length; i++) {
    System.out.println(matriz[i][j]); // Imprime el elemento de la columna j en cada fila
}
```

#### **Rellenar o modificar valores en arrays 2D**

Para **modificar elementos individuales**:

```java
matriz[2][3] = 5; // Modifica el elemento en fila 2, columna 3
```

Para **rellenar toda una fila** usamos el método `fill` de la clase `Arrays`:

```java
Arrays.fill(matriz[0], 7); // Rellena toda la fila 0 con 7
```

Para **rellenar toda una columna**, recorrer cada fila:

```java
for (int i = 0; i < matriz.length; i++) {
    matriz[i][2] = 7; // Rellena la columna 2 con 7
}
```

### **Métodos con Arrays Bidimensionales**

La clase `Arrays` del paquete `java.util` proporciona métodos estáticos útiles específicos para trabajar con arrays bidimensionales:

#### **Arrays.deepEquals()**

Compara si dos arrays bidimensionales son iguales, es decir, si tienen el mismo contenido en las mismas posiciones.

**Sintaxis**: `boolean resultado = Arrays.deepEquals(matriz1, matriz2);`

**Ejemplo**:

```java
int matriz1[][] = { {1, 2}, {3, 4} };
int matriz2[][] = { {1, 2}, {3, 4} };
int matriz3[][] = { {1, 2}, {5, 6} };

System.out.println(Arrays.deepEquals(matriz1, matriz2)); // true (son iguales)
System.out.println(Arrays.deepEquals(matriz1, matriz3)); // false (contienen valores diferentes)
```

#### **Arrays.deepToString()**

Convierte el contenido de un array bidimensional a una cadena de texto, facilitando su impresión o visualización.

**Sintaxis**: `String resultado = Arrays.deepToString(matriz);`

**Ejemplo**:

```java
int matriz[][] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };

System.out.println(Arrays.deepToString(matriz)); 
// Imprime: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
```

---

<div style="page-break-after: always;"></div>

### **Ejemplos Prácticos con Arrays Bidimensionales**

Aquí implementamos ejemplos prácticos combinando operaciones para tareas reales con matrices.

> **Ejemplo 1: Crear una matriz de notas y calcular el promedio por alumno**

Declara una matriz con notas de alumnos y calcula el promedio de cada uno:

```java
float notas[][] = {
    { 8.5f, 7.3f, 9.0f },  // Alumno 1
    { 6.5f, 7.8f, 8.2f },  // Alumno 2
    { 9.0f, 8.7f, 8.9f }   // Alumno 3
};

for (int i = 0; i < notas.length; i++) {
    float suma = 0;
    for (int j = 0; j < notas[i].length; j++) {
        suma += notas[i][j];
    }
    float promedio = suma / notas[i].length;
    System.out.println("Promedio alumno " + (i + 1) + ": " + promedio);
}
```

> **Ejemplo 2: Encontrar la nota máxima y mínima en una matriz**

Recorre toda la matriz para encontrar los valores extremos:

```java
int calificaciones[][] = { {85, 90, 78}, {92, 88, 95}, {76, 82, 80} };

int maxima = calificaciones[0][0];
int minima = calificaciones[0][0];

for (int i = 0; i < calificaciones.length; i++) {
    for (int j = 0; j < calificaciones[i].length; j++) {
        if (calificaciones[i][j] > maxima) {
            maxima = calificaciones[i][j];
        }
        if (calificaciones[i][j] < minima) {
            minima = calificaciones[i][j];
        }
    }
}

System.out.println("Calificación máxima: " + maxima);
System.out.println("Calificación mínima: " + minima);
```

> **Ejemplo 3: Sumar todos los elementos de una columna**

Recorre una columna específica y suma sus valores:

```java
int ventas[][] = {
    { 150, 200, 180 },  // Trimestre 1
    { 170, 190, 210 },  // Trimestre 2
    { 190, 220, 200 }   // Trimestre 3
};

int columna = 1; // Segunda columna
int sumaColumna = 0;

for (int i = 0; i < ventas.length; i++) {
    sumaColumna += ventas[i][columna];
}

System.out.println("Suma de la columna " + (columna + 1) + ": " + sumaColumna);
```

> **Ejemplo 4: Comparar dos matrices y encontrar diferencias**

Compara dos matrices elemento a elemento:

```java
int matriz1[][] = { {1, 2}, {3, 4} };
int matriz2[][] = { {1, 2}, {3, 5} };

boolean sonIguales = Arrays.deepEquals(matriz1, matriz2);

if (sonIguales) {
    System.out.println("Las matrices son idénticas");
} else {
    System.out.println("Las matrices tienen diferencias");
    for (int i = 0; i < matriz1.length; i++) {
        for (int j = 0; j < matriz1[i].length; j++) {
            if (matriz1[i][j] != matriz2[i][j]) {
                System.out.println("Diferencia en [" + i + "][" + j + "]: " 
                    + matriz1[i][j] + " vs " + matriz2[i][j]);
            }
        }
    }
}
```

---

<div style="page-break-after: always;"></div>

## **Ejercicios Propuestos**

Aquí tienes una serie de ejercicios para practicar los conceptos de esta unidad. Los ejercicios están organizados por dificultad y tema.

### **Ejercicios de Strings**

1. **Validar contraseña**: Crea un programa que valide si una contraseña tiene al menos 8 caracteres, contiene mayúsculas, minúsculas y números.
   - **Usa**: `length()`, `charAt()`, bucles, comparación con caracteres ASCII.
   - **Enunciado**: Lee una contraseña y valida que cumpla los requisitos. Imprime si es válida o no.

2. **Contar vocales y consonantes**: Cuenta cuántas vocales (a, e, i, o, u) y consonantes hay en una frase ingresada por el usuario.
   - **Usa**: `length()`, `charAt()`, `toLowerCase()`, bucles.
   - **Enunciado**: Lee una frase, cuenta vocales y consonantes, muestra los resultados.

3. **Buscar y reemplazar**: Busca todas las apariciones de una subcadena en una frase y reemplázalas por otra.
   - **Usa**: `indexOf()`, `substring()`, concatenación de strings, bucles.
   - **Enunciado**: Lee una frase, un texto a buscar y un reemplazo, luego imprime la frase modificada.

4. **Invertir palabra**: Lee una palabra y muéstrala al revés sin usar métodos predefinidos como `reverse()`.
   - **Usa**: `length()`, `charAt()`, bucles descendentes.
   - **Enunciado**: Pide una palabra y imprime sus caracteres en orden inverso.

5. **Validar palíndromo**: Determina si una palabra (ignorando mayúsculas/minúsculas) es un palíndromo.
   - **Usa**: `length()`, `charAt()`, `equalsIgnoreCase()`, bucles.
   - **Enunciado**: Lee una palabra y valida si se lee igual de adelante hacia atrás.

### **Ejercicios de Arrays Unidimensionales**

1. **Buscar elemento y contar apariciones**: Crea un array de números y busca cuántas veces aparece un valor específico.
   - **Usa**: `length`, bucles, contadores, condicionales.
   - **Enunciado**: Lee un array (puede ser predefinido), pide un número a buscar y muestra cuántas veces aparece.

2. **Ordenar y comparar**: Crea dos arrays, ordénalos y comprueba si son iguales después de ordenar.
   - **Usa**: `Arrays.sort()`, `Arrays.equals()`, `Arrays.toString()`.
   - **Enunciado**: Define dos arrays diferentes, ordénalos y compara si contienen los mismos elementos.

3. **Estadísticas del array**: Calcula la suma, promedio, máximo y mínimo de un array de números flotantes.
   - **Usa**: bucles, operadores aritméticos, condicionales.
   - **Enunciado**: Lee un array de notas y calcula suma, promedio, nota máxima y mínima.

4. **Invertir array**: Invierte el contenido de un array sin crear uno nuevo (o con un método auxiliar).
   - **Usa**: bucles, intercambio de variables, `Arrays.toString()`.
   - **Enunciado**: Lee un array y muestra sus elementos en orden inverso.

5. **Copiar rango**: Copia un rango específico de un array a otro usando `Arrays.copyOfRange()`.
   - **Usa**: `Arrays.copyOfRange()`, `Arrays.toString()`.
   - **Enunciado**: Lee un array, especifica posiciones inicial y final, luego copia ese rango a un nuevo array.

### **Ejercicios de Arrays Bidimensionales**

1. **Matriz de temperaturas**: Crea una matriz 3x4 que represente temperaturas de 3 ciudades en 4 meses. Calcula la temperatura promedio de cada ciudad y la del mes más cálido.
   - **Usa**: bucles anidados, operaciones aritméticas.
   - **Enunciado**: Define los datos, calcula promedio por ciudad y el mes con mayor temperatura promedio.

2. **Diagonal de una matriz**: Dada una matriz cuadrada (mismo número de filas y columnas), suma los elementos de la diagonal principal.
   - **Usa**: bucles, condición `i == j`.
   - **Enunciado**: Lee una matriz 4x4 y suma los elementos donde fila == columna.

3. **Buscar en matriz**: Busca un valor específico en una matriz 2D y muestra su posición `[fila][columna]`.
   - **Usa**: bucles anidados, condicionales, salida de bucles con bandera.
   - **Enunciado**: Define una matriz, pide un número a buscar y muestra dónde se encuentra (o "no encontrado").

4. **Comparar matrices con deepEquals()**: Crea dos matrices y verifica si son idénticas usando `Arrays.deepEquals()`.
   - **Usa**: `Arrays.deepEquals()`, `Arrays.deepToString()`.
   - **Enunciado**: Define dos matrices, compáralas e imprime si son iguales o diferentes.

5. **Imprimir matriz en formato tabla**: Crea una matriz 3x3 e imprímela en formato de tabla con bordes ASCII.
   - **Usa**: bucles anidados, `System.out.print()`, caracteres especiales.
   - **Enunciado**: Imprime la matriz con una presentación visual clara (con bordes y separadores).

6. **Suma por columnas**: Calcula la suma de cada columna en una matriz 4x3 e imprime los resultados.
   - **Usa**: bucles anidados, operaciones aritméticas.
   - **Enunciado**: Define una matriz de números y muestra el total de cada columna.

### **Ejercicios Avanzados (Combinados)**

1. **Sistema de notas de estudiantes**: Crea una matriz donde cada fila represente un estudiante y cada columna una asignatura. Calcula:
   - Promedio general de cada estudiante.
   - Promedio de cada asignatura.
   - La mejor calificación del grupo.
   - Cuántos estudiantes aprobaron (nota >= 7).

   **Usa**: bucles anidados, operaciones aritméticas, condicionales.

2. **Búsqueda en matriz irregular**: Crea una matriz irregular (jagged array) que represente diferentes secciones de un cine con diferente número de asientos. Usa un array de `boolean` para representar la disponibilidad de cada asiento (true = disponible, false = ocupado). Busca un asiento específico y muestra si está disponible.

   **Usa**: arrays irregulares, bucles anidados, `Arrays.fill()`, condicionales, array de `boolean`.
