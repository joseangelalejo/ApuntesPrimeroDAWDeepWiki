package act19gestionfutbol;

public abstract class Jugador implements Valorable {
    // ATRIBUTOS
    private String nombre;
    private int edad;
    private int numero;
    // CONSTRUCTOR
    public Jugador(String nombre, int edad, int numero) {
        this.nombre = nombre;
        this.edad = edad;
        this.numero = numero;
    }
    // GETTERS para evitar warnings de “campo no usado”
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public int getNumero() { return numero; }
    // MÉTODOS SOLICITADOS
    // Método abstracto para rendimiento
    public abstract double calcularRendimiento();
    // Método no abstracto void para mostrar información del jugador
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + " - Edad: " + edad + " - Numero: " + numero);
    }
}
