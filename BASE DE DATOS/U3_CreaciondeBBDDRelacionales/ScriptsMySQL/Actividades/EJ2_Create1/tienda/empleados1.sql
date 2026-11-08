USE tienda;
DROP TABLE IF EXISTS empleados;
CREATE TABLE empleados ( 
ID_Empleado int PRIMARY KEY AUTO_INCREMENT,
Nombre varchar(50) UNIQUE NOT NULL,
Apellidos varchar (50),
Cargo ENUM ('LIMPIADOR', 'REPONEDOR', 'CAJERO'), 
Salario decimal(7,2), 
telefono int(9) UNIQUE NULL
);
