package yate.controll;

import yate.model.MainFrameModel;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class MainFrameController extends Controller{
    
    public MainFrameController(MainFrameView view, MainFrameModel model) {
       super(view,model);
    }

    public MainFrameView getMainFrameView() {
        return (MainFrameView)getView();
    }

    public MainFrameModel getMainFrameModel() {
        return (MainFrameModel)getModel();
    }

    @Override
    public void addListener() {
        //todo
    }

}
