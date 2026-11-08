USE tienda;
DROP TABLE IF EXISTS productos;
CREATE TABLE productos ( 
ID_Producto int PRIMARY KEY AUTO_INCREMENT,
Nombre varchar(30) NOT NULL, -- 30 es M, donde M indica la cantidad maxima de caracteres
Precio decimal(6,2), /* Indica M, D donde M es cantidad de digitos y
						D es cantidad de digitos que serán decimales contando desde la derecha 
						En este caso, el dígito máximo almacenado será 9999,99 (9 mil 999 con 99)
                    */
stock int unsigned # unsigned indica que no puede ser negativo
# Agregar FK de empleado cuando lo demos en clase
);
