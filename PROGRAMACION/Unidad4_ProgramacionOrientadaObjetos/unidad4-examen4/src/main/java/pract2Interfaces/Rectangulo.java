package pract2Interfaces;

public class Rectangulo extends FiguraGeometrica {
    // ATRIBUTOS EXTRAS:
    protected double base;
    protected double altura;
    // CONSTRUCTOR
    public Rectangulo(String color, String nombre, double base, double altura) {
        super(color, nombre);
        this.base = base;
        this.altura = altura;
    }
    // MÉTODOS
    @Override
    public double calcularArea() {
        return base*altura;
    }
    @Override 
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
    @Override
    public void dibujar() {
        System.out.println(getClass().getSimpleName() + " - Nombre: " + nombre + " - Color: " + color);
        System.out.println("Base: " + base + " - Altura: " + altura);
    }
}
