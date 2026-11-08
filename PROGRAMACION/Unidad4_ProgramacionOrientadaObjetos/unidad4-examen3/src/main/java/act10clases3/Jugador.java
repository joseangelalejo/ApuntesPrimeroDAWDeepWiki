package act10clases3;

public class Jugador {
    // ATRIBUTOS
    private String nombre;
    private int edad;
    private String posicion;
    private int numeroCamiseta;
    private boolean lesionado;
    private int diasdelesion;
    private String equipo;
    private int goles;
    private int tarjetas[] = new int[2]; // tarjetas[0] para amarillas, tarjetas[1] para rojas

    // CONSTRUCTOR
    public Jugador(String nombre, int edad, String posicion, int numeroCamiseta, boolean lesionado, int diasdelesion, String equipo, int goles) {
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.numeroCamiseta = numeroCamiseta;
        this.lesionado = lesionado;
        this.diasdelesion = diasdelesion;
        this.equipo = equipo;
        this.goles = goles;
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getPosicion() { return posicion; }
    public int getNumeroCamiseta() { return numeroCamiseta; }
    public boolean isLesionado() { return lesionado; }
    public int getDiasdelesion() { return diasdelesion; }
    public String getEquipo() { return equipo; }
    public int getGoles() { return goles; }
    public int[] getTarjetas() { return tarjetas; }

    // Método para mostrar información relevante del Jugador
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Posición: " + posicion);
        System.out.println("Lesionado: " + ((lesionado) ? "SI" : "NO"));

    }
    // Método para
    public void jugarPartido() {
        if (lesionado) {
            System.out.println(nombre + " no puede jugar: está lesionado (" + diasdelesion + " días)");
            return;
        }
        if (tarjetas[1] > 0) {
            System.out.println(nombre + " no puede jugar: tiene tarjeta roja");
            return;
        }
        if (tarjetas[0] >= 2) {
            System.out.println(nombre + " no puede jugar: tiene dos amarillas");
            return;
        }
        System.out.println(nombre + " juega en el " + equipo + " como " + posicion);
    }

    public void informarLesion(int dias) {
        lesionado = true;
        diasdelesion = dias;
        System.out.println(nombre + " queda lesionado por " + dias + " días");
    }

    public void recibirAmarilla() {
        tarjetas[0]++;
    }

    public void recibirRoja() {
        tarjetas[1]++;
    }

    public void marcarGol() {
        goles++;
    }
}
