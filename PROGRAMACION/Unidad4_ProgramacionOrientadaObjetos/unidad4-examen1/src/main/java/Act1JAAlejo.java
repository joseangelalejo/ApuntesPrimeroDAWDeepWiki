public class Act1JAAlejo {
    // Crea las siguientes funciones:

    // 1. Función que dado un array lo imprime.
    public static void imprimirArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    // 2. Función  que dado un número te devuelve true si es par y false si es impar
    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }
    // 3. Función que dado un string te devuelva el número de palabras.
    public static int contarPalabras(String frase) {
        if (frase == null || frase.isEmpty()) {
            return 0;
        }
        String[] palabras = frase.trim().split("\\s+");
        return palabras.length;
    }
    // 4. Función que dado dos números devuelva true si el primero es divisible por el segundo
    public static boolean esDivisible(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero.");
        }
        return a % b == 0;
    }
    // 5. Función que te saca por pantalla un mensaje aleatorio de bienvenida.
    public static void mensajeBienvenida() {
        String[] mensajes = {
            "¡Bienvenido!",
            "¡Hola! Es un placer verte.",
            "¡Saludos! Esperamos que tengas un gran día.",
            "¡Qué alegría verte por aquí!",
            "¡Bienvenido de nuevo!"
        };
        int indiceAleatorio = (int) (Math.random() * mensajes.length);
        System.out.println(mensajes[indiceAleatorio]);
    }
    // 6. Función que dado dos número te devuelva la potencia de uno elevado al segundo. (sin usar Math.pow())
    public static double potencia(double base, int exponente) {
        double resultado = 1;
        for (int i = 0; i < Math.abs(exponente); i++) {
            resultado *= base;
        }
        return exponente < 0 ? 1 / resultado : resultado;
    }
    // 7. Función que imprime un menú de inicio.
    public static void imprimirMenu() {
        System.out.println("Menú de Inicio:");
        System.out.println("1. Opción 1");
        System.out.println("2. Opción 2");
        System.out.println("3. Opción 3");
        System.out.println("4. Salir");
    }
    // 8. Función que dada una palabra te devuelva si es un palíndromo.
    public static boolean esPalindromo(String palabra) {
        String palabraLimpia = palabra.replaceAll("\\s+", "").toLowerCase();
        int izquierda = 0;
        int derecha = palabraLimpia.length() - 1;
        while (izquierda < derecha) {
            if (palabraLimpia.charAt(izquierda) != palabraLimpia.charAt(derecha)) {
                return false;
            }
            izquierda++;
            derecha--;
        }
        return true;
    }
    public static void main(String[] args) {
    }
}