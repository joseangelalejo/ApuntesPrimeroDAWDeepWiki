# **Unidad 4. Particiones y RAID: Estrategias para la Organización y Seguridad de Datos**

- **Autor**: José Ángel Alejo Sillero
- **Centro**: Instituto Tecnológico Pablo de la Torre
- **Curso**: 2025/2026
- **Módulo**: Sistemas Informáticos
- **Unidad**: 4 - Particiones y RAID: Estrategias para la Organización y Seguridad de Datos

---
<div style="page-break-after: always;"></div>

> Tabla de Contenidos

---
<div style="page-break-after: always;"></div>

## **1. Introducción a las Particiones de Disco y volúmenes Lógicos**

- **Partición**: Es una división lógica de un disco físico que actúa como una unidad independiente. Cada partición puede tener su propio sistema de archivos(NTFS, FAT32, exFAT) y una letra de unidad asignada,se trata como un disco separado por el sistema operativo.
- **Volumen**: Es un espacio de almacenamiento dentro de un disco o conjunto de discos que puede contener un sistema de archivos. En discos básicos, un volumen suele coincidir con una partición, mientras que en discos dinámicos, un volumen puede abarcar múltiples discos físicos.

### **Diferencias clave entre Particiones y Volúmenes**

| **Características** | **Partición**                                 | **Volumen**                                      |
|---------------------|-----------------------------------------------|--------------------------------------------------|
| Ubicación           | Se crea en discos básicos                     | Se usa en discos dinámicos                       |
| Tipo de estructura  | Se basa en MBR o GPT                          | Puede abarcar varios discos                      |
| Extensibilidad      | Limitada en tamaño según tabla de particiones | Puede extenderse dinámicamente                   |
| Tipos               | Primario, Extendida, Lógica                   | Simple, Distribuido, Seccionado, Espejado Raid-5 |

Las particiones GPT (Tabla de Particiones GUID) son un estándar moderno que supera las limitaciones del MBR (Master Boot Record), permitiendo discos más grandes y más particiones. GPT es compatible con UEFI, mientras que MBR es compatible con BIOS.

GPT permite hasta 128 particiones y soporta discos de más de 2 TB, mientras que MBR está limitado a 4 particiones primarias, 24 particiones lógicas(partición extendida) y discos de hasta 2 TB.

### **Tipos de almacenamiento en Windows**

Windows permite gestionar el almacenamiento mediante dos tipos principales de discos:

1. **Discos Básicos**:
   1. Son el tipo de almacenamiento predeterminado en Windows.
   2. Usan particiones (Primarias, Extendidas y Lógicas).
   3. Solo pueden contener volúmenes dentro de un mismo disco físico.
   4. No permiten RAID nativo (excepto mediante hardware o software externo).
   5. Se gestionan con el esquema MBR (hasta 2 TB y 4 particiones) o GPT (sin límite práctico de tamaño y hasta 128 particiones).
2. **Discos Dinámicos**:
   1. Permiten crear volúmenes que abarcan varios discos físicos.
   2. Ofrecen mayor flexibilidad en la gestión del espacio de almacenamiento.
   3. Soportan configuraciones RAID por software (Espejados, Seccionados, RAID-5).
   4. Pueden extender o reducir volúmenes sin eliminar datos.

### RAID (Redundant Array of Independent Disks)

RAID es una tecnología que combina múltiples discos duros en una sola unidad lógica para mejorar el rendimiento, la redundancia o ambos. Existen varios niveles de RAID, cada uno con sus propias características y beneficios.

Nosotros vamos a trabajar con los principales, que son RAID 0, RAID 1 y RAID 5.

- **Raid 0 (Striping):** Mejor rendimiento, pero vulnerable a fallos y pérdida de datos.
  - Distribuye los datos entre dos o más discos.
  - No ofrece redundancia.
  - Si un disco falla, se pierden todos los datos.
- **Raid 1 (Mirroring):** Alta redundancia, pero requiere el doble de espacio.
  - Duplica los datos en dos discos.
  - Si un disco falla, los datos permanecen accesibles en el otro.
  - Requiere el doble de espacio de almacenamiento.
- **Raid 5 (Striping con Paridad):** Buen equilibrio entre rendimiento y redundancia.
  - Distribuye los datos y la información de paridad entre tres o más discos.
  - Puede tolerar la falla de un disco sin pérdida de datos.
  - Requiere al menos tres discos.

Windows permite configurar RAID por software utilizando discos dinámicos, lo que facilita la creación y gestión de volúmenes RAID sin necesidad de hardware adicional.

Por otro lado, permite crear Volúmenes Distribuidos (similar a RAID 0), Espejados (RAID 1) y RAID-5 en discos dinámicos, proporcionando flexibilidad y opciones de seguridad para la gestión del almacenamiento.

