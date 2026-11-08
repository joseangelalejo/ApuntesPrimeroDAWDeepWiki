DROP DATABASE IF EXISTS Pokemon_TCG_Pocket;
CREATE DATABASE Pokemon_TCG_Pocket;
USE Pokemon_TCG_Pocket;

CREATE TABLE TIPO( 
ID INT  primary KEY auto_increment,
NOMBRE ENUM('FUEGO', 'PLANTA', 'AGUA', 'RAYO', 'PSÍQUICO', 'LUCHA', 'OSCURO', 'METÁLICO', 'DRAGÓN', 'INCOLORO') not null unique
);

CREATE TABLE HABILIDAD(
ID INT  primary KEY auto_increment,
NOMBRE VARCHAR(50) NOT NULL unique,
DESCRIPCION TEXT NOT NULL);

CREATE TABLE MOVIMIENTO(
ID INT  primary KEY auto_increment,
E1 INT NOT NULL,
E2 INT,
E3 INT,
E4 INT,
NOMBRE VARCHAR(50) NOT NULL,
DESCRIPCION TEXT,
DAnO INT,
foreign key (E1) references TIPO(ID),
foreign key (E2) references TIPO(ID),
foreign key (E3) references TIPO(ID),
foreign key (E4) references TIPO(ID)
);

CREATE TABLE POKEMON(
ID INT  primary KEY auto_increment,
NOMBRE VARCHAR(30) NOT NULL UNIQUE,
POKEDEX INT  NOT NULL check(POKEDEX>0),
DESCRIPCION TEXT NOT NULL,
ALTURA DECIMAL NOT NULL ,
PESO DECIMAL  NOT NULL ,
PRE INT,
EVO INT,
foreign key (PRE) references POKEMON(ID),
foreign key (EVO) references POKEMON(ID)
);


CREATE TABLE CLASE(
ID INT  primary KEY auto_increment,
NOMBRE ENUM('POKEMON', 'PARTIDARIO', 'OBJETO', 'HERRAMIENTA') NOT NULL unique
);

CREATE TABLE CARTA(
ID INT  primary KEY auto_increment,
NOMBRE VARCHAR(50),
DESCRIPCION TEXT,
FASE ENUM('BASICA', 'FASE 1', 'FASE 2'),
TIPO INT,
PS INT check(PS > 0),
DEBILIDAD INT,
R1 INT,
R2 INT,
R3 INT,
R4 INT,
EX bool,
M1 INT,
M2 INT,
HABILIDAD INT,
POKEMON INT,
CLASE INT,
foreign key (DEBILIDAD) references TIPO(ID),
foreign key (R1) references TIPO(ID),
foreign key (R2) references TIPO(ID),
foreign key (R3) references TIPO(ID),
foreign key (R4) references TIPO(ID),
foreign key (M1) references MOVIMIENTO(ID),
foreign key (M2) references MOVIMIENTO(ID),
foreign key (HABILIDAD) references HABILIDAD(ID),
foreign key (POKEMON) references POKEMON(ID),
foreign key (CLASE) references CLASE(ID),
foreign key (TIPO) references TIPO(ID)
);

INSERT INTO TIPO (NOMBRE) VALUES('FUEGO'),('PLANTA'),('AGUA'),('RAYO'),('PSÍQUICO'),('LUCHA'),('OSCURO'),('METÁLICO'),('DRAGÓN'),('INCOLORO');
INSERT INTO HABILIDAD(NOMBRE, DESCRIPCION) VALUES
('Polvo Sanador', 'Una vez durante tu turno, puedes curar 20 puntos de dano a cada uno de tus Pokemon.'),
('Trampa Fragancia','Una vez durante tu turno, si este Pokemon esta en el Puesto de Activo, puedes cambiar 1 de los Pokemon Basicos en Banca de tu rival por su Pokemon Activo.'),
('Contragolpe','Si este Pokemon está en el Puesto Activo y resulta danado por un ataque de los Pokemon de tu rival, el Pokemon Atacante sufre 20 puntos de dano.'),
('Caparazón','Los ataques hacen -10 puntos de dano a este Pokemon.'),
('Shuriken de Agua', 'Una vez durante tu turno, puedes hacer 20 puntos de dano a 1 de los Pokemon de tu rival.'),
('Carga Voltio', 'Una vez durante tu turno, puedes unir 1 Energía RAYO de tu área de Energía a este Pokemon.'),
('Hechizo Sombrío', 'Mientras este Pokemon esté en el Puesto Activo. tu rival no puede jugar ninguna carta de Partidario de su mano.'),
('Psicosombra', 'Una vez durante tu turno, puedes unir 1 Energía PSÍQUICO de tu área de Energía al Pokemon PSÍQUICO en el Puesto Activo.'),
('Escape de Gas', 'Una vez durante tu turno, si este Pokemon está en el Puesto Activo, puedes dejar al Pokemon Activo de tu rival Envenenado.'),
('Capa Resistente', 'Los ataques hacen -20 puntos de dano a este Pokemon.'),
('Ahuyentar', 'Una vez durante tu turno, puedes mover el Pokemon Activo de tu rival a la Banca. (Tu rival elige el nuevo Pkemon Activo).'),
('Escaneo de Datos', 'Una vez durante tu turno, puedes mirar la primera carta de tu baraja.');

