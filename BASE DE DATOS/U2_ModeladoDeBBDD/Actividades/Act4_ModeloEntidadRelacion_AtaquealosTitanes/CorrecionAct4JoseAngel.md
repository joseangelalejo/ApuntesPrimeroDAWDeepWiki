# Correcciones Actividad 4 - Modelo Entidad-Relación Shingeki no Kyojin

## Entidades

1. Entidad Humanos
2. Entidad Titanes
3. Entidad Equipamiento Especial
4. Entidad Facción
5. Entidad Reinos
6. Entidad Eventos

## Atributos de las entidades

## Relaciones

1. Humanos
   1. Humanos utilizan Equipamiento Especial
   2. Humanos pertenecen a Facción
   3. Humanos participan en Eventos
   4. Humanos se transforman en Titanes
2. Titanes
   1. Titanes son transformaciones de Humanos
   2. Titanes participan en Eventos
3. Equipamiento Especial
   1. Equipamiento Especial es utilizado por Humanos
4. Facción
   1. Facción tiene Humanos
   2. Facción es controlada por Reinos
   3. Facción participa en Eventos
5. Reinos
   1. Reinos controlan Facciónes
6. Eventos
   1. Eventos tienen participación de Humanos
   2. Eventos tienen participación de Titanes
   3. Eventos tienen participación de Facciónes

### Participaciones de las relaciones

1. Humanos
   1. Humanos con Equipamiento Especial - 1 humano puede usar 0 o 1 equipamiento especial.
   2. Humanos pertenecen a Facción - 1 humano pertenece a 0 o 1 facción.
   3. Humanos participan en Eventos - 1 humano participa en 0 o N eventos.
   4. Humanos se transforman en Titanes - 1 humano puede transformarse en 0 o 1 titán (en realidad se 1 humano se puede transformar en más de un titan, pero el ejercicio no lo contempla).
2. Titanes
   1. Titanes son transformaciones de Humanos - 1 titán es la transformación de 1 humano.
   2. Titanes participan en Eventos - 1 titán participa en 0 o N eventos.
3. Equipamiento Especial
   1. Equipamiento Especial es utilizado por Humanos - 1 equipamiento especial puede ser usado por 0 o N humanos.
4. Facción
   1. Facción tiene Humanos - 1 facción tiene 1 o N humanos.
   2. Facción es controlada por Reinos - 1 facción es controlada por 0 o 1 reino.
   3. Facción participa en Eventos - 1 facción participa en 0 o N eventos.
5. Reinos
   1. Reinos controlan Facciónes - 1 reino controla 0 o 1 facciones. → **MAL → Corrección: 1 reino controla 1 o N facciones.**
6. Eventos
   1. Eventos tienen participación de Humanos - 1 evento tiene la participación de 0 o N humanos. → **MAL → Corrección**: 1 evento tiene la participación de mínimo 1 o N humanos.
   2. Eventos tienen participación de Titanes - 1 evento tiene la participación de 1 o N titanes.
   3. Eventos tienen participación de Facciónes - 1 evento tiene la participación de mínimo 1 y máximo 1 facciones; Aunque puede ser (1, N) y sería correcto.

### **CARDINALIDADES DE LAS RELACIONES:**

1. Humanos
   1. Humanos - Equipamiento Especial → 1:N
   2. Humanos - Facción → 1:N
   3. Humanos - Eventos → N:M
   4. Humanos - Titanes → 1:1
2. Titanes
   1. Titanes - Humanos → 1:1
   2. Titanes - Eventos → N:M
3. Equipamiento Especial
   1. Equipamiento Especial - Humanos → 1:N
4. Facción
   1. Facción - Humanos → 1:N
   2. Facción - Reinos → 1:1 → **MAL → Corrección: N:1**
   3. Facción - Eventos → N:M
5. Reinos
   1. Reinos - Facciónes → 1:N → **MAL → Corrección: N:1**
6. Eventos
   1. Eventos - Humanos → N:M → **BIEN**
   2. Eventos - Titanes → N:N → **MAL → Corrección N:M** Porque cuando hay dos N, la del lado débil se convierte a M.
   3. Eventos - Facciónes → 1:N → **BIEN** (aunque podría ser N:M).

#### FALLOS ENCONTRADOS

- Dos fallos menores en cardinalidades debido a no saber que cuando una cardinalidad es N:N , la del lado débil se convierte a M.
- Un fallo menor en la relación entre Reinos y Facciónes, donde en el lado debil indica (0, 1) cuando debería ser (0,N), pues un reino controla ninguna o varias facciones.

#### CORREGIDO → SI. Solo fallos menores

#### NOTA: 9.7/10
