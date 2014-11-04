/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.actions.CenterBox;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import yate.model.CenterBoxModel;
import yate.view.CenterBoxView;

/**
 *
 * @author Laurin
 */
public class DocumentUpdateAction implements DocumentListener {

    private final CenterBoxView view;
    private final CenterBoxModel model;

    public DocumentUpdateAction(CenterBoxView view, CenterBoxModel model) {
        this.view = view;
        this.model = model;
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
