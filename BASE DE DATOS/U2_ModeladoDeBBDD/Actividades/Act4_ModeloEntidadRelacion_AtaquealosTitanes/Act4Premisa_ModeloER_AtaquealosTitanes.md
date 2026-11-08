# PREMISA

## Modelo Entidad-Relación Ataque a los Titanes (Shingeki no Kyojin)

Shingeki No Kyojin
Necesitamos diseñar una Base de datos para la saga de Ataque a los Titanes. Se nos pide crear un modelo de entidad relación, para posteriormente pasarlo a modelo relacional, teniendo en cuenta la siguiente información:

En el mundo de Ataque a los titanes tenemos por un lado a los humanos y por otro a los titanes de los cuales deberemos conocer diferente información de cada uno de ellos.

De los humanos conocemos su nombre, género y edad, aparte para diferenciar a un humano de otro, al nacer a todos se les da un DNI que es único e intransferible. Algunos humanos utilizan equipamiento especial. De este equipamiento conocemos que se sabe su tipo y el número de serie que lo identifica de forma única. También se conoce la utilidad que tiene dicho equipamiento y la dificultad del mismo. No todos los humanos son capaces de utilizar equipamiento y los que usan solo consiguen usar uno. Un equipamiento puede no ser utilizado por nadie(está cogiendo polvo en una estantería) o que varios humanos lo usen.

Algunos humanos pertenecen a una facción, de estas conoceremos su nombre, objetivo e ideología , y como con estos datos somos incapaces de diferenciar unas de otras necesitaremos asignarles un código. Si un humano pertenece a una facción no podrá pertenecer a otra. Todas las facciones cuentan con al menos un integrante, pero por norma general cuentan con muchos.

Los reinos pueden tener bajo su control varias facciones, pero puede ser que no tengan ninguna facción bajo su control, en cambio las facciones o no están controladas por ningún reino o solo son controladas por uno. De los reinos conocemos su tamaño, nombre, poder y bandera. Siendo esta última algo único de un reino, es decir, jamás dos reinos tendrán la misma bandera.

Los Titanes son los otros seres que habitan el mundo, de ellos conocemos su tipo, tamaño, id y en algunos casos pueden contar con una habilidad especial, pero hay titanes que no tienen. Algunos humanos pueden transformarse en un titán, aunque hay humanos que no tienen esta capacidad, como es obvio un humano solo puede transformarse en un único titán y al revés pasa lo mismo.

Por último tenemos los eventos de los que nos conviene almacenar su fecha, la ubicación donde tienen lugar, la importancia que tuvieron y el nombre del evento, este último dato es único para cada evento por lo que es imposible encontrar dos eventos con el mismo nombre. En los eventos pueden haber varios o ningún titán involucrados, y también un mismo titán puede haberse encontrado involucrado en varios eventos distintos o no haberse involucrado en ninguno. Con los humanos pasa lo mismo, estos pueden aparecer en ningún evento o varios, y en un mismo evento siempre habrá algún humano pero por norma general aparecen varios. Las facciones también suelen participar en los eventos, una facción puede participar en varios eventos diferentes o no ser partícipe de ningún evento. Pero las facciones por motivos de protocolo, si tiene lugar un evento siempre habrá una facción y las demás facciones no podrán participar si ya hay una facción en dicho evento.
