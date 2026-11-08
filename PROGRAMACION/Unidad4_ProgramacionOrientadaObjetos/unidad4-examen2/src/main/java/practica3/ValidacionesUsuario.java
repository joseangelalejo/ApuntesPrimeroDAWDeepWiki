package practica3;

public class ValidacionesUsuario {
    // Método para validar nombre: debe devolver true si el nombre tiene al menos 2 caracteres
    public boolean validarNombre(String nombre) {
        return (nombre.length() >= 2) ? true : false;
    }

    // Método para validar email: debe devolver true si el email contiene '@'
    public boolean validarEmail(String email) {
        return (email.indexOf('@') != -1) ? true : false;
    }

    // Método para extraer el dominio del email: devolver la parte después de '@'
    public String extraerDominio(String email) {
        int indiceE = email.indexOf('@');
        if (indiceE != -1 && indiceE < (email.length() -1)) {
            return email.substring(indiceE + 1);
        }
        return "El correo no tiene un dominio válido";
    }

    // Método para convertir email a mayúsculas: devolver el email en mayúsculas
    public String convertirEmailMayusculas(String email) {
        return (email != null) ? email.toUpperCase() : "No se pudo convertir";
    }

    // Método para convertir nombre a mayúsculas: devolver el nombre en mayúsculas
    public String convertirNombreMayusculas(String nombre) {
        return (nombre != null) ? nombre.toUpperCase() : "No se pudo convertir";
    }
}