import java.util.Scanner;

public class Act14_EntradaSalidaSistema1 {
    public static void main(String[] args) {
        // 1. Calculo de IMC
            // Pide al usuario en este orden: Edad, peso en kg, altura en metros, su nombre,
            // Calcula su IMC con fórmula IMC = peso / (altura * altura)
            // Muestra los datos introducidos y el valor de su IMC con dos decimales. 
            // Indica también la categoría de peso según el IMC. 
            // Menor de 18.5= bajo peso
            // Entre 18 y 25(no incluido) = Normal
            // Entre 25 y 30(no incluido) = Sobrepeso
            // 30 o más = Obesidad
            Scanner scanner1 = new Scanner(System.in);  // Creacion scanner1 para enunciado 1
            System.out.print("Calculo de IMC\n");
            System.out.println("Introduce tu edad");
            int edad = scanner1.nextInt();
            System.out.println("Introduce tu peso en kg");
            double peso = scanner1.nextDouble();
            System.out.println("Introduce tu altura en metros");
            double altura = scanner1.nextDouble();
            scanner1.nextLine();
            System.out.println("Introduce tu nombre");
            String nombre = scanner1.nextLine();
            double IMC = peso / (altura * altura);
            System.out.printf("Nombre: %s\nEdad: %d\nPeso: %.2f kg\nAltura: %.2f m\nIMC: %.2f\n", nombre, edad, peso, altura, IMC);
            if (IMC < 18.5) {
                System.out.println("Categoría de peso: Bajo peso");
            } else if (IMC >= 18.5 && IMC < 25) {   // Con poner IMC < 25 basta, porque con la primera condición ya obviamos que será mayor o igual a 18.5
                System.out.println("Categoría de peso: Normal");
            } else if (IMC >= 25 && IMC < 30) {     // Basta con poner IMC < 30
                System.out.println("Categoría de peso: Sobrepeso");
            } else if (IMC >= 30) {System.out.println("Categoría de peso: Obesidad");}
            scanner1.close();   // Cierre de Scanner 1
        // 2. Calcular costo de un viaje. 
            // Pide al usuario:
                // Nombre
                // Distancia a recorrer en kilómetros(decimal)
                // Consumo de combustible (litros por cada 100km, decimal)
                // Precio del litro de combustible (decimal)
                // Destino del viaje (palabra o frase)
            // Calcula:
                // Litros totales usados → litros = (distancia * consumo) / 100
                // Costo total del viaje → costo = litros * precio
            // Mostrar un mensaje final personalizado
                // "¡Buen viaje, [nombre]!  El costo para llegar a [destino] será de [X.YZ] euros"
            Scanner scanner2 = new Scanner(System.in);  // Creacion scanner2 para enunciado 2
            System.out.println("Calcular costo de viaje\n");
            System.out.println("Introduzca su nombre: ");
            String nombre2 = scanner2.nextLine();
            System.out.println("Introduzca la distancia a recorrer en kilometros: ");
            float distancia = scanner2.nextFloat();
            System.out.println("Introduzca el consumo de combustibles de su vehículo cada 100km: ");
            float consumo = scanner2.nextFloat();
            System.out.println("Introduzca el precio del combustible: ");
            float precioCombustible = scanner2.nextFloat();
            scanner2.nextLine();    // Salto en el buffer antes de leer un string
            System.out.println("Introduzca el nombre de su destino");
            String destino = scanner2.nextLine();
            float litrosUsados = (distancia * consumo) / 100;
            float costoViaje = litrosUsados * precioCombustible;
            System.out.printf("¡Buen viaje, %s! El costo para llegar a %s será de %.2f euros", nombre2, destino, costoViaje );
            scanner2.close();   // Cierre scanner2
        //3. Ejercicio raro pero ideal para practicar muchas cosas.
            // Mostrar menú tal que:
            // Bienvenido al Menú de Cálculos. Elige una opción:
                // 1 - Área de un rectángulo
                // 2 - Comprobación de mayor edad
                // 3 - Saludo personalizado
                // 4 - Salir
                // Implementar switch que se repita mientras no se elija salir
            // Opción 1: Área de un rectángulo
                // Pide base y altura
                // Calcula el área → area = base * altura;
                // Muestra "El área del rectángulo es X.YZ"
            // Opción 2 - Comprobación de mayor de edad
                // Pide edad
                // Pregunta ¿Tiene permiso de sus padres? booleano
                // Lógica:
                    // Si edad >= 18 → "Eres mayor de edad"
                    // Si edad < 18 y permiso = true → "Eres menor pero con permiso"
                    // Si edad <18 y permiso = false → "Eres menor y sin permiso"
                    // Se muestra el mensaje acorde a la lógica
            // Opción 3 - Saludo personalizado
                // Pide Nombre
                // Pide Ciudad
                // Muestra "Hola [nombre], ¿cómo está la vida en [ciudad]?"
            // Opción 4 - Salir
            Scanner scanner3 = new Scanner(System.in);  // Crear scanner3 para el menú
            System.out.println("\nBievenido al Menú de Cálculos\n Elige una opción introduciendo el entero que corresponde:\n 1) Área de un rectángulo\n 2) Comprobación de mayor de edad\n 3) Saludo personalizado\n 4) Salir");
            int menu3 = scanner3.nextInt();     // Primera lectura de la opción para entrar en el While
            while (menu3 !=4) {     // Bucle while para repetir el menú hasta que se elija salir
                switch (menu3) {    // Switch para las opciones del menú (es un Switch "moderno")
                    case 1 -> {             // Apertura Case 1
                        System.out.print("\nIntroduzca la base como decimal: ");
                        float base = scanner3.nextFloat();
                        System.out.print("\nIntroduzca la altura como decimal: ");
                        float altura2 = scanner3.nextFloat();
                        float area = base * altura2;
                        System.out.printf("\nEl área del rectángulo para base: %.2f y altura %.2f es: %.2f \n", base, altura2, area);
                    } case 2 -> {           // Ciere Case 1 y Apertura Case 2
                        System.out.println("Introduce tu edad como entero");
                        int edad2 = scanner3.nextInt();
                        System.out.println("¿Tienes permiso de tus padres? Introduce 1 para Si. 2 para No.");
                        boolean tienePermiso = true;    // Boolean que establece si tiene permiso. Por defecto, true
                        int permiso = scanner3.nextInt();
                        if (permiso!=1) {tienePermiso=false;}   // If para que si permiso = 2, entonces tienePermiso=false (no tiene permiso)
                        // If para mostrar un mensaje según las distintas condiciones especificadas en el enunciado. Utilizamos el boolean tienePermiso
                        // El escaner para permiso y el if para asignación de permiso, si queremos usar un scanner.nextBoolean con boolean tienePermiso = scanner.nextBoolean(); reemplazará de la línea 120 a 122
                        if (edad2 >=18) {
                            System.out.println("Eres mayor de edad\n");
                        } else if ( edad2<18 && tienePermiso) {
                            System.out.println("Eres menor de edad pero tienes permiso\n");
                        } else if (edad2<18 && tienePermiso==false) {
                            System.out.println("Eres menor y sin permiso\n");
                        }
                    } case 3 -> {           // Cierre Case 2 y apertura Case 3
                        scanner3.nextLine();    // Salto en el buffer, porque vamos a leer un String (cadena)
                        System.out.println("Introduce tu Nombre");
                        String nombre3 = scanner3.nextLine();
                        System.out.println("Introduce el nombre de tu ciudad");
                        String ciudad3 = scanner3.nextLine();
                        System.out.printf("\nHola %s, ¿cómo está la vida en %s?\n", nombre3, ciudad3);
                    } case 4 -> { System.out.println("¡Adiós :D!"); }   // Cierre de Case 3 y, Apertura y Cierre Case 4
                }   // Cierre switch
                // Pequeño bloque de código para volver a mostrar el menú tras cada opción
                System.out.println("\nBievenido al Menú de Cálculos\n Elige una opción introduciendo el entero que corresponde:\n 1) Área de un rectángulo\n 2) Comprobación de mayor de edad\n 3) Saludo personalizado\n 4) Salir");
                menu3 = scanner3.nextInt();
            }   // Cierre de while
            scanner3.close();   // Cierre scanner3
    }

}
