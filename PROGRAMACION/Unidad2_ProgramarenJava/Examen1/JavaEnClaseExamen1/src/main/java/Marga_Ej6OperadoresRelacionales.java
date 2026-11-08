@SuppressWarnings({"unused", "all"})
public class Marga_Ej6OperadoresRelacionales {
    public static void main(String[] args) {
        
        // A partir de las siguientes declaraciones de variables:
        int i=8;
        int j=5;
        float x= 0.005F;
        float y= -0.1F;
        char c = 'c';
        char d = 'd';

        // Determina el valor de las siguientes expresiones.
        /*
         * i <= j;              //  falso.
         * c > d;               //  falso, porque en codigo ASCII, las letras aumentan su valor en el abecedario, y las minúsculas valen mas que las mayúsculas.
         * x >= 0;              //  Verdadero. Es mayor.
         * x < y--;             //  (primero comparas, luego decrementas) falso, x vale más.
         * j != y;              //  Verdadero, si son diferentes.
         * c == 99;             //  Verdadero, 'c' en ASCII vale 99.
         * !(i <= j);           //  Verdadero, "!" cambia el valor, entonces 5 vale menos que 8.
         * !(c == 99);          //  Verdadero, "c" minúscula en ascii vale 99.
         * !(x > 0);            //  Falso. El valor dado a X es mayor,al invertir símbolos, deja de cumplirse true.
         * -j == i-13;          //  Verdadero. -5 es igual a 5-13.
         * ++x > 0;             //  Verdadero. Primero hace el incremento, y luego hace la operación con el valor ya incrementado.
         * y-- < 1;             //  Verdadero. Primero hace la comparación, y tras obtener true o false, se hace el decremento.
         * c > d || c > 0;      //  Verdadero. La primera condición es false, la segunda es true, así que true.
         * 5 * (i + j) > 'c';   //  Falso. El resultado de la operación de la primera condición no es mayor al valor de 'c en ASCII'. 
        */ 
        
        //Correcciones:
        /*
         * i <=j;               //  Correcto.
         * c > d;               //  Correcto.
         * x >= 0;              //  Correcto.
         * x < y--;             //  Correcto.
         * j != y;              //  Correcto. Es distinto.
         * c == 99;             //  Correcto. 'c' en ASCII vale 99.
         * !(i <= j);           //  Correcto.
         * !(c == 99);          //  Correcto.
         * !(x > 0);            //  Correcto. Es false.
         * -j == i-13;          //  Correcto.
         * ++x > 0;             //  Correcto. ++x (que es 1.005) es mayor a 0.
         * y-- < 1;             //  Correcto.
         * c > d || c > 0;      //  Correcto.
         * 5 * (i + j) > 'c';   //  Correcto.
        */
        
        
    }
}
