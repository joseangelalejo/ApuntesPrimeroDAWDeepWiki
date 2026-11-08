# Lectura/Escritura de archivos 2

Escribe un programa en Java que gestione una lista de contactos. El programa debe permitir al usuario realizar las siguientes acciones:

1- **Agregar un nuevo contacto:**

El usuario debería poder ingresar el nombre y el número de teléfono de un nuevo contacto. Los datos del contacto deben almacenarse en un archivo llamado "contactos.txt".

Comprobar que el contacto no existe ya antes de agregarlo.

Al agregar comprobar que el número de teléfono no está guardado previamente.

Si el teléfono corresponde a otra persona preguntar si quiere cambiar la persona.

2- **Mostrar todos los contactos:**

Al seleccionar esta opción, el programa debería leer el archivo "contactos.txt" y mostrar en la consola todos los contactos almacenados, cada uno en una línea separada, con el formato:

> "Nombre: Número de Teléfono".

El programa debe utilizar las clases BufferedReader y BufferedWriter para leer y escribir en el archivo respectivamente.

El menú de opciones debe repetirse hasta que el usuario decida salir del programa.
