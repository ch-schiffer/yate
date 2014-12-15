package yate.listener.MainFrame.regex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.listener.MainFrame.MainFrameListener;
import yate.model.CenterBoxModel;
import yate.model.MainFrameModel;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class ReplaceListener extends MainFrameListener implements ActionListener {
    
    public ReplaceListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CenterBoxModel cbc = model.getCurrentCenterBox();
        if (cbc != null) {
            String keyword = view.getSearchText();
            String replaceWith = view.getReplaceText();
            cbc.getSearchReplaceManager().replaceAll(keyword, replaceWith);
        }
        
    }
    
}
