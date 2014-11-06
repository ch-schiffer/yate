package yate.listener.CenterBox;

import yate.listener.MVCListener;
import yate.model.CenterBoxModel;
import yate.model.Model;
import yate.view.CenterBoxView;
import yate.view.View;

/**
 *
 * @author Laurin
 */
public abstract class CenterBoxListener extends MVCListener {

    protected final CenterBoxView view;
    protected final CenterBoxModel model;

    public CenterBoxListener(View view, Model model) {
        super(view, model);
        this.view = (CenterBoxView)view;
        this.model = (CenterBoxModel)model;
    }
    
     
    
   
    
   
}
