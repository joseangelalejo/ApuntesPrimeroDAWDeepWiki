DROP DATABASE IF EXISTS Braw_Stars;
CREATE DATABASE Braw_Stars;
USE Braw_Stars;
SET GLOBAL log_bin_trust_function_creators = 1; -- Activador superCreador de funciones.
SET SQL_SAFE_UPDATES= 0; -- Desactviar modo seguro para delete y update.

DROP TABLE IF EXISTS Jugador;
CREATE TABLE Jugador(
NICK VARCHAR(50) PRIMARY KEY,
correo VARCHAR(100),
TROFEO INT,
RANGO VARCHAR(25),
Ultima_conexion date
);

DROP TABLE IF EXISTS Partida;
CREATE TABLE Partida (
    ID_Partida INT PRIMARY KEY auto_increment,
	MODO ENUM ( 'SUPERVIVENCIA', 'BALON BRAW', 'ATRAPA GEMAS' ),
    CANTIDAD_J INT DEFAULT 0,
    DURACION FLOAT
);
DROP TABLE IF EXISTS Resultado_partida;
CREATE TABLE Resultado_partida (
    ID INT PRIMARY KEY auto_increment,
    Posicion INT,
    ID_Partida INT,
    NICK VARCHAR(50),
    FOREIGN KEY (NICK) REFERENCES Jugador(NICK) ON UPDATE CASCADE,
	FOREIGN KEY (ID_Partida) REFERENCES Partida(ID_Partida)
);

INSERT INTO Jugador (NICK, correo, TROFEO, RANGO, ultima_conexion) VALUES 
('LunaOscura', 'luna_oscura@example.com', 1500, NULL, '2025-02-13'),
('RayoVeloz', 'rayo_veloz@example.com', 1400, NULL, '2025-03-27'),
('EspadaBrillante', 'espada_brillante@example.com', 1600, NULL, '2025-01-05'),
('ReinaFénix', 'reina_fenix@example.com', 1550, NULL, '2025-04-11'),
('SombrasSilentes', 'sombras_silentes@example.com', 1450, NULL, '2025-03-02'),
('EstrellaErrante', 'estrella_errante@example.com', 1650, NULL, '2025-01-28'),
('FuegoEterno', 'fuego_eterno@example.com', 1520, NULL, '2025-02-22'),
('TruenoCósmico', 'trueno_cosmico@example.com', 1420, NULL, '2025-05-03'),
('TornadoVeloz', 'tornado_veloz@example.com', 1630, NULL, '2025-01-11'),
('CaminanteNocturno', 'caminante_nocturno@example.com', 1510, NULL, '2025-03-09'),
('DragónCarmesí', 'dragon_carmesi@example.com', 1410, NULL, '2025-04-01'),
('NebulosaAzul', 'nebulosa_azul@example.com', 1620, NULL, '2025-02-05'),
('TitánCelestial', 'titan_celestial@example.com', 1530, NULL, '2025-03-30'),
('AuroraDivina', 'aurora_divina@example.com', 1430, NULL, '2025-01-19'),
('MariposaCósmica', 'mariposa_cosmica@example.com', 1640, NULL, '2025-04-17'),
('SableEstelar', 'sable_estelar@example.com', 1540, NULL, '2025-05-01'),
('ArcoÍrisRadiante', 'arcoiris_radiante@example.com', 1440, NULL, '2025-03-15'),
('GuardiánEspectral', 'guardian_espectral@example.com', 1610, NULL, '2025-02-01'),
('SombraArdiente', 'sombra_ardiente@example.com', 2345, NULL, '2025-04-07'),
('TormentaFugaz', 'tormenta_fugaz@example.com', 1425, NULL, '2025-01-24');

INSERT INTO Partida (MODO, CANTIDAD_J, DURACION) VALUES 
('SUPERVIVENCIA', 6, 12.5),
('BALON BRAW', 3, 8.2),
('ATRAPA GEMAS', 6, 14.8),
('SUPERVIVENCIA', 5, 11.3),
('BALON BRAW', 4, 9.7),
('ATRAPA GEMAS', 5, 13.2),
('SUPERVIVENCIA', 7, 10.8),
('BALON BRAW', 5, 8.9),
('ATRAPA GEMAS', 7, 12.6),
('SUPERVIVENCIA', 4, 13.1),
('BALON BRAW', 6, 7.5),
('ATRAPA GEMAS', 4, 11.9),
('SUPERVIVENCIA', 5, 14.2),
('BALON BRAW', 7, 6.8),
('ATRAPA GEMAS', 5, 10.5),
('SUPERVIVENCIA', 6, 12.9),
('BALON BRAW', 8, 5.6),
('ATRAPA GEMAS', 6, 9.8),
('SUPERVIVENCIA', 7, 11.7),
('BALON BRAW', 9, 4.9);

INSERT INTO Resultado_partida (Posicion, ID_Partida, NICK) VALUES 
(1, 1, 'LunaOscura'),
(2, 1, 'RayoVeloz'),
(3, 1, 'EspadaBrillante'),
(4, 1, 'ReinaFénix'),
(5, 1, 'SombrasSilentes'),
(6, 1, 'EstrellaErrante'),
(1, 2, 'FuegoEterno'),
(2, 2, 'TruenoCósmico'),
(3, 2, 'TornadoVeloz'),
(1, 3, 'CaminanteNocturno'),
(2, 3, 'DragónCarmesí'),
(3, 3, 'NebulosaAzul'),
(1, 4, 'TitánCelestial'),
(2, 4, 'AuroraDivina'),
(3, 4, 'MariposaCósmica'),
(1, 5, 'SableEstelar'),
(2, 5, 'ArcoÍrisRadiante'),
(3, 5, 'GuardiánEspectral'),
(1, 6, 'SombraArdiente'),
(2, 6, 'TormentaFugaz'),
(3, 6, 'LunaOscura');
