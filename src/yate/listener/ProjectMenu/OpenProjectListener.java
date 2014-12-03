package yate.listener.ProjectMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.model.ProjectMenuModel;
import yate.view.ProjectMenuView;

/**
 *
 * @author Laurin
 */
public class OpenProjectListener extends ProjectMenuListener implements ActionListener{

    public OpenProjectListener(ProjectMenuView view, ProjectMenuModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
