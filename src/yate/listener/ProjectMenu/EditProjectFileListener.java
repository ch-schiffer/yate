/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.listener.ProjectMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import yate.model.ProjectMenuModel;
import yate.view.ProjectMenuView;

/**
 *
 * @author Laurin
 */
public class EditProjectFileListener extends ProjectMenuListener implements ActionListener {

    public EditProjectFileListener(ProjectMenuView view, ProjectMenuModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String eingabe = JOptionPane.showInputDialog(null, "Neuer Projektname",
                "Projekt bearbeiten",
                JOptionPane.PLAIN_MESSAGE);

        //Hiew die Logik für das bearbeiten des Projektnamens. Achtung eingabe kann null oder leer sein !!!
    }

}
