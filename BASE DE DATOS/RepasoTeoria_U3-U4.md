# Examenes de teoría Unidad 3 y Unidad 4 de Bases de Datos - MySQL

## Unidad 3 - Modelo B - Test de Bases de Datos

1. ¿Qué opción ZEROFILL afecta a un número?

- a. A su valor real almacenado  
- b. A su rango permitido  
- **c. Solo a su representación visual** ✓  
- d. A su precisión decimal

2. ¿Para qué se utiliza la restricción CHECK?

- a. Evitar valores duplicados  
- b. Definir claves externas  
- **c. Limitar el rango o condición de los valores permitidos** ✓  
- d. Asignar valores por defecto

3. Nombre = NULL ¿Qué devuelve esta comparación?

- a. Siempre devolverá TRUE  
- b. Siempre devolverá FALSE  
- **c. Siempre devuelve UNDEFINED** ✓  
- d. No devuelve nada porque da error

4. ¿Qué significa UNSIGNED?

- a. No admite números positivos  
- **b. No admite números negativos** ✓  
- c. No admite signos de puntuación  
- d. No admite caracteres especiales

5. ¿Cuál de las siguientes contiene un error?

- a. ID INT Primary key  
- b. ID Varchar(50) Primary key  
- c. ID Text Primary Key  
- **d. ID FLOAT Primary key** ✗

6. ¿Cuál es la diferencia entre CHANGE y MODIFY?

- a. Modify permite cambiar tipo y restricciones  
- b. Change permite cambiar solo tipo de dato  
- **c. Modify permite modificar el nombre y el tipo** ✗  
- d. Change no permite cambiar restricciones

7. ¿Qué característica distingue a una clave primaria de una UNIQUE?

- a. UNIQUE no crea índices  
- b. PRIMARY KEY permite duplicados  
- **c. La PRIMARY KEY no admite valores NULL** ✓  
- d. UNIQUE solo puede aplicarse a una columna

8. ¿Qué privilegio permite conceder permisos a otros usuarios?

- **a. GRANT PRIVILEGES** ✓  
- b. CREATE PRIVILEGES  
- c. GRANT OPTION ✗  
- d. PUSH OPTION

9. ¿Cuál de los siguientes tipos contiene mayor precisión (admite más decimales)?

- a. DOUBLE  
- b. INTEGER  
- **c. DECIMAL(100,4)** ✗  
- d. FLOAT

10. ¿Qué indica el valor numérico en la definición VARCHAR(n)?

- **a. El número máximo de caracteres que puede almacenarse** ✓  
- b. El número mínimo de caracteres permitidos  
- c. El espacio fijo reservado para cada valor  
- d. El tamaño en bytes que ocupará siempre el campo

---

11. ¿Cuál de las siguientes restricciones NO puede ponerse a nivel de Tabla?

- a. Primary Key  
- b. Unique  
- c. NOT NULL  
- **d. Foreign Key** ✗

12. ¿Qué instrucción se utiliza para asignar un rol a un usuario?

- a. ASSIGN rol TO usuario  
- b. SET rol TO usuario  
- **c. GRANT rol TO usuario** ✓  
- d. ADD rol TO usuario

13. ¿Cuál de las siguientes definiciones encaja más con una VIEW?

- a. Estructura que almacena datos  
- b. Tabla temporal de un único uso  
- **c. Tabla virtual de una tabla física** ✓  
- d. Copia física de otra tabla

14. ¿Qué tipo geométrico representa un área cerrada?

- a. LINESTRING  
- b. MULTIPOINT ✗  
- **c. POLYGON** ✓  
- d. GEOMETRYCOLLECTION

15. ¿Qué propiedades lleva de forma interna la Primary key?

- a. NOT NULL y FOREIGN KEY  
- b. UNIQUE y AUTO_INCREMENT  
- **c. NOT NULL y UNIQUE** ✓  
- d. AUTO_INCREMENT y CHECK

16. ¿Cuál de las siguientes definiciones encaja más con un Índice?

- a. Vista materializada con acceso optimizado  
- **b. Estructura auxiliar que optimiza la localización de registros** ✓  
- c. Copia ordenada de la tabla para consultas rápidas  
- d. Restricción que evita valores duplicados

