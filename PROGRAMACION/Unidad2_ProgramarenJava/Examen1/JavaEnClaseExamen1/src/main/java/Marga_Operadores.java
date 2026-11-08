/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author José Ángel
 */
public class Marga_Operadores {
    
    public static void main(String[] args) {
    
        //En Java tenemos tres tipos de operadores: Aritméticos, los Relacionales y los Lógicos
    
        /*Los Aritméticos son:
            - -> menos (cambia signo)
            * -> multiplicar
            / -> dividir
            % -> (Módulo)
            El signo "="" es una asignación.
            Ejemplos:
        */
  
        int n1 = 3; //  n1 = 3
        int n2 = 4; //  n2 = 4
        double resultado1 = (double) n1 / n2;         // Para que la operación sea correcta hacemos un casting; indicamos en paréntesis en el dato que vamos a convertir.
        System.out.println(resultado1);

        double resultado2 = (double) n1 % n2;         // El módulo % NO indica el resultado de una división.
        System.out.println(resultado2);               // "%" Se utiliza para saber el resto de una división de 2 números.

        /*
        *   Podemos hacer contadores +1 o -1 usando:
        *   "++" -> Incrementa en 1
        *   "--" -> Reduce en 1.
        *    
        *   Cuando "++" o "--" se usa con una asignación puede dar problemas.
        *   Normalmente los usaremos como contadores.
        *   Hay dos formas de usarlo:
        *   
        *   Ejemplos:
        */
        
        // Ejemplo 1: Primero incrementa y luego asinga.
        int resultado3 = n1++;
        System.out.println(resultado3); // n1++ primero asigna y luego incrementa.
        
        // Ejemplo 2
        int resultado4 = ++n1;
        System.out.println(resultado4); // ++n1 primero incrementa y luego asigna.

        // Los Relacionales booleanos, se usan para hacer comparaciones y devuelven true or false
            /*
             * Entre ellos tenemos:
             *  ==  -> igual que            | Sintaxis a == b
             *  !=  -> diferente que        | Sintaxis a != b
             *  >   -> mayor que            | Sintaxis a > b
             *  <   -> menor que            | Sintaxis a < b
             * >=  -> mayor o igual que     | Sintaxis a >= b
             * <=  -> menor o igual que     | Sintaxis a <= b
             * 
             */
        
            // Ejemplos: vamos a preguntar si n1 es = n2.

                // Usar "==" pregunta si son iguales | Compara el objeto completo.
                //Ej:
                boolean resultado5 = n1==n2;
                System.out.println(resultado5);

                // Usar "!=" pregunta si son diferentes.
                //Ej:
                boolean resultado6 = n1!=n2;
                System.out.println(resultado6);     // Imprimirá true porque n1 y n2 son diferentes.
                System.out.println(!resultado6);    // El "!" delante de una variable booleana invierte su valor. Si es true lo convierte en false y viceversa.
            //

            /*  Hay que tener cuidado con los objetos. No se pueden usar RELACIONALES con objetos. Ejemplo:
                boolean resultado7;
                String cadena1 = "hola";
                String cadena2 = "hola";
                resultado7 = cadena1==cadena2;      // Para comparar objetos NO SE HACE ASÍ.
                System.out.println(resultado7);     // Funcionará pero no es correcto.´
            */
        
            //  
                /*
                Si comparo el valor de una variable a la que he asignado true y lo comparo con true:
                boolean v1 = true;
                boolean resultado8 = v1==true; // Pregunto si v1 es igual a true.
                System.out.println(resultado8); // Imprimirá true, porque efectivamente v1 vale true, pero es redundante y no se usa, no es correcto.
                */

                // Lo correcto es preguntar si el valor es false es false:
                boolean v2 = true;
                boolean resultado9 = v2==false;
                System.out.println(resultado9); // Imprimirá false, porque "v2" vale true.
            //

            // Otro operador relacional <= y >= . Se pueden usar >= y <= que, para preguntar si el valor de un booleano es mayor o igual o menor o igual.
                // Ejemplo:
                int edad = 18;
                boolean esMayor = edad >= 18; // Pregunto si la variable "edad" es mayor o igual que 18.
                System.out.println(esMayor); // Imprimirá true porque "edad" vale 18

                boolean esMenor = edad <= 20; // Pregunto si la variable "edad" es menor o igual que 18.
                System.out.println(esMenor); // Imprimirá false porque "edad" vale 18.
            //
        //

        // Operadores lógicos o puertas lógicas: Son AND, OR y NOT.
            // AND -> && (Doble ampersand)          | Sintaxis a && b
            // OR  -> || (Doble barra)              | Sintaxis a || b
            // NOT -> !  (Signo de exclamación)     | Sintaxis !a

            // Ejemplos:
            boolean a = true;
            boolean b = false;
            boolean c = true;

            // AND -> && - Con que una de las dos sea falsa, el resultado es falso. Ej:
            // Usar && en lugar de & nos ahorra tiempo, porque si la primera condición es falsa, no evalúa la segunda.
            boolean resultado10 = a && b; // true && false = false
            System.out.println(resultado10);

            // OR -> || - Con que una de las dos sea verdadera, el resultado es verdadero. Ej:
            boolean resultado11 = a || c; // true || true = true.
            System.out.println(resultado11);

            // NOT  -> !- Invierte el valor de una variable booleana. Ej:
            boolean resultado12 = !b; // b vale false, pero al poner el "!"
            System.out.println(resultado12);    // Imprimirá true porque el "!" invierte el valor de b.
            System.out.println(!resultado12);   // Usar ! dentro de un System.out.println invierte el valor de la variable. 

            // Podemos combinar varios operadores lógicos en una misma expresión.
                // Ejemplo:
                boolean resultado13 = (a && b) || (b || c) && !a; // El orden de las operaciones es: primero los paréntesis, luego el AND y por último el OR.
                System.out.println(resultado13); // Imprimirá false.
            //

        //
    
    }
       
}
