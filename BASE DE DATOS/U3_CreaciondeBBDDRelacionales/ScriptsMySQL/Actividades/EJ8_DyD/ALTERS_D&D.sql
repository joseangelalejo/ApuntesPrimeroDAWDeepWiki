-- ===== ACTIVIDAD 8: D&D Database - Vistas, Índices y Alteraciones =====

USE `D&D`;

-- ===== SECCIÓN 1: VISTAS (VIEWS) =====

-- V_Personajes_Criticos
-- Detecta personajes en situación crítica (ACTIVO y pg_actual <= 3)
-- Columnas: nombre, nivel_total, pg_actual, ca_total, ultima_sesion, campaña
CREATE OR REPLACE VIEW V_Personajes_Criticos AS
SELECT nombre, nivel_total, pg_actual, ca_total, ultima_sesion, campaña
FROM personajes
WHERE estado = 'ACTIVO' AND pg_actual <= 3;


-- V_Hechizos_BasicosCombate
-- Hechizos de nivel 0-1 con daño (tipo_daño <> 'NINGUNO')
-- Columnas: nombre, nivel, escuela, tipo_daño, alcance, tiempo_lanzamiento, tirada_salvacion, concentracion
CREATE OR REPLACE VIEW V_Hechizos_BasicosCombate AS
SELECT nombre, nivel, escuela, tipo_daño, alcance, tiempo_lanzamiento, tirada_salvacion, concentracion
FROM hechizos
WHERE nivel IN (0, 1) AND tipo_daño <> 'NINGUNO';


-- V_Hechizos_RitualesUtilidad
-- Hechizos que sean ritual (ritual = TRUE)
-- Columnas: nombre, nivel, escuela, ritual, duracion, componentes, material, fuente
CREATE OR REPLACE VIEW V_Hechizos_RitualesUtilidad AS
SELECT nombre, nivel, escuela, ritual, duracion, componentes, material, fuente
FROM hechizos
WHERE ritual = TRUE;


-- V_Objetos_TiendaBasica
-- Objetos permitidos a PJ y no legendarios
-- Columnas: nombre, tipo, rareza, valor_oro, peso, requiere_sintonia, fuente
CREATE OR REPLACE VIEW V_Objetos_TiendaBasica AS
SELECT nombre, tipo, rareza, valor_oro, peso, requiere_sintonia, fuente
FROM objetos
WHERE permitido_pj = TRUE AND rareza <> 'LEGENDARIA';


-- V_Objetos_Equipables
-- Objetos que sean ARMA o ARMADURA
-- Columnas: nombre, tipo, rareza, tipo_daño, dado_daño, propiedad_armas, tipo_armadura, ca_bonus, req_fuerza, sigilo_desventaja
CREATE OR REPLACE VIEW V_Objetos_Equipables AS
SELECT nombre, tipo, rareza, tipo_daño, dado_daño, propiedad_armas, tipo_armadura, ca_bonus, req_fuerza, sigilo_desventaja
FROM objetos
WHERE tipo IN ('ARMA', 'ARMADURA');


-- V_Inventario_Equipado
-- Solo ítems equipados (equipado = TRUE)
-- Columnas: personaje, objeto, equipado, ranura_equipo, estado_objeto, cargas_actuales, personalizacion
CREATE OR REPLACE VIEW V_Inventario_Equipado AS
SELECT personaje, objeto, equipado, ranura_equipo, estado_objeto, cargas_actuales, personalizacion
FROM inventario
WHERE equipado = TRUE;


-- V_Razas_CreacionPJ
-- Vamos a necesitar un selector de razas para poder seleccionar una raza jugable cada vez que queramos empezar una partida para ello crea una vista que muestre solo las razas jugables y que devuelva las columnas nombre, tamaño, velocidad_base, vision_oscuridad, rareza, resistencia_tipo, rasgo_1
CREATE OR REPLACE VIEW V_Razas_CreacionPJ AS
SELECT nombre, tamaño, velocidad_base, vision_oscuridad, rareza, resistencia_tipo, rasgo_1
FROM razas
WHERE jugable = TRUE AND rareza <> 'LEGENDARIA';


-- V_Razas_Exoticas
-- El DM quiere poder restringir opciones en campañas "low fantasy" para sacar una lista de opciones exóticas rápidamente crea una vista con razas jugables de rareza RARA o superior para ello se quiere que muestre: nombre, rareza, tamaño, velocidad_base, resistencia_tipo, rasgo_1, rasgo_2
CREATE OR REPLACE VIEW V_Razas_Exoticas AS
SELECT nombre, rareza, tamaño, velocidad_base, resistencia_tipo, rasgo_1, rasgo_2
FROM razas
WHERE jugable = TRUE AND rareza IN ('RARA', 'MUY_RARA', 'LEGENDARIA');


-- V_Clases_LanzadorasResumen
-- Requerimos una vista para obtener un resumen de clases mágicas, crea una vista que muestre solo clases que lanzan conjuros, con estas columnas: nombre, dado_vida, atributo_principal, salvaciones, tipo_lanzamiento, recursos_principales
CREATE OR REPLACE VIEW V_Clases_LanzadorasResumen AS
SELECT nombre, dado_vida, atributo_principal, salvaciones, tipo_lanzamiento, recursos_principales
FROM clases
WHERE lanzador_conjuros = TRUE;


