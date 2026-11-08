public class Ej11_EjerciciosBucles2 {
    public static void main(String[] args) {
 
        // 1. Una persona invierte una cantidad inicial C en un banco que paga un interés anual del 5%.
        // Escribe un programa que determine cuántos años tardará el dinero en duplicarse

        System.out.println("Ejercicio 1: Inversión que se duplica con interés compuesto del 5% anual");

        double cantidadInicial = 1000.0; // Cantidad inicial invertida
        double tasaInteres = 0.05; // Tasa de interés anual
        double cantidadActual = cantidadInicial;
        int contadorAnios = 0;
        /*  
        while (cantidadActual < 2 * cantidadInicial) {
            cantidadActual += cantidadActual * tasaInteres;
            contadorAnios++;
        }
        */
        
        for (contadorAnios=0; cantidadActual<2*cantidadInicial; contadorAnios++) {
            cantidadActual += cantidadActual * tasaInteres;     // Usar "+=" lo que hace es sumar y y luego asignar el resultado a la variable
        }
        
        System.out.println("Pasarán " + contadorAnios + " años hasta que su inversión inicial se duplique");

        // 2. Crea un programa que muestre los números del 1 al 10 y luego del 10 al 1. Debe hacerse con un solo bucle, no dos.
        System.out.println("Ejercicio 2: Números del 1 al 10 y luego del 10 al 1");

        int i2;
        //Mi solución, con dos bucles: No válida según el enunciado (usar solo un bucle)
            /* 
            for (i2 = 1; i2 <= 10; i2++) {
                System.out.println(i2);               // Mostrar números del 1 al 10

                if (i2 == 10) {                      // Cuando i2 llegue a 10, hacemos otro bucle para contar hacia atrás.
                    for (int j = 1; j <= 10; j++) {
                        System.out.println(11 - j);  // Mostrar números del 10 al 1
                    }
                }
            }
            */
        // Solución con un solo bucle:
            for (i2 = 1; i2 <= 20; i2++) {                 // Bucle de 1 a 20, mientras i sea menor o igual a 20
            
                if (i2 <= 10) {                      // Si i es menor o igual a 10
                    System.out.println(i2);              // Mostrar números del 1 al 10
                } else {
                    System.out.println(21 - i2);         // Mostrar números del 10 al 1
                }
            }

        // 3. Escribe un programa que pida al usuario una cantidad N (numero entero positivo) y luego calcule la suma de todos los números múltiplos de 3 o 5 que hay entre 1 y N.
        System.out.println("Ejercicio 3: Suma de múltiplos de 3 o 5 entre 1 y N");

        System.out.println("Introduzca un número entero positivo N:");

        int N = 15;                 // En realidad se usaría un scanner para leer el valor introducido por el usuario.
        int i3;
        int multiplo3 = 3;
        int multiplo5 = 5;
        int suma = 0;
        

        for (i3=1; i3<=N; i3++) {
            suma = i3;

            if (i3%multiplo3==0 || i3%multiplo5==0) {
                suma += i3;
            }
        }
        System.out.println("La suma de los múltiplos de " + multiplo3 + " y " + multiplo5 + " es: " + suma);
        
        // 4. Pide un número N y muestra todos los números del 1 al N con el siguiente formato:
        // Si es divisible por 3, mostrar "Fizz"
        // Si es divisible por 5, mostrar "Buzz"
        // Si es divisible por ambos, mostrar "FizzBuzz"
        // Si no es divisible por ninguno, mostrar el número

        System.out.println("Ejercicio 4: FizzBuzz hasta N");

        System.out.println("Introduzca un número entero positivo N:");
        int N4 = 16;                     // En realidad se usaría un scanner para leer el valor introducido por el usuario.
        int i4;

        for (i4 = 1; i4 <= N4; i4++) {                  // Bucle desde 1 hasta N (inclusive)
            if (i4 % 3 == 0 && i4 % 5 == 0) {               // Primero comprobamos si es divisible por ambos (3 y 5)
                System.out.println("FizzBuzz");                 // Mostramos "FizzBuzz"
            } else if (i4 % 3 == 0) {                       // Si no es divisible por ambos, comprobamos si es divisible solo por 3
                System.out.println("Fizz");                 // Mostramos "Fizz"
            } else if (i4 % 5 == 0) {                       // Si no es divisible por 3, comprobamos si es divisible solo por 5
                System.out.println("Buzz");                 // Mostramos "Buzz"
            } else {                                        // Si no es divisible ni por 3 ni por 5
                System.out.println(i4);                             // Mostramos el número
            }
        }

        // Este último Enunciado puede caer en el examen.

    // En el examen entrarán enunciados principalmente de bucles "for" y "while", donde usaremos estructuras de control "if", "if-else", los "Switch" y operadores lógicos.

    }
    
}
