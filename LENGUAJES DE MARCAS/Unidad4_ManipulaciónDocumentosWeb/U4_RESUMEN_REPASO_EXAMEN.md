# ⚡ U4 REPASO RÁPIDO - EXAMEN

## José Ángel Alejo | ITP 1ºDAW | RA3: Manipulación de Documentos Web

---

## 🎯 CONCEPTOS CLAVE

### DOM = Document Object Model

Estructura HTML como árbol de objetos. JavaScript accede y modifica mediante `document`.

**Lo esencial en el examen:** Seleccionar elementos → Manipular contenido → Responder eventos

### CÓDIGO EN HTML

```html
<script src="archivo.js"></script>  <!-- Al final de <body> -->
```

---

## 📌 VARIABLES

```javascript
let variable = "local";     // ✅ Recomendado
const CONSTANTE = 10;       // ✅ Para valores fijos
var antigua = "evitar";     // ❌ No usar
```

---

## 🔀 CONTROL DE FLUJO

```javascript
if (edad >= 18) { }         // Condicional
for (let i = 0; i < 5; i++) { }  // Bucle
for (let x of array) { }    // Bucle elementos
while (condición) { }       // Mientras
```

---

## 📦 FUNCIONES

```javascript
function sumar(a, b) { return a + b; }  // Función
sumar(5, 3);                             // Llamada

const multi = (a, b) => a * b;          // Arrow function
```

---

## 🔍 SELECCIONAR ELEMENTOS

| Método | Código | Resultado |
|--------|--------|-----------|
| **ID** | `document.getElementById("id")` | 1 elemento |
| **Selector** | `document.querySelector(".clase")` | 1º elemento |
| **Todos** | `document.querySelectorAll("p")` | Colección |

---

## ✏️ MANIPULAR CONTENIDO

```javascript
elemento.innerHTML = "<p>Nuevo HTML</p>";    // Cambia contenido con HTML
elemento.textContent = "Solo texto";          // Cambia solo texto
elemento.value = "nuevo valor";               // Para inputs, selects, textarea

// Acceder al contenido actual
let contenido = elemento.textContent;          // Lee el texto
let valor = input.value;                       // Lee valor del input
```

---

## 🛠️ CREAR & ELIMINAR (Opcional - probablemente no sea necesario)

```javascript
let nuevo = document.createElement("p");      // Crear elemento
nuevo.textContent = "Nuevo párrafo";
contenedor.appendChild(nuevo);                 // Añadir al final
elemento.remove();                            // Eliminar
elemento.cloneNode(true);                     // Copiar (con hijos)
```

---

## 🏷️ ATRIBUTOS

```javascript
elemento.getAttribute("href");          // Obtener
elemento.setAttribute("class", "nueva"); // Establecer
elemento.removeAttribute("disabled");   // Quitar
elemento.toggleAttribute("hidden");     // Alternar
```

---

## 🎨 ESTILOS

```javascript
elemento.style.color = "red";           // Propiedad directa
elemento.className = "activo";          // Clase completa

// classList (✅ MEJOR)
elemento.classList.add("dark");
elemento.classList.remove("light");
elemento.classList.toggle("active");
elemento.classList.contains("nav") ? true : false;
```

---

## 📊 ARRAYS & MÉTODOS

```javascript
let arr = [1, 2, 3];
arr.push(4);                    // Añadir al final
arr.pop();                      // Quitar último
arr.length;                     // Longitud
arr.map(x => x * 2);           // Transformar
arr.filter(x => x > 2);        // Filtrar
arr.forEach(x => console.log(x)); // Recorrer
```

---

## 📋 JSON

```javascript
let obj = { nombre: "José", edad: 25 };
let json = JSON.stringify(obj);  // Objeto → texto
let objeto = JSON.parse(json);   // Texto → objeto

// Fetch (cargar datos)
fetch("datos.json")
  .then(response => response.json())
  .then(data => console.log(data));
```

---

## ⚡ EVENTOS (MUY IMPORTANTE EN EXAMEN)

```javascript
// EN JAVASCRIPT (✅ Recomendado)
elemento.addEventListener("click", function() {
    console.log("Hiciste clic");
});

// O con arrow function
elemento.addEventListener("click", () => {
    console.log("Hiciste clic");
});

// Tipos comunes: click, change, input, submit, mouseover, keydown, keyup...
```

**Evitar:** `<button onclick="funcion()">` (está en HTML, no es buena práctica)

---

## 🎯 EVENTOS MÁS USADOS EN EXAMEN

### CHANGE - Para inputs y selects

```javascript
let select = document.querySelector("select");
select.addEventListener("change", (evento) => {
    let valor = evento.target.value;  // Nuevo valor
    console.log(valor);
});
```

### INPUT - Para escribir en tiempo real

```javascript
let input = document.querySelector("input");
input.addEventListener("input", (evento) => {
    console.log(evento.target.value);  // Cada carácter que se escribe
});
```

### CLICK - Es el más importante

```javascript
let boton = document.querySelector("button");
boton.addEventListener("click", () => {
    // Tu código aquí
});
```

---

## 📝 EJEMPLO PRÁCTICO: CAMBIAR COLOR

```html
<input type="color" id="picker">
<p id="texto">Mi texto</p>
```

```javascript
document.getElementById("picker").addEventListener("change", (e) => {
    document.getElementById("texto").style.color = e.target.value;
});
```

---

## ✅ CHECKLIST EXAMEN

- [ ] Seleccionar elemento correctamente (querySelector, getElementById, etc.)
- [ ] Acceder a datos: `.value` (inputs) vs `.textContent`/`.innerHTML` (divs)
- [ ] Usar `addEventListener("event", callback)` para eventos
- [ ] Manipular estilos: `elemento.style.color` o `classList.add/remove`
- [ ] Leer y cambiar atributos: `getAttribute`, `setAttribute`
- [ ] `fetch()` para cargar JSON (si es necesario)
- [ ] Arrow functions `=>` en callbacks
- [ ] Recorrer arrays: `for...of` o `.forEach()`
- [ ] Acceder a valores del evento: `evento.target.value`, `evento.target`
- [ ] `JSON.parse()` y `JSON.stringify()` si trabaja con datos

---

## 🚀 PATRÓN TÍPICO DEL EXAMEN

```javascript
// 1. Seleccionar elemento
let boton = document.querySelector("button");
let input = document.getElementById("nombre");
let items = document.querySelectorAll(".item");

// 2. Agregar evento
boton.addEventListener("click", () => {
    // 3. Hacer algo
    let valor = input.value;                // Leer
    let div = document.querySelector("div");
    div.textContent = valor;                // Escribir
    div.classList.add("highlight");        // Estilos
});
```
