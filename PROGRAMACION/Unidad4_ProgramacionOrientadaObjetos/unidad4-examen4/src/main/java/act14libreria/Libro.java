package act14libreria;
import java.time.LocalDate;
public class Libro extends Publicacion {
    // ATRIBUTOS
    private int numeroPaginas;

    // CONSTRUCTOR PRINCIPAL
    public Libro(String titulo, String autor, LocalDate anioPublicacion, Cliente clientePrestado, int numeroPaginas) {
        super(titulo, autor, anioPublicacion, clientePrestado);
        setNumeroPaginas(numeroPaginas);
    }

    // GETTERS Y SETTERS
    public int getNumeroPaginas() { return numeroPaginas;}

    public void setNumeroPaginas(int numeroPaginas) {
        if (numeroPaginas <= 0) {                 // <- comprueba rango
            throw new IllegalArgumentException("Número de páginas debe ser mayor que 0");
        }
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String toString() {
        return super.toString() + " - Páginas: " + numeroPaginas;
    }
}