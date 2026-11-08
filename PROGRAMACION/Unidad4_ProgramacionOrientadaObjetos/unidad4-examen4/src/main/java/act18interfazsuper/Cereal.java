package act18interfazsuper;

import java.time.LocalDate;

public class Cereal implements ProductoSupermercado, EsAlimento {
    // ATRIBUTOS COMUNES a cereales
    private final String marca;
    private double precio;
    private final LocalDate caducidad;
    // CONSTRUCTOR
    public Cereal(String marca, double precio, LocalDate caducidad) {
        this.marca = marca;
        this.precio = precio;
        this.caducidad = caducidad;
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
    public String toString() {
        return "Cereal{marca='" + marca + "', precio=" + precio + ", caducidad=" + caducidad + "}";
    }
}
