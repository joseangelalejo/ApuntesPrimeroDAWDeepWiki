package PracticaYo;

@SuppressWarnings({"unused", "all"})
public class Ejercicio7_1ExpresionesAlgoritmicas {
    public static void main(String[] args) {
        
        //  Escribe las expresiones algorítmas equivalentes para cada uno de los siguientes enunciados:
        
        //  1. Comprobar si el contenido de la variable precioProducto es mayor que 20€ y menor o igual que 80.
        float precioProducto = 25.5F;
        boolean expr1 = (precioProducto>20 && precioProducto<=80);
        System.out.println(expr1);

        //  2. Comprobar si una variable B de tipo carácter contiene una letra minúscula.
        char B = 'y';
        boolean expr2 = (B>='a' && B<='z');
        System.out.println(expr2);

        //  3. Modificar el valor de la variable entera Y triplicando su valor. Por ejemplo, si Y contiene 7, después contendrá 21.
        int Y = 7;
        Y = Y * 3;
        System.out.println(Y);

        //  4. La diferencia entre la suma de A y B y el producto de C por D.
        int a = 10;
        int b = 15;
        int c = 20;
        int d = 25;
        int expr4 = (a + b) - (c * d);
        System.out.println(expr4);

        //  5. La suma de la última cifra de los números enteros R y S.
        int R = 15;
        int S = 24;

        int expr5 = (R%10) + (S%10);
        System.out.println(expr5);

        //  6. La suma de los dígitos de un número entero Q de 4 cifras.
        int Q = 1234;
        int expr6 = Q/1000+(Q%1000)/100 + (Q%100)/10 + Q%10;
        System.out.println(expr6);

        //  7. Quitarle a un número entero K de 6 cifras sus dos primeras cifras. Por ejemplo, si K contiene 123456, después contendrá 3456.
        int K = 123456;
        K = K%10000;
        System.out.println(K);

    }
    
}
