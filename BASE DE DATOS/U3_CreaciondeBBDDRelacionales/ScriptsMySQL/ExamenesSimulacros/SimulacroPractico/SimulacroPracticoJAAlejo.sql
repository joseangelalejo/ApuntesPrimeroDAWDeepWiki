-- ===== POKÉDEX DATABASE CREATION =====
-- Autor: José Ángel Alejo Sillero
-- Descripción: Base de datos relacional para una Pokédex Gen 1 con control de usuarios y roles

DROP DATABASE IF EXISTS pokedex;
CREATE DATABASE pokedex;
USE pokedex;

-- ===== TABLA TIPO =====
/* Almacena los tipos de pokemon existentes
   PK es nombre porque es único y obligatorio
   Símbolo se almacena como VARCHAR aunque podría ser BLOB para imagen
*/
DROP TABLE IF EXISTS tipo;
CREATE TABLE tipo (
    nombre VARCHAR(20) PRIMARY KEY,
    simbolo VARCHAR(100) NOT NULL
);

-- ===== TABLA EFECTIVIDAD_DOBLE_TIPO =====
/* Efectividad entre tipos defensivos
   Puede haber dos tipos defensivos, por eso segundo_tipo_defensor permite NULL
   PK compuesta: tipo_atacante, primer_tipo_defensor, multiplicador
   (un mismo multiplicador no se repite para la misma combinación)
*/
DROP TABLE IF EXISTS efectividad_doble_tipo;
CREATE TABLE efectividad_doble_tipo (
    tipo_atacante VARCHAR(20) NOT NULL,
    primer_tipo_defensor VARCHAR(20) NOT NULL,
    segundo_tipo_defensor VARCHAR(20) NULL,
    multiplicador DECIMAL(3,2) NOT NULL CHECK (multiplicador IN (0.00, 0.25, 0.50, 1.00, 2.00, 4.00)),
    PRIMARY KEY (tipo_atacante, primer_tipo_defensor, multiplicador),
    FOREIGN KEY (tipo_atacante) REFERENCES tipo(nombre),
    FOREIGN KEY (primer_tipo_defensor) REFERENCES tipo(nombre),
    FOREIGN KEY (segundo_tipo_defensor) REFERENCES tipo(nombre)
);

-- ===== TABLA POKEMON =====
/* Información principal del pokemon
   Número Pokédex es PK porque es único y es el ID oficial
   Visto y Capturado son campos obligatorios y por defecto FALSE
   Primer tipo es obligatorio, segundo tipo puede no existir
*/
DROP TABLE IF EXISTS pokemon;
CREATE TABLE pokemon (
    numero_pokedex INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    especie VARCHAR(100) NULL,
    altura DECIMAL(4,2) NOT NULL CHECK (altura > 0),
    peso DECIMAL(6,2) NOT NULL CHECK (peso > 0),
    descripcion TEXT NULL,
    primer_tipo VARCHAR(20) NOT NULL,
    segundo_tipo VARCHAR(20) NULL,
    visto BOOLEAN NOT NULL DEFAULT FALSE,
    capturado BOOLEAN NOT NULL DEFAULT FALSE,
    sprite VARCHAR(200) NULL,
    FOREIGN KEY (primer_tipo) REFERENCES tipo(nombre),
    FOREIGN KEY (segundo_tipo) REFERENCES tipo(nombre)
);

-- ===== TABLA MOVIMIENTO =====
/* Movimientos de Gen 1
   ID auto-incrementable para ser manejable desde código
   Potencia puede ser NULL porque hay movimientos de estado que no hacen daño
   Precisión y PP siempre positivos
*/
DROP TABLE IF EXISTS movimiento;
CREATE TABLE movimiento (
    id_movimiento INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    tipo VARCHAR(20) NOT NULL,
    potencia INT NULL CHECK (potencia > 0),
    exactitud INT NOT NULL CHECK (exactitud > 0),
    puntos_poder INT NOT NULL CHECK (puntos_poder > 0),
    FOREIGN KEY (tipo) REFERENCES tipo(nombre)
);

