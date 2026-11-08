# Premisa pract14 - Sistema bancario con clúster de cuentas

Implementa un sistema bancario con clase abstracta para cuentas y varias estrategias de interés.

## Objetivo

Fomentar el uso de clases abstractas, herencia, interfaces y diseño orientado a objetos.

## Enunciado

1. Crea una clase abstracta `Cuenta` con:
   - `String numeroCuenta`, `double saldo`.
   - Constructor, getters, `depositar(double cantidad)`, `retirar(double cantidad)`.
   - Método abstracto `double calcularInteres()`.

2. Crea interfaces:
   - `Inversion` con `double calcularRetorno(double cantidad, int meses)`.
   - `Transferible` con `boolean transferir(Cuenta destino, double cantidad)`.

3. Subclases de `Cuenta`:
   - `CuentaAhorros` con `double interesAnual`.
   - `CuentaCorriente` con `double limiteNegativo`.
   - `CuentaInversion` con `double interesVariable` e implementa `Inversion`.

4. Haz `CuentaAhorros` y `CuentaCorriente` implementar `Transferible`.

5. En `main`:
   - Crea varias cuentas y prueba depósito, retiro, transferencia y retorno de inversión.

---

✅ Extra: Añade método `void imprimirEstado()` en `Cuenta` y sobrescribe en cada clase con detalles poderosos.
