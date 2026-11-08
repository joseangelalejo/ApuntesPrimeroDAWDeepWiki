package practicarExamen;

public class Membresia {
    // ATRIBUTOS
    private final String idMiembro;
    private String nombre;
    private String apellido;
    private double saldo;
    private String clave;
    private boolean activa;
    // CONSTRUCTOR PRINCIPAL
    public Membresia(String idMiembro, String nombre, String apellido, double saldo, String clave, boolean activa) {
        this.idMiembro = idMiembro;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = Math.abs(saldo);
        this.clave = clave;
        this.activa = activa;
    }
    // Constructor con saldo inicializado en 0
    public Membresia(String idMiembro, String nombre, String apellido, String clave, boolean activa) {
        this(idMiembro, nombre, apellido, 0.0, clave, activa);
    }
    // GETTERS Y SETTERS
    // Getters - Se excluve clave por motivos de seguridad, y saldo por petición en premisa
    public String getIdMiembro() {return idMiembro;}
    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}
    public boolean getActiva() {return activa;}
    // Setters - Se excluye ID del miembro y clave
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setSaldo(double saldo) {this.saldo = Math.abs(saldo);}
    public void setActiva(boolean activa) {this.activa = activa;}

    // MÉTODOS SOLICITADOS
    // Método para recargar saldo
    public boolean recargarSaldo(double cantidad, String clave) {
        if (activa && this.clave.equals(clave)) {
            saldo += Math.abs(cantidad);
            return true;
        }
        return false;
    }
    // Método para gastar del saldo si hay suficiente
    public boolean gastarSaldo(double cantidad) {
        if(activa && Math.abs(cantidad) <= saldo) {
            saldo -= Math.abs(cantidad);
            return true;
        }
        return false;
    }
    // Método para mostrar el saldo si la clave es correcta
    public void mostrarSaldo(String clave) {
        if (activa && this.clave.equals(clave)) {
            System.out.println("El saldo actual es: " + saldo);
        }
    }
    // Método para cambiar la clave si la actual es correcta
    public boolean cambiarClave(String actual, String nueva) {
        if (activa && actual.equals(clave)) {
            clave = nueva;
            return true;
        }
        return false;
    }
    // Método para cancelar la membresía si la clave es correcta
    public boolean cancelarMembresia(String clave) {
        if (activa && this.clave.equals(clave)) {
            activa = false;
            return true;
        }
        return false;
    }
}
