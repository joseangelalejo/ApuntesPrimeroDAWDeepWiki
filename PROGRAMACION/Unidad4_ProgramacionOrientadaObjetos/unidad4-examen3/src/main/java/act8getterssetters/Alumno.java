package act8getterssetters;

import java.util.Arrays;

public class Alumno {

    private String nombre;
    private double[] notas;

    // Constructor solo con nombre (10 notas a 0)
    public Alumno(String nombre) {
        this(nombre, new double[10]);
    }

    // Constructor principal
    public Alumno(String nombre, double[] notas) {
        this.nombre = (nombre == null || nombre.isEmpty()) ? "Sin nombre" : nombre;
        this.notas = (notas == null || notas.length != 10) ? new double[10] : Arrays.copyOf(notas, 10);
    }

    public boolean aprobado() {
        double suma = 0;

        for (double nota : notas) {
            suma += nota;
        }

        double media = suma / notas.length;
        return media >= 5;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = (nombre == null || nombre.isEmpty()) ? this.nombre : nombre;
    }

    public double[] getNotas() {
        return Arrays.copyOf(notas, notas.length);
    }

    public void setNotas(double[] notas) {
        if (notas == null || notas.length != 10) {
            return;
        }
        this.notas = Arrays.copyOf(notas, 10);
    }
}
