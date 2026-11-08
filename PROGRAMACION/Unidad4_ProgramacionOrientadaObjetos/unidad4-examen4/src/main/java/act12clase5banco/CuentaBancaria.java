package act12clase5banco;

public class CuentaBancaria {
    // ATRIBUTOS
    private String titular;
    private String numeroCuenta;
    private double saldo;
    private Pin pin;     // Usar como objeto password en lugar de String y garantizar si es fuerte o no

    // CONSTRUCTORES
    // Constructor completo
    public CuentaBancaria(String titular, String numeroCuenta, double saldo, Pin pin) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.pin = pin;
    }
    // Constructor sin saldo (saldo inicial 0)
    public CuentaBancaria(String titular, String numeroCuenta, Pin pin) {
        this(titular, numeroCuenta, 0.0, pin);
    }

    // GETTERS (no hay setters para titular, numeroCuenta ni saldo, ya que no se pueden modificar después de crear la cuenta)
    public String getTitular() { return titular; }
    public String getNumeroCuenta() { return numeroCuenta; }
    public double getSaldo() { return saldo; }
    // no hay getter de pin por motivos de seguridad

    // MÉTODOS
    // Método para ingresar dinero en la cuenta
    public void ingresar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a ingresar no puede ser menor o igual a cero");
            return;
        }
        saldo += cantidad;
    }
    // Método para retirar dinero de la cuenta (solo si el pin es correcto y hay suficiente saldo)
    public void retirar(double cantidad, String pinIntroducido) {
        if (!pin.comprobar(pinIntroducido)) {
            System.out.println("Pin incorrecto. No se puede realizar la operación.");
            return;
        }
        if (cantidad <= 0) {
            System.out.println("La cantidad a retirar no puede ser menor o igual a cero");
            return;
        }
        if (cantidad > saldo) {
            System.out.println("No se puede retirar más dinero del que hay en la cuenta.");
            return;
        }
        saldo -= cantidad;
    }
    // Método para mostrar el saldo (solo si el pin es correcto)
    public void mostrarSaldo(String pinIntroducido) {
        if (!pin.comprobar(pinIntroducido)) {
            System.out.println("Pin incorrecto. No se puede mostrar el saldo.");
            return;
        }
        System.out.println("El saldo actual es: " + saldo);
    }
    // Método para cambiar el pin (solo si el pin actual es correcto)
    public void cambiarPin(String pinActual, String pinNuevo) {
        try {
            pin.cambiar(pinActual, pinNuevo);
            System.out.println("Pin cambiado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}