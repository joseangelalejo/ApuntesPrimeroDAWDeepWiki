# **Etiquetas en HTML 5 - DIVS**

## **Definición de DIV**

La etiqueta `<div>` en HTML se utiliza para agrupar elementos y aplicarles estilos de manera conjunta.

## **Características de DIV**

La etiqueta `div` al ser un contenedor de elementos, puede usarse para organizar el contenido de una página web en secciones a las que se pueden:

- Aplicar estilos CSS.
- Manipular con JavaScript.
- Facilitar la maquetación y el diseño de la página.

Los divs pueden moverse dentro de la página, y pueden contener otros elementos HTML como párrafos, imágenes, listas, etc.

Un `div` puede contener otros divs, lo que permite crear estructuras complejas y anidadas.

La etiqueta `div` no tiene funcionalidad por sí sola, por ello se le aplica etiquetas y atributos para darle estilo y comportamiento.

La etiqueta `div` por defecto se adapta al ancho completo de la pantalla o contenedor padre, a menos que se le especifique un ancho diferente mediante CSS.

Para trabajar los `divs` apropiadamente, es importante crear divs padres e hijos, de manera que los divs hijos estén contenidos dentro de los divs padres. Así, podemos mover los divs hijos dentro de los divs padres y aplicarles estilos específicos.

## **Etiquetas y atributos relacionados**

- Atributo `style`:
  - Para que el `div` tenga un borde, se puede utilizar la propiedad `border` en CSS.
  - Para definir el tamaño del `div` se utilizan las propiedades `width` (ancho) y `height` (alto).
    - Si queremos que el `div` tenga un tamaño fijo, se pueden definir valores en píxeles (px)
    - Si queremos que el `div` se ajuste al tamaño del documento, se puede utilizar un valor en porcentaje (%).
  - Para definir cómo queremos que se muestre el div, se utiliza la propiedad `display`.
    - `block`: El div se muestra como un bloque, ocupando todo el ancho disponible.
    - `inline`: El div se muestra en línea con otros elementos, ocupando solo el espacio necesario.
    - `inline-block`: El div se comporta como un elemento en línea pero permite definir ancho y alto.
  - **Para crear separación** entre el borde del div y otros elementos externos, utilizamos la propiedad `margin` (margen exterior). Además, si queremos establecer un margen para cada lado del div:
    - `margin-top`: margen superior.
    - `margin-right`: margen derecho.
    - `margin-bottom`: margen inferior.
    - `margin-left`: margen izquierdo.
  - Para crear separación entre el contenido del div y su borde, utilizamos la propiedad `padding` (relleno interior).
  - Para mostrar el contenido dentro del div en columnas en lugar de filas, se utiliza `display: flex;` junto con la propiedad `flex-direction: column;`.
  - Cuando estamos trabajando con `display: flex;` para centrar el contenido dentro del div, se pueden utilizar las propiedades:
    - `text-align: center;` (para texto). También puede indicarse como `align-text: center;`, `text-align: left;` o `text-align: right;`.
    - `flex` y un número (para elementos flexibles). Por ejemplo, `flex: 1;` para que el elemento ocupe todo el espacio disponible. Puede indicarse como `flex: 0;` para que el elemento ocupe solo el espacio necesario.
    - `justify-content: center;` (para elementos flexibles). También puede indicarse como `justify-content: flex-start;` (para alinear a la izquierda) o `justify-content: flex-end;` (para alinear a la derecha).
  - Para centrar un div dentro de otro div:
    - Se puede utilizar `margin: auto;` junto con la definición de un ancho fijo.
    - También se puede utilizar `float: center;` para centrar horizontalmente. `float: left;` y `float: right;` se utilizan para alinear a la izquierda o derecha respectivamente.

Es importante tener en cuenta que para ajustar el contenido dentro de un div padre, podemos hacerlo utilizando `grid`, `flex`, `grid` o `block`, dependiendo de cómo queramos organizar los elementos dentro del div padre.
