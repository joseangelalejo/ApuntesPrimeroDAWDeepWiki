# Practicando Simulacro Práctico

## Teoría

```markdown
### Tipos de Atributos en Modelado de Bases de Datos

- **Atributos Simples**: Indivisibles en subpartes significativas. Ejemplo: "Nombre", "Edad".
- **Atributos Compuestos**: **Divisibles en subpartes significativas**. Ejemplo: "Nombre Completo" puede dividirse en "Nombre" y "Apellido".
- **Atributos Obligatorios**: **Siempre tendrán un valor, nunca quedarán vacíos**.
- **Atributos Opcionales**: **Pueden o no tener un valor asignado** para cada instancia de la entidad. Ejemplo: "Teléfono Secundario" en una entidad "Empleado".
- **Atributos Derivados**: **Se pueden calcular o derivar a partir de otros atributos**. Ejemplo: "Edad" puede derivarse de "Fecha de Nacimiento".
- **Atributos Multivaluados**: **Pueden tener múltiples valores para una misma entidad**. Ejemplo: "Teléfonos" de un "Empleado" puede tener varios números de teléfono asociados.
- **Atributos Clave**: **Se utilizan para identificar de manera única una entidad dentro de un conjunto**. Por ejemplo, "ID_Empleado" es un atributo clave para la entidad "Empleado".

### Notación de Chen en Diagramas ER

1. **Entidades**: Representadas por rectángulos.
2. **Atributos**: Representados por óvalos conectados a sus respectivas entidades.
   - Atributos **Clave**: Óvalo con contenido subrayado.
   - Atributos **Multivaluados**: Óvalo doble.
   - Atributos **Derivados**: Óvalo punteado con línea entera.
   - Atributo **Opcional**: Óvalo entero con línea punteada.
   - Atributo **Compuesto**: Óvalo doble con sub-ovalos conectados.
   - Atributo **Simple**: Óvalo entero.
3. **Relaciones**: Representadas por rombos conectados a las entidades involucradas.
4. **Participacion**: La participación de una entidad se coloca sobre la línea continua que conecta la entidad con la relación, en el lado contrario a la entidad que participa. Se indica con formato (X,Y) donde X es el mínimo y Y es el máximo número de instancias que pueden participar en la relación. Pueden ser:
   - (0,1): Cero o uno.
   - (1,1): Exactamente uno.
   - (0,N): Cero o muchos.
   - (1,N): Uno o muchos.
5. **Cardinalidad**: Se indica junto al rombo de la relación que conecta las entidades. Especifica el número máximo de instancias de una entidad que pueden estar asociadas con una instancia de otra entidad en la relación. Se representa con formato (X:Y), donde X es el máximo de una entidad, e Y es el máximo de la otra entidad. Pueden ser:
   - (1:N): Uno a muchos.
   - (1:1): Uno a uno. Puede estar formado por participaciones:
     - (1,1) y (0,1)
     - (1,1) y (1,1)
     - (0,1) y (0,1)
   - (N:M): Muchos a muchos.

### Adaptación de Diagramas ER a Esquemas Relacionales

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
```

---
<div style="page-break-after: always;"></div>

## Preguntas de Repaso 1 - Referencia a tipos de atributos, notación Chen básica y adaptación inicial (líneas 4-55)

1. ¿Qué es un atributo compuesto? Da un ejemplo.
2. Explica la diferencia entre un atributo obligatorio y uno opcional.
3. ¿Cómo se representan los atributos multivaluados en la notación de Chen?
4. Describe la cardinalidad (0,1) en una relación.
5. ¿Qué significa participación en una relación ER? Da un ejemplo.
6. En la adaptación a esquemas relacionales, ¿cómo se manejan las relaciones 1:N?
7. Para una relación 1:1 con participaciones (1,1) y (0,1), ¿dónde se coloca la FK?
8. ¿Cuándo se crea una tabla intermedia en relaciones N:M?
9. ¿Por qué no se incluyen atributos derivados en las tablas relacionales?
10. Transforma la siguiente entidad en una tabla relacional: Entidad 'Empleado' con atributos: ID_Empleado (clave), Nombre (compuesto: Nombre, Apellido), Teléfonos (multivaluado), Salario (opcional).

