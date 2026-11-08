/*
 * ULTRA CHULETA JAVA - EXAMEN UNIDAD 3 - ESTRUCTURA DE DATOS
 * 
 * CONTENIDOS CLAVE:
 * - Arrays Paralelos (1D) - Strings + int/double
 * - Entrada de usuario con Scanner
 * - Búsqueda en arrays (equalsIgnoreCase, indexOf, etc.)
 * - Menú con switch y bucles
 * - Manipulación de Strings (length, charAt, toLowerCase, etc.)
 * - Bucles for anidados
 * - Condicionales
 */

import java.util.Scanner; // SIEMPRE necesario para leer entrada del usuario

public class SIMULACRO_EXAMEN_JAVA {
    public static void main(String[] args) {
        
        // DECLARAR ARRAYS PARALELOS (Arrays 1D de diferentes tipos)
        
        // Array de Strings para nombres/títulos (tamaño máximo: 10)
        String[] nombres = new String[10];
        
        // Array de int para cantidad/stock (tamaño máximo: 10)
        int[] cantidad = new int[10];
        
        // Array de double para precio (tamaño máximo: 10)
        double[] precio = new double[10];
        
        // Contador para saber cuántos elementos realmente hay (≤ 10)
        int contador = 0;
        
        // CREAR SCANNER para entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // MENÚ INTERACTIVO (do-while + switch moderno)
        int opcion = 0;
        do {
            // Mostrar el menú
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║   SISTEMA DE GESTIÓN DE INVENTARIO     ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║ 1. Añadir producto                     ║");
            System.out.println("║ 2. Buscar producto                     ║");
            System.out.println("║ 3. Actualizar cantidad                 ║");
            System.out.println("║ 4. Listar todos los productos          ║");
            System.out.println("║ 5. Comparar dos productos              ║");
            System.out.println("║ 6. Salir                               ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("Seleccione opción (1-6): ");
            
            opcion = scanner.nextInt(); // Lee int
            scanner.nextLine(); // IMPORTANTE: Limpiar el buffer después de nextInt()
            
            switch (opcion) {
                case 1 -> {
                    System.out.println("\n--- AÑADIR PRODUCTO ---");
                    
                    // Verificar si hay espacio (contador < 10)
                    if (contador < 10) {
                        
                        // Solicitar nombre del producto
                        System.out.print("Nombre del producto: ");
                        String nombreProducto = scanner.nextLine(); // Lee String completo (con espacios)
                        
                        // Solicitar cantidad
                        System.out.print("Cantidad: ");
                        int cantidadProducto = scanner.nextInt();
                        
                        // Solicitar precio
                        System.out.print("Precio: ");
                        double precioProducto = scanner.nextDouble();
                        scanner.nextLine(); // IMPORTANTE: Limpiar buffer
                        
                        // Añadir a los arrays paralelos en la posición del contador
                        nombres[contador] = nombreProducto;
                        cantidad[contador] = cantidadProducto;
                        precio[contador] = precioProducto;
                        
                        // Incrementar contador
                        contador++;
                        
                        System.out.println("Producto añadido correctamente.");
                    } else {
                        System.out.println("No se pueden añadir más productos. Inventario lleno.");
                    }
                }
                
                case 2 -> {
                    System.out.println("\n--- BUSCAR PRODUCTO ---");
                    System.out.print("Nombre del producto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    
                    // BÚSQUEDA: Recorrer el array de nombres hasta encontrar
                    boolean encontrado = false;
                    for (int i = 0; i < contador; i++) {
                        
                        // COMPARAR STRINGS: usar equalsIgnoreCase() para ignorar mayúsculas
                        if (nombres[i].equalsIgnoreCase(nombreBuscar)) {
                            
                            // Mostrar datos del producto encontrado
                            System.out.println("\nProducto encontrado:");
                            System.out.println("   Nombre: " + nombres[i]);
                            System.out.println("   Cantidad: " + cantidad[i] + " unidades");
                            System.out.printf("   Precio: $%.2f%n", precio[i]); // Formatear decimales
                            
                            encontrado = true;
                            break; // IMPORTANTE: Salir del bucle cuando encuentres
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("Producto '" + nombreBuscar + "' no encontrado.");
                    }
                }
                
                case 3 -> {
                    System.out.println("\n--- ACTUALIZAR CANTIDAD ---");
                    System.out.print("Nombre del producto a actualizar: ");
                    String nombreActualizar = scanner.nextLine();
                    
                    // BÚSQUEDA similar a opción 2
                    boolean encontradoActualizar = false;
                    for (int i = 0; i < contador; i++) {
                        if (nombres[i].equalsIgnoreCase(nombreActualizar)) {
                            
                            // Mostrar cantidad actual
                            System.out.println("Cantidad actual: " + cantidad[i]);
                            
                            // Solicitar nueva cantidad
                            System.out.print("Nueva cantidad: ");
                            int nuevaCantidad = scanner.nextInt();
                            scanner.nextLine(); // Limpiar buffer
                            
                            // Actualizar el array
                            cantidad[i] = nuevaCantidad;
                            
                            System.out.println("Cantidad actualizada.");
                            encontradoActualizar = true;
                            break;
                        }
                    }
                    
                    if (!encontradoActualizar) {
                        System.out.println("Producto no encontrado.");
                    }
                }
                
                case 4 -> {
                    System.out.println("\n--- LISTADO DE PRODUCTOS ---");
                    
                    // Verificar si hay productos
                    if (contador == 0) {
                        System.out.println("No hay productos en el inventario.");
                    } else {
                        System.out.println("┌─────┬──────────────────────┬──────────┬─────────────┐");
                        System.out.println("│ #   │ Nombre               │ Cantidad │ Precio      │");
                        System.out.println("├─────┼──────────────────────┼──────────┼─────────────┤");
                        
                        // BUCLE FOR: Recorrer desde 0 hasta contador
                        for (int i = 0; i < contador; i++) {
                            // Formatear salida con printf para alinear columnas
                            System.out.printf("│ %-3d │ %-20s │ %-8d │ $%-10.2f │%n",
                                    i + 1,                    // Número (i+1 para mostrar desde 1)
                                    nombres[i],               // Nombre del producto
                                    cantidad[i],              // Cantidad
                                    precio[i]                 // Precio con 2 decimales
                            );
                        }
                        System.out.println("└─────┴──────────────────────┴──────────┴─────────────┘");
                        
                        // Mostrar total de productos
                        System.out.println("Total de productos: " + contador);
                    }
                }
                
                case 5 -> {
                    System.out.println("\n--- COMPARAR DOS PRODUCTOS ---");
                    System.out.print("Primer producto: ");
                    String producto1 = scanner.nextLine();
                    System.out.print("Segundo producto: ");
                    String producto2 = scanner.nextLine();
                    
                    // BÚSQUEDA DOBLE: Encontrar ambos productos
                    int indice1 = -1, indice2 = -1;
                    
                    for (int i = 0; i < contador; i++) {
                        if (nombres[i].equalsIgnoreCase(producto1)) indice1 = i;
                        if (nombres[i].equalsIgnoreCase(producto2)) indice2 = i;
                    }
                    
                    // Verificar si ambos fueron encontrados
                    if (indice1 != -1 && indice2 != -1) {
                        System.out.println("\n╔════════════════════════════════════════╗");
                        System.out.println("║         COMPARACIÓN DE PRODUCTOS       ║");
                        System.out.println("╠════════════════════════════════════════╣");
                        System.out.printf("║ %-36s ║%n", producto1);
                        System.out.println("║   Cantidad: " + cantidad[indice1] + " | Precio: $" + String.format("%.2f", precio[indice1]));
                        System.out.println("╠════════════════════════════════════════╣");
                        System.out.printf("║ %-36s ║%n", producto2);
                        System.out.println("║   Cantidad: " + cantidad[indice2] + " | Precio: $" + String.format("%.2f", precio[indice2]));
                        System.out.println("╚════════════════════════════════════════╝");
                        
                        // Comparar cantidades
                        if (cantidad[indice1] > cantidad[indice2]) {
                            System.out.println("-> " + producto1 + " tiene MAS cantidad.");
                        } else if (cantidad[indice1] < cantidad[indice2]) {
                            System.out.println("-> " + producto2 + " tiene MAS cantidad.");
                        } else {
                            System.out.println("-> Ambos tienen la MISMA cantidad.");
                        }
                        
                        // Comparar precios
                        if (precio[indice1] > precio[indice2]) {
                            System.out.println("-> " + producto1 + " es MAS CARO.");
                        } else if (precio[indice1] < precio[indice2]) {
                            System.out.println("-> " + producto2 + " es MAS CARO.");
                        } else {
                            System.out.println("-> Ambos tienen el MISMO precio.");
                        }
                    } else {
                        System.out.println("Uno o ambos productos no fueron encontrados.");
                    }
                }
                
                case 6 -> System.out.println("\nPrograma finalizado.");
                
                default -> System.out.println("Opción no válida. Intente de nuevo (1-6).");
            }
        } while (opcion != 6); // Repetir menú mientras no sea 6
        
        // IMPORTANTE: Cerrar el Scanner al final
        scanner.close();
    }
}

/*
 * CONCEPTOS CLAVE UTILIZADOS EN ESTE PROGRAMA
 *
 * 1. ARRAYS PARALELOS:
 *    - String[] nombres, int[] cantidad, double[] precio
 *    - Todos con mismo tamaño (10)
 *    - La posición [i] corresponde al mismo producto en los 3 arrays
 *
 * 2. SCANNER:
 *    - nextInt() -> Lee número entero
 *    - nextDouble() -> Lee número decimal
 *    - nextLine() -> Lee línea completa (STRING)
 *    - IMPORTANTE: Siempre limpiar buffer con nextLine() después de nextInt() o nextDouble()
 *
 * 3. COMPARACIÓN DE STRINGS:
 *    - .equals() -> Compara exacto (distingue mayúsculas/minúsculas)
 *    - .equalsIgnoreCase() -> Ignora mayúsculas/minúsculas
 *    - NUNCA usar == para comparar Strings en Java
 *
 * 4. BÚSQUEDA EN ARRAYS:
 *    - Bucle for desde 0 hasta contador
 *    - Usar bandera (encontrado = false)
 *    - Usar break para salir cuando encuentres
 *    - Retornar índice o -1 si no encuentra
 *
 * 5. MENÚ CON SWITCH MODERNO:
 *    - do-while para repetir menú
 *    - switch (opcion) con case -> { ... }
 *    - while (opcion != 6) para salir
 *
 * 6. FORMATEO DE SALIDA:
 *    - System.out.printf() para columnas alineadas
 *    - %.2f para 2 decimales
 *    - %d para enteros
 *    - %s para strings
 *
 * 7. VERIFICACIONES IMPORTANTES:
 *    - Comprobar si contador < 10 antes de añadir
 *    - Comprobar si contador == 0 antes de listar
 *    - Comprobar si se encuentra (encontrado = true)
 *
 * PATRONES A MEMORIZAR PARA EL EXAMEN
 *
 * PATRÓN: BÚSQUEDA SIMPLE
 * ────────────────────────────────────────────────────────────
 * boolean encontrado = false;
 * for (int i = 0; i < contador; i++) {
 *     if (nombres[i].equalsIgnoreCase(nombreBuscar)) {
 *         // hacer algo...
 *         encontrado = true;
 *         break;
 *     }
 * }
 * if (!encontrado) System.out.println("No encontrado");
 *
 *
 * PATRÓN: BÚSQUEDA DOBLE (dos productos)
 * ────────────────────────────────────────────────────────────
 * int indice1 = -1, indice2 = -1;
 * for (int i = 0; i < contador; i++) {
 *     if (nombres[i].equalsIgnoreCase(producto1)) indice1 = i;
 *     if (nombres[i].equalsIgnoreCase(producto2)) indice2 = i;
 * }
 * if (indice1 != -1 && indice2 != -1) {
 *     // ambos encontrados - hacer comparación
 * }
 *
 *
 * PATRÓN: MENÚ CON SWITCH MODERNO
 * ────────────────────────────────────────────────────────────
 * int opcion = 0;
 * do {
 *     // mostrar menú
 *     opcion = scanner.nextInt();
 *     scanner.nextLine(); // LIMPIAR BUFFER
 *     switch(opcion) {
 *         case 1 -> { // hacer algo; }
 *         case 2 -> { // hacer algo; }
 *         default -> { // opción inválida }
 *     }
 * } while (opcion != 6);
 *
 *
 * PATRÓN: LISTAR TODOS
 * ────────────────────────────────────────────────────────────
 * if (contador == 0) {
 *     System.out.println("Lista vacía");
 * } else {
 *     for (int i = 0; i < contador; i++) {
 *         System.out.println(nombres[i] + ": " + cantidad[i]);
 *     }
 * }
 */
