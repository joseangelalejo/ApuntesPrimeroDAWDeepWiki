import java.util.Scanner;
import java.util.Arrays;

/**
 * Actividad 7: Gestión de Almacén
 * 
 * PREMISA:
 * Una empresa necesita un programa para gestionar los productos de un pequeño almacén.
 * El programa trabajará con dos arrays paralelos:
 *   - Array unidimensional de Strings: nombres de productos
 *   - Array bidimensional de int: información de cada producto
 *       * Fila i → producto i
 *       * Columna 0 → stock del producto
 *       * Columna 1 → precio del producto (sin decimales)
 */
public class Act7_GestionAlmacenJAAlejo {
    public static void main(String[] args) {
        // DONE: Declarar los datos iniciales (arrays paralelos con productos predefinidos)
        // - Array unidimensional de Strings para nombres de productos
        // - Array bidimensional de int para stock y precio
        String[] nombresProductos = {"Producto1", "Producto2", "Producto3"};
        int[][] infoProductos = {
            {10, 100}, // Stock y precio de Producto1
            {5, 200},  // Stock y precio de Producto2
            {8, 150}   // Stock y precio de Producto3
        };
        
        // DONE: Crear un Scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // DONE: Implementar un menú con bucle do-while que ofrezca las siguientes opciones:
        //       1. Mostrar inventario completo
        //       2. Buscar producto por nombre
        //       3. Modificar stock de un producto
        //       4. Comparar dos productos
        //       5. Salir
        int opcion;
        do {
            System.out.println("Menú de Gestión de Almacén:\n   1. Mostrar inventario completo\n   2. Buscar producto por nombre\n   3. Modificar stock de un producto\n   4. Comparar dos productos\n   5. Salir");
            System.out.print("Seleccione una opción (1-5): ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1 -> {     // OPCIÓN 1: MOSTRAR INVENTARIO COMPLETO
                    System.out.println("\n--- INVENTARIO COMPLETO ---");
                    System.out.println("Productos: " + Arrays.toString(nombresProductos));
                    System.out.println("Detalles:");
                    for (int i = 0; i < nombresProductos.length; i++) {
                        System.out.println("  [" + i + "] " + nombresProductos[i] + " | Stock: " + infoProductos[i][0] + " | Precio: $" + infoProductos[i][1]);
                    }
                    System.out.println();
                }
                case 2 -> {     // OPCIÓN 2: BÚSQUEDA DE PRODUCTO POR NOMBRE
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    
                    int indiceBuscar = -1;
                    for (int i = 0; i < nombresProductos.length; i++) {
                        if (nombresProductos[i].equalsIgnoreCase(nombreBuscar)) {
                            indiceBuscar = i;
                            break;
                        }
                    }
                    
                    if (indiceBuscar != -1) {
                        System.out.println("Producto encontrado: " + nombresProductos[indiceBuscar]);
                        System.out.println("  Stock: " + infoProductos[indiceBuscar][0]);
                        System.out.println("  Precio: $" + infoProductos[indiceBuscar][1] + "\n");
                    } else {
                        System.out.println("Error: Producto '" + nombreBuscar + "' no encontrado.\n");
                    }
                }
                case 3 -> {     // OPCIÓN 3: MODIFICAR STOCK DE UN PRODUCTO
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreModificar = scanner.nextLine();
                    
                    int indiceModificar = -1;
                    for (int i = 0; i < nombresProductos.length; i++) {
                        if (nombresProductos[i].equalsIgnoreCase(nombreModificar)) {
                            indiceModificar = i;
                            break;
                        }
                    }
                    
                    if (indiceModificar != -1) {
                        System.out.print("Stock actual: " + infoProductos[indiceModificar][0] + ". Ingrese el nuevo valor: ");
                        int nuevoStock = scanner.nextInt();
                        scanner.nextLine();
                        int stockAnterior = infoProductos[indiceModificar][0];
                        infoProductos[indiceModificar][0] = nuevoStock;
                        System.out.println("Stock actualizado: " + stockAnterior + " → " + nuevoStock);
                        System.out.println("Datos actualizados: " + Arrays.toString(infoProductos[indiceModificar]) + "\n");
                    } else {
                        System.out.println("Error: Producto '" + nombreModificar + "' no encontrado.\n");
                    }
                }
                case 4 -> {     // OPCIÓN 4: COMPARAR DOS PRODUCTOS
                    System.out.print("Ingrese el nombre del primer producto: ");
                    String producto1 = scanner.nextLine();
                    System.out.print("Ingrese el nombre del segundo producto: ");
                    String producto2 = scanner.nextLine();
                    
                    int indice1 = -1, indice2 = -1;
                    for (int i = 0; i < nombresProductos.length; i++) {
                        if (nombresProductos[i].equalsIgnoreCase(producto1)) indice1 = i;
                        if (nombresProductos[i].equalsIgnoreCase(producto2)) indice2 = i;
                    }
                    
                    if (indice1 != -1 && indice2 != -1) {
                        System.out.println("\n--- COMPARACIÓN DE PRODUCTOS ---");
                        System.out.println(producto1 + ": " + Arrays.toString(infoProductos[indice1]));
                        System.out.println(producto2 + ": " + Arrays.toString(infoProductos[indice2]));
                        
                        // Usar Arrays.equals() para comparar arrays de información
                        if (Arrays.equals(infoProductos[indice1], infoProductos[indice2])) {
                            System.out.println("Resultado: Ambos productos tienen el MISMO stock y precio.\n");
                        } else {
                            boolean mismoStock = infoProductos[indice1][0] == infoProductos[indice2][0];
                            boolean mismoPrecio = infoProductos[indice1][1] == infoProductos[indice2][1];
                            
                            if (mismoStock && !mismoPrecio) {
                                System.out.println("Resultado: Mismo stock, DIFERENTE precio.\n");
                            } else if (!mismoStock && mismoPrecio) {
                                System.out.println("Resultado: DIFERENTE stock, mismo precio.\n");
                            } else {
                                System.out.println("Resultado: DIFERENTE stock y precio.\n");
                            }
                        }
                    } else {
                        System.out.println("Error: Uno o ambos productos no fueron encontrados.\n");
                    }
                }
                case 5 -> {     // OPCIÓN 5: SALIR
                    System.out.println("Saliendo del programa.");
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.\n");
            }
        } while (opcion != 5);
        
        // ===== OPCIÓN 1: MOSTRAR INVENTARIO COMPLETO =====
        // DONE: Mostrar todos los productos con su información completa
        //       - Recorrer con for usando .length
        //       - Mostrar formato: "Producto: X__ | Stock: X__ | Precio: X__"
        //       - Utilizar Arrays.toString() o similar para verificar datos si es necesario
        
        // ===== OPCIÓN 2: BÚSQUEDA DE PRODUCTO POR NOMBRE =====
        // DONE: Solicitar al usuario el nombre del producto a buscar
        // DONE: Recorrer el array de nombres con for usando .length
        // DONE: Comparar nombres (sin distinguir mayúsculas/minúsculas) usando métodos de String
        //       - Utilizar equalsIgnoreCase() para comparación case-insensitive
        // DONE: Si se encuentra:
        //       - Mostrar información completa del producto (stock y precio)
        // DONE: Si no se encuentra:
        //       - Mostrar mensaje de error
        
        // ===== OPCIÓN 3: MODIFICAR STOCK DE UN PRODUCTO =====
        // DONE: Solicitar al usuario el nombre del producto
        // DONE: Recorrer el array de nombres con for usando .length
        // DONE: Comparar nombres (sin distinguir mayúsculas/minúsculas)
        // DONE: Si se encuentra:
        //       - Solicitar el nuevo valor de stock
        //       - Actualizar el valor en el array bidimensional (columna 0)
        //       - Mostrar confirmación
        // DONE: Si no se encuentra:
        //       - Mostrar mensaje de error
        
        // ===== OPCIÓN 4: COMPARAR DOS PRODUCTOS =====
        // DONE: Solicitar al usuario los nombres de los dos productos a comparar
        // DONE: Buscar ambos productos en el array (recorrer con for usando .length)
        // DONE: Si ambos existen:
        //       - Comparar sus valores de stock y precio
        //       - Mostrar si tienen los mismos valores o cuáles son diferentes
        //       - Ejemplo: "Ambos productos tienen el mismo stock pero diferente precio"
        // DONE: Si alguno no existe:
        //       - Mostrar mensaje de error
        
        // ===== OPCIÓN 5: SALIR =====
        // DONE: Cerrar el Scanner y terminar el programa
        
        // RESTRICCIONES A CUMPLIR:
        // - DONE el código debe estar dentro del método main
        // - Usar bucles for con .length para recorrer arrays
        // - Usar métodos de la clase String (equalsIgnoreCase, toUpperCase, etc.)
        // - Usar métodos de la clase Arrays (Arrays.toString(), etc.)
        // - Usar arrays unidimensionales y bidimensionales
        // - Los datos pueden estar inicializados directamente en el código
        scanner.close();
    }
}
