package contenedorClases;

public class Equipo {
    // Atributos
    public String nombre;
    public Jugador[] jugadores = new Jugador[20]; // Dentro del array jugadores habrá objetos de la clase "Jugador"
    // Constructor
    public Equipo (String nombre) {
        this.nombre = nombre;
        /* En caso de no hacer la declaración del array en los atributos, 
        siendo que todos tendrán 20, podemos hacerla aquí en el constructor
        Pero o lo declaramos en los atributos o lo declaramos en el constructor
        */
        // jugadores = new Jugador[20];
    }
    // Método para fichar jugadores
    public boolean fichar(Jugador jugador) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i]==null) {
                jugadores[i] = jugador; // Almacena la instancia del objeto, con sus métodos, atributos, etc
                return true;
            }
        }
        return false;
    }
    // Método para sacar jugadores, "desficharlos", despedirlos, cesarlos
    public boolean despedir (Jugador jugador) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugador.equals(jugadores[i])) {
                jugadores[i] = null;
                return true;
            }
        }
        return false;
    }
}