Los Volúmenes Distribuidos en Windows NO son lo mismo que RAID 0, aunque ambos implican la distribución de datos entre varios discos para mejorar el rendimiento. La principal diferencia radica en la implementación y el contexto en el que se utilizan:

- **Volúmenes Distribuidos en Windows**:
  - Se crean en discos dinámicos.
  - Permiten combinar espacio de varios discos físicos en un solo volumen lógico.
  - No requieren hardware RAID específico.
  - Pueden ser extendidos o reducidos dinámicamente.
  - No ofrecen redundancia ni protección contra fallos de disco.
  - Se gestionan a través del sistema operativo Windows.
- **RAID 0**:
  - Es una configuración de RAID que distribuye datos entre dos o más discos para mejorar el rendimiento.
  - Requiere hardware RAID o soporte de software específico.
  - No ofrece redundancia; si un disco falla, se pierden todos los datos.
  - Generalmente se utiliza en entornos donde el rendimiento es crítico y la pérdida de datos no es una preocupación principal.
  - Se implementa a nivel de hardware o software RAID, no a través del sistema operativo directamente.
  - No permite la gestión dinámica del tamaño del volumen.

Por tanto los volúmenes distribuidos NO mejoran el rendimiento tanto como RAID 0, pero ofrecen mayor flexibilidad en la gestión del almacenamiento dentro del entorno de Windows y ambos carecen de redundancia y seguridad contra fallos de disco.

## Comandos para gestión de particiones en Debian

El comando `lsblk` se utiliza en sistemas Linux para listar la información de los dispositivos de bloques, como discos duros y particiones. Proporciona detalles sobre el tamaño, tipo, punto de montaje y otros atributos de cada dispositivo de bloque en el sistema.

Si agregamos la opción `-l` (secuencia larga), el comando `lsblk -l` muestra la información en un formato de lista más detallado y legible, facilitando la visualización de las características de cada dispositivo de bloque. Muestra: nombre, tamaño, tipo, punto de montaje, entre otros detalles.

```bash
NAME MAJ:MIN RM  SIZE RO TYPE MOUNTPOINTS
sda    8:0    0   20G  0 disk
sda1   8:1    0   19G  0 part /
sda2   8:2    0    1K  0 part
sda5   8:5    0  975M  0 part [SWAP]
sdb    8:16   0   10G  0 disk
sdb1   8:17   0    5G  0 part /mnt/disk1
sdb2   8:18   0    2G  0 part
sdc    8:32   0   10G  0 disk
sdd    8:48   0   10G  0 disk
```

En nuestro caso, al ejecutar `lsblk -l`, vemos que tenemos un disco sdd de 10G disponible. Vamos a trabajar con él para crear particiones y gestionar el almacenamiento.

> **Paso 1: Ver la información actual del disco**

Primero vamos a ver la información del disco con el comando `parted /dev/sdd print`:

```bash
root@vbox:~# parted /dev/sdd print
Model: ATA QEMU HARDDISK (scsi)
Disk /dev/sdd: 10,7GB
Sector size (logical/physical): 512B/512B
Partition Table: msdos
Disk Flags:

Number  Start  End  Size  Type  File system  Flags

root@vbox:~# 
```

> **Paso 2: Crear tabla de particiones MBR**

Ahora vamos a crear una tabla de particiones MBR en el disco sdd con el comando `parted /dev/sdd mklabel msdos` y veri:

```bash
root@vbox:~# parted /dev/sdd mklabel msdos
```

Verificamos que la tabla de particiones se ha creado correctamente:

```bash
root@vbox:~# parted /dev/sdd print
Model: ATA QEMU HARDDISK (scsi)
Disk /dev/sdd: 10,7GB
Sector size (logical/physical): 512B/512B
Partition Table: msdos
Disk Flags:

Number  Start  End  Size  Type  File system  Flags

root@vbox:~#
```

> **Paso 3: Crear particiones**

A continuación vamos a crear una partición primaria que ocupe 3GB con el comando `parted /dev/sdd mkpart primary ext4 1MiB 3000MiB`:

```bash
root@vbox:~# parted /dev/sdd mkpart primary ext4 1MiB 3000MiB
```

Verificamos que la partición se ha creado:

```bash
root@vbox:~# parted /dev/sdd print
Model: ATA QEMU HARDDISK (scsi)
Disk /dev/sdd: 10,7GB
Sector size (logical/physical): 512B/512B
Partition Table: msdos
Disk Flags:

Number  Start   End     Size    Type     File system  Flags
 1      1049kB  3146MB  3145MB  primary

root@vbox:~#
```

Ahora vamos a crear una segunda partición de 3GB que comience justo después de la primera partición. Ejecutamos `parted /dev/sdd mkpart primary ext4 3146MiB 6146MiB`:

```bash
root@vbox:~# parted /dev/sdd mkpart primary ext4 3146MiB 6146MiB
```

Verificamos que ambas particiones se han creado correctamente:

