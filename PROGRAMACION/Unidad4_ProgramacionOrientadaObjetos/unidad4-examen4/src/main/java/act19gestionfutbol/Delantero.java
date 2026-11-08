package act19gestionfutbol;

public class Delantero extends Jugador{
    // ATRIBUTOS
    private int goles;
    // CONSTRUCTOR
    public Delantero (String nombre, int edad, int numero, int goles) {
        super(nombre, edad, numero);
        this.goles = goles;
    }
    // GETTERS Y SETTERS
    public int getGoles() { return goles; }
    public void setGoles(int goles) { this.goles = goles; }

    // MÉTODOS SOLICITADOS
    @Override
    public double calcularValor() {
        // Según criterio (p. ej. valor monetario basado en goles)
        return goles * 100;
    }
    // Método para rendimiento
    @Override
    public  double calcularRendimiento() {
        return goles * 1.2;
    }
    // Método para nivel
    @Override
    public String nivelJugador() {
        if (goles > 10) return "Estrella";
        if (goles < 4) return "Suplente";
        return "Titular";
    }
    // Método no abstracto void para mostrar información del jugador
    public void mostrarDatos() {
        System.out.println("Nombre: " + getNombre() + " - Edad: " + getEdad() + " - Numero: " + getNumero() + "Goles: " + goles);
    }
}
