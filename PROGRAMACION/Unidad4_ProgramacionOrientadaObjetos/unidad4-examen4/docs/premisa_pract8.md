# Premisa pract8 - Tienda con Interfaces y Clases Abstractas

Diseña un modelo de tienda que combine **interfaces de comportamiento** con **clases abstractas de producto**.

## Objetivo

Reforzar interfaces para acciones y clases abstractas para jerarquía de objetos.

## Enunciado

1. Define una interfaz `Vendible` con:
   - `double obtenerPrecio()`
   - `String descripcion()`

2. Crea una clase abstracta `Producto` que implemente `Vendible` y tenga:
   - Atributos: `String nombre`, `String codigo`.
   - Constructor.
   - Implementación de `descripcion()` que muestre `nombre` y `codigo`.
   - Método abstracto `double obtenerPrecio()`.

3. Crea subclases de `Producto`:
   - `ProductoFrio` con `double temperaturaRecomendada`.
   - `ProductoElectrico` con `int consumoWatts`.
   - `ProductoRopa` con `String talla`.

   Cada subclase define su propia fórmula de `obtenerPrecio()` a partir de atributos y costo base.

4. Crea una interfaz `Descontable` con `double aplicarDescuento(double porcentaje)`.
   - Haz que `ProductoRopa` implemente `Descontable`.

5. En `main`:
   - Crea `List<Producto>` con varios productos.
   - Imprime `descripcion()` y `obtenerPrecio()`.
   - En productos descontables aplica un 10% y muestra precio final.

---

✅ Extra: Implementa otra interfaz `Impuesto` con `double calcularImpuesto()` y aplica a todas las clases.
