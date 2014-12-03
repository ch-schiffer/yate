package yate.listener.ProjectMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.model.ProjectMenuModel;
import yate.project.File;
import yate.view.ProjectMenuView;

/**
 *
 * @author Laurin
 */
public class RemoveFromProjectListener extends ProjectMenuListener implements ActionListener {

    public RemoveFromProjectListener(ProjectMenuView view, ProjectMenuModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       //Abfrage ob entfernt werden soll, sollte noch hinzugefügt werden.
        
        File selected =  view.getSelectedItem();
       
       if(selected != null)
       {
           model.removeFile(selected);
       }
    }

}
