package com.example.practica;

/**
 * EJERCICIO 5: Validar palíndromo
 * 
 * Determina si una palabra (ignorando mayúsculas/minúsculas) es un palíndromo.
 * 
 * Usa: length(), charAt(), equalsIgnoreCase(), bucles.
 * 
 * Enunciado: Lee una palabra y valida si se lee igual de adelante hacia atrás.
 */
import java.util.Scanner;
public class E5_ValidarPalindromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una palabra: ");
        String palabra = scanner.nextLine();
        scanner.close();

        boolean esPalindromo = true;
        int longitud = palabra.length();
        for (int i = 0; i < longitud / 2; i++) {
            if (Character.toLowerCase(palabra.charAt(i)) != Character.toLowerCase(palabra.charAt(longitud - 1 - i))) {
                esPalindromo = false;
                break;
            }
        }

        if (esPalindromo) {
            System.out.println("La palabra es un palíndromo.");
        } else {
            System.out.println("La palabra no es un palíndromo.");
        }
    }
}