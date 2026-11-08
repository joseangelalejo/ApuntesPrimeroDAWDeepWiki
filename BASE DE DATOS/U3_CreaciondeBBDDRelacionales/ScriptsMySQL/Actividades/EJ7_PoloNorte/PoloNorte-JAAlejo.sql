-- DATABASE según premisa:
DROP DATABASE IF EXISTS polonorte;
CREATE DATABASE polonorte;
USE polonorte;

-- TABLA ELFO
DROP TABLE IF EXISTS elfo;
CREATE TABLE elfo (
    id_elfo INT PRIMARY KEY AUTO_INCREMENT, -- Id único del elfo
    nombre VARCHAR(75) NOT NULL,
    puesto ENUM ('Envolvedor', 'Fabricante', 'Supervisor', 'Ayudante', 'Reparador') DEFAULT 'Ayudante',
    registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

--  TABLA REGALO

DROP TABLE IF EXISTS regalo;
CREATE TABLE regalo (
    id_regalo INT PRIMARY KEY AUTO_INCREMENT, -- Id único del regalo
    nombre VARCHAR(50) NOT NULL,
    categoria SET ('Acción y Aventura', 'Educativos y Creativos', 'Rol y Simulación', 'Físicos y Exteriores', 'Electrónicos') NULL,
    pegi INT NOT NULL,
    coste DECIMAL(5,3) NOT NULL
);

-- TABLA FABRICACION

DROP TABLE IF EXISTS fabricacion;
CREATE TABLE fabricacion (
    id_elfo INT NOT NULL,
    id_regalo INT NOT NULL,
    tiempo INT NOT NULL, -- elfo vago
    etapa ENUM('Fabricación', 'Reparación', 'Envoltura') NOT NULL,
    PRIMARY KEY (id_elfo, id_regalo),
    FOREIGN KEY (id_elfo) REFERENCES elfo(id_elfo),
    FOREIGN KEY (id_regalo) REFERENCES regalo(id_regalo)
);

-- TABLA CASA

DROP TABLE IF EXISTS casa;
CREATE TABLE casa (
    direccion VARCHAR(150) PRIMARY KEY, -- Dirección completa de la casa
    chimenea BOOLEAN NOT NULL,
    animal VARCHAR(100) NULL,
    seguridad ENUM('baja', 'media', 'alta') NULL, -- casa en ruinas
    personas INT NOT NULL
);

-- TABLA NIÑO

DROP TABLE IF EXISTS niño;
CREATE TABLE niño (
    id_niño INT PRIMARY KEY AUTO_INCREMENT, -- Id único del niño
    nombre VARCHAR(75) NOT NULL,
    comportamiento ENUM('Excelente', 'Bueno', 'Regular', 'Malo') NOT NULL,
    direccion_casa VARCHAR(150) NOT NULL,
    FOREIGN KEY (direccion_casa) REFERENCES casa(direccion)
);