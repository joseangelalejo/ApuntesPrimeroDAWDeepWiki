# Premisa Actividad 16: Figuras Geométricas

Diseña una jerarquía de clases para representar distintas figuras geométricas y poder calcular algunas de sus propiedades básicas.

## 1. Clase abstracta `FiguraGeometrica`

- **Atributos**
  - `String color` – color de la figura
  - `String nombre` – nombre identificador
- **Constructor** que inicialice ambos atributos.
- **Métodos abstractos** (las subclases los implementarán):
  - `double calcularArea()`
  - `double calcularPerimetro()`
  - `void dibujar()`
- **Método concreto**:
  - `void mostrarInformacion()` – imprime nombre y color.

## 2. Subclases concretas

### Rectángulo

- Atributos extra: `base` y `altura` (tipo `double`).
- Área = `base × altura`.
- Perímetro = `2 × (base + altura)`.
- `dibujar()` muestra un mensaje con sus dimensiones.

### Círculo

- Atributo extra: `radio` (`double`).
- Área = π × radio².
- Perímetro = 2 × π × radio.
- `dibujar()` indica que se dibuja un círculo con su radio.

### Triángulo

- Atributos: `lado1`, `lado2`, `lado3`, `base` y `altura` (`double`).
- Área = `(base × altura) / 2`.
- Perímetro = `lado1 + lado2 + lado3`.
- `dibujar()` menciona los tres lados.

## 3. Programa de prueba (`Main`)

1. Crear varias figuras (un rectángulo, un círculo y un triángulo, por ejemplo).
2. Guardarlas en un arreglo o lista de tipo `FiguraGeometrica`.
3. Recorrer la colección y, para cada figura:
   - llamar a `mostrarInformacion()`;
   - calcular y mostrar área y perímetro;
   - invocar `dibujar()`.

> 👉 Siguiendo este esquema el ejercicio queda en la misma línea que las demás actividades del proyecto, con una pequeña app de consola para comprobar el comportamiento.
