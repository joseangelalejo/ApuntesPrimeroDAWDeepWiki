package com.example.practica;

/**
 * EJERCICIO 9: Invertir array
 * 
 * Invierte el contenido de un array sin crear uno nuevo (o con un método auxiliar).
 * 
 * Usa: bucles, intercambio de variables, Arrays.toString().
 * 
 * Enunciado: Lee un array y muestra sus elementos en orden inverso.
 */
public class E9_InvertirArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Imprimir array original
        System.out.println("Array original:");
        System.out.println(java.util.Arrays.toString(array));

        // Invertir el array
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = temp;
        }

        // Imprimir array invertido
        System.out.println("Array invertido:");
        System.out.println(java.util.Arrays.toString(array));
    }
}
