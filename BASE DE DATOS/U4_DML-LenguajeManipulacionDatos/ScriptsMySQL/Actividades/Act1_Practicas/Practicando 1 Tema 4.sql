DROP DATABASE IF EXISTS tema4_select;
CREATE DATABASE tema4_select;
USE tema4_select;

CREATE TABLE departamentos (
  id_departamento INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(60) NOT NULL,
  ciudad VARCHAR(60) NOT NULL
);

CREATE TABLE empleados (
  id_empleado INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(40) NOT NULL,
  apellidos VARCHAR(60) NOT NULL,
  email VARCHAR(120),
  telefono VARCHAR(30),
  salario DECIMAL(10,2) NOT NULL,
  comision DECIMAL(10,2) NULL,
  fecha_alta DATE NOT NULL,
  puesto VARCHAR(50) NOT NULL,
  id_departamento INT NOT NULL,
  CONSTRAINT fk_emp_dept FOREIGN KEY (id_departamento) REFERENCES departamentos(id_departamento)
);

CREATE TABLE clientes (
  id_cliente INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(60) NOT NULL,
  apellidos VARCHAR(80) NOT NULL,
  email VARCHAR(120),
  ciudad VARCHAR(60) NOT NULL,
  pais VARCHAR(60) NOT NULL,
  telefono VARCHAR(30),
  fecha_registro DATE NOT NULL
);

CREATE TABLE productos (
  id_producto INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(80) NOT NULL,
  categoria VARCHAR(60) NOT NULL,
  precio DECIMAL(10,2) NOT NULL,
  stock INT NOT NULL,
  descuento DECIMAL(5,2) NULL
);

