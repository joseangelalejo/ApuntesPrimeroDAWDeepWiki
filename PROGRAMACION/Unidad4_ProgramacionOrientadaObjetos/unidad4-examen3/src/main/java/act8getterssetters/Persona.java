package act8getterssetters;

public class Persona {

    private String nombre;
    private int edad;

    // Constructor solo con nombre
    public Persona(String nombre) {
        this(nombre, 0);
    }

    // Constructor principal
    public Persona(String nombre, int edad) {
        this.nombre = (nombre == null || nombre.isEmpty()) ? "Sin nombre" : nombre;
        this.edad = (edad < 0) ? 0 : edad;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = (nombre == null || nombre.isEmpty()) ? this.nombre : nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = (edad < 0) ? 0 : edad;
    }
}
