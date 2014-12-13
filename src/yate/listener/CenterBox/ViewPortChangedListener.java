/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.listener.CenterBox;

import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import yate.model.CenterBoxModel;
import yate.view.CenterBoxView;

/**
 *
 * @author Christian
 */
public class ViewPortChangedListener extends CenterBoxListener implements ChangeListener{
    
    public ViewPortChangedListener(CenterBoxView view, CenterBoxModel model) {
        super(view, model);
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        JTextPane textPane = view.getTextPane();
        if (textPane.getText().length() > 0) {
            JViewport viewport = (JViewport) e.getSource();
            Rectangle viewRect = viewport.getViewRect();
            
            Point p = viewRect.getLocation();
            int startIndex = textPane.viewToModel(p);
            
            p.x += viewRect.width;
            p.y += viewRect.height;
            int endIndex = textPane.viewToModel(p);
            
            if (endIndex - startIndex >= 0) {
                model.setVisibleIndexStart(startIndex);
                model.setVisibleIndexEnd(endIndex);
                model.reHighlightSyntax();
            }
        }
    }    
}
