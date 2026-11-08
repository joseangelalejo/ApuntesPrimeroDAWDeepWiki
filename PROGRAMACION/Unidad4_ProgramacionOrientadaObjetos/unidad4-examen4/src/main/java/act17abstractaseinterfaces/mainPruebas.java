package act17abstractaseinterfaces;

public class mainPruebas {
    public static void main(String[] args) {
        System.out.println();
        EmpleadoRegular emp1 = new EmpleadoRegular("Juan Pérez", 101, 3000.00);
        Gerente gerente1 = new Gerente("María Gómez", 102, 5000.00, 2000.00);

        System.out.println("Detalles del Empleado Regular:");
        emp1.mostrarDetalles();
        System.out.println("Calculo del salario Mensual: " + emp1.calcularSalarioMensual());

        System.out.println("\nDetalles del Gerente:");
        gerente1.mostrarDetalles();
        System.out.println("Calculo del salario Mensual: " + gerente1.calcularSalarioMensual());
    }   
}
