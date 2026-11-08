USE feria_sevilla;

-- CONSULTAS MONOTABLA
/* Muestra una columna llamada Ubicación formada por nombre de la calle y su zona entre paréntesis, y otra columna llamada Densidad calculada
diviciendo la capacidad entre el producto de la longitud y el ancho.
Solo deben aparecer las calles cuyo nombre empiece por P y tengan una capacidad superior a 3000, o aquellas cuyo nombre termine en a y tengan
una capacidad inferior a 3000.
Ordena el resultado por densidad de forma descendente y, en caso de empate, por nombre de calle en orden ascendente.
*/
SELECT 
    CONCAT(c.nombre, ' (', c.zona, ')') AS Ubicación,
    ROUND(c.capacidad / (c.longitud * c.ancho), 4) AS Densidad
FROM calles c
WHERE (c.nombre LIKE 'P%' AND c.capacidad > 3000) 
   OR (c.nombre LIKE '%a' AND c.capacidad < 3000)
ORDER BY Densidad DESC, c.nombre ASC;

-- CONSULTAS COMPOSICIÓN INTERNA
/*
Mostrar el nombre y apellidos de los responsables (en una única columna apodada responsable) y 
el nombre y apellidos de los socios feriantes (en una única columna apodada "Socio Feriante") asociados a sus mismas casetas. 
Un socio feriante será aquel socio de caseta que figure además como feriante de alguna atracción. 
No deben aparecer resultados repetidos.
*/
SELECT DISTINCT
    CONCAT(p_resp.nombre, ' ', COALESCE(p_resp.apellidos, '')) AS responsable,
    CONCAT(p_socio.nombre, ' ', COALESCE(p_socio.apellidos, '')) AS 'Socio Feriante'
FROM responsables r
INNER JOIN personas p_resp ON r.persona = p_resp.dni
INNER JOIN socios_caseta sc ON r.caseta = sc.caseta
INNER JOIN personas p_socio ON sc.persona = p_socio.dni
WHERE sc.persona IN (
    SELECT DISTINCT feriante 
    FROM atracciones 
    WHERE feriante IS NOT NULL
)
ORDER BY responsable, 'Socio Feriante';

-- CONSULTAS COMPOSICIÓN EXTERNA
/*
Muestra el nombre de cada caseta, el tipo de caseta y, si existen, los nombres de los eventos celebrados en ella.
Deben aparecer también las casetas que no tengan ningún evento. 
Ordena por tipo de caseta y por nombre de la caseta.
*/
SELECT 
    c.nombre AS caseta,
    tc.nombre AS tipo_caseta,
    COALESCE(e.nombre, 'Sin evento') AS evento
FROM caseta c
INNER JOIN tipos_caseta tc ON c.tipo = tc.id
LEFT JOIN eventos e ON c.id = e.caseta
ORDER BY tc.nombre ASC, c.nombre ASC;

-- AGRUPAMIENTO Y FUNCIONES RESUMEN
/*
Muestra, para cada estado de las atracciones, el número total de atracciones y el precio medio de sus entradas.
Solo muestra los estados que tengan más de 2 atracciones.
Ordena el resultado por número de atracciones de mayor a menor.
*/
SELECT 
    a.estado,
    COUNT(DISTINCT a.id) AS total_atracciones,
    ROUND(AVG(COALESCE(a.precio, 0)), 2) AS precio_medio
FROM atracciones a
GROUP BY a.estado
HAVING COUNT(DISTINCT a.id) > 2
ORDER BY total_atracciones DESC;

-- SUBCONSULTAS
/*
Muestra el nombre de cada tipo de atracción y, para cada tipo, una columna con el número de atracciones
que pertenecen a ese tipo y otra con el número total de tickets expedidos para las atracciones de ese tipo.
*/
SELECT 
    ta.nombre AS tipo_atraccion,
    COUNT(DISTINCT a.id) AS numero_atracciones,
    COALESCE(COUNT(DISTINCT t.id), 0) AS total_tickets
FROM tipos_atraccion ta
LEFT JOIN atracciones a ON ta.id = a.tipo
LEFT JOIN tickets t ON a.id = t.atraccion
GROUP BY ta.id, ta.nombre
ORDER BY ta.nombre ASC;
