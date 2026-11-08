USE jardineria;
DROP PROCEDURE IF EXISTS actualizar_cliente;
delimiter //
CREATE PROCEDURE actualizar_cliente(
    IN codigo INT,
    IN nuevo_nombre VARCHAR(50),
    IN nuevo_telefono VARCHAR(15),
    IN nuevo_fax VARCHAR(15)
)
BEGIN
    UPDATE clientes
    SET nombre_cliente = nuevo_nombre,
        telefono = nuevo_telefono,
        fax = nuevo_fax
    WHERE codigo_cliente = codigo;
END //
delimiter ;
CALL actualizar_cliente(1, 'Nuevo Nombre', '123456789', '987654321');
SELECT * FROM clientes;
-- SELECT * FROM clientes WHERE codigo_cliente = 1;
/* Los procedimientos se utilizan para actualizar, 
    insertar o eliminar datos de una tabla, pero también 
    para realizar operaciones más complejas que involucren 
    arias tablas o lógica de negocio. En este caso, el 
    procedimiento 'actualizar_cliente' se encarga de actualizar 
    los datos de un cliente específico en la tabla 'clientes' 
    utilizando su código como identificador.
*/
/* Las funciones suelen usarse para realizar cálculos o transformaciones
    de maneras que sean reutilizables en diferentes partes de una consulta
    o en diferentes consultas. También en procedimientos.
*/