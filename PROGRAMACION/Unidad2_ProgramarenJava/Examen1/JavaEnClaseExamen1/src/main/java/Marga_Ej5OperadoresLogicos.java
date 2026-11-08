public class Marga_Ej5OperadoresLogicos {
    
    public static void main(String[] args) {
        
        // Operadores lógicos o puertas lógicas: Son AND, OR y NOT.
            // AND -> && (Doble ampersand)          | Sintaxis a && b
            // OR  -> || (Doble barra)              | Sintaxis a || b
            // NOT -> !  (Signo de exclamación)     | Sintaxis !a

        // Para las siguientes variables tipo boolean:
        boolean x = true;
        boolean y = false;
        boolean z = true;

        // Determina el valor de las siguientes expresiones lógicas:

        boolean resultado1= (x && y) || (x && z);       // Si (x AND y) OR (x AND z) son true, entonces true.
        System.out.println(resultado1);

        boolean resultado2= (x || !y) && (!x || z);     // Si (x OR y negado) y (!x OR z) son true, entonces true.
        System.out.println(resultado2);

        boolean resultado3= (x || y && z);              // Si x OR (y AND z) son true, entonces true.
        System.out.println(resultado3);
        
        boolean resultado4= !(x || y) && z;             // Si (x OR y) negado y z son true, entonces true. Pero (x OR y) es true, luego negado es false. false AND true = false.
        System.out.println(resultado4);

        boolean resultado5= (y || x && !z && !y);       // Si (x && !z) es false, entonces (x && !z && !y) será automáticamente false por cortocircuito. Por tanto, y || (x && !z && !y) se convierte en false || false, y la expresión final da false.
        System.out.println(resultado5);
        
        boolean resultado6= (!x || z && x && !y);       // Si ( z AND x AND !Y) son true, entonces (!x OR true) seria (false OR true), luego true.
        System.out.println(resultado6);
    }
}
