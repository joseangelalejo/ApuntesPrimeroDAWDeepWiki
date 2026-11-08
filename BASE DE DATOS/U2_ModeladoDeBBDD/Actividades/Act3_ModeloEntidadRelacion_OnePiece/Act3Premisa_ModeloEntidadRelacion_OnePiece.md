# PREMISA

## Modelo Entidad-Relación One-Piece

En el mundo de one piece tenemos piratas y marines de los cuales deberemos conocer diferente información de cada uno de ellos. De los piratas los datos más relevantes son su nombre y estatus. Algunos piratas cuentan con una recompensa por su captura, pero hay piratas que no tienen recompensa puesta a su cabeza. Como no tenemos ninguna información que identifique de forma única a un pirata, los registraremos con una id que los diferencie.

Todos los piratas existentes pertenecen a una única banda que por lo general está compuesta por al menos un integrante, aunque suele tener más de un integrante. De las bandas se sabe su apodo, fecha de fundación y la bandera que los diferencia de las otras bandas(ya que cada bandera es única e irrepetible). También será necesario almacenar la cantidad de territorios que posee una banda. Las bandas cuentan como mínimo con un barco para navegar. Pero como algunas son muy numerosas pueden tener muchos barcos en su poder, en cambio un barco solo puede pertenecer a una única banda. De estos barcos conoceremos su tamaño, armamento y resistencia, y ya que no podemos con estos datos diferenciar unos de otros necesitaremos darle una identificación única a cada barco

Los marines por lo general se dedican a perseguir a los piratas. Debido a que existen piratas que ni siquiera la marina conoce su existencia, hay piratas que no son perseguidos por ningún marine, pero en cambio otros son perseguidos por varios marines, al igual que hay marines que persiguen a varios piratas y otros que no persiguen a ninguno.

Todos los marines son identificados al alistarse con un Nº de marine, que jamás cambia ni se repite, también cuentan con un rango y se conoce tanto su edad como su nombre.

Tanto los piratas como los marines pueden utilizar armas, hay piratas y marines que no utilizan ningún arma(pelean a puñetazos limpios), y otros que utilizan varias armas a la vez. Pero en cambio cada arma es única para cada portador(Si la usa un marine otro marine no puede usarla, y si es usada por un pirata otro pirata no la usará). Existen armas que no son usadas por nadie. De las armas conocemos su dificultad, el tipo que es, su id(es único) y algunas armas cuentan con un rango.

Por último tenemos las denominadas “frutas del demonio”, estas pueden ser consumidas tanto por piratas como por marines, pero son tan peligrosas que hay marines y piratas que no las consumen. Estas frutas son únicas por lo que cada una de ellas solo pueden ser consumidas por una persona(entiéndase persona como un marine o un pirata), y nadie puede consumir más de una fruta. De las frutas sabemos el tipo, modelo, poder que tienen y su nombre. Como solo existe un ejemplar de cada fruta, su nombre las identifica de forma única.
