
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
 * Esta clase gestiona la lógica del juego de Piedra, Papel o Tijera, y mantiene el estado del juego.
 * Se encarga de manejar las interacciones del usuario y actualizar la interfaz gráfica en consecuencia.
 * La interfaz gráfica está representada por la clase PPT y su JFrame asociado, construido con las librerías Swing de Java y el GUI Builder de NetBeans.
 * Se incluyen métodos para manejar las elecciones del jugador, reiniciar el juego y actualizar las puntuaciones y rondas.
 * Los elementos del JFrame PPT (como jLabel1, jTextArea1, etc.) se han declarado como public static para permitir acceso directo desde esta clase sin necesidad de instancias, facilitando la actualización de la UI de manera compartida.
 * Los botones correspondientes a la máquina (jButton4, jButton5, jButton6) se han configurado como no accesibles en NetBeans (propiedad 'enabled' en false) para evitar interacción directa del usuario, permitiendo solo su coloreo para mostrar la selección aleatoria de la máquina.
 */
/** Consideraciones de diseño:
 * Si bien la lógica del juego podría optimizarse mediante uso de condiciones booleanas o estructuras de datos más complejas, se ha optado por una implementación directa y explícita para facilitar la comprensión del flujo del juego.
 * Se ha priorizado la claridad del código sobre la eficiencia o la concisión, dado el contexto educativo del proyecto y la intencionalidad del profesor de que los estudiantes comprendan los fundamentos básicos de la programación y la lógica de juegos simples.
 * Se han realizado pruebas para asegurar que la lógica de puntuación y rondas funciona correctamente.
 * La lógica descartada por ser errónea se ha comentado en el código para referencia futura.
 */
/** Consideración de empaquetado y creación del JAR ejecutable:
 * Debido a la organización de las clases y paquetes en el proyecto y el repositorio, esta clase no se encuentra en un paquete específico, por lo que para realizar una exportación a JAR correcta, evitando
 * conflictos de clase o problemas de ejecución, así como para asegurar que todas las dependencias necesarias se incluyan, se debe usar el siguiente comando desde la terminal en el directorio "classes" del proyecto:
 * `jar cvfe PracticaSwing.jar com.mycompany.practicaswing.PPT com/mycompany/practicaswing/NewClass1.class com/mycompany/practicaswing/PPT*.class`
 */
