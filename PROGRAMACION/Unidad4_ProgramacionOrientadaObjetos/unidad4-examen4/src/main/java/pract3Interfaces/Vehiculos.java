package pract3Interfaces;

public class Vehiculos {
    // ATRIBUTOS
    private String marca;
    private String modelo;
    private int anio;
    // CONSTRUCTOR PRINCIPAL
    public Vehiculos (String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }
    // MÉTODO para devolver marca, modelo y año
    public String descripcion() {
        return marca + modelo + " ( " + anio + " )";
    }
}
