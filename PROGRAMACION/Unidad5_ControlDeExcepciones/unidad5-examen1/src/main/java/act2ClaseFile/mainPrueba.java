package act2ClaseFile;

import java.io.File;
import java.util.Scanner;

public class mainPrueba {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese la ruta del directorio: ");
            String ruta = scanner.nextLine().trim();

            File dir = new File(ruta);

            if (!dir.exists()) {
                System.out.println("La ruta no existe.");
                return;
            }
            if (!dir.isDirectory()) {
                System.out.println("La ruta no es un directorio.");
                return;
            }

            System.out.println("Es un directorio.");
            System.out.println("Permiso de escritura: " + (dir.canWrite() ? "Sí" : "No"));

            File[] contenidos = dir.listFiles();
            if (contenidos == null) {
                System.out.println("No se pudo listar el contenido del directorio.");
                return;
            }

            System.out.println("\nLista de archivos y directorios:");
            for (File archivo : contenidos) {
                System.out.println((archivo.isDirectory() ? "[DIR] " : "[FILE] ") + archivo.getName());
            }

            System.out.print("\nIngrese el nombre del nuevo subdirectorio a crear: ");
            String nombreNuevo = scanner.nextLine().trim();
            File nuevoDir = new File(dir, nombreNuevo);

            if (nuevoDir.exists()) {
                System.out.println("El subdirectorio ya existe: " + nuevoDir.getName());
            } else if (nuevoDir.mkdir()) {
                System.out.println("Subdirectorio creado: " + nuevoDir.getName());
            } else {
                System.out.println("No se pudo crear el subdirectorio.");
            }

            claseFile.eliminarTxtGrandes(dir);

            int total = claseFile.contarArchivosYDirectorios(dir);
            System.out.println("\nCantidad total de archivos y directorios: " + total);

            System.out.print("\n¿Desea borrar el directorio completo recursivamente? (s/n): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("s")) {
                if (claseFile.borrarRecursivo(dir)) {
                    System.out.println("Directorio borrado recursivamente.");
                } else {
                    System.out.println("No se pudo borrar el directorio completamente.");
                }
            } else {
                System.out.println("No se borró el directorio.");
            }
        } catch (SecurityException e) {
            System.out.println("Error de permisos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
