# Act 2 - Listas Productos

Crea una aplicación que gestione una lista de productos. Cada producto debe ser representado por una clase llamada Producto, que contenga al menos los siguientes atributos:

- String nombre
- double precio
- int codigo

El programa debe mostrar un menú principal que permita al usuario realizar las siguientes operaciones:

- Agregar un producto al final de la lista. El usuario debe ingresar el nombre, precio y código del nuevo producto, que se agregará al final de la lista.
- Eliminar un producto por su código: El usuario deberá introducir un código de producto, y si existe un producto con ese código, será eliminado de la lista. Sino sacar un mensaje de que no existe el producto. Se deberá usar el iterador.
- Ver un producto por posición: El usuario deberá introducir una posición (índice) y se mostrará la información del producto en esa posición, si es válida.
- Mostrar todos los productos: Se recorrerá la lista completa y se mostrará la información de cada producto registrado.
- Salir del programa.

El menú debe repetirse hasta que el usuario elija la opción de salir. Usa estructuras de control adecuadas y maneja posibles errores, como posiciones inválidas o códigos no encontrados.
