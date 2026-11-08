# 🔄 Workflow Completo: Emoji-Replacer Suite

## 📋 Índice

- [🔄 Workflow Completo: Emoji-Replacer Suite](#-workflow-completo-emoji-replacer-suite)
  - [📋 Índice](#-índice)
  - [🚀 Instalación Rápida](#-instalación-rápida)
    - [Requisitos](#requisitos)
    - [Pasos](#pasos)
  - [🎯 Flujo Principal](#-flujo-principal)
    - [Paso 1: Iniciar la Suite](#paso-1-iniciar-la-suite)
    - [Paso 2: Seleccionar Repositorios (Opción 1)](#paso-2-seleccionar-repositorios-opción-1)
    - [Paso 3: Seleccionar Tipos de Archivo (Opción 2)](#paso-3-seleccionar-tipos-de-archivo-opción-2)
    - [Paso 4: Buscar Emojis (Opción 3)](#paso-4-buscar-emojis-opción-3)
    - [Paso 5: Reemplazar Emojis (Opción 4)](#paso-5-reemplazar-emojis-opción-4)
    - [Paso 6: Generar Reporte (Opción 5)](#paso-6-generar-reporte-opción-5)
  - [🔍 Detectar Emojis Nuevos (Opción 6)](#-detectar-emojis-nuevos-opción-6)
  - [📝 Generar Propuesta de Contribución (Opción 7)](#-generar-propuesta-de-contribución-opción-7)
    - [📄 PROPUESTA\_NUEVOS\_EMOJIS.md](#-propuesta_nuevos_emojismd)
    - [📋 GUIA\_CONTRIBUCION.md](#-guia_contribucionmd)
    - [🔄 emoji\_unicode\_map\_updated.json](#-emoji_unicode_map_updatedjson)
  - [📚 Contribuir Nuevos Emojis](#-contribuir-nuevos-emojis)
    - [Flujo Completo](#flujo-completo)
    - [Ejemplo Completo](#ejemplo-completo)
  - [💡 Casos de Uso](#-casos-de-uso)
    - [Caso 1: Reemplazar Todos los Emojis en 1 Repo](#caso-1-reemplazar-todos-los-emojis-en-1-repo)
    - [Caso 2: Auditoría de Emojis](#caso-2-auditoría-de-emojis)
    - [Caso 3: Encontrar Nuevos Emojis](#caso-3-encontrar-nuevos-emojis)
    - [Caso 4: Reemplazar Solo Markdown](#caso-4-reemplazar-solo-markdown)
  - [🔧 Solución de Problemas](#-solución-de-problemas)
    - [❌ Error: "emoji\_unicode\_map.json no encontrado"](#-error-emoji_unicode_mapjson-no-encontrado)
    - [❌ Error: "permiso denegado"](#-error-permiso-denegado)
    - [❌ Error: "Python no encontrado"](#-error-python-no-encontrado)
    - [❌ Emojis no se reemplazaron](#-emojis-no-se-reemplazaron)
    - [⚠️ Cómo Revertir Cambios](#️-cómo-revertir-cambios)
    - [🆕 Agregar Mis Propios Emojis al Mapa](#-agregar-mis-propios-emojis-al-mapa)
  - [📊 Estadísticas de Uso](#-estadísticas-de-uso)
  - [📞 Soporte](#-soporte)
  - [©️ Licencia](#️-licencia)

---

## 🚀 Instalación Rápida

### Requisitos

- Bash 4+
- Python 3.7+
- Git (para detectar repositorios)

### Pasos

```bash
# 1. Descargar suite
cd tu_directorio_con_repos
git clone https://github.com/joseangelalejo/MisApuntesITPDAW.git
cd MisApuntesITPDAW/public/Emoji-Replacer

# 2. O descarga solo los archivos
wget https://raw.githubusercontent.com/joseangelalejo/MisApuntesITPDAW/main/public/Emoji-Replacer/emoji-replacer.sh
wget https://raw.githubusercontent.com/joseangelalejo/MisApuntesITPDAW/main/public/Emoji-Replacer/emoji_unicode_map.json
# ... (descarga todos los .py)

# 3. Hacer ejecutables
chmod +x *.sh *.py

# 4. Ejecutar
./emoji-replacer.sh
```

---

## 🎯 Flujo Principal

### Paso 1: Iniciar la Suite

```bash
./emoji-replacer.sh
```

Verás este menú:

```
▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
◆ Emoji Replacer Suite
▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬

1. 🔍 Analizar y seleccionar repositorios
2. 🎯 Seleccionar tipos de archivo
3. 🔎 Buscar emojis (vista previa)
4. ✖  Reemplazar emojis (REAL)
5. 📊 Generar reporte JSON
6. 🆕 Detectar emojis nuevos
7. 📝 Generar propuesta de contribución
8. 📚 Ver documentación
0. ✗ Salir
```

### Paso 2: Seleccionar Repositorios (Opción 1)

La suite **auto-detecta** repositorios:

```
✓ Se encontraron 8 repositorio(s)

▬ Repositorios disponibles:

  [1] AutomatArch
      ~/gitrepositories/AutomatArch
  [2] data-visualizer-web-ide
      ~/gitrepositories/data-visualizer-web-ide
  [3] examdb-manager
      ~/gitrepositories/examdb-manager
  [4] joseangel-hub
      ~/gitrepositories/joseangel-hub
  ...
```

- **Selecciona con:**
  - `1,2,3` → repos 1, 2, 3
  - `1-3` → repos 1 a 3
  - `2,4,7-9` → combinaciones
  - `a` → todos
  - `n` → cancelar

### Paso 3: Seleccionar Tipos de Archivo (Opción 2)

Se ofrecen 6 presets:

```
1. Documentación (.md, .txt)
2. Python (.py)
3. JavaScript/TypeScript (.js, .ts, .jsx, .tsx)
4. Scripts varias (.sh, Dockerfile)
5. Configuración (.json, .yaml, .toml, .xml)
6. TODO (todos los tipos)
7. Personalizado
```

O crea patrones personalizados: `*.rs *.go *.java`

### Paso 4: Buscar Emojis (Opción 3)

Obtiene una **vista previa** de emojis encontrados:

```
📂 AutomatArch
automata.md: ✅ automata.md: ✅ completed (línea 15)
automata.md: ⚠️ Warning! (línea 42)

📂 joseangel-hub
README.md: ❌ error config (línea 8)
```

**Ideal para revisar antes de reemplazar.**

### Paso 5: Reemplazar Emojis (Opción 4)

⚠️ **OPERACIÓN REAL** - Modifica archivos

```
⚠⚠⚠ REEMPLAZANDO EMOJIS ⚠⚠⚠

Se procesarán:
  • Repositorios: 3
  • Patrones: *.md *.py *.ts

Se crearán backups .bak de todos los archivos modificados

¿Continuar? (s/n): s
```

- **Seguridad:**
  - Crea archivos `.bak` automáticamente
  - Puedes revertir con: `mv archivo.bak archivo`
  - Los cambios se aplican en-lugar

### Paso 6: Generar Reporte (Opción 5)

Crea JSON con auditoría:

```bash
emoji_audit_20260415_140230.json_AutomatArch
emoji_audit_20260415_140230.json_joseangel-hub
```

Formato:

```json
{
  "total_emojis": 25,
  "files_affected": 3,
  "unique_emojis": ["✅", "⚠️", "❌"],
  "details": [
    {
      "file": "README.md",
      "emoji": "✅",
      "count": 5,
      "lines": [15, 28, 42, 55, 67]
    }
  ]
}
```

---

## 🔍 Detectar Emojis Nuevos (Opción 6)

**Por qué:** Encontrar emojis que no están mapeados aún

```bash
# La suite lo hace automáticamente en la opción 6
# O manualmente:

python3 detect_new_emojis.py /repos/AutomatArch --json new_emojis.json
```

Salida:

```
═════════════════════════════════════════════════════
◆ Nuevos Emojis Detectados
═════════════════════════════════════════════════════

Total encontrados: 3
Archivos escaneados: 42
Emojis únicos: 3

TOP 10 por frecuencia:
  1. 💾 [DISKETTE] - 5 ocurrencias en 2 archivos
  2. 🔐 [LOCKED] - 3 ocurrencias en 1 archivo
  3. ⚙️ [GEAR] - 2 ocurrencias en 1 archivo

✓ Reporte guardado: new_emojis.json
```

---

## 📝 Generar Propuesta de Contribución (Opción 7)

Convierte emojis nuevos en **propuesta GitHub-compatible**

```bash
# Automático en opción 7, o manual:
python3 generate_proposal.py new_emojis.json emoji_unicode_map.json \
    --markdown PROPUESTA_NUEVOS_EMOJIS.md \
    --json emoji_unicode_map_updated.json \
    --guide GUIA_CONTRIBUCION.md
```

Genera 3 archivos:

### 📄 PROPUESTA_NUEVOS_EMOJIS.md

```markdown
# 🆕 Propuesta de Nuevos Emojis...

## 📊 Resumen
- Total de emojis nuevos: 3
- Archivos escaneados: 42

## 📝 Emojis Detectados

### 1. 💾 (Codepoint: U+1F4BE)

**Frecuencia:** 
- Ocurrencias: 5
- Archivos: 2

**Ejemplos de uso:**
- `💾 Save data to disk`
- `💾 Backup important files`
- `💾 Storage media`

**Carácter Unicode sugerido:** [COMPLETAR]  
**Descripción sugerida:** [COMPLETAR]
```

### 📋 GUIA_CONTRIBUCION.md

Pasos para contribuir:

```markdown
## Pasos para Contribuir...

### 1️⃣ Detectar Emojis Nuevos
### 2️⃣ Generar Propuesta
### 3️⃣ Completar Propuesta
### 4️⃣ Validar Cambios
### 5️⃣ Enviar Contribución
### 6️⃣ Validación
```

### 🔄 emoji_unicode_map_updated.json

```json
{
  "emoji_map": [
    {"emoji": "✅", "unicode": "\\u2705", "character": "✓", "description": "OK/Success"},
    {"emoji": "💾", "unicode": "\\u????", "character": "?", "description": "[NECESITA DESCRIPCIÓN]", "suggested_from_scan": true, "occurrences": 5}
  ]
}
```

---

## 📚 Contribuir Nuevos Emojis

### Flujo Completo

```
1. Ejecuta la suite → Opción 6 (Detectar nuevos)
    ↓
2. Genera propuesta → Opción 7
    ↓
3. Completa propuesta (encuentra Unicode chars)
    ↓
4. Abre Pull Request o Issue en GitHub
    ↓
5. Mantainers revisan y mergen
    ↓
6. Tu emoji está disponible para todos
```

### Ejemplo Completo

**1️⃣ Primera ejecución:**

```bash
./emoji-replacer.sh
# Opción 1: Selecciona todos los repos
# Opción 2: Selecciona Documentación (.md, .txt)
# Opción 6: Detecta nuevos emojis
# Opción 7: Genera propuesta
```

**2️⃣ Edita PROPUESTA_NUEVOS_EMOJIS.md:**

Encuentra caracteres Unicode en: [https://unicode.org/emoji/charts/full-emoji-list.html](https://unicode.org/emoji/charts/full-emoji-list.html)

```markdown
### 1. 💾 (Codepoint: U+1F4BE)

**Carácter Unicode sugerido:** ◆ (U+25C6 - Diamond)  
**Descripción sugerida:** Guardar/persistencia de datos, memoria
```

**3️⃣ Abre Pull Request:**

```bash
git clone https://github.com/joseangelalejo/MisApuntesITPDAW.git
cd MisApuntesITPDAW
git checkout -b feat/add-new-emojis

# Edita: public/Emoji-Replacer/emoji_unicode_map.json
# Añade las nuevas entradas

git add .
git commit -m "feat: add new emojis (💾, 🔐, ⚙️)"
git push origin feat/add-new-emojis
```

---

## 💡 Casos de Uso

### Caso 1: Reemplazar Todos los Emojis en 1 Repo

```
1. Ejecuta: ./emoji-replacer.sh
2. Opción 1: Selecciona 1 repo
3. Opción 2: Selecciona "TODO"
4. Opción 4: Reemplaza
✓ Listo
```

### Caso 2: Auditoría de Emojis

```
1. Opción 1: Selecciona repos
2. Opción 2: Selecciona tipos (.md, .py)
3. Opción 3: Busca (sin reemplazar)
✓ Ves qué emojis están donde
```

### Caso 3: Encontrar Nuevos Emojis

```
1. Opción 6: Detecta automáticamente
2. Opción 7: Genera propuesta
3. Edita propuesta
4. Contribuye al repo
```

### Caso 4: Reemplazar Solo Markdown

```
1. Opción 1: Selecciona repos
2. Opción 2: Elige "Documentación"
3. Opción 4: Reemplaza
✓ Solo .md y .txt se modifican
```

---

## 🔧 Solución de Problemas

### ❌ Error: "emoji_unicode_map.json no encontrado"

```bash
# Solución: Verifica que estés en el directorio correcto
cd MisApuntesITPDAW/public/Emoji-Replacer
./emoji-replacer.sh
```

### ❌ Error: "permiso denegado"

```bash
# Solución: Hacer ejecutables los scripts
chmod +x *.sh *.py

# O solo uno específico:
chmod +x emoji-replacer.sh
```

### ❌ Error: "Python no encontrado"

```bash
# Verificar Python
python3 --version

# Si no existe, instalar:
apt install python3      # Debian/Ubuntu
brew install python3     # macOS
pacman -S python3        # Arch Linux
```

### ❌ Emojis no se reemplazaron

```bash
# Posibles causas:
1. No seleccionaste patrones correctos (Opción 2)
2. Los archivos no tienen emojis
3. Los emojis están en comentarios (revisa con Opción 3)

# Verificar:
grep -r "✅\|⚠️\|❌" /ruta/repo --include="*.md"
```

### ⚠️ Cómo Revertir Cambios

```bash
# Los backups se crean automáticamente
ls *.bak

# Revertir un archivo:
mv archivo.bak archivo

# Revertir todos:
for f in *.bak; do mv "$f" "${f%.bak}"; done
```

### 🆕 Agregar Mis Propios Emojis al Mapa

```bash
# Edita emoji_unicode_map.json:
{
  "emoji": "🎮",
  "unicode": "\\u1f3ae",
  "character": "◊",
  "description": "Gaming/videojuegos"
}
```

---

## 📊 Estadísticas de Uso

| Operación       | Tiempo | Dependencias   |
|-----------------|--------|----------------|
| Detectar repos  | <1s    | find, bash     |
| Buscar emojis   | 1-10s  | grep, python3  |
| Reemplazar      | 2-30s  | sed, python3   |
| Generar reporte | 1-5s   | python3, json  |
| Detectar nuevos | 3-15s  | python3, regex |

---

## 📞 Soporte

- **Problemas o sugerencias:**
  - **GitHub Issues**: [https://github.com/joseangelalejo/MisApuntesITPDAW/issues](https://github.com/joseangelalejo/MisApuntesITPDAW/issues)
  - **Email**: [joseangelcorptiv@gmail.com](mailto:joseangelcorptiv@gmail.com)
  - **Wiki**: [https://github.com/joseangelalejo/MisApuntesITPDAW/wiki/Emoji-Replacer](https://github.com/joseangelalejo/MisApuntesITPDAW/wiki/Emoji-Replacer)

---

## ©️ Licencia

Emoji-Replacer Suite ⊙ 2024-2026
Released under MIT License

---

**Última actualización:** 2026-04-15
**Versión:** 2.1.0 (Con generador de propuestas)
