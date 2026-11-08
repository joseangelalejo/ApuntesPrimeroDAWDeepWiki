package practica4;

public class ProcesamientoTexto {
    // Método para contar caracteres: devolver el número de caracteres en la frase
    public int contarCaracteres(String frase) {
        return (frase != null) ? frase.length() : 0;
    }

    // Método para convertir a mayúsculas: devolver la frase en mayúsculas
    public String convertirMayusculas(String frase) {
        return frase.toUpperCase();
    }

    // Método para verificar longitud mayor a 5: devolver true si la frase tiene más de 5 caracteres
    public boolean verificarLongitudMayor5(String frase) {
        return (frase.length() > 5) ? true : false;
    }

    // Método para convertir a minúsculas: devolver la frase en minúsculas
    public String convertirMinusculas(String frase) {
        return frase.toLowerCase();
    }
}