package act4LecEscritura2;

import java.util.Scanner;

/**
 * Clase principal que implementa el menú de gestión de contactos
 */
public class Principal {
    private static Scanner scanner;
    private static GestorContactos gestor;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        gestor = new GestorContactos();

        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    mostrarContactos();
                    break;
                case 3:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.\n");
            }
        } while (opcion != 3);

        scanner.close();
    }

    /**
     * Muestra el menú de opciones
     */
    private static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║  GESTOR DE CONTACTOS           ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║ 1. Agregar un nuevo contacto   ║");
        System.out.println("║ 2. Mostrar todos los contactos ║");
        System.out.println("║ 3. Salir                       ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Obtiene la opción del usuario
     */
    private static int obtenerOpcion() {
        try {
            int opcion = Integer.parseInt(scanner.nextLine());
            return opcion;
        } catch (NumberFormatException e) {
            return -1; // Opción inválida
        }
    }

    /**
     * Agrega un nuevo contacto solicitando datos al usuario
     */
    private static void agregarContacto() {
        System.out.println("\n--- AGREGAR NUEVO CONTACTO ---");

        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese el número de teléfono: ");
        String telefono = scanner.nextLine().trim();

        if (telefono.isEmpty()) {
            System.out.println("El teléfono no puede estar vacío.");
            return;
        }

        gestor.agregarContacto(nombre, telefono, scanner);
    }

    /**
     * Muestra todos los contactos
     */
    private static void mostrarContactos() {
        System.out.println("\n--- VER CONTACTOS ---");
        gestor.mostrarContactos();
    }
}
