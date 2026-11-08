package practica7;

public class ProgramaPrincipal7 {
    public static void main(String[] args) {
        // 1. Crear una instancia de la clase DatosNumeros
        DatosNumeros datos1 = new DatosNumeros();

        // 2. Asignar valores a los campos numero1, numero2 y numero3 de la instancia
        datos1.numero1 = 3.3;
        datos1.numero2 = 7.7;
        datos1.numero3 = 15.0;
        
        // 3. Crear una instancia de la clase EstadisticasNumeros
        EstadisticasNumeros est1 = new EstadisticasNumeros();
        System.out.println("Los números son:\n" + "Numero 1: " + datos1.numero1 + "\nNumero 2: " + datos1.numero2 + "\nNumero 3: " + datos1.numero3);
        
        // 4. Llamar al método calcularPromedio pasando los números de DatosNumeros e imprimir el resultado
        System.out.println("\nEl promedio es: " + est1.calcularPromedio(datos1.numero1, datos1.numero2, datos1.numero3));
        
        // 5. Llamar al método encontrarMaximo pasando los números de DatosNumeros e imprimir el resultado
        System.out.println("EL numero mayor de los tres es: " + est1.encontrarMaximo(datos1.numero1, datos1.numero2, datos1.numero3));
        
        // 6. Llamar al método encontrarMinimo pasando los números de DatosNumeros e imprimir el resultado
        System.out.println("El número menor de los tres es: " + est1.encontrarMinimo(datos1.numero1, datos1.numero2, datos1.numero3));
        
        // 7. Llamar al método calcularSuma pasando los números de DatosNumeros e imprimir el resultado
        System.out.println("La suma de los tres números es: " + est1.calcularSuma(datos1.numero1, datos1.numero2, datos1.numero3));
    }
}