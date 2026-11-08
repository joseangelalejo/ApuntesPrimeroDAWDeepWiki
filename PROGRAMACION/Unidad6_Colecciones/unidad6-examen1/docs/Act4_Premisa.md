# Act 4 - Lista de Tareas

Una tienda quiere gestionar la atención a sus clientes mediante una (FIFO: el primero en entrar es el primero en salir).

Se dispone de una clase Cliente con los siguientes atributos:

- nombre (String)
- codCliente(int)

Realiza un programa en Java que permita:

- Añadir un cliente a la cola solicitando su nombre.
- Atender al siguiente cliente, eliminándolo de la cola y mostrando su nombre.
- Mostrar el siguiente cliente que será atendido sin eliminarlo de la cola.
- Mostrar todos los clientes que están esperando en la cola.
- Si se intenta atender o consultar un cliente cuando la cola está vacía, se mostrará un mensaje indicándolo.

AMPLIACIÓN: crear una clase Producto, que tenga los atributos nombre y precio. Añadir a cada cliente una coleccion de productos. Cuando el cliente sea atendido tendrá que salir por pantalla el total a pagar.
