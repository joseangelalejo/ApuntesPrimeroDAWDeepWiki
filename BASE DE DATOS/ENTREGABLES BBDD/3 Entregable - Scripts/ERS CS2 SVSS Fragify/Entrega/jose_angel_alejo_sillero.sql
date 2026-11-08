-- Script SQL completo para la creación de la base de datos CS2-SVSS (Fragify)
-- Proyecto: Counter Strike 2 Stats Visualizing System
-- Basado en la ERS y el modelo ER/LR. Incluye creación de BD y todas las tablas con restricciones e índices.
-- Cumple con formas normales (1FN, 2FN, 3FN), principios ACID, y compatibilidad con MySQL 8.0.11.
-- Versión: 1.0 | Fecha: 23/01/2026 | Autor: José Ángel Alejo Sillero
-- Nombre de entrega: jose_angel_alejo_sillero.sql (Formato: nombre_apellido1_apellido2.sql)
-- Ejecutar este script completo para inicializar la BD desde cero.

-- Eliminamos la base de datos si existe para evitar conflictos
DROP DATABASE IF EXISTS cs2svss;

-- Creación de la base de datos CS2-SVSS
CREATE DATABASE cs2svss CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Seleccionamos la base de datos
USE cs2svss;

-- ===== TABLA 1: JUGADORES_CS2 =====
-- Script SQL para la creación de la tabla JUGADORES_CS2 en el proyecto CS2-SVSS (Fragify)
-- Basado en la ERS y el modelo ER/LR. Esta tabla almacena la información básica de los jugadores de CS2 registrados en la plataforma.
-- Cumple con las formas normales (1FN, 2FN, 3FN) y principios ACID. Preparada para futuras expansiones con FKs a otras tablas.
-- Versión: 1.0 | Fecha: 12/01/2026 | Autor: José Ángel Alejo Sillero
-- MySQL 8.0.11 compatible.

-- Eliminamos la tabla si existe para evitar conflictos en recreaciones
DROP TABLE IF EXISTS jugadores_cs2;

