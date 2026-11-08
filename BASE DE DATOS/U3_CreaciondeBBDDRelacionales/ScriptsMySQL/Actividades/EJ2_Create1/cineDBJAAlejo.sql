DROP DATABASE IF EXISTS cineDB;
CREATE DATABASE cineDB;
USE cineDB;
DROP TABLE IF EXISTS peliculas;
CREATE TABLE peliculas ( 
ID_Pelicula int PRIMARY KEY AUTO_INCREMENT,
Titulo VARCHAR(50),
Director VARCHAR(50),
Duracion_Minutos INT, /* Con restricción de formato HH:MM:SS (horas:minutos:segundos) DONDE
						HH, MM y SS serían digitos y sería obligatoria la presencia
                        de : como elemento separador */
Anio_Lanzamiento YEAR
);
DROP TABLE IF EXISTS actores;
CREATE TABLE actores ( 
ID_Actor int PRIMARY KEY AUTO_INCREMENT,
Nombre VARCHAR(50),
Edad INT(3), /* Restricción de hasta 3 dígitos (999), aplicaría restricciones
				UNSIGNED para que sea mínimo 0 y 
                restricción para valores máximos a 199 */
Genero VARCHAR(20) /* Para permitir generos no convencionales (hombre/mujer)
					aunque realmente haría un ENUM ("HOMBRE", "MUJER", "OTROS") donde permitir OTROS, asociado a
                    un booleano, donde si el usuario ha elegido OTROS, se permite rellenar un campo
                    varchar(20)*/
);
DROP TABLE IF EXISTS clasificaciones;
CREATE TABLE clasificaciones ( 
ID_Clasificacion int PRIMARY KEY AUTO_INCREMENT,
Clasificacion VARCHAR(10)
);
