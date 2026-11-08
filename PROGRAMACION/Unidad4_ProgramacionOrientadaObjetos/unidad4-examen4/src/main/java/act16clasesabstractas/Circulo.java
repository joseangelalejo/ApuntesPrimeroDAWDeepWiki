package act16clasesabstractas;

public class Circulo extends FiguraGeometrica {
    // ATRIBUTOS
    private double radio;
    private static final double PI = Math.PI;

    // CONSTRUCTOR PRINCIPAL
    public Circulo(String nombre, String color, double radio) {
        super(nombre, color);
        this.radio = radio;
    }

    // MÉTODOS
    @Override
    public double calcularArea() { return PI * radio * radio; }

    @Override
    public double calcularPerimetro() { return 2 * PI * radio; }

    @Override
    public void dibujar() {
        System.out.println("Dibujando círculo de radio " + radio);
    }

    @Override
    public String toString() {
        return "Circulo[" + nombre + ", color=" + color + ", radio=" + radio + "]";
    }
}
