package yate.model;

import java.awt.Color;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import yate.managers.ColorManager;
import yate.view.SimpleIcon;

/**
 *
 * @author Laurin
 */
public class ChangeColorModel {

    //Das model der JList für die Farben und Identifier.
    private final DefaultListModel listModel;
    //Varibale um zu prüfen, ob Ok oder Abbrechen gewählt wurde.
    private boolean confirmed = false;
    //Der ausgewählte Index der JList.
    private int selectedIndex = 0;

    /**
     * Der Konstuktor vom ChangeColorModel nutz die übergebene HashMap, um das
     * Model der JList mit den passenden Elemneten zu füllen.
     *
     * @param colorKeys Die Initialen Identifier und Farben als HashMap.
     */
    public ChangeColorModel(HashMap<String, String> colorKeys) {
        listModel = new DefaultListModel();
        for (String key : colorKeys.keySet()) {
            addElement(ColorManager.getInstance().getColor(key), colorKeys.get(key));
        }
    }

    /**
     * Die Funktion gibt eine HashMap<String,Color> mit den geänderten Werten
     * zurück.
     *
     * @return Die geänderten Werte.
     */
    public HashMap<String, Color> getModifiedElements() {
        HashMap<String, Color> colorKeys = new HashMap<>();

        for (Object o : listModel.toArray()) {
            Color c = (Color) ((Object[]) o)[0];
            String s = (String) ((Object[]) o)[2];

            colorKeys.put(s.trim(), c);
        }
        return colorKeys;
    }

    /**
     * Die Funktion fügt eine Farbe und einen Identifier in das Model eiin.
     *
     * @param c Color
     * @param name Identifier
     */
    private void addElement(Color c, String name) {
        Object[] element = {c, new SimpleIcon(c), name};
        listModel.addElement(element);
    }

    /**
     * Gibt die in der JList ausgewählte Farbe zurück. Wenn nichts gewählt ist
     * wird null zurückgegeben.
     *
     * @return Die ausgewählte Farbe.
     */
    public Color getSelectedColor() {
        if (listModel.getElementAt(selectedIndex) != null
                && listModel.getElementAt(selectedIndex) instanceof Object[]) {
            return ((Color) ((Object[]) listModel.getElementAt(selectedIndex))[0]);

        } else {
            return null;
        }
    }

    /**
     * Setzt die Farbe des gerade ausgewählten Eintrags der JList. Ist nichts
     * ausgewählt oder die Farbe null passiert nichts.
     *
     * @param c Die zu setzende Farbe.
     */
    public void setSelectedColor(Color c) {
        if (c != null && listModel.getElementAt(selectedIndex) != null
                && listModel.getElementAt(selectedIndex) instanceof Object[]) {
            ((Object[]) listModel.getElementAt(selectedIndex))[0] = c;
            ((SimpleIcon) ((Object[]) listModel.getElementAt(selectedIndex))[1]).setColor(c);
        }
    }

    /**
     * Getter für das model der JList.
     *
     * @return Model der JList.
     */
    public DefaultListModel getListModel() {
        return listModel;
    }

    /**
     * Setter für den selectedIndex
     *
     * @param selectedIndex
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    /**
     * Getter um zu prüfen, ob der Ok button verwendet wurde.
     *
     * @return
     */
    public boolean isConfirmed() {
        return confirmed;
    }

    /**
     * Setter um den confirmed wert zu setzen.
     *
     * @param confirmed
     */
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

}
