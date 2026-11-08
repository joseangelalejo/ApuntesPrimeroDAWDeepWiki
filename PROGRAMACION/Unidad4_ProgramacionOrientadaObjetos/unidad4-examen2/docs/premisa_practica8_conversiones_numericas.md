# Práctica de Métodos de Instancia: Conversiones Numéricas

## Objetivo

Crear un programa en Java que realice conversiones numéricas (temperaturas y monedas) utilizando métodos `public` (de instancia). El enfoque está en el uso de métodos de instancia, operaciones aritméticas y fórmulas simples, sin elementos avanzados de POO.

## Requisitos

- **Clase de Datos**: Crea una clase llamada `DatosConversiones` que contenga variables para almacenar valores (tipo `double`): temperaturaCelsius y cantidadEuros.
- **Clase de Conversiones**: Crea una clase llamada `ConversionesNumericas` con métodos `public` para:
  - Convertir Celsius a Fahrenheit: Recibe celsius, devuelve (celsius * 9/5) + 32 (tipo `double`).
  - Convertir Fahrenheit a Celsius: Recibe fahrenheit, devuelve (fahrenheit - 32) * 5/9 (tipo `double`).
  - Convertir Euros a Dólares: Recibe euros, devuelve euros * 1.1 (tipo `double`).
  - Convertir Dólares a Euros: Recibe dolares, devuelve dolares / 1.1 (tipo `double`).
- **Clase Principal**: Crea una clase llamada `ProgramaPrincipal8` con el método `main` que:
  - Cree una instancia de `DatosConversiones` y asigne valores de ejemplo (por ejemplo, 25.0, 100.0).
  - Cree una instancia de `ConversionesNumericas` y llame a sus métodos para convertir.
  - Imprima los resultados en consola (conversiones realizadas).

## Instrucciones Adicionales

- Todos los métodos deben ser `public`.
- Usa tipos primitivos `double`.
- Mantén la lógica simple: operaciones aritméticas básicas.
- El programa debe compilar y ejecutarse sin errores.
- Escribe el código de manera clara y comentada para un examen a mano.

## Ejemplo de Salida Esperada

```
Celsius a Fahrenheit: 77.0
Fahrenheit a Celsius: 25.0
Euros a Dólares: 110.0
Dólares a Euros: 100.0
```

¡Practica implementando los métodos paso a paso!</content>
