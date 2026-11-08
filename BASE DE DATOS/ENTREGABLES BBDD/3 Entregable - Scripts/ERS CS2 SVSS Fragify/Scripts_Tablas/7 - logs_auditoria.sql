-- Script SQL para la creación de la tabla LOGS_AUDITORIA en el proyecto CS2-SVSS (Fragify)
-- Basado en la ERS y el modelo ER/LR. Esta tabla almacena registros de auditoría para mantenimiento y cumplimiento RGPD.
-- No tiene FKs directas; se usa para logs generales. Cumple con formas normales y principios ACID.
-- Versión: 1.0 | Fecha: 12/01/2026 | Autor: José Ángel Alejo Sillero
-- MySQL 8.0.11 compatible.

USE cs2svss;

-- Eliminamos la tabla si existe para evitar conflictos en recreaciones
DROP TABLE IF EXISTS logs_auditoria;

-- Creación de la tabla LOGS_AUDITORIA
-- Almacena logs de cambios, accesos y operaciones para auditoría y seguridad.
CREATE TABLE logs_auditoria (
    id_log INT PRIMARY KEY AUTO_INCREMENT, /* ID único del log. Clave primaria surrogate. */
    tabla_afectada VARCHAR(50) NOT NULL, /* Nombre de la tabla afectada. */
    accion ENUM('INSERT', 'UPDATE', 'DELETE', 'SELECT') NOT NULL, /* Tipo de acción realizada. */
    steam_id64_usuario VARCHAR(17), /* Usuario afectado (si aplica). Nullable. */
    descripcion TEXT, /* Descripción del cambio o acción. Nullable. */
    fecha_log DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, /* Fecha y hora del log. */
    ip_origen VARCHAR(45) /* IP del origen de la acción. Nullable. */
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Restricciones adicionales
ALTER TABLE logs_auditoria ADD CONSTRAINT chk_fecha_log CHECK (fecha_log <= NOW());

-- Índices para rendimiento
CREATE INDEX idx_tabla_afectada ON logs_auditoria (tabla_afectada);
CREATE INDEX idx_fecha_log ON logs_auditoria (fecha_log);
CREATE INDEX idx_steam_log ON logs_auditoria (steam_id64_usuario);</content>
<parameter name="filePath">c:\Users\Jose Angel\gitrepositories\MisApuntesITPDAW\BASE DE DATOS\U3_CreaciondeBBDDRelacionales\ScriptsMySQL\ERS CS2 SVSS Fragify\logs_auditoria.sql