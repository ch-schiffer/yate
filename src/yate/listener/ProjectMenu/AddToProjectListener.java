package yate.listener.ProjectMenu;

import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import yate.managers.FileManager;
import yate.managers.ProjectManager;
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
        
        if (!FileManager.getInstance().getCurrentFile().isValid()){
            JOptionPane.showMessageDialog(null, "Bitte Datei vor dem Hinzufügen abspeichern.", "Speichern", JOptionPane.INFORMATION_MESSAGE);
        } else {   
            model.addFile(FileManager.getInstance().getCurrentFile());
            ProjectManager.getInstance().getCurrentProject().addFile(FileManager.getInstance().getCurrentFile());
        }
    }
    
}
