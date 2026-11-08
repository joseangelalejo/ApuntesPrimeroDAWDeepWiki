#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
◆ Generador de Propuesta de Emojis Nuevos
▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬

Crea propuesta formateada para contribuir nuevos emojis
al proyecto MisApuntesITPDAW/Emoji-Replacer
"""

import json
import sys
from pathlib import Path
from typing import Dict, List
from datetime import datetime

class ContributionProposal:
    def __init__(self, detection_json_path: str, emoji_map_path: str):
        """Inicializar generador de propuestas"""
        self.detection = self._load_json(detection_json_path)
        self.emoji_map = self._load_json(emoji_map_path)
        self.mapped_emojis = {item['emoji'] for item in self.emoji_map.get('emoji_map', [])}
        
    def _load_json(self, path: str) -> Dict:
        """Cargar JSON"""
        try:
            with open(path, 'r', encoding='utf-8') as f:
                return json.load(f)
        except Exception as e:
            print(f"Error cargando {path}: {e}")
            return {}
    
    def generate_markdown_proposal(self) -> str:
        """Generar propuesta en Markdown"""
        new_emojis = self.detection.get('new_emojis', [])
        
        proposal = f"""# 🆕 Propuesta de Nuevos Emojis para Emoji-Replacer

**Fecha de generación:** {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}

## 📊 Resumen

- **Total de emojis nuevos:** {len(new_emojis)}
- **Archivos escaneados:** {self.detection.get('files_scanned', 0)}

## 📝 Emojis Detectados

Estos emojis fueron encontrados en los repositorios pero **NO están mapeados** en `emoji_unicode_map.json`:

"""
        
        for i, emoji_data in enumerate(new_emojis, 1):
            emoji = emoji_data.get('emoji', '?')
            occurrences = emoji_data.get('occurrences', 0)
            files_found = emoji_data.get('files_found', 0)
            codepoint = emoji_data.get('unicode_codepoint', 'N/A')
            contexts = emoji_data.get('example_contexts', [])
            
            proposal += f"""
### {i}. {emoji} (Codepoint: {codepoint})

**Frecuencia:** 
- Ocurrencias: {occurrences}
- Archivos: {files_found}

**Ejemplos de uso:**
"""
            
            for ctx in contexts:
                proposal += f"- `{ctx}`\n"
            
            proposal += f"""
**Carácter Unicode sugerido:** [COMPLETAR]  
**Descripción sugerida:** [COMPLETAR]

---
"""
        
        proposal += """
## 📋 Cómo Contribuir

1. **Completa los campos de cada emoji:**
   - Carácter Unicode sugerido
   - Descripción clara del uso

2. **Abre un issue con esta propuesta** en:
   https://github.com/joseangelalejo/MisApuntesITPDAW/issues

3. **O haz un fork y Pull Request:**
   - Edita `emoji_unicode_map.json`
   - Añade los nuevos emojis al mapeo
   - Envía PR al repositorio oficial

## 📚 Referencia de Unicodes

Para encontrar el carácter Unicode apropiado para cada emoji:
- https://unicode.org/emoji/charts/full-emoji-list.html
- https://www.unicode.org/
- Compatibilidad con sistemas POSIX/ASCII

## ✓ Checklist

- [ ] He investigado cada emoji
- [ ] He encontrado caracteres Unicode apropiados
- [ ] He escrito descripciones claras
- [ ] He verificado que no duplican emojis existentes

---

**Generado automáticamente por Emoji-Replacer Suite**
"""
        
        return proposal
    
    def generate_updated_emoji_map(self) -> Dict:
        """Generar mapa de emojis actualizado con placeholders"""
        new_emojis = self.detection.get('new_emojis', [])
        
        updated_map = self.emoji_map.copy()
        
        for emoji_data in new_emojis:
            emoji = emoji_data.get('emoji', '')
            if emoji and emoji not in self.mapped_emojis:
                updated_map['emoji_map'].append({
                    'emoji': emoji,
                    'unicode': '\\u????',  # Placeholder
                    'character': '?',       # Placeholder
                    'description': '[NECESITA DESCRIPCIÓN]',
                    'suggested_from_scan': True,
                    'occurrences': emoji_data.get('occurrences', 0),
                    'source_files': emoji_data.get('files_found', 0)
                })
        
        return updated_map
    
    def generate_contribution_guide(self) -> str:
        """Generar guía de contribución"""
        guide = """# 📚 Guía de Contribución: Nuevos Emojis

## Pasos para Contribuir Nuevos Emojis

### 1️⃣ Detectar Emojis Nuevos

