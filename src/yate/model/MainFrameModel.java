package yate.model;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SingleSelectionModel;
import javax.swing.text.StyledDocument;
import yate.controller.CenterBoxController;
import yate.controller.ProjectMenuController;
import yate.project.File;
import yate.project.Project;
import yate.view.CenterBoxView;
import yate.view.ProjectMenuView;

/**
 *
 * @author Laurin
 */
public class MainFrameModel {

    private boolean regex;
    private boolean searchVisible;
    private final Font[] availableFonts;
    private final String[] availableFontSizes;

    private DefaultComboBoxModel<String> fonts;
    private DefaultComboBoxModel<String> fontSizes;
    private SingleSelectionModel tabedPaneModel;

    private ArrayList<CenterBoxController> centerBoxes;
    private ProjectMenuController projectMenuController;

    public MainFrameModel(DefaultComboBoxModel<String> fonts, DefaultComboBoxModel<String> fontSizes, SingleSelectionModel tabedPaneModel) {
        this.availableFontSizes = new String[]{"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36"};
        regex = false;
        searchVisible = true;
        centerBoxes = new ArrayList<>();
        availableFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        this.fontSizes = fontSizes;
        this.fonts = fonts;
        this.tabedPaneModel = tabedPaneModel;

        for (String s : getFontsAsStrings()) {
            if (s != null && s.trim().length() > 0) {
                this.fonts.addElement(s);
                if (s.equals("Arial")) {
                    //07.12.14 CHS
                    //Wenn Arial vorhanden ist, als Standardfont nutzen
                    //Der erste in der Liste ist Mist
                    fonts.setSelectedItem("Arial");
                }
            }
        }

        for (String s : this.availableFontSizes) {
            this.fontSizes.addElement(s);
        }

        this.fontSizes.setSelectedItem("12");

    }

    /**
     * Getter für das aktuelle CenterBoxModel
     *
     * @return CenterBoxModel
     */
    public CenterBoxModel getCurrentCenterBox() {
        //13.12.2014 CHS
        //Einfacher Zugriff auf Aktuelle CenterBox
        int selectedIndex = getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < this.getCenterBoxes().size()) {
            return this.getCenterBoxes().get(selectedIndex).getModel();
        }
        return null;
    }

    public int getSelectedIndex() {
        return tabedPaneModel.getSelectedIndex();
    }

    public MainFrameModel(DefaultComboBoxModel<String> fonts, DefaultComboBoxModel<String> fontSizes, SingleSelectionModel tabedPaneModel, boolean regex, boolean searchVisible) {
        this(fonts, fontSizes, tabedPaneModel);
        this.regex = regex;
        this.searchVisible = searchVisible;
    }

    public String getSelectedFont() {
        return (String) fonts.getSelectedItem();
    }

    public int getSelectedFontSize() {
        return Integer.parseInt((String) fontSizes.getSelectedItem());
    }

    public void setRegex(boolean regex) {
        this.regex = regex;
    }

    public void setSearchVisible(boolean searchVisible) {
        this.searchVisible = searchVisible;
    }

    public boolean isRegex() {
        return regex;
    }

    public boolean isSearchVisible() {
        return searchVisible;
    }

    public ArrayList<CenterBoxController> getCenterBoxes() {
        return centerBoxes;
    }

    public ProjectMenuController getProjectMenuController() {
        return projectMenuController;
    }

    public void setCenterBoxes(ArrayList<CenterBoxController> centerBoxes) {
        this.centerBoxes = centerBoxes;
    }

    public void setProjectMenuController(ProjectMenuController projectMenuController) {
        this.projectMenuController = projectMenuController;
    }

    private String[] getFontsAsStrings() {
        String ret[] = new String[availableFonts.length];

        for (int i = 0; i < availableFonts.length; i++) {
            if (availableFonts[i].canDisplay('a')) {
                ret[i] = availableFonts[i].getName();
            }
        }
        return ret;
    }

    public CenterBoxController addCenterBox(File file) {
        CenterBoxView view = new CenterBoxView();

        StyledDocument document = view.getStyledDocument();

        CenterBoxModel model = new CenterBoxModel(document, file, view.getTextPane());

        view.setFont(getSelectedFont(), getSelectedFontSize());

        CenterBoxController cbc = new CenterBoxController(view, model);
        centerBoxes.add(cbc);

        return cbc;
    }

    public void removeCenterBoxController(CenterBoxController cbc) {
        centerBoxes.remove(cbc);
    }

    public void addProjectMenu(Project project) {
        ProjectMenuView view = new ProjectMenuView();
        ProjectMenuModel model = new ProjectMenuModel(project);

        projectMenuController = new ProjectMenuController(view, model);

        view.setProjectName(model.getProjectName());
    }
}
