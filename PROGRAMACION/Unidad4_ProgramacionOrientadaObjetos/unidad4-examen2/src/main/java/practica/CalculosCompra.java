package practica;

public class CalculosCompra {
    // Método para el porcentaje de descuento según la cantidad comprada
    public static double calcularDescuento(int cantidad) {
        if (cantidad >= 5) {
            return 0.1; // 10% de descuento
        } else {
            return 0.0; // Sin descuento
        }
    }
    public static double calculoTotal (double precioUnitario, int cantidad, double descuento) {
        return precioUnitario * cantidad * (1 - descuento);
    }
}