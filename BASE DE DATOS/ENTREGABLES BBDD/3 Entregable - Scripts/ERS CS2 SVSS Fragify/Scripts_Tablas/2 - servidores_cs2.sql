-- Script SQL para la creación de la tabla SERVIDORES_CS2 en el proyecto CS2-SVSS (Fragify)
-- Basado en la ERS y el modelo ER/LR. Esta tabla almacena información de servidores de juego.
-- Relación 1:N con PARTIDAS_CS2. Cumple con formas normales y principios ACID.
-- Versión: 1.0 | Fecha: 12/01/2026 | Autor: José Ángel Alejo Sillero
-- MySQL 8.0.11 compatible.

USE cs2svss;

-- Eliminamos la tabla si existe para evitar conflictos en recreaciones
DROP TABLE IF EXISTS servidores_cs2;

-- Creación de la tabla SERVIDORES_CS2
-- Almacena datos de servidores donde se alojan partidas.
CREATE TABLE servidores_cs2 (
    id_servidor INT PRIMARY KEY AUTO_INCREMENT, /* ID único del servidor. Clave primaria surrogate. */
    ip_servidor VARCHAR(45) NOT NULL, /* Dirección IP del servidor (IPv4/IPv6). */
    region VARCHAR(50) NOT NULL, /* Región geográfica del servidor. */
    tipo_servidor ENUM('OFICIAL', 'COMUNITARIO') NOT NULL, /* Tipo de servidor. */
    ping_promedio INT, /* Ping promedio en ms. Nullable. */
    ultima_actualizacion DATETIME NOT NULL /* Fecha de última verificación del servidor. */
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Restricciones adicionales
ALTER TABLE servidores_cs2 ADD CONSTRAINT chk_ping CHECK (ping_promedio >= 0 OR ping_promedio IS NULL);
ALTER TABLE servidores_cs2 ADD CONSTRAINT chk_ultima_actualizacion_serv CHECK (ultima_actualizacion <= NOW());

-- Índices para rendimiento
CREATE INDEX idx_region ON servidores_cs2 (region);
CREATE INDEX idx_tipo_servidor ON servidores_cs2 (tipo_servidor);</content>
<parameter name="filePath">c:\Users\Jose Angel\gitrepositories\MisApuntesITPDAW\BASE DE DATOS\U3_CreaciondeBBDDRelacionales\ScriptsMySQL\ERS CS2 SVSS Fragify\servidores_cs2.sql