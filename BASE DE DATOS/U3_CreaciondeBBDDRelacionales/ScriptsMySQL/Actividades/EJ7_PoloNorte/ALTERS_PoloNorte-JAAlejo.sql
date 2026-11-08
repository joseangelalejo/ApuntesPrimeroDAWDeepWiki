-- Script de ALTER para PoloNorte
USE polonorte;

-- Añadir columna Jefe a la tabla elfo
ALTER TABLE elfo ADD COLUMN jefe BOOLEAN DEFAULT FALSE;

-- Añadir columna edad a la tabla niño
ALTER TABLE niño ADD COLUMN edad INT;

-- Añadir restricción CHECK a la columna edad en niño
ALTER TABLE niño ADD CONSTRAINT chk_edad CHECK (edad <= 19);

-- Cambiar el nombre de la columna personas a niños en la tabla casa
ALTER TABLE casa CHANGE COLUMN personas niños INT NOT NULL;

-- Cambiar el tipo de dato de la columna tiempo en fabricacion a DECIMAL para mayor precisión
ALTER TABLE fabricacion MODIFY COLUMN tiempo DECIMAL(10,2) NOT NULL;
