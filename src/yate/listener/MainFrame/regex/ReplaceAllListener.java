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
public class ReplaceAllListener extends MainFrameListener implements ActionListener {
    
    public ReplaceAllListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            CenterBoxModel cbc = model.getCurrentCenterBox();
            if (cbc != null) {
                String keyword = view.getSearchText();
                String replaceWith = view.getReplaceText();
                cbc.getSearchReplaceManager().replaceAll(keyword, replaceWith);
            }
            
        }catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
