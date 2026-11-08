USE tienda;
DROP TABLE IF EXISTS clientes;
CREATE TABLE clientes ( 
ID_Cliente int PRIMARY KEY AUTO_INCREMENT,
Nombre varchar(50) UNIQUE NOT NULL,
email varchar(40) UNIQUE,
telefono varchar(15) UNIQUE NULL
# Agregar FK de empleado cuando lo demos en clase
);
