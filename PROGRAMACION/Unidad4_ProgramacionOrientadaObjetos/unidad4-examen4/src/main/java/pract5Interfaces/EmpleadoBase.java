package pract5Interfaces;

public abstract class EmpleadoBase implements Empleado{
    // ATRIBUTOS
    String nombre;
    int id;
    double salarioBase;     // Suponemos que el salario base es diario
    // CONSTRUCTOR PRINCIPAL
    public EmpleadoBase(String nombre, int id, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
    }
    @Override
    public void mostrarDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
    }
    // MÉTODOS SOLICITADOS
    public void mostrarDetalles(String nombre, int id, double salarioBase) {
        System.out.println("Detalles del Empleado:" + "\n   Nombre: " + nombre + "\n     ID: " + id + "\n    Salario base: " + salarioBase);
    }
    // MÉTODO ABSTRACTO para implementación en subclases
    double calcularSalarioMensual(double salarioBase, int dias) {
        return salarioBase * dias;
    }
    void imprimirRecibo() {
        mostrarDetalles();
    System.out.println("Salario mensual: " + calcularSalarioMensual());
    }
}
