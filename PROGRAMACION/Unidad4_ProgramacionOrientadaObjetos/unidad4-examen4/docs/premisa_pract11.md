# Premisa pract11 - Sistema de Pagos con Interfaces y Herencia

Crea un sistema de pago que use interfaces para distintos métodos y clase base para usuario.

## Objetivo

Ejercitar interfaces y herencia para manejar múltiples estrategias de pago.

## Enunciado

1. Define interfaz `MedioPago` con métodos:
   - `boolean pagar(double cantidad)`
   - `String getTipo()`

2. Crea clase abstracta `CuentaCliente` con:
   - `String nombre`, `int id`, `double saldo`.
   - Constructor y método `boolean recargar(double cantidad)`.
   - Método abstracto `boolean procesarPago(double cantidad, MedioPago medio)`.

3. Crea clases de métodos de pago:
   - `TarjetaCredito` con `double limite`.
   - `Paypal` con `String email`.
   - `Transferencia` con `String banco`.

4. Crea subclases de `CuentaCliente`:
   - `CuentaBasica`: acepta pago si saldo >= cantidad.
   - `CuentaPremium`: aplica descuento de 5% y acepta hasta saldo + 100.

5. En `main`:
   - Crea clientes y métodos de pago.
   - Haz pagos y muestra estado de saldo.

---

✅ Extra: Adjunta interfaz `Notificable` con `void enviarNotificacion(String mensaje)` y haz que las cuentas lo implementen.
