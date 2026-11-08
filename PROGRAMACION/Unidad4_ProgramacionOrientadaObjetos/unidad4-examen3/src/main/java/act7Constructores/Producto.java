package act7Constructores;

public class Producto {
    // ATRIBUTOS
    public String nombre;
    public double precio;
    public int stock;
    
    // CONSTRUCTORES
        // Constructor con precio igual a 0
    public Producto(String nombre, double precio) { 
        this(nombre, precio, 0); // Reutiliza el otro constructor
    }
        // Constructor con todos los datos
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = (precio<0) ? 0 : precio;
        this.stock = stock;
    }
}