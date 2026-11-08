DROP DATABASE IF EXISTS tiendajaalejo;
CREATE DATABASE tiendajaalejo;
USE tiendajaalejo;
DROP TABLE IF EXISTS empleados;
CREATE TABLE empleados ( 
ID_Empleado int PRIMARY KEY AUTO_INCREMENT,
Nombre varchar(50) UNIQUE NOT NULL,
Apellidos varchar (50),
Cargo ENUM ('LIMPIADOR', 'REPONEDOR', 'CAJERO'), 
Salario decimal(7,2), 
telefono int(9) UNIQUE NULL
);
DROP TABLE IF EXISTS productos;
CREATE TABLE productos ( 
ID_Producto int PRIMARY KEY AUTO_INCREMENT,
Nombre varchar(30) NOT NULL, -- 30 es M, donde M indica la cantidad maxima de caracteres
Precio decimal(6,2), /* Indica M, D donde M es cantidad de digitos y
						D es cantidad de digitos que serán decimales contando desde la derecha 
						En este caso, el dígito máximo almacenado será 9999,99 (9 mil 999 con 99)
                    */
stock int unsigned, # unsigned indica que no puede ser negativo
# Agregar FK de empleado cuando lo demos en clase
ID_Empleado int,
FOREIGN KEY (ID_Empleado) REFERENCES empleados(ID_Empleado)
);
DROP TABLE IF EXISTS clientes;
CREATE TABLE clientes ( 
ID_Cliente int PRIMARY KEY AUTO_INCREMENT,
Nombre varchar(50) UNIQUE NOT NULL,
email varchar(40) UNIQUE,
telefono varchar(15) UNIQUE NULL,
# Agregar FK de empleado cuando lo demos en clase
ID_Empleado int,
FOREIGN KEY (ID_Empleado) REFERENCES empleados(ID_Empleado)
);