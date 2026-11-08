#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
◆ Detector de Emojis Nuevos
▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬

Detecta emojis no mapeados y genera reporte
para contribución al proyecto.
"""

import os
import json
import argparse
import sys
import re
from pathlib import Path
from typing import Dict, Set, List
from datetime import datetime
from collections import defaultdict

class NewEmojiDetector:
    def __init__(self, emoji_map_path: str):
        """Inicializar detector"""
        self.emoji_map = self._load_emoji_map(emoji_map_path)
        self.mapped_emojis = set(self.emoji_map.keys())
        self.new_emojis = defaultdict(lambda: {'count': 0, 'files': set(), 'contexts': []})
        self.files_processed = 0
        
    def _load_emoji_map(self, path: str) -> Dict:
        """Cargar mapeo existente"""
        try:
            with open(path, 'r', encoding='utf-8') as f:
                data = json.load(f)
                emoji_dict = {}
                for item in data.get('emoji_map', []):
                    emoji_dict[item['emoji']] = {
                        'unicode': item['unicode'],
                        'character': item['character'],
                        'description': item['description']
                    }
                return emoji_dict
        except Exception as e:
            print(f"Error cargando mapeo: {e}")
            return {}
    
    def should_skip_file(self, file_path: str) -> bool:
        """Ignorar archivos que no tienen sentido"""
        skip_patterns = [
            '.html', '.htm', '.jpg', '.jpeg', '.png', '.gif', '.pdf',
            '.zip', '.tar', '.gz', '.bak', '.pyc', '__pycache__', '.min.js'
        ]
        
        path_str = str(file_path).lower()
        for pattern in skip_patterns:
            if pattern in path_str:
                return True
        
        if '.git' in Path(file_path).parts:
            return True
        
        return False
    
    def find_all_emojis(self, text: str) -> Set[str]:
        """Encontrar todos los posibles emojis en texto"""
        # Rango de emojis (simplificado - incluye la mayoría de emojis comunes)
        emoji_pattern = re.compile(
            "["
            "\U0001F300-\U0001F9FF"  # Emojis comunes
            "\U0001F600-\U0001F64F"  # Emoticones
            "\U0001F1E0-\U0001F1FF"  # Banderas
            "\U00002702-\U000027B0"  # Símbolos
            "\U000024C2-\U0001F251"  # Varios
            "\U0001f926-\U0001f937"  # Personas
            "\U00010000-\U0010ffff"  # Caracteres suplementarios
            "\u2600-\u2B55"          # Unicode misceláneo
            "\u200d"                 # Zero-width joiner
            "\u23cf"
            "\u23e9"
            "\u23f0"
            "\u23f3"
            "\u25fd"
            "\u25fe"
            "\u2B50"
            "\u2b55"
            "\u2934"
            "\u2935"
            "\u3030"
            "\uFE0F"
            "]+"
        )
        
        return set(emoji_pattern.findall(text))
    
    def scan_file(self, file_path: str) -> None:
        """Escanear archivo para emojis nuevos"""
        if self.should_skip_file(file_path):
            return
        
        try:
            with open(file_path, 'r', encoding='utf-8', errors='ignore') as f:
                for line_num, line in enumerate(f, 1):
                    emojis = self.find_all_emojis(line)
                    
                    for emoji in emojis:
                        if emoji not in self.mapped_emojis:
                            self.new_emojis[emoji]['count'] += 1
                            self.new_emojis[emoji]['files'].add(file_path)
                            # Guardar contexto (primeras 100 chars)
                            context = line.strip()[:100]
                            if context not in self.new_emojis[emoji]['contexts']:
                                self.new_emojis[emoji]['contexts'].append(context)
            
            self.files_processed += 1
        except Exception:
            pass
    
    def scan_directory(self, directory: str) -> None:
        """Escanear directorio"""
        for file_path in Path(directory).rglob('*'):
            if file_path.is_file():
                self.scan_file(str(file_path))
    
    def generate_contribution_json(self) -> Dict:
        """Generar JSON para contribución"""
        contribution = {
            "timestamp": datetime.now().isoformat(),
            "total_new_emojis": len(self.new_emojis),
            "files_scanned": self.files_processed,
            "new_emojis": []
        }
        
        for emoji in sorted(self.new_emojis.keys(), key=lambda x: self.new_emojis[x]['count'], reverse=True):
            data = self.new_emojis[emoji]
            contribution["new_emojis"].append({
                "emoji": emoji,
                "unicode_codepoint": f"U+{ord(emoji):X}",
                "occurrences": data['count'],
                "files_found": len(data['files']),
                "example_contexts": data['contexts'][:3],
                "suggested_character": "?",  # Usuario debe proporcionar
                "suggested_description": f"[Necesita descripción]"
            })
        
        return contribution
    
    def print_summary(self) -> None:
        """Mostrar resumen"""
        print("\n" + "="*60)
        print("DETECTOR DE EMOJIS NUEVOS - RESUMEN")
        print("="*60 + "\n")
        
        if not self.new_emojis:
            print("✓ No se encontraron emojis nuevos")
            print(f"✓ Todos los emojis encontrados están mapeados")
            return
        
        print(f"📊 Archivos escaneados: {self.files_processed}")
        print(f"🆕 Emojis nuevos encontrados: {len(self.new_emojis)}\n")
        
        print("TOP 10 Emojis más frecuentes:")
        print("-" * 60)
        
        sorted_emojis = sorted(
            self.new_emojis.items(),
            key=lambda x: x[1]['count'],
            reverse=True
        )[:10]
        
        for i, (emoji, data) in enumerate(sorted_emojis, 1):
            print(f"{i:2}. {emoji} - Ocurrencias: {data['count']} - Archivos: {len(data['files'])}")
            print(f"    → Codepoint: U+{ord(emoji):X}")
            if data['contexts']:
                print(f"    → Contexto: {data['contexts'][0][:60]}...")


def main():
    parser = argparse.ArgumentParser(
        description='Detectar emojis no mapeados en repositorios'
    )
    
    parser.add_argument('directory', nargs='?', default='.',
                       help='Directorio a escanear')
    parser.add_argument('--json', metavar='FILE',
                       help='Exportar reporte a JSON')
    parser.add_argument('--emoji-map', metavar='FILE',
                       help='Path a emoji_unicode_map.json')
    
    args = parser.parse_args()
    
    # Localizar emoji_map
    if args.emoji_map:
        emoji_map_path = args.emoji_map
    else:
        script_dir = Path(__file__).parent
        emoji_map_path = script_dir / 'emoji_unicode_map.json'
    
    if not Path(emoji_map_path).exists():
        print(f"Error: {emoji_map_path} no encontrado")
        sys.exit(1)
    
    if not Path(args.directory).is_dir():
        print(f"Error: {args.directory} no es directorio")
        sys.exit(1)
    
    # Ejecutar
    detector = NewEmojiDetector(str(emoji_map_path))
    print(f"Escaneando: {args.directory}")
    print("Espera...\n")
    
    detector.scan_directory(args.directory)
    detector.print_summary()
    
    # Exportar JSON si se solicita
    if args.json:
        contrib = detector.generate_contribution_json()
        with open(args.json, 'w', encoding='utf-8') as f:
            json.dump(contrib, f, indent=2, ensure_ascii=False)
        print(f"\n✓ Reporte exportado a: {args.json}")


if __name__ == '__main__':
    main()