```bash
root@vbox:~# parted /dev/sdd print
Model: ATA QEMU HARDDISK (scsi)
Disk /dev/sdd: 10,7GB
Sector size (logical/physical): 512B/512B
Partition Table: msdos
Disk Flags:

Number  Start   End     Size    Type     File system  Flags
 1      1049kB  3146MB  3145MB  primary
 2      3299MB  6445MB  3146MB  primary

root@vbox:~#
```

> **Paso 4: Formatear las particiones**

El comando `mkfs.ext4` significa "make filesystem ext4" y se utiliza para crear un sistema de archivos ext4 en una partición o disco en sistemas Linux. Ahora formateamos cada partición:

Formateamos la primera partición con `mkfs.ext4 /dev/sdd1`:

```bash
root@vbox:~# mkfs.ext4 /dev/sdd1
mke2fs 1.47.0 (5-Feb-2023)
Discarding device blocks: done
Creating filesystem with 786432 4k blocks and 196608 inodes
Filesystem UUID: 2e5a8b9f-d7c3-4a92-8f1e-9c3d2e1a5b7f
Superblock backups stored on blocks:
        32768, 98304, 163840, 229376, 294912, 819200, 884736

Allocating group tables: done
Writing inode tables: done
Creating journal (16384 blocks): done
Writing superblocks and filesystem accounting information: done
```

Formateamos la segunda partición con `mkfs.ext4 /dev/sdd2`:

```bash
root@vbox:~# mkfs.ext4 /dev/sdd2
mke2fs 1.47.0 (5-Feb-2023)
Discarding device blocks: done
Creating filesystem with 786432 4k blocks and 196608 inodes
Filesystem UUID: 3f6b9c0a-e8d4-5b03-9g2f-0d4e3f2b6c8g
Superblock backups stored on blocks:
        32768, 98304, 163840, 229376, 294912, 819200, 884736

Allocating group tables: done
Writing inode tables: done
Creating journal (16384 blocks): done
Writing superblocks and filesystem accounting information: done
```

Por último verificamos que las particiones se han formateado correctamente con `lsblk -f` El flag `-f` muestra información sobre los sistemas de archivos de los dispositivos de bloques:

```bash
root@vbox:~# lsblk -f
NAME   FSTYPE FSVER LABEL UUID                                 FSAVAIL FSUSE% MOUNTPOINTS
sda
├─sda1 ext4   1.0         b00c4602-7542-4942-befa-3720fbe84174   15,9G     9% /
├─sda2
└─sda5 swap   1           be027972-e7b3-4fe8-bf0b-d4bcc3087988                [SWAP]
sdb
├─sdb1 ext4   1.0         aba4bc72-7f9f-4be1-ad70-930b3c544d8b    4,6G     0% /mnt/disk1
└─sdb2
sdc
sdd
├─sdd1 ext4   1.0         850c824d-9a6b-4b93-bdbb-49e03f1abc86
└─sdd2 ext4   1.0         6aa3b672-027a-4eba-956d-3b2328a4590e
```

> **Paso 5: Eliminar particiones**

Si quisieramos eliminar una de las particiones creadas, por ejemplo la segunda, ejecutaríamos `parted /dev/sdd rm 2`:

```bash
root@vbox:~# parted /dev/sdd rm 2
Information: You may need to update /etc/fstab.
```

Verificamos que la partición se ha eliminado:

```bash
root@vbox:~# parted /dev/sdd print
Model: ATA QEMU HARDDISK (scsi)
Disk /dev/sdd: 10,7GB
Sector size (logical/physical): 512B/512B
Partition Table: msdos
Disk Flags:

Number  Start   End     Size    Type     File system  Flags
 1      1049kB  3146MB  3145MB  primary
```

> **Paso 6: Extender partición**

Para extender una partición, primero debemos eliminar todas las particiones que estén después de la que queremos extender, luego crear una nueva que abarque el espacio adicional y finalmente recrear las particiones que había después.

```bash
root@vbox:~# parted /dev/sdd print
Model: ATA QEMU HARDDISK (scsi)
Disk /dev/sdd: 10,7GB
Sector size (logical/physical): 512B/512B
Partition Table: msdos
Disk Flags:

Number  Start   End     Size    Type     File system  Flags
 1      1049kB  3146MB  3145MB  primary  ext4
 2      3299MB  6445MB  3146MB  primary  ext4
```

Actualmente tenemos en sdd las particiones sdd1(2.9G) y sdd2(2.9G), teniendo el disco un total de 10.7GB. Por ejemplo, para extender la primera partición para que ocupe 1GB más, haríamos lo siguiente:

```bash
root@vbox:~# parted /dev/sdd rm 2
Information: You may need to update /etc/fstab.
root@vbox:~# parted /dev/sdd rm 1
Information: You may need to update /etc/fstab.
root@vbox:~# parted /dev/sdd mkpart primary ext4 1MiB 4000MiB
root@vbox:~# parted /dev/sdd mkpart primary ext4 4000MiB 10206MiB
```

