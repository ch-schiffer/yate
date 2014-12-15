package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.managers.FileManager;
import yate.model.MainFrameModel;
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
        FileManager.getInstance().saveAllFiles();
    }

}
