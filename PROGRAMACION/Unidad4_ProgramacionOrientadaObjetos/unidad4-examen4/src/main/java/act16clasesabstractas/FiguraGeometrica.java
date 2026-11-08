package act16clasesabstractas;

/**
 * Clase abstracta base para figuras geométricas.
 */
public abstract class FiguraGeometrica {
    // ATRIBUTOS
    protected String color;
    protected String nombre;

    // CONSTRUCTOR PRINCIPAL
    public FiguraGeometrica(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    // GETTERS
    public String getColor() { return color; }
    public String getNombre() { return nombre; }

    // MÉTODOS
    public void mostrarInformacion() {
        System.out.println("Figura: " + nombre + " (color=" + color + ")");
    }

    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    public abstract void dibujar();

    @Override
    public String toString() {
        return "FiguraGeometrica[nombre=" + nombre + ", color=" + color + "]";
    }
}