Primero eliminamos la segunda partición (sdd2) que se encuentra en el espacio que queremos extender, luego eliminamos la primera partición (sdd1) para crear una nueva que abarque el espacio adicional. Después recreamos la segunda partición en el espacio restante. Las particiones no pueden superponerse, por lo que es necesario eliminar las que estén en el camino antes de extender. Ya que hemos eliminado las particiones, debemos formatearlas de nuevo:

```bash
root@vbox:~# mkfs.ext4 /dev/sdd1
mke2fs 1.47.0 (5-Feb-2023)
/dev/sdd1 contains a ext4 file system
        created on Fri Jan 30 10:49:40 2026
Proceed anyway? (y,N) yes
Discarding device blocks: done
Creating filesystem with 1023744 4k blocks and 256000 inodes
Filesystem UUID: c573eb42-a133-4bff-89d6-0e0523da28e1
Superblock backups stored on blocks:
        32768, 98304, 163840, 229376, 294912, 819200, 884736

Allocating group tables: done
Writing inode tables: done
Creating journal (16384 blocks): done
Writing superblocks and filesystem accounting information: done

root@vbox:~# mkfs.ext4 /dev/sdd2
mke2fs 1.47.0 (5-Feb-2023)
/dev/sdd2 contains a ext4 file system
        created on Mon Feb  2 10:12:43 2026
Proceed anyway? (y,N) y
Discarding device blocks: done
Creating filesystem with 1588736 4k blocks and 397488 inodes
Filesystem UUID: 5cad3aab-23c2-4528-bd0d-1c820190c5f1
Superblock backups stored on blocks:
        32768, 98304, 163840, 229376, 294912, 819200, 884736

Allocating group tables: done
Writing inode tables: done
Creating journal (16384 blocks): done
Writing superblocks and filesystem accounting information: done
```

Verificamos que las particiones se han extendido correctamente:

```bash
root@vbox:~# parted /dev/sdd print
Model: ATA QEMU HARDDISK (scsi)
Disk /dev/sdd: 10,7GB
Sector size (logical/physical): 512B/512B
Partition Table: msdos
Disk Flags:

Number  Start   End     Size    Type     File system  Flags
 1      1049kB  4194MB  4193MB  primary  ext4
 2      4194MB  10,7GB  6507MB  primary  ext4
```

Como se puede ver, ahora tenemos:

- **sdd1**: 4,193 MB (aproximadamente 4 GB) - partición extendida
- **sdd2**: 6,507 MB (aproximadamente 6.5 GB) - partición recreada en el espacio restante

El espacio total se ha utilizado correctamente (4.193 GB + 6.507 GB = 10.7 GB)

> **Paso 7: Montar particiones**

Para montar las particiones y hacerlas accesibles en el sistema de archivos, primero creamos los puntos de montaje y luego montamos las particiones.

La sintaxis para realizar el montaje es: ```mount <dispositivo> <punto_de_montaje>```

```bash
root@vbox:~# mkdir /mnt/particionsdd1
root@vbox:~# mkdir /mnt/particionsdd2
root@vbox:~# mount /dev/sdd1 /mnt/particionsdd1
root@vbox:~# mount /dev/sdd2 /mnt/particionsdd2
```

Verificamos que las particiones se han montado correctamente con `lsblk -f`:

```bash
root@vbox:~# lsblk -f
NAME FSTYPE FSVER LABEL UUID                                 FSAVAIL FSUSE% MOUNTPOINTS
sda
├─sda1
│    ext4   1.0         b00c4602-7542-4942-befa-3720fbe84174   15,9G     9% /
├─sda2
│
└─sda5
     swap   1           be027972-e7b3-4fe8-bf0b-d4bcc3087988                [SWAP]
sdb
├─sdb1
│    ext4   1.0         aba4bc72-7f9f-4be1-ad70-930b3c544d8b    4,6G     0% /mnt/disk1
└─sdb2

sdc
sdd
├─sdd1
│    ext4   1.0         c573eb42-a133-4bff-89d6-0e0523da28e1    3,6G     0% /mnt/particionsdd1
└─sdd2
     ext4   1.0         5cad3aab-23c2-4528-bd0d-1c820190c5f1    5,6G     0% /mnt/particionsdd2
```

Por último, para desmontar las particiones cuando ya no las necesitemos, usamos el comando `umount`, especificando la ruta del punto de montaje, no la del dispositivo:

```bash
root@vbox:~# umount /mnt/particionsdd1
root@vbox:~# umount /mnt/particionsdd2
```

Y para verificar que se han desmontado correctamente, usamos `lsblk -f` de nuevo:

