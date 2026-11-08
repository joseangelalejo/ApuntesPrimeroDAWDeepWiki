<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output method="xml" encoding="UTF-8" indent="yes" />
    <xsl:template match="/">

        <fo:root>

            <fo:layout-master-set>
                
                <fo:simple-page-master master-name="pagina"
                    page-width="21cm"
                    page-height="29.7cm"
                    margin-top="2cm"
                    margin-bottom="2cm"
                    margin-left="2cm"
                    margin-right="2cm">
                    <fo:region-body />
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="pagina">
                <fo:flow flow-name="xsl-region-body">

                    <fo:block font-size="18pt"
                        font-family="Arial"
                        font-weight="bold"
                        text-align="center"
                        space-after="20pt">
                        INFORME DEL ALUMNO
                    </fo:block>

                    <xsl:for-each select="alumnos/alumno">
                        <fo:block font-size="12pt"
                            font-family="Arial"
                            space-after="10pt"> Nombre: <xsl:value-of select="nombre" />
                        </fo:block>

                        <fo:block font-size="12pt"
                            font-family="Arial"
                            space-after="10pt"> Curso: <xsl:value-of select="curso" />
                        </fo:block>

                        <fo:block font-size="12pt"
                            font-family="Arial"> Módulo: <xsl:value-of select="modulo" />
                        </fo:block>

                        <fo:block space-after="15pt"/>
                    </xsl:for-each>

                </fo:flow>
            </fo:page-sequence>

        </fo:root>

    </xsl:template>

</xsl:stylesheet>