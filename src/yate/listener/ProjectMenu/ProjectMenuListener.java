package yate.listener.ProjectMenu;

import yate.listener.MVCListener;
import yate.model.Model;
import yate.model.ProjectMenuModel;
import yate.view.ProjectMenuView;
import yate.view.View;

/**
 *
 * @author Laurin
 */
public abstract class ProjectMenuListener extends MVCListener{

    protected final ProjectMenuView view;
    protected final ProjectMenuModel model;
    
    public ProjectMenuListener(View view, Model model) {
        super(view, model);
        this.view = (ProjectMenuView)view;
        this.model = (ProjectMenuModel)model;
    }

   
    
}
