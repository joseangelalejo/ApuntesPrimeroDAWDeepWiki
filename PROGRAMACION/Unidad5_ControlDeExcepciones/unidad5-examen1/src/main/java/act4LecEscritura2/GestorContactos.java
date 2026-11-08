package act4LecEscritura2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona la lectura y escritura de contactos en archivo
 */
public class GestorContactos {
    private static final String ARCHIVO = "contactos.txt";
    private List<Contacto> contactos;

    public GestorContactos() {
        this.contactos = new ArrayList<>();
        cargarContactosDelArchivo();
    }

    /**
     * Carga los contactos desde el archivo al iniciar
     */
    private void cargarContactosDelArchivo() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    String[] partes = linea.split(";");
                    if (partes.length == 2) {
                        String nombre = partes[0].trim();
                        String telefono = partes[1].trim();
                        contactos.add(new Contacto(nombre, telefono));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Verifica si un contacto existe por nombre
     */
    public boolean existeContactoNombre(String nombre) {
        return contactos.stream()
                .anyMatch(c -> c.getNombre().equalsIgnoreCase(nombre));
    }

    /**
     * Verifica si un teléfono ya existe en la lista
     */
    public Contacto buscarPorTelefono(String telefono) {
        return contactos.stream()
                .filter(c -> c.getTelefono().equals(telefono))
                .findFirst()
                .orElse(null);
    }

    /**
     * Agrega un nuevo contacto
     */
    public boolean agregarContacto(String nombre, String telefono, java.util.Scanner scanner) {
        // Verificar si el contacto ya existe
        if (existeContactoNombre(nombre)) {
            System.out.println("El contacto '" + nombre + "' ya existe.");
            return false;
        }

        // Verificar si el teléfono ya existe
        Contacto contactoExistente = buscarPorTelefono(telefono);
        if (contactoExistente != null) {
            System.out
                    .println("El teléfono " + telefono + " ya está registrado para: " + contactoExistente.getNombre());
            System.out.print("¿Desea reemplazar el contacto? (s/n): ");
            String respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("s")) {
                contactos.remove(contactoExistente);
                contactos.add(new Contacto(nombre, telefono));
                guardarContactos();
                System.out.println("Contacto reemplazado exitosamente.");
                return true;
            } else {
                System.out.println("Operación cancelada.");
                return false;
            }
        }

        // Agregar nuevo contacto
        contactos.add(new Contacto(nombre, telefono));
        guardarContactos();
        System.out.println("Contacto agregado exitosamente.");
        return true;
    }

    /**
     * Guarda todos los contactos en el archivo
     */
    private void guardarContactos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Contacto contacto : contactos) {
                bw.write(contacto.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    /**
     * Muestra todos los contactos almacenados
     */
    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("\nNo hay contactos registrados.\n");
            return;
        }

        System.out.println("\n--- LISTA DE CONTACTOS ---");
        for (int i = 0; i < contactos.size(); i++) {
            Contacto c = contactos.get(i);
            System.out.println((i + 1) + ". Nombre: " + c.getNombre() + ", Teléfono: " + c.getTelefono());
        }
        System.out.println("------------------------\n");
    }

    /**
     * Retorna la lista de contactos
     */
    public List<Contacto> getContactos() {
        return contactos;
    }
}
