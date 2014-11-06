package yate.main;

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

        model = new MainFrameModel();
        view = new MainFrameView();
        controller = new MainFrameController(view, model);
        controller.addListener();

        view.setVisible(true);
    }
}
