<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" indent="yes" encoding="UTF-8"/>

    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta charset="UTF-8"/>
                <title>Listado de películas</title>
            </head>
            <body>
                <h1>Listado de películas</h1>
                <ol>
                    <xsl:for-each select="peliculas/pelicula">
                        <li>
                            <strong><xsl:value-of select="titulo"/></strong>
                            <ul>
                                <li>Año: <xsl:value-of select="anio"/></li>
                                <li>Género: <xsl:value-of select="genero"/></li>
                                <li>Duración: <xsl:value-of select="duracion"/> minutos</li>
                                <li>Precio: <xsl:value-of select="precio"/></li>
                                <li>Director: <xsl:value-of select="director"/></li>
                                <li>Protagonistas:
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
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
