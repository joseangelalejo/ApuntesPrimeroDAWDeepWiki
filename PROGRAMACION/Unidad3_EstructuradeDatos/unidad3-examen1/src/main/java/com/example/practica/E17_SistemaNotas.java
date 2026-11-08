package com.example.practica;

/**
 * EJERCICIO 17: Sistema de notas de estudiantes
 * 
 * Crea una matriz donde cada fila represente un estudiante y cada columna una asignatura. 
 * Calcula:
 *   - Promedio general de cada estudiante.
 *   - Promedio de cada asignatura.
 *   - La mejor calificación del grupo.
 *   - Cuántos estudiantes aprobaron (nota >= 7).
 * 
 * Usa: bucles anidados, operaciones aritméticas, condicionales.
 * 
 * Enunciado: Realiza todos los cálculos anteriores y muestra los resultados.
 */
public class E17_SistemaNotas {
    public static void main(String[] args) {
        // Definir la matriz de notas (5 estudiantes, 4 asignaturas)
        double[][] notas = {
            {8.5, 7.0, 9.0, 6.5},
            {5.0, 6.0, 7.5, 8.0},
            {9.0, 8.5, 10.0, 9.5},
            {4.0, 5.5, 6.0, 7.0},
            {7.5, 8.0, 7.0, 6.5}
        };
        int numEstudiantes = notas.length;
        int numAsignaturas = notas[0].length;
        // Calcular el promedio general de cada estudiante
        System.out.println("Promedio general de cada estudiante:");
        for (int i = 0; i < numEstudiantes; i++) {
            double suma = 0;
            for (int j = 0; j < numAsignaturas; j++) {
                suma += notas[i][j];
            }
            double promedioEstudiante = suma / numAsignaturas;
            System.out.printf("Estudiante %d: %.2f%n", i + 1, promedioEstudiante);
        }
        // Calcular el promedio de cada asignatura
        System.out.println("\nPromedio de cada asignatura:");
        for (int j = 0; j < numAsignaturas; j++) {
            double suma = 0;
            for (int i = 0; i < numEstudiantes; i++) {
                suma += notas[i][j];
            }
            double promedioAsignatura = suma / numEstudiantes;
            System.out.printf("Asignatura %d: %.2f%n", j + 1, promedioAsignatura);
        }
        // Encontrar la mejor calificación del grupo
        double mejorCalificacion = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < numEstudiantes; i++) {
            for (int j = 0; j < numAsignaturas; j++) {
                if (notas[i][j] > mejorCalificacion) {
                    mejorCalificacion = notas[i][j];
                }
            }
        }
        System.out.printf("\nLa mejor calificación del grupo es: %.2f%n", mejorCalificacion);
        // Contar cuántos estudiantes aprobaron (nota >= 7)
        int estudiantesAprobados = 0;
        for (int i = 0; i < numEstudiantes; i++) {
            double suma = 0;
            for (int j = 0; j < numAsignaturas; j++) {
                suma += notas[i][j];
            }
            double promedioEstudiante = suma / numAsignaturas;
            if (promedioEstudiante >= 7) {
                estudiantesAprobados++;
            }
        }
        System.out.println("\nNúmero de estudiantes aprobados: " + estudiantesAprobados);
    }
}
