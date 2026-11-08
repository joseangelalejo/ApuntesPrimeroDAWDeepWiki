import java.util.Scanner;
public class ArraysJAAlejo {
    public static void main(String[] args) {
        // Quiero almacenar el nombre de los alumnos para una cantidad N de alumnos.
        // N será indicado por el usuario/profesor.
        Scanner scanner1 = new Scanner(System.in);
        String nombres [];  // Declaramos el Array con el tipo de dato, el nombre de variable y [];

        System.out.println("Introduzca cuántos alumnos tiene en su clase");
        int nalumno = scanner1.nextInt();
        scanner1.nextLine();
        // En este caso para indicar la longitud del array le hemos asignado el entero introducido por el profesor.
        nombres = new String [nalumno];
        // El índice de los arrays siempre comenzará en 0.
        for (int i = 0; i<nalumno; i++) {
            System.out.println("Introduzca el nombre del alumno: " + (i+1));
            nombres[i] = scanner1.nextLine();
        }
        System.out.println("Los nombres de sus alumnos son:");
        for (int i = 0; i<nalumno; i++) {
            System.out.println("El nombre del alumno " + (i+1) + " es " + nombres[i]);
        }
        System.out.println("Ha registrado " + nombres.length + " alumnos");
        scanner1.close();
    }
}
