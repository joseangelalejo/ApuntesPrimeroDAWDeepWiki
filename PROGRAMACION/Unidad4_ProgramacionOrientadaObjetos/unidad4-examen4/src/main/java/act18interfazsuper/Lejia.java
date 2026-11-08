package act18interfazsuper;

public class Lejia implements ProductoSupermercado, Esliquido {
    // ATRIBUTOS COMUNES a lejías
    private final String marca;
    private double precio;
    private final double volumen; // en litros
    private final String tipoEnvase;
    // CONSTRUCTOR
    public Lejia(String marca, double precio, double volumen, String tipoEnvase) {
        this.marca = marca;
        this.precio = precio;
        this.volumen = volumen;
        this.tipoEnvase = tipoEnvase;
    }
    // OVERRIDES de ProductoSupermercado
    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        precio = precio * (1 - porcentaje / 100.0);
    }

    @Override
    public double getVolumen() {
        return volumen;
    }

    @Override
    public String getTipoEnvase() {
        return tipoEnvase;
    }

    @Override
    public String toString() {
        return "Lejia{marca='" + marca + "', precio=" + precio + ", volumen=" + volumen + "L, envase='" + tipoEnvase + "'}";
    }
}
