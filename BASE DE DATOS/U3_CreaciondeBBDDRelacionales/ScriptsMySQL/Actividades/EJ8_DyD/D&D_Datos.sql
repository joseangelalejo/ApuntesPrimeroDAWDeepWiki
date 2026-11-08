USE `D&D`;

INSERT INTO razas
(nombre, mundo_origen, tamaño, velocidad_base, vision_oscuridad, idioma_principal,
 bonif_fue, bonif_des, bonif_con, bonif_int, bonif_sab, bonif_car,
 resistencia_tipo,
 rasgo_1, rasgo_1_desc, rasgo_2, rasgo_2_desc, rasgo_3, rasgo_3_desc,
 jugable, rareza, notas_master)
VALUES
('Humano','Faerûn','MEDIANO',30,0,'Común',
 1,1,1,1,1,1,
 'NINGUNA',
 'Versatilidad','Se adaptan a cualquier entorno y rol dentro del grupo.',
 'Ambición','Tienden a asumir riesgos y liderar cambios en el mundo.',
 'Aprendizaje rápido','Progresan con facilidad cuando la campaña lo permite.',
 1,'COMUN','SRD. Ajusta bonificadores si usáis reglas alternativas.'),
('Enano','Faerûn','MEDIANO',25,1,'Común',
 0,0,2,0,0,0,
 'VENENO',
 'Resistencia enana','Suelen resistir mejor toxinas y ambientes hostiles.',
 'Entrenamiento tradicional','Familiaridad cultural con armas y artesanía.',
 'Tenacidad','Aguante notable en viajes largos y situaciones difíciles.',
 1,'COMUN','SRD. Velocidad 25, visión en la oscuridad típica.'),
('Elfo','Faerûn','MEDIANO',30,1,'Común',
 0,2,0,0,0,0,
 'NINGUNA',
 'Visión en la oscuridad','Ven mejor que otros en condiciones de poca luz.',
 'Trance','Descanso diferente al sueño convencional.',
 'Sentidos agudos','Atención elevada a detalles del entorno.',
 1,'COMUN','SRD. Subrazas se pueden modelar luego con ALTER.'),
('Mediano','Faerûn','PEQUEÑO',25,0,'Común',
 0,2,0,0,0,0,
 'NINGUNA',
 'Suerte','Suelen librarse de fallos por pura fortuna.',
 'Valentía','Menos propensos a acobardarse ante amenazas mayores.',
 'Agilidad','Se mueven con soltura entre criaturas más grandes.',
 1,'COMUN','SRD. Muy útil para filtros por tamaño.'),
('Draconido','Faerûn','MEDIANO',30,0,'Común',
 2,0,0,0,0,1,
 'FUEGO',
 'Aliento dracónico','Ataque especial temático (tipo según linaje, aquí genérico).',
 'Resistencia dracónica','Resistencia asociada al linaje (aquí fijada a fuego).',
 'Presencia imponente','Carisma marcado y porte intimidante.',
 1,'POCO_COMUN','SRD. Si queréis, luego creamos variantes por linaje.'),
('Gnomo','Faerûn','PEQUEÑO',25,1,'Común',
 0,0,0,2,0,0,
 'NINGUNA',
 'Ingenio','Curiosidad y creatividad constante.',
 'Visión en la oscuridad','Comunes en comunidades subterráneas.',
 'Astucia','Dificultan engaños o efectos mentales (según reglas de mesa).',
 1,'POCO_COMUN','SRD. Ideal para prácticas con CHECK/ENUM/SET.'),
('Semielfo','Faerûn','MEDIANO',30,1,'Común',
 0,0,0,0,0,2,
 'NINGUNA',
 'Herencia dual','Mezcla cultural y biológica humano-élfica.',
 'Adaptabilidad social','Su encaje en varias culturas les da ventajas narrativas.',
 'Talentos flexibles','Permite personalización según campaña.',
 1,'POCO_COMUN','SRD. Buen caso para vistas por rareza.'),
('Semiorco','Faerûn','MEDIANO',30,1,'Común',
 2,0,1,0,0,0,
 'NINGUNA',
 'Fuerza bruta','Potencia física sobresaliente.',
 'Amenazante','Presencia intimidatoria.',
 'Resistencia','Aguante superior en situaciones límite (según reglas).',
 1,'POCO_COMUN','SRD.'),
('Tiefling','Faerûn','MEDIANO',30,1,'Común',
 0,0,0,1,0,2,
 'FUEGO',
 'Resistencia infernal','El fuego les afecta menos de lo normal.',
 'Legado extraño','Manifestaciones mágicas temáticas (según mesa).',
 'Apariencia singular','Rasgos visibles no humanos; puede afectar al rol.',
 1,'RARA','SRD. Perfecta para vistas de “razas raras jugables”.'),
('Tabaxi-Errante','Faerûn','MEDIANO',35,1,'Común',
 0,2,0,0,0,1,
 'NINGUNA',
 'Instinto felino','Reflejos rápidos y movimientos ágiles.',
 'Curiosidad compulsiva','Tienden a investigar cualquier misterio.',
 'Equilibrio natural','Se desenvuelven bien en superficies complicadas.',
 1,'RARA','Homebrew inspirado: NO es la raza oficial.'),
