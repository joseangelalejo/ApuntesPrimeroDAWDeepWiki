import java.util.Scanner;
public class Act1JAAlejo {
    public static void main(String[] args) {
        /* */
        // Enunciado 1: Escribe un programa que dada una cadena con el formato nombre+apellido1+apellido2 imprima estos en líneas separadas (suponer no apellidos ni nombres compuestos)
            String nombreCompleto1 = "Nombre+Apellido1+Apellido2";
            int espacio1 = nombreCompleto1.indexOf("+");    // Posición del primer + (simula el espacio)
            int espacio2 = nombreCompleto1.indexOf("+", espacio1 + 1);  // Posición del segundo + (simula el segundo espacio)
            String nombre1 = nombreCompleto1.substring(0, espacio1);    // El nombre será desde el inicio hasta la posición indicada con espacio1
            String apellido1 = nombreCompleto1.substring(espacio1 + 1, espacio2);   // El primer apellido será desde la posición siguiente a espacio1 hasta espacio2
            String apellido2 = nombreCompleto1.substring(espacio2 + 1);   // El segundo apellido será desde la posición siguiente a espacio2 hasta el final
            System.out.printf("%s\n%s\n%s\n", nombre1, apellido1, apellido2); 
        // Enunciado 2: Escribe un programa que cuente cuántas palabras hay en una frase. Considera que las palabras están separadas por espacios. 
            Scanner scanner2 = new Scanner(System.in); // Creación de Scanner para enunciado 2
            System.out.println("Introduce una frase: ");
            String frase2 = scanner2.nextLine();    // Asignamos la frase introducida por el usuario a la variable frase2
            int contador2 = 0;  // Contador para las separaciones válidas (no para todos los espacios)
            boolean enPalabra = false;  // Nueva variable: indica si estamos dentro de una palabra
            // Bucle modificado: cuenta transiciones de "palabra" a "espacio" para ignorar espacios consecutivos
            for (int i = 0; i < frase2.length(); i++) {
                if (frase2.charAt(i) != ' ') {
                    enPalabra = true;  // Estamos en una palabra
                } else {
                    if (enPalabra) {
                        contador2++;  // Cuenta una separación solo si veníamos de una palabra
                        enPalabra = false;  // Ya no estamos en una palabra
                    } // Ignora espacios consecutivos (no incrementa contador2)
                }
            }
            int palabras2 = (frase2.length() > 0 && contador2 > 0) ? contador2 + 1 : (frase2.trim().isEmpty() ? 0 : 1);  // Ajuste: si no hay separaciones pero hay texto, es 1 palabra; si está vacío, 0
            // Eliminé los if para espacios al inicio/final porque la nueva lógica los maneja automáticamente
            System.out.println("Hay " + palabras2 + " palabras y " + contador2 + " separaciones");   // Cambié "espacios" por "separaciones" para mayor claridad
            scanner2.close();
        
        // Enunciado 3: Escribe un programa que tome una cadena como entrada y devuelva la cadena invertida.
            String frase3 = "Holaa";
            
            // char letra1 = frase3.charAt(0);
            // char ultimaletra = frase3.charAt(frase3.length() - 1);
            // for (int i2 = 0; i2<frase3.length(); i2++) {  
            //     System.out.print(ultimaletra);  // Estoy imprimiendo continuamente la última letra..
            // }
            // System.out.print(letra1);
            // 
            for (int i2 = frase3.length() - 1; i2 >= 0; i2--) {  
                System.out.print(frase3.charAt(i2));    // Imprime el carácter en la posición i2
            }
            // Para un entero i2 igual a la longitud de la frase menos 1 (última posición) 
            // Mientras i2 sea mayor o igual a 0 (primera posición)
            // Disminuye i2 en 1 en cada iteración
        
        // Enunciado 4: Escribe un programa que determine si una cadena es un palíndromo (se lee igual de izquierda a derecha que de derecha a izquierda). Ignora mayúsculas, minúsculas y espacios.     
            System.out.println("\nEnunciado 4"); 
            String frase4 = "sal as";
            String frase4reves = "";
            String frase4esp = "";
            // For para eliminar espacios de la frase inicial
            for (int i3a =0; i3a<frase4.length(); i3a++) {
                if (frase4.charAt(i3a) != ' ') {
                    frase4esp +=frase4.charAt(i3a);    // Asigno cada carácter obtenido al string frase4reves
                }
            }
            // For para obtener la frase al revés
            for (int i3 = frase4esp.length() - 1; i3 >= 0; i3--) {
                frase4reves +=frase4esp.charAt(i3);    // Asigno cada carácter obtenido al string frase4reves
            }
            // DONE: Agregar consideración para los espacios.
            // If para comparar ambas cadenas e imprimir si son o no palíndromos
            if (frase4esp.equalsIgnoreCase(frase4reves)){
                System.out.println("Son palíndromos");
            } else {
                System.out.println("No son palíndromos");
            }
        
        // Enunciado 5: Escribe un programa que reemplace todas las apariciones de un carácter en una cadena por otro carácter.
            System.out.println("\nEnunciado 5");
            String frase5 = "Fiuuuuumba";
            char charAReemplazar = 'u';
            char charReemplazo = 'o';
            String frase5nueva = "";

            for (int i4 = 0; i4<frase5.length(); i4++) { // Antes (int i4 = frase5.length() -1; i4>=0; i4--)
                if (frase5.charAt(i4) != charAReemplazar) {
                    frase5nueva+= frase5.charAt(i4);
                } else {
                    frase5nueva+= charReemplazo;
                }
            }
            System.out.println(frase5nueva);
            // DONE Corregir FOR para que haga la asignación adecuadamente. 
            // Se imprimía la cadena al revés porque el bucle for estaba iterando desde el final hasta el principio de la cadena original.
        
        // Enunciado 6: Escribe un programa que extraiga una subcadena de una cadena dada, usando índices de inicio y fin.
        String frase6 = "ProgramacionJava";
        String subcadena1 = frase6.substring(0, 12);
        String subcadena2 = frase6.substring(12, 16);
        System.out.println("Subcadena 1: " + subcadena1 + "\nSubcadena 2: " + subcadena2);
        System.out.printf("Subcadena 1: %s%nSubcadena 2: %s%n", subcadena1, subcadena2);
    }
}