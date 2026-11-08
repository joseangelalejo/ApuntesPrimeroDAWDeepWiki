import java.util.Scanner;

public class Ej9_EstructurasdeControlEXTRAJA {
public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);               // Creo el objeto scanner para leer datos por teclado

    // 3. El director de una escuela está organizando un viaje de estudios y requiere determinar cuánto debe cobrar a cada alumno y cuánto debe pagar a la compañía de viajes por el servicio. El precio que debe pagar cada alumno se compone de dos partes:​
    // Un coste por alumno que depende del número de alumnos:
        // 65€ si son 100 o mas.    |  70€ si son entre 50 y 99.   |    95€ si son entre 30 y 49.   | 110€ si son menos de 30.
    // Importe de autobús = 400€ independientemente del número de alumnos.

    // Realiza un algoritmo que saque por pantalla lo que debe pagar cada alumno por el viaje y el importe total a pagar a la compañía de viajes., en función del número de alumnos.
    
    System.out.println("Ejercicio 3: Viaje escolar - Pago alumnos - Pago a compañia de transportes");

    System.out.println("Indica cuántos alumnos van a asistir");

    int nAlumnos = scanner.nextInt();           // Uso un scanner con tipodato INT para que el usuario indique la cantidad de alumnos.

    int tarifaAlumno = 0;

    // Estructura de Control IF-ELSE para establecer la tarifa por alumno según la cantidad de alumnos

    boolean cantidadAlumnos=true;           // Por defecto la cantidad de Alumnos es true.
        if (nAlumnos >= 100) {
            tarifaAlumno = 65;
        } else if (nAlumnos >= 50 && nAlumnos<99) {
            tarifaAlumno = 70;
        } else if (nAlumnos>=30 && nAlumnos<=49) {
            tarifaAlumno = 95;
        } else if (nAlumnos<=0){
            System.out.println("Número de alumnos no válido.");
            cantidadAlumnos=false;
        }
        else {
            tarifaAlumno = 110;
        }
    
    // Extra - Se ejecutara o no dependiendo de si la cantidad de Alumnos es true o es false

    if (cantidadAlumnos){
        int tarifaAutobus = 400;                                    // Importe fijo por el autobús, si fuera necesario que lo introdujera el usuario lo haría de la siguiente manera:

        int tarifatotalAlumnos = (tarifaAlumno*nAlumnos);           // Calculo de la cantidad total a pagar por cantidad de alumnos.

        int pagoCompañia = tarifaAlumno + tarifaAutobus;             // Calculo del pago total a la compañía de transportes. Si lo hiciera con double, como indiqué en la linea 189 sería:
        //  double pagoCompañía = Math.round((tarifatotalAlumnos + tarifaAutobus) * 100.0) / 100.0;
        
        System.out.println("El pago por alumno para: " + nAlumnos + " es de " + tarifaAlumno + " con total de " + tarifatotalAlumnos + "€");
        System.out.println("Y el pago total a la compaía sería de: " + pagoCompañia + "€" + " para un importe de autobús de " + tarifaAutobus + "€" + " y un pago total por cantidad de alumnos de " + tarifatotalAlumnos + "€");
    } else {
        System.out.println("Introduzca un número de alumnos válido");

    }

    scanner.close();
    }
   
    
}