-- ===== TABLA APRENDIZAJE_MOVIMIENTO =====
/* Relaciona pokemons con movimientos e indica cómo aprenden
   PK compuesta: pokemon, movimiento (un movimiento no puede enseñarse 2 veces al mismo pkmn)
   Tipo de aprendizaje: Nivel (learn by level), MT (TM), MO (HM)
   Si es por nivel, el nivel no es null y numero_mt_mo sí lo es
   Si es MT/MO, numero_mt_mo no es null y nivel sí
*/
DROP TABLE IF EXISTS aprendizaje_movimiento;
CREATE TABLE aprendizaje_movimiento (
    numero_pokedex INT NOT NULL,
    id_movimiento INT NOT NULL,
    tipo_aprendizaje ENUM('Nivel', 'MT', 'MO') NOT NULL,
    nivel INT NULL CHECK (nivel > 0),
    numero_mt_mo INT NULL CHECK (numero_mt_mo > 0),
    PRIMARY KEY (numero_pokedex, id_movimiento),
    FOREIGN KEY (numero_pokedex) REFERENCES pokemon(numero_pokedex),
    FOREIGN KEY (id_movimiento) REFERENCES movimiento(id_movimiento),
    /* Restricción: si es por nivel, nivel no puede ser NULL
       Si es MT/MO, numero_mt_mo no puede ser NULL */
    CONSTRAINT chk_aprendizaje CHECK (
        (tipo_aprendizaje = 'Nivel' AND nivel IS NOT NULL AND numero_mt_mo IS NULL) OR
        (tipo_aprendizaje IN ('MT', 'MO') AND numero_mt_mo IS NOT NULL AND nivel IS NULL)
    )
);

-- ===== TABLA ESTADISTICAS_BASE =====
/* Estadísticas base del pokemon (cada pkmn tiene exactamente 1)
   PK es numero_pokedex porque es 1-1 con pokemon
   Todos los stats son positivos y muy pequeños (max ~255 en Gen 1)
*/
DROP TABLE IF EXISTS estadisticas_base;
CREATE TABLE estadisticas_base (
    numero_pokedex INT PRIMARY KEY,
    ps INT NOT NULL CHECK (ps > 0),
    ataque INT NOT NULL CHECK (ataque > 0),
    defensa INT NOT NULL CHECK (defensa > 0),
    velocidad INT NOT NULL CHECK (velocidad > 0),
    FOREIGN KEY (numero_pokedex) REFERENCES pokemon(numero_pokedex)
);

-- ===== MODIFICACIONES CON ALTER TABLE =====

/* 1. Asegurar que un pokemon no pueda tener dos tipos iguales */
ALTER TABLE pokemon ADD CONSTRAINT chk_tipos_diferentes CHECK (primer_tipo != segundo_tipo OR segundo_tipo IS NULL);

/* 2. Un pokemon capturado debe haber sido visto previamente */
ALTER TABLE pokemon ADD CONSTRAINT chk_capturado_visto CHECK (capturado = FALSE OR visto = TRUE);

/* 3. Campos temporales para registrar cuándo fue visto y capturado */
ALTER TABLE pokemon ADD COLUMN fecha_visto TIMESTAMP NULL;
ALTER TABLE pokemon ADD COLUMN fecha_capturado TIMESTAMP NULL;

-- ===== VISTAS =====

/* Vista 1: Tabla de tipos sin inmunidades (multiplicador != 0) */
CREATE OR REPLACE VIEW v_tipos_efectividad AS
SELECT 
    tipo_atacante,
    primer_tipo_defensor,
    segundo_tipo_defensor,
    multiplicador
FROM efectividad_doble_tipo
WHERE multiplicador != 0.00
ORDER BY tipo_atacante, primer_tipo_defensor;

/* Vista 2: Pokémon vistos (info básica) */
CREATE OR REPLACE VIEW v_pokemon_vistos AS
SELECT 
    numero_pokedex,
    sprite,
    nombre,
    especie
FROM pokemon
WHERE visto = TRUE
ORDER BY numero_pokedex;

/* Vista 3: Pokémon capturados (con info adicional) */
CREATE OR REPLACE VIEW v_pokemon_capturados AS
SELECT 
    numero_pokedex,
    sprite,
    nombre,
    especie,
    peso,
    altura,
    descripcion
FROM pokemon
WHERE capturado = TRUE
ORDER BY numero_pokedex;

-- ===== ÍNDICES PARA OPTIMIZACIÓN =====

/* Índice para búsquedas frecuentes de pokemons vistos */
CREATE INDEX idx_pokemon_visto ON pokemon(visto);

/* Índice compuesto para búsquedas de vistos Y capturados */
CREATE INDEX idx_pokemon_visto_capturado ON pokemon(visto, capturado);

/* Índice para búsquedas por tipo */
CREATE INDEX idx_pokemon_tipo ON pokemon(primer_tipo, segundo_tipo);

/* Índice para búsquedas de efectividad según tipos defensivos */
CREATE INDEX idx_efectividad_defensiva ON efectividad_doble_tipo(primer_tipo_defensor, segundo_tipo_defensor);