('Forjados de Bruma','Faerûn','MEDIANO',30,1,'Común',
 0,0,2,1,0,0,
 'NECROTICO',
 'Cuerpo velado','Piel semi etérea, difícil de rastrear.',
 'Aliento frío','Exhalan niebla que entorpece la visión.',
 'Memoria fragmentada','Recuerdos incompletos de su creación.',
 1,'MUY_RARA','Homebrew: útiles para practicar restricciones.'),
('Dríada Urbana','Faerûn','MEDIANO',30,0,'Común',
 0,0,0,1,2,0,
 'ACIDO',
 'Empatía vegetal','Sienten la “salud” de parques y jardines.',
 'Raíces ligeras','Recuperan energía en contacto con tierra húmeda.',
 'Ojo del invernadero','Detectan toxinas y contaminantes con facilidad.',
 1,'RARA','Homebrew.'),
('Enano de Sal','Faerûn','MEDIANO',25,1,'Común',
 0,0,2,0,0,0,
 'ACIDO',
 'Piel cristalina','Resiste mejor la corrosión y ambientes salinos.',
 'Oído de mina','Perciben vibraciones y grietas cercanas.',
 'Sed de profundidad','Necesitan minerales en la dieta (detalle narrativo).',
 1,'POCO_COMUN','Homebrew variante.'),
('Elfo Cenital','Faerûn','MEDIANO',30,1,'Común',
 0,2,0,0,0,0,
 'RAYO',
 'Paso de luz','Se orientan por estrellas y reflejos.',
 'Mirada alta','Detectan destellos y señales a distancia.',
 'Ritual astral','Pequeños trucos ligados al cielo nocturno (mesa).',
 1,'RARA','Homebrew.'),
('Kóbold Carmesí','Faerûn','PEQUEÑO',30,1,'Común',
 0,2,0,0,0,0,
 'FUEGO',
 'Tácticas de banda','Ganan confianza cerca de aliados.',
 'Olfato de humo','Reconocen fuego reciente y ceniza.',
 'Cobardía práctica','Priorizan la supervivencia antes que la gloria.',
 1,'POCO_COMUN','Homebrew.'),
('Sátiro de Caverna','Faerûn','MEDIANO',35,1,'Común',
 0,2,0,0,0,1,
 'VENENO',
 'Euforia salvaje','Resisten mejor intoxicaciones y excesos.',
 'Zancada caprina','Movilidad superior en terreno irregular.',
 'Risa contagiosa','Facilitan interacciones sociales (rol).',
 1,'RARA','Homebrew.'),
('Aviánidos del Farallón','Faerûn','MEDIANO',30,0,'Común',
 0,2,0,0,1,0,
 'FRIO',
 'Plumaje aislante','Soportan mejor climas fríos y viento.',
 'Vista de altura','Detectan movimientos pequeños a distancia.',
 'Planeo','Pueden descender sin dañarse en caídas moderadas (mesa).',
 1,'RARA','Homebrew.'),
('Mirmidón de Coral','Faerûn','MEDIANO',30,1,'Común',
 1,0,2,0,0,0,
 'FRIO',
 'Armadura coralina','Piel endurecida como coral.',
 'Pulso abisal','Sienten presión y corrientes (rol).',
 'Canto de marea','Rituales simples ligados al mar (mesa).',
 1,'MUY_RARA','Homebrew acuático.'),
('Sombravivos','Faerûn','MEDIANO',30,1,'Común',
 0,2,0,0,0,1,
 'NECROTICO',
 'Sombra adherida','Su silueta delata emociones.',
 'Paso silencioso','Se mueven sin apenas sonido en penumbra.',
 'Pacto tenue','Tienen “algo” detrás… ideal para tramas.',
 1,'MUY_RARA','Homebrew.'),
('Hijos del Meteoro','Faerûn','MEDIANO',30,0,'Común',
 1,0,1,0,0,1,
 'RAYO',
 'Pulso eléctrico','Descargas menores por emoción o estrés.',
 'Marca estelar','Cicatrices brillantes con forma de constelación.',
 'Nervio rápido','Reaccionan velozmente ante sorpresas (rol).',
 1,'RARA','Homebrew.'),
('Silfos de Archivo','Faerûn','PEQUEÑO',25,0,'Común',
 0,0,0,2,1,0,
 'NINGUNA',
 'Memoria perfecta','Recuerdan textos y símbolos con precisión.',
 'Susurro de tinta','Detectan pergaminos y libros cercanos (mesa).',
 'Manos ligeras','Cuidado extremo manipulando objetos frágiles.',
 1,'RARA','Homebrew.'),
('Cíclopes Menores','Faerûn','GRANDE',30,0,'Común',
 2,0,2,0,0,0,
 'NINGUNA',
 'Ojo único','Percepción de profundidad extraña pero potente.',
 'Piel dura','Resisten golpes mejor que la media (mesa).',
 'Orgullo de clan','Reaccionan fuerte a faltas de respeto.',
 0,'LEGENDARIA','Homebrew: marcado como NO jugable (jugable=0).'),
