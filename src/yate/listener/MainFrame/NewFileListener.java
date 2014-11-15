package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.controller.CenterBoxController;
import yate.model.MainFrameModel;
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
        CenterBoxController cbc = model.addCenterBox();
        view.addCenterBoxViewToTab(cbc.getView(), "Neue Datei");
        //Datei zu FileManager hinzufügen
    }

}
