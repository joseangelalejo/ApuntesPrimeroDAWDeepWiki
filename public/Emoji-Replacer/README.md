# 🎯 Emoji-Replacer Suite 2.1.0

## ¿Qué es esto?

Suite completa para buscar, reemplazar y gestionar emojis ChatGPT en múltiples repositorios, con capacidad de detectar y proponer nuevos emojis.

## ⚡ Primer Uso (30 segundos)

```bash
./INICIO_RAPIDO.sh
```

## 📂 Archivos Principales

### 🟢 Ejecutables

| Archivo                     | Tamaño | Descripción                             |
|-----------------------------|--------|-----------------------------------------|
| **emoji-replacer.sh**       | 16 KB  | ⭐ Interfaz principal (menú interactivo) |
| **INICIO_RAPIDO.sh**        | →      | Asistente de setup inicial              |
| **find_emojis.sh**          | 5.1 KB | Búsqueda rápida con Bash                |
| **find_emojis.py**          | 11 KB  | Búsqueda avanzada con exportación       |
| **replace_emojis.py**       | 8.3 KB | Reemplazo seguro con backups            |
| **detect_new_emojis.py**    | 7.9 KB | Detectar emojis no mapeados             |
| **generate_proposal.py**    | 8.6 KB | Generar propuestas de contribución      |
| **TUTORIAL_INTERACTIVO.sh** | 14 KB  | Curso paso-a-paso                       |

### 🔵 Datos

| Archivo | Tamaño | Descripción |
|---------|--------|-------------|
| **emoji_unicode_map.json** | 4.5 KB | Mapeo de 34+ emojis a Unicode |

### 📖 Documentación

| Archivo                  | Tamaño | Para qué                      |
|--------------------------|--------|-------------------------------|
| **INDICE.md**            | 8.8 KB | Índice y menú completo        |
| **README_EMOJIS.md**     | 6.7 KB | Referencia técnica            |
| **WORKFLOW_COMPLETO.md** | 9.9 KB | Guía paso-a-paso con ejemplos |
| **RESUMEN_ENTREGA.txt**  | 13 KB  | Resumen de características    |

## 🚀 Cómo Usar

### Opción 1: Interfaz Interactiva (RECOMENDADO)

```bash
./emoji-replacer.sh
```

> Menú con opciones:

1. Detectar repos automáticamente
2. Seleccionar tipos de archivo
3. Buscar emojis (sin cambios)
4. Reemplazar emojis (con confirmación)
5. Generar reportes JSON
6. Detectar emojis nuevos
7. Generar propuesta de contribución
8. Ver documentación

### Opción 2: Herramientas Sueltas

```bash
# Buscar emojis
python3 find_emojis.py /ruta --json report.json

# Reemplazar (simulación)
python3 replace_emojis.py /ruta --dry-run

# Reemplazar (real)
python3 replace_emojis.py /ruta --force

# Detectar nuevos
python3 detect_new_emojis.py /ruta --json new.json
```

### Opción 3: Tutorial

```bash
./TUTORIAL_INTERACTIVO.sh
```

## 🔄 Flujos Comunes

### ✅ Reemplazar todos los emojis

```
./emoji-replacer.sh
→ Opción 1: Selecciona "a" (todos)
→ Opción 2: Tipo (ej: Documentación)
→ Opción 4: Reemplaza
```

### 📊 Auditar sin cambios

```
./emoji-replacer.sh
→ Opción 1: Selecciona repos
→ Opción 2: Tipo
→ Opción 3: Busca (sin modificar)
```

### 🆕 Contribuir nuevos emojis

```
./emoji-replacer.sh
→ Opción 6: Detecta nuevos
→ Opción 7: Genera propuesta
→ [Completa y sube PR a GitHub]
```

## 📋 Requisitos

- Bash 4.0+
- Python 3.7+
- Permisos de lectura/escritura

> Verificar:

```bash
bash --version
python3 --version
```

## 🔐 Seguridad

- ✓ Backups automáticos (.bak)
- ✓ Modo dry-run para simulación
- ✓ Confirmación antes de cambios
- ✓ Exclusión de .git y node_modules

## 🐛 Si algo falla

| Problema                | Solución                             |
|-------------------------|--------------------------------------|
| `permiso denegado`      | `chmod +x *.sh *.py`                 |
| `python3 no encontrado` | Instalar Python 3.7+                 |
| No ve repos             | Asegúrate que están en carpeta padre |

Ver más: **README_EMOJIS.md** (sección Troubleshooting)

## 📞 Soporte

- **GitHub:** [github.com/joseangelalejo/MisApuntesITPDAW](https://github.com/joseangelalejo/MisApuntesITPDAW)
- **Issues:** [github.com/joseangelalejo/MisApuntesITPDAW/issues](https://github.com/joseangelalejo/MisApuntesITPDAW/issues)
- **Email:** [joseangelcorptiv@gmail.com](mailto:joseangelcorptiv@gmail.com)

## 🎓 Documentación

- `INDICE.md` - Menú y tablas de referencia
- `README_EMOJIS.md` - Documentación técnica
- `WORKFLOW_COMPLETO.md` - Ejemplos paso-a-paso
- `RESUMEN_ENTREGA.txt` - Características completas

## 📦 Contenido

- **14 archivos**
- **~152 KB** total
- **8 scripts ejecutables**
- **5 documentos**
- **34+ emojis mapeados**

## ✨ Features

- ✓ Auto-detección de repositorios (Git, Node, Java, Python)
- ✓ Interfaz interactiva profesional
- ✓ Búsqueda rápida (Bash) y avanzada (Python/Regex)
- ✓ Reemplazo seguro con backups automáticos
- ✓ Detección de emojis nuevos
- ✓ Generación de propuestas formateadas
- ✓ Exportación JSON/CSV
- ✓ Modo dry-run
- ✓ Multi-repo processing
- ✓ Filtrado por tipo de archivo

## 🎯 Próximos Pasos

1. Ejecuta: `./INICIO_RAPIDO.sh`
2. Lee: `INDICE.md`
3. Usa: `./emoji-replacer.sh`
4. Contribuye: nuevos emojis

---

**Emoji-Replacer Suite** © 2024-2026 | MIT License | Desarrollado por joseangelalejo

**Versión:** 2.1.0 | **Estado:** Producción ✓
