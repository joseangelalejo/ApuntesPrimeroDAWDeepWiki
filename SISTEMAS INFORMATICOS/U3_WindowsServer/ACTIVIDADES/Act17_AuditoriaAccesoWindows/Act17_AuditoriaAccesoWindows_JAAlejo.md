# **ACTIVIDAD 17- AUDITORÍA DE ACCESOA  OBJETOS EN WINDOWS**

- **Autores**: José Ángel Alejo Sillero
- **Centro**: Instituto Tecnológico Pablo de la Torre
- **Curso**: 2025/2026
- **Módulo**: Sistemas Informáticos
- **Unidad**: 3 - Sistemas operativos en red. Windows Server

Para la realización de esta actividad se han seguido los pasos indicados en la premisa para configurar la auditoría de acceso a objetos en un equipo con Windows. A continuación, se detallan cada uno de los pasos realizados.

---
<div style="page-break-after: always;"></div>

> **Tabla de contenidos**

- [**ACTIVIDAD 17- AUDITORÍA DE ACCESOA  OBJETOS EN WINDOWS**](#actividad-17--auditoría-de-accesoa--objetos-en-windows)
  - [**Activación de la directiva de auditoría**](#activación-de-la-directiva-de-auditoría)
  - [**Creación de la carpeta y archivo de texto**](#creación-de-la-carpeta-y-archivo-de-texto)
  - [**Configuración de la auditoría en la carpeta**](#configuración-de-la-auditoría-en-la-carpeta)
  - [**Realización de acciones sobre el archivo**](#realización-de-acciones-sobre-el-archivo)
  - [**Consulta del Visor de eventos**](#consulta-del-visor-de-eventos)
  - [**Conclusión**](#conclusión)

---
<div style="page-break-after: always;"></div>

## **Activación de la directiva de auditoría**

Para activar la auditoría de acceso a objetos, hemos accedido a la Directiva de Seguridad Local. Los pasos han sido los siguientes:

1. Abrir el Ejecutar (Win + R) y escribir `secpol.msc` para abrir la Directiva de Seguridad Local.
   1. ![alt text](<IMAGENES/PASO 1_1.png>)
2. Navegar a "Directivas locales" > "Directiva de auditoría".
3. Habilitar la auditoría para "Auditar acceso a objetos" marcando "Éxito" y "Fracaso".
   1. ![alt text](<IMAGENES/PASO 1_2.png>)

## **Creación de la carpeta y archivo de texto**

Hemos creado una carpeta llamada "AuditoriaAcceso" en el escritorio y dentro de ella un archivo de texto llamado "prueba.txt". Esta carpeta sirve como contenedor para los archivos sobre los cuales se realizará la auditoría.

1. En el Explorador de Archivos, crear la carpeta llamada "AuditoriaAcceso".
2. Dentro de la carpeta, crear el archivo de texto "prueba.txt".
3. ![alt text](<IMAGENES/PASO 2.png>)

## **Configuración de la auditoría en la carpeta**

Hemos configurado la auditoría para la carpeta "AuditoriaAcceso" para registrar lecturas, escrituras y eliminaciones realizadas por nuestro usuario.

1. Hacer clic derecho en la carpeta > Propiedades > Seguridad > Avanzado > Auditoría.
   1. ![alt text](<IMAGENES/PASO 3_1.png>)
2. Agregar una entrada de auditoría para nuestro usuario, seleccionando "Lectura", "Escritura" y "Eliminación".
   1. ![alt text](<IMAGENES/PASO 3_2.png>)
   2. ![alt text](<IMAGENES/PASO 3_3.png>)
   3. ![alt text](<IMAGENES/PASO 3_4.png>)

## **Realización de acciones sobre el archivo**

Hemos realizado varias acciones sobre el archivo "prueba.txt":

- Abrirlo con el Bloc de notas.
- Modificar su contenido agregando texto.
- Guardarlo y cerrarlo.
  - ![alt text](<IMAGENES/PASO 3_5.png>)

## **Consulta del Visor de eventos**

Hemos accedido al Visor de eventos para localizar los eventos de seguridad generados.

1. Abrir el Visor de eventos (eventvwr.msc).
   1. ![alt text](<IMAGENES/PASO 4_1.png>)
2. Navegar a "Registros de Windows" > "Seguridad".
   1. ![alt text](<IMAGENES/PASO 4_2.png>)
3. Filtrar los eventos relacionados con el archivo, identificando el tipo de evento (e.g., 4663 para acceso a objetos), el usuario y el proceso.

Hemos identificado los siguientes eventos:

- Evento ID 4663: Acceso a objeto por [Usuario], proceso [Proceso].
  - En nuestro caso, el usuario aparece como "No disponible" por ser la propia cuenta de administrador.
- ![alt text](<IMAGENES/PASO 4_3.png>)

<div style="page-break-after: always;"></div>

## **Conclusión**

Esta actividad nos ha permitido entender cómo configurar y monitorear el acceso a objetos en Windows mediante auditorías. Los eventos registrados proporcionan una trazabilidad detallada de las acciones realizadas sobre archivos y carpetas.
