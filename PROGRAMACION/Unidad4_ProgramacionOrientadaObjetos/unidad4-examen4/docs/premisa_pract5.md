# Premisa pract5 - Interfaces y clases abstractas

Construye un sistema de gestión de empleados que combine **interfaces** y **clases abstractas**, tal como se vio en clase en la actividad de empleados.

## Objetivo

Practicar el uso de **interfaces**, **clases abstractas** y **polimorfismo**.

## Enunciado

1. Define una interfaz `Empleado` con los métodos:
   - `double calcularSalarioMensual()`
   - `void mostrarDetalles()`

2. Define una clase abstracta `EmpleadoBase` que implemente la interfaz `Empleado` y añada los siguientes atributos:
   - `String nombre`
   - `int id`
   - `double salarioBase`

   `EmpleadoBase` debe tener:
   - Constructor que inicialice los atributos.
   - Implementación de `mostrarDetalles()` que muestre nombre, id y salario base.
   - Método abstracto `double calcularSalarioMensual()` (será implementado en las subclases).

3. Crea las subclases:
   - `EmpleadoRegular`, donde el salario mensual es igual al salario base.
   - `Gerente`, con atributo adicional `double bonoAnual`, donde el salario mensual es salario base + bono anual.

4. En `main`:
   - Crea instancias de `EmpleadoRegular` y `Gerente`.
   - Guarda todos los empleados en una lista de `Empleado`.
   - Recorre la lista y muestra los detalles y el salario mensual de cada empleado.

---

✅ **Extra:** Haz que `EmpleadoBase` tenga un método `void imprimirRecibo()` que use `calcularSalarioMensual()` y que las subclases puedan añadir información extra (p.ej., el bono del gerente).
