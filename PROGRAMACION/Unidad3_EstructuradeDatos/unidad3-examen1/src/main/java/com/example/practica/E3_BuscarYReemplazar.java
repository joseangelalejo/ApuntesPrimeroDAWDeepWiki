package com.example.practica;

/**
 * EJERCICIO 3: Buscar y reemplazar
 * 
 * Busca todas las apariciones de una subcadena en una frase y reemplázalas por otra.
 * 
 * Usa: indexOf(), substring(), concatenación de strings, bucles.
 * 
 * Enunciado: Lee una frase, un texto a buscar y un reemplazo, luego imprime 
 * la frase modificada.
 */
import java.util.Scanner;
public class E3_BuscarYReemplazar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce una frase: ");
        String frase = scanner.nextLine();
        System.out.print("Introduce el texto a buscar: ");
        String buscar = scanner.nextLine();
        System.out.print("Introduce el texto de reemplazo: ");
        String reemplazo = scanner.nextLine();
        String resultado = "";
        int indice = 0;
        while (indice < frase.length()) {
            int posicion = frase.indexOf(buscar, indice);
            if (posicion == -1) {
                resultado += frase.substring(indice);
                break;
            } else {
                resultado += frase.substring(indice, posicion) + reemplazo;
                indice = posicion + buscar.length();
            }
        }
        System.out.println("Frase modificada: " + resultado);
        scanner.close();
    }
}
