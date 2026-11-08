package Act4_Colas1TiendaColaClientes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Clase GestorColaClientes - Gestiona una cola FIFO de clientes en la tienda
 */
public class GestorColaClientes {
    private Queue<ClienteConProductos> colaClientes;
    private Scanner scanner;
    private int contadorCodigos;

    // Constructor
    public GestorColaClientes() {
        this.colaClientes = new LinkedList<>();
        this.scanner = new Scanner(System.in);
        this.contadorCodigos = 1001;
    }

    // Mostrar menú principal
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n========== TIENDA - COLA DE CLIENTES ==========");
            System.out.println("Clientes en cola: " + colaClientes.size());
            System.out.println("1. Añadir cliente a la cola");
            System.out.println("2. Atender al siguiente cliente");
            System.out.println("3. Ver siguiente cliente");
            System.out.println("4. Mostrar todos los clientes");
            System.out.println("5. Salir del programa");
            System.out.print("Elige una opción (1-5): ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        anadirClienteCola();
                        break;
                    case 2:
                        atenderCliente();
                        break;
                    case 3:
                        verSiguienteCliente();
                        break;
                    case 4:
                        mostrarTodosClientes();
                        break;
                    case 5:
                        System.out.println("\n¡Tienda cerrada! Hasta luego.");
                        break;
                    default:
                        System.out.println("✗ Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("✗ Error: Introduce un número válido.");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 5);
    }

    // Opción 1: Añadir cliente a la cola
    private void anadirClienteCola() {
        System.out.println("\n--- Añadir cliente a la cola ---");
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("✗ El nombre no puede estar vacío.");
            return;
        }

        ClienteConProductos nuevoCliente = new ClienteConProductos(nombre, contadorCodigos++);

        // Preguntar si el cliente tiene productos (ampliación)
        System.out.println("¿Deseas agregar productos? (S/N): ");
        String respuesta = scanner.nextLine().trim().toUpperCase();

        if (respuesta.equals("S")) {
            anadirProductosAlCliente(nuevoCliente);
        }

        colaClientes.offer(nuevoCliente); // Añadir al final de la cola
        System.out.println("✓ Cliente añadido a la cola.");
    }

    // Agregar productos al cliente
    private void anadirProductosAlCliente(ClienteConProductos cliente) {
        char seguir = 'S';
        while (seguir == 'S') {
            System.out.print("Nombre del producto: ");
            String nombreProducto = scanner.nextLine().trim();

            System.out.print("Precio del producto: ");
            try {
                double precio = scanner.nextDouble();
                scanner.nextLine();

                if (precio < 0) {
                    System.out.println("✗ El precio no puede ser negativo.");
                    continue;
                }

                cliente.agregarProducto(new Producto(nombreProducto, precio));
                System.out.println("✓ Producto agregado.");

                System.out.print("¿Agregar otro producto? (S/N): ");
                respuesta = scanner.nextLine().trim().toUpperCase();
                seguir = respuesta.charAt(0);
            } catch (Exception e) {
                System.out.println("✗ Error: Introduce un precio válido.");
                scanner.nextLine();
            }
        }
    }

    // Opción 2: Atender al siguiente cliente
    private void atenderCliente() {
        System.out.println("\n--- Atender cliente ---");
        if (colaClientes.isEmpty()) {
            System.out.println("✗ La cola está vacía. No hay clientes para atender.");
            return;
        }

        ClienteConProductos clienteAtendido = colaClientes.poll(); // Sacar del principio de la cola
        System.out.println("✓ Atendiendo a: " + clienteAtendido);
        clienteAtendido.mostrarDetallesCompra();
    }

    // Opción 3: Ver siguiente cliente
    private void verSiguienteCliente() {
        System.out.println("\n--- Ver siguiente cliente ---");
        if (colaClientes.isEmpty()) {
            System.out.println("✗ La cola está vacía.");
            return;
        }

        ClienteConProductos siguienteCliente = colaClientes.peek(); // Ver sin sacar
        System.out.println("✓ Siguiente cliente: " + siguienteCliente);
    }

    // Opción 4: Mostrar todos los clientes en la cola
    private void mostrarTodosClientes() {
        System.out.println("\n--- Clientes en la cola ---");
        if (colaClientes.isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }

        int posicion = 1;
        for (ClienteConProductos cliente : colaClientes) {
            System.out.printf("[%d] %s%n", posicion++, cliente);
        }
        System.out.println("Total: " + colaClientes.size() + " cliente(s) en espera.");
    }

    // Método main
    public static void main(String[] args) {
        GestorColaClientes tienda = new GestorColaClientes();
        tienda.mostrarMenu();
    }
}
