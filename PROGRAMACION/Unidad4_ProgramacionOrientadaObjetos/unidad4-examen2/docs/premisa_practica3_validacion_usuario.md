# Práctica de Métodos de Instancia: Validación de Datos de Usuario

## Objetivo

Crear un programa en Java que valide datos básicos de un usuario utilizando métodos `public` (de instancia). El enfoque está en el uso de métodos de instancia, condicionales (`if`/`else`) y operaciones con Strings (como `length()`, `equals()`, `toUpperCase()`), sin elementos avanzados de POO.

## Requisitos

- **Clase de Datos**: Crea una clase llamada `DatosUsuario` que contenga variables para almacenar el nombre (tipo `String`) y email (tipo `String`).
- **Clase de Validaciones**: Crea una clase llamada `ValidacionesUsuario` con métodos `public` para:
  - Validar que el nombre tenga al menos 2 caracteres: Recibe el nombre y devuelve `true` si es válido, `false` en caso contrario (tipo `boolean`).
  - Validar que el email contenga '@': Recibe el email y devuelve `true` si es válido, `false` en caso contrario (tipo `boolean`).
  - Convertir el email a mayúsculas: Recibe el email y devuelve el email en mayúsculas (tipo `String`).
  - Generar nombre de usuario: Recibe el nombre y devuelve el nombre en mayúsculas (tipo `String`).
  - Extraer el dominio del email: Recibe el email y devuelve la parte después de '@' (tipo `String`).
- **Clase Principal**: Crea una clase llamada `ProgramaPrincipal3` con el método `main` que:
  - Cree una instancia de `DatosUsuario` y asigne valores de ejemplo (por ejemplo, nombre "Ana", email `ana@example.com`).
  - Cree una instancia de `ValidacionesUsuario` y llame a sus métodos para validar y generar datos.
  - Imprima los resultados en consola (validaciones y datos generados).

## Instrucciones Adicionales

- Todos los métodos deben ser `public`.
- Usa solo tipos primitivos y `String`.
- Mantén la lógica simple: condicionales básicos.
- El programa debe compilar y ejecutarse sin errores.
- Escribe el código de manera clara y comentada para un examen a mano.

## Ejemplo de Salida Esperada

```
Nombre válido: true
Email válido: true
Email en mayúsculas: ANA@EXAMPLE.COM
Nombre de usuario generado: ANA
Dominio del email: EXAMPLE.COM
```

¡Practica implementando los métodos paso a paso!
