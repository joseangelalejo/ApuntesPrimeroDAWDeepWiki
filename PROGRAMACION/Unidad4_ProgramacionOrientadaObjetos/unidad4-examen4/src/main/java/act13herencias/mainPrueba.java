package act13herencias;

public class mainPrueba {
    public static void main(String[] args) {
        // Electrodoméstico genérico
        Electrodomestico e1 = new Electrodomestico(
                Electrodomestico.TipoElectrodomestico.MICROONDAS,
                "Samsung", 0.8);
        System.out.println("\n" + e1);
        System.out.println("\nConsumo 3h: " + e1.getConsumo(3) + " kW");
        System.out.println("Coste 3h a 0,15 €/kWh: " +
                e1.getCosteConsumo(3, 0.15) + " €");
        System.out.println();

        // LAVADORAS
        Lavadora l1 = new Lavadora("LG", 400, 1.2);              // agua fría
        Lavadora l2 = new Lavadora("Bosch", 550, 1.0, true);     // agua caliente

        System.out.println(l1);
        System.out.println("Consumo 5h: " + l1.getConsumo(5) + " kW");
        System.out.println("Coste 5h a 0,15 €/kWh: " +
                l1.getCosteConsumo(5, 0.15) + " €");
        System.out.println();

        System.out.println(l2);
        System.out.println("Consumo 5h: " + l2.getConsumo(5) + " kW");
        System.out.println("Coste 5h a 0,15 €/kWh: " +
                l2.getCosteConsumo(5, 0.15) + " €");
    }
}