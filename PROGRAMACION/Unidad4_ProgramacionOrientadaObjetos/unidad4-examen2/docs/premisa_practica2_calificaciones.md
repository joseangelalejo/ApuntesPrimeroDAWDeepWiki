# Práctica de Métodos Estáticos: Gestión de Calificaciones

## Objetivo

Crear un programa en Java que gestione calificaciones simples de un alumno, utilizando métodos `public static` para realizar cálculos básicos. El enfoque está en el uso de métodos estáticos, condicionales (`if`/`else`) y operaciones aritméticas simples, sin elementos avanzados de POO.

## Requisitos

- **Clase de Datos**: Crea una clase llamada `DatosCalificaciones` que contenga variables para almacenar las notas de tres asignaturas (tipo `double`: nota1, nota2, nota3).
- **Clase de Cálculos**: Crea una clase llamada `CalculosCalificaciones` con métodos `public static` para:
  - Calcular el promedio de las tres notas: Recibe las tres notas y devuelve el promedio (tipo `double`).
  - Determinar si el alumno aprueba: Recibe el promedio y devuelve `true` si es mayor o igual a 5.0, `false` en caso contrario (tipo `boolean`).
- **Clase Principal**: Crea una clase llamada `ProgramaPrincipal2` con el método `main` que:
  - Cree una instancia de `DatosCalificaciones` y asigne valores de ejemplo (por ejemplo, 7.5, 6.0, 8.0).
  - Llame a los métodos static de `CalculosCalificaciones` para calcular el promedio y determinar si aprueba.
  - Imprima los resultados en consola (promedio y si aprueba o no).

## Instrucciones Adicionales

- Todos los métodos deben ser `public static`.
- Usa solo tipos primitivos y `String` si es necesario.
- Mantén la lógica simple: no más de un nivel de condicionales.
- El programa debe compilar y ejecutarse sin errores.
- Escribe el código de manera clara y comentada para un examen a mano.

## Ejemplo de Salida Esperada

```
Promedio: 7.17
¿Aprueba? true
```

¡Practica implementando los métodos paso a paso!
