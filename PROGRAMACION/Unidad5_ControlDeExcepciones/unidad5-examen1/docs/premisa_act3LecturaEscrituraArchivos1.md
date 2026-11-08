# Lectura/Escritura de archivos 1

Escribe un programa en Java que gestione información de alumnos utilizando objetos y archivos. El programa debe permitir al usuario realizar las siguientes acciones:

1- **Cargar alumnos desde un fichero:**

El programa deberá leer un archivo llamado "alumnos.txt". Cada línea del fichero contendrá la información de un alumno con el siguiente formato:

> nombre; edad; curso

Por cada línea leída del fichero, el programa deberá crear un objeto de la clase Alumno con los datos correspondientes y almacenarlo en un array.

Después de la lectura, el programa deberá mostrar por pantalla todos los alumnos cargados.

2- **Registrar un nuevo alumno:**

El usuario deberá introducir por teclado el nombre, la edad y el curso de un alumno.

Con esos datos, el programa deberá crear un objeto Alumno y guardar su información en el fichero "alumnos.txt" manteniendo el mismo formato:

> nombre; edad; curso

3- **Mostrar los alumnos almacenados:**

El programa deberá recorrer el array de objetos y mostrar todos los alumnos almacenados con el siguiente formato:

> Nombre - Edad años - Curso

El programa debe utilizar las clases BufferedReader y BufferedWriter para leer y escribir en el archivo respectivamente.

El menú de opciones debe repetirse hasta que el usuario decida salir del programa.
