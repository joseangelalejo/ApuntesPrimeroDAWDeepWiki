package com.example.practica;

/**
 * EJERCICIO 12: Diagonal de una matriz
 * 
 * Dada una matriz cuadrada (mismo número de filas y columnas), suma los 
 * elementos de la diagonal principal.
 * 
 * Usa: bucles, condición i == j.
 * 
 * Enunciado: Lee una matriz 4x4 y suma los elementos donde fila == columna.
 */
public class E12_DiagonalMatriz {
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int sumaDiagonal = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    sumaDiagonal += matriz[i][j];
                }
            }
        }
        System.out.println("La suma de la diagonal principal es: " + sumaDiagonal);
    }
}
