CREATE DATABASE Instituto;
USE Instituto;
CREATE TABLE alumno(
id int primary key auto_increment,
nombre varchar(50),
apellido1 varchar(50),
apellido2 varchar(50),
fecha_nacimiento date,
email varchar(100)
);