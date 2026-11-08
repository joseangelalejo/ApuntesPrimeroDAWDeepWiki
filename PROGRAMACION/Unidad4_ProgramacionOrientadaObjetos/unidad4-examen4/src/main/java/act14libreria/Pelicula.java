package act14libreria;

import java.time.LocalDate;

public class Pelicula extends Publicacion {
    // ATRIBUTOS
    private int edadMinima;

    // CONSTRUCTOR PRINCIPAL
    public Pelicula(String titulo, String autor, LocalDate anioPublicacion, Cliente clientePrestado, int edadMinima) {
        super(titulo, autor, anioPublicacion, clientePrestado);
        setEdadMinima(edadMinima);
    }

    // GETTERS Y SETTERS
    public int getEdadMinima() { return edadMinima; }

    public void setEdadMinima(int edadMinima) {
        if (edadMinima < 0) {
            throw new IllegalArgumentException("La edad mínima no puede ser negativa");
        }
        this.edadMinima = edadMinima;
    }

    @Override
    public String toString() {
        return super.toString() + " - Edad mínima: " + edadMinima;
    }

    /**
     * Sobrescribe el método prestar para verificar si el cliente tiene la edad mínima requerida.
     *
     * @param cliente el cliente que pide el préstamo
     * @return true si se ha realizado el préstamo, false si ya estaba prestada o no tiene la edad mínima
     * @throws IllegalArgumentException si cliente es null
     */
    @Override
    public boolean prestar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente no puede ser null");
        }
        // Verifica si el cliente tiene la edad mínima requerida
        if (cliente.getEdad() < edadMinima) {
            System.out.println("El cliente " + cliente.getNombre() + " no tiene la edad mínima (" + edadMinima + " años) para prestar la película.");
            return false;
        }
        // Si tiene la edad suficiente, realiza el préstamo usando el método de la clase padre
        return super.prestar(cliente);
    }
}
