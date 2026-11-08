# **BASE DE DATOS POKÉDEX**

Se desea diseñar e implementar una base de datos relacional que represente una **Pokédex de la primera generación de Pokémon**, teniendo en cuenta tanto la información básica de los Pokémon como sus tipos, movimientos, estadísticas, efectividad entre tipos y el progreso del usuario dentro del juego.

La base de datos deberá permitir **consultas diferenciadas según el rol del usuario**, garantizando la integridad de los datos y reflejando las reglas del dominio del problema.

## **TABLAS**

## **tipo**

Representa los distintos tipos de Pokémon existentes en la primera generación.

- **Nombre**: Identificador textual del tipo. Es único y obligatorio, ya que se utiliza como referencia desde otras tablas.
- **Símbolo**: Imagen o representación gráfica asociada al tipo. Debe existir siempre para cada tipo.

## **efectividad_doble_tipo**

Representa la efectividad de un tipo atacante contra Pokémon defensores que pueden tener uno o dos tipos.

- **Tipo atacante**: Tipo que realiza el ataque. Debe corresponder a un tipo válido existente.
- **Primer tipo defensor**: Tipo principal del Pokémon que recibe el ataque. Debe existir previamente.
- **Segundo tipo defensor**: Segundo tipo del Pokémon defensor. Puede admitir un valor nulo en caso de no existir tipo secundario en el pokemon defensor.
- **Multiplicador**: Valor numérico que indica la efectividad del ataque. Solo se admiten los multiplicadores propios del sistema de combate Pokémon (inmunidad → 0.00 , resistencia → 0.25 o 0.50 , neutralidad → 1.00 y ventajas → 2.00 o 4.00 ).

La manera de identificar de forma única e irrepetible las ocurrencias de esta tabla es la combinación de **Tipo atacante, Primer tipo defensor y Multiplicador.**

## **Pokemon**

Contiene la información principal de cada Pokémon.

- **Número de Pokédex**: Identificador numérico único que representa la posición oficial del Pokémon en la Pokédex.
- **Nombre**: Nombre del Pokémon. No puede repetirse y no puede estar nulo.
- **Especie**: Descripción corta de la especie a la que pertenece el Pokémon.
- **Altura**: Altura del Pokémon expresada en metros. Debe ser un valor positivo.
- **Peso**: Peso del Pokémon expresado en kilogramos. Debe ser un valor positivo.
- **Descripción**: Texto descriptivo que aparece en la Pokédex.
- **Primer tipo**: Tipo principal del Pokémon. Debe existir previamente como tipo válido.
- **Segundo tipo**: Tipo secundario del Pokémon, si lo tiene.
- **Visto**: Indica si el Pokémon ha sido visto por el usuario. Es un campo obligatorio y por defecto ningún pokemon fue visto originalmente.
- **Capturado**: Indica si el Pokémon ha sido capturado. Es un campo obligatorio y por defecto ningún pokemon fue capturado originalmente.
- **Sprite**: Imagen del Pokémon utilizada en la Pokédex.

## **Movimiento**

Almacena los movimientos existentes en la primera generación.

- **Identificador**: Identificador numérico interno del movimiento.
- **Nombre**: Nombre del movimiento. No puede repetirse y es obligatorio.
- **Tipo**: Tipo elemental del movimiento. Todo movimiento debe tener un tipo asociado siempre.
- **Potencia**: Valor muy pequeño y siempre positivo que representa el daño base del movimiento. Puede no existir en movimientos de estado.
- **Precisión**: Valor muy pequeño y siempre positivo que representa el acierto del movimiento.
- **Puntos de poder (PP)**: Número con valor muy pequeño y siempre positivo que representa las veces que el movimiento puede utilizarse.

## **Aprendizaje_Movimiento**

Relaciona Pokémon y movimientos, indicando cómo se aprenden.

- **Pokémon**: Pokémon que puede aprender el movimiento. Esto no puede ser nulo.
- **Movimiento**: Movimiento que puede ser aprendido. No puede contener valor null
- **Tipo de aprendizaje**: Forma en la que se aprende el movimiento (Nivel, MT o MO). Solo será uno de los valores antes mencionados.
- **Nivel**: Nivel al que se aprende el movimiento cuando el aprendizaje es por nivel. El nivel no puede ser 0 o inferior pero si puede ser valor nulo.
- **Número de MT/MO**: Número identificador de la MT o MO. No puede ser 0 o inferior.
Un movimiento no puede asignarse dos veces al mismo Pokémon por lo que esto sera nuestra manera de identificar cada registro de forma única.

## **Estadisticas_Base**

Contiene las estadísticas base de cada Pokémon.

- **Pokémon**: Pokémon al que pertenecen las estadísticas.
- **PS**: Puntos de salud base. Valor positivo, muy pequeño y no admite nulo.
- **Ataque**: Valor base de ataque. Valor positivo muy pequeño y no admite nulo.
- **Defensa**: Valor base de defensa. Valor positivo muy pequeño y no admite nulo.
- **Velocidad**: Valor base de velocidad. Valor positivo muy pequeño y no admite nulo.

Cada Pokémon tiene exactamente un conjunto de estadísticas base.

## **VISTAS**

El sistema debe permitir consultar:

- La tabla de tipos completa con sus multiplicadores obviando las inmunidades.
- Los Pokémon que han sido vistos solamente mostrando el número del pokemon, su sprite, nombre y la especie a la que pertenece.
- Los Pokémon que han sido capturados, mostrando información adicional con respecto a la anterior vista( Peso, Altura y Descripcion)

## **Índices**

La base de datos debe estar preparada para realizar de forma eficiente:

- Consultas frecuentes sobre Pokémon vistos.
- Consultas frecuentes sobre Pokémon vistos y capturados.
- Consultas por tipo de Pokémon.
- Consultas de efectividad según tipos defensivos( recuerda que existen dos tipos defensivos ).

## **Modificaciones**

Una vez creadas las tablas iniciales, se deberán aplicar ajustes adicionales para:

- Agrega una restricción para asegurar que un Pokémon no pueda tener dos tipos iguales.
- Asegurar que un Pokémon capturado haya sido visto previamente.
- Añadir campos temporales que indiquen cuándo un Pokémon ha sido visto y cuando ha sido capturado.
- Agrega una restricción para que si el tipo aprendizaje es por nivel, el nivel no pueda ser null y si lo sea el numero_MT_MO. Al contrario pase igual( el tipo aprendizaje es MT o MO nivel sea nulo, y numero_MT_MO no lo sea).
- Modificar nombres de columnas y relaciones manteniendo la integridad referencial.

## **USUARIOS, ROLES Y PERMISOS**

La base de datos será utilizada por distintos tipos de usuarios:

### **Profesor investigador**

Necesitamos un rol que permite consultar, insertar y actualizar pokemons, movimientos, aprendizajes, efectividades y tipos.

### **Alumnos**

Necesitaremos un rol que sólo permita consultar las vistas de visto, capturado y tabla de tipos.

### **Entidad suprema**

Este rol tendrá el poder para hacer cualquier cosa en nuestra base de datos.

Crea 3 usuarios que obtengan el rol de Alumno, uno para el rol de profesor y otro para el rol de Entidad suprema, asignarlos y activalos.
