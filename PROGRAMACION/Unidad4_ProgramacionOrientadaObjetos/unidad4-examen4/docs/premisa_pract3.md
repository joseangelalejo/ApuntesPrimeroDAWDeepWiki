# Premisa pract3 - Herencia y sobreescritura

Modela una jerarquía de **vehículos** donde algunos tienen características especiales.

## Objetivo

Practicar **herencia**, **sobreescritura** y uso de `super`, tal como vimos en clase al extender una clase base.

## Enunciado

1. Crea una clase base `Vehiculo` con:
   - atributos `String marca`, `String modelo`, `int año`.
   - constructor que inicialice todos los atributos.
   - método `String descripcion()` que devuelva `"marca modelo (año)"`.

2. Crea subclases:
   - `Coche` con atributo `int puertas`.
   - `Moto` con atributo `boolean sidecar`.
   - `Camion` con atributo `double cargaMaxima`.

3. Sobrescribe `descripcion()` en cada subclase para añadir información extra:
   - Coche: “— puertas: X”
   - Moto: “— sidecar: true/false”
   - Camion: “— carga máxima: X kg”

4. En `main`:
   - Crea una instancia de cada tipo y muestra su `descripcion`.

---

✅ **Consejo:** Usa `super.descripcion()` en las subclases para reutilizar la implementación base y añadir detalles específicos.
