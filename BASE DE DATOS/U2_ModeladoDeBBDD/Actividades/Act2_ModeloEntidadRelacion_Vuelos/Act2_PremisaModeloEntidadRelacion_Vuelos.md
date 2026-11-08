# PREMISA

## Modelo Entidad-Relación Vuelos

Crear el esquema entidad/relación que permita gestionar reservas de vuelos, de modo que:

- Los clientes pueden hacer reservas. Con la reserva se pueden reservar varias plazas, pero no poseeremos el número de asiento hasta obtener la tarjeta de embarque.
- Se pueden obtener tarjetas de embarque sin tener reserva.
- Las tarjetas de embarque se refieren a un único cliente. Cada cliente puede sacar su tarjeta de embarque indicando el número de reserva, la fecha de la misma y sus datos personales (dni, nombre, apellidos, dirección y teléfono).Además, la persona que reserva debe indicar una tarjeta de crédito que quedará asociada a esa persona. Las tarjetas de embarque tendrán la información del asiento de los clientes, como el numero fila y columna.
- El vuelo que se reserva tiene un código único, una fecha y una hora de salida y de llegada, y un aeropuerto de salida y otro de llegada.
- Los aeropuertos poseen un código único, además del nombre y la localidad y el país en el que se encuentran.
