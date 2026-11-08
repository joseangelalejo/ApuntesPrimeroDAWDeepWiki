package ApuntesClase;

/**
 * Clase Cancion - Representa una canción con sus atributos básicos
 */
public class Cancion {
    private String titulo;
    private String artista;
    private int duracion; // en segundos

    // Constructor
    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracion() {
        return duracion;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    // Método para obtener la duración formateada
    public String getDuracionFormato() {
        int minutos = duracion / 60;
        int segundos = duracion % 60;
        return String.format("%d:%02d", minutos, segundos);
    }

    // Método toString
    @Override
    public String toString() {
        return "Cancion{" +
                "titulo='" + titulo + '\'' +
                ", artista='" + artista + '\'' +
                ", duracion=" + getDuracionFormato() +
                '}';
    }

    // Método para comparar canciones por título y artista
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cancion)) {
            return false;
        }
        Cancion otra = (Cancion) obj;
        return this.titulo.equalsIgnoreCase(otra.titulo) &&
               this.artista.equalsIgnoreCase(otra.artista);
    }
}
