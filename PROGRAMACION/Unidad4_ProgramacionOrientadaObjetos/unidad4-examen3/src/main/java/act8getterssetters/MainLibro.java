package act8getterssetters;

public class MainLibro {

    public static void main(String[] args) {

        Libro libro = new Libro("El Quijote", "Cervantes", 863);

        System.out.println("Título: " + libro.getTitulo());

        if (libro.esLargo()) {
            System.out.println("Es un libro largo.");
        } else {
            System.out.println("No es un libro largo.");
        }
    }
}
