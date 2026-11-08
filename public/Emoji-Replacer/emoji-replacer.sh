#!/bin/bash

# ◆ Emoji Replacer Suite - Versión Avanzada
# ══════════════════════════════════════════════════════════════════
# Analiza repos, busca emojis ChatGPT y reemplaza por Unicode
# Ubicación: MisApuntesITPDAW/public/Emoji-Replacer/

set -e

# Colors
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
CYAN='\033[0;36m'
PURPLE='\033[0;35m'
RESET='\033[0m'
BOLD='\033[1m'

# Script dir
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
EMOJI_MAP="$SCRIPT_DIR/emoji_unicode_map.json"

# Global vars
declare -a REPOS
declare -a SELECTED_REPOS
declare -a FILE_PATTERNS=("*.md" "*.py" "*.js" "*.ts" "*.sh" "*.txt")
declare -a SELECTED_PATTERNS
DRY_RUN=false

# ═════════════════════════════════════════════════════════════════
# FUNCIONES UTILIDAD
# ═════════════════════════════════════════════════════════════════

header() {
    clear
    echo -e "${BLUE}▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬${RESET}"
    echo -e "${CYAN}◆ Emoji Replacer Suite${RESET}"
    echo -e "${BLUE}▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬${RESET}"
    echo ""
}

validate_json() {
    if [[ ! -f "$EMOJI_MAP" ]]; then
        echo -e "${RED}✗ Error: emoji_unicode_map.json no encontrado${RESET}"
        exit 1
    fi
}

# ═════════════════════════════════════════════════════════════════
# ANÁLISIS DE REPOSITORIOS
# ═════════════════════════════════════════════════════════════════

find_repos() {
    local search_dir="${1:-.}"
    local depth="${2:-2}"
    
    header
    echo -e "${YELLOW}🔍 Analizando repositorios en: $search_dir${RESET}"
    echo ""
    
    REPOS=()
    local count=0
    
    # Buscar directorios con .git (repos git)
    while IFS= read -r -d '' repo_dir; do
        REPOS+=("$(dirname "$repo_dir")")
        ((count++))
    done < <(find "$search_dir" -maxdepth $depth -name ".git" -type d -print0 2>/dev/null)
    
    # También buscar directorios con package.json, pom.xml, setup.py (repos sin .git)
    while IFS= read -r -d '' manifest; do
        local dir="$(dirname "$manifest")"
        local is_in_repos=false
        for repo in "${REPOS[@]}"; do
            if [[ "$dir" == "$repo"* ]]; then
                is_in_repos=true
                break
            fi
        done
        if [[ "$is_in_repos" == false ]]; then
            REPOS+=("$dir")
            ((count++))
        fi
    done < <(find "$search_dir" -maxdepth $depth \( -name "package.json" -o -name "pom.xml" -o -name "setup.py" \) -type f -print0 2>/dev/null)
    
    if [[ $count -eq 0 ]]; then
        echo -e "${YELLOW}⚠ No se encontraron repositorios${RESET}"
        return 1
    fi
    
    echo -e "${GREEN}✓ Se encontraron ${CYAN}$count${GREEN} repositorio(s)${RESET}"
    echo ""
    
    return 0
}

