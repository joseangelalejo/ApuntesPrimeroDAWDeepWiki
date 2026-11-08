Use world;
SELECT * from city;
SELECT 10/(2*(5+32)) as Resultado;
SELECT Name as Ciudad, Population as Población, CountryCode
as "Codigo País" from city;
SELECT Name, Population, CountryCode from city;
SELECT * from city;

SELECT Name, Continent, Population, 
concat(Name,'_', Continent,'_', Population) as Concatenación from country;

SELECT distinct Continent, Name from country;