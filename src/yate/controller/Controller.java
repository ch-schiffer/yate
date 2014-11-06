package yate.controller;

import yate.model.Model;
import yate.view.View;

/**
 *
 * @author Laurin
 */
public abstract class Controller {

    private final View view;
    private final Model model;

    public abstract void addListener();

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public Model getModel() {
        return model;
    }
}
