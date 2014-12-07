package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.controller.CenterBoxController;
import yate.managers.FileManager;
import yate.model.MainFrameModel;
import yate.project.File;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class NewFileListener extends MainFrameListener implements ActionListener {

    public NewFileListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File newFile = FileManager.getInstance().createFile();
        CenterBoxController cbc = model.addCenterBox(new File());
        view.addCenterBoxViewToTab(cbc.getView(), newFile.getFileName(),new TabCloseListener(view, model,cbc));
    }

}
