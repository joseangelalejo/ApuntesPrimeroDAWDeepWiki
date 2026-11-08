package act11clase4password;
public class mainPassword {
    public static void main(String[] args) {
        Password contrasena1 = new Password("Abc12345.");
        Password contrasena2 = new Password("abc12345");
        System.out.println((contrasena1.esFuerte()) ? "Contraseña 1: Es fuerte" : "Contraseña 1: No es fuerte"); // Debería devolver true, ya que cumple con los requisitos de fortaleza
        System.out.println((contrasena2.esFuerte()) ? "Contraseña 2: Es fuerte" : "Contraseña 2: No es fuerte"); // Debería devolver false, ya que no tiene mayúsculas ni caracteres especiales
        contrasena2.modificarContrasena(); // Debería modificar la contraseña a "Abc12345." y devolver true, ya que es fuerte
        System.out.println(contrasena1.getPassword());
        System.out.println(contrasena2.getPassword());
    }
}
