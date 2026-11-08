package PracticaYo;

@SuppressWarnings({"unused", "all"})
public class Ejercicio4_1ConversionesdeTipoDatos {
    public static void main(String[] args) {
        
        //1. A partir de las siguientes declaraciones de variables:
        byte b;
        short s;
        int i, j;
        long l;
        float f;
        double d;
        char c;


        // Determina cuál es el tipo de dato del resultado de las siguientes expresiones:
        //Pista: Si haces operaciones con distintos tipos de datos, prevalece el tipodato mayor.
        //byte → short → int → long → float → double
        //(char se trata igual que short/int)
        /*
        * b + s             //  byte + short = int (en operaciones aritméticas con tipos menores a int, todo se promociona a int antes de operar).
        * c * i             //  char + int = int, porque al usar operadores aritméticos con un char, se trata al char como int.
        * f / 2             //  float / 2(entero) = float.  creo.
        * 3.5 + i           //  double + entero = double.
        * l - j * 2.0F      //  long - float = float.
        * s + 'A'           //  short + char = int. Porque char se trata como int con operadores aritméticos, y int es mayor que short.
        * d - f + l         //  double - float = double.
        * i / 2L            //  entero / long = long.
        * 4.2F + 7.1        //  float + double = double.
        * 'z' + 10          //  char + entero = entero. Porque char se convierte en entero con operadores aritméticos, entonces entero + entero = entero.
        */


        //2. Indica en cada caso si la instrucción es válida o si se requiere una conversión explícita (casting) para que compile:
        // Pista: Se hace casting cuando el tipodato resultante de una operación es mayor al tipodato al que se le asigna el resultado.
        
        /*
        // 1
        int resultado1 = b + s;             //  Válida. byte + short = int.

        // 2
        short resultado2 = s + i;           //  Inválida. No se puede almacenar int en un short. Requiere casting. Seria:
        short resultado2 = (short)(s+i);

        // 3
        char resultado3 = c + 2;            //  Inválida. No se puede almacenar un entero en un char. Requiere casting: Sería:
        char resultado3 = (char)(c + 2);

        // 4
        float resultado4 = l + f;           //  Válida.

        // 5
        double resultado5 = d - i;          //  Válida.

        // 6
        byte resultado6 = b * c;            //  Inválida. "b" y "c" se convierten en int al usar operadores aritméticos, y no cabe en un byte. Hacemos casting.
        byte resultado6 = (byte)(b * c);

        // 7
        float resultado7 = f + d;           //  Inválida. Un double no se puede almacenar en un float. Requiere casting.
        float resultado7 = (float)(f + d);

        // 8
        short resultado8 = s * 2L;          //  Inválida. No se puede almacenar un long en un short. Requiere casting:
        short resultado8 = (short)(s * 2L);

        // 9
        double resultado9 = l / 3.0F;       //  Válido. Se puede almacenar float en un double.

        // 10
        long resultado10 = i + 10000000000L;    // Válido. Se puede almacenar un long dentro de otro long. 
        */

        // 2.2 Ahora con valores literales concretos:
        
        /*
        // 1
        int resultado1 = b + 50;        //  Válido, porque byte se convierte directamente a entero, y nit + int cabe en int.

        // 2
        short resultado2 = 300 + s;     // Inválido. Un entero no cabe en un short. Requiere casting:
        short resultado2 = (short)(300 + s);

        // 3
        char resultado3 = 'A' + 5;      //  Inválido. Un entero no cabe en un char. Requiere casting:
        char resultado3 = (char)('A' + 5);

        // 4
        float resultado4 = f + 3.5;     //  Inválido. Un decimal sin sufijo se entiende como double. Y un double no cabe en un float. Requiere casting:
        float resultado4 = (float)(f + 3.5);

        // 5
        double resultado5 = 10 + d;     //  Válido. Entero + double = double. Cabe en double.

        // 6
        byte resultado6 = b * 2;        //  Inválido. Int no cabe en un byte. Requiere casting.
        byte resultado6 = (byte)(b * 2);

        // 7
        float resultado7 = 2.5F + d;    //  Inválido. Un double no cabe en un float. Requiere casting.
        float resultado7 = (float)(2.5F + d);

        // 8
        short resultado8 = s + 1000;    //  Inválido. Un entero no cabe en un short. Requiere casting.
        short resultado8 = (short)(s + 1000);

        // 9
        double resultado9 = l / 2.0F;   //  Válido. Un float si cabe en un double.

        // 10
        long resultado10 = i + 10000000000L;    //  Válido. Un long si cabe en un long.

        */
    
    }
}
