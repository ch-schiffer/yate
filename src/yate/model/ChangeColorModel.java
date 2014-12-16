package yate.model;

import java.awt.Color;
import javax.swing.DefaultListModel;
import yate.view.SimpleIcon;

/**
 *
 * @author Laurin
 */
public class ChangeColorModel {

    private final DefaultListModel listModel;

    private int selectedIndex = 0;
    //Test
    private final Object elements[][] = {
        {Color.RED, new SimpleIcon(Color.RED), "Identifier1"},
        {Color.BLUE, new SimpleIcon(Color.BLUE), "Identifier2"},
        {Color.GREEN, new SimpleIcon(Color.GREEN), "Identifier3"},
        {Color.GRAY, new SimpleIcon(Color.GRAY), "Identifier4"},
        {Color.PINK, new SimpleIcon(Color.PINK), "Identifier5"},
        {Color.YELLOW, new SimpleIcon(Color.YELLOW), "Identifier6"},
        {Color.DARK_GRAY, new SimpleIcon(Color.DARK_GRAY), "Identifier7"}};
    //Test ende
    
    
    public ChangeColorModel() {
        listModel = new DefaultListModel();
        //Test
        for (Object o : elements) {
            listModel.addElement(o);
        }
        //Test ende

    }
    
    private void addElement(Color c, String name)
    {
        Object[] element = {c,new SimpleIcon(c),name};
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
    
    public void setSelectedColor(Color c)
    {
         if (listModel.getElementAt(selectedIndex) != null
                && listModel.getElementAt(selectedIndex) instanceof Object[]) {
             ((Object[]) listModel.getElementAt(selectedIndex))[0]=c;
             ((SimpleIcon)((Object[]) listModel.getElementAt(selectedIndex))[1]).setColor(c);
        }
    }

    public DefaultListModel getListModel() {
        return listModel;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

}
