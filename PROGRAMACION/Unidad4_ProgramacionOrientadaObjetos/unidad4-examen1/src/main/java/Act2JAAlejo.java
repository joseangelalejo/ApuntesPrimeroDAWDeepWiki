import java.util.Scanner;
public class Act2JAAlejo {
//  Crea un programa en donde el usuario introduzca un String y a continuación se le muestre un menú con las siguientes opciones:
    //  Contar palabras
    //  Contar vocales
    //  Comprobar si hay números
    //  Comprobar si una palabra está en el texto y mostrar por pantalla el nº de veces.
    //  Mostrar por pantalla la palabra más larga.
//  Cada una de estas opciones debes programarlas como una función aparte que será llamada desde el menú.
    /** public static String frase;
      * NOTA apuntes: Cuando utilizamos una variable de manera continua a lo largo de una serie de métodos podemos declararlo como estático
      * haciendo más cómodo el desarrollo de métodos.*/
    public static int contarPalabras(String frase) {
        if (frase == null || frase.isEmpty()) {
            return 0;
        }
        String[] palabras = frase.trim().split("\\s+");
        return palabras.length;
    }
    public static int contarVocales(String frase) {
        int contador = 0;
        String vocales = "aeiouAEIOU";
        for (int i = 0; i < frase.length(); i++) {
            if (vocales.indexOf(frase.charAt(i)) != -1) {
                contador++;
            }
        }
        return contador;
    }
    public static boolean contieneNumeros(String frase) {
        for (int i = 0; i < frase.length(); i++) {
            if (Character.isDigit(frase.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public static int contarOcurrencias(String frase, String palabra) {
        String[] palabras = frase.split("\\s+");
        int contador = 0;
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].equalsIgnoreCase(palabra)) {
                contador++;
            }
        }
        return contador;
    }
    public static String palabraMasLarga(String frase) {
        String[] palabraLarga = frase.split("\\s+");
        String palabraMasLarga = "";
        for (int i = 0; i< palabraLarga.length; i++) {
            if (palabraLarga[i].length() > palabraMasLarga.length()) {
                palabraMasLarga = palabraLarga[i];
            }
        }
        return palabraMasLarga;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("Introduce un String: "); // Petición de frase al usuario
            String frase = scanner.nextLine();
            System.out.println("\nMenú de opciones:\n      1. Contar palabras\n      2. Contar vocales\n      3. Comprobar si hay números\n      4. Comprobar si una palabra está en el texto\n      5. Mostrar la palabra más larga\n      6. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1 -> System.out.println("Número de palabras: " + contarPalabras(frase));
                case 2 -> System.out.println("Número de vocales: " + contarVocales(frase));
                case 3 -> {
                    if (contieneNumeros(frase)){
                        System.out.println("El texto contiene números.");
                    } else {
                        System.out.println("El texto no contiene números.");
                    }
                }
                case 4 -> {
                    System.out.println("Introduce la palabra a buscar: ");
                    String palabra = scanner.nextLine();
                    int ocurrencias = contarOcurrencias(frase, palabra);
                    System.out.println("La palabra '" + palabra + "' aparece " + ocurrencias + " veces en el texto.");
                }
                case 5 -> System.out.println("La palabra más larga es: " + palabraMasLarga(frase));
                case 6 -> System.out.println("Saliendo del programa.");
            }
        } while (opcion != 6);
        scanner.close();
    }
}