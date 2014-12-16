package yate.listener.ChangeColor;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import yate.model.ChangeColorModel;
import yate.view.ChangeColorDialog;

/**
 *
 * @author Laurin
 */
public class SelectedItemChangedListener extends ChangeColorListener implements ListSelectionListener{

    public SelectedItemChangedListener(ChangeColorDialog view, ChangeColorModel model) {
        super(view, model);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
       model.setSelectedIndex(view.getSelectedIndex());
       view.setChoserColor(model.getSelectedColor());
    }

}
