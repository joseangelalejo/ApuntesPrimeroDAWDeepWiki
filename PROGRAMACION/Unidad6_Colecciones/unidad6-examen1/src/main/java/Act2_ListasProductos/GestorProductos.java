package Act2_ListasProductos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Clase GestorProductos - Gestiona una lista de productos con menú interactivo
 */
public class GestorProductos {
    private ArrayList<Producto> listaProductos;
    private Scanner scanner;

    // Constructor
    public GestorProductos() {
        this.listaProductos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Mostrar menú principal
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n========== GESTOR DE PRODUCTOS ==========");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto por código");
            System.out.println("3. Ver producto por posición");
            System.out.println("4. Mostrar todos los productos");
            System.out.println("5. Salir del programa");
            System.out.print("Elige una opción (1-5): ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        eliminarProducto();
                        break;
                    case 3:
                        verProductoPorPosicion();
                        break;
                    case 4:
                        mostrarTodosProductos();
                        break;
                    case 5:
                        System.out.println("\n¡Hasta luego!");
                        break;
                    default:
                        System.out.println("✗ Opción no válida. Intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("✗ Error: Debes introducir un número válido.");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 5);
    }

    // Opción 1: Agregar producto
    private void agregarProducto() {
        System.out.println("\n--- Agregar nuevo producto ---");
        System.out.print("Código: ");
        try {
            int codigo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine().trim();

            if (nombre.isEmpty()) {
                System.out.println("✗ El nombre no puede estar vacío.");
                return;
            }

            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();

            if (precio < 0) {
                System.out.println("✗ El precio no puede ser negativo.");
                return;
            }

            Producto nuevoProducto = new Producto(codigo, nombre, precio);
            listaProductos.add(nuevoProducto);
            System.out.println("✓ Producto agregado correctamente.");
        } catch (Exception e) {
            System.out.println("✗ Error: Introduce datos válidos.");
            scanner.nextLine();
        }
    }

    // Opción 2: Eliminar producto por código (usando iterador)
    private void eliminarProducto() {
        System.out.println("\n--- Eliminar producto ---");
        System.out.print("Introduce el código del producto a eliminar: ");
        try {
            int codigoAEliminar = scanner.nextInt();
            scanner.nextLine();

            boolean encontrado = false;
            Iterator<Producto> iterador = listaProductos.iterator();

            while (iterador.hasNext()) {
                Producto producto = iterador.next();
                if (producto.getCodigo() == codigoAEliminar) {
                    iterador.remove();
                    System.out.println("✓ Producto eliminado correctamente.");
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("✗ No existe producto con ese código.");
            }
        } catch (Exception e) {
            System.out.println("✗ Error: Introduce un código válido.");
            scanner.nextLine();
        }
    }

    // Opción 3: Ver producto por posición
    private void verProductoPorPosicion() {
        System.out.println("\n--- Ver producto por posición ---");
        System.out.print("Introduce la posición (1-" + listaProductos.size() + "): ");
        try {
            int posicion = scanner.nextInt() - 1;
            scanner.nextLine();

            if (posicion >= 0 && posicion < listaProductos.size()) {
                Producto producto = listaProductos.get(posicion);
                System.out.println("\n✓ Producto encontrado:");
                System.out.println("  " + producto);
            } else {
                System.out.println("✗ Posición inválida.");
            }
        } catch (Exception e) {
            System.out.println("✗ Error: Introduce un número válido.");
            scanner.nextLine();
        }
    }

    // Opción 4: Mostrar todos los productos
    private void mostrarTodosProductos() {
        System.out.println("\n--- Lista de productos ---");
        if (listaProductos.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            for (int i = 0; i < listaProductos.size(); i++) {
                System.out.printf("[%d] %s%n", i + 1, listaProductos.get(i));
            }
            System.out.println("Total: " + listaProductos.size() + " producto(s)");
        }
    }

    // Método main
    public static void main(String[] args) {
        GestorProductos gestor = new GestorProductos();
        gestor.mostrarMenu();
    }
}
