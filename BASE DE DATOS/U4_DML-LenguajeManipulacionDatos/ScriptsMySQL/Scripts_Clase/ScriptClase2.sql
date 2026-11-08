Use `D&D`;
/* Hasta ahora hemos estado trabajando con select a nivel de columnas (Proyección), limitando/filtrando las columnas que deseábamos que aparecieran
	como resultado
    Ahora vamos a trabajar con filtros para limitar la cantidad de filas que nos devuelve de la tabla
	indicando los requisitos deseados. Para ello:
    SELECT DISTINCT *columna1*, *columna2* , ...
    FROM *Nombre_Tabla*
    WHERE *Expresión lógica* ....;
    
    La expresión lógica la compone el nombre de una o varias columnas, expresiones, constantes y operadores
    de comparación. Una condición especifíca una combinación de una o más expresiones y operadores lógicos (booleanos) y devuelve un
    TRUE o FALSE. Los principales operadores son:
		- Operadores de comparación
			- = | Igual que
            - <> o != | Distinto que
            - > | Mayor que
            - < |  Menor que
            - >= | Mayor o igual que
            - <= | Menor o igual que
            - BETWEEN | Entre dos valores(ambos incluidos)
            - IN | Coincide con
            - NOT IN | No coincide con
            - LIKE | Coincide con un patrón de carácteres
            - NOT LIKE | No coincide con un patrón
            - IS NULL | Es nulo
            - IS NOT NULL | No es nulo
		- Operadores Lógicos
			- AND | TRUE si todas son TRUE
            - OR  | TRUE si cualquiera es TRUE
            - NOT | TRUE si es falsa
	(TODO: Al hacer apuntes Markdown insertar tablas con operadores)
    (TODO: Introducir tabla con regla de preferencia de operadores lógicos y tabla de regla de cortocircuito)
*/
/*
SELECT distinct atributo_principal as Atributo,nombre as atributo, ID*10, 
concat(atributo_principal, '_', ID*10) from clases;
*/


-- En este caso, el atributo_principal es un número, por lo que al concatenarlo con un string, se convierte en un string, y el resultado de la concatenación es un string
-- Si queremos que el resultado de la concatenación sea un número, debemos convertir el atributo_principal a número antes de concatenarlo, para ello podemos utilizar la función CAST o CONVERT
SELECT nombre from clases where nombre like "M%e";
-- También podemos buscar nombres que empiecen con 'M', terminen con 'a' y tengan al menos 3 caracteres entre ambas, utilizando ___% para indicar al menos 3 caracteres seguidos de cualquier cantidad adicional:
SELECT nombre from clases where nombre like "M___%a";
-- Si queremos indicar que queremos una cantidad específica de caracteres entre la de inicio y la de finalización, podemos utilizar el símbolo _ para indicar un solo carácter, por ejemplo:
SELECT nombre from clases where nombre like "M_e";
-- En este caso, el resultado sería "Me", ya que el símbolo _ indica que debe haber un solo carácter entre la M y la e, y en este

SELECT * FROM clases;

-- Podemos hacer ordenación de los resultados utilizando la cláusula ORDER BY, indicando el nombre de la columna por la que queremos ordenar y el tipo de ordenación (ASC para ascendente o DESC para descendente), por ejemplo:
SELECT * FROM clases ORDER BY nombre ASC;   -- Ordena por nombre de forma ascendente (de la A a la Z)
SELECT * FROM clases ORDER BY nombre DESC;  -- Ordena por nombre de forma descendente (de la Z a la A)
SELECT * FROM clases ORDER BY ID DESC;      -- Ordena por ID de forma descendente (de mayor a menor)
-- También podemos ordenar por varias columnas, indicando el nombre de cada columna y el tipo de orden
SELECT * FROM clases ORDER BY nombre ASC, ID DESC; -- Ordena por nombre de forma ascendente y en caso de empate ordena por ID de forma descendente

/* NOTA: Si usamos ORDER BY con más de una columna de ordenación, primero se ordenará 
    por la primera columna indicada, y en caso de que haya filas con el mismo valor en esa 
    columna, se ordenará por la segunda columna indicada, y así sucesivamente si hay más 
    columnas de ordenación. Es importante tener en cuenta el orden de las columnas de ordenación 
    para obtener el resultado deseado.
*/

/* Además, podemos limitar la cantidad de columnas que se muestran en el resultado 
    utilizando la cláusula LIMIT, indicando el número de filas que queremos mostrar, 
    por ejemplo:
*/
SELECT * FROM clases LIMIT 5; -- Muestra solo las primeras 5 filas del resultado
SELECT * FROM clases ORDER BY ID DESC LIMIT 3; -- Muestra solo las 3 primeras filas del resultado ordenado por ID de forma descendente