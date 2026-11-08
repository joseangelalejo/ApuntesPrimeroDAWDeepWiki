package act17abstractaseinterfaces;

public class EmpleadoRegular extends EmpleadoBase {
    // ATRIBUTOS
    // CONSTRUCTOR PRINCIPAL
    public EmpleadoRegular(String nombre, int id, double salarioBase) {
        super(nombre, id, salarioBase);
    }
    // MÉTODOS SOLICITADOS
    @Override
    public double calcularSalarioMensual() { return salarioBase; }
}