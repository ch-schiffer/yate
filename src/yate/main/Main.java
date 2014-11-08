package yate.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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

    public static void main(String[] args) {

        try {
            // select Look and Feel
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        model = new MainFrameModel();
        view = new MainFrameView();
        controller = new MainFrameController(view, model);
        controller.addListener();

        view.setVisible(true);
    }
}
