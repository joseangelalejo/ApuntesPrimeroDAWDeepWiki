<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="text" encoding="UTF-8"/>

    <xsl:template match="/">
        <xsl:for-each select="peliculas/pelicula">
            <xsl:sort select="titulo" data-type="text" order="ascending"/>
            <xsl:text>Título: </xsl:text><xsl:value-of select="titulo"/>
            <xsl:text>&#10;</xsl:text>
            <xsl:text>Género: </xsl:text><xsl:value-of select="genero"/>
            <xsl:text>&#10;</xsl:text>
            <xsl:text>Año: </xsl:text><xsl:value-of select="anio"/>
            <xsl:text>&#10;</xsl:text>
            <xsl:text>Duración: </xsl:text><xsl:value-of select="duracion"/><xsl:text> minutos</xsl:text>
            <xsl:text>&#10;</xsl:text>
            <xsl:text>Protagonistas: </xsl:text>
            <xsl:for-each select="protagonistas/actor">
                <xsl:value-of select="."/>
                <xsl:if test="position() != last()"><xsl:text>, </xsl:text></xsl:if>
            </xsl:for-each>
            <xsl:text>&#10;&#10;</xsl:text>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>