-- ===== DCL: USUARIOS, ROLES Y PERMISOS =====

/* Crear roles */
CREATE ROLE IF NOT EXISTS rol_profesor;
CREATE ROLE IF NOT EXISTS rol_alumno;
CREATE ROLE IF NOT EXISTS rol_supremo;

/* Otorgar privilegios al rol profesor investigador */
-- Profesor puede: SELECT, INSERT, UPDATE en pokemons, movimientos, aprendizajes, efectividades y tipos
GRANT SELECT, INSERT, UPDATE ON pokedex.pokemon TO rol_profesor;
GRANT SELECT, INSERT, UPDATE ON pokedex.movimiento TO rol_profesor;
GRANT SELECT, INSERT, UPDATE ON pokedex.aprendizaje_movimiento TO rol_profesor;
GRANT SELECT, INSERT, UPDATE ON pokedex.efectividad_doble_tipo TO rol_profesor;
GRANT SELECT, INSERT, UPDATE ON pokedex.tipo TO rol_profesor;

/* Otorgar privilegios al rol alumno */
-- Alumnos solo pueden consultar las vistas de visto, capturado y tabla de tipos
GRANT SELECT ON pokedex.v_pokemon_vistos TO rol_alumno;
GRANT SELECT ON pokedex.v_pokemon_capturados TO rol_alumno;
GRANT SELECT ON pokedex.v_tipos_efectividad TO rol_alumno;

/* Otorgar privilegios al rol supremo (entidad suprema) */
-- Todos los privilegios en todas las tablas
GRANT ALL PRIVILEGES ON pokedex.* TO rol_supremo;

-- ===== CREAR USUARIOS =====

/* Crear 3 usuarios para el rol de Alumno */
CREATE USER IF NOT EXISTS 'alumno1'@'localhost' IDENTIFIED BY 'pass_alumno1';
CREATE USER IF NOT EXISTS 'alumno2'@'localhost' IDENTIFIED BY 'pass_alumno2';
CREATE USER IF NOT EXISTS 'alumno3'@'localhost' IDENTIFIED BY 'pass_alumno3';

/* Crear usuario para el rol de Profesor */
CREATE USER IF NOT EXISTS 'profesor'@'localhost' IDENTIFIED BY 'pass_profesor';

/* Crear usuario para el rol de Entidad Suprema */
CREATE USER IF NOT EXISTS 'admin'@'localhost' IDENTIFIED BY 'pass_admin';

-- ===== ASIGNAR ROLES A USUARIOS =====

/* Asignar rol de alumno */
GRANT rol_alumno TO 'alumno1'@'localhost';
GRANT rol_alumno TO 'alumno2'@'localhost';
GRANT rol_alumno TO 'alumno3'@'localhost';

/* Asignar rol de profesor */
GRANT rol_profesor TO 'profesor'@'localhost';

/* Asignar rol supremo */
GRANT rol_supremo TO 'admin'@'localhost';

-- ===== ACTIVAR ROLES AUTOMÁTICAMENTE =====

/* Los roles se activan automáticamente al conectarse */
ALTER USER 'alumno1'@'localhost' DEFAULT ROLE rol_alumno;
ALTER USER 'alumno2'@'localhost' DEFAULT ROLE rol_alumno;
ALTER USER 'alumno3'@'localhost' DEFAULT ROLE rol_alumno;
ALTER USER 'profesor'@'localhost' DEFAULT ROLE rol_profesor;
ALTER USER 'admin'@'localhost' DEFAULT ROLE rol_supremo;

-- ===== INSERCIÓN DE DATOS DE PRUEBA =====

/* Tipos Gen 1 */
INSERT INTO tipo (nombre, simbolo) VALUES ('Normal', 'normal.png');
INSERT INTO tipo (nombre, simbolo) VALUES ('Fuego', 'fuego.png');
INSERT INTO tipo (nombre, simbolo) VALUES ('Agua', 'agua.png');
INSERT INTO tipo (nombre, simbolo) VALUES ('Planta', 'planta.png');
INSERT INTO tipo (nombre, simbolo) VALUES ('Eléctrico', 'electrico.png');
INSERT INTO tipo (nombre, simbolo) VALUES ('Hielo', 'hielo.png');
INSERT INTO tipo (nombre, simbolo) VALUES ('Lucha', 'lucha.png');
INSERT INTO tipo (nombre, simbolo) VALUES ('Veneno', 'veneno.png');
INSERT INTO tipo (nombre, simbolo) VALUES ('Tierra', 'tierra.png');
INSERT INTO tipo (nombre, simbolo) VALUES ('Volador', 'volador.png');
INSERT INTO tipo (nombre, simbolo) VALUES ('Psíquico', 'psiquico.png');
INSERT INTO tipo (nombre, simbolo) VALUES ('Bicho', 'bicho.png');
INSERT INTO tipo (nombre, simbolo) VALUES ('Roca', 'roca.png');
INSERT INTO tipo (nombre, simbolo) VALUES ('Fantasma', 'fantasma.png');
INSERT INTO tipo (nombre, simbolo) VALUES ('Dragón', 'dragon.png');

