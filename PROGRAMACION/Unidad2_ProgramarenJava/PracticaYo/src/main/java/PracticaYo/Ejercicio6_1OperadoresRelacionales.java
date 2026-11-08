package PracticaYo;

@SuppressWarnings({"unused", "all"})
public class Ejercicio6_1OperadoresRelacionales {
    public static void main(String[] args) {
        
        // A partir de las siguientes declaraciones de variables:
        int a = 12;
        int b = -3;
        float p = 0.25F;
        float q = -0.75F;
        char m = 'A';
        char n = 'Z';

        // Determina el valor de las siguientes expresiones:
        /*
         * a > b;                   // True. 12 es mayor a -3.
         * m < n;                   // True. El valor ASCII de 'A' es menor que el valor de 'Z'
         * p <= q;                  // False. p es mayor que q.
         * a + b == 9;              // True.
         * p * 4 >= 1;              // True. Es igual.
         * !(a < 0);                // True. Era false, pero el "!" cambia valor.
         * n != 'Z';                // False. La variable n tiene asignado el valor de 'Z' en ASCII.
         * --a > b + 10;            // True. 11 es mayor que 7.
         * q++ < 0;                 // True. Porque primero compara, luego hace +1.
         * m == 65;                 // True. Porque 'A' en ASCII sí vale 65.
         * a + b * 2 <= 5;          // False. 12-6 = 6. Entonces 6 <= 5 es false.
         * m > 60 && n < 100;       // True. Porque 'A' = 65 y 'Z' = 90, asi que ambas son true. 
         * p > 0 || q > 0;          // True. Porque la primera condición es true.
         * !(m < n) || a < 20;      // True. Porque false or true es igual a true.
         * a - b > 'B';             // False. Porque 15 no es mayor que 66.
         */
    }
}
