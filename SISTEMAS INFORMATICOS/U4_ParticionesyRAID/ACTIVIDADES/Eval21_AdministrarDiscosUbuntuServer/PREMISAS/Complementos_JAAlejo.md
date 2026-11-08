# **Complementos para Evaluable 21 - Agregados por José Ángel Alejo**

Este documento contiene información adicional y complementaria que no estaba en la premisa original del profesor, pero que considera útil para la realización y documentación de la evaluación.

---

## **INFORMACIÓN GENERAL**

- **Módulo**: Sistemas Informáticos
- **Unidad**: 4 - Particiones y RAID
- **Tipo**: Evaluación práctica (Observación directa + Documentación)
- **Plataforma**: Ubuntu Server (comandos Linux)
- **Herramientas**: lsblk, parted, mkfs, mount, fstab, mdadm, LVM (pvcreate, vgcreate, lvcreate, lvextend, lvreduce)

---

## **ESTRUCTURA RECOMENDADA PARA EL DOCUMENTO**

Cuando realices el documento con las capturas, se recomienda esta estructura para mayor claridad:

```
# Evaluable 21: Administración de Discos en Ubuntu Server

## GRUPO 1: Gestión Básica de Discos y Particiones

### Actividad 1.1: Mostrar discos con lsblk
[Captura de pantalla]
Descripción: Se muestra la lista de todos los discos disponibles en el sistema...

### Actividad 1.2: Asignar sistema msdos
[Captura de pantalla]
Descripción: Se asigna el esquema de particiones msdos (MBR) a la unidad /dev/sdb...

... (continuar con cada actividad)
```

Esto facilita la lectura y evaluación del trabajo.

---

## **REQUISITOS TÉCNICOS**

### **Sistema Operativo**

- Ubuntu Server 20.04 LTS o superior
- Acceso de usuario con permisos `sudo`

### **Discos Necesarios**

Se requiere mínimo 4-5 discos virtuales adicionales para realizar todas las actividades de RAID y LVM de forma correcta. Estos pueden ser:

- Discos virtuales en Proxmox, VirtualBox u otro hipervisor
- Discos físicos (si se dispone de hardware)

### **Herramientas Necesarias**

Algunas herramientas vienen por defecto en Ubuntu Server, pero otras requieren instalación:

```bash
# Verificar si están instaladas
which lsblk     # Generalmente incluido
which parted    # Puede requerir instalación
which mdadm      # Requiere instalación para RAID
which lvm2       # Requiere instalación para LVM
```

Para instalar las que falten:

```bash
sudo apt update
sudo apt install -y parted mdadm lvm2
```

---

## **BUENAS PRÁCTICAS**

- **Documentar mientras trabajas**
  - No dejar todas las capturas para el final.
  - Tomar screenshots inmediatamente después de ejecutar cada comando.
  - Es más fácil documentar mientras la información está "fresca".

- **Leer la salida de errores**
  - Si un comando falla, leer cuidadosamente el mensaje de error.
  - Los errores generalmente indican qué está mal y cómo solucionarlo.
  - No ignorar los warnings, pueden ser importantes.

- **Usar explicaciones claras**
  - Cada captura debe tener una breve descripción (1-2 líneas).
  - Explicar QUÉ está haciendo el comando y POR QUÉ.
  - Ayudar al evaluador a entender tu intención.

- **Probar antes de desmontar o eliminar**
  - Verificar que todo funcione antes de eliminar particiones.
  - Usar `lsblk` o `df -h` para confirmar el estado.
  - Tener cuidado con los comandos destructivos (mkfs, lvreduce, etc.).

- **Hacer copias de seguridad**
  - Aunque sea en una máquina virtual, no perder el trabajo.
  - Tener un respaldo de las screenshots en caso de accidentes.
  - Considerar exportar el trabajo frecuentemente a PDF.

---

## **ORDEN SUGERIDO DE EJECUCIÓN**

Para evitar conflictos y facilitar la documentación, se sugiere este orden:

1. **Primero**: GRUPO 1 (Gestión Básica) - Familiarizarse con los comandos básicos.
2. **Segundo**: GRUPO 2 (RAID) - Una vez dominadas las particiones, configurar RAID.
3. **Tercero**: GRUPO 3 (LVM) - Después de entender RAID, pasar a LVM.