```bash
python3 detect_new_emojis.py /path/to/repos --json new_emojis.json
```

### 2️⃣ Generar Propuesta

```bash
python3 generate_proposal.py new_emojis.json emoji_unicode_map.json --markdown proposal.md
```

### 3️⃣ Completar Propuesta

Edita `proposal.md` e indica para cada emoji:
- Character Unicode adecuado
- Descripción clara del uso

Consulta:
- https://unicode.org/emoji/charts/full-emoji-list.html
- https://unicode.org/Public/UNIDATA/

### 4️⃣ Validar Cambios

```bash
# Verificar que el JSON es válido
python3 -m json.tool emoji_unicode_map.json > /dev/null && echo "✓ JSON válido"
```

### 5️⃣ Enviar Contribución

**Opción A: Issue**
- Abre un issue en: https://github.com/joseangelalejo/MisApuntesITPDAW/issues
- Adjunta la propuesta Markdown
- Incluye captura de pantalla de búsqueda

**Opción B: Pull Request**
```bash
git fork https://github.com/joseangelalejo/MisApuntesITPDAW.git
git checkout -b feat/add-new-emojis
# Edita emoji_unicode_map.json
git add .
git commit -m "feat: add new emojis [lista de emojis]"
git push origin feat/add-new-emojis
# Abre PR
```

### 6️⃣ Validación

Los mantainers validarán:
- ✓ Caracteres Unicode válidos
- ✓ Descripciones claras
- ✓ Sin duplicados
- ✓ Formato JSON correcto
- ✓ Uso real en el codebase

## 📊 Ejemplo de Entrada Válida

```json
{
  "emoji": "💾",
  "unicode": "\\u1f4be",
  "character": "💾",
  "description": "Guardar, persistencia de datos"
}
```

## ⚠️ Reglas Importantes

1. **Un carácter Unicode por emoji**
   - No usar emojis como caracteres
   - Preferir símbolos ASCII-compatibles

2. **Descripción clara**
   - Máximo 80 caracteres
   - Indicar uso principal y alternos

3. **Verificar no-duplicados**
   - Revisar `emoji_unicode_map.json` existente
   - Usar `grep` para buscar

4. **Validar formato**
   - JSON must be valid
   - UTF-8 encoding
   - No trailing commas

## 🔗 Enlaces Útiles

- [Unicode Charts](https://unicode.org/emoji/charts/full-emoji-list.html)
- [Unicode Data](https://unicode.org/Public/UNIDATA/)
- [Emoji Standard](https://unicode.org/reports/tr51/)
- [Este Repositorio](https://github.com/joseangelalejo/MisApuntesITPDAW)

---

**¡Gracias por contribuir! 🙏**
"""
        return guide


def main():
    import argparse
    
    parser = argparse.ArgumentParser(
        description='Generar propuesta de nuevos emojis'
    )
    
    parser.add_argument('detection_json',
                       help='JSON de detección de nuevos emojis')
    parser.add_argument('emoji_map',
                       help='emoji_unicode_map.json actual')
    parser.add_argument('--markdown', metavar='FILE',
                       help='Guardar propuesta en Markdown')
    parser.add_argument('--json', metavar='FILE',
                       help='Guardar mapa actualizado en JSON')
    parser.add_argument('--guide', metavar='FILE',
                       help='Guardar guía de contribución')
    
    args = parser.parse_args()
    
    # Validar archivos
    if not Path(args.detection_json).exists():
        print(f"Error: {args.detection_json} no encontrado")
        sys.exit(1)
    
    if not Path(args.emoji_map).exists():
        print(f"Error: {args.emoji_map} no encontrado")
        sys.exit(1)
    
    # Generar propuesta
    proposal = ContributionProposal(args.detection_json, args.emoji_map)
    
    # Exportar Markdown
    if args.markdown:
        with open(args.markdown, 'w', encoding='utf-8') as f:
            f.write(proposal.generate_markdown_proposal())
        print(f"✓ Propuesta guardada en: {args.markdown}")
    
    # Exportar JSON actualizado
    if args.json:
        updated_map = proposal.generate_updated_emoji_map()
        with open(args.json, 'w', encoding='utf-8') as f:
            json.dump(updated_map, f, indent=2, ensure_ascii=False)
        print(f"✓ Mapa actualizado guardado en: {args.json}")
    
    # Exportar guía
    if args.guide:
        with open(args.guide, 'w', encoding='utf-8') as f:
            f.write(proposal.generate_contribution_guide())
        print(f"✓ Guía de contribución guardada en: {args.guide}")


if __name__ == '__main__':
    main()