```bash
root@vbox:~# lsblk -f
NAME   FSTYPE FSVER LABEL UUID                                 FSAVAIL FSUSE% MOUNTPOINTS
sda
├─sda1 ext4   1.0         b00c4602-7542-4942-befa-3720fbe84174   15,9G     9% /
├─sda2
└─sda5 swap   1           be027972-e7b3-4fe8-bf0b-d4bcc3087988                [SWAP]
sdb
├─sdb1 ext4   1.0         aba4bc72-7f9f-4be1-ad70-930b3c544d8b    4,6G     0% /mnt/disk1
└─sdb2
sdc
sdd
├─sdd1 ext4   1.0         c573eb42-a133-4bff-89d6-0e0523da28e1
└─sdd2 ext4   1.0         5cad3aab-23c2-4528-bd0d-1c820190c5f1
```

Podemos ver que las particiones sdd1 y sdd2 ya no están montadas en ningún punto de montaje, pues la columna de MOUNTPOINTS está vacía para ambas particiones.

> **Paso 8: Configurar montaje automático al iniciar el sistema**

Tras montar un punto de montaje, debemos modificar el archivo `/etc/fstab` para que las particiones se monten automáticamente al iniciar el sistema. Para ello primero deberíamos hacerle un `cat /etc/fstab` para ver su contenido y copiarlo antes de editarlo, y luego abrir el archivo con un editor de texto, por ejemplo `nano`:

```bash
root@vbox:~# cat /etc/fstab
# /etc/fstab: static file system information.
#
# Use 'blkid' to print the universally unique identifier for a
# device; this may be used with UUID= as a more robust way to name devices
# that works even if disks are added and removed. See fstab(5).
#
# systemd generates mount units based on this file, see systemd.mount(5).
# Please run 'systemctl daemon-reload' after making changes here.
#
# <file system> <mount point>   <type>  <options>       <dump>  <pass>
# / was on /dev/sda1 during installation
UUID=b00c4602-7542-4942-befa-3720fbe84174 /               ext4    errors=remount-ro 0       1
# swap was on /dev/sda5 during installation
UUID=be027972-e7b3-4fe8-bf0b-d4bcc3087988 none            swap    sw              0       0
/dev/sr0        /media/cdrom0   udf,iso9660 user,noauto     0       0
UUID=aba4bc72-7f9f-4be1-ad70-930b3c544d8b /mnt/disk1 ext4 defaults 0 2
```

En nuestro caso, añadiríamos las siguientes líneas al final del archivo para montar automáticamente las particiones sdd1 y sdd2:

```
UUID=c573eb42-a133-4bff-89d6-0e0523da28e1 /mnt/particionsdd1 ext4 defaults 0 2
UUID=5cad3aab-23c2-4528-bd0d-1c820190c5f1 /mnt/particionsdd2 ext4 defaults 0 2
```

La sintaxis es:

```
<UUID_del_sistema_de_archivos> <punto_de_montaje> <tipo_de_sistema_de_archivos> <opciones_de_montaje> <dump> <pass>
```

Donde `dump` se refiere a si se debe hacer una copia de seguridad del sistema de archivos (0 = no, 1 = sí) y `pass` indica el orden en que se deben verificar los sistemas de archivos al arrancar (0 = no verificar, 1 = verificar primero, 2 = verificar después).

Por el contrario, si no queremos que se monten automáticamente o hemos eliminado las particiones, simplemente eliminamos las líneas correspondientes del archivo `/etc/fstab`.

Como nuestra máquina virtual se ha creado a partir de una imagen proporcionada por el profesor, cuando ejecutabamos comandos de gestión de discos, obteníamos continuamente un error/aviso indicando que "Es posible que necesites actualizar /etc/fstab".v(`Information: You may need to update /etc/fstab.`) Esto se debe a que el sistema detecta cambios en las particiones y sugiere actualizar el archivo `/etc/fstab` para reflejar esos cambios y asegurar que las particiones se monten correctamente al iniciar el sistema.

Una vez lo hemos modificado, si intentamos montar particiones de nuevo puede ser que recibamos un aviso indicando que debemos recargar el demonio de systemd para que reconozca los cambios realizados en `/etc/fstab`:

```bash
mount: (hint) your fstab has been modified, but systemd still uses
       the old version; use 'systemctl daemon-reload' to reload.
root@vbox:~# systemctl daemon-reload
```

> **Paso 9: Montar particiones extendidas (Opcional)**

Si quisiéramos crear una partición extendida en lugar de primaria, el proceso es similar, pero debemos tener en cuenta que una partición extendida puede contener múltiples particiones lógicas dentro de ella.

Para crear una partición extendida, usaríamos el comando `parted /dev/sdd mkpart extended <inicio> <fin>`.

Luego crearíamos particiones lógicas dentro de esa partición extendida usando `parted /dev/sdd mkpart logical <tipo> <inicio> <fin>`.

