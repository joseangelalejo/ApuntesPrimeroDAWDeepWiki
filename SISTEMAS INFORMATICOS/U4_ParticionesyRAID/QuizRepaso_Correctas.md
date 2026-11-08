# Quiz de Repaso - Particiones y RAID

## Fichas de estudio (ordenadas)

### 1. ¿Qué comando permite eliminar un grupo de volúmenes en LVM?

- vgremove ✓

### 2. ¿Qué comando permite listar los volúmenes lógicos existentes?

- lvs ✓

### 3. El nivel de RAID conocido como reflejado o mirroring es __________

**Respuesta:** 1

### 4. El comando utilizado para crear un grupo de volúmenes en LVM es __________

**Respuesta:** vgcreate

### 5. ¿Qué comando permite mostrar información de un disco específico como /dev/sdb?

- parted /dev/sdb print ✓

### 6. El volumen creado dentro de un grupo de volúmenes en Linux se denomina __________

**Respuesta:** volumen lógico

### 7. Además de tener tabla de particiones, es obligatorio _________ la partición

**Respuesta:** formatear

### 8. Si la primera partición termina en 1048MiB, la segunda debería comenzar en __________

**Respuesta:** 1049

### 9. ¿Qué comando permite montar el volumen RAID creado en un directorio?

- mount /dev/md0 /mnt/raid5 ✓

### 10. El comando utilizado para limpiar la cabecera RAID de un disco es __________

**Respuesta:** dmraid

### 11. ¿Qué comando permite ver los volúmenes físicos en LVM?

- pvs ✓

### 12. El nivel de RAID también conocido como 1+0 es __________

**Respuesta:** 10

### 13. ¿Cuál es una limitación principal del esquema MBR?

- Solo admite hasta 3 particiones primarias y una extendida ✓

### 14. ¿Qué característica principal tiene RAID 0?

- Mejora el rendimiento pero no ofrece tolerancia a fallos ✓

### 15. En el comando mkpart primary ext4 1MiB 500MiB, ext4 indica el tipo de __________ de la partición

**Respuesta:** sistema de archivos

### 16. ¿Qué comando permite redimensionar una partición con parted?

- parted /dev/sdX resizepart 1 3000MiB ✓

### 17. El dispositivo que se crea como volumen RAID en el ejemplo es __________

**Respuesta:** que ejemplo bro xd

### 18. ¿Cuál es el objetivo principal de utilizar RAID?

- Mejorar el rendimiento, la seguridad de los datos o ambas cosas ✓

### 19. ¿Qué comando de parted se utiliza para eliminar una partición existente?

- parted /dev/sdX rm 1 ✓

### 20. ¿Qué comando permite ver el valor End de una partición existente?

- parted /dev/sdc print ✓

### 21. El nivel de RAID conocido como seccionado o striping es __________

**Respuesta:** 0

### 22. El RAID que requiere un mínimo de cuatro discos al combinar RAID 1 y RAID 0 es __________

**Respuesta:** RAID 10

### 23. ¿Qué parámetro en mdadm indica el número de discos que formarán el RAID?

- --raid-devices ✓

### 24. Comando que instala LVM en Línux

**Respuesta:** sudo apt-get install lvm2

### 25. ¿Qué representa el directorio /mnt en Linux?

- Un punto de montaje temporal para dispositivos ✓

### 26. ¿Qué comando permite montar un volumen lógico LVM en un directorio?

- mount /dev/grupo1/volumen1 /mnt/lvm ✓

### 27. ¿Dónde se crean las particiones lógicas?

- Dentro de una partición extendida ✓

### 28. ¿Qué comando permite crear una segunda partición primaria ext4 desde 1048MiB hasta 2000MiB?

**Respuesta:** mkpart primary ext4 1048 2000

### 29. ¿Qué es LVM en Linux?

- Un sistema de gestión de volúmenes lógicos ✓

### 30. ¿Qué nivel de RAID no ofrece tolerancia a fallos y prioriza únicamente el rendimiento?

- RAID 0 ✓

