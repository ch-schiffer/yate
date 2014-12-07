/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.listener.CenterBox;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import yate.model.CenterBoxModel;
import yate.view.CenterBoxView;

/**
 *
 * @author Christian
 */
public class ScrollListener extends CenterBoxListener implements AdjustmentListener {

    public ScrollListener(CenterBoxView view, CenterBoxModel model) {
        super(view, model);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        model.reHighlightSyntax();
    }    
}
