# Git Cheatsheet

## Setup

```bash
git config --global user.name "Nombre"
git config --global user.email "email@example.com"
```

## Init & Clone

```bash
git init                           # Crear repo
git clone URL                      # Clonar repo
git remote add origin URL          # Añadir remoto
git remote -v                      # Ver remoto
```

## Status & Changes

```bash
git status                         # Ver cambios
git add .                          # Preparar todo
git add archivo                    # Preparar archivo
git commit -m "msg"                # Guardar cambios
git commit -a -m "msg"             # Add + commit
git push origin main               # Subir
git pull origin main               # Descargar
```

## Branches

| Comando                         | Uso             |
|---------------------------------|-----------------|
| `git branch`                    | Listar ramas    |
| `git branch -a`                 | Todas las ramas |
| `git checkout rama`             | Cambiar de rama |
| `git checkout -b nueva`         | Crear + cambiar |
| `git branch -d rama`            | Eliminar local  |
| `git push origin --delete rama` | Eliminar remoto |

## History

```bash
git log --oneline                  # Resumen commits
git log --oneline --graph --all    # Con gráfico
git log --numstat --since=DATE     # Cambios por fecha
```

## Undo & Reset

| Comando                 | Uso                  |
|-------------------------|----------------------|
| `git checkout hash`     | Ir a commit          |
| `git reset --soft hash` | Deshacer seguro      |
| `git reset --hard hash` | Deshacer             |
| `git revert hash`       | Crear commit inverso |

## Merge & Rebase

```bash
git merge rama                     # Fusionar rama
git rebase rama                    # Rebasear rama
git merge --abort                  # Cancelar merge
```

## Remoto & Upstream

```bash
git remote add upstream URL        # Añadir upstream
git fetch upstream                 # Traer cambios
git pull upstream main             # Traer + fusionar
git fetch --prune                  # Limpiar referencias
```

## Symlinks (Linux)

```bash
ln -s /origen /enlace              # Crear
ln -sr /origen /enlace             # Relativo
rm /enlace                         # Eliminar
```

## Symlinks (Windows)

```powershell
New-Item -ItemType SymbolicLink -Path "enlace" -Target "origen"
git config core.symlinks true
```

## SSH Config

```bash
ssh-keygen -t ed25519 -C "email"
git config --global core.sshCommand "ssh -i ~/.ssh/id_ed25519"
```

## Stash

```bash
git stash                          # Guardar cambios
git stash pop                      # Recuperar
git stash list                     # Listar
```

## Emergencia

```bash
git fetch --all                    # Descargar todo
git reset --hard origin/main       # Forzar local ⚠️
```

---
*Ref: [guia_guit_JA.md](../Git_Control_Versiones/guia_guit_JA.md)*
