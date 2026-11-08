package act14libreria;

import java.time.LocalDate;

public class mainPruebas {
    public static void main(String[] args) {
        System.out.println("--- PRUEBA DEL SISTEMA DE LIBRERÍA ---\n");

        // Crear clientes
        Cliente cliente1 = new Cliente("Juan Pérez", "CLI001", 25);
        Cliente cliente2 = new Cliente("María García", "CLI002", 17);
        Cliente cliente3 = new Cliente("Carlos López", "CLI003", 30);

        System.out.println("CLIENTES CREADOS:");
        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
        System.out.println();

        // Crear publicaciones
        Libro libro1 = new Libro("Don Quijote", "Miguel de Cervantes", LocalDate.of(1605, 1, 16), null, 600);
        Libro libro2 = new Libro("1984", "George Orwell", LocalDate.of(1949, 1, 1), null, 350);
        Disco disco1 = new Disco("Abbey Road", "The Beatles", LocalDate.of(1969, 9, 26), null, "Apple Records");
        Disco disco2 = new Disco("The Dark Side of the Moon", "Pink Floyd", LocalDate.of(1973, 3, 1), null, "Harvest Records");
        Pelicula pelicula1 = new Pelicula("Inception", "Christopher Nolan", LocalDate.of(2010, 7, 16), null, 13);
        Pelicula pelicula2 = new Pelicula("Pulp Fiction", "Quentin Tarantino", LocalDate.of(1994, 10, 14), null, 18);

        System.out.println("PUBLICACIONES CREADAS:");
        System.out.println(libro1);
        System.out.println(libro2);
        System.out.println(disco1);
        System.out.println(disco2);
        System.out.println(pelicula1);
        System.out.println(pelicula2);
        System.out.println();

        // Realizar préstamos
        System.out.println("--- REALIZANDO PRÉSTAMOS ---\n");

        // Préstamo exitoso
        if (libro1.prestar(cliente1)) {
            System.out.println("? " + cliente1.getNombre() + " ha tomado prestado: " + libro1.getTitulo());
        } else {
            System.out.println("? No se pudo prestar " + libro1.getTitulo());
        }

        // Intento de préstamo duplicado
        if (libro1.prestar(cliente2)) {
            System.out.println("? " + cliente2.getNombre() + " ha tomado prestado: " + libro1.getTitulo());
        } else {
            System.out.println("? No se pudo prestar " + libro1.getTitulo() + " (ya está prestado)");
        }

        // Préstamos de libros
        if (libro2.prestar(cliente2)) {
            System.out.println("? " + cliente2.getNombre() + " ha tomado prestado: " + libro2.getTitulo());
        }

        // Préstamos de discos
        if (disco1.prestar(cliente1)) {
            System.out.println("? " + cliente1.getNombre() + " ha tomado prestado: " + disco1.getTitulo());
        }

        if (disco2.prestar(cliente3)) {
            System.out.println("? " + cliente3.getNombre() + " ha tomado prestado: " + disco2.getTitulo());
        }

        // Préstamo de película con verificación de edad
        System.out.println();
        if (pelicula1.prestar(cliente2)) {
            System.out.println("? " + cliente2.getNombre() + " ha tomado prestado: " + pelicula1.getTitulo());
        }

        if (pelicula2.prestar(cliente2)) {
            System.out.println("? " + cliente2.getNombre() + " ha tomado prestado: " + pelicula2.getTitulo());
        } else {
            System.out.println("? " + cliente2.getNombre() + " no puede tomar prestada " + pelicula2.getTitulo() + " (menor de edad)");
        }

        if (pelicula2.prestar(cliente1)) {
            System.out.println("? " + cliente1.getNombre() + " ha tomado prestado: " + pelicula2.getTitulo());
        }

        System.out.println();

        // Mostrar información de los clientes
        System.out.println("--- INFORMACIÓN DE CLIENTES ---\n");
        System.out.println(cliente1.toString() + " - Préstamos: " + cliente1.getContadorPrestamos());
        System.out.println(cliente1.obtenerResumenOperaciones());
        System.out.println();

        System.out.println(cliente2.toString() + " - Préstamos: " + cliente2.getContadorPrestamos());
        System.out.println(cliente2.obtenerResumenOperaciones());
        System.out.println();

        System.out.println(cliente3.toString() + " - Préstamos: " + cliente3.getContadorPrestamos());
        System.out.println(cliente3.obtenerResumenOperaciones());
        System.out.println();

        // Realizar devoluciones
        System.out.println("--- REALIZANDO DEVOLUCIONES ---\n");

        libro1.devolver();
        System.out.println("? Se devolvió: " + libro1.getTitulo() + " (Cliente: " + cliente1.getNombre() + ")");

        pelicula2.devolver();
        System.out.println("? Se devolvió: " + pelicula2.getTitulo() + " (Cliente: " + cliente1.getNombre() + ")");

        System.out.println();

        // Mostrar información actualizada
        System.out.println("--- INFORMACIÓN ACTUALIZADA DE CLIENTES ---\n");
        System.out.println(cliente1.toString() + " - Préstamos: " + cliente1.getContadorPrestamos());
        System.out.println(cliente1.obtenerResumenOperaciones());
        System.out.println();

        // Verificar cliente frecuente
        System.out.println("--- VERIFICACIÓN DE CLIENTES FRECUENTES ---\n");
        System.out.println(cliente1.getNombre() + " es cliente frecuente: " + cliente1.esClienteFrecuente());
        System.out.println(cliente2.getNombre() + " es cliente frecuente: " + cliente2.esClienteFrecuente());
        System.out.println(cliente3.getNombre() + " es cliente frecuente: " + cliente3.esClienteFrecuente());
    }
}
