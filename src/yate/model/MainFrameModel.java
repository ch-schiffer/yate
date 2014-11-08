package yate.model;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.text.StyledDocument;
import yate.controller.CenterBoxController;
import yate.controller.ProjectMenuController;
import yate.view.CenterBoxView;
import yate.view.ProjectMenuView;

/**
 *
 * @author Laurin
 */
public class MainFrameModel extends Model {

    private boolean regex;
    private boolean searchVisible;
    private Font fonts[];
    private String[] fontSizes = {"10", "12", "14"};

    private ArrayList<CenterBoxController> centerBoxes;
    private ProjectMenuController projectMenuController;

    public MainFrameModel() {
        regex = false;
        searchVisible = true;
        centerBoxes = new ArrayList<>();
        loadSystemFonts();
    }

    public MainFrameModel(boolean regex, boolean searchVisible) {
        this.regex = regex;
        this.searchVisible = searchVisible;
    }

    public void loadSystemFonts() {
        fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
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

    public Font[] getFonts() {
        return fonts;
    }

    public String[] getFontsAsStrings() {
        String ret[] = new String[fonts.length];

        for (int i = 0; i < fonts.length; i++) {
            ret[i] = fonts[i].getName();
        }
        return ret;
    }

    public void setFonts(Font[] fonts) {
        this.fonts = fonts;
    }

    public String[] getFontSizes() {
        return fontSizes;
    }

    public void setFontSizes(String[] fontSizes) {
        this.fontSizes = fontSizes;
    }

    public void addCenterBox(String fileName, JTabbedPane jTP_tabed) {
        CenterBoxView view = new CenterBoxView();

        javax.swing.JTextPane pane = (javax.swing.JTextPane) view.getComponent("jTP_text");
        StyledDocument d = pane.getStyledDocument();
        CenterBoxModel model = new CenterBoxModel(d);

        CenterBoxController cbc = new CenterBoxController(view, model);
        cbc.addListener();

        centerBoxes.add(cbc);

        jTP_tabed.addTab(fileName, view);
    }

    public void addProjectMenu(String projectName, DefaultListModel<FileModel> fileModel, JPanel panel) {
        ProjectMenuView view = new ProjectMenuView();

        ProjectMenuModel model = new ProjectMenuModel();

        projectMenuController = new ProjectMenuController(view, model);
        projectMenuController.addListener();

        view.setProjectName(model.getProjectName());
        panel.add(view);
    }

}
