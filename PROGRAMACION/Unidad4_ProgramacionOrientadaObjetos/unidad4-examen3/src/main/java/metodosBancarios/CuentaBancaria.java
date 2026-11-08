package metodosBancarios;

public class CuentaBancaria {
    // ATRIBUTOS
    public String titular;  // Nombre del propietario de la cuenta
    public double saldo;    // Dinero disponible en la cuenta
    public static String banco = "Banco ITP SA";     // Nombre del banco (el mismo para todas las cuentas)

    // MÉTODOS NO ESTÁTICOS
    // Constructor
    public CuentaBancaria (String titular, double saldo){
        this.titular = titular;
        this.saldo = saldo;
    }
    // Aumentar el saldo de la cantidad indicada
    public void depositar(double cantidad) {
        this.saldo += cantidad;
    }
    // Disminuir el saldo en la cantidad indicada. Si no hay suficiente, devolver false y no decrementar
    public boolean retirar(double cantidad) {
        if (this.saldo > cantidad) {
            this.saldo -= cantidad;
            return true;
        }
        return false;
    }
    // Mostrar el nombre del titular y el saldo actual
    public void mostrarInformacion() {
        System.out.println("Nombre del titular: " + this.titular + "\nSaldo actual: " + this.saldo);
    }

    // MÉTODOS ESTÁTICOS
    // Mostrar el nombre del banco
    public static void mostrarInformacionBanco() {
        System.out.println("Nombre de la entidad bancaria: " + banco);
    }
    // Convertir euros a dólares, suponiendo tasa de cambio 1€ = 1.14$
    public static double convertirEurosADolares(double euros) {
        double dolares = (euros * 1.14);
        return dolares;
    }
    // Convertir dolares a euros, suponiendo tasa de cambio 1€ = 1.14$
    public static double convertirDolaresAEuros(double dolares) {
        double euros = (dolares / 1.14);
        return euros;
    }
    // Calcular el interés anual sobre un saldo según una tasa de interés dada
    public static double calcularInteresAnual(double saldo, double tasa) {
        double interes = saldo * (tasa/100);
        return interes;
    }
    // Comparar saldos de dos cuentas y mostrar cuál tiene más dinero
    public static void compararSaldos(CuentaBancaria cuenta1, CuentaBancaria cuenta2) {
        if (cuenta1.saldo > cuenta2.saldo) {
            System.out.println("La cuenta con más cantidad es: ");
            cuenta1.mostrarInformacion();
        } else if (cuenta2.saldo > cuenta1.saldo) {
            System.out.println("La cuenta con más cantidad es: ");
            cuenta2.mostrarInformacion();
        } else {
            System.out.println("Ambas cuentas tienen la misma cantidad: ");
            cuenta1.mostrarInformacion();
            cuenta2.mostrarInformacion();
        }
    }
}
