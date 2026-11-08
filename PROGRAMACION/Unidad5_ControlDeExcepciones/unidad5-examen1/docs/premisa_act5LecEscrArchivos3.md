# Lectura/ Escritura de ficheros 3: Gestión de notas

Escribe un programa en Java que lea el archivo "alumnos.txt", el cual contiene una lista de nombres de alumnos. Por cada alumno en la lista, el programa deberá crear un nuevo archivo con el nombre del alumno y la extensión ".txt" en la misma carpeta donde se encuentra el archivo "alumnos.txt".

Para cada uno de estos archivos de alumnos recién creados, el programa solicitará al usuario que ingrese las notas del alumno. Se le pedirá al usuario que ingrese las notas para todas los módulos que desee. Estás notas se guardarán cada una en una fila con el siguiente formato "Programación: 8"

El programa comprobará si todos los módulos están aprobados. Si es así incluirá una línea final "PROMOCIONA" y sino "NO PROMOCIONA".

El programa deberá utilizar las clases BufferedReader y BufferedWriter para interactuar con los archivos.
Al finalizar la entrada de notas para todos los alumnos, el programa deberá mostrar un mensaje indicando que se han procesado todas las notas.
