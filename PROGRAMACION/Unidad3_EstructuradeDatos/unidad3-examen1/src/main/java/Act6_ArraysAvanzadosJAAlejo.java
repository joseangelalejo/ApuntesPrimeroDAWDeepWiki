import java.util.Scanner;
/** Actividad 6 sobre Arrays Avanzados */
public class Act6_ArraysAvanzadosJAAlejo {
    public static void main(String[] args) {
        Scanner messirve = new Scanner(System.in);
        /** Premisa: Un equipo de fútbol quiere llevar el control de los goles marcados por sus jugadores a lo largo de la temporada. Para ello hay que tener en cuenta: 
         * El equipo tiene un máximo de 15 jugadores.
         * Se han disputado 10 partidos hasta el momento.
         * Los goles se almacenarán en un array bidimensional: Filas → jugadores, Columnas → partidos. El valor indica el número de goles marcados por ese jugador en ese partido
         * Además, se almacenará el nombre de cada jugador en un array paralelo.
        */
            // Array unidimensional de Strings para nombres de jugadores.
                String jugadores[] = new String[15];        
                //  String jugadores[][] = new String[15][1];   // Array bidimensional de Strings para jugador y nombres
            // Array bidimensional de enteros para GOLES. Filas: jugadores (15), Columnas: partidos (10).
                int goles[][] = new int[15][10];
        
        /** Crea un programa que tenga un menú de opciones que se repita mientras que no se pulse salir y que haga lo siguiente:
         * 1. Registrar jugadores
         * 2. Introducir goles de un partido
         * 3. Mostrar tabla completa de goles
         * 4. Mostrar goles totales de un jugador
         * 5. Mostrar pichichi del equipo
         * 6. Mostrar estadísticas de un partido
         * 7. Mostrar ranking de goleadores
         * 8. Salir
         */
        int opcion = 0;
        // DONE: Desarrollar código para cada opción del menú.
        // DONE: Implementar bucle do-while para repetir el menú hasta salir. (while si no quiero forzar la primera ejecución)
        // Menú de opciones (switch moderno)
        do {
            System.out.println("Menú de opciones:\n" + "    1. Registrar jugadores\n" + "    2. Introducir goles de un partido\n" + "    3. Mostrar tabla completa de goles\n" + "    4. Mostrar goles totales de un jugador\n" + "    5. Mostrar pichichi del equipo\n" + "    6. Mostrar estadísticas de un partido\n" + "    7. Mostrar ranking de goleadores\n" + "    8. Salir");
            opcion = messirve.nextInt();
            messirve.nextLine(); // Consumir el salto de línea pendiente después de nextInt
            switch (opcion) {
                case 1 -> { // Registrar jugadores
                    for (int i = 0; i<jugadores.length; i++) {
                        System.out.print("Introduzca el nombre del jugador " + (i+1) + ": ");
                        jugadores[i] = messirve.nextLine();
                    }
                    System.out.println("Jugadores registrados correctamente. Los jugadores son:");
                    for (int i = 0; i<jugadores.length; i++) {
                        System.out.println(jugadores[i]);
                    }
                }
                case 2 -> { // Introducir goles de un partido
                    System.out.print("Introduzca el número del partido (1-10): ");
                    int partido = messirve.nextInt() - 1; // Restar 1 para ajustar al índice del array (0-9)
                    for (int i = 0; i<jugadores.length; i++) {
                        System.out.print("Introduzca los goles marcados por " + jugadores[i] + " en el partido " + (partido+1) + ": ");
                        goles[i][partido] = messirve.nextInt();
                    }
                    System.out.println("Goles del partido " + (partido+1) + " registrados correctamente.");
                }
                case 3 -> { // Mostrar tabla completa de goles
                    System.out.println("Tabla completa de goles (jugadores x partidos):");
                    System.out.println(java.util.Arrays.deepToString(goles));
                }
                case 4 -> { // Mostrar goles totales de un jugador
                    System.out.print("Introduzca el nombre del jugador para ver sus goles totales: ");
                    String nombreJugador = messirve.nextLine();
                    int totalGoles = 0;
                    boolean jugadorEncontrado = false;
                    for (int i = 0; i<jugadores.length; i++) {
                        if (jugadores[i].equalsIgnoreCase(nombreJugador)) {
                            jugadorEncontrado = true;
                            for (int j = 0; j<goles[i].length; j++) {
                                totalGoles += goles[i][j];
                            }
                            break;
                        }
                    }
                    if (jugadorEncontrado) {
                        System.out.println("El jugador " + nombreJugador + " ha marcado un total de " + totalGoles + " goles.");
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
                }
                case 5 -> { // Mostrar pichichi del equipo
                    String pichichi = "";
                    int maxGoles = -1;
                    for (int i = 0; i<jugadores.length; i++) {
                        int totalGolesJugador = 0;
                        for (int j = 0; j<goles[i].length; j++) {
                            totalGolesJugador += goles[i][j];
                        }
                        if (totalGolesJugador > maxGoles) {
                            maxGoles = totalGolesJugador;
                            pichichi = jugadores[i];
                        }
                    }
                    System.out.println("El pichichi del equipo es " + pichichi + " con " + maxGoles + " goles.");
                }
                case 6 -> { // Mostrar estadísticas de un partido
                    System.out.print("Introduzca el número del partido para ver sus estadísticas (1-10): ");
                    int partidoEstadisticas = messirve.nextInt() - 1; // Restar 1 para ajustar al índice del array (0-9)
                    int totalGolesPartido = 0;
                    for (int i = 0; i<jugadores.length; i++) {
                        totalGolesPartido += goles[i][partidoEstadisticas];
                    }
                    System.out.println("El total de goles en el partido " + (partidoEstadisticas+1) + " es: " + totalGolesPartido);
                }
                case 7 -> { // Mostrar ranking de goleadores
                    int[] totalGolesPorJugador = new int[jugadores.length];
                    for (int i = 0; i<jugadores.length; i++) {
                        for (int j = 0; j<goles[i].length; j++) {
                            totalGolesPorJugador[i] += goles[i][j];
                        }
                    }
                    // Crear un array de índices para ordenar
                    Integer[] indices = new Integer[jugadores.length];
                    for (int i = 0; i<indices.length; i++) {
                        indices[i] = i;
                    }
                    // Ordenar los índices según los goles totales (burbuja simple para claridad)
                    for (int i = 0; i<indices.length-1; i++) {
                        for (int j = 0; j<indices.length-i-1; j++) {
                            if (totalGolesPorJugador[indices[j]] < totalGolesPorJugador[indices[j+1]]) {
                                // Intercambiar
                                int temp = indices[j];
                                indices[j] = indices[j+1];
                                indices[j+1] = temp;
                            }
                        }
                    }
                    // Mostrar ranking
                    System.out.println("Ranking de goleadores:");
                    for (int i = 0; i<indices.length; i++) {
                        System.out.println((i+1) + ". " + jugadores[indices[i]] + " - " + totalGolesPorJugador[indices[i]] + " goles");
                    }
                }
                case 8 -> { // Salir
                    System.out.println("\n¡Hasta la próxima jugada, amigos del fútbol y del código!\nQue el balón siempre ruede a tu favor… ¡y que los arrays nunca te den fuera de juego!");
                }
                default -> { // Opción no válida
                    System.out.println("\nOpción no válida. Por favor, elija una opción del menú. O introduzca 8 para salir.");
                }
            }
        } while (opcion != 8);
        messirve.close();
    }
}
