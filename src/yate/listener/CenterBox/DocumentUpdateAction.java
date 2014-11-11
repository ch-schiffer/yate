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

    private void action() {
        //model.updateLineNumbers();
        //view.setLines(model.getLineNumbers());
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
