import java.util.Scanner;
public class U3Estructuradatos {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in); // Creación de un objeto Scanner para leer la entrada estándar

        String nombre = "Pepe";
        nombre.length(); // Llama al método length() de la clase String para obtener la longitud de la cadena
        // Para usar el método length() directamente en una cadena literal, se puede hacer así:
        System.out.println("Pepe".length()); // Usa el método length() en una cadena literal, dentro de un System.out.println

        //Para leer una cadena desde la entrada estándar y obtener su último carácter:
        System.out.println("Dime una palabra: ");
        String nombre2 = scanner1.nextLine(); // Lee una línea de entrada del usuario y la almacena en la variable nombre2
        System.out.println(nombre2.charAt(nombre2.length() - 1)); // Imprime el último carácter de la cadena nombre2 usando charAt() y length()
        
        // Si quiero imprimir todos los caracteres de la cadena uno por uno, puedo usar un bucle for:
        for (int i = 0; i < nombre2.length(); i++) {
            System.out.println(nombre2.charAt(i));
        }
        // Comparar cadenas en Java
        nombre2= "Pepe"; // Asignación de un nuevo valor a la variable nombre2 para las siguientes comparaciones
        // Que dos objetos String tenga los mismos atributos no significa que sean iguales
        // Para poder comparar cadenas en Java, se utiliza el método equals():
        System.out.println(nombre.equals(nombre2)); // Compara las cadenas nombre y nombre2 y imprime el resultado (true o false)
            // En este caso imprimirá false incluo si el usuario introduce "pepe" porque las mayúsculas y minúsculas importan
        // Para comparar sin importar mayúsculas y minúsculas, se puede usar equalsIgnoreCase():
        System.out.println(nombre.equalsIgnoreCase(nombre2)); // Compara las cadenas sin importar mayúsculas y minúsculas y imprime el resultado (true o false)
            // En este caso imprimirá true si el usuario introduce "pepe".
            // El ignoreCase no ignorará acentos o caracteres especiales.
        // Además tenemos otros métodos como toLowerCase() y toUpperCase() para convertir cadenas a minúsculas o mayúsculas respectivamente.
        System.out.println(nombre2.toUpperCase()); // Convierte la cadena nombre2 a mayúsculas y la imprime
        System.out.println(nombre2.toLowerCase()); // Convierte la cadena nombre2 a minúsculas y la imprime

        // Si tenemos un string con espacios como "Margarita Rivas Cobo" y queremos separar cada palabra:
        String nombreCompleto = "Margarita Rivas Cobo";
            // Necesitaremos saber en qué posición están los espacios. Para ello usamos el método indexOf():
        int espacio1 = nombreCompleto.indexOf(" "); // Encuentra la posición del primer espacio en la cadena nombreCompleto
            // Solo nos devolverá la posición del primer espacio.
        // IndexOf nos permite usar dos parámetros: el carácter o cadena a buscar y la posición desde la que empezar a buscar.
            // Por tanto, para encontrar el segundo espacio, podemos indicar manualmente la posición desde la que buscar el segundo espacio (en este caso, 10):
        int espacio2 = nombreCompleto.indexOf(" ", 10); // Busca el espacio a partir de la posición 10 y lo imprime
        // Ahora bien, cuando queremos indicar la cadena desde la que buscar y especificar la posición donde empezar a buscar y la posición donde dejar de buscar, indicamos dentro del indexOf():
        int espacio3 = nombreCompleto.indexOf(" ", 18, 25); // Busca el espacio a partir de la posición siguiente al primer espacio
        System.out.println(espacio1); // Imprime la posición del primer espacio
        System.out.println(espacio2); // Imprime la posición del segundo espacio
        System.out.println(espacio3); // Imprime la posición del tercer espacio (Si no existe imprime -1)
        // Por ejemplo, si para un nombre Maria queremos buscar la letra 'a', hariamos:
        String nombre3 = "Maria";
        System.out.println(nombre3.indexOf('a')); // Imprime la posición de la primera 'a' en "Maria"
        // Si quisieramos buscar la m minúscula, nos devolvería -1 porque no existe.
        // Por ello, primero debería hacer un toLowerCase() a la cadena y luego buscar la 'm':
        System.out.println(nombre3.toLowerCase().indexOf('m')); // Convierte nombre3 a minúsculas y busca la posición de 'm'
            // Si quisieramos hacer el toLowerCase() fuera del println, sería:
                // nombre3 = nombre3.toLowerCase();
                // System.out.println(nombre3.indexOf('m'));
                // Pero es menos efectivo.
        // Si quisieramos buscar desde el final de la cadena hacia el principio, usaríamos el método lastIndexOf():
        System.out.println(nombre3.lastIndexOf('a')); // Imprime la posición de la última 'a' en "Maria". Sería 4.
        scanner1.close();   // Cierre del scanner

        // Otro método es el substring, que permite obtener subcadenas dentro de una cadena:
        String nombre4 = "Jose Angel Alejo";
        // El método para obtener subcadenas es "substring()". Dentro se indicarmos la posición inicial y la posición final (la final no se incluye):
            System.out.println( nombre4.substring(0, 4)); // Imprime la subcadena obtenida ("Jose"), sin contar el espacio, que está en la posicion 4
        // Si quisieramos imprimir la primera y segunda palabra, haríamos:
            System.out.println( nombre4.substring(0, 10)); // Imprime la subcadena obtenida ("Jose Angel"), sin contar el espacio, que está en la posicion 10

    }
}
