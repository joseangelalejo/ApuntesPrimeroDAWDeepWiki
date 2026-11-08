package com.example.practica;

/**
 * EJERCICIO 16: Suma por columnas
 * 
 * Calcula la suma de cada columna en una matriz 4x3 e imprime los resultados.
 * 
 * Usa: bucles anidados, operaciones aritméticas.
 * 
 * Enunciado: Define una matriz de números y muestra el total de cada columna.
 */
public class E16_SumaColumnas {
    public static void main(String[] args) {
        // Definir la matriz 4x3
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12}
        };
        // Array para almacenar la suma de cada columna
        int[] sumaColumnas = new int[matriz[0].length];
        // Calcular la suma de cada columna
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sumaColumnas[j] += matriz[i][j];
            }
        }
        // Imprimir los resultados
        for (int j = 0; j < sumaColumnas.length; j++) {
            System.out.println("Suma de la columna " + (j + 1) + ": " + sumaColumnas[j]);
        }
    }
}
