/** Archivo java con "apuntes" de clase sobre Arrays el dia 4 de Diciembre e implementación de métodos realizados en actividades prácticas */
import java.util.Arrays; // Importar clase Arrays, tiene métodos propios.
import java.util.Random; // Para generar valores aleatorios
public class ClasesArraysJAAlejo {
    public static void main(String[] args) {
        // Array inicial/original
        int numero[] = {15, 15, 6, 7, 9, 50};
        System.out.println("Array original: " + Arrays.toString(numero));

        // Método de clase Arrays para copiar números
        // Sintaxis tipodato nuevoArray[] = Arrays.copyOf(arrayacopiar, longitudacopiar);
        int numero1[] = Arrays.copyOf(numero, 3);
        /** Consideraciones del método
         * Con este método, declaramos un nuevo array a la vez que le aplicamos el método deseado.
         * Siempre empezará a copiar desde la izquierda hasta la derecha(posición 0)
         * Si la cantidad deseada a copiar es mayor, solo copiará la cantidad existente.
         */
        System.out.println("Copia de los primeros 3 elementos: " + Arrays.toString(numero1));

        // El método Arrays.copyOfRange permite copiar desde una posición exacta.
        /* Sintaxis de Arrays.copyOfRange es:
            tipodato nuevoArray[] = Arrays.copyOfRange(arrayFuente, desde, hasta);
        */
        int arrayCopynumero[] = Arrays.copyOfRange(numero, 2, 4);
        /** Consideraciones:
         * Las posiciones de los arrays a copiar se cuentan desde la izquierda, comenzando en 0.
         * Si el array tiene una longitud de 5 posiciones, las posiciones irán de 0 a 4.
         */
        System.out.println("Copia de rango (índices 2 a 3): " + Arrays.toString(arrayCopynumero));

        // Si quisieramos hacer la copia al revés, usariamos from array.length-n, to array.length
        int arrayCopyInverso[] = Arrays.copyOfRange(numero, (numero.length-3), numero.length);
        System.out.println("Copia de los últimos 3 elementos: " + Arrays.toString(arrayCopyInverso));

        // Método Arrays.fill para rellenar/sustituir valores
        boolean bol[] = new boolean[8];
        System.out.println("Array boolean por defecto: " + Arrays.toString(bol));
        // Por defecto imprimirá 8 false, por lo que si queremos que sean true:
        /* Sintaxis de Arrays.fill
            Arrays.fill(arrayoriginal, valorsustituir);
        */
        Arrays.fill(bol, true);
        /** Consideraciones de Array.fill:
         * Sustituirá todos los valores
         */
        System.out.println("Array boolean rellenado con true: " + Arrays.toString(bol));

        // Ejemplo de Arrays.fill con rango
        boolean asientos[] = new boolean[15];
        System.out.println("Asientos iniciales: " + Arrays.toString(asientos));
        Arrays.fill(asientos, 5, 11, true); // Rellena desde índice 5 hasta 10 con true
        System.out.println("Asientos ocupados (índices 5-10): " + Arrays.toString(asientos));

        /* Apuntes a partir del día 5 de Diciembre de 2025 */
        /** Consideración en cuanto a asignación de Arrays y otros objetos:
         * Cuando hacemos una asignación de un objeto (ejemplo "array1=array2;")
         * Lo que estamos haciendo es REFERENCIAR los valores en memoria del array2.
         * Es decir, el "array1" referenciará a "array2" y sus valores en memoria.
         * Por tanto, si cambiamos los valores de array2, cambiarán los de array1
         */
        System.out.println("\n--- Ejemplo de referencias en memoria ---");
        int[] array1 = {1, 2, 3};
        int[] array2 = array1; // Referencia
        System.out.println("array1 inicial: " + Arrays.toString(array1));
        array2[0] = 99; // Cambia array1 también
        System.out.println("Después de cambiar array2[0] a 99:");
        System.out.println("array1: " + Arrays.toString(array1));
        System.out.println("array2: " + Arrays.toString(array2));

        // Comparar arrays con Método de clase Arrays
        int numero5[] = {1,2,3,4,5};
        int numero6[] = {1,2,3,4,5};
        // Metodo Arrays.equals(array1, array2)
        if (Arrays.equals(numero5, numero6)) {
            System.out.println("\nArrays numero5 y numero6 son iguales");
        } else {
            System.out.println("\nArrays numero5 y numero6 NO son iguales");
        }
        /** Consideraciones de Arrays.equals
         * Devolverá true SÓLO cuando coincidan tanto su longitud como
         * los valores de cada posición
         */

        // Método para imprimir los valores de un array (sin usar for)
        // Método .toString lo que hace es convertir los valores almacenados a String
        System.out.println("Impresión con toString: " + Arrays.toString(numero5)); // Imprimirá los arrays con formato [pos1, pos2, pos3]

        // Método .sort para ordenar los valores de un Array
        int numero7[] = {1,15,100,24,7,15};
        System.out.println("Array antes de sort: " + Arrays.toString(numero7));
        /* Sintaxis Arrays.sort(nombreArray)
         */
        Arrays.sort(numero7);
        /** Consideraciones del método .sort
         * Por defecto, .sort ordenará de manera ascendente
         * NO creará un nuevo array, ordenará un array existente.
         * Los números los ordenará de menor a mayor (ascendente)
         * Si queremos hacer un .copyOf de un array (que hemos ordenado anteriormente),
         * haremos la copia del array ya ordenado
         */
        System.out.println("Array después de sort: " + Arrays.toString(numero7));

        // Muestra de uso de .copyOf tras .sort
        int[] numero7Copia = Arrays.copyOf(numero7, numero7.length);
        System.out.println("Copia del array ordenado: " + Arrays.toString(numero7Copia));

        // Ejemplo con Random para generar array aleatorio
        Random rand = new Random();
        int[] arrayAleatorio = new int[10];
        for (int i = 0; i < arrayAleatorio.length; i++) {
            arrayAleatorio[i] = rand.nextInt(51); // Números de 0 a 50
        }
        System.out.println("\nArray generado aleatoriamente: " + Arrays.toString(arrayAleatorio));

        // Ejemplo de printf con Arrays.toString
        System.out.printf("Array aleatorio usando printf: %s%n", Arrays.toString(arrayAleatorio));
    }
}
