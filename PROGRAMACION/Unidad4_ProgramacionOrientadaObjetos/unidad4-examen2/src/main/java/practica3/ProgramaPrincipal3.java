package practica3;

public class ProgramaPrincipal3 {
    public static void main(String[] args) {
        // 1. Crear una instancia de la clase DatosUsuario
        DatosUsuario usuario1 = new DatosUsuario();

        // 2. Asignar valores a los campos nombre y email de la instancia (por ejemplo, "Ana" y "ana@example.com")
        usuario1.nombre = "Juan";
        usuario1.email = "juan@gmail.com";

        // 3. Crear una instancia de la clase ValidacionesUsuario
        ValidacionesUsuario validar1 = new ValidacionesUsuario();

        // 4. Llamar al método validarNombre pasando el nombre de DatosUsuario e imprimir el resultado
        System.out.println("\nNombre válido: " + validar1.validarNombre(usuario1.nombre));

        // 5. Llamar al método validarEmail pasando el email de DatosUsuario e imprimir el resultado
        System.out.println("Email válido: " + validar1.validarEmail(usuario1.email));

        // 6. Llamar al método extraerDominio pasando el email de DatosUsuario e imprimir el resultado
        String dominio = validar1.extraerDominio(usuario1.email);
        System.out.println("Dominio: " + dominio);

        // 7. Llamar al método convertirEmailMayusculas pasando el email de DatosUsuario e imprimir el resultado
        System.out.println("Email en mayúsculas: " + validar1.convertirEmailMayusculas(usuario1.email));

        // 8. Llamar al método convertirNombreMayusculas pasando el nombre de DatosUsuario e imprimir el resultado
        System.out.println("Nombre en mayúsculas: " + validar1.convertirNombreMayusculas(usuario1.nombre));
    }
}