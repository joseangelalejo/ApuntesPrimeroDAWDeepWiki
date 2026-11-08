package ejemplos;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        // Usando constructor por defecto
        Persona p1 = new Persona();
        System.out.println("Persona 1: " + p1);

        // Usando constructor con nombre
        Persona p2 = new Persona("Juan");
        System.out.println("Persona 2: " + p2);

        // Usando constructor con nombre y edad
        Persona p3 = new Persona("Ana", 25);
        System.out.println("Persona 3: " + p3);

        // Usando constructor completo
        Persona p4 = new Persona("Carlos", 30, "Madrid");
        System.out.println("Persona 4: " + p4);
    }
}