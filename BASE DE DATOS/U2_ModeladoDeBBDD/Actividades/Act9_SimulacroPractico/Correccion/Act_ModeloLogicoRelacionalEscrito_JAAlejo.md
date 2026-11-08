# Act9 - Modelo Lógico Relacional Escrito - José Ángel Alejo Sillero

## Entidades | Atributos | Claves Primarias

- Partidos: ID_Partido (PK), Fecha Inicio, Duración, Videojuego, Patrocinador.
- Equipos: Nombre_Equipo (PK), Entrenador, Logotipo, Presupuesto, Patrocinador (opcional).
- Jugador: ID_Jugador (PK), Nacionalidad, Alias, Fecha Nacimiento, Edad (derivado de Fecha Nacimiento).
- Jueces: Nº_Licencia (PK), Nombre, Nacionalidad, Fecha Nacimiento, Edad (derivado de Fecha Nacimiento).
- Pabellones: Nombre_Pabellón (PK), Ubicación, Capacidad, Cantidad de Pantallas, Tipo de conexión a internet.

## Relaciones | Claves foráneas

- Partidos_Compiten Equipos: Cardinalidad N:M, Participaciones (1,N) y (1,N).
  - Se crea una tabla intermedia "Partidos_Compiten_Equipos" con claves foráneas ID_Partido y Nombre_Equipo.
  - Y se le asigna una PK a la tabla: ID_PartidosCompiten (PK).
- Jueces_Supervisan Jugadores: Cardinalidad 1:1, Participaciones (0,1) y (0,1). Se crea una tabla intermedia "Jueces_Supervisan_Jugador" con claves foráneas Nº_Licencia y ID_Jugador.
  - Y se le asigna una PK a la tabla: ID_JuecesSupervisan (PK).
- Jueces_Asignados Partidos: Cardinalidad 1:N, Participaciones (1, N) y (0, 1). Se añade la clave primaria de Jueces (Nº_Licencia) como clave foránea en la tabla Partidos.
- Jugadores_Forman Equipos: Cardinalidad  1:N, Participaciones (1, N) y (1, 1). Se añade la clave primaria de Equipos (Nombre_Equipo) como clave foránea en la tabla Jugadores.
- Pabellones_Celebran Partidos: Cardinalidad 1:1, Participaciones (1, 1) y (1, 1). Es indiferente que clave primaria se añada como clave foránea en la tabla de la otra entidad, pero por claridad agregamos la clave primaria de Partidos (ID_Partido) como clave foránea en la tabla Pabellones.

## Tablas Resultantes

**De esta forma, las tablas resultantes serían:**

- Partidos: ID_Partido (PK), Fecha Inicio, Duración, Videojuego, Patrocinador. Nº_Licencia (FK).
- Equipos: Nombre_Equipo (PK), Entrenador, Logotipo, Presupuesto, Patrocinador (opcional).
- Jugador: ID_Jugador (PK), Nacionalidad, Alias, Fecha Nacimiento, Edad (derivado de Fecha Nacimiento). Nombre_Equipo (FK).
- Jueces: Nº_Licencia (PK), Nombre, Nacionalidad, Fecha Nacimiento, Edad (derivado de Fecha Nacimiento).
- Pabellones: Nombre_Pabellón (PK), Ubicación, Capacidad, Cantidad de Pantallas, Tipo de conexión a internet. ID_Partido (FK).

**Las tablas intermedias serían:**

- Partidos_Compiten_Equipos: ID_PartidosCompiten (PK), ID_Partido (FK), Nombre_Equipo (FK).
- Jueces_Supervisan_Jugador: ID_JuecesSupervisan (PK), Nº_Licencia (FK), ID_Jugador (FK).
