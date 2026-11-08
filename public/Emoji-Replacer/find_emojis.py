#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
◆ Buscador de Emojis ChatGPT - Python Version
▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬

Script que busca emojis tipo ChatGPT en repositorios
y proporciona mapeo a caracteres Unicode.
"""

import os
import json
import argparse
import sys
from pathlib import Path
from typing import Dict, List, Tuple
from datetime import datetime
import re

# Colores para terminal
class Colors:
    RESET = '\033[0m'
    RED = '\033[0;31m'
    GREEN = '\033[0;32m'
    YELLOW = '\033[1;33m'
    BLUE = '\033[0;34m'
    CYAN = '\033[0;36m'
    BOLD = '\033[1m'

class EmojiScanner:
    def __init__(self, emoji_map_path: str):
        """Inicializar scanner con archivo de mapeo"""
        self.emoji_map = self._load_emoji_map(emoji_map_path)
        self.results = {}
        self.stats = {
            'total_emojis': 0,
            'files_with_emojis': 0,
            'unique_emojis': set(),
            'files_processed': 0
        }
        
    def _load_emoji_map(self, path: str) -> Dict:
        """Cargar mapeo de emojis desde JSON"""
        try:
            with open(path, 'r', encoding='utf-8') as f:
                data = json.load(f)
                # Crear diccionario emoji -> unicode
                emoji_dict = {}
                for item in data.get('emoji_map', []):
                    emoji_dict[item['emoji']] = {
                        'unicode': item['unicode'],
                        'character': item['character'],
                        'description': item['description']
                    }
                return emoji_dict
        except FileNotFoundError:
            print(f"{Colors.RED}✗ Error: No se encontró {path}{Colors.RESET}")
            sys.exit(1)
        except json.JSONDecodeError:
            print(f"{Colors.RED}✗ Error: Archivo JSON inválido: {path}{Colors.RESET}")
            sys.exit(1)
    
    def should_skip_file(self, file_path: str) -> bool:
        """Determinar si el archivo debe ser ignorado"""
        skip_patterns = [
            '.html', '.htm', '.jpg', '.jpeg', '.png', '.gif', '.pdf',
            '.zip', '.tar', '.gz', '.bak', 'node_modules', '.git',
            '.min.js', '.min.css', '.pyc', '__pycache__'
        ]
        
        path_str = str(file_path).lower()
        
        # Excluir extensiones
        for pattern in skip_patterns:
            if pattern in path_str:
                return True
        
        # Excluir rutas específicas
        if '.git' in file_path.parts or 'node_modules' in file_path.parts:
            return True
        
        return False
    
    def find_emojis_in_file(self, file_path: Path) -> List[Tuple[int, str, str]]:
        """Buscar emojis en un archivo"""
        matches = []
        
        try:
            with open(file_path, 'r', encoding='utf-8', errors='ignore') as f:
                for line_num, line in enumerate(f, 1):
                    for emoji in self.emoji_map.keys():
                        if emoji in line:
                            matches.append((line_num, emoji, line.strip()))
                            self.stats['total_emojis'] += 1
                            self.stats['unique_emojis'].add(emoji)
        except Exception as e:
            pass  # Ignorar errores de lectura
        
        return matches
    
    def scan_directory(self, directory: str) -> None:
        """Escanear directorio recursivamente"""
        dir_path = Path(directory)
        
        print(f"{Colors.CYAN}▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬{Colors.RESET}")
        print(f"{Colors.BLUE}◆ Escaneando: {directory}{Colors.RESET}")
        print(f"{Colors.CYAN}▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬{Colors.RESET}")
        print()
        
        for file_path in dir_path.rglob('*'):
            if not file_path.is_file():
                continue
            
            if self.should_skip_file(file_path):
                continue
            
            self.stats['files_processed'] += 1
            matches = self.find_emojis_in_file(file_path)
            
            if matches:
                self.stats['files_with_emojis'] += 1
                self.results[str(file_path)] = matches
    
    def print_report(self) -> None:
        """Mostrar reporte formateado"""
        if not self.results:
            print(f"{Colors.GREEN}✓ ¡Excelente! No se encontraron emojis{Colors.RESET}\n")
            return
        
        for file_path, matches in self.results.items():
            print(f"{Colors.YELLOW}📄 {file_path}{Colors.RESET}")
            
            for line_num, emoji, content in matches:
                unicode_info = self.emoji_map.get(emoji, {})
                character = unicode_info.get('character', '?')
                description = unicode_info.get('description', 'Sin descripción')
                
                # Limitar contenido mostrado
                display_content = content[:100]
                if len(content) > 100:
                    display_content += "..."
                
                print(f"  {Colors.GREEN}▬{Colors.RESET} Línea {Colors.BLUE}{line_num}{Colors.RESET}: "
                      f"Emoji {Colors.RED}{emoji}{Colors.RESET} → {Colors.GREEN}{character}{Colors.RESET} ({description})")
                print(f"    {display_content}")
            
            print()
    
    def print_summary(self) -> None:
        """Mostrar resumen estadístico"""
        print(f"{Colors.BLUE}▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬{Colors.RESET}")
        print(f"{Colors.BLUE}★ RESUMEN{Colors.RESET}")
        print(f"{Colors.BLUE}▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬{Colors.RESET}")
        print(f"📊 Archivos procesados: {Colors.CYAN}{self.stats['files_processed']}{Colors.RESET}")
        print(f"📂 Archivos con emojis: {Colors.YELLOW if self.stats['files_with_emojis'] > 0 else Colors.GREEN}{self.stats['files_with_emojis']}{Colors.RESET}")
        print(f"🎯 Total de emojis: {Colors.RED if self.stats['total_emojis'] > 0 else Colors.GREEN}{self.stats['total_emojis']}{Colors.RESET}")
        print(f"⭐ Emojis únicos: {len(self.stats['unique_emojis'])}")
        print()
    
    def export_json(self, output_file: str) -> None:
        """Exportar resultados a JSON"""
        export_data = {
            'scan_date': datetime.now().isoformat(),
            'statistics': {
                'total_emojis': self.stats['total_emojis'],
                'files_with_emojis': self.stats['files_with_emojis'],
                'files_processed': self.stats['files_processed'],
                'unique_emojis': list(self.stats['unique_emojis'])
            },
            'results': {}
        }
        
        for file_path, matches in self.results.items():
            export_data['results'][file_path] = [
                {
                    'line': line_num,
                    'emoji': emoji,
                    'unicode_character': self.emoji_map[emoji]['character'],
                    'description': self.emoji_map[emoji]['description'],
                    'content': content
                }
                for line_num, emoji, content in matches
            ]
        
        try:
            with open(output_file, 'w', encoding='utf-8') as f:
                json.dump(export_data, f, indent=2, ensure_ascii=False)
            print(f"{Colors.GREEN}✓ Exportado a: {output_file}{Colors.RESET}")
        except Exception as e:
            print(f"{Colors.RED}✗ Error al exportar: {e}{Colors.RESET}")
    
    def export_csv(self, output_file: str) -> None:
        """Exportar resultados a CSV"""
        try:
            import csv
            with open(output_file, 'w', newline='', encoding='utf-8') as f:
                writer = csv.writer(f)
                writer.writerow(['Archivo', 'Línea', 'Emoji', 'Carácter Unicode', 'Descripción', 'Contenido'])
                
                for file_path, matches in self.results.items():
                    for line_num, emoji, content in matches:
                        unicode_info = self.emoji_map.get(emoji, {})
                        writer.writerow([
                            file_path,
                            line_num,
                            emoji,
                            unicode_info.get('character', '?'),
                            unicode_info.get('description', ''),
                            content[:100]
                        ])
            
            print(f"{Colors.GREEN}✓ Exportado a: {output_file}{Colors.RESET}")
        except Exception as e:
            print(f"{Colors.RED}✗ Error al exportar CSV: {e}{Colors.RESET}")


def main():
    parser = argparse.ArgumentParser(
        description='Buscar emojis ChatGPT en repositorios',
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="""
Ejemplos de uso:
  # Escanear directorio actual
  python3 find_emojis.py .
  
  # Escanear específico con salida JSON
  python3 find_emojis.py /path/to/repos --json report.json
  
  # Escanear con salida CSV
  python3 find_emojis.py /path/to/repos --csv report.csv
        """
    )
    
    parser.add_argument('directory', nargs='?', default='.', 
                       help='Directorio a escanear (por defecto: actual)')
    parser.add_argument('--json', metavar='FILE', 
                       help='Exportar resultados a JSON')
    parser.add_argument('--csv', metavar='FILE',
                       help='Exportar resultados a CSV')
    parser.add_argument('--verbose', '-v', action='store_true',
                       help='Mostrar información detallada')
    
    args = parser.parse_args()
    
    # Localizar emoji_unicode_map.json
    script_dir = Path(__file__).parent
    emoji_map_path = script_dir / 'emoji_unicode_map.json'
    
    if not emoji_map_path.exists():
        print(f"{Colors.RED}✗ Error: emoji_unicode_map.json no encontrado en {script_dir}{Colors.RESET}")
        sys.exit(1)
    
    # Validar directorio
    if not Path(args.directory).is_dir():
        print(f"{Colors.RED}✗ Error: {args.directory} no es un directorio válido{Colors.RESET}")
        sys.exit(1)
    
    # Ejecutar escaneo
    scanner = EmojiScanner(str(emoji_map_path))
    scanner.scan_directory(args.directory)
    
    # Mostrar reporte
    scanner.print_report()
    scanner.print_summary()
    
    # Exportar si se solicita
    if args.json:
        scanner.export_json(args.json)
    
    if args.csv:
        scanner.export_csv(args.csv)


if __name__ == '__main__':
    main()
