DROP DATABASE IF EXISTS ITP_Pablo_de_la_Torre;
CREATE DATABASE ITP_Pablo_de_la_Torre;
USE ITP_Pablo_de_la_Torre;
DROP TABLE IF EXISTS profesor;
CREATE TABLE profesor (
id_profesor INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(60) NOT NULL,
email VARCHAR(80) UNIQUE NOT NULL,
salario DECIMAL(6,2) CHECK(salario>=1000) 
);
DROP TABLE IF EXISTS curso;
CREATE TABLE curso (
id_curso INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(80) NOT NULL UNIQUE,
nivel  ENUM('BÁSICO','INTERMEDIO','AVANZADO') DEFAULT('BÁSICO'),
profesor_id int,
constraint fk_profesor FOREIGN KEY (profesor_id) REFERENCES profesor(id_profesor)
);
DROP TABLE IF EXISTS alumno;
CREATE TABLE alumno (
id_alumno INT PRIMARY KEY AUTO_INCREMENT,
nombre TINYTEXT NOT NULL,
fecha_nacimiento DATE CHECK (fecha_nacimiento<='2025-12-09'), /*	De momento se introduce manualmente la fecha actual.
																	Para que compare la fecha con la fecha actual, se utilizarán triggers
                                                                    y aún no lo hemos visto
                                                                */
email VARCHAR(40) UNIQUE NOT NULL DEFAULT(concat(nombre, '@itpfp.com'))
);
DROP TABLE IF EXISTS matricula;
CREATE TABLE matricula (
constraint id_matricula PRIMARY KEY(curso_id, alumno_id),
curso_id int,	# Atributo para foreign key de curso
FOREIGN KEY (curso_id) REFERENCES curso(id_curso) ON DELETE CASCADE,	/*	Referencia de FK a PK. Establecería como ON DELETE SET NULL, si no fuera por (linea 36)*/
/* ON DELETE CASCADE realiza:
	al eliminar una fila de la tabla principal, las filas dependientes
	en esta tabla se eliminará, es decir:
	si eliminamos un curso, las matrículas asociadas se eliminarán
*/
/*	Consideración ON DELETE SET NULL:
	en la foreign key no permite establecer ON DELETE SET NULL. PORQUE
	aunque en la práctica funciona, puede ser que ahora mismo no lo permita porque
    las ocurrencias actuales están vacias, generando una excepción no controlada
*/
alumno_id int,	# Atributo para foreign key de alumno
FOREIGN KEY (alumno_id) REFERENCES alumno(id_alumno) ON DELETE CASCADE,	/*	Referencia de FK a PK.*/
fecha_matriculacion DATE DEFAULT (current_date()) # También podría ser: fecha_matriculacion DATE DEFAULT (date(now()))
);
