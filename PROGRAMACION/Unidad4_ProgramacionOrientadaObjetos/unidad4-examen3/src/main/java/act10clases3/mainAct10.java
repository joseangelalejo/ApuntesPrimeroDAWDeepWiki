package act10clases3;

public class mainAct10 {
    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Lionel Messi", 36, "Delantero", 10, false, 0, "PSG", 700);
        Entrenador entrenador1 = new Entrenador("Pep Guardiola", 52, "Manchester City");
        entrenador1.setJugador(jugador1);

        System.out.println(); // Línea en blanco para agregar separación
        entrenador1.mostrarInfo();
        System.out.println();
        jugador1.mostrarInfo();
        System.out.println();
        System.out.println(); // Línea en blanco para agregar separació
        jugador1.jugarPartido();
        jugador1.recibirAmarilla();
        jugador1.recibirAmarilla();
        jugador1.jugarPartido(); // ahora no puede jugar
        jugador1.informarLesion(20);
        jugador1.jugarPartido(); // sigue sin poder
        jugador1.recibirRoja(); // tarjeta roja adicional
        
        System.out.println();   // Línea en blanco para agregar separación
        System.out.println("El entrenador " + entrenador1.getNombre() + " entrena a " +
                        (entrenador1.getJugador() != null ? entrenador1.getJugador().getNombre() : "nadie"));
        jugador1.mostrarInfo();
    }

}