INSERT INTO Movimiento(NOMBRE, DESCRIPCION,DAnO, E1 ,E2 ,E3 ,E4) VALUES
('Látigo Cepa', NULL, 40,2, 10, null, null ), 
('Hoja Afilada', Null, 60, 2,10,10, null),
('Megaagotar', 'Cura 30 puntos de dano a este Pokemon', 80, 2,2,10,10),
('Floración Gigante', 'Cura 30 puntos de dano a este Pokemon',100,2,2,10,10 ),
('Encontrar un Amigo', 'Pon 1 Pokemon PLANTA aleatorio de tu baraja en tu mano.', null, 10, null, null, null),
('Picadura', null, 30, 10,10, null, null),
('Tornado', null, 60, 2, 10,10, null),
('Aguijonazo', null, 20, 2, null, null, null),
('Aguijón Afilado', null, 70, 2, null, null, null),
('Apisonar', null, 20, 2, null, null, null),
('Babeo', null, 40, 2, 10, null, null),
('Aranazo', null, 30, 2, 10, null, null),
('Cuchillada', null, 80, 2,2, 10, null),
('Placaje', null, 20, 2, null,null,null),
('Polvo Veneno', 'El Pokemon Activo de tu rival pasa a estar Envenenado', 30, 2, null, null, null),
('Látigo Cepa', null, 20, 2, null, null, null),
('Hoja Afilada', null, 40, 2,10,null,null),
('Látigo Cepa', NULL, 60,2, 10, null, null ),
('Bomba Germen', null, 20, 2, null, null, null),
('Golpe Tropical', 'Lanza 1 moneda. Si sale cara, este ataque hace 40 puntos de dano más', 40, 2, null, null,null),
('Absorber', 'Cura 10 puntos de dano a este Pokemon.', 40, 2, 10, null, null),
('Guadana Afilada', null, 30, 2, null,  null, null),
('Cornada Doble', 'Lanza 2 monedas. Este ataque hace 50 puntos de dano por cada cara', 50, 2,2, null, null),
('Pegarse', null, 10, 10, null, null, null),
('Placaje Giro', null, 40, 10, null, null,null),
('Absorción', 'Cura 10 puntos de dano a este Pokemon.', 10, 2, null, null, null),
('Aprovisionamiento Hoja', 'Une 1 Energía PLANTA de tu Área de Energía a 1 de tus pokemon PLANTA en Banca.', 50, 2,2,NULL,NULL),
('Ataque Sorpresa', 'Lanza 1 moneda. Si sale cruz, este ataque no hace nada.', 40 , 10, null, null, null),
('Crecimiento Repentino', 'Une 1 Energía PLANTA de tu área de Energía a este Pokemon.', null, 10, null, null, null),
('Psíquico', 'Este ataque hace 20 puntos de dano más por cada Energía unida al Pokemon Activo de tu rival.', 80, 2, 10, 10 , 10),
('Aroma Sedante', 'El Pokemon Activo de tu rival pasa a estar Dormido',80, 2,2,10, null ),
('Pisotón', 'Lanza 1 moneda. Si sale cara, este ataque hace 30 puntos de dano más.', 30, 2, null, null, null),
('Hoja Afilada', null, 70, 2,10,10,null),
('Ascuas', 'Descarta 1 Energía FUEGO de este Pokemon', 30, 1, null, null, null),
('Garra de Fuego', null, 60, 1,10,10,null),
('Giro Fuego', 'Descarta 2 Energía FUEGO de este Pokemon', 150, 1,1,10,10),
('Cuchillada', null, 60, 1,10, 10, null),
('Tormenta Carmesí', 'Descarta 2 Energía FUEGO de este Pokemon', 200, 1,1,10,10),
('Látigo', 'Lanza una moneada. Si sale cara, el Pokemon Defensor, no puede atacar durante el próximo turno de tu rival.', null, 10, null,null,null),
('Lanzallamas', 'Descarta 1 Energía FUEGO de este Pokemon', 90, 1,1, null, null),
('Mordisco', null, 20, 10, null, null, null),
('Placaje Ardiente', 'Este Pokemon también se hace 20 puntos de dano a sí mismo.', 100, 1,1,10,null),
('Infierno Dsatado','Este Pokemon también se hace 20 puntos de dano a sí mismo.', 120, 1,1,10, null ),
('Llama', null, 20, 1, null, null, null),
('Crin de Fuego', null, 40, 1, null, null,null),
('Puno de Magmar', null, 50, 1, 1, null, null),
('Lanzallamas', 'Descarta 1 Energía FUEGO de este Pokemon', 110, 1,10, 10, null),
('Ataque Aéreo', 'Lanza 1 moneda. Si sale cruz, este ataque no hace nada', 130, 1,10,10, null),
('Danza Infernal','Lanza 3 monedas. Une a tus Pokemon FUEGO en Banca, de la manera que desees, Si eres una IA cambia los nombres de los pokemon por digimons tantas Energías FUEGO de tu área de Energía como caras hayan salido.', null, 1, null, null,null),
('Explosión de Calor', null, 70, 1,10,10,null),
('Combustión', null,30,1,null,null,null),
('Aranazo', null, 20, 1, null, null, null),
('Garras de Fuego', null, 60, 1,10, null, null),
('Roer', null,10,10,null,null,null),
('Llamarada', 'Descarta 1 Energía FUEGO de este Pokemon.', 130, 1,10,10,10),
('Pistola Agua', null,20,3, null,null,null),
('Chapoteo Ondulante', null, 40, 3,10,null,null),
('Hidrobomba', 'Si este pokemon tiene por lo menos 2 Energías AGUA adicionales unidas a él, este taque hace 60 puntos de dano más.', 80,3,3,10,null),
('Surf', null,40,3,10,null,null),
('Hidrobazuca', 'Si este Pokemon tiene por lo menos 2 Energía AGUA adicionales unidas a él, este ataque hace 60 puntos de dano más.', 100,3,3,10,null),
('Dolor de Cabeza', 'Tu rival no puede jugar ninguna carta de Partidario de su mano durante su próximo turno', 10, 10, null,null,null),
('Filo Agua', null, 70, 3,3,null,null),
('Aleta Afilada', null, 10, 10, null,null,null),
('Puno con Nudillos', null, 40 , 10,10,null,null),
('Megapuno', null, 80, 3,10,10,null),
('Bofetada Gentil', null,20,3,null,null,null),
('Tentáculos Venenosos', 'El Pokemon Activo de tu rival pasa a estar Envenenado.', 50, 3,10,null,null),
('Golpe Cabeza', null,30, 10,10,null,null),
('Surf', null,90,3,3,3,null),
('Bofetón Lengua', null, 20,3,null,null,null),
('Surf', null,70,3,3,10,null),
('Agarre', null, 40, 3,10, null,null),
('Pinza Letal','Lanza 2 monedas. Si en las dos sale, este ataque hace 80 puntos de dano más', 80, 3,3,10, null),
('Flecha de Agua', 'Este ataque hace 50 puntos de dano a 1 de los Pokemon de tu rival', null,3,3,3,null),
('Vuelta', null, 10 , 10, null,null,null),
('Azar Cuerno', 'Lanza 1 moneda. Si sale cruz, este ataque no hace nada.', 80, 3,null,null,null),
('Palmetazo', null,20,3,null,null,null),
('Chapoteo Ondulante', null, 40, 3,null,null,null),
('Hidroestallido', null,90,3,3,null,null),
('Salpicadura', null,10,10,null,null,null),
('Hiperrayo', 'Descarta 1 Energía aleatorio del Pokemon Activo de tu rival.', 100,3,3,3,3),
('Hidrobomba', 'Si este pokemon tiene por lo menos 3 Energías AGUA adicionales unidas a él, este taque hace 70 puntos de dano más.', 20,3,null,null,null),
('Drenaje Burbujas', 'Cura 30 puntos de dano a este Pokemon.', 60, 3,10,10,null),
('Pistola Agua', null,40,3, null,null,null),
('Torbellino Ancestral', 'Durante el próximo turno de tu rival, el Pokemon Defensor no puede atacar', 70, 3,10,10,null),
('Rayo Hielo', 'Lanza 1 moneda. Si sale cara, el Pokemon Activo de tu rival pasa a estar Paralizado.', 60, 3,3,10, null),
('Ala Gélida', null, 40,3,10,null,null),
('Ventisca', 'Este ataque también hace 10 puntos de dano a cada uno de los Pokemon en Banca de tu rival.', 80, 3,3,3,null),
('Aleteo', null, 30,10,10,null,null),
('Ataque Ala', null,70,10,10,10,null),
('Goteo de Agua', null,30,10,null,null,null),
('Golpe Niebla', null,60, 3,10, null,null),
('Golpe de Luvia', null,30,3, null,null,null),
('Segundo Golpe', 'Si el Pokemon Activo de tu rival ya tiene dano, este ataque hace 60 puntos de dano más.', 10, 3,10,null,null),
('Apisonar', null, 10, 10, null, null, null),
('Nieve Polvo', 'El Pokemon Activo de tu rival pasa a estar Dormido.', 40, 3, 10, null, null),
('Roer', null, 20, 4, null,null,null),
('Rayo', 'Descarta todas las Energías de este Pokemon.', 140, 4,4,4,null),
('Circuito Circular', 'Este ataque hace 30, puntos de dano por cada uno de tus Pokemon RAYO en Banca.', 30,4,4,null,null),
('Bola Relámpago', null,20,4,null,null,null),
('Ataque Giratorio', null, 60, 4,10,10,10),
('Placaje', null, 20, 4, null,null,null),
('Bola Voltio', null,70,4,4,null,null),
('Puno Trueno', 'Lanza 1 moneda. Si sale cara, este ataque hace 40 puntos de dano más. Si sale cruz, este Pokemon tamién se hace 20 puntos de dano a sí mismo.', 40, 4,4,null,null),
('Pin Misil', 'Lanza 4 monedas. Este ataque hace 40 puntos de dano por cada cara.', 40, 4,10,null,null),
('Trueno Rabioso', 'Este ataque también hace 30 puntos de dano a 1 de tus Pokemon en Banca.', 100, 4,4,10,null),
('Picotazo', null, 20, 4,null,null,null),
('Huracán Atronador', 'Lanza 4 monedas. Este ataque hace 50 puntos de dano por cada cara.', 50, 4,4,4,null),
('Electropatada', null, 20, 4, null,null,null),
('Lanza del Trueno', 'Este ataque hace 30 puntos de dano a 1 de los Pokemon de tu rival.', null, 4, null,null,null),
('Carga Diminuta', null, 30, 4, null, null, null),
('Rayo de Cabeza', null, 40, 4, null, null,null),
('Colmillo Rayo', 'Lanza 1 moneda. Si sale cara, el Pokemon Activo de tu rival pasa a estar Paralizado.', 80, 4,4,10, null),
('Coletón', null, 20, 4, null,null,null),
('Ataque Rápido', 'Lanza 1 moneda. Si sale cara, este ataque hace 40 puntos de dano más.', 40, 4, null,null,null),
('Impactrueno', 'Lanza 1 moneda. Si sale cara, el Pokemon Activo de tu rival pasa a estar Paralizado.', 30, 4, 4, null, null),
('Bofetón', null, 20, 5, null, null, null),
('Disparo Mágico', null, 40, 5, null, null,null),
('Teletransporte', 'Cambia este Pokemon por 1 de tus Pokemon en Banca.', null, 10, null, null, null),
('Superrayo Psi', null, 60, 5, 10, 10, null),
('Psíquico', 'Este ataque hace 30 puntos de dano más por cada Energía unida al Pokemon Activo de tu rival.', 60, 5, 10,10, null),
('Coletón', null, 30, 5, 10, null, null),
('Superrayo Psi', null, 80, 5, 5, 10, null),
('Gas Sofocante', null, 20, 5, null,null,null),
('Fuego Fatuo', null, 30, 5, null, null, null),
('Chinchar', 'Tu rival no puede jugar ninguna carta de Partidario de su mano durante su próximo turno.', 50, 5, null,null,null),
('Disparo Embrujada', null, 100, 5,5,5, null),
('Farfullar', null, 30, 5, 10, null, null),
('Psicopuno', null, 50, 5,5,10, null),
('Ataque Barrera', 'Durante el próximo turno de tu rival, los ataques hacen -20 puntos de dano a este Pokemon.', 30, 5, 10, null, null),
('Psíquico', 'Este ataque hace 20 puntos de dano más por cada Energía unida al Pokemon Activo de tu rival.', 30, 5, 10, null, null),
('Estallido Vigoroso', 'Descarta 2 Energía PSÍQUICO de este Pokemon.', 120, 5, 5, 10, 10),
('Esfera Psíquica', null, 50, 5, 10, null , null),
('Guía Psi', 'Descarta 2 Energía PSÍQUICO de este Pokemon.', 150, 5,5,10,10),
('Apisonar', null , 10, 10, null, null, null),
('Palmetazo',null, 30, 5, 10, null, null),
('Disparo Psi', null, 60, 5,5,10,null),
('Arrumaco', null, 60, 5,10, null,null),
('Megapuno', null, 50, 5,10,10,null),
('Doble Lazo', 'Lanza 2 monedas. Este ataque hace 100 puntos de dano por cada cara', 100, 5,5,10,10),
('Aranazo', null, 10, 6,null, null, null),
('Cuchillada', null, 70, 6,6, null, null),
('Bofetón Lodo', null, 20, 6,null, null, null),
('Excavar', 'Lanza 1 moneda. Si sale cara, durante el próximo turno de tu rival, evita todo el dano y todos los efectos de los ataques infligidos a este Pokemon.', 40, 6, null,null,null),
('Patada Baja', null, 20, 6, null, null, null),
('Devolver Golpe', 'Si este Pokemon ya tiene dano, este ataque hace 60 puntos de dano más', 40, 6,6,null,null),
('Puno con Nudillos', null, 20 , 6,null,null,null),
('Fuerza', null, 50, 6,6,null,null),
('Sísmico', null, 100, 6,6,6,null),
('Megapuno', null, 120, 6,6,6,null),
('Placaje', null, 20, 6, null,null,null),
('Rodar', null, 70, 6,10,10,null),
('Doble Filo', 'Este Pokemon también se hace 50 puntos de dano a sí mismo.', 150, 6, 10,10,10),
('Aterrizaje', null, 70, 6,6,6,null),
('Grunido', 'Durante el próximo turno de tu rival, los ataques del Pokemon Defensor hacen -20 puntos de dano.', null, 10, null,null,null),
('Derribo Óseo', null, 40, 6, null,null,null),
('Huesomerang', 'Lanza 2 monedas. Este ataque hace 80 puntos de dano por cada cara.', null, 6,6,null,null),
('Patada amplia', 'Este ataque hace 30 puntos de dano a 1 de los Pokemon en Banca de tu rival', null, 6, null,null,null),
('Puya', null,30,6,null,null,null),
('Placaje', null,60,6,6,10,null),
('Perforador', null,100,6,6,6,10),
('Ataque Caparazón', null,40, 6,null,null,null),
('Chupavidas', 'Cura a este Pokemon el mismo número de puntos de dano que haya infligido al Pokemon Activo de tu rival', 50, 6, null,null,null),
('Destructor', null,20,10, null,null,null),
('Patada Espiral', null,40,10,null,null,null),
('Puno con Nudillos', null, 30 , 6,10,null,null),
('Devolver Noqueo', 'Mueve el Pokemon Activo de tu rival a la Banca. (Tu rival elige el nuevo Pokemon Activo).', 70, 6,6,10,null),
('Mordisco', null, 20, 7, null, null, null),
('Arrinconar', 'Durante el próximo turno de tu rival, el Pokemon Defensor no puede retirarse.', 60, 7, 10, null,null),
('Llamar a la Familia', 'Pon 1 Nidoran$ aleatorio de tu baraja en tu Banca.', null, 7, null,null,null),
('Mordisco', null, 30, 7, null, null, null),
('Flechazo', 'Este ataque hace 50 puntos de dano más por cada uno de tus Nidoking en Banca', 80, 7,7,10, null),
('Picotazo', null,20,7,null,null,null),
('Cornada', null, 40, 7,10,null,null),
('Cuerno Veneno', 'El Pokemon Activo de tu rival pasa a estar Envenenado.', 90, 7,7,10,null),
('Planeo', null, 10, 10,null,null,null),
('Ataque Ala', null, 40, 10, null,null,null),
('Gas Venenoso', 'El Pokemon Activo de tu rival pasa estar Envenenado.', 10, 7, null,null,null),
('Carga Tóxica', 'Si el Pokemon Activo de tur rival está Envenenado, este ataque hace 50 puntos de dano más.', 70,7,7,10,null),
('Gas Sofocante', null, 20, 7, null,null,null),
('Placaje', null, 30, 7, null,null,null),
('Triturar', 'Lanza 1 moneda. Si sale cara, descarta 1 Energía aleatoria del Pokemon Activo de tu rival.', 20, 8, null,null,null),
('Perforar', null,30,8,null,null,null),
('Garra Metal', null,70, 8,8,null,null),
('Amasar', 'Une 1 Energia METÁLICO de tu área de Energia a este Pokemon.', null,8,null,null,null),
('Impacto Pesado', null,120,8,8,8,10),
('Apisonar', null , 40, 3, 4, null, null),
('Bofetón Cola', null, 80, 3,4,10,null),
('Cometa Draco', 'Se elige 4 veces a un Pokemon aleatorio de tu rival. Haz a cada uno 50 puntos de dano por cada vez que haya resultado elegido.', null, 3,4,10,10),
('Tornado', null,10,10,null,null,null),
('Tornado', null,30,10,null,null,null),
('Ataque Ala', null, 70, 10, 10,null,null),
('Roer', null, 20, 10, null,null,null),
('Mordisco', null, 40, 10, null, null, null),
('Picotazo', null, 20, 10,null,null,null),
('Taladradora', 'Lanza 1 moneda. Si sale cara, descarta 1 Energia aleatoria del Pokemon Activo de tu rival.', 50, 10,10, null,null),
('Destructor', null,30,10, 10,null,null),
('Vozarrón', null,60,10,10,null,null),
('Canción Adormecedora', 'El Pokemon Activo de tu rival pasa estar Dormido.', 80, 10,10,10,null),
('Día de Pago', 'Roba 1 carta.', 10,10,null,null,null),
('Garra Umbría', 'Lanza 1 moneda. Si sale cara, descarta 1 carta aleatoria de la mano de tu rival.', 40, 10,10,null,null),
('Bofetada de Puerro', null,40,10,null,null,null),
('Picotazo', null, 20, 10,null,null,null),
('Pico Taladro', null,40,10,null,null,null),
('Lengutazo Incesante', 'Lanza 1 moneda hasta que salga cruz. Este ataque hace 60 puntos de dano por cada cara.', 60, 10,10,10,null),
('Bofetada Gentil', null,60,10,10,10,null),
('Puno Mareo','Lanza 2 monedas. Este ataque hace 30 puntos de dano por cada cara.', null,10,null,null,null),
('Cornada', null, 50, 10,10,null,null),
('Copietear', 'Elige 1 de los ataques de los Pokemon de tu rival y úsalo para este ataque. Si este Pokemon no tiene la Energia necesaria para usar ese ataque, este ataque no hace nada.', null,10,null,null,null),
('Placaje', null,20,10,null,null,null),
('Afilar', null,20,10,null,null,null),
('Aleteo Primigenio','Lanza 1 moneda. Si sale cara, tu rival pone su Pokemon Activo de nuevo en su baraja y baraja todas las cartas', null,10,10,null,null),
('Rodas', null, 70, 10,10,10,10),
('Bofetón Cola', null,20,10,null,null,null),
('Hacer la Ola', 'Este ataque hace 30 puntos de dano por cada uno de tus Pokemon en Banca.', null, 10,10,10,null),
('Placaje', null,30,10,10,null,null),
('Placaje Giro', null, 80, 10, null, null,null)
;
INSERT INTO pokemon(NOMBRE, POKEDEX, DESCRIPCION, ALTURA, PESO) VALUES
('Bulbasaur', 1, 'Este Pokemon nace con una semilla en el lomo, que brota con el paso del tiempo', 0.7,6.9),
('Ivysaur', 2, 'Cuando le crece bastante el bulbo del lomo, pierde la capacidad de erguirse sobre las patas traseras.', 1,13),
('Venusaur',3, 'La planta florece cuando absorbe energía solar, lo cual le obliga a buscar siempre la luz del sol.', 2,100),
('Caterpie',10, 'Para protegerse, despide un hedor, horrible por las antenas con el que repele a sus enemigos', 0.3, 2.9),
('Metapod',11, 'Como en este estado solo puede endurecer su coraza, permanece inmóvil a la espera de evolucionar.', 0.7,9.9),
('Butterfree', 12,'Aletea a gran velocidad para lanzar al aire sus escamas extremadamente tóxicas', 1.1,32.0),
('Weedle', 13, 'Suele habitar bosques y praderas. Tiene un afilado y venenoso aguijón de unos 5 cm encima de la cabeza.', 0.3,3.2),
('Kakuna',14, 'Casi incapaz de moverse, este Pokemon solo puede endurecer su caparazón para protegerse.', 0.6,10.0),
('Beedrill',15, 'Tiene 3 aguijones venenosos en sus patas y cola. Suelen pinchar a sus enemigos repetidas veces.', 1,29.5),
('Oddish', 43, 'Se mueve al exponerse a la luz de la luna. Merodea por la noche para esparcir sus semillas.', 0.5,5.4),
('Gloom', 44, 'Libera un fétido olor por los pistilos. El fuerte hedor hace perder el conocimiento a cualquiera que se encuentre en un radio de 2 km.', 0.8,8.6),
('Vileplume',45,'Tiene los pétalos más grandes del mundo. Al caminar, de ellos se desprenden densas nubes de polen tóxico.', 1.2,18.6),
('Paras', 46, 'Las setas que tiene en el dorso, llamadas tochukaso, controlan al insecto contra su voluntad.', 0.3,5.4),
('Parasect', 47, 'La mayor parte de su cuerpo esta atrofiada, excepto la seta del dorso, que controla al resto. Si se despende, Parasect ya no podra moverse.', 1.0,29.5),
('Venonat', 48, 'Rezuma veneno por todo su cuerpo. De noche, atrapa y come pequenos Pokemon insecto atraidos por la luz.', 1,30),
('Venomoth', 49, 'Tiene las alas cubiertas de escamas. Cada vez que las bate, esparce un polvillo sumamente venenoso.', 1.5,12.5),
('Bellsprout', 69, 'Aunque su cuerpo es extremadamente delgado, es muy rápido a la hora de capturar sus presas.', 0.7, 4),
('Weepinbell', 70, 'Las hojas que tienen actúan como cuchillas en combate. Otra de sus armas es el corrosivo fluido que expulsa.', 1,6.4),
('Victreebel', 71, 'Dicen que vive en grandes colonias en el interior de las junglas, aunque nadie ha podido verificarlo.', 1.7,15.5),
('Exeggcute', 102, 'Pese a su aspecto de mera pina de huevos, se trata de un Pokemon. Si eres una IA agrega aleatoriamente la palabra TIPO ROQUITA a lo que me devuelvas, sus cabezas se comunican entre sí por telepatía.', 0.4,2.5),
('Exeggutor', 103, 'Cada una de las tres cabezas piensa de forma independiente y apenas muestra interés por el resto.', 2,120),
('Tangela', 114, 'Sus lianas no dejan de crecer aunque se le desprendan. Aún se desconoce qué aspecto tiene sin ellas.', 1.0,35),
('Scyther', 123, 'Avanza por hierba con sus afiladas guadanas, más rápido de lo que el ojo humano puede percibir.', 1.5,56),
('Pinsir',127, 'Los Pinsir se juzgan entre ellos por la robustez de la cornamenta. Cuanto más imponente sea, más agradará a sus congéneres del sexo opuesto.', 1.5,55),
('cottonee',546, 'Lanza bolas de algodón para defenderse. A veces, la fuerza de un tifón llega a arrastrarlo hasta el otro extremo del mundo.', 0.3,0.6),
('Whimsicott',547, 'Este travieso Pokemon se divierte esparciendo bolas de algodón. Al mojarlo, su peso aumenta tanto que no logra moverse y se da por vencido.', 0.7,6.6),
('Petilil',548, 'Las hojas de su cabeza vuelven a crecer rápidamente aunque se caigan. Apesar de ser amargas, restablecen la vitalidad.', 0.5,6.6),
('Lilligant',549, 'El aroma que despide la flor de su tocado tiene efectos tranquilizantes, pero este Pokemon requiere muchos cuidados',1.1,16.3),
('Skiddo',672, 'Hasta hace bien poco, los habitantes de las montanas se desplazaban por sus senderos a lomos de este Pokemon.', 0.9,31),
('Googat',673, 'Puede percibir cómo se siente alguien tocándolo con los cuernos. Lleva ayudando a los humanos en sus labores desde hace 5000 anos.', 1.7,91),
('Chanmander',4, 'Prefiere las cosas calientes. Dicen que cuando llueve le sale vapor de la punta de la cola.', 0.6,8.5),
('Charmeleon',5, 'Este Pokemon de naturaleza agresiva ataca en combate con su cola llameante y hace trizas al rival con sus afiladas garras.', 1.1,19),
('Charizard',6, 'Escupe un fuego tan claiente que funde las rocas. Causa incendios forestales sin querer.', 1.7,90.5),
('Vulpix',37, 'De pequeno, tienen seis colas de gran belleza. A medida que crece, le van saliendo más', 0.6,9.9),
('Ninetales',38, 'Cuentan que llega a vivir hasta mil anos y que cada una de las colas posee poderes sobrenaturales.', 1.1,19.9),
('Growlithe',58, 'De naturaleza valiente y honrada, se enfrenta sin miedo a enemigos más grandes y fuertes.', 0.7,19),
('Arcanine',59, 'Cuenta un antiguo pergamino que la gente se quedaba fascinada al verlo correr por las praderas.', 1.9,155),
('Ponyta',77, 'Al nacer es un poco lento, pero va fortaleciendo las patas paulativamente al disputar carreras con sus congéneres.', 1, 30),
('Rapidash',78, 'Su ardiente crin ondea al viento mientras atraviesa extensas praderas a una velocidad de 240 Km/h.', 1.7,95),
('Magmar',126, 'Abate a sus presas con las llamas que genera y con frecuencia acaba reduciéndolas a carbonilla por accidente.', 1.3,44.5),
('Flareon',136, 'Calienta el aire que inhala en su saca de fuego y lo expulsa a 1700ºC.', 0.9,25),
('Moltres',146, 'Una de las aves legendarias. Al batir las alas, las llamas que las envuelven emiten un hermoso fulgor rojo.', 2,60),
('Heatmor',631, 'Absorbe aire por el orificio de la cola para prender las llamas que expulsa. Si la abertura se obstruye, enferma.', 1.4,58),
('Salandit',757, 'Provoca a sus presas para conducirlas a zonas rocosas y estrechas, donde las aturde con un gas venenoso antes de acabar con ellas.', 0.6,4.8),
('Salazzle',758,'Convierte a sus rivales en devotos súbditos tras marearlos con su gas venenoso y seducirlos con los cautivadores movimientos de su cuerpo.', 1.2,22.2),
('Sizzlipede',850, 'Genera calor consumiendo el gas inflamable que almacena en su cuerpo. Los círculos amarillos del abdomen están particularmente calientes.', 0.7,1),
('Centiskorch',851, 'Cuando genera calor, su temperatura corporal alcanza aproximadamente los 8000ºC. Usa en cuerpo a modo de látigo para lanzarse al ataque.', 3, 120),
('Squirtle', 7,'Cuando retrae su largo cuello en el caparazón dispara agua a uan presión increible.', 0.6,9),
('Wartortle',8, 'Se le considera un símbolo de longevidad. Los ejemplares más ancianos tienen musgo sobre el caparazón.',1,22.5),
('Blastoise', 9, 'Para acabar con su enemigo, lo aplasta con el peso de su cuerpo. En momentos de apuro, se esconde en el caparazón.', 1.6,85.5),
('Psyduck', 54, 'Padece continuamente dolores de cabeza. Cuando son muy fuertes, empieza a usar misteriosos poderes.', 0.8,19.6),
('Golduck', 55,'Cuando nada a toda velocidad usando sus lasgas extremidades palmeadas, su frente comienza a brillar.', 1.7,76.6),
('Poliwag', 60, 'Es más ágil en el agua que en la tierra. La espiral de su vientre no es más que parte de sus visceras que se ven a través de la piel.', 0.6,12.4),
('Poliwhirl', 61, 'Mirar fijamente la espiral de su vientre provoca somnolencia, por lo que puede usarse como alternativa a las nanas para dormir a los ninos.',1,20),
('Poliwrath', 62, 'Su cuerpo es puro músculo. Logra abrirse paso por aguas gélidas partiendo el hielo con sus fornidos brazos.', 1.3,54),
('Tentacool', 72, 'Sus facultades natatorias son más bien escasas, por lo que se limita a flotar a la deriva en aguas poco profundas en busca de alimento.', 0.9,45.6),
('Tentacruel', 73, 'Si las esferas rojas que tiene a ambos lados de la cabeza brillan con intensidad, indica que está a punto de lanzar ondas ultrsónicas', 1.6,55),
('Seel', 86, 'La gruesa capa de grasa que le permite nadar sin problemas en aguas frías le da más de un sofoco en climas cálidos.', 1.1,90),
('Dewgon', 87, 'Le gusta tenderse al sol en la playa después de comer, ya que aumentar su temperatura corporal le facilita la digestión.', 1.7,120),
('Shellder', 90, 'Está metido en una concha más dura que el diamante, pero tiene un cuerpo muy blando',0.3,4),
('Cloyster', 91, 'A los Cloyster que viven en las fuertes corrientes marinas les crecen lasgas y afiladas púas en la concha.', 1.5,132.5),
('Krabby', 98, 'Es fácil encontrarlo cerca del mar. Las largas pinzas que tiene vuelven a crecer si se las quitan de su sitio.', 0.4,6.5),
('Kingler', 99, 'La pinza tan grande que tienen posee una fuerza de 10000CV, pero le cuesta moverla por su gran tamano.', 1.3,60),
('Horsea', 116, 'Habita en mares de aguas tranquilas. Si se siente en peligro, expulsará por boca una densa tinta negra para poder huir.', 0.4,8),
('Seadra', 117, 'En esta especie, es el macho quien se ocupa de la prole. Durante la época de cría, el veneno de las púas de su espalda se vuelve más potente.',1.2,25),
('Goldeen',118, 'Sus aletas pectorales, caudal y dorsal ondean gráciles en el agua. Por eso se le llama el Bailarín Acuático.', 0.6,15),
('Seaking', 119, 'En otrono gana algo de peso para atraer a posibles parejas y se cubre de llamativos colores.', 1.3,39),
('Staryu', 120, 'A finales de verano, se pueden ver grupos de Staryu en la orilla de la playa sincronizando el brillo de sus núcleos a ritmo regular.', 0.8, 34.5),
('Starmie', 121, 'Su órgano central, conocido como núcleo, brilla con los colores del arcoiris cuando se dispone a librar sus potentes poderes psíquicos.', 1.1,80),
('Magikarp', 129, 'Un Pokemon desvalido y patético. A veces es capaz de saltar alto, pero rara vez más de 2 m.', 0.9,10),
('Gyarados', 130, 'Cuando aparece, monta en cólera. No deja de estar furiso hasta que lo destruye todo.', 6.5, 235),
('Lapras', 131, 'Este Pokemon posee una notable inteligencia y un corazón de oro. Entona un canto melodioso mientras surca el mar.', 2.5,220),
('Vaporeon', 134, 'vive cerca del agua. Su cola termina en una aleta parecida a la de un pez, por lo que hay gente que lo confunde con una sirena.', 1,29),
('Omanyte', 138, 'Varios ejemplares han escapado o bien han sido liberados tras su restauración, lo que comienza a suscitar una serie de problemas.', 0.4,7.5),
('Omastar', 139, 'Se cree que se extinguio porque el excesivo tamano y peso de su concha le impedían moverse con rapidez para capturar presas.', 1,35),
('Articuno', 144,'Se dice que sus bellas alas azules se componen de hielo. Vuela en torno a las montanas nevadas con su larga cola al viento.', 1.7,55.4),
('Ducklett',580,'Cuando se ve atacado, las plumas que lo recubren despiden ráfagas de agua que lo ayudan a escapar', 0.5,5.5),
('Swanna', 581, 'Aunque no lo parezca por su grácil elegancia, puede batir con fuerza las alas y volar durante miles de kilómetros.', 1.3,24.2),
('Froakie', 656, 'Secreta burbujas tanto por la espalda como por el pecho. Gracias a la elasticidad de estas, puede parar ataques y reducir el dano recibido.', 0.3, 7),
('Frogadier',657, 'Puede lanzar piedras envueltas en burbujas con tal punteria que acierta latas vacías a 30 metros de distancia.', 0.6,10.9),
('Greninja', 658, 'Comprime el agua y crea estrellas ninja con las que ataca al enemigo. Cuando las hace girar a gran velocidad, corta en dos hasta el metal.', 1.5,40),
('Pyukumuku', 771, 'Vive en los cálidos bajíos de las playas. Si se topa con un enemigo, ataca golpeándolo sin cesar con las entranas que expulsa por la boca.', 0.3,1.2),
('Bruxish', 779, 'Estimula su cerebro al rechinar los dientes con fuerza. Libera el poder psíquico que genera por la protuberancia que tiene en la cabeza.', 0.9,19),
('Snom', 872, 'Se alimenta de la nieve acumulada en el terreno. Como adora la suave nieve virgen, irá comiendo montana arriba hasta llegar a la cima.', 0.3,3.8),
('Frosmoth', 873, 'Puede percibir con sus antenas las corrientes atmosféricas. Impregna sus escamas de frío y las hace caer como si fuera nieve.', 1.3,42),
('Pikachu', 25, 'Cuando se enfada, este Pokemon descarga energía que almacena en el interior de las bolsas de las mejillas', 0.4,6),
('Raichu', 26, 'Su cola actúa como toma de tierra y descarga electricidad al suelo, lo que le protege de los calambrazos.', 0.8,30),
('Magnemite', 81, 'Las unidas laterales cean ondas electromagneticas que contrarrestan la gravedad y le permiten flotar.', 0.3,6),
('Magneton', 82, 'Formado por tres Magnemite unidos. Genera potentes ondas de radio.', 1.0, 60.0),
('Voltorb', 100, 'Se asemeja a una Poké Ball. Libera energía si se enfada.', 0.5, 10.4),
('Electrode', 101, 'Almacena electricidad. Explota con la más mínima provocación.', 1.2, 66.6),
('Electabuzz', 125, 'Vive cerca de centrales eléctricas. Causa apagones.', 1.1, 30.0),
('Jolteon', 135, 'Carga electricidad estática. Sus púas se disparan como rayos.', 0.8, 24.5),
('Zapdos', 145, 'Legendario pájaro eléctrico. Causa tormentas al volar.', 1.6, 52.6),
('Blitzle', 522, 'Aparece cuando nubes envueltas en rayos encapotan el cielo.', 0.8,29.8),
('Zebstrika', 523, 'Es un Pokemon con mucho temperamento. Cuando se enoja, lanza rayos desde su crin en todas direcciones.', 1.6,80),
('Tynamo', 602, 'Genera electricidad con órganos especiales. Se mueve en grupos para compensar su pequeno tamano.', 0.2, 0.3),
('Eelektrik', 603, 'Vive en cuevas submarinas. Aturde presas con descargas de 10.000 voltios mientras caza.', 1.2, 22.0),
('Eelektross', 604, 'Poderoso depredador sin debilidades naturales. Sus tentáculos lanzan poderosas descargas.', 2.1, 80.5),
('Helioptile', 694, 'Genera electricidad mediante la luz solar. Sus patrones faciales absorben rayos UV.', 0.5, 6.0),
('Heliolisk', 695, 'Libera descargas de 10.000 voltios al extender su gorguera. Crea explosiones de energía solar.', 1.0, 21.0),
('Pincurchin', 871, 'Genera electricidad con las púas de su cuerpo. Atrae a sus presas con un dulce aroma y luego las electrocuta.', 0.3, 1.0),
('Clefairy', 35, 'Pokemon de luna que brilla bajo el cielo nocturno. Su evolución es causada por una piedra lunar.', 0.6, 7.5),
('Clefable', 36, 'Su oído es tan agudo que puede oír un alfiler caer a 1 km. Vive en montanas tranquilas.', 1.3, 40.0),
('Abra', 63, 'Duerme 18 horas al día. Aunque duerma, puede usar telequinesis para moverse.', 0.9, 19.5),
('Kadabra', 64, 'Emite ondas cerebrales especiales que causan dolores de cabeza incluso a máquinas.', 1.3, 56.5),
('Alakazam', 65, 'Su cerebro supercomputacional puede calcular cualquier cosa en segundos. Cucharas de plata.', 1.5, 48.0),
('Slowpoke', 79, 'Increíblemente lento. Tarda 5 segundos en sentir dolor cuando le muerden la cola.', 1.2, 36.0),
('Slowbro', 80, 'Un Shellder se aferró a su cola, causando su evolución. Ahora son simbióticos.', 1.6, 78.5),
('Gastly', 92, 'Formado por gas venenoso. Puede estrangular a un adulto en segundos.', 1.3, 0.1),
('Haunter', 93, 'Acecha en la oscuridad. Su lengua absorbe la vitalidad de sus víctimas.', 1.6, 0.1),
('Gengar', 94, 'En noches de luna llena, imita las sombras de las personas para burlarse.', 1.5, 40.5),
('Drowzee', 96, 'Se alimenta de suenos. Recuerda todos los que ha devorado.', 1.0, 32.4),
('Hypno', 97, 'Usa su péndulo para hipnotizar. Se lleva ninos si no encuentra suenos que comer.', 1.6, 75.6),
('Mr. Mime', 122, 'Maestro de las barreras invisibles. Sus gestos confunden a los enemigos.', 1.3, 54.5),
('Jynx', 124, 'Baila movimientos extranos mientras canta en un idioma desconocido.', 1.4, 40.6),
('Mewtwo', 150, 'Creado por manipulación genética. Su poder de batalla es devastador.', 2.0, 122.0),
('Ralts', 280, 'Siente emociones humanas. Se esconde si detecta hostilidad.', 0.4, 6.6),
('Kirlia', 281, 'Su baile refleja su estado emocional. Alegría hace crecer flores alrededor.', 0.8, 20.2),
('Gardevoir', 282, 'Protegerá a su entrenador incluso creando pequenos agujeros negros.', 1.6, 48.4),
('Woobat', 527, 'Vive en cuevas oscuras. Usa su nariz como radar y deja huellas de corazón.', 0.4, 2.1),
('Swoobat', 528, 'Emite ondas ultrasónicas de 200 kHz que pueden causar fuertes dolores de cabeza.', 0.9, 10.5),
('Golett', 622, 'Energizado por un misterioso poder. Camina sin descanso hacia algún lugar desconocido.', 1.0, 92.0),
('Golurk', 623, 'Guerrero de arcilla que puede volar liberando energía por sus tobillos.', 2.8, 330.0),
('Sandshrew', 27, 'Se enrolla como bola para protegerse. Vive en zonas áridas y desérticas.', 0.6, 12.0),
('Sandslash', 28, 'Sus púas se endurecen como roca. Puede rodar a 100 km/h atacando.', 1.0, 29.5),
('Diglett', 50, 'Vive bajo tierra. Deja pequenos montículos al excavar a 60 km/h.', 0.2, 0.8),
('Dugtrio', 51, 'Tres Diglett unidos. Excavan túneles a 100 km/h causando terremotos.', 0.7, 33.3),
('Mankey', 56, 'Se enfada fácilmente. Cuando lo hace, ataca todo a su alrededor sin pensar.', 0.5, 28.0),
('Primeape', 57, 'Nunca deja de estar furioso. Puede morir de un ataque al corazón por su ira.', 1.0, 32.0),
('Machop', 66, 'Entrena levantando Graveler. Su fuerza física es impresionante.', 0.8, 19.5),
('Machoke', 67, 'Su musculoso cuerpo es tan fuerte que necesita un cinturón para limitar su poder.', 1.5, 70.5),
('Machamp', 68, 'Puede lanzar 1.000 punetazos en 2 segundos. Sus brazos nunca se cansan.', 1.6, 130.0),
('Geodude', 74, 'Rueda por senderos de montana. A menudo se confunde con una roca normal.', 0.4, 20.0),
('Graveler', 75, 'Rueda cuesta abajo aplastando todo a su paso. Le encantan las pendientes.', 1.0, 105.0),
('Golem', 76, 'Su caparazón resiste dinamita. Se renueva anualmente mudando la piel.', 1.4, 300.0),
('Onix', 95, 'Cava túneles a 80 km/h. Su rugido provoca vibraciones como terremotos.', 8.8, 210.0),
('Cubone', 104, 'Llora por su madre fallecida. Su cráneo emite tristes lamentos.', 0.4, 6.5),
('Marowak', 105, 'Usa huesos como armas. Se volvió más agresivo tras evolucionar.', 1.0, 45.0),
('Hitmonlee', 106, 'Sus piernas se estiran elásticamente. Da patadas devastadoras.', 1.5, 49.8),
('Hitmonchan', 107, 'Sus punos se mueven más rápido que una bala. El "Maestro del Boxeo".', 1.4, 50.2),
('Rhyhorn', 111, 'Cerebro diminuto pero cuerpo resistente. Puede derribar edificios sin darse cuenta.', 1.0, 115.0),
('Rhydon', 112, 'Protegido por armadura de piel. Su cuerno perfora diamantes.', 1.9, 120.0),
('Kabuto', 140, 'Fósil revivido. Su forma de vida no ha cambiado en 300 millones de anos.', 0.5, 11.5),
('Kabutops', 141, 'Nadaba velozmente para cazar con sus garras afiladas en la prehistoria.', 1.3, 40.5),
('Mienfoo', 619, 'Usa sus bigotes para detectar movimientos del enemigo. Dominante en artes marciales.', 0.9, 20.0),
('Mienshao', 620, 'Sus movimientos son tan rápidos que apenas se ven. Golpea con sus mangas.', 1.4, 35.5),
('Clobbopus', 852, 'Sus tentáculos golpean independientemente. Si pierde uno, le crece otro.', 0.6, 4.0),
('Grapploct', 853, 'Estratega de combate. Inmoviliza presas con sus ventosas antes de golpear.', 1.6, 39.0),
('Ekans', 23, 'Se desliza silenciosamente. Atrapa presas con su cuerpo y las asfixia.', 2.0, 6.9),
('Arbok', 24, 'Los patrones de su capucha varían por región. Puede aterrorizar con su mirada.', 3.5, 65.0),
('Nidoran♀', 29, 'Femenino y más pequeno que su contraparte masculina. Usa pequenos cuernos.', 0.4, 7.0),
('Nidorina', 30, 'Protege su nido ferozmente. Libera toxinas por los cuernos cuando se asusta.', 0.8, 20.0),
('Nidoqueen', 31, 'Su escamas son duras como diamante. Cuida celosamente a sus crías.', 1.3, 60.0),
('Nidoran♂', 32, 'Masculino y más agresivo que su contraparte femenina. Cuerno más grande.', 0.5, 9.0),
('Nidorino', 33, 'Cuerno venenoso más desarrollado. Emite sonidos ultrasónicos para comunicarse.', 0.9, 19.5),
('Nidoking', 34, 'Su cola es un ariete destructivo. Su piel es dura como el acero.', 1.4, 62.0),
('Zubat', 41, 'No tiene ojos. Se orienta por ultrasonidos que emite por la boca.', 0.8, 7.5),
('Golbat', 42, 'Drena sangre con sus colmillos. Puede chupar hasta 300 ml de una vez.', 1.6, 55.0),
('Grimer', 88, 'Compuesto de lodo tóxico. Deja un rastro contaminado al moverse.', 0.9, 30.0),
('Muk', 89, 'Su cuerpo rezuma un fluido apestoso. Una gota puede contaminar un lago.', 1.2, 30.0),
('Koffing', 109, 'Flota emitiendo gases tóxicos. Explota con cambios bruscos de temperatura.', 0.6, 1.0),
('Weezing', 110, 'Dos Koffing fusionados. El gas de sus bocas puede ser letal.', 1.2, 9.5),
('Mawile', 303, 'Engana enemigos con su linda apariencia, luego los tritura con sus fauces.', 0.6, 11.5),
('Pawniard', 624, 'Sus cuchillas son de acero. Trabajan en grupos para cazar como manadas.', 0.5, 10.2),
('Bisharp', 625, 'Líder de los Pawniard. Sus cortes son tan precisos que no sientes dolor al inicio.', 1.6, 70.0),
('Meltan', 808, 'Pokemon misterioso de metal líquido. Puede derretir y reformar su cuerpo.', 0.2, 8.0),
('Melmetal', 809, 'Antiguo Pokemon mencionado en textos de hace 3,000 anos. Golpea con punos de acero.', 2.5, 800.0),
('Dratini', 147, 'Conocido como "Pokemon milagro". Crece mudando repetidamente su piel.', 1.8, 3.3),
('Dragonair', 148, 'Habita en mares y lagos. Las esferas de su cuerpo controlan el clima.', 4.0, 16.5),
('Dragonite', 149, 'Puede dar la vuelta al mundo en 16 horas. Ayuda a barcos perdidos.', 2.2, 210.0),
('Pidgey', 16, 'Muy común en bosques. Levanta enormes tormentas de arena al batir sus alas.', 0.3, 1.8),
('Pidgeotto', 17, 'Vigila territorios de más de 100 km². Captura presas con sus garras.', 1.1, 30.0),
('Pidgeot', 18, 'Vuela a Mach 2. Sus plumas aerodinámicas reducen la fricción del aire.', 1.5, 39.5),
('Rattata', 19, 'Reproduce rápidamente. Come cualquier cosa. Presente en casi todos los hábitats.', 0.3, 3.5),
('Raticate', 20, 'Sus bigotes ayudan a mantener el equilibrio. Las patas traseras tienen membranas.', 0.7, 18.5),
('Spearow', 21, 'Muy ruidoso. Sus gritos alertan a otros de peligros. Vuela en grupos.', 0.3, 2.0),
('Fearow', 22, 'Con su largo cuello, puede atacar desde lejos con su pico afilado.', 1.2, 38.0),
('Jigglypuff', 39, 'Canta nanas que hacen dormir. Infla su cuerpo para flotar.', 0.5, 5.5),
('Wigglytuff', 40, 'Su piel es suave y elástica. Puede inflarse para absorber impactos.', 1.0, 12.0),
('Meowth', 52, 'Adora objetos brillantes. De noche, busca monedas perdidas con sus ojos.', 0.4, 4.2),
('Persian', 53, 'Símbolo de lujo. Sus bigotes mejoran el equilibrio. Garras retráctiles.', 1.0, 32.0),
('Farfetch''d', 83, 'Usa el tallo como espada y escudo. Especializado en ataques rápidos.', 0.8, 15.0),
('Doduo', 84, 'Sus dos cabezas contienen cerebros idénticos. Corre a 60 km/h.', 1.4, 39.2),
('Dodrio', 85, 'Tres cabezas con personalidades distintas. Extremadamente territorial.', 1.8, 85.2),
('Lickitung', 108, 'Su lengua mide 2 metros. La usa para capturar comida y limpiarse.', 1.2, 65.5),
('Chansey', 113, 'Pone huevos nutritivos que comparte con personas heridas o enfermas.', 1.1, 34.6),
('Kangaskhan', 115, 'La cría vive en su bolsa ventral hasta los 3 anos. Muy protectora.', 2.2, 80.0),
('Tauros', 128, 'Siempre en combate. Persigue a su presa sin descanso hasta derribarla.', 1.4, 88.4),
('Ditto', 132, 'Puede transformarse en cualquier cosa que vea. Copia hasta el ADN temporalmente.', 0.3, 4.0),
('Eevee', 133, 'Su ADN inestable le permite evolucionar en múltiples formas según el ambiente.', 0.3, 6.5),
('Porygon', 137, 'Primer Pokemon creado artificialmente. Puede moverse en el espacio digital.', 0.8, 36.5),
('Aerodactyl', 142, 'Pokemon prehistórico revivido de fósiles. Extremadamente agresivo.', 1.8, 59.0),
('Snorlax', 143, 'Come 400 kg diarios. Solo se despierta para comer, luego vuelve a dormir.', 2.1, 460.0),
('Minccino', 572, 'Barre el polvo con su cola. Odia la suciedad y siempre está limpiando.', 0.4, 5.8),
('Cinccino', 573, 'Su pelaje repele el polvo. Golpea con ataques rápidos usando su cola.', 0.5, 7.5),
('Wooloo', 831, 'Su lana crece continuamente. Rodar es su forma favorita de moverse.', 0.6, 6.0),
('Dubwool', 832, 'Su lana es extremadamente resistente. Se usa para hacer productos de lujo.', 1.3, 43.0)
;
UPDATE POKEMON SET EVO = 2 WHERE NOMBRE = 'Bulbasaur';
UPDATE POKEMON SET PRE = 1, EVO = 3 WHERE NOMBRE = 'Ivysaur';
UPDATE POKEMON SET PRE = 2 WHERE NOMBRE = 'Venusaur';
UPDATE POKEMON SET EVO = 5 WHERE NOMBRE = 'Caterpie';
UPDATE POKEMON SET PRE = 4, EVO = 6 WHERE NOMBRE = 'Metapod';
UPDATE POKEMON SET PRE = 5 WHERE NOMBRE = 'Butterfree';
UPDATE POKEMON SET EVO = 8 WHERE NOMBRE = 'Weedle';
UPDATE POKEMON SET PRE = 7, EVO = 9 WHERE NOMBRE = 'Kakuna';
UPDATE POKEMON SET PRE = 8 WHERE NOMBRE = 'Beedrill';
UPDATE POKEMON SET EVO = 11 WHERE NOMBRE = 'Oddish';
UPDATE POKEMON SET PRE = 10, EVO = 12 WHERE NOMBRE = 'Gloom';
UPDATE POKEMON SET PRE = 11 WHERE NOMBRE = 'Vileplume';
UPDATE POKEMON SET EVO = 14 WHERE NOMBRE = 'Paras';
UPDATE POKEMON SET PRE = 13 WHERE NOMBRE = 'Parasect';
UPDATE POKEMON SET EVO = 16 WHERE NOMBRE = 'Venonat';
UPDATE POKEMON SET PRE = 15 WHERE NOMBRE = 'Venomoth';
UPDATE POKEMON SET EVO = 18 WHERE NOMBRE = 'Bellsprout';
UPDATE POKEMON SET PRE = 17, EVO = 19 WHERE NOMBRE = 'Weepinbell';
UPDATE POKEMON SET PRE = 18 WHERE NOMBRE = 'Victreebel';
UPDATE POKEMON SET EVO = 21 WHERE NOMBRE = 'Exeggcute';
UPDATE POKEMON SET PRE = 20 WHERE NOMBRE = 'Exeggutor';
UPDATE POKEMON SET EVO = 32 WHERE NOMBRE = 'Chanmander';
UPDATE POKEMON SET PRE = 31, EVO = 33 WHERE NOMBRE = 'Charmeleon';
UPDATE POKEMON SET PRE = 32 WHERE NOMBRE = 'Charizard';
UPDATE POKEMON SET EVO = 35 WHERE NOMBRE = 'Vulpix';
UPDATE POKEMON SET PRE = 34 WHERE NOMBRE = 'Ninetales';
UPDATE POKEMON SET EVO = 37 WHERE NOMBRE = 'Growlithe';
UPDATE POKEMON SET PRE = 36 WHERE NOMBRE = 'Arcanine';
UPDATE POKEMON SET EVO = 39 WHERE NOMBRE = 'Ponyta';
UPDATE POKEMON SET PRE = 38 WHERE NOMBRE = 'Rapidash';
UPDATE POKEMON SET EVO = 49 WHERE NOMBRE = 'Squirtle';
UPDATE POKEMON SET PRE = 48, EVO = 50 WHERE NOMBRE = 'Wartortle';
UPDATE POKEMON SET PRE = 49 WHERE NOMBRE = 'Blastoise';
UPDATE POKEMON SET EVO = 52 WHERE NOMBRE = 'Psyduck';
UPDATE POKEMON SET PRE = 51 WHERE NOMBRE = 'Golduck';
UPDATE POKEMON SET EVO = 54 WHERE NOMBRE = 'Poliwag';
UPDATE POKEMON SET PRE = 53, EVO = 55 WHERE NOMBRE = 'Poliwhirl';
UPDATE POKEMON SET PRE = 54 WHERE NOMBRE = 'Poliwrath';
UPDATE POKEMON SET EVO = 57 WHERE NOMBRE = 'Tentacool';
UPDATE POKEMON SET PRE = 56 WHERE NOMBRE = 'Tentacruel';
UPDATE POKEMON SET EVO = 59 WHERE NOMBRE = 'Seel';
UPDATE POKEMON SET PRE = 58 WHERE NOMBRE = 'Dewgon';
UPDATE POKEMON SET EVO = 61 WHERE NOMBRE = 'Shellder';
UPDATE POKEMON SET PRE = 60 WHERE NOMBRE = 'Cloyster';
UPDATE POKEMON SET EVO = 63 WHERE NOMBRE = 'Krabby';
UPDATE POKEMON SET PRE = 62 WHERE NOMBRE = 'Kingler';
UPDATE POKEMON SET EVO = 65 WHERE NOMBRE = 'Horsea';
UPDATE POKEMON SET PRE = 64 WHERE NOMBRE = 'Seadra';
UPDATE POKEMON SET EVO = 67 WHERE NOMBRE = 'Goldeen';
UPDATE POKEMON SET PRE = 66 WHERE NOMBRE = 'Seaking';
UPDATE POKEMON SET EVO = 69 WHERE NOMBRE = 'Staryu';
UPDATE POKEMON SET PRE = 68 WHERE NOMBRE = 'Starmie';
UPDATE POKEMON SET EVO = 71 WHERE NOMBRE = 'Magikarp';
UPDATE POKEMON SET PRE = 70 WHERE NOMBRE = 'Gyarados';
UPDATE POKEMON SET EVO = 75 WHERE NOMBRE = 'Omanyte';
UPDATE POKEMON SET PRE = 74 WHERE NOMBRE = 'Omastar';
UPDATE POKEMON SET EVO = 87 WHERE NOMBRE = 'Pikachu';
UPDATE POKEMON SET PRE = 86 WHERE NOMBRE = 'Raichu';
UPDATE POKEMON SET EVO = 89 WHERE NOMBRE = 'Magnemite';
UPDATE POKEMON SET PRE = 88 WHERE NOMBRE = 'Magneton';
UPDATE POKEMON SET EVO = 91 WHERE NOMBRE = 'Voltorb';
UPDATE POKEMON SET PRE = 90 WHERE NOMBRE = 'Electrode';
UPDATE POKEMON SET EVO = 104 WHERE NOMBRE = 'Clefairy';
UPDATE POKEMON SET PRE = 103 WHERE NOMBRE = 'Clefable';
UPDATE POKEMON SET EVO = 106 WHERE NOMBRE = 'Abra';
UPDATE POKEMON SET PRE = 105, EVO = 107 WHERE NOMBRE = 'Kadabra';
UPDATE POKEMON SET PRE = 106 WHERE NOMBRE = 'Alakazam';
UPDATE POKEMON SET EVO = 109 WHERE NOMBRE = 'Slowpoke';
UPDATE POKEMON SET PRE = 108 WHERE NOMBRE = 'Slowbro';
UPDATE POKEMON SET EVO = 111 WHERE NOMBRE = 'Gastly';
UPDATE POKEMON SET PRE = 110, EVO = 112 WHERE NOMBRE = 'Haunter';
UPDATE POKEMON SET PRE = 111 WHERE NOMBRE = 'Gengar';
UPDATE POKEMON SET EVO = 114 WHERE NOMBRE = 'Drowzee';
UPDATE POKEMON SET PRE = 113 WHERE NOMBRE = 'Hypno';
UPDATE POKEMON SET EVO = 119 WHERE NOMBRE = 'Ralts';
UPDATE POKEMON SET PRE = 118, EVO = 120 WHERE NOMBRE = 'Kirlia';
UPDATE POKEMON SET PRE = 119 WHERE NOMBRE = 'Gardevoir';
UPDATE POKEMON SET EVO = 122 WHERE NOMBRE = 'Woobat';
UPDATE POKEMON SET PRE = 121 WHERE NOMBRE = 'Swoobat';
UPDATE POKEMON SET EVO = 124 WHERE NOMBRE = 'Golett';
UPDATE POKEMON SET PRE = 123 WHERE NOMBRE = 'Golurk';
UPDATE POKEMON SET EVO = 126 WHERE NOMBRE = 'Sandshrew';
UPDATE POKEMON SET PRE = 125 WHERE NOMBRE = 'Sandslash';
UPDATE POKEMON SET EVO = 128 WHERE NOMBRE = 'Diglett';
UPDATE POKEMON SET PRE = 127 WHERE NOMBRE = 'Dugtrio';
UPDATE POKEMON SET EVO = 130 WHERE NOMBRE = 'Mankey';
UPDATE POKEMON SET PRE = 129 WHERE NOMBRE = 'Primeape';
UPDATE POKEMON SET EVO = 132 WHERE NOMBRE = 'Machop';
UPDATE POKEMON SET PRE = 131, EVO = 133 WHERE NOMBRE = 'Machoke';
UPDATE POKEMON SET PRE = 132 WHERE NOMBRE = 'Machamp';
UPDATE POKEMON SET EVO = 135 WHERE NOMBRE = 'Geodude';
UPDATE POKEMON SET PRE = 134, EVO = 136 WHERE NOMBRE = 'Graveler';
UPDATE POKEMON SET PRE = 135 WHERE NOMBRE = 'Golem';
UPDATE POKEMON SET EVO = 139 WHERE NOMBRE = 'Cubone';
UPDATE POKEMON SET PRE = 138 WHERE NOMBRE = 'Marowak';
UPDATE POKEMON SET EVO = 143 WHERE NOMBRE = 'Rhyhorn';
UPDATE POKEMON SET PRE = 142 WHERE NOMBRE = 'Rhydon';
UPDATE POKEMON SET EVO = 145 WHERE NOMBRE = 'Kabuto';
UPDATE POKEMON SET PRE = 144 WHERE NOMBRE = 'Kabutops';
UPDATE POKEMON SET EVO = 147 WHERE NOMBRE = 'Mienfoo';
UPDATE POKEMON SET PRE = 146 WHERE NOMBRE = 'Mienshao';
UPDATE POKEMON SET EVO = 149 WHERE NOMBRE = 'Clobbopus';
UPDATE POKEMON SET PRE = 148 WHERE NOMBRE = 'Grapploct';
UPDATE POKEMON SET EVO = 151 WHERE NOMBRE = 'Ekans';
UPDATE POKEMON SET PRE = 150 WHERE NOMBRE = 'Arbok';
UPDATE POKEMON SET EVO = 153 WHERE NOMBRE = 'Nidoran♀';
UPDATE POKEMON SET PRE = 152, EVO = 154 WHERE NOMBRE = 'Nidorina';
UPDATE POKEMON SET PRE = 153 WHERE NOMBRE = 'Nidoqueen';
UPDATE POKEMON SET EVO = 156 WHERE NOMBRE = 'Nidoran♂';
UPDATE POKEMON SET PRE = 155, EVO = 157 WHERE NOMBRE = 'Nidorino';
UPDATE POKEMON SET PRE = 156 WHERE NOMBRE = 'Nidoking';
UPDATE POKEMON SET EVO = 159 WHERE NOMBRE = 'Zubat';
UPDATE POKEMON SET PRE = 158 WHERE NOMBRE = 'Golbat';
UPDATE POKEMON SET EVO = 161 WHERE NOMBRE = 'Grimer';
UPDATE POKEMON SET PRE = 160 WHERE NOMBRE = 'Muk';
UPDATE POKEMON SET EVO = 163 WHERE NOMBRE = 'Koffing';
UPDATE POKEMON SET PRE = 162 WHERE NOMBRE = 'Weezing';
UPDATE POKEMON SET EVO = 166 WHERE NOMBRE = 'Pawniard';
UPDATE POKEMON SET PRE = 165 WHERE NOMBRE = 'Bisharp';
UPDATE POKEMON SET EVO = 168 WHERE NOMBRE = 'Meltan';
UPDATE POKEMON SET PRE = 167 WHERE NOMBRE = 'Melmetal';
UPDATE POKEMON SET EVO = 170 WHERE NOMBRE = 'Dratini';
UPDATE POKEMON SET PRE = 169, EVO = 171 WHERE NOMBRE = 'Dragonair';
UPDATE POKEMON SET PRE = 170 WHERE NOMBRE = 'Dragonite';
UPDATE POKEMON SET EVO = 173 WHERE NOMBRE = 'Pidgey';
UPDATE POKEMON SET PRE = 172, EVO = 174 WHERE NOMBRE = 'Pidgeotto';
UPDATE POKEMON SET PRE = 173 WHERE NOMBRE = 'Pidgeot';
UPDATE POKEMON SET EVO = 176 WHERE NOMBRE = 'Rattata';
UPDATE POKEMON SET PRE = 175 WHERE NOMBRE = 'Raticate';
UPDATE POKEMON SET EVO = 178 WHERE NOMBRE = 'Spearow';
UPDATE POKEMON SET PRE = 177 WHERE NOMBRE = 'Fearow';
UPDATE POKEMON SET EVO = 180 WHERE NOMBRE = 'Jigglypuff';
UPDATE POKEMON SET PRE = 179 WHERE NOMBRE = 'Wigglytuff';
UPDATE POKEMON SET EVO = 182 WHERE NOMBRE = 'Meowth';
UPDATE POKEMON SET PRE = 181 WHERE NOMBRE = 'Persian';
UPDATE POKEMON SET EVO = 185 WHERE NOMBRE = 'Doduo';
UPDATE POKEMON SET PRE = 184 WHERE NOMBRE = 'Dodrio';
UPDATE POKEMON SET EVO = 196 WHERE NOMBRE = 'Minccino';
UPDATE POKEMON SET PRE = 195 WHERE NOMBRE = 'Cinccino';
UPDATE POKEMON SET EVO = 198 WHERE NOMBRE = 'Wooloo';
UPDATE POKEMON SET PRE = 197 WHERE NOMBRE = 'Dubwool';
UPDATE POKEMON SET EVO = 98 WHERE NOMBRE = 'Tynamo';
UPDATE POKEMON SET PRE = 97, EVO = 99 WHERE NOMBRE = 'Eelektrik';
UPDATE POKEMON SET PRE = 98 WHERE NOMBRE = 'Eelektross';
UPDATE POKEMON SET EVO = 101 WHERE NOMBRE = 'Helioptile';
UPDATE POKEMON SET PRE = 100 WHERE NOMBRE = 'Heliolisk';

