#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
◆ Reemplazador automático de Emojis
▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬

Script que reemplaza automáticamente emojis ChatGPT
por caracteres Unicode. CREA BACKUPS ANTES DE EJECUTAR.
"""

import os
import json
import argparse
import sys
import shutil
from pathlib import Path
from typing import Dict, List
from datetime import datetime

# Colores
class Colors:
    RESET = '\033[0m'
    RED = '\033[0;31m'
    GREEN = '\033[0;32m'
    YELLOW = '\033[1;33m'
    BLUE = '\033[0;34m'
    CYAN = '\033[0;36m'
    BOLD = '\033[1m'

class EmojiReplacer:
    def __init__(self, emoji_map_path: str, dry_run: bool = False, backup: bool = True):
        """Inicializar reemplazador"""
        self.emoji_map = self._load_emoji_map(emoji_map_path)
        self.dry_run = dry_run
        self.backup = backup
        self.stats = {
            'files_processed': 0,
            'files_modified': 0,
            'replacements': 0,
            'backup_created': 0
        }
    
    def _load_emoji_map(self, path: str) -> Dict[str, str]:
        """Cargar mapeo de emojis"""
        try:
            with open(path, 'r', encoding='utf-8') as f:
                data = json.load(f)
                emoji_dict = {}
                for item in data.get('emoji_map', []):
                    emoji_dict[item['emoji']] = item['character']
                return emoji_dict
        except Exception as e:
            print(f"{Colors.RED}✗ Error cargando mapeo: {e}{Colors.RESET}")
            sys.exit(1)
    
    def should_skip_file(self, file_path: str) -> bool:
        """Determinar si archivo debe ignorarse"""
        skip_patterns = [
            '.html', '.htm', '.jpg', '.jpeg', '.png', '.gif', '.pdf',
            '.zip', '.tar', '.gz', '.bak', '.pyc', '__pycache__'
        ]
        
        path_str = str(file_path).lower()
        for pattern in skip_patterns:
            if pattern in path_str:
                return True
        
        if '.git' in Path(file_path).parts:
            return True
        
        return False
    
    def create_backup(self, file_path: str) -> str:
        """Crear backup del archivo"""
        backup_path = f"{file_path}.bak"
        try:
            shutil.copy2(file_path, backup_path)
            self.stats['backup_created'] += 1
            return backup_path
        except Exception as e:
            print(f"{Colors.RED}✗ Error creando backup: {e}{Colors.RESET}")
            return None
    
    def replace_emojis_in_file(self, file_path: str) -> int:
        """Reemplazar emojis en archivo"""
        replacements = 0
        
        try:
            with open(file_path, 'r', encoding='utf-8', errors='ignore') as f:
                content = f.read()
            
            original_content = content
            
            for emoji, unicode_char in self.emoji_map.items():
                if emoji in content:
                    count = content.count(emoji)
                    content = content.replace(emoji, unicode_char)
                    replacements += count
                    self.stats['replacements'] += count
            
            if content != original_content:
                self.stats['files_modified'] += 1
                
                if not self.dry_run:
                    # Crear backup si no es dry_run
                    if self.backup:
                        self.create_backup(file_path)
                    
                    # Escribir archivo
                    with open(file_path, 'w', encoding='utf-8') as f:
                        f.write(content)
        
        except Exception as e:
            print(f"{Colors.RED}✗ Error procesando {file_path}: {e}{Colors.RESET}")
        
        return replacements
    
    def process_directory(self, directory: str) -> None:
        """Procesar directorio completo"""
        print(f"\n{Colors.CYAN}▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬{Colors.RESET}")
        print(f"{Colors.BLUE}◆ Reemplazando emojis en: {directory}{Colors.RESET}")
        if self.dry_run:
            print(f"{Colors.YELLOW}⚠ MODO SIMULACIÓN (sin cambios reales){Colors.RESET}")
        print(f"{Colors.CYAN}▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬{Colors.RESET}\n")
        
        dir_path = Path(directory)
        
        for file_path in dir_path.rglob('*'):
            if not file_path.is_file():
                continue
            
            if self.should_skip_file(str(file_path)):
                continue
            
            self.stats['files_processed'] += 1
            replacements = self.replace_emojis_in_file(str(file_path))
            
            if replacements > 0:
                action = "Se reemplazaría" if self.dry_run else "Reemplazado"
                print(f"{Colors.GREEN}✓{Colors.RESET} {action} {replacements} emoji(s) en: {file_path}")
    
    def print_summary(self) -> None:
        """Mostrar resumen"""
        print(f"\n{Colors.CYAN}▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬{Colors.RESET}")
        print(f"{Colors.BLUE}★ RESUMEN{Colors.RESET}")
        print(f"{Colors.CYAN}▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬{Colors.RESET}")
        
        print(f"📊 Archivos procesados: {Colors.CYAN}{self.stats['files_processed']}{Colors.RESET}")
        print(f"🔄 Archivos modificados: {Colors.YELLOW if self.stats['files_modified'] > 0 else Colors.GREEN}{self.stats['files_modified']}{Colors.RESET}")
        print(f"✖ Reemplazamientos totales: {Colors.YELLOW if self.stats['replacements'] > 0 else Colors.GREEN}{self.stats['replacements']}{Colors.RESET}")
        print(f"💾 Backups creados: {Colors.CYAN}{self.stats['backup_created']}{Colors.RESET}")
        
        if self.dry_run:
            print(f"\n{Colors.YELLOW}⚠ Estos números son ESTIMACIONES (modo simulación activado){Colors.RESET}")
        
        print()


def main():
    parser = argparse.ArgumentParser(
        description='Reemplazar automáticamente emojis ChatGPT por Unicode',
        epilog="""
