package calculos;

public class CalculosPedido {

    public static boolean esPedidoGrande(int cantidad) {
        return cantidad > 50;
    }

    public static double calcularDescuento(double importeBruto, int cantidad) {
        if (esPedidoGrande(cantidad)) {
            return importeBruto * 0.10;
        } else {
            return 0.0;
        }
    }

    public static double importeFinal(double importeBruto, double descuento) {
        return importeBruto - descuento;
    }
}