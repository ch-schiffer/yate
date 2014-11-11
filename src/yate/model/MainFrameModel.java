package yate.model;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.SingleSelectionModel;
import javax.swing.text.StyledDocument;
import yate.controller.CenterBoxController;
import yate.controller.ProjectMenuController;
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

    public MainFrameModel(DefaultComboBoxModel<String> fonts, DefaultComboBoxModel<String> fontSizes) {
        this.availableFontSizes = new String[]{"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36"};
        regex = false;
        searchVisible = true;
        centerBoxes = new ArrayList<>();
        availableFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        this.fontSizes = fontSizes;
        this.fonts = fonts;

        for (String s : getFontsAsStrings()) {
            this.fonts.addElement(s);
        }

        for (String s : this.availableFontSizes) {
            this.fontSizes.addElement(s);
        }

        this.fontSizes.setSelectedItem("12");
        this.fonts.setSelectedItem("Arial");
    }

    public MainFrameModel(DefaultComboBoxModel<String> fonts, DefaultComboBoxModel<String> fontSizes, boolean regex, boolean searchVisible) {
        this(fonts, fontSizes);
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

    public String[] getFontsAsStrings() {
        String ret[] = new String[availableFonts.length];

        for (int i = 0; i < availableFonts.length; i++) {
            ret[i] = availableFonts[i].getName();
        }
        return ret;
    }

    public CenterBoxController addCenterBox() {
        CenterBoxView view = new CenterBoxView();

        StyledDocument d = view.getStyledDocument();
        CenterBoxModel model = new CenterBoxModel(d);

        view.setFont(getSelectedFont(), getSelectedFontSize());

        CenterBoxController cbc = new CenterBoxController(view, model);
        centerBoxes.add(cbc);

        return cbc;
    }

    public void addProjectMenu(String projectName, DefaultListModel<FileModel> fileModel) {
        ProjectMenuView view = new ProjectMenuView();

        ProjectMenuModel model = new ProjectMenuModel("test", fileModel);

        projectMenuController = new ProjectMenuController(view, model);

        view.setProjectName(model.getProjectName());
    }

}
