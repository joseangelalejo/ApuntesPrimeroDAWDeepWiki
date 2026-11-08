# Revisión de preparación pública

Documento de control para preparar esta copia como repositorio público.

---

## Comprobaciones realizadas

- La copia se trabaja de forma independiente del repositorio original.
- Se conserva la estructura de módulos y unidades.
- No se han eliminado actividades, apuntes ni recursos.
- Se han mantenido separadas las dos carpetas de prácticas de empresa.
- Se ha revisado la presencia de rutas absolutas y referencias al repositorio original.
- El `.gitignore` ya excluye varios artefactos de compilación, cachés, secretos y temporales.

## Adaptaciones realizadas en esta copia

- Se ha actualizado el README general para reflejar el contenido real.
- Se han creado índices de entrada para los módulos principales.
- Se ha añadido esta revisión para distinguir documentación de material académico.
- No se ha modificado el contenido técnico de las actividades.

## Elementos que requieren revisión manual antes de publicar

### Datos personales

Hay documentos de actividades, entregas, prácticas de empresa y nombres de archivos que pueden contener datos personales o información del centro. Antes de publicar conviene revisar:

- DNI, teléfonos, direcciones y correos.
- Memorias o documentación de prácticas de empresa.
- Capturas de pantalla con nombres de usuario.
- Credenciales, tokens, claves o configuraciones privadas.
- Rutas locales que revelen información innecesaria.

No se han borrado automáticamente porque podría eliminarse material académico válido.

### Artefactos generados

La copia contiene archivos que parecen generados por compilación o ejecución, como:

- `.class`
- `bin/`
- `obj/`
- `target/`
- `.jar`
- `.dll`
- `.pdb`

El `.gitignore` evita que muchos artefactos nuevos se añadan, pero los archivos ya existentes siguen físicamente en la copia. Se recomienda decidir manualmente si se quieren conservar antes del primer commit.

### Prácticas de empresa

Las carpetas:

- `Practicas de Empresa 1 DAW`
- `Practicas_Empresa_1DAW`

no se han fusionado ni eliminado. Hay que revisar si incluyen información de empresa, clientes, compañeros o documentos que no deban hacerse públicos.

---

## Recomendación antes del primer commit

1. Revisar manualmente prácticas de empresa y documentos identificados como personales.
2. Buscar secretos y credenciales en archivos de configuración.
3. Decidir si se conservan binarios y artefactos generados.
4. Revisar `git status --ignored`.
5. Hacer el primer commit solo después de comprobar el contenido staged.
