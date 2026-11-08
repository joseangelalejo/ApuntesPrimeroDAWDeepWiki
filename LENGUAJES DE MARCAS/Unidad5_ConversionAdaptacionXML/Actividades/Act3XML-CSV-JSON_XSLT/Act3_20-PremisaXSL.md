# Actividad 20: TRANSFORMACIÓN DE UN XML A CSV Y JSON MEDIANTE XSLT

En esta actividad se deberá partir de un archivo XML dado y crear dos hojas de estilo XSLT distintas.

- La primera deberá transformar el contenido del XML en un archivo CSV con una línea de cabecera y una fila por cada elemento, debe de estar ordenador por nombre alfabéticamente.
- La segunda deberá transformar ese mismo XML en un archivo JSON respetando correctamente la sintaxis de este formato.

Entregar un único documento PDF que incluya capturas de pantalla donde se visualice el XML cargado en el navegador mostrando correctamente la transformación a CSV Y JSON, así como el código de la hoja de estilos XSLT utilizada.

> Código base en XML para la transformación:

```XML
<?xml version="1.0" encoding="UTF-8"?>
<alumnos>
    <alumno>
        <nombre>Juan</nombre>
        <edad>20</edad>
    </alumno>
    <alumno>
        <nombre>Ana</nombre>
        <edad>18</edad>
    </alumno>
    <alumno>
        <nombre>Carlos</nombre>
        <edad>22</edad>
    </alumno>
    <alumno>
        <nombre>Lucía</nombre>
        <edad>19</edad>
    </alumno>
    <alumno>
        <nombre>Pedro</nombre>
        <edad>21</edad>
    </alumno>
</alumnos>
```

![alt text](<csv y json-Premisa.png>)
