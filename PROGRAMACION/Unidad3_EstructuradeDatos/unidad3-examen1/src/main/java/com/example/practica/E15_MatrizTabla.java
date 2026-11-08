package com.example.practica;

/**
 * EJERCICIO 15: Imprimir matriz en formato tabla
 * 
 * Crea una matriz 3x3 e imprímela en formato de tabla con bordes ASCII.
 * 
 * Usa: bucles anidados, System.out.print(), caracteres especiales.
 * 
 * Enunciado: Imprime la matriz con una presentación visual clara 
 * (con bordes y separadores).
 */
public class E15_MatrizTabla {
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("+---+---+---+");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" " + matriz[i][j] + " |");
            }
            System.out.println();
            System.out.println("+---+---+---+");
        }
    }
}
