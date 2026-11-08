/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaswing;

import java.awt.Color;
import java.util.Random;
import javax.swing.JButton;
/**
 *
 * @author José Ángel
 */
/** Descripción de la clase:
 * Esta clase gestiona la lógica del juego de Fuego, Agua o Planta (triángulo de ventajas tipo Pokémon), y mantiene el estado del juego.
 * Se encarga de manejar las interacciones del usuario y actualizar la interfaz gráfica en consecuencia.
 * La interfaz gráfica está representada por la clase JFramePokemon y su JFrame asociado, construido con las librerías Swing de Java y el GUI Builder de NetBeans.
 * Se incluyen métodos para manejar las elecciones del jugador, reiniciar el juego y actualizar las puntuaciones y rondas.
 * Los elementos del JFrame JFramePokemon (como jLabel1, jTextArea1, etc.) se han declarado como public static para permitir acceso directo desde esta clase sin necesidad de instancias, facilitando la actualización de la UI de manera compartida.
 * Los botones correspondientes a la máquina (jButton4, jButton5, jButton6) se han configurado como no accesibles en NetBeans (propiedad 'enabled' en false) para evitar interacción directa del usuario, permitiendo solo su coloreo para mostrar la selección aleatoria de la máquina.
 */
/** Reglas del juego:
 * - Fuego gana a Planta
 * - Planta gana a Agua
 * - Agua gana a Fuego
 * - Si ambos eligen lo mismo: empate
 */
/** Consideraciones de diseño:
 * Si bien la lógica del juego podría optimizarse mediante uso de condiciones booleanas o estructuras de datos más complejas, se ha optado por una implementación directa y explícita para facilitar la comprensión del flujo del juego.
 * Se ha priorizado la claridad del código sobre la eficiencia o la concisión, dado el contexto educativo del proyecto y la intencionalidad del profesor de que los estudiantes comprendan los fundamentos básicos de la programación y la lógica de juegos simples.
 */
/** Consideración de empaquetado y creación del JAR ejecutable:
 * Para realizar una exportación a JAR correcta del juego Pokémon, evitando conflictos de clase o problemas de ejecución, así como para asegurar que todas las dependencias necesarias se incluyan, 
 * se debe usar el siguiente comando desde la terminal en el directorio "classes" del proyecto (normalmente target/classes en proyectos Maven):
 * jar cvfe JuegoPokemon.jar com.mycompany.practicaswing.ClassVentajas com/mycompany/practicaswing/*.class
 * Este comando crea un JAR ejecutable llamado JuegoPokemon.jar con ClassVentajas como clase principal, incluyendo todas las clases del paquete (JFramePokemon, PokemonIconGenerator, TriangleAdvantagePanel).
 */
public class ClassVentajas {
    public static JButton[] allBtn = new JButton[3];
    
    public static int jugador = 0;
    public static int maquina = 0;
    public static int empates = 0;
    public static int rondas = 0;
    public static int rondasG = 0;
    public static int rondasL = 0;
    public static int rondasE = 0;
    // Variable para rastrear el botón seleccionado por el usuario (gris persistente hasta reinicio)
    public static JButton seleccionUsuario = null;
        // Null es un valor especial que indica (en este caso) que no hay ningún botón seleccionado actualmente.
        // Utilizaré null permite diferenciar entre "ningún botón seleccionado" y "un botón seleccionado que podría ser cualquier botón".
    
    /** Método principal que inicia la aplicación, crea la ventana JFramePokemon y asigna los botones al array. 
     * Se declara public static void porque es el punto de entrada (requiere static), accesible públicamente y no devuelve valor. */
    public static void main(String[] args) {
        JFramePokemon nf = new JFramePokemon();
        nf.setVisible(true);
        allBtn[0] = nf.jButton4;
        allBtn[1] = nf.jButton5;
        allBtn[2] = nf.jButton6;
    }
    
