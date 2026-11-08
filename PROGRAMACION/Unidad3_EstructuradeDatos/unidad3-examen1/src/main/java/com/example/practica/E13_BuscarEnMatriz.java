package com.example.practica;

/**
 * EJERCICIO 13: Buscar en matriz
 * 
 * Busca un valor específico en una matriz 2D y muestra su posición [fila][columna].
 * 
 * Usa: bucles anidados, condicionales, salida de bucles con bandera.
 * 
 * Enunciado: Define una matriz, pide un número a buscar y muestra dónde se 
 * encuentra (o "no encontrado").
 */
public class E13_BuscarEnMatriz {
    public static void main(String[] args) {
        int[][] matriz = {
            {5, 12, 7, 9},
            {3, 15, 8, 6},
            {14, 2, 11, 4}
        };

        int numeroABuscar = 8; // Número a buscar en la matriz
        boolean encontrado = false;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == numeroABuscar) {
                    System.out.println("Número " + numeroABuscar + " encontrado en la posición: [" + i + "][" + j + "]");
                    encontrado = true;
                    break; // Salir del bucle interno
                }
            }
            if (encontrado) {
                break; // Salir del bucle externo
            }
        }

        if (!encontrado) {
            System.out.println("Número " + numeroABuscar + " no encontrado en la matriz.");
        }
    }
}
