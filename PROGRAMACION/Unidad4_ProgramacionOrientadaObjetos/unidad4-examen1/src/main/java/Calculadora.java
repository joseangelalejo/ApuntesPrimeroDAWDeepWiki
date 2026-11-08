import java.util.Scanner;

public class Calculadora {
    // Método para sumar dos enteros
    public int sumar(int a, int b) {
        return a + b;
    }

    // Sobrecarga del método sumar para sumar tres enteros
    public int sumar(int a, int b, int c) {
        return a + b + c;
    }

    // Sobrecarga del método sumar para sumar dos números de punto flotante
    public double sumar(double a, double b) {
        return a + b;
    }

    // Método para restar dos enteros
    public int restar(int a, int b) {
        return a - b;
    }

    // Método para calcular el valor absoluto de un entero
    public int absoluto(int a) {
        return Math.abs(a);
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nMenú: \n  1. Suma\n  2. Resta\n  3. Valor absoluto\n  4. Salir\nElige una opción: ");
            int opcion = scanner.nextInt();
            int a, b;

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingresa primer número: ");
                    a = scanner.nextInt();
                    System.out.print("Ingresa segundo número: ");
                    b = scanner.nextInt();
                    System.out.println("Resultado: " + calc.sumar(a, b));
                }
                case 2 -> {
                    System.out.print("Ingresa primer número: ");
                    a = scanner.nextInt();
                    System.out.print("Ingresa segundo número: ");
                    b = scanner.nextInt();
                    System.out.println("Resultado: " + calc.restar(a, b));
                }
                case 3 -> {
                    System.out.print("Ingresa un número: ");
                    a = scanner.nextInt();
                    System.out.println("Valor absoluto: " + calc.absoluto(a));
                }
                case 4 -> {
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
