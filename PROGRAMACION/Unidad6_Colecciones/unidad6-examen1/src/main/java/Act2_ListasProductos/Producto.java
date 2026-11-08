package Act2_ListasProductos;

/**
 * Clase Producto - Representa un producto con código, nombre y precio
 */
public class Producto {
    private int codigo;
    private String nombre;
    private double precio;

    // Constructor
    public Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    // Setters
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método toString
    @Override
    public String toString() {
        return String.format("[%d] %s - %.2f€", codigo, nombre, precio);
    }
}