Primeramente verificamos el estado actual del disco con un `parted /dev/sdd print`:

```bash
root@vbox:~# parted /dev/sdd print
Model: ATA QEMU HARDDISK (scsi)
Disk /dev/sdd: 10,7GB
Sector size (logical/physical): 512B/512B
Partition Table: msdos
Disk Flags:

Number  Start   End     Size    Type     File system  Flags
 1      1049kB  4194MB  4193MB  primary  ext4
 2      4194MB  10,7GB  6507MB  primary  ext4
```

Ahora eliminamos ambas particiones para crear una partición extendida que abarque un 80%, y luego creamos dos particiones lógicas dentro de esa partición extendida:

```bash
root@vbox:~# parted /dev/sdd rm 2
Information: You may need to update /etc/fstab.
root@vbox:~# parted /dev/sdd rm 1
Information: You may need to update /etc/fstab.
root@vbox:~# parted /dev/sdd mkpart extended 0% 80%
Information: You may need to update /etc/fstab.

root@vbox:~# lsblk -l
NAME MAJ:MIN RM  SIZE RO TYPE MOUNTPOINTS
sda    8:0    0   20G  0 disk
sda1   8:1    0   19G  0 part /
sda2   8:2    0    1K  0 part
sda5   8:5    0  975M  0 part [SWAP]
sdb    8:16   0   10G  0 disk
sdb1   8:17   0    5G  0 part /mnt/disk1
sdb2   8:18   0    2G  0 part
sdc    8:32   0   10G  0 disk
sdd    8:48   0   10G  0 disk
sdd1   8:49   0    1K  0 part
root@vbox:~# parted /dev/sdd print
Model: ATA QEMU HARDDISK (scsi)
Disk /dev/sdd: 10,7GB
Sector size (logical/physical): 512B/512B
Partition Table: msdos
Disk Flags:

Number  Start   End     Size    Type      File system  Flags
 1      1049kB  8590MB  8589MB  extended               lba
```

Ahora creamos dos particiones lógicas dentro de la partición extendida:

```bash
root@vbox:~# parted /dev/sdd mkpart logical ext4 1MiB 4290MiB
Warning: You requested a partition from 1049kB to 4498MB (sectors 2048..8785919).
The closest location we can manage is 1049kB to 4498MB (sectors 2049..8785919).
Is this still acceptable to you?
Yes/No? yes
Warning: The resulting partition is not properly aligned for best performance: 2049s % 2048s != 0s
Ignore/Cancel? ignore
Information: You may need to update /etc/fstab.

root@vbox:~# parted /dev/sdd mkpart logical ext4 4290MB 8590MB
Warning: You requested a partition from 4290MB to 8590MB (sectors 8378906..16777343).
The closest location we can manage is 4498MB to 8590MB (sectors 8785921..16777215).
Is this still acceptable to you?
Yes/No? yes
Warning: The resulting partition is not properly aligned for best performance: 8785921s % 2048s != 0s
Ignore/Cancel? ignore
Information: You may need to update /etc/fstab.

root@vbox:~# parted /dev/sdd print
Model: ATA QEMU HARDDISK (scsi)
Disk /dev/sdd: 10,7GB
Sector size (logical/physical): 512B/512B
Partition Table: msdos
Disk Flags:

Number  Start   End     Size    Type      File system  Flags
 1      1049kB  8590MB  8589MB  extended               lba
 5      1049kB  4498MB  4497MB  logical
 6      4498MB  8590MB  4092MB  logical
```

> **Paso 10: Formatear y montar particiones lógicas en particiones extendidas**

Ahora formateamos las particiones lógicas creadas dentro de la partición extendida. Para ello primero hacemos un `lsblk -l` para ver las particiones lógicas y un `parted /dev/sdd print` para verificar su estado:

```bash
root@vbox:~# lsblk -l
NAME MAJ:MIN RM  SIZE RO TYPE MOUNTPOINTS
sda    8:0    0   20G  0 disk
sda1   8:1    0   19G  0 part /
sda2   8:2    0    1K  0 part
sda5   8:5    0  975M  0 part [SWAP]
sdb    8:16   0   10G  0 disk
sdb1   8:17   0    5G  0 part /mnt/disk1
sdb2   8:18   0    2G  0 part
sdc    8:32   0   10G  0 disk
sdd    8:48   0   10G  0 disk
sdd1   8:49   0    1K  0 part
sdd5   8:53   0  4,2G  0 part
sdd6   8:54   0  3,8G  0 part
root@vbox:~# parted /dev/sdd print
Model: ATA QEMU HARDDISK (scsi)
Disk /dev/sdd: 10,7GB
Sector size (logical/physical): 512B/512B
Partition Table: msdos
Disk Flags:

Number  Start   End     Size    Type      File system  Flags
 1      1049kB  8590MB  8589MB  extended               lba
 5      1049kB  4498MB  4497MB  logical
 6      4498MB  8590MB  4092MB  logical
```

