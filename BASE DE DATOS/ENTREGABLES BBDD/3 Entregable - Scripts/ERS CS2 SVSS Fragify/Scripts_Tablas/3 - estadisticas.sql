-- Script SQL para la creación de la tabla ESTADISTICAS_CS2 en el proyecto CS2-SVSS (Fragify)
-- Basado en la ERS y el modelo ER/LR. Esta tabla almacena estadísticas individuales de rendimiento de los jugadores en partidas competitivas.
-- Relación 1:N con JUGADORES_CS2. Cumple con formas normales y principios ACID.
-- Versión: 1.0 | Fecha: 12/01/2026 | Autor: José Ángel Alejo Sillero
-- MySQL 8.0.11 compatible.

USE cs2svss;

-- Eliminamos la tabla si existe para evitar conflictos en recreaciones
DROP TABLE IF EXISTS estadisticas_cs2;

-- Creación de la tabla ESTADISTICAS_CS2
-- Almacena métricas de rendimiento por jugador, actualizadas automáticamente vía APIs.
CREATE TABLE estadisticas_cs2 (
    id_estadistica INT PRIMARY KEY AUTO_INCREMENT, /* ID único de la estadística. Clave primaria surrogate. */
    steam_id64 VARCHAR(17) NOT NULL, /* FK a JUGADORES_CS2. Identificador del jugador. */
    kills INT NOT NULL DEFAULT 0, /* Número total de eliminaciones. */
    deaths INT NOT NULL DEFAULT 0, /* Número total de muertes. */
    assists INT NOT NULL DEFAULT 0, /* Número total de asistencias. */
    headshots INT NOT NULL DEFAULT 0, /* Número total de headshots. */
    clutches INT NOT NULL DEFAULT 0, /* Número total de clutches (situaciones 1vX ganadas). */
    kd_ratio DECIMAL(5,2) NOT NULL DEFAULT 0.00, /* Relación K/D calculada (kills/deaths). */
    mvps INT NOT NULL DEFAULT 0, /* Número total de MVPs (Most Valuable Player). */
    tiempo_jugado INT NOT NULL DEFAULT 0, /* Tiempo total jugado en minutos. */
    ultima_actualizacion DATETIME NOT NULL, /* Fecha de última actualización de estas estadísticas. */
    FOREIGN KEY (steam_id64) REFERENCES jugadores_cs2(steam_id64) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Restricciones adicionales
ALTER TABLE estadisticas_cs2 ADD CONSTRAINT chk_kd_ratio CHECK (kd_ratio >= 0);
ALTER TABLE estadisticas_cs2 ADD CONSTRAINT chk_tiempo_jugado CHECK (tiempo_jugado >= 0);
ALTER TABLE estadisticas_cs2 ADD CONSTRAINT chk_ultima_actualizacion_est CHECK (ultima_actualizacion <= NOW());

-- Índices para rendimiento
CREATE INDEX idx_steam_estadisticas ON estadisticas_cs2 (steam_id64);
CREATE INDEX idx_kd_ratio ON estadisticas_cs2 (kd_ratio);</content>
<parameter name="filePath">c:\Users\Jose Angel\gitrepositories\MisApuntesITPDAW\BASE DE DATOS\U3_CreaciondeBBDDRelacionales\ScriptsMySQL\ERS CS2 SVSS Fragify\estadisticas.sql