### 31. ¿Qué es una partición en un disco duro?

- Una división lógica dentro de un disco físico ✓

### 32. Después de crear el RAID (por ejemplo /dev/md0), es necesario formatearlo con el comando __________

**Respuesta:** mkfs.ext4

### 33. ¿Qué RAID requiere un mínimo de cuatro discos para su implementación?

- RAID 10 ✓

### 34. Si falla un disco y se pueden reconstruir los datos mediante paridad, estamos ante?

- RAID 5 ✓

### 35. ¿Qué ventaja ofrece GPT frente a MBR?

- Permite crear más particiones y soporta discos de mayor tamaño ✓

### 36. ¿Qué nivel de RAID utiliza efecto espejo copiando exactamente los datos en dos discos?

- RAID 1 ✓

### 37. Los discos __________ ofrecen mayor flexibilidad en la gestión del almacenamiento

**Respuesta:** dinámicos

### 38. El RAID que proporciona tolerancia a fallos copiando los datos en dos discos idénticos es __________

**Respuesta:** RAID 1

### 39. ¿Cómo distribuye los datos RAID 0?

- Mediante striping entre varios discos ✓

### 40. Antes de eliminar un RAID montado, es necesario desmontarlo con el comando __________

**Respuesta:** umount

### 41. Antes de crear un RAID con mdadm, se recomienda limpiar la tabla de particiones con el comando __________

**Respuesta:** wipefs

### 42. El parámetro utilizado en lvcreate para indicar el tamaño de 2GB es __________

**Respuesta:** -L

### 43. El comando completo para crear un volumen lógico llamado datos de 2GB en el grupo grupo1 es __________

**Respuesta:** lvcreate -L 2G -n datos grupo1

### 44. ¿Qué significa RAID?

- Redundant Array of Independent Disks ✓

### 45. Una partición lógica necesita estar dentro de una partición ________

**Respuesta:** extendida

### 46. El comando de parted que permite crear una nueva tabla de particiones en un disco es __________

**Respuesta:** mklabel

### 47. El sistema que primero llena un disco y luego continúa con el siguiente, sin ofrecer seguridad ni mejora de velocidad, es __________

**Respuesta:** JBOD

### 48. El comando completo para crear un grupo de volúmenes (sdb1 y sdc1) llamado grupo1 es __________

**Respuesta:** vgcreate grupo1 /dev/sdv1 /dev/sdc1

### 49. El RAID que requiere como mínimo tres discos para funcionar es __________

**Respuesta:** RAID 5

### 50. El comando utilizado para crear un sistema de archivos ext4 en una partición es __________

**Respuesta:** mkfs.ext4

### 51. ¿Qué significa VG en LVM?

**Respuesta:** volume group

### 52. ¿Qué comando permite crear un volumen lógico de 2GB en LVM en el grupo 1?

- lvcreate -L 2G -n volumen1 grupo1 ✓

### 53. En el comando mdadm --create --verbose /dev/md0 --level=0 --raid-devices=2 /dev/sdc /dev/sdd, el parámetro que indica el nivel RAID es __________

**Respuesta:** --level=0

### 54. ¿Cuál es la principal diferencia entre un disco básico y un disco dinámico en Windows?

- El dinámico permite crear volúmenes que abarcan varios discos y el básico usa particiones tradicionales ✓

### 55. ¿Qué palabra se puede usar en lugar de primary para crear una partición extendida en MBR?

- extended ✓

### 56. El nivel de RAID que utiliza paridad para poder reconstruir los datos si falla un disco es __________

**Respuesta:** RAID 5

### 57. ¿Con qué esquemas de partición pueden gestionarse los discos básicos?

- MBR o GPT ✓

### 58. El RAID que crea espejos y después distribuye los datos entre ellos es __________

**Respuesta:** RAID 10

### 59. El archivo donde se configura el montaje automático de particiones en Linux es __________

**Respuesta:** fstab

### 60. El nivel de RAID que copia exactamente los mismos datos en dos discos (efecto espejo) es __________

**Respuesta:** RAID 10

