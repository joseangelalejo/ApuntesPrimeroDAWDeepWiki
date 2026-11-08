delimiter //
create FUNCTION evaluacion(nota int)
returns varchar(50) deterministic
BEGIN
    declare resultado varchar(50);
    IF nota>=5 then
        Begin
            SET resultado = 'aprobado';
            return resultado;
        END;
    ELSEIF nota<5 then
        Begin
            SET resultado = 'Suspenso';
            return resultado;
        END;
    ELSE
        begin
            SET resultado = 'Ha habido un error';
            return resultado;
        END;
    END IF;
END //

delimiter ;