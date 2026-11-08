# **Evaluable 21: Administración de Discos en Ubuntu Server**

## **ACTIVIDADES A REALIZAR**

### **GRUPO 1: Gestión Básica de Discos y Particiones**

Realiza las siguientes operaciones en Ubuntu Server utilizando comandos de línea de comandos:

1. **Mostrar discos del sistema** con `lsblk`
2. **Asignar un sistema de particiones msdos** (MBR) a una unidad disponible
3. **Crear 3 particiones primarias** en un disco disponible usando `parted`
4. **Crear 1 partición extendida y 2 particiones lógicas** en el mismo disco
5. **Formatear una unidad de almacenamiento** con un sistema de archivos específico usando `mkfs`
   - Puede ser: ext4, ext3, btrfs, xfs, o ntfs
6. **Montar una unidad** y asignarle un punto de montaje usando `mount`
7. **Configurar montaje automático** en `/etc/fstab`
8. **Verificar el punto de montaje** con `lsblk` o `df -h`

---

### **GRUPO 2: Configuración de RAID con mdadm**

Realiza las siguientes operaciones de RAID en Ubuntu Server:

1. **Configurar un RAID 0** (seccionado) con `mdadm`
2. **Configurar un RAID 1** (reflejado) con `mdadm`
3. **Configurar un RAID 5** con `mdadm`
4. **Configurar un RAID 10** con `mdadm`
5. **Desmontar un volumen reflejado** (RAID 1) y **eliminar el reflejo** con `mdadm`
6. **Añadir un reflejo** a un volumen existente con `mdadm`
7. **Sustituir un disco defectuoso** en una configuración RAID sin perder datos usando `mdadm`
8. **Configurar el montaje automático** de discos RAID en `/etc/fstab`
9. **Verificar el estado** de los discos y volúmenes RAID con `lsblk` y `mdadm --detail`
10. **Desmontar** la unidad RAID
11. **Eliminar una partición** utilizada en RAID

---

### **GRUPO 3: Gestión de Volúmenes Lógicos (LVM)**

Realiza las siguientes operaciones con LVM (Logical Volume Manager):

1. **Crear un volumen lógico** utilizando:
   - `pvcreate` (crear volumen físico)
   - `vgcreate` (crear grupo de volúmenes)
   - `lvcreate` (crear volumen lógico)
2. **Aumentar el tamaño** de un volumen lógico usando:
   - `lvextend` (extender el volumen)
   - `resize2fs` o `xfs_growfs` (redimensionar el sistema de archivos)
3. **Reducir el tamaño** de un volumen lógico usando:
   - `lvreduce` (reducir el volumen)
   - `resize2fs` (redimensionar el sistema de archivos)
4. **Redimensionar una partición** existente

---

## **MODO DE ENTREGA**

En un documento, realiza capturas de pantalla de cada actividad, mostrando la consola de Linux, el comando utilizado y el resultado que muestra después de ejecutar la operación.

---

## **RÚBRICA DE EVALUACIÓN**

### **1. Observación Directa en Clase /10**

| Calificación     | Puntos | Criterios                                                                                                                                                                 |
|------------------|--------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Excelente**    | **4**  | Trabaja de manera constante en clase, avanza sin distracciones y demuestra interés genuino en la actividad. Realiza preguntas pertinentes y busca mejorar constantemente. |
| **Bueno**        | **3**  | Trabaja bien en clase, aunque con algunas pausas o distracciones leves. Mantiene un ritmo de trabajo aceptable y completa la mayoría de las tareas asignadas.             |
| **Regular**      | **2**  | Se distrae con frecuencia y avanza poco en la actividad sin ayuda. Necesita intervención constante del docente para mantener el enfoque.                                  |
| **Insuficiente** | **0**  | No avanza en clase o muestra desinterés en la actividad. No participa activamente ni realiza esfuerzo visible.                                                            |

---

### **2. Autonomía en la Ejecución /2**

| Calificación     | Puntos | Criterios                                                                                                                                                  |
|------------------|--------|------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Excelente**    | **2**  | Realiza el trabajo sin ayuda, investiga soluciones de forma independiente y soluciona problemas por su cuenta. Consulta documentación cuando es necesario. |
| **Bueno**        | **1**  | Necesita orientación mínima, pero desarrolla bien el proyecto. Es capaz de resolver problemas después de recibir guía inicial del docente.                 |
| **Insuficiente** | **0**  | No avanza sin la intervención directa y constante del docente. Requiere explicaciones paso a paso para cada tarea.                                         |

---

### **3. Funcionamiento de los Comandos /3**

| Calificación     | Puntos | Criterios                                                                                                                                                                    |
|------------------|--------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Excelente**    | **3**  | Todos los comandos funcionan correctamente en la terminal sin errores. La sintaxis es correcta y los resultados son los esperados en todas las actividades.                  |
| **Bueno**        | **2**  | La mayoría de los comandos funcionan correctamente, pero algunos presentan fallos menores o errores que se corriges posteriormente. El 80%+ de las operaciones son exitosas. |
| **Insuficiente** | **0**  | La mayoría de los comandos están incorrectos o no se pueden ejecutar. Menos del 50% de las operaciones funcionan correctamente. Hay errores sintácticos o lógicos graves.    |

---

### **4. Presentación del Proyecto /1**

| Calificación     | Puntos | Criterios                                                                                                                                                                             |
|------------------|--------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Excelente**    | **1**  | La documentación es clara, ordenada y bien redactada. Usa capturas de pantalla de forma efectiva para respaldar la información. Tiene índice, estructura lógica y es fácil de seguir. |
| **Insuficiente** | **0**  | Falta organización y claridad en la presentación. Contiene errores de redacción, las capturas son poco legibles o no están bien asociadas a las actividades. Estructura confusa.      |

---

## **TOTAL PUNTUACIÓN: /16**

- Observación Directa: 10 puntos (siendo /4 el máximo en cada nivel)
- Autonomía: 2 puntos
- Funcionamiento de Comandos: 3 puntos
- Presentación: 1 punto

---

## **NOTAS IMPORTANTES**

Para obtener más detalles sobre requisitos técnicos, estructura recomendada del documento, buenas prácticas y preguntas frecuentes, consultar el archivo complementario: **Complementos_JAAlejo.md**

---

**Premisa oficial del Evaluable 21**  

---

## Requisitos post-entrega inicial

Tras la entrega inicial, el profesor ha añadido los siguientes requisitos adicionales relacionados con la gestión avanzada de volúmenes lógicos (LVM):

- Crear un volumen lógico utilizando LVM (`pvcreate`, `vgcreate`, `lvcreate`).
- Aumentar el tamaño de un volumen lógico con `lvextend`.
- Reducir el tamaño de un volumen lógico con `lvreduce`.
- Mostrar los volúmenes lógicos, físicos y los grupos de volúmenes (`pvs`, `vgs`, `lvs`).
- Eliminar un volumen lógico.
- Eliminar un grupo de volúmenes.
- Eliminar un volumen físico.

Estos requisitos deben ser implementados y documentados tras la entrega inicial de la actividad.

**Asignatura**: Sistemas Informáticos  
**Unidad**: 4 - Particiones y RAID