### Respuestas

1. Es un atributo compuesto por varios atributos simples. Por ejemplo, un atributo compuesto "Dirección" puede dividirse en atributos simples: Calle, Tipo Via, Número_Portal, Código_Postal. Entre otros
2. Un atributo obligatorio es un atributo que siempre tendrá un valor, nunca quedará vacío. Pueden ser o no ser atributos claves. Por ejemplo, en una entidad DNI, Nombre y Apellidos serán atributos obligatorios.
Un atributo opcional no siempre tendrá un valor asignado. Por ejemplo, en una entidad Contacto, "Telefono 1" será un atributo simple u obligatorio, pero "Telefono2" puede ser opcional, según las necesidades de la BBDD
3. Con un óvalo doble. Por ejemplo, un atributo multivaluado "Teléfonos" puede tener varios teléfonos a la vez para una misma ocurrencia de una entidad
4. (Saltada por confusión)
5. La participación en una relación se refiere a con qué minimo y con qué maximo participa una entidad en una relación. Por ejemplo, si una entidad Jugador aporta (1,N) en la relación Jugador_Juega_Juegos, eso significa que el jugador juega mínimo 1 y máximo muchos juegos
6. La PK de la entidad situada en el lado 1 se exporta como fk a la tabla/entidad del lado muchos(N)
7. La pk del lado 0,1 se exporta como fk al lado que aporta 1,1
8. En la práctica siempre, porque es lo más aconsejable. Lo que se hace es crear la tabla intermedia que representa la relación, y a esa tabla se le crea una PK propia, y se exportan las PK de ambas entidades participantes en la relación como FK a la tabla intermedia. Por último, si la relación tiene algún atributo propio, se agrega a la tabla intermedia.
9. Porque se pueden generar más tarde cuando se hagan consultas. Por ejemplo, si tenemos la cantidad de disparos de un jugador y tenemos la cantidad de disparos acertados, podemos generar mediante consulta el "% aciertos"
10. Sería:
    1. Tabla Empleado.
       1. PK: ID_Empleado.
       2. Atributos:
          1. Nombre (NOT_NULL)
          2. Apellido (NOT_NULL)
          3. Salario
    2. Tabla Teléfonos
       1. PK: ID_Telefonos
       2. Atributo: Teléfono (Obligatorio, Simple) (NOT_NULL)
    3. Tabla Empleado_Tienen_Teléfonos (representa la relación entre Empleado y Teléfonos, donde Empleado aporta (1,N) y Teléfonos aporta (0,1) y por tanto la cardinalidad sería 1:N)
       1. PK: Empleado_Tienen_Teléfonos
       2. FK: ID_Empleado, ID_Telefonos

## Preguntas de Repaso 2 - Referencia a notación Chen completa y adaptación a relacionales (líneas 4-55)

1. ¿Cómo se representan las entidades en la notación de Chen?  
   a) Rectángulos ✓ <- Yo  
   b) Óvalos  
   c) Rombos  
2. ¿Qué símbolo se usa para atributos clave en Chen?  
   a) Óvalo doble  
   b) Óvalo subrayado ✓ <- Yo  
   c) Óvalo punteado  
3. Verdadero o falso: Los atributos multivaluados se representan con óvalos dobles.  
   Verdadero ✓ <- Yo  
4. ¿Cuál es el significado de la cardinalidad (0,N)?  
   a) Exactamente uno  
   b) Cero o uno  
   c) Cero o muchos ✓ <- Yo  
5. ¿Dónde se indica la participación en una relación ER según Chen?  
   a) Dentro del rombo  
   b) Sobre la línea de conexión ✓ <- Yo  
   c) En los óvalos  