('Tejedores de Arena','Faerûn','MEDIANO',30,0,'Común',
 0,2,0,1,0,0,
 'ACIDO',
 'Piel arenosa','Tolera polvo, calor seco y abrasión.',
 'Rastro borrado','Difícil seguir sus huellas en desierto.',
 'Sed controlada','Aguantan más sin agua (rol/campaña).',
 1,'RARA','Homebrew desértico.'),
('Quimeranos','Faerûn','MEDIANO',30,1,'Común',
 1,1,0,0,0,0,
 'VENENO',
 'Herencia mixta','Rasgos físicos combinados; apariencia variable.',
 'Adaptación rápida','Se acostumbran a entornos nuevos con facilidad.',
 'Instinto de presa','Reaccionan ante peligro de forma visceral.',
 1,'MUY_RARA','Homebrew: ideal para luego normalizar en tabla aparte.');

INSERT INTO clases
(nombre, dado_vida, atributo_principal, salvaciones,
 competencia_armas, competencia_armaduras, competencia_herram,
 competencia_habilidades,
 lanzador_conjuros, tipo_lanzamiento, recursos_principales,
 armadura_sin_bonif, notas_master)
VALUES
('Barbaro','d12','FUE','FUE,CON',
 'Armas simples y marciales',
 'Armaduras ligeras y medias, escudos',
 NULL,
 'ATLETISMO,INTIMIDACION,SUPERVIVENCIA,TRATO_CON_ANIMALES',
 FALSE,'NINGUNO','Furia',
 TRUE,'Clase marcial pura orientada a resistencia y daño.'),
('Bardo','d8','CAR','DES,CAR',
 'Armas simples, ballestas ligeras, espadas cortas',
 'Armaduras ligeras',
 'Instrumentos musicales',
 'INTERPRETACION,PERSUASION,ENGANAR,HISTORIA',
 TRUE,'CONOCIDO','Inspiración',
 FALSE,'Lanzador versátil con fuerte componente social.'),
('Clerigo','d8','SAB','SAB,CAR',
 'Armas simples',
 'Armaduras ligeras y medias, escudos',
 NULL,
 'RELIGION,MEDICINA,PERCEPCION',
 TRUE,'PREPARADO','Canalizar divinidad',
 FALSE,'Lanzador divino con dominio temático.'),
('Druida','d8','SAB','SAB,DES',
 'Armas simples',
 'Armaduras ligeras y medias (no metálicas)',
 'Herramientas herbales',
 'NATURALEZA,SUPERVIVENCIA,PERCEPCION',
 TRUE,'PREPARADO','Forma salvaje',
 FALSE,'Conexión directa con la naturaleza.'),
('Guerrero','d10','FUE','FUE,CON',
 'Armas simples y marciales',
 'Todas las armaduras y escudos',
 NULL,
 'ATLETISMO,PERCEPCION,SUPERVIVENCIA',
 FALSE,'NINGUNO','Acción adicional',
 FALSE,'Clase marcial más flexible.'),
('Monje','d8','DES','DES,SAB',
 'Armas simples, armas de monje',
 'Sin armaduras',
 NULL,
 'ACROBACIAS,ATLETISMO,SIGILO',
 FALSE,'NINGUNO','Ki',
 TRUE,'Combate sin armadura y movilidad alta.'),
('Paladin','d10','FUE','SAB,CAR',
 'Armas simples y marciales',
 'Todas las armaduras y escudos',
 NULL,
 'PERSUASION,INTIMIDACION,RELIGION',
 TRUE,'PREPARADO','Canalizar divinidad, juramentos',
 FALSE,'Guerrero sagrado con magia limitada.'),
('Explorador','d10','DES','DES,SAB',
 'Armas simples y marciales',
 'Armaduras ligeras y medias, escudos',
 NULL,
 'SUPERVIVENCIA,NATURALEZA,PERCEPCION,SIGILO',
 TRUE,'CONOCIDO','Enemigo predilecto',
 FALSE,'Especialista en exploración y rastreo.'),
('Picaro','d8','DES','DES,INT',
 'Armas simples, ballestas ligeras, espadas cortas',
 'Armaduras ligeras',
 'Herramientas de ladrón',
 'SIGILO,JUEGO_DE_MANOS,ENGANAR,PERCEPCION',
 FALSE,'NINGUNO','Ataque furtivo',
 FALSE,'Daño preciso y habilidades sociales.'),
('Hechicero','d6','CAR','CON,CAR',
 'Armas simples',
 'Sin armaduras',
 NULL,
 'ARCANO,ENGANAR,INTIMIDACION',
 TRUE,'CONOCIDO','Puntos de hechicería',
 TRUE,'Magia innata y flexible.'),
('Brujo','d8','CAR','SAB,CAR',
 'Armas simples',
 'Armaduras ligeras',
 NULL,
 'ARCANO,ENGANAR,INTIMIDACION',
 TRUE,'PACTO','Espacios de pacto',
 FALSE,'Lanzador con recursos únicos.'),
