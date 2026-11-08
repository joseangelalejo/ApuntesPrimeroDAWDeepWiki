package act17abstractaseinterfaces;

public abstract class EmpleadoBase implements Empleado {
    // ATRIBUTOS
    protected String nombre;
    protected int id;
    protected double salarioBase;
    // CONSTRUCTOR PRINCIPAL
    public EmpleadoBase(String nombre, int id, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
    }
    // MÉTODOS SOLICITADOS
    // Método de implementación de mostrarDetalles
    @Override
    public void mostrarDetalles() {
        System.out.printf("Empleado: %s, ID: %d, Salario Base: %.2f, Salario Mensual: %.2f%n", nombre, id, salarioBase, calcularSalarioMensual());
    }
    // Método abstracto para calcular el salario mensual, que será implementado por las clases hijas
    @Override
    public abstract double calcularSalarioMensual();
}
