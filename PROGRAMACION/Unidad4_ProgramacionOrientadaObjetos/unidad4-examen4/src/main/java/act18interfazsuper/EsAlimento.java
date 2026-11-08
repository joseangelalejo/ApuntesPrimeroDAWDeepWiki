package act18interfazsuper;

import java.time.LocalDate;
// LocalDate obtiene la fecha actual del sistema

public interface EsAlimento {
    // Métodos específicos para productos alimenticios
    LocalDate getCaducidad();
    boolean esCaducado();
}
