package act19gestionfutbol;

public class Portero extends Jugador {
    // ATRIBUTOS
    private int paradas;
    // CONSTRUCTOR
    public Portero (String nombre, int edad, int numero, int paradas) {
        super(nombre, edad, numero);
        this.paradas = paradas;
    }
    // GETTERS Y SETTERS
    public int getParadas() { return paradas; }
    public void setParadas(int paradas) { this.paradas = paradas; }
    // MÉTODOS SOLICITADOS
    @Override
    public double calcularValor() {
        // Según criterio (p. ej. valor monetario basado en paradas)
        return paradas * 100;
    }
    // Método para rendimiento
    @Override
    public  double calcularRendimiento() {
        return paradas * 1.2;
    }
    // Método para nivel
    @Override
    public String nivelJugador() {
        if (paradas > 10) return "Estrella";
        if (paradas < 4) return "Suplente";
        return "Titular";
    }
    // Método no abstracto void para mostrar información del jugador
    public void mostrarDatos() {
        System.out.println("Nombre: " + getNombre() + " - Edad: " + getEdad() + " - Numero: " + getNumero() + "paradas: " + paradas);
    }
}
