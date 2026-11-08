package pract2Interfaces;

public abstract class FiguraGeometrica {
    // ATRIBUTOS
    protected String color;
    protected String nombre;
    // CONSTRUCTOR
    public FiguraGeometrica(String color, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }
    // MÉTODOS ABSTRACTOS SOLICITADOS
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    public abstract void dibujar();
    // MÉTODO CONCRETO
    public void mostrarInformacion() {
        System.out.println(getClass().getSimpleName() + " - Nombre: " + nombre + " - Color: " + color);
    }
}
