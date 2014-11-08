package yate.controller;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import yate.listener.MainFrame.FontChangedListener;
import yate.listener.MainFrame.FontSizeChangedListener;
import yate.listener.MainFrame.OpenNewFileListener;
import yate.listener.MainFrame.SaveAllfilesListener;
import yate.listener.MainFrame.SaveFileListener;
import yate.listener.MainFrame.newFileListener;
import yate.listener.MainFrame.regex.FindNextListener;
import yate.listener.MainFrame.regex.FindPreviousListener;
import yate.listener.MainFrame.regex.ReplaceAllListener;
import yate.listener.MainFrame.regex.ReplaceListener;
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

        model.addProjectMenu("Test Project", null, (JPanel) view.getComponent("jP_Pmv"));
        //model.addCenterBox("Test1", (javax.swing.JTabbedPane) view.getComponent("jTP_tabed"));
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
        ((javax.swing.JButton) getMainFrameView().getComponent("jB_open")).addActionListener(new OpenNewFileListener(getMainFrameView(), getMainFrameModel()));
        ((javax.swing.JButton) getMainFrameView().getComponent("jB_save")).addActionListener(new SaveFileListener(getMainFrameView(), getMainFrameModel()));
        ((javax.swing.JButton) getMainFrameView().getComponent("jB_saveAll")).addActionListener(new SaveAllfilesListener(getMainFrameView(), getMainFrameModel()));

        ((javax.swing.JMenuItem) getMainFrameView().getComponent("jMI_new")).addActionListener(new newFileListener(getMainFrameView(), getMainFrameModel()));
        ((javax.swing.JMenuItem) getMainFrameView().getComponent("jMI_open")).addActionListener(new OpenNewFileListener(getMainFrameView(), getMainFrameModel()));
        ((javax.swing.JMenuItem) getMainFrameView().getComponent("jMI_save")).addActionListener(new SaveFileListener(getMainFrameView(), getMainFrameModel()));
        ((javax.swing.JMenuItem) getMainFrameView().getComponent("jMI_saveAll")).addActionListener(new SaveAllfilesListener(getMainFrameView(), getMainFrameModel()));

        //((javax.swing.JMenuItem) getMainFrameView().getComponent("jMI_save")).addActionListener(new SaveFileListener(getMainFrameView(), getMainFrameModel()));
        //((javax.swing.JMenuItem) getMainFrameView().getComponent("jMI_saveAll")).addActionListener(new SaveAllFilesListener(getMainFrameView(), getMainFrameModel()));
        ((javax.swing.JComboBox<String>) getMainFrameView().getComponent("jCB_font")).addActionListener(new FontChangedListener(getMainFrameView(), getMainFrameModel()));
        ((javax.swing.JComboBox<String>) getMainFrameView().getComponent("jCB_fontSize")).addActionListener(new FontSizeChangedListener(getMainFrameView(), getMainFrameModel()));

        ((javax.swing.JButton) getMainFrameView().getComponent("jB_next")).addActionListener(new FindNextListener(getMainFrameView(), getMainFrameModel()));
        ((javax.swing.JButton) getMainFrameView().getComponent("jB_previous")).addActionListener(new FindPreviousListener(getMainFrameView(), getMainFrameModel()));
        ((javax.swing.JButton) getMainFrameView().getComponent("jB_replace")).addActionListener(new ReplaceListener(getMainFrameView(), getMainFrameModel()));
        ((javax.swing.JButton) getMainFrameView().getComponent("jB_replaceAll")).addActionListener(new ReplaceAllListener(getMainFrameView(), getMainFrameModel()));

    }

}
