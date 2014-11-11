package yate.listener.ProjectMenu;

import yate.model.ProjectMenuModel;
import yate.view.ProjectMenuView;

/**
 *
 * @author Laurin
 */
public abstract class ProjectMenuListener {

    protected final ProjectMenuView view;
    protected final ProjectMenuModel model;

    public ProjectMenuListener(ProjectMenuView view, ProjectMenuModel model) {
        this.view = view;
        this.model = model;
    }

}
