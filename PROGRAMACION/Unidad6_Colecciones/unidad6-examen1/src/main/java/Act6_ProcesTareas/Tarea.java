public class Tarea implements Comparable<Tarea> {
    private int id;
    private String titulo;
    private String descripcion;
    private int prioridad; // 1=Alta, 2=Media, 3=Baja

    public Tarea(int id, String titulo, String descripcion, int prioridad) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Tarea otra) {
        return Integer.compare(this.prioridad, otra.prioridad);
    }

    @Override
    public String toString() {
        String nivelPrioridad = prioridad == 1 ? "ALTA" : (prioridad == 2 ? "MEDIA" : "BAJA");
        return "[ID: " + id + "] " + titulo + " (" + nivelPrioridad + ") - " + descripcion;
    }
}