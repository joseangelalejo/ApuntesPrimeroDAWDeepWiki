package act1Excepciones;

public class Usuario {
    // ATRIBUTOS
    private String contrasena;
    // CONSTRUCTOR
    public Usuario(String contrasena) throws ContrasenaInvalidaException {
        setContrasena(contrasena);
    }
    // GETTERS y SETTERS
    public void setContrasena(String contrasena) throws ContrasenaInvalidaException {
        validarContrasena(contrasena);
        this.contrasena = contrasena;
    }

    // MÉTODO DE VALIDACIÓN DE CONTRASEÑA
    public void validarContrasena(String contrasena) throws ContrasenaInvalidaException {
        if (contrasena == null || contrasena.length() < 8) {
            throw new ContrasenaInvalidaException("La contraseña debe tener al menos 8 caracteres");
        }
        boolean tieneNumero = false;
        for (char c : contrasena.toCharArray()) {   // Recorrer cada carácter, .toCharArray() convierte la cadena en un array de caracteres
            if (Character.isDigit(c)) {
                tieneNumero = true;
                break;
            }
        }
        if (!tieneNumero) { // Si es false, no se encontró ningún número
            throw new ContrasenaInvalidaException("La contraseña debe contener al menos un número");
        }
    }
    // Overrida de toString para debug y visualización legible
    @Override
    public String toString() {
        return "Usuario{contrasena='" + contrasena + "'}";
    }
}
