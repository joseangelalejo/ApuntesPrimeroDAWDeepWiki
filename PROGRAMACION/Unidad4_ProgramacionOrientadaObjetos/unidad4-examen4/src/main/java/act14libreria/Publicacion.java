package act14libreria;

import java.time.LocalDate; // Reto de Marga (profesora), gestionar fecha con LocalDate en lugar de usar String

public class Publicacion {
    // ATRIBUTOS
    private String titulo;
    private String autor;
    private LocalDate anioPublicacion; // ahora es fecha completa
    private Cliente clientePrestado; // null = no está prestada

    // CONSTRUCTOR PRINCIPAL
    public Publicacion(String titulo, String autor, LocalDate anioPublicacion, Cliente clientePrestado) {
        setTitulo(titulo);
        setAutor(autor);
        setAnioPublicacion(anioPublicacion);
        this.clientePrestado = clientePrestado; // puede iniciarse a null
    }
    /**
     * "IllegalArgumentException" lo que hace es lanzar una excepción (error) si el argumento 
     * no es válido, en lugar de permitir que el programa continúe con datos incorrectos.
     * Además, genera alertas en VSCode o NetBeans.
     * Permite especificar un mensaje descriptivo indicándolo como String, de la misma manera que en Sysout.
     */ 
    // GETTERS Y SETTERS
    public String getTitulo() { return titulo; }
    public LocalDate getAnioPublicacion() { return anioPublicacion; }
    public String getAutor() { return autor; }
    // Setters
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título obligatorio");
        }
        this.titulo = titulo;
        // Registra operación de gestión si está prestada
        if (clientePrestado != null) { clientePrestado.registrarOperacionGestion(); }
    }
    public void setAutor(String autor) {
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("Autor obligatorio");
        }
        this.autor = autor;
        // Registra operación de gestión si está prestada
        if (clientePrestado != null) { clientePrestado.registrarOperacionGestion(); }
    }
    public void setAnioPublicacion(LocalDate anioPublicacion) {
        if (anioPublicacion == null) {
            throw new IllegalArgumentException("Fecha de publicación obligatoria");
        }
        if (anioPublicacion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha no puede ser futura");
        }
        this.anioPublicacion = anioPublicacion;
        // Registra operación de gestión si está prestada
        if (clientePrestado != null) { clientePrestado.registrarOperacionGestion(); }
    }

    // MÉTODOS SOLICITADOS
    // Overrida de toString para mostrar la información de la publicación de forma legible
    @Override
    public String toString() {
        return "Título: " + titulo + " - Autor: " + autor + " - Fecha de publicación: " + anioPublicacion;
    }

    /**
     * Intenta prestar la publicación a un cliente.
     *
     * @param cliente el cliente que pide el préstamo
     * @return true si se ha realizado el préstamo, false si ya estaba prestada
     * @throws IllegalArgumentException si cliente es null
     */
    // Método para ceder publicaciones a clientes (prestamos). Devuelve true si se ha realizado el préstamo, false si ya estaba prestada.
    public boolean prestar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente no puede ser null");
        }
        if (clientePrestado != null) {
            // ya está prestada
            return false;
        }
        clientePrestado = cliente;
        cliente.incrementarPrestamo(); // Incrementa el contador de préstamos del cliente (ver clase Cliente.java)
        cliente.registrarRetirada(); // Registra la operación de retirada
        return true;
    }

    // Devuelve la publicación (queda libre).
    public void devolver() {
        if (clientePrestado != null) {
            clientePrestado.decrementarPrestamo(); // Decrementa el contador de préstamos del cliente
            clientePrestado.registrarDevolucion(); // Registra la operación de devolución
            clientePrestado = null;
        }
    }
}