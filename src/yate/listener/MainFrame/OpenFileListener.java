package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import yate.controller.CenterBoxController;
import yate.managers.FileManager;
import yate.model.MainFrameModel;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class OpenFileListener extends MainFrameListener implements ActionListener {

    public OpenFileListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser openFile = new JFileChooser();
        if (openFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            File file = openFile.getSelectedFile();

            FileManager.getInstance().loadFile(file);

            CenterBoxController cbc = model.addCenterBox();
            view.addCenterBoxViewToTab(cbc.getView(), FileManager.getInstance().getCurrentFile().getPath());
            cbc.getView().setText(FileManager.getInstance().getCurrentFile().getContent());
            cbc.getView().focusElement();
        }        
    }
}
