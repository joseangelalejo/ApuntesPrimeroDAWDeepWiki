import java.util.Scanner;
@SuppressWarnings({"unused", "all"})
public class Ex2Estructurasdecontrol {
    
    public static void main(String[] args) {

        // Estructuras de control ALTERNATIVAS
            // Estructura de control Simple: If
            int n = 3;
            int n1 = 9;
            if (n1 > n) {
                System.out.println(n1 + " Es mayor que" + n);       // En este ejemplo, el símbolo + no suma. Lo utilizamos para mostrar el valor de las variables `n1` y `n` que están declaradas
            }


            // Estructura de control Doble: If...Else

            if (n1 > n) {
                System.out.println(n1 + " Es mayor que" + n);       // En este ejemplo, el símbolo + no suma. Lo utilizamos para mostrar el valor de las variables `n1` y `n` que están declaradas
            }
            else {
                System.out.println(n1 + "No es mayor que" + n);     // Con "ELSE" establecemos lo que pasa cuando no se cumple "IF"
            }
        
        
            // Estructura de control Múltiple: Switch

            int dia = 2;
            switch (dia) {
                case 1:
                    System.out.println("Lunes");
                    break;                              // Usamos break para que no siga ejecutando los siguientes case.
                case 2:
                    System.out.println("Martes");       // En caso de no utilizar break, seguiría ejecutando los siguientes case hasta encontrar un break o finalizar el switch.
                    break;                              // Esto provoca una caida de flujo y puede ser útil en algunos casos.
                case 3:
                    System.out.println("Miercoles");
                    break;
                case 4:
                    System.out.println("Jueves");
                    break;
                case 5:
                    System.out.println("Viernes");
                    break;
                case 6, 7:                              // Podemos agrupar varios case que hagan lo mismo.
                    System.out.println("Sabado");
                    break;
                default:                                // El default es opcional. Se ejecuta si no se cumple ningún case.
                    System.out.println("Valor no valido");
                    break;
            }

            //Switch moderno
            // Desde Java 14 podemos usar switch de una forma más simplificada, usando flechas "->" en lugar de ":" y "break".
            // En este caso no es necesario usar "break", ya que la flecha indica el final del case.

            switch (dia) {
                case 1-> System.out.println("Lunes");
                case 2-> System.out.println("Martes");
                case 3-> System.out.println("Miercoles");
                case 6, 7-> System.out.println("Es fin de semana");
                default-> System.out.println("Valor no valido");        
            }

            // Podemos hacer que el Switch devuelva un valor y lo guarde en una variable. En este caso una variable String.
            String diaSemana;
            diaSemana = switch (dia) {
                case 1-> "Lunes";
                case 2-> "Martes";
                case 3-> "Miercoles";
                case 6, 7-> "Fin de semana";
                default-> "Valor no valido";
            };
            System.out.println(diaSemana);

            // IF-ELSE ANIDADOS
            // Los IF-Else anidados son aquellos que contienen dentro de su bloque otro IF-Else.
            // En IF-Else anidado, cuando se cumple una condición, se ignoran las demás condiciones.

            float nota = 7.5f;

            if (nota >= 0 && nota < 5){
                System.out.println("Suspenso");
            }
            else if (nota<6) {                          // No es necesario indicar que debe "nota>= 0 && nota<6". Se asume que será = o mayor a 0 al no cumplirse la condición IF anterior
                System.out.println("Suficiente");
            }
            else if (nota<7) {
                System.out.println("Bien");
            }
            else if (nota<9) {
                System.out.println("Notable");
            }
            else if (nota<=10) {
                System.out.println("Sobresaliente");
            }
            else if (nota>10 || nota<0) {               // Agregamos "|| nota<0" para controlar notas no válidas.
                System.out.println("Nota no válida");
            }
        
        // Estructuras de control BUCLES
        
            // Bucle While
                Scanner scanner = new Scanner(System.in);

                int num2 = 0;
                int suma = 0;
                while (suma <= 100) {
                    System.out.print("Introduce un número para sumar: ");
                    num2 = scanner.nextInt();                   // Leemos el número introducido por el usuario
                    suma = suma + num2;                         // Se puede indicar como suma += num2;
                }

            scanner.nextLine();              // Limpio el buffer del scanner para no afectar a la siguiente lectura.
            
            // Bucles Do...While
            
                int num3;

                do {
                    System.out.print("Introduce un número mayor que 0: ");
                    num3 = scanner.nextInt();
                } while (num3 < 0);                            // El bucle se repite mientras la condición sea verdadera.
            
            // Bucles For

            for (int num5=8 ; num5 <= 5 ; num5++) {         // Para num5 empezando en 8, mientras num5 sea menor o igual a 5, incrementa num5 en 1.
                System.out.println("Número: " + num5);

            }
        scanner.close();

        // Ejercicio de práctica: Pide un número por pantalla y muestra su tabla de multiplicar del 1 al 10.
        Scanner scanner2 = new Scanner(System.in);

        System.out.print("Introduce un número para ver su tabla de multiplicar: ");

        int numTabla = scanner2.nextInt();

        for (int multiplicador=1 ; multiplicador <=10 ; multiplicador++) {
            
            int resultado = numTabla * multiplicador;
            System.out.println(numTabla +  "x" +  multiplicador +  "=" +  resultado);
        }

        scanner2.close();
    }
   
}
