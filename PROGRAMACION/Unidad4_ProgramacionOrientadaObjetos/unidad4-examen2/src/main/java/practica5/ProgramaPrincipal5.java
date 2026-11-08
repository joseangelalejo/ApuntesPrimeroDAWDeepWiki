package practica5;

public class ProgramaPrincipal5 {
    public static void main(String[] args) {
        // 1. Crear una instancia de la clase DatosSalario
        DatosSalario datos1 = new DatosSalario();
        // 2. Asignar valores a los campos horasTrabajadas, tarifaHora y nombreEmpleado de la instancia (por ejemplo, 45.0, 10.0, "Juan Pérez")
        datos1.horasTrabajadas = 120.0;
        datos1.tarifaHora = 3.0;
        datos1.nombreEmpleado = "Pepito Perez Periz";
        // 3. Crear una instancia de la clase CalculosSalario
        CalculosSalario calc1 = new CalculosSalario();
        // 4. Llamar al método calcularSalarioBase pasando horas y tarifa de DatosSalario e imprimir el resultado
        double salariobase = calc1.calcularSalarioBase(datos1.horasTrabajadas, datos1.tarifaHora);
        System.out.println("\nEl salario base es: " + salariobase);
        // 5. Llamar al método calcularBonoHorasExtra pasando horas y tarifa de DatosSalario e imprimir el resultado
        double bono = calc1.calcularBonoHorasExtra(datos1.horasTrabajadas, datos1.tarifaHora);
        System.out.println("El bono por " + (datos1.horasTrabajadas-40) + " horas extras es: " + bono);
        // 6. Llamar al método calcularSalarioTotal pasando base y bono calculados e imprimir el resultado
        System.out.println("El salario total de " + datos1.nombreEmpleado + " es " + calc1.calcularSalarioTotal(salariobase, bono));
        // 7. Llamar al método obtenerIniciales pasando el nombre de DatosSalario e imprimir el resultado
        System.out.println(calc1.obtenerIniciales(datos1.nombreEmpleado));
    }
}