### 61. ¿Qué comando se utiliza en Linux para crear un RAID por software?

- mdadm ✓

### 62. ¿Qué comando permite crear una partición primaria ext4 de 1MiB a 500MiB con parted?

- parted /dev/sdX mkpart primary ext4 1MiB 500MiB ✓

### 63. El tipo de almacenamiento que suma discos uno detrás de otro como si fueran uno solo grande y no es RAID se llama __________

**Respuesta:** JBOD

### 64. Después de crear el volumen lógico, el sistema de archivos se crea con el comando __________

**Respuesta:** mkfs.ext4

### 65. El RAID que prioriza el rendimiento sobre la tolerancia a fallos es __________

**Respuesta:** RAID 0

### 66. ¿Qué ventaja ofrecen los discos dinámicos respecto a la gestión del espacio?

- Permiten extender o reducir volúmenes sin eliminar datos ✓

### 67. ¿Qué permiten hacer los discos dinámicos en Windows que no permiten los discos básicos?

- Crear volúmenes que abarcan varios discos físicos ✓

### 68. El comando de parted utilizado para cambiar el tamaño de una partición es __________

**Respuesta:** resizepart

### 69. Si queremos crear un RAID 1 en lugar de RAID 0 con mdadm, el parámetro que india el nivel de RAID 1 correcto sería __________

**Respuesta:** --level=1

### 70. ¿Qué comando se utiliza para detener un RAID activo en Linux?

- mdadm --stop /dev/md0 ✓

### 71. ¿Qué comando en Linux muestra los discos y particiones en forma de árbol?

- lsblk ✓

### 72. El tipo de RAID que mantiene el sistema funcionando aunque falle un disco es __________

**Respuesta:** RAID 1, RAID 5 y RAID 10

### 73. El nivel de RAID que permite recuperar la información tras el fallo de un disco gracias a la paridad es __________

**Respuesta:** RAID 5

### 74. ¿Qué comando se utiliza para convertir particiones en volúmenes físicos en LVM?

- pvcreate ✓

### 75. ¿Qué tipo de configuraciones RAID soportan los discos dinámicos por software?

- Espejados, seccionados y RAID-5 ✓

### 76. ¿Qué comando se utiliza en Linux para crear un RAID por software?

- mdadm ✓

### 77. El RAID que reparte los datos entre varios discos para aumentar la velocidad, pero no ofrece seguridad, es __________

**Respuesta:** RAID 0

### 78. MBR tiene un límite aproximado de tamaño de disco de ________ TB

**Respuesta:** 2

### 79. El componente de LVM que representa una partición o disco convertido para usarse en LVM es __________

**Respuesta:** pv

### 80. ¿Qué comando se utiliza en Linux para crear una tabla de particiones en un disco con parted?

- parted /dev/sdb mklabel gpt ✓

### 81. El comando utilizado para eliminar un volumen lógico es __________

**Respuesta:** lvremove

### 82. ¿Qué comando permite identificar los discos antes de crear una partición?

- lsblk ✓

### 83. ¿Qué comando permite crear un volumen lógico dentro de un grupo de volúmenes?

- lvcreate ✓

### 84. En el comando parted /dev/sdX mkpart primary ext4 1MiB 500MiB, la palabra primary indica que la partición será __________

**Respuesta:** principal, primaria

### 85. Antes de montar una partición, es necesario crear un punto de montaje en el directorio ___________

**Respuesta:** mnt

### 86. El comando utilizado para eliminar un volumen físico de LVM es __________

**Respuesta:** pvremove

### 87. ¿Cuál es la función principal de una partición extendida?

- Actuar como contenedor de particiones lógicas ✓

### 88. Si en un RAID ____ se rompe un disco, se pierden todos los datos

**Respuesta:** RAID 0

### 89. ¿Qué representa el archivo /dev/sda en un sistema Linux?

- Un disco duro completo ✓

### 90. El tipo de RAID que pierde toda la información si falla un solo disco es __________

**Respuesta:** RAID 0

