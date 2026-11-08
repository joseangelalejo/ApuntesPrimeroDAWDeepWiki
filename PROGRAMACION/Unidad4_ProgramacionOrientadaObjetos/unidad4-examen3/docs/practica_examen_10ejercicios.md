# 10 Ejercicios de Práctica para el Examen - Métodos, Constructores, Getters y Setters

<!-- markdownlint-disable MD024 MD001 -->

---

## Ejercicio 1: Sistema de Biblioteca - Gestión de Libros

Crea una clase `Libro` que represente un libro en una biblioteca con las siguientes características:

### Atributos (privados)

- `isbn` (String): número identificador único del libro
- `titulo` (String): título del libro
- `autor` (String): nombre del autor
- `copias` (int): número de copias disponibles
- `contrasena` (String): contraseña para operaciones de administrador

#### Restricciones

- El atributo `copias` no puede disminuir por debajo de 0
- El atributo `contrasena` no puede consultarse directamente
- El ISBN no puede modificarse después de crear el libro

### Constructores

- Constructor con todos los atributos
- Constructor sin copias (se inicializa a 1)

### Métodos

- Getters y setters de los atributos permitidos
- `prestar()`: disminuye las copias disponibles (máximo 1)
- `devolver()`: aumenta las copias disponibles
- `mostrarDisponibilidad()`: muestra el número de copias disponibles
- `cambiarContrasena(String actual, String nueva)`: permite cambiar la contraseña si la actual es correcta

---

## Ejercicio 2: Sistema de Tienda - Gestión de Productos

Crea una clase `Producto` que represente un artículo en una tienda con las siguientes características:

### Atributos (privados)

- `codigo` (String): código único del producto
- `nombre` (String): nombre del producto
- `precio` (double): precio del producto
- `stock` (int): cantidad disponible en almacén
- `codigoSeguridad` (int): código de 4 dígitos para operaciones de descuento

#### Restricciones

- El precio no puede ser negativo
- El stock no puede ser negativo
- El código de seguridad no puede consultarse directamente
- El código del producto es inmutable

### Constructores

- Constructor con todos los atributos
- Constructor sin stock (se inicializa a 0)

#### Métodos

- Getters y setters de los atributos permitidos
- `agregarStock(int cantidad)`: añade cantidad al stock
- `vender(int cantidad)`: vende productos (valida que haya stock suficiente)
- `aplicarDescuento(double porcentaje, int codigo)`: aplica descuento solo si el código de seguridad es correcto
- `cambiarCodigoSeguridad(int actual, int nuevo)`: cambia el código si el actual es correcto

---

## Ejercicio 3: Sistema de Hotel - Gestión de Reservas

Crea una clase `Habitacion` que represente una habitación en un hotel con las siguientes características:

### Atributos (privados)

- `numero` (int): número de habitación (inmutable)
- `tipo` (String): tipo de habitación (individual, doble, suite)
- `precioNoche` (double): precio por noche
- `reservada` (boolean): indica si está reservada
- `huesped` (String): nombre del huésped que la ocupa
- `pinAcceso` (int): PIN de 4 dígitos para acceder

### Restricciones

- El número de habitación no puede modificarse
- El PIN no puede consultarse directamente
- El precio no puede ser negativo
- La habitación solo puede tener un huésped

### Constructores

- Constructor con todos los atributos (excepto huesped y reservada)
- Constructor sin precio (se inicializa a 100.0)

### Métodos

- Getters y setters de atributos permitidos
- `reservar(String nombreHuesped)`: reserva la habitación si está disponible
- `liberar(int pin)`: libera la habitación si el PIN es correcto
- `mostrarEstado()`: muestra si está reservada y por quién
- `cambiarPin(int actual, int nuevo)`: cambia el PIN si el actual es correcto

---

## Ejercicio 4: Sistema de Gimnasio - Gestión de Membresías

Crea una clase `Membresia` que represente una membresía en un gimnasio con las siguientes características:

### Atributos (privados)

- `idMiembro` (String): número identificador único del miembro
- `nombre` (String): nombre del miembro
- `apellido` (String): apellido del miembro
- `saldo` (double): saldo disponible en la cuenta
- `clave` (String): clave de seguridad para transacciones
- `activa` (boolean): indica si la membresía está activa

### Restricciones

- El saldo no puede ser negativo
- La clave no puede consultarse directamente
- El ID del miembro es inmutable
- No hay getter directo para el saldo

### Constructores

- Constructor con todos los atributos
- Constructor sin saldo (se inicializa a 0)

### Métodos

