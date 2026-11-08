package programaPrincipalBanca;
import metodosBancarios.CuentaBancaria;
public class ProgramaPrincipal {
    public static void main(String[] args) {
        CuentaBancaria.mostrarInformacionBanco();
        // Crear dos cuentas con distinto saldo
        CuentaBancaria cuenta1 = new CuentaBancaria("pepe", 0);
        CuentaBancaria cuenta2 = new CuentaBancaria("Juanito", 100);

        // Mostrar información de ambas cuentas
        System.out.println("\nInformación de ambas cuentas:   ");
        cuenta1.mostrarInformacion();
        cuenta2.mostrarInformacion();

        // Comparar los saldos de las cuentas
        System.out.println("\nComparar el saldo de dos cuentas:  ");
        CuentaBancaria.compararSaldos(cuenta1, cuenta2);

        //Convertir 100€ a 100$ con los métodos estáticos
        System.out.println("\nConvertir 100 euros a 100 dolares:  ");
        System.out.println("    100 euros son " + CuentaBancaria.convertirEurosADolares(100) + " dólares.");
            // Si quisiera hacerlo directamente con el saldo de una cuenta, por ejemplo la cuenta 2, en lugar de "100" indicaría "cuenta2.saldo"
        // Convertir 100$ a 100€ con métodos estáticos
        System.out.println("\nConvertir 100 dolares a 100 euros: ");
        System.out.println("    100 dólares son " + CuentaBancaria.convertirDolaresAEuros(100) + " euros.");
        
        // Calcular el interés anual de una cuenta con una tasa del 5%
        System.out.println("\nInterés anual de una cuenta con una tasa del 5%");
        System.out.println("    El interés anual es de: " + CuentaBancaria.calcularInteresAnual(cuenta2.saldo, 5));
    }
    
}
