# **Premisa para Generación de Mensajes de Commit - José Ángel Alejo Sillero**

Esta guía define el formato estándar y recomendaciones para generar mensajes de commit en el repositorio MisApuntesITPDAW. Utiliza esta premisa al solicitar a una IA que genere un mensaje de commit apropiado.

---

## **TABLA DE CONTENIDOS**

- [**Premisa para Generación de Mensajes de Commit - José Ángel Alejo Sillero**](#premisa-para-generación-de-mensajes-de-commit---josé-ángel-alejo-sillero)
  - [**TABLA DE CONTENIDOS**](#tabla-de-contenidos)
  - [**1. ESTRUCTURA GENERAL**](#1-estructura-general)
    - [**Ejemplo Completo**](#ejemplo-completo)
  - [**2. TIPO DE COMMIT**](#2-tipo-de-commit)
  - [**3. ÁMBITO (SCOPE)**](#3-ámbito-scope)
    - [**Ámbitos Principales**](#ámbitos-principales)
    - [**Formato**](#formato)
  - [**4. DESCRIPCIÓN BREVE**](#4-descripción-breve)
    - [**Reglas**](#reglas)
    - [**Ejemplos**](#ejemplos)
  - [**5. CUERPO DEL COMMIT (OPCIONAL)**](#5-cuerpo-del-commit-opcional)
    - [**Formato del Cuerpo**](#formato-del-cuerpo)
    - [**Ejemplo de Cuerpo**](#ejemplo-de-cuerpo)
    - [**Cuándo INCLUIR el cuerpo**](#cuándo-incluir-el-cuerpo)
    - [**Cuándo OMITIR el cuerpo**](#cuándo-omitir-el-cuerpo)
  - [**6. EJEMPLOS REALES**](#6-ejemplos-reales)
    - [**Ejemplo 1: Commit Complejo (con cuerpo)**](#ejemplo-1-commit-complejo-con-cuerpo)
    - [**Ejemplo 2: Commit de Estilo**](#ejemplo-2-commit-de-estilo)
    - [**Ejemplo 3: Commit de Configuración**](#ejemplo-3-commit-de-configuración)
    - [**Ejemplo 4: Commit Simple (sin cuerpo)**](#ejemplo-4-commit-simple-sin-cuerpo)
    - [**Ejemplo 5: Commit de Múltiples Funcionalidades**](#ejemplo-5-commit-de-múltiples-funcionalidades)
  - [**7. PATRONES A SEGUIR**](#7-patrones-a-seguir)
    - [**Patrón para Nuevas Actividades/Ejercicios**](#patrón-para-nuevas-actividadesejercicios)
    - [**Patrón para Correcciones de Base de Datos**](#patrón-para-correcciones-de-base-de-datos)
    - [**Patrón para Mejoras de Código**](#patrón-para-mejoras-de-código)
  - [**8. LO QUE NO HACER**](#8-lo-que-no-hacer)
  - [**9. PASOS PARA USAR ESTA PREMISA**](#9-pasos-para-usar-esta-premisa)
    - [**Cuando solicites un mensaje de commit a una IA:**](#cuando-solicites-un-mensaje-de-commit-a-una-ia)
    - [**Ejemplo de Solicitud a una IA:**](#ejemplo-de-solicitud-a-una-ia)
  - [**REFERENCIAS**](#referencias)

---

## **1. ESTRUCTURA GENERAL**

Los mensajes de commit siguen el estándar de **Conventional Commits** adaptado al español:

```markdown
<tipo>(<ámbito>): <descripción breve>

* <cambio detallado 1>
* <cambio detallado 2>
* <cambio detallado 3>
```

### **Ejemplo Completo**

```markdown
feat(base de datos): agregar columnas y restricciones en Polo Norte siguiendo premisas del profesor

* Añadir columna 'jefe' a la tabla 'elfo'.
* Añadir columna 'edad' a la tabla 'niño'.
* Añadir restricción CHECK a la columna 'edad' en 'niño'.
* Cambiar el nombre de la columna 'personas' a 'niños' en la tabla 'casa'.
* Modificar el tipo de dato de la columna 'tiempo' en 'fabricacion' a DECIMAL para mayor precisión.
```

---

## **2. TIPO DE COMMIT**

El tipo debe ser uno de los siguientes (Conventional Commits):

| Tipo         | Descripción                              | Cuándo usar                                                                         |
|--------------|------------------------------------------|-------------------------------------------------------------------------------------|
| **feat**     | Nueva característica o archivo           | Crear nuevos archivos, actividades, funcionalidades, ejercicios                     |
| **fix**      | Corrección de errores                    | Arreglar bugs, correcciones lógicas                                                 |
| **style**    | Cambios de formato                       | Refactoring sin cambios de lógica, correcciones de nomenclatura, limpieza de código |
| **chore**    | Cambios en configuración                 | Modificaciones en .gitignore, pom.xml, configuración del proyecto                   |
| **docs**     | Cambios de documentación                 | Solo si modifica README, guías generales (no para contenido de actividades)         |
| **refactor** | Reestructuración sin cambios funcionales | Reorganizar código, mejorar estructura                                              |

**IMPORTANTE:** `feat` es el más utilizado en este repositorio para contenido educativo.

---

## **3. ÁMBITO (SCOPE)**

El ámbito especifica el área del proyecto afectada. Debe ir entre paréntesis y en minúsculas:

### **Ámbitos Principales**

- `(base de datos)` - Cambios en BBDD, scripts SQL, actividades de bases de datos
- `(Digitalización)` - Contenido de la unidad de Digitalización
- `(programacion)` - Ejercicios y actividades de programación Java
- `(sistemas informaticos)` - Contenido de Sistemas Informáticos, Windows Server
- `(lenguajes de marcas)` - HTML, CSS, XML, actividades de marcado
- `(entornos de desarrollo)` - IDE, Swing, herramientas de desarrollo
- `(sostenibilidad)` - Contenido de sostenibilidad empresarial
- `(guía Git)` - Guías y documentación sobre Git
- `(ServerMinecraft)` - Proyecto del servidor Minecraft
- `(.gitignore)` - Cambios en archivo de exclusiones

### **Formato**

```markdown
feat(base de datos): descripción
feat(Digitalización): descripción
style(programacion): descripción
chore(.gitignore): descripción
```

---

## **4. DESCRIPCIÓN BREVE**

La descripción sigue después de `:` (dos puntos y espacio).

### **Reglas**

✅ **HACER:**

- Usar **minúsculas** al inicio (excepto si comienza con nombre propio)
- Ser **descriptivo pero conciso** (máximo 72 caracteres idealmente, pero puede ser más)
- Redactar en **ESPAÑOL**
- Usar verbos en infinitivo: "crear", "agregar", "implementar", "corregir", "ajustar"
- Ser específico sobre QUÉ se está haciendo

❌ **NO HACER:**

- Escribir en inglés
- Usar mayúsculas iniciales (salvo nombres propios)
- Ser demasiado genérico ("actualizar archivo", "cambios")
- Usar puntos finales
- Usar verbos en participio o pasado

### **Ejemplos**

✅ Correctos:

- `agregar premisa de actividad evaluable sobre Google Drive, Docs y Sheets`
- `crear actividad 17 de auditoría de acceso a objetos en Windows`
- `Crear scripts SQL completos para BD CS2-SVSS con documentación`
- `corregir nombres de tablas a minúsculas`
- `implementar funcionalidades completas del menú y crear versión alternativa optimizada`

❌ Incorrectos:

- `Add new feature` (inglés)
- `Updating files` (inglés, participio)
- `Cambios varios` (demasiado genérico)
- `agregar archivo.` (puntuación final)
- `CREAR DOCUMENTO` (mayúsculas innecesarias)

---

## **5. CUERPO DEL COMMIT (OPCIONAL)**

Si hay cambios significativos o el commit es complejo, agregar un cuerpo con viñetas.

### **Formato del Cuerpo**

- Separar del título con **una línea en blanco**
- Usar **viñetas con asterisco**: `*`
- Cada viñeta describe un cambio específico
- Ser específico: mencionar archivos, tablas, funciones cuando sea relevante
- Mantener consistencia: todas las viñetas deben tener similar nivel de detalle

### **Ejemplo de Cuerpo**

```markdown
* Agregar archivo Act17_AuditoriaAccesoWindows_JAAlejo.md con documentación completa de la actividad
* Incluir tabla de contenidos con enlaces internos navegables
* Detallar pasos para activación de directiva de auditoría
* Documentar configuración de auditoría en carpetas
* Agregar procedimiento de consulta del Visor de eventos
* Incluir archivo de premisa PremisaAct17.md
```

### **Cuándo INCLUIR el cuerpo**

- Cambios complejos con múltiples elementos
- Cuando hay necesidad de explicar CÓMO y POR QUÉ
- Commits con más de 2-3 cambios relacionados
- Cuando se modifican múltiples archivos

### **Cuándo OMITIR el cuerpo**

- Cambios simples y obvios
- Un único cambio claro
- Correcciones menores

---

## **6. EJEMPLOS REALES**

### **Ejemplo 1: Commit Complejo (con cuerpo)**

```markdown
feat(base de datos): crear script para la base de datos Polo Norte

* Se agrega un nuevo script SQL para la creación de la base de datos 'polonorte'.
* Incluye tablas para 'elfo', 'regalo', 'fabricacion', 'casa' y 'niño'.
* Define las relaciones y restricciones necesarias entre las tablas.
```

### **Ejemplo 2: Commit de Estilo**

```markdown
style(base de datos): corregir nombres de tablas a minúsculas

* Se cambió el nombre de las tablas ELFO y REGALO a minúsculas.
* Mejora la consistencia en la nomenclatura de las tablas.
```

### **Ejemplo 3: Commit de Configuración**

```markdown
chore(.gitignore): agregar Minecraft.zip a la lista de exclusiones

* Se añade el archivo Minecraft.zip a la sección de archivos personales, Minecraft Server.
* Se añade el directorio MC/ a la lista de exclusiones.
```

### **Ejemplo 4: Commit Simple (sin cuerpo)**

```markdown
feat(Digitalización): agregar premisa de actividad evaluable sobre Google Drive, Docs y Sheets
```

### **Ejemplo 5: Commit de Múltiples Funcionalidades**

```markdown
feat(programacion): implementar funcionalidades completas del menú y crear versión alternativa optimizada

* Cambiar comentario de "TODO" a "DONE" en la sección de desarrollo del menú.
* Implementar opción 6: mostrar estadísticas de un partido.
* Implementar opción 7: mostrar ranking de goleadores con ordenación manual.
* Crear archivo Alt_Act6_ArraysAvanzadosJAAlejo.java con versión optimizada.
* Reemplazar ordenación manual con Arrays.sort() para mayor eficiencia.
```

---

## **7. PATRONES A SEGUIR**

### **Patrón para Nuevas Actividades/Ejercicios**

```markdown
feat(<ámbito>): crear/agregar <tipo> <número/nombre> de <descripción>

* Crear documento <nombre_archivo>.md con <descripción de contenido>
* Incluir <elementos específicos: tabla de contenidos, ejemplos, etc.>
* Detallar <aspectos clave>
* Agregar <recursos adicionales si aplica>
```

**Ejemplo:**

```markdown
feat(sistemas informaticos): Crear actividad 17 de auditoría de acceso a objetos en Windows

* Agregar archivo Act17_AuditoriaAccesoWindows_JAAlejo.md
* Incluir tabla de contenidos con enlaces internos
* Detallar pasos para activación de directiva de auditoría
```

### **Patrón para Correcciones de Base de Datos**

```markdown
feat(base de datos): <modificar/agregar> <elemento> <descripción adicional>

* <cambio 1 específico>
* <cambio 2 específico>
* <cambio 3 específico>
```

**Ejemplo:**

```markdown
feat(base de datos): agregar columnas y restricciones en Polo Norte siguiendo premisas del profesor

* Añadir columna 'jefe' a la tabla 'elfo'.
* Añadir columna 'edad' a la tabla 'niño'.
* Añadir restricción CHECK a la columna 'edad' en 'niño'.
```

### **Patrón para Mejoras de Código**

```markdown
feat(<ámbito>): <mejorar/refactorizar> <qué> <descripción>

* <implementación 1>
* <implementación 2>
* <optimización o mejora realizada>
```

**Ejemplo:**

```markdown
feat(programacion): implementar funcionalidades completas del menú

* Implementar opción 6 para mostrar estadísticas de partidos
* Agregar funcionalidad para determinar el pichichi
* Implementar ordenación de goleadores
```

---

## **8. LO QUE NO HACER**

❌ **ERRORES COMUNES A EVITAR**

| Error                       | Ejemplo Incorrecto                   | Solución                                                       |
|-----------------------------|--------------------------------------|----------------------------------------------------------------|
| Usar inglés                 | `feat(db): add new tables`           | Usar español: `feat(base de datos): agregar nuevas tablas`     |
| Genérico                    | `feat(base de datos): actualizar`    | Ser específico: `agregar columnas y restricciones`             |
| Puntuación final            | `feat(prog): crear función.`         | Sin punto: `feat(programacion): crear función`                 |
| Mayúsculas iniciales        | `AGREGAR Archivo Nuevo`              | Minúsculas: `agregar archivo nuevo`                            |
| Verbo en participio         | `feat: agregado archivo`             | Infinitivo: `feat: agregar archivo`                            |
| Sin ámbito                  | `feat: cambios en archivo`           | Con ámbito: `feat(base de datos): cambios`                     |
| Demasiado corto             | `feat(db): fix`                      | Descriptivo: `feat(base de datos): corregir nombres de tablas` |
| Commits múltiples mezclados | Cambios de BD + código + docs en uno | Separar por tipo/ámbito                                        |

---

## **9. PASOS PARA USAR ESTA PREMISA**

### **Cuando solicites un mensaje de commit a una IA:**

1. **Proporciona el contexto:**
   - Qué archivos fueron modificados
   - Qué cambios se realizaron
   - En qué ámbito del proyecto (base de datos, programación, etc.)

2. **Incluye esta premisa:**
   - Copia el enlace a este documento o la sección relevante
   - O proporciona un resumen de los patrones

3. **Solicita el formato específico:**

   ```bash
   Basándote en la premisa de commits de José Ángel Alejo:
   
   Cambios realizados:
   - [describe cambios]
   - [describe cambios]
   
   Genera un mensaje de commit en formato:
   <tipo>(<ámbito>): <descripción>

   * viñeta 1
   * viñeta 2
   ```

4. **Revisa y adapta si es necesario:**
   - Verifica que siga el patrón
   - Asegúrate de que sea descriptivo
   - Corrige si es necesario antes de hacer commit

### **Ejemplo de Solicitud a una IA:**

```bash
Necesito un mensaje de commit siguiendo esta premisa:
https://github.com/jaalejo/MisApuntesITPDAW/docs/Guias_JAAlejo/Premisa_MensajesCommit_JAAlejo.md

Cambios realizados:
- He creado un nuevo documento de actividad evaluable sobre Google Cloud
- He incluido instrucciones paso a paso para Google Drive, Docs y Sheets
- He agregado ejemplos con fórmulas y tablas
- He corregido errores de markdown linting

Archivos modificados/creados:
- Act_AplicacionesProgramasNubeGoogle-Jaalejo.md (nuevo)
- PremisaProf.md (actualizado)

Ámbito: Digitalización / Unidad 3

Genera el mensaje de commit con viñetas detalladas.
```

---

## **REFERENCIAS**

- [Conventional Commits](https://www.conventionalcommits.org/) - Estándar utilizado como base
- Repositorio: MisApuntesITPDAW
- Autor: José Ángel Alejo Sillero
- Última actualización: 14 de Enero de 2026
