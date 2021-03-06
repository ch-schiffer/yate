package yate.listener.ProjectMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import yate.managers.ProjectManager;
import yate.model.ProjectMenuModel;
import yate.view.ProjectMenuView;

/**
 *
 * @author Carina
 */
public class NewProjectListener extends ProjectMenuListener implements ActionListener {
    
    public NewProjectListener(ProjectMenuView view, ProjectMenuModel model) {
        super(view, model);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String eingabe = JOptionPane.showInputDialog(null, "Projektname",
                "Neues Projekt",
                JOptionPane.PLAIN_MESSAGE);
        if (eingabe != null && !eingabe.equals("")) {
            ProjectManager.getInstance().createProject();
            ProjectManager.getInstance().getCurrentProject().setName(eingabe);
            model.setProject(ProjectManager.getInstance().getCurrentProject());
            view.setProjectName(ProjectManager.getInstance().getCurrentProject().getName());
        }
    }
    
}
