package com.example.practica;

/**
 * EJERCICIO 14: Comparar matrices con deepEquals()
 * 
 * Crea dos matrices y verifica si son idénticas usando Arrays.deepEquals().
 * 
 * Usa: Arrays.deepEquals(), Arrays.deepToString().
 * 
 * Enunciado: Define dos matrices, compáralas e imprime si son iguales o diferentes.
 */
public class E14_CompararMatrices {
    public static void main(String[] args) {
        int[][] matriz1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] matriz2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        boolean sonIguales = java.util.Arrays.deepEquals(matriz1, matriz2);

        System.out.println("Matriz 1:");
        System.out.println(java.util.Arrays.deepToString(matriz1));

        System.out.println("Matriz 2:");
        System.out.println(java.util.Arrays.deepToString(matriz2));

        if (sonIguales) {
            System.out.println("Las matrices son iguales.");
        } else {
            System.out.println("Las matrices son diferentes.");
        }
    }
}