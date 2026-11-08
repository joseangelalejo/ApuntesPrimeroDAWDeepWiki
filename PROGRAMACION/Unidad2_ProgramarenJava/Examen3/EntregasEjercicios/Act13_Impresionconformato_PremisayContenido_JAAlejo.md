# Premisa Actividad 13 - Impresión con Formato - José Ángel Alejo Sillero

- [Premisa Actividad 13 - Impresión con Formato - José Ángel Alejo Sillero](#premisa-actividad-13---impresión-con-formato---josé-ángel-alejo-sillero)
  - [**Apartado 1 - Impresión con Formato en Java**](#apartado-1---impresión-con-formato-en-java)
  - [**Mi propuesta de código para Tabla**](#mi-propuesta-de-código-para-tabla)

---
<div style="page-break-after: always;"></div>

1. Busca como imprimir con el siguiente formato:
    - Imprimir enteros.
    - Imprimir números decimales.
    - Imprimir texto (cadenas).
    - Imprimir caracteres individuales.
    - Imprimir valores booleanos.
    - Imprimir números en notación científica.
    - Imprimir números en base octal o hexadecimal.
    - Imprimir con un número concreto de decimales.
    - Imprimir con un ancho fijo de campo.
    - Alinear los valores a la izquierda o a la derecha.
    - Rellenar con ceros a la izquierda.
    - Mostrar siempre el signo positivo o negativo.
    - Separar los miles con comas o puntos.
    - Mostrar los números negativos entre paréntesis.
    - Mostrar el prefijo del tipo de número (por ejemplo, para hexadecimales).
    - Cambiar el orden en que se imprimen los argumentos.
    - Combinar varias opciones de formato en una misma línea.

2. A continuación, realiza una impresión con formato que muestre una tabla que contenga al menos la siguiente información:

| Nombre de una persona (cadena de texto). | Edad (entero). | Nota media(float redondeado). | Aprobado(String "Si" o "No" según booleano) |
|------------------------------------------|----------------|-------------------------------|---------------------------------------------|
| Nombre1                                  | 25             | 8.75                          | Si                                          |

- Consideraciones:
  - Cada columna debe usar las variables de la lista anterior.
  - El resultado debe verse ordenado y legible.

---
<div style="page-break-after: always;"></div>

## **Apartado 1 - Impresión con Formato en Java**

Imprimir con formato en Java se puede lograr utilizando la clase `System.out.printf()` o el método `String.format()`. A continuación, se describen las diferentes opciones de formato mencionadas en la premisa:

> **Imprimir enteros**: Utiliza `%d` para enteros. El %n al final añade un salto de línea.

```java
int numero = 42;
System.out.printf("Número entero: %d%n", numero);
```

> **Imprimir números decimales**: Utiliza `%f` para números de punto flotante.

```javadouble decimal = 3.14159;
System.out.printf("Número decimal: %.2f%n", decimal); // 2 decimales
```

> Imprimir texto (cadenas): Utiliza `%s` para cadenas de texto.

```java
String texto = "Hola, Mundo!";
System.out.printf("Texto: %s%n", texto);
```

> Imprimir caracteres individuales: Utiliza `%c` para caracteres.

```java
char caracter = 'A';
System.out.printf("Carácter: %c%n", caracter);
```

> Imprimir valores booleanos: Utiliza `%b` para valores booleanos.

```java
boolean valor = true;
System.out.printf("Valor booleano: %b%n", valor);
```

> Imprimir números en notación científica: Utiliza `%e` para notación científica.

```java
double cientifico = 12345.6789;
System.out.printf("Notación científica: %.2e%n", cientifico);
```

> Imprimir números en base octal o hexadecimal: Utiliza `%o` para octal y `%x` para hexadecimal.

```java
int numero = 255;
System.out.printf("Número octal: %o%n", numero);
System.out.printf("Número hexadecimal: %x%n", numero);
```

> Imprimir con un número concreto de decimales: Usa `.Nf` donde N es el número de decimales, f es el formato de punto flotante(para números decimales float o double). Y `%n` para salto de línea, aunque también se puede usar una secuencia de escape `"\n"`.

```java
double numero = 3.14159;
System.out.printf("Número con 3 decimales: %.3f%n", numero);
```

> Imprimir con un ancho fijo de campo: Usa `%Nf` donde N es el ancho total del campo.

```java
double numero = 3.14;
System.out.printf("Número con ancho fijo: %10.2f%n", numero);
```

> Alinear los valores a la izquierda o a la derecha: Usa `-` para alinear a la izquierda.

```java
double numero = 3.14;
System.out.printf("Alinear a la derecha: %10.2f%n", numero);
System.out.printf("Alinear a la izquierda: %-10.2f%n", numero);
```

> Rellenar con ceros a la izquierda: Usa `0` antes del ancho.

```java
int numero = 42;
System.out.printf("Rellenar con ceros: %05d%n", numero);
```

> Mostrar siempre el signo positivo o negativo: Usa `+` antes del formato.

```java
int numero = 42;
System.out.printf("Mostrar signo: %+d%n", numero);
```

> Separar los miles con comas o puntos: Usa `,` antes del formato.

```java
int numero = 1000000;
System.out.printf("Separar miles: %,d%n", numero);
```

> Mostrar los números negativos entre paréntesis: Usa `(` antes del formato.

```java
int numero = -42;
System.out.printf("Números negativos entre paréntesis: %(d%n", numero);
```

> Mostrar el prefijo del tipo de número (por ejemplo, para hexadecimales): Usa `#` antes del formato.

```java
int numero = 255;
System.out.printf("Prefijo hexadecimal: %#x%n", numero);
```

> Cambiar el orden en que se imprimen los argumentos: Usa `$` para especificar el índice del argumento.

```java
String nombre = "Juan";
int edad = 30;
System.out.printf("Edad: %2$d, Nombre: %1$s%n", nombre, edad);
```

> Combinar varias opciones de formato en una misma línea:

```java
double numero = -12345.6789;
System.out.printf("Número combinado: %+010.2f%n", numero);
```

---

Por ejemplo, para imprimir una tabla sencilla con la información solicitada en el apartado 2, se podría hacer lo siguiente:

```java
public class TablaPersonas {
    public static void main(String[] args) {
        String nombre = "Nombre1";
        int edad = 25;
        float notaMedia = 8.75f;
        boolean aprobado = true;

        System.out.printf("%-20s | %-5s | %-12s | %-8s%n", "Nombre", "Edad", "Nota Media", "Aprobado");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-20s | %-5d | %-12.2f | %-8s%n", nombre, edad, notaMedia, aprobado ? "Si" : "No");
    }
}
```

Este código imprimirá una tabla con las columnas alineadas y los datos formateados correctamente.

---
<div style="page-break-after: always;"></div>

## **Mi propuesta de código para Tabla**

```java
public class Act13_Impresionconformato {

    public static void main(String[] args) {
        String nombre = "Pepito";
        int edad = 25;

        float notaMedia = 4.997544f;
        float notaTruncada = (float) Math.floor(notaMedia * 100) / 100; // Trunca el float a 2 decimales sin redondear
        boolean aprobado = true;        // Booleano para determinar si está aprobado o no

        if (notaMedia <4.99){      // Lógica para determinar si está aprobado o no. Si la nota media es menor que 4,99, está suspenso. e imprime la tabla.
            aprobado = false;
            System.out.printf("%-20s | %-5s | %-12s | %-12s | %-8s%n", "Nombre", "Edad", "Nota Media", "Nota Truncada", "Aprobado");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-20s | %-5d | %-12.2f | %-12.2f | %-8s%n", nombre, edad, notaMedia, notaTruncada, aprobado ? "Si" : "No");
        } else {                // Si la nota media es mayor o igual a 4,99, está aprobado. e imprime la tabla.
            aprobado = true;        
            System.out.printf("%-20s | %-5s | %-12s | %-12s | %-8s%n", "Nombre", "Edad", "Nota Media", "Nota Truncada", "Aprobado");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-20s | %-5d | %-12.2f | %-12.2f | %-8s%n", nombre, edad, notaMedia, notaTruncada, aprobado ? "Si" : "No");
        }
    }
}
```

- **Lógica de la tabla:**
- **En el primer System.out.printf**
  - "%-20s" imprime la cadena con un ancho fijo de campo de 20 caracteres, alineado a la izquierda.
  - "%-5s" imprime el entero con un ancho fijo de campo de 5
  - "%-12s" imprime el float con un ancho fijo de campo de 12 caracteres, alineado a la izquierda.
  - "%-12s" imprime el float truncado con un ancho fijo de campo de 12 caracteres, alineado a la izquierda.
  - "%-8s" imprime la cadena con un ancho fijo de campo de 8 caracteres, alineado a la izquierda y el %n al final indica un salto de línea.
- **En medio hay un System.out.println que imprime una línea de separación.**
- **En el segundo System.out.printf:**
  - "%-20s" imprime la variable nombre con un ancho fijo de campo de 20 caracteres, alineado a la izquierda.
  - "%-5d" imprime la variable edad como un entero con un ancho fijo de campo de 5 caracteres, alineado a la izquierda.
  - "%-12.2f" imprime la variable notaMedia como un float con 2 decimales y un ancho fijo de campo de 12 caracteres, alineado a la izquierda.
  - "%-12.2f" imprime la variable notaTruncada como un float con 2 decimales y un ancho fijo de campo de 12 caracteres, alineado a la izquierda.
    - "%-8s" imprime "Si" o "No" según el valor booleano aprobado, con un ancho fijo de campo de 8 caracteres, alineado a la izquierda.
    - Después de establecer los formateos, se indican las variables a las que se refiere en orden: nombre, edad, notaMedia y aprobado ? "Si" : "No"
    - Respecto al valor "aprobado", a continuación se agrega una comprobación ternaria para imprimir "Si" si aprobado es true, o "No" si aprobado es false.
