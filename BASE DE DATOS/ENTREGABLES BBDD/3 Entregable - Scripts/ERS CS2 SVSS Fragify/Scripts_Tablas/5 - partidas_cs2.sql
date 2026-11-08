-- Script SQL para la creación de la tabla PARTIDAS_CS2 en el proyecto CS2-SVSS (Fragify)
-- Basado en la ERS y el modelo ER/LR. Esta tabla almacena datos detallados de partidas jugadas.
-- Relaciones N:M con JUGADORES_CS2 y 1:N con SERVIDORES_CS2. Cumple con formas normales y principios ACID.
-- Versión: 1.0 | Fecha: 12/01/2026 | Autor: José Ángel Alejo Sillero
-- MySQL 8.0.11 compatible.

USE cs2svss;

-- Eliminamos la tabla si existe para evitar conflictos en recreaciones
DROP TABLE IF EXISTS partidas_cs2;

-- Creación de la tabla PARTIDAS_CS2
-- Almacena información de cada partida, incluyendo participantes y resultados.
CREATE TABLE partidas_cs2 (
    id_partida VARCHAR(50) PRIMARY KEY, /* ID único de la partida (generado por Valve). */
    mapa VARCHAR(50) NOT NULL, /* Nombre del mapa jugado. */
    modo ENUM('COMPETITIVO', 'PREMIERE') NOT NULL, /* Modo de juego. */
    resultado ENUM('VICTORIA', 'DERROTA') NOT NULL, /* Resultado para el equipo del jugador. */
    duracion_minutos INT NOT NULL, /* Duración de la partida en minutos. */
    fecha_partida DATETIME NOT NULL, /* Fecha y hora de la partida. */
    steam_id64 VARCHAR(17) NOT NULL, /* FK a JUGADORES_CS2. Jugador principal. */
    id_servidor INT, /* FK a SERVIDORES_CS2. Servidor donde se jugó. Nullable si no disponible. */
    kills INT NOT NULL DEFAULT 0, /* Kills en esta partida. */
    deaths INT NOT NULL DEFAULT 0, /* Deaths en esta partida. */
    FOREIGN KEY (steam_id64) REFERENCES jugadores_cs2(steam_id64) ON DELETE CASCADE,
    FOREIGN KEY (id_servidor) REFERENCES servidores_cs2(id_servidor) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Restricciones adicionales
ALTER TABLE partidas_cs2 ADD CONSTRAINT chk_duracion CHECK (duracion_minutos > 0);
ALTER TABLE partidas_cs2 ADD CONSTRAINT chk_fecha_partida CHECK (fecha_partida <= NOW());

-- Índices para rendimiento
CREATE INDEX idx_steam_partidas ON partidas_cs2 (steam_id64);
CREATE INDEX idx_fecha_partida ON partidas_cs2 (fecha_partida);
CREATE INDEX idx_mapa ON partidas_cs2 (mapa);</content>
<parameter name="filePath">c:\Users\Jose Angel\gitrepositories\MisApuntesITPDAW\BASE DE DATOS\U3_CreaciondeBBDDRelacionales\ScriptsMySQL\ERS CS2 SVSS Fragify\partidas_cs2.sql