package act1Excepciones;

public class mainEj1y2 {
    public static void main(String[] args) {
        // Instancias de ejercicio 1 - CuentaBancaria
        CuentaBancaria cuenta1 = new CuentaBancaria(100.0);
        CuentaBancaria cuenta2 = new CuentaBancaria(200.0);
        // Instancias de ejercicio 2 - En try-catch | Línea 17~

        // try-catch para ejercicio 1
        try {
            System.out.println("Retirando 50 de cuenta1: " + cuenta1.retirar(50));
            System.out.println("Retirando 150 de cuenta2: " + cuenta2.retirar(180));
            System.out.println("Retirando 60 de cuenta1: " + cuenta1.retirar(60)); // Lanza la excepción, quedan 50
            System.out.println("Retirando 50 de cuenta2: " + cuenta2.retirar(50)); // Lanza la excepción, quedan 20
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // try-catch para ejercicio 2
        try {
            Usuario usuario1 = new Usuario("contraseña123");
            Usuario usuario2 = new Usuario("otracontraseña456");
            Usuario usuario3 = new Usuario("corta"); // Lanza la excepción por ser menor a 8 caracteres
            System.out.println("Usuario 1: " + usuario1);
            System.out.println("Usuario 2: " + usuario2);
            System.out.println("Usuario 3: " + usuario3);
        } catch (ContrasenaInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}