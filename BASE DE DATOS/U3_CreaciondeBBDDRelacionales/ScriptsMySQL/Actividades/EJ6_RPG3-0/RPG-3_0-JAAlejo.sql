-- DATABASE según premisa:
DROP DATABASE IF EXISTS RPGV3_0;
CREATE DATABASE RPGV3_0;
USE RPGV3_0;

-- TABLA JUGADOR
DROP TABLE IF EXISTS jugador;
CREATE TABLE jugador (
    id_jugador INT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    esAdmin BOOLEAN NOT NULL DEFAULT(0)
);

-- TABLA PERSONAJE
DROP TABLE IF EXISTS personaje;
CREATE TABLE personaje (
    id_personaje INT PRIMARY KEY AUTO_INCREMENT,
    nombre_personaje VARCHAR(50) UNIQUE NOT NULL,
    nivel INT DEFAULT 1 CHECK (nivel BETWEEN 1 AND 100),
    experiencia INT DEFAULT 1 CHECK (experiencia BETWEEN 0 AND 100),
    jugador_id INT,
    FOREIGN KEY (jugador_id)
        REFERENCES jugador(id_jugador)
        ON DELETE SET NULL
);

-- TABLA HABILIDADES
DROP TABLE IF EXISTS habilidades;
CREATE TABLE habilidades (
    id_habilidad INT PRIMARY KEY AUTO_INCREMENT,
    nombre_habilidad VARCHAR(50) UNIQUE NOT NULL,
    descripcion TEXT NULL,
    nivel_desbloqueo INT DEFAULT 1 CHECK (nivel_desbloqueo BETWEEN 1 AND 100)
);

-- TABLA MISIONES
DROP TABLE IF EXISTS misiones;
CREATE TABLE misiones (
    id_mision INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    descripcion_mision TEXT NULL,
    dificultad INT CHECK (dificultad BETWEEN 1 AND 100)
);

-- TABLA PERSONAJE_MISION
DROP TABLE IF EXISTS personaje_mision;
CREATE TABLE personaje_mision (
    id_relacionpm INT PRIMARY KEY AUTO_INCREMENT,
    personaje_id INT,
    mision_id INT,
    fecha_realizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    recompensa_exp INT,
    FOREIGN KEY (personaje_id)				-- Atributo personaje_id en esta tabla
        REFERENCES personaje(id_personaje)	-- PM id_personaje en tabla "personaje"
        ON DELETE SET NULL,					-- Se establece como NULL al borrar la tabla/columna al que hace referencia
    FOREIGN KEY (mision_id)					-- Atributo mision_id en esta tabla
        REFERENCES misiones(id_mision)		-- PM id_mision en tabla "misiones"
        ON DELETE SET NULL					-- Se establece como NULL al borrar la tabla/columna al que hace referencia
);

-- Insertar datos de prueba
/* Insertar datos de prueba en la tabla jugador */
INSERT INTO jugador (nombre_usuario, email, esAdmin) VALUES ('Pepillo', 'pepillo@prueba.com', '0');
INSERT INTO jugador (nombre_usuario, email, esAdmin) VALUES ('Francisquillo', 'francisquillo@prueba.com', '1');

	-- Ver tabla
	SELECT * FROM jugador;

/* Insertar datos de prueba en la tabla personajes*/
INSERT INTO personaje (nombre_personaje, nivel, experiencia, jugador_id) VALUES('Francisquillo1','30','90.28','1');
INSERT INTO personaje (nombre_personaje, nivel, experiencia, jugador_id) VALUES('Pepillo1','40','90.28','2');

	-- Ver tabla
    SELECT * FROM personaje;
/* Insertar datos de prueba en la tabla misiones */
INSERT INTO misiones(titulo, descripcion_mision, dificultad) VALUES('En busca de la vaca dorada','Encuentra la misteriosa vaca dorada, última vez vista en el rancho del Baity','15');
INSERT INTO misiones(titulo, descripcion_mision, dificultad) VALUES('Al rescate de la vaca dorada','Recupera la increíble vaca dorada del rancho del Baito','20');

	-- Ver tabla
    SELECT * FROM misiones;

/* Insertar datos de prueba en la tabla personaje_mision */
INSERT INTO personaje_mision(personaje_id, mision_id, recompensa_exp) VALUES ('1','2','120.22');
INSERT INTO personaje_mision(personaje_id, mision_id, recompensa_exp) VALUES ('2','2','100.22');
INSERT INTO personaje_mision(personaje_id, mision_id, recompensa_exp) VALUES ('1','1','50.22');
INSERT INTO personaje_mision(personaje_id, mision_id, recompensa_exp) VALUES ('2','1','30.22');

	-- Ver tabla
    SELECT * FROM personaje_mision;