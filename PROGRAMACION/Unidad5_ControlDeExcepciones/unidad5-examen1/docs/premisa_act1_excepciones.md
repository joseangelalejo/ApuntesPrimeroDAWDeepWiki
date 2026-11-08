# Actividad 1 - Excepciones

- **Ejercicio 1: Crear una excepción SaldoInsuficienteException y lanzarla si el saldo es menor que el monto a retirar**. Instrucciones:
  - Crear una clase SaldoInsuficienteException
  - Crear una clase CuentaBancaria con un método retirar(double cantidad).
  - Si el saldo es menor que cantidad, lanzar la excepción.
  - En main, capturar la excepción y mostrar un mensaje.

- **Ejercicio 2: Crear una excepción ContraseñaInvalidaException y lanzarla si la contraseña no cumple ciertos requisitos**. Instrucciones:
  - La contraseña debe tener al menos 8 caracteres y contener un número.
  - Si no se cumple, lanzar ContraseñaInvalidaException.
  - Crea un clase Usuario, con un atributo contraseña. El método para cambiar la contraseña (set), así como el constructor, deben comprobar que esta es válida.
  - Capturar y manejar la excepción en main.
