import java.util.Scanner;

public class ED_EstructuraScannerPruebas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Abrimos Scanner

        System.out.println("Cuál es tu nombre?");
        String nombre = scanner.nextLine(); // Indicamos esperar a entrada de texto

        System.out.println("¿Cuantos años tienes?");
        int edad = scanner.nextInt(); // variable int, llamada edad, usamos Int para que espere a un numero entero

        scanner.nextLine(); // Usamos para limpiar el scanner. Sino, no nos preguntará cual es nuestra
        // comida favorita
        System.out.println("¿Cual es tu comida favorita?");
        String comida = scanner.nextLine();

        System.out.println("Hola " + nombre);
        System.out.println("Tienes " + edad + " años");
        System.out.println("Te gusta la comida " + comida);

        scanner.close(); // Cerramos el Scanner

    }

}
