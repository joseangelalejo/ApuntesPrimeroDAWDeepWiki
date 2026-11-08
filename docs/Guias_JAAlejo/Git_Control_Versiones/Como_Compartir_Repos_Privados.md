# Cómo Compartir un Repositorio Privado con Permisos de Solo Lectura - José Ángel Alejo Sillero

Esta guía explica paso a paso cómo compartir un repositorio privado en GitHub con alguien, otorgando permisos de solo lectura (lectura). Esto permite que la persona invitada vea, clone y descargue el contenido, pero no edite, haga commits o modifique el repositorio.

- [Cómo Compartir un Repositorio Privado con Permisos de Solo Lectura - José Ángel Alejo Sillero](#cómo-compartir-un-repositorio-privado-con-permisos-de-solo-lectura---josé-ángel-alejo-sillero)
  - [1. Preparación del Repositorio](#1-preparación-del-repositorio)
  - [2. Invitar a un Colaborador en GitHub](#2-invitar-a-un-colaborador-en-github)
    - [Paso 1: Acceder a la configuración del repositorio](#paso-1-acceder-a-la-configuración-del-repositorio)
    - [Paso 2: Ve a la sección de Colaboradores](#paso-2-ve-a-la-sección-de-colaboradores)
    - [Paso 3: Agrega al colaborador](#paso-3-agrega-al-colaborador)
    - [Paso 4: Envía la invitación](#paso-4-envía-la-invitación)
  - [3. Verificación y Gestión](#3-verificación-y-gestión)
    - [Verificar acceso](#verificar-acceso)
    - [Gestionar permisos](#gestionar-permisos)
  - [4. Consejos Adicionales](#4-consejos-adicionales)
  - [Webgrafía / Recursos](#webgrafía--recursos)

---

## 1. Preparación del Repositorio

Antes de compartirlo, deberías asegurarte de que el repositorio esté limpio y seguro, para ello haremos lo siguiente:

- **Revisar información sensible**: Elimina o excluye datos personales, contraseñas, claves API o rutas absolutas. Yo uso un archivo `.gitignore` para excluir archivos automáticamente.
- **Confirmar que el repo esté en privado**: En GitHub, ve a Settings > Danger Zone y verifica que sea privado.
- **Hacer un commit limpio**: Asegúrate de que todos los cambios estén commited y pushed.

```bash
git status  # Verifica el estado
git add .   # Añade cambios si es necesario
git commit -m "Versión limpia para compartir"
git push origin main  # Sube a GitHub
```

## 2. Invitar a un Colaborador en GitHub

### Paso 1: Acceder a la configuración del repositorio

- Ve a tu repositorio en GitHub (ejemplo: <https://github.com/tu-usuario/nombre-repo>).
- Haz clic en la pestaña **Settings** (engranaje) en la parte superior.

### Paso 2: Ve a la sección de Colaboradores

- En el menú lateral izquierdo, selecciona **Collaborators** (o "Colaboradores").
- Si es necesario, confirma tu contraseña o usa autenticación de dos factores (2FA).

### Paso 3: Agrega al colaborador

- Haz clic en **Add people** (o "Agregar personas").
- Ingresa el username de GitHub de la persona (ejemplo: `usuarioPepe`).
- Selecciona el usuario de la lista de resultados.
- En **Choose a role**, selecciona **Read** (solo lectura).
- Haz clic en **Add [username] to this repository**.

### Paso 4: Envía la invitación

- GitHub enviará una notificación por email al colaborador.
- El colaborador debe aceptar la invitación desde sus notificaciones en GitHub o el email.

## 3. Verificación y Gestión

### Verificar acceso

- Una vez aceptada, el colaborador debería aparecer en la lista de colaboradores con rol "Read".
- El colaborador podrá:
  - Ver archivos y commits.
  - Clonar el repositorio: `git clone https://github.com/tu-usuario/nombre-repo.git`.
  - Descargar archivos.
- **No podrá**: Editar, hacer push, crear branches o modificar settings.

### Gestionar permisos

- Para revocar acceso: Ve a Collaborators (o "Colaboradores"), haz clic en el usuario y selecciona "Remove".
- Para cambiar permisos: Edita el rol desde la misma página.

## 4. Consejos Adicionales

- **Comunicación**: Es recomendable enviar un mensaje al colaborador con el enlace del repositorio y explicar que es solo de lectura.
- **Seguridad**: Compartir solo lo necesario; si hay dudas sobre contenido sensible, revisa el repo con herramientas como `grep`.
- **Alternativas**: Si no quieres usar colaboradores, haz el repo público (todos pueden ver, pero no editar).
- **Problemas comunes**: Si el usuario no aparece en la búsqueda, verifica el username. Si no acepta, reenvía la invitación.

<div style="page-break-after: always;"></div>

Esta guía asegura un sharing seguro y controlado. Para más detalles, consulta la documentación oficial de GitHub.

## Webgrafía / Recursos

- [GitHub Docs: Managing access to your repository](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/managing-repository-settings/managing-access-to-your-repository)
- [GitHub Docs: Inviting collaborators to a personal repository](https://docs.github.com/en/github/setting-up-and-managing-your-github-user-account/inviting-collaborators-to-a-personal-repository)
