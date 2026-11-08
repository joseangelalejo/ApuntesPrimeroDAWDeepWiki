# Guía rápida de Git - Para principiantes

- [Guía rápida de Git - Para principiantes](#guía-rápida-de-git---para-principiantes)
  - [1. Configuración inicial (solo la primera vez)](#1-configuración-inicial-solo-la-primera-vez)
  - [2. Crear un nuevo repositorio desde cero](#2-crear-un-nuevo-repositorio-desde-cero)
    - [Opción A: Empezar desde tu computadora](#opción-a-empezar-desde-tu-computadora)
    - [Opción B: Clonar un repositorio existente](#opción-b-clonar-un-repositorio-existente)
  - [3. Flujo de trabajo diario](#3-flujo-de-trabajo-diario)
    - [3.1. Comprobar el estado](#31-comprobar-el-estado)
    - [3.2. Añadir cambios al staging](#32-añadir-cambios-al-staging)
    - [3.3. Guardar cambios (commit)](#33-guardar-cambios-commit)
    - [3.4. Subir cambios a GitHub](#34-subir-cambios-a-github)
    - [3.5. Descargar cambios de GitHub](#35-descargar-cambios-de-github)
  - [4. Trabajar con ramas](#4-trabajar-con-ramas)
    - [Ejemplo práctico con ramas develop y feature](#ejemplo-práctico-con-ramas-develop-y-feature)
  - [5. Ver historial](#5-ver-historial)
  - [6. Ver cambios del día actual](#6-ver-cambios-del-día-actual)
  - [7. Comandos de emergencia](#7-comandos-de-emergencia)
    - [Descartar cambios locales y sincronizar con el repositorio remoto](#descartar-cambios-locales-y-sincronizar-con-el-repositorio-remoto)
  - [8. Comandos útiles adicionales](#8-comandos-útiles-adicionales)
  - [9. Enlaces simbólicos](#9-enlaces-simbólicos)
    - [Configurar Git para manejar enlaces simbólicos](#configurar-git-para-manejar-enlaces-simbólicos)
    - [Crear un enlace simbólico](#crear-un-enlace-simbólico)
      - [Windows](#windows)
      - [Arch Linux / Debian](#arch-linux--debian)
      - [Comparativa: Windows vs Linux](#comparativa-windows-vs-linux)
    - [Usar el enlace en Git](#usar-el-enlace-en-git)
  - [10. Resolución de problemas con SSH en extensiones de Git](#10-resolución-de-problemas-con-ssh-en-extensiones-de-git)
    - [Problema: Extensiones como Git Graph no pueden hacer fetch con SSH](#problema-extensiones-como-git-graph-no-pueden-hacer-fetch-con-ssh)
    - [Solución: Configurar Git para usar SSH con clave específica](#solución-configurar-git-para-usar-ssh-con-clave-específica)
  - [11. Comandos adicionales de Git](#11-comandos-adicionales-de-git)
    - [Comandos básicos y flujo de trabajo](#comandos-básicos-y-flujo-de-trabajo)
    - [Ver historial y navegación](#ver-historial-y-navegación)
    - [Trabajar con ramas](#trabajar-con-ramas)
    - [Repositorios remotos](#repositorios-remotos)
    - [Configuración](#configuración)
  - [12. Merge de ramas en una nueva rama](#12-merge-de-ramas-en-una-nueva-rama)
  - [📝 Resumen del flujo básico](#-resumen-del-flujo-básico)
  - [Mini guía creada por Jose Angel Alejo, alumno de 1º de DAW en ITPFP Pablo de la Torre\*](#mini-guía-creada-por-jose-angel-alejo-alumno-de-1º-de-daw-en-itpfp-pablo-de-la-torre)

## 1. Configuración inicial (solo la primera vez)

```bash
git config --global user.name "TuNombre"   # Configura tu nombre de usuario global
git config --global user.email "tuemail@example.com"  # Configura tu email global
```

## 2. Crear un nuevo repositorio desde cero

### Opción A: Empezar desde tu computadora

```bash
# 1. Inicializa un nuevo repositorio Git en la carpeta actual
git init

# 2. Añade todos los archivos del directorio actual al stage
git add .

# 3. Confirmación (commit) con todos los archivos añadidos
git commit -m "first commit"

# 4. Renombra la rama actual a "main"
git branch -M main

# 5. Vincula tu repositorio local con un repositorio remoto en GitHub
git remote add origin git@github.com:usuario/repositorio.git

# 6. Sube los cambios a GitHub
# (la opción -u establece un tracking para que, en el futuro, se pueda usar
# simplemente git push y git pull sin especificar rama ni remoto)
git push -u origin main
```

**Nota sobre SSH vs HTTPS:** Git soporta dos protocolos para conectarte a repositorios remotos: SSH y HTTPS.

- **SSH**: Usa claves criptográficas para autenticación (más seguro, sin necesidad de ingresar credenciales cada vez). Requiere configurar una clave SSH. Ejemplo: `git@github.com:usuario/repositorio.git`.
- **HTTPS**: Usa tu nombre de usuario y contraseña/Personal Access Token. Es más simple para principiantes, pero pide credenciales frecuentemente. Ejemplo: `https://github.com/usuario/repo.git`.

Usa SSH si prefieres seguridad sin prompts constantes; HTTPS si es más fácil de configurar inicialmente. Puedes cambiar entre ellos con `git remote set-url origin <nueva-url>`.

### Opción B: Clonar un repositorio existente

```bash
git clone URL_DEL_REPOSITORIO  # Descarga una copia completa del repositorio
```

## 3. Flujo de trabajo diario

### 3.1. Comprobar el estado

```bash
git status  # Muestra qué archivos han cambiado y están listos para hacer commit
```

### 3.2. Añadir cambios al staging

```bash
git add .           # Añade todos los archivos nuevos o modificados
git add archivo.txt # Añade un archivo específico
```

### 3.3. Guardar cambios (commit)

```bash
git commit -m "Mensaje descriptivo"  # Guarda los cambios con un mensaje
```

### 3.4. Subir cambios a GitHub

```bash
git push origin main  # Sube tus cambios al repositorio remoto
```

### 3.5. Descargar cambios de GitHub

```bash
git pull origin main  # Trae los cambios del repositorio remoto y los fusiona
```

## 4. Trabajar con ramas

Las ramas permiten trabajar en diferentes versiones del código sin afectar la rama principal. Un flujo común es usar `main` para producción, `develop` para desarrollo continuo, y ramas `feature` para nuevas funcionalidades.

```bash
git branch              # Lista las ramas locales
git checkout nombre_rama   # Cambia a otra rama existente
git checkout -b nueva_rama # Crea una nueva rama y cambia a ella
```

### Ejemplo práctico con ramas develop y feature

Imagina que tienes una rama `develop` para desarrollo y quieres crear una nueva funcionalidad en una rama `feature/nueva-funcion`.

1. **Asegúrate de estar en develop y actualízala**:

   ```bash
   git checkout develop
   git pull origin develop  # Trae cambios recientes
   ```

2. **Crea y cambia a una rama feature desde develop**:

   ```bash
   git checkout -b feature/nueva-funcion
   ```

3. **Trabaja en la nueva funcionalidad**: Haz commits en `feature/nueva-funcion`.

   ```bash
   git add .
   git commit -m "Añadir nueva funcionalidad"
   ```

4. **Sube la rama feature al remoto**:

   ```bash
   git push -u origin feature/nueva-funcion
   ```

5. **Fusiona la feature de vuelta a develop** (cuando esté lista):

   ```bash
   git checkout develop
   git merge feature/nueva-funcion
   git push origin develop
   ```

6. **Elimina la rama feature después del merge**:

   ```bash
   git branch -d feature/nueva-funcion  # Local
   git push origin --delete feature/nueva-funcion  # Remoto
   ```

**Consejo:** Usa `git branch -a` para ver todas las ramas (locales y remotas). Si hay conflictos en el merge, resuélvelos editando los archivos y haciendo `git add` y `git commit`.

## 5. Ver historial

```bash
git log --oneline  # Muestra un historial resumido de commits
```

## 6. Ver cambios del día actual

Para ver todos los cambios realizados en el día actual, incluyendo la cantidad de líneas agregadas y eliminadas por cada archivo en los commits de hoy:

```bash
git log --numstat --since="2025-11-18" --until="2025-11-19"
```

- Reemplaza `since` y `until` con las fechas correspondientes al día que deseas analizar.
- La salida muestra por cada archivo: líneas agregadas, líneas eliminadas y nombre del archivo.
- Si no hay commits, no muestra nada.

> Este comando funcionará en terminales Unix/Linux y en PowerShell de Windows.
> Dentro de Git Bash en Windows, también funcionará correctamente.

Si queremos ver solo el total de líneas agregadas y eliminadas en los commits del día actual, podemos usar:

```bash
git log --numstat --since="2025-11-18" --until="2025-11-19" | awk '$1 ~ /^[0-9]+$/ && $2 ~ /^[0-9]+$/ {add += $1; del += $2} END {print "Agregadas:", add, "Eliminadas:", del}'
```

- La condición `$1 ~ /^[0-9]+$/ && $2 ~ /^[0-9]+$/` asegura que solo sume líneas numéricas, evitando errores con archivos binarios o no textuales.

## 7. Comandos de emergencia

### Descartar cambios locales y sincronizar con el repositorio remoto

```bash
git fetch --all     # Descarga todos los cambios del remoto
git reset --hard    # Sobrescribe tu copia local con el contenido del repositorio
```

⚠️ **Advertencia:** Este comando elimina todos tus cambios locales sin posibilidad de recuperarlos.

## 8. Comandos útiles adicionales

```bash
git remote add origin URL_DEL_REPOSITORIO  # Añade un repositorio remoto
git push -u origin main  # Primera vez subiendo a main (establece tracking)
```

## 9. Enlaces simbólicos

Los enlaces simbólicos (symlinks) permiten compartir carpetas o archivos entre diferentes ubicaciones en tu sistema de archivos sin duplicar el contenido. Son útiles para organizar proyectos compartiendo recursos comunes.

### Configurar Git para manejar enlaces simbólicos

Por defecto, Git en Windows no maneja symlinks correctamente. Configura esto una vez por repositorio:

```bash
git config core.symlinks true  # Habilita el manejo de symlinks en este repositorio
```

### Crear un enlace simbólico

#### Windows

Crear symlinks requiere permisos de administrador. Abre PowerShell o CMD como administrador y ejecuta:

```powershell
# Para carpetas (usando PowerShell)
New-Item -ItemType SymbolicLink -Path "ruta\al\enlace" -Target "ruta\al\carpeta\original"

# Para carpetas (usando CMD)
mklink /D "ruta\al\enlace" "ruta\al\carpeta\original"

# Para archivos (usando CMD)
mklink "ruta\al\enlace" "ruta\al\archivo\original"
```

**Ejemplo en Windows:**

```powershell
New-Item -ItemType SymbolicLink -Path "C:\Users\usuario\DAW\scripts" -Target "C:\Users\usuario\scripts_compartidos"
```

#### Arch Linux / Debian

En Linux, los enlaces simbólicos son mucho más simples. No requieren permisos de administrador:

```bash
# Sintaxis básica
ln -s /ruta/original /ruta/del/enlace

# Para carpetas
ln -s /home/usuario/scripts_compartidos /home/usuario/DAW/scripts

# Para crear enlaces relativos (recomendado para repositorios)
ln -sr /ruta/original /ruta/del/enlace
```

**Ejemplo en Arch/Debian:**

```bash
ln -s ~/scripts_compartidos ~/DAW/scripts
```

**Comandos útiles en Linux:**

```bash
# Ver detalles del enlace simbólico
ls -l ~/DAW/scripts

# Ver hacia dónde apunta el enlace
readlink ~/DAW/scripts

# Eliminar un enlace simbólico
rm ~/DAW/scripts

# Crear enlace relativo (mejor para repositorios Git)
ln -sr ~/scripts_compartidos ~/DAW/scripts
```

#### Comparativa: Windows vs Linux

| Operación               | Windows               | Linux          |
|-------------------------|-----------------------|----------------|
| **Crear enlace**        | `New-Item` o `mklink` | `ln -s`        |
| **Sintaxis**            | Parámetros nombrados  | Posicional     |
| **Rutas**               | `\`                   | `/`            |
| **Permisos necesarios** | Administrador         | Usuario normal |
| **Enlace relativo**     | Automático            | `-r` flag      |
| **Ver destino**         | Propiedades           | `readlink`     |
| **Eliminar**            | `del` o Delete        | `rm`           |

### Usar el enlace en Git

Después de crear el symlink, añádelo al repositorio como cualquier otro archivo:

```bash
git add ruta/al/enlace
git commit -m "Añadir enlace simbólico a carpeta compartida"
```

⚠️ **Nota:** Si clonas el repositorio en otro sistema, asegúrate de que también tenga `core.symlinks true` configurado para que los symlinks se creen correctamente. En Linux, esto es menos problemático, pero en Windows es imprescindible.

---

## 10. Resolución de problemas con SSH en extensiones de Git

### Problema: Extensiones como Git Graph no pueden hacer fetch con SSH

A veces, extensiones de VS Code como Git Graph o GitLens fallan al intentar operaciones remotas con SSH, mostrando errores como "Permission denied (publickey)", incluso si el comando `git fetch` funciona perfectamente en la terminal integrada de VS Code.

**Causa probable:** Las extensiones ejecutan Git en un contexto diferente al de la terminal, donde el agente SSH o la configuración no están disponibles.

### Solución: Configurar Git para usar SSH con clave específica

Configura Git globalmente para que use el ejecutable SSH con tu clave privada. Esto asegura que tanto la terminal como las extensiones usen la misma configuración.

1. **Verifica que tengas una clave SSH generada** (si no, créala):

   ```bash
   ssh-keygen -t ed25519 -C "tu-email@ejemplo.com"
   ```

   - Presiona Enter para aceptar la ubicación por defecto (C:/Users/Usuario/.ssh/id_ed25519).
   - Opcional: Ingresa una passphrase para mayor seguridad.

2. **Agrega la clave pública a tu cuenta de GitHub/GitLab/etc.**:
   - Copia el contenido de C:/Users/Usuario/.ssh/id_ed25519.pub.
   - Ve a la configuración de SSH de tu proveedor (ej. GitHub > Settings > SSH and GPG keys) y agrega la clave.

3. **Inicia el agente SSH y agrega la clave privada** (opcional - principalmente necesario si tu clave tiene passphrase):

   ```powershell
   Start-Service ssh-agent  # Inicia el servicio (necesita permisos de admin)
   ssh-add "C:/Users/Usuario/.ssh/id_ed25519"  # Agrega la clave al agente
   ```

   > **Nota:** Este paso es principalmente beneficioso cuando tu clave SSH tiene una passphrase, ya que evita que se te pida la passphrase repetidamente. Si tu clave NO tiene passphrase, puedes omitir este paso; el paso 4 será suficiente.

4. **Configura Git para usar SSH con la clave**:

- **Opción 1: Configuración GLOBAL (afecta a todos tus repositorios Git)**:

```bash
git config --global core.sshCommand "C:/Windows/System32/OpenSSH/ssh.exe -i C:/Users/Usuario/.ssh/id_ed25519"
```

Esta configuración se aplica a todos los repositorios en tu sistema. Úsala si quieres que todas las extensiones de VS Code en cualquier proyecto usen la misma clave SSH.

- **Opción 2: Configuración POR REPOSITORIO (solo afecta al repositorio actual)**:

Navega al directorio del repositorio en la terminal integrada de VS Code y ejecuta:

```bash
git config core.sshCommand "C:/Windows/System32/OpenSSH/ssh.exe -i C:/Users/Usuario/.ssh/id_ed25519"
```

- **Opción 3: Reemplazar la configuración SSH en el repositorio actual**:
  - Para aplicarla en el repositorio deseado, debe ejecutarse el comando dentro de la carpeta del repositorio. Es útil si diferentes repositorios requieren claves SSH distintas o si prefieres no modificar la configuración global. Repite este comando en cada repositorio que necesite esta configuración.

```bash
git config --replace-all core.sshCommand "C:/Windows/System32/OpenSSH/ssh.exe -i C:/Users/TUUSUARIO/.ssh/id_ed25519"
```

(Reemplaza `TUUSUARIO` por tu nombre de usuario de Windows. Usa la ruta genérica para que funcione en cualquier equipo.)

- **Nota:** No es posible configurar Git específicamente por extensión de VS Code (por ejemplo, solo para Git Graph). La configuración afecta a todas las extensiones que interactúan con Git en ese repositorio. Si el problema es solo con ciertas extensiones, considera usar la configuración por repositorio en los proyectos afectados.

**¿Por qué configurar globalmente resuelve problemas en extensiones?**

Las extensiones de VS Code (como Git Graph o GitLens) ejecutan comandos de Git en un proceso separado del terminal integrado. Este proceso puede no heredar el mismo entorno (por ejemplo, variables de entorno como `SSH_AGENT_PID` o el agente SSH corriendo). Al configurar `core.sshCommand` globalmente, se asegura de que Git use siempre el ejecutable SSH correcto con tu clave privada, independientemente del contexto de ejecución. Esto resuelve inconsistencias donde la terminal funciona (porque hereda tu entorno), pero las extensiones fallan debido a un contexto limitado.

Si prefieres no usar configuración global, la opción por repositorio también funciona, ya que las extensiones respetan la configuración local del repo.

**Verificación:**

- Prueba `git fetch` en la terminal: Debería funcionar.
- Abre Git Graph y prueba fetch: Ahora debería funcionar sin errores de "Permission denied".

**Nota:** Si aún falla, cambia temporalmente el remoto a HTTPS para la extensión: `git remote set-url origin https://github.com/usuario/repo.git`. Para repos privados, usa un Personal Access Token como contraseña. Este cambio afecta solo a la configuración local del repositorio y no modifica otros dispositivos o clones que puedan estar usando SSH. Es reversible: ejecuta `git remote set-url origin git@github.com:usuario/repositorio.git` para volver a SSH. Si el problema persiste, revisa los permisos de archivos y asegúrate de que el agente SSH esté corriendo globalmente.

---

## 11. Comandos adicionales de Git

### Comandos básicos y flujo de trabajo

- `git reset`: Elimina archivos del área de preparación.
- `git commit -a -m "nombre del commit"`: El "-a" hace el `git add .`, ahorrándonos un paso.

### Ver historial y navegación

- `git log`: Muestra todos los commits.
- `git log --oneline --graph --decorate --all`: Muestra las ramas y commits.
- `git checkout "hash commit"`: Vuelve temporalmente a un commit anterior en modo detached HEAD. Para volver a la rama actual, usa `git checkout "nombre Rama"`.
- `git reset --hard "hash commit"`: Regresa de forma permanente a un commit, deshaciendo los cambios posteriores.
- `git revert "hash commit"`: Vuelve a un estado anterior pero manteniendo los commits posteriores, crea un nuevo commit en el estado del commit especificado.
- `git checkout -b "nueva rama" "hash commit"`: Crea una nueva rama desde un commit anterior sin alterar la rama actual.
- `git reset --soft "hash commit"`: Elimina commits de forma segura.

### Trabajar con ramas

- `git branch -d "nombre-de-la-rama"`: Eliminar rama.
- `git branch -a`: Ver todas las ramas.
- `git merge master`: Fusiona la rama actual con la master.

### Repositorios remotos

- `git remote remove origin`: Desvincula la ubicación remota de un repositorio.
- `git remote -v`: Muestra el repositorio vinculado.

### Configuración

Verificar la configuración actual:

```bash
git config user.email
git config user.name
```

## 12. Merge de ramas en una nueva rama

Para combinar cambios de múltiples ramas en una nueva rama, sigue estos pasos:

```bash
# 1. Cambiar a la rama base (por ejemplo, main)
git checkout main

# 2. Crear una nueva rama desde la rama base
git checkout -b nueva-rama

# 3. Mergear la primera rama (por ejemplo, rama-producto)
git merge rama-producto

# 4. Si hay conflictos, resolverlos editando los archivos y luego:
git add archivo-conflicto.html
git commit -m "Resolver conflictos del merge"

# 5. Mergear la segunda rama (por ejemplo, rama-cociente)
git merge rama-cociente

# 6. Resolver conflictos si los hay, y commitear
git add archivo-conflicto.html
git commit -m "Merge ramas producto y cociente en nueva-rama"
```

Esto crea una rama que combina los cambios de ambas ramas, resolviendo conflictos manualmente.

---

## 📝 Resumen del flujo básico

1. `git status` - Ver qué ha cambiado
2. `git add .` - Preparar archivos
3. `git commit -m "mensaje"` - Guardar cambios
4. `git push origin main` - Subir a GitHub
5. `git pull origin main` - Descargar de GitHub

## Mini guía creada por Jose Angel Alejo, alumno de 1º de DAW en ITPFP Pablo de la Torre*
