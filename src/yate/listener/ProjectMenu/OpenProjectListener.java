package yate.listener.ProjectMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import yate.managers.ProjectManager;
import yate.model.ProjectMenuModel;
import yate.project.File;
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
       JFileChooser openFile = new JFileChooser();
        if (openFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
           try {
               ProjectManager.getInstance().loadProject(new FileInputStream(openFile.getSelectedFile()));
               for (File f: ProjectManager.getInstance().getCurrentProject().getFiles()){
                   model.addFile(f);
               }
           } catch (FileNotFoundException ex) {
               Logger.getLogger(OpenProjectListener.class.getName()).log(Level.SEVERE, null, ex);
           }
        }  
    }
    
}
