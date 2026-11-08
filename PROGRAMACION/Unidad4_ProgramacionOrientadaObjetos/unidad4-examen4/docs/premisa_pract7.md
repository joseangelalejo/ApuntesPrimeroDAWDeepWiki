# Premisa pract7 - Biblioteca con Clases Abstractas e Interfaces

Construye un sistema de gestión de una biblioteca usando **clases abstractas** y **interfaces**.

## Objetivo

Practicar la abstracción con clases base, interfaces para comportamientos y colecciones polimórficas.

## Enunciado

1. Define una clase abstracta `Publicacion` con:
   - Atributos: `String titulo`, `String autor`, `int anio`.
   - Constructor.
   - Método `void mostrarDatos()` que muestre todos los atributos.
   - Método abstracto `int diasPrestamo()`.

2. Crea una interfaz `Prestamo` con métodos:
   - `void prestar(String nombreCliente)`
   - `void devolver()`
   - `boolean estaPrestado()`

3. Crea clases que extiendan `Publicacion` e implementen `Prestamo`:
   - `Libro` con atributo `int paginas`; el préstamo es 21 días.
   - `Revista` con atributo `int numero`; el préstamo es 7 días.
   - `AudioLibro` con atributo `double duracionHoras`; el préstamo es 14 días.

4. Cada implementación de `prestado` debe almacenar el cliente y fecha (puede ser `String`).

5. En `main`:
   - Crea una lista `List<Publicacion>`, añade instancias de cada tipo.
   - Recorre la lista y llama a `mostrarDatos()`, `diasPrestamo()`.
   - Prueba prestar y devolver elementos y muestra estado con `estaPrestado()`.

---

✅ Extra: Crea método `void imprimirEtiqueta()` en `Publicacion` y sobreescríbelo en `AudioLibro` con datos de duración.
