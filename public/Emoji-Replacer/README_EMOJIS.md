# ◆ Suite de Herramientas para Eliminar Emojis ChatGPT

Conjunto de scripts para buscar y reemplazar emojis tipo ChatGPT por caracteres Unicode en múltiples repositorios.

---

## 📚 Contenido

- **`emoji_unicode_map.json`** — Mapeo completo de emojis a caracteres Unicode
- **`find_emojis.sh`** — Script bash para buscar emojis (legible, rápido)
- **`find_emojis.py`** — Script Python con exportación JSON/CSV (más features)
- **`replace_emojis.py`** — Reemplazador automático con backups
- **`README_EMOJIS.md`** — Este archivo

---

## 🚀 Instalación Rápida

### Opción 1: Clonar desde MisApuntesITPDAW (Público)

```bash
# Descargar los scripts
git clone https://github.com/joseangelalejo/MisApuntesITPDAW.git emoji-tools
cd emoji-tools

# Hacer scripts ejecutables
chmod +x find_emojis.sh replace_emojis.py find_emojis.py
```

### Opción 2: Copiar archivos a tus repos

```bash
# Si ya tienes los archivos
cp emoji_unicode_map.json ~/repositorios/
cp find_emojis.sh ~/repositorios/
cp find_emojis.py ~/repositorios/
```

---

## 🔍 Buscar Emojis

### Con Bash (Recomendado para búsquedas rápidas)

```bash
# Buscar en directorio actual
./find_emojis.sh .

# Buscar en directorio específico
./find_emojis.sh /path/to/repos

# Salida esperada:
# 📄 Archivo: src/main.py
#   ▬ Línea 15: Emoji 📚 → UNICODE: ◆
#     # ◆ Aquí va la documentación...
```

### Con Python (Más features)

```bash
# Búsqueda simple
python3 find_emojis.py .

# Exportar a JSON
python3 find_emojis.py /repos --json report.json

# Exportar a CSV
python3 find_emojis.py /repos --csv report.csv

# Verbose output
python3 find_emojis.py . -v
```

---

## 🔄 Reemplazar Emojis

### Simulación (SIN modificar archivos)

```bash
# Probar primero sin hacer cambios
python3 replace_emojis.py . --dry-run

# Salida:
# ✓ Se reemplazaría 5 emoji(s) en: src/main.py
# ✓ Se reemplazaría 2 emoji(s) en: docs/guide.md
```

### Reemplazamiento Real

```bash
# Reemplazar con confirmación y backups
python3 replace_emojis.py .

# Reemplazar sin confirmación
python3 replace_emojis.py . --force

# Reemplazar sin crear .bak
python3 replace_emojis.py . --force --no-backup
```

**IMPORTANTE:** Todos los archivos modificados recibirán la extensión `.bak` como respaldo automático.

---

## 📊 Mapeo de Emojis Disponibles

| Emoji | Unicode  | Carácter | Uso                 |
|:-----:|:--------:|:--------:|---------------------|
|  📚   | `\u25c6` |    ◆     | Documentación       |
|  📋   | `\u25ac` |    ▬     | Tabla de contenidos |
|  🎯   | `\u2605` |    ★     | Objetivo            |
|  📊   | `\u25a0` |    ■     | Estadísticas        |
|   ✅   | `\u2713` |    ✓     | Completado          |
|   ⚠️   | `\u26a0` |    ⚠     | Advertencia         |
|  🔴   | `\u25cf` |    ●     | Problema            |
|   ⚒️   | `\u2692` |    ⚒     | Herramientas        |
|   ✨   | `\u2605` |    ★     | Especial            |
|  🛠️   | `\u2692` |    ⚒     | Guía                |
|   ✗   | `\u2717` |    ✗     | Error               |
|   ⚡   | `\u26a1` |    ⚡     | Rápido              |
|   ⚙️   | `\u2699` |    ⚙     | Configuración       |
|  💻   | `\u2328` |    ⌨     | Código              |

**Ver `emoji_unicode_map.json` para lista completa (34 emojis mapeados)**

---

## 📋 Flujo de Trabajo Recomendado

