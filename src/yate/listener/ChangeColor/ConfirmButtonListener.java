package yate.listener.ChangeColor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.model.ChangeColorModel;
import yate.view.ChangeColorDialog;

/**
 *
 * @author Laurin
 */
public class ConfirmButtonListener extends ChangeColorListener implements ActionListener {

    public ConfirmButtonListener(ChangeColorDialog view, ChangeColorModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Hier die aktuellen Farben und identifier aus dem model abholen.
        model.setConfirmed(true);
        view.dispose();
    }

}
