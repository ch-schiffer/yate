package yate.controller;

import yate.model.FileModel;
import yate.model.ProjectMenuModel;
import yate.view.ProjectMenuView;

/**
 *
 * @author Laurin
 */
public class ProjectMenuController extends Controller {

    public ProjectMenuController(ProjectMenuView view, ProjectMenuModel model) {
        super(view, model);
        ((javax.swing.JList<FileModel>) view.getComponent("jL_files")).setModel(model.getFiles());
    }

    @Override
    public void addListener() {
        //todo
    }

}
