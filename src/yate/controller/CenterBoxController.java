package yate.controller;

import yate.listener.CenterBox.DocumentUpdateAction;
import yate.listener.CenterBox.ViewPortChangedListener;
import yate.model.CenterBoxModel;
import yate.view.CenterBoxView;

/**
 *
 * @author Laurin
 */
public class CenterBoxController {
    
    private final CenterBoxView view;
    private final CenterBoxModel model;
    
    public CenterBoxController(CenterBoxView view, CenterBoxModel model) {
        this.view = view;
        this.model = model;
        addListener();
    }
    
    public CenterBoxView getView() {
        return view;
    }
    
    public CenterBoxModel getModel() {
        return model;
    }
    
    private void addListener() {
        view.addDocumentUpdateAction(new DocumentUpdateAction(view, model));
        view.addAutoCompleteListener(model.getAutoCompleteManager());
        view.addViewPortChangeListener(new ViewPortChangedListener(view, model));
    }
    
}
