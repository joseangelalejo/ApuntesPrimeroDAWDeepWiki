package tienda;

import calculos.CalculosPedido;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        double precioUnitario = 10.0; // Valor fijo para el precio unitario
        int cantidad = 60; // Valor fijo para la cantidad

        double importeBruto = DatosPedido.importeBruto(precioUnitario, cantidad);
        String tipoPedido = DatosPedido.tipoPedido(cantidad);
        boolean pedidoValido = DatosPedido.pedidoValido(cantidad);
        double descuento = CalculosPedido.calcularDescuento(importeBruto, cantidad);
        double importeFinal = CalculosPedido.importeFinal(importeBruto, descuento);

        System.out.println("\nImporte bruto: " + importeBruto);
        System.out.println("Tipo de pedido: " + tipoPedido);
        System.out.println("Pedido válido: " + (pedidoValido ? "Sí" : "No"));
        System.out.println("Descuento aplicado: " + descuento);
        System.out.println("Importe final: " + importeFinal);
    }
}