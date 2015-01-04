/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.listener.MainFrame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.swing.JOptionPane;
import yate.controller.CenterBoxController;
import yate.managers.FileManager;
import yate.model.MainFrameModel;
import yate.project.File;
import yate.view.MainFrameView;

/**
 *
 * @author Carpae
 */
public class MainFrameWindowListener extends MainFrameListener implements WindowListener {
    
    public MainFrameWindowListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        // Temporäre Dateien laden, wenn vorhanden
        String tmpdir = System.getProperty("java.io.tmpdir");
        
        java.io.File tempDir = new java.io.File(tmpdir);
        FilenameFilter fileNameFilter = new FilenameFilter() {
            
            @Override
            public boolean accept(java.io.File dir, String name) {
                return name.endsWith(".yate");
            }
        };
        
        for (java.io.File file : tempDir.listFiles(fileNameFilter)) {
            File openedFile = FileManager.getInstance().createFile();
            try (BufferedReader sc = new BufferedReader(new FileReader(file))) {
                StringBuilder sb = new StringBuilder();
                
                while (sc.ready()){
                    sb.append(sc.readLine());
                    sb.append("\n");
                }
                openedFile.setContent(sb.toString());
            } catch (IOException ex) {
            }
            
            CenterBoxController cbc = model.addCenterBox(openedFile);
            view.addCenterBoxViewToTab(cbc.getView(), file.getName(),new TabCloseListener(view, model,cbc));
            cbc.getView().setText(openedFile.getContent());
            cbc.getView().focusElement();
            file.delete();
        }
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        boolean saved = true;
        for (File file : FileManager.getInstance().getAllFiles()) {
            saved = file.isSaved();
            if (!saved) break;
        }
        if (saved || JOptionPane.showConfirmDialog(null, "Einige Änderungen wurden nicht gespeichert."
                + " Trotzdem beenden?","Speichern",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            FileManager.getInstance().deleteAllTemporaryFiles();
            System.exit(0);
        }
    }
    
    @Override
    public void windowClosed(WindowEvent e) {
    }
    
    @Override
    public void windowIconified(WindowEvent e) {
    }
    
    @Override
    public void windowDeiconified(WindowEvent e) {
    }
    
    @Override
    public void windowActivated(WindowEvent e) {
    }
    
    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
