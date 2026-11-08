package practica8;

public class ProgramaPrincipal8 {
    public static void main(String[] args) {
        // 1. Crear una instancia de la clase DatosConversiones
        DatosConversiones conver1 = new DatosConversiones();

        // 2. Asignar valores a los campos temperaturaCelsius y cantidadEuros de la instancia (por ejemplo, 25.0, 100.0)
        conver1.temperaturaCelsius = 20.0;
        conver1.cantidadEuros = 81.0;

        // 3. Crear una instancia de la clase ConversionesNumericas
        ConversionesNumericas cnum1 = new ConversionesNumericas();
        
        // 4. Llamar al método convertirCelsiusAFahrenheit pasando la temperatura de DatosConversiones e imprimir el resultado
        double tempFahrenheit = cnum1.convertirCelsiusAFahrenheit(conver1.temperaturaCelsius);
        System.out.println("\n" + conver1.temperaturaCelsius + " Celsius en Fahrenheit es: " + tempFahrenheit);
        
        // 5. Llamar al método convertirFahrenheitACelsius pasando el resultado anterior e imprimir el resultado
        System.out.println(tempFahrenheit + " Fahrenheit en Celsius es: " + cnum1.convertirFahrenheitACelsius(tempFahrenheit));
        
        // 6. Llamar al método convertirEurosADolares pasando la cantidad de DatosConversiones e imprimir el resultado
        double cantDolares = cnum1.convertirEurosADolares(tempFahrenheit);
        System.out.println(conver1.cantidadEuros + " en dolares es: " + cantDolares);
        
        // 7. Llamar al método convertirDolaresAEuros pasando el resultado anterior e imprimir el resultado
        System.out.println(cantDolares + " en euros es: " + cnum1.convertirDolaresAEuros(cantDolares));
    }
}