public class NewClass1 {
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
    /** Método principal que inicia la aplicación, crea la ventana PPT y asigna los botones al array. 
     * Se declara public static void porque es el punto de entrada (requiere static), accesible públicamente y no devuelve valor. */
    public static void main(String[] args) {
    PPT nf = new PPT();
    nf.setVisible(true);
    allBtn[0] = nf.jButton4;
    allBtn[1] = nf.jButton5;
    allBtn[2] = nf.jButton6;
    }
    /** Maneja la lógica de una ronda del juego: selecciona la máquina, evalúa el resultado y actualiza la UI. 
     * Se declara public static void porque debe ser accesible desde PPT (public), compartido sin instancia (static) y no devuelve valor. */
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
        // Lógica reducida
        if (boton.getText().equals(allBtn[NumRandom].getText())) {
            // Empate
            PPT.jLabel1.setText("Empate 0.0");
            PPT.jLabel1.setBackground(Color.orange);
            empates++;
        } else if ((boton.getText().equals("Papel") && allBtn[NumRandom].getText().equals("Piedra")) || (boton.getText().equals("Piedra") && allBtn[NumRandom].getText().equals("Tijera")) || (boton.getText().equals("Tijera") && allBtn[NumRandom].getText().equals("Papel"))) {
            // Victoria del usuario
            PPT.jLabel1.setText("¡Has ganado!");
            PPT.jLabel1.setBackground(Color.green);
            jugador++;
        } else {
            // Derrota (victoria de la máquina)
            PPT.jLabel1.setText("Pierde D:");
            PPT.jLabel1.setBackground(Color.red);
            maquina++;
        }
        // Actualizar el TextArea1 con las puntuaciones actuales
        PPT.jTextArea1.setText("PUNTUACIÓN\n" + "Jugador: " + jugador + "\n" + "Máquina: " + maquina + "\n" + "Empates: " + empates);
        // Seleccionar el nuevo botón y colorearlo en gris (persistente)
        seleccionUsuario = boton;
        boton.setBackground(Color.gray);
        /* Lógica original comentada, correcta pero demasiado extensa...
            if (boton.getText().equals(allBtn[NumRandom].getText())) {
                PPT.jLabel1.setText("Empate 0.0");
                PPT.jLabel1.setBackground(Color.orange);
                empates++;
            } else if (boton.getText().equals("Papel") && allBtn[NumRandom].getText().equals("Tijera")){
                PPT.jLabel1.setText("Pierde D:");
                PPT.jLabel1.setBackground(Color.red);
                maquina++;
            } else if (boton.getText().equals("Papel") && allBtn[NumRandom].getText().equals("Piedra")){
                PPT.jLabel1.setText("¡Has ganado!");
                PPT.jLabel1.setBackground(Color.green);
                jugador++;
            } else if (boton.getText().equals("Piedra") && allBtn[NumRandom].getText().equals("Papel")){
                PPT.jLabel1.setText("Pierde D:");
                PPT.jLabel1.setBackground(Color.red);
                maquina++;
            } else if (boton.getText().equals("Piedra") && allBtn[NumRandom].getText().equals("Tijera")){
                PPT.jLabel1.setText("¡Has ganado!");
                PPT.jLabel1.setBackground(Color.green);
                jugador++;
            } else if (boton.getText().equals("Tijera") && allBtn[NumRandom].getText().equals("Piedra")){
                PPT.jLabel1.setText("Pierde D:");
                PPT.jLabel1.setBackground(Color.red);
                maquina++;
            } else if (boton.getText().equals("Tijera") && allBtn[NumRandom].getText().equals("Papel")){
                PPT.jLabel1.setText("¡Has ganado!");
                PPT.jLabel1.setBackground(Color.green);
                jugador++;
            }
        */
    }
    
    /** Resetea completamente el juego: puntuaciones, rondas, UI y selección de usuario. 
     * Se declara public static void porque debe ser accesible desde PPT (public), compartido sin instancia (static) y no devuelve valor. */
    public static void BtnReinicioTotal(JButton jButton7) {
        jugador = 0;
        maquina = 0;
        empates = 0;
        rondas = 0;
        rondasG = 0;
        rondasL = 0;
        rondasE = 0;
        PPT.jTextArea1.setText("PUNTUACIÓN\n" + "Jugador: " + jugador + "\n" + "Máquina: " + maquina + "\n" + "Empates: " + empates);
        PPT.jTextArea2.setText("RONDAS: " + rondas + "\n" + "Ganadas: " + rondasG + "\n" + "Perdidas: " + rondasL + "\n" + "Empatadas: " + rondasE);
        PPT.jLabel1.setText("Resultado");
        PPT.jLabel1.setBackground(Color.white);
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
     * Se declara public static void porque debe ser accesible desde PPT (public), compartido sin instancia (static) y no devuelve valor. */
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
        }  // Si no hay puntuaciones, significa que o el usuario acaba de empezar, o se ha usado mi botón de reinicio total (jButton7)

        // Después resetear puntuaciones siempre, independientemente del IF anterior
        jugador = 0;
        maquina = 0;
        empates = 0;

        // Para acabar actualizar GUI de JFrame (jTextArea 1 y 2, jLabel y colores de botones)
        PPT.jTextArea2.setText("RONDAS: " + rondas + "\n" + "Ganadas: " + rondasG + "\n" + "Perdidas: " + rondasL + "\n" + "Empatadas: " + rondasE);
        PPT.jTextArea1.setText("PUNTUACIÓN\n" + "Jugador: " + jugador + "\n" + "Máquina: " + maquina + "\n" + "Empates: " + empates);
        PPT.jLabel1.setText("Resultado");
        PPT.jLabel1.setBackground(Color.white);
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
    // DONE: Implementar lógica para colorear el botón seleccionado por el usuario en gris. Debe cambiarse cuando se pulsa otro botón.
    // DONE: Implementar lógica para rondas ganadas, perdidas y empatadas en un nuevo jTextArea
    /* Lógica antigua de botón reinicio, comentada para referencia de implementación erronea
    // Nuevo método con lógica para el boton de la GUI jButton7
        //  Contiene:
        //    - Linea 80: setText para el TextArea2 (almacena la puntuación)
        //    - Linea 81: setText para jLabel1 (contiene el resultado de la ronda actual)
        //    - Linea 82: setBackground para restablecer color de jLabel1 a blanco
        //    - Línea 83->85: bucle For para restablecer el color de todos los botones de la máquina
        //
        // DONE: Logica de boton reinicio, en botón reinicio. Línea 95 
    public static void BtnReinicio(JButton jButton8) {
        // IF para lógica de puntuación
        // FIX no contempla puntuaciones 0 pero rondas con valor
        if ((jugador == 0 && maquina == 0 && empates ==0) && (rondas ==0 || rondasG == 0 || rondasL == 0 || rondasE ==0)){   // Si todas las puntuaciones son 0, significa que se ha usado el jButton7 o que acabamos de empezar.
            jugador=0;                                                                                                         // Por
            maquina=0;
            empates=0;
            rondas = 0;                                     // Significa que se ha usado el reinicio total
            rondasG = 0;
            rondasL = 0;
            rondasE = 0;
        } else if (rondas > 0) { // Si las rondas no son 0, las puntuaciones si lo serán, pero se conservan las rondas con su valor actual
            rondas = rondas; 
            rondasG = rondasG;
            rondasL = rondasL;
            rondasE = rondasE;
        }else {
            if ((jugador > maquina)) {          // Condición para rondas ganadas
                rondas++;
                rondasG++;
            } else if (jugador < maquina) {     // Condición para rondas perdidas
                rondas++;
                rondasL++;
            } else if (jugador == maquina) {    // Condición para empates
                rondas++;
                rondasE++;
            }
        }
        PPT.jTextArea2.setText("RONDAS: " + rondas + "\n" + "Ganadas: " + rondasG + "\n" + "Perdidas: " + rondasL + "\n" + "Empatadas: " + rondasE);
        jugador = 0;
        maquina = 0;
        empates = 0;
        PPT.jTextArea1.setText("PUNTUACIÓN\n" + "Jugador: " + jugador + "\n" + "Máquina: " + maquina + "\n" + "Empates: " + empates);
        PPT.jLabel1.setText("Resultado");
        PPT.jLabel1.setBackground(Color.white);
        for (int i=0; i<allBtn.length; i++) {
            allBtn[i].setBackground(Color.white);
        }
    }
    */
    }
