<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="UTF-8"/>

    <xsl:template match="/">
        <xsl:text>{&#10;  "alumnos": [&#10;</xsl:text>
        <xsl:for-each select="alumnos/alumno">
            <xsl:sort select="nombre" data-type="text" order="ascending"/>
            <xsl:text>    {&#10;      "nombre": "</xsl:text>
            <xsl:value-of select="nombre"/>
            <xsl:text>",&#10;      "edad": "</xsl:text>
            <xsl:value-of select="edad"/>
            <xsl:text>"&#10;    }</xsl:text>
            <xsl:if test="position() != last()">
                <xsl:text>,&#10;</xsl:text>
            </xsl:if>
        </xsl:for-each>
        <xsl:text>&#10;  ]&#10;}</xsl:text>
    </xsl:template>

</xsl:stylesheet>
