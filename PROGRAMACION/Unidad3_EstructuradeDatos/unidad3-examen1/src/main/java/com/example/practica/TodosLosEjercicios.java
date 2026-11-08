package com.example.practica;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/**
 * TODOS LOS EJERCICIOS COMBINADOS (E1 - E18)
 * 
 * Menú interactivo para ejecutar cualquiera de los 18 ejercicios.
 */
public class TodosLosEjercicios {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    ejercicio1_ValidarContrasena();
                    break;
                case 2:
                    ejercicio2_ContarVocalesConsonantes();
                    break;
                case 3:
                    ejercicio3_BuscarYReemplazar();
                    break;
                case 4:
                    ejercicio4_InvertirPalabra();
                    break;
                case 5:
                    ejercicio5_ValidarPalindromo();
                    break;
                case 6:
                    ejercicio6_BuscarYContar();
                    break;
                case 7:
                    ejercicio7_OrdenarYComparar();
                    break;
                case 8:
                    ejercicio8_EstadisticasArray();
                    break;
                case 9:
                    ejercicio9_InvertirArray();
                    break;
                case 10:
                    ejercicio10_CopiarRango();
                    break;
                case 11:
                    ejercicio11_MatrizTemperaturas();
                    break;
                case 12:
                    ejercicio12_DiagonalMatriz();
                    break;
                case 13:
                    ejercicio13_BuscarEnMatriz();
                    break;
                case 14:
                    ejercicio14_CompararMatrices();
                    break;
                case 15:
                    ejercicio15_MatrizTabla();
                    break;
                case 16:
                    ejercicio16_SumaColumnas();
                    break;
                case 17:
                    ejercicio17_SistemaNotas();
                    break;
                case 18:
                    ejercicio18_CineJaggedArray();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }

            if (continuar && opcion >= 1 && opcion <= 18) {
                System.out.println("\nPresiona Enter para continuar...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    static void mostrarMenu() {
        System.out.println("\n========== MENÚ DE EJERCICIOS ==========");
        System.out.println("1.  Validar Contraseña");
        System.out.println("2.  Contar Vocales y Consonantes");
        System.out.println("3.  Buscar y Reemplazar");
        System.out.println("4.  Invertir Palabra");
        System.out.println("5.  Validar Palíndromo");
        System.out.println("6.  Buscar y Contar");
        System.out.println("7.  Ordenar y Comparar");
        System.out.println("8.  Estadísticas de Array");
        System.out.println("9.  Invertir Array");
        System.out.println("10. Copiar Rango");
        System.out.println("11. Matriz de Temperaturas");
        System.out.println("12. Diagonal de Matriz");
        System.out.println("13. Buscar en Matriz");
        System.out.println("14. Comparar Matrices");
        System.out.println("15. Matriz en Tabla");
        System.out.println("16. Suma de Columnas");
        System.out.println("17. Sistema de Notas");
        System.out.println("18. Cine Jagged Array");
        System.out.println("0.  Salir");
        System.out.print("Elige una opción: ");
    }

    // EJERCICIO 1
    static void ejercicio1_ValidarContrasena() {
        System.out.println("\n========== EJERCICIO 1: VALIDAR CONTRASEÑA ==========");
        String password = "";
        boolean tieneMayus = false, tieneMinus = false, tieneNumero = false;
        do {
            System.out.print("Introduce la contraseña: ");
            password = scanner.nextLine();
            tieneMayus = false;
            tieneMinus = false;
            tieneNumero = false;
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
                    System.out.println(
                            "La contraseña debe contener al menos una mayúscula, una minúscula y un número.");
                }
            }
        } while ((!tieneMayus || !tieneMinus || !tieneNumero) || password.length() < 8);
    }

    // EJERCICIO 2 
    static void ejercicio2_ContarVocalesConsonantes() {
        System.out.println("\n========== EJERCICIO 2: CONTAR VOCALES Y CONSONANTES ==========");
        System.out.print("Introduce una frase: ");
        String frase = scanner.nextLine();
        int vocales = 0;
        int consonantes = 0;
        frase = frase.toLowerCase();
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vocales++;
                } else {
                    consonantes++;
                }
            }
        }
        System.out.println("Frase analizada: " + frase + ". Cantidad de letras: " + (vocales + consonantes));
        System.out.println("Número de vocales: " + vocales);
        System.out.println("Número de consonantes: " + consonantes);
    }

    // EJERCICIO 3 
    static void ejercicio3_BuscarYReemplazar() {
        System.out.println("\n========== EJERCICIO 3: BUSCAR Y REEMPLAZAR ==========");
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
    }

    // EJERCICIO 4 
    static void ejercicio4_InvertirPalabra() {
        System.out.println("\n========== EJERCICIO 4: INVERTIR PALABRA ==========");
        System.out.print("Introduce una palabra: ");
        String palabra = scanner.nextLine();

        String palabraInvertida = "";
        for (int i = palabra.length() - 1; i >= 0; i--) {
            palabraInvertida += palabra.charAt(i);
        }

        System.out.println("Palabra invertida: " + palabraInvertida);
    }

    // EJERCICIO 5 
    static void ejercicio5_ValidarPalindromo() {
        System.out.println("\n========== EJERCICIO 5: VALIDAR PALÍNDROMO ==========");
        System.out.print("Introduce una palabra: ");
        String palabra = scanner.nextLine();

        boolean esPalindromo = true;
        int longitud = palabra.length();
        for (int i = 0; i < longitud / 2; i++) {
            if (Character.toLowerCase(palabra.charAt(i)) != Character
                    .toLowerCase(palabra.charAt(longitud - 1 - i))) {
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

    // EJERCICIO 6 
    static void ejercicio6_BuscarYContar() {
        System.out.println("\n========== EJERCICIO 6: BUSCAR Y CONTAR ==========");
        int[] numeros = { 3, 5, 7, 3, 2, 3, 8, 5, 3 };

        System.out.print("Introduce un número a buscar: ");
        int numeroABuscar = scanner.nextInt();

        int contador = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroABuscar) {
                contador++;
            }
        }

        System.out.println("El número " + numeroABuscar + " aparece " + contador + " veces en el array.");
    }

    // EJERCICIO 7 
    static void ejercicio7_OrdenarYComparar() {
        System.out.println("\n========== EJERCICIO 7: ORDENAR Y COMPARAR ==========");
        int[] array1 = { 5, 3, 8, 1, 2 };
        int[] array2 = { 3, 5, 2, 8, 1 };

        Arrays.sort(array1);
        Arrays.sort(array2);

        System.out.println("Array 1 ordenado: " + Arrays.toString(array1));
        System.out.println("Array 2 ordenado: " + Arrays.toString(array2));

        if (Arrays.equals(array1, array2)) {
            System.out.println("Los arrays son iguales después de ordenar.");
        } else {
            System.out.println("Los arrays no son iguales después de ordenar.");
        }
    }

    // EJERCICIO 8 
    static void ejercicio8_EstadisticasArray() {
        System.out.println("\n========== EJERCICIO 8: ESTADÍSTICAS DE ARRAY ==========");
        System.out.print("Ingrese el número de notas: ");
        int n = scanner.nextInt();
        float[] notas = new float[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + ": ");
            notas[i] = scanner.nextFloat();
        }
        float suma = 0;
        float maximo = notas[0];
        float minimo = notas[0];
        for (float nota : notas) {
            suma += nota;
            if (nota > maximo) {
                maximo = nota;
            }
            if (nota < minimo) {
                minimo = nota;
            }
        }
        float promedio = suma / n;
        System.out.println("Suma de las notas: " + suma + "\nPromedio de las notas: " + promedio
                + "\nNota máxima: " + maximo + "\nNota mínima: " + minimo);
    }

    // EJERCICIO 9 
    static void ejercicio9_InvertirArray() {
        System.out.println("\n========== EJERCICIO 9: INVERTIR ARRAY ==========");
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        System.out.println("Array original:");
        System.out.println(Arrays.toString(array));

        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = temp;
        }

        System.out.println("Array invertido:");
        System.out.println(Arrays.toString(array));
    }

    // EJERCICIO 10 
    static void ejercicio10_CopiarRango() {
        System.out.println("\n========== EJERCICIO 10: COPIAR RANGO ==========");
        int[] originalArray = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        int start = 2;
        int end = 7;

        int[] copiedArray = Arrays.copyOfRange(originalArray, start, end);

        System.out.println("Array original:");
        System.out.println(Arrays.toString(originalArray));

        System.out.println("Array copiado (rango " + start + " a " + (end - 1) + "):");
        System.out.println(Arrays.toString(copiedArray));
    }

    // EJERCICIO 11 
    static void ejercicio11_MatrizTemperaturas() {
        System.out.println("\n========== EJERCICIO 11: MATRIZ DE TEMPERATURAS ==========");
        Random random = new Random(0);

        double[][] temperaturas = new double[3][4];
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                temperaturas[i][j] = 5 + random.nextDouble() * 30;
            }
        }

        for (int i = 0; i < temperaturas.length; i++) {
            double suma = 0;
            for (int j = 0; j < temperaturas[i].length; j++) {
                suma += temperaturas[i][j];
            }
            double promedioCiudad = suma / temperaturas[i].length;
            System.out.printf("Promedio de temperatura de la Ciudad %d: %.2f°C%n", i + 1, promedioCiudad);
        }

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

    // EJERCICIO 12 
    static void ejercicio12_DiagonalMatriz() {
        System.out.println("\n========== EJERCICIO 12: DIAGONAL DE MATRIZ ==========");
        int[][] matriz = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        int sumaDiagonal = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    sumaDiagonal += matriz[i][j];
                }
            }
        }
        System.out.println("La suma de la diagonal principal es: " + sumaDiagonal);
    }

    // EJERCICIO 13 
    static void ejercicio13_BuscarEnMatriz() {
        System.out.println("\n========== EJERCICIO 13: BUSCAR EN MATRIZ ==========");
        int[][] matriz = { { 5, 12, 7, 9 }, { 3, 15, 8, 6 }, { 14, 2, 11, 4 } };

        int numeroABuscar = 8;
        boolean encontrado = false;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == numeroABuscar) {
                    System.out.println("Número " + numeroABuscar + " encontrado en la posición: [" + i + "][" + j
                            + "]");
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Número " + numeroABuscar + " no encontrado en la matriz.");
        }
    }

    // EJERCICIO 14 
    static void ejercicio14_CompararMatrices() {
        System.out.println("\n========== EJERCICIO 14: COMPARAR MATRICES ==========");
        int[][] matriz1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matriz2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        boolean sonIguales = Arrays.deepEquals(matriz1, matriz2);

        System.out.println("Matriz 1:");
        System.out.println(Arrays.deepToString(matriz1));

        System.out.println("Matriz 2:");
        System.out.println(Arrays.deepToString(matriz2));

        if (sonIguales) {
            System.out.println("Las matrices son iguales.");
        } else {
            System.out.println("Las matrices son diferentes.");
        }
    }

    // EJERCICIO 15 
    static void ejercicio15_MatrizTabla() {
        System.out.println("\n========== EJERCICIO 15: MATRIZ EN TABLA ==========");
        int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println("+---+---+---+");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" " + matriz[i][j] + " |");
            }
            System.out.println();
            System.out.println("+---+---+---+");
        }
    }

    // EJERCICIO 16 
    static void ejercicio16_SumaColumnas() {
        System.out.println("\n========== EJERCICIO 16: SUMA DE COLUMNAS ==========");
        int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
        int[] sumaColumnas = new int[matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sumaColumnas[j] += matriz[i][j];
            }
        }
        for (int j = 0; j < sumaColumnas.length; j++) {
            System.out.println("Suma de la columna " + (j + 1) + ": " + sumaColumnas[j]);
        }
    }

    // EJERCICIO 17 
    static void ejercicio17_SistemaNotas() {
        System.out.println("\n========== EJERCICIO 17: SISTEMA DE NOTAS ==========");
        double[][] notas = { { 8.5, 7.0, 9.0, 6.5 }, { 5.0, 6.0, 7.5, 8.0 }, { 9.0, 8.5, 10.0, 9.5 },
                { 4.0, 5.5, 6.0, 7.0 }, { 7.5, 8.0, 7.0, 6.5 } };
        int numEstudiantes = notas.length;
        int numAsignaturas = notas[0].length;

        System.out.println("Promedio general de cada estudiante:");
        for (int i = 0; i < numEstudiantes; i++) {
            double suma = 0;
            for (int j = 0; j < numAsignaturas; j++) {
                suma += notas[i][j];
            }
            double promedioEstudiante = suma / numAsignaturas;
            System.out.printf("Estudiante %d: %.2f%n", i + 1, promedioEstudiante);
        }

        System.out.println("\nPromedio de cada asignatura:");
        for (int j = 0; j < numAsignaturas; j++) {
            double suma = 0;
            for (int i = 0; i < numEstudiantes; i++) {
                suma += notas[i][j];
            }
            double promedioAsignatura = suma / numEstudiantes;
            System.out.printf("Asignatura %d: %.2f%n", j + 1, promedioAsignatura);
        }

        double mejorCalificacion = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < numEstudiantes; i++) {
            for (int j = 0; j < numAsignaturas; j++) {
                if (notas[i][j] > mejorCalificacion) {
                    mejorCalificacion = notas[i][j];
                }
            }
        }
        System.out.printf("\nLa mejor calificación del grupo es: %.2f%n", mejorCalificacion);

        int estudiantesAprobados = 0;
        for (int i = 0; i < numEstudiantes; i++) {
            double suma = 0;
            for (int j = 0; j < numAsignaturas; j++) {
                suma += notas[i][j];
            }
            double promedioEstudiante = suma / numAsignaturas;
            if (promedioEstudiante >= 7) {
                estudiantesAprobados++;
            }
        }
        System.out.println("\nNúmero de estudiantes aprobados: " + estudiantesAprobados);
    }

    // EJERCICIO 18 
    static void ejercicio18_CineJaggedArray() {
        System.out.println("\n========== EJERCICIO 18: CINE JAGGED ARRAY ==========");
        boolean[][] cine = new boolean[3][];
        cine[0] = new boolean[5];
        cine[1] = new boolean[7];
        cine[2] = new boolean[4];

        for (int i = 0; i < cine.length; i++) {
            Arrays.fill(cine[i], true);
        }

        cine[0][1] = false;
        cine[1][3] = false;
        cine[2][0] = false;

        int seccionBuscada = 1;
        int asientoBuscado = 4;

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
