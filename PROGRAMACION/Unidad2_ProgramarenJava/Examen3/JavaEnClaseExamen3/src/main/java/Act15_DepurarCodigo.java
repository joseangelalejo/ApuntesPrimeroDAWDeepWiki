import java.util.Scanner;

public class Act15_DepurarCodigo {
    public static void main(String[] args) {
        @SuppressWarnings("resource")   // Trozo de código para evitar warning por no cerrar el Scanner en VSCode
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        double saldo = 100.0; 
        String nombreCuenta = "Sin nombre"; 
        do {
            System.out.println("\n--- MENÚ BANCO ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Depositar porcentaje del saldo");
            System.out.println("5. Cambiar nombre de la cuenta");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();  // asumiendo entrada válida
            
            switch (opcion) {
                case 1:
                    System.out.println("Cuenta de: " + nombreCuenta);
                    System.out.println("Saldo actual: " + saldo + " €");
                    break;
                case 2:
                    System.out.print("Introduce cuánto quieres depositar: ");
                    int deposito = sc.nextInt(); 
                    saldo = saldo + deposito / 100;
                    System.out.println("Depósito realizado. Nuevo saldo: " + saldo + " €");
                    break;
                case 3:
                    System.out.print("Introduce cuánto quieres retirar: ");
                    double retirar = sc.nextDouble();
                    if (retirar > saldo)
                        System.out.println("Saldo insuficiente.");
                    else {
                        saldo = saldo - retirar;
                        System.out.println("Retiro realizado. Nuevo saldo: " + saldo + " €");
                    }
                    break;
                case 4:
                    System.out.print("Porcentaje a depositar del saldo actual: ");
                    int porcentaje = sc.nextInt();
                    double monto = saldo * porcentaje / 100;
                    saldo = saldo + monto;
                    System.out.println("Has depositado " + monto + " €. Nuevo saldo: " + saldo + " €");
                    break;
                case 5:
                    System.out.print("Introduce tu nombre: ");
                    String nombre = sc.nextLine(); 
                    nombreCuenta = nombre;
                    System.out.println("Nombre actualizado a: " + nombreCuenta);
                    break;
                case 6:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion < 6);

        // Mensaje final al salir mostrando nombre y saldo
        System.out.println("\n--- RESUMEN DE CUENTA ---");
        System.out.println("Nombre del usuario: " + nombreCuenta);
        System.out.println("Saldo final: " + saldo + " €");
        System.out.println("aa");
    }
}
