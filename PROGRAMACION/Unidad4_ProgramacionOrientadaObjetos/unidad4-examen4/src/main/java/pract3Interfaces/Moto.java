package pract3Interfaces;

public class Moto extends Vehiculos {
    // ATRIBUTOS
    private boolean sidecar;
    // CONSTRUCTOR
    public Moto (String marca, String modelo, int anio, boolean sidecar) {
        super(marca, modelo, anio);
        this.sidecar = sidecar;
    }
    // Override de descripcion
    public String descripcion() {
        return super.descripcion() + " - Sidecar: " + ((sidecar) ? "Si" : "No");
    }
}
