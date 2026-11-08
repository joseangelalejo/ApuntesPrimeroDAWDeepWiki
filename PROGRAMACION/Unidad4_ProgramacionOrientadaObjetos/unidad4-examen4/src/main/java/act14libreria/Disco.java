package act14libreria;

import java.time.LocalDate;

public class Disco extends Publicacion {
    // ATRIBUTOS
    private String discografica;

    // CONSTRUCTOR PRINCIPAL
    public Disco(String titulo, String autor, LocalDate anioPublicacion, Cliente clientePrestado, String discografica) {
        super(titulo, autor, anioPublicacion, clientePrestado);
        setDiscografica(discografica);
    }

    // GETTERS Y SETTERS
    public String getDiscografica() { return discografica; }

    public void setDiscografica(String discografica) {
        if (discografica == null || discografica.isBlank()) {
            throw new IllegalArgumentException("Discográfica obligatoria");
        }
        this.discografica = discografica;
    }

    @Override
    public String toString() {
        return super.toString() + " - Discográfica: " + discografica;
    }
}
