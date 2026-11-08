package PracticaYo;

public class Ejercicio2ValidarLiterales_TipodeLiteralySistemadeNumeracion {
    public static void main(String[] args) {
        // A. Indica cuál de los siguientes literales son válidos en Java. Si es válido, indica el tipo (int, long, float, double) y el sistema de numeración (edcimal, binario, octal, hexadecimal). Si el literal no es válido, explica por qué.
        /*
         * 123;             // Válido. Entero. Decimal.
         * 0b1010;          // Válido. Entero. Binario.
         * 077;             // Válido. Entero. Octal
         * 0x1F;            // Válido. Entero. Hexadecimal.
         * 0xG1;            // Inválido. La "G" no es un dígito hexadecimal.
         * 1_000_000;       // Válido. Entero. Binario.
         * 123_456_789L;    // Válido. Long. Decimal.
         * 12.34;           // Válido. Double. Decimal.
         * .56;             // Válido. Double. Decimal.
         * 1e3;             // Válido. Double. Decimal.
         * 1e-3;            // Válido. Double. Decimal.
         * 1.2e3F;          // Válido. Float. Decimal.
         * 0b102;           // Inválido. Solo 0 y 1 son permitidos en binario.
         * 0XABC;           // Válido. Entero. Hexadecimal.
         * 0x1A2B3C;        // Válido. Entero. Hexadecimal.
         * 0_123;           // Válido. Entero. Octal.
         * 0.12.3;          // Inválido, no se permiten tantos puntos.
         * 123_4.56;        // Válido. Double. Decimal. Se permiten guiones bajos entre números. 
         * 1_2_3_4L;        // Válido. Long. Decimal. Se permiten guiones bajos entre dígitos. 
         * 0b1101_1010;     // Válido. Entero. Binario.
         * 0xDEAD_BEEF;     // Válido. Entero o long. Hexadecimal.
         * 0X1G;            // Inválido. G no permitido en Hexadecimal.
         * _1234;           // No puede comenzar con "_".
         * 1.23E_4;         // Inválido. Un "_" no puede ir antes o después de una "E/e".
         * 3.14F;           // Válido. Float. Decimal.
         */
        //  Correcto. Corregido.

        // B. Indica cuáles son válidos en Java. Si no lo son, explica el motivo.
        /*
         * 'a';         // Válido.
         * 'Z';         // Válido.
         * '\n';        // Válido. Es una secuencia de escape.
         * '\t';        // Válido. Es una secuencia de escape.
         * '\\';        // Válido. Es una secuencia de escape.
         * '/';         // Creo que no válido.
         * '\u0041';    // Válido, se pueden usar Unicodes seguidos de 4 dígitos hexadecimales.
         * 'abc';       // Inválido, solo puede contener un carácter.
         * '"';         // Debería ser válido, es un símbolo individual.
         * 'ñ';         // Válido.
         * ' ';         // Válido, el espacio cuenta como un carácter.
         * '$';         // Válido, es un símbolo individual.
         * '';          // Inválido, no se puede dejar vacío.
         * '0';         // Válido, es un caracter numérico válido.
         * k;           // Inválido, debe ir entre comillas simples.
         * '+';         // Válido solo dentro de comillas simples.
         * '?';         // Válido, es un carácter válido.
         * 'â';         // Válido, es un carácter Unicode válido.
         * '€';         // Es un carácter unicode válido.
         * "a";         // Inválido, las comillas dobles indican un string, no un literal char.
         */
    }
}
