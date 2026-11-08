import java.util.Scanner;
public class PracticaExamen3EDJA {
    public static void main(String[] args) {
        // Archivo java para practicar Operadores lógicos, Scanner y estructuras de control de cara a tercer examen del módulo Entornos de Desarrollo
        // Actividad 1 - Operadores lógicos y IF: Pide al usuario su edad y si tiene DNI (true/false). Muestra "Puede entrar" solo si edad >=18 y tieneDNI es true.
            /* 
            Scanner scanner1 = new Scanner(System.in);
            boolean tieneDNI;
            System.out.println("Ingrese su edad:");
            int edad = scanner1.nextInt();
            System.out.println("¿Tiene DNI? Introduce 1 para SI. 2 para NO.");
            int dni = scanner1.nextInt();   
            switch (dni) {
                case 1 -> tieneDNI = true;
                case 2 -> tieneDNI = false;
                default -> tieneDNI = false;
            }
            // Se puede reemplazar el switch anterior por un scanner de boolean, pero se deja así para practicar Switch. Sería:
                // System.out.println("¿Tiene DNI? Introduce true para \"Si\" o false para \"No\":");
                // boolean tieneDNI = scanner1.nextBoolean();
            // De esta manera, eliminaríamos el switch, la variable dni y la declaración de tieneDNI de la línea 7.
            // Las líneas eliminadas serían 7 y 10-16. El código se reduciría de 17 a 11 líneas.
            if (edad>=18 && tieneDNI==true) {
                System.out.println ("Puede entrar");
            } else {
                System.out.println("No puede entrar");
            }
            scanner1.close();
            
        // Actividad 2 - Scanner y Switch antiguo: Pide un número del 1 al 7 y muestra el día de la semana usando switch con break.
            Scanner scanner2 = new Scanner(System.in);
            boolean diaValido;
            do {
                diaValido=true;
                System.out.println("Ingresa un número del 1 al 7:");
                int dia = scanner2.nextInt();
                switch (dia) {
                    case 1:
                        System.out.println("Es Lunes");
                        break;
                    case 2:
                        System.out.println("Es Martes");
                        break;
                    case 3:
                        System.out.println("Es Miércoles");
                        break;
                    case 4:
                        System.out.println("Es Jueves");
                        break;
                    case 5:
                        System.out.println("Es Viernes");
                        break;
                    case 6:
                        System.out.println("Es Sábado");
                        break;
                    case 7:
                        System.out.println("Es Domingo");
                        break;
                    default:
                        System.out.println("Número no válido. Introduzca un número válido, del 1 al 7");
                        diaValido = false;
                }
            } while (diaValido==false);
            scanner2.close();
            
        // Actividad 3 - IF-ELSE anidado: Pide un número entero. Si es positivo, verifica si es par; si no, impar. Si negativo, muestra "Negativo"; si cero, "Cero".
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Introduce un número entero");
        int num = scanner3.nextInt();
        if (num>0) {
            int resultado = num%2;
            if (resultado==0) {
                System.out.println("Es positivo y par");
            } else {
                System.out.println("Es positivo e impar");
            }
        }else if(num<0) {
            System.out.println("Es negativo");
        } else {
            System.out.println("Es cero");
        }
        scanner3.close();
        
        // Actividad 4 - While y Scanner: Pide números hasta que se ingrese 0. Suma los positivos y cuenta los negativos.
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Suma de números. Introduce 0 para salir.");
        int num4 = scanner4.nextInt();
        int suma = 0;
        int negativos=0;
        while (num4!=0) {
            if (num4>0) {
                suma += num4;
            } else {
                negativos++;
            }
            System.out.printf("\nResultado de suma: %d . Lleva %d negativos. \nIngrese 0 para salir u otro número para continuar: ", suma, negativos);
            num4 = scanner4.nextInt();
        }
        scanner4.close();
        
        // Actividad 5 - Do-While: Pide una contraseña ("1234") hasta 3 intentos. Si correcta, "Acceso concedido"; sino, "Denegado".
        Scanner scanner5 = new Scanner(System.in);
        final String contrasenaCorrecta = "1234";
        String contrasenaUsuario;
        int intentos = 3;
        boolean accesoConcedido = false;
        do {
            System.out.println("Introduce la contraseña:");
            contrasenaUsuario = scanner5.nextLine();
            intentos--;
            if (contrasenaUsuario.equals(contrasenaCorrecta)) {
                accesoConcedido = true;
                System.out.println("Acceso concedido");
            } else {
                System.out.printf("\nIncorrecta. Intentos restantes: %d%n", intentos);
            }
        } while (!accesoConcedido && intentos!=0);
        if (!accesoConcedido && intentos==0) {System.out.println("Acceso denegado.");}
        scanner5.close();
        
        // Actividad 6 - For y operadores lógicos: Recorre del 1 al 20. Si divisible por 3 y 5, "FizzBuzz"; por 3, "Fizz"; por 5, "Buzz"; sino, el número.
        for (int i=0; i<=20; i++) {
            if (i%3==0 && i%5==0) {
                System.out.println("FizzBuzz");
            } else if (i%3==0) {
                System.out.println("Fizz");
            } else if (i%5==0) {
                System.out.println("Buzz");
            } else {System.out.println(i);}
        }
        
        // Podemos hacer que tanto i como el número al que llegar lo introduzca el usuario usando scanner:
        Scanner scanner6 = new Scanner(System.in);
        System.out.println("Introduzca el número desde el que empezar: ");
        int ib = scanner6.nextInt();
        System.out.println("Introduzca el número hasta el que llegar");
        int num6 = scanner6.nextInt();
        if (ib<num6) {
            for (int i = ib;i<=num6; i++) {
                if (i%3==0 && i%5==0) {
                    System.out.println("FizzBuzz");
                } else if (i%3==0) {
                    System.out.println("Fizz");
                } else if (i%5==0) {
                    System.out.println("Buzz");
                } else {System.out.println(i);}
            }
        } else if (ib>num6){
            for (int i = ib;i>=num6; i--) {
                if (i%3==0 && i%5==0) {
                    System.out.println("FizzBuzz");
                } else if (i%3==0) {
                    System.out.println("Fizz");
                } else if (i%5==0) {
                    System.out.println("Buzz");
                } else {System.out.println(i);}
            }
        } else {
            System.out.print("Son iguales");
        }
        scanner6.close();
        // Actividad 7 - Switch moderno: Pide una letra y determina si es vocal o consonante usando switch con strings.
        Scanner scanner7 = new Scanner(System.in);
        System.out.println("Introduce una letra:");
        String letra = scanner7.nextLine().toLowerCase();
        switch (letra) {
            case "a", "e", "i", "o", "u" -> System.out.println("Es una vocal");
            default -> System.out.println("Es una consonante");
        }
        scanner7.close();
        */
        // Actividad 8 - Combinado (Scanner, IF-ELSE, operadores): Pide dos números y una operación (+,-,*,/). Realiza la operación; si inválida, "No soportada".
        Scanner scanner8 = new Scanner(System.in);
        System.out.print("\nIntroduzca el primer número: ");
        float n8a = scanner8.nextFloat();
        System.out.print("\nIntroduzca el segundo número: ");
        float n8b = scanner8.nextFloat();
        System.out.println("Indique la operación que desea realizar.\n1) Suma\n2) Resta\n3) Multiplicar\n4) Dividir");
        int operacion = scanner8.nextInt();
        switch (operacion) {
            case 1 -> System.out.println((n8a+n8b));
            case 2 -> System.out.println((n8a-n8b));
            case 3 -> System.out.println((n8a*n8b));
            case 4 -> {
                float resultado = (n8a/n8b);
                System.out.printf("\n %.3f", resultado);
            }
            default -> System.out.println("Opción no válida");
        }
        scanner8.close();
    }
}
