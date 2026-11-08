# **Guía Completa: MediCat + Ventoy en Linux** - José Ángel Alejo Sillero

Una guía práctica y paso a paso para instalar y configurar **MediCat** (suite de herramientas de diagnóstico) con **Ventoy** (multiboot USB) en **Arch Linux**.

---

## Tabla de Contenidos

- [**Guía Completa: MediCat + Ventoy en Linux** - José Ángel Alejo Sillero](#guía-completa-medicat--ventoy-en-linux---josé-ángel-alejo-sillero)
  - [Tabla de Contenidos](#tabla-de-contenidos)
  - [Conceptos Previos](#conceptos-previos)
    - [¿Qué es MediCat?](#qué-es-medicat)
    - [¿Qué es Ventoy?](#qué-es-ventoy)
  - [Requisitos](#requisitos)
    - [Hardware](#hardware)
    - [Software](#software)
    - [Conexión](#conexión)
  - [Parte 1: Instalar Ventoy](#parte-1-instalar-ventoy)
    - [Paso 1.1: Instalación desde AUR](#paso-11-instalación-desde-aur)
    - [Paso 1.2: Verificar la instalación](#paso-12-verificar-la-instalación)
  - [Parte 2: Preparar MediCat](#parte-2-preparar-medicat)
    - [Opción A: Descargar MediCat Completo (Recomendado)](#opción-a-descargar-medicat-completo-recomendado)
    - [Opción B: Descargar ISOs Individuales](#opción-b-descargar-isos-individuales)
  - [Parte 3: Transferir a USB](#parte-3-transferir-a-usb)
    - [Paso 3.1: Identificar la unidad USB](#paso-31-identificar-la-unidad-usb)
    - [Paso 3.2: Instalar Ventoy en el USB](#paso-32-instalar-ventoy-en-el-usb)
    - [Paso 3.3: Montar el USB](#paso-33-montar-el-usb)
    - [Paso 3.4: Copiar MediCat](#paso-34-copiar-medicat)
    - [Paso 3.5: Desmontar el USB](#paso-35-desmontar-el-usb)
  - [Uso y Arranque](#uso-y-arranque)
    - [Paso 4.1: Configurar BIOS/UEFI](#paso-41-configurar-biosuefi)
    - [Paso 4.2: Arrancar desde el USB](#paso-42-arrancar-desde-el-usb)
  - [Herramientas Incluidas](#herramientas-incluidas)
    - [🔍 Diagnóstico](#-diagnóstico)
    - [💾 Recuperación](#-recuperación)
    - [🔧 Reparación](#-reparación)
    - [🧹 Limpieza](#-limpieza)
  - [Troubleshooting](#troubleshooting)
    - [Problema: El USB no arranca](#problema-el-usb-no-arranca)
    - [Problema: USB montado pero no aparecen archivos](#problema-usb-montado-pero-no-aparecen-archivos)
    - [Problema: No hay espacio suficiente](#problema-no-hay-espacio-suficiente)
    - [Problema: Ventoy no se instala](#problema-ventoy-no-se-instala)
    - [Problema: El USB se desconecta durante la copia](#problema-el-usb-se-desconecta-durante-la-copia)
  - [📋 Resumen del Proceso Completo](#-resumen-del-proceso-completo)
  - [🎯 Casos de Uso Comunes](#-casos-de-uso-comunes)
    - [Diagnóstico de RAM defectuosa](#diagnóstico-de-ram-defectuosa)
    - [Recuperar datos de un disco corrupto](#recuperar-datos-de-un-disco-corrupto)
    - [Reparar arranque de Windows](#reparar-arranque-de-windows)
    - [Borrado seguro antes de vender PC](#borrado-seguro-antes-de-vender-pc)
  - [🔗 Enlaces Útiles](#-enlaces-útiles)

---

## Conceptos Previos

### ¿Qué es MediCat?

**MediCat** es una distribución live basada en Linux que incluye una colección exhaustiva de herramientas para:

- 🔍 **Diagnóstico de hardware**: Pruebas de RAM, disco duro, CPU
- 💾 **Recuperación de datos**: Restauración de archivos eliminados
- 🔧 **Reparación del sistema**: Boot repair, recuperación de contraseñas
- 🧹 **Limpieza y optimización**: Malware removal, limpieza de registros
- 📦 **Backup y clonación**: Copias de seguridad, clonación de discos

### ¿Qué es Ventoy?

**Ventoy** es una herramienta que convierte una unidad USB en un **multiboot** dinámico:

- Permite múltiples ISOs en un mismo USB
- Solo copias archivos, sin reescribir la unidad cada vez
- Genera un menú de arranque automático
- Compatible con casi todas las ISOs

---

## Requisitos

### Hardware

- 💿 **MicroSD de 32GB o más** (o USB de igual capacidad)
- 🖥️ **Lector de tarjetas SD/USB**
- 📱 **PC con Arch Linux** (o compatible)

### Software

- `ventoy-bin` (desde AUR)
- `wget` o `curl` (para descargar)
- `sudo` (privilegios de administrador)

### Conexión

- 🌐 Acceso a internet

---

## Parte 1: Instalar Ventoy

### Paso 1.1: Instalación desde AUR

```bash
# Con yay
yay -S ventoy-bin

# O con paru
paru -S ventoy-bin
```

Ventoy se instala en `/usr/bin/ventoy-bin`.

### Paso 1.2: Verificar la instalación

```bash
ventoy-bin --version
```

Deberías ver algo como: `Ventoy version 1.0.X`

---

## Parte 2: Preparar MediCat

### Opción A: Descargar MediCat Completo (Recomendado)

Si ya descargaste MediCat completo, está listo. Si no:

```bash
# Descarga (esto puede tardar, son varios GB)
cd ~/Descargas
wget https://descargar-medicat-aqui.com/medicat.7z

# Descomprimir (requiere 7zip)
sudo pacman -S p7zip
7z x medicat.7z -o ~/medicat_descargado
```

### Opción B: Descargar ISOs Individuales

```bash
cd ~/Descargas

# Hiren's Boot CD
wget https://www.hirensbootcd.org/files/Hiren\'s%20Boot%20CD%2015.3.iso

# SystemRescue
wget https://github.com/SystemRescue/SystemRescue/releases/download/10.01/systemrescue-10.01-amd64.iso

# Clonezilla
wget https://clonezilla.org/downloads/download.php?branch=stable
```

---

## Parte 3: Transferir a USB

### Paso 3.1: Identificar la unidad USB

```bash
# Conecta el USB/MicroSD
lsblk

# Busca tu dispositivo (ej: sdb, sdc)
# Ten cuidado: elige la capacidad correcta
```

**⚠️ ADVERTENCIA**: Reemplaza `sdX` con el dispositivo correcto en los siguientes pasos.

### Paso 3.2: Instalar Ventoy en el USB

```bash
# Esto FORMATEARÁ la unidad
sudo ventoy-bin -i /dev/sdX

# Verás una advertencia. Escribe 'y' y presiona Enter
# Espera a que termine (puede tardar minutos)
```

### Paso 3.3: Montar el USB

```bash
# Tras instalar Ventoy, el USB se monta automáticamente en:
# /run/media/usuario/Ventoy

# Si no se monta, hazlo manualmente:
sudo mkdir -p /mnt/ventoy
sudo mount /dev/sdX1 /mnt/ventoy
```

### Paso 3.4: Copiar MediCat

**Si tienes MediCat desempaquetado:**

```bash
# Copia TODO el contenido
sudo cp -r ~/medicat_descargado/* /run/media/usuario/Ventoy/

# Sincroniza para asegurar
sudo sync
```

**Si tienes ISOs individuales:**

```bash
# Copia directamente a la raíz
sudo cp ~/Descargas/*.iso /run/media/usuario/Ventoy/

sudo sync
```

### Paso 3.5: Desmontar el USB

```bash
# Importante: desmonta DESPUÉS de copiar
sudo umount /run/media/usuario/Ventoy

# O si lo montaste manualmente:
sudo umount /mnt/ventoy
```

---

## Uso y Arranque

### Paso 4.1: Configurar BIOS/UEFI

1. **Reinicia el PC**
2. **Accede a BIOS/UEFI**: Presiona (normalmente):
   - `Del` o `F2` (Intel)
   - `F2` o `F12` (AMD)
   - `F10` (HP)
   - Varía según fabricante

3. **Cambia el orden de arranque**: USB primero
4. **Guarda y sal** (F10 o según indicaciones)

### Paso 4.2: Arrancar desde el USB

1. **Conecta el USB**
2. **Reinicia la PC**
3. **Verás el menú de Ventoy** con todas las ISOs disponibles
4. **Selecciona MediCat** o la herramienta que necesites
5. **Presiona Enter** y espera a que cargue

---

## Herramientas Incluidas

### 🔍 Diagnóstico

| Herramienta         | Uso                                | Tiempo           |
|---------------------|------------------------------------|------------------|
| **MemTest86+**      | Prueba exhaustiva de RAM           | 1-4 horas        |
| **HDAT2**           | Diagnóstico de disco duro          | 30 min - 2 horas |
| **Spinrite**        | Reparación de sectores defectuosos | Horas            |
| **Ultimate BootCD** | Suite completa de diagnóstico      | Varía            |

### 💾 Recuperación

| Herramienta                      | Especialidad                        |
|----------------------------------|-------------------------------------|
| **EaseUS Data Recovery**         | Recuperación de archivos eliminados |
| **MiniTool Power Data Recovery** | Búsqueda profunda de datos          |
| **Rescuezilla**                  | Clonación de particiones            |
| **Macrium Reflect**              | Backup profesional                  |

### 🔧 Reparación

| Herramienta          | Función                            |
|----------------------|------------------------------------|
| **Boot Repair Disk** | Reparación automática GRUB/Windows |
| **Super GRUB2 Disk** | Recuperación de GRUB2              |
| **EasyUEFI**         | Gestión de opciones UEFI           |
| **Jayro's Lockpick** | Reset de contraseña Windows        |

### 🧹 Limpieza

| Herramienta          | Acción                          |
|----------------------|---------------------------------|
| **Malwarebytes**     | Eliminación de malware          |
| **Dr.Web CureIt!**   | Escaneo antivirus               |
| **CCleanerPortable** | Limpieza de archivos temporales |
| **ShredOS**          | Borrado seguro de datos         |

---

## Troubleshooting

### Problema: El USB no arranca

**Solución:**

```bash
# Verifica el dispositivo correcto
lsblk

# Reinstala Ventoy
sudo ventoy-bin -i /dev/sdX --force

# Si aún no funciona, formatea primero
sudo mkfs.vfat /dev/sdX1 -n VENTOY
```

### Problema: USB montado pero no aparecen archivos

```bash
# Verifica permisos
ls -la /run/media/usuario/Ventoy/

# Si ves archivos ocultos, muéstralos
ls -la /run/media/usuario/Ventoy/.*
```

### Problema: No hay espacio suficiente

```bash
# Verifica el uso
df -h /run/media/usuario/Ventoy/

# Si está lleno, borra archivos innecesarios
sudo rm /run/media/usuario/Ventoy/archivo_grande.iso
```

### Problema: Ventoy no se instala

```bash
# Intenta con la GUI
ventoy-gui

# O reinstala desde AUR
yay -R ventoy-bin
yay -S ventoy-bin
```

### Problema: El USB se desconecta durante la copia

```bash
# Copia con progress bar
sudo rsync -av --progress ~/medicat_descargado/ /run/media/usuario/Ventoy/

# O por lotes pequeños
sudo cp -v ~/medicat_descargado/Diagnostic_Tools /run/media/usuario/Ventoy/
```

---

## 📋 Resumen del Proceso Completo

```bash
# 1. Instalar Ventoy
yay -S ventoy-bin

# 2. Identificar USB
lsblk

# 3. Instalar Ventoy en USB
sudo ventoy-bin -i /dev/sdX

# 4. Copiar MediCat
sudo cp -r ~/medicat_descargado/* /run/media/usuario/Ventoy/

# 5. Sincronizar
sudo sync

# 6. Desmontar
sudo umount /run/media/usuario/Ventoy

# 7. Arrancar desde BIOS y seleccionar MediCat
```

---

## 🎯 Casos de Uso Comunes

### Diagnóstico de RAM defectuosa

1. Arranca MemTest86+
2. Ejecuta el test completo
3. Espera 2-4 horas para resultados confiables
4. Si hay errores = RAM defectuosa

### Recuperar datos de un disco corrupto

1. Arranca SystemRescue
2. Abre una terminal
3. Usa `fsck` o `TestDisk` para analizar
4. Intenta recuperar con EaseUS Data Recovery

### Reparar arranque de Windows

1. Arranca Boot Repair Disk
2. Deja que repare automáticamente
3. Reinicia el PC normalmente

### Borrado seguro antes de vender PC

1. Arranca ShredOS
2. Selecciona el disco completo
3. Deja que borre con múltiples pasadas
4. 100% irrecuperable

---

## 🔗 Enlaces Útiles

- **Ventoy Oficial**: [https://www.ventoy.net/](https://www.ventoy.net/)
- **MediCat**: [https://www.hirensbootcd.org/](https://www.hirensbootcd.org/) (incluido en MediCat)
- **SystemRescue**: [https://www.system-rescue.org/](https://www.system-rescue.org/)
- **Arch Linux Wiki Git**: [https://wiki.archlinux.org/title/git](https://wiki.archlinux.org/title/git)

---

**Autor**: José Ángel Alejo Sillero  
**Centro**: Instituto Tecnológico Pablo de la Torre  
**Asignatura**: Sistemas Informáticos / Diagnóstico de Hardware  
**Actualizado**: 1 de febrero de 2026

**Nota**: Esta guía se ha creado basándose en experiencia práctica con Arch Linux, Ventoy 1.1.10 y MediCat. Los pasos pueden variar ligeramente según versiones futuras. No se trata de trabajo de clase ni tarea.
