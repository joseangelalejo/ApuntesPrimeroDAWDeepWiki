import java.util.Scanner;                   // Importo el util Scanner para usarlo en el programa

public class ED_EstructuraIFPruebas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);       // Declaramos que la Estructura Scanner será invocada con el nombre "scanner"

        System.out.println("Ingrese su edad: ");        // Pedimos la entrada del dato al usuario
        int edad = scanner.nextInt();                       // Declaramos el scanner como un int (tipo de dato que leeremos) llamado edad y le asignamos scanner.nextInt (nextInt indica que esperaremos a que el dato introducido sea un Integer/Entero)

        if (edad >= 18) {                                   // Utilizamos para la condición de IF, la variable INT edad (que tomará el valor que introduzcamos en el scanner)
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }
        
        scanner.close();
    }
}
