package com.example.practica;
import java.util.Scanner;

/**
 * EJERCICIO 1: Validar contraseña
 * 
 * Crea un programa que valide si una contraseña tiene al menos 8 caracteres,
 * contiene mayúsculas, minúsculas y números.
 * 
 * Usa: length(), charAt(), bucles, comparación con caracteres ASCII.
 * 
 * Enunciado: Lee una contraseña y valida que cumpla los requisitos. 
 * Imprime si es válida o no.
 */
public class E1_ValidarContrasena {
    public static void main(String[] args) {
        // Implementa aquí el programa
        java.util.Scanner scanner = new Scanner(System.in);
        String password = "";
        boolean tieneMayus = false, tieneMinus = false, tieneNumero = false;
        do {
        System.out.print("Introduce la contraseña: ");
        password = scanner.nextLine();
        tieneMayus = false; tieneMinus = false; tieneNumero = false;
            if (password.length() < 8) {
                System.out.println("La contraseña debe tener al menos 8 caracteres.");
            } else {
                for (int i = 0; i < password.length(); i++) {
                    char c = password.charAt(i);
                    if (c >= 'A' && c <= 'Z') {
                        tieneMayus = true;
                    } else if (c >= 'a' && c <= 'z') {
                        tieneMinus = true;
                    } else if (c >= '0' && c <= '9') {
                        tieneNumero = true;
                    }
                }
                if (tieneMayus && tieneMinus && tieneNumero) {
                    System.out.println("Contraseña válida.");
                } else {
                    System.out.println("La contraseña debe contener al menos una mayúscula, una minúscula y un número.");
                }
            }
        } while ((!tieneMayus || !tieneMinus || !tieneNumero) || password.length() < 8);
        scanner.close();    // Cierre de scanner "scanner"
    }
}
