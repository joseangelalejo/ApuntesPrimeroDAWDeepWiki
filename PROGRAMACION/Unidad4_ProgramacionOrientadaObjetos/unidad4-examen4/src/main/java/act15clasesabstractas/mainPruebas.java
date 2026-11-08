package act15clasesabstractas;

public class mainPruebas {
    public static void main(String[] args) {
        System.out.println("--- PRUEBAS DE CLASES ABSTRACTAS (Mueble/SillaGiratoria) ---\n");

        // instancias de ejemplo
        SillaGiratoria s1 = new SillaGiratoria(120.0, "madera", false);
        SillaGiratoria s2 = new SillaGiratoria(150.0, "acero", true);

        System.out.println("Sillas creadas:");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println();

        System.out.println("Precios finales:");
        System.out.println("s1 -> " + s1.calcularPrecioFinal() + " €");
        System.out.println("s2 -> " + s2.calcularPrecioFinal() + " €");
        System.out.println();

        System.out.println("Transporte:");
        s1.transportar();
        s2.transportar();
    }
}
