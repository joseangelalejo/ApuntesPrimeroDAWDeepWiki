# Premisa pract4 - Composición y delegación

Construye un sistema de **órdenes de compra** usando composición entre clases, como se trabajó en clase cuando introdujimos la idea de “un objeto tiene otros objetos”.

## Objetivo

Ver la diferencia entre herencia y composición; usar objetos dentro de objetos para modelar conceptos más complejos.

## Enunciado

1. Crea la clase `Producto` con:
   - `String nombre`
   - `double precio`

2. Crea la clase `LineaPedido` con:
   - `Producto producto`
   - `int cantidad`
   - método `double subtotal()` (precio * cantidad)

3. Crea la clase `Pedido` con:
   - `List<LineaPedido> lineas`
   - método `void agregarLinea(Producto producto, int cantidad)`
   - método `double total()` que suma `subtotal()` de cada línea
   - método `String resumen()` que devuelve texto con cada línea y el total

4. En `main`:
   - Crea varios `Producto`.
   - Crea un `Pedido`, agrega líneas y muestra el `resumen()`.

---

✅ **Ejercicio extra:** Añade un método `void mostrarDetalle()` en `LineaPedido` que devuelva una línea con el nombre del producto, cantidad y subtotal, y úsalo en `Pedido.resumen()`.
