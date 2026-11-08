# **Unidad 3 - Hojas de Estilo en HTML5 - José Ángel Alejo Sillero**

- [**Unidad 3 - Hojas de Estilo en HTML5 - José Ángel Alejo Sillero**](#unidad-3---hojas-de-estilo-en-html5---josé-ángel-alejo-sillero)
  - [**1. INTRODUCCIÓN A CSS**](#1-introducción-a-css)
  - [**2. ESTRUCTURA Y SINTAXIS DE CSS**](#2-estructura-y-sintaxis-de-css)
  - [**3. FORMAS DE APLICAR ESTILOS CSS**](#3-formas-de-aplicar-estilos-css)
    - [**ESTRUCTURA DE ESTILOS**](#estructura-de-estilos)
  - [**4. UNIDADES Y TIPOS DE DATOS EN CSS**](#4-unidades-y-tipos-de-datos-en-css)
    - [**UNIDADES DE LONGITUD | ABSOLUTAS Y RELATIVAS**](#unidades-de-longitud--absolutas-y-relativas)
    - [**COLORES**](#colores)
    - [**GRADIENTES**](#gradientes)
    - [**IMÁGENES DE FONDO**](#imágenes-de-fondo)
    - [**TIPOS DE LETRAS**](#tipos-de-letras)
  - [**5. SELECTORES | PSEUDOCLASES | PSEUDOELEMENTOS EN CSS**](#5-selectores--pseudoclases--pseudoelementos-en-css)
    - [**SELECTORES BÁSICOS EN CSS**](#selectores-básicos-en-css)
      - [**DE ATRIBUTOS**](#de-atributos)
      - [**AGRUPACIÓN DE SELECTORES EN CSS**](#agrupación-de-selectores-en-css)
      - [**COMBINADORES DE SELECTORES EN CSS**](#combinadores-de-selectores-en-css)
    - [**PSEUDOCLASES EN CSS**](#pseudoclases-en-css)
    - [**PSEUDOELEMENTOS EN CSS**](#pseudoelementos-en-css)
  - [**6. PROPIEDADES**](#6-propiedades)
    - [**MODELO DE CAJAS**](#modelo-de-cajas)
    - [**FLEX VS GRID**](#flex-vs-grid)
      - [**PROPIEDADES DE FLEXBOX**](#propiedades-de-flexbox)
      - [**PROPIEDADES DE GRID**](#propiedades-de-grid)
    - [**FLOAT**](#float)
    - [**POSITION**](#position)
    - [**DESBORDE (OVERFLOW)**](#desborde-overflow)
    - [**TEXTO**](#texto)
    - [**LISTAS Y TABLAS**](#listas-y-tablas)
      - [**LISTAS**](#listas)
      - [**TABLAS**](#tablas)
    - [**DISEÑO ADAPTATIVO - MEDIA QUERIES**](#diseño-adaptativo---media-queries)
  - [**7. APLICAR ESTILOS CSS - EJEMPLOS**](#7-aplicar-estilos-css---ejemplos)
    - [**EJEMPLO DE ESTILO CON CLASS**](#ejemplo-de-estilo-con-class)
    - [**EJEMPLO DE ESTILO CON ID**](#ejemplo-de-estilo-con-id)
  - [**8. EJEMPLOS DE COMBINADORES EN CSS**](#8-ejemplos-de-combinadores-en-css)
    - [EJEMPLO DE COMBINADOR DE HIJO DIRECTO (`>`)](#ejemplo-de-combinador-de-hijo-directo-)
    - [EJEMPLO DE COMBINADOR DE DESCENDIENTE (` `) con CLASS](#ejemplo-de-combinador-de-descendiente---con-class)
    - [EJEMPLO DE SELECTOR UNIVERSAL (`*`)](#ejemplo-de-selector-universal-)
    - [EJEMPLO COMPLETO](#ejemplo-completo)

## **1. INTRODUCCIÓN A CSS**

CSS (Cascading Style Sheets) es un lenguaje utilizado para describir la presentación de documentos HTML. La estructura básica de una regla CSS consta de un apartado llamado **selector** y un bloque de declaraciones.

## **2. ESTRUCTURA Y SINTAXIS DE CSS**

En CSS, las reglas de estilo se componen de dos partes principales: el **selector** y el **bloque de declaraciones**.

- **Selector** → Especifica a qué elementos HTML se aplicarán los estilos. Puede ser un nombre de etiqueta (como `p`, `h1`), una clase (precedida por un punto, como `.mi-clase`), o un ID (precedido por un símbolo de almohadilla, como `#mi-id`).
- **Bloque de declaraciones** → Contiene una o más declaraciones de estilo encerradas entre llaves `{}`. Cada declaración consta de una propiedad CSS y un valor, separados por dos puntos `:` y terminados con un punto y coma `;`. Por ejemplo, `color: red;` es una declaración que establece el color del texto en rojo.

```css
h1 {
    color: blue;          /* Propiedad: color, Valor: blue */
    font-size: 24px;     /* Propiedad: font-size, Valor: 24px */
}
```

## **3. FORMAS DE APLICAR ESTILOS CSS**

Tenemos tres formas principales de aplicar estilos CSS a un documento HTML: **en línea (inline styles)**, **internos (internal styles)** y **externos (external styles)**.

- **En línea (inline styles)** → Se aplican directamente en las etiquetas HTML mediante el atributo `style`. Esta forma no se recomienda para proyectos grandes o complejos.
- **Internos (internal styles)** → Se definen dentro de una etiqueta `<style>` en la sección `<head>` del documento HTML. Permite centralizar los estilos para una sola página.
- **Externos (external styles)** → Se crean en un archivo CSS separado y se enlazan al documento HTML mediante una etiqueta `<link>` en la sección `<head>`. Esta es la forma más recomendada, ya que permite reutilizar los estilos en múltiples páginas y mantener el código más organizado.

Existe **un orden de prioridad en la aplicación de estilos CSS**, conocido como **cascada**. La prioridad se determina por varios factores (de **mayor a menor importancia**):

1. Importancia (reglas con !important tienen máxima prioridad).
2. Especificidad del selector (cuanto más específico, más prioridad, ej. ID > clase > elemento).especificidad, pero no siempre ganan sobre estilos externos o internos más específicos.
3. Orden de aparición (el último estilo definido gana si la especificidad es igual).
4. Origen (estilos del navegador < estilos del usuario < estilos del autor). Los estilos en línea tienen alta especificidad, pero no siempre ganan sobre estilos externos o internos más específicos.

### **ESTRUCTURA DE ESTILOS**

```css
    selector {
        propiedad: valor;
        propiedad: valor;
    }
```

- Donde:
  - **Selector** → indica a qué elementos HTML se aplican los estilos. Por ejemplo, `body`, `h1`, `.clase`, `#id`, `p`, etc.
  - **Llaves** → `{}` encierran las declaraciones de estilo.
  - **Propiedad** → es el aspecto visual que se desea modificar, como `color`, `font-size`, `margin`, etc.
  - **Valor** → es el valor asignado a la propiedad, como `red`, `16px`, `10px`, etc.

En el caso de los **estilos externos**, la estructura es similar, pero con las siguientes diferencias:

1. Se **crea un archivo CSS separado** (por ejemplo, `estilos.css`) con la estructura indicada anteriormente.
2. El documento *.css* se **enlaza al documento HTML mediante la etiqueta `<link>` en la sección `<head>`** → `<link rel="stylesheet" href="estilos.css">`.

## **4. UNIDADES Y TIPOS DE DATOS EN CSS**

### **UNIDADES DE LONGITUD | ABSOLUTAS Y RELATIVAS**

En CSS, las medidas pueden ser absolutas o relativas.

- **Absolutas** → px (píxeles), cm (centímetros), mm (milímetros), Q (cuartos de milímetro), in (pulgadas),pt (puntos, 1/72 in), pc (picas, 1/16 in).
- **Relativas** → **%** (porcentaje del contenedor padre), **em** (relativo al tamaño de fuente del elemento padre), **rem** (relativo al tamaño de fuente raíz), **vw** (viewport width, 1% del ancho del viewport), **vh** (viewport height, 1% de la altura del viewport).

- **Diferencias clave:**
- Las **medidas absolutas son fijas** y no cambian con el tamaño de la pantalla o la ventana del navegador, ni varían según el dispositivo.
- Las **medidas relativas se adaptan al contexto**, varían según el tamaño de la pantalla, la ventana del navegador o el tamaño de fuente del elemento padre.

### **COLORES**

Se pueden definir de varias maneras, normalmente: Nombre del color, Valores RGB, Valores HEXADECIMALES, Valores HSL.

- **Nombre de colores** → Ejemplo: `color: red;`
- **Valores RGB** → Ejemplo: `color: rgb(255, 0, 0);`
- **Valores HEXADECIMALES** → Ejemplo: `color: #FF0000;`
- **Valores HSL** → Ejemplo: `color: hsl(0, 100%, 50%);`

### **GRADIENTES**

También se pueden aplicar degradados utilizando la propiedad `background: tipo (to direccion, color1, color2, ...);`. Donde:

- `TIPO` puede ser → `linear-gradient`, `radial-gradient`, `conic-gradient`, `repeating-linear-gradient`, `repeating-radial-gradient`, `repeating-conic-gradient`.
- `DIRECCION` puede ser → `to left`, `to right`, `to top`, `to bottom`, `to top left`, `to top right`, `to bottom left`, `to bottom right`, o un ángulo en grados (por ejemplo, `45deg`).
- `COLOR` puede ser uno o más colores (separados con comas), definidos de la misma manera que en la propiedad `background-color`.

Por ejemplo:

```css
background: radial-gradient(circle, red, yellow);
```

### **IMÁGENES DE FONDO**

Para establecer una imagen de fondo en un elemento, se utiliza la propiedad `background-image`. Ejemplo: `background-image: url('ruta/de/la/imagen.jpg');`

### **TIPOS DE LETRAS**

En CSS, se pueden utilizar diferentes tipos de letras (fuentes) para estilizar el texto. Algunos de los tipos de letras más comunes son:

- **Fuentes serif** → Tienen adornos en los extremos de las letras. Ejemplo: `font-family: 'Times New Roman', serif;`
- **Fuentes sans-serif** → No tienen adornos. Ejemplo: `font-family: 'Arial', sans-serif;`
- **Fuentes monospace** → Todas las letras ocupan el mismo espacio. Ejemplo: `font-family: 'Courier New', monospace;`
- **Fuentes cursivas (cursive)** → Se refieren a fuentes manuscritas o con estilo caligráfico, no necesariamente inclinadas (eso sería italic). Ejemplo: `font-family: 'Comic Sans MS', cursive;`

Si queremos utilizar fuentes personalizadas que no están disponibles de forma predeterminada en los navegadores, podemos utilizar servicios como Google Fonts. Para ello, se debe incluir un enlace en la sección `<head>` del documento HTML y luego aplicar la fuente en el CSS.

```html
<head>
    <link href="https://fonts.googleapis.com/css2?family=David+Libre:wght@700&family=Miracode&display=swap" rel="stylesheet">
</head>
```

Si quisieramos aplicar una fuente que tengamos instaladas en nuestro SO, podemos hacerlo directamente en la propiedad `font-family`, especificando el nombre exacto de la fuente. En mi caso, tengo "David Libre" y "Miracode" instaladas. Por ejemplo:

```css
h1 {
    font-family: 'David Libre', serif;
}
p {
    font-family: 'Miracode', monospace;
}
```

## **5. SELECTORES | PSEUDOCLASES | PSEUDOELEMENTOS EN CSS**

### **SELECTORES BÁSICOS EN CSS**

- Existen **4 tipos principales de selectores** en CSS: **Universales**, **de tipo**, **de clase** y de **ID(identificados por #)**.
  - **Selector universal (`*`)** → Aplica estilos a todos los elementos del documento.
  - **Selector de tipo:** → Aplica estilos a todos los elementos de un tipo específico, como `body`, `h1`, `p`, etc.
  - **Selector de clase (`.clase`)** → Aplica estilos a todos los elementos que tienen una clase específica.
  - **Selector de ID (`#id`)** → Aplica estilos a un único elemento que tiene un ID específico.
- También existen otros selectores más avanzados, entre los que destacan: De atributos y pseudoselectores (nos centramos en nth-child).
  - **Selector de atributos (`[atributo]`)** → Permite seleccionar elementos HTML basados en la presencia o el valor de un atributo específico.
  - **Pseudoselector nth-child(n)** → Selecciona el hijo según su posición dentro de su elemento padre. Formas comunes de usarlo:
    - Un **número específico**  → `nth-child(3)` selecciona el tercer hijo.
    - Una **fórmula**, como:
      - Hijos en posiciones pares (2, 4, 6, ...) → `nth-child(2n)`.
      - Hijos en posiciones impares (1, 3, 5, ...) → `nth-child(2n+1)`.
      - Múltiplos de un número → `nth-child(3n)` selecciona el 3º, 6º, 9º, etc.
    - Por **palabras clave**:
      - Hijos en posiciones pares → `nth-child(even)`.
      - Hijos en posiciones impares → `nth-child(odd)`.

#### **DE ATRIBUTOS**

Los selectores de atributos **permiten seleccionar elementos HTML basados en la presencia o el valor de un atributo específico**. La sintaxis básica es:

```css
[atributo] {
    /* estilos */
}
[atributo="valor"] {
    /* estilos */
}
```

- Algunas de las formas comunes de utilizar los selectores de atributos incluyen:
  - El elemento **contiene el atributo** → `elemento[atributo] { ... }`.
  - El elemento **no contiene el atributo** → `elemento:not([atributo]) { ... }`.
  - El atributo **tiene un valor específico** → `elemento[atributo="valor"] { ... }`.
  - El atributo **NO tiene un valor específico** → `elemento[atributo!="valor"] { ... }`.
  - El atributo **tiene un valor específico en algun lugar** → `elemento[atributo~="valor"] { ... }`.
    - Busca palabras completas.
    - Ignora mayúsculas, minúsculas y caracteres especiales. Por ejemplo, selecciona `valor`, `valor1 valor2`, `valor-otro`, etc.
  - El atributo **contiene un valor específico** → `elemento[atributo*="valor"] { ... }`.
    - Selecciona si el valor está en cualquier parte del atributo.
    - Se diferencia de `~=` en que este último busca palabras completas separadas por espacios, mientras que `*=` busca el valor en cualquier parte del atributo, incluso si está dentro de una palabra más grande.
  - El atributo **comienza con un valor específico** → `elemento[atributo^="valor"] { ... }`.
  - El atributo **termina con un valor específico** → `elemento[atributo$="valor"] { ... }`.

#### **AGRUPACIÓN DE SELECTORES EN CSS**

Para agrupar selectores en CSS y aplicarles los mismos estilos, se pueden separar los selectores con comas `,`. De esta manera, se puede reducir la repetición de código y mantener el CSS más limpio y organizado. La sintaxis básica sería:

```css
selector1, selector2, selector3 {
    propiedad: valor;
    propiedad: valor;
}
```

#### **COMBINADORES DE SELECTORES EN CSS**

Los combinadores son **símbolos que permiten combinar selectores para seleccionar elementos en función de su relación con otros elementos** en el documento HTML. Los combinadores más comunes son:

- De **Hermanos** → Todos los elementos de tipo B que sean hermanos de un elemento A. Sintaxis: `A ~ B` selecciona todos los elementos B que son hermanos de A.
- De **Hijos Directos** → Todos los elementos de tipo B que sean hijos directos de un elemento A. Sintaxis: `A > B` selecciona todos los elementos B que son hijos directos de A.
- De **Descendiente** → Todos los elementos de tipo B que sean descendientes de un elemento A. Sintaxis: `A B` selecciona todos los elementos B que son descendientes de A.
- De **Adyacente** → El elemento B que es el siguiente hermano inmediato de un elemento A. Sintaxis: `A + B` selecciona el primer elemento B que sigue inmediatamente a A.
- De **Descendientes de clase** → Selecciona todos los elementos que son descendientes de un elemento con una clase específica. Por ejemplo, `.contenedor p` selecciona todos los `<p>` que están dentro de cualquier elemento con la clase `contenedor`.

### **PSEUDOCLASES EN CSS**

Las pseudoclases en CSS son **palabras clave que se agregan a los selectores para especificar un estado especial** del elemento seleccionado. Se utilizan para definir estilos que se aplican cuando un elemento está en un estado particular, como cuando el usuario interactúa con él.

- **Algunas de las pseudoclases más comunes incluyen**:
  - `:hover` → Aplica estilos cuando el usuario pasa el cursor sobre un elemento.
  - `:focus` → Aplica estilos cuando un elemento recibe el foco, como al hacer clic en un campo de formulario.
  - `:checked` → Aplica estilos a los elementos de formulario que están marcados, como casillas de verificación o botones de opción.
  - `:valid` → Aplica estilos a los elementos de formulario que son válidos según las reglas de validación.
  - `:invalid` → Aplica estilos a los elementos de formulario que no son válidos según las reglas de validación.
  - `:out-of-range` → Aplica estilos a los elementos de formulario cuyo valor está fuera del rango permitido.
  - `:link` → Aplica estilos a los enlaces que aún no han sido visitados.
  - `:visited` → Aplica estilos a los enlaces que ya han sido visitados.
  - `:optional` → Aplica estilos a los elementos de formulario que no son obligatorios.
  - `:required` → Aplica estilos a los elementos de formulario que son obligatorios.

### **PSEUDOELEMENTOS EN CSS**

Son similares a las pseudoclases, pero en lugar de seleccionar por estado del elemento, permiten **seleccionar y estilizar partes específicas de un elemento**. Se utilizan para aplicar estilos a partes del contenido que no están directamente representadas en el HTML.

Para diferenciarlos de las pseudoclases, los pseudoelementos se **representan con dos puntos dobles `selector::pseudoelemento`** en lugar de uno `:`.

- Algunos de los **pseudoelementos más comunes** incluyen:
  - `::first-letter` → Selecciona la primera letra del contenido de un elemento.
  - `::first-line` → Selecciona la primera línea del contenido de un elemento.
  - `::selection` → Selecciona la parte del contenido que el usuario ha seleccionado (resaltado) con el cursor.
- Los dos siguientes pseudoelementos permiten **insertar contenido antes o después del contenido real** de un elemento:
  - `::before` → Permite insertar contenido **antes del contenido real** de un elemento.
  - `::after` → Permite **insertar contenido después del contenido real** de un elemento.
  - El contenido se define mediante la propiedad `content:`. Puede ser texto, imágenes (usando `url('')`), o vacío (`""`).
  - El content vacío (`""`) es útil para crear elementos decorativos o aplicar estilos sin añadir contenido visible. Por ejemplo, para crear un cuadro decorativo rojo tras el párrafo (CSS y HTML respectivamente):

  ```css
    .cuadro::after {
      content: "";
      display: inline-block;
      width: 16px;
      height: 16px;
      background: red;
      margin-left: 8px;
    }
  ```

  ```html
    <p class="cuadro">Este es un párrafo con un cuadro rojo al final.</p>
  ```

## **6. PROPIEDADES**

Las propiedades son las características o aspecto de un elemento que queremos modificar. No todos los tipos de elemento tienen las mismas propiedades.

### **MODELO DE CAJAS**

El modelo de cajas se refiere a que todos los elementos en HTML se ubican dentro de un contenedor rectangular llamado **"caja"**. Estas cajas tienen un conjunto de propiedades que afectan al tamaño y espacio que ocupan en la página web.

**Las propiedades principales del modelo de cajas son**:

- **MÁRGENES INTERNOS Y EXTERNOS**: Se puede indicar el margen en todas direcciones o de forma individual (top, right, bottom, left).
  - **Margin** → Margen exterior, espacio entre el elemento en sí y los objetos a su alrededor.
  - **Padding** → Margen interior, espacio entre el contenido del elemento y el borde del mismo.
- **BORDES Y OUTLINE**: Sus propiedades son similares, pero tienen diferencias importantes. Sus propiedades comunes son width y height (sin incluir espacios como padding o margin).
  - **Border** → Borde del elemento, se puede definir el grosor, estilo y color. Se pueden aplicar de forma global o individual (top, right, bottom, left).
    - Propiedades relacionadas: `border-radius` (para bordes redondeados), `border-style`, `border-width`, `border-color`.
  - **Outline** → Contorno del elemento, similar al borde pero no afecta al tamaño de la caja.
    - Propiedades relacionadas: `outline-style`, `outline-width`, `outline-color`, `outline-offset` (para separar el contorno del borde).
- **FONDOS (Background)**: Define el fondo del elemento. Sus propiedades asociadas son:
  - **`background-color`** → Color de fondo. Puede ser gradiente haciendo uso de `linear-gradient`, `radial-gradient`, etc.
  - **`background-repeat`** → Define si la imagen de fondo se repite o no. Puede ser `repeat`, `no-repeat`, `repeat-x`, `repeat-y`.
  - **`background-position`** → Define la posición de la imagen de fondo dentro del elemento (tomando como referencia la esquina superior izquierda). Puede ser valores como `top left`, `center center`, `bottom right`, o valores específicos en píxeles o porcentajes. Siempre se indica **primero la posición horizontal y luego la vertical**.
  - **`background-size`** → Define el tamaño de la imagen de fondo.
  - **`background-attachment`** → Define si la imagen de fondo se fija sobre la pantalla **(fixed)**, se desplaza al hacer scroll **(scroll)** o se desplaza con el contenido **(local)**.
  - **`background-image`** → Define la imagen de fondo del elemento. Se utiliza la función `url('ruta/de/la/imagen.jpg')` para especificar la ruta de la imagen.
  - **`opacity`** → Define la opacidad del elemento, con valores entre 0 (completamente transparente) y 1 (completamente opaco). Permite usar porcentajes (0% a 100%) en lugar de valores decimales (0 a 1), aunque es inusual
    - Por ejemplo, `opacity: 0.5;` hace que el elemento sea semi-transparente.

Los elementos HTML **se dividen en dos grandes grupos según su comportamiento en el flujo** del documento:

- **Elementos de bloque**: Ocupan todo el ancho posible del navegador, por lo que se muestran en líneas distintas.
- **Elementos de línea**: Ocupan solo la parte necesaria para mostrar su contenido, por lo que no se puede definir su ancho, alto ni márgenes verticales.

Cada *elemento se muestra de una u otra forma de manera predeterminada*. Podemos **modificar el comportamiento usando la propiedad `display`**:

- **`display: block;`** → El elemento se comporta como un bloque.
  - Los elementos se muestran en líneas distintas.
  - Se pueden definir sus dimensiones (ancho y alto).
- **`display: inline;`** → El elemento se comporta como una línea.
  - Los elementos se mostrarán en la misma línea siempre que haya espacio.
  - No se pueden definir sus dimensiones (ancho y alto).
- **`display: inline-block;`** → El elemento se comporta como una línea, pero permitiendo definir sus dimensiones (ancho y alto).
  - Se mostrarán en la misma línea siempre que haya espacio.
  - Se pueden definir sus dimensiones (ancho y alto).

### **FLEX VS GRID**

La propiedad Display permite seleccionar entre dos métodos para diseñar el layout de una página web: **Flexbox** y **Grid**.

- **Flexbox**: Los elementos se organizan en *una sola dimensión (fila o columna)*. Es ideal para diseños lineales y adaptativos. Es más sencillo de implementar para layouts simples.
- **Grid**: Los elementos se organizan en *dos dimensiones (filas y columnas)*. Es más potente para diseños complejos y estructurados.

Normalmente, se utiliza **Flexbox para componentes individuales** (como divs) y **Grid para el diseño general** de la página.

#### **PROPIEDADES DE FLEXBOX**

Las **propiedades se establecen en el elemento padre** (contenedor flex) y se aplican a los elementos hijos (elementos flex).

- **`display: flex;`** → Activa el modo flex en el contenedor.
- **`flex-direction`** → Define la dirección de los elementos dentro del contenedor en filas o columnas → `row`, `column`, `row-reverse`, `column-reverse`.
- **`flex-wrap`** → Define si los elementos deben ajustarse a una nueva línea cuando no caben en una sola línea → `nowrap`, `wrap`, `wrap-reverse`.
- **`justify-content`** → Alinea los elementos a lo largo del eje principal → `flex-start`, `flex-end`, `center`, `space-between`(), `space-around`, `space-evenly`.
- **`align-items`** → Alinea los elementos a lo largo del eje transversal → `flex-start`, `flex-end`, `center`, `baseline`, `stretch`.
- **`align-content`** → Alinea las líneas de elementos cuando hay espacio extra en el contenedor → `flex-start`, `flex-end`, `center`, `space-between`, `space-around`, `stretch`.

Además de las propiedades del contenedor padre (contenedor flex), también existen **propiedades que se aplican a los elementos hijos/interiores**, llamados items (elementos flex). Aunque los items de un contenedor flexbox pueden tener indicadas sus propiedades del modelo de cajas (márgenes, bordes, tamaño, padding...), también se pueden hacer **dinámicas** de forma que se adapten a la forma y tamaño de su contenedor padre y del resto de items.

Para ello nos servimos de **tres propiedades específicas de los items flexbox**:

- **`flex-grow`** → Define la capacidad de un elemento para **crecer si hay espacio disponible** (valor por defecto: 0).
  - Si todos los items tienen `flex-grow: 1;`, se distribuirán el espacio disponible por igual.
  - Si un item tiene `flex-grow: 2;`, otro `flex-grow: 1;` y otro `flex-grow: 3;`, el primero crecerá el doble que el segundo y el tercero crecerá tres veces más que el segundo.
- **`flex-shrink`** → Define la capacidad de un elemento para **reducirse si no hay suficiente espacio** (valor por defecto: 1).
  - Si todos los items tienen `flex-shrink: 1;`, se reducirán proporcionalmente cuando no haya suficiente espacio.
  - Si un item tiene `flex-shrink: 0;`, no se reducirá aunque no haya suficiente espacio, mientras que los otros items con `flex-shrink: 1;` se reducirán para ajustarse.
- **`flex-basis`** → Define el **tamaño inicial de un elemento antes de que se ajuste al espacio disponible** con las propiedades `flex-grow` y `flex-shrink` (valor por defecto: auto).
  - Puede establecerse en unidades absolutas o relativas o en `auto`, que toma el tamaño natural del contenido del elemento.

> **Excepciones e incompatibilidades entre propiedades de Flexbox:**

- **`align-content`** solo tiene efecto si `flex-wrap` no es `nowrap` y hay múltiples líneas de elementos (es decir, cuando los items se envuelven). Si todos los items caben en una línea, esta propiedad no se aplica.
- **`flex-shrink`** puede no reducir los elementos si hay suficiente espacio en el contenedor o si `flex-wrap` permite que los items se muevan a nuevas líneas en lugar de encogerse.
- **`flex-grow`** y **`flex-shrink`** interactúan con **`flex-basis`**: si `flex-basis` es `auto`, los valores de grow/shrink ajustan el tamaño natural; con valores fijos, sobrescriben el tamaño inicial (indicado en `flex-basis`).
- En navegadores antiguos (como Internet Explorer < 11), propiedades como `flex-wrap`, `align-content` o valores de `flex-direction` complejos pueden no ser soportadas, requiriendo prefijos o fallbacks.
- **`justify-content`** y **`align-items`** no afectan directamente a items individuales con `flex-grow`/`flex-shrink`, pero pueden influir en el espacio disponible para el crecimiento/reducción.

#### **PROPIEDADES DE GRID**

Las propiedades se establecen en el elemento padre (contenedor grid) y se aplican a los elementos hijos (elementos grid).

Antes de usar Grid, es necesario definir el contenedor grid con la propiedad `display: grid;`. O, alternativamente, `display: inline-grid;` si se desea que el contenedor tenga un comportamiento en línea. También es posible definir un contenedor grid como un contenedor flexbox, utilizando `display: flex;` junto con `display: grid;` en el mismo contenedor.

Para **definir las filas y columnas del grid en el contenedor padre**, se utilizan las siguientes propiedades (más comunes):

- **`grid-template-columns`** → Define el número y tamaño de las columnas en el grid. Se indica en unidades relativas, absolutas, automáticas o fracciones (fr, funciona de manera similar a flex-grow).
  - Ejemplo: `grid-template-columns: 20% 2fr 1fr;` define tres columnas, la primera ocupa el 20% del contenedor, la segunda ocupa dos fracciones del espacio restante y la tercera una fracción. Si dentro del contenedor grid hay más items que las celdas definidas, se crearán nuevas filas automáticamente respetando la definición de columnas.
- **`grid-template-rows`** → Define el número y tamaño de las filas en el grid. Se indica en unidades relativas, absolutas, automáticas o fracciones (fr).
  - Ejemplo: `grid-template-rows: 100px auto 2fr;` define tres filas, la primera de 100 píxeles, la segunda con altura automática según su contenido y la tercera ocupando dos fracciones del espacio restante.
  - Puede combinarse con el valor **repeat()** para definir múltiples filas o columnas iguales de forma más sencilla.
    - Ejemplo: `grid-template-rows: repeat(5, 300px);` crea cinco filas de 300 píxeles cada una.
    - Ejemplo: `grid-template-columns: repeat(3, 1fr);` crea tres columnas de igual tamaño, cada una ocupando una fracción del espacio disponible.
- **`grid-gap`** → Sintaxis: `grid-gap: fila columna;`. Forma abreviada de definir ambos `grid-row-gap` y `grid-column-gap` al mismo tiempo.
  - **`grid-row-gap`** → Define el espacio (gap) entre las filas del grid (dentro del contenedor).
  - **`grid-column-gap`** → Define el espacio (gap) entre las columnas del grid (dentro del contenedor).
  
Al igual que en Flexbox, existen propiedades que se **aplican a los elementos hijos/interiores (items grid)**. Por ejemplo, para indicar que un *item grid* ocupe varias filas o columnas, podemos **indicar su fila y columna de inicio y fin** (la de fin no se incluye) con las siguientes propiedades:

- **`grid-column-start`** → Define la columna donde comienza el item grid.
- **`grid-column-end`** → Define la columna donde termina el item grid (no se incluye).
- **`grid-row-start`** → Define la fila donde comienza el item grid.
- **`grid-row-end`** → Define la fila donde termina el item grid (no se incluye).

Estas propiedades permiten que un item grid **ocupe varias filas o columnas** dentro del contenedor grid. Estas cuatro propiedades también se pueden abreviar en dos propiedades, siendo más sencillas de utilizar:

- **`grid-column`** →  Abreviatura de `grid-column-start` y `grid-column-end`. Sintaxis: `grid-column: inicio / fin;`.
  - **Ejemplo**: `grid-column: 1 / 3;` hace que el item grid ocupe desde la columna 1 hasta la columna 3 (no se incluye la columna 3), es decir, ocupará las columnas 1 y 2.
- **`grid-row`** →  Abreviatura de `grid-row-start` y `grid-row-end`. Sintaxis: `grid-row: inicio / fin;`.
  - **Ejemplo**: `grid-row: 2 / 4;` hace que el item grid ocupe desde la fila 2 hasta la fila 4 (no se incluye la fila 4), es decir, ocupará las filas 2 y 3.
- **Consideraciones**:
  - El **valor de `inicio`** indica la línea de la columna donde comienza el item grid.
  - El **valor de `fin`** indica la línea de la columna donde termina el item grid (no se incluye).
  - Si **se desea que un item grid ocupe toda la fila o columna**, se puede utilizar la **palabra clave `span`** seguida del número de filas o columnas que debe abarcar desde el item grid de inicio.
    - Ejemplo 1: `grid-column: span 2;` hace que el item grid ocupe dos columnas completas.
    - Ejemplo 2: `grid-row: span 3;` hace que el item grid ocupe tres filas completas.

> **Excepciones e incompatibilidades entre propiedades de Grid**:

- En navegadores antiguos (como Internet Explorer < 11), muchas propiedades de Grid no son soportadas, requiriendo prefijos o fallbacks.
- El **uso combinado de Grid y Flexbox en el mismo contenedor** puede generar conflictos en la disposición de los elementos, ya que ambos métodos tienen sus propias reglas de diseño.
- Al **definir tamaños de filas y columnas con unidades relativas (como fr) junto con tamaños fijos** (como px), puede haber comportamientos inesperados si el contenedor cambia de tamaño. Por ello se recomienda utilizar principalmente unidades relativas para un diseño más adaptable, especialmente en diseños responsivos.
- El **uso de `grid-auto-flow` puede afectar la forma en que los elementos se colocan automáticamente en el grid**, lo que puede entrar en conflicto con las posiciones explícitas definidas por `grid-column` y `grid-row`.
- El **uso de `grid-template-areas` puede complicar la comprensión del diseño** si no se utiliza de manera coherente con las otras propiedades de Grid.

### **FLOAT**

Como ya sabemos, los elementos de bloque ocupan por defecto todo el ancho del navegador, y se muestran en líneas distintas. Si se le asigna un tamaño distinto, se ajustará a ese tamaño, y se mostrará por defecto a la izquierda. Pero si queremos que un elemento de bloque **se alinee a la derecha o a la izquierda** y que el resto del contenido fluya a su alrededor, podemos utilizar la propiedad `float`. La sintaxis es: `float: valor;`, donde los valores posibles son:

```css
selector {
    float: none;   /* Elimina el efecto de float, el elemento vuelve a su comportamiento por defecto */
    float: left;   /* Alinea el elemento a la izquierda */
    float: right;  /* Alinea el elemento a la derecha */
    float: inherit; /* Hereda el valor de float del elemento padre */
}
```

Además, **cuando no se indica la propiedad `float`** (o se mantiene en `none`), los elementos de bloque se posicionan uno encima del otro, en líneas distintas. Al aplicar `float: left;` o `float: right;`, lo harán en la misma línea, siempre que haya espacio suficiente en el contenedor padre.

Por otro lado, es **recomendable utilizar la propiedad `clear`** en los *elementos que siguen a un elemento flotante* para **evitar problemas de superposición o solapamiento**. La sintaxis es: `clear: valor;`, donde los valores posibles son:

```css
selector {
    clear: none;    /* No se aplica ninguna restricción de limpieza */
    clear: left;    /* El elemento no se colocará al lado izquierdo de un elemento flotante */
    clear: right;   /* El elemento no se colocará al lado derecho de un elemento flotante */
    clear: both;    /* El elemento no se colocará al lado izquierdo ni derecho de un elemento flotante */
    clear: inherit; /* Hereda el valor de clear del elemento padre */
}
```

### **POSITION**

Otra forma de posicionar elementos en una página web es mediante la propiedad `position`. Esta propiedad **permite definir cómo se posiciona un elemento en relación con su contenedor padre** o con la ventana del navegador.

Los **valores más comunes** son:

- **`static`** → Es el valor por defecto. Los elementos se posicionan en el flujo normal del documento.
- **`relative`** → El elemento se posiciona en relación a su posición original en el flujo del documento. Se pueden usar las propiedades `top`, `right`, `bottom` y `left` para mover el elemento desde su posición original.
- **`absolute`** → El elemento se posiciona en relación a su contenedor padre más cercano que tenga una posición distinta a `static`. Si no hay ningún contenedor padre con posición distinta a `static`, se posiciona en relación a la ventana del navegador. Se pueden usar las propiedades `top`, `right`, `bottom` y `left` para definir la posición exacta.
- **`fixed`** → El elemento se posiciona en relación a la ventana del navegador y permanece en la misma posición incluso cuando se hace scroll. Se pueden usar las propiedades `top`, `right`, `bottom` y `left` para definir la posición exacta.
- **`sticky`** → El elemento se comporta como `relative` hasta que alcanza un umbral definido por las propiedades `top`, `right`, `bottom` o `left`, momento en el cual se comporta como `fixed`.

Para **indicar la posición exacta cuando la propiedad `position` es distinta de `static`** (cuando el elemento está posicionado), se utilizan las siguientes propiedades:

- **`top` y `bottom`** → Define la distancia desde el borde superior/inferior(respectivamente) del contenedor padre o de la ventana del navegador (según el valor de `position`).
- **`right` y `left`** → Define la distancia desde el borde derecho/izquierdo(respectivamente) del contenedor padre o de la ventana del navegador.
- **`z-index`** → Define el orden de apilamiento de los elementos posicionados. Un elemento con un valor de `z-index` más alto se mostrará por encima de un elemento con un valor más bajo.

### **DESBORDE (OVERFLOW)**

En ocasiones, el **contenido de un elemento puede exceder el tamaño definido para ese elemento**. En estos casos, se puede utilizar la propiedad **`overflow` para controlar cómo se maneja el desbordamiento del contenido**.

Los valores más comunes son:

```css
selector {
    overflow: visible;   /* El contenido desbordado es visible */
    overflow: hidden;    /* El contenido desbordado se oculta */
    overflow: scroll;    /* Se añaden barras de desplazamiento para ver el contenido desbordado */
    overflow: auto;      /* Se añaden barras de desplazamiento solo si es necesario */
}
```

Si se desea **controlar el desbordamiento en una sola dirección (horizontal o vertical)**, se pueden utilizar las propiedades `overflow-x` y `overflow-y` de la siguiente manera:

```css
selector {
    overflow-x: valor;   /* Controla el desbordamiento horizontal */
    overflow-y: valor;   /* Controla el desbordamiento vertical */
}
```

Pueden tomar los mismos valores que la propiedad `overflow`.

El uso de la propiedad `overflow` es **especialmente útil cuando se trabaja con elementos con un tamaño fijo** y se desea controlar cómo se muestra el contenido que excede ese tamaño.

### **TEXTO**

Los **estilos de texto en CSS** son fundamentales, siendo la base de cualquier página web. Algunas de las propiedades más comunes e importantes para estilizar texto incluyen:

- **`color`** → Define el color del texto.
- **`font-size`** → Define el tamaño del texto.
- **`font-style`** → Define el estilo de la fuente (normal, italic, oblique).
- **`font-family`** → Define la familia de fuentes del texto (serif, sans-serif, monospace, cursive, fantasy, o fuentes personalizadas).
- **`font-weight`** → Define el grosor de la fuente (normal, bold, bolder, lighter, o valores numéricos del 100 al 900).
- **`text-indent`** → Define la sangría(tabulación) de la primera línea del texto.
  - Para sangrar todo el párrafo, se puede usar `padding-left` o `margin-left` en su lugar, en un selector apuntando al párrafo completo (selector de tipo `p`, clase, id, atributo, combinador, etc.). Se recomienda usar `padding-left` para no afectar al margen externo del párrafo.
- **`text-transform`** → Define la transformación del texto (uppercase, lowercase, capitalize, none).

Tenemos otras **propiedades adicionales para estilizar el texto**, como:

- **`text-decoration-line`** → Define la línea de decoración del texto (underline, overline, line-through, none).
- **`text-decoration-style`** → Define el estilo de la línea de decoración del texto (solid, double, dotted, dashed, wavy).
- **`text-decoration-color`** → Define el color de la línea de decoración del texto
- **`text-decoration`** → Se utiliza para definir todas las propiedades de decoración del texto en una sola línea. En orden: `text-decoration: line style color;`. Por ejemplo: `text-decoration: underline wavy red;`.
- **`text-shadow`** → Define una sombra para el texto. Se especifica con desplazamiento horizontal, desplazamiento vertical, desenfoque y color. Ejemplo: `text-shadow: 2px 2px 5px rgba(0,0,0,0.5);`.
- **`text-align`** → Define la alineación del texto (left, right, center, justify).
- **`line-height`** → Define la altura de la línea del texto (interlineado). Se indica en unidades relativas, absolutas o como un número sin unidad (multiplicador del tamaño de fuente, decimal o entero).
- **`letter-spacing` y `word-spacing`** → Definen el espaciado entre letras y palabras, respectivamente. Se pueden especificar en unidades relativas o absolutas.

### **LISTAS Y TABLAS**

#### **LISTAS**

- **`list-style-type`** → Define la apariencia de la viñeta o número en una lista, ya sea **desordenada** (disc, circle, square, none) o **ordenada** (decimal, lower-alpha, upper-alpha, lower-roman, upper-roman, lower-greek, lower-latin, upper-latin, none).
- **`list-style-position`** → Define la posición de la viñeta o número en relación con el contenido de la lista (inside, outside).
- **`list-style-image`** → Permite utilizar una imagen personalizada como viñeta en lugar de los estilos predeterminados. Se utiliza la función `url('ruta/de/la/imagen.png')` para especificar la ruta de la imagen.
  - Ejemplo: `list-style-image: url('images/bullet.png');`
  - Si se utiliza una imagen personalizada, las propiedades `list-style-type` y `list-style-position` no tendrán efecto.
  - Si la imagen no se puede cargar, se utilizará el estilo predeterminado definido por `list-style-type`.
  - Se puede usar una imagen diferente para cada elemento de la lista si se aplica la propiedad `list-style-image` directamente a los elementos `<li>` individuales.
- **`list-style`** → Es una forma abreviada de definir las tres propiedades anteriores en una sola línea. La sintaxis es: `list-style: type position image;`. Por ejemplo: `list-style: square inside url('images/bullet.png');`.

#### **TABLAS**

- **`border-collapse`** → Define si los bordes de las celdas de una tabla se colapsan en un solo borde o se mantienen separados. Los valores posibles son `collapse` (los bordes se colapsan) y `separate` (los bordes se mantienen separados, que es el valor por defecto).
- **`border-spacing`** → Define el espacio entre los bordes de las celdas de una tabla cuando `border-collapse` no se establece o está establecido en `separate`. Se especifica en unidades relativas o absolutas.
- **`caption-side`** → Define la posición del título (caption) de una tabla. Los valores posibles son `top` (por defecto) y `bottom`.
- **`empty-cells`** → Define si las celdas vacías de una tabla se muestran o no. Los valores posibles son `show` (mostrar, por defecto) y `hide` (ocultar).
- **`vertical-align`** → Define la alineación vertical del contenido de las celdas: `top`, `middle`, `bottom`, `baseline`.
- **`table-layout`** → Define el algoritmo utilizado para el diseño de la tabla. Los valores posibles son `auto` (por defecto, el navegador calcula el ancho de las columnas en función del contenido) y `fixed` (el ancho de las columnas se define por el ancho de la tabla y las columnas se distribuyen uniformemente).

### **DISEÑO ADAPTATIVO - MEDIA QUERIES**

Las **media queries son una característica de CSS que permite aplicar estilos específicos en función de las características del dispositivo o la ventana del navegador**, como el ancho, la altura, la resolución, la orientación, entre otros. Esto es especialmente útil para crear diseños web adaptativos (responsive design) que se ajusten a diferentes tamaños de pantalla y dispositivos.

La sintaxis básica de una media query es la siguiente:

```css
@media (condición) {
    /* estilos específicos para la condición */
}
```

La **condición** dentro de los paréntesis define cuándo se aplicarán los estilos especificados.

Las **características más comunes** que se utilizan en las media queries incluyen:

- **Ancho de la pantalla** → `width`, `min-width`, `max-width`.
  - Ejemplo: `@media (min-width: 800px) { ... }` aplica estilos si el ancho de la pantalla es de al menos 800 píxeles.
- **Altura de la pantalla** → `height`, `min-height`, `max-height`.
  - Ejemplo: `@media (max-width: 600px) { ... }` aplica estilos si el ancho de la pantalla es de 600 píxeles o menos.
- **Orientación de la pantalla** → `orientation` (landscape o portrait).
  - Ejemplo: `@media (orientation: landscape) { ... }` aplica estilos si la pantalla está en orientación horizontal.
- **Resolución de la pantalla** → `resolution`, `min-resolution`, `max-resolution`.
  - Ejemplo: `@media (min-resolution: 300dpi) { ... }` aplica estilos si la resolución de la pantalla es al menos 300 puntos por pulgada.
- **Tipo de dispositivo** → `device-width`, `device-height`, `device-aspect-ratio`.
  - Ejemplo: `@media (device-width: 768px) { ... }` aplica estilos si el ancho del dispositivo es exactamente 768 píxeles.
- **Relación de aspecto** → `aspect-ratio`, `min-aspect-ratio`, `max-aspect-ratio`.
  - Ejemplo: `@media (min-aspect-ratio: 16/9) { ... }` aplica estilos si la relación de aspecto del dispositivo es al menos 16:9.
- **Modo de color** → `color`, `min-color`, `max-color`. Se aplica según el número de bits por canal de color.
  - Ejemplo: `@media (min-color: 8) { ... }` aplica estilos si el dispositivo tiene al menos 8 bits por canal de color.

Existen muchas otras características que se pueden utilizar en las media queries, pero las mencionadas anteriormente son las más comunes y ampliamente utilizadas.

En la condición, se pueden utilizar diferentes características, pero una distinción común es entre **media queries de ancho (width)** y **media queries de altura (height)**. Es importante tener en cuenta que:

- Cuando **se utiliza `min-width`**, los estilos se aplican cuando el ancho de la pantalla es **mayor o igual** al valor especificado.
- Cuando **se utiliza `max-width`**, los estilos se aplican cuando el ancho de la pantalla es **menor o igual** al valor especificado.
- Las **condiciones pueden combinarse** utilizando operadores lógicos como `and`, `or` y `not`. Por ejemplo:
  - `@media (min-width: 600px) and (max-width: 1200px) { ... }` aplica estilos cuando el ancho de la pantalla está entre 600 y 1200 píxeles.
  - `@media (orientation: landscape) and (min-width: 800px) { ... }` aplica estilos cuando la pantalla está en orientación horizontal y tiene un ancho mínimo de 800 píxeles.
  - `@media (orientation: portrait) or (max-width: 500px) { ... }` aplica estilos cuando la pantalla está en orientación vertical o tiene un ancho máximo de 500 píxeles.
  - `@media not (orientation: landscape) and (min-width: 800px) { ... }` aplica estilos cuando la pantalla no está en orientación horizontal y tiene un ancho mínimo de 800 píxeles.
    - El operador `not` invierte la condición que sigue a continuación. No se puede utilizar para negar múltiples condiciones combinadas con `and` u `or`. Sólo puede negar una condición individual o un grupo de condiciones entre paréntesis.
    - Ejemplo de uso con paréntesis: `@media not ( (min-width: 600px) and (max-width: 1200px) ) { ... }` aplica estilos cuando el ancho de la pantalla no está entre 600 y 1200 píxeles.

Tenemos **dos formas principales de utilizar media queries** en CSS: En una hoja de estilo(interno/externo) y en el linker al CSS en el head del documento HTML.

1. **En una hoja de estilo (interno o externo)** → Se  definen los estilos específicos para diferentes condiciones, ya sea en el CSS externo o en el CSS interno del HTML.

   ```css
   @media (max-width: 600px) {
       body {
           background-color: lightblue;
       }
       p {
           font-size: 14px;
       }
   }
   @media (min-width: 601px) and (max-width: 1200px) {
       body {
           background-color: lightgreen;
       }
       p {
           font-size: 18px;
       }
   }
   @media (min-width: 1201px) {
       body {
           background-color: lightcoral;
       }
       p {
           font-size: 22px;
       }
   }
   ```

2. **Apuntando en el HTML al archivo CSS externo** → Se pueden definir media queries directamente en la etiqueta `<link>` que enlaza al archivo CSS externo, utilizando el atributo `media` .

   ```html
    <link rel="stylesheet" href="styles.css" media="(max-width: 600px)"> <!-- Estilos para pantallas pequeñas, ancho máximo de 600 píxeles  -->
    <link rel="stylesheet" href="styles-medium.css" media="(min-width: 601px) and (max-width: 1200px)"> <!-- Estilos para pantallas medianas, entre 601 y 1200 píxeles  -->
    <link rel="stylesheet" href="styles-large.css" media="(min-width: 1201px)"> <!-- Estilos para pantallas grandes, ancho mínimo de 1201 píxeles  -->
   ```

En este último ejemplo, se crean tres archivos CSS diferentes para cada rango de tamaño de pantalla. Cada archivo contendrá los estilos específicos para ese rango.

Normalmente, se utiliza una combinación de estas tres formas para lograr un diseño web adaptativo completo y eficiente. Sin embargo:

- La **forma más común es utilizar media queries dentro de un archivo CSS** externo o dentro de una etiqueta `<style>` en el documento HTML.
- **No se recomienda utilizar el atributo `media` en la etiqueta `<link>`** para archivos CSS externos, ya que puede complicar la gestión de estilos y aumentar el número de solicitudes HTTP.

## **7. APLICAR ESTILOS CSS - EJEMPLOS**

Para aplicar estilos CSS internos en un documento HTML, se utiliza la etiqueta `<style>` dentro de la sección `<head>` del documento, y la sintaxis es la misma que cuando lo aplicamos de manera externa. Con la peculiaridad de que el código CSS va dentro de la etiqueta `<style>`  y no se indica el archivo externo. (`<link rel="stylesheet" href="foo/bar.css">`). Un ejemplo básico sería el siguiente:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clase1CSS</title>
    <style>
        p {
            color: blue;
            font-family: Miracode, monospace;
            font-size: 18px;
        }
    </style>
</head>
<body>
    <p>Párrafo de prueba 1</p>
    <p style="font-family: 'David Libre Bold', serif;">Párrafo de prueba 2</p>
</body>
</html>
```

- En este ejemplo, **todos los elementos `<p>` tendrán el color azul, la fuente "Miracode" y un tamaño de 18 píxeles**, a menos que se sobrescriba con un estilo en línea, como en el segundo párrafo.
- Si aplicamos un estilo en línea, este tendrá prioridad sobre el estilo definido en la sección `<style>`, pero sólo para ese elemento específico.
- Además, al definir un estilo en línea, **sólo cambiaran las propiedades concretas especificadas**, pero las demás propiedades definidas en la sección `<style>` seguirán aplicándose.

Ahora bien, **podemos aplicar estilos concretamente a elementos con un identificador único (ID) o a elementos que comparten una clase común cambiando el selector**. Y aplicando id o class en las etiquetas HTML correspondientes.

Para ello, se utiliza el **símbolo `#` para los ID** y el **símbolo `.` para las clases**.

### **EJEMPLO DE ESTILO CON CLASS**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clase1CSS</title>
    <style>
        p {
            color: blue;
            font-family: Miracode, monospace;
            font-size: 18px;
        }
        .estilo2 {
            color: red;
            font-family: 'David Libre Bold', serif;
            font-size: 22px;
        }
    </style>
</head>
<body>
    <p>Párrafo de prueba 1</p>
    <p class="estilo2">Párrafo de prueba 2</p>
</body>
</html>
```

- En este ejemplo, el primer párrafo tendrá el estilo definido para todos los `<p>`, mientras que el segundo párrafo, que tiene la clase `estilo2`, aplicará los estilos específicos definidos para esa clase.

### **EJEMPLO DE ESTILO CON ID**

Si quisiéramos **aplicar estilos a un elemento con un ID específico**, el código sería similar, pero utilizando `#` en lugar de `.`. Y a las etiquetas HTML a las que queremos aplicar el estilo, les pondríamos el atributo `id="nombreID"`.

Por ejemplo:

```html
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clase1CSS</title>
    <style>
        /* Selector de ID */
        #estilo3 {
            color: green;
            font-family: Arial, sans-serif;
            font-size: 20px;
        }
    </style>
</head>
<body>
    <p id="estilo3">Párrafo de prueba 3</p>
</body>
</html>
```

- En este ejemplo, el párrafo con el ID `estilo3` aplicará los estilos definidos para ese ID. En este caso, el texto será verde, con la fuente Arial y un tamaño de 20 píxeles.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clase1CSS</title>
    <style>
        /* Selectores de tipo */
        p {
            color: blue;
            font-family: Miracode, monospace;
            font-size: 18px;
        }
        /* Selector de clase */
        .estilo2 {
            color: red;
            font-family: 'David Libre Bold', serif;
            font-size: 22px;
        }
        /* Selector de ID */
        #estilo3 {
            color: green;
            font-family: Arial, sans-serif;
            font-size: 20px;
        }
    </style>
</head>
<body>
    <p>Párrafo de prueba 1</p>
    <p class="estilo2">Párrafo de prueba 2</p>
    <p id="estilo3">Párrafo de prueba 3</p>
</body>
</html>
```

>En este ejemplo completo, el primer párrafo tendrá el estilo definido para todos los `<p>`, el segundo párrafo aplicará los estilos específicos de la clase `estilo2`, y el tercer párrafo, que tiene el ID `estilo3`, aplicará los estilos definidos para ese ID.

## **8. EJEMPLOS DE COMBINADORES EN CSS**

Los combinadores en CSS nos permiten seleccionar elementos en función de su relación con otros elementos en el documento HTML. A continuación, se presentan ejemplos de algunos combinadores comunes.

### EJEMPLO DE COMBINADOR DE HIJO DIRECTO (`>`)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clase1CSS</title>
    <style>
        /* Estilos para elementos hijos de padre concreto */
        ul>li {     /* En este caso, se aplicarán estilos a los elementos <li> que son hijos directos de <ul> */
            background-color: #f0f0f0;
            padding: 10px;
            border: 1px solid #ccc;
            width: 200px;
        }
    </style>
</head>
<body>
    <!-- Lista desordenada -->
    <ul>
        <li>Elemento 1</li>
        <li>Elemento 2</li>
        <li>Elemento 3</li>
    </ul>
</body>
</html>
```

En este ejemplo, los elementos `<li>` que son hijos directos de la lista `<ul>` tendrán un fondo gris claro, un padding de 10 píxeles, un borde sólido y un ancho de 200 píxeles.

### EJEMPLO DE COMBINADOR DE DESCENDIENTE (` `) con CLASS

Si quisieramos aplicar estilos a los elementos `p` que son hijos directos de un `div` con una clase específica, el código sería similar, pero agregando la clase al selector. Por ejemplo:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clase1CSS</title>
    <style>
        /* Estilos para elementos con clase concreta dentro de un div */
        div.divEstilo2 p {
            text-decoration: underline;
            color: teal;
        }
    </style>
</head>
<body>
    <!-- Div con clase específica-->
    <div class="divEstilo2">
        <p>Este párrafo está dentro de un div con clase "estilo2".</p>
    </div>
</body>
</html>
```

>En este ejemplo, los párrafos `<p>` que son hijos directos de un `<div>` con la clase `divEstilo2` tendrán un subrayado y el color teal.

### EJEMPLO DE SELECTOR UNIVERSAL (`*`)

También tenemos los selectores universales, que se representan con el símbolo `*`. Este selector aplica estilos a **todos los elementos** del documento HTML. Por ejemplo:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clase1CSS</title>
    <style>
        /* Por último, tenemos los selectores universales*/
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
    <p>Párrafo de prueba 1</p>
    <p class="estilo2">Párrafo de prueba 2</p>
    <p id="estilo3">Párrafo de prueba 3</p>
</body>
</html>
```

>En este ejemplo, todos los elementos del documento tendrán un margen y padding de 0, y el box-sizing se establecerá en border-box, lo que afecta cómo se calculan las dimensiones de los elementos.

### EJEMPLO COMPLETO

A continuación, se muestra un **ejemplo completo que incluye todos los conceptos mencionados anteriormente**:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clase1CSS</title>
    <style>
        /* Selectores de tipo */
        p {
            color: blue;
            font-family: Miracode, monospace;
            font-size: 18px;
        }
        /* Selector de clase */
        .estilo2 {
            color: red;
            font-family: 'David Libre Bold', serif;
            font-size: 22px;
        }
        /* Selector de ID */
        #estilo3 {
            color: green;
            font-family: Arial, sans-serif;
            font-size: 20px;
        }
        /* Estilos para elementos hijos de padre concreto */
        ul>li {     /* En este caso, se aplicarán estilos a los elementos <li> que son hijos directos de <ul> */
            background-color: #f0f0f0;
            padding: 10px;
            border: 1px solid #ccc;
            width: 200px;
            font-size: 16px;
            font-family: 'Courier New', Courier, monospace;
            font-style: italic;
            font-weight: bold;
            color: brown;
        }
        /* En este caso, se aplicarán estilos a los elementos <p> que son hijos directos de <div> y <form> */
        div>form>p {
            font-style: italic;
            color: purple;
        }
        /* Si quisiéramos aplicar estilos a todos los elementos de un tipo concreto que se encuentren dentro de un div */
        div p {
            font-weight: bold;
            color: orange;
        }
        /* Estilos para elementos con clase concreta dentro de un div */
        div.divEstilo2 p {
            text-decoration: underline;
            color: teal;
        }
        /* Por último, tenemos los selectores universales*/
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        /* El selector universal (*) aplica estilos a todos los elementos del documento */
    </style>
</head>
<body>
    <p>Párrafo de prueba 1</p>
    <p class="estilo2">Párrafo de prueba 2</p>
    <p id="estilo3">Párrafo de prueba 3</p>
    <!-- Lista desordenada -->
    <ul>
        <li>Elemento 1</li>
        <li>Elemento 2</li>
        <li>Elemento 3</li>
    </ul>
    <!-- Div con formulario -->
    <div>
        <form>
            <p>Este párrafo está dentro de un formulario que a su vez está dentro de un div.</p>
        </form>
    </div>
    <!-- Div con párrafos -->
    <div>
        <p>Este es un párrafo dentro de un div.</p>
        <p style="color: blue;">Otro párrafo dentro del mismo div.</p>
    </div>
    <!-- Div con clase específica-->
    <div class="divEstilo2">
        <p>Este párrafo está dentro de un div con clase "estilo2".</p>
    </div>
</body>
</html>
```

>En este ejemplo completo, se aplican diferentes estilos a párrafos, listas y elementos dentro de divs y formularios, utilizando selectores de tipo, clase, ID y relaciones padre-hijo.