17. ¿Qué diferencia hay entre usuario@localhost y usuario@'%' en MySQL?

- a. El segundo solo permite conexiones en modo lectura  
- b. Ambos representan exactamente el mismo usuario y acceso  
- **c. El segundo permite conexión desde cualquier host autorizado** ✓  
- d. El primero hereda automáticamente más privilegios

18. ¿Cuál de las siguientes restricciones NO puede ponerse a nivel de Columna?

- a. Foreign Key  
- **b. Unique** (marcado)  
- c. NOT NULL  
- d. Primary Key ✗

19. La sentencia ALTER pertenece al conjunto de instrucciones:

- **a. DDL** ✓  
- b. DAL  
- c. DCL  
- d. DML

20. ¿Cuál es una limitación habitual al usar restricciones CHECK a nivel de Columna?

- a. Se convierten automáticamente en índices  
- b. Solo funcionan en columnas numéricas  
- **c. No pueden hacer referencia a otras tablas** ✓  
- d. Ninguna es correcta ✗

## Unidad 4 - Modelo A - Test de Bases de Datos

1. ¿En qué caso es obligatorio usar GROUP BY en SQL?

- **a. Al mostrar columnas no agregadas junto a funciones de resumen.** ✓  
- b. Al filtrar columnas no agregadas junto a funciones de resumen.  
- c. Al unir columnas no agregadas junto a funciones de resumen.  
- d. Al ordenar columnas no agregadas junto a funciones de resumen.

2. ¿Cuál de las siguientes solamente sirve para datos numéricos?

- a. Min()  
- b. Count()  
- c. Max()  
- **d. Todas son falsas** ✓

3. ¿Cuál es la diferencia principal entre RIGHT JOIN y LEFT JOIN?

- a. RIGHT JOIN conserva todas las filas de la derecha, pero descarta las que no tienen coincidencia en la izquierda.  
- b. LEFT JOIN conserva todas las filas de la izquierda, pero descarta las que no tienen coincidencia en la derecha.  
- **c. LEFT JOIN conserva todas las filas de la izquierda, pero no descarta las que no tienen coincidencia en la derecha.** ✓  
- d. RIGHT JOIN conserva todas las filas de la izquierda, pero no descarta las que no tienen coincidencia en la derecha.

4. ¿Qué hace CONCAT() en MySQL?

- a. Combina partes de texto en columnas.  
- b. Agrupa fragmentos de cadena en bloques.  
- **c. Une varias cadenas en una sola.** ✓  
- d. Vincula textos separados en campos.

5. El uso de la cláusula WHERE corresponde la función de:

- **a. Selección** ✓  
- b. Eliminación  
- c. Unión  
- d. Proyección

6. *Nota: "Suponiendo que no quiere ver los null"*

- a. Where Columna in NULL  
- b. Where Columna not NULL  
- c. Where Columna = NULL ❌  
- **d. Ninguna es correcta** ✓

7. Si una tabla tiene 6 filas, una columna con 4 valores no NULL y 3 valores distintos, ¿qué devuelven COUNT(*), COUNT(columna) y COUNT(DISTINCT columna)?

- a. 4, 6, 3  
- b. 6, 6, 4  
- **c. 6, 4, 3** ✓  
- d. 4, 4, 3

8. ¿Qué operador se considera exclusivo del uso de subconsultas en SQL?

- a. EXISTS  
- b. IN  
- c. BETWEEN  
- **d. Ninguno es exclusivo** ✓

9. ¿Cuál es la diferencia principal entre UNION y UNION ALL en SQL?

- a. Unen varias tablas, pero UNION exige coincidencias y UNION ALL conserva todas las filas.  
- b. Combinan columnas de distintas tablas, pero UNION repite registros y UNION ALL los filtra.  
- c. Relacionan tablas por campos comunes, pero UNION muestra duplicados y UNION ALL los oculta.  
- **d. Unen los resultados de varias consultas, pero UNION elimina duplicados y UNION ALL los conserva.** ✓

10. ¿Qué condiciones se deben cumplir para poder usar USING en un INNER JOIN?

