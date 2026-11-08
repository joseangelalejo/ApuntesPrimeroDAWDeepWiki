use jardineria;
drop function if exists la_hipocresia;

delimiter $$

create function la_hipocresia( lado1 int, lado2 int)
returns double
deterministic
begin
    return sqrt(pow(lado1, 2) + pow(lado2, 2));
end$$
delimiter ;

drop function if exists celsius_a_fahrenheit;
delimiter //

create function celsius_a_fahrenheit( grados_celsius double)
returns double
deterministic
begin
    return (grados_celsius * 9 / 5) + 32;
end//
delimiter ;


drop function if exists generar_correo;
delimiter //

create function generar_correo( p_nombre varchar(50), p_apellido varchar(50))
returns varchar(150)
deterministic
begin
    declare v_nombre varchar(80);
    declare v_apellido varchar(80);
	return concat(v_nombre, '.', v_apellido, '@itpfp.com');
end //
delimiter ;


drop function if exists contar_pedidos_rechazados;
delimiter //

create function contar_pedidos_rechazados( p_mes int, p_codigo_oficina varchar(10))
returns int reads sql data
begin
    declare v_total int default 0;

    SELECT  count(*) into v_total FROM pedido join cliente on pedido.codigo_cliente = cliente.codigo_cliente
	join empleado on cliente.codigo_empleado_rep_ventas = empleado.codigo_empleado
    where pedido.estado = 'Rechazado' and month(pedido.fecha_pedido) = p_mes
	and empleado.codigo_oficina = p_codigo_oficina;
    return v_total;
end//
delimiter ;


drop function if exists empleado_del_mes;
delimiter $$
CREATE FUNCTION empleado_del_mes(p_mes INT)
returns VARCHAR(200) reads sql data
begin
    declare v_empleado varchar(200);
	SET v_empleado = ( SELECT concat(empleado.codigo_empleado, ' - ',
	empleado.nombre, ' ', empleado.apellido1) from empleado 
    join cliente on empleado.codigo_empleado = cliente.codigo_empleado_rep_ventas
    join pedido on cliente.codigo_cliente = pedido.codigo_cliente
    join detalle_pedido on pedido.codigo_pedido = detalle_pedido.codigo_pedido
    where month(pedido.fecha_pedido) = p_mes and pedido.estado = 'Entregado'
    group by empleado.codigo_empleado, empleado.nombre, empleado.apellido1
    order by sum(detalle_pedido.cantidad * detalle_pedido.precio_unidad) DESC,
    empleado.codigo_empleado ASC
    limit 1); 
    
    return v_empleado;
end$$
delimiter ;

drop function if exists cliente_mas_pedidos_mes;
delimiter //
CREATE function cliente_mas_pedidos_mes(p_mes INT)
RETURNS VARCHAR(200) reads sql data
begin
    declare v_cliente varchar(200);
	SET v_cliente = ( SELECT concat(cliente.codigo_cliente, ' - ',
	cliente.nombre_cliente) from cliente 
    join pedido on cliente.codigo_cliente = pedido.codigo_cliente
    where month(pedido.fecha_pedido) = p_mes
    group by cliente.codigo_cliente, cliente.nombre_cliente
    order by count(pedido.codigo_pedido) DESC,
    cliente.codigo_cliente ASC
    limit 1); 
    
    return v_cliente;
end//
delimiter ;