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
- Volumen Distribuido: suma discos, sin redundancia ni mejora rendimiento.

> **Notas prácticas**

- /etc/fstab: añade una línea para montaje automático, ejemplo:
  `/dev/sdb1 /mnt/disco1 ext4 defaults 0 2`
- Flujo LVM: `pvcreate` → `vgcreate` → `lvcreate` → `mkfs` → `mount`
- Extender LVM: `lvextend` y `resize2fs` (o `xfs_growfs`)
- RAID con mdadm: usa `mdadm --create`, `mdadm --detail`, `mdadm --stop`
- Usa `lsblk` y `df -h` para verificar discos, particiones y puntos de montaje.
