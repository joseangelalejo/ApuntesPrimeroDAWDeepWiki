package act3LecEscritura1;

public class alumno {
    // ATRIBUTOS
    private String nombre;
    private int edad;
    private String curso;

    // CONSTRUCTOR PRINCIPAL
    public alumno(String nombre, int edad, String curso) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }
    // GETTERS Y SETTERS
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }

    public void setEdad(int edad) { this.edad = edad; }

    public String getCurso() { return curso; }

    public void setCurso(String curso) { this.curso = curso; }

    // OVERRIDE TOSTRING
    @Override
    public String toString() {
        return nombre + "; " + edad + "; " + curso;
    }
}
