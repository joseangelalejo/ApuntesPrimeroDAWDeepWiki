# 📚 REPASO UNIDAD 3 - ESTRUCTURAS DE DATOS EN JAVA

> Resumen INTENSIVO para examen del 27 de enero de 2026 ⏰

---

## 🎯 **CONTENIDOS DEL EXAMEN**

- ✅ Strings (Cadenas de Texto)
- ✅ Arrays Unidimensionales (1D)
- ✅ Arrays Bidimensionales (2D / Matrices)
- ✅ Métodos de la clase Arrays
- ✅ 18+ Ejercicios Prácticos

---

## 📖 **1. STRINGS - MÉTODOS ESENCIALES**

| Método                     | Función              | Ejemplo                                  |
|----------------------------|----------------------|------------------------------------------|
| `length()`                 | Nº de caracteres     | `"Hola".length()` → 4                    |
| `charAt(index)`            | Carácter en posición | `"Hola".charAt(0)` → 'H'                 |
| `equals(String)`           | Compara exacto       | `"Hola".equals("hola")` → false          |
| `equalsIgnoreCase(String)` | Compara sin mayús    | `"Hola".equalsIgnoreCase("hola")` → true |
| `toUpperCase()`            | A mayúsculas         | `"hola".toUpperCase()` → "HOLA"          |
| `toLowerCase()`            | A minúsculas         | `"HOLA".toLowerCase()` → "hola"          |
| `indexOf(char)`            | Busca posición       | `"Hola".indexOf('l')` → 2                |
| `lastIndexOf(char)`        | Última posición      | `"Hola".lastIndexOf('l')` → 2            |
| `substring(inicio, fin)`   | Extrae subcadena     | `"Hola".substring(0, 2)` → "Ho"          |
| `split(delimitador)`       | Divide en array      | `"A,B,C".split(",")` → ["A","B","C"]     |
| `trim()`                   | Quita espacios       | `"  Hola  ".trim()` → "Hola"             |

**⚠️ IMPORTANTE**: Strings se comparan con `.equals()` ❌ NO con `==`

---

## 📦 **2. ARRAYS UNIDIMENSIONALES**

### Declaración e Inicialización

```java
// Con valores
int numeros[] = {1, 2, 3, 4, 5};

// Vacío con tamaño
String nombres[] = new String[5];

// Tamaño variable
int[] array = new int[n];  // n introducido por usuario
```

### Atributos y Bucles

```java
array.length  // ⚠️ NO es método, es PROPIEDAD

// Bucle tradicional
for (int i = 0; i < array.length; i++) {
    System.out.println(array[i]);
}

// Bucle for-each
for (int valor : array) {
    System.out.println(valor);
}
```

### Patrones Comunes

**Suma y Media:**

```java
int suma = 0;
for (int i = 0; i < array.length; i++) {
    suma += array[i];
}
double media = (double) suma / array.length;
```

**Máximo y Mínimo:**

```java
int max = array[0];
int min = array[0];
for (int i = 1; i < array.length; i++) {
    if (array[i] > max) max = array[i];
    if (array[i] < min) min = array[i];
}
```

**Búsqueda:**

```java
int indice = -1;
for (int i = 0; i < array.length; i++) {
    if (array[i] == valor) {
        indice = i;
        break;  // ⚠️ IMPORTANTE: parar cuando encuentres
    }
}
```

**Invertir Array:**

```java
for (int i = 0; i < array.length / 2; i++) {
    int temp = array[i];
    array[i] = array[array.length - 1 - i];
    array[array.length - 1 - i] = temp;
}
```

---

## 🔧 **3. MÉTODOS DE LA CLASE Arrays**

Importar: `import java.util.Arrays;`

| Método                             | Qué hace                     | Ejemplo                         |
|------------------------------------|------------------------------|---------------------------------|
| `copyOf(array, longitud)`          | Copia hasta longitud         | `Arrays.copyOf(arr, 3)`         |
| `copyOfRange(array, desde, hasta)` | Copia rango (hasta excluida) | `Arrays.copyOfRange(arr, 1, 4)` |
| `fill(array, valor)`               | Rellena todo                 | `Arrays.fill(arr, 5)`           |
| `fill(array, desde, hasta, valor)` | Rellena rango                | `Arrays.fill(arr, 2, 5, 10)`    |
| `equals(arr1, arr2)`               | ¿Son iguales?                | `Arrays.equals(arr1, arr2)`     |
| `sort(array)`                      | Ordena ascendente            | `Arrays.sort(arr)`              |
| `toString(array)`                  | Convierte a String           | `Arrays.toString(arr)`          |

---

## 🎲 **4. ARRAYS BIDIMENSIONALES (MATRICES)**

### Declaración

