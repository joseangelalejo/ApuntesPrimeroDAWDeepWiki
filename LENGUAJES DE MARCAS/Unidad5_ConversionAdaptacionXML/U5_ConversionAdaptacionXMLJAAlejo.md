# UT7 — Conversión y Adaptación de Documentos XML - José Ángel Alejo

---

## Índice

1. [La Familia XSL](#1-la-familia-xsl)
2. [XPath — Navegación del árbol XML](#2-xpath--navegación-del-árbol-xml)
   - 2.1 Tipos de nodos
   - 2.2 Expresiones: estructura y sintaxis
   - 2.3 Predicados
   - 2.4 Ejes (Axis)
   - 2.5 Funciones
3. [XSLT — Transformación de documentos](#3-xslt--transformación-de-documentos)
   - 3.1 Estructura básica del archivo .xsl
   - 3.2 Elementos esenciales de XSLT
   - 3.3 Condicionales
   - 3.4 Atributos dinámicos con `xsl:attribute`
   - 3.5 Casos prácticos resueltos (XML→HTML, XML→TXT, XML→CSV, XML→JSON)
4. [XSL-FO — Documentos paginados y PDF](#4-xsl-fo--documentos-paginados-y-pdf)
   - 4.1 Estructura del archivo .fo
   - 4.2 Regiones de página
   - 4.3 Contenido: `fo:flow` y `fo:block`
   - 4.4 Conversión con Apache FOP
5. [Flujo completo XML → PDF](#5-flujo-completo-xml--pdf)
6. [Referencia rápida de errores comunes](#6-referencia-rápida-de-errores-comunes)

---

## 1. La Familia XSL

XML sirve para **almacenar** datos estructurados. La familia **XSL** (eXtensible Stylesheet Language), definida por el W3C, sirve para **transformar y presentar** esos datos en otros formatos.

| Tecnología | Nombre completo        | Para qué sirve                                                   |
|------------|------------------------|------------------------------------------------------------------|
| **XPath**  | XML Path Language      | Navegar y seleccionar nodos dentro del árbol XML                 |
| **XSLT**   | XSL Transformations    | Transformar XML en otro documento (HTML, TXT, CSV, JSON, XML…)   |
| **XSL-FO** | XSL Formatting Objects | Definir formato visual para documentos paginados (PDF, PS, RTF…) |

> **Relación entre ellas:** XPath es la herramienta de navegación que usa XSLT internamente. XSLT genera la salida (incluyendo archivos `.fo`). XSL-FO + Apache FOP produce el PDF final.

```
XML original  ──→  Procesador XSLT (.xsl)  ──→  HTML / TXT / CSV / JSON / .fo
                                                              │
                                                              ↓
                                                    Procesador XSL-FO (FOP)
                                                              │
                                                              ↓
                                                           PDF / PS / RTF
```

---

## 2. XPath — Navegación del árbol XML

XPath modela el documento XML como un **árbol de nodos**. Las expresiones se construyen como **rutas de navegación**, similar a las rutas de un sistema de archivos.

### 2.1 Tipos de nodos

| Tipo          | Descripción                                        |
|---------------|----------------------------------------------------|
| **Document**  | El documento XML completo (nodo raíz virtual, `/`) |
| **Element**   | Cada etiqueta: `<pelicula>`, `<titulo>`, etc.      |
| **Attribute** | Propiedades dentro de una etiqueta: `@id`, `@lang` |
| **Text**      | El contenido textual dentro de una etiqueta        |
| **Namespace** | Enlace URI de un espacio de nombres                |

### 2.2 Expresiones: estructura y sintaxis

La estructura formal de una expresión XPath es:

```
/axis::node_test[predicate]
```

- Los tres componentes son:
  - **axis** — dirección de búsqueda (opcional)
  - **node_test** — qué nodo buscar
  - **predicate** — filtro adicional (opcional)

#### Símbolos básicos de ruta

| Símbolo | Significado |
|---|---|
| `/` | Hijo directo (ruta absoluta desde raíz) |
| `//` | Cualquier descendiente (no necesariamente hijo directo) |
| `.` | Nodo actual |
| `..` | Nodo padre |
| `@` | Atributo (`@id`, `@lang`) |
| `*` | Comodín — cualquier elemento |

#### Ejemplos con el XML de películas

```xml
<!-- XML de ejemplo -->
<peliculas>
    <pelicula id="p1">
        <titulo>Inception</titulo>
        <genero>Ciencia Ficcion</genero>
        <anio>2010</anio>
        <precio>9.99</precio>
        <protagonistas>
            <actor>Leonardo DiCaprio</actor>
        </protagonistas>
    </pelicula>
</peliculas>
```

| Expresión XPath              | Resultado                                |
|------------------------------|------------------------------------------|
| `/peliculas/pelicula/titulo` | Todos los títulos                        |
| `/peliculas/pelicula/genero` | Todos los géneros                        |
| `//pelicula/@id`             | Todos los atributos `id`                 |
| `/peliculas/pelicula/@*`     | Todos los atributos de cada película     |
| `/peliculas/pelicula/*`      | Todos los hijos directos de `<pelicula>` |

### 2.3 Predicados

Los predicados van entre `[]` y **filtran** los nodos seleccionados.

#### Tipos de predicados

**Por posición:**

```xpath
//pelicula[1]           → primera película
//pelicula[last()]      → última película
//pelicula[last()-1]    → penúltima película
```

**Por condición lógica** (operadores: `=`, `!=`, `>`, `<`, `>=`, `<=`, `and`, `or`, `not`):

```xpath
/peliculas/pelicula[anio > 2010]/titulo          → títulos posteriores a 2010
/peliculas/pelicula[precio > 10.00]              → películas de más de 10€
/peliculas/pelicula[genero='Ciencia Ficcion']    → solo SciFi
/peliculas/pelicula[@id='p3']/titulo             → título de la película p3
```

**Por función:**

```xpath
//pelicula[contains(titulo, 'The')]              → títulos que contengan "The"
//pelicula[starts-with(titulo, 'E')]             → títulos que empiecen por "E"
```

> ⚠️ **XPath 1.0 vs 2.0:** Las funciones `avg()`, `ends-with()`, `upper-case()`, `lower-case()`, `min()`, `max()` solo funcionan en XPath 2.0. Visual Studio Code con XML Tools usa XPath 1.0. Para promedios en XPath 1.0: `sum(//precio) div count(//pelicula)`.

### 2.4 Ejes (Axis)

Los ejes permiten moverse en cualquier dirección del árbol desde la posición actual.

| Eje | Equivalente corto | Descripción |
|---|---|---|
| `child::` | `/` | Hijos directos del nodo actual |
| `descendant::` | `//` | Cualquier descendiente |
| `parent::` | `..` | Nodo padre |
| `ancestor::` | — | Cualquier antepasado |
| `attribute::` | `@` | Atributos del nodo |
| `self::` | `.` | El propio nodo actual |
| `following-sibling::` | — | Siguiente nodo hermano |
| `preceding-sibling::` | — | Anterior nodo hermano |

**Ejemplo:**

```xpath
//pelicula/following-sibling::pelicula[1]   → la película siguiente a cada película
//actor/ancestor::pelicula                  → la película contenedora de cada actor
```

### 2.5 Funciones

Funciones usables **en la ruta** (node_test) o **en predicados**:

| Función                     | Descripción                       | Disponible en      |
|-----------------------------|-----------------------------------|--------------------|
| `count(expr)`               | Número de nodos                   | XPath 1.0          |
| `sum(nodos)`                | Suma de valores numéricos         | XPath 1.0          |
| `contains(nodo,"txt")`      | `true` si contiene el texto       | XPath 1.0          |
| `starts-with(nodo,"txt")`   | `true` si empieza por el texto    | XPath 1.0          |
| `string-length(nodo)`       | Longitud de la cadena             | XPath 1.0          |
| `substring(nodo,p1,p2)`     | Subcadena entre posiciones        | XPath 1.0          |
| `string(nodo)`              | Convierte a cadena de texto       | XPath 1.0          |
| `position()`                | Posición del nodo en la iteración | XPath 1.0          |
| `last()`                    | Posición del último nodo          | XPath 1.0          |
| `text()`                    | Solo el contenido textual         | XPath 1.0          |
| `avg(nodos)`                | Media de valores numéricos        | **XPath 2.0 solo** |
| `min(nodos)` / `max(nodos)` | Mínimo / Máximo                   | **XPath 2.0 solo** |
| `ends-with(nodo,"txt")`     | `true` si termina por el texto    | **XPath 2.0 solo** |
| `upper-case(nodo)`          | Convierte a mayúsculas            | **XPath 2.0 solo** |
| `lower-case(nodo)`          | Convierte a minúsculas            | **XPath 2.0 solo** |

---

## 3. XSLT — Transformación de documentos

XSLT aplica **plantillas** (`templates`) al árbol XML. El procesador navega el árbol usando XPath y, cuando encuentra una coincidencia, genera la salida declarada en la plantilla.

**Para probar en el navegador**, añade al XML:

```xml
<?xml-stylesheet type="text/xsl" href="archivo.xsl" ?>
```

### 3.1 Estructura básica del archivo .xsl

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    
    <!-- Tipo de salida: html | xml | text -->
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>
    
    <!-- Eliminar espacios en blanco del XML fuente (recomendado) -->
    <xsl:strip-space elements="*"/>
    
    <!-- Plantilla raíz: punto de entrada -->
    <xsl:template match="/">
        <!-- Aquí va la estructura del documento de salida -->
    </xsl:template>
    
</xsl:stylesheet>
```

> El atributo `match="/"` hace que la plantilla se aplique a la raíz del documento. Es el punto de inicio de toda transformación.

### 3.2 Elementos esenciales de XSLT

#### `xsl:value-of` — Extraer texto de un nodo

```xml
<xsl:value-of select="titulo"/>
<xsl:value-of select="@id"/>
<xsl:value-of select="precio"/>
```

Inserta el contenido textual del nodo en la salida. Muy usado para rellenar celdas `<td>`.

---

#### `xsl:for-each` — Bucle sobre un conjunto de nodos

```xml
<xsl:for-each select="peliculas/pelicula">
    <li>
        <strong><xsl:value-of select="titulo"/></strong>
    </li>
</xsl:for-each>
```

Itera sobre cada nodo que coincida con la expresión XPath del `select`.

---

#### `xsl:sort` — Ordenar dentro de un bucle

Siempre va dentro de `xsl:for-each`, **antes** del contenido:

```xml
<xsl:for-each select="peliculas/pelicula">
    <xsl:sort select="titulo" data-type="text" order="ascending"/>
    <!-- contenido -->
</xsl:for-each>
```

| Atributo    | Valores posibles                             |
|-------------|----------------------------------------------|
| `select`    | Expresión XPath del campo por el que ordenar |
| `data-type` | `text` (alfabético) o `number` (numérico)    |
| `order`     | `ascending` (por defecto) o `descending`     |

---

#### `xsl:template` y `xsl:apply-templates` — Plantillas múltiples

```xml
<xsl:template match="/">
    <html><body>
        <xsl:apply-templates select="peliculas/pelicula"/>
    </body></html>
</xsl:template>

<xsl:template match="pelicula">
    <div><xsl:value-of select="titulo"/></div>
</xsl:template>
```

`apply-templates` delega el procesamiento a otra plantilla que coincida con el nodo. Sin `select`, procesa todos los hijos.

---

#### `xsl:text` — Texto literal en la salida

Imprescindible para CSV, JSON y texto plano donde cada carácter importa.

```xml
<xsl:text>nombre,edad&#10;</xsl:text>   <!-- cabecera CSV con salto de línea -->
<xsl:text>,</xsl:text>                   <!-- separador CSV -->
<xsl:text>&#10;</xsl:text>              <!-- salto de línea (newline) -->
```

- **Caracteres especiales frecuentes:**
  - `&#10;` → salto de línea (LF)
  - `&#13;` → retorno de carro (CR)
  - `&#9;` → tabulación (TAB)

---

### 3.3 Condicionales

#### `xsl:if` — Condición simple (sin else)

```xml
<xsl:if test="precio &gt; 10">
    <span style="color:red;">Premium</span>
</xsl:if>
```

> ⚠️ **Escapado obligatorio en XML:** los operadores `>` y `<` deben escribirse como `&gt;` y `&lt;` dentro de los atributos XML.

---

#### `xsl:choose` — Condición múltiple (switch/if-elseif-else)

```xml
<xsl:choose>
    <xsl:when test="precio &gt; 12">
        <span>Muy caro</span>
    </xsl:when>
    <xsl:when test="precio &gt; 9">
        <span>Precio medio</span>
    </xsl:when>
    <xsl:otherwise>
        <span>Oferta</span>
    </xsl:otherwise>
</xsl:choose>
```

---

#### Control de comas en listas (JSON/CSV)

Patrón clásico para no poner coma en el **último** elemento:

```xml
<xsl:if test="position() != last()">
    <xsl:text>,&#10;</xsl:text>
</xsl:if>
```

### 3.4 Atributos dinámicos con `xsl:attribute`

No se puede anidar una instrucción XSLT dentro de un atributo HTML directamente. Se usa `xsl:attribute`:

```xml
<!-- INCORRECTO (no válido en XML): -->
<img src="<xsl:value-of select='imagen'/>"/>

<!-- CORRECTO: -->
<img>
    <xsl:attribute name="src">
        <xsl:value-of select="imagen"/>
    </xsl:attribute>
</img>
```

### 3.5 Casos prácticos resueltos

#### Caso A — XML → HTML (lista ordenada con sublistas)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>
    <xsl:strip-space elements="*"/>

    <xsl:template match="/">
        <html lang="es">
            <head><title>Películas</title></head>
            <body>
                <h1>Listado de películas</h1>
                <ol>
                    <xsl:for-each select="peliculas/pelicula">
                        <li>
                            <strong><xsl:value-of select="titulo"/></strong>
                            <ul>
                                <li>Género: <xsl:value-of select="genero"/></li>
                                <li>Año: <xsl:value-of select="anio"/></li>
                                <li>Director: <xsl:value-of select="director"/></li>
                                <li>Protagonistas:
                                    <ul>
                                        <xsl:for-each select="protagonistas/actor">
                                            <li><xsl:value-of select="."/></li>
                                        </xsl:for-each>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </xsl:for-each>
                </ol>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
```

---

#### Caso B — XML → Texto plano (ordenado alfabéticamente)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="UTF-8"/>

    <xsl:template match="/">
        <xsl:for-each select="peliculas/pelicula">
            <xsl:sort select="titulo" data-type="text" order="ascending"/>
            <xsl:text>Título: </xsl:text><xsl:value-of select="titulo"/>
            <xsl:text> | Género: </xsl:text><xsl:value-of select="genero"/>
            <xsl:text> | Año: </xsl:text><xsl:value-of select="anio"/>
            <xsl:text>&#10;</xsl:text>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
```

---

#### Caso C — XML → CSV (con cabecera, ordenado)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="UTF-8"/>

    <xsl:template match="/">
        <!-- Línea de cabecera -->
        <xsl:text>nombre,edad&#10;</xsl:text>
        <!-- Una fila por alumno, ordenada alfabéticamente -->
        <xsl:for-each select="alumnos/alumno">
            <xsl:sort select="nombre" data-type="text" order="ascending"/>
            <xsl:value-of select="nombre"/>
            <xsl:text>,</xsl:text>
            <xsl:value-of select="edad"/>
            <xsl:text>&#10;</xsl:text>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
```

---

#### Caso D — XML → JSON (con coma controlada entre objetos)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="UTF-8"/>

    <xsl:template match="/">
        <xsl:text>{&#10;  "alumnos": [&#10;</xsl:text>
        <xsl:for-each select="alumnos/alumno">
            <xsl:sort select="nombre" data-type="text" order="ascending"/>
            <xsl:text>    {&#10;      "nombre": "</xsl:text>
            <xsl:value-of select="nombre"/>
            <xsl:text>",&#10;      "edad": "</xsl:text>
            <xsl:value-of select="edad"/>
            <xsl:text>"&#10;    }</xsl:text>
            <!-- Coma solo si NO es el último elemento -->
            <xsl:if test="position() != last()">
                <xsl:text>,&#10;</xsl:text>
            </xsl:if>
        </xsl:for-each>
        <xsl:text>&#10;  ]&#10;}</xsl:text>
    </xsl:template>
</xsl:stylesheet>
```

---

## 4. XSL-FO — Documentos paginados y PDF

XSL-FO describe **cómo se presenta visualmente** el contenido en documentos paginados. Se usa cuando el destino es PDF, PostScript, RTF o PNG.

### 4.1 Estructura del archivo .fo

Un archivo `.fo` es XML válido con el espacio de nombres `fo:`. La jerarquía obligatoria es:

```
fo:root
├── fo:layout-master-set          ← configuración de páginas
│   └── fo:simple-page-master     ← una "plantilla de página" (puede haber varias)
│       ├── fo:region-body        ← cuerpo (obligatorio)
│       ├── fo:region-before      ← cabecera (opcional)
│       ├── fo:region-after       ← pie de página (opcional)
│       ├── fo:region-start       ← lateral izquierdo (opcional)
│       └── fo:region-end         ← lateral derecho (opcional)
└── fo:page-sequence              ← el contenido real
    ├── fo:static-content         ← contenido fijo (cabeceras/pies)
    └── fo:flow                   ← contenido que fluye (cuerpo)
        └── fo:block              ← bloque de contenido (párrafos, títulos...)
```

### 4.2 Regiones de página

```xml
<?xml version="1.0" encoding="UTF-8"?>
<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <!-- 1. Definir el layout de la página -->
    <fo:layout-master-set>
        <fo:simple-page-master
            master-name="A4-vertical"
            page-height="29.7cm"
            page-width="21cm"
            margin="2cm">
            
            <fo:region-body margin-top="1.5cm" margin-bottom="1.5cm"/>
            <fo:region-before extent="1cm"/>   <!-- cabecera: 1cm -->
            <fo:region-after  extent="1cm"/>   <!-- pie:      1cm -->
        </fo:simple-page-master>
    </fo:layout-master-set>

    <!-- 2. Contenido de la página -->
    <fo:page-sequence master-reference="A4-vertical">

        <!-- Contenido fijo: cabecera -->
        <fo:static-content flow-name="xsl-region-before">
            <fo:block font-size="9pt" text-align="right">Documento Oficial</fo:block>
        </fo:static-content>

        <!-- Contenido fijo: pie de página -->
        <fo:static-content flow-name="xsl-region-after">
            <fo:block font-size="9pt" text-align="center">Página 1</fo:block>
        </fo:static-content>

        <!-- Contenido que fluye: cuerpo -->
        <fo:flow flow-name="xsl-region-body">
            <fo:block font-size="18pt" font-weight="bold" space-after="5mm">
                Título del informe
            </fo:block>
            <fo:block font-size="12pt">
                Contenido del documento...
            </fo:block>
        </fo:flow>

    </fo:page-sequence>

</fo:root>
```

### 4.3 Contenido: `fo:flow` y `fo:block`

`fo:block` es el elemento de contenido básico. Equivale a un `<div>` o párrafo en HTML.

**Atributos de estilo más usados:**

| Atributo           | Ejemplo                                 | Descripción                |
|--------------------|-----------------------------------------|----------------------------|
| `font-size`        | `12pt`                                  | Tamaño de letra            |
| `font-weight`      | `bold`                                  | Negrita                    |
| `font-family`      | `Arial`                                 | Tipografía                 |
| `color`            | `#333333`                               | Color del texto            |
| `background-color` | `#f0f0f0`                               | Fondo del bloque           |
| `text-align`       | `left` / `center` / `right` / `justify` | Alineación                 |
| `space-before`     | `5mm`                                   | Margen superior del bloque |
| `space-after`      | `5mm`                                   | Margen inferior del bloque |
| `padding`          | `3mm`                                   | Relleno interior           |
| `border-style`     | `solid`                                 | Tipo de borde              |
| `border-width`     | `1pt`                                   | Grosor del borde           |

### 4.4 Conversión con Apache FOP

Apache FOP es el procesador que convierte el `.fo` en el documento final. **Instalación en Windows:**

1. Descargar el binario desde [xmlgraphics.apache.org/fop](https://xmlgraphics.apache.org/fop/)
2. Descomprimir y copiar la ruta de la carpeta `fop/`
3. Añadir al PATH del sistema (Variables de entorno → Path → Nuevo)
4. Verificar: `fop -version`

**Comando de conversión:**

```bash
# Sintaxis general
fop archivo.fo -formato nombre_salida.ext

# Ejemplos
fop informe.fo -pdf  informe.pdf
fop informe.fo -ps   informe.ps
fop informe.fo -rtf  informe.rtf
fop informe.fo -png  informe.png
```

---

## 5. Flujo completo XML → PDF

Cuando los datos están en XML y el destino es un PDF, el proceso tiene **dos pasos**:

**Paso 1:** XSLT transforma el XML en un archivo `.fo` (con `method="xml"` en `xsl:output`)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml"/>  <!-- ← salida XML, no html -->

    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="pagina" margin="2cm"
                    page-height="29.7cm" page-width="21cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="pagina">
                <fo:flow flow-name="xsl-region-body">
                    <xsl:for-each select="peliculas/pelicula">
                        <fo:block font-size="14pt" font-weight="bold" space-after="3mm">
                            <xsl:value-of select="titulo"/>
                        </fo:block>
                        <fo:block font-size="11pt" space-after="5mm">
                            Director: <xsl:value-of select="director"/> |
                            Año: <xsl:value-of select="anio"/>
                        </fo:block>
                    </xsl:for-each>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
```

**Paso 2:** Apache FOP convierte el `.fo` en PDF:

```bash
fop peliculas.fo -pdf peliculas.pdf
```

---

## 6. Referencia rápida de errores comunes

| Error                                      | Causa                                               | Solución                                                                                    |
|--------------------------------------------|-----------------------------------------------------|---------------------------------------------------------------------------------------------|
| El XML no transforma en el navegador       | Falta la línea `<?xml-stylesheet ...?>` en el XML   | Añadir `<?xml-stylesheet type="text/xsl" href="archivo.xsl" ?>` en la segunda línea del XML |
| Error de parsing en el `.xsl`              | El XSL no es XML bien formado (etiqueta no cerrada) | Revisar que TODAS las etiquetas XSLT estén cerradas                                         |
| `>` o `<` en un `test=""` causa error      | Caracteres reservados en XML                        | Usar `&gt;` y `&lt;` en lugar de `>` y `<`                                                  |
| JSON con coma al final del último elemento | No se controla la posición                          | Añadir `<xsl:if test="position() != last()">` antes de la coma                              |
| `avg()` no funciona en Visual Studio       | XPath 1.0 no lo soporta                             | Usar `sum(//precio) div count(//pelicula)`                                                  |
| FOP dice "No such file or directory"       | No estás en la carpeta del `.fo`                    | Abrir la terminal en la carpeta correcta antes de ejecutar `fop`                            |
| Salida CSV sin saltos de línea             | Usar `method="html"` en lugar de `"text"`           | Cambiar `xsl:output method="text"`                                                          |

---

> **Consejo de examen:** El flujo siempre es el mismo: (1) identificar nodos con XPath → (2) recorrerlos con `xsl:for-each` → (3) volcar valores con `xsl:value-of` → (4) ordenar si hace falta con `xsl:sort`. Asegúrate de que el XSL está bien formado como XML antes de ejecutar.
