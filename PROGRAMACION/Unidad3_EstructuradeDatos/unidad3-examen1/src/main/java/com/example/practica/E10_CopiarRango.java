package com.example.practica;

/**
 * EJERCICIO 10: Copiar rango
 * 
 * Copia un rango específico de un array a otro usando Arrays.copyOfRange().
 * 
 * Usa: Arrays.copyOfRange(), Arrays.toString().
 * 
 * Enunciado: Lee un array, especifica posiciones inicial y final, luego copia 
 * ese rango a un nuevo array.
 */
public class E10_CopiarRango {
    public static void main(String[] args) {
        int[] originalArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int start = 2; // posición inicial (inclusive)
        int end = 7;   // posición final (exclusive)

        // Copiar el rango especificado del array original
        int[] copiedArray = java.util.Arrays.copyOfRange(originalArray, start, end);

        // Imprimir ambos arrays
        System.out.println("Array original:");
        System.out.println(java.util.Arrays.toString(originalArray));

        System.out.println("Array copiado (rango " + start + " a " + (end - 1) + "):");
        System.out.println(java.util.Arrays.toString(copiedArray));
    }
}
