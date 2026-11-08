package com.example.practica;

/**
 * EJERCICIO 7: Ordenar y comparar
 * 
 * Crea dos arrays, ordénalos y comprueba si son iguales después de ordenar.
 * 
 * Usa: Arrays.sort(), Arrays.equals(), Arrays.toString().
 * 
 * Enunciado: Define dos arrays diferentes, ordénalos y compara si contienen 
 * los mismos elementos.
 */
import java.util.Scanner;
import java.util.Arrays;
public class E7_OrdenarYComparar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] array1 = {5, 3, 8, 1, 2};
        int[] array2 = {3, 5, 2, 8, 1};

        Arrays.sort(array1);
        Arrays.sort(array2);

        System.out.println("Array 1 ordenado: " + Arrays.toString(array1));
        System.out.println("Array 2 ordenado: " + Arrays.toString(array2));

        if (Arrays.equals(array1, array2)) {
            System.out.println("Los arrays son iguales después de ordenar.");
        } else {
            System.out.println("Los arrays no son iguales después de ordenar.");
        }
        scanner.close();
    }
}