import java.util.Scanner;

public class Act12_Sentenciasdecontrol {
    public static void main(String[] args) {
        // Los Enunciados de este ejercicio son bastante largos, por lo que en el examen entrarán enunciados un poco mas cortos.

        // 1. Piedra, Papel o Tijera: Simula el juego “Piedra, Papel o Tijera” entre dos usuarios. Un usuario elige 1=Piedra, 2=Papel, 3=Tijera. El usuario 2 elige. Usa condicionales para determinar el ganador y muestra un mensaje. Permite repetir varias rondas.
        
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Juego: Piedra papel o tijeras");

        System.out.println (" Jugador 1, elige: 1 = Piedra, 2 = Papel, 3 = Tijeras. Ingrese 0 para salir.");

        int jugador1 = scanner1.nextInt();

        System.out.println (" Jugador 2, elige: 1 = Piedra, 2 = Papel, 3 = Tijeras");

        int jugador2 = scanner1.nextInt();

        while (jugador1 != 0 || jugador2 !=0) {

            if (jugador1==jugador2) {
                System.out.println("¡Empate!\n");
            } else if ((jugador1==1 && jugador2==3) || (jugador1==2 && jugador2==1) || (jugador1==3 && jugador2==2)) {
                System.out.println("¡Jugador 1 gana!\n");
            } else {
                System.out.println("¡Jugador 2 gana!\n");
            }

            System.out.println (" Jugador 1, elige: 1 = Piedra, 2 = Papel, 3 = Tijeras. Ingrese 0 para salir.");

            jugador1 = scanner1.nextInt();

            System.out.println (" Jugador 2, elige: 1 = Piedra, 2 = Papel, 3 = Tijeras");

            jugador2 = scanner1.nextInt();
        }

        scanner1.close();

        
        // Extra: Dar la opción al inicio de pelear contra la máquina o contra otro jugador. Si se elige pelear contra la máquina, se genera un número aleatorio entre 1 y 3 para la máquina. Si no, ejecutar el juego entre dos jugadores como he hecho arriba.
            // Además, permitir que el usuario elija salir en cualquier momento introduciendo un 0.
                // Nota: Introducir cero cuando ya estás en medio de una partida, hace que se salga de esa partida y vuelva al menú principal. Para salir del programa, hay que introducir 0 en el menú principal.
            // Además, la máquina tendrá un nombre gracioso, al ganar o perder, el programa mostrará un mensaje personalizado con el nombre de la máquina.
            // Se me ha ocurrido pedir el nombre del jugador 1 al inicio, para personalizar los mensajes. El nombre del jugador 2 se pedirá si se elige jugar contra otro jugador.
         
            Scanner scannerExtra1 = new Scanner(System.in);

            System.out.println("\nExtra: Pelear contra la máquina o contra otro jugador.\n");

            System.out.println("Introduce tú nombre:");
            String nombreJugador = scannerExtra1.nextLine();

            String nombreMaquina = "Maquina super inteligente 3000 V2";
            int jugadorMaquina;
            int jugadorExtra1;
            int jugadorExtra2;
            int eleccion;

            do {
                System.out.println("Elige tu oponente: 1 = Máquina, 2 = Otro jugador. Introduce 0 para salir. \n");

                eleccion = scannerExtra1.nextInt();
                scannerExtra1.nextLine(); // Limpiar el buffer, si no, al pedir el nombre del jugador 2, se salta la entrada.

                if (eleccion == 1) {
                    // Pelear contra la máquina
                    System.out.println("Has elegido pelear contra " + nombreMaquina + ". Introduce 0 para salir. \n");

                    do {

                    System.out.println("Jugador, elige: 1 = Piedra, 2 = Papel, 3 = Tijeras. \n");

                    jugadorExtra1 = scannerExtra1.nextInt();                    // Lee la elección del jugador humano.

                    jugadorMaquina = (int)(Math.random() * 3) + 1; // Generar número aleatorio entre 1 y 3

                    System.out.println(nombreMaquina + " ha elegido: " + jugadorMaquina + "\n");

                    if (jugadorExtra1 == 0) {
                        System.out.println("Saliendo del juego contra " + nombreMaquina + ". Volviendo al menú principal\n");
                    } else if (jugadorExtra1 == jugadorMaquina) {
                        System.out.println("¡Empate con " + nombreMaquina + "!\n");
                    } else if ((jugadorExtra1 == 1 && jugadorMaquina == 3) || (jugadorExtra1 == 2 && jugadorMaquina == 1) || (jugadorExtra1 == 3 && jugadorMaquina == 2)) {
                        System.out.println("¡Has ganado a " + nombreMaquina + "! ¡Felicidades!\n");
                    } else {
                        System.out.println("¡" + nombreMaquina + " te ha ganado! ¡Inténtalo de nuevo!\n");
                    }

                    } while (jugadorExtra1 != 0);

                } else if (eleccion == 2) { // Pelear contra otro jugador

                    System.out.println("Has elegido pelear contra otro jugador. Introduce el nombre del jugador 2:");
                    String nombreJugador2 = scannerExtra1.nextLine();

                    System.out.println("Si no quieres seguir jugando, introduce 0 para salir. \n");
                    
                    do {
                    System.out.println(" Jugador 1, elige: 1 = Piedra, 2 = Papel, 3 = Tijeras. \n");

                    jugadorExtra1 = scannerExtra1.nextInt();

                    System.out.println(" Jugador 2, elige: 1 = Piedra, 2 = Papel, 3 = Tijeras. \n");

                    jugadorExtra2 = scannerExtra1.nextInt();

                    if (jugadorExtra1 == 0 || jugadorExtra2 == 0) {
                        System.out.println("Volviendo al menú principal.. Adios ;D\n");
                    } else if (jugadorExtra1 == jugadorExtra2) {
                        System.out.println("¡Empate!\n");
                    } else if ((jugadorExtra1 == 1 && jugadorExtra2 == 3) || (jugadorExtra1 == 2 && jugadorExtra2 == 1) || (jugadorExtra1 == 3 && jugadorExtra2 == 2)) {
                        System.out.println("¡" + nombreJugador + " gana!\n");
                    } else {
                        System.out.println("¡" + nombreJugador2 + " gana!\n");
                    }
                    } while (jugadorExtra1 != 0 && jugadorExtra2 != 0);
                }

            } while (eleccion != 0);

            System.out.println("Saliendo del programa. Gracias por jugar ;D");

            scannerExtra1.close();
        
        // 2. Convertir un número de binario a decimal: El programa para pasar un número expresado en binario a decimal se basa en la forma tradicional de hacerlo. 
        // Los dígitos del número binario ocupan una posición que se numera de derecha a izquierda empezando por cero. 
        // La posición del dígito más a la derecha es la 0. Para pasar el número a decimal se multiplica cada dígito binario por 2 elevado a la posición que ocupa. 
        // La suma de todos los productos es el equivalente en decimal.
        // A tener en cuenta → Para hacer la elevación a potencia de (posición) utilizamos Math.pow(base, exponente);
         
        Scanner scanner2 = new Scanner(System.in);

        System.out.println("2: Pasar números de Sistema Binarios a Sistema Decimal\n");

        System.out.println("Introduce el número binario que quieres pasar a Decimal.");

        int binario = scanner2.nextInt();                       // Escaner del número binario, declarado como entero.
        int decimal = 0;                                        // Variable para almacenar el número decimal resultante.
        int posicion = 0;                                       // Variable para llevar la cuenta de la posición del dígito.
        int digito;                                             // Variable para almacenar el dígito actual.

        while (binario > 0) {                                   // Mientras queden dígitos en el número binario.
            digito = binario % 10;
            decimal += digito * Math.pow(2, posicion);       // Sumar a decimal su propio valor más el dígito por 2 elevado a la posición y luego incrementar la posición. Math.pow devuelve un double, pero al ser asignado a un int, se convierte automáticamente.
            binario /= 10;                                      // Eliminar el último dígito del número binario.         
            posicion++;
        }

        System.out.println("El número en decimal es: " + decimal + "\n");

        scanner2.close();

        
        // Extra: Seguir pidiendo números binarios hasta que el usuario decida salir.

        Scanner scannerExtra2 = new Scanner(System.in);     // Creo un scanner nuevo para este extra, así no interfiere con el scanner del ejercicio anterior, y no tengo que estar limpiando el buffer.

        System.out.println("Extra: Pasar números de Sistema Binarios a Sistema Decimal. Introduce la letra `s` para salir. \n");

        String entrada;
        do {
            System.out.println("Introduce el número binario que quieres pasar a Decimal. Para salir, introduce 's'. \n");

            entrada = scannerExtra2.nextLine();

            if (!entrada.equalsIgnoreCase("s")) {                       // Si la entrada no es 's', procesar el número binario. Si la es 's', pasamos al else
                int binarioExtra = Integer.parseInt(entrada);                         // Conversión tipo  la entrada a un número entero.
                int decimalExtra = 0;
                int posicionExtra = 0;
                int digitoExtra;

                while (binarioExtra > 0) {                                           // Mientras queden dígitos en el número binario. (porque cuando el resultado sea 0, ya no quedarán dígitos)
                    digitoExtra = binarioExtra % 10;
                    decimalExtra += digitoExtra * Math.pow(2, posicionExtra);     // Sumar a decimal su propio valor más el dígito por 2 elevado a la posición y luego se incrementa la posición. El Math.pow devuelve un double, pero al ser asignado a un int, se convierte automáticamente.
                    binarioExtra /= 10;                                             // Eliminar el último dígito del número binario.
                    posicionExtra++;
                }

                System.out.println("El número en decimal es: " + decimalExtra + "\n");
            } else {                                                                // Si la entrada es S, mostramos mensaje de salida y salimos del bucle.
                System.out.println("Saliendo del programa. Adios ;D");
            }

        } while (!entrada.equalsIgnoreCase("s"));                    // Utilizo do-while para asegurar que el bucle se ejecuta al menos una vez.

        scannerExtra2.close();
        
        /*
         * Hay un "problema", y es que si el usuario introduce para salir una letra s seguida de números o más letras, el programa lanzará un error y no imprimirá el mensaje de salida.
         * Una de las formas de solucionarlo que se me ocurre es cambiar la condición del if y la del do_while, de la siguiente manera:
         *  if (!(entrada.length() > 0 && entrada.toLowerCase().charAt(0) == 's')) {
         *      En este if, utilizamos length() para comprobar que la entrada tiene al menos un carácter, y charAt(0) para obtener el primer carácter de la entrada y compararlo con 's' ignorando mayúsculas.
         *      Además, con el .toLowerCase() convertimos el carácter a minúscula para hacer la comparación sin importar si el usuario introduce 'S' mayúscula o 's' minúscula.
         * 
         *  do {
         *    ...
         *  }while (!(entrada.length() > 0 && entrada.toLowerCase().charAt(0) == 's'));
         *      En la condición del do_while, hacemos lo mismo que en el if, para asegurarnos de que el bucle continúa hasta que el usuario introduzca una entrada que comience con 's' o 'S'.
         *  El resto del código dentro del if y del do_while sería igual que como lo tenemos entre las líneas 74 y 105.
         */

        // 3. Comprobar si dos números son amigos: Dos números enteros positivos A y B son números amigos si la suma de los divisores propios de A es igual a B y la suma de los divisores propios de B es igual a A. Los divisores propios de un número incluyen la unidad pero no el propio número. Un ejemplo de números amigos son los números 220 y 284. Los divisores propios de 220 son 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 y 110. La suma de los divisores propios de 220 da como resultado 284. Los divisores propios de 284 son 1, 2, 4, 71 y 142. La suma de los divisores propios de 284 da como resultado 220.Por lo tanto 220 y 284 son amigos. 
        // Otras parejas de números amigos son: 1184 y 1210, 2620 y 2924, 5020 y 5564, 6232 y 6367, 10744 y 10856, 12285 y 14595, 17296 y 18416.
        
        Scanner scanner3 = new Scanner(System.in);
        String respuesta;
        
            System.out.println("¿Quieres comprobar si dos números son amigos? (s/n)");
            respuesta = scanner3.next();

            // Con el primer if, comprobamos si la respuesta del usuario es 's' o 'S', para proceder a pedir los números y comprobar si son amigos.
            if (respuesta.equalsIgnoreCase("s")) {          // Con la función equalsIgnoreCase, comparamos la respuesta del usuario con 's' ignorando mayúsculas y minúsculas.
                int num1 = 1, num2 = 1; // Inicializar para entrar al bucle
                do {
                    System.out.println("\n Introduce el primer número: ");      
                    num1 = scanner3.nextInt();
                    System.out.println("\n Introduce el segundo número: ");
                    num2 = scanner3.nextInt();

                    if (num1 == 0 || num2 == 0) {
                        System.out.println("\n Saliendo de la comprobación de números amigos.");
                        break;
                    }

                    // Aquí comprobamos si los números son amigos.
                    int sumaDivA = 0;
                    for (int i = 1; i < num1; i++) {            // Bucle para encontrar los divisores propios de num1 y sumarlos.
                        if (num1 % i == 0) {                // Si i es un divisor propio de num1
                            sumaDivA += i;                  // Sumamos i a la suma de los divisores propios de num1.
                        }
                    }
                    int sumaDivB = 0;

                    for (int i = 1; i < num2; i++) {            // Bucle para encontrar los divisores propios de num2 y sumarlos.
                        if (num2 % i == 0) {                    // Si i es un divisor propio de num2
                            sumaDivB += i;                      // Sumamos i a la suma de los divisores propios de num2.
                        }
                    }
                    if (sumaDivA == num2 && sumaDivB == num1) {     // Comprobamos si la suma de los divisores propios de num1 es igual a num2 y viceversa.
                        System.out.println( "\n" + num1 + " y " + num2 + " son números amigos.");
                    } else {
                        System.out.println("\n" + num1 + " y " + num2 + " no son números amigos.");
                    }
                    System.out.println("\n Recuerda, para salir introduce 0.");
                } while (num1 != 0 && num2 != 0);
            }
        
        scanner3.close();
    }
    
}