6. En la adaptación a esquemas relacionales, ¿qué se hace con atributos compuestos?  
   a) Se eliminan  
   b) Se descomponen en atributos simples ✓ <- Yo  
   c) Se convierten en tablas  
7. ¿Cómo se manejan las relaciones 1:N en la adaptación?  
   a) Se crea una tabla intermedia  
   b) La PK del lado 1 se añade como FK en el lado N ✓ <- Yo  
   c) Se fusionan las tablas  
8. Para una relación 1:1 con participaciones (1,1) y (0,1), ¿dónde se coloca la FK?  
   a) En cualquiera de las dos tablas  
   b) En la tabla del lado (1,1) ✓ <- Yo  
   c) En una tabla intermedia  
9. ¿Se incluyen atributos derivados en las tablas relacionales?  
   a) Sí, siempre  
   b) No, se calculan en consultas ✓ <- Yo  
   c) Solo si son obligatorios  
10. ¿Qué se crea para relaciones N:M en la adaptación?  
    a) Una FK directa  
    b) Una tabla intermedia con PK propia ✓ <- Yo  
    c) Se duplican las entidades  
11. Verdadero o falso: Las entidades se transforman en tablas con su PK como PK de la tabla.  
    Verdadero ✓ <- Yo  
12. ¿Cómo se representan las relaciones en Chen?  
    a) Rectángulos  
    b) Rombos ✓ <- Yo  
    c) Óvalos  
13. ¿Qué tipo de atributo se representa con óvalo punteado?  
    a) Multivaluado  
    b) Derivado ✓ <- Yo  
    c) Compuesto  
14. ¿Cuál es la cardinalidad (1,N)?  
    a) Uno o muchos ✓ <- Yo  
    b) Cero o uno  
    c) Exactamente uno  
15. En relaciones 1:1 con (0,1) y (0,1), ¿qué se hace?  
    a) FK en una tabla  
    b) Tabla intermedia ✓ <- Yo  
    c) Se fusionan las tablas  
16. ¿Qué se hace con atributos opcionales en la adaptación?  
    a) Se eliminan  
    b) Se permiten valores nulos ✓ <- Yo  
    c) Se convierten en obligatorios  
17. Verdadero o falso: Para N:M, la tabla intermedia incluye las PKs de ambas entidades como FKs.  
    Verdadero ✓ <- Yo  
18. ¿Cómo se indica un atributo opcional en Chen?  
    a) Óvalo doble  
    b) Óvalo con línea punteada ✓ <- Yo  
    c) Óvalo subrayado  
19. ¿Qué se hace con atributos multivaluados en la adaptación?  
    a) Se ignoran  
    b) Se separan en nuevas tablas ✓ <- Yo  
    c) Se convierten en simples  
20. ¿Dónde se coloca la FK en relaciones 1:N?  
    a) En el lado 1  
    b) En el lado N ✓ <- Yo  
    c) En ambas

---
<div style="page-break-after: always;"></div>

## Preguntas de Repaso 3 - Referencia a notación Chen (participación, cardinalidad, atributos) (líneas 16-38)

1. ¿Cuáles de los siguientes se representan con óvalos en la notación de Chen? (Selección múltiple)  
    a) Entidades  
    b) Atributos ✓ <- Yo  
    c) Relaciones  
    d) Todas son correctas  
    e) Ninguna es correcta  
2. Verdadero o falso: Las entidades se representan con rectángulos en Chen.  
    Verdadero ✓ <- Yo  
3. ¿Cómo se representan los atributos compuestos en Chen?  
    a) Óvalo doble con sub-ovalos conectados ✓ <- Yo  
    b) Óvalo punteado  
    c) Óvalo subrayado  
    d) Todas son correctas  
    e) Ninguna es correcta  
4. ¿Dónde se indica la participación en un diagrama ER de Chen?  
    a) Dentro del rombo  
    b) Sobre la línea de conexión ✓ <- Yo  
    c) En los óvalos  
    d) Todas son correctas  
    e) Ninguna es correcta  
