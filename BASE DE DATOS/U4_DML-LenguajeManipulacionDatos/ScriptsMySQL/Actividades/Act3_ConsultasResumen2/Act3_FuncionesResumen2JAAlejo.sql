USE world;

-- ¿Cuántas ciudades hay registradas en cada país (usando el código de país CountryCode)?
SELECT CountryCode, COUNT(*) AS NumCiudades FROM city GROUP BY CountryCode;
-- ¿Cuál es la población mínima, máxima y media de las ciudades registradas?
SELECT MIN(Population) AS PoblacionMinima, MAX(Population) AS PoblacionMaxima, AVG(Population) AS PoblacionMedia FROM city;
-- ¿Cuántos países hay en cada continente?
SELECT Continent, COUNT(*) AS NumPaises FROM country GROUP BY Continent;
-- ¿Cuál es la población total y la población media de los países en cada continente?
SELECT Continent, SUM(Population) AS PoblacionTotal, AVG(Population) AS PoblacionMedia FROM country GROUP BY Continent;
-- ¿Qué idiomas son oficiales en 10 o más países?
SELECT * from countrylanguage;
    /* Sentencia inicial
        SELECT Language, COUNT(DISTINCT CountryCode) AS 'IsOfficial>10' FROM countrylanguage WHERE IsOfficial = 'T' GROUP BY Language HAVING COUNT(DISTINCT CountryCode) >= 10;;
    */
    /*Script correcto:*/
SELECT Language, COUNT(DISTINCT CountryCode) AS NumPaises FROM countrylanguage WHERE IsOfficial = 'T' GROUP BY Language HAVING COUNT(DISTINCT CountryCode) >= 10 ORDER BY NumPaises DESC;
-- ¿Qué distritos tienen una población total de ciudades superior a 5.000.000 de habitantes?
SELECT District, SUM(Population) AS PoblacionTotal FROM city GROUP BY District HAVING SUM(Population) > 5000000 ORDER BY PoblacionTotal DESC;
-- Por cada continente, mostrar el número de países, la esperanza de vida media y el GNP medio, considerando solo continentes con al menos 30 países.
-- Por cada continente, calcular la población total y la densidad media de población de los países, mostrando solo aquellos continentes cuya población total supere los 500.000.000 de habitantes.
-- ¿Qué países (por código) tienen al menos 20 ciudades registradas y cuya población media de ciudades supera los 200.000 habitantes?
-- ¿Qué idiomas aparecen en al menos 15 países y tienen un porcentaje medio de hablantes superior al 20%?