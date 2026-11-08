/* Examen de José Ángel Alejo Sillero - 1ºDAW | 26/03/2026 | Práctico Unidad 4 - Recuperación
 Según hablado con profesorado a raíz de incidencia, solo tengo que hacer las actividades de nivel fácil y nivel medio. Las difíciles ya tengo un 10
 y no estarán en el script de entrega.
 */
USE feria_sevilla;
-- Consultas monotabla
/*Facil: Muestra todos los datos de la tabla personas cuya edad sea mayor o igual a 18 años (recuerda que los datos son de 2025)*/
SELECT *
FROM personas
WHERE DATE_ADD(fecha_nacimiento, INTERVAL 18 YEAR) <= CURDATE()
    AND fecha_nacimiento IS NOT NULL;
/*Medio: Muestra el nombre y precio + iva de las diferentes atracciones, cuya capacidad sea mayor a 5 y estén en estado abierta o cuya capacidad sea menor a 5 y su estado sea distinto a abierta*/
SELECT nombre,
    ROUND(precio + (precio * 0.21), 2) AS precio_con_iva
FROM atracciones
WHERE (
        capacidad > 5
        AND estado = 'ABIERTA'
    )
    OR (
        capacidad < 5
        AND estado != 'ABIERTA'
    )
ORDER BY nombre;
-- Consultas composición Interna
/*Facil: Muestra el nombre de las atracciones junto con el nombre de su tipo de atracción de todas aquellas que el tipo sea Acuático*/
SELECT a.nombre,
    ta.nombre AS tipo_atraccion
FROM atracciones a
    INNER JOIN tipos_atraccion ta ON a.tipo = ta.id
WHERE ta.nombre = 'Acuático';
/*Medio: Muestra el nombre de la atracción, el nombre de su tipo, su zona y el nombre y apellidos del feriante que la gestiona. Ordena el resultado por el nombre de la zona*/
SELECT a.nombre,
    ta.nombre AS tipo_atraccion,
    a.zona,
    CONCAT(p.nombre, ' ', COALESCE(p.apellidos, '')) AS feriante
FROM atracciones a
    INNER JOIN tipos_atraccion ta ON a.tipo = ta.id
    INNER JOIN personas p ON a.feriante = p.dni
WHERE a.feriante IS NOT NULL
ORDER BY a.zona;
-- Consultas composición externa
/*Facil: Muestra un listado con el nombre de todas aquellas personas de la tabla personas, que no han sido socios de ninguna caseta. Ordena el listado alfabéticamente por los nombres.*/
SELECT DISTINCT p.nombre,
    p.apellidos
FROM personas p
    LEFT JOIN socios_caseta sc ON p.dni = sc.persona
WHERE sc.persona IS NULL
ORDER BY p.nombre ASC;
/*Medio:*/
-- Agrupamiento y funciones resumen
/*Facil: Muestra la cantidad total de eventos del tipo 'CENA SOCIOS' apodando a la columna resultante como "Cantidad de socios"*/
SELECT COUNT(*) AS 'Cantidad de socios'
FROM eventos
WHERE tipo = 'CENA SOCIOS';
/*Medio: Muestra el nombre de cada tipo de caseta junto con la media del aforo de las casetas que pertenecen a cada tipo*/
SELECT tc.nombre,
    AVG(c.aforo) AS media_aforo
FROM tipos_caseta tc
    LEFT JOIN caseta c ON tc.id = c.tipo
GROUP BY tc.id,
    tc.nombre
ORDER BY tc.nombre;
-- Subconsultas
/*Facil: Muestra el nombre, aforo y tamaño de aquellas casetas cuyo aforo sea superior al aforo máximo de las casetas de tipo familiar*/
SELECT nombre,
    aforo,
    tamaño
FROM caseta
WHERE aforo > (
        SELECT MAX(c.aforo)
        FROM caseta c
            INNER JOIN tipos_caseta tc ON c.tipo = tc.id
        WHERE tc.nombre = 'FAMILIAR'
    );
/*Medio: Muestra el nombre, el aforo y la calle de aquellas casetas cuyo aforo sea superior al aforo medio de las casetas situadas en la misma zona que su calle*/
SELECT c.nombre,
    c.aforo,
    c.calle
FROM caseta c
WHERE c.aforo > (
        SELECT AVG(c2.aforo)
        FROM caseta c2
            INNER JOIN calles cl2 ON c2.calle = cl2.id
        WHERE cl2.zona = (
                SELECT cl.zona
                FROM calles cl
                WHERE cl.id = c.calle
            )
    );