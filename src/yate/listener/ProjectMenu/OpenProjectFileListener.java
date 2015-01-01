/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.listener.ProjectMenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JList;
import yate.managers.FileManager;
import yate.managers.ProjectManager;
import yate.model.ProjectMenuModel;
import yate.view.ProjectMenuView;

/**
 *
 * @author Carpae
 */
public class OpenProjectFileListener extends ProjectMenuListener implements MouseListener {

    public OpenProjectFileListener(ProjectMenuView view, ProjectMenuModel model) {
        super(view, model);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        JList list = (JList) e.getSource();
        if (e.getClickCount() >= 2) {
            int index = list.locationToIndex(e.getPoint());
            FileManager.getInstance().loadFile(ProjectManager.getInstance().getCurrentProject().getFiles().get(index));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

    
}
