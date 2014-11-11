package yate.listener.CenterBox;

import yate.model.CenterBoxModel;
import yate.view.CenterBoxView;

/**
 *
 * @author Laurin
 */
public abstract class CenterBoxListener {

    protected final CenterBoxView view;
    protected final CenterBoxModel model;

    public CenterBoxListener(CenterBoxView view, CenterBoxModel model) {
        this.view = view;
        this.model = model;
    }

}
