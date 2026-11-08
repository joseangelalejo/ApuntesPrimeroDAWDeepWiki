package act7Constructores;

public class Alumno {
    // ATRIBUTOS
    public String nombre;
    public int edad;
    public static int totalAlumnos; // Estático para contar el total de alumnos creados
    public int idAlumno;

    // CONSTRUCTORES
    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        totalAlumnos++;
        this.idAlumno = totalAlumnos;   // Para asignar id único
    }
    // Método para mostrar el alumno actual
    public void mostrarAlumno() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", ID: " + idAlumno);
    }
    // Método para mostrar el total de alumnos
    public static void totalAlumnos() {    // Convertir en estático? Quiero mostrar datos de la clase o del objeto?
        System.out.println("El total de alumnos es: " + totalAlumnos);
    }
}
