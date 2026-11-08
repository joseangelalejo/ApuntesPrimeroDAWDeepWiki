package act7Constructores;

public class MainAct7Cons {
    public static void main(String[] args) {
        System.out.println();   // System.out.println vacío para mejorar el formato y lectura en terminal
        // Alumno
        Alumno a1 = new Alumno("Juan", 20);
        Alumno a2 = new Alumno("María", 22);
        a1.mostrarAlumno();
        a2.mostrarAlumno();
        Alumno.totalAlumnos();

        // Libro
        Libro l1 = new Libro("1984", "George Orwell", 328);
        Libro l2 = new Libro("El Quijote", "Cervantes");
        Libro l3 = new Libro("Misterioso");

        System.out.println("\nLibros:");
        System.out.println("Título: " + l1.titulo + ", Autor: " + l1.autor + ", Páginas: " + l1.numPaginas);
        System.out.println("Título: " + l2.titulo + ", Autor: " + l2.autor + ", Páginas: " + l2.numPaginas);
        System.out.println("Título: " + l3.titulo + ", Autor: " + l3.autor + ", Páginas: " + l3.numPaginas);

        // Producto
        Producto p1 = new Producto("Chocolate", 1.5);
        Producto p2 = new Producto("Jabón", -2.0, 10); // precio negativo -> 0
        Producto p3 = new Producto("Leche", 0.85, 20);

        System.out.println("\nProductos:");
        System.out.println(p1.nombre + " - " + p1.precio + " euros - stock: " + p1.stock);
        System.out.println(p2.nombre + " - " + p2.precio + " euros - stock: " + p2.stock);
        System.out.println(p3.nombre + " - " + p3.precio + " euros - stock: " + p3.stock);

        // Rectángulo
        Rectangulo r1 = new Rectangulo(3, 4);
        Rectangulo r2 = new Rectangulo(5); // cuadrado

        System.out.println("\nRectángulos:");
        System.out.println("Base: " + r1.base + ", Altura: " + r1.altura);
        System.out.println("Base: " + r2.base + ", Altura: " + r2.altura);
    }
}