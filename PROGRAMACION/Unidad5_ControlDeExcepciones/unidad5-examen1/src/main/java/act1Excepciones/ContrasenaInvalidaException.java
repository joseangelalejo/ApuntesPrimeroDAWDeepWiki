package act1Excepciones;

public class ContrasenaInvalidaException extends Exception {
    // Constructor por defecto con mensaje predefinido
    public ContrasenaInvalidaException() { super("Contraseña inválida"); }
    // Constructor adicional para permitir mensajes personalizados
    public ContrasenaInvalidaException(String mensaje) { super(mensaje); }
}