ADVERTENCIA: Este script modifica archivos. Siempre crea backups.

Ejemplos:
  # Simulación (sin cambios)
  python3 replace_emojis.py . --dry-run
  
  # Reemplazar en directorio actual
  python3 replace_emojis.py .
  
  # Reemplazar sin crear backups
  python3 replace_emojis.py /path/repos --no-backup
        """
    )
    
    parser.add_argument('directory', nargs='?', default='.',
                       help='Directorio a procesar (por defecto: actual)')
    parser.add_argument('--dry-run', action='store_true',
                       help='Simular cambios sin modificar archivos')
    parser.add_argument('--no-backup', action='store_true',
                       help='No crear archivos .bak')
    parser.add_argument('--force', '-f', action='store_true',
                       help='No pedir confirmación')
    
    args = parser.parse_args()
    
    # Validar directorio
    if not Path(args.directory).is_dir():
        print(f"{Colors.RED}✗ Error: {args.directory} no es un directorio válido{Colors.RESET}")
        sys.exit(1)
    
    # Localizar mapa
    script_dir = Path(__file__).parent
    emoji_map_path = script_dir / 'emoji_unicode_map.json'
    
    if not emoji_map_path.exists():
        print(f"{Colors.RED}✗ Error: emoji_unicode_map.json no encontrado{Colors.RESET}")
        sys.exit(1)
    
    # Confirmación
    if not args.dry_run and not args.force and not args.no_backup:
        print(f"{Colors.YELLOW}⚠ ADVERTENCIA: Esto modificará archivos{Colors.RESET}")
        print(f"Se crearán backups (.bak) de todos los archivos modificados\n")
        response = input(f"{Colors.YELLOW}¿Continuar? (s/n): {Colors.RESET}")
        if response.lower() != 's':
            print("Operación cancelada.")
            sys.exit(0)
    
    # Ejecutar
    replacer = EmojiReplacer(
        str(emoji_map_path),
        dry_run=args.dry_run,
        backup=not args.no_backup
    )
    
    replacer.process_directory(args.directory)
    replacer.print_summary()


if __name__ == '__main__':
    main()
