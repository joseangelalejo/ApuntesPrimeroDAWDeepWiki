<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" indent="yes" encoding="UTF-8"/>
    <xsl:strip-space elements="*"/>

    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta charset="UTF-8"/>
                <title>Listado de películas</title>
                <style>
                    body { font-family: Arial, sans-serif; margin: 1.4rem; line-height: 1.5; background: #f5f7fb; color: #20232a; }
                    h1, h2 { color: #0d3b66; }
                    ol, ul { margin-left: 1.4rem; }
                    li { margin-bottom: 0.4rem; }
                    pre { background: #ffffff; border: 1px solid #ccd6dd; padding: 1rem; white-space: pre-wrap; word-wrap: break-word; }
                    .nota { font-size: 0.95rem; color: #3a4a5a; }
                </style>
            </head>
            <body>
                <h1>Listado de películas</h1>
                <p class="nota">Transformación XML → HTML mediante XSLT. Cada película se muestra como un elemento de lista ordenada y sus datos asociados aparecen en una lista desordenada.</p>

                <h2>Películas en lista ordenada</h2>
                <ol>
                    <xsl:for-each select="peliculas/pelicula">
                        <li>
                            <strong><xsl:value-of select="titulo"/></strong>
                            <ul>
                                <li><strong>Género:</strong> <xsl:value-of select="genero"/></li>
                                <li><strong>Año:</strong> <xsl:value-of select="anio"/></li>
                                <li><strong>Duración:</strong> <xsl:value-of select="duracion"/> minutos</li>
                                <li><strong>Precio:</strong> $<xsl:value-of select="precio"/></li>
                                <li><strong>Director:</strong> <xsl:value-of select="director"/></li>
                                <li><strong>Protagonistas:</strong>
                                    <ul>
                                        <xsl:for-each select="protagonistas/actor">
                                            <li><xsl:value-of select="."/></li>
                                        </xsl:for-each>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </xsl:for-each>
                </ol>

                <h2>Salida de texto plano ordenada por título</h2>
                <pre><xsl:for-each select="peliculas/pelicula"><xsl:sort select="titulo" data-type="text" order="ascending"/>
Título: <xsl:value-of select="titulo"/> | Género: <xsl:value-of select="genero"/> | Año: <xsl:value-of select="anio"/> | Duración: <xsl:value-of select="duracion"/> min | Protagonistas: <xsl:for-each select="protagonistas/actor"><xsl:value-of select="."/><xsl:if test="position() != last()"><xsl:text>, </xsl:text></xsl:if></xsl:for-each>
</xsl:for-each></pre>

                <p class="nota">Abre <code>premisa_peliculas.xml</code> en el navegador para ver esta transformación con el XSLT aplicado automáticamente.</p>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
