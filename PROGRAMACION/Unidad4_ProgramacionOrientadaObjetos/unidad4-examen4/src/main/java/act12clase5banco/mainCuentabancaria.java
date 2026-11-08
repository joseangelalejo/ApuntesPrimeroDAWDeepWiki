package act12clase5banco;

public class mainCuentabancaria {
        public static void main(String[] args) {
            Pin pin1 = new Pin("1234");
            CuentaBancaria cuenta1 = new CuentaBancaria("María", "ES00-0000", pin1);
            cuenta1.ingresar(200);
            cuenta1.mostrarSaldo("1234");
            cuenta1.retirar(50, "1234");
            cuenta1.cambiarPin("1234", "4321");
            cuenta1.mostrarSaldo("4321");
    }
}
