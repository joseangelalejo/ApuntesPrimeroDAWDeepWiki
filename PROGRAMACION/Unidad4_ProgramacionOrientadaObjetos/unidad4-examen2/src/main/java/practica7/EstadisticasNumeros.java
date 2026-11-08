package practica7;

public class EstadisticasNumeros {
    // Método para calcular promedio: devolver (n1 + n2 + n3) / 3
    public double calcularPromedio(double numero1, double numero2, double numero3) {
        return (numero1+numero2+numero3)/3;
    }
    // Método para encontrar máximo: devolver el mayor de los tres números
    public double encontrarMaximo(double numero1, double numero2, double numero3) {
        return Math.max(Math.max(numero2, numero3), numero3);
    }
    // Método para encontrar mínimo: devolver el menor de los tres números
    public double encontrarMinimo(double numero1, double numero2, double numero3) {
        return Math.min(Math.min(numero1, numero2), numero3);
    }
    // Método para calcular suma: devolver n1 + n2 + n3
    public double calcularSuma (double numero1, double numero2, double numero3) {
        return numero1+numero2+numero3;
    }

}