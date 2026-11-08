# Premisa Profesor

Desarrolla una aplicación en **Java (Swing)** usando **JFrame** para implementar un juego interactivo **“Fuego, Agua o Planta”** entre el usuario y el ordenador (triángulo de ventajas tipo Pokémon).

## **Reglas del juego:**

- **Fuego** gana a **Planta**
- **Planta** gana a **Agua**
- **Agua** gana a **Fuego**

- Si ambos eligen lo mismo: **empate**

## **Interfaz (en un JFrame):**

1. **Tres botones** para que el usuario elija: **Fuego, Agua, Planta**.
2. **Otros tres botones** (a la derecha) que representen la elección del ordenador:
   - El ordenador selecciona uno de forma **aleatoria**.
   - Estos botones deben estar **deshabilitados** (no disponibles para el usuario).
   - El botón elegido por la máquina debe “marcarse” (por ejemplo, cambiando el color de fondo).
3. Un **JLabel** para mostrar el resultado: *“Ganas / Pierdes / Empate”*.
4. Un **JLabel** para mostrar la **puntuación** acumulada del jugador (y opcionalmente la del PC).

## **Estructura obligatoria:**

- Tener **2 clases**: una clase del JFrame (diseño) y una clase principal (lógica).
- Desde la clase principal se debe acceder a los componentes del JFrame mediante una **instancia** del JFrame y haciendo los botones/labels **public**.
- La lógica se ejecuta desde un método **public static** de la clase principal, llamado desde los eventos de los botones del JFrame, pasando como parámetro el texto del botón (`getText()`).

## Texto Classroom

Desarrolla una aplicación en Java (Swing) usando JFrame para implementar un juego interactivo “Fuego, Agua o Planta” entre el usuario y el ordenador (triángulo de ventajas tipo Pokémon).

Reglas del juego:

- Fuego gana a Planta
- Planta gana a Agua
- Agua gana a Fuego

Si ambos eligen lo mismo: empate
