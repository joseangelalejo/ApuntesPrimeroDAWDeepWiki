# Premisa Proyecto - Catálogo de Películas

Partiendo del ejemplo visto en clase (cargar un JSON externo y pintarlo en HTML con JavaScript), vas a crear un mini-catálogo de películas estilo Netflix, con carátulas en formato tarjetas usando CSS Grid.

La página web debe:

- Leer un archivo JSON externo con datos de películas.
- Mostrar el catálogo en una página principal con formato de “carátulas”.
- Al hacer click en una película, abrir una página de detalle con toda la información (tráiler, sinopsis, actores, año, etc.).

ESTRUCTURA DEL PROYECTO (MÍNIMA)

- index.html              (catálogo)
- detalle.html            (ficha de película)
- películas.json          (datos)
- En los html metéis los script y los css

DATOS OBLIGATORIOS EN EL JSONEl archivo películas.json debe contener un array de películas. Cada película debe incluir:

- titulo
- sinopsis
- actores (array de strings)
- trailer (URL normal de YouTube)
- caratula (ruta a imagen o URL)
- año

EJEMPLO DE ESTRUCTURA (ORIENTATIVO)

```json
[
    {
      "titulo": "Ejemplo",
      "sinopsis": "Texto...",
      "actores": ["Actor 1", "Actor 2"],
      "trailer": "https://www.youtube.com/watch?v=...&quot;,
      "caratula": "img/ejemplo.jpg",
      "año": 2020
    }
  ]
```

PÁGINA 1: CATÁLOGO (index.html)
Requisitos:

- Cargar peliculas.json con fetch().
- Pintar las películas dentro de un div.
- Cada película se verá como una “carátula” (imagen) en forma de tarjeta.
- Se puede usar esta base de grid:

```css
.teclado {
  display: grid;
  grid-template-columns: repeat(10, 1fr);
  gap: 10px;
}

.teclado > * {
  aspect-ratio: 2 / 3;
}
```

Comportamiento:

- Cada tarjeta debe ser clicable.
- Al hacer click, debe ir a detalle.html

PÁGINA 2: DETALLE (detalle.html)
Requisitos:

- Volver a cargar peliculas.json con fetch().
- Buscar la película con ese título.
- Mostrar en la página:
  - Título
  - Año
  - Sinopsis
  - Actores (en una lista o texto separado por comas)
  - Carátula (imagen)
  - Tráiler (insertado como iframe si es posible, o enlace si no)
- Incluir un botón "Volver al catálogo" que lleve a index.html.

REQUISITOS DE DISEÑO (SENCILLOS PERO CUIDADOS)

- Estilo visual tipo plataforma de streaming:
  - Fondo oscuro o neutro
  - Tarjetas con borde redondeado y efecto hover.
  - Texto legible y bien alineado
- La página debe verse ordenada y “limpia”.

ENTREGA

- Carpeta comprimida (.zip) con todos los archivos.
- Debe funcionar abriendo index.html y navegando al detalle sin errores.
- Si usas imágenes locales, inclúyelas en una carpeta img/.

EVALUACIÓN

- Funcionamiento (JSON + navegación)
  - Carga correcta del JSON externo.
  - Pintado correcto del catálogo con grid y carátulas.
  - Click en película abre detalle.html con la película correcta.
  - En detalle se muestran todos los campos solicitados.

- Maquetación y presentación
  - Uso correcto del grid.
  - Diseño coherente (tarjetas, márgenes, tipografía).

- OBSERVACIÓN DIRECTA Y TRABAJO EN CLASE (PARTE DE LA NOTA)
  - Una parte del proyecto se evaluará mediante observación directa:
    - Avance real durante las clases.
