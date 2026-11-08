package act10clases3;

public class Entrenador {
    // ATRIBUTOS
    private String nombre;
    private int edad;
    private String equipo;

    // CONSTRUCTOR
    public Entrenador(String nombre, int edad, String equipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.equipo = equipo;
    }
    // Getters
    public String getNombre() {return nombre;}
    public int getEdad() {return edad;}
    public String getEquipo() {return equipo;}
    // SETTER para relación jugador-entrenador
    private Jugador jugador;

    public void setJugador(Jugador j) { jugador = j; }
    public Jugador getJugador() { return jugador; }
    // Método para mostrar la información relevante del entrenador
    public void mostrarInfo() {
        System.out.println("Entrenador: " + ((nombre.isEmpty()) ? "Nombre no definido" : nombre));
        System.out.println("Edad: " + ((edad <= 0) ? "Edad no definida" : edad));
        System.out.println("Equipo: " + ((equipo.isEmpty()) ? "Equipo no definido" : equipo));
    }
}
