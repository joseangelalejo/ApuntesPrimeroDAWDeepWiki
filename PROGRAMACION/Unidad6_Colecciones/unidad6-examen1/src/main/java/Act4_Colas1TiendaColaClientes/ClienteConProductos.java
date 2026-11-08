package Act4_Colas1TiendaColaClientes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Clase ClienteConProductos - Cliente con lista de productos (ampliación)
 */
public class ClienteConProductos extends Cliente {
    private ArrayList<Producto> productos;

    // Constructor
    public ClienteConProductos(String nombre, int codCliente) {
        super(nombre, codCliente);
        this.productos = new ArrayList<>();
    }

    // Agregar producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Obtener lista de productos
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    // Calcular total a pagar
    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    // Mostrar detalles de compra
    public void mostrarDetallesCompra() {
        System.out.println("\n════════════════════════════════════");
        System.out.println("DETALLES DE COMPRA");
        System.out.println("════════════════════════════════════");
        System.out.println("Cliente: " + getNombre());
        System.out.println("Código: " + getCodCliente());
        System.out.println("\nProductos:");
        if (productos.isEmpty()) {
            System.out.println("  (ninguno)");
        } else {
            for (int i = 0; i < productos.size(); i++) {
                System.out.println("  [" + (i + 1) + "] " + productos.get(i));
            }
        }
        System.out.println("\nTOTAL A PAGAR: " + String.format("%.2f€", calcularTotal()));
        System.out.println("════════════════════════════════════\n");
    }
}
