package yate.listener.ChangeColor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.model.ChangeColorModel;
import yate.view.ChangeColorDialog;

/**
 *
 * @author Laurin
 */
public class CancelButtonListener extends ChangeColorListener implements ActionListener{

    public CancelButtonListener(ChangeColorDialog view, ChangeColorModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.dispose();
    }

}
