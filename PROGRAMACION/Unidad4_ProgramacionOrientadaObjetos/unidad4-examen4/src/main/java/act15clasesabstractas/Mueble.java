package act15clasesabstractas;

/**
 * Clase abstracta base para representar un mueble con precio y material.
 */
public abstract class Mueble {
    // ATRIBUTOS
    protected double precioBase;
    protected String material;

    // CONSTRUCTOR PRINCIPAL
    public Mueble(double precioBase, String material) {
        this.precioBase = precioBase;
        this.material = material;
    }

    // GETTERS
    public double getPrecioBase() { return precioBase; }
    public String getMaterial() { return material; }

    /**
     * Calcula el precio final del mueble según sus características.
     * Debe implementarse en las subclases.
     */
    public abstract double calcularPrecioFinal();

    /**
     * Muestra cómo se transporta el mueble.
     */
    public abstract void transportar();

    @Override
    public String toString() {
        return "Mueble[material=" + material + ", precioBase=" + precioBase + "]";
    }
}
