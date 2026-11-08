package act18interfazsuper;
import java.time.LocalDate;

public class mainPruebas {
    public static void main(String[] args) {
        Lejia lejia1 = new Lejia("MarcaA", 3.50, 1.5, "Plástico");
        Cereal cereal1 = new Cereal("MarcaC", 2.99, LocalDate.of(2024, 12, 31));

        System.out.println(lejia1);
        System.out.println(cereal1);

        // Aplicar descuentos
        lejia1.aplicarDescuento(10); // 10% de descuento
        cereal1.aplicarDescuento(20); // 20% de descuento

        System.out.println("Después de aplicar descuentos:");
        System.out.println(lejia1);
        System.out.println(cereal1);

        // Verificar caducidad del cereal
        System.out.println(cereal1.esCaducado() ? "El cereal está caducado." : "El cereal no está caducado.");
    }
}
