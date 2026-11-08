import java.util.Scanner;

/** Actividad sobre Arrays de 2 dimensiones */
public class Act4Arrays2DJAAlejo {
    public static void main(String[] args) {

        // Enunciado 1: Suma de todos los elementos de una matriz
        // Dada una matriz de enteros de tamaño 4×3 ya inicializada en el código
        // El programa debe calcular y mostrar la suma total de todos sus elementos.
        System.out.println("Enunciado 1: Suma de todos los elementos de una matriz");
        // Array con valores dados
        int enteros1[][] = {{4, 5, 6}, {7, 6, 8}, {2, 5, 7}, {1, 3, 10}};
        int sumatotal = 0;
        // Bucle for para recorrer cada fila y columna
        for (int i = 0; i < enteros1.length; i++) {
            for (int j = 0; j < enteros1[i].length; j++) {
                sumatotal += enteros1[i][j];
            }
        }
        System.out.println("La suma total de los valores es: " + sumatotal);

        // Enunciado 2: Contar cuántos números son mayores que 10
        // Crea un array de 2 dimensiones de tamaño 45 con valores introducidos por el usuario.
        // El programa debe decir cuántos de esos números son mayores que 10.
        System.out.println("\nEnunciado 2: Contar cuántos números son mayores que 10");
        Scanner scanner1 = new Scanner(System.in);
        // Array de tamaño 4x5 de enteros
        int enteros2[][] = new int[4][5];
        int mayores10 = 0;
        System.out.println("Introduzca los valores del array.");
        // Bucle para leer valores del usuario
        for (int i = 0; i < enteros2.length; i++) {
            for (int j = 0; j < enteros2[i].length; j++) {
                System.out.print("    Valor = ");
                enteros2[i][j] = scanner1.nextInt();
            }
        }
        // Bucle para contar números mayores que 10
        for (int i = 0; i < enteros2.length; i++) {
            for (int j = 0; j < enteros2[i].length; j++) {
                if (enteros2[i][j] > 10) {
                    mayores10++;
                }
            }
        }
        System.out.println("Hay " + mayores10 + " números mayores de 10");
        scanner1.close();

        // Enunciado 3: Matriz identidad
        // Pide un número n y crea una matriz cuadrada nn
        // Que sea una matriz identidad (1 en la diagonal principal, 0 en el resto)
        System.out.println("\nEnunciado 3: Matriz identidad");
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Introduce un número entero: ");
        int n = scanner2.nextInt();
        // Array de tamaño n x n
        int enteros3[][] = new int[n][n];
        // Bucle para asignar 1 en diagonal, 0 en resto
        for (int i = 0; i < enteros3.length; i++) {
            for (int j = 0; j < enteros3[i].length; j++) {
                if (i == j) {
                    enteros3[i][j] = 1;
                } else {
                    enteros3[i][j] = 0;
                }
            }
        }
        // Bucle para imprimir la matriz
        for (int i = 0; i < enteros3.length; i++) {
            for (int j = 0; j < enteros3[i].length; j++) {
                System.out.print(enteros3[i][j] + " ");
            }
            System.out.println();
        }
        scanner2.close();

        // Enunciado 4: Sopa de letras simplificada
        // Crea una matriz de caracteres 65 con letras introducidas por el usuario
        // El usuario escribe una letra, y el programa debe decir cuántas veces aparece y en qué posiciones
        System.out.println("\nEnunciado 4: Sopa de letras simplificada");
        Scanner scanner4 = new Scanner(System.in);
        // Array de tamaño 6x5 de caracteres
        char enteros4[][] = new char[6][5];
        System.out.println("Introduzca los valores del array (minúsculas si son letras).");
        // Bucle para leer caracteres y convertir a minúsculas
        for (int i = 0; i < enteros4.length; i++) {
            for (int j = 0; j < enteros4[i].length; j++) {
                // Character.toLowerCase para asegurar minúsculas, .charAt(0) para primer carácter
                enteros4[i][j] = Character.toLowerCase(scanner4.next().charAt(0));
            }
        }
        System.out.print("Introduce la letra que deseas buscar: ");
        char buscar4 = Character.toLowerCase(scanner4.next().charAt(0));
        int apariciones = 0;
        // Bucle para buscar la letra y contar apariciones
        for (int i = 0; i < enteros4.length; i++) {
            for (int j = 0; j < enteros4[i].length; j++) {
                if (enteros4[i][j] == buscar4) {
                    apariciones++;
                    int posFila = i;
                    int posColumna = j;
                    // Mostrar posiciones en base 1 (sumar 1)
                    System.out.printf("    Aparece en la fila %d, columna %d %n", (posFila + 1), (posColumna + 1));
                }
            }
        }
        if (apariciones == 0) {
            System.out.printf("La letra %c no se encuentra en la matriz %n", buscar4);
        } else {
            System.out.printf("La letra %c aparece %d veces %n", buscar4, apariciones);
        }
        // Imprimir la matriz para verificar
        System.out.println("\nLa matriz introducida es:");
        for (int i = 0; i < enteros4.length; i++) {
            System.out.print("    ");
            for (int j = 0; j < enteros4[i].length; j++) {
                System.out.printf("%c ", enteros4[i][j]);
            }
            System.out.println();
        }
        scanner4.close();
    }
}
