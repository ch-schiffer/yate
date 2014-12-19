package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import yate.managers.FileManager;
import yate.model.MainFrameModel;
import yate.project.File;
import yate.view.CloseTab;
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
        ArrayList <CloseTab> tabs = view.getTabs();
        for (int i = 0; i < FileManager.getInstance().getAllFiles().size(); i++) {
            File file = FileManager.getInstance().getAllFiles().get(i);
            if (!file.isValid()){
                JFileChooser openFile = new JFileChooser();
                if (openFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    file.setPath(openFile.getSelectedFile().getPath());
                    file.setContent(model.getCenterBoxes().get(i).getModel().getText());
                   // view.setCurrentTabTitle(file.getName());
                    tabs.get(i).setTitle(file.getName());
                    System.out.println(file.getName());
                }
            }  
        }
        FileManager.getInstance().saveAllFiles();
    }
    
}
