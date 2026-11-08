package act17abstractaseinterfaces;

public class Gerente extends EmpleadoBase {
    // ATRIBUTOS
    private double bonoAnual;
    // CONSTRUCTOR PRINCIPAL
    public Gerente(String nombre, int id, double salarioBase, double bonoAnual) {
        super(nombre, id, salarioBase);
        this.bonoAnual = bonoAnual;
    }
    // MÉTODOS SOLICITADOS
    @Override
    public double calcularSalarioMensual() {
        return salarioBase + bonoAnual/12;
    }
    // Mostrar detalles
    @Override
    public void mostrarDetalles() {
        System.out.printf("Gerente: %s, ID: %d, Salario Base: %.2f, Bono Anual: %.2f, Salario Mensual: %.2f%n", nombre, id, salarioBase, bonoAnual, calcularSalarioMensual());
    }
}