('Mago','d6','INT','INT,SAB',
 'Armas simples',
 'Sin armaduras',
 'Herramientas de escritura',
 'ARCANO,HISTORIA,INVESTIGACION',
 TRUE,'PREPARADO','Espacios de conjuro',
 TRUE,'Lanzador arcano por excelencia.'),
('Artifice','d8','INT','CON,INT',
 'Armas simples',
 'Armaduras ligeras y medias, escudos',
 'Herramientas de artesano',
 'ARCANO,INVESTIGACION,HISTORIA',
 TRUE,'PREPARADO','Infusiones',
 FALSE,'Clase técnica y mágica basada en objetos.');


DELIMITER $$

DROP PROCEDURE IF EXISTS generar_personajes $$
CREATE PROCEDURE generar_personajes(IN total INT)
BEGIN
  DECLARE i INT DEFAULT 1;
  DECLARE cnt_razas INT;
  DECLARE raza_elegida INT;
  DECLARE off INT;
  DECLARE pgm SMALLINT UNSIGNED;
  DECLARE pga SMALLINT UNSIGNED;

  SELECT COUNT(*) INTO cnt_razas FROM razas;

  IF cnt_razas = 0 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No hay razas en la tabla razas.';
  END IF;

  WHILE i <= total DO

    -- elegir raza existente por posición
    SET off = MOD(i-1, cnt_razas);
    SELECT id INTO raza_elegida
    FROM razas
    ORDER BY id
    LIMIT off, 1;

    -- PG garantizados
    SET pgm = 10 + MOD(i, 20);              -- 10..29
    SET pga = 1 + MOD(i, pgm);              -- 1..pgm  (SIEMPRE <= pgm)

    INSERT INTO personajes (
      nombre, alias, genero, edad, altura_cm, peso_kg, raza,
      alineamiento, nivel_total, fue, des, con, inteli, sab, car,
      pg_max, pg_actual, estado
    ) VALUES (
      CONCAT('PJ_', LPAD(i,4,'0')),
      CONCAT('Alias_', LPAD(i,4,'0')),
      ELT(MOD(i,4)+1,'M','F','NB','OTRO'),
      18 + MOD(i,50),
      150 + MOD(i,50),
      50 + MOD(i,40),
      raza_elegida,
      ELT(MOD(i,9)+1,'LB','NB','CB','LN','N','CN','LM','NM','CM'),
      1 + MOD(i,20),
      8 + MOD(i,10),
      8 + MOD(i+1,10),
      8 + MOD(i+2,10),
      8 + MOD(i+3,10),
      8 + MOD(i+4,10),
      8 + MOD(i+5,10),
      pgm,
      pga,
      ELT(MOD(i,4)+1,'ACTIVO','ACTIVO','NPC','RETIRADO')
    );

    SET i = i + 1;
  END WHILE;
END$$

DELIMITER ;


DELIMITER $$

