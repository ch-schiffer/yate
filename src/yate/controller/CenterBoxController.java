package yate.controller;

import yate.listener.CenterBox.DocumentUpdateAction;
import yate.model.CenterBoxModel;
import yate.view.CenterBoxView;

/**
 *
 * @author Laurin
 */
public class CenterBoxController extends Controller{

    public CenterBoxController(CenterBoxView view, CenterBoxModel model) {
        super(view,model);
    }
    
    private CenterBoxView getCenterBoxView()
    {
        return (CenterBoxView)getView();
    }
    
    private CenterBoxModel getCenterBoxModel()
    {
        return (CenterBoxModel)getModel();
    }

    public void addListener() {
        getCenterBoxView().addDocumentUpdateListener(new DocumentUpdateAction(getCenterBoxView(), getCenterBoxModel()));
    }

}