```bash
# 1. Copiar herramientas a directorio de repos
cp emoji_unicode_map.json find_emojis.* ~/repos/

# 2. Buscar todos los emojis (sin modificar)
cd ~/repos
./find_emojis.sh .

# 3. Revisar resultados detallados
python3 find_emojis.py . --json report.json
cat report.json | jq '.'

# 4. Simular reemplazos
python3 replace_emojis.py . --dry-run

# 5. Si todo se ve bien, ejecutar reemplazo
python3 replace_emojis.py . --force

# 6. Verificar que no hay más emojis
./find_emojis.sh .
# Debería mostrar: "✓ ¡Excelente! No se encontraron emojis ChatGPT"
```

---

## 🔧 Casos de Uso

### Caso 1: Limpiar repositorio específico

```bash
cd ~/Proyectos/MiRepo
/path/to/find_emojis.sh .
# Si hay emojis:
/path/to/replace_emojis.py . --force
```

### Caso 2: Auditoría de múltiples repos

```bash
cd ~/Repositorios

# Generar reporte de todos
python3 ../find_emojis.py . --json audit.json --csv audit.csv

# Revisar resultados
jq '.statistics' audit.json
```

### Caso 3: Integración en CI/CD

```yaml
# .gitlab-ci.yml o similar
check-emojis:
  script:
    - python3 find_emojis.py . --json report.json
    - '[ $(jq ".statistics.total_emojis" report.json) -eq 0 ] || exit 1'
```

---

## 🛡️ Seguridad

**Importante:**

1. ✓ Los scripts **NO modifican archivos** sin permiso explícito
2. ✓ El modo `--dry-run` es la opción segura por defecto
3. ✓ Los backups (`.bak`) se crean **antes** de cualquier cambio
4. ✓ Todos los scripts usan UTF-8 con manejo seguro de errores
5. ✓ Se ignoran automáticamente archivos binarios, `.git`, `node_modules`

**Recomendaciones:**

- Siempre usar `--dry-run` primero
- Comitear cambios antes de ejecutar reemplazos
- Revisar backups `.bak` si algo sale mal

---

## 🔍 Troubleshooting

### "Error: No se encontró emoji_unicode_map.json"

```bash
# Verificar que el archivo existe
ls -la emoji_unicode_map.json

# Si no existe, asegúrate de copiar todos los archivos del repo
```

### "Permiso denegado" en scripts

```bash
# Hacer ejecutables
chmod +x find_emojis.sh replace_emojis.py find_emojis.py
```

### Script Python no funciona

```bash
# Verificar Python 3.6+
python3 --version

# Instalar json (viene con Python por defecto)
# Si falta módulo 'csv':
python3 -m pip install --upgrade python

# Ejecutar con python3 explícitamente
python3 find_emojis.py .
```

### Resultados inesperados

```bash
# Usar verbose mode
python3 find_emojis.py . -v

# Verificar manualmente archivo
grep -n "📚\|📋\|🎯" archivo.md
```

---

## 📈 Estadísticas

- Estos scripts han sido probados en:
  - ✓ Repositorios con 1K+ archivos
  - ✓ Archivos de texto, código, markdown
  - ✓ Encoding: UTF-8, ISO-8859-1, diversos
  - ✓ Sistemas: Linux, macOS, WSL

---

## 📝 Notas Técnicas

### Emojis vs Unicode

- **Problema:** Los emojis son caracteres especiales que:
  - No se renderizan igual en todos lados
  - Afectan a sistemas de bajo nivel
  - Crean problemas en CI/CD
  - Dificultan búsquedas de texto

- **Solución:** Caracteres Unicode ASCII-compatible que:
  - Se ven bien en terminal pura
  - Son 100% compatible con texto plano
  - Se indexan correctamente
  - Funcionan en cualquier sistema

### Ejemplos de Conversión

```
📚 → ◆  (Diamante, documentación)
✅ → ✓  (Mark, completado)
❌ → ✖  (X, error)
⚠️ → ⚠  (Triángulo, advertencia)
🔄 → ↻  (Flecha circular, ciclo)
```

---

## 🤝 Contribuir

Para agregar nuevos emojis al mapeo:

1. Editar `emoji_unicode_map.json`
2. Seguir el formato JSON existente
3. Agregar unicode hexadecimal
4. Probar con los scripts
5. Documentar en README

---

## 📜 Licencia

Estos scripts son parte del proyecto público **MisApuntesITPDAW**.
Libre para usar, modificar y distribuir.

---

- **Fecha de creación:** Abril 2024
- **Última actualización:** Abril 2026  
- **Versión:** 1.0  
- **Autor:** José Ángel Alejo Sillero
