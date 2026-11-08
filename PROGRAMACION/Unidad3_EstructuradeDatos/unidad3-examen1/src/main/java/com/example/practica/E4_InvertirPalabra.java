package com.example.practica;

/**
 * EJERCICIO 4: Invertir palabra
 * 
 * Lee una palabra y muéstrala al revés sin usar métodos predefinidos como reverse().
 * 
 * Usa: length(), charAt(), bucles descendentes.
 * 
 * Enunciado: Pide una palabra y imprime sus caracteres en orden inverso.
 */
import java.util.Scanner;
public class E4_InvertirPalabra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una palabra: ");
        String palabra = scanner.nextLine();
        scanner.close();

        String palabraInvertida = "";
        for (int i = palabra.length() - 1; i >= 0; i--) {
            palabraInvertida += palabra.charAt(i);
        }

        System.out.println("Palabra invertida: " + palabraInvertida);
    }
}
