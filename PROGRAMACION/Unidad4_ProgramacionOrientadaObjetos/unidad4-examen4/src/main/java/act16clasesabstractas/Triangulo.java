package act16clasesabstractas;

public class Triangulo extends FiguraGeometrica {
    // ATRIBUTOS
    private double lado1;
    private double lado2;
    private double lado3;
    private double base;
    private double altura;

    // CONSTRUCTOR PRINCIPAL
    public Triangulo(String nombre, String color, double lado1, double lado2, double lado3, double base, double altura) {
        super(nombre, color);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.base = base;
        this.altura = altura;
    }

    // MÉTODOS
    @Override
    public double calcularArea() { return (base * altura) / 2; }

    @Override
    public double calcularPerimetro() { return lado1 + lado2 + lado3; }

    @Override
    public void dibujar() {
        System.out.println("Dibujando triángulo con lados " + lado1 + ", " + lado2 + ", " + lado3);
    }

    @Override
    public String toString() {
        return "Triangulo[" + nombre + ", color=" + color + ", lados=" + lado1 + "," + lado2 + "," + lado3 + "]";
    }
}
