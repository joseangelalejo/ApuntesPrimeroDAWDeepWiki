using Calculadora;
using Xunit;

namespace CalculadoraTests;

public class OperacionesTests
{
    private readonly Operaciones _operaciones;

    public OperacionesTests()
    {
        _operaciones = new Operaciones();
    }

    #region Pruebas de Suma
    [Fact]
    public void Suma_DosNumerosPositivos_DevuelveSuma()
    {
        // Arrange
        double a = 10;
        double b = 5;
        double esperado = 15;

        // Act
        double resultado = _operaciones.Suma(a, b);

        // Assert
        Assert.Equal(esperado, resultado);
    }

    [Fact]
    public void Suma_NumerosNegativos_DevuelveSuma()
    {
        // Arrange
        double a = -10;
        double b = -5;
        double esperado = -15;

        // Act
        double resultado = _operaciones.Suma(a, b);

        // Assert
        Assert.Equal(esperado, resultado);
    }

    [Fact]
    public void Suma_CeroMasNumero_DevuelveNumero()
    {
        // Arrange
        double a = 0;
        double b = 5;
        double esperado = 5;

        // Act
        double resultado = _operaciones.Suma(a, b);

        // Assert
        Assert.Equal(esperado, resultado);
    }
    #endregion

    #region Pruebas de Resta
    [Fact]
    public void Resta_DosNumerosPositivos_DevuelveResta()
    {
        // Arrange
        double a = 10;
        double b = 5;
        double esperado = 5;

        // Act
        double resultado = _operaciones.Resta(a, b);

        // Assert
        Assert.Equal(esperado, resultado);
    }

    [Fact]
    public void Resta_NumeroMenorAMayor_DevuelveNegativo()
    {
        // Arrange
        double a = 5;
        double b = 10;
        double esperado = -5;

        // Act
        double resultado = _operaciones.Resta(a, b);

        // Assert
        Assert.Equal(esperado, resultado);
    }

    [Fact]
    public void Resta_NumerosIguales_DevuelveCero()
    {
        // Arrange
        double a = 10;
        double b = 10;
        double esperado = 0;

        // Act
        double resultado = _operaciones.Resta(a, b);

        // Assert
        Assert.Equal(esperado, resultado);
    }

    [Fact]
    public void Resta_NumeroMenosNegativo_DevuelvePositivo()
    {
        // Arrange
        double a = 10;
        double b = -5;
        double esperado = 15;

        // Act
        double resultado = _operaciones.Resta(a, b);

        // Assert
        Assert.Equal(esperado, resultado);
    }
    #endregion

    #region Pruebas de Multiplicación
    [Fact]
    public void Multiplicar_DosNumerosPositivos_DevuelveMultiplicacion()
    {
        // Arrange
        double a = 10;
        double b = 5;
        double esperado = 50;

        // Act
        double resultado = _operaciones.Multiplicar(a, b);

        // Assert
        Assert.Equal(esperado, resultado);
    }

    [Fact]
    public void Multiplicar_NumeroPorCero_DevuelveCero()
    {
        // Arrange
        double a = 10;
        double b = 0;
        double esperado = 0;

        // Act
        double resultado = _operaciones.Multiplicar(a, b);

        // Assert
        Assert.Equal(esperado, resultado);
    }

    [Fact]
    public void Multiplicar_NumerosNegativosYPositivo_DevuelveNegativo()
    {
        // Arrange
        double a = 10;
        double b = -5;
        double esperado = -50;

        // Act
        double resultado = _operaciones.Multiplicar(a, b);

        // Assert
        Assert.Equal(esperado, resultado);
    }

    [Fact]
    public void Multiplicar_DosNumerosNegativos_DevuelvePositivo()
    {
        // Arrange
        double a = -10;
        double b = -5;
        double esperado = 50;

        // Act
        double resultado = _operaciones.Multiplicar(a, b);

        // Assert
        Assert.Equal(esperado, resultado);
    }
    #endregion

    #region Pruebas de División
    [Fact]
    public void Dividir_DosNumerosPositivos_DevuelveDivision()
    {
        // Arrange
        double a = 10;
        double b = 5;
        double esperado = 2;

        // Act
        double resultado = _operaciones.Dividir(a, b);

        // Assert
        Assert.Equal(esperado, resultado);
    }

    [Fact]
    public void Dividir_DividirPorCero_LanzaArgumentException()
    {
        // Arrange
        double a = 10;
        double b = 0;

        // Act & Assert
        Assert.Throws<ArgumentException>(() => _operaciones.Dividir(a, b));
    }

    [Fact]
    public void Dividir_NumerosNegativosYPositivo_DevuelveNegativo()
    {
        // Arrange
        double a = 10;
        double b = -5;
        double esperado = -2;

        // Act
        double resultado = _operaciones.Dividir(a, b);

        // Assert
        Assert.Equal(esperado, resultado);
    }

    [Fact]
    public void Dividir_CeroDividoPorNumero_DevuelveCero()
    {
        // Arrange
        double a = 0;
        double b = 5;
        double esperado = 0;

        // Act
        double resultado = _operaciones.Dividir(a, b);

        // Assert
        Assert.Equal(esperado, resultado);
    }
    #endregion

    #region Pruebas de Iguales
    [Fact]
    public void Iguales_DosNumerosIguales_DevuelveTrue()
    {
        // Arrange
        double a = 5;
        double b = 5;

        // Act
        bool resultado = _operaciones.Iguales(a, b);

        // Assert
        Assert.True(resultado);
    }

    [Fact]
    public void Iguales_DosNumerosDiferentes_DevuelveFalse()
    {
        // Arrange
        double a = 5;
        double b = 3;

        // Act
        bool resultado = _operaciones.Iguales(a, b);

        // Assert
        Assert.False(resultado);
    }

    [Fact]
    public void Iguales_AmbosCero_DevuelveTrue()
    {
        // Arrange
        double a = 0;
        double b = 0;

        // Act
        bool resultado = _operaciones.Iguales(a, b);

        // Assert
        Assert.True(resultado);
    }

    [Fact]
    public void Iguales_NumerosNegativosIguales_DevuelveTrue()
    {
        // Arrange
        double a = -5;
        double b = -5;

        // Act
        bool resultado = _operaciones.Iguales(a, b);

        // Assert
        Assert.True(resultado);
    }
    #endregion

    #region Pruebas con errores intencionales (para demostración)
    [Fact]
    public void PruebaQueDebeFallar_SumaIncorrecta_DevuelveFalse()
    {
        // Arrange
        double a = 10;
        double b = 5;
        double esperadoIncorrecto = 20; // Valor incorrecto intencional

        // Act
        double resultado = _operaciones.Suma(a, b);

        // Assert - Esta prueba fallará
        Assert.Equal(esperadoIncorrecto, resultado);
    }
    #endregion
}

