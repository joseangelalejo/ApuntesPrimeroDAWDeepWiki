public class Ej8_SentenciasAlternativas {
    public static void main(String[] args) {
        
        // Resuelve los siguientes enunciados

        // 1 - Pide tu edad y responde con un mensaje gracioso según el rango: niño, adolescente, adulto, “¿eres un viajero del tiempo?” (>120).
            System.out.println("Indica tu edad");
            int edadUsuario = 66;
        
            if (edadUsuario>120) {
                System.out.println("¿Eres un viajero del tiempo?");
            } else if (edadUsuario>4 && edadUsuario<15) {
                System.out.println("Eres un niño");
            } else if (edadUsuario>=15 && edadUsuario<22) {
                System.out.println("Eres un adolescente");
            } else if (edadUsuario>22 && edadUsuario<50) {
                System.out.println("Eres un adulto");
            } else if (edadUsuario>=50 && edadUsuario<120 && edadUsuario!=65) {
                System.out.println("Es usted un anciano");
            } else if (edadUsuario==65) {
                System.out.println("¡Tu debes ser Emmet Brown! Me encanta tu Delorean :D");
            } else {
                System.out.println("Introduzca una edad mayor a 4");
            }
        // Correcto pero mal optimizado?
        // 2 - Pide un número y muestra “parece mágico” si es múltiplo de 7 y 11 a la vez.
            System.out.println("Indica un número para saber si es múltiplo de 7 y de 11");

            int nUser = 23;
            if (nUser%7 == 0 && nUser%11==0); {
                System.out.println("¡Parece mágico!");
            }

        // 3 - Pide una letra y muestra si es vocal normal, vocal con tilde o consonante.


        // 4 - Pide un número y responde si es perfecto (la suma de sus divisores = número) o no.


        // 5 - Pide tu peso y altura y calcula IMC; muestra un mensaje raro según el resultado: “peso pluma”, “equilibrio zen”, “peso galáctico”.
            // Si quisiera que pesoUsuario y alturaUsuario fuera introducido por el usuario, usaría Scanner.

            System.out.println("Indica tu peso en kg");
            double pesoUsuario = 70.5;                          

            System.out.println("Indica tu altura en metros");
            double alturaUsuario = 1.75;

            double imc = pesoUsuario / (alturaUsuario * alturaUsuario);

            if (imc<18.5) {
                System.out.println("Peso pluma");
            } else if (imc>=18.5 && imc<24.9) {
                System.out.println("Equilibrio zen");
            } else if (imc>=25) {
                System.out.println("Peso galáctico");
            }
            //Está bien, pero puedo usar float en lugar de double, ya que no requiere tanta precisión.

        // 6 - Pide un número y muestra si su doble es mayor que 100, igual a 100, o muy pequeño.
            System.out.println("Indique un número para saber si su doble es mayor que 100, igual o muy pequeño");

            int numero6 = 30;           // Este sería el número que introduce el usuario. Para ello usaría un scanner.

            int dobleNumero2 = (numero6*2);

            if (dobleNumero2>100) {
                System.out.println("Es mayor a 100");
            } else if (dobleNumero2==100){
                System.out.println("Es igual a 100");
            } else {
                System.out.println("Es menor a 100");
            }
            // Es correcto

        // 7 - Pide una letra y muestra si es mayúscula valiente, minúscula tímida, o otra criatura rara.


        // 8 - Pide un número y responde si es divisible por la suma de sus dígitos (número curioso) o no.
            System.out.println("Indica un número");

            int numero8 = 100;      // Sería el número introducido por el usuario

            int sumadigitos = (numero8%1000)/100 + (numero8%100)/10 + numero8%10;

            if (numero8%sumadigitos==0) {
                System.out.println("Número curioso");
            } else {
                System.out.println("Número no curioso");
            }
            //
    }
}
