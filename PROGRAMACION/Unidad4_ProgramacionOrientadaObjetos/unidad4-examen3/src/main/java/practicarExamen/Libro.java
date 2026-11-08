package practicarExamen;
public class Libro {
    // ATRIBUTOS
    private final String isbn;  // Final para que no pueda ser modificado tras la creación de la instancia
    private String titulo;
    private String autor;
    private int copias;
    private String contrasena;
    // CONSTRUCTOR COMPLETO
    public Libro(String isbn, String titulo, String autor, int copias, String contrasena) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.copias = (copias <= 0) ? 1 : copias;
        this.contrasena = contrasena;
    }
    // CONSTRUCTOR CON copias inicializada en 1
    public Libro(String isbn, String titulo, String autor, String contrasena) {
        this(isbn, titulo, autor, 1, contrasena);
    }

    // GETTERS Y SETTERS
    // Getters
    public String getIsbn() {return isbn;}
    public String getTitulo() {return titulo;}
    public String getAutor() {return autor;}
    public int getCopias() {return copias;}
    // Setters
    public void setTitulo(String titulo) {
        this.titulo = (titulo == null || titulo.isEmpty()) ? this.titulo : titulo;
    }
    public void setAutor(String autor) {
        this.autor = (autor == null || autor.isEmpty()) ? this.autor : autor;
    }
    public void setCopias(int copias) {
        this.copias = (copias<=0) ? 1 : copias;
    }

    // MÉTODOS SOLICITADOS
    // Método prestar() para disminuir las copias disponibles
    public boolean prestar(int prestado) {
        if (prestado == 1 && copias > 0) {
            copias -= prestado;
            return true;
        }
        System.out.println("La cantidad introducida es distinta a 1. No se pueden prestar más de un libro a la vez");
        return false;
    }
    
    // Método devolver() para aumentar las copias disponibles
    public boolean devolver(int devolver) {
        if (devolver > 0) {
            copias += devolver;
            return true;
        }
        return false;
    }
    // Método mostrarDisponibilidad() para mostrar el número de copias disponibles
    public void mostrarDisponibilidad() {
        System.out.println("Cantidad de copias disponibles del libro" + titulo + ": " + copias);
    }
    // Método para cambiar la contraseña
    public void cambiarContrasena(String actual, String nueva) {
        if (!actual.equals(nueva) && actual.equals(contrasena)) {
            contrasena = nueva;
        }
    }
}
