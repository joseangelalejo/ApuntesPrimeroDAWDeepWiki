/** Archivo java con "apuntes" de clase sobre Métodos para Arrays 2D el dia 16 de Diciembre e implementación de métodos realizados en actividades prácticas */
public class MetodosArrays2D_1 {
    public static void main(String[] args) {
        /** Comparar arrays 2D - deepEquals
         * Para comparar arrays 2D sin bucles, no podemos usar Arrays.equals() directamente,
         * usaremos el método `Arrays.deepEquals(array1, array2);`
         * Este método compara arrays multidimensionales.
         * Devuelve true si son iguales, false si no lo son.
         * Se consideran iguales si tienen la misma estructura (cantidad de filas y columnas)
         * y los mismos valores en cada posición.
        */
            // Ejemplo de uso, arrays iguales:
                int array1[][] = {{1,2,3}, {4,5,6}};
                int array2[][] = {{1,2,3}, {4,5,6}};
                boolean sonIguales1 = java.util.Arrays.deepEquals(array1, array2);
                System.out.println("¿Los arrays son iguales? " + sonIguales1); // Devolverá true
            // Ejemplo de arrays diferentes:
                int array3[][] = {{1,2,3}, {4,5,7}};
                boolean sonIguales2 = java.util.Arrays.deepEquals(array1, array3);
                System.out.println("¿Los arrays son iguales? " + sonIguales2); // Devolverá false
            /**Consideraciones:
             * 1. Compara el contenido de los arrays en todas sus dimensiones.
             * 2. Si los arrays tienen diferentes dimensiones o tamaños, devolverá false.
             * 3. Funciona correctamente para comparar arrays regulares con irregulares, pero
             * dará false si las estructuras no coinciden.
             * 4. Al comparar arrays de diferentes tipos de datos (ejemplo int[][] con String[][]),
             * devolverá false automáticamente.
             * 4.1 No sirve para comparar arrays de diferente tipo de datos a menos que
             * usemos bucles o métodos de conversión ().
             * 
             */
        /** Imprimir arrays 2D - deepToString
         * Para imprimir arrays 2D sin bucles, no podemos usar Arrays.toString() directamente,
         * usaremos el método `Arrays.deepToString(array);`
         */
            // Ejemplo de uso:
                int arrayImprimir[][] = {{10,20,30}, {40,50,60}, {70,80,90}};
                String representacionArray = java.util.Arrays.deepToString(arrayImprimir);
                System.out.println("Representación del array 2D: " + representacionArray);
                // La salida será: [[10, 20, 30], [40, 50, 60], [70, 80, 90]]
            /**Consideraciones:
             * 1. Convierte el array multidimensional en una cadena legible.
             * 2. Cada sub-array se representa entre corchetes.
             * 3. Es útil para depuración y visualización rápida de datos en arrays 2D.
             * 4. Funciona para arrays de cualquier tipo de datos (int, String, etc.).
             */
    }   
}
