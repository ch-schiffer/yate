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
public class NewProjectListener extends ProjectMenuListener implements ActionListener {

    public NewProjectListener(ProjectMenuView view, ProjectMenuModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String eingabe = JOptionPane.showInputDialog(null, "Projektname",
                "Neues Projekt",
                JOptionPane.PLAIN_MESSAGE);

        //Hier die Logik für das erstellen eines neuen Projekts. Achtung eingabe kann null oder leer sein !!!
    }

}
