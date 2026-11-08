# Catálogo de Películas — Proyecto LM

Proyecto educativo del módulo de **Lenguajes de Marcas** que consiste en un **catálogo dinámico de películas** con manipulación de datos JSON y CSS.

Aplicación web que permite explorar, filtrar y visualizar información de películas de forma interactiva.

## 🎬 Características

- 📋 **Catálogo dinámico** — Películas cargadas desde JSON
- 🔍 **Búsqueda y filtrado** — Por título, género, año, etc.
- 🎨 **Interfaz responsiva** — Diseño moderno y limpio
- ⚡ **Manipulación DOM** — JavaScript vanilla (sin frameworks)
- 💾 **Datos en JSON** — Estructura clara y mantenible
- 🎯 **Detalles de película** — Vista detail con información completa

## 📂 Estructura

```
Proyecto/
├── index.html             # Página principal del catálogo
├── detalle.html           # Página de detalle de película
├── styles.css             # Estilos CSS
├── peliculas.json         # Base de datos de películas
└── Premisaproyecto.md     # Especificación del proyecto
```

## 📝 Contenido de peliculas.json

```json
[
  {
    "id": 1,
    "titulo": "Nombre de la película",
    "año": 2023,
    "genero": "Acción",
    "director": "Director",
    "cartel": "url-imagen.jpg",
    "descripcion": "Sinopsis de la película",
    "duracion": 120,
    "imdb": 8.5
  }
]
```

## 🚀 Ejecución local

### Opción 1: Con Live Server (VS Code)

1. Instala la extensión **Live Server** en VS Code
2. Click derecho en `index.html` → "Open with Live Server"
3. Se abrirá automáticamente en `http://localhost:5500`

### Opción 2: Con Python

```bash
# Python 3
python -m http.server 8000

# Python 2
python -m SimpleHTTPServer 8000

# Abre http://localhost:8000
```

### Opción 3: Con Node.js

```bash
# Con http-server (instalar primero: npm install -g http-server)
http-server
```

## 🎯 Funcionalidades principales

### Página Principal (index.html)

- ✅ Lista de todas las películas
- ✅ Grid responsivo con tarjetas
- ✅ Búsqueda por título
- ✅ Filtrado por género y año
- ✅ Links a detalle de película

### Página de Detalle (detalle.html)

- ✅ Información completa de la película
- ✅ Cartel/póster en grande
- ✅ Sinopsis detallada
- ✅ Valoración IMDb
- ✅ Botón volver al catálogo

## 🔧 Modificar películas

1. Abre `peliculas.json`
2. Añade o modifica objetos de película
3. Guarda el archivo
4. Recarga la página en el navegador

```json
{
  "id": 2,
  "titulo": "Nueva Película",
  "año": 2024,
  "genero": "Drama",
  "director": "Nuevo Director",
  "cartel": "nueva-pelicula.jpg",
  "descripcion": "Sinopsis...",
  "duracion": 130,
  "imdb": 7.8
}
```

## 🎨 Personalizar estilos

Edita `styles.css` para cambiar:

- Colores de fondo
- Tipografía
- Espaciado y tamaños
- Efectos hover
- Media queries para responsividad

## 📋 Conceptos abarcados

- ✅ HTML5 semántico
- ✅ CSS3 (Grid, Flexbox, Media Queries)
- ✅ JavaScript vanilla (DOM, JSON, eventos)
- ✅ Manipulación y parseo de JSON
- ✅ Responsive design
- ✅ Buenas prácticas de estructura web

## 📚 Recursos educativos

- [MDN — Web Docs](https://developer.mozilla.org/)
- [W3Schools — HTML/CSS/JS](https://www.w3schools.com/)
- [JSON.org](https://www.json.org/)
- [CSS Grid Guide](https://css-tricks.com/snippets/css/complete-guide-grid/)

## 📝 Especificación del proyecto

Consulta `Premisaproyecto.md` para la especificación técnica y requisitos completos.

---

**Proyecto educativo** — Instituto Tecnológico Pablo de la Torre
**Centro**: ITPDAT | **Módulo**: Lenguajes de Marcas | **Ciclo**: DAW
