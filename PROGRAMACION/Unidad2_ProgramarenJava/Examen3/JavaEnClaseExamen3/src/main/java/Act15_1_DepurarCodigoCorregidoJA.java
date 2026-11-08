import java.util.Scanner;

public class Act15_1_DepurarCodigoCorregidoJA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        double saldo = 100.0; 
        String nombreCuenta = "Sin nombre";
        String nombreCliente = "Cliente 1";
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
                    System.out.println("Cuenta de: " + nombreCliente);
                    System.out.println("Nombre de la cuenta: " + nombreCuenta);
                    System.out.println("Saldo actual: " + saldo + " €");
                    break;
                case 2:
                    // System.out.println("Saldo actual: " + saldo + " €");
                    System.out.print("Introduce cuánto quieres depositar: ");
                    int deposito = sc.nextInt();
                    saldo = saldo + deposito;
                    System.out.println("Depósito realizado. Nuevo saldo: " + saldo + " €");
                    break;
                case 3:
                    // System.out.println("Saldo actual: " + saldo + " €");
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
                    // System.out.println("Saldo actual: " + saldo + " €");
                    System.out.print("Porcentaje a depositar del saldo actual: ");
                    int porcentaje = sc.nextInt();
                    double monto = saldo * porcentaje / 100;
                    saldo = saldo + monto;
                    System.out.println("Has depositado " + monto + " €. Nuevo saldo: " + saldo + " €");
                    break;
                case 5:
                    sc.nextLine(); // Consumir el salto de línea pendiente
                    System.out.println("Nombre actual de la cuenta: " + nombreCuenta);
                    System.out.print("Introduce el nuevo nombre de la cuenta: ");
                    nombreCuenta = sc.nextLine();
                    System.out.println("Nombre actualizado a: " + nombreCuenta);
                    break;
                case 6:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion < 6 && opcion > 0);
        // Mensaje final al salir mostrando nombre y saldo
        System.out.println("\n--- RESUMEN DE CUENTA ---");
        System.out.println("Nombre del usuario: " + nombreCliente);
        System.out.println("Nombre de la cuenta: " + nombreCuenta);
        System.out.println("Saldo final: " + saldo + " €");
        sc.close();
    }
}