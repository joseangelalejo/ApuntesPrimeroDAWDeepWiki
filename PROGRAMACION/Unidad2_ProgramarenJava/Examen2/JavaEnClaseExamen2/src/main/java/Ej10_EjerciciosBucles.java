import java.util.Scanner;

public class Ej10_EjerciciosBucles {
    public static void main(String[] args) {
        
         Scanner scanner = new Scanner(System.in);               // Creo el objeto scanner para leer datos por teclado

        // Ejercicio 10 - Utiliza la estructura de control adecuada para los siguientes enunciados 

        // 1. Suma de números hasta que se introduzca cero.

        System.out.println("Introduzca un número entero para sumar. Para dejar de sumar, introduzca 0");

        int n1;
        int suma = 0;

        do{
            System.out.println("Ingrese el número para sumar");

            n1 = scanner.nextInt();

            suma = suma + n1;
            System.out.println("El resultado es: " + (suma));

        } while (n1 != 0);

        System.out.println("Adios :D");
        
        // 2. Calcular el factorial de un número. El 
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Introduzca un número entero para calcular su factorial:");
        int numero = scanner.nextInt();
        long factorial = 1L;                      // El factorial empieza por 1

        for (int i = 1; i <= numero; i++) {             // Bucle desde 1 hasta el número introducido
            factorial = factorial*i;
        }

        System.out.println("El factorial de " + numero + " es: " + factorial);

        // 3. Comprobar si un número es primo.
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Introduce un número entero para comprobar si es primo:");
        
        int numPrimo = scanner.nextInt();
        boolean esPrimo = true;

        if (numPrimo <= 1) {
            esPrimo = false;
        } else {
            for (int i = 2; i < numPrimo; i++) {        // Para un número mayor que 1, dividimos entre todos los números desde 2 hasta numPrimo-1
                if (numPrimo % i == 0) {                // Si el numPrimo es disivisible por i (es decir, el resto es 0), no será primo
                    esPrimo = false;
                    break;                              // Salimos del bucle si encontramos un divisor
                }
            }
        }

        if (esPrimo) {
            System.out.println(numPrimo + " es un número primo.");
        } else {
            System.out.println(numPrimo + " no es un número primo.");
        }

        //4. Contar cúantos números positivos, negativos y ceros introduce el usuario. El programa termina cuando el usuario introduce 999.
        scanner.nextLine(); // Limpiar el buffer

        int positivos = 0;
        int negativos = 0;
        int ceros = 0;
        int num;

        System.out.println("Introduce números enteros para contar positivos, negativos y ceros. Introduce 999 para terminar:");

        do {
            num = scanner.nextInt();

            if (num > 0 && num != 999) {                  // condición para no contar el 999 como número introducido por el usuario, porque 999 es para salir
                positivos++;
            } else if (num < 0) {
                negativos++;
            } else if (num == 0) {
                ceros++;
            }

        } while (num != 999);

        System.out.println("Números positivos: " + positivos);
        System.out.println("Números negativos: " + negativos);
        System.out.println("Ceros: " + ceros);

        //5. Calcular el promedio de números introducidos hasta que se introduzca un 0.
        scanner.nextLine(); //Limpiar buffer

        System.out.println("Introduzca números para saber su promedio. Para salir, introduzca 0");

        int num5 = scanner.nextInt();
        int contador = 0;
        float suma2 = num5;

        while (num5 != 0) {
            System.out.println("Dame otro número");
            num5 = scanner.nextInt();
            suma2 += num5;
            contador++;
        }

        if (num5==0){
            System.out.println("Adios ;D");
        } else {
            float promedio = suma2 / contador;
            System.out.println("Su promedio es: " + promedio);

        }
        
        //6. Aproximar π con la serie de Leibniz:  π ≈ 4 × (1 - 1/3 + 1/5 - 1/7 + 1/9 - ...)  dado el número de factores que queremos.
        scanner.nextLine(); //Limpiar buffer

        System.out.println("Introduce el número de términos para aproximar pi:");

        double terminos = scanner.nextDouble();

        double sumapi = 0;

        for (double i = 1; i <= terminos; i++){

            if (i % 2 == 0){
                sumapi -= 1.0 / (2 * i - 1);
            } else {
                sumapi += 1.0 / (2 * i - 1);
            }
        }

        double piAproximado = 4 * sumapi;

        System.out.println("La aproximación de pi con " + terminos + " términos es: " + piAproximado);

        scanner.close();

    }
    
}
 