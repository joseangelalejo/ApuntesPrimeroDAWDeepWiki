using Calculadora;

Operaciones calc = new Operaciones();

Console.WriteLine("=== CALCULADORA DE PRUEBAS UNITARIAS ===\n");

// Ejemplos de uso
Console.WriteLine("--- Ejemplos de operaciones ---");
Console.WriteLine($"Suma(10, 5) = {calc.Suma(10, 5)}");
Console.WriteLine($"Resta(10, 5) = {calc.Resta(10, 5)}");
Console.WriteLine($"Multiplicar(10, 5) = {calc.Multiplicar(10, 5)}");
Console.WriteLine($"Dividir(10, 5) = {calc.Dividir(10, 5)}");
Console.WriteLine($"Iguales(5, 5) = {calc.Iguales(5, 5)}");
Console.WriteLine($"Iguales(5, 3) = {calc.Iguales(5, 3)}");

Console.WriteLine("\n--- Intentando dividir por cero ---");
try
{
    var resultado = calc.Dividir(10, 0);
}
catch (ArgumentException ex)
{
    Console.WriteLine($"Error capturado: {ex.Message}");
}
