# **JavaScript & DOM - José Ángel Alejo - ITP 1ºDAW - Teoría Completa Examen U4**

- **Módulo:** Lenguaje de marcas y sistemas de gestión  
- **Profesor:** José Repiso
- **Curso:** 1º DAM/DAW  
- **RA 3:** Accede y manipula documentos web utilizando lenguajes de script de cliente.

---

## 🚀 **PARA EL EXAMEN (Enfoque principal)**

**Recuerda:** El HTML está hecho. Tu trabajo será escribir JavaScript para:

1. **Seleccionar elementos** → querySelector(), getElementById(), querySelectorAll()
2. **Leer datos** → .value (inputs), .textContent (elementos)
3. **Escribir datos** → .innerHTML, .textContent, .value
4. **Escuchar eventos** → addEventListener() (click, change, input)
5. **Cambiar estilos** → .style.propiedad o .classList.add/remove()
6. **Manipular atributos** → setAttribute(), getAttribute()

**Orden de prioridad de estudio:**

1. **CRÍTICO:** Secciones 8-11 (Seleccionar, Manipular, Atributos, Estilos)
2. **CRUCIAL:** Sección 14 (Eventos)
3. **IMPORTANTE:** Secciones 4-6 (Variables, Control, Funciones)
4. **COMPLEMENTARIO:** Secciones 12-13 (Arrays, JSON)

---
<div style="page-break-after: always;"></div>

## 📋 **TABLA DE CONTENIDOS**

