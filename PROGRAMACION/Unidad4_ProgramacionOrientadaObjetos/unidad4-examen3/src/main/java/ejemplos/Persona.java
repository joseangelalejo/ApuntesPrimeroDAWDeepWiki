package ejemplos;

public class Persona {

    private String nombre;
    private int edad;
    private String ciudad;

    // Constructor por defecto
    public Persona() {
        this.nombre = "Desconocido";
        this.edad = 0;
        this.ciudad = "Desconocida";
    }

    // Constructor con nombre
    public Persona(String nombre) {
        this.nombre = nombre;
        this.edad = 0;
        this.ciudad = "Desconocida";
    }

    // Constructor con nombre y edad
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = "Desconocida";
    }

    // Constructor completo
    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    // Método toString para mostrar la información
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}