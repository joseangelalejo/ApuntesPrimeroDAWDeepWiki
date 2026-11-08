package agenda;

/**
 * Clase para gestionar una agenda de contactos.
 * Proporciona métodos para añadir, buscar, modificar, eliminar y listar contactos.
 */
public class AgendaContactos {
    static String nombres[] = new String[10];      // Capacidad máxima de 10 contactos
    static String telefonos[] = new String[10];    // Capacidad máxima de 10 teléfonos, uno para cada contacto
    static int totalContactos = 0;
    // DONE: Añade un contacto a la agenda
    public static boolean agregarContacto(String nombre, String telefono) {
        if (totalContactos >= 10) {
            return false;
        }
        for (int i = 0; i < totalContactos; i++) {
            if (nombres[i] != null && nombres[i].equalsIgnoreCase(nombre)) {
                return false; // El contacto ya existe
            }
        }
        for (int i = 0; i < totalContactos; i++) {
            if (telefonos[i] != null && telefonos[i].equalsIgnoreCase(telefono)) {
                return false;
            }
        }
        nombres[totalContactos] = nombre;
        telefonos[totalContactos] = telefono;
        totalContactos++;
        return true;
    }
    
    // DONE: Busca un contacto por nombre (ignora mayúsculas/minúsculas)
    public static String buscarContacto(String nombre) {
        int posicion = 0;
        for (int i = 0; i < totalContactos; i++) {
            if (nombres[i] != null && nombres[i].equalsIgnoreCase(nombre)) {
                posicion = i;
                return "El contacto ya existe en la posición " + posicion + " con teléfono: " + telefonos[i];
            }
        }
        return "El contacto no existe en la agenda.";
    }
    
    // DONE: Modifica el teléfono de un contacto existente
    public static boolean modificarContacto(String nombre, String nuevoTelefono) {
        for (int i = 0; i < totalContactos; i++) {
            if (nombres[i] != null && nombres[i].equalsIgnoreCase(nombre)) {
                telefonos[i] = nuevoTelefono;
                return true;
            }
        }
        return false;
    }
    
    // DONE: Elimina un contacto de la agenda
    public static boolean eliminarContacto(String nombre) {
        for (int i = 0; i < totalContactos; i++) {
            if (nombres[i] != null && nombres[i].equalsIgnoreCase(nombre)) {
                nombres[i] = null;
                telefonos[i] = null;
                totalContactos--;
                return true;
            }
        }
        return false;
    }
    
    // DONE: Lista todos los contactos de la agenda
    public static void listarContactos() {
    for (int i = 0; i < totalContactos; i++) {
        System.out.printf("|   Posición: %d   |   Contacto: %s   |   Teléfono: %s%n", 
            (i + 1), nombres[i], telefonos[i]);
    }
    }
}
