# Actovodad 23: MODIFICACIÓN DE DOCUMENTOS XML. XQUERY

1. Modifica el nombre del alumno con id="1" para que pase a llamarse Pedro.
2. Modifica la edad del alumno llamado Ana para que tenga 23 años.
3. Inserta el nodo <telefono>600111222</telefono> dentro del alumno con id="1".
4. Inserta el nodo <estado>activo</estado> en todos los alumnos del XML.
5. Inserta el nodo <becado>si</becado> únicamente en el alumno llamado Luis.
6. Elimina el nodo email del alumno con id="3".
7. Elimina completamente el alumno con id="2".
8. Reemplaza el nodo <curso> del alumno con id="1" por <curso>DAW</curso>.
9. Renombra el nodo edad del alumno con id="3" para que pase a llamarse anios.
10. Añade el atributo matriculado="si" al alumno con id="1".
11. Modifica el atributo matriculado del alumno con id="1" para que su valor sea "no".
12. Elimina el atributo matriculado del alumno con id="1".
13. Inserta el nodo <direccion>Sevilla</direccion> al principio del alumno con id="1".
14. Inserta el nodo <observaciones>Buen rendimiento</observaciones> al final del alumno con id="1".
15. Inserta un nuevo alumno con los siguientes datos: 

```xml
<alumno id="4">
<nombre>Carlos</nombre>
<edad>21</edad>
<curso>DAM</curso>
</alumno>
```

16. Reemplaza completamente el nodo alumno con id="3" por otro alumno con los datos que desees.
17. Elimina todos los nodos email del documento XML mediante una única consulta.
18. Añade el atributo estado="activo" a todos los alumnos.
19. Modifica el valor del curso de todos los alumnos para que sea "ASIR".
20. Renombra todos los nodos curso para que pasen a llamarse ciclo.