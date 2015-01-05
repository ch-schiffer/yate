package yate.listener.CenterBox;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import yate.managers.FileManager;
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
        if (isEnabled) {
            model.analyseSyntax();
            
            if (FileManager.getInstance().getCountChanges() > 100 ) {
                try {
                    FileManager.getInstance().getCurrentFile().setContent(model.getText());
                    // Zwischenspeichern
                    FileManager.getInstance().saveAllFilesTemporary();
                    
                    // Zähler wieder auf 0 setzen
                    FileManager.getInstance().resetCountChanges();
                } catch (IOException ex) {
                    Logger.getLogger(DocumentUpdateAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        SwingUtilities.invokeLater(resetSearchReplaceManager);
        action();
        indent(e.getOffset(), e.getDocument());
        FileManager.getInstance().incrementCountChanges();
        FileManager.getInstance().getCurrentFile().setSaved(false);
    }
    
    @Override
    public void removeUpdate(DocumentEvent e) {
        action();        
        FileManager.getInstance().incrementCountChanges();
        FileManager.getInstance().getCurrentFile().setSaved(false);
    }
    
    @Override
    public void changedUpdate(DocumentEvent e) {
        action();
    }
    
    private final Runnable resetSearchReplaceManager = new Runnable() {
        @Override
        public void run() {
            model.getSearchReplaceManager().reset();
        }
    };
    
    private void indent(int offset, Document d) {
        try {
            if (offset == 0) return;
            int currentIndex = view.getCurrentCaretPosition();
            String text = d.getText(0, d.getLength());
            char insertedChar = text.charAt(offset);
            if (insertedChar == '}') {
                model.indentCode();
                view.setCaretPosition(currentIndex+1);
            }
        } catch (BadLocationException ex) {
        }
    }
}
