/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.controll;

import yate.actions.CenterBox.DocumentUpdateAction;
import yate.model.CenterBoxModel;
import yate.view.CenterBoxView;

/**
 *
 * @author Laurin
 */
public class CenterBoxController {

    private final CenterBoxView view;
    private final CenterBoxModel model;

    /**
     * @param view Die Passende View fuer das Model.
     * @param model Das Model fuer die CenterBox.
     *
     * Die Funktion addListener muss seperat aufgerufen werden.
     */
    public CenterBoxController(CenterBoxView view, CenterBoxModel model) {

        this.view = view;
        this.model = model;
    }

    public void addListener() {
        view.addDocumentUpdateListener(new DocumentUpdateAction(view, model));
    }

}
