package com.example.practica;

import java.util.Random;

/**
 * EJERCICIO 11: Matriz de temperaturas
 * 
 * Crea una matriz 3x4 que represente temperaturas de 3 ciudades en 4 meses. 
 * Calcula la temperatura promedio de cada ciudad y la del mes más cálido.
 * 
 * Usa: bucles anidados, operaciones aritméticas.
 * 
 * Enunciado: Define los datos, calcula promedio por ciudad y el mes con 
 * mayor temperatura promedio.
 */
public class E11_MatrizTemperaturas {
    public static void main(String[] args) {
        // Random random = new Random();
        Random random = new Random(0); // Semilla fija para resultados reproducibles

        // Definir la matriz de temperaturas (3 ciudades, 4 meses) con valores aleatorios
        double[][] temperaturas = new double[3][4];
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                temperaturas[i][j] = 5 + random.nextDouble() * 30; // Temperaturas entre 5°C y 35°C
            }
        }

        // Calcular el promedio de temperatura por ciudad
        for (int i = 0; i < temperaturas.length; i++) {
            double suma = 0;
            for (int j = 0; j < temperaturas[i].length; j++) {
                suma += temperaturas[i][j];
            }
            double promedioCiudad = suma / temperaturas[i].length;
            System.out.printf("Promedio de temperatura de la Ciudad %d: %.2f°C%n", i + 1, promedioCiudad);
        }

        // Calcular el mes con la mayor temperatura promedio
        double[] promediosMensuales = new double[4];
        for (int j = 0; j < temperaturas[0].length; j++) {
            double sumaMes = 0;
            for (int i = 0; i < temperaturas.length; i++) {
                sumaMes += temperaturas[i][j];
            }
            promediosMensuales[j] = sumaMes / temperaturas.length;
        }

        int mesMasCalido = 0;
        for (int j = 1; j < promediosMensuales.length; j++) {
            if (promediosMensuales[j] > promediosMensuales[mesMasCalido]) {
                mesMasCalido = j;
            }
        }

        System.out.printf("El mes más cálido es el mes %d con una temperatura promedio de %.2f°C%n",
                          mesMasCalido + 1, promediosMensuales[mesMasCalido]);
    }
}
