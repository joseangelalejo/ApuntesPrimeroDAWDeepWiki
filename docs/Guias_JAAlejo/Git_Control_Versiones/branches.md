# Estructura de Branches en MisApuntesITPDAW

## Introducción

Este documento describe la estructura de branches propuesta para el repositorio `MisApuntesITPDAW`. El objetivo es organizar el trabajo por asignaturas y tareas generales, facilitando el desarrollo paralelo entre laptop y torre, y manteniendo la estabilidad del código principal.

## Branches Recomendadas

1. **main**: La branch principal, con el código estable y final. Aquí meto las versiones completas.
2. **develop**: Para juntar cambios entre laptop y torre. La uso para integrar todo antes de main.
3. **feature/bases_datos**: Para todo lo de BASE DE DATOS, como scripts SQL y ejercicios de la U3.
4. **feature/entornos_desarrollo**: Para ENTORNOS DE DESARROLLO, Swing y prácticas de IDE.
5. **feature/lenguajes_marcas**: Para LENGUAJES DE MARCAS, HTML/CSS y actividades.
6. **feature/programacion**: Para PROGRAMACIÓN, Java POO y exámenes.
7. **feature/sistemas_informaticos**: Para SISTEMAS INFORMÁTICOS, VMs y docs.
8. **feature/sostenibilidad_digitalizacion**: Para SOSTENIBILIDAD y DIGITALIZACION juntas.
9. **feature/docs**: Para la carpeta docs/, guías y recursos.
10. **feature/general**: Para archivos generales como README, TODO y configs.

## Diagrama ASCII

```markdown
main---|---------------------------------
  develop---|-----------------------------
            feature/bases_datos---|------
            feature/entornos_desarrollo---|-
            feature/lenguajes_marcas---|---
            feature/programacion---|------
            feature/sistemas_informaticos---|-
            feature/sostenibilidad_digitalizacion---|-
            feature/docs---|----------------
            feature/general---|-------------
```

## Flujo de Trabajo Habitual

1. **Diario**: Creo una branch feature desde develop para la asignatura que toque (ej. feature/bases-datos).
2. **Desarrollo**: Cambio a esa branch, edito archivos y commiteo cambios.
3. **Integrar**: Cuando termino, mergeo a develop.
4. **Publicar/Release**: Fusionar de develop a main via PR en GitHub para versiones estables.
5. **Sync/Sincronización**: Uso `git fetch` y `git pull` para sincronizar entre mi portátil y mi torre.

## Comandos Git Habituales

- **Crear branch**: `git checkout -b nombre-branch` (desde develop).
- **Cambiar branch**: `git checkout nombre-branch`.
- **Commit**: `git add .` y luego `git commit -m "mensaje"`.
- **Push**: `git push origin nombre-branch`.
- **Merge**: `git checkout develop` luego `git merge nombre-branch`.
- **Fetch remoto**: `git fetch origin`.
- **Pull**: `git pull origin nombre-branch`.
- **Eliminar branch**: `git branch -d nombre-branch` (después de merge).

Protejo con rules en GitHub para no borrar por error.

## Protección de Branches

Para evitar borrados accidentales, configuro rules en GitHub (Settings > Branches):

- **main**: Require PR, Block force pushes, Restrict deletions, 1 approval. Bypass para mí (owner).
- **develop**: Igual que main, pero sin Require PR para flexibilidad.
- **feature/* (todas)**: Solo Restrict deletions y Block force pushes. No Require PR.

Excepción para el owner/administrador del repo para bypass en casos necesarios.

Esto no es peligroso para vulnerabilidades; al contrario, mejora seguridad al controlar merges y evitar cambios no autorizados. Solo afecta gestión interna, no expone código.
