import java.util.Scanner;

public class Act3_PracticaScanner_Switch {
    public static void main(String[] args) {
        // Resuelve los ejercicios haciendo uso de la clase Scanner y la estructura de control Switch vistas en clase:

        // 1 Dia de la semana - Pide un número del 1 al 7 y muestra el nombre del dia con switch.
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un día de la semana (1 al 7)");

        String diasemana = scanner.nextLine();
        switch (diasemana) {
            case "1":
                System.out.println("Lunes");
                break;
            case "2":
                System.out.println("Martes"); 
                break;
            case "3":
                System.out.println("Miercoles");
                break;
            case "4":
                System.out.println("Jueves");
                break;
            case "5":
                System.out.println("Viernes");
                break;
            case "6":
                System.out.println("Sabado");
                break;
            case "7":
                System.out.println("Domingo");
                break;
            default:                                // El default es opcional. Se ejecuta si no se cumple ningún case.
                System.out.println("Valor no valido");
                break;
        }
        // Correcto

        // 2 Menú de calculadora - Pide dos números y una opción de menú: 1) sumar 2) restar 3) multiplicar 4) dividir. Usa switch para ejecutar la operación.
        System.out.println("Ingrese la opción de operación (1: sumar, 2: restar, 3: multiplicar, 4: dividir):");
        int opcion = scanner.nextInt();
        
        System.out.println("Ingrese el primer número:");
        double num1 = scanner.nextDouble();

        System.out.println("Ingrese el segundo número:");
        double num2 = scanner.nextDouble();

        switch (opcion) {
            case 1:
                System.out.println("Resultado: " + (num1 + num2));
                break;
            case 2:
                System.out.println("Resultado: " + (num1 - num2));
                break;
            case 3:
                System.out.println("Resultado: " + (num1 * num2));
                break;
            case 4:
                if (num2 != 0) {
                    System.out.println("Resultado: " + (num1 / num2));
                } else {
                    System.out.println("Error: División por cero no permitida.");
                }
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
        // Correcto

        // 3 Vocal o consonante - Pide una letra y dice si es vocal (a, e, i, o, u) o consonante. Maneja mayúsculas/minúsculas con toLowerCase().

        System.out.println("Por favor ingrese una letra para saber si es vocal o consonante");

        scanner.nextLine();
        String vocalconsonante = scanner.nextLine().toLowerCase();
        switch (vocalconsonante) {
            case "a", "e", "i", "o", "u":
                System.out.println("Es una vocal");
                break;
        
            default:
            System.out.println ("Es una consonante");
                break;
        }

        // Correcto

        // 4 Calificación o texto - Pide una nota (0–10) y muestra: 0–4 “Insuficiente”, 5 “Suficiente”, 6 “Bien”, 7–8 “Notable”, 9–10 “Sobresaliente”.
        System.out.println("Por favor ingrese una nota (0-10):");
        
        scanner.nextInt();
        int nota = scanner.nextInt();

        // Si quisieramos usar decimales en el switch, tendríamos que declarar la variable nota como double y luego hacer un casting a int antes del switch.
        /*  Ejemplo:
            double nota = scanner.nextDouble();
            double nota = scanner.nextDouble();
            int nota2 = (int) nota;
            Y en el Switch indicar la variable nota2 en lugar de nota. */
        switch (nota) {
            case 0, 1, 2, 3, 4 -> System.out.println("Insuficiente");
            case 5 -> System.out.println("Suficiente");
            case 6 -> System.out.println("Bien");
            case 7,8 -> System.out.println("Notable");
            case 9,10 -> System.out.println("Sobresaliente");
            default -> System.out.println("Nota no válida");
        }
        // Correcto
        
        // 5 - Mes a días - Pide el número de mes (1–12) y devuelve cuántos días tiene (ignora años bisiestos o añade una pregunta sí/no para febrero).
        System.out.println("Por favor, ingrese un mes (indicando el número correspondiente)");

        scanner.nextInt();
        int diames = scanner.nextInt();

        switch (diames) {
            case 1, 3, 5, 7, 8, 10, 12 -> System.out.println("Tiene 31 días");
            case 2 -> System.out.println("Tiene 28 días");
            case 4, 6, 9, 11 -> System.out.println("Tiene 30 días");
            default -> System.out.println("Introduzca un mes válido");
        }

        // 6 - Semáforo - Pide una palabra: “rojo”, “amarillo”, “verde” y muestra la acción (“Detente”, “Precaución”, “Avanza”).

        System.out.println("Por favor, indique de que color está el semáforo (rojo, amarillo, o verde)");

        scanner.nextLine();
        String semaforo = scanner.nextLine();

        switch (semaforo) {
            case "rojo" -> System.out.println("Detente");
            case "amarillo" -> System.out.print("Precaución");
            case "verde" -> System.out.println("Avanza");
            default -> System.out.println("Indique un color válido. Si esta apagado, avanza con precaución");
        }

        scanner.close();
    }
}