package com.example.practica;

/**
 * EJERCICIO 6: Buscar elemento y contar apariciones
 * 
 * Crea un array de números y busca cuántas veces aparece un valor específico.
 * 
 * Usa: length, bucles, contadores, condicionales.
 * 
 * Enunciado: Lee un array (puede ser predefinido), pide un número a buscar 
 * y muestra cuántas veces aparece.
 */
import java.util.Scanner;
public class E6_BuscarYContar {
    public static void main(String[] args) {
        int[] numeros = {3, 5, 7, 3, 2, 3, 8, 5, 3}; // Array predefinido
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número a buscar: ");
        int numeroABuscar = scanner.nextInt();

        int contador = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroABuscar) {
                contador++;
            }
        }

        System.out.println("El número " + numeroABuscar + " aparece " + contador + " veces en el array.");
        scanner.close();
    }
}
