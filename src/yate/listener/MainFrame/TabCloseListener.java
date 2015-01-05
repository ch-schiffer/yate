package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import yate.controller.CenterBoxController;
import yate.managers.FileManager;
import yate.model.MainFrameModel;
import yate.project.File;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class TabCloseListener extends MainFrameListener implements ActionListener{
    private final CenterBoxController cbc;
    
    public TabCloseListener(MainFrameView view, MainFrameModel model, CenterBoxController cbc) {
        super(view, model);
        this.cbc=cbc;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        File currentFile = cbc.getModel().getFile();
        if (currentFile.isSaved() || JOptionPane.showConfirmDialog(view, "Die enthält ungespeicherte Änderungen. Trotzdem schließen?","Schließen",JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            view.removeTab(cbc.getView());
            model.removeCenterBoxController(cbc);
            FileManager.getInstance().closeFile(cbc.getModel().getFile());
        }
    }    
}
