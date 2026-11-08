package Act3_ColeccionLista_banco;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase BancoApp - Aplicación principal del banco con login y gestión de cuentas
 */
public class BancoApp {
    private ArrayList<Cliente> clientes;
    private Scanner scanner;
    private Cliente clienteActual;

    // Constructor
    public BancoApp() {
        this.clientes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.clienteActual = null;
        inicializarClientesEjemplo();
    }

    // Inicializar con clientes de ejemplo
    private void inicializarClientesEjemplo() {
        Cliente cliente1 = new Cliente("Juan", "García López", 1001);
        cliente1.agregarCuenta(new Cuenta("ES1234567890", 1500.00));
        cliente1.agregarCuenta(new Cuenta("ES1234567891", 500.00));

        Cliente cliente2 = new Cliente("María", "Rodríguez Martín", 1002);
        cliente2.agregarCuenta(new Cuenta("ES1234567892", 2000.00));

        clientes.add(cliente1);
        clientes.add(cliente2);
        System.out.println("✓ Sistema inicializado con 2 clientes de ejemplo.\n");
    }

    // Menú de login
    public void mostrarMenuLogin() {
        int opcion;
        do {
            System.out.println("\n========== BANCO - LOGIN ==========");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Crear nuevo cliente");
            System.out.println("3. Salir del programa");
            System.out.print("Elige una opción (1-3): ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        iniciarSesion();
                        if (clienteActual != null) {
                            mostrarMenuCliente();
                        }
                        break;
                    case 2:
                        crearNuevoCliente();
                        break;
                    case 3:
                        System.out.println("\n¡Hasta luego!");
                        opcion = 3;
                        break;
                    default:
                        System.out.println("✗ Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("✗ Error: Introduce un número válido.");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 3);
    }

    // Iniciar sesión
    private void iniciarSesion() {
        System.out.println("\n--- Iniciar sesión ---");
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Introduce tu código de cliente: ");
        try {
            int codigo = scanner.nextInt();
            scanner.nextLine();

            for (Cliente cliente : clientes) {
                if (cliente.getNombre().equalsIgnoreCase(nombre) && 
                    cliente.getCodigoCliente() == codigo) {
                    clienteActual = cliente;
                    System.out.println("\n✓ Bienvenido, " + cliente.getNombre() + "!");
                    return;
                }
            }

            System.out.println("✗ Cliente no encontrado. ¿Deseas crear uno nuevo? (S/N)");
            String respuesta = scanner.nextLine().trim().toUpperCase();
            if (respuesta.equals("S")) {
                crearNuevoClienteConDatos(nombre, codigo);
            }
        } catch (Exception e) {
            System.out.println("✗ Error: Introduce un código válido.");
            scanner.nextLine();
        }
    }

    // Crear nuevo cliente
    private void crearNuevoCliente() {
        System.out.println("\n--- Crear nuevo cliente ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine().trim();

        System.out.print("Código de cliente: ");
        try {
            int codigo = scanner.nextInt();
            scanner.nextLine();

            crearNuevoClienteConDatos(nombre, codigo);
            clienteActual = clientes.get(clientes.size() - 1);
            System.out.println("✓ Cliente creado. ¡Bienvenido, " + nombre + "!");
        } catch (Exception e) {
            System.out.println("✗ Error: Introduce un código válido.");
            scanner.nextLine();
        }
    }

    // Crear nuevo cliente con datos
    private void crearNuevoClienteConDatos(String nombre, int codigo) {
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine().trim();

        Cliente nuevoCliente = new Cliente(nombre, apellidos, codigo);
        clientes.add(nuevoCliente);
        clienteActual = nuevoCliente;
    }

    // Menú del cliente
    private void mostrarMenuCliente() {
        int opcion;
        do {
            System.out.println("\n========== MENÚ DEL CLIENTE ==========");
            System.out.println("Bienvenido: " + clienteActual.getNombre() + " " + clienteActual.getApellidos());
            System.out.println("1. Añadir cuenta");
            System.out.println("2. Borrar cuenta");
            System.out.println("3. Imprimir saldo");
            System.out.println("4. Meter/sacar dinero");
            System.out.println("5. Cerrar sesión");
            System.out.print("Elige una opción (1-5): ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        anadirCuenta();
                        break;
                    case 2:
                        borrarCuenta();
                        break;
                    case 3:
                        imprimirSaldo();
                        break;
                    case 4:
                        meteSacarDinero();
                        break;
                    case 5:
                        System.out.println("✓ Sesión cerrada.");
                        clienteActual = null;
                        opcion = 5;
                        break;
                    default:
                        System.out.println("✗ Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("✗ Error: Introduce un número válido.");
                scanner.nextLine();
                opcion = 0;
            }
        } while (opcion != 5 && clienteActual != null);
    }

    // Opción 1: Añadir cuenta
    private void anadirCuenta() {
        System.out.println("\n--- Añadir cuenta ---");
        String numeroCuenta = generarNumeroCuentaAutomatico();
        Cuenta nuevaCuenta = new Cuenta(numeroCuenta, 0.0);
        clienteActual.agregarCuenta(nuevaCuenta);
        System.out.println("✓ Cuenta creada: " + numeroCuenta + " con saldo 0€");
    }

    // Generar número de cuenta automático
    private String generarNumeroCuentaAutomatico() {
        int numCuentas = clienteActual.getCuentas().size() + 1;
        int baseNum = clienteActual.getCodigoCliente() * 100 + numCuentas;
        return "ES" + String.format("%014d", baseNum);
    }

    // Opción 2: Borrar cuenta
    private void borrarCuenta() {
        System.out.println("\n--- Borrar cuenta ---");
        if (clienteActual.getCuentas().isEmpty()) {
            System.out.println("✗ No tienes cuentas.");
            return;
        }

        mostrarCuentasCliente();
        System.out.print("Introduce el número de cuenta a borrar: ");
        String numeroCuenta = scanner.nextLine().trim();

        if (clienteActual.eliminarCuenta(numeroCuenta)) {
            System.out.println("✓ Cuenta borrada correctamente.");
        } else {
            System.out.println("✗ Cuenta no encontrada.");
        }
    }

    // Opción 3: Imprimir saldo
    private void imprimirSaldo() {
        System.out.println("\n--- Consultar saldo ---");
        if (clienteActual.getCuentas().isEmpty()) {
            System.out.println("✗ No tienes cuentas.");
            return;
        }

        mostrarCuentasCliente();
        System.out.print("Introduce el número de cuenta: ");
        String numeroCuenta = scanner.nextLine().trim();

        Cuenta cuenta = clienteActual.obtenerCuenta(numeroCuenta);
        if (cuenta != null) {
            System.out.println("✓ " + cuenta);
        } else {
            System.out.println("✗ Cuenta no encontrada.");
        }
    }

    // Opción 4: Meter/sacar dinero
    private void meteSacarDinero() {
        System.out.println("\n--- Operación de dinero ---");
        if (clienteActual.getCuentas().isEmpty()) {
            System.out.println("✗ No tienes cuentas.");
            return;
        }

        mostrarCuentasCliente();
        System.out.print("Introduce el número de cuenta: ");
        String numeroCuenta = scanner.nextLine().trim();

        Cuenta cuenta = clienteActual.obtenerCuenta(numeroCuenta);
        if (cuenta == null) {
            System.out.println("✗ Cuenta no encontrada.");
            return;
        }

        System.out.println("1. Ingresar dinero");
        System.out.println("2. Retirar dinero");
        System.out.print("Elige (1 o 2): ");

        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Cantidad: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine();

            if (opcion == 1) {
                cuenta.ingresarDinero(cantidad);
                System.out.println("✓ Dinero ingresado. Nuevo saldo: " + cuenta.getSaldo() + "€");
            } else if (opcion == 2) {
                if (cuenta.retirarDinero(cantidad)) {
                    System.out.println("✓ Dinero retirado. Nuevo saldo: " + cuenta.getSaldo() + "€");
                } else {
                    System.out.println("✗ Saldo insuficiente.");
                }
            } else {
                System.out.println("✗ Opción no válida.");
            }
        } catch (Exception e) {
            System.out.println("✗ Error: Introduce una cantidad válida.");
            scanner.nextLine();
        }
    }

    // Mostrar cuentas del cliente
    private void mostrarCuentasCliente() {
        if (clienteActual.getCuentas().isEmpty()) {
            System.out.println("No tienes cuentas.");
            return;
        }

        System.out.println("Tus cuentas:");
        for (Cuenta cuenta : clienteActual.getCuentas()) {
            System.out.println("  " + cuenta);
        }
    }

    // Método main
    public static void main(String[] args) {
        BancoApp banco = new BancoApp();
        banco.mostrarMenuLogin();
    }
}
