use jardineria;
drop function if exists par_impar;
delimiter $$
CREATE FUNCTION par_impar(numero INT)
returns VARCHAR(20) deterministic
begin
    declare resultado varchar(20);
    
    IF numero > 0 THEN set resultado = 'Positivo';
    ELSEIF numero < 0 THEN set resultado = 'Negativo';
    ELSE set resultado = 'Cero';
    END IF;
    return resultado;
end$$
delimiter ;


DROP FUNCTION IF EXISTS momento_dia;
delimiter //
CREATE FUNCTION momento_dia(hora INT)
returns VARCHAR(20) deterministic
begin
    CASE
		WHEN hora between 0 and 5 THEN return 'Madrugada';
		WHEN hora between 6 and 11 THEN return 'Mañana';
		WHEN hora between 12 and 19 THEN return 'Tarde';
		WHEN hora between 20 and 23 THEN return 'Noche';
		ELSE return 'Error';
    END CASE;
end//
delimiter ;


drop function if exists estado_del_pedido;
delimiter $$
CREATE FUNCTION estado_del_pedido(codigo INT)
returns VARCHAR(100) reads sql data
begin
declare v_estado varchar(30);
declare v_mensaje varchar(100);
SET v_estado = ( SELECT pedido.estado from pedido where pedido.codigo_pedido = codigo );
    CASE
		WHEN v_estado = 'Pendiente' THEN set v_mensaje = 'Pedido en espera';
		WHEN v_estado = 'Entregado' THEN set v_mensaje = 'Pedido entregado correctamente';
		WHEN v_estado = 'Rechazado' THEN set v_mensaje = 'Pedido cancelado/rechazado';
		ELSE set v_mensaje = 'Estado desconocido';
    END CASE;
    
    return v_mensaje;
end$$
delimiter ;


drop function if exists clasificar_cliente;
delimiter $$
CREATE FUNCTION clasificar_cliente(codigo INT)
returns VARCHAR(50) reads sql data
begin
declare v_limite decimal(15,2);
declare v_tipo varchar(50);
SET v_limite = ( SELECT cliente.limite_credito from cliente where cliente.codigo_cliente = codigo );
IF v_limite is null THEN set v_tipo = 'Cliente no encontrado';
ELSEIF v_limite < 5000 THEN set v_tipo = 'Básico';
ELSEIF v_limite between 5000 and 20000 THEN set v_tipo = 'Estándar';
ELSE set v_tipo = 'Preferente';
END IF;
return v_tipo;
end$$
delimiter ;


drop function if exists margen_producto;
delimiter $$
CREATE FUNCTION margen_producto(codigo VARCHAR(15))
returns VARCHAR(50) reads sql data
begin
declare v_margen decimal(15,2);
declare v_resultado varchar(50);
SET v_margen = ( SELECT producto.precio_venta - producto.precio_proveedor
from producto where producto.codigo_producto = codigo );
    
    IF v_margen is null THEN set v_resultado = 'Producto no encontrado';
    ELSEIF v_margen < 5 THEN set v_resultado = 'Margen bajo';
    ELSEIF v_margen between 5 and 15 THEN set v_resultado = 'Margen medio';
    ELSE set v_resultado = 'Margen alto';
    END IF;
return v_resultado;
end$$
delimiter ;