Esta progresión permite construir conocimiento de forma incremental.

---

## **NOTAS SOBRE PENALIZACIONES**

Podrían deducirse puntos por:

- **Redacción**: Faltas de ortografía o texto poco claro
- **Presentación**: Capturas poco legibles o sin asociación clara a las actividades
- **Completitud**: Actividades incompletas no se evaluarán
- **Plazos**: Entregas tardías pueden resultar en reducción de puntuación

---

## **CÁLCULO DE LA NOTA FINAL**

La evaluación suma un total de **16 puntos**:

- Observación Directa: 10 puntos (40%)
- Autonomía: 2 puntos (13%)
- Funcionamiento de Comandos: 3 puntos (19%)
- Presentación: 1 punto (6%)
- Resto: 0 puntos (no hay puntuación extra)

**Para convertir a escala 0-10:**

```
Nota Final = (Puntos obtenidos / 16) × 10
```

- **Ejemplos:**
  - 16 puntos → 10.0
  - 12 puntos → 7.5
  - 8 puntos → 5.0
  - 4 puntos → 2.5
  - 0 puntos → 0.0

---

## **PREGUNTAS FRECUENTES**

**¿Puedo usar un disco con datos?**
No. Todos los comandos deben ejecutarse en discos nuevos o vacíos sin información importante.

**¿Puedo saltarme alguna actividad?**
No se recomienda. La rúbrica evalúa el funcionamiento de los comandos, que requiere completar todas las actividades.

**¿Qué pasa si un comando falla?**
Documentar el fallo, leer el error, intentar solucionar el problema y volver a intentar. Mostrar cómo resolver problemas también es valorado en "Autonomía".

**¿Puedo hacer todo desde la interfaz gráfica en lugar de comandos?**
No. La evaluación específicamente pide comandos de Linux en terminal.

**¿Cuánto tiempo debería tardar esto?**
Depende de la experiencia del usuario con Linux. Estimadamente 6-8 horas de trabajo, pero puede variar.

---

## **INFORMACIÓN SOBRE LA ENTREGA**

### **Nombre del Archivo**

El documento final debe ser guardado con el siguiente nombre:

- `Eval21_AdministrarDiscosUbuntuServer_JAAlejo.md` (si se entrega en Markdown)
- `Eval21_AdministrarDiscosUbuntuServer_JAAlejo.pdf` (si se convierte a PDF)

### **Contenido Esperado en la Entrega**

El documento debe incluir:

- Título y autor (José Ángel Alejo Sillero)
- Tabla de contenidos (opcional pero recomendado)
- Tres secciones principales: GRUPO 1, GRUPO 2, GRUPO 3
- Para cada actividad: captura de pantalla + descripción
- Conclusión breve resumiendo lo realizado

### **Estructura Recomendada del Documento**

- Usar esta estructura para mantener claridad y facilitar la evaluación:
  - Encabezado: Título y metadata
  - Tabla de contenidos: Enlaces internos a cada grupo
  - GRUPO 1: Subdivisiones para cada actividad (1.1, 1.2, etc.)
  - GRUPO 2: Subdivisiones para cada actividad (2.1, 2.2, etc.)
  - GRUPO 3: Subdivisiones para cada actividad (3.1, 3.2, etc.)
  - Conclusión o resumen final

- Cada subsección de actividad debe incluir:
  - Título claro de la actividad
  - Captura de pantalla mostrando: consola, comando ejecutado, resultado
  - Descripción breve (1-2 líneas) explicando qué se está haciendo

### **Detalles de la Rúbrica Original**

Ten en cuenta que la rúbrica del profesor evalúa 4 criterios principales:

1. **Observación Directa en Clase** (hasta 10 puntos distribuidos): Cómo trabajas durante la realización en clase, tu constancia, concentración e interés.
2. **Autonomía en la Ejecución** (2 puntos): Capacidad de resolver problemas sin ayuda directa y de investigar soluciones independientemente.
3. **Funcionamiento de los Comandos** (3 puntos): Que todos los comandos ejecutados funcionen correctamente sin errores.
4. **Presentación del Proyecto** (1 punto): Claridad, orden y buena redacción de la documentación.

**Total: 16 puntos** (escala convertible a 0-10).

---

**Documento de apoyo creado por José Ángel Alejo Sillero**
**Fecha de creación**: 3 de febrero de 2026
