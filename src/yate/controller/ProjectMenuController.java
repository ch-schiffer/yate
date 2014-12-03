package yate.controller;

import yate.listener.ProjectMenu.AddToProjectListener;
import yate.listener.ProjectMenu.EditProjectFileListener;
import yate.listener.ProjectMenu.NewProjectListener;
import yate.listener.ProjectMenu.OpenProjectListener;
import yate.listener.ProjectMenu.RemoveFromProjectListener;
import yate.listener.ProjectMenu.SaveProjectListener;
import yate.model.ProjectMenuModel;
import yate.project.File;
import yate.view.ProjectMenuView;

/**
 *
 * @author Laurin
 */
public class ProjectMenuController {

    private final ProjectMenuView view;
    private final ProjectMenuModel model;

    public ProjectMenuController(ProjectMenuView view, ProjectMenuModel model) {
        this.model = model;
        this.view = view;
        
        view.setListModel(model.getDlm());
        
        //Test
        model.addFile(new File("C:/testdi/test.pdf"));
        model.addFile(new File("C:/testdi/test.html"));
        model.addFile(new File("C:/testdi/test.txt"));
        //Test Ende
        addListener();
    }

    public ProjectMenuView getView() {
        return view;
    }

    public ProjectMenuModel getModel() {
        return model;
    }

    private void addListener() {
        view.addAddToProjectListener(new AddToProjectListener(view, model));
        view.addEditProjectFileListener(new EditProjectFileListener(view, model));
        view.addNewProjectListener(new NewProjectListener(view, model));
        view.addRemoveFromProjectListener(new RemoveFromProjectListener(view, model));
        view.addOpenProjectListener(new OpenProjectListener(view, model));
        view.addSaveProjectListener(new SaveProjectListener(view, model));
    }

}
