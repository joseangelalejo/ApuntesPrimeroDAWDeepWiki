package practica5;

public class CalculosSalario {
    // Método para calcular salario base: devolver horas * tarifa
    public double calcularSalarioBase(double horas, double tarifa) {
        return horas * tarifa;
    }

    // Método para calcular bono horas extra: devolver bono por horas extra (ej. horas extra * tarifa * 1.5)
    public double calcularBonoHorasExtra(double horas, double tarifa) {
        if (horas > 40) {
            return ((horas-40) * tarifa * 1.5);
        }
        return 0.0;
    }

    // Método para calcular salario total: devolver base + bono
    public double calcularSalarioTotal(double base, double bono) {
        return base + bono;
    }

    // Método para obtener iniciales: devolver las iniciales del nombre (ej. "Juan Pérez" -> "J.P.")
    public String obtenerIniciales(String nombre) {
        String[] partes = nombre.split(" ");
        String iniciales = "";
        if (partes.length == 2) {
            iniciales = partes[0].charAt(0) + "." + partes[1].charAt(0) + ".";
            return iniciales.toUpperCase();
        } else if (partes.length > 2) {
            for (int i = 0; i < partes.length; i++) {
                iniciales += partes[i].charAt(0) + ".";
            }
            return iniciales.toUpperCase();
        } else if (partes.length == 1) {
            return (String.valueOf(partes[0].charAt(0)) + ".").toUpperCase(); 
        }
        return iniciales;
    }
}