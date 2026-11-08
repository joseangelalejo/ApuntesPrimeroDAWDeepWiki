<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" encoding="UTF-8"/>

    <xsl:template match="/">
        <xsl:text>nombre,edad&#10;</xsl:text>
        <xsl:for-each select="alumnos/alumno">
            <xsl:sort select="nombre" data-type="text" order="ascending"/>
            <xsl:value-of select="nombre"/>
            <xsl:text>,</xsl:text>
            <xsl:value-of select="edad"/>
            <xsl:text>&#10;</xsl:text>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>
