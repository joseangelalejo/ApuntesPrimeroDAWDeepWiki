package pract2Interfaces;

public class Circulo extends FiguraGeometrica {
    // ATRIBUTOS EXTRAS
    protected double radio;
    // CONSTRUCTOR
    public Circulo(String color, String nombre, double radio) {
        super(color, nombre);
        this.radio = radio;
    }
    // MÉTODOS
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
    @Override 
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
    @Override
    public void dibujar() {
        System.out.println(getClass().getSimpleName() + " - Nombre: " + nombre + " - Color: " + color);
        System.out.println("Radio: " + radio);
    }
}