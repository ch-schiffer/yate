package yate.listener.MainFrame;

import yate.listener.MVCListener;
import yate.model.MainFrameModel;
import yate.model.Model;
import yate.view.MainFrameView;
import yate.view.View;

/**
 *
 * @author Laurin
 */
public abstract class MainFrameListener extends MVCListener{

    protected final MainFrameView view;
    protected final MainFrameModel model;
    
    public MainFrameListener(View view, Model model) {
        super(view, model);
        this.view = (MainFrameView) view;
        this.model = (MainFrameModel) model;
    }
    
}
