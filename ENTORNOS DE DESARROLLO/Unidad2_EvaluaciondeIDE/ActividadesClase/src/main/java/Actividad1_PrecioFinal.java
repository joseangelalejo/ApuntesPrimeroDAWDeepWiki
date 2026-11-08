public class Actividad1_PrecioFinal {
    public static void main(String[] args) {
        // === Cambia estos valores ===
        double precioBase = 120.0;
        double porcentajeDescuento = 50;  // en %
        double iva = 21.0;                  // en %

        // == Cálculos intermedios ===
        double descuento = precioBase * (porcentajeDescuento / 100.0);
        double precioConDescuento = precioBase - descuento;
        double importeIVA = precioConDescuento * (iva / 100.0);
        double total = precioConDescuento + importeIVA;

        // == Salida ==
        System.out.println("Precio base: " + precioBase);
        System.out.println("Descuento (" + porcentajeDescuento + "%): " + descuento);
        System.out.println("Precio con descuento:" + precioConDescuento);
        System.out.println("IVA (" + iva + "%): " + importeIVA);
        System.out.println("TOTAL: " + total);

    }
}
