DROP DATABASE IF EXISTS Centro_Internacional_de_Expediciones;
CREATE DATABASE Centro_Internacional_de_Expediciones;
USE Centro_Internacional_de_Expediciones;

CREATE TABLE pais (
codigo ENUM('ESP', 'FR', 'POR') PRIMARY KEY ,
nombre varchar(10),
poblacion mediumint,
area_km2 DOUBLE,	/* Utilizo Double en lugar de float porque requiero precisión
						en ocasiones area_km2 de paises se utilizan para cálculos en economía
						aunque a priori no debería ser necesaria tanta precisión en nuestra BBD
                        debido a la naturaleza del negocio al que se orienta
					*/
Continente ENUM('Europa', 'Asia', 'África')
);
CREATE TABLE cientifico (
id_cientificio INT PRIMARY KEY AUTO_INCREMENT,
Nombre_completo VARCHAR(30),
Biografia TEXT,
Foto_Perfil MEDIUMBLOB, /* No se puede restringir tipos de archivos que admitimos,
							por ejemplo PNG o JPG, se hace desde el lado del servidor */
Curriculum_PDF MEDIUMBLOB,
Experiencia INT(2) UNSIGNED,
Salario decimal(7,2),
Fecha_Nacimiento DATE,
Hora_Registro TIMESTAMP, /* Timestamp extrae fecha exacta y hora exacta hasta el segundo
							Es útil para control de registros y acceso/cambios a sistemas
                            Más adelante veremos que se pueden aplicar restricciones y funciones
							*/
Alta_Sistema BOOLEAN
);
CREATE TABLE expedicion (
id_expedicion INT PRIMARY KEY AUTO_INCREMENT,
titulo TINYTEXT,
descripcion_detallada MEDIUMTEXT,
nivel_peligro ENUM('BAJO', 'MEDIO', 'ALTO'),
tipos_zona SET('SELVA', 'DESIERTO', 'OCEANO'),
presupuesto_estimado DECIMAL(8,2),
fecha_inicio TIMESTAMP, /* Utilizo timestamp suponiendo que la fecha de inicio se toma de
							una aplicación/sistema con la que el personal de campo marca el inicio y en ese
                            momento manda a la BBDD la hora de inicio
                            */
momento_registro TIMESTAMP,
coordenada_centro POINT,
area_operacion POLYGON
);
CREATE TABLE equipamiento (
id_item INT PRIMARY KEY AUTO_INCREMENT,
nombre_Item TINYTEXT,
categoria ENUM ('MÉDICO', 'HERRAMIENTA', 'EMERGENCIA'),
peso_KG DECIMAL(5,2),
manual_texto LONGTEXT,
manual_pdf LONGBLOB,
sensor_datos_json JSON
);
CREATE TABLE ruta (
ID_ruta INT PRIMARY KEY AUTO_INCREMENT,
nombre_Ruta MEDIUMTEXT,
longitud_metros DOUBLE,
dificultad ENUM ('FACIL', 'MEDIA', 'DIFICIL'),
puntos_recorrido MULTIPOINT,	/* Suponiendo que los puntos del recorrido serán usados
									sobre un archivo de ruta donde se generará la ruta mediante
									marcadores de coordenada, donde el estándar de archivo es KML o GPX*/
zonas_alternativas GEOMETRYCOLLECTION,	# Conjunto de multipoints bien diferenciados
notas TINYTEXT
);