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

    private final DefaultListModel listModel;
    private boolean confirmed = false;

    private int selectedIndex = 0;

    public ChangeColorModel(HashMap<String, String> colorKeys) {
        listModel = new DefaultListModel();
        for (String key : colorKeys.keySet()) {
            addElement(ColorManager.getInstance().getColor(key), colorKeys.get(key));
        }
    }

    public HashMap<String, Color> getModifyedElements() {
        HashMap<String, Color> colorKeys = new HashMap<>();

        for (Object o : listModel.toArray()) {
            Color c = (Color) ((Object[]) o)[0];
            String s = (String) ((Object[]) o)[2];

            colorKeys.put(s.trim(), c);
        }
        return colorKeys;
    }

    private void addElement(Color c, String name) {
        Object[] element = {c, new SimpleIcon(c), name};
        listModel.addElement(element);
    }

    public Color getSelectedColor() {
        if (listModel.getElementAt(selectedIndex) != null
                && listModel.getElementAt(selectedIndex) instanceof Object[]) {
            return ((Color) ((Object[]) listModel.getElementAt(selectedIndex))[0]);

        } else {
            return null;
        }
    }

    public void setSelectedColor(Color c) {
        if (listModel.getElementAt(selectedIndex) != null
                && listModel.getElementAt(selectedIndex) instanceof Object[]) {
            ((Object[]) listModel.getElementAt(selectedIndex))[0] = c;
            ((SimpleIcon) ((Object[]) listModel.getElementAt(selectedIndex))[1]).setColor(c);
        }
    }

    public DefaultListModel getListModel() {
        return listModel;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

}
