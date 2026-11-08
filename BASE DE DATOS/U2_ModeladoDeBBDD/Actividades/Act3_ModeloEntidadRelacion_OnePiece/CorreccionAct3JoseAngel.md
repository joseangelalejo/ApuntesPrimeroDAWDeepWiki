# Correcciones Actividad 3 - Modelo Entidad-Relación One Piece

1. La entidad "Barco" he englobado los atributos "Tamaño", "Armamento" y "Resistencia" en un atributo compuesto llamada "Características". Aunque **está bien**, el anunciado no especifica que dichos atributos sean "Características" por tanto **no es necesario**.
2. Entidades Piratas, Bandas, Barcos, Marines, Armas, Frutas del diablo -> **Correctas**
   1. Los atributos de estas entidades son correctos.
3. **En la entidad "Frutas del diablo" que el atributo "Poder" sea clave es correcto**, pero según la información del enunciado sería "Nombre" aunque no tenga sentido que lo sea.

4. PARTICIPACIONES DE LAS RELACIONES:
   **1. Participaciones en Relaciones Frutas del diablo**
       2. Relación frutas del diablo y Marines
          1. 1 marine consume 0 o 1 fruta del diablo -> **Correcto**
          2. 1 fruta del diablo es consumida por 0 o 1 marine -> **Correcto**
       3. Relación frutas del diablo y Piratas
          1. 1 pirata consume 0 o 1 fruta del diablo -> **Correcto**
          2. 1 fruta del diablo es consumida por 0 o 1 pirata -> **Correcto**
    2. **Participaciones en Relaciones ARMAS**
       1. Relacion armas y marines
          1. 1 marine puede usar 0 o N armas -> **Correcto**
          2. 1 arma puede ser usada por 0 o N marines -> **Correcto**
       2. Relacion armas y piratas
          1. 1 pirata puede usar 0 o N armas -> **Correcto**
          2. 1 arma puede ser usada por 0 o N piratas -> **Correcto**
    3. **Participaciones en Relaciones Marines persiguen Piratas**
       1. 1 Marine persigue a 0 o N piratas -> **Correcto**
       2. 1 pirata es perseguido por 0 o N marines -> **Correcto**
    4. **Participaciones en Relaciones Bandas tienen Barcos**
       1. 1 banda tiene 1 o N barcos -> **Correcto**
       2. 1 barco pertenece a 0 y solo 1 banda -> **Correcto**

5. **CARDINALIDADES DE LAS RELACIONES:**
    1. Relación frutas del diablo y Marines -> 1:1 **Correcta**
    2. Relación frutas del diablo y Piratas -> 1:1 **Correcta**
    3. Relacion armas y marines -> 1:N **Correcta**
    4. Relacion armas y piratas -> 1:N **Correcta**
    5. Marines persiguen Piratas -> 1:N **Correcta**
    6. Bandas tienen Barcos -> 1:N **Correcta**
