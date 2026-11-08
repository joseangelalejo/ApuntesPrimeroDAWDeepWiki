package com.example.practica;
import java.util.Scanner;

/**
 * EJERCICIO 2: Contar vocales y consonantes
 * 
 * Cuenta cuántas vocales (a, e, i, o, u) y consonantes hay en una frase
 * ingresada por el usuario.
 * 
 * Usa: length(), charAt(), toLowerCase(), bucles.
 * 
 * Enunciado: Lee una frase, cuenta vocales y consonantes, muestra los resultados.
 */
public class E2_ContarVocalesConsonantes {
    public static void main(String[] args) {
        // Implementa aquí el programa
        java.util.Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String frase = scanner.nextLine();
        int vocales = 0;
        int consonantes = 0;
        frase = frase.toLowerCase();
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {vocales++;} 
                else {consonantes++;}
            }
        }
        System.out.println("Frase analizada: " + frase + ". Cantidad de letras: " + (vocales + consonantes));
        System.out.println("Número de vocales: " + vocales);
        System.out.println("Número de consonantes: " + consonantes);
        scanner.close();
    }
}
