# Premisa Actividad 17 - Clases Abstractas e Interfaces

Crear un sistema de gestión de empleados que permita administrar tanto empleados regulares como gerentes.

Cada empleado tiene un nombre, un ID único y un salario base.

Los gerentes, además, tienen un bono anual. Requerimientos:

Define una interfaz Empleado con los siguientes métodos:

- double calcularSalarioMensual(): Un método para calcular el salario mensual del empleado.
- void mostrarDetalles(): Un método para mostrar los detalles del empleado.

Define una clase abstracta EmpleadoBase que implemente la interfaz Empleado. Esta clase debe contener los siguientes atributos y métodos:

- Atributos:
  - String nombre: El nombre del empleado.
  - int id: El ID único del empleado.
  - double salarioBase: El salario base del empleado.

Métodos:

- Constructor que inicializa los atributos.
- Implementación del método mostrarDetalles().
- Método abstracto calcularSalarioMensual() que deberá ser implementado por las subclases.

Define una subclase de EmpleadoBase llamada Gerente que agregue el siguiente atributo:

- double bonoAnual: El bono anual del gerente.

Y la subclase EmpleadoRegular.
Implementa los métodos necesarios en las clases EmpleadoRegular y Gerente para calcular el salario mensual y mostrar los detalles de cada empleado.

Cálculo del salario mensual:

- Para empleados regulares, el salario mensual es igual al salario base.
- Para los gerentes, el salario mensual es igual a la suma del salario base y el bono anual.

Crea una clase Main que contenga el método main para probar tu sistema. Crea instancias de empleados regulares y gerentes, y muestra sus detalles.
