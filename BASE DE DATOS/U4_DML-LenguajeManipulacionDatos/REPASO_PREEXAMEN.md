# Repaso rápido para examen DML

## 1 - Qué es DML

- DML = Lenguaje de Manipulación de Datos (trabaja con los datos: consultar, insertar, actualizar, borrar).

## 2 - SELECT (consulta)

- `SELECT columnas FROM tabla;`  (usar `*` para todas las columnas)
- Alias: `SELECT columna AS alias`

## 3 - Filtrar filas (WHERE)

- `WHERE condición`
- Comparadores básicos: `=`, `<>`, `>`, `<`, `>=`, `<=`
- Operadores lógicos: `AND`, `OR`, `NOT`
- Conjuntos/patrones: `IN()`, `BETWEEN`, `LIKE`, `IS NULL`

## 4 - Ordenar (ORDER BY)

- `ORDER BY columna ASC|DESC`

## 5 - Agrupar y resumen

- `GROUP BY columna`
- Funciones: `COUNT()`, `SUM()`, `AVG()`, `MAX()`, `MIN()`
- Filtrar grupos: `HAVING condición`

## 6 - Unir tablas (JOIN)

- `INNER JOIN ... ON ...`: solo filas con coincidencia de las columnas indicadas.
- `LEFT JOIN ... ON ...`: todas las filas de la tabla izquierda + coincidencias de la tabla derecha (NULL cuando no hay match).
- `RIGHT JOIN ... ON ...`: todas las filas de la tabla derecha + coincidencias de la tabla izquierda (NULL cuando no hay match).
- `CROSS JOIN`: producto cartesiano (todas las combinaciones) — usar con cuidado.
- `USING(columna)`: forma corta de `ON t1.columna = t2.columna` cuando el nombre es el mismo.

## 7 - Combinar consultas

- `UNION`: une resultados sin duplicados (requiere mismo número de columnas y tipos compatibles).
- `UNION ALL`: une resultados con duplicados (más rápido cuando no interesa eliminar repetidos).
- Las columnas se emparejan por posición, no por nombre.
