# Premisa Actividad 3: Métodos estáticos Gestión de un Parking

El proyecto debe contener dos paquetes:

- parking
- calculos

Y tres clases:

- DatosParking, que pertenecerá al paquete parking.
- CalculosParking, que pertenecerá al paquete calculos.
- ProgramaPrincipal, que también pertenecerá al paquete parking.

La clase DatosParking contendrá métodos estáticos que devuelvan información sobre el estado del parking. Deberá incluir los siguientes métodos:

- plazasLibres(int plazasTotales, int plazasOcupadas), que devuelve el número de plazas libres.
- parkingCompleto(int plazasTotales, int plazasOcupadas), que devuelve true si el parking está completo y false en caso contrario.
- estadoParking(int plazasTotales, int plazasOcupadas), que devuelve un String con uno de los siguientes valores: "COMPLETO", "CASI COMPLETO" si quedan cinco plazas o menos, o "DISPONIBLE".

La clase CalculosParking contendrá métodos estáticos con lógica de cálculo. Deberá incluir los siguientes métodos:

- esEstanciaLarga(int horas), que devuelve true si la estancia es de cinco horas o más.
- calcularPrecio(int horas), que devuelve el precio a pagar en función de las horas y que debe utilizar internamente el método esEstanciaLarga para decidir qué tarifa aplicar. La tarifa normal para estancias cortas será de dos euros la primera hora y uno con cinco euros cada hora adicional, y la tarifa reducida para estancias largas será de uno con cinco euros la primera hora y un euro cada hora adicional.
- porcentajeOcupacion(int plazasTotales, int plazasOcupadas), que devuelve el porcentaje de ocupación del parking como un valor double.

La clase ProgramaPrincipal contendrá el método main y será la única clase que muestre información por pantalla. Desde el método main se definirán valores fijos para el número de plazas totales, el número de plazas ocupadas y las horas de estancia, se llamará a los métodos de las clases DatosParking y CalculosParking, y se mostrará por pantalla el número de plazas libres, el estado del parking, el porcentaje de ocupación, si la estancia es larga o corta y el precio final a pagar.