DROP PROCEDURE IF EXISTS generar_objetos $$
CREATE PROCEDURE generar_objetos(IN total INT)
BEGIN
  DECLARE i INT DEFAULT 1;

  DECLARE v_tipo VARCHAR(20);
  DECLARE v_rareza VARCHAR(20);
  DECLARE v_sintonia BOOLEAN;

  DECLARE v_peso DECIMAL(6,2);
  DECLARE v_valor DECIMAL(10,2);

  DECLARE v_tipo_dano VARCHAR(20);
  DECLARE v_dado VARCHAR(10);
  DECLARE v_props VARCHAR(200);

  DECLARE v_ca_bonus TINYINT;
  DECLARE v_tipo_arm VARCHAR(20);
  DECLARE v_req_fue TINYINT UNSIGNED;
  DECLARE v_sig_desv BOOLEAN;

  DECLARE v_cargas SMALLINT UNSIGNED;

  WHILE i <= total DO

    -- 1) Tipo (rotación)
    SET v_tipo = ELT(MOD(i,7)+1,'ARMA','ARMADURA','CONSUMIBLE','HERRAMIENTA','TESORO','ARTEFACTO','MISC');

    -- 2) Rareza (más comunes que legendarias)
    SET v_rareza = ELT(MOD(i,10)+1,
      'COMUN','COMUN','COMUN','POCO_COMUN','POCO_COMUN',
      'RARA','RARA','MUY_RARA','LEGENDARIA','POCO_COMUN'
    );

    -- 3) Sintonía: normalmente para artefactos y objetos raros+
    SET v_sintonia = (v_tipo IN ('ARTEFACTO') OR v_rareza IN ('MUY_RARA','LEGENDARIA'));

    -- 4) Peso / valor (fórmulas simples)
    SET v_peso  = ROUND((MOD(i*7, 250) / 10), 2);      -- 0.00 .. 24.90
    SET v_valor = ROUND((MOD(i*97, 50000) / 10), 2);   -- 0.00 .. 4999.90

    -- Defaults para campos “dependientes”
    SET v_tipo_dano = 'NINGUNO';
    SET v_dado = NULL;
    SET v_props = NULL;

    SET v_ca_bonus = 0;
    SET v_tipo_arm = 'NINGUNA';
    SET v_req_fue  = NULL;
    SET v_sig_desv = FALSE;

    SET v_cargas = 0;

    -- 5) Ajustes según tipo
    IF v_tipo = 'ARMA' THEN
      SET v_tipo_dano = ELT(MOD(i,6)+1,'CORTANTE','CONTUNDENTE','PERFORANTE','FUEGO','FRIO','VENENO');
      SET v_dado = ELT(MOD(i,6)+1,'1d4','1d6','1d8','1d10','2d6','1d12');

      -- Propiedades (SET como string con comas)
      SET v_props = ELT(MOD(i,6)+1,
        'LIGERA,FINA',
        'DOS_MANOS,PESADA',
        'A_DISTANCIA,MUNICION',
        'VERSATIL',
        'ALCANCE,ARROJADIZA',
        'RECARGA,A_DISTANCIA'
      );

    ELSEIF v_tipo = 'ARMADURA' THEN
      SET v_ca_bonus = 1 + MOD(i,4); -- 1..4
      SET v_tipo_arm = ELT(MOD(i,4)+1,'LIGERA','MEDIA','PESADA','ESCUDO');

      -- Requisito fuerza y desventaja sigilo solo si es pesada (y a veces media)
      IF v_tipo_arm = 'PESADA' THEN
        SET v_req_fue = 13 + MOD(i,3);    -- 13..15
        SET v_sig_desv = TRUE;
      ELSEIF v_tipo_arm = 'MEDIA' THEN
        SET v_req_fue = NULL;
        SET v_sig_desv = (MOD(i,3)=0);
      ELSE
        SET v_req_fue = NULL;
        SET v_sig_desv = FALSE;
      END IF;

    ELSEIF v_tipo = 'CONSUMIBLE' THEN
      SET v_cargas = 1 + MOD(i,5); -- 1..5

    END IF;

    -- 6) INSERT final (nombre único garantizado por i)
    INSERT INTO objetos (
      nombre, tipo, rareza, requiere_sintonia,
      peso, valor_oro,
      tipo_daño, dado_daño, propiedad_armas,
      ca_bonus, tipo_armadura, req_fuerza, sigilo_desventaja,
      descripcion, efectos_json, consumible_cargas,
      permitido_pj, fuente
    ) VALUES (
      CONCAT('Objeto_', LPAD(i, 4, '0')),
      v_tipo,
      v_rareza,
      v_sintonia,
      v_peso,
      v_valor,
      v_tipo_dano,
      v_dado,
      v_props,
      v_ca_bonus,
      v_tipo_arm,
      v_req_fue,
      v_sig_desv,
      CONCAT('Descripción generada del objeto #', i, ' (', v_tipo, ', ', v_rareza, ').'),
      JSON_OBJECT('seed', i, 'tipo', v_tipo, 'rareza', v_rareza, 'notas', CONCAT('gen_', i)),
      v_cargas,
      TRUE,
      'PHB'
    );

    SET i = i + 1;
  END WHILE;

