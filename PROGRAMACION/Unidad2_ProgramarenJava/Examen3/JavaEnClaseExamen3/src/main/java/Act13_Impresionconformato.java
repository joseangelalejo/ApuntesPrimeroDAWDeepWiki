public class Act13_Impresionconformato {
    
    public static void main(String[] args) {
        String nombre = "Pepito";
        int edad = 25;

        float notaMedia = 4.997544f;
        float notaTruncada = (float) Math.floor(notaMedia * 100) / 100; // Trunca el float a 2 decimales sin redondear
        boolean aprobado = true;        // Booleano para determinar si está aprobado o no

        if (notaMedia <4.99){      // Lógica para determinar si está aprobado o no. Si la nota media es menor que 4,99, está suspenso. e imprime la tabla.
            aprobado = false;
            System.out.printf("%-20s | %-5s | %-12s | %-12s | %-8s%n", "Nombre", "Edad", "Nota Media", "Nota Truncada", "Aprobado");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-20s | %-5d | %-12.2f | %-12.2f | %-8s%n", nombre, edad, notaMedia, notaTruncada, aprobado ? "Si" : "No");
        } else {                // Si la nota media es mayor o igual a 4,99, está aprobado. e imprime la tabla.
            aprobado = true;        
            System.out.printf("%-20s | %-5s | %-12s | %-12s | %-8s%n", "Nombre", "Edad", "Nota Media", "Nota Truncada", "Aprobado");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-20s | %-5d | %-12.2f | %-12.2f | %-8s%n", nombre, edad, notaMedia, notaTruncada, aprobado ? "Si" : "No");
        }
        
        // Explicación del código:

        // En la tabla:
            //En el primer System.out.printf
                // "%-20s" imprime la cadena con un ancho fijo de campo de 20 caracteres, alineado a la izquierda.
                // "%-5s" imprime el entero con un ancho fijo de campo de 5
                // "%-12s" imprime el float con un ancho fijo de campo de 12 caracteres, alineado a la izquierda.
                // "%-12s" imprime el float truncado con un ancho fijo de campo de 12 caracteres, alineado a la izquierda.
                // "%-8s" imprime la cadena con un ancho fijo de campo de 8 caracteres, alineado a la izquierda y el %n al final indica un salto de línea.


            // En medio hay un System.out.println que imprime una línea de separación.

            // En el segundo System.out.printf:
                // "%-20s" imprime la variable nombre con un ancho fijo de campo de 20 caracteres, alineado a la izquierda.
                // "%-5d" imprime la variable edad como un entero con un ancho fijo de campo de 5 caracteres, alineado a la izquierda.
                // "%-12.2f" imprime la variable notaMedia como un float con 2 decimales y un ancho fijo de campo de 12 caracteres, alineado a la izquierda.
                // "%-12.2f" imprime la variable notaTruncada como un float con 2 decimales y un ancho fijo de campo de 12 caracteres, alineado a la izquierda.
                // "%-8s" imprime "Si" o "No" según el valor booleano aprobado, con un ancho fijo de campo de 8 caracteres, alineado a la izquierda.

                // Después de establecer los formateos, se indican las variables a las que se refiere en orden: nombre, edad, notaMedia y aprobado ? "Si" : "No"
                    // Respecto al valor "aprobado", a continuación se agrega una comprobación ternaria para imprimir "Si" si aprobado es true, o "No" si aprobado es false.


        // Extra JA - Hacer que el float notaMedia se calcule a partir de una variable nota, que aumentará su valor de uno en uno con un for, y el for se repetirá mientras una variable cuantasNotas sea menor que 10.

            // Aún no.

        
    }

    
}
