package act3LecEscritura1;

import java.io.*;
import java.util.Arrays;

public class GestorAlumnos {
    // ATRIBUTOS
    private static final String ARCHIVO = "alumnos.txt";
    private alumno[] alumnos;
    private int totalAlumnos;

    public GestorAlumnos() {
        this.alumnos = new alumno[10];
        this.totalAlumnos = 0;
        cargarAlumnos();
        if (totalAlumnos > 0) {
            System.out.println("Alumnos cargados desde el archivo:");
            mostrarAlumnos();
        } else {
            System.out.println("No hay alumnos cargados desde el archivo.");
        }
    }

    private void asegurarCapacidad() {
        if (totalAlumnos >= alumnos.length) {
            alumnos = Arrays.copyOf(alumnos, alumnos.length * 2);
        }
    }
    // Método para cargar alumnos desde el archivo
    private void cargarAlumnos() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] partes = linea.split(";");
                if (partes.length != 3) {
                    continue;
                }
                String nombre = partes[0].trim();
                int edad;
                try {
                    edad = Integer.parseInt(partes[1].trim());
                } catch (NumberFormatException e) {
                    continue;
                }
                String curso = partes[2].trim();
                agregarAlumnoArray(new alumno(nombre, edad, curso));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    // Método para registrar alumnos
    public boolean registrarAlumno(String nombre, int edad, String curso) {
        if (nombre == null || nombre.isEmpty() || curso == null || curso.isEmpty()) {
            return false;
        }
        if (edad < 0) {
            return false;
        }

        alumno nuevoAlumno = new alumno(nombre, edad, curso);
        agregarAlumnoArray(nuevoAlumno);
        return guardarAlumnos();
    }
    // Método para agregar alumnos al array
    private void agregarAlumnoArray(alumno alumno) {
        asegurarCapacidad();
        alumnos[totalAlumnos++] = alumno;
    }
    // Método para guardar alumnos en el archivo
    private boolean guardarAlumnos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (int i = 0; i < totalAlumnos; i++) {
                bw.write(alumnos[i].toString());
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
            return false;
        }
    }
    // Método para mostrar alumnos
    public void mostrarAlumnos() {
        if (totalAlumnos == 0) {
            System.out.println("No hay alumnos registrados.");
            return;
        }

        for (int i = 0; i < totalAlumnos; i++) {
            alumno actual = alumnos[i];
            System.out.println(actual.getNombre() + " - " + actual.getEdad() + " años - " + actual.getCurso());
        }
    }
}
