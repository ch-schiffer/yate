/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.listener.ProjectMenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JList;
import yate.controller.CenterBoxController;
import yate.listener.MainFrame.TabCloseListener;
import yate.main.Main;
import yate.managers.FileManager;
import yate.managers.ProjectManager;
import yate.model.MainFrameModel;
import yate.model.ProjectMenuModel;
import yate.project.File;
import yate.syntax.asm.AsmLanguage;
import yate.syntax.c.CLanguage;
import yate.syntax.cpp.CppLanguage;
import yate.syntax.csharp.CSharpLanguage;
import yate.syntax.java.JavaLanguage;
import yate.syntax.python.PythonLanguage;
import yate.view.MainFrameView;
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
            File selectedFile = ProjectManager.getInstance().getCurrentProject().getFiles().get(index);
            FileManager.getInstance().loadFile(new java.io.File(selectedFile.getPath()));
            MainFrameView mainFrameView = Main.getView();
            MainFrameModel mainFrameModel = Main.getModel();
            CenterBoxController cbc = mainFrameModel.addCenterBox(selectedFile);
            mainFrameView.addCenterBoxViewToTab(cbc.getView(), selectedFile.getName(),new TabCloseListener(mainFrameView, mainFrameModel,cbc));            
            cbc.getView().setText(selectedFile.getContent());
            cbc.getView().focusElement();
            selectedFile.setSaved(true);
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