- [**JavaScript \& DOM - José Ángel Alejo - ITP 1ºDAW - Teoría Completa Examen U4**](#javascript--dom---josé-ángel-alejo---itp-1ºdaw---teoría-completa-examen-u4)
  - [📋 **TABLA DE CONTENIDOS**](#-tabla-de-contenidos)
  - [📌 **1. LA ESTRUCTURA CLIENTE-SERVIDOR**](#-1-la-estructura-cliente-servidor)
    - [**Componentes principales**](#componentes-principales)
    - [Capas del desarrollo web](#capas-del-desarrollo-web)
  - [💻 **2. INTRODUCCIÓN A JAVASCRIPT**](#-2-introducción-a-javascript)
    - [Definición](#definición)
    - [**Características fundamentales**](#características-fundamentales)
    - [**Diferencias con otros lenguajes**](#diferencias-con-otros-lenguajes)
  - [🔧 **3. INSERTAR CÓDIGO JAVASCRIPT EN HTML**](#-3-insertar-código-javascript-en-html)
    - [**3.1 Código interno: Etiqueta `<script>`**](#31-código-interno-etiqueta-script)
    - [**3.2 Código externo: Archivo `.js`**](#32-código-externo-archivo-js)
  - [📦 **4. VARIABLES Y CONSTANTES**](#-4-variables-y-constantes)
    - [**Declaración**](#declaración)
    - [**`let` - Variable local**](#let---variable-local)
    - [**`const` - Constante**](#const---constante)
    - [**`var` - Variable global**](#var---variable-global)
    - [**Tipos de datos**](#tipos-de-datos)
    - [**Comentarios**](#comentarios)
    - [**Depuración con consola** 🐛](#depuración-con-consola-)
  - [🔀 **5. BUCLES Y ESTRUCTURAS DE CONTROL**](#-5-bucles-y-estructuras-de-control)
    - [**Estructura condicional: `if`**](#estructura-condicional-if)
    - [**Estructura condicional: `if...else`**](#estructura-condicional-ifelse)
    - [**Operadores de comparación**](#operadores-de-comparación)
    - [**Operadores lógicos**](#operadores-lógicos)
    - [**Bucle `for`** 🔁](#bucle-for-)
    - [**Bucle `for...of` (Para elementos)**](#bucle-forof-para-elementos)
    - [**Bucle `while`**](#bucle-while)
    - [**Switch...case** 📄](#switchcase-)
  - [6. Funciones](#6-funciones)
    - [Definición de función](#definición-de-función)
    - [Llamada de función](#llamada-de-función)
    - [Función con parámetros](#función-con-parámetros)
    - [Función con retorno](#función-con-retorno)
    - [Función con múltiples parámetros](#función-con-múltiples-parámetros)
    - [Ejecutar función al hacer clic](#ejecutar-función-al-hacer-clic)
    - [Función anónima (Arrow function)](#función-anónima-arrow-function)
  - [📋 **7. MANIPULACIÓN DE DOCUMENTOS HTML: EL DOM**](#-7-manipulación-de-documentos-html-el-dom)
    - [**¿Qué es el DOM?**](#qué-es-el-dom)
    - [**El objeto `document`**](#el-objeto-document)
  - [8. Seleccionar elementos](#8-seleccionar-elementos)
    - [Por ID: `getElementById()`](#por-id-getelementbyid)
    - [Por selector CSS: `querySelector()`](#por-selector-css-queryselector)
    - [Todos los elementos: `querySelectorAll()`](#todos-los-elementos-queryselectorall)
    - [Comparación de métodos](#comparación-de-métodos)
  - [9. Manipular elementos](#9-manipular-elementos)
    - [Obtener/Cambiar contenido: `innerHTML`](#obtenercambiar-contenido-innerhtml)
    - [Obtener/Cambiar solo texto: `textContent`](#obtenercambiar-solo-texto-textcontent)
    - [Diferencia `innerHTML` vs `textContent`](#diferencia-innerhtml-vs-textcontent)
    - [Crear nuevos elementos: `createElement()`](#crear-nuevos-elementos-createelement)
    - [Añadir elemento a otro: `appendChild()`](#añadir-elemento-a-otro-appendchild)
    - [Insertar elemento en posición específica: `insertBefore()`](#insertar-elemento-en-posición-específica-insertbefore)
    - [Eliminar elementos: `remove()`](#eliminar-elementos-remove)
    - [Clonar elementos: `cloneNode()`](#clonar-elementos-clonenode)
  - [10. Manipular atributos](#10-manipular-atributos)
    - [Leer atributo: `getAttribute()`](#leer-atributo-getattribute)
    - [Establecer atributo: `setAttribute()`](#establecer-atributo-setattribute)
    - [Eliminar atributo: `removeAttribute()`](#eliminar-atributo-removeattribute)
    - [Toggle atributo: `toggleAttribute()`](#toggle-atributo-toggleattribute)
    - [Acceso directo a atributos](#acceso-directo-a-atributos)
  - [11. Manipular estilos](#11-manipular-estilos)
    - [Cambiar estilos directamente: `.style`](#cambiar-estilos-directamente-style)
    - [Nota sobre propiedades en camelCase](#nota-sobre-propiedades-en-camelcase)
    - [Cambiar clases CSS: `className`](#cambiar-clases-css-classname)
    - [Manipular clases: `classList`](#manipular-clases-classlist)
    - [Ejemplo práctico: Cambiar tema](#ejemplo-práctico-cambiar-tema)
  - [12. Arrays y bucles avanzados](#12-arrays-y-bucles-avanzados)
    - [Definir un array](#definir-un-array)
    - [Acceder a elementos](#acceder-a-elementos)
    - [Propiedades y métodos de arrays](#propiedades-y-métodos-de-arrays)
    - [Recorrer un array](#recorrer-un-array)
      - [Con `for` tradicional](#con-for-tradicional)
      - [Con `for...of`](#con-forof)
      - [Con `forEach()`](#con-foreach)
    - [Filtrar array: `filter()`](#filtrar-array-filter)
    - [Transformar array: `map()`](#transformar-array-map)
  - [13. JSON y carga de datos](#13-json-y-carga-de-datos)
    - [¿Qué es JSON?](#qué-es-json)
    - [Estructura JSON](#estructura-json)
    - [Array de objetos en JavaScript](#array-de-objetos-en-javascript)
    - [JSON interno en HTML](#json-interno-en-html)
    - [JSON externo con `fetch()`](#json-externo-con-fetch)
  - [14. Eventos en JavaScript](#14-eventos-en-javascript)
    - [¿Qué es un evento?](#qué-es-un-evento)
    - [Eventos comunes](#eventos-comunes)
    - [Formas de usar eventos](#formas-de-usar-eventos)
      - [1. Atributo en HTML (más simple)](#1-atributo-en-html-más-simple)
      - [2. Propiedad `.onclick` en JavaScript](#2-propiedad-onclick-en-javascript)
      - [3. Método `addEventListener()` (más moderno)](#3-método-addeventlistener-más-moderno)
    - [Evento `change` en selects e inputs](#evento-change-en-selects-e-inputs)
    - [Evento `input` para capturar cambios mientras escribes](#evento-input-para-capturar-cambios-mientras-escribes)
    - [Acceder al valor de inputs](#acceder-al-valor-de-inputs)
    - [Prevenir acciones por defecto](#prevenir-acciones-por-defecto)
  - [Criterios de Evaluación (RA 3)](#criterios-de-evaluación-ra-3)
  - [Ejemplo Completo: Panel de Personalización de Currículum](#ejemplo-completo-panel-de-personalización-de-currículum)
  - [Resumen de Conceptos Clave](#resumen-de-conceptos-clave)

---
<div style="page-break-after: always;"></div>

## 📌 **1. LA ESTRUCTURA CLIENTE-SERVIDOR**

### **Componentes principales**

- **Cliente (Client-side / Front-end):** Código que se ejecuta en el navegador del usuario. Maneja la estructura (HTML), presentación (CSS) e interactividad (JavaScript).
- **Servidor (Server-side / Back-end):** Hardware y software que almacena y procesa datos complejos.
- **Red:** Conexión entre clientes y servidores a través de Internet.

### Capas del desarrollo web

El desarrollo web se divide en cuatro capas ascendentes:

- **Contenido:** Texto, imágenes, multimedia (datos)
- **Estructura:** HTML, DOM (organización de contenido)
- **Presentación:** CSS (estilos visuales)
- **Comportamiento:** JavaScript (interactividad y dinamismo)

JavaScript actúa en la capa de comportamiento, **aportando dinamismo e interacciones con el usuario**.

---
<div style="page-break-after: always;"></div>

## 💻 **2. INTRODUCCIÓN A JAVASCRIPT**

### Definición

JavaScript es un lenguaje de **programación interpretado** que permite crear páginas web dinámicas e interactivas. Se ejecuta por completo en el navegador del cliente, no necesita conexión con un servidor para funcionar.

### **Características fundamentales**

| Característica     | Descripción                                                                                    |
|--------------------|------------------------------------------------------------------------------------------------|
| **Interpretado**   | El navegador ejecuta el código línea por línea sin necesidad de compilar                       |
| **Dinámico**       | Permite modificar, añadir y eliminar elementos HTML en tiempo real                             |
| **Tipado débil**   | No es necesario especificar el tipo de dato (número, texto, booleano...) al crear una variable |
| **Ligero**         | Ocupa poco espacio en memoria                                                                  |
| **Case sensitive** | Distingue entre mayúsculas y minúsculas (`nombre` ≠ `Nombre`)                                  |

### **Diferencias con otros lenguajes**

- A diferencia de HTML y CSS (lenguajes de marcas), JavaScript es un **lenguaje de programación** ❌ **NO es lenguaje de marcas**.
- Permite usar **variables, funciones, objetos** y es **Orientado a Objetos (OOP)**.
- Proporciona **interactividad real**, no solo estructura o styling.

---
<div style="page-break-after: always;"></div>

## 🔧 **3. INSERTAR CÓDIGO JAVASCRIPT EN HTML**

JavaScript se integra en HTML de **dos formas principales**:

### **3.1 Código interno: Etiqueta `<script>`**

```html
<script>
    // El código JavaScript va aquí
    console.log("Hola mundo");
</script>
```

**Ubicación recomendada:** Al final del `<body>`, justo antes de `</body>`.

**¿Por qué?** Permite que el **HTML se cargue completamente antes de ejecutar** el JavaScript. ⚠️ Si está en el `<head>`, puede haber problemas porque intenta acceder a elementos que **aún no existen**.

### **3.2 Código externo: Archivo `.js`**

```html
<script src="archivo.js"></script>
```

**Ventajas:**

- Separa el código HTML del JavaScript
- Reutilizable en múltiples páginas
- Más fácil de mantener

**Archivo `archivo.js`:**

```javascript
// Contenido del archivo externo
console.log("Este código está en un archivo externo");
```

---
<div style="page-break-after: always;"></div>

## 📦 **4. VARIABLES Y CONSTANTES**

### **Declaración**

En JavaScript moderno, se usan **tres palabras clave**:

```javascript
let edad = 25;           // Variable local
const nombre = "José";   // Constante
var ciudad = "Madrid";   // Variable global (evitar)
```

### **`let` - Variable local**

```javascript
let contador = 0;
```

- Accesible solo dentro del **bloque** donde se declara (entre llaves `{ }`)
- Permite **redeclaración y reasignación**
- ✅ **Recomendado** para la mayoría de casos

### **`const` - Constante**

```javascript
const PI = 3.14159;
const coloresDisponibles = ["rojo", "azul", "verde"];
```

- El valor **no puede cambiar** una vez asignado ❌
- Siempre es **local**
- ✅ **Buena práctica**: usar para valores que no cambian

> ⚠️ **Nota:** Aunque una constante no puede cambiar de valor, si es un **objeto o array**, sí se pueden modificar sus propiedades o elementos internos.

### **`var` - Variable global**

```javascript
var antigua = "no recomendado";
```

- Accesible en todo el código
- Puede causar **problemas de alcance**
- ❌ **No recomendado** en JavaScript moderno

### **Tipos de datos**

JavaScript asigna el tipo automáticamente:

```javascript
let numero = 42;           // Número
let texto = "Hola";        // Texto (String)
let verdadero = true;      // Booleano
let nada = null;           // Sin valor
let indefinido = undefined;// No inicializado
let lista = [1, 2, 3];     // Array
let objeto = {             // Objeto
    nombre: "José",
    edad: 25
};
```

### **Comentarios**

```javascript
// Comentario de una línea

/* Comentario de 
   múltiples líneas */
```

### **Depuración con consola** 🐛

```javascript
console.log("Mensaje de depuración");
console.error("Esto es un error");
console.warn("Esto es una advertencia");
```

**Para ver la consola en el navegador:** `F12` o `Ctrl+Mayús+K`

⚠️ **En el examen:** Usa console.log() para depurar. Abre la consola (F12) para ver errores y mensajes.

---
<div style="page-break-after: always;"></div>

## 🔀 **5. BUCLES Y ESTRUCTURAS DE CONTROL**

### **Estructura condicional: `if`**

```javascript
if (edad >= 18) {
    console.log("Eres mayor de edad");
}
```

### **Estructura condicional: `if...else`**

```javascript
if (edad >= 18) {
    console.log("Mayor de edad");
} else if (edad >= 16) {
    console.log("Casi mayor");
} else {
    console.log("Menor de edad");
}
```

### **Operadores de comparación**

```javascript
edad == 25      // Igual (flexible)
edad === 25     // Igual y mismo tipo ✅ (RECOMENDADO)
edad != 25      // Diferente
edad > 25       // Mayor que
edad < 25       // Menor que
edad >= 25      // Mayor o igual
edad <= 25      // Menor o igual
```

### **Operadores lógicos**

```javascript
edad > 18 && ciudad === "Madrid"     // AND (y)
edad > 18 || ciudad === "Madrid"     // OR (o)
!(edad > 18)                          // NOT (no)
```

### **Bucle `for`** 🔁

```javascript
for (let i = 0; i < 5; i++) {
    console.log(i); // Imprime 0, 1, 2, 3, 4
}
```

**Estructura:** `for (inicialización; condición; actualización)`

### **Bucle `for...of` (Para elementos)**

```javascript
let colores = ["rojo", "azul", "verde"];

for (let color of colores) {
    console.log(color);
}
```

### **Bucle `while`**

```javascript
let i = 0;
while (i < 5) {
    console.log(i);
    i++;
}
```

Se ejecuta **mientras** se cumpla la condición.

### **Switch...case** 📄

```javascript
let dia = 3;

switch (dia) {
    case 1:
        console.log("Lunes");
        break;
    case 2:
        console.log("Martes");
        break;
    case 3:
        console.log("Miércoles");
        break;
    default:
        console.log("Día desconocido");
}
```

---

## 6. Funciones

### Definición de función

```javascript
function saludar() {
    console.log("¡Hola!");
}
```

Solo la define, aún no se ejecuta.

### Llamada de función

```javascript
saludar(); // Ahora se ejecuta
```

### Función con parámetros

```javascript
function saludar(nombre) {
    console.log("¡Hola, " + nombre + "!");
}

saludar("José");    // Imprime: ¡Hola, José!
saludar("María");   // Imprime: ¡Hola, María!
```

### Función con retorno

```javascript
function sumar(a, b) {
    return a + b;
}

let resultado = sumar(5, 3);
console.log(resultado); // 8
```

### Función con múltiples parámetros

```javascript
function cambiarColor(elemento, color) {
    elemento.style.color = color;
}
```

### Ejecutar función al hacer clic

```html
<button onclick="saludar()">Haz clic</button>
```

Este evento ejecuta la función cuando se hace clic.

### Función anónima (Arrow function)

Sintaxis moderna:

```javascript
const sumar = (a, b) => a + b;
console.log(sumar(5, 3)); // 8
```

```javascript
const saludar = () => {
    console.log("Hola");
};

saludar();
```

---
<div style="page-break-after: always;"></div>

## 📋 **7. MANIPULACIÓN DE DOCUMENTOS HTML: EL DOM**

### **¿Qué es el DOM?**

El **DOM (Document Object Model)** es un estándar del W3C que **representa la estructura HTML como un árbol de objetos**. Permite que JavaScript acceda y modifique dinámicamente:

- **Contenido** del documento (texto)
- **Estructura** (elementos HTML)
- **Estilos** (CSS)
- **Atributos** HTML
- **Eventos** del usuario

### **El objeto `document`**

En JavaScript, `document` es el **objeto principal que representa toda la página HTML**.

```javascript
document  // Representa la página entera
document.body    // Accede al <body>
document.head    // Accede al <head>
```

---

## 8. Seleccionar elementos

Para manipular elementos, primero hay que seleccionarlos.

### Por ID: `getElementById()`

```html
<h1 id="titulo">Mi Currículum</h1>
```

```javascript
let elemento = document.getElementById("titulo");
console.log(elemento);
```

**Características:**

- Selecciona UN única elemento por su ID
- Devuelve `null` si no encuentra nada
- Las IDs deben ser únicas en la página

### Por selector CSS: `querySelector()`

```html
<p class="descripcion">Texto 1</p>
<p class="descripcion">Texto 2</p>
```

```javascript
// Selecciona el PRIMERO que coincida
let elemento = document.querySelector(".descripcion");

// Por etiqueta
let parrafo = document.querySelector("p");

// Por ID
let titulo = document.querySelector("#titulo");

// Por atributo
let input = document.querySelector("input[type='text']");
```

### Todos los elementos: `querySelectorAll()`

```javascript
// Selecciona TODOS los que coincidan
let elementos = document.querySelectorAll(".descripcion");

// Acceder al segundo elemento (índice 1)
elementos[1].innerHTML = "Nuevo texto";

// Recorrer todos
for (let i = 0; i < elementos.length; i++) {
    console.log(elementos[i].innerHTML);
}

// O con for...of
for (let elemento of elementos) {
    console.log(elemento.innerHTML);
}
```

### Comparación de métodos

| Método               | Devuelve    | Cantidad                    |
|----------------------|-------------|-----------------------------|
| `getElementById()`   | Un elemento | 1 (si existe)               |
| `querySelector()`    | Un elemento | 1 (el primero que coincida) |
| `querySelectorAll()` | NodeList    | Todos los que coincidan     |

---

## 9. Manipular elementos

### Obtener/Cambiar contenido: `innerHTML`

```html
<h1 id="titulo">Título original</h1>
```

```javascript
// Leer contenido
let contenido = document.getElementById("titulo").innerHTML;
console.log(contenido); // "Título original"

// Cambiar contenido (solo texto)
document.getElementById("titulo").innerHTML = "Nuevo título";

// Cambiar contenido (con HTML dentro)
document.getElementById("titulo").innerHTML = "Título <b>en negrita</b>";
```

### Obtener/Cambiar solo texto: `textContent`

```javascript
// Solo el texto, ignora etiquetas HTML
document.getElementById("titulo").textContent = "Nuevo título";

// No puedes incluir etiquetas HTML
document.getElementById("titulo").textContent = "Texto <b>en negrita</b>";
// Mostraría literalmente: Texto <b>en negrita</b>
```

### Diferencia `innerHTML` vs `textContent`

```html
<p id="parrafo">Hola <b>mundo</b></p>
```

```javascript
let p = document.getElementById("parrafo");

console.log(p.innerHTML);     // "Hola <b>mundo</b>"  (con etiquetas)
console.log(p.textContent);   // "Hola mundo"         (solo texto)
```

| Propiedad | Usa | Ejemplo |
|-----------|-----|----------|
| `.innerHTML` | Cuando necesites incluir HTML | `div.innerHTML = "<b>Negrita</b>"` |
| `.textContent` | Cuando solo sea texto (más seguro) | `p.textContent = "Hola"` |

**Para examen:** Si el enunciado dice cambiar texto, usa .textContent. Si dice añadir HTML, usa .innerHTML.

### Crear nuevos elementos: `createElement()`

```javascript
// Crear un nuevo párrafo
let nuevoParrafo = document.createElement("p");

// Darle contenido
nuevoParrafo.innerHTML = "Este es un nuevo párrafo";

// Darle una clase
nuevoParrafo.className = "descripcion";

// Añadirlo al final del body
document.body.appendChild(nuevoParrafo);
```

### Añadir elemento a otro: `appendChild()`

```html
<div id="contenedor"></div>
```

```javascript
let contenedor = document.getElementById("contenedor");
let nuevoDato = document.createElement("p");
nuevoDato.innerHTML = "Nuevo contenido";

// Añadir al final
contenedor.appendChild(nuevoDato);
```

### Insertar elemento en posición específica: `insertBefore()`

```html
<div id="lista">
    <p>Elemento 1</p>
    <p id="elemento2">Elemento 2</p>
    <p>Elemento 3</p>
</div>
```

```javascript
let lista = document.getElementById("lista");
let nuevoElemento = document.createElement("p");
nuevoElemento.innerHTML = "Elemento 1.5";

let elemento2 = document.getElementById("elemento2");

// Insertar antes de "elemento2"
lista.insertBefore(nuevoElemento, elemento2);
```

Resultado: Elemento 1 → Elemento 1.5 → Elemento 2 → Elemento 3

### Eliminar elementos: `remove()`

```javascript
// Eliminar un elemento por completo
let elemento = document.getElementById("titulo");
elemento.remove();
```

### Clonar elementos: `cloneNode()`

```javascript
let original = document.getElementById("miDiv");

// true = clonar con contenido incluido
let copia = original.cloneNode(true);

document.body.appendChild(copia);
```

---

## 10. Manipular atributos

### Leer atributo: `getAttribute()`

```html
<img id="foto" src="imagen.jpg" alt="Mi foto">
```

```javascript
let foto = document.getElementById("foto");
console.log(foto.getAttribute("src"));      // "imagen.jpg"
console.log(foto.getAttribute("alt"));      // "Mi foto"
```

### Establecer atributo: `setAttribute()`

```javascript
let enlace = document.getElementById("miEnlace");

// Cambiar href (URL a la que apunta)
enlace.setAttribute("href", "https://ejemplo.com");

// Cambiar alt de imagen
foto.setAttribute("alt", "Nueva descripción");

// Crear atributo que no existe
foto.setAttribute("data-autor", "José");
```

### Eliminar atributo: `removeAttribute()`

```javascript
let boton = document.getElementById("miBoton");

// Eliminar el atributo disabled
boton.removeAttribute("disabled");
```

### Toggle atributo: `toggleAttribute()`

Alterna entre activado y desactivado.

```html
<button id="btn" disabled>Desactivado</button>
```

```javascript
let boton = document.getElementById("btn");

// Primera llamada: elimina disabled (activar)
boton.toggleAttribute("disabled");

// Segunda llamada: agrega disabled (desactivar)
boton.toggleAttribute("disabled");
```

Útil para:

- `disabled` (activar/desactivar)
- `required` (campos obligatorios)
- Atributos booleanos

### Acceso directo a atributos

Algunos atributos comunes pueden accederse directamente:

```javascript
let enlace = document.getElementById("miEnlace");
enlace.href = "https://ejemplo.com";  // Equivalente a setAttribute("href", ...)

let imagen = document.getElementById("foto");
imagen.src = "nueva.jpg";              // Equivalente a setAttribute("src", ...)
```

---

## 11. Manipular estilos

### Cambiar estilos directamente: `.style`

```html
<h1 id="titulo">Mi Título</h1>
```

```javascript
let titulo = document.getElementById("titulo");

// Cambiar color
titulo.style.color = "red";

// Cambiar tamaño de fuente
titulo.style.fontSize = "32px";

// Cambiar color de fondo
titulo.style.backgroundColor = "yellow";

// Cambiar font-family (nota: camelCase)
titulo.style.fontFamily = "Arial, sans-serif";

// Cambiar margin
titulo.style.margin = "20px";

// Cambiar display
titulo.style.display = "none";    // Ocultar
titulo.style.display = "block";   // Mostrar
```

### Nota sobre propiedades en camelCase

En CSS se escriben con guión:

```css
background-color: blue;
font-family: Arial;
font-size: 20px;
```

En JavaScript se escriben en camelCase:

```javascript
style.backgroundColor = "blue";
style.fontFamily = "Arial";
style.fontSize = "20px";
```

### Cambiar clases CSS: `className`

```html
<style>
    .titulo-destacado {
        color: red;
        font-size: 32px;
        font-weight: bold;
    }
    
    .titulo-normal {
        color: black;
        font-size: 18px;
    }
</style>

<h1 id="titulo" class="titulo-normal">Mi Título</h1>
```

```javascript
let titulo = document.getElementById("titulo");

// Cambiar clase completamente
titulo.className = "titulo-destacado";
```

### Manipular clases: `classList`

```javascript
let titulo = document.getElementById("titulo");

// Agregar clase
titulo.classList.add("titulo-destacado");

// Eliminar clase
titulo.classList.remove("titulo-destacado");

// Alternar clase (toggle)
titulo.classList.toggle("titulo-destacado");

// Comprobar si tiene clase
if (titulo.classList.contains("titulo-destacado")) {
    console.log("Tiene la clase");
}
```

### Ejemplo práctico: Cambiar tema

```html
<html>
<head>
    <style>
        body {
            background-color: white;
            color: black;
        }
        
        body.modo-oscuro {
            background-color: #333;
            color: white;
        }
        
        h1 {
            color: blue;
        }
        
        h1.modo-oscuro {
            color: lightblue;
        }
    </style>
</head>
<body>
    <h1 id="titulo">Mi Título</h1>
    <button onclick="cambiarTema()">Cambiar Tema</button>
    
    <script>
        function cambiarTema() {
            document.body.classList.toggle("modo-oscuro");
            document.getElementById("titulo").classList.toggle("modo-oscuro");
        }
    </script>
</body>
</html>
```

---

## 12. Arrays y bucles avanzados

### Definir un array

```javascript
let frutas = ["manzana", "plátano", "naranja"];

// O con new
let numeros = new Array(1, 2, 3, 4, 5);

// Array vacío
let lista = [];
```

### Acceder a elementos

```javascript
let frutas = ["manzana", "plátano", "naranja"];

console.log(frutas[0]);   // "manzana"
console.log(frutas[1]);   // "plátano"
console.log(frutas[2]);   // "naranja"

// Último elemento
console.log(frutas[frutas.length - 1]); // "naranja"
```

### Propiedades y métodos de arrays

```javascript
let frutas = ["manzana", "plátano", "naranja"];

// Longitud
console.log(frutas.length); // 3

// Agregar al final
frutas.push("fresa");      // frutas = ["manzana", "plátano", "naranja", "fresa"]

// Agregar al principio
frutas.unshift("uva");     // frutas = ["uva", "manzana", "plátano", "naranja", "fresa"]

// Eliminar último
frutas.pop();              // Devuelve "fresa"

// Eliminar primero
frutas.shift();            // Devuelve "uva"

// Buscar índice
console.log(frutas.indexOf("plátano")); // 1

// Unir en texto
console.log(frutas.join(", ")); // "manzana, plátano, naranja"

// Invertir
frutas.reverse();

// Ordenar
frutas.sort();
```

### Recorrer un array

#### Con `for` tradicional

```javascript
let frutas = ["manzana", "plátano", "naranja"];

for (let i = 0; i < frutas.length; i++) {
    console.log(frutas[i]);
}
```

#### Con `for...of`

```javascript
for (let fruta of frutas) {
    console.log(fruta);
}
```

#### Con `forEach()`

```javascript
frutas.forEach((fruta, index) => {
    console.log(`${index}: ${fruta}`);
});
```

### Filtrar array: `filter()`

```javascript
let numeros = [1, 2, 3, 4, 5, 6];

// Obtener solo pares
let pares = numeros.filter(n => n % 2 === 0);
console.log(pares); // [2, 4, 6]
```

### Transformar array: `map()`

```javascript
let numeros = [1, 2, 3, 4, 5];

// Multiplicar cada número por 2
let dobles = numeros.map(n => n * 2);
console.log(dobles); // [2, 4, 6, 8, 10]
```

---

## 13. JSON y carga de datos

### ¿Qué es JSON?

**JSON (JavaScript Object Notation)** es un formato estándar para intercambiar datos. Es fácil de leer para humanos y máquinas.

### Estructura JSON

```json
[
    {
        "titulo": "El Padrino",
        "año": 1972,
        "director": "Francis Ford Coppola"
    },
    {
        "titulo": "Inception",
        "año": 2010,
        "director": "Christopher Nolan"
    }
]
```

### Array de objetos en JavaScript

```javascript
let peliculas = [
    { titulo: "El Padrino", año: 1972 },
    { titulo: "Inception", año: 2010 },
    { titulo: "Interstellar", año: 2014 }
];

// Acceder a propiedades
console.log(peliculas[0].titulo);  // "El Padrino"
console.log(peliculas[1].año);     // 2010
```

### JSON interno en HTML

```html
<table id="tablaPeliculas">
    <thead>
        <tr>
            <th>Título</th>
            <th>Año</th>
        </tr>
    </thead>
    <tbody></tbody>
</table>

<script>
    // Definir JSON
    let peliculas = [
        { titulo: "El Padrino", año: 1972 },
        { titulo: "Inception", año: 2010 },
        { titulo: "Interstellar", año: 2014 }
    ];

    // Obtener tbody
    let tabla = document.querySelector("#tablaPeliculas tbody");

    // Recorrer y agregar filas
    for (let pelicula of peliculas) {
        let fila = `<tr>
                        <td>${pelicula.titulo}</td>
                        <td>${pelicula.año}</td>
                    </tr>`;
        tabla.innerHTML += fila;
    }
</script>
```

### JSON externo con `fetch()`

```javascript
fetch("peliculas.json")
    .then(response => response.json())    // Convertir a JSON
    .then(peliculas => {
        let tabla = document.querySelector("#tablaPeliculas tbody");
        
        for (let pelicula of peliculas) {
            let fila = `<tr>
                            <td>${pelicula.titulo}</td>
                            <td>${pelicula.año}</td>
                        </tr>`;
            tabla.innerHTML += fila;
        }
    })
    .catch(error => console.error("Error:", error));
```

**Archivo `peliculas.json`:**

```json
[
    { "titulo": "El Padrino", "año": 1972 },
    { "titulo": "Inception", "año": 2010 },
    { "titulo": "Interstellar", "año": 2014 }
]
```

---

## 14. Eventos en JavaScript

### ¿Qué es un evento?

Un evento es una acción que ocurre en el navegador cuando el usuario interactúa con la página o en ciertos momentos de la carga.

🎯 **ESTO ES FUNDAMENTAL EN EL EXAMEN** - Los eventos son la base de la interactividad.

### Eventos comunes

| Evento      | Descripción                      |
|-------------|----------------------------------|
| `click`     | Hacer clic con el ratón          |
| `change`    | Cambiar el valor de un input     |
| `input`     | Escribir en un campo de texto    |
| `mouseover` | Pasar el ratón sobre un elemento |
| `mouseout`  | Sacar el ratón del elemento      |
| `focus`     | El elemento recibe el foco       |
| `blur`      | El elemento pierde el foco       |
| `keydown`   | Presionar una tecla              |
| `keyup`     | Soltar una tecla                 |
| `load`      | La página se carga completamente |
| `submit`    | Enviar un formulario             |

### Formas de usar eventos

#### 1. Atributo en HTML (más simple)

```html
<button onclick="saludar()">Haz clic</button>

<script>
    function saludar() {
        alert("¡Hola!");
    }
</script>
```

#### 2. Propiedad `.onclick` en JavaScript

```html
<button id="miBoton">Haz clic</button>

<script>
    let boton = document.getElementById("miBoton");
    
    boton.onclick = function() {
        alert("¡Hola!");
    };
</script>
```

#### 3. Método `addEventListener()` (más moderno)

```html
<button id="miBoton">Haz clic</button>

<script>
    let boton = document.getElementById("miBoton");
    
    boton.addEventListener("click", function() {
        alert("¡Hola!");
    });
</script>
```

### Evento `change` en selects e inputs

```html
<select id="tamaño" onchange="cambiarTamaño()">
    <option value="12px">Pequeño</option>
    <option value="18px">Mediano</option>
    <option value="24px">Grande</option>
</select>

<h1 id="titulo">Mi Título</h1>

<script>
    function cambiarTamaño() {
        let select = document.getElementById("tamaño");
        let titulo = document.getElementById("titulo");
        
        // El valor seleccionado
        titulo.style.fontSize = select.value;
    }
</script>
```

### Evento `input` para capturar cambios mientras escribes

```html
<input type="color" id="colorPicker" placeholder="Elige color">
<p id="parrafo">Este texto cambiará de color</p>

<script>
    document.getElementById("colorPicker").addEventListener("input", function() {
        let color = this.value;
        document.getElementById("parrafo").style.color = color;
    });
</script>
```

### Acceder al valor de inputs

```html
<input type="text" id="nombreInput" placeholder="Escribe tu nombre">
<button onclick="mostrarNombre()">Mostrar</button>

<script>
    function mostrarNombre() {
        let nombre = document.getElementById("nombreInput").value;
        alert("Tu nombre es: " + nombre);
    }
</script>
```

### Prevenir acciones por defecto

```html
<form id="miFormulario">
    <input type="text" name="email" required>
    <button type="submit">Enviar</button>
</form>

<script>
    document.getElementById("miFormulario").addEventListener("submit", function(event) {
        event.preventDefault(); // No enviar el formulario
        console.log("Envío prevenido");
    });
</script>
```

---

## Criterios de Evaluación (RA 3)

✓ **Se han identificado y clasificado los lenguajes de script de cliente** (JavaScript)  
✓ **Se ha identificado la sintaxis básica** (variables, funciones, bucles, condicionales)  
✓ **Se han utilizado métodos para seleccionar elementos** (getElementById, querySelector, querySelectorAll)  
✓ **Se han creado y modificado elementos** (createElement, appendChild, innerHTML)  
✓ **Se han eliminado elementos** (remove)  
✓ **Se han realizado modificaciones sobre estilos** (style, className, classList)  

---

## Ejemplo Completo: Panel de Personalización de Currículum

(Como el que se pide en **Activity 6**)

```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Currículum Personalizable</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            padding: 20px;
            transition: background-color 0.3s;
        }

        body.dark-mode {
            background-color: #222;
            color: white;
        }

        .contenedor {
            display: flex;
            gap: 20px;
            max-width: 1200px;
            margin: 0 auto;
        }

        /* Panel de configuración */
        .panel-config {
            width: 250px;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            max-height: 600px;
            overflow-y: auto;
        }

        body.dark-mode .panel-config {
            background-color: #333;
        }

        .panel-config h2 {
            margin-bottom: 20px;
            color: #333;
        }

        body.dark-mode .panel-config h2 {
            color: white;
        }

        .control-group {
            margin-bottom: 15px;
        }

        .control-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            font-size: 12px;
            text-transform: uppercase;
        }

        .control-group input,
        .control-group select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }

        body.dark-mode .control-group input,
        body.dark-mode .control-group select {
            background-color: #444;
            color: white;
            border-color: #555;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: bold;
            margin-top: 10px;
        }

        button:hover {
            background-color: #45a049;
        }

        /* Currículum */
        .curriculum {
            flex: 1;
            background-color: white;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        body.dark-mode .curriculum {
            background-color: #333;
            color: white;
        }

        .curriculum h1 {
            color: #4CAF50;
            margin-bottom: 10px;
        }

        .curriculum h2 {
            color: #4CAF50;
            margin-top: 25px;
            margin-bottom: 10px;
            border-bottom: 2px solid #4CAF50;
            padding-bottom: 5px;
        }

        .curriculum p {
            margin-bottom: 10px;
            line-height: 1.6;
        }

        .accent-color {
            color: #4CAF50;
        }
    </style>
</head>
<body>
    <div class="contenedor">
        <!-- Panel de Configuración -->
        <div class="panel-config">
            <h2>⚙️ Personalizar</h2>
            
            <div class="control-group">
                <label>Tipo de fuente títulos</label>
                <select id="fontTitulos" onchange="cambiarFuente()">
                    <option value="Arial, sans-serif">Arial</option>
                    <option value="Georgia, serif">Georgia</option>
                    <option value="'Courier New', monospace">Courier</option>
                    <option value="'Comic Sans MS', cursive">Comic Sans</option>
                </select>
            </div>

            <div class="control-group">
                <label>Tamaño títulos (px)</label>
                <input type="number" id="sizeTitulos" value="32" min="16" max="48" onchange="cambiarTamaño()">
            </div>

            <div class="control-group">
                <label>Color títulos</label>
                <input type="color" id="colorTitulos" value="#4CAF50" onchange="cambiarColor()">
            </div>

            <div class="control-group">
                <label>Tipo de fuente párrafos</label>
                <select id="fontParrafos" onchange="cambiarFuente()">
                    <option value="Arial, sans-serif">Arial</option>
                    <option value="Georgia, serif">Georgia</option>
                    <option value="'Courier New', monospace">Courier</option>
                </select>
            </div>

            <div class="control-group">
                <label>Tamaño párrafos (px)</label>
                <input type="number" id="sizeParrafos" value="14" min="10" max="20" onchange="cambiarTamaño()">
            </div>

            <div class="control-group">
                <label>Color párrafos</label>
                <input type="color" id="colorParrafos" value="#333333" onchange="cambiarColor()">
            </div>

            <div class="control-group">
                <label>Color de fondo</label>
                <input type="color" id="colorFondo" value="#ffffff" onchange="cambiarFondo()">
            </div>

            <div class="control-group">
                <label>Color de acentos</label>
                <input type="color" id="colorAcentos" value="#4CAF50" onchange="cambiarAcentos()">
            </div>

            <button onclick="toggleDarkMode()">🌙 Modo Oscuro</button>
            <button onclick="reiniciar()">↺ Reiniciar</button>
        </div>

        <!-- Currículum -->
        <div class="curriculum">
            <h1 id="nombre">José Ángel Alejo García</h1>
            <p id="titulo">Desarrollador Web Full Stack</p>

            <h2>Resumen</h2>
            <p id="resumen">Estudiante de Desarrollo de Aplicaciones Web con experiencia en HTML, CSS y JavaScript. Apasionado por la programación web moderna y las mejores prácticas de desarrollo.</p>

            <h2>Experiencia</h2>
            <p id="exp1"><strong>Proyectos personales</strong> - 2024 a presente<br>Desarrollo de aplicaciones web dinámicas e interactivas</p>
            <p id="exp2"><strong>Prácticas en empresa</strong> - 2024<br>Participación en proyectos web reales</p>

            <h2>Habilidades</h2>
            <p id="skills">HTML5, CSS3, JavaScript, Responsive Design, Git, Node.js, JSON, DOM Manipulation</p>

            <h2>Educación</h2>
            <p id="educacion"><strong>Grado Superior en Desarrollo de Aplicaciones Web</strong><br>Instituto de Educación (2023 - presente)</p>
        </div>
    </div>

    <script>
        // Estado inicial
        const estadoInicial = {
            fontTitulos: 'Arial, sans-serif',
            sizeTitulos: '32',
            colorTitulos: '#4CAF50',
            fontParrafos: 'Arial, sans-serif',
            sizeParrafos: '14',
            colorParrafos: '#333333',
            colorFondo: '#ffffff',
            colorAcentos: '#4CAF50'
        };

        function cambiarFuente() {
            let h1 = document.querySelector('.curriculum h1');
            let h2s = document.querySelectorAll('.curriculum h2');
            let ps = document.querySelectorAll('.curriculum p');

            let fontTitulos = document.getElementById('fontTitulos').value;
            let fontParrafos = document.getElementById('fontParrafos').value;

            h1.style.fontFamily = fontTitulos;
            h2s.forEach(h2 => h2.style.fontFamily = fontTitulos);
            ps.forEach(p => p.style.fontFamily = fontParrafos);
        }

        function cambiarTamaño() {
            let h1 = document.querySelector('.curriculum h1');
            let h2s = document.querySelectorAll('.curriculum h2');
            let ps = document.querySelectorAll('.curriculum p');

            let sizeTitulos = document.getElementById('sizeTitulos').value;
            let sizeParrafos = document.getElementById('sizeParrafos').value;

            h1.style.fontSize = sizeTitulos + 'px';
            h2s.forEach(h2 => h2.style.fontSize = (sizeTitulos * 0.7) + 'px');
            ps.forEach(p => p.style.fontSize = sizeParrafos + 'px');
        }

        function cambiarColor() {
            let h1 = document.querySelector('.curriculum h1');
            let h2s = document.querySelectorAll('.curriculum h2');
            let ps = document.querySelectorAll('.curriculum p');

            let colorTitulos = document.getElementById('colorTitulos').value;
            let colorParrafos = document.getElementById('colorParrafos').value;

            h1.style.color = colorTitulos;
            h2s.forEach(h2 => h2.style.color = colorTitulos);
            ps.forEach(p => p.style.color = colorParrafos);
        }

        function cambiarFondo() {
            let colorFondo = document.getElementById('colorFondo').value;
            document.querySelector('.curriculum').style.backgroundColor = colorFondo;
        }

        function cambiarAcentos() {
            let colorAcentos = document.getElementById('colorAcentos').value;
            let h1 = document.querySelector('.curriculum h1');
            let h2s = document.querySelectorAll('.curriculum h2');

            h1.style.color = colorAcentos;
            h2s.forEach(h2 => {
                h2.style.color = colorAcentos;
                h2.style.borderBottomColor = colorAcentos;
            });
        }

        function toggleDarkMode() {
            document.body.classList.toggle('dark-mode');
        }

        function reiniciar() {
            document.getElementById('fontTitulos').value = estadoInicial.fontTitulos;
            document.getElementById('sizeTitulos').value = estadoInicial.sizeTitulos;
            document.getElementById('colorTitulos').value = estadoInicial.colorTitulos;
            document.getElementById('fontParrafos').value = estadoInicial.fontParrafos;
            document.getElementById('sizeParrafos').value = estadoInicial.sizeParrafos;
            document.getElementById('colorParrafos').value = estadoInicial.colorParrafos;
            document.getElementById('colorFondo').value = estadoInicial.colorFondo;
            document.getElementById('colorAcentos').value = estadoInicial.colorAcentos;

            document.body.classList.remove('dark-mode');

            cambiarFuente();
            cambiarTamaño();
            cambiarColor();
            cambiarFondo();
            cambiarAcentos();
        }
    </script>
</body>
</html>
```

---

## Resumen de Conceptos Clave

| Concepto | Uso |
|----------|-----|
| **DOM** | Interfaz que permite acceder y modificar elementos HTML |
| **querySelector()** | Selecciona elementos usando selectores CSS |
| **innerHTML** | Cambia el contenido HTML de un elemento |
| **style** | Modifica estilos en línea |
| **classList** | Añade, elimina o alterna clases CSS |
| **addEventListener()** | Asigna eventos a elementos |
| **createElement()** | Crea nuevos elementos HTML |
| **appendChild()** | Añade un elemento al final de otro |
| **Arrays** | Estructuras de datos para almacenar múltiples valores |
| **Bucles** | Repiten código mientras se cumpla una condición |
| **Funciones** | Bloques de código reutilizable |
| **JSON** | Formato para intercambiar datos estructurados |

---

---

## ⚠️ **ERRORES COMUNES (EVITA ESTOS)**

### 1. Olvidar esperar a que el HTML cargue

```javascript
// ❌ MALO - El elemento no existe aún
let elemento = document.querySelector("#titulo");
elemento.innerHTML = "Hola";  // Error: null
```

```javascript
// ✅ BIEN - Esperar a que cargue
document.addEventListener("DOMContentLoaded", function() {
    let elemento = document.querySelector("#titulo");
    elemento.innerHTML = "Hola";
});
```

### 2. Confundir `.value` con `.textContent`

```html
<input type="text" id="nombre" value="José">
<p id="parrafo">Hola</p>
```

```javascript
// ❌ MALO
console.log(document.querySelector("#nombre").textContent);  // ""  (vacío)
console.log(document.querySelector("#parrafo").value);        // undefined

// ✅ BIEN
console.log(document.querySelector("#nombre").value);         // "José"
console.log(document.querySelector("#parrafo").textContent);  // "Hola"
```

### 3. No acceder a evento.target

```javascript
// ❌ MALO - `this` podría no ser lo que esperas
document.querySelector("select").addEventListener("change", function() {
    console.log(this.value);  // Funciona pero peligroso
});

// ✅ BIEN - evento.target es más explícito
document.querySelector("select").addEventListener("change", function(evento) {
    console.log(evento.target.value);  // Claro y seguro
});
```

---

## 🎯 **PATRONES TÍPICOS DE EXAMEN**

### Patrón 1: Leer input y mostrar resultado

```html
<input type="text" id="entrada">
<button id="btn">Aceptar</button>
<p id="resultado"></p>
```

```javascript
document.querySelector("#btn").addEventListener("click", function() {
    let valor = document.querySelector("#entrada").value;
    document.querySelector("#resultado").textContent = valor;
});
```

### Patrón 2: Select que cambia contenido

```html
<select id="opciones">
    <option value="azul">Azul</option>
    <option value="rojo">Rojo</option>
</select>
<p id="texto">Mi texto</p>
```

```javascript
document.querySelector("#opciones").addEventListener("change", function(evento) {
    let color = evento.target.value;
    document.querySelector("#texto").style.color = color;
});
```

### Patrón 3: Togglear clase CSS

```html
<style>
    .activo { color: green; }
</style>

<button id="btn">Activar</button>
<p id="texto">Texto</p>
```

```javascript
document.querySelector("#btn").addEventListener("click", function() {
    document.querySelector("#texto").classList.toggle("activo");
});
```

---

## 🐛 **DEBUGGING TIPS (En el examen)**

### Abre la consola (F12)

- **Windows:** `F12` o `Ctrl+Mayús+I`
- **Mac:** `Cmd+Option+I`

### Usa console.log() para ver qué pasa

```javascript
let valor = document.querySelector("#input").value;
console.log("Valor capturado: ", valor);  // Ver qué contiene
console.log("Elemento: ", document.querySelector("#input")); // Ver elemento
```

Si tu código no funciona:

1. Abre la consola (F12)
2. Busca mensajes rojos de error
3. Usa console.log() para verificar valores
4. Asegúrate de que el elemento existe

---

**Fecha de creación:** 10 de marzo de 2026  
**Última actualización:** 11 de marzo de 2026  
**Para:** Examen de Unidad 4 - Lenguaje de Marcas  
**Basado en:** Actividades 1-6 y notas de clase del Profesor José Repiso Rodríguez

---

## Resumen de Conceptos Clave (REFERENCIA RÁPIDA)

| Concepto | Uso | Ejemplo |
|----------|-----|---------|
| **querySelector()** | Seleccionar 1 elemento | `document.querySelector("#id")` |
| **querySelectorAll()** | Seleccionar múltiples | `document.querySelectorAll(".clase")` |
| **.value** | Leer input | `input.value` |
| **.textContent** | Cambiar/leer texto | `p.textContent = "Hola"` |
| **.innerHTML** | Cambiar HTML | `div.innerHTML = "<b>Texto</b>"` |
| **.style** | Cambiar estilos en línea | `elemento.style.color = "red"` |
| **.classList** | Gestionar clases CSS | `elemento.classList.add("activo")` |
| **addEventListener()** | Escuchar eventos | `btn.addEventListener("click", fn)` |
| **evento.target** | Elemento que dispara evento | `evento.target.value` |
| **createElement()** | Crear elemento HTML | `document.createElement("p")` |
| **appendChild()** | Añadir hijo | `padre.appendChild(hijo)` |
| **setAttribute()** | Establecer atributo | `img.setAttribute("src", "url")` |
| **for...of** | Recorrer array | `for (let x of array) {}` |
| **console.log()** | Debugging | `console.log(valor)` |