    /** Maneja la lógica de una ronda del juego: selecciona la máquina, evalúa el resultado y actualiza la UI. 
     * Se declara public static void porque debe ser accesible desde JFramePokemon (public), compartido sin instancia (static) y no devuelve valor. */
    public static void BtnRm(JButton boton) {
        // Deseleccionar el botón anterior si existe (poner en blanco)
        if (seleccionUsuario != null) {
            seleccionUsuario.setBackground(Color.white);
        }
        Random rm = new Random();
        int NumRandom = rm.nextInt(allBtn.length);
        
        for (int i=0; i<allBtn.length; i++) {
            allBtn[i].setBackground(Color.white);
        }
        
        allBtn[NumRandom].setBackground(Color.red);
        boton.setBackground(Color.white);
        
        // Lógica del triángulo de ventajas: Fuego > Planta > Agua > Fuego
        if (boton.getText().equals(allBtn[NumRandom].getText())) {
            // Empate
            JFramePokemon.jLabel1.setText("Empate 0.0");
            JFramePokemon.jLabel1.setBackground(Color.orange);
            empates++;
        } else if ((boton.getText().equals("Agua") && allBtn[NumRandom].getText().equals("Fuego")) || (boton.getText().equals("Planta") && allBtn[NumRandom].getText().equals("Agua")) || (boton.getText().equals("Fuego") && allBtn[NumRandom].getText().equals("Planta"))) {
            // Victoria del usuario: Agua>Fuego, Planta>Agua, Fuego>Planta
            JFramePokemon.jLabel1.setText("¡Has ganado!");
            JFramePokemon.jLabel1.setBackground(Color.green);
            jugador++;
        } else {
            // Derrota (victoria de la máquina)
            JFramePokemon.jLabel1.setText("Pierdes D:");
            JFramePokemon.jLabel1.setBackground(Color.red);
            maquina++;
        }
        
        // Actualizar el TextArea1 con las puntuaciones actuales
        JFramePokemon.jTextArea1.setText("PUNTUACIÓN\n" + "Jugador: " + jugador + "\n" + "Máquina: " + maquina + "\n" + "Empates: " + empates);
        
        // Seleccionar el nuevo botón y colorearlo en gris (persistente)
        seleccionUsuario = boton;
        boton.setBackground(Color.gray);
    }
    
    /** Resetea completamente el juego: puntuaciones, rondas, UI y selección de usuario. 
     * Se declara public static void porque debe ser accesible desde JFramePokemon (public), compartido sin instancia (static) y no devuelve valor. */
    public static void BtnReinicioTotal(JButton jButton7) {
        jugador = 0;
        maquina = 0;
        empates = 0;
        rondas = 0;
        rondasG = 0;
        rondasL = 0;
        rondasE = 0;
        JFramePokemon.jTextArea1.setText("PUNTUACIÓN\n" + "Jugador: " + jugador + "\n" + "Máquina: " + maquina + "\n" + "Empates: " + empates);
        JFramePokemon.jTextArea2.setText("RONDAS: " + rondas + "\n" + "Ganadas: " + rondasG + "\n" + "Perdidas: " + rondasL + "\n" + "Empatadas: " + rondasE);
        JFramePokemon.jLabel1.setText("Resultado");
        JFramePokemon.jLabel1.setBackground(Color.white);
        // Resetear el botón seleccionado a blanco y null (reinicio total)
        if (seleccionUsuario != null) {
            seleccionUsuario.setBackground(Color.white);
        }
        seleccionUsuario = null;
        // Resetear los botones de la máquina a blanco
        for (int i = 0; i < allBtn.length; i++) {
            allBtn[i].setBackground(Color.white);
        }
    }
    
    /** Resetea parcialmente: calcula rondas ganadas/perdidas, resetea puntuaciones y UI, mantiene estadísticas acumuladas. 
     * Se declara public static void porque debe ser accesible desde JFramePokemon (public), compartido sin instancia (static) y no devuelve valor. */
    public static void BtnReinicio(JButton jButton8) {
        // Primer IF, para lógica de puntuación y rondas
        if (jugador > 0 || maquina > 0 || empates > 0) {  // Cuando hay alguna puntuación que considerar
            rondas++;  // Siempre suma 1 ronda por sesión
            if (jugador > maquina) {
                rondasG++;  // Más victorias del jugador
            } else if (maquina > jugador) {
                rondasL++;  // Más victorias de la máquina
            } else {
                rondasE++;  // Empates o igualados
            }
        }  // Si no hay puntuaciones, significa que o el usuario acaba de empezar, o se ha usado el botón de reinicio total (jButton7)

        // Después resetear puntuaciones siempre, independientemente del IF anterior
        jugador = 0;
        maquina = 0;
        empates = 0;

        // Para acabar actualizar GUI de JFrame (jTextArea 1 y 2, jLabel y colores de botones)
        JFramePokemon.jTextArea2.setText("RONDAS: " + rondas + "\n" + "Ganadas: " + rondasG + "\n" + "Perdidas: " + rondasL + "\n" + "Empatadas: " + rondasE);
        JFramePokemon.jTextArea1.setText("PUNTUACIÓN\n" + "Jugador: " + jugador + "\n" + "Máquina: " + maquina + "\n" + "Empates: " + empates);
        JFramePokemon.jLabel1.setText("Resultado");
        JFramePokemon.jLabel1.setBackground(Color.white);
        // Resetear el botón seleccionado a blanco y null (reinicio parcial)
        if (seleccionUsuario != null) {
            seleccionUsuario.setBackground(Color.white);
        }
        seleccionUsuario = null;
        // Resetear los botones de la máquina a blanco
        for (int i = 0; i < allBtn.length; i++) {
            allBtn[i].setBackground(Color.white);
        }
    }
}
