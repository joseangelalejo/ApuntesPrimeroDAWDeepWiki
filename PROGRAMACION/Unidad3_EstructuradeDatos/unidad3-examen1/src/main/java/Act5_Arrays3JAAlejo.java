import java.util.Scanner;
import java.util.Arrays;
public class Act5_Arrays3JAAlejo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**Enunciado 1: Crea un programa donde el profesor diga al principio cuantas notas hay,
         * para posteriormente crear un array donde almacene las mismas
         * (se las dará el profesor por teclado)
         */
        /*
        System.out.println("¿Cuántas notas va a introducir?");
        int n = scanner.nextInt();
        System.out.println("A continuación, introduzca las notas:");
        int notas1[] = new int[n+1];
        for (int i=0; i<notas1.length-1; i++) {
            notas1[i] = scanner.nextInt();
        }
        */
        /**Modifica el programa anterior
         * para que la última nota almacenada en el array sea la media
         * de las dadas anteriormente.
         */
        /*
        int sumaNotas = 0;
        for (int i = 0; i<notas1.length-1; i++){sumaNotas+= notas1[i];}
        notas1[n] = sumaNotas/(n-1);
        System.out.println(Arrays.toString(notas1));
         */
        /**Modifica el programa anterior para que sea almacene las notas de n alumnos
         * (número dado por el profesor)
         */
        /*
        System.out.println("¿Cuántas notas va a introducir?");
        int m = scanner.nextInt();
        System.out.println("A continuación, introduzca las notas:");
        int notas2[] = new int[m+1];
        for (int i=0; i<notas2.length-1; i++) {
            notas2[i] = scanner.nextInt();
        }
        int sumaNotas2 = 0;
        for (int i = 0; i<notas2.length-1; i++){sumaNotas2+= notas2[i];}
        notas2[m] = sumaNotas2/(m-1);
        System.out.println(Arrays.toString(notas2));
        */
        /**Modifica el programa anterior para que el profesor pueda consultar:
         * 1. Número de aprobados.
         * 2. Número de suspensos.
         * 3. Media de la clase.
         * 4. Nota máxima y mínima de la clase.
         */
        /* 
        // Calcular estadísticas una vez
        int aprobados = 0;
        int suspensos = 0;
        int sumaTotal = 0;
        int notaMax = Integer.MIN_VALUE;
        int notaMin = Integer.MAX_VALUE;
        for (int i = 0; i<notas2.length-1; i++){
            if (notas2[i]>=5){
                aprobados++;
            } else {
                suspensos++;
            }
            sumaTotal+= notas2[i];
            if (notas2[i]>notaMax){
                notaMax = notas2[i];
            }
            if (notas2[i]<notaMin){
                notaMin = notas2[i];
            }
        }
        
        boolean continuar = true;
        do {
            System.out.println("Indique qué desea consultar:\n1. Número de aprobados.\n2. Número de suspensos.\n3. Media de la clase.\n4. Nota máxima y mínima de la clase.\n5. Salir");
            int opcion = scanner.nextInt();
            switch (opcion){
                case 1 -> System.out.println("Número de aprobados: " + aprobados);
                case 2 -> System.out.println("Número de suspensos: " + suspensos);
                case 3 -> System.out.println("Media de la clase: " + (sumaTotal/(notas2.length-1)));
                case 4 -> System.out.println("Nota máxima: " + notaMax + "\nNota mínima: " + notaMin);
                case 5 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        } while (continuar);
        */

        // Código resultante unificado (combina todos los apartados en un solo flujo)
        // Pedir m (número de notas), leer m notas, calcular media en posición m, mostrar array.
        // Luego calcular estadísticas y menú do while.
        /* */
        System.out.println("¿Cuántas notas va a introducir?");
        int m = scanner.nextInt();
        System.out.println("A continuación, introduzca las notas:");
        int notas[] = new int[m+1];
        for (int i=0; i<notas.length-1; i++) {
            notas[i] = scanner.nextInt();
        }
        int sumaNotas = 0;
        for (int i = 0; i<notas.length-1; i++){sumaNotas+= notas[i];}
        notas[m] = sumaNotas/m;  // Media correcta
        System.out.println(Arrays.toString(notas));

        // Calcular estadísticas
        int aprobados = 0, suspensos = 0, sumaTotal = 0;
        int notaMax = Integer.MIN_VALUE, notaMin = Integer.MAX_VALUE;
        for (int i = 0; i<notas.length-1; i++){
            if (notas[i]>=5) aprobados++; else suspensos++;
            sumaTotal += notas[i];
            if (notas[i]>notaMax) notaMax = notas[i];
            if (notas[i]<notaMin) notaMin = notas[i];
        }

        // Menú do while
        boolean continuar = true;
        do {
            System.out.println("Indique qué desea consultar:\n1. Número de aprobados.\n2. Número de suspensos.\n3. Media de la clase.\n4. Nota máxima y mínima.\n5. Salir");
            int opcion = scanner.nextInt();
            switch (opcion){
                case 1 -> System.out.println("Número de aprobados: " + aprobados);
                case 2 -> System.out.println("Número de suspensos: " + suspensos);
                case 3 -> System.out.println("Media de la clase: " + (sumaTotal/m));
                case 4 -> System.out.println("Nota máxima: " + notaMax + "\nNota mínima: " + notaMin);
                case 5 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        } while (continuar);
        
        scanner.close();
    }
}
