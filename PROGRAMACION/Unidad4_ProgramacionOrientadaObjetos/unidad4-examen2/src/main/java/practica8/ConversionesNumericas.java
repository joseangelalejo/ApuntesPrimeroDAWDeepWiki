package practica8;

public class ConversionesNumericas {
    // Método para convertir Celsius a Fahrenheit: devolver (celsius * 9/5) + 32
    public double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    // Método para convertir Fahrenheit a Celsius: devolver (fahrenheit - 32) * 5/9
    public double convertirFahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    // Método para convertir Euros a Dólares: devolver euros * 1.1 (tasa aproximada)
    public double convertirEurosADolares(double euros) {
        return euros * 1.1;
    }

    // Método para convertir Dólares a Euros: devolver dolares / 1.1
    public double convertirDolaresAEuros(double dolares) {
        return dolares / 1.1;
    }
}