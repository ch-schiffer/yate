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
public class CaretListener implements javax.swing.event.CaretListener{

    protected final CenterBoxView view;
    protected final CenterBoxModel model;

    public CaretListener(CenterBoxView view, CenterBoxModel model) {
        this.view = view;
        this.model = model;
    }
    
    @Override
    public void caretUpdate(CaretEvent e) {
        model.highlightBracers(e.getDot());
    }    
}
