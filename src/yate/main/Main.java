package yate.main;

import java.awt.Color;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import yate.controller.MainFrameController;
import yate.model.MainFrameModel;
import yate.project.File;
import yate.project.Project;
import yate.syntax.java.JavaLanguage;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class Main {

    private static MainFrameView view;
    private static MainFrameModel model;
    private static MainFrameController controller;

    public static void main(String[] args) {

        Project p = new Project();
        p.setName("Test");
        p.setPath("Test.xml");
        p.setLanguage(new JavaLanguage());
        p.addFile(new File());
        p.addFile(new File ("File"));
        HashMap <String, Color> colors = new HashMap <>();
        colors.put("keyword", Color.blue);
        colors.put("keyword2", Color.green);
        colors.put("keyword3", Color.red);
        p.setColors(colors);
        
        XMLEncoder enc = null;
        
        try {
            enc = new XMLEncoder(new FileOutputStream(p.getPath()));
            enc.writeObject(p);
            
        } catch (IOException e) {}
        finally {
            if (enc != null) {
                enc.close();
            }
        }
        
        XMLDecoder dec = null;
        
        try {
            dec = new XMLDecoder(new FileInputStream(p.getPath()));
            Project p1 = (Project) dec.readObject();
            System.out.println(p1.getPath());
            
        } catch (IOException e) {}
        finally {
            if (dec != null) {
                dec.close();
            }
        }
        
        
        try {
            // select Look and Feel
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        view = new MainFrameView();
        model = new MainFrameModel(view.getFontModel(), view.getFontSizeModel());
        controller = new MainFrameController(view, model);

        view.setVisible(true);
    }
}
