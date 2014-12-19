package yate.controller;

import yate.listener.ChangeColor.CancelButtonListener;
import yate.listener.ChangeColor.ColorChangedListener;
import yate.listener.ChangeColor.ConfirmButtonListener;
import yate.listener.ChangeColor.SelectedItemChangedListener;
import yate.model.ChangeColorModel;
import yate.view.ChangeColorDialog;

/**
 *
 * @author Laurin
 */
public class ChangeColorController {

    private final ChangeColorDialog view;
    private final ChangeColorModel model;

    public ChangeColorController(ChangeColorDialog view, ChangeColorModel model) {
        this.view = view;
        this.model = model;

        model.setSelectedIndex(view.getSelectedIndex());
        view.setChoserColor(model.getSelectedColor());

        addListener();

        view.setVisible(true);

    }

    private void addListener() {
        view.addCancelButtonListener(new CancelButtonListener(view, model));
        view.addConfirmButtonListener(new ConfirmButtonListener(view, model));
        view.addSelectedItemChangedListener(new SelectedItemChangedListener(view, model));
        view.addColorChangedListener(new ColorChangedListener(view, model));
    }

    public ChangeColorDialog getView() {
        return view;
    }

    public ChangeColorModel getModel() {
        return model;
    }

}
