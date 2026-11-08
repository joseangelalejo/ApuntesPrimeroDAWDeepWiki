public class Marga_Ej4ConversionesdeTipoDatos {
    public static void main(String[] args) {
        
        //1. A partir de las siguientes declaraciones de variables:
        /*
         * byte b;
         * short s;
         * long ln;
         * int i, j;
         * float f;
         * double d;
         * char c;
         */

        // Determina cuál es el tipo de dato del resultado de las siguientes expresiones:
        //Pista: Si haces operaciones con distintos tipos de datos, prevalece el tipodato mayor.
         /*
          * i + c;          //  entero + char dará entero.
          * f-c;            //  Será float
          * 5.2 /j;         //  double / entero dará un número double.
          * d + i;          //  double + entero dará un double.
          * j - 4L * 2.5F;  //  entero - long * float . Dará un float, que es el mayor.
          * s + j;          //  short + entero dará un entero.
          * 'a' + c;        //  usar "+" trata los "char" como "int" (enteros), por lo que int + int = int
          * i * f * 2.5;    //  entero * float * double dará un double.
          * d + c;          //  double + char dará un double.
        */

        //2. A partir de las siguientes declaraciones de variables:
        /*
         * byte b;
         * short s;
         * long ln;
         * int i, j;
         * float f;
         * double d;
         * char c;
        */

        // Indica en cada caso si la instrucción es válida o si se requiere una conversión explícita (casting) para que compile: 
        // Se hará conversión cuando el tipodato resultante de una operación es mayor al tipodato al que se asigna el resultado.
         /*
          * int z = b + s;          // Válida. byte + short dá un short, que se puede guardar en un int. No hace falta conversión
          * float x = i / f;        // Válida. entero / float es un float. Un float se puede almacenar en un float.
          * char ch = c + i;        // Inválida. char + entero da entero ; hay que hacer conversión explícita para almacenar en char. El casting explícito sería: char ch = (char)(c+i);
          *
          * long l = ln + i;        //  long + entero es long, se puede guardar en un long.
          * double r = d-f;         //  double - float es double. Se puede almacenar en double.  
          * float y = j * 3.5F;     //  float * float es float. La conversión se hace de manera implícita.
          * short y = s + 100000;   //  short + entero da entero. Hacemos conversion explicita.
          *                         El casting sería short y = (short)(s + 100000);
          *
          * byte nb = b * c;        // byte * char da un entero, hay que hacer conversión para almacenarlo en un byte.
          *                         Sería byte nb = (byte)(b*c);
          *
          * float w = f + d;        // float + double da double. Double necesita conversión para convertirlo a float.
          *                         Sería float w = (float)(f + d);
          *
          * double res = ln / 2.0;  // long + double dará un double. Double se puede almacenar en un double.
          */
        //
    }
}
