package com.example.practica;

/**
 * EJERCICIO 8: Estadísticas del array
 * 
 * Calcula la suma, promedio, máximo y mínimo de un array de números flotantes.
 * 
 * Usa: bucles, operadores aritméticos, condicionales.
 * 
 * Enunciado: Lee un array de notas y calcula suma, promedio, nota máxima y mínima.
 */
import java.util.Scanner;
public class E8_EstadisticasArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definir el tamaño del array
        System.out.print("Ingrese el número de notas: ");
        int n = scanner.nextInt();
        // Crear el array para almacenar las notas
        float[] notas = new float[n];
        // Leer las notas del usuario
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + ": ");
            notas[i] = scanner.nextFloat();
        }
        // Inicializar variables para cálculos
        float suma = 0;
        float maximo = notas[0];
        float minimo = notas[0];
        // Calcular suma, máximo y mínimo
        for (float nota : notas) {
            suma += nota;
            if (nota > maximo) {
                maximo = nota;
            }
            if (nota < minimo) {
                minimo = nota;
            }
        }
        // Calcular promedio
        float promedio = suma / n;
        // Mostrar resultados
        System.out.println("Suma de las notas: " + suma + "\nPromedio de las notas: " + promedio + "\nNota máxima: " + maximo + "\nNota mínima: " + minimo);
        scanner.close();
    }
}
