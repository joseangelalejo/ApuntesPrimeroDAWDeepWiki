package clase5herencia;

public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected String matricula;
    protected double velocidad;      // se usa desde Coche

    public Vehiculo(String marca, String modelo, String matricula) {
        this(marca, modelo, matricula, 0);   // constructor por defecto
    }

    public Vehiculo(String marca, String modelo, String matricula, double velocidadInicial) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = velocidadInicial;
    }

    public double getVelocidad() {          // ejemplo de uso
        return velocidad;
    }

    public void setVelocidad(double v) {
        velocidad = v;
    }
    // Sobreescritura de método toString
    public String toString() {
        return marca + " " + modelo + " (" + matricula + ") - Velocidad: " + velocidad + " km/h";
    }
}