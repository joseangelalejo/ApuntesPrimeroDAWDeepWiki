package act8getterssetters;

public class MainCoche {

    public static void main(String[] args) {

        Coche coche = new Coche("Toyota");
        coche.acelerar(80);

        System.out.println("Velocidad actual: " + coche.getVelocidad());
    }
}
