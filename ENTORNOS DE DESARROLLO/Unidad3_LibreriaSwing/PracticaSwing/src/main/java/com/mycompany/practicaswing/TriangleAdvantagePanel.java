package com.mycompany.practicaswing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 * Panel personalizado que dibuja el triángulo de ventajas de tipos Pokémon
 * Agua > Fuego > Planta > Agua
 * @author José Ángel
 */
public class TriangleAdvantagePanel extends JPanel {
    
    private static final int PANEL_WIDTH = 180;
    private static final int PANEL_HEIGHT = 160;
    private static final int ICON_SIZE = 48;
    
    public TriangleAdvantagePanel() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setOpaque(false); // Fondo transparente
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Coordenadas del triángulo equilátero
        int centerX = PANEL_WIDTH / 2;
        int topY = 20;
        int bottomY = PANEL_HEIGHT - 30;
        int leftX = 40;
        int rightX = PANEL_WIDTH - 40;
        
        // Punto superior (Agua)
        int x1 = centerX;
        int y1 = topY;
        
        // Punto inferior izquierdo (Fuego)
        int x2 = leftX;
        int y2 = bottomY;
        
        // Punto inferior derecho (Planta)
        int x3 = rightX;
        int y3 = bottomY;
        
        // Dibujar el triángulo
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new java.awt.BasicStroke(2));
        g2d.drawLine(x1, y1, x2, y2); // Superior a Fuego
        g2d.drawLine(x2, y2, x3, y3); // Fuego a Planta
        g2d.drawLine(x3, y3, x1, y1); // Planta a Superior
        
        // Dibujar iconos en las esquinas
        // Agua (arriba)
        PokemonIconGenerator.createWaterIcon().paintIcon(this, g2d, x1 - ICON_SIZE/2, y1 - ICON_SIZE/2);
        
        // Fuego (abajo izquierda)
        PokemonIconGenerator.createFireIcon().paintIcon(this, g2d, x2 - ICON_SIZE/2, y2 - ICON_SIZE/2 + 10);
        
        // Planta (abajo derecha)
        PokemonIconGenerator.createGrassIcon().paintIcon(this, g2d, x3 - ICON_SIZE/2, y3 - ICON_SIZE/2 + 10);
        
        // Dibujar símbolos ">" de ventaja
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.setColor(new Color(0, 100, 0)); // Verde oscuro para las flechas
        
        // Lado izquierdo: Agua > Fuego
        int midLeftX = (x1 + x2) / 2 - 15;
        int midLeftY = (y1 + y2) / 2;
        g2d.drawString(">", midLeftX, midLeftY);
        
        // Lado inferior: Fuego > Planta
        int midBottomX = (x2 + x3) / 2 - 5;
        int midBottomY = (y2 + y3) / 2 + 15;
        g2d.drawString(">", midBottomX, midBottomY);
        
        // Lado derecho: Planta > Agua
        int midRightX = (x3 + x1) / 2 + 5;
        int midRightY = (y3 + y1) / 2;
        g2d.drawString(">", midRightX, midRightY);
    }
}
