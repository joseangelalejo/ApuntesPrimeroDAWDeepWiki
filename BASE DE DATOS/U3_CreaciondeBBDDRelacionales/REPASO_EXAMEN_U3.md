# **U3 - REPASO | Creación de BBDD Relacionales**

## **1. SQL - CONCEPTOS**

| **SUBLENGUAJE** | **FUNCIÓN**        | **OPERACIONES**                |
|-----------------|--------------------|--------------------------------|
| **DDL**         | Define estructura  | CREATE, ALTER, DROP            |
| **DML**         | Manipula datos     | SELECT, INSERT, UPDATE, DELETE |
| **DCL**         | Gestiona seguridad | GRANT, REVOKE                  |

## **2. DDL - CREACIÓN**

| **OPERACIÓN**      | **SINTAXIS**                                   | **NOTA**                            |
|--------------------|------------------------------------------------|-------------------------------------|
| **BD**             | `CREATE DATABASE nombre; USE nombre;`          | Imprescindible USE                  |
| **Tabla**          | `CREATE TABLE tabla (col tipo restricciones);` | Mínimo PK                           |
| **PK**             | `PRIMARY KEY`                                  | Único, no NULL, identifica registro |
| **FK**             | `FOREIGN KEY`                                  | Relación con otra tabla             |
| **UNIQUE**         | `UNIQUE`                                       | Valores únicos, acepta NULL         |
| **NOT NULL**       | `NOT NULL`                                     | Prohibe nulos                       |
| **CHECK**          | `CHECK (condición)`                            | Limita rango                        |
| **DEFAULT**        | `DEFAULT valor`                                | Valor automático                    |
| **AUTO_INCREMENT** | `AUTO_INCREMENT`                               | Incrementa sin especificar          |

## **3. TIPOS DE DATOS**

| **CATEGORÍA**  | **TIPOS**                       | **EJEMPLO**             |
|----------------|---------------------------------|-------------------------|
| **Enteros**    | TINYINT, SMALLINT, INT, BIGINT  | IDs (INT, BIGINT)       |
| **Decimales**  | DECIMAL(m,d), FLOAT, DOUBLE     | Dinero: DECIMAL         |
| **Texto**      | CHAR(n), VARCHAR(n), TEXT       | Nombres, descripciones  |
| **Fecha/Hora** | DATE, TIME, DATETIME, TIMESTAMP | Fechas: DATE            |
| **Booleano**   | BOOLEAN (= TINYINT(1))          | 0/1                     |
| **JSON**       | JSON                            | Datos semiestructurados |

---

## **4. OPERACIONES DDL**

| **OPERACIÓN**     | **SINTAXIS**                                       |
|-------------------|----------------------------------------------------|
| **ALTER ADD**     | `ALTER TABLE tabla ADD columna tipo;`              |
| **ALTER DROP**    | `ALTER TABLE tabla DROP COLUMN columna;`           |
| **ALTER MODIFY**  | `ALTER TABLE tabla MODIFY columna INT NOT NULL;`   |
| **ALTER CHANGE**  | `ALTER TABLE tabla CHANGE old_name new_name tipo;` |
| **DROP TABLE**    | `DROP TABLE nombre;`                               |
| **DROP DATABASE** | `DROP DATABASE nombre;`                            |
| **DROP VIEW**     | `DROP VIEW nombre;`                                |
| **DROP INDEX**    | `DROP INDEX idx ON tabla;`                         |

---

## **5. ÍNDICES Y VISTAS**

| **CONCEPTO** | **DEFINICIÓN**       | **VENTAJAS/DESVENTAJAS**    |
|--------------|----------------------|-----------------------------|
| **Índice**   | Atajo para búsquedas | ✓ Velocidad \| ✗ Memoria    |
| **Vista**    | Tabla virtual        | ✓ Simplifica \| No almacena |

---

## **6. DCL - CONTROL DE ACCESO**

| **OPERACIÓN**   | **SINTAXIS**                                          |
|-----------------|-------------------------------------------------------|
| **CREATE USER** | `CREATE USER 'user'@'localhost' IDENTIFIED BY 'pwd';` |
| **DROP USER**   | `DROP USER 'user'@'localhost';`                       |
| **GRANT**       | `GRANT SELECT, INSERT ON db.* TO 'user'@'localhost';` |
| **REVOKE**      | `REVOKE INSERT ON db.tabla FROM 'user'@'localhost';`  |
| **CREATE ROLE** | `CREATE ROLE nombre_rol;`                             |

**Niveles:** Global (todas BBDD) \| Base datos (una BD) \| Tabla \| Columna

---

## **7. INTEGRIDAD REFERENCIAL**

| **OPCIÓN**   | **COMPORTAMIENTO**             |
|--------------|--------------------------------|
| **CASCADE**  | Elimina registros dependientes |
| **SET NULL** | FK = NULL                      |
| **RESTRICT** | Prohibe eliminación            |

---

## **CLAVE: CONSTRAINTS NOMBRADOS**

```sql
CONSTRAINT pk_id PRIMARY KEY (id)
CONSTRAINT uk_email UNIQUE (email)
CONSTRAINT ck_edad CHECK (edad >= 18)
CONSTRAINT fk_depto FOREIGN KEY (id_depto) REFERENCES departamentos(id)
```

---

## **QUIZ RÁPIDO**

✓ DDL define, DML manipula, DCL gestiona  
✓ PK = único+no NULL (1/tabla) \| UNIQUE = único (múltiples NULL)  
✓ FK = integridad referencial \| CASCADE = elimina dependientes  
✓ DECIMAL para dinero, FLOAT para aproximado  
✓ Índices = velocidad búsqueda + consume memoria  
✓ Vistas = tabla virtual, simplifica, no almacena  
✓ ALTER MODIFY = tipo/restricciones \| CHANGE = renombra+modifica
