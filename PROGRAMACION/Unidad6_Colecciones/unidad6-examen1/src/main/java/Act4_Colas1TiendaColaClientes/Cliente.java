package Act4_Colas1TiendaColaClientes;

/**
 * Clase Cliente - Representa un cliente en la cola
 */
public class Cliente {
    private String nombre;
    private int codCliente;

    // Constructor
    public Cliente(String nombre, int codCliente) {
        this.nombre = nombre;
        this.codCliente = codCliente;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getCodCliente() {
        return codCliente;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    // Método toString
    @Override
    public String toString() {
        return nombre + " (Código: " + codCliente + ")";
    }
}
