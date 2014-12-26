/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.listener.CenterBox;

import javax.swing.event.CaretEvent;
import yate.model.CenterBoxModel;
import yate.view.CenterBoxView;

/**
 * CaretListener, der Informationen über ein Caret in einem JTextPane liefert
 * @author Christian
 */
public class CaretListener extends CenterBoxListener implements javax.swing.event.CaretListener {

    /**
     * Konstruktor, erzeugt eine neue Instanz des Listeners
     * @param view View, das dem Listener zugeordnet ist
     * @param model Model, das dem Listener zugeordnet ist 
     */
    public CaretListener(CenterBoxView view, CenterBoxModel model) {
        super(view, model);
    }

    /**
     * Wird ausgelöst, wenn sich die Caret-Position ändert, um das Syntax-
     * Highlighting der Klammern anzupassen
     * @param e Informationen über die Caret-Position
     */
    @Override
    public void caretUpdate(CaretEvent e) {
        model.highlightBracers(e.getDot());
    }

    
}
