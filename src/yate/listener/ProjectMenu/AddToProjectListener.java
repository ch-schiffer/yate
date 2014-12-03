package yate.listener.ProjectMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import yate.managers.FileManager;
import yate.model.ProjectMenuModel;
import yate.view.ProjectMenuView;

/**
 *
 * @author Laurin
 */
public class AddToProjectListener extends ProjectMenuListener implements ActionListener {

    public AddToProjectListener(ProjectMenuView view, ProjectMenuModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser openFile = new JFileChooser();
        if (openFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            File file = openFile.getSelectedFile();

            FileManager.getInstance().loadFile(file);

            model.addFile(new yate.project.File(FileManager.getInstance().getCurrentFile().getPath()));
        }   
    }

}
