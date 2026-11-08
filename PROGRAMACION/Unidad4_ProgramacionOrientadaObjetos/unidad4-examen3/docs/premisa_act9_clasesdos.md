# Actividad 9: Clases dos

Crea una clase Vehiculos que defina objeto de este tipo, para ello tendrán que tener los siguientes atributos:

- tipovehículo (1.-moto, 2.- coche, 3.- eléctrico, 4.- camioneta)
- matricula
- consumo (litros a los 100km)
- nplazas
- antiguedad (en años)
- itv (indicará si este año pasó ya la itv)
- tara que soporta el vehículo (kg)

Esta clase tendrá los siguientes constructores:

- un constructor que permita crear un objeto asignado todos los valores.
- otro para las motos, al usar este constructor no hará falta pasar el tipo de vehículo y automáticamente se asignará el tipo de vehículo a moto y nplazas a dos, así mismo la tara será 0.
- otro para eléctricos, al usar este constructor no hará falta pasar el tipo de vehículo y el consumo se pondrá a 0.

Así mismo crear los siguientes métodos:

- un método, pasaritv, que devuelva si este año es necesario pasar la itv. Para ello tener en cuenta qué vehículo es y si ya paso este año la itv con anterioridad.
- un método, cargalibre, al que se le pase la carga actual del vehículo y devuelva que carga podemos aún poner.
- un método, autonomia, que pasandole los litros que tiene en el depósito nos devuelva cuantos km nos quedan.

Además crea los get de todos los atributos y los set solo para matricula e itv.
