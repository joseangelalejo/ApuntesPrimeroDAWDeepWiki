package PracticaYo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PracticaEx2_BuclesyEstructuras1 {
    public static void main(String[] args) {

    // Unidad 2 - Programación en Java - Práctica Estructuras de Control - Bucles y Estructuras Alternativas cara a examen | José Ángel Alejo
    Scanner scanner = new Scanner(System.in);
        
    // 1. Pide al usuario un número entero y determina si es par o impar usando la estructura que consideres adecuada.
    
    System.out.println("Enunciado 1: Determinar si un número es par o impar.");

    int n1extra = 1;

    do {
            try {
                System.out.print("Introduce un número entero (0 para salir): ");
                n1extra = scanner.nextInt();

                if (n1extra != 0) {
                    if (n1extra % 2 == 0) {
                        System.out.println("El número: " + n1extra + " es par");
                    } else {
                        System.out.println("El número: " + n1extra + " no es par");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero válido. Inténtalo de nuevo.");
                scanner.nextLine();  // Limpiar el buffer
                n1extra = 1;  // Asignar valor para continuar el bucle
            }
        } while (n1extra != 0);

    scanner.nextLine();  // Limpiar buffer entre enunciados

    // 2. Crea un programa que muestre los números del 1 al 10 utilizando el bucle que consideres adecuado.

    System.out.println("Enunciado 2: Mostrar números del 1 al 10.");

    for (int i2 = 1; i2 <= 10; i2++) {
        System.out.println(i2);
    }

    // 3. Pide al usuario una letra y determina si es una vocal o una consonante usando la estructura que consideres adecuada.

    System.out.println("Enunciado 3: Determinar si una letra es vocal o consonante.");

    System.out.print("Introduce una letra: ");
    char letra3 = scanner.next().toLowerCase().charAt(0);       // Métodos: el .next() toma la siguiente entrada como String, toLowerCase() convierte a minúscula y charAt(0) obtiene el primer carácter.

    if (letra3 == 'a' || letra3 == 'e' || letra3 == 'i' || letra3 == 'o' || letra3 == 'u') {
        System.out.println("La letra: " + letra3 + " es vocal");
    } else {
        System.out.println("La letra: " + letra3 + " es consonante");
    }

    scanner.nextLine();  // Limpiar buffer entre enunciados
    
    // 4. Calcula la suma de los primeros 100 números naturales utilizando un bucle que consideres adecuado.

    System.out.println("Enunciado 4: Calcular la suma de los primeros 100 números naturales.");

    for (int i4 = 0; i4 <= 100; i4++) {
        System.out.println(i4);
    }

    // 5. Pide al usuario dos números y muestra cuál es mayor, menor o si son iguales. Utiliza la estructura que consideres adecuada.

    System.out.println("Enunciado 5: Comparación de numeros. Menor, igual o mayor.");

    System.out.println("Introduce el primer número entero");
    int n5a = scanner.nextInt();

    System.out.println("Introduce el segundo número entero");
    int n5b = scanner.nextInt();

    if (n5a == n5b) {
        System.out.println(n5a + " es igual que " + n5b);
    }else if (n5a > n5b){
        System.out.println(n5a + " es mayor que " + n5b);
    }else if (n5a < n5b){
        System.out.println(n5a + " es menor que " + n5b);
    } else {
        System.out.println("Dato introducido no válido.");
    }
    
    scanner.nextLine();  // Limpiar buffer entre enunciados
    
    // 6. Pide al usuario un número y determina si es positivo, negativo o cero.

    System.out.println("Enunciado 6: Determinar si un número es positivo, negativo o cero.");
    System.out.println("Introduce un número entero");
    int n6 = scanner.nextInt();

    if (n6 == 0) {
        System.out.println(n6 + " es igual a 0");
    } else if (n6 < 0){
        System.out.println(n6 + " es negativo");
    } else if (n6 > 0) {
        System.out.println(n6 + " es positivo");
    } else {
        System.out.println("Número no válido");
    }

    // 7. Muestra los números pares del 1 al 20 utilizando un bucle.

    System.out.println("Enunciado 7: Mostrar números pares del 1 al 20.");
    for (int i7 = 1; i7 <= 20; i7++) {
        if (i7 % 2 == 0) {
            System.out.println(i7);
        }
    }

    // 8. Pide al usuario un día de la semana (1-7) y muestra su nombre usando switch.

    System.out.println("Enunciado 8: Mostrar nombre del día de la semana.");
    System.out.print("Introduce un número del 1 al 7: ");
    int dia = scanner.nextInt();

    switch (dia) {
        case 1 -> System.out.println("Lunes");
        case 2 -> System.out.println("Martes");
        case 3 -> System.out.println("Miércoles");
        case 4 -> System.out.println("Jueves");
        case 5 -> System.out.println("Viernes");
        case 6 -> System.out.println("Sábado");
        case 7 -> System.out.println("Domingo");
        default -> System.out.println("Día no válido.");
    }

    // 9. Calcula el factorial de un número introducido por el usuario utilizando un bucle.

    System.out.println("Enunciado 9: Calcular el factorial de un número.");
    System.out.print("Introduce un número entero: ");
    int numero = scanner.nextInt();
    int factorial = 1;

    for (int i9 = 1; i9 <= numero; i9++) {
        factorial *= i9;
    }

    System.out.println("El factorial de " + numero + " es: " + factorial);
    
    // 10. Pide al usuario un número N y calcula la suma de todos los números impares desde 1 hasta N.

    System.out.println("Enunciado 10: Pide al usuario un número N y calcula la suma de todos los números impares desde 1 hasta N.");

    System.out.println("Introduce un número entero: ");

    int n10 = scanner.nextInt();
    int sumaImpares = 0;

    for (int i10 = 1; i10 <= n10; i10++) {
        if (i10 % 2 != 0) {
            sumaImpares += i10;
        }
    }
    System.out.println("La suma de los números impares desde 1 hasta " + n10 + " es: " + sumaImpares);
    
    // 11. Determina si un número entero introducido por el usuario es divisible entre dós números enteros también introducidos por el usuario.

    System.out.println("Enunciado 11: Determinar si un número introducido por el usuario es divisible por dos números introducidos por el usuario");

    System.out.print("Introduce un número entero: ");
    int n11 = scanner.nextInt();

    System.out.print("Introduce el primer divisor: ");

    int m1 = scanner.nextInt();

    System.out.print("Introduce el segundo divisor: ");

    int m2 = scanner.nextInt();

    if (n11%m1 == 0 && n11%m2 == 0) {
        System.out.println("El número " + n11 + " es divisible por " + m1 + " y " + m2 + ".");
    } else if (n11%m1 == 0 && n11%m2 != 0) {
        System.out.println("El número " + n11 + " solo es divisible por " + m1 + ".");
    } else if (n11%m1 != 0 && n11%m2 == 0) {
        System.out.println("El número " + n11 + " solo es divisible por " + m2 + ".");
    } else {
        System.out.println("El número " + n11 + " NO es divisible por " + m1 + " ni " + m2 + ".");
    }

    // 12. Pide al usuario una letra y determina si es una vocal (incluyendo vocales acentuadas como á, é, í, ó, ú), una consonante o un carácter no válido.

    System.out.println("Enunciado 12: Pide al usuario una letra y determina si es una vocal, incluyendo vocales acentuadas como á, é, í, ó, ú, una consonante o un carácter no válido.");

    System.out.print("Introduce la letra");

    char letra12 = scanner.next().charAt(0);  // Toma el primer carácter de la cadena

    if (letra12 == 'a' || letra12 == 'e' || letra12 == 'i' || letra12 == 'o' || letra12 == 'u' || letra12 == 'á' || letra12 == 'é' || letra12 == 'í' || letra12 == 'ó' || letra12 == 'ú') {
        System.out.print( letra12 + " es una vocal.");

    } else if (Character.isLetter(letra12)) {             // El método Character.isLetter() comprueba si el carácter es una letra del alfabeto. 
        System.out.print(letra12 + " es una consonante");   // Como ya hemos descartado que no es vocal, pero si es una letra del alfabeto, entonces debe ser consonante.
    } else {
        System.out.print(letra12 + " no es una letra válida");  // Si no es vocal ni consonante, entonces no es una letra válida.
    }

    // 13. Calcula el área de un triángulo pidiendo base y altura al usuario.

    System.out.println("Enunciado 13: Calcular el área de un triángulo pidiendo base y altura al usuario.");
    System.out.print("Introduce la base del triángulo: ");
    double base13 = scanner.nextDouble();

    System.out.print("Introduce la altura del triángulo: ");
    double altura13 = scanner.nextDouble();
    double area13 = (base13 * altura13) / 2;
    System.out.println("A partir de la base: " + base13 + " y la altura: " + altura13 + ". El área del triángulo es: " + area13);
        
    // 14. Pide un número y determina si es un cuadrado perfecto (es decir, si su raíz cuadrada es un entero).
        System.out.println("Enunciado 14: Determinar si un número es un cuadrado perfecto.");
        System.out.print("Introduce un número entero: ");

        int n14 = scanner.nextInt();
        boolean esCuadradoPerfecto = false;

        for (int i14 = 1; i14 * i14 <= n14; i14++) {        // Itera desde 1 hasta la raíz cuadrada de n14
            if (i14 * i14 == n14) {                         // Comprueba si el cuadrado de i14 es igual a n14
                esCuadradoPerfecto = true;                  // Si es así, establece la bandera a true y sale del bucle
                break;                                      // El break detiene el bucle una vez que se encuentra un cuadrado perfecto. Evita iteraciones innecesarias.
            }
        }

        if (esCuadradoPerfecto) {                                       // Muestra el resultado basado en la bandera
            System.out.println(n14 + " es un cuadrado perfecto.");      // Si la bandera es true, entonces n14 es un cuadrado perfecto
        } else {
            System.out.println(n14 + " NO es un cuadrado perfecto.");   // Si la bandera es false, entonces n14 no es un cuadrado perfecto
        }
        
    // 15. Muestra los números del 1 al 50 que son divisibles por 7.

    System.out.println("Enunciado 15: Mostrar números del 1 al 50 que son divisibles por 7.");

    for (int i15 = 1; i15 <= 50; i15++) {
        if (i15 % 7 == 0) {
            System.out.print(i15 + "\n");
        } 
    }
    
    // 16. Pide dos números y determina cuál es el mayor, el menor o si son iguales, pero usando solo operadores lógicos.

    System.out.println("Enunciado 16: Pide dos números y determina cuál es el mayor, el menor o si son iguales, pero usando solo operadores lógicos.");

    System.out.print("Ingresa el primer número: ");

    int n16a = scanner.nextInt();

    System.out.print("Ingresa el segundo número: ");

    int n16b = scanner.nextInt();

    if (n16a == n16b) {
        System.out.println(n16a + " y " + n16b + "son iguales.");
    } else if (n16a > n16b) {
        System.out.println(n16a + " es mayor que " + n16b + ".");
    } else if (n16a < n16b) {
        System.out.println(n16b + " es mayor que " + n16a + ".");
    } else {
        System.out.println("Números no válidos.");
    }
        
    // 17. Pide al usuario un número N y calcula la suma de los primeros N números pares (ejemplo: si N=3, suma 2+4+6=12).

    System.out.println(" Enunciado 17: Pide al usuario un número N y calcula la suma de los primeros N números pares (ejemplo: si N=3, suma 2+4+6=12).");

    System.out.print("Introduce un número entero N (positivo): ");

    int n17 = scanner.nextInt();

    int suma17 = 0;             // Variable para acumular suma
    int contadorPares17 = 0;    // Variable para saber cuantos pares he sumado
    int i17;

    for (i17 = 1; contadorPares17 < n17; i17++) {
        if (i17 % 2 == 0){
            suma17 += i17;
            contadorPares17++;
        }
    }
    System.out.println("La suma de los primeros " + n17 + " números pares es: " + suma17);
        
    // 18. Pide un carácter y determina si es un dígito numérico (0-9).

    System.out.println("Enunciado 18: Pide un carácter y determina si es un dígito numérico (0-9).");

    System.out.print("Introduce un carácter: ");
    char char18 = scanner.next().charAt(0);          // Toma el primer carácter de la cadena introducida por el usuario.

    if (Character.isDigit(char18)) {                       // El método ".isDigit" utilizado con la clase Character verifica si el carácter es un dígito numérico.
        System.out.println(char18 + " SÍ es un dígito.");
    } else {
        System.out.println(char18 + " NO es un dígito.");
    }

        
    // 19. Muestra la tabla de multiplicar de un número introducido por el usuario, del 1 al 10.

    System.out.println("Enunciado 19: Muestra la tabla de multiplicar de un número introducido por el usuario, del 1 al 10.");

    System.out.print("Introduce un número: ");

    double n19 = scanner.nextDouble();

    int multi19;

    for (multi19 = 1; multi19<=10; multi19++){
        double resultado19 = n19 * multi19;
        System.out.println(n19 + " x " + multi19 + " = " + resultado19);
    }
        
    // 20. Pide un número y cuenta cuántos dígitos tiene.

    System.out.println("Enunciado 20: Pide un número y cuenta cuántos dígitos tiene.");
    System.out.print("Introduce un número entero: ");
    int n20 = scanner.nextInt();        // Número introducido por el usuario

    int contador20;         // Contador de dígitos
    int numero20 = n20;         // Variable temporal para manipular el número

    for (contador20 = 0; numero20 != 0; numero20 /= 10) {
        contador20++;
    }

    System.out.println("El número " + n20 + " tiene " + contador20 + " dígitos.");
        
    // 21. Determina si un año introducido por el usuario es bisiesto.

    System.out.println("Enunciado 21: Determina si un año introducido por el usuario es bisiesto.");
    System.out.print("Introduce un año (por ejemplo, 2024): ");
    int año21 = scanner.nextInt();
    if ((año21 % 4 == 0 && año21 % 100 != 0) || (año21 % 400 == 0)) {       // Un año es bisiesto si es divisible por 4 pero no por 100, o si es divisible por 400.
        System.out.println(año21 + " es un año bisiesto.");                 
    } else {
        System.out.println(año21 + " no es un año bisiesto.");
    }
        // Esa lógica de división viene de la regla básica del calendario gregoriano que dice: Si un número es divisible por 4 será bisiesto, excepto si es divisible por 100. A menos que además de ser divisible por 4 sea divisible por 400.
        
    // 22. Calcula el máximo común divisor (MCD) de dos números usando el algoritmo de Euclides.

    // 23. Pide un número N y calcula la suma de los cuadrados de los primeros N números naturales.

    // 24. Muestra los números primos entre 1 y 100.

    // 25. Pide una cadena de texto y cuenta cuántas vocales tiene.

    // 26. Calcula el interés compuesto de una inversión: pide capital inicial, tasa de interés anual y años.

    // 27. Pide un número y determina si es un palíndromo (se lee igual al revés).

    // 28. Muestra el patrón de asteriscos en forma de triángulo rectángulo con N filas, donde N es introducido por el usuario.

    // 29. Calcula la serie de Fibonacci hasta el término N, donde N es introducido por el usuario.

    // 30. Pide un número y encuentra todos sus divisores.
        /* 
    System.out.println("Enunciado 30: Pide un número y encuentra todos sus divisores.");

    System.out.print("Introduce un número entero: ");

    int n30 = scanner.nextInt();        // Escaner del entero.

    int d30;                            // Variable para almacenar divisores
    int i30;                            // Variable usada como contador en bucle FOR, para dividir.

    for (i30 = 1; i30<=n30; i30++) {

        d30 = n30%i30;                  // A d30 le asignamos el resto resultado de dividir n30 entre i30 (usando módulo)

        if (d30==0) {                   // Si el resto módulo da 0, se imprimirá el número divisible(i30).
            System.out.println(i30 + " SI es divisor. \n");
        } else {                        // Si el resto no es 0, no es divisible, por lo que se imprime:
            System.out.println(i30 + " NO es divisor. \n"); 
        }       // Las secuencias de escape "\n" son para agregar un espacio entre cada número, así se ve mejor, aunque ocupe más espacio en terminal.
        
    
        //Si sólo queremos que muestre los números divisibles, el if quedaría:
            //if (d30==0){
            //    System.out.println(i30 + "\n");
            //}
        
    }
    */

    scanner.close();
    }
}
