public class Ej1_EstructurasdeControl {
    
    public static void main(String[] args) {
        // Indica la estructura de control a usar para cada enunciado Y desarrollalo (sin usar Scanner).

        // 1 - Calificación con letras => Pide una calificación (A, B, C, D, F) y muestra un mensaje acorde (ejemplo: "Excelente" para A)
        
        System.out.println("Por favor, introduzca su nota A, B, C, D o F");

        char calificacion = 'A';
        switch (calificacion) {
            case 'A' -> System.out.println("Excelente");
            case 'B' -> System.out.println("Aprobado");
            case 'C' -> System.out.println("Suficiente");
            case 'D', 'F' -> System.out.println("Suspenso");
        }
        
        // 2 - Determinar si un número ingresado por el usuario es un múltiplo de 5. 

        System.out.println("Por favor, ingrese un número para saber si es múltiplo de 5");
        
        int n2 = 3;         // Sería el número que introduce el usuario (contemplo que podría usarse Scanner)
        int nM = 5;         // El número 5, por si quisieramos usar un número distinto a 5 introducido por el usuario.
        // Podemos hacerlo con booleando, simplemente declaramos " boolean divisible;"
        if (n2%nM == 0) {                                       // Comprobamos con "==" si el resto de los dos números es igual a 0
            System.out.println("Es múltiplo de 5");
        }
        else {
            System.out.println("No es múltiplo de 5");
        }

        // Ejemplo usando boolean
        boolean divisible;

                if (n2%nM == 0) {                                       // Comprobamos con "==" si el resto de los dos números es igual a 0
            divisible = true;
        }
        else {
            divisible = false;
        }
        System.out.println("¿" + n2 + " divisible entre" + nM + "? ->" + divisible);
        
        // 3 - Realiza un algoritmo que reciba un carácter (letra) ingresado por el usuario y determine si es mayúscula o minúscula.
        System.out.println("Por favor ingrese una letra para saber si es mayúscula o minúscula");

        char letraUsuario = 'a';
        
        if (letraUsuario>=65 && letraUsuario<=90) {
            System.out.println("Es mayúscula");
        } else if (letraUsuario>=97 && letraUsuario<=122) {             // Los "else if" siempre necesitan una condición
            System.out.println("Es minúscula");
        } else {                                                        //Los "else" no necesitan condicion.
            System.out.print("Otro caracter");
        }

    }
}
