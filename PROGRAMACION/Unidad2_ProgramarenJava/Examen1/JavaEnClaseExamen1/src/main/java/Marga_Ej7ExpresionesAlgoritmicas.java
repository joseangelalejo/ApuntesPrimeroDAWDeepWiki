public class Marga_Ej7ExpresionesAlgoritmicas {
    public static void main(String[] args) {
        // Escribe las expresiones algorítimas equivalentes para cada uno de los siguientes enunciados:

        // 1. Comprobar si el contenido de la variable precio es igual o mayor que 10€ y menor que 50€
        float precio = 12.3F;
        boolean resultado1 = (precio>=10 && precio<50);
        System.out.println(resultado1);

        // 2. Comprobar si una variable A de tipo carácter contiene una letra mayúscula.
        char A = 'y';
        boolean resultado2 = (A>=65 && A<=90);
        System.out.println(resultado2);  // En este caso dará false.
        // El valor asignado a la variable A debe ser mayor o igual a 65, o menor o igual a 90.
        // Esto se debe a que las letras mayúsculas en ASCII van de 65 a 90.

        // 3. Modificar el valor de la variable entera X duplicando su valor.
        // Por ejemplo si N contiene el valor de 10, después de la operación contendrá el valor de 20.
        int x = 10;
        x = x*2;
        System.out.println(x);

        //4 La diferencia entre el producto de A por B y la suma de C más D.
        int a = 10;
        int b = 15;
        int c = 20;
        int d = 8;
        
        System.out.println(a*b -(c+d));

        // 5 La suma de la última cifra de los números enteros N y M.
        // Sería mas correcto hacer:
        int N = 20;
        int M = 25;
        int suma = (N%10) + (M%10);         // Los paréntesis no son necesarios, porque siempre se harán primero los "%" antes que la suma, por preferencia.
        System.out.println(suma);

        // 6 La suma de los dígitos de un número entero P de 3 cifras.
        int P = 123;
        suma = P/100+(P%100)/10 + P%10;
        System.out.println(suma);
        // Lo que hemos hecho es extrare los dígitos, sacando el resto que necesito mediante divisiones.
        // Y luego sumamos los restos. | P/100 = 1 ; (P%100)/10 es igual a 2 ; P%10 es igual a 3.

        // 7 Quitarle a un número entero J de 5 cifras su primera cifra. Por ejemplo, si J contiene valor 12345, después de la operación contendrá el valor 2345.
        int J = 12345;
        J = J%10000;        // Al hacer esto sacaremos el primer número y nos dará de resto las demás cifras.
        System.out.println(J);

    }
}
