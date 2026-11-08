# Premisa pract6 - Herencia y Polimorfismo de Vehículos

Construye un sistema de gestión de vehículos utilizando **clases abstractas**, **herencia** e **interfaces**.

## Objetivo

Practicar herencia de clases abstractas, implementación de interfaces y uso de polimorfismo.

## Enunciado

1. Crea una clase abstracta `Vehiculo` con:
   - Atributos: `String marca`, `String modelo`, `int año`, `double precio`.
   - Constructor para inicializar los atributos.
   - Método concreto `void mostrarInfo()` que imprima la información básica.
   - Método abstracto `double precioSeguro()`.

2. Crea una interfaz `Electrificable` con:
   - `double autonomia()` (kilómetros con batería completa)
   - `void cargarBateria(double cantidad)` (porcentaje a recargar)

3. Crea clases que extiendan `Vehiculo`:
   - `CocheGasolina` con atributo `double litrosTanque`, `double consumo`.
     - `precioSeguro()`: `precio * 0.05 + 100`
   - `CocheElectrico` que implemente `Electrificable` y tenga `double capacidadBateria`.
     - `precioSeguro()`: `precio * 0.03 + 50`.
     - `autonomia()`: `capacidadBateria * 5`.
     - `cargarBateria(double cantidad)`: aumenta capacidad (max 100).

4. En `main`:
   - Crea 2 instancias de cada clase y almacénalas en `List<Vehiculo>`.
   - Recorre la lista e imprime `mostrarInfo()` y `precioSeguro()`.
   - Si el vehículo es instancia de `Electrificable`, imprime `autonomia()` y prueba `cargarBateria(10)`.

---

✅ Extra: Implementa otra clase `Moto` con herencia de `Vehiculo` y cálculo de seguro diferente.
