package com.example.practica;

/**
 * EJERCICIO 18: Búsqueda en matriz irregular
 * 
 * Crea una matriz irregular (jagged array) que represente diferentes secciones de un cine 
 * con diferente número de asientos. Usa un array de boolean para representar la 
 * disponibilidad de cada asiento (true = disponible, false = ocupado). 
 * Busca un asiento específico y muestra si está disponible.
 * 
 * Usa: arrays irregulares, bucles anidados, Arrays.fill(), condicionales, 
 * array de boolean.
 * 
 * Enunciado: Simula un sistema de búsqueda de asientos disponibles en un cine.
 */
public class E18_CineJaggedArray {
    public static void main(String[] args) {
        // Definir la matriz irregular de asientos (3 secciones con diferente número de asientos)
        boolean[][] cine = new boolean[3][];
        cine[0] = new boolean[5];  // Sección 1 con 5 asientos
        cine[1] = new boolean[7];  // Sección 2 con 7 asientos
        cine[2] = new boolean[4];  // Sección 3 con 4 asientos

        // Inicializar todos los asientos como disponibles (true)
        for (int i = 0; i < cine.length; i++) {
            java.util.Arrays.fill(cine[i], true);
        }

        // Simular algunos asientos ocupados (false)
        cine[0][1] = false; // Sección 1, asiento 2 ocupado
        cine[1][3] = false; // Sección 2, asiento 4 ocupado
        cine[2][0] = false; // Sección 3, asiento 1 ocupado

        // Buscar un asiento específico
        int seccionBuscada = 1; // Segunda sección (índice 1)
        int asientoBuscado = 4; // Quinto asiento (índice 4)

        // Verificar disponibilidad del asiento
        if (seccionBuscada >= 0 && seccionBuscada < cine.length &&
            asientoBuscado >= 0 && asientoBuscado < cine[seccionBuscada].length) {
            if (cine[seccionBuscada][asientoBuscado]) {
                System.out.println("El asiento está disponible.");
            } else {
                System.out.println("El asiento está ocupado.");
            }
        } else {
            System.out.println("El asiento buscado no existe.");
        }
    }
}
