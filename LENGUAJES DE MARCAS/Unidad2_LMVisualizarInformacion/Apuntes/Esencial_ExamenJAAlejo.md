# **HTML5 - José Ángel Alejo - ITP 1ºDAW - Esencial Examen HTML5**

- [**HTML5 - José Ángel Alejo - ITP 1ºDAW - Esencial Examen HTML5**](#html5---josé-ángel-alejo---itp-1ºdaw---esencial-examen-html5)
  - [**ETIQUETAS Y ATRIBUTOS**](#etiquetas-y-atributos)
  - [**Etiquetas comunes para Formatear párrafos**](#etiquetas-comunes-para-formatear-párrafos)
  - [**Hipervínculos**](#hipervínculos)
  - [**Contenido Multimedia**](#contenido-multimedia)
  - [**LISTAS, TABLAS Y FORMULARIOS**](#listas-tablas-y-formularios)
    - [**Listas**](#listas)
    - [**Tablas**](#tablas)
    - [**Formularios**](#formularios)
  - [**DIVS Y LAYOUTS**](#divs-y-layouts)
    - [**Excepciones en propiedades de style**](#excepciones-en-propiedades-de-style)
    - [**Layouts y Flexbox**](#layouts-y-flexbox)
    - [**Excepciones en flexbox**](#excepciones-en-flexbox)

---
<div style="page-break-after: always;"></div>

## **ETIQUETAS Y ATRIBUTOS**

>Las etiquetas definen la estructura y contenido de la página. **Etiquetas comunes**:

- **`<h1>` a `<h6>`**: Definen encabezados de diferentes niveles, de más a menos importante. Se ve así: `<h1>Encabezado de nivel 1</h1>`. Solo debe haber un `<h1>` por página.
- **`<p>`**: Define un párrafo. Se ve así: `<p>Este es un párrafo.</p>`.
- **`<a>`**: Define un hipervínculo. Se ve así: `<a href="https://www.ejemplo.com">Visitar Ejemplo</a>`.
- **`<img>`**: Inserta una imagen. Se ve así: `<img src="imagen.jpg" alt="Descripción de la imagen">`.
- **`<div>`**: Define una sección o contenedor genérico. Se ve así: `<div>Contenido del contenedor</div>`.
- **`<span>`**: Define un contenedor en línea para aplicar estilos o atributos a una parte del texto. Se ve así: `<span style="color: red;">Texto en rojo</span>`.
- **`<br>`**: Inserta un salto de línea.
- **`<hr>`**: Inserta una línea horizontal para separar contenido.

>Los **atributos modifican el comportamiento o la apariencia de un elemento**. Cada **atributo tiene un nombre y un valor, separados por un signo igual** (`=`) y el valor se encierra entre comillas.
>**Atributos comunes**:

- **`name`**: Define el nombre de un elemento. Por ejemplo, `name="username"` en un campo de formulario. Se vería así: `<input type="text" name="username">`.
- **`title`**: Proporciona información adicional sobre un elemento, que generalmente se muestra como una sugerencia al pasar el cursor sobre él. Por ejemplo, `title="Este es un enlace a la página principal"` en un enlace. Se vería así: `<a href="index.html" title="Este es un enlace a la página principal">Inicio</a>`.
- **`id`**: Asigna un identificador único a un elemento HTML, que puede ser utilizado para estilos CSS o scripts JavaScript. Por ejemplo, `id="header"` en un encabezado. Se vería así: `<h1 id="header">Bienvenido</h1>`.
- **`style`**: Permite aplicar estilos CSS directamente a un elemento HTML. Por ejemplo, `style="color: red;"` para cambiar el color del texto a rojo. Se vería así: `<p style="color: red;">Este es un párrafo rojo.</p>`. Es el atributo más básico para aplicar estilos en línea.
- **`href`**: Especifica la URL de destino de un hipervínculo. Por ejemplo, `href="https://www.ejemplo.com"` en un enlace. Se vería así: `<a href="https://www.ejemplo.com">Visitar Ejemplo</a>`.
  - **`src`**: Especifica la fuente de un recurso, como una imagen o un archivo multimedia. Por ejemplo, `src="imagen.jpg"` en una etiqueta de imagen. Se vería así: `<img src="imagen.jpg" alt="Descripción de la imagen">`.
  - **`alt`**: Proporciona una descripción alternativa para una imagen, que se muestra si la imagen no se puede cargar. Por ejemplo, `alt="Descripción de la imagen"` en una etiqueta de imagen. Se vería así: `<img src="imagen.jpg" alt="Descripción de la imagen">`.

---
<div style="page-break-after: always;"></div>

## **Etiquetas comunes para Formatear párrafos**

- **`<p>`**: Define un párrafo. Se ve así: `<p>Este es un párrafo.</p>`.
- **`<pre>`**: Define un bloque de texto preformateado, que se muestra con un espaciado y una fuente monoespaciada. Se ve así: `<pre>Texto preformateado</pre>`.
- **`<br>`**: Inserta un salto de línea dentro de un párrafo. Se ve así: `Primera línea<br>Segunda línea`.
- **`<hr>`**: Inserta una línea horizontal para separar contenido. Se ve así: `<hr>`.
- **`<b>`**: Aplica negrita al texto. Se ve así: `<b>Texto en negrita</b>`.
- **`<i>`**: Aplica cursiva al texto. Se ve así: `<i>Texto en cursiva</i>`.
- **`<em>`**: Aplica énfasis al texto, generalmente representado en cursiva. Se ve así: `<em>Texto enfatizado</em>`.
- **`<u>`**: Aplica subrayado al texto. Se ve así: `<u>Texto subrayado</u>`.
- **`<small>`**: Reduce el tamaño del texto. Se ve así: `<small>Texto pequeño</small>`.
- **`<mark>`**: Resalta el texto. Se ve así: `<mark>Texto resaltado</mark>`.
- **`<ins>`**: Indica texto insertado. Se ve así: `<ins>Texto insertado</ins>`.
- **`<del>`**: Indica texto eliminado, generalmente representado con una línea atravesada. Se ve así: `<del>Texto eliminado</del>`.
- **`<sup>`**: Aplica superíndice al texto. Se ve así: `<sup>Texto en superíndice</sup>`.
- **`<sub>`**: Aplica subíndice al texto. Se ve así: `<sub>Texto en subíndice</sub>`.
- **`<strong>`**: Aplica un énfasis fuerte al texto, generalmente representado en negrita. Da importancia en motores de búsqueda. Se ve así: `<strong>Texto con énfasis fuerte</strong>`.
- **`<a>`**: Define un hipervínculo. Se ve así: `<a href="https://www.ejemplo.com">Visitar Ejemplo</a>`.

Etiquetas como `<h1>`, `<strong>`, `<em>` y `<mark>`, **dan importancia semántica al contenido** y en motores de búsqueda.

## **Hipervínculos**

Los hipervínculos se crean utilizando la etiqueta `<a>` (ancla) junto con el atributo `href` (para enlaces a otras páginas o recursos).

- **`href`**: Especifica la URL de destino del hipervínculo. Por ejemplo, `href="https://www.ejemplo.com"` en un enlace. Se vería así: `<a href="https://www.ejemplo.com">Visitar Ejemplo</a>`.
- **`target`**: Define dónde se abrirá el enlace. Los valores comunes son:
  - `_self`: Abre el enlace en la misma pestaña o ventana (valor predeterminado).
  - `_blank`: Abre el enlace en una nueva pestaña o ventana. Muy útil en dispositivos móviles para no perder la página original.
- Ejemplo: `<a href="https://www.ejemplo.com" target="_blank">Abrir en nueva pestaña</a>`.

**Para crear un vínculo dentro del mismo documento**, se puede utilizar el atributo `id` para definir un punto de anclaje y luego enlazar a ese punto utilizando el símbolo `#` seguido del valor del `id`.

```html
<h2 id="seccion1">Sección 1</h2>
<p>Contenido de la sección 1.</p>
<a href="#seccion1">Ir a la Sección 1</a>
```

---
<div style="page-break-after: always;"></div>

## **Contenido Multimedia**

- Las **etiquetas estándar** según el tipo de contenido multimedia son:
  - `<img>` para imágenes
  - `<audio>` y `</audio>` para audio
  - `<video>` y `</video>` para vídeo

- Los **atributos comunes para `<img>` son:**
  - **`src`**: Especifica la ruta absoluta o relativa de la imagen a mostrar. Ejemplo: `<img src="imagen.jpg" alt="Descripción de la imagen">`.
  - **`alt`**: Descripción alternativa de la imagen. Se muestra si la imagen no se puede cargar. La leen los lectores de pantalla. Ejemplo: `<img src="imagen.jpg" alt="Imagen de gato">`.
  - **`width` y `height`**: Definen el ancho y la altura de la imagen en píxeles. Ejemplo: `<img src="imagen.jpg" alt="Descripción de la imagen" width="300" height="200">`.
    - Si solo se especifica uno, el otro se ajusta automáticamente.
  - **`title`**: Proporciona información adicional sobre la imagen. Se muestra al pasar el cursor por encima. Ejemplo: `<img src="imagen.jpg" alt="Descripción de la imagen" title="Imagen de un paisaje">`.
- **Casos de uso adicionales incluyen:**
  - **Si queremos crear un hipervínculo en una imagen**, podemos envolver la etiqueta `<img>` dentro de una etiqueta `<a>`, utilizando el atributo `href` para definir la URL de destino. Por ejemplo:
    - **`href`**: Define la URL de destino de un hipervínculo. Por ejemplo, `href="https://www.ejemplo.com"` en un enlace. Se vería así: `<a href="https://www.ejemplo.com">Visitar Ejemplo</a>`.
  - **Si la imagen se obtiene de una URL externa**, se puede indicar la URL en el atributo `src`. Por ejemplo:
    - `<img src="https://www.ejemplo.com/imagen.jpg" alt="Descripción de la imagen">`.

- Los **atributos comunes para `<audio>` y `<video>` son:**
  - **`src`**: Especifica la ruta del archivo de audio. Ejemplo: `<audio src="audio.mp3" controls></audio>`.
  - **`controls`**: Muestra los controles de reproducción (reproducir, pausar, volumen). Ejemplo: `<audio src="audio.mp3" controls></audio>`.
  - **`autoplay`**: Reproduce el audio automáticamente al cargar la página. Ejemplo: `<audio src="audio.mp3" autoplay></audio>`.
  - **`loop`**: Reproduce el audio en bucle. Ejemplo: `<audio src="audio.mp3" loop></audio>`.
- **Atributos específicos para `<video>`:**
  - **`width` y `height`**: Definen el ancho y la altura del vídeo en píxeles. Ejemplo: `<video src="video.mp4" width="640" height="360" controls></video>`.
  - **`poster`**: Especifica una imagen que se muestra antes de que el vídeo comience a reproducirse. Ejemplo: `<video src="video.mp4" poster="imagen.jpg" controls></video>`.
  - **`muted`**: Inicia el vídeo sin sonido. Ejemplo: `<video src="video.mp4" muted controls></video>`.
- **Casos de uso adicionales y buenas prácticas:**
  - Para **incrustar un vídeo de una plataforma externa** usamos la etiqueta `<iframe>`. Por ejemplo:
    - `<iframe width="560" height="315" src="https://www.youtube.com/embed/VIDEO_ID" frameborder="0" allowfullscreen></iframe>`.
      - La propiedad `frameborder` define el grosor del borde del iframe (0 es sin borde).
      - La propiedad `allowfullscreen` permite que el vídeo se vea en pantalla completa.
  - Si usamos la etiqueta `<source>` no usaremos el atributo src en la etiqueta principal `<audio>` o `<video>`.
  - Es recomendable indicar varios `<source>` dentro de las etiquetas `<audio>` y `<video>`.

    - ```html
      <audio controls>
        <source src="audio.mp3" type="audio/mpeg">
        <source src="audio.ogg" type="audio/ogg">
        Tu navegador no soporta el elemento de audio.
      </audio>
      ```

  - Si quisieramos alinear varias imágenes o videos usaríamos el atributo `style` con la propiedad CSS  `justify-content` en un contenedor flexbox (que se crea utilizando `display: flex`). Ejemplo:

      ```html
      <div style="display: flex; justify-content: center;">
        <img src="imagen1.jpg" alt="Descripción de la imagen 1">
        <img src="imagen2.jpg" alt="Descripción de la imagen 2">
        <video src="video.mp4" controls></video>
      </div>
    ```

---
<div style="page-break-after: always;"></div>

## **LISTAS, TABLAS Y FORMULARIOS**

Son elementos semánticos esenciales para organizar y presentar datos en una página web. Estructuran el contenido que envuelven.

- **Listas**: Se utilizan para **organizar información en listas ordenadas, desordenadas o de definición**. Pueden ser listas ordenadas (`<ol>`), listas desordenadas (`<ul>`) y listas de definición (`<dl>`).
- **Tablas**: Se utilizan para **presentar datos tabulares de manera estructurada**. Pueden incluir encabezados (`<th>`), filas (`<tr>`) y celdas (`<td>`).
- **Formularios**: Se utilizan para **recopilar información del usuario de manera organizada**. Pueden incluir campos de entrada (`<input>`), áreas de texto (`<textarea>`), botones (`<button>`) y otros elementos interactivos.

### **Listas**

Las listas en HTML5 se utilizan para organizar información de manera estructurada. Existen tres tipos principales de listas: listas ordenadas, listas desordenadas y listas de definición.

- **Listas ordenadas**: Se crean utilizando la etiqueta `<ol>`, y cada elemento de la lista se define con la etiqueta `<li>`. Dentro de `<ol>`, podemos utilizar el atributo `type` para especificar el tipo de numeración: `1` (números, por defecto), `A` (letras mayúsculas), `a` (letras minúsculas), `I` (números romanos mayúsculos), `i` (números romanos minúsculos).
- **Listas desordenadas**: Se crean utilizando la etiqueta `<ul>`, y cada elemento se define con `<li>`. Dentro de `<ul>`, podemos utilizar el atributo `style` con `list-style-type` para especificar el tipo de viñeta: `disc` (sólida, por defecto), `circle` (circular), `square` (cuadrada), `none` (sin viñeta).
- **Listas de definición**: Se crean utilizando la etiqueta `<dl>`, que contiene pares de términos y descripciones. Cada término se define con `<dt>`, y cada descripción con `<dd>`.
- **Listas anidadas**: Son listas que contienen otras listas dentro de sus elementos, permitiendo estructuras jerárquicas. Por ejemplo, una `<ol>` puede contener una `<ul>` dentro de un `<li>`.

### **Tablas**

Las tablas en HTML5 se utilizan para presentar datos tabulares de manera estructurada. Una tabla se define con `<table>`, que contiene elementos para organizar filas y columnas.

- Elementos principales: `<tr>` (fila), `<th>` (celda de encabezado), `<td>` (celda de datos).
- Otros elementos: `<thead>` (encabezado), `<tbody>` (cuerpo), `<tfoot>` (pie), `<caption>` (título), `<colgroup>` y `<col>` (para estilos en columnas).

Para aplicar estilos CSS a tablas, se puede usar el atributo `style` en `<table>` o elementos hijos. Propiedades comunes incluyen `border`, `border-collapse`, `width`, `height`, `background-color`, `text-align`, `vertical-align`, `padding`, `margin`, etc. No mezclar con flexbox, grid o float.

### **Formularios**

Usan `<label>` para asociar descripciones a campos, vinculando con `for` e `id` para accesibilidad.

Entradas principales con `<input>`, con atributos clave:

- `type`: text, password, email, number, date, checkbox, radio, submit, reset, file, button, hidden, tel, url, color, range.
- `name`: Identifica el campo para envío.
- `value`: Valor predeterminado o texto del botón.
- `required`: Campo obligatorio.
- `placeholder`: Texto sugerencia que desaparece al escribir.
- `accept`: Para archivos (ej. "image/png,image/jpeg").

`<select>` crea menús desplegables con `<option>`, atributos como `name` y `multiple` para selección múltiple.

`<textarea>` para texto multilínea, con `name`, `rows`, `cols` y `placeholder`.

Ejemplo básico:

```html
<form action="/enviar" method="POST">
  <label for="nombre">Nombre:</label>
  <input type="text" id="nombre" name="nombre" required placeholder="Ingresa tu nombre">
  <input type="submit" value="Enviar">
</form>
```

---
<div style="page-break-after: always;"></div>

## **DIVS Y LAYOUTS**

Los elementos `<div>` son contenedores genéricos utilizados para agrupar otros elementos y aplicarles estilos o comportamientos comunes mediante CSS.

Para aplicar estilos a un `<div>`, utilizamos el atributo `style`. Propiedades comunes incluyen:

- `border`: Define el ancho, estilo y color del borde (ej. `border: 1px solid black;`).
- `margin`: Define el espacio alrededor del `<div>` (ej. `margin: 10px;` para centrar: `margin: 0 auto;`).
- `padding`: Define el espacio interior entre el contenido y el borde (ej. `padding: 10px;`).
- `background-color`: Define el color de fondo (ej. `background-color: lightblue;`).
- `background-image`: Establece una imagen de fondo (ej. `background-image: url('ruta/imagen.jpg');`).
- `background-repeat`: Controla si la imagen se repite (valores: `repeat`, `repeat-x`, `repeat-y`, `no-repeat`).
- `background-size`: Define el tamaño de la imagen de fondo (valores: `auto`, `cover`, `contain`).
- `background-position`: Define la posición de la imagen (ej. `top left`, `center center`).
- `width` y `height`: Definen ancho y altura (en px o %).
- `min-width`, `max-width`, `min-height`, `max-height`: Definen límites de tamaño.
- `display`: Controla cómo se muestra el `<div>` (valores: `block` por defecto, `inline`, `inline-block`, `flex`, `inline-flex`).
- `text-align`: Alinea el texto (valores: `left`, `center`, `right`).
- `vertical-align`: Alinea verticalmente (valores: `top`, `middle`, `bottom`).
- `font-size`: Define el tamaño de la fuente.

### **Excepciones en propiedades de style**

Algunas propiedades pueden heredarse de elementos padres (ej. `font-size`, `color`) o no aplicarse según el valor de `display`. Por ejemplo:

- `width` y `height` no afectan cuando `display: inline;`.
- `margin-top` y `margin-bottom` no aplican cuando `display: inline;`.
- `vertical-align` solo aplica a elementos en línea o tabla (valores como `top`, `middle`, `bottom`).
- `background-repeat` con valores como `repeat-x` o `repeat-y` repiten solo en ejes específicos.
- `text-align` con valores como `left`, `center`, `right` alinean texto, pero no afectan a elementos de bloque sin texto.

### **Layouts y Flexbox**

Para organizar `<div>`, utilizamos layouts CSS. El enfoque principal es **flexbox**:

- `display: flex;`: Convierte el `<div>` en un contenedor flexible, organizando elementos hijos en fila o columna.
- `flex-direction`: Define la dirección (valores: `row` para horizontal, `column` para vertical).
- `justify-content`: Alinea elementos a lo largo del eje principal (valores: `flex-start`, `center`, `flex-end`, `space-between`, `space-around`).
- `align-items`: Alinea elementos a lo largo del eje transversal (valores: `flex-start`, `center`, `flex-end`, `stretch`).
- `flex`: En elementos hijos, distribuye espacio proporcionalmente. El valor numérico indica la proporción (ej. `flex: 1;` ocupa 1 parte, `flex: 2;` ocupa 2 partes).

### **Excepciones en flexbox**

`justify-content` y `align-items` solo afectan a elementos hijos en contenedores flex. Si se usa `flex` en hijos, no se pueden usar `width` y `height` en ellos, ya que el tamaño se calcula automáticamente.

Otras **opciones para Layouts incluyen**:

- `float`: Posiciona el `<div>` a la izquierda o derecha (valores: `left`, `right`, `none`). No compatible con flexbox.
- Grid: Utiliza `display: grid;` para layouts en cuadrícula, pero se enfoca en flexbox.

No mezclar flexbox con float en el mismo contenedor. Es recomendable usar hojas de estilo externas para estilos.
