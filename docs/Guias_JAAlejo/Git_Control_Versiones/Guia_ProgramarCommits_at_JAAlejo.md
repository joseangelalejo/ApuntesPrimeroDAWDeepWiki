# **Guía: Programar Commits en Arch Linux usando `at`**

- **Autor**: José Ángel Alejo Sillero
- **Centro**: Instituto Tecnológico Pablo de la Torre
- **Fecha**: 18 de enero de 2026
- **Sistema Operativo**: Arch Linux
- **Herramienta**: `at` (Demonio de planificación de tareas)

---

> **Tabla de contenidos**

- [**Guía: Programar Commits en Arch Linux usando `at`**](#guía-programar-commits-en-arch-linux-usando-at)
  - [**1. INTRODUCCIÓN**](#1-introducción)
  - [**2. QUÉ ES `at`**](#2-qué-es-at)
    - [**2.1 Conceptos Básicos**](#21-conceptos-básicos)
    - [**2.2 `at` vs `cron`**](#22-at-vs-cron)
  - [**3. INSTALACIÓN Y CONFIGURACIÓN**](#3-instalación-y-configuración)
    - [**3.1 Instalación en Arch Linux**](#31-instalación-en-arch-linux)
    - [**3.2 Iniciar el Servicio**](#32-iniciar-el-servicio)
    - [**3.3 Habilitar Inicio Automático**](#33-habilitar-inicio-automático)
  - [**4. SINTAXIS BÁSICA DE `at`**](#4-sintaxis-básica-de-at)
    - [**4.1 Formato de Tiempo**](#41-formato-de-tiempo)
    - [**4.2 Ejemplos de Formatos Válidos**](#42-ejemplos-de-formatos-válidos)
  - [**5. MÉTODO 1: PROGRAMAR COMMITS DE FORMA INTERACTIVA**](#5-método-1-programar-commits-de-forma-interactiva)
    - [**5.1 Pasos Básicos**](#51-pasos-básicos)
    - [**5.2 Ejemplo Práctico**](#52-ejemplo-práctico)
  - [**6. MÉTODO 2: PROGRAMAR COMMITS CON PIPE (RECOMENDADO)**](#6-método-2-programar-commits-con-pipe-recomendado)
    - [**6.1 Estructura General**](#61-estructura-general)
    - [**6.2 Ejemplo Completo**](#62-ejemplo-completo)
    - [**6.3 Desglose del Comando**](#63-desglose-del-comando)
  - [**7. MÉTODO 3: USAR UN SCRIPT EXTERNO**](#7-método-3-usar-un-script-externo)
    - [**7.1 Crear el Script**](#71-crear-el-script)
    - [**7.2 Programar el Script**](#72-programar-el-script)
    - [**7.3 Verificación**](#73-verificación)
  - [**8. VERIFICAR Y GESTIONAR TAREAS PROGRAMADAS**](#8-verificar-y-gestionar-tareas-programadas)
    - [**8.1 Ver Tareas Programadas**](#81-ver-tareas-programadas)
    - [**8.2 Ver Detalles de una Tarea**](#82-ver-detalles-de-una-tarea)
    - [**8.3 Eliminar una Tarea Programada**](#83-eliminar-una-tarea-programada)
    - [**8.4 Ver Historial de Ejecución**](#84-ver-historial-de-ejecución)
  - [**9. CASOS DE USO PRÁCTICOS**](#9-casos-de-uso-prácticos)
    - [**9.1 Commit Programado Hoy a las 20\_00**](#91-commit-programado-hoy-a-las-20_00)
    - [**9.2 Commit Programado para Mañana**](#92-commit-programado-para-mañana)
    - [**9.3 Commit con Mensaje Multilinea**](#93-commit-con-mensaje-multilinea)
    - [**9.4 Commit con Archivo de Premisa**](#94-commit-con-archivo-de-premisa)
  - [**10. TROUBLESHOOTING**](#10-troubleshooting)
    - [**10.1 Error: "Can't open /run/atd.pid to signal atd"**](#101-error-cant-open-runatdpid-to-signal-atd)
    - [**10.2 La Tarea No Se Ejecuta a la Hora Programada**](#102-la-tarea-no-se-ejecuta-a-la-hora-programada)
    - [**10.3 Problemas con Caracteres Especiales**](#103-problemas-con-caracteres-especiales)
    - [**10.4 Verificar Permisos de Usuario**](#104-verificar-permisos-de-usuario)
  - [**11. BUENAS PRÁCTICAS**](#11-buenas-prácticas)
  - [**12. COMPARACIÓN: MÉTODOS DE PROGRAMACIÓN**](#12-comparación-métodos-de-programación)
  - [**REFERENCIAS**](#referencias)

---

<div style="page-break-after: always;"></div>

## **1. INTRODUCCIÓN**

En ocasiones, necesitamos **programar un commit de Git para ejecutarse en un momento específico**, sin necesidad de estar frente a la computadora. Arch Linux proporciona `at`, una herramienta poderosa y sencilla para programar tareas puntuales.

Esta guía te enseñará cómo **programar commits de forma segura y confiable** usando `at`, desde lo básico hasta casos de uso avanzados.

**Requisitos previos:**

- Arch Linux instalado
- Acceso a terminal
- Git configurado y repositorio local
- Cambios en el area de staging (staged)

---

## **2. QUÉ ES `at`**

### **2.1 Conceptos Básicos**

`at` es un **demonio de planificación de tareas** que permite ejecutar comandos en un momento específico del futuro, una sola vez.

**Características principales:**

- Ejecuta comandos **exactamente una vez** a la hora programada
- No requiere configuración compleja
- Funciona en segundo plano
- Ideal para tareas puntuales y únicas
- Compatible con cualquier comando de shell

### **2.2 `at` vs `cron`**

| **Aspecto**       | **`at`**                       | **`cron`**                             |
|-------------------|--------------------------------|----------------------------------------|
| **Frecuencia**    | Una sola vez                   | Repetidamente (diario, semanal, etc)   |
| **Caso de uso**   | Tareas puntuales               | Tareas periódicas                      |
| **Configuración** | Simple                         | Más compleja                           |
| **Ejemplo**       | "Ejecuta esto hoy a las 20:00" | "Ejecuta esto cada domingo a las 3 AM" |

---

## **3. INSTALACIÓN Y CONFIGURACIÓN**

### **3.1 Instalación en Arch Linux**

```bash
# Instalar at
sudo pacman -S at

# Verificar instalación
which at
at --version
```

### **3.2 Iniciar el Servicio**

```bash
# Iniciar el servicio atd (demonio de at)
sudo systemctl start atd

# Verificar que está corriendo
sudo systemctl status atd
```

### **3.3 Habilitar Inicio Automático**

Para que `atd` se inicie automáticamente al encender la máquina:

```bash
sudo systemctl enable atd
```

Verificar que está habilitado:

```bash
sudo systemctl is-enabled atd
```

---

## **4. SINTAXIS BÁSICA DE `at`**

### **4.1 Formato de Tiempo**

`at` soporta múltiples formatos de tiempo:

| **Formato**               | **Descripción**                | **Ejemplo**                              |
|---------------------------|--------------------------------|------------------------------------------|
| **HH:MM**                 | Hora en formato 24 horas (hoy) | `20:00`, `15:30`                         |
| **midnight**              | Medianoche (00:00)             | `at midnight`                            |
| **noon**                  | Mediodía (12:00)               | `at noon`                                |
| **teatime**               | Las 4 PM (16:00)               | `at teatime`                             |
| **tomorrow**              | Mañana a la misma hora         | `at 20:00 tomorrow`                      |
| **+N minutes/hours/days** | Relativo al presente           | `at now + 1 hour`, `at now + 30 minutes` |
| **Fecha completa**        | DD.MM.YYYY HH:MM               | `at 18.01.2026 20:00`                    |

### **4.2 Ejemplos de Formatos Válidos**

```bash
# Hoy a las 20:00
at 20:00

# Mañana a las 15:00
at 15:00 tomorrow

# En 2 horas desde ahora
at now + 2 hours

# En 30 minutos
at now + 30 minutes

# A medianoche
at midnight

# Fecha específica
at 19.01.2026 20:00

# Formato 12 horas (PM/AM)
at 8:00 PM
at 3:30 PM tomorrow
```

---

## **5. MÉTODO 1: PROGRAMAR COMMITS DE FORMA INTERACTIVA**

El método interactivo es simple pero menos flexible para commits con mensajes largos.

### **5.1 Pasos Básicos**

```bash
# 1. Abrir at interactivamente
at 20:00

# 2. El sistema te pedirá que ingreses comandos (se verá "at>" o "heredoc>")
# 3. Escribe tu comando de git
cd /ruta/a/tu/repositorio && git commit -m "Tu mensaje aquí"

# 4. Presiona Ctrl+D para guardar y salir
# 5. at confirmará la tarea programada
```

### **5.2 Ejemplo Práctico**

```bash
$ at 20:00
warning: commands will be executed using /bin/sh
at> cd /home/miniature/gitrepositories/MisApuntesITPDAW
at> git commit -m "feat(base de datos): crear apuntes U3"
at> <Ctrl+D>
job 1 at Sun Jan 18 20:00:00 2026
```

**Ventajas:**

- Simple y directo
- No requiere scripts

**Desventajas:**

- Difícil para mensajes multilinea
- Requiere interacción manual
- Propenso a errores de tipeo

---

<div style="page-break-after: always;"></div>

## **6. MÉTODO 2: PROGRAMAR COMMITS CON PIPE (RECOMENDADO)**

Este es el método más práctico y recomendado para programar commits con mensajes complejos.

### **6.1 Estructura General**

```bash
echo "comando_a_ejecutar" | at hora

# Para múltiples comandos:
echo -e "comando1\ncomando2\ncomando3" | at hora
```

### **6.2 Ejemplo Completo**

```bash
echo "cd /home/miniature/gitrepositories/MisApuntesITPDAW && git commit -m 'feat(base de datos): crear apuntes completos de U3'" | at 20:00
```

**Para mensajes multilinea:**

```bash
echo "cd /home/miniature/gitrepositories/MisApuntesITPDAW && git commit -m 'feat(base de datos): crear apuntes completos de U3

* Crear archivo U3 con documentación
* Documentar SQL, DDL, DML, DCL
* Incluir tipos de datos MySQL
* Detallar restricciones de columna'" | at 20:00
```

### **6.3 Desglose del Comando**

```bash
echo "..."                 # Envía el comando
| at 20:00               # A través del pipe a at, para la hora 20:00

# Dentro del comando:
cd /ruta/repo             # Navega al repositorio
&&                         # Solo continúa si el cd fue exitoso
git commit -m '...'       # Ejecuta el commit
```

---

## **7. MÉTODO 3: USAR UN SCRIPT EXTERNO**

Para commits muy complejos, es mejor crear un script bash reutilizable.

### **7.1 Crear el Script**

Crear el archivo `commit_script.sh`:

```bash
cat > /tmp/git_commit.sh << 'EOF'
#!/bin/bash
cd /home/miniature/gitrepositories/MisApuntesITPDAW
git commit -m "feat(base de datos): crear apuntes completos de U3

* Crear archivo U3_CreaciondeBBDDRelacionales_JAAlejo.md con documentación completa
* Documentar SQL, DDL, DML, DCL con historia, estandarización y clasificación
* Incluir tipos de datos MySQL: numéricos, texto, fecha/hora, lógicos, binarios, JSON, espaciales
* Detallar restricciones de columna: PRIMARY KEY, NOT NULL, UNIQUE, FOREIGN KEY, CHECK
* Documentar sentencias ALTER (ADD, DROP, MODIFY, CHANGE) y DROP
* Incluir secciones sobre índices: tipos, creación, eliminación y ejemplos prácticos
* Documentar vistas: definición, características, ventajas, creación y diferencias con índices
* Detallar DCL: gestión de usuarios, roles, privilegios en MySQL con ejemplos
* Agregar tabla de contenidos completa con enlaces internos navegables
* Mantener consistencia con formato y estilo de apuntes U1 y U2"
EOF
chmod +x /tmp/git_commit.sh
```

### **7.2 Programar el Script**

```bash
# Programar la ejecución del script
echo "/tmp/git_commit.sh" | at 20:00

# Verificar que se programó
atq
```

### **7.3 Verificación**

```bash
# Ver detalles de la tarea
at -c 1

# Ver el contenido del script
cat /tmp/git_commit.sh
```

**Ventajas:**

- Ideal para comandos muy largos
- Reutilizable
- Fácil de mantener y editar
- Permite agregar más lógica si es necesario

---

## **8. VERIFICAR Y GESTIONAR TAREAS PROGRAMADAS**

### **8.1 Ver Tareas Programadas**

```bash
# Listar todas las tareas
atq

# Salida típica:
# 1 Sun Jan 18 20:00:00 2026 a miniature
# 2 Mon Jan 19 15:00:00 2026 a miniature
```

### **8.2 Ver Detalles de una Tarea**

```bash
# Ver contenido completo de la tarea número 1
at -c 1

# Verás el comando que se ejecutará
```

### **8.3 Eliminar una Tarea Programada**

```bash
# Eliminar la tarea número 1
atrm 1

# O más explícitamente
at -r 1

# Verificar que se eliminó
atq
```

### **8.4 Ver Historial de Ejecución**

```bash
# Ver log de atd (si está disponible)
sudo journalctl -u atd -n 20

# O en el archivo de log del sistema
sudo tail -f /var/log/atd
```

---

<div style="page-break-after: always;"></div>

## **9. CASOS DE USO PRÁCTICOS**

### **9.1 Commit Programado Hoy a las 20_00**

```bash
# Simple
echo "cd ~/gitrepositories/MisApuntesITPDAW && git commit -m 'feat: actualizar apuntes'" | at 20:00

# Con ruta absoluta
echo "cd /home/miniature/gitrepositories/MisApuntesITPDAW && git commit -m 'feat(base de datos): crear apuntes U3'" | at 20:00
```

### **9.2 Commit Programado para Mañana**

```bash
# Mañana a las 10:00 AM
echo "cd /home/miniature/gitrepositories/MisApuntesITPDAW && git commit -m 'feat: cambios de mañana'" | at 10:00 tomorrow
```

### **9.3 Commit con Mensaje Multilinea**

```bash
# Usar printf para mejor control de nuevas líneas
printf "cd /home/miniature/gitrepositories/MisApuntesITPDAW\ngit commit -m 'feat(base de datos): U3 apuntes\n\n* Punto 1\n* Punto 2\n* Punto 3'" | at 20:00
```

### **9.4 Commit con Archivo de Premisa**

Si tienes un archivo con el mensaje de commit:

```bash
# Crear archivo con el mensaje
cat > /tmp/commit_msg.txt << 'EOF'
feat(base de datos): crear apuntes completos de U3

* Crear archivo U3_CreaciondeBBDDRelacionales_JAAlejo.md
* Documentar SQL, DDL, DML, DCL
* Incluir tipos de datos MySQL
EOF

# Programar commit leyendo el archivo
echo "cd /home/miniature/gitrepositories/MisApuntesITPDAW && git commit -F /tmp/commit_msg.txt" | at 20:00
```

---

## **10. TROUBLESHOOTING**

### **10.1 Error: "Can't open /run/atd.pid to signal atd"**

**Causa:** El servicio `atd` no está corriendo.

**Solución:**

```bash
# Iniciar el servicio
sudo systemctl start atd

# Habilitar para inicio automático
sudo systemctl enable atd

# Verificar estado
sudo systemctl status atd
```

### **10.2 La Tarea No Se Ejecuta a la Hora Programada**

**Posibles causas:**

1. **`atd` no está corriendo:**

   ```bash
   sudo systemctl status atd
   sudo systemctl start atd
   ```

2. **Hora incorrecta del sistema:**

   ```bash
   # Verificar hora actual
   date
   
   # Si es incorrecta, ajustar (ej. con timedatectl)
   timedatectl
   ```

3. **Usuario sin permisos en `/etc/at.allow`:**

   ```bash
   # Verificar si /etc/at.allow existe
   cat /etc/at.allow 2>/dev/null || echo "No existe"
   
   # Si existe, tu usuario debe estar listado
   sudo cat /etc/at.allow
   ```

### **10.3 Problemas con Caracteres Especiales**

**Problema:** Caracteres especiales (acentos, comillas) pueden causar errores.

**Solución:** Usar comillas simples para proteger el contenido:

```bash
# ✓ Correcto
echo 'cd /repo && git commit -m "feat: esto es más fácil"' | at 20:00

# ✗ Evitar
echo "cd /repo && git commit -m "feat: esto falla"" | at 20:00
```

### **10.4 Verificar Permisos de Usuario**

```bash
# Ver si existe /etc/at.deny
cat /etc/at.deny 2>/dev/null || echo "No existe"

# Ver si tu usuario está en /etc/at.allow
sudo grep $(whoami) /etc/at.allow

# Si no está, necesitas agregarlo
sudo sh -c "echo $(whoami) >> /etc/at.allow"
```

---

## **11. BUENAS PRÁCTICAS**

✅ **HACER:**

- **Usar rutas absolutas** para el directorio del repositorio
- **Probar el comando manualmente** antes de programarlo
- **Verificar con `atq`** que la tarea se programó correctamente
- **Usar `at -c ID`** para verificar el comando exacto que se ejecutará
- **Guardar scripts importantes** en ubicaciones permanentes (no `/tmp`)
- **Usar comillas simples** para proteger caracteres especiales
- **Agregar logs** si trabajas con scripts complejos

❌ **NO HACER:**

- **Programar commits críticos** para horas donde no puedas monitorear
- **Usar rutas relativas** (usa rutas absolutas siempre)
- **Confiar solo en memoria** - verifica con `atq` que se programó
- **Olvidar iniciar `atd`** - es fácil olvidarlo
- **Usar `at` para tareas repetitivas** - usa `cron` en su lugar
- **Programar múltiples commits** sin verificar que el repositorio esté en buen estado

---

## **12. COMPARACIÓN: MÉTODOS DE PROGRAMACIÓN**

| **Método**         | **Complejidad** | **Mensajes Largos** | **Reutilizable** | **Recomendado para**             |
|--------------------|-----------------|---------------------|------------------|----------------------------------|
| **Interactivo**    | Muy baja        | No                  | No               | Commits simples                  |
| **Pipe**           | Baja            | Sí*                 | Parcial          | Commits medianos                 |
| **Script externo** | Media           | Sí                  | Sí               | Commits complejos, reutilización |

*Con pipe, es algo tedioso pero posible con escapes correctos.

---

## **REFERENCIAS**

- **Documentación oficial de `at`:** `man at`
- **Comando de ayuda:** `at --help`
- **Arch Wiki:** [archlinux.org](https://wiki.archlinux.org/)
- **Manual de systemctl:** `man systemctl`
- **Premisa de commits del autor:** [Premisa_MensajesCommit_JAAlejo.md](./Premisa_MensajesCommit_JAAlejo.md)

---

**Última actualización:** 18 de enero de 2026  
**Autor:** José Ángel Alejo Sillero  
**Versión:** 1.0
