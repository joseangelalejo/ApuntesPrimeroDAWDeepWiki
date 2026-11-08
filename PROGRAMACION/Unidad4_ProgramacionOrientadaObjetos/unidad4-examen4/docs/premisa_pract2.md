# Premisa pract2 - Polimorfismo con figuras

Desarrolla una jerarquía de figuras geométricas y demuestra polimorfismo usando una clase abstracta.

## Objetivo

Practicar **polimorfismo**, **clases abstractas** y **sobreescritura de métodos**, como se vio en clase.

## Enunciado

1. Crea una clase abstracta `FiguraGeometrica` con:
   - atributos `String color` y `String nombre`.
   - constructor que inicialice ambos atributos.
   - métodos abstractos:
     - `double calcularArea()`
     - `double calcularPerimetro()`
     - `void dibujar()`
   - método concreto:
     - `void mostrarInformacion()` que imprima nombre y color.

2. Implementa las subclases:
   - `Rectangulo` (atributos `double base`, `double altura`).
   - `Circulo` (atributo `double radio`).
   - `Triangulo` (atributos `double lado1`, `double lado2`, `double lado3`, `double base`, `double altura`).

   Cada una debe:
   - implementar `calcularArea()` y `calcularPerimetro()` según su fórmula.
   - implementar `dibujar()` mostrando un mensaje con sus dimensiones.

3. En `main`:
   - Crea varias figuras y guárdalas en una lista de `FiguraGeometrica`.
   - Recorre la lista y para cada figura:
     - llama a `mostrarInformacion()`;
     - imprime el área y el perímetro;
     - invoca `dibujar()`.

---

✅ **Tip:** Usa `getClass().getSimpleName()` para imprimir el tipo de figura dentro de `mostrarInformacion()` o `dibujar()`.
