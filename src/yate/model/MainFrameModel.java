package yate.model;

import java.util.ArrayList;
import yate.controll.CenterBoxController;
import yate.controll.ProjectMenuController;

/**
 *
 * @author Laurin
 */
public class MainFrameModel extends Model{
    private boolean regex;
    private boolean searchVisible;
    
    private ArrayList<CenterBoxController> centerBoxes;
    private ProjectMenuController projectMenuController;

    public MainFrameModel() {
        regex = false;
        searchVisible=true;
    }

    public MainFrameModel(boolean regex, boolean searchVisible) {
        this.regex = regex;
        this.searchVisible = searchVisible;
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
    
    
}
