-- Script SQL para la creación de la tabla RANKINGS_CS2 en el proyecto CS2-SVSS (Fragify)
-- Basado en la ERS y el modelo ER/LR. Esta tabla almacena rankings competitivos (PREMIERE y por mapa).
-- Relación 1:N con JUGADORES_CS2. Cumple con formas normales y principios ACID.
-- Versión: 1.0 | Fecha: 12/01/2026 | Autor: José Ángel Alejo Sillero
-- MySQL 8.0.11 compatible.

USE cs2svss;

-- Eliminamos la tabla si existe para evitar conflictos en recreaciones
DROP TABLE IF EXISTS rankings_cs2;

-- Creación de la tabla RANKINGS_CS2
-- Almacena puntuaciones ELO, tiers y posiciones por mapa/jugador.
CREATE TABLE rankings_cs2 (
    id_ranking INT PRIMARY KEY AUTO_INCREMENT, /* ID único del ranking. Clave primaria surrogate. */
    steam_id64 VARCHAR(17) NOT NULL, /* FK a JUGADORES_CS2. Identificador del jugador. */
    tipo_ranking ENUM('PREMIERE', 'MAPA') NOT NULL, /* Tipo de ranking: PREMIERE global o por mapa. */
    mapa VARCHAR(50), /* Nombre del mapa (solo si tipo_ranking = 'MAPA'). Nullable. */
    puntos_elo INT NOT NULL DEFAULT 0, /* Puntos ELO actuales. */
    tier VARCHAR(20) NOT NULL, /* Grupo/tier actual (e.g., 'Bronze', 'Global Elite'). */
    posicion_global INT, /* Posición en ranking global (solo PREMIERE). Nullable. */
    ultima_actualizacion DATETIME NOT NULL, /* Fecha de última actualización del ranking. */
    FOREIGN KEY (steam_id64) REFERENCES jugadores_cs2(steam_id64) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Restricciones adicionales
ALTER TABLE rankings_cs2 ADD CONSTRAINT chk_puntos_elo CHECK (puntos_elo >= 0);
ALTER TABLE rankings_cs2 ADD CONSTRAINT chk_posicion_global CHECK (posicion_global > 0 OR posicion_global IS NULL);
ALTER TABLE rankings_cs2 ADD CONSTRAINT chk_ultima_actualizacion_rank CHECK (ultima_actualizacion <= NOW());

-- Índices para rendimiento
CREATE INDEX idx_steam_rankings ON rankings_cs2 (steam_id64);
CREATE INDEX idx_tipo_ranking ON rankings_cs2 (tipo_ranking);
CREATE INDEX idx_puntos_elo ON rankings_cs2 (puntos_elo DESC);</content>
<parameter name="filePath">c:\Users\Jose Angel\gitrepositories\MisApuntesITPDAW\BASE DE DATOS\U3_CreaciondeBBDDRelacionales\ScriptsMySQL\ERS CS2 SVSS Fragify\rankings_cs2.sql