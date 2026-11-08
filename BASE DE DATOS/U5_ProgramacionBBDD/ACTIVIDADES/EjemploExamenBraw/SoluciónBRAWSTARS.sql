USE braw_stars;
DROP function if exists Determinar_Rango;
DELIMITER //
CREATE FUNCTION Determinar_Rango( USUARIO VARCHAR(50))
returns VARCHAR(25) deterministic
BEGIN
DECLARE TROFEOS INT;
set TROFEOS = (SELECT TROFEO FROM JUGADOR WHERE NICK = USUARIO);
CASE  
WHEN TROFEOS between 1 AND 500 THEN RETURN "BRONCE";
WHEN TROFEOS between 501 AND 1000 THEN RETURN "PLATA";
WHEN TROFEOS between 1001 AND 2000 THEN RETURN "ORO";
WHEN TROFEOS between 2001 AND 4000 THEN RETURN "PLATINO";
WHEN TROFEOS > 4000 THEN RETURN "MASTER";
ELSE RETURN  "N/C";
END CASE;
END //
DELIMITER ;
select Determinar_Rango('SombraArdiente');
select * FROM JUGADOR;
/*
1. ( 1’5 puntos ) Crea una función llamada Determinar_Rango cuya finalidad es obtener el
rango de un jugador dependiendo de la cantidad de trofeos de los que disponga el propio
jugador. Para ello necesitarás:
● La función recibe por parámetros el nombre del jugador ( NICK ) del que se quiere
calcular su rango.
● El rango de un jugador depende de la cantidad de trofeos que posee:
○ Si el jugador tiene entre 1 y 500 trofeos, su rango será Bronce
○ Si el jugador tiene entre 501 y 1000, su rango será Plata.
○ Si el jugador tiene entre 1001 y 2000, su rango será Oro.
○ Si el jugador tiene entre 2001 y 4000, su rango será Platino.
○ Si el jugador tiene más de 4000, su rango es Master.
○ En caso de no encontrarse entre las opciones anteriores su rango es N/C (
No Clasificado ).

● El valor a devolver de la función ( El Rango del jugador ) debe ser una cadena de
caracteres.
*/

/*
2. ( 2 puntos )Crea una función llamada CalcularTrofeosPartida cuya finalidad es calcular la
cantidad de trofeos que un jugador recibirá en una partida. Para ello necesitarás:
● La función necesitará recibir como parámetros de entrada el nombre del jugador ( NICK ) y el
ID de la partida ( ID_Partida ), necesarios para poder calcular los trofeos que van a ganar o
perder.
● Para poder realizar el cálculo será necesario saber:
○ El modo de juego de la partida ( MODO ) en cuestión.
○ La posición en la que dicho jugador quedó en la partida ( Posicion ) en cuestión.
● El número de trofeos ganados variará teniendo en cuenta lo siguiente:
○ Si el modo de juego es SUPERVIVENCIA :
■ Y el jugador ha quedado en la posición 1, la cantidad de trofeos que gana es
15.
■ Si quedó en la posición 2, ganará 12 trofeos.
■ Si quedó en la posición 3, ganará 10 trofeos .
■ Si quedó entre la posición 4 y 8, ganará 5 trofeos.
■ Para cualquier otra posición perderá 5 trofeos (Lo mismo que ganar -5).
○ Si el modo de juego es BALON BRAW:
■ Y el jugador quedó en la posición 1, ganará 10 trofeos.
■ Para cualquier otra posición perderá 5 trofeos (Lo mismo que ganar -5).
○ Si el modo de juego es ATRAPA GEMAS:
■ Y el jugador quedó en la posición 1, ganará 20 trofeos.
■ Para cualquier otra posición perderá 10 trofeos (Lo mismo que ganar -10).
● El valor a devolver de la función ( La cantidad de trofeos ganados por el jugador en una
partida ) debe ser un número entero.
*/
DROP FUNCTION IF EXISTS CalcularTrofeosPartida;
DELIMITER $$
CREATE FUNCTION CalcularTrofeosPartida(NOMBRE VARCHAR(50), ID INT) 
RETURNS INT DETERMINISTIC 
BEGIN
DECLARE MODO_JUEGO VARCHAR(100);
DECLARE POSICION_JUGADOR INT;
SET MODO_JUEGO = (SELECT MODO FROM PARTIDA WHERE ID_Partida = ID);
SET POSICION_JUGADOR = (SELECT Posicion FROM resultado_partida WHERE NICK = NOMBRE AND
ID_Partida = ID);
CASE MODO_JUEGO
WHEN 'SUPERVIVENCIA' THEN
	BEGIN
		IF POSICION_JUGADOR = 1 THEN RETURN 15;
        ELSEIF POSICION_JUGADOR = 2 THEN RETURN 12;
        ELSEIF POSICION_JUGADOR = 3 THEN RETURN 10;
        ELSEIF POSICION_JUGADOR between 4 AND 8 THEN RETURN 5;
        ELSE RETURN -5;
        END IF;
    END;
WHEN 'BALON BRAW' THEN
	BEGIN
		IF POSICION_JUGADOR = 1 THEN RETURN 10;
        ELSE RETURN -5;
        END IF;
    END ;
WHEN 'ATRAPA GEMAS' THEN
		BEGIN
		IF POSICION_JUGADOR = 1 THEN RETURN 20;
        ELSE RETURN -10;
        END IF;
		END ;
