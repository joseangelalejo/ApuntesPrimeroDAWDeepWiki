package act11clase4password;

import java.util.Scanner;
import java.util.Random;

public class Password {
    // ATRIBUTOS
    private String password;

    // CONSTRUCTOR por defecto
    public Password(String password) {
        this.password = password;
    }
    // Constructor por defecto con password aleatoria de longitud 8
    public Password() {
        this(generateRandom(8));
    }
    // Constructor con longitud especificada y password aleatoria
    public Password(int longitud) {
        this(generateRandom(longitud));
    }

    /*
     * Este método es un "envoltorio" que llama al método esFuerte directamente
     * sobre el atributo password de la clase, por ejemplo:
     * Password pwd = new Password();
     * pwd.setPassword("Abc12345.");
     * boolean esFuerte = pwd.esFuerte(); // Llama al método esFuerte() sin
     * argumentos, que a su vez llama a esFuerte(this.password)
     */
    public boolean esFuerte() {
        return esFuerte(this.password);
    }

    // Método de verificación de la fortaleza/seguridad del password
    public boolean esFuerte(String pwd) {
        if (pwd == null || pwd.length() < 8) {
            return false;
        }
        int may = 0, min = 0, dig = 0;
        boolean tieneSimbolo = false;
        for (char c : pwd.toCharArray()) { /* Recorrer cada carácter del password y contar mayúsculas, minúsculas,
                                            * dígitos y
                                            * verificar si hay caracteres especiales. */
            if (Character.isUpperCase(c)) { // Los métodos .isUpperCase(), .isLowerCase() y .isDigit() de la clase
                                            // Character se utilizan para verificar el tipo de carácter.
                may++; // Sumar a mayúsculas.
            } else if (Character.isLowerCase(c)) {
                min++; // Sumar a minúsculas
            } else if (Character.isDigit(c)) {
                dig++; // Sumar a dígitos
            } else if (c == '.' || c == '_') {
                tieneSimbolo = true; // Establecer si hay caracteres especiales (puntos o guiones bajos)
            }
        }
        /* Al haber convertido pwd a un array de caracteres, se puede recorrer con un
         * bucle for-each para verificar carácteres, pero
         * también se podría haber utilizado un bucle for tradicional con índices para
         * acceder a cada carácter del string.
         */
        return (may >= 2 && min >= 2 && dig >= 1 && tieneSimbolo); // Devolverá true si el password es fuerte, false en caso contrario
    }

    // Método para modificar el password
    public boolean modificarContrasena() {
        Scanner sc = new Scanner(System.in);
        String nuevaContrasena;
        System.out.print("Introduce la nueva contraseña: ");
        nuevaContrasena = sc.nextLine(); // Leer la nueva contraseña desde la entrada estándar (consola)
        if (esFuerte(nuevaContrasena)) {
            this.password = nuevaContrasena;
            sc.close();
            return true;
        }
        sc.close();
        return false;
    }

    // Métodos de "AMPLIACIÓN"
    /**
     * Genera una contraseña aleatoria de la longitud solicitada.
     * Se usa en el constructor que recibe un entero.
     */
    private static String generateRandom(int longitud) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789"
                + "!@#$%&*"; // se puede ajustar el conjunto
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }
    // GETTERS
    public String getPassword() {
        return password;
    }
    // No haré setters, sólo se puede modificar a través del método modificarContrasena() que verifica la fortaleza
    
}
