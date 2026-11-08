import java.util.*;

public class ProcesadorTareas {
    private PriorityQueue<Tarea> tareasPendientes;
    private List<Tarea> tareasCompletadas;
    private int contadorId;

    public ProcesadorTareas() {
        tareasPendientes = new PriorityQueue<>();
        tareasCompletadas = new ArrayList<>();
        contadorId = 1;
    }

    public void agregarTarea(String titulo, String descripcion, int prioridad) {
        Tarea tarea = new Tarea(contadorId++, titulo, descripcion, prioridad);
        tareasPendientes.add(tarea);
        System.out.println("✓ Tarea agregada: " + tarea);
    }

    public void procesarTareas() {
        if (tareasPendientes.isEmpty()) {
            System.out.println("⚠ No hay tareas pendientes.");
        } else {
            Tarea tarea = tareasPendientes.poll();
            tareasCompletadas.add(tarea);
            System.out.println("✓ Tarea procesada: " + tarea);
        }
    }

    public void procesarTodasLasTareas() {
        if (tareasPendientes.isEmpty()) {
            System.out.println("⚠ No hay tareas pendientes.");
        } else {
            System.out.println("Procesando todas las tareas...");
            while (!tareasPendientes.isEmpty()) {
                Tarea tarea = tareasPendientes.poll();
                tareasCompletadas.add(tarea);
                System.out.println("  → " + tarea);
            }
            System.out.println("✓ Todas las tareas han sido procesadas.");
        }
    }

    public void imprimirColaPendientes() {
        if (tareasPendientes.isEmpty()) {
            System.out.println("✓ Cola de pendientes vacía.");
        } else {
            System.out.println("\n📋 TAREAS PENDIENTES:");
            int posicion = 1;
            for (Tarea tarea : tareasPendientes) {
                System.out.println(posicion + ". " + tarea);
                posicion++;
            }
        }
    }

    public void imprimirColaCompletadas() {
        if (tareasCompletadas.isEmpty()) {
            System.out.println("✓ Sin tareas completadas.");
        } else {
            System.out.println("\n✅ TAREAS COMPLETADAS:");
            int posicion = 1;
            for (Tarea tarea : tareasCompletadas) {
                System.out.println(posicion + ". " + tarea);
                posicion++;
            }
        }
    }

    public static void main(String[] args) {
        ProcesadorTareas procesador = new ProcesadorTareas();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== PROCESADOR DE TAREAS =====");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Procesar siguiente tarea");
            System.out.println("3. Procesar todas las tareas");
            System.out.println("4. Ver tareas pendientes");
            System.out.println("5. Ver tareas completadas");
            System.out.println("6. Salir");
            System.out.print("Seleccione opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Prioridad (1=Alta, 2=Media, 3=Baja): ");
                    int prioridad = scanner.nextInt();
                    if (prioridad >= 1 && prioridad <= 3) {
                        procesador.agregarTarea(titulo, descripcion, prioridad);
                    } else {
                        System.out.println("⚠ Prioridad no válida.");
                    }
                    break;
                case 2:
                    procesador.procesarTareas();
                    break;
                case 3:
                    procesador.procesarTodasLasTareas();
                    break;
                case 4:
                    procesador.imprimirColaPendientes();
                    break;
                case 5:
                    procesador.imprimirColaCompletadas();
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