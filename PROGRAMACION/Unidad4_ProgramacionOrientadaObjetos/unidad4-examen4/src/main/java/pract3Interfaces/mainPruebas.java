package pract3Interfaces;

public class mainPruebas {
    public static void main(String[] args) {
        // INSTANCIAS
        Coche coche1 = new Coche("Toyota", "Corolla", 2020, 4);
        Moto moto1 = new Moto("Harley-Davidson", "Street 750", 2019, false);
        Camion camion1 = new Camion("Volvo", "FH16", 2018, 25000);
        // Mostrar descripción de cada instancia
        System.out.println();
        coche1.descripcion();
        moto1.descripcion();
        camion1.descripcion();
    }
}
