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
 * Listener, der auf Klicken des Buttons "Nächstes" wartet beim Suchen
 */
public class FindNextListener extends MainFrameListener implements ActionListener {
    
    public FindNextListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }
    
    public void actionPerformed(ActionEvent e) {
            //Index des ausgewählten tabs.
            int selectedIndex = view.getSelectedTabIndex();
            //Prüfen on der Index gültig ist.
            if(selectedIndex >=0 && selectedIndex<model.getCenterBoxes().size()) {
                CenterBoxController cbc = model.getCenterBoxes().get(selectedIndex);
                // Dokument, in dem gesucht werden soll
                StyledDocument doc = cbc.getView().getStyledDocument();
                // das zu suchende Schlüsselwort
                String keyword = view.getSearchText();
                // Angabe, ob reguläre Ausdrücke berücksichtigt werden sollen oder nicht
                cbc.getModel().getSearchReplaceManager().setRegex(model.isRegex());
                // Aufruf der Suche-Methode zur Vorwärtssuche
                cbc.getModel().getSearchReplaceManager().search(keyword, true);
            }          
    }
}
 