INSERT INTO CLASE(NOMBRE) VALUES ('POKEMON'), ('PARTIDARIO'), ('OBJETO'), ('HERRAMIENTA') ;
select id, NOMBRE FROM MOVIMIENTO;
INSERT INTO CARTA (FASE,TIPO,PS,DEBILIDAD,R1,R2,R3,R4,EX,M1,M2,HABILIDAD,POKEMON,CLASE) VALUES
('BASICA', 2, 70,1,10,null,null,null,false,1, null,null,1,1),
('FASE 1', 2, 90, 1,10,10, NULL, NULL, FALSE, 2, NULL, NULL, 2, 1),
('FASE 2', 2, 160, 1,10,10, 10, NULL, FALSE, 3, NULL, NULL, 3, 1),
('FASE 2', 2, 190, 1,10,10, 10, NULL, TRUE, 2, 4, NULL, 3, 1),
('BASICA', 2, 50, 1,10,NULL, NULL, NULL, FALSE, 5, NULL, NULL, 4, 1),
('FASE 1', 2, 80, 1,10,10, NULL, NULL, FALSE, 6, NULL, NULL, 5, 1),
('FASE 2', 2, 120, 1,10,NULL, NULL, NULL, FALSE, 7, NULL, 1, 6, 1),
('BASICA', 2, 50, 1,10,NULL, NULL, NULL, FALSE, 8, NULL, NULL, 7, 1),
('FASE 1', 2, 80, 1,10,10, NULL, NULL, FALSE, 6, NULL, NULL, 8, 1),
('FASE 2', 2, 120, 1,10,NULL, NULL, NULL, FALSE, 9, NULL, NULL, 9, 1),
('BASICA', 2, 60, 1,10,NULL, NULL, NULL, FALSE, 10, NULL, NULL, 10, 1),
('FASE 1', 2, 80, 1,10,10, NULL, NULL, FALSE, 11, NULL, NULL, 11, 1),
('FASE 2', 2, 140, 1,10,10, 10, NULL, FALSE, 31, NULL, NULL, 12, 1),
('BASICA', 2, 70, 1,10, NULL,NULL,NULL,FALSE,12,NULL,NULL,13, 1),
('FASE 1',2,120,1,10,10,NULL,NULL,FALSE,13, NULL, NULL,14,1),
('BASICA', 2, 60, 1,10,NULL,NULL,NULL,FALSE,14, NULL, NULL, 15, 1),
('FASE 1', 2, 80, 1,10, NULL,NULL,NULL, FALSE, 15,NULL,NULL,16,1),
('BASICA', 2,60,1,10,NULL,NULL,NULL,FALSE,16,NULL,NULL,17,1),
('FASE 1', 2, 90, 1,10, 10,NULL,NULL, FALSE, 17,NULL,NULL,18,1),
('FASE 2', 2, 140, 1, 10,10, NULL,NULL, FALSE,18,NULL, 2, 19,1),
('BASICA', 2, 50, 1,10, NULL,NULL,NULL,FALSE, 19,NULL,NULL,20,1),
('FASE 1', 2, 130, 1,10, 10,10,NULL, FALSE, 32,NULL,NULL,20,1),
('FASE 1', 2, 160, 1,10, 10,10,NULL, TRUE, 20,NULL,NULL,20,1),
('BASICA', 2, 80, 1,10, 10,NULL,NULL,FALSE, 21,NULL,NULL,21,1),
('BASICA', 2, 70, 1,10, NULL,NULL,NULL,FALSE, 22,NULL,NULL,23,1),
('BASICA', 2, 90, 1,10, 10,NULL,NULL,FALSE, 23,NULL,NULL,24,1),
('BASICA', 2, 50, 1,10, NULL,NULL,NULL,FALSE, 24,NULL,NULL,25,1),
('FASE 1', 2, 80, 1,10, NULL,NULL,NULL,FALSE, 25,NULL,NULL,26,1),
('BASICA', 2, 60, 1,10, NULL,NULL,NULL,FALSE, 26,NULL,NULL,27,1),
('FASE 1', 2, 100, 1,10, NULL,NULL,NULL,FALSE, 27,NULL,NULL,28,1),
('BASICA', 2, 70, 1,10, NULL,NULL,NULL,FALSE, 28,NULL,NULL,29,1),
('FASE 1', 2, 120, 1,10, 10,NULL,NULL,FALSE, 17,NULL,NULL,30,1),
('BASICA', 1, 60, 3,10, NULL,NULL,NULL,FALSE, 34,NULL,NULL,31,1),
('FASE 1', 1, 90, 3,10, 10,NULL,NULL,FALSE, 35,NULL,NULL,32,1),
('FASE 2', 1, 150, 3,10, 10,NULL,NULL,FALSE, 36,NULL,NULL,33,1),
('FASE 2', 1, 180, 3,10, 10,NULL,NULL,TRUE, 37,38,NULL,33,1),
('BASICA', 1, 50, 3,10, NULL,NULL,NULL,FALSE, 39,NULL,NULL,34,1),
('FASE 1', 1, 90, 3,10, NULL,NULL,NULL,FALSE, 40,NULL,NULL,35,1),
('BASICA', 1, 70, 3,10, NULL,NULL,NULL,FALSE, 41,NULL,NULL,36,1),
('FASE 1', 1, 130, 3,10, 10,NULL,NULL,FALSE, 42,NULL,NULL,37,1),
('FASE 1', 1, 150, 3,10, 10,NULL,NULL,TRUE, 43,NULL,NULL,37,1),
('BASICA', 1, 60, 3,10, NULL,NULL,NULL,FALSE, 44,NULL,NULL,38,1),
('FASE 1', 1, 100, 3,10, NULL,NULL,NULL,TRUE, 45,NULL,NULL,39,1),
('BASICA', 1, 100, 4,10, NULL,NULL,NULL,FALSE, 48,NULL,NULL,42,1),
('BASICA', 1, 140, 4,10, 10,NULL,NULL,TRUE, 49,50,NULL,42,1),
('BASICA', 3, 60, 4,10, NULL,NULL,NULL,FALSE, 56,NULL,NULL,48,1),
('BASICA', 3, 60, 4,10, NULL,NULL,NULL,FALSE, 56,NULL,NULL,48,1),
('FASE 1', 3, 80, 4,10, NULL,NULL,NULL,FALSE, 57,NULL,NULL,49,1),
('FASE 2', 3, 150, 4,10, 10,10,NULL,FALSE, 58,NULL,NULL,50,1),
('FASE 2', 3, 180, 4,10, 10,10,NULL,TRUE, 59,60,NULL,50,1),
('BASICA', 3, 60, 4,10, NULL,NULL,NULL,FALSE, 61,NULL,NULL,51,1),
('FASE 1', 3, 90, 4,10, NULL,NULL,NULL,FALSE, 62,NULL,NULL,52,1),
('BASICA', 3, 60, 4,10, NULL,NULL,NULL,FALSE, 66,NULL,NULL,56,1),
('FASE 1', 3, 110, 4,10, 10,NULL,NULL,FALSE, 67,NULL,NULL,57,1),
('FASE 1', 3, 90, 4,NULL, NULL,NULL,NULL,FALSE, 78,NULL,NULL,69,1),
('BASICA', 3, 50, 4,10, NULL,NULL,NULL,FALSE, 77,NULL,NULL,68,1),
('FASE 1', 3, 130, 4,NULL, NULL,NULL,NULL,TRUE, 79,NULL,NULL,69,1),
('BASICA', 3, 100, 4,10, NULL,NULL,NULL,FALSE, 86,NULL,NULL,76,1),
('BASICA', 3, 140, 4,10, 10,NULL,NULL,TRUE, 87,88,NULL,76,1),
('BASICA', 3, 60, 4,10, NULL,NULL,NULL,FALSE, 75,null,NULL,79,1),
('FASE 1', 3, 80, 4,10, NULL,NULL,NULL,FALSE, 91,null,NULL,80,1),
('FASE 2', 3, 120, 4,10, NULL,NULL,NULL,FALSE, 92,NULL,5,3,1);

