DROP DATABASE IF EXISTS INSTITUTO;
CREATE DATABASE INSTITUTO;
USE INSTITUTO;
CREATE TABLE CURSO (
    ID_CURSO INT PRIMARY KEY AUTO_INCREMENT,
    MATERIAS INT,
    NOMBRE VARCHAR(50)
);
CREATE TABLE ALUMNO (
    ID_ALUMNO INT PRIMARY KEY AUTO_INCREMENT,
    NOMBRE VARCHAR(50),
    EDAD INT,
    ID_CURSO INT,
    FOREIGN KEY (ID_CURSO) REFERENCES CURSO(ID_CURSO)
);
INSERT INTO CURSO (ID_CURSO, MATERIAS)
VALUES (1, 5),
    (2, 3);
INSERT INTO ALUMNO (ID_ALUMNO, NOMBRE, EDAD, ID_CURSO)
VALUES (1, 'PEPE', 30, 1),
    (2, 'JUAN', 30, 2),
    (3, 'ANTONIO', 30, NULL);
-- comprobar que las tablas existen
SHOW TABLES;
-- consultas de ejemplo
-- Consulta usando JOIN
SELECT a.nombre,
    c.materias
FROM ALUMNO AS a
    JOIN CURSO AS c USING (ID_CURSO);
-- Consulta usando LEFT JOIN
SELECT *
FROM ALUMNO;
SELECT *
FROM CURSO;

USE sakila;

SELECT customer.first_name, country.country from country
join city on city.country_id = country.country_id
join address on city.city_id = address.city_id
join customer on address.address_id = customer.address_id;