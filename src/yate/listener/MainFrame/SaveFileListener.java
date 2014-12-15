package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import yate.controller.CenterBoxController;
import yate.managers.FileManager;
import yate.model.MainFrameModel;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class SaveFileListener extends MainFrameListener implements ActionListener {
    
    public SaveFileListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!FileManager.getInstance().getCurrentFile().isValid()){
            JFileChooser openFile = new JFileChooser();
            if (openFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
               FileManager.getInstance().getCurrentFile().setPath(openFile.getSelectedFile().getPath());
               FileManager.getInstance().getCurrentFile().setContent(model.getCurrentCenterBox().getText());
               view.setCurrentTabTitle(FileManager.getInstance().getCurrentFile().getName());
               FileManager.getInstance().saveCurrentFile();
            }
        }
    }
    
}
