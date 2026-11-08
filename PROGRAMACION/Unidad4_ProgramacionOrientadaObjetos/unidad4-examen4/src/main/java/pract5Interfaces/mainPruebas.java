package pract5Interfaces;

import java.util.List;
import java.util.ArrayList;

public class mainPruebas {
    public static void main(String[] args) {
        // Instancias de Empleado Regular
        EmpleadoRegular eR1 = new EmpleadoRegular("Pepito Perez", 129010, 80);
        EmpleadoRegular eR2 = new EmpleadoRegular("Juanito Juarez", 894501, 80);
        // Instancias de Gerente
        Gerente g1 = new Gerente("Manuel Monzon", 163490, 90, 120);
        Gerente g2 = new Gerente("Alberto Alferez", 679310, 90, 120);
        // LISTA
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(eR1);
        empleados.add(g1);
        empleados.add(eR2);
        empleados.add(g2);
        System.out.println();
        for (Empleado emp : empleados) {
            emp.mostrarDetalles();
            System.out.println("Salario mensual: " + emp.calcularSalarioMensual());
            System.out.println("---");
        }
    }
}
