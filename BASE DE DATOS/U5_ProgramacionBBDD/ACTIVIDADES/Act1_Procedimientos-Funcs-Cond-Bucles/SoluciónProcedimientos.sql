USE feria_sevilla;
DROP PROCEDURE IF EXISTS calculadora_edad;
DELIMITER //
CREATE PROCEDURE calculadora_edad(IN fecha_nacimiento date, OUT edad int)
BEGIN
SET edad = timestampdiff( DAY, fecha_nacimiento, current_date());
END //
DELIMITER ;
CALL calculadora_edad('2002-04-10', @edad);
SELECT @edad;
DROP PROCEDURE if exists cambio_moneda;
DELIMITER //
CREATE PROCEDURE cambio_moneda(IN euro decimal())
BEGIN
SELECT euro*1.17 as Dolares;
END //
DELIMITER ;

CALL cambio_moneda(100);

DROP PROCEDURE if exists comprobar_email;
DELIMITER //
CREATE PROCEDURE comprobar_email(IN email varchar(100), OUT correcto boolean)
BEGIN
SET correcto = email like '%@%.%';
END //
DELIMITER ;
CALL comprobar_email('ftristanitpfp.com', @resultado);
SELECT @resultado;

use jardineria;
DELIMITER $$
CREATE PROCEDURE clientes_pais(IN pais_buscar varchar(50))
BEGIN
SELECT * from cliente where pais = pais_buscar;
END $$
DELIMITER ;
CALL clientes_pais('USA');

DELIMITER //
CREATE PROCEDURE metodo_pago(in metodo_de_pago varchar(40))
BEGIN
SELECT YEAR(fecha_pago), sum(total) from pago where forma_pago = metodo_de_pago
	group by YEAR(fecha_pago);
END //
DELIMITER ;
CALL metodo_pago('PayPal');

DELIMITER //
CREATE PROCEDURE actualizador( IN codigo int, IN nuevo_nombre varchar(30), 
IN apellido varchar(40), IN tel varchar(15), IN faxsito varchar(15)
)
BEGIN
update cliente SET nombre_contacto = nuevo_nombre, apellido_contacto = apellido,
telefono = tel, fax = faxsito where codigo_cliente = codigo;
END //

DELIMITER ;
SELECT * from cliente;
CALL actualizador(1, 'pepito','Ramirez', '955773321', 'jfhwjfvwf');

DELIMITER //
CREATE PROCEDURE descuento_gama()
BEGIN
declare gamita varchar(50);
SET gamita = (SELECT gama from producto 
join detalle_pedido on detalle_pedido.codigo_producto = producto.codigo_producto
join pedido on pedido.codigo_pedido = detalle_pedido.codigo_pedido group by gama
order by sum(cantidad) limit 1);
update producto SET precio_venta = precio_venta*0.85 where gama = gamita;
END //
DELIMITER ;
SELECT precio_venta from producto where gama= 'Herramientas';
CALL descuento_gama();
SELECT precio_venta from producto where gama= 'Herramientas';




