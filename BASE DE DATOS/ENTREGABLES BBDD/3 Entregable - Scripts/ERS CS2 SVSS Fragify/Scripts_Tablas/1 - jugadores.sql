-- Script SQL para la creación de la tabla JUGADORES_CS2 en el proyecto CS2-SVSS (Fragify)
-- Basado en la ERS y el modelo ER/LR. Esta tabla almacena la información básica de los jugadores de CS2 registrados en la plataforma.
-- Cumple con las formas normales (1FN, 2FN, 3FN) y principios ACID. Preparada para futuras expansiones con FKs a otras tablas.
-- Versión: 1.0 | Fecha: 12/01/2026 | Autor: José Ángel Alejo Sillero
-- MySQL 8.0.11 compatible.

USE cs2svss;

-- Eliminamos la tabla si existe para evitar conflictos en recreaciones
DROP TABLE IF EXISTS jugadores_cs2;

-- Creación de la tabla JUGADORES_CS2
-- Entidad fuerte con clave primaria natural (Steam_ID64). Almacena perfiles de jugadores verificados vía Steam.
CREATE TABLE jugadores_cs2 (
    steam_id64 VARCHAR(17) PRIMARY KEY, /* Identificador único de Steam (17 caracteres numéricos). Clave primaria natural. */
    nombre_usuario_steam VARCHAR(255) NOT NULL, /* Nombre público del jugador en Steam. Obligatorio para identificación. */
    fecha_registro_fragify DATETIME NOT NULL, /* Fecha y hora de registro en la plataforma Fragify. Obligatorio. */
    estado_verificacion TINYINT(1) NOT NULL DEFAULT 0, /* Estado de verificación de la cuenta (0: no verificada, 1: verificada). Obligatorio. */
    clave_juego_unica VARCHAR(255), /* Clave única para acceso completo a datos de CS2 (opcional, para reportes avanzados). Nullable. */
    ultima_actualizacion_datos DATETIME NOT NULL, /* Fecha y hora de la última sincronización de datos con APIs/Steam. Obligatorio. */
    estado_actividad TINYINT(1) NOT NULL DEFAULT 1 /* Estado de actividad del jugador (0: inactivo, 1: activo). Obligatorio. */
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Restricciones adicionales para integridad de datos
-- Verificación de formato de Steam_ID64 (debe ser numérico y exactamente 17 caracteres)
ALTER TABLE jugadores_cs2 ADD CONSTRAINT chk_steam_id64_format CHECK (steam_id64 REGEXP '^[0-9]{17}$');
-- Verificación de que fecha_registro_fragify no sea futura
ALTER TABLE jugadores_cs2 ADD CONSTRAINT chk_fecha_registro CHECK (fecha_registro_fragify <= NOW());
-- Verificación de que ultima_actualizacion_datos no sea futura
ALTER TABLE jugadores_cs2 ADD CONSTRAINT chk_ultima_actualizacion CHECK (ultima_actualizacion_datos <= NOW());
-- Índice en nombre_usuario_steam para búsquedas rápidas
CREATE INDEX idx_nombre_usuario ON jugadores_cs2 (nombre_usuario_steam);
-- Índice en estado_verificacion para filtrar cuentas verificadas
CREATE INDEX idx_estado_verificacion ON jugadores_cs2 (estado_verificacion);
-- Índice en estado_actividad para filtrar jugadores activos
CREATE INDEX idx_estado_actividad ON jugadores_cs2 (estado_actividad);