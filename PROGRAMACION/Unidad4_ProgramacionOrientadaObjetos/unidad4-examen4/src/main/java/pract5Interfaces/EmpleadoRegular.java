package pract5Interfaces;

public class EmpleadoRegular extends EmpleadoBase{
    public EmpleadoRegular(String nombre, int id, double salarioBase) {
        super(nombre, id, salarioBase);
    }

    @Override
    public double calcularSalarioMensual() {
        return salarioBase;
    }

}