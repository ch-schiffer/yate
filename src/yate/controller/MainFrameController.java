package yate.controller;

import javax.swing.JComboBox;
import yate.listener.MainFrame.newFileListener;
import yate.model.MainFrameModel;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class MainFrameController extends Controller {

    public MainFrameController(MainFrameView view, MainFrameModel model) {
        super(view, model);
        addComboBoxModel();

        model.addCenterBox("Test1", (javax.swing.JTabbedPane) view.getComponent("jTP_tabed"));
        view.pack();
    }

    public MainFrameView getMainFrameView() {
        return (MainFrameView) getView();
    }

    public MainFrameModel getMainFrameModel() {
        return (MainFrameModel) getModel();
    }

    private void addComboBoxModel() {
        JComboBox font = ((JComboBox) getView().getComponent("jCB_font"));
        font.setModel(new javax.swing.DefaultComboBoxModel(getMainFrameModel().getFontsAsStrings()));
        font.setSelectedItem("Arial");

        JComboBox fontSize = ((JComboBox) getView().getComponent("jCB_fontSize"));
        fontSize.setModel(new javax.swing.DefaultComboBoxModel(getMainFrameModel().getFontSizes()));
        fontSize.setSelectedItem("12");
    }

    @Override
    public void addListener() {

        ((javax.swing.JButton) getMainFrameView().getComponent("jB_newFile")).addActionListener(new newFileListener(getMainFrameView(), getMainFrameModel()));
        //todo
    }

}
