# Apuntes Examen Práctico José Ángel Alejo Sillero

Modelos conceptuales **Entidad-Relación (ER) - Notación de Chen**

![Notacion de Chen Entidades, Atributos y Relaciones](Imagenes\NotacionCHEN\NotacionAtributosEntidadesRelaciones.png)

Consideraciones para transformación de modelos ER a modelos Lógico-Relacionales:

1. **Entidades** se transforman en tablas. La clave primaria (PK) de la entidad se convierte en la PK de la tabla.
2. **ATRIBUTOS:**
   1. Los **atributos multivaluados** se separan en nuevas tablas, permitiendo registrar varios valores para una misma entidad.
   2. Los **atributos compuestos** se descomponen en sus atributos simples constituyentes.
   3. Los **atributos derivados** no se incluyen en las tablas, ya que pueden calcularse a partir de otros atributos cuando sea necesario.
   4. Los **atributos opcionales** se permiten tener valores nulos en la tabla.
3. **RELACIONES**:
   1. **Relaciones uno a muchos (1:N)**: La PK de la tabla/entidad situada en el lado "uno" (1) se añade como FK en la tabla/entidad del lado "muchos" (N).
   2. **Relaciones uno a uno (1:1)**: La PK de una de las tablas se añade como FK en la otra tabla, **dependiendo de las participaciones de cada entidad**. Para ello, tenemos los siguientes casos:
      - **(1,1) y (0,1)** → **FK se coloca en la tabla de la entidad con participación (1,1)**.
      - **(1,1) y (1,1)** → **FK puede colocarse en cualquiera de las dos tablas**.
      - **(0,1) y (0,1)** → **La relación se representará mediante una tabla intermedia con PK propia, y se exportan las PKs de ambas entidades como FKs**. Si la relación tiene atributos propios, se incluirán en la tabla intermedia.
   3. **Relaciones muchos a muchos (N:M)**: Se **crea una tabla intermedia** que representa la relación, se **crea una PK para la tabla** y luego se **añaden como FKs las PKs de las dos tablas relacionadas**. Se debe tener en cuenta:
      - Si la relación tiene atributos propios, se incluirán en la tabla intermedia.
