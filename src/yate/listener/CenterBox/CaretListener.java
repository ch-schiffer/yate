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
 *
 * @author Christian
 */
public class CaretListener extends CenterBoxListener implements javax.swing.event.CaretListener {

    public CaretListener(CenterBoxView view, CenterBoxModel model) {
        super(view, model);
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        model.highlightBracers(e.getDot());
    }

    
}
