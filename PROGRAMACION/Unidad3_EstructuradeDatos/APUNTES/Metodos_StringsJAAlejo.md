# **U3 - Estructura de Datos | Métodos Strings Java**

- [**U3 - Estructura de Datos | Métodos Strings Java**](#u3---estructura-de-datos--métodos-strings-java)
  - [**Métodos Básicos para Manipular Strings: `length()` y `charAt()`**](#métodos-básicos-para-manipular-strings-length-y-charat)
    - [`length()`](#length)
    - [`charAt()`](#charat)
  - [**Comparación de Strings: `equals()` y `equalsIgnoreCase()`**](#comparación-de-strings-equals-y-equalsignorecase)
  - [**Transformación de Strings: `toUpperCase()` y `toLowerCase()`**](#transformación-de-strings-touppercase-y-tolowercase)
  - [**Búsqueda en Strings: `indexOf()` y `lastIndexOf()`**](#búsqueda-en-strings-indexof-y-lastindexof)
    - [`indexOf()`](#indexof)
    - [`lastIndexOf()`](#lastindexof)
  - [**Extracción de Subcadenas: `substring()`**](#extracción-de-subcadenas-substring)
  - [Ejemplos Prácticos y Combinaciones de Métodos](#ejemplos-prácticos-y-combinaciones-de-métodos)
  - [Conclusión y Notas Adicionales](#conclusión-y-notas-adicionales)

---
<div style="page-break-after: always;"></div>

## **Métodos Básicos para Manipular Strings: `length()` y `charAt()`**

### `length()`

Devuelve la longitud de la cadena (número de caracteres). Sintaxis: `nombrecadena.length();` o directamente en una literal: `"Pepe".length();` (devuelve 4).

**Ejemplo** (del código Java):

```java
String nombre = "Pepe";
int longitud = nombre.length(); // Almacena 4
System.out.println("Pepe".length()); // Imprime 4
```

### `charAt()`

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

## **Comparación de Strings: `equals()` y `equalsIgnoreCase()`**

En Java, las strings son objetos, por lo que no se comparan con `==` (compara referencias). Usamos `equals()` para comparación exacta (distingue mayúsculas/minúsculas) y `equalsIgnoreCase()` para ignorar mayúsculas.

**Ejemplo** (del código Java):

```java
String nombre = "Pepe";
String nombre2 = "pepe"; // O entrada del usuario
System.out.println(nombre.equals(nombre2)); // false (distingue mayúsculas)
System.out.println(nombre.equalsIgnoreCase(nombre2)); // true (ignora mayúsculas, pero no acentos)
```

## **Transformación de Strings: `toUpperCase()` y `toLowerCase()`**

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

## **Búsqueda en Strings: `indexOf()` y `lastIndexOf()`**

### `indexOf()`

Busca la primera ocurrencia de un carácter o subcadena. Devuelve la posición (desde 0) o -1 si no se encuentra. Puede especificar una posición de inicio.

**Ejemplo** (del código Java):

```java
String nombreCompleto = "Margarita Rivas Cobo";
int espacio1 = nombreCompleto.indexOf(" "); // Primera posición de espacio (9)
int espacio2 = nombreCompleto.indexOf(" ", 10); // Desde posición 10 (18)

String nombre3 = "Maria";
System.out.println(nombre3.indexOf('a')); // 1 (primera 'a')
System.out.println(nombre3.toLowerCase().indexOf('m')); // 0 (después de convertir)
```

### `lastIndexOf()`

Busca desde el final hacia el principio.

**Ejemplo** (del código Java):

```java
System.out.println(nombre3.lastIndexOf('a')); // 4 (última 'a' en "Maria")
```

## **Extracción de Subcadenas: `substring()`**

Extrae una parte de la cadena, indicando posición de inicio (incluida) y fin (no incluida).

**Ejemplo** (del código Java):

```java
String nombre4 = "Jose Angel Alejo";
System.out.println(nombre4.substring(0, 4)); // "Jose"
System.out.println(nombre4.substring(0, 10)); // "Jose Angel"
```

## **División de Cadenas: `split()`**

Divide una cadena en un array de substrings usando un delimitador (separador). Es especialmente útil para procesar datos separados por caracteres específicos.

**Sintaxis**: `String[] resultado = cadena.split(delimitador);`

También existe una sobrecarga que limita el número de divisiones: `String[] resultado = cadena.split(delimitador, límite);`

**Ejemplo** (del código Java):

```java
String nombres = "Pepe,Juan,Maria";
String[] arrayNombres = nombres.split(",");
System.out.println(Arrays.toString(arrayNombres)); // [Pepe, Juan, Maria]

// Con límite de divisiones:
String frase = "Uno-Dos-Tres-Cuatro";
String[] partes = frase.split("-", 2); // Divide en máximo 2 elementos
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

---
<div style="page-break-after: always;"></div>

## Ejemplos Prácticos y Combinaciones de Métodos

Aquí implementamos los 6 enunciados del archivo `Act1JAAlejo.java`, combinando métodos para tareas prácticas.

- **Enunciado 1: Separar nombre+apellido1+apellido2**: Usa `indexOf("+")` y `substring()` para dividir una cadena fija.

  ```java
  String nombreCompleto1 = "Nombre+Apellido1+Apellido2";
  int espacio1 = nombreCompleto1.indexOf("+");
  int espacio2 = nombreCompleto1.indexOf("+", espacio1 + 1);
  String nombre1 = nombreCompleto1.substring(0, espacio1);
  String apellido1 = nombreCompleto1.substring(espacio1 + 1, espacio2);
  String apellido2 = nombreCompleto1.substring(espacio2 + 1);
  System.out.println(nombre1 + " " + apellido1 + " " + apellido2);
  ```

- **Enunciado 2: Contar espacios en una frase**: Usa `Scanner`, `length()`, `charAt()` en bucle para contar espacios.

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

- **Enunciado 3: Invertir una cadena**: Usa `length()`, `charAt()` en bucle descendente para invertir.

  ```java
  String frase3 = "Holaa";
  for (int i2 = frase3.length() - 1; i2 >= 0; i2--) {
      System.out.print(frase3.charAt(i2));
  }
  ```

- **Enunciado 4: Verificar si es palíndromo**: Usa `length()`, `charAt()` en bucle para invertir, luego `equalsIgnoreCase()`.

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

- **Enunciado 5: Reemplazar caracteres**: Usa `length()`, `charAt()` en bucle ascendente para reemplazar.

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

- **Enunciado 6: Extraer subcadenas**: Usa `substring()` con índices fijos.

  ```java
  String frase6 = "ProgramacionJava";
  String subcadena1 = frase6.substring(0, 12);
  String subcadena2 = frase6.substring(12, 16);
  System.out.println("Subcadena 1: " + subcadena1 + "\nSubcadena 2: " + subcadena2);
  System.out.printf("Subcadena 1: %s%nSubcadena 2: %s%n", subcadena1, subcadena2);
  ```

Recuerda cerrar `Scanner` con `scanner.close()`.

---
<div style="page-break-after: always;"></div>

## Conclusión y Notas Adicionales

- Usa `equals()` en lugar de `==` para strings, ya que compara contenido, no referencias (ver Enunciado 4).
- Métodos como `indexOf()` devuelven -1 si no encuentran nada; valida siempre antes de usar (ver Enunciados 1 y 2).
- Combina métodos en bucles para tareas complejas, como invertir, reemplazar o contar (ver Enunciados 3-5).
- Recuerda cerrar `Scanner` para evitar leaks de recursos (ver Enunciados 2 y ejemplos).
- Próximamente: Colecciones (Arrays/ArrayLists) para estructuras más complejas.
