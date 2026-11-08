# Premisa pract15 - Gestión de Juegos y Puntuaciones

Diseña un sistema de juego con clases abstractas e interfaces para distintos modos de juego.

## Objetivo

Fijar conceptos de diseño de jerarquías, polimorfismo y clases abstractas.

## Enunciado

1. Crea clase abstracta `Juego` con:
   - `String nombre`, `int nJugadores`.
   - Constructor, getters.
   - Método abstracto `void iniciarPartida()`.
   - Método `void mostrarInfo()`.

2. Interfaz `Puntuable` con:
   - `void asignarPuntaje(String jugador, int puntaje)`
   - `int obtenerPuntaje(String jugador)`
   - `Map<String,Integer> ranking()`

3. Crea subclases de `Juego`:
   - `JuegoSinglePlayer` (id del jugador único).
   - `JuegoMultiPlayer` (lista de jugadores, implementa `Puntuable`).

4. En `main`:
   - Crea instancias de ambos tipos.
   - Inicia partidas.
   - Para multijugador: asigna puntajes y muestra ranking.

---

✅ Extra: Añade clase `Torneo` con una lista de `Juego` y método `void correrTorneo()` que llame `iniciarPartida()` de cada juego y acumule los puntajes.