A continuación formateamos las particiones lógicas sdd5 y sdd6 con `mkfs.ext4`:

```bash
root@vbox:~# mkfs.ext4 /dev/sdd5
mke2fs 1.47.0 (5-Feb-2023)
Discarding device blocks: done
Creating filesystem with 1097983 4k blocks and 274720 inodes
Filesystem UUID: 12f429e7-8ff1-41d8-b5d4-fd0c05a3a8d2
Superblock backups stored on blocks:
        32768, 98304, 163840, 229376, 294912, 819200, 884736

Allocating group tables: done
Writing inode tables: done
Creating journal (16384 blocks): done
Writing superblocks and filesystem accounting information: done

root@vbox:~# mkfs.ext4 /dev/sdd6
mke2fs 1.47.0 (5-Feb-2023)
Discarding device blocks: done
Creating filesystem with 998911 4k blocks and 249984 inodes
Filesystem UUID: 4181e759-d778-4e8d-aeb1-23e44ea4b001
Superblock backups stored on blocks:
        32768, 98304, 163840, 229376, 294912, 819200, 884736

Allocating group tables: done
Writing inode tables: done
Creating journal (16384 blocks): done
Writing superblocks and filesystem accounting information: done
```

A continuación montamos las particiones lógicas creando primero los puntos de montaje y luego montándolas. Por último verificamos que se han montado correctamente con `lsblk -f`:

```bash
root@vbox:~# mkdir /mnt/particionsdd5
root@vbox:~# mkdir /mnt/particionsdd6
root@vbox:~# mount /dev/sdd5 /mnt/particionsdd5
root@vbox:~# mount /dev/sdd6 /mnt/particionsdd6
root@vbox:~# lsblk -f
NAME   FSTYPE FSVER LABEL UUID                                 FSAVAIL FSUSE% MOUNTPOINTS
sda
├─sda1 ext4   1.0         b00c4602-7542-4942-befa-3720fbe84174   15,9G     9% /
├─sda2
└─sda5 swap   1           be027972-e7b3-4fe8-bf0b-d4bcc3087988                [SWAP]
sdb
├─sdb1 ext4   1.0         aba4bc72-7f9f-4be1-ad70-930b3c544d8b    4,6G     0% /mnt/disk1
└─sdb2
sdc
sdd
├─sdd1
├─sdd5 ext4   1.0         12f429e7-8ff1-41d8-b5d4-fd0c05a3a8d2    3,8G     0% /mnt/particionsdd5
└─sdd6 ext4   1.0         4181e759-d778-4e8d-aeb1-23e44ea4b001    3,5G     0% /mnt/particionsdd6
root@vbox:~#
```

> **Paso 11: Redimensionar particiones lógicas**

Redimensionar particiones lógicas implica cambiar su tamaño para aumentar o disminuir el espacio asignado a ellas. En sistemas Linux, esto se puede hacer utilizando herramientas como `parted` o `fdisk`, pero es importante tener en cuenta que redimensionar particiones puede llevar a la pérdida de datos si no se realiza correctamente. Siempre se recomienda hacer una copia de seguridad de los datos importantes antes de proceder.

En nuestro caso, al ser un entorno de pruebas no realizaremos la copia de seguridad.
Para redimensionar una partición lógica, primero debemos desmontarla si está montada, luego eliminarla y crear una nueva partición lógica con el tamaño deseado. Después, debemos formatearla nuevamente y restaurar los datos si es necesario. Nosotros tenemos las particiones lógicas sdd5 y sdd6 montadas dentro de una particióne extendida en sdd1. Vamos a redimensionar la partición lógica sdd5 para que ocupe 1GB menos, y luego ajustaremos sdd6 para que ocupe el espacio restante. Primero desmontamos las particiones lógicas:

```bash
root@vbox:~# umount /mnt/particionsdd5
root@vbox:~# umount /mnt/particionsdd6
root@vbox:~# parted /dev/sdd print
Model: ATA QEMU HARDDISK (scsi)
Disk /dev/sdd: 10,7GB
Sector size (logical/physical): 512B/512B
Partition Table: msdos
Disk Flags:

Number  Start   End     Size    Type      File system  Flags
 1      1049kB  8590MB  8589MB  extended               lba
 5      1049kB  4498MB  4497MB  logical   ext4
 6      4498MB  8590MB  4092MB  logical   ext4
```

Ahora eliminamos la partición lógica sdd6 para liberar espacio, luego eliminamos sdd5 para crear una nueva partición lógica con el tamaño reducido, y finalmente recreamos sdd6 con el espacio restante:

