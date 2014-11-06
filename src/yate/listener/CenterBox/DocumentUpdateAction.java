package yate.listener.CenterBox;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import yate.model.Model;
import yate.view.View;

/**
 *
 * @author Laurin
 */
public class DocumentUpdateAction extends CenterBoxListener implements DocumentListener {

    public DocumentUpdateAction(View view, Model model) {
        super(view, model);
    }
    
    private void action() {
        model.updateLineNumbers();
        view.setLines(model.getLineNumbers());
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
