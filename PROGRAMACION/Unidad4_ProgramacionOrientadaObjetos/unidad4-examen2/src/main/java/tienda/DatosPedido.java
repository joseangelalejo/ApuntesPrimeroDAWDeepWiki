package tienda;

public class DatosPedido {

    public static double importeBruto(double precioUnitario, int cantidad) {
        return precioUnitario * cantidad;
    }

    public static boolean pedidoValido(int cantidad) {
        return cantidad > 0 && cantidad <= 100;
    }

    public static String tipoPedido(int cantidad) {
        if (cantidad < 10) {
            return "PEQUEÑO";
        } else if (cantidad <= 50) {
            return "MEDIANO";
        } else {
            return "GRANDE";
        }
    }
}