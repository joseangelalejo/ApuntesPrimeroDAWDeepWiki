# Práctica de Métodos de Instancia: Cálculos Financieros

## Objetivo

Crear un programa en Java que realice cálculos financieros simples utilizando métodos `public` (de instancia). El enfoque está en el uso de métodos de instancia, operaciones aritméticas y funciones matemáticas (como `Math.pow`), sin elementos avanzados de POO.

## Requisitos

- **Clase de Datos**: Crea una clase llamada `DatosFinancieros` que contenga variables para almacenar valores (tipo `double` e `int`): capital, tasa, tiempo.
- **Clase de Cálculos**: Crea una clase llamada `CalculosFinancieros` con métodos `public` para:
  - Calcular interés simple: Recibe capital, tasa, tiempo, devuelve `capital * tasa * tiempo` (tipo `double`).
  - Calcular interés compuesto: Recibe capital, tasa, tiempo, devuelve capital * (1 + tasa)^tiempo (tipo `double`).
  - Calcular pago mensual: Recibe capital, tasa, tiempo, devuelve (capital * tasa) / (1 - (1 + tasa)^(-tiempo)) (tipo `double`).
- **Clase Principal**: Crea una clase llamada `ProgramaPrincipal12` con el método `main` que:
  - Cree una instancia de `DatosFinancieros` y asigne valores de ejemplo (por ejemplo, 1000.0, 0.05, 2).
  - Cree una instancia de `CalculosFinancieros` y llame a sus métodos para calcular.
  - Imprima los resultados en consola (cálculos realizados).

## Instrucciones Adicionales

- Todos los métodos deben ser `public`.
- Usa tipos primitivos `double` e `int`.
- Mantén la lógica simple: operaciones aritméticas básicas.
- El programa debe compilar y ejecutarse sin errores.
- Escribe el código de manera clara y comentada para un examen a mano.

## Ejemplo de Salida Esperada

```
Interés simple: 100.0
Interés compuesto: 1102.5
Pago mensual: 43.87
```

¡Practica implementando los métodos paso a paso!</content>