```bash
root@vbox:~# parted /dev/sdd rm 5
Information: You may need to update /etc/fstab.
root@vbox:~# parted /dev/sdd rm 6
Information: You may need to update /etc/fstab.
root@vbox:~# parted /dev/sdd mkpart logical ext4 1MiB 3790MiB
Warning: You requested a partition from 1049kB to 3974MB (sectors 2048..7761919).
The closest location we can manage is 1049kB to 3974MB (sectors 2049..7761919).
Is this still acceptable to you?
Yes/No? yes
Warning: The resulting partition is not properly aligned for best performance: 2049s % 2048s != 0s
Ignore/Cancel? ignore
Information: You may need to update /etc/fstab.

root@vbox:~# parted /dev/sdd mkpart logical ext4 3790MB 8590MB
Warning: You requested a partition from 3790MB to 8590MB (sectors 7402343..16777343).
The closest location we can manage is 3974MB to 8590MB (sectors 7761921..16777215).
Is this still acceptable to you?
Yes/No? yes
Warning: The resulting partition is not properly aligned for best performance: 7761921s % 2048s != 0s
Ignore/Cancel? ignore
Information: You may need to update /etc/fstab.
root@vbox:~# parted /dev/sdd print
Model: ATA QEMU HARDDISK (scsi)
Disk /dev/sdd: 10,7GB
Sector size (logical/physical): 512B/512B
Partition Table: msdos
Disk Flags:

Number  Start   End     Size    Type      File system  Flags
 1      1049kB  8590MB  8589MB  extended               lba
 5      1049kB  3974MB  3973MB  logical   ext4
 6      3974MB  8590MB  4616MB  logical
```

Ahora formateamos las particiones lógicas redimensionadas:

```bash
root@vbox:~# mkfs.ext4 /dev/sdd5
mke2fs 1.47.0 (5-Feb-2023)
/dev/sdd5 contains a ext4 file system
        last mounted on Mon Feb  2 10:55:05 2026
Proceed anyway? (y,N) yes
Discarding device blocks: done
Creating filesystem with 969983 4k blocks and 242880 inodes
Filesystem UUID: d6e45aca-89a6-4f02-be5d-0ffcd2fdaed1
Superblock backups stored on blocks:
        32768, 98304, 163840, 229376, 294912, 819200, 884736

Allocating group tables: done
Writing inode tables: done
Creating journal (16384 blocks): done
Writing superblocks and filesystem accounting information: done

root@vbox:~# mkfs.ext4 /dev/sdd6
mke2fs 1.47.0 (5-Feb-2023)
Discarding device blocks: done
Creating filesystem with 1126911 4k blocks and 282240 inodes
Filesystem UUID: ba9381ee-5414-4ceb-9040-d133b0804775
Superblock backups stored on blocks:
        32768, 98304, 163840, 229376, 294912, 819200, 884736

Allocating group tables: done
Writing inode tables: done
Creating journal (16384 blocks): done
Writing superblocks and filesystem accounting information: done
```

A mí me sale un aviso para la partición sdd5 indicando que ya contiene un sistema de archivos, ya que la hemos redimensionado y formateado de nuevo, en mi caso indico que sí quiero proceder.:

```bash
/dev/sdd5 contains a ext4 file system
        last mounted on Mon Feb  2 10:55:05 2026
```

Seguidamente montamos las particiones lógicas redimensionadas y verificamos que se han montado correctamente:

```bash
root@vbox:~# mount /dev/sdd5 /mnt/particionsdd5
root@vbox:~# mount /dev/sdd6 /mnt/particionsdd6
root@vbox:~# lsblk -f
NAME   FSTYPE FSVER LABEL UUID                                 FSAVAIL FSUSE% MOUNTPOINTS
sda
├─sda1 ext4   1.0         b00c4602-7542-4942-befa-3720fbe84174   15,9G     9% /
├─sda2
└─sda5 swap   1           be027972-e7b3-4fe8-bf0b-d4bcc3087988                [SWAP]
sdb
├─sdb1 ext4   1.0         aba4bc72-7f9f-4be1-ad70-930b3c544d8b    4,6G     0% /mnt/disk1
└─sdb2
sdc
sdd
├─sdd1
├─sdd5 ext4   1.0         d6e45aca-89a6-4f02-be5d-0ffcd2fdaed1    3,4G     0% /mnt/particionsdd5
└─sdd6 ext4   1.0         ba9381ee-5414-4ceb-9040-d133b0804775    3,9G     0% /mnt/particionsdd6
```

Por último, verificamos el nuevo tamaño de las particiones lógicas redimensionadas:

```bash
root@vbox:~# parted /dev/sdd print
Model: ATA QEMU HARDDISK (scsi)
Disk /dev/sdd: 10,7GB
Sector size (logical/physical): 512B/512B
Partition Table: msdos
Disk Flags:

Number  Start   End     Size    Type      File system  Flags
 1      1049kB  8590MB  8589MB  extended               lba
 5      1049kB  3974MB  3973MB  logical   ext4
 6      3974MB  8590MB  4616MB  logical   ext4
```
