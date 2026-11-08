# Premisa de actividad 12: Clases Java - Banco

Se desea crear una aplicación que gestione cuentas bancarias sencillas.  
La clase CuentaBancaria tendrá los siguientes atributos:

- titular: nombre del titular de la cuenta
- numeroCuenta : número de cuenta
- saldo : dinero disponible en la cuenta
- pin: código de seguridad de la cuenta

El atributo saldo no puede modificarse directamente. El atributo pin no puede consultarse directamente.

Constructores:

- Constructor con todos los atributos
- Constructor sin saldo (se inicializa a 0)

Métodos:
La clase debe incluir:

- Getters y setters de los atributos permitidos
- ingresar(double cantidad): añade dinero al saldo
- retirar(double cantidad, int pin): retira dinero solo si el PIN es correcto y hay saldo suficiente
- mostrarSaldo(String  pin): muestra el saldo solo si el PIN es correcto
- cambiarPin(String  pinActual,  String pinNuevo): permite cambiar el PIN si el actual es correcto

Restricciones

- No permitir cantidades negativas
- No permitir retirar más saldo del disponible
- El saldo solo puede modificarse mediante métodos (ingresar y retirar)
- El PIN nunca debe mostrarse directamente
- Hacer un main instanciando objetos y usando sus métodos