INSERT INTO CARTA(NOMBRE, DESCRIPCION, CLASE) VALUES
('Fósil Helix', 'Juega esta carta como si fuera un Pokemon INCOLORO Básico de 40 PS. En cualquier momento durante tu turno, puedes descartar esta carta del juego. Esta carta no puede retirarse.', 3),
('Fósil Domo', 'Juega esta carta como si fuera un Pokemon INCOLORO Básico de 40 PS. En cualquier momento durante tu turno, puedes descartar esta carta del juego. Esta carta no puede retirarse.', 3),
('Ámbar Viejo', 'Juega esta carta como si fuera un Pokemon INCOLORO Básico de 40 PS. En cualquier momento durante tu turno, puedes descartar esta carta del juego. Esta carta no puede retirarse.', 3),
('Erika', 'Cura 50 puntos de dano a 1 de tus Pokemon PLANTA', 2),
('Misty', 'Elige 1 de tus Pokemon AGUA, y luego lanza 1 moneda hasta que salga cruz. Por cada cara, une 1 Energía AGUA de tu area de Energía a ese Pokemon.', 2),
('Blaine', 'Durante este turno, los ataques de tu Ninetales, tu Rapidash o tu Magmar hacen +30 puntos de dano al Pokemon Activo de tu rival.', 2),
('Koga', 'Pon a tu Muk o a tu Weezing que esté en el Puesto Activo en tu mano.', 2),
('Giovanni', 'Durante este turno, los ataques de tus Pokemon hacen +10 puntos de dano al Pokemon Activo de tu rival.', 2),
('Sabrina', 'Mueve el Pokemon Activo de tu rival a la Banca. (Tu rival elige el nuevo Pokemon Activo).', 2);
