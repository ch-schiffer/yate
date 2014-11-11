package yate.controller;

import yate.listener.ProjectMenu.AddToProjectListener;
import yate.listener.ProjectMenu.EditProjectFileListener;
import yate.listener.ProjectMenu.NewProjectListener;
import yate.listener.ProjectMenu.RemoveFromProjectListener;
import yate.model.ProjectMenuModel;
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
    }

}
