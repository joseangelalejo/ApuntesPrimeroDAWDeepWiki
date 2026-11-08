/*
 * Una biblioteca desea informatizar su sistema de gestión de libros.
 * 
 * Escribe un programa que permita al usuario realizar las siguientes operaciones:
 * 
 * Añadir libros al inventario:
 *     - Solicita al usuario el título del libro y el número de ejemplares disponibles.
 *     - Añade esta información a dos arrays paralelos: uno para los títulos de los libros y otro para el número de ejemplares.
 *     - Si el inventario ya tiene 10 libros, muestra un mensaje indicando que no se pueden añadir más.
 * 
 * Actualizar la cantidad de ejemplares de un libro:
 *     - Solicita al usuario el título del libro.
 *     - Busca el libro en el array. Si existe, solicita el nuevo número de ejemplares y actualiza el array correspondiente.
 *     - Si no existe, muestra un mensaje de error indicando que el libro no está registrado.
 * 
 * Consultar la cantidad de ejemplares de un libro:
 *     - Solicita al usuario el título del libro.
 *     - Muestra la cantidad de ejemplares disponibles si el libro existe.
 *     - Si no existe, muestra un mensaje indicando que el libro no está registrado.
 * 
 * Listar todos los libros disponibles:
 *     - Muestra en pantalla todos los títulos de los libros con la cantidad de ejemplares disponibles en un formato claro.
 * 
 * Requisitos adicionales:
 *     - Los arrays deben tener un tamaño fijo de 10.
 *     - Manejar correctamente los índices del array para evitar desbordamientos.
 *     - Usar strings para buscar libros por título, ignorando mayúsculas/minúsculas.
 *     - Por tema de tiempo NO hace falta que se hagan validaciones para evitar entradas incorrectas (como cantidades negativas o cadenas vacías).
 *       Ni que se repita el menú, solo se podrá seleccionar una sola opción. En caso de que se seleccione una opción incorrecta, sacar un mensaje informando.
 */
import java.util.Scanner;
public class Act8_RepasoJAAlejo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Nuevo escáner
        // Variables y arrays a usar
        String[] titulos = new String[10];
        int[] ejemplares = new int[10];
        int contadorLibros = 0;
        // Menú de opciones
        System.out.println("Seleccione una opción:  \n1. Añadir libro\n  2. Actualizar cantidad de ejemplares\n  3. Consultar cantidad de ejemplares\n  4. Listar todos los libros\n  5. Salir");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        switch (opcion) {
            case 1 -> {
                System.out.println("Añadir libro seleccionado.");
                if (contadorLibros < 10) {
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el número de ejemplares disponibles: ");
                    int cantidad = scanner.nextInt();
                    titulos[contadorLibros] = titulo;       // Añadir título al array
                    ejemplares[contadorLibros] = cantidad;  // Añadir cantidad al array
                    contadorLibros++;                       // Incrementar el contador de libros
                    System.out.println("Libro añadido correctamente.");
                } else {
                    System.out.println("No se pueden añadir más libros. Inventario lleno.");
                }
            }
            case 2 -> {
                System.out.println("Actualizar cantidad de ejemplares seleccionado.");
                System.out.print("Ingrese el título del libro a actualizar: ");
                String tituloActualizar = scanner.nextLine();
                boolean encontrado = false;
                for (int i = 0; i < contadorLibros; i++) {
                    if (titulos[i].equalsIgnoreCase(tituloActualizar)) {
                        System.out.print("Ingrese el nuevo número de ejemplares: ");
                        int nuevaCantidad = scanner.nextInt();
                        ejemplares[i] = nuevaCantidad; // Actualizar la cantidad
                        System.out.println("Cantidad actualizada correctamente.");
                        encontrado = true;
                        break;              // Salir del bucle una vez encontrado
                    }
                }
                if (!encontrado) {
                    System.out.println("Error: El libro no está registrado.");
                }
            }
            case 3 -> {
                System.out.println("Consultar cantidad de ejemplares seleccionado.");
                System.out.print("Ingrese el título del libro a consultar: ");
                String tituloConsultar = scanner.nextLine();
                boolean encontradoConsultar = false;
                for (int i = 0; i < contadorLibros; i++) {
                    if (titulos[i].equalsIgnoreCase(tituloConsultar)) {
                        System.out.println("Cantidad de ejemplares disponibles: " + ejemplares[i]);
                        encontradoConsultar = true;
                        break;              // Salir del bucle una vez encontrado
                    }
                }
                if (!encontradoConsultar) {
                    System.out.println("El libro no está registrado.");
                }
            }
            case 4 -> {
                System.out.println("Listar todos los libros seleccionado.");
                if (contadorLibros == 0) {
                    System.out.println("No hay libros en el inventario.");
                } else {
                    System.out.println("Libros disponibles:");
                    for (int i = 0; i < contadorLibros; i++) {
                        System.out.println("Título: " + titulos[i] + " | Ejemplares: " + ejemplares[i]);
                    }
                }
            }
            case 5 -> System.out.println("Saliendo del programa.");
            default -> System.out.println("Opción incorrecta.");
        }
        scanner.close();
    }
}
