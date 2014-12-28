/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.listener.MainFrame.regex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.listener.MainFrame.MainFrameListener;
import yate.model.MainFrameModel;
import yate.view.MainFrameView;

/**
 *
 * @author Carina
 * Listener, der auf Änderungen in der regex-Checkbox reagiert und 
 * die Suche nach regulären Ausdrücken an- bzw. ausschaltet
 */
public class RegexChangedListener extends MainFrameListener implements ActionListener{

    public RegexChangedListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }

    public void actionPerformed(ActionEvent e) {
       model.setRegex(view.isRegex());
    }
    
}
