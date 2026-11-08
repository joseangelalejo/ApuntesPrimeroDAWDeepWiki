# PREMISA Actividad 5: Manipulación de DOM - Atributos y Estilos

> EJERCICIO 1 – Añadir atributo dinámicamente usando setAttribute()

- Crea un botón con el texto “Activar enlace” y un enlace `<a>` sin atributo href.
- Al pulsar el botón, añade mediante JavaScript el atributo href al enlace con valor `https://www.google.com`.
- Si ya tiene href, cambia su valor a `https://www.youtube.com`.

> EJERCICIO 2 – Eliminar atributo con removeAttribute()

- Crea una imagen con atributo width="300" y un botón que diga “Quitar tamaño”.
- Al pulsarlo, elimina el atributo width de la imagen.

> EJERCICIO 3 – Deshabilitar y habilitar Input

- Crea un input de texto y un botón que diga “Bloquear / Desbloquear”.
- Al pulsar el botón, usa toggleAttribute("disabled") para activar o desactivar el input.

> EJERCICIO 4 – Cambiar clase mediante atributo

- Crea un párrafo con clase "rojo" definida en CSS.
- Crea un botón que al pulsarlo cambie la clase a "azul" usando setAttribute("class", "azul").

> EJERCICIO 5 – Control de visibilidad con hidden

- Crea un div con texto dentro.
- Añade un botón que use toggleAttribute("hidden") para mostrar y ocultar el div.

> EJERCICIO 6 – Cambiar clase usando className

- Crea un div con clase "cajaNormal".
- Define otra clase llamada "cajaDestacada" con fondo diferente.
- Añade un botón que cambie la clase usando: `elemento.className = "cajaDestacada";`
- Haz que al volver a pulsar recupere la clase original.

> EJERCICIO 7 – Modificar un estilo directamente con style

- Crea un párrafo sin estilos inline.
- Añade un botón que cambie su color a azul usando: `elemento.style.color = "blue"`;
- Añade otro botón que cambie el tamaño de letra a 25px usando: `elemento.style.fontSize = "25px";`

> EJERCICIO 8 – Aplicar múltiples estilos desde JavaScript

- Crea un párrafo con texto.
- Añade un botón que al pulsarlo:
  - Cambie el color del texto a blanco.
  - Cambie el fondo a negro.
  - Aumente el tamaño de letra.
  - Añada padding.
- Todo usando varias líneas con elemento.style.propiedad = valor.
