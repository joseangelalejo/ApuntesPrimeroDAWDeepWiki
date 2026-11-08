package practica;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        // Instancia de DatosCompra con datos de ejemplo
        DatosCompra compra = new DatosCompra("Morcilla L+", 8.0, 15);
        
        // Calcular descuento usando la cantidad de la instancia
        double descuento = CalculosCompra.calcularDescuento(compra.cantidad);
        
        // Calcular total usando precio y cantidad de la instancia
        double total = CalculosCompra.calculoTotal(compra.precio, compra.cantidad, descuento);
        
        // Imprimir resultados
        System.out.println("Producto: " + compra.producto);
        System.out.println("Descuento aplicado: " + descuento);
        System.out.println("Total a pagar: " + total);
    }
}