package yate.controll;

import yate.view.View;
import yate.model.Model;

/**
 *
 * @author Laurin
 */
public abstract class Controller {
    private final View view;
    private final Model model;
    
     public abstract void addListener();
    
    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;
        addListener();
    }

    public View getView() {
        return view;
    }

    public Model getModel() {
        return model;
    }
}
