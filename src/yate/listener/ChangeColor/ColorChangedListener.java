package yate.listener.ChangeColor;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import yate.model.ChangeColorModel;
import yate.view.ChangeColorDialog;

/**
 *
 * @author Laurin
 */
public class ColorChangedListener extends ChangeColorListener implements ChangeListener {

    public ColorChangedListener(ChangeColorDialog view, ChangeColorModel model) {
        super(view, model);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        model.setSelectedColor(view.getChosenColor());
        view.repaintList();
    }

}
