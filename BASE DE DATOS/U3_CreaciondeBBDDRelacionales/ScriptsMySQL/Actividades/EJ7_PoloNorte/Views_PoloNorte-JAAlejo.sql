-- ===== VISTAS - POLO NORTE =====

USE polonorte;

-- ===== VIEW 1: ELFOS CON CANTIDAD DE REGALOS =====
CREATE OR REPLACE VIEW v_elfos_regalos AS
SELECT 
    e.id_elfo,
    e.nombre,
    e.puesto,
    COUNT(f.id_regalo) as cantidad_regalos,
    e.registro
FROM elfo e
LEFT JOIN fabricacion f ON e.id_elfo = f.id_elfo
GROUP BY e.id_elfo, e.nombre, e.puesto, e.registro
ORDER BY e.id_elfo;

-- ===== VIEW 2: REGALOS CON DETALLES DE FABRICACIÓN =====
CREATE OR REPLACE VIEW v_regalos_fabricacion AS
SELECT 
    r.id_regalo,
    r.nombre,
    r.categoria,
    r.pegi,
    r.coste,
    COUNT(f.id_elfo) as elfos_fabricando,
    AVG(f.tiempo) as tiempo_promedio_fabricacion
FROM regalo r
LEFT JOIN fabricacion f ON r.id_regalo = f.id_regalo
GROUP BY r.id_regalo, r.nombre, r.categoria, r.pegi, r.coste
ORDER BY r.id_regalo;

-- ===== VIEW 3: NIÑOS CON INFORMACIÓN DE CASAS =====
CREATE OR REPLACE VIEW v_niños_casas AS
SELECT 
    n.id_niño,
    n.nombre as nombre_niño,
    n.comportamiento,
    c.direccion,
    c.chimenea,
    c.animal,
    c.seguridad,
    c.niños as personas_en_casa
FROM niño n
INNER JOIN casa c ON n.direccion_casa = c.direccion
ORDER BY n.id_niño;

-- ===== VIEW 4: CASAS CON CANTIDAD DE NIÑOS =====
CREATE OR REPLACE VIEW v_casas_niños AS
SELECT 
    c.direccion,
    c.chimenea,
    c.animal,
    c.seguridad,
    c.niños,
    COUNT(n.id_niño) as cantidad_niños
FROM casa c
LEFT JOIN niño n ON c.direccion = n.direccion_casa
GROUP BY c.direccion, c.chimenea, c.animal, c.seguridad, c.niños
ORDER BY c.direccion;

-- ===== VIEW 5: FABRICACIÓN CON NOMBRES DE ELFOS Y REGALOS =====
CREATE OR REPLACE VIEW v_fabricacion_detallada AS
SELECT 
    f.id_elfo,
    e.nombre as elfo,
    e.puesto,
    f.id_regalo,
    r.nombre as regalo,
    r.coste,
    f.tiempo,
    f.etapa
FROM fabricacion f
INNER JOIN elfo e ON f.id_elfo = e.id_elfo
INNER JOIN regalo r ON f.id_regalo = r.id_regalo
ORDER BY f.id_elfo, f.id_regalo;

-- ===== VIEW 6: ELFOS POR PUESTO =====
CREATE OR REPLACE VIEW v_elfos_por_puesto AS
SELECT 
    puesto,
    COUNT(*) as cantidad_elfos,
    GROUP_CONCAT(nombre SEPARATOR ', ') as nombres
FROM elfo
GROUP BY puesto
ORDER BY puesto;

-- ===== VIEW 7: REGALOS POR CATEGORÍA Y PEGI =====
CREATE OR REPLACE VIEW v_regalos_categoría AS
SELECT 
    categoria,
    pegi,
    COUNT(*) as cantidad_regalos,
    AVG(coste) as coste_promedio,
    MIN(coste) as coste_minimo,
    MAX(coste) as coste_maximo
FROM regalo
WHERE categoria IS NOT NULL
GROUP BY categoria, pegi
ORDER BY categoria, pegi;

-- ===== VIEW 8: NIÑOS EXCELENTES Y SUS CASAS =====
CREATE OR REPLACE VIEW v_niños_excelentes AS
SELECT 
    n.id_niño,
    n.nombre as nombre_niño,
    c.direccion,
    c.chimenea,
    c.animal,
    c.seguridad
FROM niño n
INNER JOIN casa c ON n.direccion_casa = c.direccion
WHERE n.comportamiento = 'Excelente'
ORDER BY n.nombre;

-- ===== VIEW 9: CASAS SIN CHIMENEA =====
CREATE OR REPLACE VIEW v_casas_sin_chimenea AS
SELECT 
    c.direccion,
    c.animal,
    c.seguridad,
    c.niños,
    COUNT(n.id_niño) as cantidad_niños
FROM casa c
LEFT JOIN niño n ON c.direccion = n.direccion_casa
WHERE c.chimenea = FALSE
GROUP BY c.direccion, c.animal, c.seguridad, c.niños;

-- ===== VIEW 10: TIEMPO TOTAL DE FABRICACIÓN POR ELFO =====
CREATE OR REPLACE VIEW v_tiempo_fabricacion_por_elfo AS
SELECT 
    e.id_elfo,
    e.nombre,
    e.puesto,
    SUM(f.tiempo) as tiempo_total_minutos,
    ROUND(SUM(f.tiempo) / 60, 2) as tiempo_total_horas,
    COUNT(f.id_regalo) as cantidad_tareas
FROM elfo e
LEFT JOIN fabricacion f ON e.id_elfo = f.id_elfo
GROUP BY e.id_elfo, e.nombre, e.puesto
ORDER BY tiempo_total_minutos DESC;

-- ===== VERIFICACIÓN DE VISTAS CREADAS =====
SELECT TABLE_NAME 
FROM INFORMATION_SCHEMA.VIEWS 
WHERE TABLE_SCHEMA = 'polonorte'
ORDER BY TABLE_NAME;

-- ===== FIN DEL SCRIPT DE VISTAS =====
