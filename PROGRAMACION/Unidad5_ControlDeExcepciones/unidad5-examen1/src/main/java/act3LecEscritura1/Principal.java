package act3LecEscritura1;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorAlumnos gestor = new GestorAlumnos();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero(scanner);

            switch (opcion) {
                case 1 -> { registrarAlumno(scanner, gestor);}
                case 2 -> gestor.mostrarAlumnos();
                case 3 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }
    // Método para mostrar el menú de opciones
    private static void mostrarMenu() {
        System.out.println("\n==== GESTIÓN DE ALUMNOS ====");
        System.out.println("1. Registrar un nuevo alumno");
        System.out.println("2. Mostrar los alumnos almacenados");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }
    // Método para leer un número entero con manejo de excepciones
    private static int leerEntero(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    // Método para registrar un nuevo alumno
    private static void registrarAlumno(Scanner scanner, GestorAlumnos gestor) {
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Ingrese la edad del alumno: ");
        int edad;
        try {
            edad = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Edad inválida. Debe ser un número entero.");
            return;
        }

        System.out.print("Ingrese el curso del alumno: ");
        String curso = scanner.nextLine().trim();

        if (nombre.isEmpty() || curso.isEmpty()) {
            System.out.println("Nombre y curso no pueden estar vacíos.");
            return;
        }

        if (gestor.registrarAlumno(nombre, edad, curso)) {
            System.out.println("Alumno registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el alumno.");
        }
    }
}
