package pract5Interfaces;

public class Gerente extends EmpleadoBase{
    // ATRIBUTOS
    double bonoAnual;
    // CONSTRUCTOR
    public Gerente(String nombre, int id, double salarioBase, double bonoAnual) {
        super(nombre, id, salarioBase);
        this.bonoAnual = bonoAnual;
    }
    // MÉTODOS
    @Override
    public double calcularSalarioMensual() {
        return salarioBase + bonoAnual;
    }
    @Override
    public void imprimirRecibo() {
        super.imprimirRecibo();
    System.out.println("Bono anual: " + bonoAnual);
    }
}
