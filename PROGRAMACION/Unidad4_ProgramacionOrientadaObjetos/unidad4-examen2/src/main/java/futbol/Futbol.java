package futbol;

import contenedorClases.Equipo;
import contenedorClases.Jugador;

public class Futbol {
    public static void main(String[] args) {
        // Crear equipo
        Equipo equipo1 = new Equipo("Alcorcon");
        // Crear jugador
        Jugador j1 = new Jugador("Pepe", "15", "centrocampista");
        Jugador j2 = new Jugador("Juan", "8", "portero");
        // Equipo Alcorcon contrata al jugador 1 
        if (equipo1.fichar(j1)) {
            System.out.println(j1.nombre + " Fichado con éxito por " + equipo1.nombre);
        }
        // Esto no es importante por ahora
        /* Se pueden crear instancias de objetos dentro de los parámetros del método, pero no es recomendable, porque no se puede reutilizar esa instancia, y si queremos hacer algo con ese jugador después de ficharlo, no podremos, porque no tenemos una referencia a ese objeto, ya que no lo hemos almacenado en una variable, sino que lo hemos creado directamente dentro del método fichar. Por eso es mejor crear la instancia del jugador antes, almacenarla en una variable, y luego pasar esa variable como parámetro al método fichar.
            if (equipo1.fichar(new Jugador("Pepe", "15", "centrocampista"))) {
                System.out.println(j1.nombre + " Fichado con éxito por " + equipo1.nombre);
            }
        Pero se presenta un problema, y es que si queremos hacer algo con ese jugador después de ficharlo, 
        no podremos, porque no tenemos una referencia a ese objeto, ya que no lo hemos almacenado en una variable, 
        sino que lo hemos creado directamente dentro del método fichar. Por eso es mejor crear la instancia del jugador antes, 
        almacenarla en una variable, y luego pasar esa variable como parámetro al método fichar.

        Además, no podriamos usar un for tradicional, tendríamos que usar un for each, pero el for each no nos 
        permite modificar el array, sino que solo nos permite leerlo, y en este caso, necesitamos modificarlo 
        para almacenar el jugador fichado en la posición del array que corresponda. Por eso es mejor crear la instancia 
        del jugador antes, almacenarla en una variable, y luego pasar esa variable como parámetro al método fichar.
        Quedaría algo así:
        for (Jugador jugador : jugadores) {
            if (jugador == null) {
                jugador = new Jugador("Pepe", "15", "centrocampista");
                return true;
            }
        }
        */
        // El jugador 1 ha metido un gol
        j1.marcarGol();
        System.out.print("");
        // El jugador 2 ha metido varios goles
        j2.marcarGol(3);
        System.out.print("");
    }
}