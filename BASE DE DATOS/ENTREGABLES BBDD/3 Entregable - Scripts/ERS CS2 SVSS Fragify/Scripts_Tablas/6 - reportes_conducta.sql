-- Script SQL para la creación de la tabla REPORTES_CONDUCTA en el proyecto CS2-SVSS (Fragify)
-- Basado en la ERS y el modelo ER/LR. Esta tabla almacena reportes de conducta inapropiada (futuro, dependiente de frontend).
-- Relación 1:N con JUGADORES_CS2. Cumple con formas normales y principios ACID.
-- Versión: 1.0 | Fecha: 12/01/2026 | Autor: José Ángel Alejo Sillero
-- MySQL 8.0.11 compatible.

USE cs2svss;

-- Eliminamos la tabla si existe para evitar conflictos en recreaciones
DROP TABLE IF EXISTS reportes_conducta;

-- Creación de la tabla REPORTES_CONDUCTA
-- Almacena reportes para revisiones de Overwatch, incluyendo evidencia.
CREATE TABLE reportes_conducta (
    id_reporte INT PRIMARY KEY AUTO_INCREMENT, /* ID único del reporte. Clave primaria surrogate. */
    steam_id64_reportado VARCHAR(17) NOT NULL, /* FK a JUGADORES_CS2. Jugador reportado. */
    steam_id64_reportador VARCHAR(17) NOT NULL, /* FK a JUGADORES_CS2. Jugador que reporta. */
    motivo ENUM('GRIEFING', 'CHEATING', 'TOXICITY', 'OTRO') NOT NULL, /* Motivo del reporte. */
    descripcion TEXT, /* Descripción detallada del incidente. Nullable. */
    evidencia VARCHAR(255), /* Enlace o código de compartición de demo/replay. Nullable. */
    fecha_reporte DATETIME NOT NULL, /* Fecha y hora del reporte. */
    estado_reporte ENUM('PENDIENTE', 'REVISADO', 'RESUELTO') NOT NULL DEFAULT 'PENDIENTE', /* Estado del reporte. */
    FOREIGN KEY (steam_id64_reportado) REFERENCES jugadores_cs2(steam_id64) ON DELETE CASCADE,
    FOREIGN KEY (steam_id64_reportador) REFERENCES jugadores_cs2(steam_id64) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Restricciones adicionales
ALTER TABLE reportes_conducta ADD CONSTRAINT chk_fecha_reporte CHECK (fecha_reporte <= NOW());

-- Índices para rendimiento
CREATE INDEX idx_reportado ON reportes_conducta (steam_id64_reportado);
CREATE INDEX idx_reportador ON reportes_conducta (steam_id64_reportador);
CREATE INDEX idx_estado_reporte ON reportes_conducta (estado_reporte);</content>
<parameter name="filePath">c:\Users\Jose Angel\gitrepositories\MisApuntesITPDAW\BASE DE DATOS\U3_CreaciondeBBDDRelacionales\ScriptsMySQL\ERS CS2 SVSS Fragify\reportes_conducta.sql