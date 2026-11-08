# Práctica de Métodos de Instancia: Conversiones de Unidades

## Objetivo

Crear un programa en Java que realice conversiones de unidades (longitud y volumen) utilizando métodos `public` (de instancia). El enfoque está en el uso de métodos de instancia, operaciones aritméticas y constantes de conversión, sin elementos avanzados de POO.

## Requisitos

- **Clase de Datos**: Crea una clase llamada `DatosUnidades` que contenga variables para almacenar valores (tipo `double`): metros y litros.
- **Clase de Conversiones**: Crea una clase llamada `ConversionesUnidades` con métodos `public` para:
  - Convertir metros a pies: Recibe metros, devuelve metros * 3.28084 (tipo `double`).
  - Convertir pies a metros: Recibe pies, devuelve pies / 3.28084 (tipo `double`).
  - Convertir litros a galones: Recibe litros, devuelve litros * 0.264172 (tipo `double`).
  - Convertir galones a litros: Recibe galones, devuelve galones / 0.264172 (tipo `double`).
- **Clase Principal**: Crea una clase llamada `ProgramaPrincipal10` con el método `main` que:
  - Cree una instancia de `DatosUnidades` y asigne valores de ejemplo (por ejemplo, 10.0, 20.0).
  - Cree una instancia de `ConversionesUnidades` y llame a sus métodos para convertir.
  - Imprima los resultados en consola (conversiones realizadas).

## Instrucciones Adicionales

- Todos los métodos deben ser `public`.
- Usa tipos primitivos `double`.
- Mantén la lógica simple: operaciones aritméticas básicas.
- El programa debe compilar y ejecutarse sin errores.
- Escribe el código de manera clara y comentada para un examen a mano.

## Ejemplo de Salida Esperada

```
Metros a pies: 32.8084
Pies a metros: 10.0
Litros a galones: 5.28344
Galones a litros: 20.0
```

¡Practica implementando los métodos paso a paso!</content>
