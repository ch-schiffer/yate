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
 * Listener, der auf Drücken des Buttons "Ersetzen" reagiert
 * und dann die replace-Methode aufruft und das angegebene Schlüsselwort einmalig ersetzt
 */
public class ReplaceListener extends MainFrameListener implements ActionListener {
    
    public ReplaceListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }
    
    public void actionPerformed(ActionEvent e) {
        CenterBoxModel cbc = model.getCurrentCenterBox();
        if (cbc != null) {
            // Schlüsselwort, das ersetzt werden soll
            String keyword = view.getSearchText();
            // Schlüssel, mit dem ersetzt werden soll
            String replaceWith = view.getReplaceText();
            // einmalige Ersetzung des Schlüsselworts durch Aufruf der replace-Methode
            cbc.getSearchReplaceManager().replace(keyword, replaceWith);
        }
        
    }
    
}
