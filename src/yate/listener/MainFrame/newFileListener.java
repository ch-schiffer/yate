/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.model.Model;
import yate.view.View;

/**
 *
 * @author Laurin
 */
public class newFileListener extends MainFrameListener implements ActionListener {

    public newFileListener(View view, Model model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.addCenterBox("New File", (javax.swing.JTabbedPane) view.getComponent("jTP_tabed"));
    }

}
