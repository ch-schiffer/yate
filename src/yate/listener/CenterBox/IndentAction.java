/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.listener.CenterBox;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import yate.model.CenterBoxModel;
import yate.view.CenterBoxView;

/**
 * Aktion die ausgeführt wird, um den Code entsprechend den Coderichtlinien
 * einzurücken
 * @author Christian
 */
public class IndentAction extends AbstractAction {

    private final CenterBoxModel model;
    private final CenterBoxView view;
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     * @param model Model, das die Aktion ausführt
     * @param view View, in der das Ergebnis dargestellt wird
     */
    public IndentAction(CenterBoxModel model, CenterBoxView view) {
        this.model = model;
        this.view = view;
    }
    
    /**
     * Führt die Aktion aus
     * @param e Informationen über die Information
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int currentIndex = view.getCurrentCaretPosition();
        model.indentCode();
        view.setCaretPosition(currentIndex+1);
    }    
}
