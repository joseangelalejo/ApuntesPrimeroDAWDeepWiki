# Repaso Examen: Particiones y RAID

> **Comandos clave**

| Acción                         | Comando/Ejemplo                                 |
|--------------------------------|-------------------------------------------------|
| Eliminar grupo volúmenes LVM   | vgremove                                        |
| Listar volúmenes lógicos LVM   | lvs                                             |
| Crear grupo volúmenes LVM      | vgcreate grupo1 /dev/sdb1 /dev/sdc1             |
| Crear volumen lógico           | lvcreate -L 2G -n datos grupo1                  |
| Ver volúmenes físicos LVM      | pvs                                             |
| Montar volumen RAID            | mount /dev/md0 /mnt/raid5                       |
| Limpiar cabecera RAID          | dmraid                                          |
| Crear sistema de archivos ext4 | mkfs.ext4 /dev/sdX1                             |
| Crear partición con parted     | parted /dev/sdX mkpart primary ext4 1MiB 500MiB |
| Redimensionar partición        | parted /dev/sdX resizepart 1 3000MiB            |
| Eliminar partición             | parted /dev/sdX rm 1                            |
| Ver discos y particiones       | lsblk                                           |
| Detener RAID                   | mdadm --stop /dev/md0                           |

> **Niveles RAID**

| Nivel | Nombre                | Característica principal             | Discos mínimos | Resumen                          |
|-------|-----------------------|--------------------------------------|----------------|----------------------------------|
| 0     | Striping              | Rendimiento, sin tolerancia a fallos | 2              | Solo rendimiento, no seguridad   |
| 1     | Mirroring             | Espejo, tolerancia a fallos          | 2              | Espejo, seguridad                |
| 5     | Paridad               | Rendimiento + tolerancia a fallos    | 3              | Paridad, seguridad y rendimiento |
| 10    | 1+0 (espejo+striping) | Alto rendimiento y seguridad         | 4              | Combina espejo y striping        |

> **Conceptos básicos**

- MBR: máx. 4 particiones primarias (o 3 + 1 extendida), hasta 2TB.
- GPT: más particiones, soporta discos grandes.
- Partición lógica: dentro de extendida.
- /mnt: punto de montaje temporal.
- LVM: gestión flexible de volúmenes.
- JBOD: suma discos, sin redundancia ni mejora rendimiento.

> **Particionado y gestión de discos**

- parted: crear/eliminar/redimensionar particiones
  - Ej: `parted /dev/sdb mklabel msdos`, `parted /dev/sdb mkpart primary ext4 1MiB 500MiB`, `parted /dev/sdb rm 1`
- mkfs: formatear partición (`mkfs.ext4 /dev/sdb1`, `mkfs.xfs /dev/sdb1`)
- mount/umount: montar/desmontar (`mount /dev/sdb1 /mnt/disco1`, `umount /mnt/disco1`)
- /etc/fstab: añadir línea para montaje automático
- lsblk, df -h: ver discos, particiones y puntos de montaje

> **RAID con mdadm (resumen)**

- Crear RAID 0: `mdadm --create /dev/md0 --level=0 --raid-devices=2 /dev/sdb1 /dev/sdc1`
- Crear RAID 1: `mdadm --create /dev/md1 --level=1 --raid-devices=2 /dev/sdd1 /dev/sde1`
- Crear RAID 5: `mdadm --create /dev/md5 --level=5 --raid-devices=3 /dev/sdf1 /dev/sdg1 /dev/sdh1`
- Crear RAID 10: `mdadm --create /dev/md10 --level=10 --raid-devices=4 /dev/sdi1 /dev/sdj1 /dev/sdk1 /dev/sdl1`
- Ver estado: `mdadm --detail /dev/md0`
- Detener RAID: `mdadm --stop /dev/md0`

> **LVM (flujo básico)**

1. Crear volumen físico: `pvcreate /dev/sdb1`
2. Crear grupo de volúmenes: `vgcreate grupo1 /dev/sdb1`
3. Crear volumen lógico: `lvcreate -L 2G -n datos grupo1`
4. Formatear: `mkfs.ext4 /dev/grupo1/datos`
5. Montar: `mount /dev/grupo1/datos /mnt/lvm`
6. Extender: `lvextend -L +1G /dev/grupo1/datos` y `resize2fs /dev/grupo1/datos`
7. Reducir: `lvreduce -L 1G /dev/grupo1/datos` y `resize2fs /dev/grupo1/datos`
