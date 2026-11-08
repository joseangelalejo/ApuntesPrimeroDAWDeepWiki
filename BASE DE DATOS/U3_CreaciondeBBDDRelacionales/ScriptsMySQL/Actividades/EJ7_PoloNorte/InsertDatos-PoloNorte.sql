-- ===== SCRIPT DE DATOS DE PRUEBA - POLO NORTE =====

USE polonorte;

-- ===== TABLA 1: ELFO =====
INSERT INTO elfo (nombre, puesto) VALUES
('Jingleberry', 'Supervisor'),
('Snowdrop', 'Fabricante'),
('Tinsel', 'Fabricante'),
('Rudolph', 'Envolvedor'),
('Sparkle', 'Envolvedor'),
('Frosty', 'Reparador'),
('Ginger', 'Ayudante'),
('Cookie', 'Ayudante'),
('Noelle', 'Supervisor'),
('Zippy', 'Fabricante');

-- ===== TABLA 2: REGALO =====
INSERT INTO regalo (nombre, categoria, pegi, coste) VALUES
('Bicicleta deportiva', 'Físicos y Exteriores', 6, 45.999),
('Consola de videojuegos', 'Electrónicos', 7, 79.990),
('Juego de construcción', 'Educativos y Creativos', 4, 35.490),
('Patinete eléctrico', 'Físicos y Exteriores', 8, 95.500),
('Robot programable', 'Educativos y Creativos', 10, 89.990),
('Dron con cámara', 'Electrónicos', 12, 99.990),
('Juego de mesa estrategia', 'Rol y Simulación', 8, 25.990),
('Tablet infantil', 'Electrónicos', 5, 75.990),
('Patines sobre ruedas', 'Físicos y Exteriores', 6, 55.490),
('Cámara Instax', 'Electrónicos', 7, 69.990),
('Microscopio', 'Educativos y Creativos', 10, 45.990),
('Maleta de viaje', 'Físicos y Exteriores', 0, 85.490);

-- ===== TABLA 3: CASA =====
INSERT INTO casa (direccion, chimenea, animal, seguridad, personas) VALUES
('Calle Principal 10, Madrid', TRUE, 'Perro', 'media', 4),
('Avenida del Parque 25, Barcelona', TRUE, 'Gato', 'alta', 3),
('Calle Luna 7, Valencia', FALSE, NULL, 'baja', 5),
('Plaza Mayor 12, Sevilla', TRUE, 'Perro', 'media', 6),
('Calle Rosario 33, Bilbao', FALSE, 'Gato', 'media', 2),
('Paseo de la Laguna 5, Málaga', TRUE, NULL, 'alta', 4),
('Calle San Felipe 18, Córdoba', TRUE, 'Perro', 'media', 3),
('Avenida Libertad 40, Murcia', FALSE, NULL, 'baja', 7),
('Calle Antigua 9, Palma', TRUE, 'Loro', 'alta', 5),
('Calle Nueva 2, Las Palmas', FALSE, 'Gato', 'media', 4);

-- ===== TABLA 4: NIÑO =====
INSERT INTO niño (nombre, comportamiento, direccion_casa) VALUES
('Alejandro', 'Excelente', 'Calle Principal 10, Madrid'),
('María', 'Bueno', 'Calle Principal 10, Madrid'),
('Carlos', 'Regular', 'Avenida del Parque 25, Barcelona'),
('Sofia', 'Excelente', 'Avenida del Parque 25, Barcelona'),
('Lucas', 'Malo', 'Calle Luna 7, Valencia'),
('Emma', 'Bueno', 'Calle Luna 7, Valencia'),
('Daniel', 'Excelente', 'Plaza Mayor 12, Sevilla'),
('Isabella', 'Bueno', 'Calle Rosario 33, Bilbao'),
('Jorge', 'Regular', 'Paseo de la Laguna 5, Málaga'),
('Lucia', 'Excelente', 'Calle San Felipe 18, Córdoba'),
('Andrés', 'Bueno', 'Avenida Libertad 40, Murcia'),
('Valentina', 'Regular', 'Calle Antigua 9, Palma'),
('Pablo', 'Malo', 'Calle Nueva 2, Las Palmas'),
('Elena', 'Bueno', 'Calle Nueva 2, Las Palmas');

-- ===== TABLA 5: FABRICACION =====
INSERT INTO fabricacion (id_elfo, id_regalo, tiempo, etapa) VALUES
-- Jingleberry (Supervisor)
(1, 2, 480, 'Fabricación'),
(1, 6, 360, 'Fabricación'),
-- Snowdrop (Fabricante)
(2, 1, 240, 'Fabricación'),
(2, 3, 180, 'Fabricación'),
(2, 5, 600, 'Fabricación'),
-- Tinsel (Fabricante)
(3, 7, 120, 'Fabricación'),
(3, 10, 300, 'Fabricación'),
(3, 11, 400, 'Fabricación'),
-- Rudolph (Envolvedor)
(4, 1, 45, 'Envoltura'),
(4, 3, 30, 'Envoltura'),
(4, 7, 25, 'Envoltura'),
-- Sparkle (Envolvedor)
(5, 2, 90, 'Envoltura'),
(5, 6, 75, 'Envoltura'),
(5, 8, 60, 'Envoltura'),
-- Frosty (Reparador)
(6, 4, 200, 'Reparación'),
(6, 6, 150, 'Reparación'),
-- Ginger (Ayudante)
(7, 9, 100, 'Fabricación'),
(7, 12, 80, 'Fabricación'),
-- Cookie (Ayudante)
(8, 5, 250, 'Fabricación'),
(8, 10, 120, 'Envoltura'),
-- Noelle (Supervisor)
(9, 4, 350, 'Fabricación'),
(9, 8, 280, 'Fabricación'),
-- Zippy (Fabricante)
(10, 11, 320, 'Fabricación'),
(10, 2, 400, 'Reparación');

-- ===== VERIFICACIÓN DE DATOS INSERTADOS =====
SELECT COUNT(*) as Total_Elfos FROM elfo;
SELECT COUNT(*) as Total_Regalos FROM regalo;
SELECT COUNT(*) as Total_Casas FROM casa;
SELECT COUNT(*) as Total_Niños FROM niño;
SELECT COUNT(*) as Total_Fabricaciones FROM fabricacion;

-- ===== FIN DEL SCRIPT =====