- a. No requiere coincidencias de nombres entre las columnas a unir entre ambas tablas.  
- **b. Debe coincidir los nombres de las columnas a unir entre ambas tablas.** ✓  
- c. No deben coincidir el nombre de las columnas de ninguna de las tablas a unir.  
- d. Debe coincidir solamente las columnas a unir entre ambas tablas.

11. ¿Cuándo resulta obligatorio asignar alias a una tabla?

- **a. Cuando comparte atributos con otra relación enlazada.** ✓  
- b. Cuando se reutiliza una columna en varias cláusulas.  
- c. Cuando la unión no puede resolverse con USING.  
- d. Cuando interviene con más de un papel en la consulta.

12. ¿Qué parte de una consulta básica determina el origen de los datos?

- **a. FROM** ✓  
- b. WHERE  
- c. SELECT  
- d. ORDER BY

13. ¿En cuál de los siguientes casos debe usarse HAVING en lugar de WHERE?

- a. Para mostrar el número de empleados de cada departamento situado en Madrid.  
- **b. Para mostrar los departamentos cuyo número de empleados sea mayor que 5.** ✓  
- c. Para mostrar el salario máximo de cada departamento con empleados activos.  
- d. Para mostrar la suma de salarios por departamento de los empleados con antigüedad mayor de 10 años.

14. ¿Qué función cumple la segunda columna en una cláusula ORDER BY con varias columnas?

- a. Reorganiza los registros de la primera columna cuando sus valores se repiten en varias filas.  
- **b. Establece por sí sola el orden de los registros que comparten el mismo valor en la primera columna.** ✓  
- c. Mantiene el orden de la primera columna, pero solo dentro de los grupos ya formados por ella.  
- d. Aplica un nuevo criterio de orden sin alterar el orden principal definido por la primera columna.

15. ¿Cuándo hace falta indicar la tabla delante de una columna?

- a. Cuando la tabla fue renombrada dentro de la consulta.  
- b. Cuando la columna se usa fuera del SELECT.  
- **c. Cuando sin esa referencia no queda claro de qué tabla sale.** ✓  
- d. Cuando dos columnas participan en la misma comparación.

16. ¿En cuál de las siguientes consultas DISTINCT no aporta ninguna utilidad?

- a. SELECT DISTINCT departamento FROM empleados;  
- **b. SELECT DISTINCT id_empleado FROM empleados;** ✓  
- c. SELECT DISTINCT ciudad FROM clientes;  
- d. SELECT DISTINCT categoria FROM productos;

17. ¿Qué debe aportar una subconsulta situada en SELECT para que la consulta sea válida?

- a. Una tabla con el mismo número de columnas.  
- b. Una lista ordenada de resultados relacionados.  
- **c. Un único dato por cada fila externa.** ✓  
- d. Un conjunto de valores compatible con IN.

18. ¿Por qué en una subconsulta con EXISTS suele escribirse SELECT 1?

- a. Porque EXISTS exige una subconsulta con una sola columna numérica.  
- b. Porque SELECT 1 hace que la subconsulta se convierta en escalar.  
- **c. Porque solo importa que la subconsulta devuelva alguna fila.** ✓  
- d. Porque EXISTS compara ese 1 con la condición externa.

19. ¿Qué ocurre cuando un CROSS JOIN combina dos tablas sin condición de unión?

- a. Las filas sin coincidencia se repiten en el resultado.  
- b. Las tablas se agrupan antes de formar la unión.  
- **c. Cada fila de una tabla se combina con todas las de la otra.** ✓  
- d. Los valores nulos se excluyen automáticamente.

20. ¿Qué diferencia mejor a LIKE frente a IN?

- a. LIKE no admite subconsultas; IN si.  
- **b. LIKE busca coincidencias en textos, IN comprueba pertenencia.** ✓  
- c. LIKE comprueba pertenencia en una lista, IN busca coincidencias en textos.  
- d. LIKE admite subconsultas; IN no.

---

## TEST PRACTICA 1 - TEMA 3

[Tema 3](https://forms.gle/uVw7jx3ZG9v3a98AA)

## TEST PRACTICA 1 - TEMA 4

[Tema 4](https://forms.gle/9YXs57hfKbaWb1Ly9)
