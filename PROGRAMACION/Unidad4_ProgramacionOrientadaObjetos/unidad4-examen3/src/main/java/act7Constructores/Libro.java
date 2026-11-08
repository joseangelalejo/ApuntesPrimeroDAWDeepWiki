package act7Constructores;

public class Libro {
    // ATRIBUTOS
    public String titulo;
    public String autor;
    public int numPaginas;
    // CONSTRUCTORES
        // Constructor con todos los datos
    public Libro(String titulo, String autor, int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }
        // Constructor con paginas = 0
    public Libro(String titulo, String autor) {
        this(titulo, autor, 0);
    }
        // Constructor con autor desconocido
    public Libro(String titulo) {
        this(titulo, "Desconocido", 0);
        }
}
