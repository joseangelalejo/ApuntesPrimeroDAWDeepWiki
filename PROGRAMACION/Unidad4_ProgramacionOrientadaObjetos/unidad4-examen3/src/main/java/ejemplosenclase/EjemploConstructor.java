package ejemplosenclase;

public class EjemploConstructor {
    public static void main(String[] args) {
        // Crear un objeto de la clase Alumno utilizando el constructor
        Alumno alumno1 = new Alumno("Juan", 20, "Programación");
        
        // Imprimir los atributos del alumno
        System.out.println("Nombre: " + alumno1.nombre);
        System.out.println("Edad: " + alumno1.edad);
        System.out.println("Curso: " + alumno1.curso);
        
        /* De momento usamos los atributos de esta manera, pero no es lo ideal 
        por motivos de seguridad, lo ideal es usar métodos getters y setters 
        para acceder a los atributos de la clase, pero eso lo veremos más adelante 
        en la unidad.
        */
    }
}