/* Pokémon de prueba */
INSERT INTO pokemon (numero_pokedex, nombre, especie, altura, peso, descripcion, primer_tipo, segundo_tipo, visto, capturado, sprite)
VALUES (1, 'Bulbizarre', 'Pokémon Semilla', 0.71, 6.9, 'Un pokémon planta clásico', 'Planta', 'Veneno', TRUE, TRUE, 'bulbizarre.png');

INSERT INTO pokemon (numero_pokedex, nombre, especie, altura, peso, descripcion, primer_tipo, segundo_tipo, visto, capturado, sprite)
VALUES (4, 'Salamandra', 'Pokémon Lagartija', 0.61, 8.5, 'Un pokémon fuego de inicio', 'Fuego', NULL, TRUE, FALSE, 'salamandra.png');

INSERT INTO pokemon (numero_pokedex, nombre, especie, altura, peso, descripcion, primer_tipo, segundo_tipo, visto, capturado, sprite)
VALUES (7, 'Caparincho', 'Pokémon Tortuga', 0.51, 9.0, 'Un pokémon agua de inicio', 'Agua', NULL, TRUE, TRUE, 'caparincho.png');

/* Movimientos de prueba */
INSERT INTO movimiento (nombre, tipo, potencia, exactitud, puntos_poder) VALUES ('Placaje', 'Normal', 40, 100, 35);
INSERT INTO movimiento (nombre, tipo, potencia, exactitud, puntos_poder) VALUES ('Látigo Cepa', 'Planta', 45, 100, 25);
INSERT INTO movimiento (nombre, tipo, potencia, exactitud, puntos_poder) VALUES ('Lanzallamas', 'Fuego', 90, 100, 15);
INSERT INTO movimiento (nombre, tipo, potencia, exactitud, puntos_poder) VALUES ('Pistola Agua', 'Agua', 40, 100, 25);

/* Aprendizajes de prueba */
INSERT INTO aprendizaje_movimiento (numero_pokedex, id_movimiento, tipo_aprendizaje, nivel, numero_mt_mo)
VALUES (1, 2, 'Nivel', 7, NULL);

INSERT INTO aprendizaje_movimiento (numero_pokedex, id_movimiento, tipo_aprendizaje, nivel, numero_mt_mo)
VALUES (4, 3, 'Nivel', 9, NULL);

INSERT INTO aprendizaje_movimiento (numero_pokedex, id_movimiento, tipo_aprendizaje, nivel, numero_mt_mo)
VALUES (7, 4, 'Nivel', 7, NULL);

/* Estadísticas de prueba */
INSERT INTO estadisticas_base (numero_pokedex, ps, ataque, defensa, velocidad) VALUES (1, 45, 49, 49, 45);
INSERT INTO estadisticas_base (numero_pokedex, ps, ataque, defensa, velocidad) VALUES (4, 39, 52, 43, 65);
INSERT INTO estadisticas_base (numero_pokedex, ps, ataque, defensa, velocidad) VALUES (7, 44, 48, 65, 43);

/* Efectividades de prueba (reducidas al mínimo para testing) */
INSERT INTO efectividad_doble_tipo (tipo_atacante, primer_tipo_defensor, segundo_tipo_defensor, multiplicador)
VALUES ('Fuego', 'Agua', NULL, 0.50);

INSERT INTO efectividad_doble_tipo (tipo_atacante, primer_tipo_defensor, segundo_tipo_defensor, multiplicador)
VALUES ('Fuego', 'Planta', NULL, 2.00);

INSERT INTO efectividad_doble_tipo (tipo_atacante, primer_tipo_defensor, segundo_tipo_defensor, multiplicador)
VALUES ('Agua', 'Fuego', NULL, 2.00);

-- ===== VERIFICACIÓN FINAL =====

SELECT 'Base de datos Pokédex creada correctamente' AS estado;
SHOW TABLES;
SELECT TABLE_NAME FROM INFORMATION_SCHEMA.VIEWS WHERE TABLE_SCHEMA = 'pokedex';
