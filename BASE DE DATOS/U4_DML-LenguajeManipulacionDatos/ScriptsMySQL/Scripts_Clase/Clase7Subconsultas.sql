DROP DATABASE IF EXISTS empresa_subconsultas;
CREATE DATABASE empresa_subconsultas;
USE empresa_subconsultas;

CREATE TABLE cliente (
    id_cliente INT PRIMARY KEY,
    nombre VARCHAR(50),
    ciudad VARCHAR(50),
    categoria INT
);

CREATE TABLE comercial (
    id_comercial INT PRIMARY KEY,
    nombre VARCHAR(50),
    comision DECIMAL(4,2)
);

CREATE TABLE pedido (
    id_pedido INT PRIMARY KEY,
    total DECIMAL(10,2),
    fecha DATE,
    id_cliente INT,
    id_comercial INT,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_comercial) REFERENCES comercial(id_comercial)
);

INSERT INTO cliente VALUES
(1,'Ana','Sevilla',100),
(2,'Luis','Madrid',200),
(3,'Carlos','Sevilla',150),
(4,'Marta','Valencia',300),
(5,'Elena','Madrid',120),
(6,'Pablo','Bilbao',180);

INSERT INTO comercial VALUES
(1,'Roberto',0.10),
(2,'Laura',0.15),
(3,'Sergio',0.12),
(4,'Carmen',0.20);

INSERT INTO pedido VALUES
(1,1200,'2024-01-10',1,1),
(2,800,'2024-01-12',2,2),
(3,1500,'2024-01-15',3,1),
(4,400,'2024-02-01',1,3),
(5,2200,'2024-02-10',4,4),
(6,950,'2024-02-18',5,2),
(7,300,'2024-03-01',6,3),
(8,1800,'2024-03-05',2,1);

-- Mostrar los clientes cuya categoría sea mayor que la categoría media.
SELECT * FROM cliente;
SELECT * FROM cliente WHERE categoria > (SELECT AVG(categoria) FROM cliente);
    -- Para filtrar por el AVG de categoria lo insertamos en elwhere con parentesis, realizando la subconsulta
-- Mostrar los pedidos cuyo total sea superior al total medio de todos los pedidos.
SELECT * FROM pedido WHERE total > (SELECT AVG(total) FROM pedido);
    -- Para filtrar por el AVG de total lo insertamos en el where con parentesis, realizando la subconsulta
-- Mostrar los clientes que viven en la misma ciudad que el cliente con id 1.
SELECT * FROM cliente WHERE ciudad = (SELECT ciudad FROM cliente WHERE id_cliente = 1);
    -- Para filtrar por la ciudad del cliente con id 1, realizamos una subconsulta que nos devuelve la ciudad del cliente con id 1, y luego filtramos por esa ciudad en el where de la consulta principal.
-- Mostrar los clientes que han realizado algún pedido.
SELECT * FROM cliente WHERE id_cliente IN (SELECT DISTINCT id_cliente FROM pedido);
    -- Para filtrar por los clientes que han realizado algún pedido, realizamos una subconsulta que nos devuelve los id_cliente de la tabla pedido, y luego filtramos por esos id_cliente en el where de la consulta principal.
-- Mostrar los clientes que NO han realizado pedidos.
SELECT * FROM cliente WHERE id_cliente NOT IN (SELECT DISTINCT id_cliente FROM pedido);
    -- Para filtrar por los clientes que no han realizado pedidos, realizamos una subconsulta que nos devuelve los id_cliente de la tabla pedido, y luego filtramos por esos id_cliente en el where de la consulta principal utilizando NOT IN.
-- Mostrar los clientes cuya ciudad esté entre las ciudades donde hay clientes con categoría mayor a 150.
SELECT DISTINCT ciudad FROM cliente WHERE categoria>150;
    -- Subconsulta donde la categoria sea mayor a 150 y la ciudad sea una de las ciudades que devuelve la subconsulta.
    SELECT * FROM cliente WHERE ciudad IN (SELECT DISTINCT ciudad FROM cliente WHERE categoria>150);
    -- Subconsulta donde la categoría sea mayor a 150 y la ciudad sea Madrid
    SELECT * FROM cliente WHERE ciudad IN (SELECT DISTINCT ciudad FROM cliente WHERE categoria>150) AND ciudad = "Madrid";
-- Mostrar los pedidos cuyo total sea mayor que TODOS los pedidos del cliente 1.
SELECT * FROM pedido WHERE total > ALL(SELECT MAX(total) FROM pedido WHERE id_cliente = 1);
    -- Para filtrar por los pedidos cuyo total sea mayor que todos los pedidos del cliente 1, realizamos una subconsulta que nos devuelve el total máximo de los pedidos del cliente 1, y luego filtramos por ese total en el where de la consulta principal utilizando >.
    -- También podemos usar ANY en lugar de ALL, pero en este caso no tendría sentido ya que solo hay un pedido del cliente 1, por lo que el resultado sería el mismo.
SELECT * FROM pedido WHERE total > ANY(SELECT MAX(total) FROM pedido WHERE id_cliente = 1);
-- Mostrar los pedidos cuyo total sea mayor que ALGÚN pedido del cliente 1.
SELECT * FROM pedido WHERE total > ANY(SELECT total FROM pedido WHERE id_cliente = 1);
    -- Para filtrar por los pedidos cuyo total sea mayor que algún pedido del cliente 1, realizamos una subconsulta que nos devuelve el total de los pedidos del cliente 1, y luego filtramos por ese total en el where de la consulta principal utilizando > ANY.
-- Mostrar los clientes que tengan al menos un pedido superior a 1000€.
SELECT * FROM cliente WHERE id_cliente IN (SELECT DISTINCT id_cliente FROM pedido WHERE total > 1000);
    -- Para filtrar por los clientes que tengan al menos un pedido superior a 1000€, realizamos una subconsulta que nos devuelve los id_cliente de la tabla pedido donde el total sea mayor a 1000, y luego filtramos por esos id_cliente en el where de la consulta principal utilizando IN.
-- Mostrar los comerciales que no hayan realizado ningún pedido.
SELECT * FROM comercial where id_comercial NOT IN(SELECT DISTINCT id_comercial FROM pedido);
    -- Para filtrar por los comerciales que no hayan realizado ningún pedido, realizamos una subconsulta que nos devuelve los id_comercial de la tabla pedido, y luego filtramos por esos id_comercial en el where de la consulta principal utilizando NOT IN.
-- Mostrar cada cliente junto con el número total de pedidos que ha realizado.
SELECT cliente.nombre AS cliente, (SELECT COUNT(*) FROM pedido WHERE pedido.id_cliente = cliente.id_cliente) AS total_pedidos
FROM cliente;
    -- Para mostrar cada cliente junto con el número total de pedidos que ha realizado, realizamos una subconsulta que nos devuelve el número de pedidos que ha realizado cada cliente, y luego lo mostramos junto con el nombre del cliente en la consulta principal.
-- Mostrar cada comercial junto con el total de ventas que ha generado.
SELECT comercial.nombre AS comercial, (SELECT SUM(total) FROM pedido WHERE pedido.id_comercial = comercial.id_comercial) AS total_ventas
FROM comercial;
    -- Para mostrar cada comercial junto con el total de ventas que ha generado, realizamos una subconsulta que nos devuelve el total de ventas que ha generado cada comercial, y luego lo mostramos junto con el nombre del comercial en la consulta principal.