### 91. ¿Cuál es el tipo de almacenamiento predeterminado en Windows?

- Discos básicos ✓

### 92. ¿Qué característica diferencia a un volumen en discos dinámicos?

- Puede abarcar varios discos físicos ✓

### 93. ¿Qué comando se utiliza para desmontar una partición montada?

- umount /mnt/Disco1 ✓

### 94. ¿Qué comando se utiliza para montar manualmente una partición en Linux?

- mount /dev/sdX1 /mnt/Disco1 ✓

### 95. Para poder usar una partición en Linux es necesario que el disco tenga una tabla de particiones como __________ o GPT

**Respuesta:** MBR

### 96. El tipo de RAID que combina rendimiento y seguridad mediante paridad distribuida es __________

**Respuesta:** RAID 5

### 97. El comando utilizado para mostrar los grupos de volúmenes es __________

**Respuesta:** lsblk -f

### 98. En Linux, el directorio donde se encuentran los archivos especiales que representan dispositivos del sistema es __________

**Respuesta:** /etc

### 99. ¿Qué parámetro de mdadm indica el nivel de RAID que se va a crear?

- --level ✓

### 100. ¿Qué representa normalmente /dev/sda1?

- La primera partición del disco sda ✓

### 101. El nivel de RAID que combina striping (RAID 0) y mirroring (RAID 1) es __________

**Respuesta:** RAID 10

### 102. El almacenamiento que no mejora el rendimiento ni ofrece redundancia y no es un nivel RAID es __________

**Respuesta:** Volumen Distribuido

### 103. ¿Qué comando se utiliza en Linux para formatear una partición con el sistema de archivos ext4?

- mkfs.ext4 ✓

### 104. El tipo de RAID que ofrece alto rendimiento y tolerancia a fallos combinando espejo y seccionado es __________

**Respuesta:** RAID 5

### 105. En la salida de lsblk, el campo SIZE indica el ________ del dispositivo o partición

**Respuesta:** tamaño

### 106. El RAID que ofrece máxima seguridad mediante duplicación de datos es __________

**Respuesta:** RAID 2

### 107. ¿Qué característica define a una partición primaria?

- Puede contener un sistema operativo y arrancar el sistema ✓

### 108. En parted, para eliminar la partición número 2 se utiliza el comando __________

**Respuesta:** delete partition override

### 109. En Linux, el directorio que se utiliza habitualmente para montar manualmente particiones es __________

**Respuesta:** /mnt

### 110. El RAID que ofrece tolerancia a fallos sin perder tanta capacidad como en RAID 1 es __________

**Respuesta:** RAID 5

### 111. El tipo de volumen que permite unir discos de distintos tamaños sin tolerancia a fallos es __________

**Respuesta:** Volumen Distribuido

### 112. ¿Cuál de los siguientes es un tipo de partición?

- Primaria ✓

### 113. ¿Qué nivel de RAID combina striping y mirroring para ofrecer alto rendimiento y tolerancia a fallos?

- RAID 10 ✓

### 114. El nivel de RAID que mejora el rendimiento mediante striping pero no ofrece tolerancia a fallos es __________

**Respuesta:** RAID 0

### 115. El nivel de RAID que distribuye bloques de datos entre varios discos sin paridad ni espejo es __________

**Respuesta:** RAID 1

### 116. ¿Qué comando se utiliza en LVM para crear un grupo de volúmenes?

- vgcreate grupo1 /dev/sdb1 /dev/sdc1 ✓

### 117. ¿Qué utilizan los discos básicos para organizar el espacio?

- Particiones primarias, extendidas y lógicas ✓

### 118. ¿Qué nivel de RAID utiliza paridad distribuida y requiere al menos tres discos?

- RAID 5 ✓

### 119. Antes de crear una segunda partición con parted, es necesario conocer el valor __________ de la partición anterior

**Respuesta:** size

### 120. RAID combina varios ________ para que trabajen como una sola unidad

**Respuesta:** discos

### 121. ¿Qué comando para un RAID existente en /dev/md1?

- mdadm --stop /dev/md1 ✓