END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS generar_objetos $$
CREATE PROCEDURE generar_objetos(IN total INT)
BEGIN
  DECLARE i INT DEFAULT 1;

  DECLARE v_tipo VARCHAR(20);
  DECLARE v_rareza VARCHAR(20);
  DECLARE v_sintonia BOOLEAN;

  DECLARE v_peso DECIMAL(6,2);
  DECLARE v_valor DECIMAL(10,2);

  DECLARE v_tipo_dano VARCHAR(20);
  DECLARE v_dado VARCHAR(10);
  DECLARE v_props VARCHAR(200);

  DECLARE v_ca_bonus TINYINT;
  DECLARE v_tipo_arm VARCHAR(20);
  DECLARE v_req_fue TINYINT UNSIGNED;
  DECLARE v_sig_desv BOOLEAN;

  DECLARE v_cargas SMALLINT UNSIGNED;

  WHILE i <= total DO

    -- 1) Tipo (rotación)
    SET v_tipo = ELT(MOD(i,7)+1,'ARMA','ARMADURA','CONSUMIBLE','HERRAMIENTA','TESORO','ARTEFACTO','MISC');

    -- 2) Rareza (más comunes que legendarias)
    SET v_rareza = ELT(MOD(i,10)+1,
      'COMUN','COMUN','COMUN','POCO_COMUN','POCO_COMUN',
      'RARA','RARA','MUY_RARA','LEGENDARIA','POCO_COMUN'
    );

    -- 3) Sintonía: normalmente para artefactos y objetos raros+
    SET v_sintonia = (v_tipo IN ('ARTEFACTO') OR v_rareza IN ('MUY_RARA','LEGENDARIA'));

    -- 4) Peso / valor (fórmulas simples)
    SET v_peso  = ROUND((MOD(i*7, 250) / 10), 2);      -- 0.00 .. 24.90
    SET v_valor = ROUND((MOD(i*97, 50000) / 10), 2);   -- 0.00 .. 4999.90

    -- Defaults para campos “dependientes”
    SET v_tipo_dano = 'NINGUNO';
    SET v_dado = NULL;
    SET v_props = NULL;

    SET v_ca_bonus = 0;
    SET v_tipo_arm = 'NINGUNA';
    SET v_req_fue  = NULL;
    SET v_sig_desv = FALSE;

    SET v_cargas = 0;

    -- 5) Ajustes según tipo
    IF v_tipo = 'ARMA' THEN
      SET v_tipo_dano = ELT(MOD(i,6)+1,'CORTANTE','CONTUNDENTE','PERFORANTE','FUEGO','FRIO','VENENO');
      SET v_dado = ELT(MOD(i,6)+1,'1d4','1d6','1d8','1d10','2d6','1d12');

      -- Propiedades (SET como string con comas)
      SET v_props = ELT(MOD(i,6)+1,
        'LIGERA,FINA',
        'DOS_MANOS,PESADA',
        'A_DISTANCIA,MUNICION',
        'VERSATIL',
        'ALCANCE,ARROJADIZA',
        'RECARGA,A_DISTANCIA'
      );

    ELSEIF v_tipo = 'ARMADURA' THEN
      SET v_ca_bonus = 1 + MOD(i,4); -- 1..4
      SET v_tipo_arm = ELT(MOD(i,4)+1,'LIGERA','MEDIA','PESADA','ESCUDO');

      -- Requisito fuerza y desventaja sigilo solo si es pesada (y a veces media)
      IF v_tipo_arm = 'PESADA' THEN
        SET v_req_fue = 13 + MOD(i,3);    -- 13..15
        SET v_sig_desv = TRUE;
      ELSEIF v_tipo_arm = 'MEDIA' THEN
        SET v_req_fue = NULL;
        SET v_sig_desv = (MOD(i,3)=0);
      ELSE
        SET v_req_fue = NULL;
        SET v_sig_desv = FALSE;
      END IF;

    ELSEIF v_tipo = 'CONSUMIBLE' THEN
      SET v_cargas = 1 + MOD(i,5); -- 1..5

    END IF;

    -- 6) INSERT final (nombre único garantizado por i)
    INSERT INTO objetos (
      nombre, tipo, rareza, requiere_sintonia,
      peso, valor_oro,
      tipo_daño, dado_daño, propiedad_armas,
      ca_bonus, tipo_armadura, req_fuerza, sigilo_desventaja,
      descripcion, efectos_json, consumible_cargas,
      permitido_pj, fuente
    ) VALUES (
      CONCAT('Objeto_', LPAD(i, 4, '0')),
      v_tipo,
      v_rareza,
      v_sintonia,
      v_peso,
      v_valor,
      v_tipo_dano,
      v_dado,
      v_props,
      v_ca_bonus,
      v_tipo_arm,
      v_req_fue,
      v_sig_desv,
      CONCAT('Descripción generada del objeto #', i, ' (', v_tipo, ', ', v_rareza, ').'),
      JSON_OBJECT('seed', i, 'tipo', v_tipo, 'rareza', v_rareza, 'notas', CONCAT('gen_', i)),
      v_cargas,
      TRUE,
      'PHB'
    );

    SET i = i + 1;
  END WHILE;

END$$

DELIMITER ;


DELIMITER $$

DROP PROCEDURE IF EXISTS generar_inventario $$
CREATE PROCEDURE generar_inventario(IN total INT)
BEGIN
  DECLARE i INT DEFAULT 1;

  DECLARE cnt_pers INT;
  DECLARE cnt_obj INT;

  DECLARE off_p INT;
  DECLARE off_o INT;

  DECLARE v_personaje INT;
  DECLARE v_objeto INT;

  DECLARE v_cantidad SMALLINT UNSIGNED;
  DECLARE v_equipado BOOLEAN;
  DECLARE v_ranura VARCHAR(20);
  DECLARE v_estado VARCHAR(10);
  DECLARE v_cargas SMALLINT UNSIGNED;

  -- contar filas reales (no asumir IDs consecutivos)
  SELECT COUNT(*) INTO cnt_pers FROM personajes;
  SELECT COUNT(*) INTO cnt_obj FROM objetos;

  IF cnt_pers = 0 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No hay personajes en la tabla personajes.';
  END IF;

  IF cnt_obj = 0 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No hay objetos en la tabla objetos.';
  END IF;

  WHILE i <= total DO

    -- offsets por rotación (evita RAND y evita IDs inexistentes)
    SET off_p = MOD(i-1, cnt_pers);

    -- para objetos metemos un salto distinto para mezclar
    SET off_o = MOD((i-1) * 7, cnt_obj);

    -- ID real de personaje
    SELECT id INTO v_personaje
    FROM personajes
    ORDER BY id
    LIMIT off_p, 1;

    -- ID real de objeto
    SELECT id INTO v_objeto
    FROM objetos
    ORDER BY id
    LIMIT off_o, 1;

    -- cantidad (1..5)
    SET v_cantidad = 1 + MOD(i, 5);

    -- equipado (1 de cada 4 aprox)
    SET v_equipado = (MOD(i, 4) = 0);

    -- ranura (si equipado, más probable mano/torso/cabeza)
    IF v_equipado THEN
      SET v_ranura = ELT(MOD(i,5)+1,'TORSO','MANO_DER','MANO_IZQ','CABEZA','PIES');
    ELSE
      SET v_ranura = ELT(MOD(i,3)+1,'MOCHILA','MOCHILA','OTRO');
    END IF;

    -- estado del objeto
    SET v_estado = ELT(MOD(i,5)+1,'NUEVO','USADO','USADO','DANADO','MALDITO');

    -- cargas actuales (0..3)
    SET v_cargas = MOD(i, 4);

    -- Insert
    INSERT INTO inventario (
      personaje, objeto, cantidad, equipado, ranura_equipo,
      estado_objeto, cargas_actuales, personalizacion, notas, obtenido_en
    ) VALUES (
      v_personaje, v_objeto, v_cantidad, v_equipado, v_ranura,
      v_estado, v_cargas,
      CONCAT('Skin_', MOD(i, 30)),
      CONCAT('Loot generado #', i),
      DATE_SUB(CURDATE(), INTERVAL MOD(i, 365) DAY)
    );

    SET i = i + 1;
  END WHILE;

