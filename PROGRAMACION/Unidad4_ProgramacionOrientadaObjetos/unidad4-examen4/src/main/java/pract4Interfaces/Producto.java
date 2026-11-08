package pract4Interfaces;

public class Producto {
    // ATRIBUTOS
    private String nombre;
    private double precio;
    // CONSTRUCTOR PRINCIPAL
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    // MÉTODOS SOLICITADOS
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
