package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

            yate.project.File newFile = FileManager.getInstance().loadFile(openFile.getSelectedFile());

            CenterBoxController cbc = model.addCenterBox(newFile);
            view.addCenterBoxViewToTab(cbc.getView(), newFile.getFileName(),new TabCloseListener(view, model,cbc));
            FileManager.getInstance().loadFile(file);

            CenterBoxController cbc = model.addCenterBox();
            view.addCenterBoxViewToTab(cbc.getView(), FileManager.getInstance().getCurrentFile().getName(),new TabCloseListener(view, model,cbc));
            cbc.getView().setText(FileManager.getInstance().getCurrentFile().getContent());
            cbc.getView().focusElement();
        }        
    }
}
