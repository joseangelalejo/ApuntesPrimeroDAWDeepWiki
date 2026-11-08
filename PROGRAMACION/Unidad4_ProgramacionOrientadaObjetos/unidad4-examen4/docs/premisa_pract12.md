# Premisa pract12 - Animales y Comportamientos

Implementa una jerarquía de animales con herencia y múltiples interfaces.

## Objetivo

Practicar interfaces múltiples, polimorfismo y clases abstractas.

## Enunciado

1. Crea clase abstracta `Animal` con:
   - `String nombre`, `int edad`.
   - Constructor, getters.
   - Método abstracto `void hacerSonido()`.

2. Interfaces:
   - `Volador` con método `void volar()`.
   - `Nadador` con método `void nadar()`.
   - `Terrestre` con método `void correr()`.

3. Clases concretas de animales:
   - `Pajaro` (implementa `Volador`, `Terrestre`).
   - `Pez` (implementa `Nadador`).
   - `Perro` (implementa `Terrestre`).
   - `Anfibio` (implementa `Nadador` y `Terrestre`).

4. En `main`:
   - Crea lista de `Animal` con instancias.
   - Recorre lista, invoca `hacerSonido()` y comportamiento específico con `instanceof`.

---

✅ Extra: Añade método `int horasDeAlimentacion()` abstracto en `Animal` y define en cada clase.
