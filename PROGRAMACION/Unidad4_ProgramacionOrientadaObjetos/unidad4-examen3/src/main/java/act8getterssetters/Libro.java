package act8getterssetters;

public class Libro {

    private String titulo;
    private String autor;
    private int paginas;

    // Constructor solo con título
    public Libro(String titulo) {
        this(titulo, "Desconocido", 0);
    }

    // Constructor principal
    public Libro(String titulo, String autor, int paginas) {
        this.titulo = (titulo == null || titulo.isEmpty()) ? "Sin título" : titulo;
        this.autor = (autor == null || autor.isEmpty()) ? "Anónimo" : autor;
        this.paginas = (paginas < 0) ? 0 : paginas;
    }

    public boolean esLargo() {
        return paginas > 300;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = (titulo == null || titulo.isEmpty()) ? this.titulo : titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = (autor == null || autor.isEmpty()) ? this.autor : autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = (paginas < 0) ? 0 : paginas;
    }
}
