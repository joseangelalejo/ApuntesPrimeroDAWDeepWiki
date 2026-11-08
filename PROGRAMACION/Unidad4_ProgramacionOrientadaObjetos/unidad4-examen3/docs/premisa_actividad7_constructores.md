# Actividad 7: Constructores

Realiza las siguientes clases con sus atributos y constructores

1.-Clase Rectangulo:

- double base
- double altura

Constructores:

- Constructor con base y altura.
- Constructor solo con base → altura = base (cuadrado).

El segundo constructor debe llamar al primero usando this().

2.- Clase Producto:

- String nombre
- double precio
- int stock

Constructores:

- nombre y precio → stock = 0
- nombre, precio y stock

Si el precio es negativo, el constructor debe poner el precio a 0.

3.-Clase Alumno:

- String nombre
- int edad
- int totalAlumnos

Cada vez que se cree un alumno, el constructor debe aumentar el contador.

Métodos:

- mostrarAlumno()
- mostrar total de alumnos creados.

4.- Clase Alumno (modificación del anterior)

- String nombre
- int edad
- int idAlumno

Cada alumno deberá tener un id único, correspondiente al número de objeto creado.
Métodos:

- mostrarAlumno()

5.-Clase Libro:

- String titulo
- String autor
- int numPaginas

Constructores:

- Solo título → autor = "Desconocido", páginas = 0
- título y autor → páginas = 0
- título, autor y páginas

Todos los constructores deben reutilizar código.
