package pract3Interfaces;

public class Coche extends Vehiculos {
    // ATRIBUTO
    private int puertas;
    // CONSTRUCTOR
    public Coche (String marca, String modelo, int anio, int puertas) {
        super(marca, modelo, anio);
        this.puertas = puertas;
    }
    // Overridade descripción para añadir información
    @Override
    public String descripcion() {
        return super.descripcion() + " - Puertas: " + puertas;
    }
}