- Getters y setters de atributos permitidos
- `recargarSaldo(double cantidad, String clave)`: recarga el saldo si la clave es correcta
- `gastarSaldo(double cantidad)`: gasta del saldo si hay suficiente
- `mostrarSaldo(String clave)`: muestra el saldo solo si la clave es correcta
- `cambiarClave(String actual, String nueva)`: cambia la clave si la actual es correcta
- `cancelarMembresia(String clave)`: cancela la membresía si la clave es correcta

---

## Ejercicio 5: Sistema de Empleados - Gestión de Nóminas

Crea una clase `Empleado` que represente un empleado con su información de nómina:

### Atributos (privados)

- `numeroEmpleado` (String): identificador único (inmutable)
- `nombre` (String): nombre del empleado
- `departamento` (String): departamento donde trabaja
- `salarioBase` (double): salario base mensual
- `saldoNomina` (double): saldo acumulado para pagar
- `tokenAutenticacion` (String): token para validar operaciones sensibles

### Restricciones

- El número de empleado no puede modificarse
- El token no puede consultarse directamente
- El salario no puede ser menor a 0
- El saldo de nómina no debe visualizarse directamente sin token

### Constructores

- Constructor con todos los atributos
- Constructor sin saldo (se inicializa a 0)

### Métodos

- Getters y setters de atributos permitidos
- `acumularNomina()`: suma el salario base al saldo
- `pagarNomina(double cantidad, String token)`: paga al empleado si el token es válido
- `consultarNomina(String token)`: muestra el saldo solo con token válido
- `cambiarToken(String actual, String nuevo)`: cambia el token si el actual es correcto
- `ajustarSalario(double nuevoSalario, String token)`: ajusta el salario si el token es válido

---

## Ejercicio 6: Sistema de Email - Gestión de Buzón

Crea una clase `CuentaEmail` que represente una cuenta de correo electrónico:

### Atributos (privados)

- `usuario` (String): nombre de usuario (inmutable)
- `dominio` (String): dominio del email
- `contrasena` (String): contraseña de la cuenta
- `almacenamiento` (int): capacidad total en MB
- `espacioUsado` (int): espacio utilizado en MB
- `cantidadMensajes` (int): número de mensajes en el buzón

### Restricciones

- El usuario no puede cambiar
- La contraseña no puede consultarse
- El almacenamiento no puede ser menor a 1 MB
- El espacio usado no puede superar el almacenamiento

### Constructores

- Constructor con todos los atributos
- Constructor sin espacio (almacenamiento = 1000, espacioUsado = 0)

### Métodos

- Getters y setters de atributos permitidos
- `enviarCorreo(int tamanio)`: registra un email enviado (consume espacio)
- `recibirCorreo(int tamanio, String contrasena)`: recibe un email si hay espacio y contraseña correcta
- `eliminarCorreo(int tamanio)`: libera espacio al eliminar un email
- `mostrarEspacioDisponible(String contrasena)`: muestra espacio solo con contraseña correcta
- `cambiarContrasena(String actual, String nueva)`: cambia contraseña si la actual es correcta

---

## Ejercicio 7: Sistema de Películas - Plataforma de Streaming

Crea una clase `Suscripcion` que represente una suscripción a una plataforma de streaming:

### Atributos (privados)

- `idSuscriptor` (String): identificador único (inmutable)
- `nombre` (String): nombre del suscriptor
- `plan` (String): tipo de plan (básico, estándar, premium)
- `fechaVencimiento` (String): fecha de vencimiento
- `peliculasVistas` (int): número de películas vistas
- `claveAcceso` (String): clave para acceder a contenido premium

### Restricciones

- El ID no puede cambiar
- La clave no puede visualizarse
- Las películas vistas no pueden disminuir
- La suscripción solo puede renovarse con clave correcta

### Constructores

- Constructor con todos los atributos
- Constructor sin películas vistas (inicializa a 0)

### Métodos

- Getters y setters de atributos permitidos
- `verPelicula()`: incrementa el contador de películas vistas
- `renovarSuscripcion(String claveAcceso)`: renueva si la clave es correcta
- `cambiarPlan(String nuevoPlan, String claveAcceso)`: cambia el plan si la clave es válida
- `mostrarEstadoSuscripcion(String claveAcceso)`: muestra detalles solo con clave correcta
- `cambiarClave(String actual, String nueva)`: cambia la clave si la actual es correcta

---

## Ejercicio 8: Sistema de Vuelos - Gestión de Reservas Aéreas

Crea una clase `ReservaVuelo` que represente una reserva de vuelo:

