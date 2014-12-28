package yate.listener.MainFrame.regex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.listener.MainFrame.MainFrameListener;
import yate.model.CenterBoxModel;
import yate.model.MainFrameModel;
import yate.view.MainFrameView;

/**
 *
 * @author Carina
 * Listener, der auf Drücken des Buttons "Alle ersetzen" reagiert
 * und dann die replaceAll-Methode aufruft
 */
public class ReplaceAllListener extends MainFrameListener implements ActionListener {
    
    public ReplaceAllListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        CenterBoxModel cbc = model.getCurrentCenterBox();
        if (cbc != null) {
            // Schlüüselwort, das ersetzt werden soll
            String keyword = view.getSearchText();
            // Schlüssel, mit dem ersetzt werden soll
            String replaceWith = view.getReplaceText();
            // Angabe, ob reguläre Ausdrücke berücksichtigt werden sollen oder nicht
            cbc.getSearchReplaceManager().setRegex(model.isRegex());
            // Aufruf der replaceAll-Methode im SearchReplaceManager
            cbc.getSearchReplaceManager().replaceAll(keyword, replaceWith);
        }       
    }
    
}
