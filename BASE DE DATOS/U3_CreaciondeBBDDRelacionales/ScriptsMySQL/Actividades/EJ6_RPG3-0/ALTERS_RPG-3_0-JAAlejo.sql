-- DATABASE según premisa:
USE RPGV3_0;
SHOW tables;

-- Modificaciones
-- Cambiar nombre de columna Nombre_usuario a nombre
ALTER TABLE jugador RENAME COLUMN nombre_usuario TO nombre;

-- Modificar tamaño del varchar de email
ALTER TABLE jugador MODIFY COLUMN email VARCHAR(100) UNIQUE NOT NULL;

-- Agregar NOT NULL a admin
ALTER TABLE jugador MODIFY COLUMN esAdmin BOOLEAN NOT NULL DEFAULT 0;

-- Cambiar check de nivel en personaje a hasta 150
ALTER TABLE personaje MODIFY COLUMN nivel INT DEFAULT 1 CHECK (nivel BETWEEN 1 AND 150);

-- Eliminar columna id_relacionpm de personaje_mision
ALTER TABLE personaje_mision DROP COLUMN id_relacionpm;

-- Corregir foreign keys para evitar conflicto con SET NULL en columnas NOT NULL
ALTER TABLE personaje_mision DROP FOREIGN KEY personaje_mision_ibfk_1;
ALTER TABLE personaje_mision DROP FOREIGN KEY personaje_mision_ibfk_2;

-- Agregar primary key compuesta
ALTER TABLE personaje_mision ADD PRIMARY KEY (personaje_id, mision_id);

-- Recrear foreign keys con RESTRICT
ALTER TABLE personaje_mision ADD CONSTRAINT personaje_mision_ibfk_1 FOREIGN KEY (personaje_id) REFERENCES personaje(id_personaje) ON DELETE RESTRICT;
ALTER TABLE personaje_mision ADD CONSTRAINT personaje_mision_ibfk_2 FOREIGN KEY (mision_id) REFERENCES misiones(id_mision) ON DELETE RESTRICT;

-- Vistas e Índices
/** Vista tabla jugador: Detalle_Jugadores - Incluye:
		- Su nombre de usuario
        - Correo
        - Si son o no administradores.
*/
CREATE VIEW Detalle_Jugadores AS
SELECT nombre AS nombre_usuario, email, esAdmin FROM jugador;

/** Vista tabla habilidades: Resumen_Habilidades - Lista de habilidades disponibles con:
		- Nivel requerido
        - Descripción abreviada
*/
CREATE VIEW Resumen_Habilidades AS
SELECT nombre_habilidad, nivel_desbloqueo, LEFT(descripcion, 100) AS descripcion_abreviada FROM habilidades;

-- Índices
CREATE INDEX idx_email_jugador ON jugador(email);
CREATE INDEX idx_nivel_habilidad ON habilidades(nivel_desbloqueo);