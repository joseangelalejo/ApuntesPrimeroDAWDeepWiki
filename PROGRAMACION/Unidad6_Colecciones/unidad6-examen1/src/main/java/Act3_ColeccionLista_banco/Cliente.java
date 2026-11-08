package Act3_ColeccionLista_banco;

import java.util.ArrayList;

/**
 * Clase Cliente - Representa un cliente del banco con sus cuentas
 */
public class Cliente {
    private String nombre;
    private String apellidos;
    private int codigoCliente;
    private ArrayList<Cuenta> cuentas;

    // Constructor
    public Cliente(String nombre, String apellidos, int codigoCliente) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigoCliente = codigoCliente;
        this.cuentas = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    // Agregar cuenta
    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    // Eliminar cuenta por número
    public boolean eliminarCuenta(String numeroCuenta) {
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getNumeroCuenta().equals(numeroCuenta)) {
                cuentas.remove(i);
                return true;
            }
        }
        return false;
    }

    // Obtener cuenta por número
    public Cuenta obtenerCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    // Método toString
    @Override
    public String toString() {
        return String.format("Cliente: %s %s (Código: %d) | Cuentas: %d", 
                nombre, apellidos, codigoCliente, cuentas.size());
    }
}
