package yate.listener.ProjectMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.managers.ProjectManager;
import yate.model.ProjectMenuModel;
import yate.view.ProjectMenuView;

/**
 *
 * @author Laurin
 */
public class SaveProjectListener extends ProjectMenuListener implements ActionListener{

    public SaveProjectListener(ProjectMenuView view, ProjectMenuModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProjectManager.getInstance().saveProject();
    }
    
}
