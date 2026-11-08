import java.util.Arrays;
import java.util.Random;
public class Act3JAAlejo {
    public static void main(String[] args) {
        Random rand = new Random();    // Función random para crear números randoms al llamarla.
        /*  */
        //  Enunciado 1: Escribe un programa que tenga un array de 4 posiciones. Haz una copia de 6 usando el método oportuno. Imprime los dos array y mira que sucede con las posiciones nuevas.
            System.out.println("\nEnunciado 1:");
            int array1[] = {1,2,3,4};
            int array1b[] = Arrays.copyOf(array1, 6);
            System.out.println("Array inicial de 4: " + Arrays.toString(array1) + "\nArray de 6: " + Arrays.toString(array1b));
            // Las posiciones "extras" tienen valor por defecto de 0.
        
        //  Enunciado 2: Dado un array de 10 números aleatorios crea un array igual de los último 5 números.
            System.out.println("\nEnunciado 2:");
            int array2[] = new int[10]; // Array de 10 posiciones
            //  For para llenar el array con números aleatorios
                for (int i = 0; i<array2.length; i++) {
                    array2[i] = rand.nextInt(51); // Números desde 0 hasta 50 inclusive
                }
            int array2b[] = Arrays.copyOfRange(array2, array2.length-5, array2.length);
            System.out.println("    Array original: " + Arrays.toString(array2) + "\n    Array de copia: " + Arrays.toString(array2b));
        
        //  Enunciado 3: Dado un array de 8 dividilo en dos.
            System.out.println("\nEnunciado 3:");
            int array3[] = {1,2,3,4,5,6,7,8};
            int array3a[] = Arrays.copyOfRange(array3, array3.length-4, array3.length);
            int array3b[] = Arrays.copyOfRange(array3, 0, 4);
            System.out.println("    Array original: " + Arrays.toString(array3) + "\n    Primera mitad: " + Arrays.toString(array3a) + "\n    Segunda mitad: " + Arrays.toString(array3b));
        
        //  Enunciado 4: Haz una copia de un array y verifica que son iguales.
            System.out.println("\nEnunciado 4:");
            int array4[] = new int[10];
            //  For para llenar el array con números aleatorios
                for (int i = 0; i<array4.length; i++) {
                    array4[i] = rand.nextInt(51); // Números desde 0 hasta 50 inclusive
                }
            //  Array de copia
            int array4a[] = Arrays.copyOf(array4, array4.length);
            //  If para comprobar si son iguales o no
                if (Arrays.equals(array4, array4a)) {
                    System.out.println("    Son iguales");
                } else {
                    System.out.println("    NO son iguales");
                }
            // Imprimir los arrays para verificar si eran o no iguales
                System.out.println("        Array original: " + Arrays.toString(array4) + "\n        Array de copia: " + Arrays.toString(array4a));
            
        //  Enunciado 5: Crea un array  de 15 posiciones para representar asientos de un cine. Inicialmente los asiento deben estar vacíos. Y luego se hará una compra del 5 al 10.
            System.out.println("\nEnunciado 5:");
            boolean asientos[] = new boolean[15];  // Asientos disponibles (valor por defecto 0)
            System.out.println("        Array original: " + Arrays.toString(asientos));
            // Método de clase Arrays (Arrays.fill) para rellenar un rango de un array con un valor específico especificando array, inicio, fin y valor
                Arrays.fill(asientos, 5, 11, true);  // Ahora: [true, true, ..., true]
                // DONE: Verificar que el rango funciona comentando el bucle for
            System.out.println("        Array modificado: " + Arrays.toString(asientos));
            // También se podría hacer con un bucle for:
                //  for (int i = 5; i<=10; i++) {
                //      asientos[i] = true;
                //  }
        
        //  Enunciado 6: Dado un array de 15 números aleatorios ordénalos. Saca por pantalla el array desordenado y el ordenado.
            System.out.println("\nEnunciado 6:");
            int array6[] = new int [15];
            //  For para rellenar el array
                for (int i = 0; i<array6.length; i++) {
                    array6[i] = rand.nextInt(51); // Números desde 0 hasta 50 inclusive
                }
            //  Nuevo array copia del original y lo ordenamos.
                int array6a[] = Arrays.copyOf(array6, array6.length);
                Arrays.sort(array6a);   //  Ordenar el nuevo array
            //  Imprimir array desordenado y luego ordenado
                //  System.out.println("    Array desordenado: " + Arrays.toString(array6) + "\n    Array ordenado: " + Arrays.toString(array6a));
            //  Prueba de System.out.printf JA | Si funciona. Se puede usar .toString en un System.out.printf
                System.out.printf("     Array desordenado: %s%n     Array ordenado: %s", Arrays.toString(array6), Arrays.toString(array6a));
    }
}
