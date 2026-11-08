# **GUÍA DE VSCODE PARA DESARROLLO EN JAVA Y GESTIÓN DE PROYECTOS | JOSÉ ÁNGEL ALEJO SILLERO**

Este archivo contiene instrucciones paso a paso para realizar tareas comunes y útiles en Visual Studio Code (VSCode), especialmente en el contexto de desarrollo y gestión de proyectos.

- [**GUÍA DE VSCODE PARA DESARROLLO EN JAVA Y GESTIÓN DE PROYECTOS | JOSÉ ÁNGEL ALEJO SILLERO**](#guía-de-vscode-para-desarrollo-en-java-y-gestión-de-proyectos--josé-ángel-alejo-sillero)
  - [**INTRODUCCIÓN**](#introducción)
  - [**HERRAMIENTAS CASE**](#herramientas-case)
    - [**EXTENSIONES, CONFIGURACIÓN Y USO DEL DEBUGGER EN JAVA PARA VSCODE**](#extensiones-configuración-y-uso-del-debugger-en-java-para-vscode)
      - [**CONFIGURACIÓN PARA DEBUGGEAR ARCHIVOS/PROGRAMAS EN JAVA:**](#configuración-para-debuggear-archivosprogramas-en-java)
      - [**CAMBIAR ATAJOS DE TECLADO PARA EL DEBUGGER:**](#cambiar-atajos-de-teclado-para-el-debugger)
      - [**INICIAR EL DEBUG**](#iniciar-el-debug)
        - [**OPCIÓN 1: USANDO EL BOTÓN DE DEBUG EN EL EDITOR**](#opción-1-usando-el-botón-de-debug-en-el-editor)
        - [**OPCIÓN 2: USANDO LA BARRA DE DEBUG**](#opción-2-usando-la-barra-de-debug)
      - [**CÓMO NAVEGAR EL DEBUG PASO A PASO**](#cómo-navegar-el-debug-paso-a-paso)
      - [**BUENAS PRÁCTICAS DE DEBUGGING**](#buenas-prácticas-de-debugging)
        - [**DÓNDE PONER BREAKPOINTS**](#dónde-poner-breakpoints)
    - [**USO DEL PROFILER EN JAVA PARA VSCODE**](#uso-del-profiler-en-java-para-vscode)
      - [**REQUISITOS PREVIOS**](#requisitos-previos)
      - [**INICIAR EL PROFILING**](#iniciar-el-profiling)
        - [**OPCIÓN 1: USANDO JAVA MISSION CONTROL (JMC)**](#opción-1-usando-java-mission-control-jmc)
        - [**OPCIÓN 2: USANDO VISUALVM**](#opción-2-usando-visualvm)
      - [**ANALIZAR RESULTADOS**](#analizar-resultados)
      - [**CONSEJOS PARA PROFILING EFECTIVO**](#consejos-para-profiling-efectivo)
  - [Creación de Enlaces Simbólicos en VSCode](#creación-de-enlaces-simbólicos-en-vscode)
    - [Windows](#windows)
      - [Consejos adicionales para Windows](#consejos-adicionales-para-windows)
    - [Arch Linux / Debian](#arch-linux--debian)
      - [Consejos adicionales para Linux](#consejos-adicionales-para-linux)
      - [Verificar la Creación del Enlace Simbólico](#verificar-la-creación-del-enlace-simbólico)
      - [Verificar la correcta interpretación del enlace simbólico por Git](#verificar-la-correcta-interpretación-del-enlace-simbólico-por-git)
  - [**RESOLUCIÓN DE PROBLEMAS CON SSH EN EXTENSIONES DE GIT**](#resolución-de-problemas-con-ssh-en-extensiones-de-git)
    - [**Problema: Extensiones como Git Graph no pueden hacer fetch con SSH**](#problema-extensiones-como-git-graph-no-pueden-hacer-fetch-con-ssh)
    - [**Solución: Configurar Git para usar SSH con clave específica**](#solución-configurar-git-para-usar-ssh-con-clave-específica)

<div style="page-break-after: always;"></div>

## **INTRODUCCIÓN**

VSCode es un editor de código fuente gratuito y extensible desarrollado por Microsoft. Estas instrucciones te ayudarán a aprovechar al máximo sus funcionalidades.

<!-- Aquí se agregarán las instrucciones específicas -->

## **HERRAMIENTAS CASE**

### **EXTENSIONES, CONFIGURACIÓN Y USO DEL DEBUGGER EN JAVA PARA VSCODE**

Para poder utilizar el debugger en VSCode con un proyecto Java, hay que asegurarse de tener instalada las extensiones:

- **Extension Pack for Java (Microsoft)**: Paquete completo para desarrollo en Java, incluyendo soporte para Maven, depuración y más.
- **Debugger for Java (Microsoft)**: Depuración de aplicaciones Java.

#### **CONFIGURACIÓN PARA DEBUGGEAR ARCHIVOS/PROGRAMAS EN JAVA:**

Para **debuggear archivos Java individuales (sin un proyecto completo con Maven o Gradle), configura VSCode de la siguiente manera**:

1. Abre el archivo Java que deseas debuggear.
2. Ve al menú **Run** > **Add Configuration...**.
3. Selecciona **"Java: Launch Current File"** para crear una configuración automática en `.vscode/launch.json`.
4. Esto permitirá debuggear el archivo actual directamente.

#### **CAMBIAR ATAJOS DE TECLADO PARA EL DEBUGGER:**

Para personalizar los atajos de teclado de las opciones del debugger:

1. Ve a **File** > **Preferences** > **Keyboard Shortcuts** (o presiona `Ctrl+K Ctrl+S`).
2. En la barra de búsqueda, escribe los comandos de debug:
   - `debug.continue` (Continuar - por defecto F5 o botón ▶️)
   - `debug.stepOver` (Step Over - por defecto F10 o botón ⏭️)
   - `debug.stepInto` (Step Into - por defecto F11 o botón ⬇️)
   - `debug.stepOut` (Step Out - por defecto Shift + F11 o botón ⬆️)
3. Haz clic derecho en el comando y selecciona **"Change Keybinding"** para asignar un nuevo atajo.
4. Presiona la combinación de teclas deseada y guarda.

**Nota:** Personaliza los atajos según tu comodidad para mejorar la eficiencia en el debug. Recuerda que los cambios se aplican globalmente en VSCode.

Una vez que tenemos las extensiones necesarias y el entorno configurado, podemos proceder a debugear nuestro código Java.

Primeramente, si quieres debugear el archivo, agrega breakpoints (puntos de ruptura), en las secciones de código deseadas.

A continuación, inicia el debug con una de las opciones detalladas a continuación y navega paso a paso:

1. **Inicia el debug**:
   - **Opción 1: Usando el botón de debug en el editor**: Haz clic en el botón de insecto (🐛) en la esquina superior derecha. Selecciona "Debug Java" o "Run and Debug". El programa se compilará y ejecutará en modo debug, deteniéndose en el primer breakpoint.
   - **Opción 2: Usando la barra de debug**: Ve a Run > Start Debugging (F5). Si es la primera vez, elige "Java" y configura "Debug (Launch)" para archivos individuales o proyectos Maven. Para tu archivo, configura el mainClass sin paquete.
2. **Navega paso a paso** con opciones como Continuar (F5), Step Over (F10), Step Into (F11), Step Out (Shift+F11).
3. **Inspecciona variables**: Pasa el mouse sobre ellas o usa el panel "Variables" para ver valores y expandir objetos complejos. **Ejemplo:** Para `int edad = 25`, verás "edad = 25". Para `Scanner scanner`, expande propiedades.
4. Toma notas sobre el comportamiento del programa.
5. Finaliza el debug.

#### **INICIAR EL DEBUG**

##### **OPCIÓN 1: USANDO EL BOTÓN DE DEBUG EN EL EDITOR**

- En la esquina superior derecha del editor (junto al botón de "Run"), haz clic en el botón de insecto (🐛) o "Debug".
- Selecciona "Debug Java" o "Run and Debug" si aparece un menú.
- El programa se compilará y comenzará a ejecutarse en modo debug. Se detendrá en el primer breakpoint.

##### **OPCIÓN 2: USANDO LA BARRA DE DEBUG**

- Ve a Run > Start Debugging (o presiona F5).
- Si es la primera vez, VS Code te pedirá configurar el debug. Elige "Java" y selecciona "Debug (Attach)" o "Debug (Launch)" para proyectos Maven.
- Para tu archivo, usa "Debug (Launch)" y configura el mainClass según corresponde y sin paquete (en caso de no tener paquete).
- La ejecución se detendrá en el primer breakpoint.

**Nota:** Si usas Maven, VS Code puede usar automáticamente mvnDebug o configuraciones integradas.

#### **CÓMO NAVEGAR EL DEBUG PASO A PASO**

Una vez pausado en un breakpoint, usa la barra de herramientas de debug en la parte superior (o el panel lateral "Run and Debug"):

- **Continuar (F5 o botón ▶️):** Reanuda la ejecución hasta el siguiente breakpoint.
- **Step Over (F10 o botón ⏭️):** Ejecuta la línea actual y pasa a la siguiente (sin entrar en métodos llamados).
- **Step Into (F11 o botón ⬇️):** Entra dentro de un método llamado en la línea actual (útil para inspeccionar funciones como `scanner.nextInt()`).
- **Step Out (Shift + F11 o botón ⬆️):** Sale del método actual y vuelve al llamador.
- **Restart (Ctrl + Shift + F5):** Reinicia el debug desde el principio.
- **Stop (Shift + F5):** Detiene el debug.

#### **BUENAS PRÁCTICAS DE DEBUGGING**

Para un debugging efectivo en Java con VSCode, sigue estos consejos clave:

1. **Familiarízate con el debugger**: Conoce los atajos de teclado como F5 (Continuar), F10 (Step Over) 🏃‍♂️, F11 (Step Into) ⬇️, y Shift+F11 (Step Out) ⬆️.
2. **No abuses de breakpoints**: Limita a 5-10 puntos de ruptura. Si son muchos, usa **Step Over** o **Step Into** para avanzar línea a línea, en lugar de **Continuar** directamente hasta el siguiente breakpoint.
3. **Usa watch expressions**: Agrega expresiones clave en "Watch" para ver cómo cambian las variables en tiempo real (e.g., contadores o condiciones).
4. **Pruebas con entradas variadas**: Ejecuta con entradas normales, límites y errores para cubrir todos los casos.
5. **Errores comunes**:
   - Si un if no entra, pausa en la condición y revísala.
   - Si un bucle no para, pausa dentro para verificar.
   - Si Scanner falla, pausa antes y después de lecturas.
   - Para código largo, divide en funciones y enfócate en bloques sospechosos.
6. **Documenta hallazgos**: Anota qué probaste y descubriste para futuras referencias.
7. **Desactiva breakpoints innecesarios**: Una vez verificado un bloque, desactívalos en la pestaña "Breakpoints" para evitar pausas extras.
8. **Revisa mensajes de error**: Presta atención a advertencias del IDE durante la ejecución.
9. **Evita debuggear en producción**: Usa entornos de desarrollo para pruebas seguras con datos sensibles. 🔒

##### **DÓNDE PONER BREAKPOINTS**

Para un debugging eficiente, coloca breakpoints en puntos estratégicos:

1. **Inicio del programa**: Primera línea del `main` para verificar estado inicial.
2. **Estructuras de control**: Antes y después de bucles (`while`, `for`), condicionales (`if`, `switch`) y casos (`case`).
3. **Lecturas/escrituras**: Antes y después de métodos como `Scanner.nextInt()` o `System.out.println()`.
4. **Asignaciones importantes**: Antes y después de cálculos o cambios de variables.
5. **Final del programa**: Antes de cerrar recursos como `scanner.close()`.

Para **INDICACIONES más detalladas sobre CÓMO NAVEGAR EL DEBUG y BUENAS PRÁCTICAS DE DEBUGGING EN JAVA y ejemplos con IMÁGENES, consultar el documento [BuenasPracticasDebuggingJAVA_JAAlejo.md](./BuenasPracticasDebuggingJAVA_JAAlejo.md).**

---

### **USO DEL PROFILER EN JAVA PARA VSCODE**

El profiler analiza rendimiento de aplicaciones Java, identificando cuellos de botella en CPU, memoria y tiempo. **VSCode** no tiene profiler nativo, pero usa extensiones o herramientas externas.

#### **REQUISITOS PREVIOS**

- **JDK con herramientas de profiling**: Asegúrate de tener JDK 21 o superior instalado, ya que incluye herramientas como `jvisualvm` o `jmc` (Java Mission Control).
- **Extensiones de VSCode**:
  - Instala la extensión "Extension Pack for Java (Microsoft)" (incluye soporte para profiling básico).
  - Opcionalmente, instala "Codewind Java Profiler (IBM)" si está disponible en el marketplace.

#### **INICIAR EL PROFILING**

##### **OPCIÓN 1: USANDO JAVA MISSION CONTROL (JMC)**

1. **Ejecuta tu aplicación en modo profiling**:
   - Abre el terminal integrado en VSCode (Ctrl + `).
   - Navega al directorio de tu proyecto (ej. `cd "PROGRAMACION/Unidad2_ProgramarenJava"`).
   - Ejecuta el comando para compilar y ejecutar con profiling:

     ```bash
     mvn compile exec:java -Dexec.mainClass="tu.ClasePrincipal" -Djava.awt.headless=true
     ```

     O usa `java -jar target/tu-app.jar` si tienes un JAR.

2. **Conecta JMC**:
   - Abre Java Mission Control desde el JDK (busca `jmc` en el menú de inicio de Windows).
   - Crea una nueva conexión JMX: Archivo > Conectar > Crear nueva conexión.
   - Especifica `localhost:1099` (puerto por defecto para JMX).
   - Inicia el profiling y analiza métricas como CPU, memoria y hilos.

##### **OPCIÓN 2: USANDO VISUALVM**

1. **Instala VisualVM** (si no viene con JDK):
   - Descarga de [https://visualvm.github.io/](https://visualvm.github.io/) o usa el incluido en JDK.

2. **Ejecuta tu aplicación**:

   - En el terminal de VSCode, ejecuta:

     ```bash
     java -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -cp target/classes tu.ClasePrincipal
     ```

3. **Conecta VisualVM**:
   - Abre VisualVM.
   - Agrega una nueva conexión JMX a `localhost:1099`.
   - Monitorea el uso de CPU, memoria heap, hilos y realiza profiling de CPU o memoria.

#### **ANALIZAR RESULTADOS**

- **CPU Profiling**: Identifica métodos que consumen más tiempo. Busca hotspots (métodos lentos).
- **Memory Profiling**: Detecta fugas de memoria o uso excesivo. Usa "Heap Dump" para analizar objetos en memoria.
- **Hilos**: Revisa deadlocks o hilos bloqueados.

#### **CONSEJOS PARA PROFILING EFECTIVO**

- **Ejecuta en entorno representativo**: Usa datos reales para obtener resultados precisos.
- **Limita el alcance**: Profilea secciones específicas de código, no toda la aplicación.
- **Compara ejecuciones**: Antes y después de optimizaciones.
- **Evita profiling en producción**: Usa desarrollo o staging.

**Nota:** Para profiling avanzado, considera herramientas como YourKit (YourKit LLC) o JProfiler (ej-technologies GmbH), que se integran con VSCode vía extensiones.

---

## Creación de Enlaces Simbólicos en VSCode

### Windows

Sigue estos pasos para crear enlaces simbólicos en Windows usando PowerShell en **VSCode**:

1. **Abre el Terminal Integrado en VS Code** (presiona `Ctrl + ``) o abre PowerShell directamente.
2. **Ejecuta como administrador**: Haz clic derecho en el terminal y selecciona "Ejecutar como administrador" para evitar errores de permisos.
3. **Navega al directorio deseado**:

   ```powershell
   cd "C:\ruta\a\tu\directorio"
   ```

4. **Crea el enlace simbólico** usando el cmdlet `New-Item`:

   - Para un archivo:

   ```powershell
   New-Item -ItemType SymbolicLink -Path <nombre_del_enlace> -Target "<ruta_completa_al_archivo_original>"
   ```

   Ejemplo:

   ```powershell
   New-Item -ItemType SymbolicLink -Path Teoria_U1.pdf -Target "ENTORNOS DE DESARROLLO\Unidad1_ReconocimientoElementosDesarrolloSoftware\ApuntesU1md\Teoria_U1_ReconocimientoElementosDesarrolloSoftware.pdf"
   ```

   - Para un directorio:

   ```powershell
   New-Item -ItemType SymbolicLink -Path <nombre_del_enlace> -Target "<ruta_completa_al_directorio_original>"
   ```

   Ejemplo:

   ```powershell
   New-Item -ItemType SymbolicLink -Path MisNotas -Target "ENTORNOS DE DESARROLLO"
   ```

5. Presiona Enter. No verás un mensaje de confirmación, pero el enlace se creará si no hay errores.

#### Consejos adicionales para Windows

- **Rutas**: Usa rutas absolutas (completas) para evitar problemas. Si usas rutas relativas, asegúrate de estar en el directorio correcto.
- **Permisos**: Si obtienes un error como "Acceso denegado", confirma que estás ejecutando como administrador.
- **Verificación**: Después de crearlo, puedes verificar con `dir` en cmd o `Get-ChildItem` en PowerShell. El enlace aparecerá con una flecha (→) indicando el objetivo.
- **Eliminar un enlace**: Usa `del <nombre_del_enlace>` (para archivos) o `rmdir <nombre_del_enlace>` (para directorios). No afecta el archivo original.

### Arch Linux / Debian

En Linux, los enlaces simbólicos son mucho más simples. No requieren permisos especiales:

1. **Abre el Terminal Integrado en VS Code** (presiona `Ctrl + ``) o usa una terminal normal.
2. **Navega al directorio deseado**:

   ```bash
   cd ~/ruta/a/tu/directorio
   ```

3. **Crea el enlace simbólico** usando `ln -s`:

   - Para un archivo o directorio:

   ```bash
   ln -s <ruta_original> <nombre_del_enlace>
   ```

   Ejemplo:

   ```bash
   ln -s "ENTORNOS DE DESARROLLO/Unidad1_ReconocimientoElementosDesarrolloSoftware/ApuntesU1md/Teoria_U1.pdf" Teoria_U1.pdf
   ln -s "ENTORNOS DE DESARROLLO" MisNotas
   ```

   - Con rutas relativas (mejor para repositorios):

   ```bash
   ln -sr <ruta_original> <nombre_del_enlace>
   ```

4. Presiona Enter. Verás un mensaje de confirmación si el enlace se crea correctamente.

#### Consejos adicionales para Linux

- **Rutas**: Usa `~` para referirte al directorio home. Puedes usar rutas relativas sin problemas.
- **Permisos**: No necesitas permisos especiales en Linux (a diferencia de Windows).
- **Verificación**: Usa `ls -l` para ver los enlaces. Aparecerán con una flecha (→). Usa `readlink <nombre>` para ver hacia dónde apuntan.
- **Eliminar un enlace**: Usa `rm <nombre_del_enlace>`. No afecta el archivo original.

---

#### Verificar la Creación del Enlace Simbólico

**Windows (PowerShell)**:

```powershell
Get-ChildItem -Force
Get-Item MiEnlace | Select-Object -ExpandProperty Target
```

**Linux (Bash)**:

```bash
ls -l
readlink nombre_del_enlace
```

**Nota:** Si el enlace no aparece o no funciona, revisa permisos (ejecuta como administrador), rutas (usa absolutas) y asegúrate de que el archivo objetivo exista. Si hay errores, elimina el enlace con `Remove-Item <nombre_del_enlace>` y vuelve a crearlo.

---

#### Verificar la correcta interpretación del enlace simbólico por Git

Una vez comprobado que nuestro enlace simbólico funciona correctamente, debemos asegurarnos de que nuestro repositorio de Git podrá manejar e interpretar correctamente los symlinks. <br>
Por defecto, Git en Windows no maneja symlinks correctamente. Configura esto una vez por repositorio:

```bash
git config core.symlinks true  # Habilita el manejo de symlinks en este repositorio
```

---

## **RESOLUCIÓN DE PROBLEMAS CON SSH EN EXTENSIONES DE GIT**

### **Problema: Extensiones como Git Graph no pueden hacer fetch con SSH**

A veces, extensiones de VS Code como Git Graph o GitLens fallan al intentar operaciones remotas con SSH, mostrando errores como "Permission denied (publickey)", incluso si el comando `git fetch` funciona perfectamente en la terminal integrada de VS Code.

**Causa probable:** Las extensiones ejecutan Git en un contexto diferente al de la terminal, donde el agente SSH o la configuración no están disponibles.

### **Solución: Configurar Git para usar SSH con clave específica**

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

     Esta configuración solo se aplica al repositorio actual. Es útil si diferentes repositorios requieren claves SSH distintas o si prefieres no modificar la configuración global. Repite este comando en cada repositorio que necesite esta configuración.

     **Nota:** No es posible configurar Git específicamente por extensión de VS Code (por ejemplo, solo para Git Graph). La configuración afecta a todas las extensiones que interactúan con Git en ese repositorio. Si el problema es solo con ciertas extensiones, considera usar la configuración por repositorio en los proyectos afectados.

**¿Por qué configurar globalmente resuelve problemas en extensiones?**

Las extensiones de VS Code (como Git Graph o GitLens) ejecutan comandos de Git en un proceso separado del terminal integrado. Este proceso puede no heredar el mismo entorno (por ejemplo, variables de entorno como `SSH_AGENT_PID` o el agente SSH corriendo). Al configurar `core.sshCommand` globalmente, se asegura de que Git use siempre el ejecutable SSH correcto con tu clave privada, independientemente del contexto de ejecución. Esto resuelve inconsistencias donde la terminal funciona (porque hereda tu entorno), pero las extensiones fallan debido a un contexto limitado.

Si prefieres no usar configuración global, la opción por repositorio también funciona, ya que las extensiones respetan la configuración local del repo.

**Verificación:**

- Prueba `git fetch` en la terminal: Debería funcionar.
- Abre Git Graph y prueba fetch: Ahora debería funcionar sin errores de "Permission denied".

**Nota:** Si aún falla, cambia temporalmente el remoto a HTTPS para la extensión: `git remote set-url origin https://github.com/usuario/repo.git`. Para repos privados, usa un Personal Access Token como contraseña. Este cambio afecta solo a la configuración local del repositorio y no modifica otros dispositivos o clones que puedan estar usando SSH. Es reversible: ejecuta `git remote set-url origin git@github.com:usuario/repo.git` para volver a SSH. Si el problema persiste, revisa los permisos de archivos y asegúrate de que el agente SSH esté corriendo globalmente.
