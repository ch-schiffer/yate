package yate.listener.MainFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.model.Model;
import yate.view.View;

/**
 *
 * @author Laurin
 */
public class newFileListener extends MainFrameListener implements ActionListener {

    public newFileListener(View view, Model model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.addCenterBox("New File", (javax.swing.JTabbedPane) view.getComponent("jTP_tabed"));

        String font = ((javax.swing.JComboBox<String>) view.getComponent("jCB_font")).getSelectedItem().toString();
        int size = Integer.parseInt(((javax.swing.JComboBox<String>) view.getComponent("jCB_fontSize")).getSelectedItem().toString());

        View cb = model.getCenterBoxes().get(model.getCenterBoxes().size() - 1).getView();
        javax.swing.JTextPane text = (javax.swing.JTextPane) cb.getComponent("jTP_text");
        text.setFont(new Font(font, 0, size));

    }

}