CREATE TABLE pedidos (
  id_pedido INT PRIMARY KEY AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  fecha DATE NOT NULL,
  estado ENUM('pendiente','enviado','entregado','cancelado') NOT NULL, 
  gastos_envio DECIMAL(10,2) NOT NULL,
  CONSTRAINT fk_ped_cliente FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

CREATE TABLE lineas_pedido (
  id_linea INT PRIMARY KEY AUTO_INCREMENT,
  id_pedido INT NOT NULL,
  id_producto INT NOT NULL,
  cantidad INT NOT NULL,
  precio_unitario DECIMAL(10,2) NOT NULL,
  CONSTRAINT fk_lin_ped FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
  CONSTRAINT fk_lin_prod FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

INSERT INTO departamentos (nombre, ciudad) VALUES
('Ventas', 'Madrid'),
('Marketing', 'Barcelona'),
('IT', 'Valencia'),
('Finanzas', 'Madrid'),
('Logística', 'Sevilla');

INSERT INTO empleados (nombre, apellidos, email, telefono, salario, comision, fecha_alta, puesto, id_departamento) VALUES
('Ana',   'López Martín',   'ana.lopez@empresa.com',   '600111222', 2100.00,  250.00, '2023-02-15', 'Comercial', 1),
('Luis',  'Pérez Gómez',    'luis.perez@empresa.com',  '600333444', 1800.00,   NULL, '2022-10-01', 'Marketing Jr', 2),
('Marta', 'Sánchez Ruiz',   'marta.sanchez@empresa.com','600555666', 2600.00,  400.00,'2021-06-20', 'Comercial Senior', 1),
('Jorge', 'Díaz Torres',    NULL,                      '600777888', 3200.00,   NULL, '2020-01-10', 'Admin Sistemas', 3),
('Nerea', 'Gil Navarro',    'nerea.gil@empresa.com',   NULL,        2950.00,  100.00,'2024-03-05', 'Analista', 4),
('Iván',  'Romero Vidal',   'ivan.romero@empresa.com', '600999000', 1500.00,   NULL, '2024-11-18', 'Mozo Almacén', 5),
('Sara',  'Molina Cano',    'sara.molina@empresa.com', '611222333', 2400.00,  300.00,'2022-04-12', 'Comercial', 1),
('Óscar', 'Herrera León',   'oscar.herrera@empresa.com','611444555', 2750.00,   NULL, '2023-09-30', 'Desarrollador', 3);

INSERT INTO clientes (nombre, apellidos, email, ciudad, pais, telefono, fecha_registro) VALUES
('Carlos', 'Vega Santos',    'c.vega@gmail.com',     'Madrid',     'España', '700111222', '2023-01-09'),
('Lucía',  'Ortega Nieto',   'lucia.o@hotmail.com',  'Barcelona',  'España', '700333444', '2023-07-21'),
('Paula',  'Ríos Medina',    NULL,                  'Valencia',   'España', NULL,        '2024-02-11'),
('Hugo',   'Campos Lara',    'hugo.campos@gmail.com','Sevilla',    'España', '700555666', '2024-05-30'),
('Emma',   'Suárez Pardo',   'emma.suarez@gmail.com','Lisboa',     'Portugal','351900111','2022-12-01'),
('Noah',   'Martins Silva',  'noah.ms@gmail.com',    'Oporto',     'Portugal','351900222','2024-09-14'),
('Sofía',  'Navarro Pérez',  'sofia.np@gmail.com',   'Madrid',     'España', '700777888', '2025-01-03'),
('Diego',  'Iglesias Mora',  'diego.im@gmail.com',   'Bilbao',     'España', '700999000', '2023-11-17');

INSERT INTO productos (nombre, categoria, precio, stock, descuento) VALUES
('Teclado Mecánico',     'Periféricos',  79.99,  30,  10.00),
('Ratón Gaming',         'Periféricos',  49.90,  50,  NULL),
('Monitor 24"',          'Monitores',   159.00,  20,  15.00),
('Monitor 27"',          'Monitores',   249.00,  12,  20.00),
('SSD 1TB',              'Almacenamiento', 89.50, 40, NULL),
('HDD 2TB',              'Almacenamiento', 69.99, 35,  5.00),
('Portátil 14"',         'Portátiles',  699.00,  8,  50.00),
('Portátil 16"',         'Portátiles',  999.00,  5,  NULL),
('Auriculares Bluetooth','Audio',        59.90,  25,  10.00),
('Altavoz',              'Audio',        39.90,  60,  NULL);

INSERT INTO pedidos (id_cliente, fecha, estado, gastos_envio) VALUES
(1, '2024-01-10', 'entregado',  4.99),
(2, '2024-02-05', 'enviado',    6.50),
(3, '2024-02-20', 'cancelado',  4.99),
(4, '2024-03-02', 'entregado',  0.00),
(1, '2024-04-15', 'pendiente',  3.99),
(5, '2023-12-22', 'entregado',  7.99),
(6, '2024-10-01', 'enviado',    5.99),
(7, '2025-01-12', 'pendiente',  4.50);

INSERT INTO lineas_pedido (id_pedido, id_producto, cantidad, precio_unitario) VALUES
(1, 1, 1, 79.99),
(1, 2, 2, 49.90),
(2, 3, 1, 159.00),
(2, 9, 1, 59.90),
(3, 7, 1, 699.00),
(4, 10, 2, 39.90),
(4, 6, 1, 69.99),
(5, 5, 3, 89.50),
(6, 4, 1, 249.00),
(6, 1, 1, 79.99),
(7, 8, 1, 999.00),
(7, 2, 1, 49.90),
(8, 9, 2, 59.90);

-- Muestra todas las columnas de empleados.
SELECT * FROM empleados;
-- Muestra solo nombre, apellidos y salario de empleados.
SELECT nombre,apellidos,salario FROM empleados;
-- Muestra nombre, categoría y precio de productos.
SELECT nombre,categoria,precio FROM productos;
-- Muestra todas las columnas de clientes.
SELECT * FROM clientes;
-- Muestra id_pedido, fecha y estado de pedidos.
SELECT id_pedido,fecha,estado FROM pedidos;
-- En empleados, muestra nombre, salario y salario incrementado en 200 €.
SELECT nombre, salario, salario + 200 AS salario_incrementado FROM empleados;
-- Muestra nombre, salario mensual y salario anual calculado.
SELECT nombre, salario, salario * 12 AS salario_anual FROM empleados;
-- En productos, muestra nombre, precio original, precio rebajado en 10 € y precio con IVA incluido.
SELECT nombre, precio, precio - 10 AS precio_rebajado, (precio) * 1.21 AS precio_conIVA FROM productos;
-- En lineas_pedido, muestra id_pedido, id_producto y el subtotal de cada línea.
SELECT id_pedido, id_producto, (cantidad * precio_unitario) AS subtotal FROM lineas_pedido;
-- En pedidos, muestra todos los datos incluyendo una columna con gastos de envío con IVA aplicado.
SELECT *, (gastos_envio*1.21) AS gastos_envioConIVA FROM pedidos;
-- En empleados, muestra nombre y apellidos con los encabezados "Nombre" y "Apellidos".
SELECT nombre AS Nombre, apellidos AS Apellidos FROM empleados;
-- En productos, muestra nombre y precio con el encabezado "Precio (€)".
SELECT nombre, precio AS 'Precio(€)' FROM productos;
-- En lineas_pedido, muestra id_linea e importe total de cada línea.
SELECT id_linea, (cantidad * precio_unitario) AS importe_total FROM lineas_pedido;
-- En clientes, muestra nombre y fecha_registro con el encabezado "Alta".
SELECT nombre, fecha_registro AS Alta FROM clientes;
-- En clientes, muestra una columna cliente formada por nombre y apellidos.
SELECT concat(nombre, ' ', apellidos) AS Cliente FROM clientes;
-- En empleados, muestra una columna empleado formada por apellidos y nombre separados por coma.
SELECT concat(apellidos, ', ', nombre) FROM empleados;
-- En clientes, muestra id_cliente junto con el texto "Cliente: Nombre Apellidos - País".
SELECT id_cliente, concat('Cliente: ', nombre, ' ', apellidos, ' - ', pais) AS Datos_Cliente FROM clientes;
-- En productos, muestra id_producto junto con el texto "Producto: Nombre (Categoría)".
SELECT id_producto, concat('Producto: ', nombre, ' (', categoria, ')') AS Datos_Producto FROM productos;
-- Lista todas las ciudades de clientes (con posibles repeticiones).
SELECT ciudad FROM clientes;
-- Lista las ciudades de clientes sin repetir.
SELECT distinct ciudad FROM clientes;
-- Lista los países de clientes sin repetir.
SELECT distinct pais FROM clientes;
-- Lista los puestos existentes entre empleados sin repetir.
SELECT distinct puesto FROM empleados;
-- Muestra todos los datos de empleados con salario superior a 2500 €.
SELECT * FROM empleados WHERE salario>2500;
-- Muestra todos los datos de productos cuyo precio no supere los 60 €.
SELECT * FROM productos WHERE precio<=60;
-- Muestra todos los datos de clientes que residan en España.
SELECT * FROM clientes WHERE pais = 'España';
-- Muestra todos los datos de pedidos cuyo estado no sea entregado.
SELECT * FROM pedidos WHERE estado != 'entregado';
-- Muestra nombre y salario de empleados que no tengan comisión.
SELECT nombre, salario FROM empleados WHERE comision IS NULL;
-- Muestra nombre y correo electrónico de empleados con email registrado.
SELECT nombre, email FROM empleados WHERE email IS NOT NULL;
-- Muestra todos los datos de productos sin descuento aplicado.
SELECT * FROM productos WHERE descuento IS NULL;
-- Muestra nombre y stock de productos con existencias entre 10 y 30 unidades.
SELECT nombre, stock FROM productos WHERE stock >=10 && stock <=30;
-- Muestra id_pedido y fecha de pedidos realizados entre el 1 de febrero y el 31 de marzo de 2024.
SELECT id_pedido, fecha FROM pedidos WHERE fecha BETWEEN '2024-02-01' AND '2024-03-31' order by FECHA DESC;

-- Muestra todos los datos de productos de categoría Audio o Monitores.
SELECT * FROM productos WHERE categoria = 'Audio' || categoria = 'Monitores';
-- Muestra nombre, apellidos y ciudad de clientes cuya ciudad no sea Madrid ni Barcelona.
SELECT nombre, apellidos, ciudad FROM clientes WHERE ciudad != 'Madrid' || ciudad != 'Barcelona';
-- Muestra nombre, apellidos y correo de clientes cuyo email termina en gmail.com.
SELECT nombre, apellidos, email FROM clientes WHERE email LIKE '%gmail.com';
-- Muestra nombre y puesto de empleados cuyo nombre empieza por M.
SELECT nombre, puesto FROM empleados WHERE nombre LIKE 'M%';
-- Muestra todos los datos de productos cuyo nombre contiene la palabra Monitor.
SELECT * FROM productos WHERE nombre LIKE '%Monitor%';
-- Muestra nombre y apellidos de empleados cuyos apellidos contienen "ez".
SELECT nombre, apellidos FROM empleados WHERE apellidos LIKE '%ez%';
-- Muestra nombre y ciudad de clientes cuya ciudad comienza por B.
SELECT nombre, ciudad FROM clientes WHERE ciudad LIKE 'B%';
-- Muestra nombre y precio de productos cuyo nombre no contiene la palabra Portátil.
SELECT nombre, precio FROM productos WHERE nombre NOT LIKE '%Portátil%';
-- Muestra todos los datos de productos con precio superior a 50 € y stock de al menos 20 unidades.
SELECT * FROM productos WHERE precio > 50 && stock >=20;
-- Muestra nombre y salario de empleados del departamento de Ventas (id 1) con salario igual o superior a 2300 €.
SELECT nombre, salario FROM empleados WHERE id_departamento = 1 && salario >= 2300;
-- Muestra todos los datos de clientes de España o Portugal.
SELECT * FROM clientes WHERE pais = 'España' || pais = 'Portugal' ;
-- Muestra todos los datos de pedidos en estado enviado o pendiente.
SELECT * FROM pedidos WHERE estado = 'enviado' || estado = 'pendiente';
-- Muestra nombre y precio de productos de categoría Audio sin descuento.
SELECT nombre, precio FROM productos WHERE categoria = 'Audio' AND descuento IS NULL;
-- Muestra nombre y apellidos de empleados sin comisión ni correo electrónico.
SELECT nombre, apellidos FROM empleados WHERE comision IS NULL && email IS NULL;
-- Lista empleados ordenados por salario de menor a mayor mostrando todos sus datos.
SELECT * FROM empleados ORDER BY salario ASC;
-- Lista clientes mostrando todos sus datos ordenados por país y dentro por ciudad en orden inverso.
SELECT * FROM clientes ORDER BY pais ASC, ciudad DESC;
-- Lista productos mostrando todos sus datos ordenados por categoría y precio de mayor a menor.
SELECT * FROM productos ORDER BY categoria ASC, precio DESC;
-- Lista pedidos mostrando todos sus datos ordenados por fecha descendente.
SELECT * FROM pedidos ORDER BY fecha DESC;
-- Mostrar nombre, salario mensual y salario anual de empleados con sueldo entre 2000 y 3000 €, empezando por los que más cobran al año.
SELECT nombre, salario, salario * 12 AS salario_anual FROM empleados WHERE salario BETWEEN 2000 AND 3000 ORDER BY salario_anual DESC;
-- Mostrar clientes de España con correo Gmail incluyendo nombre completo y ordenados por apellidos.
SELECT * FROM clientes WHERE email LIKE '%gmail.com' AND pais = 'España' ORDER BY apellidos ASC;
-- Mostrar ciudades de clientes sin repetir y en orden alfabético.
SELECT distinct ciudad FROM clientes ORDER BY ciudad ASC;
-- Mostrar pedidos de 2024 excepto anulados mostrando todos sus datos, ordenados por fecha.
SELECT * FROM pedidos WHERE fecha LIKE '%2024%' && estado != 'anulado' ORDER BY fecha;
-- Mostrar empleados con datos de contacto incompletos incluyendo una columna que combine email y teléfono.
SELECT *, concat(email, telefono) FROM empleados WHERE email IS NULL || telefono IS NULL;
-- Mostrar líneas de pedido con id_pedido, id_producto e importe total solo cuando este sea al menos 150 €, empezando por los mayores importes.
SELECT id_pedido, id_producto, (cantidad * precio_unitario) AS importe_total FROM lineas_pedido WHERE (cantidad * precio_unitario) >= 150 ORDER BY importe_total DESC;