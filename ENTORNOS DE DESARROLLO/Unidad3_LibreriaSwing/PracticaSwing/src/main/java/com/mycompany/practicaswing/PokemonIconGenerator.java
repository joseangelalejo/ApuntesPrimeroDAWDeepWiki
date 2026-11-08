package com.mycompany.practicaswing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 * Generador de iconos para tipos Pokémon
 * @author José Ángel
 */
public class PokemonIconGenerator {
    
    private static final int ICON_SIZE = 48;
    
    /**
     * Genera un icono de tipo Agua (gota de agua)
     */
    public static ImageIcon createWaterIcon() {
        BufferedImage img = new BufferedImage(ICON_SIZE, ICON_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Fondo circular azul claro
        g2d.setColor(new Color(100, 180, 255, 200));
        g2d.fillOval(2, 2, ICON_SIZE - 4, ICON_SIZE - 4);
        
        // Gota de agua (azul oscuro)
        g2d.setColor(new Color(30, 100, 200));
        // Forma de gota
        int[] xPoints = {ICON_SIZE/2, ICON_SIZE/2 - 8, ICON_SIZE/2 - 10, ICON_SIZE/2, ICON_SIZE/2 + 10, ICON_SIZE/2 + 8};
        int[] yPoints = {12, 20, 30, 38, 30, 20};
        g2d.fillPolygon(xPoints, yPoints, 6);
        
        // Brillo en la gota
        g2d.setColor(new Color(150, 220, 255, 180));
        g2d.fillOval(ICON_SIZE/2 - 3, 18, 5, 5);
        
        g2d.dispose();
        return new ImageIcon(img);
    }
    
    /**
     * Genera un icono de tipo Fuego (llama)
     */
    public static ImageIcon createFireIcon() {
        BufferedImage img = new BufferedImage(ICON_SIZE, ICON_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Fondo circular naranja claro
        g2d.setColor(new Color(255, 180, 100, 200));
        g2d.fillOval(2, 2, ICON_SIZE - 4, ICON_SIZE - 4);
        
        // Llama externa (rojo-naranja)
        g2d.setColor(new Color(255, 100, 30));
        int[] xPointsOuter = {ICON_SIZE/2, ICON_SIZE/2 - 10, ICON_SIZE/2 - 12, ICON_SIZE/2 - 8, ICON_SIZE/2, ICON_SIZE/2 + 8, ICON_SIZE/2 + 12, ICON_SIZE/2 + 10};
        int[] yPointsOuter = {10, 16, 24, 32, 38, 32, 24, 16};
        g2d.fillPolygon(xPointsOuter, yPointsOuter, 8);
        
        // Llama interna (amarillo)
        g2d.setColor(new Color(255, 220, 50));
        int[] xPointsInner = {ICON_SIZE/2, ICON_SIZE/2 - 6, ICON_SIZE/2 - 7, ICON_SIZE/2 - 5, ICON_SIZE/2, ICON_SIZE/2 + 5, ICON_SIZE/2 + 7, ICON_SIZE/2 + 6};
        int[] yPointsInner = {14, 18, 24, 30, 34, 30, 24, 18};
        g2d.fillPolygon(xPointsInner, yPointsInner, 8);
        
        g2d.dispose();
        return new ImageIcon(img);
    }
    
    /**
     * Genera un icono de tipo Planta (hoja)
     */
    public static ImageIcon createGrassIcon() {
        BufferedImage img = new BufferedImage(ICON_SIZE, ICON_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Fondo circular verde claro
        g2d.setColor(new Color(150, 255, 150, 200));
        g2d.fillOval(2, 2, ICON_SIZE - 4, ICON_SIZE - 4);
        
        // Hoja (verde oscuro)
        g2d.setColor(new Color(50, 180, 50));
        // Forma de hoja
        int[] xPoints = {ICON_SIZE/2, ICON_SIZE/2 - 12, ICON_SIZE/2 - 10, ICON_SIZE/2 - 6, ICON_SIZE/2, ICON_SIZE/2 + 6, ICON_SIZE/2 + 10, ICON_SIZE/2 + 12};
        int[] yPoints = {12, 18, 24, 30, 38, 30, 24, 18};
        g2d.fillPolygon(xPoints, yPoints, 8);
        
        // Nervio central de la hoja
        g2d.setColor(new Color(80, 200, 80));
        g2d.fillRect(ICON_SIZE/2 - 1, 14, 2, 22);
        
        // Nervios laterales
        g2d.drawLine(ICON_SIZE/2, 20, ICON_SIZE/2 - 6, 24);
        g2d.drawLine(ICON_SIZE/2, 20, ICON_SIZE/2 + 6, 24);
        g2d.drawLine(ICON_SIZE/2, 26, ICON_SIZE/2 - 5, 30);
        g2d.drawLine(ICON_SIZE/2, 26, ICON_SIZE/2 + 5, 30);
        
        g2d.dispose();
        return new ImageIcon(img);
    }
}
