package act18interfazsuper;

import java.time.LocalDate;

public class Leche implements ProductoSupermercado, EsAlimento, Esliquido {
    // ATRIBUTOS COMUNES a leches
    private final String marca;
    private double precio;
    private final LocalDate caducidad;
    private final double volumen; // en litros
    private final String tipoEnvase;
    // CONSTRUCTOR
    public Leche(String marca, double precio, LocalDate caducidad, double volumen, String tipoEnvase) {
        this.marca = marca;
        this.precio = precio;
        this.caducidad = caducidad;
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
    public LocalDate getCaducidad() {
        return caducidad;
    }

    @Override
    public boolean esCaducado() {
        return LocalDate.now().isAfter(caducidad);
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
        return "Leche{marca='" + marca + "', precio=" + precio + ", caducidad=" + caducidad + ", volumen=" + volumen + "L, envase='" + tipoEnvase + "'}";
    }
}