5. Verdadero o falso: Los atributos simples se representan con óvalos enteros.  
    Verdadero ✓ <- Yo  
6. ¿Qué representa un rombo en Chen?  
    a) Entidad  
    b) Atributo  
    c) Relación ✓ <- Yo  
    d) Todas son correctas  
    e) Ninguna es correcta  
7. ¿Cuáles de los siguientes son tipos de atributos en Chen? (Selección múltiple)  
    a) Clave  
    b) Multivaluado  
    c) Derivado  
    d) Opcional  
    e) Todas son correctas ✓ <- Yo  
8. Verdadero o falso: La participación se indica con líneas continuas en Chen.  
    Verdadero  
    Falso ✓ <- Yo  
    Justificación: Se indica sobre las líneas continuas con formato (X,Y).  
9. ¿Cómo se representa un atributo derivado?  
    a) Óvalo doble  
    b) Óvalo punteado ✓ <- Yo  
    c) Óvalo subrayado  
    d) Todas son correctas  
    e) Ninguna es correcta  
10. ¿Qué significa la participación (0,1) en Chen?  
    a) Exactamente uno  
    b) Cero o uno ✓ <- Yo  
    c) Uno o muchos  
    d) Todas son correctas  
    e) Ninguna es correcta  
11. Verdadero o falso: Los atributos opcionales se representan con óvalos con línea punteada.  
    Verdadero ✓ <- Yo  
12. ¿Dónde se conectan los atributos en un diagrama ER de Chen?  
    a) Al rombo  
    b) A la entidad  
    c) A la relación  
    d) Todas son correctas  
    e) Ninguna es correcta ✓ <- Yo  
    Justificación: Depende, si es un atributo de entidad entonces sería B. Si es un atributo de relación entonces sería C.  
13. ¿Cuáles de las siguientes participaciones existen en Chen? (Selección múltiple)  
    a) (0,1)  
    b) (1,1)  
    c) (0,N)  
    d) (1,N)  
    e) Todas son correctas ✓ <- Yo  
14. Verdadero o falso: Las relaciones conectan entidades mediante líneas.  
    Verdadero ✓ <- Yo  
15. ¿Qué se usa para representar entidades en Chen?  
    a) Óvalos  
    b) Rectángulos ✓ <- Yo  
    c) Rombos  
    d) Todas son correctas  
    e) Ninguna es correcta  
16. ¿Cómo se indica un atributo multivaluado en Chen?  
    a) Óvalo doble ✓ <- Yo  
    b) Óvalo punteado  
    c) Óvalo subrayado  
    d) Todas son correctas  
    e) Ninguna es correcta  
17. Verdadero o falso: La participación se indica cerca de las conexiones entre entidades y relaciones.  
    Verdadero ✓ <- Yo  
18. ¿Qué representa un óvalo doble en Chen?  
    a) Atributo compuesto  
    b) Atributo multivaluado ✓ <- Yo  
    c) Atributo derivado  
    d) Todas son correctas  
    e) Ninguna es correcta  
19. ¿Dónde se coloca la participación en Chen?  
    a) Dentro del óvalo  
    b) Sobre la línea de conexión ✓ <- Yo  
    c) En el rombo  
    d) Todas son correctas  
    e) Ninguna es correcta  
20. Verdadero o falso: Los atributos clave se representan con óvalos subrayados.  
    Verdadero ✓ <- Yo

## Preguntas de Repaso 4 - Referencia a adaptación de diagramas ER a esquemas relacionales (líneas 39-55)

1. Verdadero o falso: Las entidades se transforman en tablas con su clave primaria como clave primaria de la tabla.
    Verdadero ✓ <- Yo
2. ¿Qué se hace con los atributos multivaluados en la adaptación a esquemas relacionales?
   a) Se eliminan
   b) Se separan en nuevas tablas ✓ <- Yo
   c) Se convierten en obligatorios
   d) Todas son correctas
   e) Ninguna es correcta
