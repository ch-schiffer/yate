package yate.listener.ChangeColor;

import yate.model.ChangeColorModel;
import yate.view.ChangeColorDialog;

/**
 *
 * @author Laurin
 */
public abstract class ChangeColorListener {
    protected final ChangeColorDialog view;
    protected final ChangeColorModel model;

    public ChangeColorListener(ChangeColorDialog view, ChangeColorModel model) {
        this.view = view;
        this.model = model;
    }
    
    
}
