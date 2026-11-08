# Premisa Actividad 14: Herencias 2 - Librería

En este ejercicio, desarrollaremos un programa en Java para gestionar diferentes tipos de publicaciones, como libros y discos, junto con la posibilidad de prestarlos a clientes.

## Clases a Implementar

- **Clase Publicacion**: Esta clase representa una publicación genérica y contendrá los siguientes atributos:
  - titulo
  - autor
  - añoPublicacion
  - clientePrestado: Cliente (representando al cliente que tiene prestada la publicación, o null si no está prestada)
  - Además, tendrá los **siguientes métodos**:
    - **toString()**: Método para mostrar la información básica de la publicación.
    - **prestar(Cliente cliente)**: Método para prestar la publicación a un cliente.
    - **devolver()**: Método para devolver la publicación, eliminando la referencia al cliente prestado.

- **Clase Libro**: Esta clase representa un libro y heredará de Publicacion.
  - Tendrá un atributo adicional: numeroPaginas.
  - Además, sobrescribirá el método  toString() para incluir el número de páginas.
- **Clase Disco**: Esta clase representa un disco y también heredará de Publicacion.
  - Tendrá un atributo adicional: discografica.
  - También, sobrescribirá el método  toString() para incluir la discográfica.
- **Clase Pelicula**: Esta clase representa una película y también heredará de Publicacion.
  - Tendrá un atributo adicional: edadMinima (representa la edad mínima requerida para prestar la película).
  - Además, sobrescribirá el método  toString() para incluir la edad mínima y el método prestar() para verificar si el cliente tiene la edad mínima requerida antes de prestar la película.
- **Clase Cliente**: Esta clase representa a una persona que puede tomar prestadas las publicaciones.
- Tendrá los atributos:
- nombre.
- codigoCliente.
- edad.

> **Nota:** *Crear un **main donde se prueben las clases** y métodos implementados*.
