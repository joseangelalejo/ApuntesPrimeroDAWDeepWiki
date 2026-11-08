package pract4Interfaces;

public class LineaPedido {
    // ATRIBUTOS
    private Producto producto;
    private int cantidad;
    // CONSTRUCTOR
    public LineaPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    // MÉTODOS SOLICITADOS
    public double subtotal() {
        return producto.getPrecio() * cantidad;
    }

    public String mostrarDetalle() {
        return cantidad + " x " + producto.getNombre() + " = " + subtotal();
    }
}