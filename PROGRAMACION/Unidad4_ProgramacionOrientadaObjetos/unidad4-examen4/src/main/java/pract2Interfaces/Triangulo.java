package pract2Interfaces;

public class Triangulo extends FiguraGeometrica {
    // ATRIBUTOS EXTRAS
    protected double lado1;
    protected double lado2;
    protected double lado3;
    protected double base;
    protected double altura;
    // CONSTRUCTOR
    public Triangulo(String color, String nombre, double lado1, double lado2, double lado3, double base, double altura) {
        super(color, nombre);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.base = base;
        this.altura = altura;
    }
    // MÉTODOS
    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }
    @Override 
    public double calcularPerimetro() {
        return  lado1 + lado2 + lado3;
    }
    @Override
    public void dibujar() {
        System.out.println(getClass().getSimpleName() + " - Nombre: " + nombre + " - Color: " + color);
        System.out.println("Lado 1: " + lado1 + " - Lado 2: " + lado2 + " - Lado 3: " + lado3 + "\nBase: " + base + " - Altura: " + altura);
    }
}