END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS generar_mazmorras $$
CREATE PROCEDURE generar_mazmorras(IN total INT)
BEGIN
  DECLARE i INT DEFAULT 1;

  DECLARE v_min TINYINT UNSIGNED;
  DECLARE v_max TINYINT UNSIGNED;
  DECLARE v_diff VARCHAR(10);
  DECLARE v_amb VARCHAR(20);
  DECLARE v_tramp VARCHAR(10);
  DECLARE v_puzz VARCHAR(10);
  DECLARE v_tags VARCHAR(200);

  WHILE i <= total DO

    -- niveles siempre coherentes (min <= max)
    SET v_min = 1 + MOD(i, 15);                  -- 1..15
    SET v_max = v_min + MOD(i, 6);               -- min..min+5

    SET v_diff = ELT(MOD(i,4)+1,'FACIL','MEDIA','DIFICIL','MORTAL');
    SET v_amb  = ELT(MOD(i,8)+1,'CUEVA','CRIPTA','BOSQUE','CASTILLO','RUINAS','SUBTERRANEO','CIUDAD','PLANAR');

    SET v_tramp = ELT(MOD(i,3)+1,'BAJA','MEDIA','ALTA');
    SET v_puzz  = ELT(MOD(i+1,3)+1,'BAJA','MEDIA','ALTA');

    -- tags (SET) como string separado por comas o NULL
    SET v_tags = ELT(MOD(i,6)+1,
      NULL,
      'NO_MUERTOS',
      'DRACONICO,CULTISTAS',
      'DEMONIOS,MAGIA_SALVAJE',
      'VENENO,ILUSIONES',
      'GOBLINOIDES'
    );

    INSERT INTO mazmorras (
      nombre, region, nivel_recomendado_min, nivel_recomendado_max,
      dificultad, ambiente, trampas_frecuencia, puzzles_frecuencia,
      tesoro_estimado_oro, mapa_url, descripcion, reglas_especiales,
      tags, activa
    ) VALUES (
      CONCAT('Mazmorra_', LPAD(i,4,'0')),
      ELT(MOD(i,6)+1,'Costa de la Espada','Valle Sombrio','Tierras Altas','Desierto Rojo','Archipielago Bruma','Mar Interior'),
      v_min, v_max,
      v_diff,
      v_amb,
      v_tramp,
      v_puzz,
      MOD(i*137, 50000),
      CONCAT('https://mapas.local/mz_', LPAD(i,4,'0'), '.png'),
      CONCAT('Descripción generada de la mazmorra #', i, '.'),
      CONCAT('Reglas especiales #', i, ': efectos ambientales y condiciones temáticas.'),
      v_tags,
      (MOD(i,10) <> 0)   -- 10% inactivas
    );

    SET i = i + 1;
  END WHILE;

END$$

DELIMITER ;
 
DELIMITER $$

