# Actividad 21: GENERACIÓN DE UN DOCUMENTO PDF A PARTIR DE XML MEDIANTE XSL-FO

1. Crear un archivo XML que contenga información de al menos 20 alumnos. Cada alumno deberá incluir los siguientes datos: nombre, primer apellido, segundo apellido, DNI, teléfono, ciclo formativo, curso y tutor.
2. Diseñar una transformación XSLT que permita convertir el archivo XML en un documento en formato XSL-FO, definiendo la estructura y el formato del contenido.
3. Configurar el archivo XSL-FO para que genere un documento con formato de página A4, incluyendo márgenes adecuados y una estructura clara contoda la información de los alumnos.
4. Generar el archivo .fo resultante a partir de la transformación del XML.
5. Convertir el archivo .fo en un documento PDF final donde se visualice correctamente la tabla con todos los alumnos.
6. Comprobar que el PDF generado contiene todos los datos correctamente organizados y presentados en formato tabular.

abrir terminal Visual Studio: control + ñ

EXPORTAR EL XML A FO: java -jar saxon-he-12.9.jar -s:alumno.xml -xsl:alumno.xsl
-o:alumno.fo

EXPORTAR EL FO A PDF: fop alumno.fo -pdf alumno.pdf

MODO DE ENTREGA

--

Entregar un documento con captura de pantalla del ARCHIVO.FO y DEL PDF GENERADO.
