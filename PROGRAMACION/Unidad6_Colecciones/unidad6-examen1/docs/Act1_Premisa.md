# Act 1 - Listas - Reproductor

Crea un programa en Java que simule un reproductor de música. Para ello tendrás que:

Crear una clase Cancion en un archivo .java que defina los siguientes atributos:

- Título
- Artista
- Duración (en segundos o minutos)

Además, deberás definir los métodos necesarios para acceder y modificar estos atributos.

En el main, crea un menú interactivo donde el usuario pueda elegir entre las siguientes opciones:

1. Añadir canción
2. Borrar canción
3. Reproducir canción
4. Mostrar lista de reproducción
5. Salir del programa

Funcionamiento de cada opción:

- Añadir canción: Añade una nueva canción al final de la lista. Se debe comprobar que no exista ya una canción con el mismo título y artista (opcionalmente, lanza una excepción si ya existe).
- Borrar canción: El usuario podrá elegir borrar por título o por número de posición en la lista. Si hay más de una canción con el mismo título, muestra las coincidencias con su índice para que el usuario elija cuál borrar.
- Reproducir canción: Permite al usuario seleccionar una canción por título o índice para "reproducirla" (imprimir en consola los datos de la canción como si estuviera sonando).
- Mostrar lista de reproducción: Muestra todas las canciones de la lista con su índice y datos básicos.
- Salir: Finaliza el programa.

Al inicio del programa, añade unas cuantas canciones de ejemplo a la lista sin pedir datos al usuario.
