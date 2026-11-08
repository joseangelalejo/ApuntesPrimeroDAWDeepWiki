import java.util.Scanner;

public class ActEvaluable1_U3JAAlejo {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Bienvenido al parque de atracciones. \n A continuación te solicitaremos unos datos para gestionar tu acceso.");

    System.out.println("¿Cómo te llamas?");

        String nombre = scanner.nextLine();

    System.out.println("¿Cuantos años tienes?");

        int edad = scanner.nextInt();

    System.out.println("Qué dia de la semana quieres ir al parque? Introduce el numero concorde al día que quieres ir: \n 1) Lunes \n 2) Martes \n 3) Miercoles \n 4) Jueves \n 5) Viernes \n 6) Sábado \n 7) Domingo");

        int diaSemana = scanner.nextInt();

    if (edad >= 18){
        System.out.println("Eres mayor de edad, puedes entrar sin acompañante.");
    } else if (edad > 0 && edad < 18) {
        System.out.println(" Eres menor de edad, necesitas un acompañante adulto.");

    }

    if ( edad >= 18 && (diaSemana==6 || diaSemana==7)) {
        System.out.println("¡Enhorabuena! Tienes acceso al pase especial de fin de semana :D");
    } else {
        System.out.println("¡Vaya! Parece ser que no cumples los requisitos para el pase especial de fin de semana D:");
    }

    if (nombre != "Jose" && nombre != "jose"){                          // Siempre imprime "Tu nombre es diferente de Jose.", aunque el nombre sea "Jose" o "jose". Supuestamente porque para comparar Strings en Java no se usa "!=" sino el método .equals(), pero como no lo hemos dado en clase no pueod usarlo.
        System.out.println("Tu nombre es diferente de Jose.");
    }

    /*Si usara .equals() (pero sin utilizar ignoreCase)sería así:
     * if (!nombre.equals("Jose") && !nombre.equals("jose")){
     *    System.out.println("Tu nombre es diferente de Jose.");
     *  }
     */
    System.out.println("\n ¿Qué quieres hacer? Introduce el número acorde a tu opción. \n 1) Ver información de precios. \n 2) Ver atracciones disponibles \n 3) Salir del programa.");

    int menu1 = scanner.nextInt();

    while (menu1 != 3){

        if (menu1 == 1) {
            System.out.println("\n Nuestros precios varían según la edad. Los precios estándar individuales son: \n A) Mayor de edad → 15€ \n B) Menor de edad → 7€ \n C) Mayor de 50 años o estudiante → 10€ \n Si usted tiene un pase especial de fin de semana, se aplicará un descuento de 2€");

        } else if (menu1 == 2) {
            System.out.println("\n Nuestras atracciones disponibles actualmente son: \n El tio vivo \n La montaña alemana \n La casa desencantada. \n El ratón vacilado \n Para ver más atracciones, puede consultar el apartado 'Atracciones' en nuestra web");

        } else if (menu1 == 3) {
            System.out.println(" Adiós :D");
        }
        else {
            System.out.println("\n Número no válido");
        }

        System.out.println("\n ¿Qué quieres hacer? Introduce el número acorde a tu opción. \n 1) Ver información de precios. \n 2) Ver atracciones disponibles \n 3) Salir del programa.");

        menu1 = scanner.nextInt();
    }

    scanner.close();
    }
    
}
