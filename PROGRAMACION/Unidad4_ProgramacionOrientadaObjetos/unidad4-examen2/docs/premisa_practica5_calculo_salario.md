# Práctica de Métodos de Instancia: Cálculos de Salario

## Objetivo

Crear un programa en Java que calcule salarios y procese nombres utilizando métodos `public` (de instancia). El enfoque está en el uso de métodos de instancia, operaciones aritméticas y manipulación de Strings (como `split()`, `substring()`), sin elementos avanzados de POO.

## Requisitos

- **Clase de Datos**: Crea una clase llamada `DatosSalario` que contenga variables para almacenar horas trabajadas (tipo `double`), tarifa por hora (tipo `double`) y nombre del empleado (tipo `String`).
- **Clase de Cálculos**: Crea una clase llamada `CalculosSalario` con métodos `public` para:
  - Calcular salario base: Recibe horas y tarifa, devuelve horas * tarifa (tipo `double`).
  - Calcular bono horas extra: Recibe horas y tarifa, devuelve bono por horas extra (ej. si horas > 40, calcular `(horas - 40) * tarifa * 1.5`) (tipo `double`).
  - Calcular salario total: Recibe base y bono, devuelve base + bono (tipo `double`).
  - Obtener iniciales: Recibe el nombre y devuelve las iniciales (ej. "Juan Pérez" -> "J.P.") (tipo `String`).
- **Clase Principal**: Crea una clase llamada `ProgramaPrincipal5` con el método `main` que:
  - Cree una instancia de `DatosSalario` y asigne valores de ejemplo (por ejemplo, 45.0 horas, 10.0 tarifa, "Juan Pérez").
  - Cree una instancia de `CalculosSalario` y llame a sus métodos para calcular y procesar.
  - Imprima los resultados en consola (cálculos realizados).

## Instrucciones Adicionales

- Todos los métodos deben ser `public`.
- Usa tipos primitivos y `String`.
- Mantén la lógica simple: operaciones aritméticas básicas.
- El programa debe compilar y ejecutarse sin errores.
- Escribe el código de manera clara y comentada para un examen a mano.

## Ejemplo de Salida Esperada

```
Salario base: 450.0
Bono horas extra: 75.0
Salario total: 525.0
Iniciales: J.P.
```

¡Practica implementando los métodos paso a paso!
