DELIMITER //
CREATE procedure CONTADOR(in numero int)
begin
declare contando int default(0);
WHILE contando<=numero DO
SELECT contando;
SET contando = contando+1;
END WHILE;
END //

DELIMITER ;
call contador(20);

DROP PROCEDURE IF EXISTS CONTADOR2;
DELIMITER //
CREATE procedure CONTADOR2(in numero int)
begin
declare contando int default(0);
REPEAT
SELECT CONTANDO;
SET CONTANDO = CONTANDO+1;
UNTIL CONTANDO>NUMERO END REPEAT;
END //

DELIMITER ;
call contador2(10);

DROP PROCEDURE IF EXISTS CONTADOR3;
DELIMITER //
CREATE procedure CONTADOR3(in numero int)
begin
declare contando int default(0);
pepito: LOOP
   
    SELECT contando;
    IF contando >numero THEN
        LEAVE pepito;
    SET contando = contando+1;
   
    END if;
END LOOP pepito;
END //

DELIMITER ;
call contador3(10);