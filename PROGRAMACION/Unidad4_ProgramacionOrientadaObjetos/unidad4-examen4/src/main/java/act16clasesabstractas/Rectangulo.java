package act16clasesabstractas;

public class Rectangulo extends FiguraGeometrica {
    // ATRIBUTOS
    private double base;
    private double altura;

    // CONSTRUCTOR PRINCIPAL
    public Rectangulo(String nombre, String color, double base, double altura) {
        super(nombre, color);
        this.base = base;
        this.altura = altura;
    }

    // MÉTODOS
    @Override
    public double calcularArea() { return base * altura; }

    @Override
    public double calcularPerimetro() { return 2 * (base + altura); }

    @Override
    public void dibujar() {
        System.out.println("Dibujando rectángulo de base " + base + " y altura " + altura);
    }

    @Override
    public String toString() {
        return "Rectangulo[" + nombre + ", color=" + color + ", base=" + base + ", altura=" + altura + "]";
    }
}
