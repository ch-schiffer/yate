package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.model.CenterBoxModel;
import yate.model.MainFrameModel;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class TestButtonListener extends MainFrameListener implements ActionListener {

    public TestButtonListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CenterBoxModel cbm = model.getCurrentCenterBox();
        if (cbm != null) {
            cbm.indentCode();
        }
    }

}
