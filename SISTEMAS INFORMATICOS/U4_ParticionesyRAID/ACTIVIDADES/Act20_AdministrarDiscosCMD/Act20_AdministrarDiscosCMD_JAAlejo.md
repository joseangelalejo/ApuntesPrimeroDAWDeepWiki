# Act20 Administrar Discos con CMD - JAAlejo

- **Autor**: José Ángel Alejo Sillero
- **Centro**: Instituto Tecnológico Pablo de la Torre
- **Curso**: 2025/2026
- **Módulo**: Sistemas Informáticos
- **Unidad**: 4 - Particiones y RAID

---
<div style="page-break-after: always;"></div>

- Formateo de un disco con Diskpart
  - Abre la consola de comandos y accede a Diskpart.
  - Lista los discos disponibles en el sistema.
    - ![Discos disponibles en el sistema](IMAGENES/1_FormatearDiscoDiskpart/1_DiscosIniciales.png)
  - Selecciona el disco que deseas formatear.
  - Limpia completamente el disco seleccionado.
  - Crea una nueva partición primaria en el disco.
  - Formatea la partición en NTFS.
  - Asigna una letra de unidad a la nueva partición.
  - Sal de Diskpart.
  - ![alt text](IMAGENES/1_FormatearDiscoDiskpart/2_RestodeComandos.png)

- Creación de una partición (MBR)
  - Inicia Diskpart desde la consola de comandos.
  - Lista los discos disponibles y selecciona aquel donde deseas crear la partición.
  - Crea 3 partición primaria, extendida y una lógica.
  - Asigna una letra de unidad a la partición creada.
    - ![alt text](IMAGENES/2_CrearParticionMBR/Paso1_CrearParticiones.png)
  - Muestra la partición creada.
  - Sal de Diskpart.
    - ![alt text](IMAGENES/2_CrearParticionMBR/Paso2_MostrarParticion.png)

- Creación de una partición (GPT)
  - Convierte un disco a sistemas de particiones GPT
  - Muestra en consola el sistema de particiones que tiene.
    - ![alt text](IMAGENES/3_CrearParticionGPT/Paso1.png)
  - Crea 4 particiones primarias
  - Muestras las particiones
  - Sal de Diskpart.
    - ![alt text](IMAGENES/3_CrearParticionGPT/Paso2.png)

- Extensión de un volumen
  - Accede a Diskpart desde la consola de comandos.
  - Lista los volúmenes disponibles en el sistema.
  - Selecciona el volumen que deseas extender.
    - ![alt text](IMAGENES/4_ExtensiondeVolumen/Paso1_SeleccionarVolumen.png)
  - Extiende el volumen utilizando todo el espacio disponible o un tamaño específico.
  - Sal de Diskpart.
  - ![alt text](IMAGENES/4_ExtensiondeVolumen/Paso2_ListarVolumenes.png)

- Reducción de un volumen
  - Abre Diskpart y lista los volúmenes del sistema.
  - Selecciona el volumen que deseas reducir.
  - Reduce el volumen en una cantidad específica de megabytes.
  - Sal de Diskpart.
  - ![alt text](IMAGENES/5_ReducciondeVolumen/ReducirVolumen.png)

- Eliminación de un volumen
  - Abre Diskpart y lista los volúmenes disponibles en el sistema.
  - Selecciona el volumen creado anteriormente.
  - Elimina el volumen seleccionado.
  - Sal de Diskpart.
  - ![alt text](IMAGENES/6_EliminarVolumen/EliminarVolumen.png)

Entrega: Capturas de pantalla de cada uno de los procesos realizados en un documento .pdf
