USE rpgv1_0;
# Sobre ALTER dentro de BBDD
/** Sintaxis:
ALTER elemento nombre_elemento TIPO_comando tipo_subelemento nombre_elemento;
Donde:
- Elemento puede ser: DATABASE, TABLE, VIEW, INDEX,CONSTRAIN, USER o ROL
- nombre_elemento será el nombre del elemento al que nos referimos
- TIPO_comando puede ser: ADD o DROP principalmente.
	- Con comportamiento especial MODIFY, CHANGE o RENAME.
- tipo_subelemento: Como COLUMN, constraint, foreign key, ...
- nombre_elemento: el nombre del elemento, seguido de sus restricciones y especificaciones
*/
# Siempre es buena práctica usar describe en las tablas antes de modificarlas.
describe jugador;
# Ejemplos de ALTER ADD
# Agregar a la tabla JUGADOR una columna EDAD de tipo int
ALTER TABLE jugador ADD EDAD int;

# Ejemplos de ALTER drop
# Eliminar de la tabla jugador la columna EDAD
ALTER TABLE jugador DROP COLUMN EDAD;

ALTER TABLE jugador ADD EDAD int; # Para poder hacer los ALTERS siguientes
# Ejemplo de ALTER rename
ALTER TABLE jugador rename column EDAD to EDAD2;

/** Ejemplo de ALTER MODIFY - Consideraciones y función:
	- Sirve para modificar los tipos de datos y restricciones de un archivo.
    - No altera las columnas con UNIQUE
    - Elimina las propiedades DEFAULT
*/
# Modificar el tipo de dato de una tabla. Los UNIQUE se mantienen
ALTER TABLE jugador MODIFY column email text Not null;
ALTER TABLE jugador MODIFY column email char not null default('holamundo');

# ALTER CHANGE - Permite modificar nombre y tipodato
/** 
*/