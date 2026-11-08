# Colas2: túnel de lavado

Un túnel de lavado dispone de una zona de espera donde los vehículos se colocan en una cola para ser atendidos. Los clientes que disponen de una tarjeta Premium tienen prioridad y su vehículo se coloca al principio de la cola, mientras que los clientes normales se colocan al final.  

Clase Vehiculo
Crear una clase Vehiculo con los siguientes atributos:

    matricula (String)
    marca (String)
    modelo (String)
    premium (boolean)

La clase debe incluir:

    Constructor.
    Getters.
    Método toString().

Programa principal
Mostrar un menú con las siguientes opciones:

1. Registrar vehículo

- Solicitar:
  - Matrícula.
  - Marca.
  - Modelo.
  - Si el cliente es Premium (S/N).

Crear el objeto Vehiculo.

- Si es Premium, añadirlo al principio de la cola.
- Si no es Premium, añadirlo al final.

Mostrar un mensaje indicando que el vehículo ha sido registrado.

1. Lavar siguiente vehículo

Atender al primer vehículo de la cola.

Mostrar los datos del vehículo que entra al túnel de lavado.

Si no hay vehículos en espera, informar al usuario.

3. Mostrar siguiente vehículo

Mostrar el vehículo que será lavado a continuación sin eliminarlo de la cola.

4. Mostrar todos los vehículos en espera

Mostrar la cola completa en orden de lavado.

5. Mostrar último vehículo de la cola

6. Mostrar qué vehículo será el último en ser lavado.

7. Salir
