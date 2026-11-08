# Práctica de Métodos de Instancia: Validaciones Numéricas

## Objetivo

Crear un programa en Java que realice validaciones numéricas utilizando métodos `public` (de instancia). El enfoque está en el uso de métodos de instancia, condicionales y operaciones básicas con números, sin elementos avanzados de POO.

## Requisitos

- **Clase de Datos**: Crea una clase llamada `DatosNumericos` que contenga variables para almacenar números (tipo `double`): numero1, numero2.
- **Clase de Validaciones**: Crea una clase llamada `ValidacionesNumericas` con métodos `public` para:
  - Verificar par: Recibe numero, devuelve true si numero % 2 == 0 (tipo `boolean`).
  - Verificar positivo: Recibe numero, devuelve true si numero > 0 (tipo `boolean`).
  - Verificar rango: Recibe numero, min, max, devuelve true si numero entre min y max (tipo `boolean`).
- **Clase Principal**: Crea una clase llamada `ProgramaPrincipal14` con el método `main` que:
  - Cree una instancia de `DatosNumericos` y asigne valores de ejemplo (por ejemplo, 4.0, -2.0).
  - Cree una instancia de `ValidacionesNumericas` y llame a sus métodos para validar.
  - Imprima los resultados en consola (validaciones realizadas).

## Instrucciones Adicionales

- Todos los métodos deben ser `public`.
- Usa tipos primitivos `double` y `boolean`.
- Mantén la lógica simple: condicionales básicos.
- El programa debe compilar y ejecutarse sin errores.
- Escribe el código de manera clara y comentada para un examen a mano.

## Ejemplo de Salida Esperada

```
Es par: true
Es positivo: false
Está en rango: true
```

¡Practica implementando los métodos paso a paso!</content>