END CASE;
RETURN 0;
END $$
DELIMITER ;

/*
3. ( 1’5 puntos )Crea un procedimiento llamado ActualizarDatosJugador que permitirá que el
usuario actualice sus datos, el nombre del jugador ( NICK ) y el correo electrónico ( correo ).
Para ello necesitarás:
● El procedimiento requiere recibir como parámetros de entrada el nombre actual del jugador
(NICK), el correo antiguo del jugador ( correo ), el nuevo nombre por el que se quiere
actualizar y el nuevo correo electrónico por el que se quiere actualizar.
● Necesitaremos controlar el código de error 1062, el cual ocurre cuando el nuevo nombre de
usuario que se desea poner coincide con uno ya existente. Cuando este error se produzca se
deberá mostrar un mensaje notificando que el nombre ya está en uso y no es posible usarlo y
tras ello finalizará el proceso.
● También deberemos comprobar que sí existe el nombre de usuario que se desea modificar
(el nick antiguo existe en la BD). Esto no es necesario hacerlo mediante un manejador de
errores, puedes hacerlo durante la ejecución normal del procedimiento:
○ En caso de no existir mostrar el mensaje, ‘No existe ningún jugador con ese nick’ .
○ En caso de si existir, actualizar los datos antiguos por los nuevos ( NICK → Nuevo
NICK y correo → Nuevo correo ) y tras ello mostrar el mensaje, 'Datos
actualizados correctamente' .
*/


DROP PROCEDURE IF EXISTS ActualizarDatosJugador;
DELIMITER //
CREATE PROCEDURE ActualizarDatosJugado(IN NOMBRE_VIEJO VARCHAR(50),
 IN NOMBRE_NUEVO VARCHAR(50), IN correo_VIEJO VARCHAR(100), IN correo_NUEVO VARCHAR(100), OUT HOLA VARCHAR(50))
 BEGIN
 DECLARE EXIT HANDLER FOR 1062 SELECT "El nombre escogido ya esta siendo usado por otro
	jugador";
 IF NOMBRE_VIEJO = (SELECT NICK FROM JUGADOR WHERE NICK = NOMBRE_VIEJO) THEN
	 BEGIN 
		UPDATE jugador 
        SET NICK = NOMBRE_NUEVO, correo = correo_NUEVO
        WHERE NICK = NOMBRE_VIEJO;
	 END;
ELSE SELECT 'No existe ningún jugador con ese nick';
END IF;
 END //
DELIMITER ; 
call ActualizarDatosJugado('FuegoEtornoElPEPE','Juanito1234','','Juanito1234@gmail.com');
SELECT * from jugador;

/*
4. ( 2 puntos )Crea un procedimiento almacenado llamado ActualizarTrofeosRangoPartida que
nos permitirá dar el id de una partida, actualizar la cantidad de trofeos y el Rango de todos
los jugadores que participaron en dicha partida. Para ello necesitarás:
● Que el procedimiento reciba como parámetro de entrada el ID de una partida.
● Será necesario utilizar un cursor recorrer la tabla Resultado_partida y obtener los nombres
de jugadores ( NICK ) de todos aquellos que jugaron la partida en cuestión.
● Por cada llamada al cursor que realicemos:
○ Obtendremos el nombre de un jugador ( NICK ).
○ Calcularemos los trofeos que ese jugador ha ganado en la partida(utiliza la función
que ya tienes).
○ Actualiza los trofeos que tiene ese jugador en la tabla de jugador(sumando los
trofeos actuales que tiene y sumandole los obtenidos).
○ Determina el Rango de jugador tras la actualización de sus trofeos (utiliza la
función que ya tienes).
○ Actualiza el Rango del jugador en la tabla de jugador (sustituyendo directamente el
valor).

● Tras finalizar el cursor, lo último que realizará el procedimiento será mostrar un mensaje de
confirmación de la actualización de toda la tabla.
*/

DROP PROCEDURE IF EXISTS ActualizarTrofeosRangoPartida;
DELIMITER //
CREATE PROCEDURE ActualizarTrofeosRangoPartida( IN IDENTIFICADOR INT)
BEGIN
DECLARE FIN boolean default FALSE;
DECLARE NOMBRE VARCHAR(50);
DECLARE TROFEOS_GANADOR INT;

DECLARE CURSOR_JUGADORES CURSOR FOR SELECT NICK FROM resultado_partida WHERE ID_Partida = IDENTIFICADOR;
DECLARE continue handler for NOT FOUND SET FIN = TRUE;
OPEN CURSOR_JUGADORES;
ETIQUETA: LOOP
fetch CURSOR_JUGADORES INTO NOMBRE;
	IF FIN THEN
		LEAVE ETIQUETA;
	END IF;
SET TROFEOS_GANADOR = CalcularTrofeosPartida(NOMBRE, IDENTIFICADOR);
UPDATE jugador SET TROFEO = TROFEO+TROFEOS_GANADOR WHERE NICK = NOMBRE;
UPDATE JUGADOR SET RANGO = Determinar_Rango(NOMBRE) WHERE NICK = NOMBRE;
END LOOP ETIQUETA;
CLOSE CURSOR_JUGADORES;
SELECT 'TODOS LOS DATOS DE LOS JUGADORES DE ESTA PARTIDA HAN SIDO ACTUALIZADOS';
END //
DELIMITER ;