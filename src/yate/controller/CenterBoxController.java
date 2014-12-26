package yate.controller;

import yate.listener.CenterBox.CaretListener;
import yate.listener.CenterBox.DocumentUpdateAction;
import yate.listener.CenterBox.ViewPortChangedListener;
import yate.model.CenterBoxModel;
import yate.view.CenterBoxView;

/**
 *
 * @author Laurin
 */
public class CenterBoxController {

    //Die View des Contollers.
    private final CenterBoxView view;
    //Das Model des Contollers.
    private final CenterBoxModel model;

    /**
     * Der Konstuktor bekommt seine View und sein Model übergeben. Dann hängt
     * dieser die Listener an die View an.
     *
     * @param view Die View des Contollers.
     * @param model Das Model des Contollers.
     */
    public CenterBoxController(CenterBoxView view, CenterBoxModel model) {
        this.view = view;
        this.model = model;
        addListener();
    }

    /**
     * Getter für die View.
     *
     * @return Das Model des Contollers.
     */
    public CenterBoxView getView() {
        return view;
    }

    /**
     * Getter für das Model.
     *
     * @return Das Model des Contollers.
     */
    public CenterBoxModel getModel() {
        return model;
    }

    /**
     * Erstellt die Listener und hängt diese an die View an. Wird im Konstuktor
     * aufgerufen.
     */
    private void addListener() {
        view.addDocumentUpdateAction(new DocumentUpdateAction(view, model));
        view.addAutoCompleteListener(model.getAutoCompleteManager());
        view.addViewPortChangeListener(new ViewPortChangedListener(view, model));
        view.addCaretListener(new CaretListener(view, model));
    }
}
