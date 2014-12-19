package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import yate.managers.FileManager;
import yate.model.MainFrameModel;
import yate.project.File;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class SaveAllFilesListener extends MainFrameListener implements ActionListener {
    
    public SaveAllFilesListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (File file: FileManager.getInstance().getAllFiles()) {
            if (!file.isValid()){
                JFileChooser openFile = new JFileChooser();
                if (openFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    file.setPath(openFile.getSelectedFile().getPath());
                    file.setContent(model.getCurrentCenterBox().getText());
                    view.setCurrentTabTitle(file.getName());
                    
               //     FileManager.getInstance().setCurrentFile(file);
              //      FileManager.getInstance().saveCurrentFile();
                }
            }  
        }
        FileManager.getInstance().saveAllFiles();
    }
    
}
