# Práctica de Métodos Estáticos: Gestión de Compra en Tienda

## Objetivo

Crear un programa en Java que simule una compra simple en una tienda, utilizando métodos `public static` para realizar cálculos básicos. El enfoque está en el uso de métodos estáticos, condicionales (`if`/`else`) y operaciones aritméticas simples, sin elementos avanzados de POO.

## Requisitos

- **Clase de Datos**: Crea una clase llamada `DatosCompra` que contenga variables para almacenar el precio unitario de un producto (tipo `double`) y la cantidad comprada (tipo `int`).
- **Clase de Cálculos**: Crea una clase llamada `CalculosCompra` con métodos `public static` para:
  - Calcular el descuento basado en la cantidad: Si la cantidad es mayor o igual a 5, aplica un 10% de descuento; de lo contrario, no hay descuento. El método debe devolver el porcentaje de descuento (tipo `double`).
  - Calcular el total final: Recibe el precio unitario, la cantidad y el descuento, y devuelve el total a pagar (tipo `double`). Usa la fórmula: `total = (precioUnitario * cantidad) * (1 - descuento)`.
- **Clase Principal**: Crea una clase llamada `ProgramaPrincipal` con el método `main` que:
  - Cree una instancia de `DatosCompra` y asigne valores de ejemplo (por ejemplo, precio unitario 10.0 y cantidad 6).
  - Llame a los métodos static de `CalculosCompra` para calcular el descuento y el total.
  - Imprima los resultados en consola (descuento aplicado y total final).

## Instrucciones Adicionales

- Todos los métodos deben ser `public static`.
- Usa solo tipos primitivos y `String` si es necesario.
- Mantén la lógica simple: no más de un nivel de condicionales.
- El programa debe compilar y ejecutarse sin errores.
- Escribe el código de manera clara y comentada para un examen a mano.

## Ejemplo de Salida Esperada

```
Descuento aplicado: 0.1
Total a pagar: 54.0
```

¡Practica implementando los métodos paso a paso!