-- V_Clases_Tanques
-- Crea una vista con clases que tienen dado de vida d10 o d12, mostrando: nombre, dado_vida, atributo_principal, competencia_armaduras, armadura_sin_bonif, recursos_principales. Esta vista sirve para montar composiciones del grupo o para el DM al generar guardias / campeones.
CREATE OR REPLACE VIEW V_Clases_Tanques AS
SELECT nombre, dado_vida, atributo_principal, competencia_armaduras, armadura_sin_bonif, recursos_principales
FROM clases
WHERE dado_vida IN ('d10', 'd12');


-- V_Personajes_ActivosFichaCorta
-- El DM necesita poder visualizar rapidamente el estado de la partida, así que creale una vista de personajes ACTIVOS, estilo "ficha corta", con estas columnas: alias, raza, nivel_total, alineamiento, pg_actual, pg_max, ca_total, oro, campaña, jugador
CREATE OR REPLACE VIEW V_Personajes_ActivosFichaCorta AS
SELECT p.alias, r.nombre AS raza, p.nivel_total, p.alineamiento, p.pg_actual, p.pg_max, p.ca_total, p.oro, p.campaña, p.jugador
FROM personajes p
JOIN razas r ON p.raza = r.id
WHERE p.estado = 'ACTIVO';


-- ===== SECCIÓN 2: ÍNDICES =====

-- IDX_Razas_JugableRareza
-- Índice compuesto para búsquedas por jugable y rareza
CREATE INDEX IDX_Razas_JugableRareza 
ON razas (jugable, rareza);


-- IDX_Clases_LanzadorTipo
-- Índice compuesto para filtrar por lanzador_conjuros y tipo_lanzamiento
CREATE INDEX IDX_Clases_LanzadorTipo 
ON clases (lanzador_conjuros, tipo_lanzamiento);


-- IDX_Personajes_EstadoPG
-- Índice compuesto para consultas de personajes ACTIVOS y críticos
CREATE INDEX IDX_Personajes_EstadoPG 
ON personajes (estado, pg_actual);


-- IDX_Hechizos_NivelDanio
-- Índice compuesto para filtrar por nivel y tipo_daño
CREATE INDEX IDX_Hechizos_NivelDanio 
ON hechizos (nivel, tipo_daño);


-- IDX_Objetos_TipoRareza
-- Índice compuesto para tienda e inventario (tipo y rareza)
CREATE INDEX IDX_Objetos_TipoRareza 
ON objetos (tipo, rareza);


-- ===== SECCIÓN 3: ALTERACIONES (ALTER TABLE) =====

-- ===== ALTER TABLE razas =====

-- Restricción: velocidad_base solo puede tomar valores 25, 30 o 35
ALTER TABLE razas
ADD CONSTRAINT chk_velocidad_base_valores 
CHECK (velocidad_base IN (25, 30, 35));


-- ===== ALTER TABLE clases =====

-- Restricción: si lanzador_conjuros = FALSE, tipo_lanzamiento debe ser NINGUNO
ALTER TABLE clases
ADD CONSTRAINT chk_lanzador_tipo_lanzamiento 
CHECK (lanzador_conjuros = TRUE OR tipo_lanzamiento = 'NINGUNO');

-- Eliminar índice IDX_Clases_LanzadorTipo (si existe)
ALTER TABLE clases DROP INDEX IDX_Clases_LanzadorTipo;


-- ===== ALTER TABLE personajes =====

-- Restricción: si estado = 'MUERTO', pg_actual debe ser 0
ALTER TABLE personajes
ADD CONSTRAINT chk_muerto_pg_cero 
CHECK (estado <> 'MUERTO' OR pg_actual = 0);


-- ===== ALTER TABLE personaje_clase =====

-- Restricción: dado_vida_restante no puede ser mayor que nivel_clase
ALTER TABLE personaje_clase
ADD CONSTRAINT chk_dado_vida_limite 
CHECK (dado_vida_restante <= nivel_clase);

-- Cambiar nombre de columna notas_master por notas
ALTER TABLE personaje_clase
CHANGE COLUMN notas_master notas TEXT;


-- ===== ALTER TABLE hechizos =====

-- Restricción: si concentracion = TRUE, duracion no puede ser 'Instantánea'
ALTER TABLE hechizos
ADD CONSTRAINT chk_concentracion_duracion 
CHECK (concentracion = FALSE OR duracion <> 'Instantánea');

-- Quitar restricción NOT NULL de ritual
ALTER TABLE hechizos
MODIFY COLUMN ritual BOOLEAN DEFAULT NULL;


-- ===== ALTER TABLE objetos =====

-- Restricción: valor_oro y peso no pueden ser negativos
ALTER TABLE objetos
ADD CONSTRAINT chk_valor_peso_positivos 
CHECK (valor_oro >= 0 AND peso >= 0);

-- Restricción: si tipo = 'ARMADURA', tipo_armadura no puede ser NINGUNA
ALTER TABLE objetos
ADD CONSTRAINT chk_armadura_tipo 
CHECK (tipo <> 'ARMADURA' OR tipo_armadura <> 'NINGUNA');


-- ===== ALTER TABLE inventario =====

-- Restricción: una sola fila por combinación de personaje y objeto
ALTER TABLE inventario
ADD CONSTRAINT uq_personaje_objeto 
UNIQUE (personaje, objeto);

-- Cambiar valor por defecto de equipado a TRUE
ALTER TABLE inventario
MODIFY COLUMN equipado BOOLEAN NOT NULL DEFAULT TRUE;


-- ===== ALTER TABLE mazmorras =====

-- Restricción: tesoro_estimado_oro no puede ser negativo
ALTER TABLE mazmorras
ADD CONSTRAINT chk_tesoro_positivo 
CHECK (tesoro_estimado_oro >= 0);


-- ===== FIN DEL SCRIPT =====
