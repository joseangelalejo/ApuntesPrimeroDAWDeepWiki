DROP DATABASE IF EXISTS Composiciones;
CREATE DATABASE Composiciones;
USE Composiciones;
CREATE TABLE departamentos (
    id_departamento INT PRIMARY KEY,
    nombre_departamento VARCHAR(50) NOT NULL
);
CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY,
    nombre_empleado VARCHAR(60) NOT NULL,
    id_departamento INT,
    sueldo DECIMAL(10, 2) NOT NULL
);
ALTER table empleados
add foreign key(id_departamento) references departamentos(id_departamento);
CREATE TABLE ubicaciones_departamento (
    id_departamento INT PRIMARY KEY,
    ciudad VARCHAR(40) NOT NULL
);
ALTER table ubicaciones_departamento
add foreign key(id_departamento) references departamentos(id_departamento);
CREATE TABLE extension_departamento (
    id_departamento INT PRIMARY KEY,
    ciudad VARCHAR(40) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    director VARCHAR(60) NOT NULL
);
ALTER table extension_departamento
add foreign key(id_departamento) references departamentos(id_departamento);
CREATE TABLE sedes (
    id_sede INT PRIMARY KEY,
    id_departamento INT NOT NULL,
    ciudad VARCHAR(40) NOT NULL,
    direccion VARCHAR(80) NOT NULL
);
ALTER table sedes
add foreign key(id_departamento) references departamentos(id_departamento);
CREATE TABLE proyectos (
    id_proyecto INT PRIMARY KEY,
    nombre_proyecto VARCHAR(80) NOT NULL
);
CREATE TABLE asignaciones (
    id_asignacion INT PRIMARY KEY,
    emp_id INT NOT NULL,
    proy_id INT NOT NULL,
    horas_semana INT NOT NULL
);
ALTER table asignaciones
add foreign key(proy_id) references proyectos(id_proyecto);
ALTER table asignaciones
add foreign key(emp_id) references empleados(id_empleado);
INSERT INTO departamentos
VALUES (10, 'Ventas'),
    (20, 'Informática'),
    (30, 'Recursos Humanos'),
    (40, 'Finanzas'),
    (50, 'Marketing');
INSERT INTO empleados
VALUES (1, 'Ana García', 10, 2100.00),
    (2, 'Luis Fernández', 10, 1850.00),
    (3, 'Marta López', 20, 3300.00),
    (4, 'Pablo Martín', 20, 2950.00),
    (5, 'Sofía Romero', NULL, 1500.00),
    (6, 'Javier Ruiz', 30, 2200.00),
    (7, 'Carmen Sánchez', 30, 2050.00),
    (8, 'Diego Navarro', 10, 1950.00),
    (9, 'Lucía Torres', 20, 3100.00),
    (10, 'Alberto Molina', 40, 2800.00),
    (11, 'Raquel Ortega', 40, 2650.00),
    (12, 'Héctor Castillo', NULL, 1750.00);
INSERT INTO ubicaciones_departamento
VALUES (10, 'Madrid'),
    (20, 'Barcelona'),
    (30, 'Sevilla'),
    (40, 'Valencia'),
    (50, 'Bilbao');
INSERT INTO extension_departamento
VALUES (10, 'Madrid', '910-111-222', 'Beatriz Alonso'),
    (20, 'Barcelona', '930-333-444', 'Ignacio Pastor'),
    (30, 'Sevilla', '950-555-666', 'María del Mar Ríos'),
    (40, 'Valencia', '960-777-888', 'Sergio Crespo'),
    (
        50,
        'San Sebastián',
        '944-999-000',
        'Nerea Etxeberria'
    );
INSERT INTO sedes
VALUES (1, 10, 'Madrid', 'C/ Alcalá 100'),
    (2, 20, 'Barcelona', 'Av. Diagonal 200'),
    (3, 30, 'Sevilla', 'C/ Sierpes 15'),
    (4, 40, 'Valencia', 'Gran Vía 10');
INSERT INTO proyectos
VALUES (100, 'CRM Comercial'),
    (110, 'Campaña Black Friday'),
    (200, 'Migración a la Nube'),
    (210, 'Ciberseguridad 2026'),
    (300, 'Plan de Onboarding');
INSERT INTO asignaciones
VALUES (1, 1, 100, 10),
    (2, 2, 110, 12),
    (3, 3, 200, 15),
    (4, 4, 210, 8),
    (5, 7, 300, 10),
    (6, 10, 210, 10),
    (7, 11, 210, 6);

/* COMPOSICIONES INTERNAS:
    1- Se utilizan para mostrar sólo los registros que tienen correspondencia en ambas tablas.
    2- Se pueden hacer con INNER JOIN o NATURAL JOIN.
    3- INNER JOIN: se especifica la condición de unión, es decir, las columnas por las que se van a unir las tablas. Si no se especifica la condición de unión, se hace un producto cartesiano, es decir, se combinan todos los registros de ambas tablas, lo que no es lo que queremos.
        Sintaxis: SELECT columnas FROM tabla1 INNER JOIN tabla2 ON condición_de_unión;
    4- NATURAL JOIN: se unen las tablas automáticamente por las columnas que tienen el mismo nombre, sin necesidad de especificar la condición de unión. Si no hay columnas con el mismo nombre, no se puede hacer un NATURAL JOIN. Si hay varias columnas con el mismo nombre, se unen todas esas columnas, y se muestran sólo una vez en el resultado.
        Sintaxis: SELECT columnas FROM tabla1 NATURAL JOIN tabla2;
*/
/* CONSIDERACIONES:
    1- En las composiciones internas, si no se especifica la condición de unión, se hace un producto cartesiano, es decir, se combinan todos los registros de ambas tablas, lo que no es lo que queremos.
    2- En el INNER JOIN, si no se especifica la condición de unión, se hace un producto cartesiano, es decir, se combinan todos los registros de ambas tablas, lo que no es lo que queremos.
    3- En el NATURAL JOIN, si no hay columnas con el mismo nombre, no se puede hacer un NATURAL JOIN. Si hay varias columnas con el mismo nombre, se unen todas esas columnas, y se muestran sólo una vez en el resultado.
*/

