package act1Excepciones;

public class CuentaBancaria {
    // ATRIBUTOS
    private double saldo;
    // CONSTRUCTOR
    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }
    // MÉTODO DE RETIRO
    public double retirar(double cantidad) throws SaldoInsuficienteException {
        if (cantidad > saldo) {
            throw new SaldoInsuficienteException();
        }
        saldo -= cantidad;
        return cantidad;
    }
}
