package act14libreria;

public class Cliente {
    // ATRIBUTOS
    private String nombre;
    private String codigoCliente;
    private int edad;
    // CONSTRUCTOR PRINCIPAL
    public Cliente(String nombre, String codigoCliente, int edad) {
        setNombre(nombre);
        setCodigoCliente(codigoCliente);
        setEdad(edad);
    }
    // GETTERS Y SETTERS
    public String getNombre() { return nombre; }
    public String getCodigoCliente() { return codigoCliente; }
    public int getEdad() { return edad; }
    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCodigoCliente(String codigoCliente) { this.codigoCliente = codigoCliente; }
    public void setEdad(int edad) { this.edad = edad; }
    // MÉTODO TO STRING
    @Override
    public String toString() { return "Cliente: " + nombre + " (Código: " + codigoCliente + ", Edad: " + edad + ")";}    // EXTRA: MÉTODOS DE OPERACIONES DE PRÉSTAMOS Y RETIROS
    
    // Método para verificar si el cliente es mayor de edad
    public boolean esMayorDeEdad() { return edad >= 18;}

    // MÉTODOS CONTADOR DE PRÉSTAMOS
    private int contadorPrestamos = 0;

    // Getter para obtener el contador de préstamos
    public int getContadorPrestamos() { return contadorPrestamos;}

    // Método para incrementar el contador de préstamos
    public void incrementarPrestamo() { contadorPrestamos++;}
    // Método para decrementar el contador de préstamos
    public void decrementarPrestamo() {
        if (contadorPrestamos > 0) {
            contadorPrestamos--;
        }
    }
    // Método para verificar si el cliente es frecuente (es frecuente es aquel que ha realizado más de 5 préstamos)
    public boolean esClienteFrecuente() { return contadorPrestamos > 5;}

    // ARRAY DE OPERACIONES [retiradas, devoluciones, cambios_gestión]
    private int[] operaciones = {0, 0, 0}; // índice 0: retiradas, índice 1: devoluciones, índice 2: cambios de gestión

    // Getter para las operaciones individuales y totales
    public int getOperacionesRetirada() { return operaciones[0]; }
    public int getOperacionesDevolucion() { return operaciones[1]; }
    public int getOperacionesGestion() { return operaciones[2]; }
    public int getTotalOperaciones() { return operaciones[0] + operaciones[1] + operaciones[2]; }

    // Método para registrar una retirada (préstamo) o una devolución o un cambio de gestión
    public void registrarRetirada() { operaciones[0]++; }
    public void registrarDevolucion() { operaciones[1]++; }
    public void registrarOperacionGestion() { operaciones[2]++; }

    // Método para mostrar un resumen de operaciones
    public String obtenerResumenOperaciones() { return "Retiradas: " + operaciones[0] + ", Devoluciones: " + operaciones[1] + ", Cambios de gestión: " + operaciones[2] + ", Total: " + getTotalOperaciones();
    }
}