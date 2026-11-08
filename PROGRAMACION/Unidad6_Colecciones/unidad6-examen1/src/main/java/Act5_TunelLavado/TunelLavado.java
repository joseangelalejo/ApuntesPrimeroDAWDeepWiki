import java.util.*;

public class TunelLavado {
    private Deque<Vehiculo> cola;

    public TunelLavado() {
        cola = new LinkedList<>();
    }

    public void registrarVehiculo(String matricula, String marca, String modelo, boolean premium) {
        Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, premium);
        
        if (premium) {
            cola.addFirst(vehiculo);
            System.out.println("✓ Vehículo Premium registrado al principio de la cola.");
        } else {
            cola.addLast(vehiculo);
            System.out.println("✓ Vehículo registrado al final de la cola.");
        }
    }

    public void lavarSiguiente() {
        if (cola.isEmpty()) {
            System.out.println("⚠ No hay vehículos en espera.");
        } else {
            Vehiculo vehiculo = cola.removeFirst();
            System.out.println("🚗 Lavando: " + vehiculo);
        }
    }

    public void mostrarSiguiente() {
        if (cola.isEmpty()) {
            System.out.println("⚠ No hay vehículos en espera.");
        } else {
            System.out.println("→ Siguiente a lavar: " + cola.getFirst());
        }
    }

    public void mostrarTodos() {
        if (cola.isEmpty()) {
            System.out.println("⚠ La cola está vacía.");
        } else {
            System.out.println("📋 Cola completa:");
            int posicion = 1;
            for (Vehiculo v : cola) {
                System.out.println(posicion + ". " + v);
                posicion++;
            }
        }
    }

    public void mostrarUltimo() {
        if (cola.isEmpty()) {
            System.out.println("⚠ No hay vehículos en espera.");
        } else {
            System.out.println("↓ Último en ser lavado: " + cola.getLast());
        }
    }

    public static void main(String[] args) {
        TunelLavado tunel = new TunelLavado();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== TÚNEL DE LAVADO =====");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Lavar siguiente vehículo");
            System.out.println("3. Mostrar siguiente vehículo");
            System.out.println("4. Mostrar todos los vehículos en espera");
            System.out.println("5. Mostrar último vehículo de la cola");
            System.out.println("6. Salir");
            System.out.print("Seleccione opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Matrícula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("¿Es Premium? (S/N): ");
                    boolean premium = scanner.nextLine().toUpperCase().equals("S");
                    tunel.registrarVehiculo(matricula, marca, modelo, premium);
                    break;
                case 2:
                    tunel.lavarSiguiente();
                    break;
                case 3:
                    tunel.mostrarSiguiente();
                    break;
                case 4:
                    tunel.mostrarTodos();
                    break;
                case 5:
                    tunel.mostrarUltimo();
                    break;
                case 6:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("⚠ Opción no válida.");
            }
        }
        scanner.close();
    }
}