/*Condiciones de unión con NATURAL JOINT:
    1- La unión se realiza a través de las columnas con mismo nombre, de las tablas que queremos conectar
    2- Si existe más de una columna con el mismo nombre, se unirán todas esas columnas, y se mostrarán sólo una vez en el resultado.
*/
/* Mostrar todos los empleados(Nombre) con su departamento(Nombre) y su sueldo. */
-- Se puede hacer con NATURAL JOIN, ya que las tablas empleados y departamentos tienen una columna con el mismo nombre (id_departamento)
SELECT * FROM empleados;
SELECT nombre_empleado, nombre_departamento, sueldo
FROM empleados NATURAL JOIN departamentos;

/*Mostrar cada departamento(Soló nombre) con su ciudad (ubicación) y su información ampliada(
 teléfono y director), indicando también la ciudad que aparece en la información ampliada. */
SELECT * FROM departamentos;
SELECT departamentos.nombre_departamento AS Nombre_departamentos, 
    ubicaciones_departamento.ciudad AS ubicación, telefono, director, extension_departamento.ciudad AS extensión
    FROM departamentos NATURAL JOIN ubicaciones_departamento JOIN extension_departamento USING(id_departamento);
/*La diferencia entre usar, por ejemplo en este caso USIGN o NATURAL JOIN es:
    1- Hay que especificar la columna por la que se va a unir, en este caso id_departamento, ya que ambas tablas tienen varias columnas con el mismo nombre.
    2- En el resultado del NATURAL, no aparecerán todas las columnas de ambas tablas, porque se muestran solo las columnas que tienen el mismo nombre en ambas tablas, y se eliminan duplicados. 
    3- Por estas dos razones se utiliza más el USING, ya que es más explícito, y se pueden mostrar todas las columnas de ambas tablas, sin eliminar duplicados.
*/
/* Mostrar las asignaciones de empleados a proyectos, indicando:
 nombre del empleado, nombre del proyecto y horas por semana. */
SELECT * FROM proyectos;
select empleados.nombre_empleado, proyectos.nombre_proyecto, asignaciones.horas_semana
    FROM proyectos JOIN asignaciones ON proyectos.id_proyecto = asignaciones.proy_id 
    JOIN empleados ON asignaciones.emp_id = empleados.id_empleado;

/* COMPOSICIONES EXTERNAS: 
    1- Se utilizan para mostrar todos los registros de una tabla, aunque no tengan correspondencia en la otra tabla.
    2- Se pueden hacer con LEFT JOIN, RIGHT JOIN o FULL OUTER JOIN.
    3- LEFT JOIN: muestra todos los registros de la tabla de la izquierda, aunque no tengan correspondencia en la tabla de la derecha. Si no tienen correspondencia, se muestran NULL en las columnas de la tabla de la derecha.
        Sintaxis: SELECT columnas FROM tabla1 LEFT JOIN tabla2 ON condición_de_unión;
    4- RIGHT JOIN: muestra todos los registros de la tabla de la derecha, aunque no tengan correspondencia en la tabla de la izquierda. Si no tienen correspondencia, se muestran NULL en las columnas de la tabla de la izquierda.
        Sintaxis: SELECT columnas FROM tabla1 RIGHT JOIN tabla2 ON condición_de_unión;
    5- FULL OUTER JOIN: muestra todos los registros de ambas tablas, aunque no tengan correspondencia entre ellas. Si no tienen correspondencia, se muestran NULL en las columnas de la tabla que no tiene correspondencia.
        Sintaxis: SELECT columnas FROM tabla1 FULL OUTER JOIN tabla2 ON condición_de_unión;
*/
/* CONSIDERACIONES:
    1- En MySQL no existe el FULL OUTER JOIN, pero se puede simular con una combinación de LEFT JOIN y RIGHT JOIN.
    2- En las composiciones externas, si no se especifica la condición de unión, se hace un producto cartesiano, es decir, se combinan todos los registros de ambas tablas, lo que no es lo que queremos.
*/
/* Mostrar todos los empleados(nombre), tengan o no tengan departamento (si no tiene, debe salir NULL). */
SELECT nombre_empleado, nombre_departamento
FROM empleados LEFT JOIN departamentos ON empleados.id_departamento = departamentos.id_departamento;
/* Mostrar todos los departamentos, tengan o no tengan sede (si no tiene, debe salir NULL). */
SELECT nombre_departamento, ciudad, direccion
FROM departamentos LEFT JOIN sedes ON departamentos.id_departamento = sedes.id_departamento;