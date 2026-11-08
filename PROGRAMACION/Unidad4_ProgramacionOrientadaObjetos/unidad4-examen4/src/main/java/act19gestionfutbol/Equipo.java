package act19gestionfutbol;

public class Equipo {
    // ATRIBUTOS
    private String nombre;
    private Jugador[] jugadores = new Jugador[11];

    // CONSTRUCTOR
    public Equipo(String nombre) {this.nombre = nombre;}
    // GETTERS Y SETTERS
    public String getNombre() { return nombre; }
    public Jugador[] getJugadores() { return jugadores; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    // MÉTODOS
    // MÉTODOS SOLICITADOS
    /*
     * Implementacion inicial
     * public void mostrarDatosEquipo() {
     * System.out.println("Equipo: " + nombre);
     * for (Jugador jugador : jugadores) {
     * if (jugador != null) {
     * jugador.mostrarDatos();
     * System.out.println("Valor: " + jugador.calcularValor());
     * System.out.println("Nivel: " + jugador.nivelJugador());
     * System.out.println("Rendimiento: " + jugador.calcularRendimiento());
     * System.out.println("-------------------");
     * }
     * }
     * }
     */
    // Mostrar datos sin detalles valor/nivel/rendimiento
    public void mostrarDatosEquipo() {
        System.out.println("Equipo: " + nombre);
        for (Jugador jugador : jugadores) {
            if (jugador != null) {
                jugador.mostrarDatos(); // solo muestra nombre/edad/número
            }
        }
    }

    // INFORME EQUIPO
    public String generarInformeEquipo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo: ").append(nombre).append("\n");

        for (int i = 0; i < jugadores.length; i++) {
            Jugador jugador = jugadores[i];
            if (jugador != null) {
                sb.append("Posición ").append(i + 1).append(": ");
                sb.append(jugador.getNombre()).append(" - Edad: ").append(jugador.getEdad())
                        .append(" - Número: ").append(jugador.getNumero()).append("\n");
                sb.append("  Valor: ").append(jugador.calcularValor()).append("\n");
                sb.append("  Nivel: ").append(jugador.nivelJugador()).append("\n");
                sb.append("  Rendimiento: ").append(jugador.calcularRendimiento()).append("\n");
                sb.append("-------------------\n");
            }
        }
        return sb.toString();
    }

    public double calcularRendimientoTotal() {
        double total = 0;
        for (Jugador jugador : jugadores) {
            if (jugador != null) {
                total += jugador.calcularRendimiento();
            }
        }
        return total;
    }

    // EXTRAS
    // Agregar jugador:
    /*
     * Implementación inicial:
     * public void agregarJugador(Jugador jugador, int posicion) {
     * if (posicion >= 0 && posicion < jugadores.length) {
     * jugadores[posicion] = jugador;
     * }
     * }
     */
    // Implementación mejorada para manejar posiciones ocupadas y buscar hueco libre
    public boolean agregarJugador(Jugador jugador, int posicionUnoBase) {
        // Variable indice 1‑11 a 0‑10 para usar en el array
        int indice = posicionUnoBase - 1;

        // 1 - Intentar la posición pedida (si es válida y está libre)
        if (indice >= 0 && indice < jugadores.length && jugadores[indice] == null) {
            jugadores[indice] = jugador;
            System.out.println("Jugador agregado en posición " + posicionUnoBase);
            return true;
        }
        // 2 - Si la posición estaba ocupada o era inválida, buscar el primer hueco
        // libre
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] == null) {
                jugadores[i] = jugador;
                System.out.println("Jugador agregado en posición " + (i + 1)); // mostrar 1‑based
                return true;
            }
        }
        // 3 - Si no hay huecos libres
        System.out.println("No se pudo agregar el jugador. No hay posiciones libres.");
        return false;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Jugador jugador : jugadores) {
            if (jugador != null) {
                total += jugador.calcularValor();
            }
        }
        return total;
    }
}
