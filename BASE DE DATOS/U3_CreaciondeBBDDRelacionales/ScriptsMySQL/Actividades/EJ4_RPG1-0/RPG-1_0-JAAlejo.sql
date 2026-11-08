DROP DATABASE IF EXISTS RPGV1_0;
CREATE DATABASE RPGV1_0;
USE RPGV1_0;

DROP TABLE IF EXISTS jugador;
CREATE TABLE jugador (
id_jugador INT PRIMARY KEY AUTO_INCREMENT,
nombre_usuario VARCHAR(50) UNIQUE NOT NULL,
email VARCHAR(50) UNIQUE NOT NULL,
registro TIMESTAMP DEFAULT (current_timestamp()),
esAdmin BOOLEAN NOT NULL DEFAULT(0)
);

DROP TABLE IF EXISTS personaje;
CREATE TABLE personaje (
id_personaje INT PRIMARY KEY AUTO_INCREMENT,
nombre_personaje VARCHAR(50) UNIQUE NOT NULL,
nivel INT UNSIGNED DEFAULT(1) CHECK (nivel>=1 AND nivel<=100),
experiencia DECIMAL(4,2) UNSIGNED DEFAULT(0) CONSTRAINT experiencia CHECK (experiencia>=0 AND experiencia<=100),
jugador_id int,
FOREIGN KEY (jugador_id) REFERENCES jugador(id_jugador) ON DELETE SET NULL
);

DROP TABLE IF EXISTS habilidades;
CREATE TABLE habilidades (
id_habilidad INT PRIMARY KEY AUTO_INCREMENT,
nombre_habilidad VARCHAR(50) UNIQUE NOT NULL,
descripcion TEXT NULL,	/*	Aunque se indica cadena de caracterers larga, siendo solo texto
							no se dará la ocasión en la cual la descripción de una habilidad por sí misma
                            requiera más espacio/almacenamiento del proporcionado por TEXT. En caso de necesitar
                            más espacio, la descripción no sería valida o se están indicando en la descripción cosas que no
                            proceden, como fortalezas, debilidades, cooldown, tipo elemental, etc
						*/
nivel_desbloqueo INT UNSIGNED DEFAULT(150) # CONSTRAINT niveldesbloqueo CHECK (nivel_desbloqueo>0 AND nivel_desbloqueo<=100)
/*	Consideración nivel_desbloqueo:
	Siendo que el nivel de desbloqueo de una habilidad no será mayor que el máximo nivel de un personaje(100), y no queremos 
    permitir valores negativos con UNSIGNED es suficiente.
    Por defecto será 150 (mayor al nivel máximo de un personaje) en lugar de 1 para evitar que al introducir
    una habilidad nueva en fase de pruebas, algún usuario pueda desbloquearla accidentalmente.
*/
);

DROP TABLE IF EXISTS misiones;
CREATE TABLE misiones (
id_mision INT PRIMARY KEY AUTO_INCREMENT,
titulo VARCHAR(100) NOT NULL,
descripcion_mision TEXT NULL,
dificultad SMALLINT UNSIGNED DEFAULT(1) CONSTRAINT nivel_recomendado CHECK (dificultad>=1 AND dificultad<=100)
/*	Consideración dificultad: Indica el nivel recomendado para realizar la misión
	por defecto 1, podemos usar NOT NULL pero entonces dará problemas con CHECK dificultad entre 1 y 100 inclusive
*/
);

DROP TABLE IF EXISTS personaje_mision;
CREATE TABLE personaje_mision (
id_relacionpm INT PRIMARY KEY AUTO_INCREMENT,
personaje_id int,
FOREIGN KEY (personaje_id) REFERENCES personaje(id_personaje) ON DELETE SET NULL,
mision_id int,
FOREIGN KEY (mision_id) REFERENCES misiones(id_mision) ON DELETE SET NULL,
/*	Consideración foreign keys: Indicado como on delete set null en ambos casos PERO
	sería mucho mejor no eliminarla, sino guardar el último valor conocido.
    En caso de querer conservar on delete set null para mision y para personaje, sería conveniente almacenar
    la id del jugador que realiza la misión, o bien crear un registro de MISIONES_COMPLETADAS para cada jugador
*/
fecha_realizacion TIMESTAMP DEFAULT (current_timestamp()),
recompensa_exp DECIMAL(6,2) UNSIGNED DEFAULT(1)
);

/* Insertar datos de prueba en la tabla jugador */
INSERT INTO jugador (nombre_usuario, email, esAdmin) VALUES ('Pepillo', 'pepillo@prueba.com', '0');
INSERT INTO jugador (nombre_usuario, email, esAdmin) VALUES ('Francisquillo', 'francisquillo@prueba.com', '1');


/* Insertar datos de prueba en la tabla personajes*/
INSERT INTO personaje (nombre_personaje, nivel, experiencia, jugador_id) VALUES('Francisquillo1','30','90.28','1');
INSERT INTO personaje (nombre_personaje, nivel, experiencia, jugador_id) VALUES('Pepillo1','40','90.28','2');

/* Insertar datos de prueba en la tabla misiones */
INSERT INTO misiones(titulo, descripcion_mision, dificultad) VALUES('En busca de la vaca dorada','Encuentra la misteriosa vaca dorada, última vez vista en el rancho del Baity','15');
INSERT INTO misiones(titulo, descripcion_mision, dificultad) VALUES('Al rescate de la vaca dorada','Recupera la increíble vaca dorada del rancho del Baito','20');

/* Insertar datos de prueba en la tabla personaje_mision */
INSERT INTO personaje_mision(personaje_id, mision_id, recompensa_exp) VALUES ('1','2','120.22');
INSERT INTO personaje_mision(personaje_id, mision_id, recompensa_exp) VALUES ('2','2','100.22');
INSERT INTO personaje_mision(personaje_id, mision_id, recompensa_exp) VALUES ('1','1','50.22');
INSERT INTO personaje_mision(personaje_id, mision_id, recompensa_exp) VALUES ('2','1','30.22');
SELECT * FROM personaje;
SELECT * FROM misiones;
SELECT * FROM personaje_mision;
/* Indices */
CREATE INDEX nivel_personaje ON personaje(nivel, jugador_id);
/* Ver Índices \ SHOW INDEX FROM "nombretabla"	*/
SHOW INDEX FROM personaje; /* Para ver los índices de una tabla*/

/* Consultas */

/*	Consulta para mostrar todos los personajes donde nivel sea igual a 10 o el nombre contenga la letra a*/
SELECT * from personaje where nivel = 10 or nombre_personaje like 'A%';

/*	Vistas	*/

/*	Crear Vistas (monotabla)*/
CREATE VIEW vista_personajemision20 AS	/* Crear vista*/
SELECT   personaje_id, mision_id, recompensa_exp	/* Seleccionar columnas*/
FROM personaje_mision	/* Tabla de donde sacamos los datos*/
WHERE recompensa_exp > 20;	/*Requisito para mostrar datos*/

DESCRIBE vista_personajemision20;	/* Para ver cómo está compuesta la view	*/
SELECT * FROM vista_personajemision20;	/* Para ver la vista como tabla */