```java
// Vacío
int matriz[][] = new int[3][4];  // 3 filas, 4 columnas

// Con valores
int matriz[][] = {{1, 2, 3}, {4, 5, 6}};  // 2×3
```

### Acceso y Atributos

```java
matriz[fila][columna]           // Acceso elemento
matriz.length                   // Nº de FILAS
matriz[0].length                // Nº de COLUMNAS
```

### Recorrido (Bucles Anidados)

```java
// Recorrer toda la matriz
for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        System.out.println(matriz[i][j]);
    }
}

// Recorrer una fila
for (int j = 0; j < matriz[0].length; j++) {
    System.out.println(matriz[fila][j]);
}

// Recorrer una columna
for (int i = 0; i < matriz.length; i++) {
    System.out.println(matriz[i][columna]);
}
```

### Métodos para Arrays 2D

```java
// Comparar matrices
Arrays.deepEquals(matriz1, matriz2);

// Convertir a String
Arrays.deepToString(matriz);
```

### Patrones 2D Comunes

**Suma Total:**

```java
int sumaTotal = 0;
for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        sumaTotal += matriz[i][j];
    }
}
```

**Contar con Condición:**

```java
int contador = 0;
for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        if (matriz[i][j] > 10) contador++;
    }
}
```

---

## 💻 **5. TUS EJERCICIOS PRÁCTICOS**

### Act1JAAlejo (6 ejercicios Strings)

- ✅ Separar nombre+apellido
- ✅ Contar palabras en frase
- ✅ Invertir cadena
- ✅ Validar palíndromo
- ✅ Reemplazar caracteres
- ✅ Extraer subcadenas

### Act2JAAlejo (8 ejercicios Arrays 1D)

- ✅ Suma elementos
- ✅ Media de valores
- ✅ Máximo y mínimo
- ✅ Invertir array
- ✅ Buscar en array
- ✅ Desplazar elementos
- ✅ Eliminar elemento
- ✅ Reemplazar valores

### Act3JAAlejo (6 ejercicios métodos Arrays)

- ✅ copyOf con extensión
- ✅ copyOfRange últimos elementos
- ✅ Dividir array en dos
- ✅ Verificar igualdad
- ✅ Rellenar (fill)
- ✅ Ordenar (sort)

### Act4Arrays2DJAAlejo (4 ejercicios Arrays 2D)

- ✅ Suma total matriz
- ✅ Contar > 10
- ✅ Matriz identidad
- ✅ Sopa de letras

### Act5_Arrays3JAAlejo (Sistema notas)

- ✅ Almacenar notas
- ✅ Calcular media
- ✅ Aprobados/Suspensos
- ✅ Menú interactivo

### Act6_ArraysAvanzadosJAAlejo (Sistema goles equipo)

- ✅ Matriz paralela (nombres + goles)
- ✅ Registrar jugadores
- ✅ Introducir goles
- ✅ Mostrar pichichi
- ✅ Ranking goleadores

### Act7_GestionAlmacenJAAlejo (Sistema almacén)

- ✅ Arrays paralelos
- ✅ Búsqueda producto
- ✅ Modificar stock
- ✅ Comparar productos

---

## ⚡ **TIPS PARA NO FALLAR**

| ❌ ERROR COMÚN                      | ✅ SOLUCIÓN                                                       |
|------------------------------------|------------------------------------------------------------------|
| `array.length()`                   | `array.length` (es propiedad, NO método)                         |
| `string1 == string2`               | `string1.equals(string2)`                                        |
| `substring(0, 3)` incluye 3        | `substring(0, 3)` = posiciones 0, 1, 2 (FIN EXCLUIDA)            |
| Olvidar `import java.util.Arrays;` | SIEMPRE importar para usar métodos Arrays                        |
| Matriz: fila o columna no claro    | RECUERDA: `matriz.length` = filas, `matriz[0].length` = columnas |
| Bucles anidados sin cuidado        | Usa `i` para filas, `j` para columnas                            |
| `charAt()` en arrays               | ❌ charAt es solo para String. Arrays: `array[i]`                 |
| Índice fuera de rango              | ✅ Verifica siempre `i < array.length`                            |

---

## 🔍 **CHECKLIST ANTES DEL EXAMEN**

- [ ] Sé los 11 métodos principales de String
- [ ] Entiendo la diferencia entre `.length()` y `.length`
- [ ] Domino los bucles for y for-each
- [ ] Sé copiar arrays con copyOf y copyOfRange
- [ ] Entiendo cómo funcionan los bucles anidados
- [ ] Conozco los 7 ejercicios principales
- [ ] Puedo hacer un bucle que busque, cuente, sume, invierta
- [ ] Sé acceder a `matriz[fila][columna]` correctamente

---

**Última actualización**: 25 de enero de 2026 | ¡Tú puedes con este examen! 💪
