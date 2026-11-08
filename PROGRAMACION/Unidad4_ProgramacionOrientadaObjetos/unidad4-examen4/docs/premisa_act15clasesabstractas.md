# Premisa Actividad 15: Clases Abstractas

Una actividad orientada a trabajar con **clases abstractas** en Java. Se solicita crear una jerarquía de clases que represente muebles y su capacidad de transporte.

## Requisitos principales

1. **Clase abstracta `Mueble`**
   - Atributos:
     - `precioBase`: precio base del mueble
     - `material`: material con el que está hecho el mueble
   - Constructor para inicializar los atributos anteriores.
   - Métodos abstractos (deberán implementarse en las subclases):
     - `calcularPrecioFinal()`
     - `transportar()`

2. **Clase `SillaGiratoria`** (hereda de `Mueble`)
   - Atributo adicional:
     - `tieneReposabrazos` (booleano que indica si la silla tiene reposabrazos o no)
   - Implementaciones requeridas:
     - `calcularPrecioFinal()` debe sumar **50 €** al `precioBase` si `tieneReposabrazos` es verdadero.
     - `transportar()` debe mostrar un mensaje indicando que la silla está siendo transportada.
   - **Extras JA** (para igualar el nivel de otras prácticas):
     - Sobrescribir `toString()` mostrando los datos relevantes y el precio final.
     - Crear una clase de pruebas (`mainPruebas`) que instancie varias sillas y demuestre el cálculo de precios y el transporte, similar a otras actividades del proyecto.

---

> Recuerda que todos los métodos abstractos de la clase base deben ser concretados en las subclases.
