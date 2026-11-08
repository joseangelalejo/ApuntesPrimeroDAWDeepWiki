# Estructuras de control - Entornos de Desarrollo

## Clase Scanner

La clase *Scanner* se utiliza para leer y analizar la entrada de datos del usuario o para procesar texto.
A continuación un ejemplo de como se utiliza la clase Scanner en Java:

```java
import java.util.Scanner;       // Se importa la librería del Scanner.

public static void main(String[] args) {

Scanner scanner = new Scanner(System.in); // Abrimos Scanner (declarandolo y creando el objeto)

System.out.println("Ingrese su nombre");   // Indicamos al usuario que queremos que introduzca en este caso su nombre.

String nombre = scanner.nextLine(); // Indicamos esperar a entrada de texto por parte del usuario
System.out.println("Hola, " + nombre);

// Si queremos por ejemplo preguntar por un número entero

System.out.println("Ingrese su edad");
int edad = scanner.nextInt();               // Ahora usamos scanner.nextInt en lugar de "nextLine" porque estamos pidiendo un dato tipo Integer (Entero)
System.out.println("Tienes, " + edad);
scanner.close();
}
```

En este ejemplo se crea la clase Scanner (primero hay que importarla). El primer caso que vamos a introducir en la consola es el nombre, como vamos a introducir carácteres creamos un `scanner.nextLine()`, y luego esos caracteres que introducimos en la consola se guardan en la variable String `nombre`, que es la que vamos a llamar para mostrar el mensaje de saludo.

Luego hacemos lo mismo pero para un número entero, en este caso usamos `scanner.nextInt()` y guardamos el valor introducido en la variable `edad` de tipo int (entero).

## Clase IF (Condicional)

El `if` es una estructura de control que se utiliza para tomar decisiones en un programa. Permite ejecutar un bloque de código si se cumple una condición específica.

```java
public static void main(String[] args) {

    int edad = 18;
        
    if (edad >= 18) {
        System.out.println("Eres mayor de edad");
    } else {
        System.out.println("Eres menor de edad");
    }
}
```

En este ejemplo creamos una variable de tipo int, donde almacenamos el valor 18. Luego usamos la estructura `if` para comprobar si la variable `edad` es mayor o igual a 18. Si la condición se cumple, se ejecuta el bloque de código dentro del `if`, mostrando "Eres mayor de edad". Si no se cumple, se ejecuta el bloque dentro del `else`, mostrando "Eres menor de edad".

### Combinación de Scanner e IF

Se pueden combinar el uso de Scanner con el uso del IF, usando los dos ejemplos que hemos visto hasta ahora.
Por ejemplo:

```java
public class ED_EstructuraIFPruebas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);       // Declaramos que la Estructura Scanner será invocada con el nombre "scanner"

        System.out.println("Ingrese su edad: ");        // Pedimos la entrada del dato al usuario
        int edad = scanner.nextInt();                       // Declaramos el scanner como un int (tipo de dato que leeremos) llamado edad y le asignamos scanner.nextInt (nextInt indica que esperaremos a que el dato introducido sea un Integer/Entero)

        if (edad >= 18) {                                   // Utilizamos para la condición de IF, la variable INT edad (que tomará el valor que introduzcamos en el scanner)
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }
        
        scanner.close();
    }
}
```

En este ejemplo, primero importamos y declaramos la clase Scanner para leer la entrada del usuario. Pedimos al usuario que ingrese su edad y almacenamos ese valor en la variable `edad` utilizando `scanner.nextInt()`. Luego, usamos una estructura `if` para verificar si la edad es mayor o igual a 18 y mostramos el mensaje correspondiente.

## While (Bucle)

El `while` es una estructura de control que permite repetir un bloque de código mientras una condición sea verdadera. En otras palabras, ejecuta el código dentro del bucle tantas veces como sea necesario hasta que la condición deje de cumplirse.

```java
public class ED_EstructuraWhilePruebas {
    public static void main(String[] args) {
        int contador = 1;                                   //  Creamos una variable contador inicializada a 1.

        while (contador <= 5) {                             //  Condición: mientras contador sea menor o igual a 5.
            System.out.println("Iteración: " + contador);   //  Imprime el valor actual del contador.
            contador++;                                     //  Incrementa el contador en 1.

        }
    }
}
```

En este ejemplo creamos una variable de tipo int llamada `contador`, que inicializamos a 1. Luego, utilizamos un bucle `while` que se ejecuta mientras el valor de `contador` sea menor o igual a 5. Dentro del bucle, imprimimos el valor actual de `contador` y luego incrementamos su valor en 1. El bucle continuará hasta que `contador` sea mayor que 5.

## Switch (Estructura de selección múltiple)

El `switch` es una estructura de control que permite elegir un camino de ejecución entre varios basándose en el valor de una variable o expresión. Es útil cuando se tienen múltiples condiciones que dependen del mismo valor.

```java
public class ED_EstructuraSwitchPruebas {
    public static void main(String[] args) {
        
        int opcion = 2;                                             //  Creamos una variable opción inicializada a 2.

        switch (opcion) {                                           //  Evaluamos el valor de la variable opción.
            case 1:                                                 //  Si opción es igual a 1.
                System.out.println("Opción 1 seleccionada.");
                break;                                              //  Salimos del switch.
            case 2:                                                 //  Si opción es igual a 2.
                System.out.println("Opción 2 seleccionada.");
                break;                                              //  Salimos del switch.
            default:                                                //  Si ninguna de las opciones anteriores coincide.
                System.out.println("Opción no válida.");
                break;                                              //  Salimos del switch.
        }
    }
}
```

En este ejemplo, creamos una variable de tipo int llamada `opcion`, que inicializamos a 2. Luego, utilizamos una estructura `switch` para evaluar el valor de `opcion`. Dependiendo del valor, se ejecuta el bloque de código correspondiente al caso que coincida. Si no coincide con ninguno de los casos definidos, se ejecuta el bloque `default`, imprimiendo "Opción no válida". Podemos crear tantos casos como queramos.
