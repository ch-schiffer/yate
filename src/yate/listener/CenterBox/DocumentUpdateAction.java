package yate.listener.CenterBox;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import yate.model.CenterBoxModel;
import yate.view.CenterBoxView;

/**
 *
 * @author Laurin
 */
public class DocumentUpdateAction extends CenterBoxListener implements DocumentListener {

    public DocumentUpdateAction(CenterBoxView view, CenterBoxModel model) {
        super(view, model);
    }
    
    /**
     * Kennzeichnet, ob der Listener aktiv ist. Dies ist notwendig, um Endlossschleifen
     * durch das Triggern von Events innerhalb eines Events zu vermeiden, insbesondere
     * wenn diese durch externe Threads invoked werden.
     */
    public static boolean isEnabled = true;
    
    
    private void action() {
        if (isEnabled)
        {
            model.analyseSyntax();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        action();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        action();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        action();
    }

}
