import java.util.Scanner;

public class Act12_Extra_PiedraPapelTijeraJA {
        public static void main(String[] args) {
        // Los Enunciados de este ejercicio son bastante largos, por lo que en el examen entrarán enunciados un poco mas cortos.

        // 1. Piedra, Papel o Tijera: Simula el juego “Piedra, Papel o Tijera” entre dos usuarios. Un usuario elige 1=Piedra, 2=Papel, 3=Tijera. El usuario 2 elige. Usa condicionales para determinar el ganador y muestra un mensaje. Permite repetir varias rondas.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Juego: Piedra papel o tijeras");

        System.out.println (" Jugador 1, elige: 1 = Piedra, 2 = Papel, 3 = Tijeras. Ingrese 0 para salir.");

        int jugador1 = scanner.nextInt();

        System.out.println (" Jugador 2, elige: 1 = Piedra, 2 = Papel, 3 = Tijeras");

        int jugador2 = scanner.nextInt();

        while (jugador1 != 0 || jugador2 !=0) {

            if (jugador1==jugador2) {
                System.out.println("¡Empate!\n");
            } else if ((jugador1==1 && jugador2==3) || (jugador1==2 && jugador2==1) || (jugador1==3 && jugador2==2)) {
                System.out.println("¡Jugador 1 gana!\n");
            } else {
                System.out.println("¡Jugador 2 gana!\n");
            }

            System.out.println (" Jugador 1, elige: 1 = Piedra, 2 = Papel, 3 = Tijeras. Ingrese 0 para salir.");

            jugador1 = scanner.nextInt();

            System.out.println (" Jugador 2, elige: 1 = Piedra, 2 = Papel, 3 = Tijeras");

            jugador2 = scanner.nextInt();
        }



        scanner.close();

        // Si quisiera dar la opción de jugar contra la máquina (1 jugador) o contra otro usuario(dos jugadores, tal y como ya he hecho), ¿como sería?
        // Para que la máquina elija un número aleatorio entre 1 y 3, ¿qué función debería usar? 
        // Debería ser un Math.random() adaptado a ese rango.
    }
    
}
