# Práctica de Métodos de Instancia: Procesamiento de Texto

## Objetivo

Crear un programa en Java que procese frases de texto utilizando métodos `public` (de instancia). El enfoque está en el uso de métodos de instancia, condicionales (`if`/`else`) y operaciones con Strings (como `length()`, `toUpperCase()`, `toLowerCase()`), sin elementos avanzados de POO.

## Requisitos

- **Clase de Datos**: Crea una clase llamada `DatosTexto` que contenga una variable para almacenar la frase (tipo `String`).
- **Clase de Procesamiento**: Crea una clase llamada `ProcesamientoTexto` con métodos `public` para:
  - Contar caracteres: Recibe la frase y devuelve el número de caracteres (tipo `int`).
  - Convertir a mayúsculas: Recibe la frase y devuelve la frase en mayúsculas (tipo `String`).
  - Verificar longitud mayor a 5: Recibe la frase y devuelve `true` si tiene más de 5 caracteres, `false` en caso contrario (tipo `boolean`).
  - Convertir a minúsculas: Recibe la frase y devuelve la frase en minúsculas (tipo `String`).
- **Clase Principal**: Crea una clase llamada `ProgramaPrincipal4` con el método `main` que:
  - Cree una instancia de `DatosTexto` y asigne un valor de ejemplo (por ejemplo, "Hola Mundo").
  - Cree una instancia de `ProcesamientoTexto` y llame a sus métodos para procesar la frase.
  - Imprima los resultados en consola (procesamientos realizados).

## Instrucciones Adicionales

- Todos los métodos deben ser `public`.
- Usa solo tipos primitivos y `String`.
- Mantén la lógica simple: condicionales básicos.
- El programa debe compilar y ejecutarse sin errores.
- Escribe el código de manera clara y comentada para un examen a mano.

## Ejemplo de Salida Esperada

```
Número de caracteres: 10
Frase en mayúsculas: HOLA MUNDO
Longitud mayor a 5: true
Frase en minúsculas: hola mundo
```

¡Practica implementando los métodos paso a paso!
