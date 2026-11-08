# Archivo todo para Entregable 2 de Bases de Datos

## DONE 1: Hacer revisión del modelo ER actual para detectar posibles mejoras o errores

## DONE 2: Revisar que mi análisis de adaptaciones para el modelo ER sea correcto

## DONE 3: Revisar que los tipos de atributos indicados en el modelo ER sean los adecuados

## DONE 4: Comprobar que las restricciones de integridad indicadas en el modelo ER son correctas y completas

## DONE 5: Realizar correcciones al modelo ER según los puntos anteriores

### Crear entidad Mapas con cuatro atributos: NombreMapa (PK), PoolPremiere(booleano obligatorio, establece si el mapa está disponible para jugar en el modo Ranking Premiere) y DisponibleActualmente (booleano obligatorio, indica si el mapa está disponible actualmente en el juego, si NO está disponible, entonces ese mapa no tendrá relación actualmente con el resto de entidades) y VersionMapa (entero obligatorio, indica la versión actual del mapa en el juego, por ejemplo, 1, 2, 3, etc.)

### Además, eliminar el atributo Mapa del resto de entidades que la contienen actualmente

### Y, establecer las relaciones necesarias entre la nueva entidad Mapas, y la entidad Modo_de_Juego

### Crear entidad/tabla Modos_de_Juego con tres atributos: NombreModo (PK), DescripcionModo (atributo obligatorio que describe el modo de juego) y un booleano DisponibleActualmente(si, no). Y establecer relación con la Mapas y con la entidad Partidas

### Respecto a la relación entre Partidas y Jugadores

#### Eliminar la entidad intermedia Partida_Jugador

#### Cambiar el nombre de la relación entre Partidas y Jugadores_CS2 a "Participan_en" o "Juegan_en". La cardinalidad será de tipo N:M, con participación (1,N) desde Partidas hacia Jugadores_CS2, y participación (0,N) desde Jugadores_CS2 hacia Partidas

#### Para saber cuántos jugadores participan en una partida, añadir un atributo Num_Jugadores (entero obligatorio) a la entidad Partidas, que tendrá un dominio entre 1 y 20

## DONE 6: Actualizar el documento Markdown con las modificaciones realizadas al modelo ER

## DONE 7 : Desarrollar explicación de adaptaciones realizadas a entidades, atributos y relaciones propuestas en el ERS al realizar el modelo Entidad-Relación

## DONE 8: Desarrollar análisis de adaptaciones del modelo ER al modelo relacional

## DONE 9: Realizar el diagrama del modelo relacional basado en el modelo ER corregido, el análisis y las adaptaciones indicadas

## DONE 10: Actualizar el documento Markdown con el análisis de adaptaciones y el diagrama del modelo relacional, revisar coherencia completa del documento y formato adecuado

## TDONE 10.2: Actualizar imágenes del modelo ER y del modelo relacional en el documento Markdown final

## DONE 11: Darle formato al documento Markdown final para preparar su exportacion a PDF para entrega e impresión

## DONE 12: Exportar el documento Markdown final a PDF para su entrega e impresión

## DONE 13: Revisar el PDF final para asegurar que todo el contenido se visualiza correctamente y está listo para su entrega

## DONE 14: Realizar la entrega del documento PDF finalizado según las indicaciones del profesor
