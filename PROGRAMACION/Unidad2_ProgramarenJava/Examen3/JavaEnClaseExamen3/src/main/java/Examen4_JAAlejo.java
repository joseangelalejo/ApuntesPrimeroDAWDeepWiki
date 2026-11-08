import java.util.Scanner;
public class Examen4_JAAlejo {
    public static void main(String[] args) {
        // Pedir clave de acceso (defecto entero)
            // Si falla 3 veces, se cierra el programa.
        // Si consigue entrar:
            // Mostrar menu con 4 opciones:
                // 1. Añadir venta.
                    // Se pide coste del producto y se suma al total.
                    // Se saca por pantalla el resultado.
                // 2. Devolver producto.
                    // Pedir coste del producto.
                    // Se comprueba si es menor o igual que el total.
                        // Si es menor o igual, restamos al total el coste del producto.
                        // Si es mayor, mostrar "Total insuficiente"
                // 3. Ver total.
                    // Se muestra el resultado total con dos decimales.
                // 4. Salir y pagar.
                    // Pedir nombre al usuario y se mostrará el total de la cuenta con dos decimales en un mensaje:
                    // "El total es [total] €. Gracias por su compra [nombre]"
        // Mostrar menú nuevamente tras cada opción.
        // Si la opción es 4, mostrar "El total es X. Gracias por su compra" y salir del programa.
        // Agregar default para opción no valida.
        Scanner scanner1 = new Scanner(System.in); 
        System.out.println("Bienvenido a la aplicación de caja registradora");
        final int clavedefecto = 12345; // Clave por defecto. Es un entero constante. La clave es 12345
        System.out.println("Introduzca su clave de acceso");
        int clave = scanner1.nextInt();
        int intentos = 3;
        if (clave != clavedefecto && intentos>0) {
            while (clave != clavedefecto && intentos>0) {
                intentos--;
                System.out.println ("Clave incorrecta, le quedan " + intentos + " intentos.");
                clave = scanner1.nextInt();
                if (intentos == 0) {
                    System.out.println("Sistema bloqueado.");
                }
            }
        } else {
            System.out.println("Por favor, elija una opción: \n1) Añadir venta\n2) Devolver producto\n3) Ver total\n4) Salir y pagar");
            int opcion = scanner1.nextInt();
            float añadir = 0;
            int costeproducto = 0;
            float devolver = 0;
            String usuario = "Usuario";
            while (opcion>0 && opcion<=4){
                float costeTotal = añadir - devolver;
                devolver = costeTotal-costeproducto;
                switch (opcion) {
                    case 1 -> { // Añadir venta
                    System.out.println("Introduzca el coste de su producto");
                    costeproducto = scanner1.nextInt();
                    añadir = costeproducto + costeTotal;
                    System.out.println("Su cuenta tiene un total de " + añadir);
                    }
                    case 2 -> { // Devolver producto
                        System.out.println("Introduzca el coste de su producto");
                        costeproducto = scanner1.nextInt();
                        if (costeproducto <= costeTotal) {
                            System.out.println(devolver);
                        } else{
                            System.out.println("Total insuficiente");
                        }
                    }
                    case 3 -> { // Ver total
                        System.out.printf("El total es de %.2f euros", costeTotal);
                    }
                    case 4 -> { // Salir y pagar
                        scanner1.nextLine(); // Para manejar errores de lectura de Int y enteros
                        System.out.println("Introduzca su nombre");
                        usuario = scanner1.nextLine();  // Scanner para asignar a usuario el nombre que se ha introducido
                        System.out.printf("\n El total es %.2f euros. Gracias por su compra %s", costeTotal, usuario);
                    }
                    default -> {
                        System.out.println("Opción no válida");
                    }
                }   // Cierre switch
                System.out.println("\nPor favor, elija una opción: \n1) Añadir venta\n2) Devolver producto\n3) Ver total\n4) Salir y pagar");
                opcion = scanner1.nextInt();
            }   // Cierre while
        }   // Cierre if-else
        scanner1.close();
    }
}
