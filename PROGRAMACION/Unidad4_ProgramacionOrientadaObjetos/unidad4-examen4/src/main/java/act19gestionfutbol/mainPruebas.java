package act19gestionfutbol;

public class mainPruebas {
    public static void main(String[] args) {
        // Instancias de jugadores de cada tipo
        System.out.println();
        Jugador delantero = new Delantero("Messi", 36, 10, 15);
        Jugador delantero2 = new Delantero("Mbappé", 25, 7, 12);
        Jugador defensa = new Defensa("Piqué", 35, 3, 8);
        Jugador defensa2 = new Defensa("Ramos", 38, 4, 9);
        Jugador portero = new Portero("Ter Stegen", 32, 1, 12);
        Jugador portero2 = new Portero("Courtois", 31, 1, 14);
        // Crear equipo y asignar jugadores
        System.out.println("\n --====-- \nCreando equipo y asignando jugadores...");
        Equipo equipo = new Equipo("FC Barcelona");
        equipo.agregarJugador(delantero, 1);
        equipo.agregarJugador(delantero2, 2);
        equipo.agregarJugador(defensa, 3);
        equipo.agregarJugador(defensa2, 4);
        equipo.agregarJugador(portero, 5);
        equipo.agregarJugador(portero2, 6);
        // Mostrar datos del equipo
        System.out.println("\n --=====-- \nDatos del equipo:");
        equipo.mostrarDatosEquipo();
        // Generar informe
        System.out.println("\n --=======-- \nInforme del equipo:");
        System.out.println(equipo.generarInformeEquipo());

    }
}
