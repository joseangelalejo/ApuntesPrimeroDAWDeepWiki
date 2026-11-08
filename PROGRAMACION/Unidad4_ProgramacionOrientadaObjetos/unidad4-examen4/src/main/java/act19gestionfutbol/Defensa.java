package act19gestionfutbol;

public class Defensa extends Jugador {
    // ATRIBUTOS
    private int robos;
    // CONSTRUCTOR
    public Defensa (String nombre, int edad, int numero, int robos) {
        super(nombre, edad, numero);
        this.robos = robos;
    }
    // GETTERS Y SETTERS
    public int getRobos() { return robos; }
    public void setRobos(int robos) { this.robos = robos; }
    // MÉTODOS SOLICITADOS
    @Override
    public double calcularValor() {
        // Según criterio (p. ej. valor monetario basado en robos)
        return robos * 100;
    }
    // Método para rendimiento
    @Override
    public  double calcularRendimiento() {
        return robos * 1.2;
    }
    // Método para nivel
    @Override
    public String nivelJugador() {
        if (robos > 10) return "Estrella";
        if (robos < 4) return "Suplente";
        return "Titular";
    }
    // Método no abstracto void para mostrar información del jugador
    public void mostrarDatos() {
        System.out.println("Nombre: " + getNombre() + " - Edad: " + getEdad() + " - Numero: " + getNumero() + "robos: " + robos);
    }
}
