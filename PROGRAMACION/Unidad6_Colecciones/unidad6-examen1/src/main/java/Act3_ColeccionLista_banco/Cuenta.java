package Act3_ColeccionLista_banco;

/**
 * Clase Cuenta - Representa una cuenta bancaria
 */
public class Cuenta {
    private String numeroCuenta;
    private double saldo;

    // Constructor
    public Cuenta(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    // Getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    // Setters
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método para ingresar dinero
    public void ingresarDinero(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
        }
    }

    // Método para retirar dinero
    public boolean retirarDinero(double cantidad) {
        if (cantidad > 0 && cantidad <= this.saldo) {
            this.saldo -= cantidad;
            return true;
        }
        return false;
    }

    // Método toString
    @Override
    public String toString() {
        return String.format("Cuenta: %s | Saldo: %.2f€", numeroCuenta, saldo);
    }
}
