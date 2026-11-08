package PracticaYo;

@SuppressWarnings({"unused", "all"})
public class Ejercicio7_2ExpresionesAlgoritmicas {
    public static void main(String[] args) {
        
        //  7.2 Escribe las expresiones algorítmas equivalentes para cada uno de los siguientes enunciados:
        
        //  1. Comprobar si un número entero num de 3 cifras es mayor que 500 y menor que 800.
        int num = 350;
        boolean expr1 = (num>500 && num<800);

        //  2. Obtener la suma de las centenas y decenas de un número entero N de 3 cifras.
        int N = 346;
        int expr2 = (N%1000)/100 + (N%100)/10;
        System.out.println(expr2);

        //  3. Duplicar el valor de una variable entera M.
        int M = 30;
        M = M * 2;
        System.out.println(M); 

        //  4. Calcular la diferencia entre el producto de A y B y la resta de C menos D.
        int A = 15;
        int B = 30;
        int C = 50;
        int D = 5;

        int expr4 = (A*B) - (C-D);
        System.out.println(expr4);

        //  5. Obtener la última cifra de un número entero P y comprobar si es par.
        int P = 1234;
        int expr5 = P%10;
        boolean esPar = (expr5%2==0);
        System.out.println(esPar);

        //  6. Suma de todos los dígitos de un número entero Q de 4 cifras.
        int Q = 1234;
        int expr6 = Q/1000 + (Q%1000)/100 + (Q%100)/10 + Q%10;
        System.out.println(expr6);

        //  7. Eliminar la primera cifra de un número entero R de 5 cifras.
        int R = 47689;
        int expr7 = R%10000;
        System.out.println(expr7);
    }    
}
