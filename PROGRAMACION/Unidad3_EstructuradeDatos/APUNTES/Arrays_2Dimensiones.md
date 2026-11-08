# Apuntes de Arrays de 2 dimensiones en Java - Programación

- [Apuntes de Arrays de 2 dimensiones en Java - Programación](#apuntes-de-arrays-de-2-dimensiones-en-java---programación)
  - [**INTRODUCCIÓN - ARRAYS 2D (regulares)**](#introducción---arrays-2d-regulares)
    - [**Acceso a elementos del array 2D**](#acceso-a-elementos-del-array-2d)
    - [**Operaciones con arrays 2D**](#operaciones-con-arrays-2d)
      - [Obtener la longitud de un array 2D](#obtener-la-longitud-de-un-array-2d)
      - [**Obtener/Imprimir todos los valores del Array 2D (filas y columnas)**](#obtenerimprimir-todos-los-valores-del-array-2d-filas-y-columnas)
      - [**Obtener/Imprimir todos los valores de una fila o columna**](#obtenerimprimir-todos-los-valores-de-una-fila-o-columna)
      - [**Asignar valores de una fila a un array unidimensional**](#asignar-valores-de-una-fila-a-un-array-unidimensional)
      - [Rellenar o modificar valores en arrays 2D](#rellenar-o-modificar-valores-en-arrays-2d)
  - [**Métodos con Arrays de 2 Dimensiones**](#métodos-con-arrays-de-2-dimensiones)
    - [**Arrays.deepEquals()**](#arraysdeepequals)
    - [**Arrays.deepToString()**](#arraysdeeptostring)
  - [**Ejemplos Prácticos con Arrays Bidimensionales**](#ejemplos-prácticos-con-arrays-bidimensionales)
    - [Ejemplo 1: Calcular el promedio de notas por alumno](#ejemplo-1-calcular-el-promedio-de-notas-por-alumno)
    - [Ejemplo 2: Encontrar el valor máximo y mínimo en una matriz](#ejemplo-2-encontrar-el-valor-máximo-y-mínimo-en-una-matriz)
    - [Ejemplo 3: Sumar una columna específica](#ejemplo-3-sumar-una-columna-específica)
    - [Ejemplo 4: Comparar dos matrices](#ejemplo-4-comparar-dos-matrices)
  - [**ARRAYS IRREGULARES**](#arrays-irregulares)
    - [**Declaración de Arrays Irregulares**](#declaración-de-arrays-irregulares)
    - [**Ejemplo Práctico: Sistema de Reserva de Asientos Irregular**](#ejemplo-práctico-sistema-de-reserva-de-asientos-irregular)
    - [**Consideraciones Importantes**](#consideraciones-importantes)

---
<div style="page-break-after: always;"></div>

## **INTRODUCCIÓN - ARRAYS 2D (regulares)**

Los arrays de 2 dimensiones permiten almacenar varios valores para una misma "ocurrencia". Es decir, es un array de dos arrays.

Por ejemplo, para almacenar las notas de una serie de alumnos. Si tuvieramos 4 notas para cada alumno.

Para **declarar arrays de dos dimensiones** se realiza:

```java
tipodato notas[][];
```

- **Donde**:
  - "tipodato" es el tipo de dato que almacenará el array (int, float, String, etc).
  - Los **corchetes dobles "[][]" indican que es un array de dos dimensiones**.
  - "notas" es el nombre del array.

Para nuestro ejemplo concreto, sería:

```java
float notas[][];
```

Donde si imaginamos un array de dos dimensiones **como una matriz/tabla**, el *primer corchete* indica la **fila** y el **segundo la columna**.

Por tanto, en cada corchete se indica el número de elementos que tendrá cada dimensión, es decir, el número de filas y columnas.

Si para nuestro ejemplo queremos indicar que tenemos 2 alumnos con 3 notas cada uno, sería:

```java
float notas[][] = new float[2][3];
```

- **Donde**:
- El primer corchete "[2]" indica que hay 2 filas (2 alumnos).
- El segundo corchete "[3]" indica que hay 3 columnas (3 notas por alumno).

Se puede **representar como una tabla/matriz**:

|          | Nota 1 | Nota 2 | Nota 3 |
|----------|--------|--------|--------|
| Alumno 1 | 8.3    | 7.9    | 3.4    |
| Alumno 2 | 7.6    | 6.8    | 5.5    |

Cada posición en la tabla se accede mediante los índices de fila y columna, empezando desde 0.

O de manera tradicional:

```text
array notas = {
  { 8.3, 7.9, 3.4},  // Alumno 1
  { 7.6, 6.8, 5.5}   // Alumno 2
}

array notas = {
  { notas[0][0], notas[0][1], notas[0][2]},  // Alumno 1
  { notas[1][0], notas[1][1], notas[1][2]}   // Alumno 2
}

array notas = { { 8.3, 7.9, 3.4},  { 7.6, 6.8, 5.5}  }
```

Al igual que en la tabla, tenemos 2 filas (alumnos) y 3 columnas (notas) y se accede a cada elemento mediante sus índices.

### **Acceso a elementos del array 2D**

Si quisieramos **acceder a la nota 2 del alumno 1**, es decir a la fila 1 y columna 2, nos referiríamos a sus **índices/posiciones** respecto al array 2D, **comenzando desde 0**:

```java
notas[0][1]  // Accede a la nota 2 del alumno 1
```

- **Donde**:
  - El primer índice "[0]" indica la fila (alumno 1).
  - El segundo índice "[1]" indica la columna (nota 2).

Esto nos devolvería el valor **7.9**.

Si por ejemplo tuvieramos un array de 2 dimensiones para representar los asientos de una sala de cine con 7 filas y 6 columnas:

```java
boolean asientos[][] = new boolean[7][6];
```

- **Donde**:
  - El tipo de dato es "boolean" (true/false) para indicar si un asiento está ocupado o libre.
  - El nombre del array es "asientos".
  - Tiene 7 filas (filas de asientos) y 6 columnas (asientos por fila).
  - Por defecto, todos los asientos estarán libres (false).

### **Operaciones con arrays 2D**

#### Obtener la longitud de un array 2D

Cuando trabajamos con arrays de dos dimensiones, es común necesitar conocer la cantidad de filas y columnas que tiene el array.
Cada "fila" del array es en sí misma un array unidimensional, por lo que podemos para **saber la longitud (cantidad) de filas y columnas** del array asientos, usamos el método `.length`:

```java
System.out.println(asientos.length);    // Cantidad de filas
System.out.println(asientos[0].length); // Cantidad de columnas
```

- **Donde**:
  - `asientos.length` nos da la cantidad de filas (7 en este caso).
  - `asientos[0].length` nos da la cantidad de columnas (6 en este caso).

Al ser un array regular, todas las filas tienen la misma cantidad de columnas, por lo que podemos usar cualquier fila (como la fila 0) para obtener la cantidad de columnas.

#### **Obtener/Imprimir todos los valores del Array 2D (filas y columnas)**

Si quisieramos **imprimir todos los valores del array**, recorreríamos todas las filas y columnas con bucles `for` anidados:

```java
for (int i = 0; i < asientos.length; i++) {
  for (int j = 0; j < asientos[i].length; j++) {
    System.out.print(asientos[i][j] + " "); // Imprime cada asiento en la fila i
  }
}
```

- Donde:
  - El primer bucle `for` recorre las filas.
  - El segundo bucle `for` recorre las columnas de cada fila.
  - Los índices `i` y `j` se usan para acceder a cada asiento en la posición `[i][j]`. Y siempre se inicializan desde 0.

#### **Obtener/Imprimir todos los valores de una fila o columna**

Para **imprimir todos los valores de una fila**, recorreríamos las columnas de esa fila usando un bucle `for`:

```java
for (int j = 0; j < asientos[i].length; j++) {
    System.out.println(asientos[0][j]); // Imprime cada asiento en la fila 1
}
```

- **Donde**:
  - `i` es el índice de la fila que queremos imprimir.
  - `j` recorre las columnas de esa fila.

Para nuestro ejemplo de asientos, si quisieramos obtener la fila 2 (índice 1):

```java
for (int j = 0; j < asientos[1].length; j++) {
    System.out.println(asientos[1][j]); // Imprime cada asiento en la fila 2
}
```

#### **Asignar valores de una fila a un array unidimensional**

Si queremos **asignar los valores de una fila específica del array 2D a un array unidimensional que se refiere a una fila concreta del bidimensional**, podemos hacerlo utilizando un bucle `for` para copiar los valores.

El proceso es:

1. Declaramos un array unidimensional para almacenar los valores de la fila. En `[]` ponemos la cantidad de columnas que tiene el array 2D. O usamos `asientos[n].length` para obtener la cantidad de columnas, donde `n` es el índice de la fila que queremos copiar.
2. Usamos un bucle `for` para recorrer las columnas de la fila específica del array 2D y asignar cada valor al array unidimensional.
3. Imprimimos o utilizamos el array unidimensional según sea necesario.
   1. Para comprobar que los valores se han copiado correctamente, podemos imprimir el array unidimensional con un bucle `for` o utilizando `Arrays.toString()`.

Utilizando un ejemplo de notas de alumnos:

```java
float notas[][] = {
    { 8.3f, 7.9f, 3.4f},  // Alumno 1
    { 7.6f, 6.8f, 5.5f},  // Alumno 2
    { 9.0f, 8.5f, 7.2f}   // Alumno 3
};

int n = Scanner.nextInt(); // Índice del alumno (fila) que queremos copiar, introducido por el usuario (Si queremos que sea el alumno 1, n= 0; si es el alumno 2, n=1; etc.)

float nombreAlumno[] = new float[notas[n].length]; // Array unidimensional para almacenar las notas de un alumno

for (int j = 0; j < notas[n].length; j++) {
    nombreAlumno[j] = notas[n][j]; // Copia cada nota del alumno n al array unidimensional
}

System.out.println(Arrays.toString(nombreAlumno)); // Imprime las notas del alumno n
```

Podemos imprimir el array bidimensional en forma de matriz para verificar que los valores se han copiado correctamente:

```java
System.out.println("\nLa matriz introducida es:");
    for (int i = 0; i < notas.length; i++) {
        System.out.print("    "); // Tabulación para mejorar formato
        for (int j = 0; j < notas[i].length; j++) {
            System.out.printf("%f ", notas[i][j]);
        }
        System.out.println(); // Salto de línea al llegar a n (cantidad filas/columnas)
    }
```

#### Rellenar o modificar valores en arrays 2D

Para **"ocupar" asientos de manera individual**, por ejemplo, en la fila 3 los asientos 4 y 5:

```java
asientos[2][3] = true; // Ocupa el asiento en fila 3, columna 4
asientos[2][4] = true; // Ocupa el asiento en fila 3, columna 5
```

Si quisieramos **ocupar toda una fila**, por ejemplo la fila 1, usaríamos el método `fill` de la clase `Arrays`:

```java
Arrays.fill(asientos[0], true); // Ocupa toda la fila 1
```

Si quisieramos **ocupar toda una columna**, tendríamos que *recorrer cada fila y ocupar el asiento correspondiente en esa columna*, usando un bucle `for`:

```java
for (int i = 0; i < asientos.length; i++) {
    asientos[i][2] = true; // Ocupa el asiento en la columna 3 de cada fila
}
```

- Donde `asientos[i][2]` accede a la columna 3 (índice 2) de cada fila `i`.

## **Métodos con Arrays de 2 Dimensiones**

La clase `Arrays` del paquete `java.util` proporciona métodos estáticos útiles específicos para trabajar con arrays bidimensionales. A continuación se detallan:

### **Arrays.deepEquals()**

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

**Consideraciones:**

- Compara **exactamente** longitud y contenido de ambas matrices.
- Es más eficiente que hacer un bucle manual para comparar elementos.
- Devuelve `false` si las dimensiones son diferentes, aunque tengan el mismo contenido.

### **Arrays.deepToString()**

Convierte el contenido de un array bidimensional a una cadena de texto, facilitando su impresión o visualización de forma legible.

**Sintaxis**: `String resultado = Arrays.deepToString(matriz);`

**Ejemplo**:

```java
int matriz[][] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };

System.out.println(Arrays.deepToString(matriz)); 
// Imprime: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
```

**Consideraciones:**

- Devuelve una representación en String de toda la matriz.
- Es útil para **depuración y visualización rápida**.
- Funciona con matrices de cualquier tamaño y tipo de dato.
- Para matrices grandes, el String resultante puede ser muy largo.

---

<div style="page-break-after: always;"></div>

## **Ejemplos Prácticos con Arrays Bidimensionales**

A continuación, presentamos algunos ejemplos prácticos que combinan operaciones comunes con matrices.

### Ejemplo 1: Calcular el promedio de notas por alumno

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

### Ejemplo 2: Encontrar el valor máximo y mínimo en una matriz

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

### Ejemplo 3: Sumar una columna específica

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

### Ejemplo 4: Comparar dos matrices

```java
int matriz1[][] = { {1, 2}, {3, 4} };
int matriz2[][] = { {1, 2}, {3, 5} };

if (Arrays.deepEquals(matriz1, matriz2)) {
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

## **ARRAYS IRREGULARES**

También se pueden trabajar con **Arrays irregulares o jagged arrays** (filas con diferente cantidad de columnas). Utilizar arrays irregulares es útil cuando las filas no necesitan tener la misma cantidad de elementos, pero no es el estándar para representar matrices o tablas.

### **Declaración de Arrays Irregulares**

Para declarar un array irregular, definimos el número de filas pero **dejamos sin definir el número de columnas**, para luego asignar a cada fila su tamaño específico:

```java
boolean asientosIrregulares[][] = new boolean[7][];
asientosIrregulares[0] = new boolean[2]; // Fila 1 con 2 asientos
asientosIrregulares[1] = new boolean[3]; // Fila 2 con 3 asientos
asientosIrregulares[2] = new boolean[4]; // Fila 3 con 4 asientos
asientosIrregulares[3] = new boolean[2]; // Fila 4 con 2 asientos
```

- Donde:
  - `boolean asientosIrregulares[][]` declara el array bidimensional.
  - `new boolean[7][]` crea 7 filas sin definir columnas.
  - Luego, asignamos a cada fila un tamaño diferente según sea necesario.

Alternativa: **Definir directamente con inicialización**:

```java
boolean asientosIrregulares[][] = {
    { false, false },                      // Fila 1: 2 columnas
    { false, false, false },               // Fila 2: 3 columnas
    { false, false, false, false },        // Fila 3: 4 columnas
    { false, false }                       // Fila 4: 2 columnas
};
```

### **Ejemplo Práctico: Sistema de Reserva de Asientos Irregular**

Imaginemos un teatro donde diferentes secciones tienen diferente cantidad de asientos:

```java
// Crear matriz irregular: 4 secciones con diferente número de asientos
boolean [][] asientos = new boolean[4][];
asientos[0] = new boolean[5];  // Sección VIP: 5 asientos
asientos[1] = new boolean[8];  // Sección A: 8 asientos
asientos[2] = new boolean[10]; // Sección B: 10 asientos
asientos[3] = new boolean[6];  // Sección C: 6 asientos

// Reservar algunos asientos
Arrays.fill(asientos[0], false); // Todos libres inicialmente

// Ocupar asientos específicos
asientos[0][2] = true;  // Asiento 3 de la sección VIP
asientos[0][4] = true;  // Asiento 5 de la sección VIP

asientos[1][0] = true;  // Asiento 1 de la sección A
asientos[1][7] = true;  // Asiento 8 de la sección A

// Mostrar disponibilidad por sección
for (int seccion = 0; seccion < asientos.length; seccion++) {
    int disponibles = 0;
    for (int asiento = 0; asiento < asientos[seccion].length; asiento++) {
        if (!asientos[seccion][asiento]) {
            disponibles++;
        }
    }
    System.out.println("Sección " + (char)('A' + seccion) + ": " 
        + disponibles + " de " + asientos[seccion].length + " disponibles");
}
```

**Salida:**

```
Sección A: 3 de 5 disponibles
Sección B: 6 de 8 disponibles
Sección C: 10 de 10 disponibles
Sección D: 6 de 6 disponibles
```

### **Consideraciones Importantes**

- **Acceso a elementos**: Cada fila puede tener diferente longitud; valida siempre `asientos[i].length` para evitar `IndexOutOfBoundsException`.
- **No podemos eliminar**: Solo reasignar valores (ej: `false` en lugar de `true`).
- **Comparación**: `Arrays.deepEquals()` también funciona con arrays irregulares.
- **Impresión**: `Arrays.deepToString()` muestra correctamente la estructura irregular.
