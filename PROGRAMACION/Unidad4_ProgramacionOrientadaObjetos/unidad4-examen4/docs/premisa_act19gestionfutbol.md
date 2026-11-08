# Premisa Actividad 19: Sistema de gestión de jugadores de futbol

Crear un sistema de gestión de jugadores de fútbol que permita administrar distintos tipos de jugadores (como delanteros, porteros o defensas). Cada jugador tiene un nombre, una edad y un número de camiseta. Algunos jugadores, además, pueden ser valorados según su rendimiento.

> Requerimientos:

Define una interfaz Valorable con los siguientes métodos:

- double calcularValor(): Un método para calcular el valor del jugador.
- String nivelJugador(): Un método para indicar el nivel del jugador ("Estrella", "Titular", "Suplente").

Define una clase abstracta Jugador que represente a un jugador de fútbol e implementa la interfaz. Esta clase debe contener los siguientes atributos y métodos:

- Atributos:
  - String nombre: El nombre del jugador.
  - int edad: La edad del jugador.
  - int numero: El número de camiseta.
- Métodos:
  - Constructor que inicializa los atributos.
  - Método abstracto double calcularRendimiento() que deberá ser implementado por las subclases.
  - Método void mostrarDatos() que muestre la información del jugador.

Define las siguientes subclases de Jugador:

> Delantero

Añade el atributo:

- int goles: Número de goles marcados.

> Portero

Añade el atributo:

- int paradas: Número de paradas realizadas.

> Defensa

Añade el atributo:

- int robos: Número de balones recuperados.

Implementa los métodos necesarios en las clases para calcular el rendimiento, el valor y el nivel de cada jugador.

> Cálculo del rendimiento (orientativo):

- Delantero: en función de los goles.
- Portero: en función de las paradas.
- Defensa: en función de los robos.

> Nivel del jugador (orientativo):

- Alto rendimiento → "Estrella"
- Rendimiento medio → "Titular"
- Bajo rendimiento → "Suplente"

> Define una clase Equipo que contenga:

- Atributos:
  - String nombre: Nombre del equipo.
  - Jugador[] jugadores: Array de jugadores.
- Métodos:
  - Mostrar los datos de todos los jugadores.
  - Calcular el rendimiento total del equipo.

Finalmente, crea una clase Main que contenga el método main para probar tu sistema:

- Crea instancias de distintos tipos de jugadores.
- Añádelos a un equipo.
- Muestra sus datos, rendimiento, valor y nivel.
