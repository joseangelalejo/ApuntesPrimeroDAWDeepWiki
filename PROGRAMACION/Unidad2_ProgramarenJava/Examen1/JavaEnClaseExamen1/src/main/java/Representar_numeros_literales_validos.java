@SuppressWarnings({"unused", "all"})
public class Representar_numeros_literales_validos {
    
    /* Investiga como se representan los números en los distintos sistemas de numeración.
    *  Indica cuáles de los siguientes literales son válidos en JAVA. Si el literal es válido indica además de qué tipo es (int, double, long, etc),
    *  y el sistema de numeración en el que está escrito (decimal, binario, octal, hexadecimal). Si el literal no es válido explica porqué no lo es. 
    */
        // Para representar números en distintos sistemas de numeración en Java se utilizan los siguientes prefijos:
        // Decimal: No tiene prefijo. Ejemplo: 42
        // Binario: Prefijo "0b" o "0B". Ejemplo: 0b101010
        // Octal: Prefijo "0". Ejemplo: 052
        // Hexadecimal: Prefijo "0x" o "0X". Ejemplo: 0x2A

    public static void main(String[] args) {
    
        double numero = 0.5;
        double numero1 = .5;
        double numero2 = 9.3e12;

        System.out.println(9.3e12);     // Válido. Es un número en notación científica (base 10) que representa 9.3 x 10^12.

        double numero3 = 9.3e-12;       // Válido. Es un número en notación científica (base 10) que representa 9.3 x 10^-12.
        System.out.println(9.3e-12);    // Válido. Es un número en notación científica (base 10) que representa 9.3 x 10^-12.

        int numero4 = 12345678;         // Válido. Es un número decimal (base 10).
        long numero5 = 12345678L;       // El sufijo "L" indica que es un literal de tipo long.
       
        //    System.out.println(0.8E+0.8);  // No válido. La notación científica no permite un exponente con punto decimal. Debería ser 0.8E8 o 0.8e8.
        //    System.out.println(0.8Ee8);     // No válido. La notación científica no permite un exponente con punto decimal. Debería ser 0.8E8 o 0.8e8.

        
        int numero6 = 05_15;            // Válido. Es un número octal (base 8) que representa el valor decimal 41.
        
        System.out.println(05_15);      // Válido. Es un número octal (base 8) que representa el valor decimal 41.
        
        System.out.println(0XBC5DA);    // Válido. Es un número hexadecimal (base 16) que representa el valor decimal 12345626.
        
        System.out.println(0x87e3a);    // Válido. Es un número hexadecimal (base 16) que representa el valor decimal 553866.
        
        long numero7 = 234567L;       // Válido. Es un número decimal (base 10) con el sufijo "L" que indica que es un literal de tipo long.
    
    
    }
}       
