package act8getterssetters;

public class MainPersona {

    public static void main(String[] args) {

        Persona p1 = new Persona("Carlos");
        p1.mostrarDatos();

        p1.setEdad(25);

        System.out.println("Después de actualizar la edad:");
        p1.mostrarDatos();
    }
}
