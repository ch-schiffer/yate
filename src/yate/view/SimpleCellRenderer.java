package yate.view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Eigener Cell Renderer, der ein farbiges Icon und einen String in der gleichen
 * Farbe in einer Listenzeile darstellt.
 *
 * @author Laurin
 */
public class SimpleCellRenderer implements ListCellRenderer {

    /**
     * Überschreiben der Funktionen des Interfaces.
     *
     * @param list
     * @param value
     * @param index
     * @param isSelected
     * @param cellHasFocus
     * @return
     */
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        //Die Farbe des Textes und des Icons.
        Color theForeground = null;
        Icon theIcon = null;
        //Der Text, der Später gezeigt werden soll.
        String theText = null;

        //Das Label für den String
        JLabel renderer = (JLabel) new DefaultListCellRenderer().getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

        //Sichergehen, dass ein Array übergeben wurde.
        if (value instanceof Object[]) {
            Object values[] = (Object[]) value;
            //Abfragen der Werte.
            theForeground = (Color) values[0];
            theIcon = (Icon) values[1];
            theText = "     " + (String) values[2];
        } else {
            //Falls fehlerhafte übergabe setzen von default Werten.
            theForeground = list.getForeground();
            theText = "";
        }

        if (!isSelected) {
            renderer.setForeground(theForeground);
        }
        if (theIcon != null) {
            renderer.setIcon(theIcon);
        }

        renderer.setText(theText);

        return renderer;
    }

}
