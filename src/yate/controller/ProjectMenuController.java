package yate.controller;

import yate.listener.ProjectMenu.AddToProjectListener;
import yate.listener.ProjectMenu.EditProjectFileListener;
import yate.listener.ProjectMenu.NewProjectListener;
import yate.listener.ProjectMenu.OpenProjectListener;
import yate.listener.ProjectMenu.RemoveFromProjectListener;
import yate.listener.ProjectMenu.SaveProjectListener;
import yate.model.ProjectMenuModel;
import yate.view.ProjectMenuView;

/**
 *
 * @author Laurin
 */
public class ProjectMenuController {

    //Die View des Contollers.
    private final ProjectMenuView view;
    //Das Model des Contollers.
    private final ProjectMenuModel model;

    /**
     * Der Konstuktor bekommt seine View und sein Model übergeben. Dann hängt
     * dieser die Listener an die View an. Zudem wird in die View die
     * Projektliste geladen.
     *
     * @param view Die View des Contollers.
     * @param model Das Model des Contollers.
     */
    public ProjectMenuController(ProjectMenuView view, ProjectMenuModel model) {
        this.model = model;
        this.view = view;

        view.setListModel(model.getDlm());

        addListener();
    }

    /**
     * Getter für die View.
     *
     * @return Das Model des Contollers.
     */
    public ProjectMenuView getView() {
        return view;
    }

    /**
     * Getter für das Model.
     *
     * @return Das Model des Contollers.
     */
    public ProjectMenuModel getModel() {
        return model;
    }

    /**
     * Erstellt die Listener und hängt diese an die View an. Wird im Konstuktor
     * aufgerufen.
     */
    private void addListener() {
        view.addAddToProjectListener(new AddToProjectListener(view, model));
        view.addEditProjectFileListener(new EditProjectFileListener(view, model));
        view.addNewProjectListener(new NewProjectListener(view, model));
        view.addRemoveFromProjectListener(new RemoveFromProjectListener(view, model));
        view.addOpenProjectListener(new OpenProjectListener(view, model));
        view.addSaveProjectListener(new SaveProjectListener(view, model));
    }

}
