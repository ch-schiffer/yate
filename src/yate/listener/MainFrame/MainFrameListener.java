package yate.listener.MainFrame;

import yate.model.MainFrameModel;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public abstract class MainFrameListener {

    protected final MainFrameView view;
    protected final MainFrameModel model;

    public MainFrameListener(MainFrameView view, MainFrameModel model) {
        this.view = view;
        this.model = model;
    }

}
