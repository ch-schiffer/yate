package yate.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import yate.controller.MainFrameController;
import yate.model.MainFrameModel;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class Main {
    
    private static MainFrameView view;
    private static MainFrameModel model;
    private static MainFrameController controller;
    
    public static MainFrameView getView() {
        return view;
    }
    
    public static MainFrameModel getModel() {
        return model;
    }
    
    public static void main(String[] args) {
        
        try {
            // select Look and Feel
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        view = new MainFrameView();
        model = new MainFrameModel(view.getFontModel(), view.getFontSizeModel(),view.getJTabedPaneModel());
        controller = new MainFrameController(view, model);
        
        view.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        view.setVisible(true);
    }
}
