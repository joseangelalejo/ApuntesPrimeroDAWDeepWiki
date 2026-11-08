package PracticaYo;

@SuppressWarnings({"unused", "all"})
public class Ejercicio5_1DeterminarValorExpresionesLogicas {
    public static void main(String[] args) {
        // Operadores lógicos o puertas lógicas: AND, OR y NOT.
            // AND -> && (Doble ampersand)          | Sintaxis a && b
            // OR  -> || (Doble barra)              | Sintaxis a || b
            // NOT -> !  (Signo de exclamación)     | Sintaxis !a
        
            // Orden de precedencia de los operadores lógicos:
                // 1. NOT
                // 2. AND
                // 3. OR
            // Regla de cortocircuito:
                // En una expresión lógica con operador AND, si el primero es false, el segundo no se evalúa porque es false.
                    // Por ejemplo: A && B; Si A es false, no se evalúa B porque el resultado será false.
                // En una expresión lógica con el operador OR, si el primer operando es true, no se evalúa el segundo operando porque el resultado final será true.
                    // Por ejemplo: A || B; Si A es true, no se evalúa B porque el resultado será true.
        
        // A. Determina el valor de las siguientes expresiones lógicas:
        // Para las siguientes variables tipo boolean:
        boolean x = true;
        boolean y = false;
        boolean z = true;

        // Determina el valor de las siguientes expresiones lógicas:

        boolean expr1= x && !y || z;                    //  true AND true OR true dá true.

        boolean expr2= !(x && y) || (y && !z);          //  true OR false dá true

        boolean expr3= (x || y) && (!x || !z);          //  true AND false da false
        
        boolean expr4= !(!x || y) && z;                 //  true AND true dará true

        boolean expr5= x && (y || !z) || (!y && z);     //  true AND false OR true = false OR true = true
        
        boolean expr6= !(x || !y) && (z || y);          // false AND true = false.
    }
}
