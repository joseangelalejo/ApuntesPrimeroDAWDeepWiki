package ejemplosenclase;

public class Alumno {
    // Atributos
    String nombre;
    int edad;
    String curso;
    
    // Constructor, tendrá el mismo nombre que la clase, no tiene tipo de retorno, ni siquiera void y se ejecuta automáticamente al crear un objeto de la clase
    public Alumno(String nombre, int edad, String curso) {
    this.nombre = nombre;
    this.edad = edad;
    this.curso = curso;
    }
}
