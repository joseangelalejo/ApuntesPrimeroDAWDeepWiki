package agenda;

import java.util.Scanner;

/**
 * Programa principal para gestionar la agenda de contactos.
 * Se usa un array 2D para almacenar nombre y teléfono en la misma estructura por petición del profesorado.
 * Documento realizado a partir de "ProgramaPrincipal.java", el programa principal donde se utilizan dos arrays 1D siguiendo la premisa del profesorado.
 */
public class ProgramaPrincipal2D {
    static Scanner scanner = new Scanner(System.in);
    static String[][] contactos2D = new String[10][2];  // [10 contactos])[2 datos: nombre(fila), teléfono(columna)]
    static int totalContactos = 0;

    /**
     * Muestra el menú principal de opciones.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---\n 1. Añadir contacto\n 2. Buscar contacto\n 3. Modificar contacto\n 4. Eliminar contacto\n 5. Listar contactos\n 6. Salir");
    }

    // Métodos de la agenda
    public static boolean agregarContacto(String nombre, String telefono) {
        if (totalContactos >= 10) {
            return false;
        }
        // Verificar si el nombre o teléfono ya existen
        for (int i = 0; i < 10; i++) {
            if (contactos2D[i][0] != null && contactos2D[i][0].equalsIgnoreCase(nombre)) {
                return false; // El contacto ya existe
            }
        }
        for (int i = 0; i < 10; i++) {
            if (contactos2D[i][1] != null && contactos2D[i][1].equalsIgnoreCase(telefono)) {
                return false;
            }
        }
        // Buscar el primer espacio null disponible
        for (int i = 0; i < 10; i++) {
            if (contactos2D[i][0] == null) {
                contactos2D[i][0] = nombre;
                contactos2D[i][1] = telefono;
                totalContactos++;
                return true;
            }
        }
        return false;
    }

    // Método para buscar contactos
    public static String buscarContacto(String nombre) {
        for (int i = 0; i < 10; i++) {
            if (contactos2D[i][0] != null && contactos2D[i][0].equalsIgnoreCase(nombre)) {
                return "\nContacto encontrado en posición " + (i + 1) + " | Nombre: " + contactos2D[i][0] + " | Teléfono: " + contactos2D[i][1];
            }
        }
        return "\nEl contacto no existe en la agenda.";
    }

    // Método para modificar contactos
    public static boolean modificarContacto(String nombre, String nuevoNombre, String nuevoTelefono) {
        for (int i = 0; i < 10; i++) {
            if (contactos2D[i][0] != null && contactos2D[i][0].equalsIgnoreCase(nombre)) {
                contactos2D[i][0] = nuevoNombre;
                contactos2D[i][1] = nuevoTelefono;
                return true;
            }
        }
        return false;
    }

    // Método para eliminar contactos
    public static boolean eliminarContacto(String nombre) {
        for (int i = 0; i < 10; i++) {
            if (contactos2D[i][0] != null && contactos2D[i][0].equalsIgnoreCase(nombre)) {
                System.out.println("Está seguro de que desea eliminar al contacto " + contactos2D[i][0] + " con número de teléfono: " + contactos2D[i][1] + "\nIngrese 'true' para Si, y 'false' para No");
                boolean eliminarSi = scanner.nextBoolean();
                if (eliminarSi) {
                    contactos2D[i][0] = null;
                    contactos2D[i][1] = null;
                    totalContactos--;
                    return true;
                }
            }
        }
        return false;
    }

    public static void listarContactos() {
        if (totalContactos == 0) {
            System.out.println("\nLa agenda está vacía.\n");
            return;
        }
        System.out.println("\n--- CONTACTOS ---");
        int contador = 0;
        for (int i = 0; i < 10; i++) {
            if (contactos2D[i][0] != null) {
                System.out.printf("%d. %s - %s%n", (contador + 1), contactos2D[i][0], contactos2D[i][1]);
                contador++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        System.out.println("--- AGENDA DE CONTACTOS ---");

        while (!salir) {
            mostrarMenu();
            System.out.print("\nSeleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch(opcion) {
                case 1 -> {     // Añadir contacto
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del contacto: ");
                    String telefono = scanner.nextLine();
                    boolean agregado = agregarContacto(nombre, telefono);
                    if (agregado) {
                        System.out.println("Contacto añadido exitosamente.");
                    } else {
                        System.out.println("No se pudo añadir el contacto. Puede que ya exista o la agenda esté llena.");
                    }
                }
                case 2 -> {     // Buscar contacto
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    String resultado = buscarContacto(nombre);
                    System.out.println(resultado);
                }
                case 3-> {      // Modificar contacto
                    System.out.println("Ingrese el nombre del contacto a modificar: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el nuevo nombre del contacto: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.println("Ingrese el nuevo teléfono del contacto: ");
                    String nuevoTelefono = scanner.nextLine();
                    boolean modificado = modificarContacto(nombre, nuevoNombre, nuevoTelefono);
                    if (modificado) {
                        System.out.println("Contacto modificado exitosamente.");
                    } else {
                        System.out.println("No se pudo modificar el contacto. Puede que no exista.");
                    }
                }
                case 4-> {      // Eliminar contacto
                    listarContactos();
                    System.out.print("\nIngrese el nombre del contacto a eliminar: ");
                    String nombre = scanner.nextLine();
                    boolean eliminado = eliminarContacto(nombre);
                    if (eliminado) {
                        System.out.println("Contacto eliminado exitosamente.");
                    } else {
                        System.out.println("No se pudo eliminar el contacto. Puede que no exista.");
                    }
                }
                case 5 -> {listarContactos();}
                case 6 -> salir = true;
                default -> System.out.println("Opción no válida.");
            }
        }
        scanner.close();
        System.out.println("¡Hasta luego! :D\n");
    }
}
