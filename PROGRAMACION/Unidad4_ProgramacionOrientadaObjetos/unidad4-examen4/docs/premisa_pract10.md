# Premisa pract10 - Biblioteca de Figuras Geométricas

Modela un sistema de figuras geométricas con herencia y métodos abstractos.

## Objetivo

Reforzar diseño de clase abstracta, override y cálculo polimórfico.

## Enunciado

1. Crea clase abstracta `Figura` con:
   - Atributo `String color`.
   - Constructor y getter.
   - Método abstracto `double area()`.
   - Método abstracto `double perimetro()`.

2. Crea subclases:
   - `Círculo` con `double radio`.
   - `Rectángulo` con `double ancho`, `double alto`.
   - `Triángulo` con `double ladoA`, `ladoB`, `ladoC`.

3. Implementa `area()` y `perimetro()` en cada subclase.

4. Crea interfaz `Escalable` con `void escalar(double factor)`.
   - Haz que `Rectángulo` y `Triángulo` implementen `Escalable`.

5. En `main`:
   - Crea `List<Figura>` con instancias.
   - Muestra area y perímetro de cada una.
   - Escala las figuras escalables y muestra los nuevos valores.

---

✅ Extra: Añade `void mostrarDetalle()` en `Figura` y reescribe en cada clase con formato 'Figura: color, area=X, perimetro=Y'.
