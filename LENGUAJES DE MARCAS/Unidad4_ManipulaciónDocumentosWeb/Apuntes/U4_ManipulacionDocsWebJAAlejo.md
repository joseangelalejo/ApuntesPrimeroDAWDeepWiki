# Unidad 4: Manipulación de Documentos Web - Apuntes

Apuntes basados en las actividades 1, 2, 3 y 4 de la Unidad 4, integrando teoría del profesor. Solo se incluyen conceptos y técnicas usados en esas actividades.

> **Tabla de contenidos:**

- [Unidad 4: Manipulación de Documentos Web - Apuntes](#unidad-4-manipulación-de-documentos-web---apuntes)
  - [La estructura cliente-servidor](#la-estructura-cliente-servidor)
  - [Introducción a JavaScript](#introducción-a-javascript)
  - [Insertar código JavaScript en HTML](#insertar-código-javascript-en-html)
  - [Variables y constantes](#variables-y-constantes)
  - [Bucles y estructuras de control](#bucles-y-estructuras-de-control)
  - [Mensajes y entrada de datos](#mensajes-y-entrada-de-datos)
  - [Funciones](#funciones)
  - [Manipulación de documentos HTML](#manipulación-de-documentos-html)
  - [El DOM (Modelo de Objetos del Documento)](#el-dom-modelo-de-objetos-del-documento)
  - [Seleccionar elementos](#seleccionar-elementos)
  - [Manipular elementos](#manipular-elementos)
  - [Manipular atributos](#manipular-atributos)
  - [Manipular estilos](#manipular-estilos)
  - [Arrays](#arrays)
  - [Math.random](#mathrandom)
  - [Operaciones Matemáticas](#operaciones-matemáticas)

## La estructura cliente-servidor

El lado del cliente (client-side o front-end) se ejecuta en el navegador del usuario, manejando estructura y presentación. El lado del servidor (server-side o back-end) maneja datos complejos. La red conecta clientes y servidores.

Capas del desarrollo web:

- Contenido (texto, multimedia)
- Estructura (DOM, HTML)
- Presentación (CSS)
- Comportamiento (JavaScript)

JavaScript aporta dinamismo e interacciones en la capa de comportamiento.

## Introducción a JavaScript

JavaScript es un lenguaje de scripting interpretado, dinámico, de tipado débil y ligero. Es case sensitive y permite modificar documentos HTML dinámicamente.

Características clave:

- Interpretado: Se ejecuta línea por línea sin compilación previa.
- Dinámico: Modifica elementos HTML.
- De tipado débil: No requiere declarar tipos de datos.
- Ligero: Ocupa poco memoria.

## Insertar código JavaScript en HTML

- **Interno**: Usar `<script>` al final del `<body>` para ejecutar después de cargar HTML.
- **Externo**: Archivo `.js` con `<script src="archivo.js"></script>`.

Ejemplo usado en actividades: Código interno en `<script>` para funciones y manipulación DOM.

## Variables y constantes

- `let`: Variable local, accesible solo en su bloque.
- `var`: Variable global (menos recomendado).
- `const`: Constante, no modificable.

Comentarios: `//` o `/* */`. Mensajes por consola: `console.log("mensaje")`.

En actividades: Usado `let` para variables como arrays y contadores.

## Bucles y estructuras de control

- **if**: `if (condición) { ... }`
- **if-else**: `if (condición) { ... } else { ... }`
- **for**: `for (let i = 0; i < array.length; i++) { ... }` – Usado para recorrer arrays y generar listas.

No se usaron while, do-while o switch en las actividades.

## Mensajes y entrada de datos

- `alert("mensaje")`: Muestra popup con botón Aceptar.
- `prompt("mensaje")`: Pide input al usuario, devuelve string o null.

Usado en actividades para pedir nombre, contraseña o color.

## Funciones

Declaración: `function nombre() { ... }`. Llamadas vía `onclick` en botones: `<button onclick="nombre()">`.

Usado para encapsular lógica como verificaciones, cálculos y cambios de estilo.

## Manipulación de documentos HTML

JavaScript permite acceder y modificar elementos HTML mediante objetos predefinidos.

## El DOM (Modelo de Objetos del Documento)

El DOM es un estándar W3C para acceder dinámicamente al contenido, estructura y estilo de una página web. Permite añadir, eliminar, modificar elementos, atributos y estilos.

## Seleccionar elementos

- `document.getElementById("id")`: Selecciona por ID.
- `document.querySelector("selector")`: Selecciona el primer elemento que coincida con selector CSS.
- `document.querySelectorAll("selector")`: Selecciona todos los elementos (NodeList), acceder con `[i]`.

Usado en actividades para seleccionar párrafos, botones y divs.

## Manipular elementos

- `.innerText = "texto"`: Modifica texto plano.
- `.innerHTML = "<html>"`: Modifica contenido con HTML (ej. listas).
- `.remove()`: Elimina elemento.

Usado para mostrar resultados en párrafos y generar listas ordenadas/no ordenadas.

No se creó ni insertó nuevos elementos en las actividades.

## Manipular atributos

- `.setAttribute("atributo", "valor")`: Añade/modifica atributo.
- `.removeAttribute("atributo")`: Elimina atributo.
- `.toggleAttribute("atributo")`: Habilita/desactiva atributo.

No usado directamente en actividades, pero relacionado con estilos.

## Manipular estilos

- `.style.propiedad = "valor"`: Modifica estilo inline (ej. `.style.fontSize = "30px"`).
- Cambiar clase: `.className = "nuevaClase"`.

Usado para cambiar colores, tamaños de fuente y fondos.

## Arrays

- Declaración: `const array = [valores];` (ej. `const numeros = [3, 12, 7, 25, 4, 18];`).
- Acceso: `array[i]`.
- Longitud: `array.length`.
- Usado para listas de números/nombres.

## Math.random

- `Math.floor(Math.random() * max)`: Genera números aleatorios (ej. para colores RGB).

## Operaciones Matemáticas

- Básicas: `+`, `-`, `*`, `/`.
- Usado en calculadora.

- TODO: Agregar apuntes conforme avancemos en actividades y teoría en clase.
