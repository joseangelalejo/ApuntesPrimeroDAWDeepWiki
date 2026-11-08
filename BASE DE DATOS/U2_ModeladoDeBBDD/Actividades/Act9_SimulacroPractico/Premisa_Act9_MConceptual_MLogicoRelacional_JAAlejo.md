# Premisa de Actividad 9: Modelo E-R y Lógico Relacional

## Enunciado - e-Sports

Se va a celebrar un gran torneo de e-Sports, y para poder organizarlo correctamente se nos ha pedido realizar un modelo entidad-relación del evento, para luego realizar su transformación al modelo relacional. Sabemos lo siguiente:

- El torneo incluye muchos partidos diferentes que se llevarán a cabo durante varios días.
  - Cada uno de los partidos tendrá una fecha de inicio, una duración concreta, y si lo tiene, también almacenaremos el patrocinador del partido.
  - En estos partidos se juegan diferentes videojuegos. Hay que tener en cuenta que el videojuego no identifica de forma única al partido (puede haber varios partidos con el mismo videojuego, por ejemplo, League of Legends 5v5 y League of Legends 1v1 cuentan como el mismo videojuego).
- Todos los partidos que se celebran son de equipos de jugadores, por lo que estos serán los que compitan en los partidos.
  - Un equipo puede competir en varios partidos diferentes, pero debe participar en al menos un partido una vez registrado. De igual forma, un partido no se registrará si ningún equipo participa.
  - No permitiremos que se registren dos equipos con el mismo nombre para diferenciarlos.
  - Cada equipo debe tener un entrenador, un logotipo representativo, y un presupuesto, ya que se quieren nivelar los primeros enfrentamientos. Al igual que los partidos, los equipos pueden tener un patrocinador.
- Cada partido contará como mínimo con un juez, aunque en ocasiones se necesitarán varios jueces para el mismo partido. 
  - La organización del torneo busca evitar conflictos, por lo que se requiere el Nº de licencia de cada juez, para que no sea asignado a más de un partido, evitando posibles manipulaciones.
  - Además de la licencia, se necesita conocer su nombre, nacionalidad, y fecha de nacimiento, con este último dato se calculará la edad del juez y se almacenará.
- Algunos jueces tienen una particularidad, ya que también pueden estar asignados para supervisar a un jugador en concreto.
  - Es posible que algunos jueces no tengan esta función, pero aquellos que sí lo hagan solo podrán supervisar a un jugador.
  - Lo mismo ocurre con los jugadores, que pueden estar supervisados por un solo juez o no estar bajo supervisión.
- Los jugadores son aquellos que forman parte de los equipos.
  - Los jugadores solo pueden pertenecer a un equipo y no pueden jugar por sí solos.
  - De ellos, sabemos su nacionalidad, alias / apodo, fecha de nacimiento, y la edad, calculada a partir de la fecha de nacimiento. Además, se les asignará un número identificativo único.
- Finalmente, tenemos los pabellones, que son los lugares donde se celebrarán los partidos.
  - Cada partido debe realizarse en un único pabellón, y cada pabellón solo puede albergar un partido.
    - Si un pabellón no alberga ningún partido, no formará parte de la base de datos.
    - Los pabellones se diferencian por su nombre, y cuentan con una ubicación, capacidad, y la cantidad de pantallas de las que dispone.
    - Además, se almacenará el tipo de conexión a internet de la que se dispone en el recinto.

NOTA: **PREMISA FORMATEADA POR JOSÉ ÁNGEL ALEJO SILLERO**
