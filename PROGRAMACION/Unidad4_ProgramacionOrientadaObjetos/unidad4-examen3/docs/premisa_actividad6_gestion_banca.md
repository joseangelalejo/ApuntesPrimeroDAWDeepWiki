# Actividad 6: Gestión de Banca - Clase, constructor y métodos estáticos

## Premisa

Deberás crear una clase `CuentaBancaria` que permita realizar operaciones básicas y usar para funcionalidades generales del banco.

## PASOS

### 1. Crear una clase CuentaBancaria con los siguientes atributos

- `titular` (String) → Nombre del propietario de la cuenta.
- `saldo` (double) → Dinero disponible en la cuenta.
- `banco` (String, estático) → Nombre del banco (igual para todas las cuentas).

### 2. Métodos NO estáticos

- **Constructor** para inicializar `titular` y `saldo`.
- `depositar(double cantidad)`: Aumenta el saldo en la cantidad indicada.
- `retirar(double cantidad)`: Disminuye el saldo en la cantidad indicada. Si no hay suficiente dinero que devuelva `false` y no decremente el saldo.
- `mostrarInformacion()`: Muestra el nombre del titular y el saldo actual.

### 3. Métodos estáticos

- `mostrarInformacionBanco()`: Muestra el nombre del banco.
- `convertirEurosADolares(double euros)`: Convierte euros a dólares. Suponer tasa de cambio 1€ = 1.14$.
- `convertirDolaresAEuros(double dolares)`: Convierte dólares a euros. Suponer tasa de cambio 1€ = 1.14$.
- `calcularInteresAnual(double saldo, double tasa)`: Calcula el interés anual sobre un saldo según una tasa de interés dada.
- `compararSaldos(CuentaBancaria cuenta1, CuentaBancaria cuenta2)`: Compara los saldos de dos cuentas y muestra cuál tiene más dinero.

## En la CLASE PRINCIPAL (ProgramaPrincipal)

En el método `main()`, realiza las siguientes acciones:

- Muestra la información del banco.
- Crea dos cuentas con saldos diferentes.
- Muestra la información de ambas cuentas.
- Compara los saldos de las cuentas.
- Convierte 100€ a $ y 100$ a € con los métodos estáticos.
- Calcula el interés anual de una cuenta con una tasa del 5%.
