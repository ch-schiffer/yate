package yate.listener.MainFrame.regex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.StyledDocument;
import yate.controller.CenterBoxController;
import yate.listener.MainFrame.MainFrameListener;
import yate.model.MainFrameModel;
import yate.view.MainFrameView;

/**
 *
 * @author Carina
 */
public class FindNextListener extends MainFrameListener implements ActionListener {
    
    public FindNextListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            //Index des ausgewählten tabs.
            int selectedIndex = view.getSelectedTabIndex();
            //Prüfen on der Index gültig ist.
            if(selectedIndex >=0 && selectedIndex<model.getCenterBoxes().size()) {
                CenterBoxController cbc = model.getCenterBoxes().get(selectedIndex);
                StyledDocument doc = cbc.getView().getStyledDocument();
                String keyword = view.getSearchText();
                cbc.getModel().getSearchReplaceManager().setRegex(model.isRegex());
                cbc.getModel().getSearchReplaceManager().search(keyword, true);
            }          
    }
}
 