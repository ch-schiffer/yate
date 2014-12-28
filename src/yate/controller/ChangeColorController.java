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

    //Die View des Contollers.
    private final ChangeColorDialog view;
    //Das Model des Contollers.
    private final ChangeColorModel model;

    /**
     * Der Konstuktor bekommt seine View und sein Model übergeben. Dann hängt
     * dieser die Listener an die View an.
     *
     * @param view Die View des Contollers.
     * @param model Das Model des Contollers.
     */
    public ChangeColorController(ChangeColorDialog view, ChangeColorModel model) {
        this.view = view;
        this.model = model;

        model.setSelectedIndex(view.getSelectedIndex());
        view.setChoserColor(model.getSelectedColor());

        addListener();

        view.setVisible(true);

    }

    /**
     * Erstellt die Listener und hängt diese an die View an. Wird im Konstuktor
     * aufgerufen.
     */
    private void addListener() {
        view.addCancelButtonListener(new CancelButtonListener(view, model));
        view.addConfirmButtonListener(new ConfirmButtonListener(view, model));
        view.addSelectedItemChangedListener(new SelectedItemChangedListener(view, model));
        view.addColorChangedListener(new ColorChangedListener(view, model));
    }

    /**
     * Getter für die View.
     *
     * @return Das Model des Contollers.
     */
    public ChangeColorDialog getView() {
        return view;
    }

    /**
     * Getter für das Model.
     *
     * @return Das Model des Contollers.
     */
    public ChangeColorModel getModel() {
        return model;
    }

}
