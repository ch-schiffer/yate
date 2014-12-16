package yate.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

/**
 *
 * @author Laurin
 */
public class SimpleIcon implements Icon {

    private Color color;

    public SimpleIcon(Color c) {
        this.color = c;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int getIconHeight() {
        return 20;
    }

    @Override
    public int getIconWidth() {
        return 20;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.drawRect(0, 0, 25, 25);
        g.fillRect(0, 0, 25, 25);
    }
}
