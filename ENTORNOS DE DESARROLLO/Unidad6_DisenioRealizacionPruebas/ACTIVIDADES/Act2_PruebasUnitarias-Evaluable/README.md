# **Proyecto de Pruebas Unitarias en C#**

## Descripción

Este es un proyecto de consola C# que demuestra la implementación de pruebas unitarias usando xUnit. El proyecto incluye una clase `Operaciones` con métodos matemáticos básicos y un conjunto completo de pruebas unitarias.

## Estructura del Proyecto

```
PruebasUnitarias.slnx (Solución principal)
├── Calculadora/ (Proyecto principal)
│   ├── Calculadora.csproj
│   ├── Program.cs (Aplicación de consola)
│   └── Operaciones.cs (Clase con los métodos)
└── CalculadoraTests/ (Proyecto de pruebas)
    ├── CalculadoraTests.csproj
    └── UnitTest1.cs (Pruebas unitarias)
```

## Requisitos Previos

- .NET 10.0 o superior
- Visual Studio 2026 o Visual Studio Code
- Conocimiento básico de C# y pruebas unitarias

## Métodos Implementados

### Clase Operaciones

1. **Suma(double a, double b)** - Suma dos números
2. **Resta(double a, double b)** - Resta dos números
3. **Multiplicar(double a, double b)** - Multiplica dos números
4. **Dividir(double a, double b)** - Divide dos números (lanza excepción si divisor es cero)
5. **Iguales(double a, double b)** - Devuelve true si dos números son iguales

## Pruebas Unitarias

El proyecto incluye **20 pruebas unitarias** que cubren:

### Pruebas de Suma (3 pruebas)

- Suma de dos números positivos
- Suma de números negativos
- Suma de cero más un número

### Pruebas de Resta (4 pruebas)

- Resta de dos números positivos
- Resta cuando el minuendo es menor
- Resta de números iguales
- Resta con números negativos

### Pruebas de Multiplicación (4 pruebas)

- Multiplicación de números positivos
- Multiplicación por cero
- Multiplicación de números negativos y positivos
- Multiplicación de dos números negativos

### Pruebas de División (4 pruebas)

- División de números positivos
- División por cero (manejo de excepciones)
- División con números negativos
- División de cero entre un número

### Pruebas de Iguales (4 pruebas)

- Comparación de números iguales
- Comparación de números diferentes
- Comparación de ceros
- Comparación de números negativos iguales

### Prueba Intencional con Fallo (1 prueba)

- Una prueba diseñada para fallar (demostrativo)

## Uso

### Ejecutar la Aplicación de Consola

```bash
dotnet run --project Calculadora
```

Esto mostrará ejemplos de operaciones y manejo de excepciones.

### Ejecutar las Pruebas Unitarias

```bash
dotnet test
```

Esto ejecutará todas las pruebas. El resultado mostrará:

- 19 pruebas exitosas
- 1 prueba con error intencional (para demostración)

### Compilar el Proyecto

```bash
dotnet build
```

## Resultados Esperados

### Ejecución de Consola

```
=== CALCULADORA DE PRUEBAS UNITARIAS ===

--- Ejemplos de operaciones ---
Suma(10, 5) = 15
Resta(10, 5) = 5
Multiplicar(10, 5) = 50
Dividir(10, 5) = 2
Iguales(5, 5) = True
Iguales(5, 3) = False

--- Intentando dividir por cero ---
Error capturado: El divisor no puede ser cero
```

### Resultados de Pruebas

```
Resumen de pruebas: total: 20; con errores: 1; correcto: 19; omitido: 0
```

## Framework de Pruebas

- **xUnit**: Framework de pruebas usado para crear las pruebas unitarias
- **Assert**: Métodos de aserción para validar resultados

### Métodos Assert Utilizados

- `Assert.Equal()` - Verifica igualdad
- `Assert.True()` - Verifica que la expresión sea verdadera
- `Assert.False()` - Verifica que la expresión sea falsa
- `Assert.Throws<>()` - Verifica que se lance una excepción específica

## Características Demostradas

1. ✅ Clase con múltiples métodos
2. ✅ Pruebas unitarias con xUnit
3. ✅ Diferentes tipos de aserciones
4. ✅ Manejo de excepciones
5. ✅ Pruebas exitosas y con fallos
6. ✅ Documentación de código con comentarios XML
7. ✅ Patrón Arrange-Act-Assert (AAA)
8. ✅ Casos de uso variados (positivos, negativos, casos especiales)

## Entrega de la Actividad

Según los requisitos de la actividad, se incluyen:

1. ✅ Método `Resta` que toma dos números y devuelve la resta
2. ✅ Pruebas unitarias para verificar `Suma` y `Resta`
3. ✅ Método que verifica si dos números son iguales
4. ✅ Prueba unitaria para verificar igualdad
5. ✅ Métodos `Multiplicar` y `Dividir`
6. ✅ Pruebas unitarias para cada caso de uso
7. ✅ Uso de diferentes métodos en Assert
8. ✅ Video de ejecución (código disponible en los archivos)

## Autor

Actividad de clase evaluable - Pruebas Unitarias

## Fechas

- Creación: 2026-05-13
- Lenguaje: C#
- Framework: .NET 10.0
