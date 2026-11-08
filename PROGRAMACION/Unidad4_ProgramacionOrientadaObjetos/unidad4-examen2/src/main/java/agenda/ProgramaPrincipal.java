package agenda;

import java.util.Scanner;

/**
 * Programa principal para gestionar la agenda de contactos.
 * Proporciona un menú interactivo para el usuario.
 */
public class ProgramaPrincipal {
    static Scanner scanner = new Scanner(System.in);
    static String nombres[] = new String[10];      // Capacidad máxima de 10 contactos
    static String telefonos[] = new String[10];    // Capacidad máxima de 10 teléfonos
    static int totalContactos = 0;
    /**
     * Muestra el menú principal de opciones.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---\n 1. Añadir contacto\n 2. Buscar contacto\n 3. Modificar contacto\n 4. Eliminar contacto\n 5. Listar contactos\n 6. Salir");
    }
    // Métodos de la agenda, se agregan en el mismo archivo que el main por indicación de la profesora
    public static boolean agregarContacto(String nombre, String telefono) {
        if (totalContactos >= 10) {
            return false;
        }
        // Verificar si el nombre o teléfono ya existen
        for (int i = 0; i < 10; i++) {
            if (nombres[i] != null && nombres[i].equalsIgnoreCase(nombre)) {
                return false; // El contacto ya existe
            }
        }
        for (int i = 0; i < 10; i++) {
            if (telefonos[i] != null && telefonos[i].equalsIgnoreCase(telefono)) {
                return false;
            }
        }
        // Buscar el primer espacio null disponible
        for (int i = 0; i < 10; i++) {
            if (nombres[i] == null) {
                nombres[i] = nombre;
                telefonos[i] = telefono;
                totalContactos++;
                return true;
            }
        }
        return false;
    }
    // Método para buscar contactos
    public static String buscarContacto(String nombre) {
        for (int i = 0; i < 10; i++) {
            if (nombres[i] != null && nombres[i].equalsIgnoreCase(nombre)) {
                return "\nContacto encontrado en posición " + (i + 1) + " | Nombre: " + nombres[i] + " | Teléfono: " + telefonos[i];
            }
        }
        return "\nEl contacto no existe en la agenda.";
    }
    // Método para modificar contactos.
    public static boolean modificarContacto(String nombre, String nuevoNombre, String nuevoTelefono) {
        for (int i = 0; i < 10; i++) {
            if (nombres[i] != null && nombres[i].equalsIgnoreCase(nombre)) {
                nombres[i] = nuevoNombre;
                telefonos[i] = nuevoTelefono;
                return true;
            }
        }
        return false;
    }
    // Método para eliminar contactos. No se desplazan los elementos del array porque no se ha explicado y se ha indicado explicitamente en clase que no lo hagamos
    public static boolean eliminarContacto(String nombre) {
        for (int i = 0; i < 10; i++) {
            if (nombres[i] != null && nombres[i].equalsIgnoreCase(nombre)) {
                System.out.println("Está seguro de que desea eliminar al contacto " + nombres[i] + " con número de teléfono: " + telefonos[i] + "\nIngrese 'true' para Si, y 'false' para No");
                boolean eliminarSi = scanner.nextBoolean();
                if (eliminarSi) {
                    nombres[i] = null;
                    telefonos[i] = null;
                    totalContactos--;
                    return true;
                }
            }
        }
        return false;
    }
    /*Si en el método elimminarContacto quisiera hacerlo usando totalContactos en la condición del if (en lugar de 10), tendría que desplazar, sería:
        public static boolean eliminarContacto(String nombre) {
        for (int i = 0; i < totalContactos; i++) {
            if (nombres[i] != null && nombres[i].equalsIgnoreCase(nombre)) {
                // Desplazar elementos hacia arriba
                for (int j = i; j < totalContactos - 1; j++) {
                    nombres[j] = nombres[j + 1];
                    telefonos[j] = telefonos[j + 1];
                }
                // Limpiar la última posición
                nombres[totalContactos - 1] = null;
                telefonos[totalContactos - 1] = null;
                totalContactos--;
                return true;
            }
        }
        return false;
    // Si no lo hiciera de esta manera, al listar los contactos, aparecerían huecos vacíos donde se han eliminado contactos y sólo se mostrarían los contactos que hay antes de esos huecos null.
    */
    
    public static void listarContactos() {
        if (totalContactos == 0) {
            System.out.println("\nLa agenda está vacía.\n");
            return;
        }
        System.out.println("\n--- CONTACTOS ---");
        int contador = 0;
        for (int i = 0; i < 10; i++) {
            if (nombres[i] != null) {
                System.out.printf("%d. %s - %s%n", (contador + 1), nombres[i], telefonos[i]);
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
                case 1 -> {     // DONE: Implementar añadir contacto
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
                case 2 -> {     // DONE: Implementar buscar contacto
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    String resultado = buscarContacto(nombre);
                    System.out.println(resultado);
                }
                case 3-> {      // DONE: Implementar modificar contacto
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
                case 4-> {      // DONE: Implementar eliminar contacto
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