3. ¿Cómo se manejan los atributos compuestos en la adaptación?
   a) Se eliminan
   b) Se descomponen en atributos simples ✓ <- Yo
   c) Se convierten en tablas
   d) Todas son correctas
   e) Ninguna es correcta
4. Verdadero o falso: Los atributos derivados se incluyen en las tablas relacionales.
    Falso ✓ <- Yo
5. ¿Qué se permite con los atributos opcionales en la adaptación?
   a) Se eliminan
   b) Se permiten valores nulos ✓ <- Yo
   c) Se convierten en obligatorios
   d) Todas son correctas
   e) Ninguna es correcta
6. ¿Cómo se manejan las relaciones 1:N en la adaptación?
   a) Se crea una tabla intermedia
   b) La PK del lado 1 se añade como FK en el lado N ✓ <- Yo
   c) Se fusionan las tablas
   d) Todas son correctas
   e) Ninguna es correcta
7. Para una relación 1:1 con participaciones (1,1) y (0,1), ¿dónde se coloca la FK?
   a) En cualquiera de las dos tablas
   b) En la tabla del lado (1,1) ✓ <- Yo
   c) En una tabla intermedia
   d) Todas son correctas
   e) Ninguna es correcta
8. ¿Qué se hace en relaciones 1:1 con participaciones (1,1) y (1,1)?
   a) FK en una tabla
   b) FK puede colocarse en cualquiera de las dos tablas ✓ <- Yo
   c) Tabla intermedia
   d) Todas son correctas
   e) Ninguna es correcta
9. Para relaciones 1:1 con (0,1) y (0,1), ¿qué se crea?
   a) Una FK directa
   b) Una tabla intermedia con PK propia ✓ <- Yo
   c) Se duplican las entidades
   d) Todas son correctas
   e) Ninguna es correcta
10. Verdadero o falso: En relaciones N:M, se crea una tabla intermedia con PK propia.
    Verdadero ✓ <- Yo
11. ¿Qué se añade como FKs en la tabla intermedia de relaciones N:M?
    a) Las PKs de ambas entidades ✓ <- Yo
    b) Solo la PK de una entidad
    c) Atributos derivados
    d) Todas son correctas
    e) Ninguna es correcta
12. Verdadero o falso: Si una relación tiene atributos propios, se incluyen en la tabla intermedia en N:M.
    Verdadero ✓ <- Yo
13. ¿Qué se hace con atributos multivaluados en la adaptación? (Selección múltiple)
    a) Se separan en nuevas tablas ✓ <- Yo
    b) Se permiten valores nulos
    c) Se convierten en simples
    d) Todas son correctas
    e) Ninguna es correcta
14. En relaciones 1:N, ¿dónde se coloca la FK?
    a) En el lado 1
    b) En el lado N ✓ <- Yo
    c) En ambas
    d) Todas son correctas
    e) Ninguna es correcta
15. Verdadero o falso: Los atributos compuestos se descomponen en sus atributos simples constituyentes.
    Verdadero ✓ <- Yo
16. ¿Qué no se incluye en las tablas relacionales?
    a) Atributos obligatorios
    b) Atributos derivados ✓ <- Yo
    c) Atributos clave
    d) Todas son correctas
    e) Ninguna es correcta
17. Para relaciones 1:1 con (1,1) y (0,1), la FK se coloca en:
    a) La tabla del lado (1,1) ✓ <- Yo
    b) La tabla del lado (0,1)
    c) Una tabla intermedia
    d) Todas son correctas
    e) Ninguna es correcta
18. Verdadero o falso: En N:M, la tabla intermedia incluye las PKs de ambas entidades como FKs.
    Verdadero ✓ <- Yo
19. ¿Qué se crea para representar relaciones N:M?
    a) Una FK directa
    b) Una tabla intermedia ✓ <- Yo
    c) Se fusionan las tablas
    d) Todas son correctas
    e) Ninguna es correcta
20. Verdadero o falso: Los atributos opcionales permiten valores nulos en las tablas.
    Verdadero ✓ <- Yo
