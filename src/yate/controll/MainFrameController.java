/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.controll;

import yate.model.MainFrameModel;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class MainFrameController {

    private final MainFrameView view;
    private final MainFrameModel model;

    /**
     * @param view Die Passende View fuer das Model.
     * @param model Das Model fuer das MainFrame.
     *
     * Die Funktion addListener muss seperat aufgerufen werden.
     */
    public MainFrameController(MainFrameView view, MainFrameModel model) {

        this.view = view;
        this.model = model;
    }

    public MainFrameView getView() {
        return view;
    }

    public MainFrameModel getModel() {
        return model;
    }

    public void addListener() {
        //@TODO: Listener adden.

    }

}
