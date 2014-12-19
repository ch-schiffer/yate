package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.controller.CenterBoxController;
import yate.managers.FileManager;
import yate.model.MainFrameModel;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class TabCloseListener extends MainFrameListener implements ActionListener{
    private CenterBoxController cbc;
    
    public TabCloseListener(MainFrameView view, MainFrameModel model, CenterBoxController cbc) {
        super(view, model);
        this.cbc=cbc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.removeTab(cbc.getView());
        model.removeCenterBoxController(cbc);
        FileManager.getInstance().closeFile(cbc.getModel().getFile());
    }
    
}
