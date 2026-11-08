DROP PROCEDURE IF EXISTS insertar_oficina_segura;

DELIMITER //
CREATE PROCEDURE insertar_oficina_segura(
    IN codigo VARCHAR(10),
    IN CITY VARCHAR(30),
    IN country VARCHAR(50),
    IN region_nueva VARCHAR(50),
    IN postal VARCHAR(10),
    IN tel VARCHAR(20),
    IN direccion1 VARCHAR(50),
    IN direccion2 VARCHAR(50)
)
begin
DECLARE CONTINUE HANDLER FOR 1062  -- Código de error para clave duplicada
BEGIN
    -- Manejar el error, por ejemplo, registrarlo o mostrar un mensaje
    SELECT 'La oficina ya existe.' AS oficina_error;
END;
INSERT into oficina VALUES(codigo, CITY, country, region_nueva, postal, tel, direccion1, direccion2);
end //
DELIMITER;
SELECT * from oficina;
CALL insertar_oficina_segura('ESP001', 'Madrid', 'España', 'Madrid', '28001', '123456789', 'Calle Mayor 1', 'Calle Mayor 2');