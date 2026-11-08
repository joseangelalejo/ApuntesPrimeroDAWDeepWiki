package clase5herencia;

public class Herencia {
    public static void main(String[] args) {
        Coche coche1 = new Coche("Seat", "Ibiza", "1234-ABC", 5);
        System.out.println(coche1);
        Coche coche2 = new Coche("Renault", "Clio", "5678-DEF");
        System.out.println(coche2);

        System.out.println();
        System.out.println(coche1.getVelocidad());
        System.out.println("Acelerando coche1...");
        coche1.acelerar(200);
        System.out.println(coche1.getVelocidad());
    }
}
