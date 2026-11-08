USE world;

-- ¿Cuántos países hay en cada continente?
SELECT Continent, COUNT(*) AS NumPaises FROM country GROUP BY Continent;
-- Población total por continente.
SELECT Continent, SUM(Population) AS PoblacionTotal FROM country GROUP BY Continent;
-- Muestra solo los continentes con más de 50 países.
SELECT Continent, COUNT(*) AS NumPaises FROM country GROUP BY Continent HAVING COUNT(*) > 50;
-- Dentro de Europe, ¿cuántos países hay por Region?
SELECT Region, COUNT(*) AS NumPaises FROM country WHERE Continent = 'Europe' GROUP BY Region;
-- Para cada Region, calcula la población media de sus países, pero solo en Asia. Muestra solo regiones con media > 50 millones.  
SELECT Region, AVG(Population) AS PoblacionMedia FROM country WHERE Continent = 'Asia' GROUP BY Region HAVING AVG(Population) > 50000000;
-- Para cada Region (solo en Americas), muestra el nº de países, la población total, GNP medio (ignorando NULL) y quédate solo con regiones que cumplan con al menos 10 países, población total > 100 millones y GNP medio > 10.000
SELECT Region, COUNT(*) AS NumPaises, SUM(Population) AS PoblacionTotal, AVG(GNP) AS GNPMedio FROM country WHERE Continent = 'Americas' GROUP BY Region HAVING COUNT(*) >= 10 AND SUM(Population) > 100000000 AND AVG(GNP) > 10000;