list_repos() {
    echo -e "${BLUE}▬ Repositorios disponibles:${RESET}"
    echo ""
    for ((i=0; i<${#REPOS[@]}; i++)); do
        local repo="${REPOS[$i]}"
        local name=$(basename "$repo")
        echo "  ${BOLD}[$((i+1))]${RESET} $name"
        echo "      ${CYAN}$(echo $repo | sed "s|$HOME|~|g")${RESET}"
    done
    echo ""
}

select_repos() {
    header
    list_repos
    
    echo -e "${YELLOW}Selecciona repos a procesar:${RESET}"
    echo "  • Números: 1,2,3 o rango: 1-3 o 1,3,5"
    echo "  • 'a' para todos"
    echo "  • 'n' para ninguno (cancelar)"
    read -p "> " selection
    
    SELECTED_REPOS=()
    
    if [[ "$selection" == "n" ]]; then
        echo -e "${YELLOW}✗ Operación cancelada${RESET}"
        sleep 1
        return 1
    fi
    
    if [[ "$selection" == "a" ]]; then
        SELECTED_REPOS=("${REPOS[@]}")
        echo -e "${GREEN}✓ Seleccionados todos los repos${RESET}"
        return 0
    fi
    
    # Parsear selecciones
    IFS=',' read -ra selections <<< "$selection"
    for sel in "${selections[@]}"; do
        sel=$(echo "$sel" | xargs)  # trim whitespace
        
        if [[ "$sel" =~ ^[0-9]+-[0-9]+$ ]]; then
            # Rango: 1-3
            local start=${sel%-*}
            local end=${sel#*-}
            for ((j=start; j<=end; j++)); do
                if [[ $j -gt 0 && $j -le ${#REPOS[@]} ]]; then
                    SELECTED_REPOS+=("${REPOS[$((j-1))]}")
                fi
            done
        elif [[ "$sel" =~ ^[0-9]+$ ]]; then
            # Individual: 5
            if [[ $sel -gt 0 && $sel -le ${#REPOS[@]} ]]; then
                SELECTED_REPOS+=("${REPOS[$((sel-1))]}")
            fi
        fi
    done
    
    if [[ ${#SELECTED_REPOS[@]} -eq 0 ]]; then
        echo -e "${RED}✗ No se seleccionó ningún repo${RESET}"
        sleep 2
        return 1
    fi
    
    echo -e "${GREEN}✓ Seleccionados ${#SELECTED_REPOS[@]} repo(s)${RESET}"
    sleep 1
    return 0
}

# ═════════════════════════════════════════════════════════════════
# SELECCIÓN DE TIPOS DE ARCHIVO
# ═════════════════════════════════════════════════════════════════

select_file_types() {
    header
    echo -e "${BLUE}▬ Tipos de archivo disponibles:${RESET}"
    echo ""
    
    local all_patterns=("*.md" "*.py" "*.js" "*.ts" "*.jsx" "*.tsx" "*.sh" "*.txt" "*.json" "*.yaml" "*.yml" "*.toml" "*.java" "*.rs" "*.go" "Dockerfile" "*.html" "*.css" "*.xml")
    
    echo "  Presets:"
    echo "    ${BOLD}[1]${RESET} Documentación (*.md, *.txt)"
    echo "    ${BOLD}[2]${RESET} Código Python (*.py)"
    echo "    ${BOLD}[3]${RESET} Código JavaScript/TypeScript (*.js, *.ts, *.jsx, *.tsx)"
    echo "    ${BOLD}[4]${RESET} Scripts (*.sh, Dockerfile)"
    echo "    ${BOLD}[5]${RESET} Configuración (*.json, *.yaml, *.yml, *.toml, *.xml)"
    echo "    ${BOLD}[6]${RESET} Todos los soportados"
    echo "    ${BOLD}[7]${RESET} Personalizado"
    echo ""
    
    read -p "Elige preset (1-7): " preset
    
    case $preset in
        1)
            SELECTED_PATTERNS=("*.md" "*.txt")
            ;;
        2)
            SELECTED_PATTERNS=("*.py")
            ;;
        3)
            SELECTED_PATTERNS=("*.js" "*.ts" "*.jsx" "*.tsx")
            ;;
        4)
            SELECTED_PATTERNS=("*.sh" "Dockerfile")
            ;;
        5)
            SELECTED_PATTERNS=("*.json" "*.yaml" "*.yml" "*.toml" "*.xml")
            ;;
        6)
            SELECTED_PATTERNS=("*.md" "*.py" "*.js" "*.ts" "*.jsx" "*.tsx" "*.sh" "*.txt" "*.json" "*.yaml" "*.yml" "*.toml" "*.java" "*.rs" "*.go" "Dockerfile" "*.html" "*.css" "*.xml")
            ;;
        7)
            echo ""
            echo -e "${YELLOW}Ingresa patrones separados por espacios (ej: *.md *.py):${RESET}"
            read -p "> " custom
            SELECTED_PATTERNS=($custom)
            ;;
        *)
            echo -e "${RED}✗ Opción inválida${RESET}"
            sleep 1
            return 1
            ;;
    esac
    
    echo -e "${GREEN}✓ Patrones seleccionados: ${CYAN}${SELECTED_PATTERNS[*]}${RESET}"
    sleep 1
    return 0
}

# ═════════════════════════════════════════════════════════════════
# OPERACIONES DE BÚSQUEDA Y REEMPLAZO
# ═════════════════════════════════════════════════════════════════

search_emojis() {
    header
    echo -e "${BLUE}▬ Buscando emojis...${RESET}"
    echo ""
    
    local search_cmd=""
    for pattern in "${SELECTED_PATTERNS[@]}"; do
        if [[ -z "$search_cmd" ]]; then
            search_cmd="-name '$pattern' -o"
        else
            search_cmd="$search_cmd -name '$pattern' -o"
        fi
    done
    search_cmd="${search_cmd% -o}"
    
    for repo in "${SELECTED_REPOS[@]}"; do
        echo -e "${CYAN}📂 $(basename "$repo")${RESET}"
        cd "$repo"
        python3 "$SCRIPT_DIR/find_emojis.py" . 2>&1 | head -50
        cd - > /dev/null
    done
}

replace_emojis_interactive() {
    header
    echo -e "${YELLOW}⚠⚠⚠ REEMPLAZANDO EMOJIS ⚠⚠⚠${RESET}"
    echo ""
    echo "Se procesarán:"
    echo "  • Repositorios: ${#SELECTED_REPOS[@]}"
    echo "  • Patrones: ${SELECTED_PATTERNS[*]}"
    echo ""
    echo -e "${YELLOW}Se crearán backups .bak de todos los archivos modificados${RESET}"
    echo ""
    read -p "¿Continuar? (s/n): " confirm
    
    if [[ "$confirm" != "s" ]]; then
        echo -e "${YELLOW}✗ Operación cancelada${RESET}"
        sleep 1
        return
    fi
    
    for repo in "${SELECTED_REPOS[@]}"; do
        echo -e "${CYAN}📂 Procesando $(basename "$repo")...${RESET}"
        cd "$repo"
        python3 "$SCRIPT_DIR/replace_emojis.py" . --force
        cd - > /dev/null
    done
}

generate_report() {
    header
    echo -e "${BLUE}▬ Generando reporte...${RESET}"
    echo ""
    
    local report_file="emoji_audit_$(date +%Y%m%d_%H%M%S).json"
    
    for repo in "${SELECTED_REPOS[@]}"; do
        echo -e "${CYAN}📂 Procesando $(basename "$repo")...${RESET}"
        cd "$repo"
        python3 "$SCRIPT_DIR/find_emojis.py" . --json "${report_file}_$(basename "$repo")" 2>&1 | tail -3
        cd - > /dev/null
    done
    
    echo ""
    echo -e "${GREEN}✓ Reportes generados con prefijo: $report_file${RESET}"
    sleep 2
}

detect_new_emojis() {
    header
    echo -e "${BLUE}▬ Detectando emojis nuevos...${RESET}"
    echo ""
    
    if [[ ${#SELECTED_REPOS[@]} -eq 0 ]]; then
        echo -e "${RED}✗ Selecciona repositorios primero${RESET}"
        sleep 2
        return
    fi
    
    local detection_file="emojis_nuevos_$(date +%Y%m%d_%H%M%S).json"
    
    for repo in "${SELECTED_REPOS[@]}"; do
        echo -e "${CYAN}📂 Analizando $(basename "$repo")...${RESET}"
        cd "$repo"
        python3 "$SCRIPT_DIR/detect_new_emojis.py" . --json "$detection_file" 2>&1 | tail -5
        cd - > /dev/null
    done
    
    echo ""
    echo -e "${GREEN}✓ Análisis completado: $detection_file${RESET}"
    sleep 2
}

generate_contribution_proposal() {
    header
    echo -e "${BLUE}▬ Generando propuesta de contribución...${RESET}"
    echo ""
    
    # Buscar el archivo más reciente de detección
    local latest_detection=$(ls -t emojis_nuevos_*.json 2>/dev/null | head -1)
    
    if [[ -z "$latest_detection" ]]; then
        echo -e "${YELLOW}⚠ Primero ejecuta 'Detectar emojis nuevos' (opción 6)${RESET}"
        sleep 3
        return
    fi
    
    echo -e "${CYAN}Usando detección: $latest_detection${RESET}"
    echo ""
    
    # Generar propuesta
    python3 "$SCRIPT_DIR/generate_proposal.py" "$latest_detection" "$SCRIPT_DIR/emoji_unicode_map.json" \
        --markdown "PROPUESTA_NUEVOS_EMOJIS_$(date +%Y%m%d).md" \
        --json "emoji_unicode_map_updated.json" \
        --guide "GUIA_CONTRIBUCION.md" 2>&1
    
    echo ""
    echo -e "${GREEN}✓ Propuesta generada:${RESET}"
    echo "  • PROPUESTA_NUEVOS_EMOJIS_$(date +%Y%m%d).md"
    echo "  • emoji_unicode_map_updated.json"
    echo "  • GUIA_CONTRIBUCION.md"
    echo ""
    echo -e "${CYAN}Próximos pasos:${RESET}"
    echo "  1. Revisa PROPUESTA_NUEVOS_EMOJIS_$(date +%Y%m%d).md"
    echo "  2. Completa los campos de Unicode y descripción"
    echo "  3. Sigue GUIA_CONTRIBUCION.md para contribuir"
    
    sleep 3
}

# ═════════════════════════════════════════════════════════════════
# MENÚ PRINCIPAL
# ═════════════════════════════════════════════════════════════════

show_main_menu() {
    while true; do
        header
        
        if [[ ${#SELECTED_REPOS[@]} -gt 0 ]]; then
            echo -e "${GREEN}✓ Repos seleccionados: ${#SELECTED_REPOS[@]}${RESET}"
            echo -e "${GREEN}✓ Patrones: ${SELECTED_PATTERNS[*]}${RESET}"
        else
            echo -e "${YELLOW}⚠ No hay repos/patrones seleccionados${RESET}"
        fi
        
        echo ""
        echo -e "${BLUE}▬ MENÚ PRINCIPAL${RESET}"
        echo ""
        echo "1. 🔍 Analizar y seleccionar repositorios"
        echo "2. 🎯 Seleccionar tipos de archivo"
        echo "3. 🔎 Buscar emojis (vista previa)"
        echo "4. ✖  Reemplazar emojis (REAL)"
        echo "5. 📊 Generar reporte JSON"
        echo "6. 🆕 Detectar emojis nuevos"
        echo "7. 📝 Generar propuesta de contribución"
        echo "8. 📚 Ver documentación"
        echo "0. ✗ Salir"
        echo ""
        read -p "Opción: " choice
        
        case $choice in
            1)
                find_repos "." 3 || true
                select_repos || true
                ;;
            2)
                if [[ ${#SELECTED_REPOS[@]} -eq 0 ]]; then
                    echo -e "${RED}✗ Selecciona repositorios primero${RESET}"
                    sleep 2
                else
                    select_file_types || true
                fi
                ;;
            3)
                if [[ ${#SELECTED_REPOS[@]} -eq 0 ]] || [[ ${#SELECTED_PATTERNS[@]} -eq 0 ]]; then
                    echo -e "${RED}✗ Selecciona repos y patrones primero${RESET}"
                    sleep 2
                else
                    search_emojis
                    echo ""
                    read -p "Presiona Enter para continuar..."
                fi
                ;;
            4)
                if [[ ${#SELECTED_REPOS[@]} -eq 0 ]] || [[ ${#SELECTED_PATTERNS[@]} -eq 0 ]]; then
                    echo -e "${RED}✗ Selecciona repos y patrones primero${RESET}"
                    sleep 2
                else
                    replace_emojis_interactive
                fi
                ;;
            5)
                if [[ ${#SELECTED_REPOS[@]} -eq 0 ]]; then
                    echo -e "${RED}✗ Selecciona repositorios primero${RESET}"
                    sleep 2
                else
                    generate_report
                    read -p "Presiona Enter para continuar..."
                fi
                ;;
            6)
                detect_new_emojis
                read -p "Presiona Enter para continuar..."
                ;;
            7)
                generate_contribution_proposal
                read -p "Presiona Enter para continuar..."
                ;;
            8)
                if [[ -f "$SCRIPT_DIR/README_EMOJIS.md" ]]; then
                    less "$SCRIPT_DIR/README_EMOJIS.md"
                else
                    echo -e "${RED}✗ README_EMOJIS.md no encontrado${RESET}"
                    sleep 2
                fi
                ;;
            0)
                echo -e "${GREEN}✓ Adiós${RESET}"
                exit 0
                ;;
            *)
                echo -e "${RED}✗ Opción inválida${RESET}"
                sleep 1
                ;;
        esac
    done
}

# ═════════════════════════════════════════════════════════════════
# MAIN
# ═════════════════════════════════════════════════════════════════

main() {
    validate_json
    show_main_menu
}

# Se ejecuta
main
