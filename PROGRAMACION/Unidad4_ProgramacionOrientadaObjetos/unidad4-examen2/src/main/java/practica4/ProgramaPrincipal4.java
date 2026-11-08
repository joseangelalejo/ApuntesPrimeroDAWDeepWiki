package practica4;

public class ProgramaPrincipal4 {
    public static void main(String[] args) {
        // 1. Crear una instancia de la clase DatosTexto
        DatosTexto datos1 = new DatosTexto();
        // 2. Asignar valores al campo frase de la instancia (por ejemplo, "Hola Mundo")
        datos1.frase = "Lleva la tarara un vestido blanco lleno de cascabeles";
        // 3. Crear una instancia de la clase ProcesamientoTexto
        ProcesamientoTexto pros1 = new ProcesamientoTexto();
        // 4. Llamar al método contarCaracteres pasando la frase de DatosTexto e imprimir el resultado
        System.out.println("\nCantidad de carácteres : " + pros1.contarCaracteres(datos1.frase));
        // 5. Llamar al método convertirMayusculas pasando la frase de DatosTexto e imprimir el resultado
        System.out.println("Frase en mayúsculas: " + pros1.convertirMayusculas(datos1.frase));;
        // 6. Llamar al método verificarLongitudMayor5 pasando la frase de DatosTexto e imprimir el resultado
        System.out.println("¿Tiene la frase más de 5 carácteres? -> " + pros1.verificarLongitudMayor5(datos1.frase));
        // 7. Llamar al método convertirMinusculas pasando la frase de DatosTexto e imprimir el resultado
        System.out.println("Frase en minúsculas: " + pros1.convertirMinusculas(datos1.frase));
    }
}