# Premisa pract9 - Gestión de Ecommerce con Interfaces y Herencia

Construye un modelo de carrito de compras para un ecommerce usando interfaces, clases abstractas y colecciones.

## Objetivo

- Practicar diseño de jerarquía de clases
- Implementar interfaces para comportamiento común
- Uso de polimorfismo en colecciones

## Enunciado

1. Define una interfaz `IComprable` con:
   - `double obtenerPrecio()`
   - `String obtenerNombre()`

2. Crea una clase abstracta `Articulo` implementando `IComprable` con:
   - `String nombre` y `double precio`.
   - Constructor, getters y setters.
   - Método `String descripcion()` que devuelva nombre y precio.

3. Crea las subclases:
   - `ArticuloTecnologia` con atributo `int garantiaMeses`.
   - `ArticuloRopa` con atributo `String talla`.
   - `ArticuloAlimentacion` con atributo `boolean perecedero`.

4. Crea una interfaz `Imprimible` con `void imprimirEtiqueta()`.
   - Implementa en los artículos, la etiqueta debe incluir tipo y atributos.

5. En `main`:
   - Lista de `IComprable` con varios artículos.
   - Calcular el total de la compra.
   - Imprimir etiqueta de cada artículo (con `instanceof` si hace falta).

---

✅ Extra: Añade `boolean esDescuentoValido(double porcentaje)` en `Articulo` y aplícalo solo a `ArticuloRopa`.
