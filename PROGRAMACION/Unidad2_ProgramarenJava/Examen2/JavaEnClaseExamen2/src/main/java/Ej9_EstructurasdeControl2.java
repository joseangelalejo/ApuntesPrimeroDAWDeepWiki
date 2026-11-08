import java.util.Scanner;

public class Ej9_EstructurasdeControl2 {
    
    public static void main(String[] args) {
        
    // 9. Resuelve los siguientes enunciados:
        // 1. Pide al usuario una distancia en kilómetros y que elija un modo de transporte (autobús, coche, bicicleta, caminar). Muestra el tiempo estimado para llegar al destino (en horas) suponiendo que la velocidad media para cada modo es:
            // Autobús = 90km/h.    |   Coche  = 90km/h     |   Bicileta = 12Km/h       |   Caminar = 5km/h

            Scanner scanner = new Scanner(System.in);               // Creo el objeto scanner para leer datos por teclado

            System.out.println("Indique su medio de transporte: 1) Autobús o Coche | 2) Bicicleta | 3) Caminando");

            int medioTransporte = scanner.nextInt();

            System.out.println("Indique la distancia que quiere recorrer en kilómetros:");
            double distancia = scanner.nextDouble();

            int velocidadMedia=0;         // Creo la variable int velocidadMedia y le doy un valor temporal.

            if (medioTransporte == 1) {                 // Uso una estructura if-else para asignar la velocidad media según el transporte elegido. Reemnplaza al 0.
                velocidadMedia = 90;
            } else if (medioTransporte == 2) {
                velocidadMedia = 12;
            } else if (medioTransporte == 3) {
                velocidadMedia = 5;
            } else {
                System.out.println("Medio de transporte no válido.");
            }
            // Para comprobar funcionalidad con Debugger agregar breakpoint en línea 22.

                // Realmente, al ser valores fijos sería mas óptimo usar un Switch Moderno, sería de la siguiente manera:

                switch (medioTransporte) {
                    case 1 -> velocidadMedia = 90;
                    case 2 -> velocidadMedia = 12;
                    case 3 -> velocidadMedia = 5;
                }
                // Para comprobar funcionalidad con Debugger agregar breakpoint a línea 36.

        //double tiempoHoras = (distancia/velocidadMedia);        // Calculo el tiempo en Horas. Para redondear a 4 decimales usaría:
                                                                    double tiempoHoras = Math.round((distancia/velocidadMedia)*10000) /10000.0;
                                                                    // Otra opción si quiero redondear a 4 decimales pero sólo en la salida de datos usaría System.out.printf, pero aún no se usarlo.

        int tiempoMinutos = (int)(tiempoHoras * 60);            // Convierto el tiempo a minutos, y utilizo un casteo a int para redondear el resultado.

        // Muestro el resultado según el transporte elegido.
        
            // Usando Switch moderno
                switch (medioTransporte) {
                    case 1 -> System.out.println("El tiempo estimado en llegar a su destino en Autobús o Coche es de: "  + (tiempoMinutos) + " minutos.");
                    case 2 -> System.out.println("El tiempo estimado en llegar a su destino en Bicicleta es de: "  + (tiempoMinutos) + " minutos.");
                    case 3 -> System.out.println("El tiempo estimado en llegar a su destino Caminando es de: "  + (tiempoMinutos) + " minutos.");
                    default -> System.out.println("Medio de transporte no válido.");

                }

                // Utilizar breakpoint en línea 38 para comprobar funcionamiento con Debugger.

            // Usando if-else
                if (medioTransporte == 1) {
                    System.out.println("El tiempo estimado en llegar a su destino en Autobús o Coche es de: " + (tiempoHoras) + " horas.");
                } else if (medioTransporte == 2) {
                    System.out.println("El tiempo estimado en llegar a su destino en Bicicleta es de: " + (tiempoHoras) + " horas.");
                } else if (medioTransporte == 3) {
                    System.out.println("El tiempo estimado en llegar a su destino Caminando es de: " + (tiempoHoras) + " horas.");
                } else {
                    System.out.println("Medio de transporte no válido.");
                }
                // Utilizar breakpoint en línea 49 para comprobar funcionamiento con Debugger.

        // A falta de corregir en clase
        
            // A PARTIR DE AQUÍ ES EXTRA, NO LO PIDE EL ENUNCIADO PERO LO AÑADO YO PARA PRACTICAR MÁS:
                // Si además quisiera mostrar el tiempo en horas o minutos según la preferencia del usuario, eliminaría/comentaría el bloque Switch Moderlo y el segundo bloque if-else podría hacerlo así:
                    System.out.println("¿Desea ver el tiempo en horas o minutos? (H/M)");
                    char eleccion = scanner.next().toUpperCase().charAt(0);             // Leo la opción del usuario y la paso a mayúscular para evitar errores. Con "".charAt(0)"" obtengo el primer carácter de la cadena (por si el usuario escribe mas de una letra).

                    if (eleccion == 'H') {
                        System.out.println("Tiempo estimado en Horas: " + tiempoHoras);          // Uso printf en lugar de println porque printf me permite formatear mejor la salida si quisiera, utilizando %f para números decimales.
                    } else if (eleccion == 'M') {
                        System.out.println("Tiempo estimado en Minutos: " + tiempoMinutos);
                    } else {
                        System.out.println("Opción no válida. Mostrando tiempo en minutos por defecto.");
                        System.out.println("Tiempo estimado: " + tiempoMinutos);
                    }

                    // Para usar comentar líneas 35 a 55 o utilizar breakpoint en línea 61 para comprobar funcionamiento con Debugger.

                // Si quisiera usar una mezcla de If-Else con Switch para mostrar la respuesta el tiempo en Horas o Minutos y que cambie la respuesta según el transporte sería:
                    if (eleccion == 'H') {
                        // Switch para elegir el nombre del medio y mostrar tiempo en horas
                        switch (medioTransporte) {
                            case 1 -> System.out.println("Su tiempo estimado en horas para Autobús/Coche es: " + tiempoHoras);
                            case 2 -> System.out.println("Su tiempo estimado en horas para Bicicleta es: " + tiempoHoras);
                            case 3 -> System.out.println("Su tiempo estimado en horas para Caminar es: " + tiempoHoras);
                            default -> System.out.println("Medio de transporte no válido. No se puede calcular tiempo en horas.");
                        }
                    } else if (eleccion == 'M') {
                        // Switch para elegir el nombre del medio y mostrar tiempo en minutos
                        switch (medioTransporte) {
                            case 1 -> System.out.println("Su tiempo estimado en minutos para Autobús/Coche es: " + tiempoMinutos);
                            case 2 -> System.out.println("Su tiempo estimado en minutos para Bicicleta es: " + tiempoMinutos);
                            case 3 -> System.out.println("Su tiempo estimado en minutos para Caminar es: " + tiempoMinutos);
                            default -> System.out.println("Medio de transporte no válido. No se puede calcular tiempo en minutos.");
                        }
                    } else {
                        System.out.println("Opción no válida. Mostrando tiempo en minutos por defecto.");
                        switch (medioTransporte) {
                            case 1 -> System.out.println("Su tiempo estimado en minutos para Autobús/Coche es: " + tiempoMinutos);
                            case 2 -> System.out.println("Su tiempo estimado en minutos para Bicicleta es: " + tiempoMinutos);
                            case 3 -> System.out.println("Su tiempo estimado en minutos para Caminar es: " + tiempoMinutos);
                            default -> System.out.println("Medio de transporte no válido.");
                        }
                    }
                    // Para usar comentar líneas 35 a 72 o utilizar breakpoint en línea 76 para comprobar funcionamiento con Debugger.

        // 2. Realiza un programa que clasifique un triángulo tras recibir el tamaño de sus lados. Se debe clasificar como triángulo:
            // Equilátero = Tres lados iguales.     |   Isósceles = Dos lados iguales, uno diferente.       |   Escaleno = Tres lados diferentes.
            
                System.out.println("Ejercicio 2: Clasificación de un triángulo según sus lados.");

                scanner.nextLine();         // Limpio el buffer del scanner por si acaso, para que no de errores con los valores almacenados en el ejercicio anterior.

                System.out.println("Introduzca la longitud del primer lado del triángulo:");
                double lado1 = scanner.nextDouble();
                
                System.out.println("Introduzca la longitud del segundo lado del triángulo:");
                double lado2 = scanner.nextDouble();

                System.out.println("Introduzca la longitud del tercer lado del triángulo");
                double lado3 = scanner.nextDouble();

                // Bloque If-Else para clasificar el triángulo según los valores introducidos.

                    if (lado1==lado2 && lado2==lado3) {
                        System.out.println("El triángulo es Equilátero");
                    } else if (lado1==lado2 && lado2!=lado3 || lado1==lado3 && lado3!=lado2 || lado2==lado3 && lado3!=lado1){
                        System.out.println("El triángulo es Escaleno");
                    } else {
                        System.out.println("El triángulo es Isósceles");
                    }
                
                    // Si quisieramos ahorrarnos tantas condiciones en elseif para Escaleno, cambiariamos y sería elseif para Isósceles y Else para Escaleno. Seria:
                    /*if (lado1==lado2 && lado2==lado3) {
                        System.out.println("El triángulo es Equilátero");
                    } else if (lado1!=lado2 && lado2!= lado3){
                        System.out.println("El triángulo es Escaleno");
                    } else {
                        System.out.println("El triángulo es Isósceles");
                    }
                    */

            // La primera forma es correcta, pero es menos óptima que la segunda manera.

        // 3. El director de una escuela está organizando un viaje de estudios y requiere determinar cuánto debe cobrar a cada alumno y cuánto debe pagar a la compañía de viajes por el servicio. El precio que debe pagar cada alumno se compone de dos partes:​
            // Un coste por alumno que depende del número de alumnos:
                // 65 euros si son 100 o mas.    |  70 euros si son entre 50 y 99.   |    95 euros si son entre 30 y 49.   | 110 euros si son menos de 30.
            // Importe de autobús = 400 euros independientemente del número de alumnos.

            // Realiza un algoritmo que saque por pantalla lo que debe pagar cada alumno por el viaje y el importe total a pagar a la compañía de viajes., en función del número de alumnos.
            
            System.out.println("Ejercicio 3: Viaje escolar - Pago alumnos - Pago a compañia de transportes");

            scanner.nextLine();         // Limpio el buffer del scanner por si acaso, para que no de errores con los valores almacenados en el ejercicio anterior.

            System.out.println("Indica cuántos alumnos van a asistir");

            int nAlumnos = scanner.nextInt();           // Uso un scanner con tipodato INT para que el usuario indique la cantidad de alumnos.

            int tarifaAlumno = 0;

            // Estructura de Control IF-ELSE para establecer la tarifa por alumno según la cantidad de alumnos

                if (nAlumnos >= 100) {
                    tarifaAlumno = 65;
                } else if (nAlumnos >= 50 && nAlumnos<99) {
                    tarifaAlumno = 70;
                } else if (nAlumnos>=30 && nAlumnos<=49) {
                    tarifaAlumno = 95;
                } else if (nAlumnos<=0){
                    System.out.println("Número de alumnos no válido.");
                }
                else {
                    tarifaAlumno = 110;
                }

            int tarifaAutobus = 400;                                    // Importe fijo por el autobús, si fuera necesario que lo introdujera el usuario lo haría de la siguiente manera:
                /*
                 * double tarifaAutobus = scanner.nextDouble();
                 * Y ajustaría el cálculo de int pagoCompañía para que sea un double redondeado a 2 decimales. Sería;
                 * double pagoCompañía = Math.round((tarifatotalAlumnos + tarifaAutobus) * 100.0) / 100.0;
                 */

            int tarifatotalAlumnos = (tarifaAlumno*nAlumnos);           // Calculo de la cantidad total a pagar por cantidad de alumnos.

            

            int pagoCompañia = tarifaAlumno + tarifaAutobus;             // Calculo del pago total a la compañía de transportes. Si lo hiciera con double, como indiqué en la linea 189 sería:
            //  double pagoCompañía = Math.round((tarifatotalAlumnos + tarifaAutobus) * 100.0) / 100.0;
            
            System.out.println("El pago por alumno para: " + nAlumnos + " es de " + tarifaAlumno + " con total de " + tarifatotalAlumnos + " euros");
            System.out.println("Y el pago total a la compaía sería de: " + pagoCompañia + " euros" + " para un importe de autobús de " + tarifaAutobus + " euros" + " y un pago total por cantidad de alumnos de " + tarifatotalAlumnos + " euros");

            // Extra en -> [Ej9_EstructurasdeControlEXTRAJA.java](./Ej9_EstructurasdeControlEXTRAJA.java)


        // 4. Una compañía de transporte internacional tiene servicio de envío a algunos países de América del Norte, América Central, América del Sur, Europa y Asia. 
            // El coste por servicio depende del peso del paquete y el país de destino:​
            //  America del norte → 24euros/kg    | América del sur → 20euros/kg    |   Europa → 10euros/kg     |   Asia → 15euros/kg   |   África → 20euros/kg
            
            // Parte de su política implica que los paquetes con un peso superior a 30kg no son transportados, por cuestiones de logística y seguridad.​ 
            
            //Realiza un algoritmo para determinar el cobro por la entrega de un paquete o, en su caso, el rechazo de la entrega.​

            scanner.nextLine();         // Limpio el buffer del scanner por si acaso, para que no de errores con los valores almacenados en el ejercicio anterior.

            System.out.println("Ejercicio 4: Compañia transporte - Cobro por entrega O - Rechazo de entrega(paquete>30kg)");

            System.out.println("Indique el peso del paquete en kg:");

            double pesoPaquete = scanner.nextDouble();

            while (pesoPaquete <= 0 || pesoPaquete > 30) {                  // Uso while para asegurarme que el peso del paquete no es negativo, cero o mayor a 30kg.
                System.out.println("Indique un peso válido:");
                pesoPaquete = scanner.nextDouble();
            }

            System.out.println("Indique el continente de destino: 1) América del Norte | 2) América del Sur | 3) Europa | 4) Asia | 5) África");
            int continenteDestino = scanner.nextInt();

            while (continenteDestino < 1 || continenteDestino > 5) {
                System.out.println("Continente no válido.");
                System.out.println("Indique un continente válido: 1) América del Norte | 2) América del Sur | 3) Europa | 4) Asia | 5) África");
                continenteDestino = scanner.nextInt();
            }

            double costePorKg = 0;          // Valor temporal para costePorKg
            
            // Uso Switch Moderno para asignar valor a costePorKg según el continente de destino.
            switch (continenteDestino) {
                case 1 -> costePorKg = 24;
                case 2 -> costePorKg = 20;
                case 3 -> costePorKg = 10;
                case 4 -> costePorKg = 15;
                case 5 -> costePorKg = 20;
                default -> System.out.println("Continente no válido.");
            }

            double costeTotalEnvio = Math.round((costePorKg * pesoPaquete) * 100.0) / 100.0; // Calculo el coste total y lo redondeo a dos decimales usando Math.round y operaciones matemáticas.

            System.out.println("El coste total de envío del paquete es: " + costeTotalEnvio + " euros");


        scanner.close();
    }
}