-- Creación de la tabla JUGADORES_CS2
-- Entidad fuerte con clave primaria natural (Steam_ID64). Almacena perfiles de jugadores verificados vía Steam.
CREATE TABLE jugadores_cs2 (
    steam_id64 VARCHAR(17) PRIMARY KEY, /* Identificador único de Steam (17 caracteres numéricos). Clave primaria natural. */
    nombre_usuario_steam VARCHAR(255) NOT NULL, /* Nombre público del jugador en Steam. Obligatorio para identificación. */
    fecha_registro_fragify DATETIME NOT NULL, /* Fecha y hora de registro en la plataforma Fragify. Obligatorio. */
    estado_verificacion TINYINT NOT NULL DEFAULT 0, /* Estado de verificación de la cuenta (0: no verificada, 1: verificada). Obligatorio. */
    clave_juego_unica VARCHAR(255), /* Clave única para acceso completo a datos de CS2 (opcional, para reportes avanzados). Nullable. */
    ultima_actualizacion_datos DATETIME NOT NULL, /* Fecha y hora de la última sincronización de datos con APIs/Steam. Obligatorio. */
    estado_actividad TINYINT NOT NULL DEFAULT 1 /* Estado de actividad del jugador (0: inactivo, 1: activo). Obligatorio. */
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Restricciones adicionales para integridad de datos
-- Verificación de formato de Steam_ID64 (debe ser numérico y exactamente 17 caracteres)
ALTER TABLE jugadores_cs2 ADD CONSTRAINT chk_steam_id64_format CHECK (steam_id64 REGEXP '^[0-9]{17}$');
-- Nota: Las validaciones de fechas futuras se deben manejar a nivel de aplicación, no en CHECK constraints
-- MySQL no permite funciones como NOW() en CHECK constraints
-- Índice en nombre_usuario_steam para búsquedas rápidas
CREATE INDEX idx_nombre_usuario ON jugadores_cs2 (nombre_usuario_steam);
-- Índice en estado_verificacion para filtrar cuentas verificadas
CREATE INDEX idx_estado_verificacion ON jugadores_cs2 (estado_verificacion);
-- Índice en estado_actividad para filtrar jugadores activos
CREATE INDEX idx_estado_actividad ON jugadores_cs2 (estado_actividad);

-- ===== TABLA 2: SERVIDORES_CS2 =====
-- Script SQL para la creación de la tabla SERVIDORES_CS2 en el proyecto CS2-SVSS (Fragify)
-- Basado en la ERS y el modelo ER/LR. Esta tabla almacena información de servidores de juego.
-- Relación 1:N con PARTIDAS_CS2. Cumple con formas normales y principios ACID.
-- Versión: 1.0 | Fecha: 12/01/2026 | Autor: José Ángel Alejo Sillero
-- MySQL 8.0.11 compatible.

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

-- Índices para rendimiento
CREATE INDEX idx_region ON servidores_cs2 (region);
CREATE INDEX idx_tipo_servidor ON servidores_cs2 (tipo_servidor);

-- ===== TABLA 3: ESTADISTICAS_CS2 =====
-- Script SQL para la creación de la tabla ESTADISTICAS_CS2 en el proyecto CS2-SVSS (Fragify)
-- Basado en la ERS y el modelo ER/LR. Esta tabla almacena estadísticas individuales de rendimiento de los jugadores en partidas competitivas.
-- Relación 1:N con JUGADORES_CS2. Cumple con formas normales y principios ACID.
-- Versión: 1.0 | Fecha: 12/01/2026 | Autor: José Ángel Alejo Sillero
-- MySQL 8.0.11 compatible.

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

-- Índices para rendimiento
CREATE INDEX idx_steam_estadisticas ON estadisticas_cs2 (steam_id64);
CREATE INDEX idx_kd_ratio ON estadisticas_cs2 (kd_ratio);

-- ===== TABLA 4: RANKINGS_CS2 =====
-- Script SQL para la creación de la tabla RANKINGS_CS2 en el proyecto CS2-SVSS (Fragify)
-- Basado en la ERS y el modelo ER/LR. Esta tabla almacena rankings competitivos (PREMIERE y por mapa).
-- Relación 1:N con JUGADORES_CS2. Cumple con formas normales y principios ACID.
-- Versión: 1.0 | Fecha: 12/01/2026 | Autor: José Ángel Alejo Sillero
-- MySQL 8.0.11 compatible.

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

-- Índices para rendimiento
CREATE INDEX idx_steam_rankings ON rankings_cs2 (steam_id64);
CREATE INDEX idx_tipo_ranking ON rankings_cs2 (tipo_ranking);
CREATE INDEX idx_puntos_elo ON rankings_cs2 (puntos_elo DESC);

-- ===== TABLA 5: PARTIDAS_CS2 =====
-- Script SQL para la creación de la tabla PARTIDAS_CS2 en el proyecto CS2-SVSS (Fragify)
-- Basado en la ERS y el modelo ER/LR. Esta tabla almacena datos detallados de partidas jugadas.
-- Relaciones N:M con JUGADORES_CS2 y 1:N con SERVIDORES_CS2. Cumple con formas normales y principios ACID.
-- Versión: 1.0 | Fecha: 12/01/2026 | Autor: José Ángel Alejo Sillero
-- MySQL 8.0.11 compatible.

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

-- Índices para rendimiento
CREATE INDEX idx_steam_partidas ON partidas_cs2 (steam_id64);
CREATE INDEX idx_fecha_partida ON partidas_cs2 (fecha_partida);
CREATE INDEX idx_mapa ON partidas_cs2 (mapa);

-- ===== TABLA 6: REPORTES_CONDUCTA =====
-- Script SQL para la creación de la tabla REPORTES_CONDUCTA en el proyecto CS2-SVSS (Fragify)
-- Basado en la ERS y el modelo ER/LR. Esta tabla almacena reportes de conducta inapropiada (futuro, dependiente de frontend).
-- Relación 1:N con JUGADORES_CS2. Cumple con formas normales y principios ACID.
-- Versión: 1.0 | Fecha: 12/01/2026 | Autor: José Ángel Alejo Sillero
-- MySQL 8.0.11 compatible.

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

-- Restricciones adicionales: Las validaciones de fechas futuras se manejan a nivel de aplicación

-- Índices para rendimiento
CREATE INDEX idx_reportado ON reportes_conducta (steam_id64_reportado);
CREATE INDEX idx_reportador ON reportes_conducta (steam_id64_reportador);
CREATE INDEX idx_estado_reporte ON reportes_conducta (estado_reporte);

-- ===== TABLA 7: LOGS_AUDITORIA =====
-- Script SQL para la creación de la tabla LOGS_AUDITORIA en el proyecto CS2-SVSS (Fragify)
-- Basado en la ERS y el modelo ER/LR. Esta tabla almacena registros de auditoría para mantenimiento y cumplimiento RGPD.
-- No tiene FKs directas; se usa para logs generales. Cumple con formas normales y principios ACID.
-- Versión: 1.0 | Fecha: 12/01/2026 | Autor: José Ángel Alejo Sillero
-- MySQL 8.0.11 compatible.

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

-- Restricciones adicionales: Las validaciones de fechas futuras se manejan a nivel de aplicación

-- Índices para rendimiento
CREATE INDEX idx_tabla_afectada ON logs_auditoria (tabla_afectada);
CREATE INDEX idx_fecha_log ON logs_auditoria (fecha_log);
CREATE INDEX idx_steam_log ON logs_auditoria (steam_id64_usuario);

-- ===== VISTAS (VIEWS) =====
-- Script SQL para la creación de vistas en el proyecto CS2-SVSS (Fragify)
-- Las vistas optimizan consultas frecuentes mencionadas en la ERS y mejoran el rendimiento
-- Versión: 1.0 | Fecha: 23/01/2026 | Autor: José Ángel Alejo Sillero

-- VISTA 1: Ranking de jugadores por puntos ELO (PREMIERE)
-- Utilidad: Obtener ranking rápido sin joins costosos. Consulta crítica de ERS para top 100.
-- Justificación: La ERS especifica que el ranking PREMIERE es el más valorado. Esta vista evita cálculos repetidos.
CREATE VIEW vw_ranking_jugadores_elo AS
SELECT 
    j.steam_id64,
    j.nombre_usuario_steam,
    r.puntos_elo,
    r.tier,
    r.posicion_global,
    r.ultima_actualizacion,
    RANK() OVER (ORDER BY r.puntos_elo DESC) AS ranking_posicion
FROM jugadores_cs2 j
INNER JOIN rankings_cs2 r ON j.steam_id64 = r.steam_id64
WHERE r.tipo_ranking = 'PREMIERE'
ORDER BY r.puntos_elo DESC;

-- VISTA 2: Resumen de estadísticas del jugador
-- Utilidad: Dashboard de rendimiento sin cálculos en tiempo real. Métricas agregadas de un vistazo.
-- Justificación: Consulta frecuente en la plataforma Fragify para mostrar perfil del jugador.
CREATE VIEW vw_estadisticas_jugador_resumen AS
SELECT 
    j.steam_id64,
    j.nombre_usuario_steam,
    j.estado_actividad,
    e.kills,
    e.deaths,
    e.assists,
    e.kd_ratio,
    e.mvps,
    e.headshots,
    ROUND((e.kills / NULLIF(e.deaths, 0)), 2) AS kd_calculado,
    e.tiempo_jugado,
    e.ultima_actualizacion
FROM jugadores_cs2 j
LEFT JOIN estadisticas_cs2 e ON j.steam_id64 = e.steam_id64
WHERE j.estado_actividad = 1;

-- VISTA 3: Reportes pendientes para inspectores de Valve
-- Utilidad: Filtrar reportes no resueltos. Facilita revisión de Valve con permisos de solo lectura.
-- Justificación: ERS menciona que Valve accederá con permisos de lectura a reportes. Optimiza búsquedas.
CREATE VIEW vw_reportes_pendientes_valve AS
SELECT 
    r.id_reporte,
    j_reportado.nombre_usuario_steam AS jugador_reportado,
    j_reportador.nombre_usuario_steam AS jugador_reportador,
    r.motivo,
    r.descripcion,
    r.evidencia,
    r.fecha_reporte,
    r.estado_reporte,
    DATEDIFF(NOW(), r.fecha_reporte) AS dias_desde_reporte
FROM reportes_conducta r
INNER JOIN jugadores_cs2 j_reportado ON r.steam_id64_reportado = j_reportado.steam_id64
INNER JOIN jugadores_cs2 j_reportador ON r.steam_id64_reportador = j_reportador.steam_id64
WHERE r.estado_reporte = 'PENDIENTE'
ORDER BY r.fecha_reporte ASC;

-- VISTA 4: Partidas recientes de un jugador
-- Utilidad: Historial sin procesar todas las partidas. Acceso rápido a últimas partidas.
-- Justificación: Consulta típica en plataforma web. Mejora UX al no recargar tabla completa.
CREATE VIEW vw_partidas_recientes_jugador AS
SELECT 
    p.id_partida,
    j.steam_id64,
    j.nombre_usuario_steam,
    p.mapa,
    p.modo,
    p.resultado,
    p.duracion_minutos,
    p.fecha_partida,
    p.kills,
    p.deaths,
    ROUND((p.kills / NULLIF(p.deaths, 0)), 2) AS kd_partida
FROM partidas_cs2 p
INNER JOIN jugadores_cs2 j ON p.steam_id64 = j.steam_id64
ORDER BY p.fecha_partida DESC
LIMIT 1000;

-- VISTA 5: Análisis de rendimiento por mapa
-- Utilidad: Estadísticas segregadas por mapa. Identifica fortalezas/debilidades por mapa.
-- Justificación: ERS menciona análisis de rendimiento por mapa. Vista facilitará consultas complejas.
CREATE VIEW vw_rendimiento_por_mapa AS
SELECT 
    j.steam_id64,
    j.nombre_usuario_steam,
    p.mapa,
    COUNT(p.id_partida) AS total_partidas_mapa,
    SUM(CASE WHEN p.resultado = 'VICTORIA' THEN 1 ELSE 0 END) AS victorias_mapa,
    ROUND(SUM(CASE WHEN p.resultado = 'VICTORIA' THEN 1 ELSE 0 END) / COUNT(p.id_partida) * 100, 2) AS tasa_victoria_mapa,
    ROUND(AVG(p.kills), 2) AS kills_promedio_mapa,
    ROUND(AVG(p.deaths), 2) AS deaths_promedio_mapa,
    MAX(p.fecha_partida) AS ultima_partida_mapa
FROM partidas_cs2 p
INNER JOIN jugadores_cs2 j ON p.steam_id64 = j.steam_id64
GROUP BY j.steam_id64, p.mapa
ORDER BY j.steam_id64, p.mapa;

-- ===== ROLES, USUARIOS Y PERMISOS =====
-- Script SQL para la creación de roles y control de acceso en el proyecto CS2-SVSS (Fragify)
-- Implementa el modelo de control de acceso basado en roles mencionado en la ERS Sección 3.3
-- Versión: 1.0 | Fecha: 23/01/2026 | Autor: José Ángel Alejo Sillero

-- ROLE 1: ADMINISTRADOR DEL SISTEMA
-- Descripción: Acceso total a la base de datos. Responsable de mantenimiento, backups, auditoría.
-- Por qué estos permisos: Necesita control total para operaciones administrativas, optimización y cumplimiento RGPD.
CREATE USER IF NOT EXISTS 'admin_cs2'@'localhost' IDENTIFIED BY 'admin_secure_pass_2026';
GRANT ALL PRIVILEGES ON cs2svss.* TO 'admin_cs2'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

-- ROLE 2: SERVICIO API (Actualización automática)
-- Descripción: Inserta/actualiza estadísticas, rankings y partidas. Lee datos públicos de jugadores y servidores.
-- Por qué estos permisos: La ERS especifica actualización automática vía APIs/Steam. Necesita INSERT/UPDATE limitados.
CREATE USER IF NOT EXISTS 'api_service'@'localhost' IDENTIFIED BY 'api_service_key_2026';
GRANT SELECT ON cs2svss.jugadores_cs2 TO 'api_service'@'localhost';
GRANT SELECT ON cs2svss.servidores_cs2 TO 'api_service'@'localhost';
GRANT INSERT, UPDATE ON cs2svss.estadisticas_cs2 TO 'api_service'@'localhost';
GRANT INSERT, UPDATE ON cs2svss.rankings_cs2 TO 'api_service'@'localhost';
GRANT INSERT, UPDATE ON cs2svss.partidas_cs2 TO 'api_service'@'localhost';
GRANT SELECT ON cs2svss.logs_auditoria TO 'api_service'@'localhost';
FLUSH PRIVILEGES;

-- ROLE 3: INSPECTOR DE VALVE (Solo lectura de reportes)
-- Descripción: Acceso de solo lectura a reportes de conducta y datos de jugadores. Cumple RGPD y seguridad.
-- Por qué estos permisos: ERS Sección 1.2 especifica "Valve Corporation accede con permisos de solo lectura a reportes".
--                         Restricción CRUCIAL para proteger integridad de datos. No puede modificar nada.
CREATE USER IF NOT EXISTS 'valve_inspector'@'remote_valve_server' IDENTIFIED BY 'valve_api_readonly_key_2026';
GRANT SELECT ON cs2svss.reportes_conducta TO 'valve_inspector'@'remote_valve_server';
GRANT SELECT ON cs2svss.jugadores_cs2 TO 'valve_inspector'@'remote_valve_server';
GRANT SELECT ON cs2svss.estadisticas_cs2 TO 'valve_inspector'@'remote_valve_server';
GRANT SELECT ON cs2svss.partidas_cs2 TO 'valve_inspector'@'remote_valve_server';
FLUSH PRIVILEGES;

-- ROLE 4: JUGADOR FRAGIFY (Usuario de plataforma)
-- Descripción: Lectura de propias estadísticas y rankings. En futuro: lectura de historial de reportes hechos.
-- Por qué estos permisos: Acceso mínimo para visualizar datos personales en la plataforma Fragify.
--                         Preparado para futuro cuando se implemente frontend y autenticación por Steam OAuth.
CREATE USER IF NOT EXISTS 'jugador_fragify'@'localhost' IDENTIFIED BY 'jugador_pass_2026';
GRANT SELECT ON cs2svss.estadisticas_cs2 TO 'jugador_fragify'@'localhost';
GRANT SELECT ON cs2svss.rankings_cs2 TO 'jugador_fragify'@'localhost';
GRANT SELECT ON cs2svss.partidas_cs2 TO 'jugador_fragify'@'localhost';
FLUSH PRIVILEGES;

-- ROLE 5: PROFESOR/EVALUADOR (Acceso de auditoría y evaluación)
-- Descripción: Acceso completo de solo lectura a toda la base de datos. Permite evaluación del trabajo realizado.
-- Por qué estos permisos: Evaluador académico que necesita verificar integridad del diseño, datos y cumplimiento de requisitos.
--                         Permiso SELECT en todas las tablas y vistas, sin capacidad de modificación.
--                         Host localhost para acceso local desde institución educativa.
CREATE USER IF NOT EXISTS 'profesor_evaluador'@'localhost' IDENTIFIED BY 'profesor_cs2_2026';
GRANT SELECT ON cs2svss.jugadores_cs2 TO 'profesor_evaluador'@'localhost';
GRANT SELECT ON cs2svss.servidores_cs2 TO 'profesor_evaluador'@'localhost';
GRANT SELECT ON cs2svss.estadisticas_cs2 TO 'profesor_evaluador'@'localhost';
GRANT SELECT ON cs2svss.rankings_cs2 TO 'profesor_evaluador'@'localhost';
GRANT SELECT ON cs2svss.partidas_cs2 TO 'profesor_evaluador'@'localhost';
GRANT SELECT ON cs2svss.reportes_conducta TO 'profesor_evaluador'@'localhost';
GRANT SELECT ON cs2svss.logs_auditoria TO 'profesor_evaluador'@'localhost';
GRANT SELECT ON cs2svss.vw_ranking_jugadores_elo TO 'profesor_evaluador'@'localhost';
GRANT SELECT ON cs2svss.vw_estadisticas_jugador_resumen TO 'profesor_evaluador'@'localhost';
GRANT SELECT ON cs2svss.vw_reportes_pendientes_valve TO 'profesor_evaluador'@'localhost';
GRANT SELECT ON cs2svss.vw_partidas_recientes_jugador TO 'profesor_evaluador'@'localhost';
GRANT SELECT ON cs2svss.vw_rendimiento_por_mapa TO 'profesor_evaluador'@'localhost';
FLUSH PRIVILEGES;

-- Fin del script. La base de datos CS2-SVSS con roles, vistas y permisos está lista para uso.