### Atributos (privados)

- `numeroReserva` (String): número de reserva (inmutable)
- `pasajero` (String): nombre del pasajero
- `vuelo` (String): número de vuelo
- `asiento` (String): número de asiento
- `precio` (double): precio del vuelo
- `pagado` (boolean): indica si ya se pagó
- `codigoSeguro` (int): código de 6 dígitos para cambios/cancelaciones

### Restricciones

- El número de reserva no puede cambiar
- El código de seguro no puede consultarse
- El precio no puede ser negativo
- Solo se puede cambiar el asiento si no está pagado

### Constructores

- Constructor con todos los atributos
- Constructor sin pagado (se inicializa a false)

### Métodos

- Getters y setters de atributos permitidos
- `pagarReserva()`: marca la reserva como pagada
- `cambiarAsiento(String nuevoAsiento, int codigo)`: cambia asiento si es válido y no está pagado
- `cancelarReserva(int codigo)`: cancela si el código es correcto
- `mostrarDetalles()`: muestra estado de la reserva
- `cambiarCodigoSeguro(int actual, int nuevo)`: cambia código si el actual es correcto

---

## Ejercicio 9: Sistema de Medicinas - Gestión de Farmacia

Crea una clase `Medicamento` que represente un medicamento en una farmacia:

### Atributos (privados)

- `codigoFarmaco` (String): código único del medicamento (inmutable)
- `nombre` (String): nombre del medicamento
- `dosis` (String): dosis recomendada
- `precioUnitario` (double): precio por unidad
- `cantidad` (int): número de unidades en stock
- `controlado` (boolean): indica si es medicamento controlado
- `pinAdministrador` (int): PIN de 4 dígitos para acceso administrativo

### Restricciones

- El código no puede cambiar
- El PIN no puede consultarse
- La cantidad no puede ser negativa
- Los medicamentos controlados solo se venden con PIN correcto

## Constructores

- Constructor con todos los atributos
- Constructor sin cantidad (se inicializa a 0)

### Métodos

- Getters y setters de atributos permitidos
- `vender(int cantidad, int pin)`: vende si hay stock y (si es controlado) PIN correcto
- `reponer(int cantidad)`: añade medicamentos al stock
- `mostrarDisponibilidad()`: muestra stock disponible
- `consultarPrecio()`: devuelve el precio unitario
- `cambiarPin(int actual, int nuevo)`: cambia PIN si el actual es correcto

---

## Ejercicio 10: Sistema de Videojuegos - Biblioteca de Juegos

Crea una clase `Videojuego` que represente un juego en una plataforma de gaming:

### Atributos (privados)

- `idJuego` (String): identificador único del juego (inmutable)
- `titulo` (String): título del juego
- `genero` (String): género del juego
- `precio` (double): precio de compra
- `horasJugadas` (int): horas totales jugadas
- `logrosDesbloqueados` (int): número de logros conseguidos
- `tokenPropiedad` (String): token que prueba que eres propietario

### Restricciones

- El ID no puede cambiar
- El token no puede visualizarse
- Las horas jugadas no pueden disminuir
- Solo se pueden desbloquear logros si eres propietario (token)

### Constructores

- Constructor con todos los atributos
- Constructor sin horas jugadas (se inicializa a 0)

### Métodos

- Getters y setters de atributos permitidos
- `jugar(int horas, String token)`: añade horas si eres propietario
- `desbloquearLogro(int cantidad, String token)`: incrementa logros si token es válido
- `mostrarProgreso(String token)`: muestra horas y logros solo siendo propietario
- `transferirPropiedad(String nuevoToken)`: transfiere el token a otro usuario
- `cambiarToken(String actual, String nuevo)`: cambia el token si el actual es correcto

---

## Notas para la práctica

✅ **Conceptos clave a practicar:**

- Encapsulación (atributos privados)
- Constructores sobrecargados
- Getters y setters con validación
- Métodos que requieren validación (contraseña, PIN, token, etc.)
- Atributos inmutables (sin setter)
- Atributos derivados (no accesibles directamente)
- Métodos que interactúan con múltiples atributos

📝 **Recomendaciones:**

- Implementa cada ejercicio en un paquete separado
- Crea una clase Main para probar cada ejercicio
- Valida todas las restricciones en los métodos
- Maneja casos de error apropiadamente

🎯 **Estructura de las clases:**

- Cada clase debe tener sus atributos privados
- Incluye constructores sobrecargados
- Implementa getters y setters con lógica de validación
- Los métodos especiales deben validar credenciales

---
