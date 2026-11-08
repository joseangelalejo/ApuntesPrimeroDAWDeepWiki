# **Etiquetas en HTML 5 - Listas, Tablas, y Formularios**

- [**Etiquetas en HTML 5 - Listas, Tablas, y Formularios**](#etiquetas-en-html-5---listas-tablas-y-formularios)
  - [Listas](#listas)
    - [Listas ordenadas](#listas-ordenadas)
    - [Lista desordenadas](#lista-desordenadas)
    - [Lista de definición](#lista-de-definición)
  - [Formularios](#formularios)
  - [Ejemplo completo con Listas y Formularios](#ejemplo-completo-con-listas-y-formularios)
  - [Tablas](#tablas)

## Listas

Existen 3 tipos de listas en HTML5: Listas ordenadas, desordenadas y de definición.

### Listas ordenadas

Una lista ordenada es equivalente en Word a una lista numerada (como un índice). Se crea con la etiqueta `<ol>` (ordered list) y cada elemento de la lista se define con la etiqueta `<li>` (list item).

Dentro de la etiqueta `<ol>`, se pueden utilizar varios atributos para personalizar la apariencia de la lista:

- `type`: Define el tipo de numeración. Los valores posibles son:
  - `1`: Números (1, 2, 3, ...)
  - `A`: Letras mayúsculas (A, B, C, ...)
  - `a`: Letras minúsculas (a, b, c, ...)
  - `I`: Números romanos mayúsculos (I, II, III, ...)
  - `i`: Números romanos minúsculos (i, ii, iii, ...)

Se pueden crear listas dentro de listas para crear sublistas.

Ejemplo:

```html
    <ol type="1">               <!-- Lista ordenada, con atributo type que define el tipo de numeración -->
        <li>Listas</li>
        <li>Tablas</li>
        <li>Formularios</li>
    </ol>
```

### Lista desordenadas

Una lista desordenada es equivalente en Word a una lista con viñetas. Se crea con la etiqueta `<ul>` (unordered list) y cada elemento de la lista se define con la etiqueta `<li>` (list item).

En las listas desordenadas también se pueden utilizar varios atributos para personalizar la apariencia de la lista:

- `style="list-style-type: <tipo>;"`: Define el estilo de las viñetas. Los valores posibles son:
  - `disc`: Viñetas sólidas (predeterminado)
  - `circle`: Viñetas en forma de círculo
  - `square`: Viñetas en forma de cuadrado
  - `none`: Sin viñetas
  
Ejemplo:

```html
    <ul style="list-style-type: disc;">
        <li>Listas</li>
        <li>Tablas</li>
        <li>Formularios</li>
    </ul>
```

### Lista de definición

Una lista de definición se utiliza para definir términos y sus descripciones. Se crea con la etiqueta `<dl>` (definition list), donde cada término se define con la etiqueta `<dt>` (definition term) y su descripción con la etiqueta `<dd>` (definition description).

Ejemplo:

```html
    <dl>                                   <!-- Lista de definiciones -->
        <dt>Elemento de definición</dt>    <!-- Define el término que se va a definir -->
        <dd>Definición del elemento</dd>   <!-- Proporciona la definición del término -->
        <dt>Otro elemento de definición</dt>
        <dd>Definición del otro elemento</dd>
    </dl>
```

## Formularios

Los formularios en HTML se utilizan para recopilar información del usuario. Se crean con la etiqueta `<form>` y pueden contener varios elementos de formulario, como campos de texto, botones, casillas de verificación, etc.

Todos los componentes del formulario se indican con la etiqueta `<input>`, que tiene varios atributos para definir su comportamiento:

- `type`: Define el tipo de campo de entrada. Algunos valores comunes son:
  - **`text`: Campo de texto**
  - **`password`: Campo de contraseña**
  - **`submit`: Botón de envío**
  - **`reset`: Botón de reinicio**
  - **`checkbox`: Casilla de verificación**
  - **`radio`: Botón de opción**
  - `email`: Campo para direcciones de correo electrónico
  - `number`: Campo para números
  - `date`: Campo para fechas
  - `file`: Campo para subir archivos
  - `button`: Botón genérico
  - `hidden`: Campo oculto
  - `url`: Campo para direcciones web
  - `name`: Nombre del campo de entrada.
  - **`placeholder`: Texto que aparece dentro del campo de entrada como una pista para el usuario.**
  - **`name`: Nombre del campo de entrada, utilizado para identificar el campo cuando se envía el formulario. Se utiliza para agrupar botones de opción (radio buttons).**
  - **`range`: Campo deslizante para seleccionar un valor dentro de un rango.**

- **`select`: Define una lista desplegable.**
  - **`option`: Define una opción dentro de una lista desplegable.**

- **`textarea`: Define un área de texto multilínea.**
  - rows: Define el número de filas visibles en el área de texto.
  - cols: Define el número de columnas visibles en el área de texto.
  - placeholder: Texto que aparece dentro del área de texto como una pista para el usuario.

## Ejemplo completo con Listas y Formularios

Ejemplo de todo un documento html con formularios y listas realizado como referencia en clase:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <ol type="1">               <!-- Lista ordenada, con atributo type que define el tipo de numeración -->
        <li>Listas ordenadas</li>
        <li>Tablas</li>
        <li>Formularios</li>
    </ol>

    <ul style="list-style-type: disc;">                        <!-- Lista desordenada. En las etiquetas <ul> las <li> se muestra en viñeta(simbolos) -->
        <li>Listas desordenadas</li>
        <li>Tablas</li>
        <li>Formularios</li>
    </ul>

    <dl>                                   <!-- Lista de definiciones -->
        <dt>Elemento de definición</dt>    <!-- Define el término que se va a definir -->
        <dd>Definición del elemento</dd>   <!-- Proporciona la definición del término -->
        <dt>Otro elemento de definición</dt>
        <dd>Definición del otro elemento</dd>
    </dl>

    <br>
    <hr>  <!-- Línea horizontal para separar contenido -->
    <br>

    <form>
        <input type="text" type="text"name="nombre" placeholder="Casilla de ejemplo"><br>
        <!--- Campo de texto para ingresar datos, con un marcador de posición (placeholder) que indica al usuario qué debe ingresar -->

        <p>Usuario<input type="text" name="usuario" placeholder="Introduce tu usuario"></p>
        <p>Contraseña<input type="password" name="password" placeholder="Introduce tu contraseña"></p>
        <!--- Si utilizamos la etiqueta <p> para agrupar elementos de formulario, podemos aplicar estilos más fácilmente, en este caso, agregamos un texto y la casilla de input aparecerá en la siguiente línea-->

        <br>

        Nombre: <input type="text" name="nombre" placeholder="Introduce tu nombre"><br>
        Apellido: <input type="text" name="apellido" placeholder="Introduce tu apellido"><br>
        <!--- Si utilizamos la etiqueta <p> para agrupar elementos de formulario, podemos aplicar estilos más fácilmente, en este caso, agregamos un texto y la casilla de input aparecerá en la siguiente línea-->
        <!-- Si queremos que ambos campos aparezcan uno a continuación de otro, obviamos la etiqueta <br> -->
        
        <br>

        <input type="radio" name="Color"> Rojo
        <input type="radio" name="Color"> Amarillo
        <input type="radio" name="Color"> Azul
        <!--- Botones de opción (radio buttons) para seleccionar un color -->
            <!--- Los atributos "name" en botones de opción permiten agruparlos, de modo que solo se pueda seleccionar uno a la vez -->
            <!--- Los atributos value definen el valor que se enviará al servidor cuando se seleccione una opción -->
        <br>

        <input type="radio" name="Genero"> Hombre
        <input type="radio" name="Genero"> Mujer
        
        <hr>
        <input type="email" name="correo" placeholder="Introduce tu correo electrónico"><br>
        <!--- Campo de entrada para correo electrónico, con validación automática del formato de correo -->

        <input type="range" name="volumen" min="0" max="100" value="50"><br>
        <!--- Control deslizante (range) para seleccionar un valor dentro de un rango definido -->
        
        <hr>
        <br>
        <input type="file" name="archivo"><br>
        <!--- Campo para seleccionar un archivo desde el sistema del usuario -->
        <textarea rows="4" cols="40" id="comentarios" placeholder="Introduce tus comentarios"></textarea>

        <hr>
        <br>
        <input type="checkbox" name="aceptar" value="si"> Acepto los términos y condiciones<br>
        <!--- Casilla de verificación (checkbox), en este caso para aceptar términos y condiciones -->
        <input type="checkbox" name="suscripcion" value="si"> Deseo suscribirme al boletín<br>
        <input type="checkbox" name="notificaciones" value="si"> Quiero recibir notificaciones por correo electrónico<br>

        <br>
        Seleccione su pais<select name="pais">    <!--- Menú desplegable (select) para elegir un país -->
            <option>España</option>
            <option>México</option>
            <option>Argentina</option>
            <option>Colombia</option>
        </select>

            <br>
        <hr font size="5" color="blue">  <!-- Línea horizontal para separar contenido, con atributos para personalizar su apariencia -->
        <br>
        <input type="reset" value="Restablecer">    <!--- Botón para restablecer el formulario -->
        <input type="submit" value="Enviar">    <!--- Botón para enviar el formulario -->
    </form>
</body>
</html>
```

## Tablas

Para crear tablas en HTML se utilizan la etiqueta `<table>`, junto con otras etiquetas como:

- `<caption>` Proporciona un título o leyenda para la tabla.
- `<tr>` Delimita cada fila de una tabla.
- `<td>` Delimita cada celda de una fila.
- `<th>` Delimita cada celda de encabezado de una tabla.
- `<thead>` Delimita el encabezado de una tabla.
- `<tbody>` Delimita el cuerpo de una tabla.
- `<tfoot>` Delimita el pie de una tabla.

La estructura básica de una tabla sería:

```html
<table>
  <tr>
    <td>Celda 1</td>
    <td>Celda 2</td>
  </tr>
  <tr>
    <td>Celda 3</td>
    <td>Celda 4</td>
  </tr>
</table>
```

---

Para aplicar estilos a las distintas filas y columnas de una tabla utilizamos `<colgroup>`

- `<colgroup>` Delimita un grupo de columnas en una tabla, permite aplicar estilos o atributos a varias columnas a la vez.
- `<col>` Delimita una columna dentro de un grupo de columnas.
- `span` Atributo de `<col>` que especifica el número de columnas que abarca.
- `style` Atributo de `<col>` que permite aplicar estilos CSS a la columna.

Ejemplo simple de tabla utilizando `<colgroup>` para aplicar estilos a la tabla:

```html
<table>

    <caption> Ejemplo de tabla en HTML: <br> Calendario</caption>  <!-- Título de la tabla -->

    <colgroup>                  <!-- Permite aplicar estilo a una tabla-->

        <!-- Si no usamos la etiqueta span, los col se aplicarán en todas las filas, siguiendo el orden de las columnas -->
        <col style="background-color: orange;">   <!-- Aplica un estilo específico a la primera columna -->
        <col style="background-color: lightblue;"> <!-- Aplica un estilo específico a la segunda columna -->
        <col style="background-color: lightgreen;"> <!-- Aplica un estilo específico a la tercera columna -->
    </colgroup>


    <thead>                         <!-- Encabezado de la tabla -->
        <tr>
            <th colspan="3"> Calendario</th>
        </tr>

        <tr>                        <!-- Fila de la tabla, en este caso agrupa varias celdas -->   
            <th>DIAS</th>   <!-- <th> para definir que la celda es de encabezado -->
            <th>MESES</th>
            <th>AÑOS</th>
        </tr>
    </thead>

    <tbody>                         <!-- Cuerpo de la tabla -->
        <tr>                        <!-- Define una fila de datos dentro de la tabla-->
            <td>03</td>         <!-- <td> para definir que la celda es de datos normales-->
            <td>Diciembre</td>
            <td>2001</td>
        </tr>
        <tr>
            <td>09</td>
            <td>Febrero</td>
            <td>2002</td>
    </tbody>

</table>
```

---

Si queremos modificar las propiedades de una tabla (como el borde) y aplicarle estilo sin usar `<colgroup>`,  podemos utilizar atributos dentro de la etiqueta `<table>` asignados a un atributo `style`, son los siguientes::

- `background-color`: Define el color de fondo de la tabla.
- `border`: Define el grosor del borde de la tabla. Podemos especificar el grosor en píxeles (px), puntos (pt), em, etc mediante:
  - `border: 1px solid black;` (borde de 1 píxel, sólido y de color negro)
  - `border: 2pt dashed red;` (borde de 2 puntos, discontinuo y de color rojo)
  - `border: 3px dotted blue;` (borde de 3 píxeles, punteado y de color azul)
- `border-collapse`: Define si los bordes de las celdas deben colapsarse en un solo borde o no. Su valor puede ser:
  - `collapse`: Los bordes de las celdas se colapsan en un solo borde.
  - `separate`: Los bordes de las celdas se mantienen separados (valor predeterminado).
- `border-spacing`: Define el espacio entre los bordes de las celdas.
- `padding`: Define el espacio entre el contenido de la celda y su borde.
- `text-align`: Define la alineación del texto en las celdas. Sus valores pueden ser:
  - `left`: Alinea el texto a la izquierda.
  - `center`: Centra el texto.
  - `right`: Alinea el texto a la derecha.
  - `justify`: Justifica el texto.
- `vertical-align`: Define la alineación vertical del contenido en las celdas. Sus valores pueden ser:
  - `top`: Alinea el contenido en la parte superior de la celda.
  - `middle`: Centra el contenido verticalmente en la celda.
  - `bottom`: Alinea el contenido en la parte inferior de la celda.
  - `baseline`: Alinea el contenido según la línea base del texto.
- `width`: Define el ancho de la tabla. Puede especificarse en píxeles (px), porcentaje (%), em, etc.
- `height`: Define la altura de la tabla. Puede especificarse en píxeles (px), porcentaje (%), em, etc.
- `font-size`: Define el tamaño de la fuente del texto en las celdas.

Todos estos modificadores del atributo `style`se pueden aplicar tanto en la etiqueta `<table>` como en las etiquetas `<tr>`, `<td>`, y `<th>`, para personalizar aún más la apariencia de la tabla y sus celdas.

Ejemplo completo utilizando `stlyle` en una tabla:

```html
<table style="border: 6px solid black; border-collapse: separate;">

<caption> Ejemplo de tabla en HTML: <br> COMPONENTES CRÍTICOS DE UN ORDENADOR</caption>  <!-- Título de la tabla -->

<thead style="background-color: darkgrey;">                         <!-- Encabezado de la tabla -->
<tr>
    <th colspan="3"> COMPONENTES CRÍTICOS DEL ORDENADOR DE VON NEUMANN</th>
</tr>

<tr>                        <!-- Fila de la tabla, en este caso agrupa varias celdas -->   
    <th>COMPONENTE</th>   <!-- <th> para definir que la celda es de encabezado -->
    <th>Compuesto por</th>
    <th>Descripción</th>
</tr>
</thead>

<tbody style="background-color: gray;border: 6px solid black;">                         <!-- Cuerpo de la tabla -->
<tr style="background-color: lightcoral;">                        <!-- Define una fila de datos dentro de la tabla-->
    <td style="text-align: center;">UNIDAD DE ENTRADA</td>                                      <!-- <td> para definir que la celda es de datos normales-->
    <td>Dispositivos de entrada (teclado, ratón, escaner)</td>
    <td>Permite al usuario introducir datos e instrucciones en el sistema</td>
</tr>
<tr style="background-color: lightblue;">
    <td style="text-align: center;">UNIDAD DE SALIDA</td>                           <!-- text-align: center; centramos el contenido -->
    <td>Dispositivos de salida (monitor, impresora, altavoces)</td>
    <td>Muestra información al usuario</td>
</tr>
<tr style="background-color: indigo;">
    <td style="text-align: center;">CPU - (UNIDAD CENTRAL DE PROCESO)</td>
    <td>CPU y Microprocesadores</td>
    <td>Cerebro del ordenador: ejecuta instrucciones y procesa datos</td>
</tr>
<tr style="background-color: lightgreen;">
    <td style="text-align: center;">ALU (Unidad Aritmético-Lógica)</td>
    <td>Parte de la cpu</td>
    <td>Realiza operaciones aritméticas y lógicas</td>
</tr>
<tr style="background-color: orange;">
    <td style="text-align: center;">UC (Unidad de Control)</td>
    <td>Parte de la CPU</td>
    <td>Dirige el flujo de datos e instrucciones dentro del sistema</td>
</tr>
</tbody>
```
