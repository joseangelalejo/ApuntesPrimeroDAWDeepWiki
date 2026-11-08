package act8getterssetters;

public class MainAlumno {

    public static void main(String[] args) {

        double[] notas = { 6, 7, 5, 8, 4, 9, 6, 7, 5, 6 };

        Alumno alumno = new Alumno("Ana", notas);

        System.out.println("Nombre: " + alumno.getNombre());

        if (alumno.aprobado()) {
            System.out.println("Está aprobado.");
        } else {
            System.out.println("Está suspenso.");
        }
    }
}
