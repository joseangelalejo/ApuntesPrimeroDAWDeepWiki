import java.util.Arrays;
/** Apuntes sobre arrays de dos dimensiones tomados en clase a partir del dia 11 de Diciembre de 2025 */
public class Arrays2D {
    public static void main(String[] args) {
        // Declaración de un array de dos dimensiones para notas de alumnos.
            // Tipo de dato: float
            // Nombre del array: notas
            // Dimensiones: 2 filas (alumnos) y 3 columnas (notas)
        float notas[][] = new float[2][3];
        System.out.println("Filas del array notas: " + notas.length);
        // Declaración de un array de dos dimensiones para asientos de un cine.
            // Tipo de dato: boolean
            // Nombre del array: asientos
            // Dimensiones: 6 filas y 6 columnas
        boolean asientos[][] = new boolean[7][6];
        // Si un asiento está ocupado, se marca como true, si está libre, como false.
            // Por defecto, todos los asientos están libres (false).
            // Para "ocupar" asientos, por ejemplo, en la fila 3 los asientos 4 y 5:
        asientos[2][3] = true; // Fila 3, Asiento 4
        asientos[2][4] = true; // Fila 3, Asiento 5
        /*  Por otro lado, si quisieramos ocupar toda una fila, por ejemplo la fila 1,
            podemos declararlo con el método fill de la clase Arrays:
         */
        Arrays.fill(asientos[0], true); // Ocupa toda la fila 1
        // Para saber la longitud (cantidad) de filas y columnas del array asientos, usamos el método .length:
        System.out.println("Filas del array asientos: " + asientos.length);    // Cantidad de filas | Imprime 7
        System.out.println("Columnas del array asientos: " + asientos[0].length); // Cantidad de columnas | Imprime 6

        // También se pueden trabajar con Arrays irregulares (filas con diferente cantidad de columnas):
            // Para este ejemplo de asientos de cine, imaginemos que la primera fila tiene 2 asientos, la segunda 3, la tercera 4 y la cuarta 2.
            boolean asientosIrregulares[][] = new boolean[7][];
            asientosIrregulares[0] = new boolean[2]; // Fila 1 con 2 asientos (2 columnas)
            asientosIrregulares[1] = new boolean[3]; // Fila 2 con 3 asientos (3 columnas)
            asientosIrregulares[2] = new boolean[4]; // Fila 3 con 4 asientos (4 columnas)
            asientosIrregulares[3] = new boolean[2]; // Fila 4 con 2 asientos (2 columnas)
            /* Aquí lo que estamos haciendo es:
                1. Declarar un array de booleanos llamado asientosIrregulares con 7 filas y sin definir las columnas.
                2. Luego, para cada fila, definimos la cantidad de columnas (asientos) que tendrá.
                3. Por defecto, todos los asientos estarán libres (false).
             */
            // Si quisieramos ocupar asientos de manera:
                // Todos de la fila 1(0)
                // Primero y último de la fila 2(1)
                // Ninguno de la fila 3(2)
                // Segundo de la fila 4(3)
                Arrays.fill(asientosIrregulares[0], true); // Ocupa toda la fila 1
                asientosIrregulares[1][0] = true; // Ocupa primer asiento de la fila 2
                asientosIrregulares[1][2] = true; // Ocupa último asiento de la fila 2
                // La fila 3 queda libre
                asientosIrregulares[3][1] = true; // Ocupa segundo asiento de la fila 4
    }
}