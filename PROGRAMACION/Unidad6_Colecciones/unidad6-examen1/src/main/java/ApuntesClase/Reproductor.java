package ApuntesClase;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Reproductor - Simula un reproductor de música con menú interactivo
 */
public class Reproductor {
    private ArrayList<Cancion> listaReproduccion;
    private Scanner scanner;

    // Constructor
    public Reproductor() {
        this.listaReproduccion = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        inicializarCancionesEjemplo();
    }

    // Inicializar con canciones de ejemplo
    private void inicializarCancionesEjemplo() {
        listaReproduccion.add(new Cancion("Bohemian Rhapsody", "Queen", 354));
        listaReproduccion.add(new Cancion("Stairway to Heaven", "Led Zeppelin", 482));
        listaReproduccion.add(new Cancion("Imagine", "John Lennon", 183));
        listaReproduccion.add(new Cancion("Like a Rolling Stone", "Bob Dylan", 369));
        listaReproduccion.add(new Cancion("Hotel California", "Eagles", 391));
        System.out.println("✓ Reproductor inicializado con 5 canciones de ejemplo.\n");
    }

    // Mostrar menú principal
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n========== REPRODUCTOR DE MÚSICA ==========");
            System.out.println("1. Añadir canción");
            System.out.println("2. Borrar canción");
            System.out.println("3. Reproducir canción");
            System.out.println("4. Mostrar lista de reproducción");
            System.out.println("5. Salir del programa");
            System.out.print("Elige una opción (1-5): ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        anadirCancion();
                        break;
                    case 2:
                        borrarCancion();
                        break;
                    case 3:
                        reproducirCancion();
                        break;
                    case 4:
                        mostrarListaReproduccion();
                        break;
                    case 5:
                        System.out.println("\n¡Hasta luego!");
                        break;
                    default:
                        System.out.println("✗ Opción no válida. Intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("✗ Error: Debes introducir un número válido.");
                scanner.nextLine(); // Limpiar buffer
                opcion = 0;
            }
        } while (opcion != 5);
    }

    // Opción 1: Añadir canción
    private void anadirCancion() {
        System.out.println("\n--- Añadir nueva canción ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine().trim();

        if (titulo.isEmpty()) {
            System.out.println("✗ El título no puede estar vacío.");
            return;
        }

        System.out.print("Artista: ");
        String artista = scanner.nextLine().trim();

        if (artista.isEmpty()) {
            System.out.println("✗ El artista no puede estar vacío.");
            return;
        }

        System.out.print("Duración (en segundos): ");
        try {
            int duracion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (duracion <= 0) {
                System.out.println("✗ La duración debe ser mayor a 0 segundos.");
                return;
            }

            Cancion nuevaCancion = new Cancion(titulo, artista, duracion);

            // Verificar si ya existe
            if (listaReproduccion.contains(nuevaCancion)) {
                System.out.println("✗ Esta canción ya existe en la lista.");
                return;
            }

            listaReproduccion.add(nuevaCancion);
            System.out.println("✓ Canción añadida correctamente.");
        } catch (Exception e) {
            System.out.println("✗ Error: La duración debe ser un número válido.");
            scanner.nextLine();
        }
    }

    // Opción 2: Borrar canción
    private void borrarCancion() {
        System.out.println("\n--- Borrar canción ---");
        System.out.println("¿Deseas borrar por (1) Título o (2) Posición en la lista?");
        System.out.print("Elige (1 o 2): ");

        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (opcion == 1) {
                System.out.print("Introduce el título de la canción: ");
                String titulo = scanner.nextLine().trim();

                ArrayList<Integer> coincidencias = new ArrayList<>();
                for (int i = 0; i < listaReproduccion.size(); i++) {
                    if (listaReproduccion.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                        coincidencias.add(i);
                    }
                }

                if (coincidencias.isEmpty()) {
                    System.out.println("✗ No se encontraron canciones con ese título.");
                } else if (coincidencias.size() == 1) {
                    listaReproduccion.remove((int) coincidencias.get(0));
                    System.out.println("✓ Canción borrada correctamente.");
                } else {
                    System.out.println("Se encontraron " + coincidencias.size() + " coincidencias:");
                    for (int idx : coincidencias) {
                        System.out.println("  [" + (idx + 1) + "] " + listaReproduccion.get(idx));
                    }
                    System.out.print("¿Cuál deseas borrar? (número de posición): ");
                    int posicion = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (posicion >= 0 && posicion < listaReproduccion.size()) {
                        listaReproduccion.remove(posicion);
                        System.out.println("✓ Canción borrada correctamente.");
                    } else {
                        System.out.println("✗ Posición no válida.");
                    }
                }
            } else if (opcion == 2) {
                mostrarListaReproduccion();
                System.out.print("Introduce el número de posición (1-" + listaReproduccion.size() + "): ");
                int posicion = scanner.nextInt() - 1;
                scanner.nextLine();

                if (posicion >= 0 && posicion < listaReproduccion.size()) {
                    listaReproduccion.remove(posicion);
                    System.out.println("✓ Canción borrada correctamente.");
                } else {
                    System.out.println("✗ Posición no válida.");
                }
            } else {
                System.out.println("✗ Opción no válida.");
            }
        } catch (Exception e) {
            System.out.println("✗ Error: Introduce un número válido.");
            scanner.nextLine();
        }
    }

    // Opción 3: Reproducir canción
    private void reproducirCancion() {
        System.out.println("\n--- Reproducir canción ---");
        System.out.println("¿Deseas buscar por (1) Título o (2) Posición en la lista?");
        System.out.print("Elige (1 o 2): ");

        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (opcion == 1) {
                System.out.print("Introduce el título de la canción: ");
                String titulo = scanner.nextLine().trim();

                boolean encontrada = false;
                for (Cancion cancion : listaReproduccion) {
                    if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                        reproducirCancionDirecta(cancion);
                        encontrada = true;
                        break;
                    }
                }

                if (!encontrada) {
                    System.out.println("✗ No se encontró ninguna canción con ese título.");
                }
            } else if (opcion == 2) {
                mostrarListaReproduccion();
                System.out.print("Introduce el número de posición (1-" + listaReproduccion.size() + "): ");
                int posicion = scanner.nextInt() - 1;
                scanner.nextLine();

                if (posicion >= 0 && posicion < listaReproduccion.size()) {
                    reproducirCancionDirecta(listaReproduccion.get(posicion));
                } else {
                    System.out.println("✗ Posición no válida.");
                }
            } else {
                System.out.println("✗ Opción no válida.");
            }
        } catch (Exception e) {
            System.out.println("✗ Error: Introduce un número válido.");
            scanner.nextLine();
        }
    }

    // Función auxiliar para reproducir una canción
    private void reproducirCancionDirecta(Cancion cancion) {
        System.out.println("\n♪♪♪ REPRODUCIENDO ♪♪♪");
        System.out.println("Título: " + cancion.getTitulo());
        System.out.println("Artista: " + cancion.getArtista());
        System.out.println("Duración: " + cancion.getDuracionFormato());
        System.out.println("♪♪♪ [==========] 100% ♪♪♪\n");
    }

    // Opción 4: Mostrar lista de reproducción
    private void mostrarListaReproduccion() {
        System.out.println("\n--- Lista de reproducción ---");
        if (listaReproduccion.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            for (int i = 0; i < listaReproduccion.size(); i++) {
                Cancion cancion = listaReproduccion.get(i);
                System.out.printf("[%d] %s - %s (%s)%n",
                        i + 1,
                        cancion.getTitulo(),
                        cancion.getArtista(),
                        cancion.getDuracionFormato());
            }
            System.out.println("Total: " + listaReproduccion.size() + " canción(es)");
        }
    }

    // Método main
    public static void main(String[] args) {
        Reproductor reproductor = new Reproductor();
        reproductor.mostrarMenu();
    }
}
