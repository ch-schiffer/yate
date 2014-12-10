package yate.listener.MainFrame.regex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.Document;
import yate.controller.CenterBoxController;
import yate.listener.MainFrame.MainFrameListener;
import yate.managers.SearchReplaceManager;
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
        try {
            //Index des ausgewählten tabs.
            int selectedIndex = view.getSelectedTabIndex();
            //Prüfen on der Index gültig ist.
            if(selectedIndex >=0 && selectedIndex<model.getCenterBoxes().size()) {
                CenterBoxController cbc = model.getCenterBoxes().get(selectedIndex);
                String keyword = view.getSearchText();
                String replaceWith = view.getReplaceText();
                cbc.getModel().getSearchReplaceManager().replace(keyword, replaceWith);
            }
            
        }catch (Exception ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
