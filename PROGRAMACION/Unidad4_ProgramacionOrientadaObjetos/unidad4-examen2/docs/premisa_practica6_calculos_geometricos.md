# Práctica de Métodos de Instancia: Cálculos Geométricos

## Objetivo

Crear un programa en Java que calcule áreas y perímetros de figuras geométricas utilizando métodos `public` (de instancia). El enfoque está en el uso de métodos de instancia, operaciones aritméticas y constantes matemáticas (como `Math.PI`), sin elementos avanzados de POO.

## Requisitos

- **Clase de Datos**: Crea una clase llamada `DatosGeometricos` que contenga variables para almacenar medidas (tipo `double`): lado (para cuadrado) y radio (para círculo).
- **Clase de Cálculos**: Crea una clase llamada `CalculosGeometricos` con métodos `public` para:
  - Calcular área de cuadrado: Recibe lado, devuelve lado * lado (tipo `double`).
  - Calcular perímetro de cuadrado: Recibe lado, devuelve lado * 4 (tipo `double`).
  - Calcular área de círculo: Recibe radio, devuelve π * radio^2 (tipo `double`).
  - Calcular perímetro de círculo: Recibe radio, devuelve `2 * π * radio` (tipo `double`).
- **Clase Principal**: Crea una clase llamada `ProgramaPrincipal6` con el método `main` que:
  - Cree una instancia de `DatosGeometricos` y asigne valores de ejemplo (por ejemplo, lado=5.0, radio=3.0).
  - Cree una instancia de `CalculosGeometricos` y llame a sus métodos para calcular.
  - Imprima los resultados en consola (cálculos realizados).

## Instrucciones Adicionales

- Todos los métodos deben ser `public`.
- Usa tipos primitivos `double`.
- Mantén la lógica simple: operaciones aritméticas básicas.
- El programa debe compilar y ejecutarse sin errores.
- Escribe el código de manera clara y comentada para un examen a mano.

## Ejemplo de Salida Esperada

```
Área del cuadrado: 25.0
Perímetro del cuadrado: 20.0
Área del círculo: 28.274333882308138
Perímetro del círculo: 18.84955592153876
```

¡Practica implementando los métodos paso a paso!</content>
