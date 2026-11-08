import java.util.Scanner;
public class Act16_AplicacionCompleta {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);  // Apertura del scanner (scanner1)
        final int codigodefecto = 12345;    // He agreado "final" para definir que la variable entera codigodefecto es constante
        int intentos = 3;
        System.out.println("Bienvenido a la plataforma interactiva de Fitness+.");
        int codigoacceso;
        boolean accesoConcedido;
        
        // WHILE para controlar acceso
        do {
            System.out.println("Por favor, introduzca su código de acceso: ");
            codigoacceso = scanner1.nextInt();
            accesoConcedido = (codigoacceso == codigodefecto);
            if (!accesoConcedido) {
                intentos--;
                System.out.println("Código incorrecto, le quedan: " + intentos + " intentos");
            }
        } while (!accesoConcedido && intentos>0);  // Cierre WHILE
        // IF para que el programa se ejecute sólo si se ha concedido acceso
        if (intentos==0 && !accesoConcedido) {  // No se ejecutará
        System.out.println("Acceso denegado. Contacte con administración.");
        } else {  // El programa sí se ejecutará
            int opcion = 0;
            float puntos1 = 0;
            float puntosTotales = 0;
            String nombreusuario = "Usuario por defecto";
            while (opcion!=4) {
                System.out.println("\nMENU PRINCIPAL \n Introduzca el número que corresponde a la opción. \n 1) Registrar actividad realizada.\n 2) Consultar puntos acumulados.\n 3) Cambiar nombre del socio.\n 4) Salir");
                opcion = scanner1.nextInt();
                switch (opcion) {
                    case 1 -> {
                        scanner1.nextLine();
                        System.out.println("Introduzca el nombre de la actividad realizada: ");
                        String actividadrealizada = scanner1.nextLine();
                        System.out.println("Introduzca la cantidad de minutos realizados");
                        int minutos = scanner1.nextInt();
                        // puntos 1 = (float)(minutos*2.5); | Es innecesario, sustituyo por -> puntos1 = minutos*2.5f
                        puntos1 = minutos*2.5f;
                        puntosTotales += puntos1;
                        System.out.printf("\nActividad registrada: %s. Ha ganado %.1f puntos. Puntos totales: %.1f puntos.\n", actividadrealizada, puntos1, puntosTotales);
                    } case 2 -> {
                        System.out.printf("\nEstimado %s , sus puntos acumulados son: %.1f \n", nombreusuario, puntosTotales);
                    } case 3 -> {
                        scanner1.nextLine();
                        System.out.println("Introduzca su nuevo nombre de usuario: ");
                        nombreusuario = scanner1.nextLine();
                        System.out.println("\nNombre actualizado correctamente");
                    } case 4 -> {
                        System.out.println(nombreusuario + " gracias por utilizar Fitness+. ¡Hasta pronto!");
                    } default -> {
                        System.out.println("Opcion no válida");
                    }   
                }   // Cierre SWITCH
            }   // Cierre WHILE
        }   // Cierre IF
        scanner1.close();   // Cierre del scanner antes de finalizar el programa.
    }
}