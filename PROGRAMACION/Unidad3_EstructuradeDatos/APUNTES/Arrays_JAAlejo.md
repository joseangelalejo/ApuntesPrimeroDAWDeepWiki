# **Apuntes de Arrays Unidimensionales en Java - Programación**

- [**Apuntes de Arrays Unidimensionales en Java - Programación**](#apuntes-de-arrays-unidimensionales-en-java---programación)
  - [**Introducción**](#introducción)
  - [**Declaración e Inicialización de Arrays**](#declaración-e-inicialización-de-arrays)
  - [**Recorrer Arrays con Bucles**](#recorrer-arrays-con-bucles)
  - [**Métodos de la Clase Arrays**](#métodos-de-la-clase-arrays)
    - [Arrays.copyOf](#arrayscopyof)
    - [Arrays.copyOfRange](#arrayscopyofrange)
    - [Arrays.fill](#arraysfill)
    - [Arrays.equals](#arraysequals)
    - [Arrays.toString](#arraystostring)
    - [Arrays.sort](#arrayssort)
  - [**Consideraciones sobre Referencias en Memoria**](#consideraciones-sobre-referencias-en-memoria)
  - [**Ejemplos Prácticos con Arrays Unidimensionales**](#ejemplos-prácticos-con-arrays-unidimensionales)
    - [Ejemplo 1: Buscar un elemento en el array](#ejemplo-1-buscar-un-elemento-en-el-array)
    - [Ejemplo 2: Calcular estadísticas de un array](#ejemplo-2-calcular-estadísticas-de-un-array)
    - [Ejemplo 3: Ordenar y comparar dos arrays](#ejemplo-3-ordenar-y-comparar-dos-arrays)
    - [Ejemplo 4: Rellenar un rango específico de un array](#ejemplo-4-rellenar-un-rango-específico-de-un-array)
    - [Ejemplo 5: Copiar un rango de elementos](#ejemplo-5-copiar-un-rango-de-elementos)

## **Introducción**

Existen Arrays de infinitas dimensiones. Por ahora, cuando nos referimos a Arrays lo haremos de manera unidimensional, es decir "una sola fila de datos".

Un Array es un objeto que representa un conjunto de datos del mismo TIPO. Por tanto, al ser un objeto y declararse como clase implícita, no tiene métodos propios como `.charAt` o `.substring`.

El único metodo que podemos usar directamente es `length`.

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

Si ya sabemos el tamaño del Array y los valores que tendrá, lo declaramos directamente. ```String nombres[] = {"Pepe", "Juan", "Maria"}```

La **longitud de los arrays son un atributo**, no son métodos. Por tanto, para imprimir su longitud usaremos `System.out.println(nombrearray.length)`. Nos devolverá la cantidad de registros/instancias del array, no el índice.

## **Declaración e Inicialización de Arrays**

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

### **Recorrer Arrays con Bucles**

Además del bucle `for` tradicional, Java ofrece el **bucle `for-each`** para recorrer arrays de forma más simple y legible cuando no necesitas el índice.

#### **Bucle `for` Tradicional**

```java
int numeros[] = {10, 20, 30, 40, 50};

// Recorrer con índice (útil si necesitas saber la posición)
for (int i = 0; i < numeros.length; i++) {
    System.out.println("Índice " + i + ": " + numeros[i]);
}
```

#### **Bucle `for-each` (Enhanced For Loop)**

```java
int numeros[] = {10, 20, 30, 40, 50};

// Recorrer sin índice (más simple si solo necesitas el valor)
for (int numero : numeros) {
    System.out.println("Valor: " + numero);
}
```

**Comparación:**

- **`for` tradicional**: Acceso a índices, mayor control, necesario para modificar elementos.
- **`for-each`**: Más legible, menos verboso, acceso solo a valores (no a índices).

## **Métodos de la Clase Arrays**

La clase `Arrays` (del paquete `java.util`) proporciona métodos estáticos útiles para trabajar con arrays. A continuación, se detallan algunos métodos clave con ejemplos basados en código práctico.

### Arrays.copyOf

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

### Arrays.copyOfRange

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

### Arrays.fill

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

### Arrays.equals

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

### Arrays.toString

Convierte un array a una cadena de texto para impresión fácil.

**Sintaxis**: `Arrays.toString(array)`

**Ejemplo**:

```java
int numero5[] = {1, 2, 3, 4, 5};
System.out.println(Arrays.toString(numero5));  // Imprime: [1, 2, 3, 4, 5]
```

### Arrays.sort

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
- Para orden descendente, puedes usar `Arrays.sort(array, Collections.reverseOrder())` si es necesario.

## **Consideraciones sobre Referencias en Memoria**

Cuando asignamos un array a otro (ejemplo: `array1 = array2`), no se copia el contenido, sino que se crea una referencia a la misma ubicación en memoria. Por tanto, cambios en `array2` afectarán a `array1`.

**Ejemplo**:

```java
int[] array1 = {1, 2, 3};
int[] array2 = array1;  // array2 referencia a array1
array2[0] = 99;  // Cambia array1[0] también
System.out.println(Arrays.toString(array1));  // [99, 2, 3]
```

Para copiar realmente, usar métodos como `Arrays.copyOf`.

---

<div style="page-break-after: always;"></div>

## **Ejemplos Prácticos con Arrays Unidimensionales**

A continuación, presentamos ejemplos prácticos que combinan operaciones comunes con arrays.

### Ejemplo 1: Buscar un elemento en el array

```java
int numeros[] = {10, 45, 23, 67, 89, 12, 34};
int buscado = 67;
int posicion = -1;

for (int i = 0; i < numeros.length; i++) {
    if (numeros[i] == buscado) {
        posicion = i;
        break;
    }
}

if (posicion != -1) {
    System.out.println("El número " + buscado + " se encontró en la posición " + posicion);
} else {
    System.out.println("El número " + buscado + " no fue encontrado");
}
```

### Ejemplo 2: Calcular estadísticas de un array

```java
int calificaciones[] = {85, 92, 78, 95, 88, 76, 90};

int suma = 0;
int maxima = calificaciones[0];
int minima = calificaciones[0];

for (int i = 0; i < calificaciones.length; i++) {
    suma += calificaciones[i];
    
    if (calificaciones[i] > maxima) {
        maxima = calificaciones[i];
    }
    if (calificaciones[i] < minima) {
        minima = calificaciones[i];
    }
}

float promedio = (float) suma / calificaciones.length;
System.out.println("Suma: " + suma);
System.out.println("Promedio: " + promedio);
System.out.println("Máxima: " + maxima);
System.out.println("Mínima: " + minima);
```

### Ejemplo 3: Ordenar y comparar dos arrays

```java
int array1[] = {5, 2, 8, 1, 9};
int array2[] = {1, 2, 5, 8, 9};

// Copiar y ordenar array1
int array1Ordenado[] = Arrays.copyOf(array1, array1.length);
Arrays.sort(array1Ordenado);

System.out.println("Array 1 original: " + Arrays.toString(array1));
System.out.println("Array 1 ordenado: " + Arrays.toString(array1Ordenado));
System.out.println("Array 2: " + Arrays.toString(array2));

if (Arrays.equals(array1Ordenado, array2)) {
    System.out.println("Los arrays contienen los mismos elementos");
} else {
    System.out.println("Los arrays tienen elementos diferentes");
}
```

### Ejemplo 4: Rellenar un rango específico de un array

```java
boolean asientos[] = new boolean[10];
Arrays.fill(asientos, false);  // Todos los asientos libres

// Ocupar asientos del 3 al 6
Arrays.fill(asientos, 3, 7, true);

System.out.println("Estado de asientos: " + Arrays.toString(asientos));
// Imprime: [false, false, false, true, true, true, true, false, false, false]
```

### Ejemplo 5: Copiar un rango de elementos

```java
int original[] = {10, 20, 30, 40, 50, 60, 70, 80};
int copia[] = Arrays.copyOfRange(original, 2, 6);

System.out.println("Array original: " + Arrays.toString(original));
System.out.println("Copia (índices 2-5): " + Arrays.toString(copia));
// Imprime: [30, 40, 50, 60]
```

---

- Los arrays tienen tamaño fijo una vez inicializados; para estructuras dinámicas, considera usar `ArrayList` (colecciones).
- Los índices siempre empiezan en 0; valida límites para evitar `IndexOutOfBoundsException` (por ejemplo, con `if (i < array.length)`).
- Métodos como `Arrays.sort()` modifican el array original in-place; haz copias si necesitas preservar el orden inicial.
- Para copiar arrays, usa `Arrays.copyOf()` o `Arrays.copyOfRange()` en lugar de asignación directa (`array1 = array2`), que crea referencias.
- Recuerda cerrar `Scanner` con `scanner.close()` para evitar leaks de recursos.
- Combina métodos de `Arrays` con bucles para tareas complejas, como búsqueda o transformación.
- Para generar arrays con valores aleatorios en ejemplos, puedes usar `Random` de `java.util`: `Random rand = new Random(); int valor = rand.nextInt(51);`
- Para impresión avanzada, `System.out.printf` puede usarse con `Arrays.toString`: `System.out.printf("Array: %s", Arrays.toString(array));`
- Próximamente: Colecciones avanzadas (ArrayList, HashMap) para estructuras de datos más flexibles.
