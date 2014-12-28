package yate.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

/**
 * Simples Icon, das ein viereck in der übergebene Farbe darstellt.
 *
 * @author Laurin
 */
public class SimpleIcon implements Icon {

    //Die Farbe des Rechtecks.
    private Color color;

    private final int width, height;

    /**
     * Neue Instanz des SimpleIcon.
     *
     * @param c Color, die Farbe des Icons.
     */
    public SimpleIcon(Color c) {
        this.color = c;
        this.width = 25;
        this.height = 25;
    }

    /**
     * Getter für die Farbe.
     *
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Setter für die Farbe.
     *
     * @param color Color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gibt die Höhe des Icons zurück.
     *
     * @return Die Höhe.
     */
    @Override
    public int getIconHeight() {
        return height;
    }

    /**
     * Gibt die Breite des Icons zurück.
     *
     * @return Die Breite.
     */
    @Override
    public int getIconWidth() {
        return width;
    }

    /**
     * Überschreiben der Funktionen des Interfaces.
     *
     * @param c
     * @param g
     * @param x
     * @param y
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.drawRect(0, 0, 25, 25);
        g.fillRect(0, 0, 25, 25);
    }
}