DROP PROCEDURE IF EXISTS generar_enemigos $$
CREATE PROCEDURE generar_enemigos(IN total INT)
BEGIN
  DECLARE i INT DEFAULT 1;

  DECLARE v_tipo VARCHAR(20);
  DECLARE v_tam VARCHAR(12);
  DECLARE v_cr DECIMAL(4,2);
  DECLARE v_xp INT UNSIGNED;

  WHILE i <= total DO

    SET v_tipo = ELT(MOD(i,12)+1,
      'BESTIA','NO_MUERTO','DRAGON','HUMANOIDE','CONSTRUCTO','DEMONIO','DIABLO','FEY','ELEMENTAL','GIGANTE','ABERRACION','PLANTA'
    );

    SET v_tam = ELT(MOD(i,6)+1,'TINY','SMALL','MEDIUM','LARGE','HUGE','GARGANTUAN');

    -- CR >= 0 (cumple chk_cr)
    -- 0.25, 0.50, 1.00, 2.00, 3.00, 5.00, 8.00, 10.00...
    SET v_cr = ELT(MOD(i,10)+1, 0.25, 0.50, 1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 8.00, 10.00);

    -- XP aproximado (no oficial; solo coherente para tener números)
    SET v_xp = CAST(v_cr * 120 AS UNSIGNED) + MOD(i*17, 80);

    INSERT INTO enemigos (
      nombre, tipo, sub_tipo, alineamiento, tamano,
      cr, xp, ca, pg, velocidad,
      fue, des, con, inteli, sab, car,
      sentidos, idiomas, resistencias, inmunidades, vulnerabilidades,
      ataque_principal, danio_principal, habilidades_especiales,
      legendario, guarida, notas_master
    ) VALUES (
      CONCAT('Enemigo_', LPAD(i,4,'0')),
      v_tipo,
      ELT(MOD(i,6)+1,'Acechador','Guardia','Sombra','Chaman','Berserker','Coloso'),
      ELT(MOD(i,9)+1,'LB','NB','CB','LN','N','CN','LM','NM','CM'),
      v_tam,
      v_cr,
      v_xp,
      10 + MOD(i, 11),
      5 + MOD(i*3, 120),
      20 + MOD(i, 25),

      6 + MOD(i, 15),
      6 + MOD(i+2, 15),
      6 + MOD(i+4, 15),
      6 + MOD(i+6, 15),
      6 + MOD(i+8, 15),
      6 + MOD(i+10, 15),

      ELT(MOD(i,4)+1,'Vision en la oscuridad','Olfato agudo','Sentido tremor','Percepcion pasiva alta'),
      ELT(MOD(i,4)+1,'Común','Común,Infernal','Común,Draconico','Ninguno'),
      ELT(MOD(i,5)+1,NULL,'FRIO','FUEGO','VENENO','NECROTICO'),
      ELT(MOD(i,6)+1,NULL,NULL,'VENENO','NECROTICO',NULL,'NINGUNA'),
      ELT(MOD(i,5)+1,NULL,'RADIO','FUEGO',NULL,'ACIDO'),

      ELT(MOD(i,5)+1,'Garra','Mordisco','Golpe','Rayo','Drenaje'),
      ELT(MOD(i,6)+1,'1d4','1d6','1d8','1d10','2d6','3d6'),
      CONCAT('Habilidad especial #', i, ': efecto temático (homebrew).'),

      (MOD(i,25)=0),  -- 1 de cada 25 legendario
      (MOD(i,20)=0),  -- 1 de cada 20 con guarida
      CONCAT('Notas del master para enemigo #', i)
    );

    SET i = i + 1;
  END WHILE;

END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS generar_eventos $$
CREATE PROCEDURE generar_eventos(IN total INT)
BEGIN
  DECLARE i INT DEFAULT 1;

  DECLARE v_tipo VARCHAR(20);
  DECLARE v_estado VARCHAR(12);
  DECLARE v_prio VARCHAR(10);
  DECLARE v_tags VARCHAR(200);

  WHILE i <= total DO

    SET v_tipo = ELT(MOD(i,8)+1,'MISION','DESCUBRIMIENTO','TRAMPA','TESORO','DIALOGO','BOSS','PUZLE','ENCUENTRO');
    SET v_estado = ELT(MOD(i,5)+1,'PENDIENTE','EN_CURSO','RESUELTO','FALLIDO','CANCELADO');
    SET v_prio = ELT(MOD(i,4)+1,'BAJA','MEDIA','ALTA','CRITICA');

    SET v_tags = ELT(MOD(i,6)+1,
      NULL,
      'MAGIA',
      'INTRIGA,POLITICA',
      'EXPLORACION,SUPERVIVENCIA',
      'TERROR',
      'HUMOR'
    );

    INSERT INTO eventos (
      nombre, tipo, estado, prioridad,
      fecha_programada, fecha_resolucion,
      ubicacion, descripcion, recompensas, consecuencias,
      es_secreto, tags
    ) VALUES (
      CONCAT('Evento_', LPAD(i,4,'0')),
      v_tipo,
      v_estado,
      v_prio,
      DATE_ADD(CURDATE(), INTERVAL MOD(i, 120) DAY),
      IF(v_estado IN ('RESUELTO','FALLIDO'), DATE_SUB(CURDATE(), INTERVAL MOD(i, 90) DAY), NULL),
      ELT(MOD(i,6)+1,'Puerto Viejo','Bosque Susurrante','Torre en Ruinas','Mercado Negro','Cripta Sellada','Paso de Montaña'),
      CONCAT('Descripción del evento #', i, ' (', v_tipo, ').'),
      CONCAT('Recompensa #', i, ': oro, objeto o favor narrativo.'),
      CONCAT('Consecuencia #', i, ': cambia el estado del mundo o relaciones.'),
      (MOD(i,7)=0),  -- 1 de cada 7 es secreto
      v_tags
    );

    SET i = i + 1;
  END WHILE;

END$$

DELIMITER ;

CALL generar_personajes(4000);
CALL generar_objetos(80);
CALL generar_inventario(2000);  
CALL generar_mazmorras(80);
CALL generar_enemigos(200);
CALL generar_eventos(120);