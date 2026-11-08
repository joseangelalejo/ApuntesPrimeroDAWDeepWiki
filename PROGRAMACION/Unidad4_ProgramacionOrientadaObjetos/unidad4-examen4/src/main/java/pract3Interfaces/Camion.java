package pract3Interfaces;

public class Camion extends Vehiculos {
    // ATRIBUTOS
    private double cargaMaxima;
    // CONSTRUCTOR
    public Camion (String marca, String modelo, int anio, double cargaMaxima) {
        super(marca, modelo, anio);
        this.cargaMaxima = cargaMaxima;
    }
    // Override de descripción
    @Override
    public String descripcion() {
        return super.descripcion() + " - Carga máxima: " + cargaMaxima + " kg";
    }
}
