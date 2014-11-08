package yate.listener.MainFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.controller.CenterBoxController;
import yate.model.Model;
import yate.view.View;

/**
 *
 * @author Laurin
 */
public class FontChangedListener extends MainFrameListener implements ActionListener {

    public FontChangedListener(View view, Model model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String font = ((javax.swing.JComboBox<String>) view.getComponent("jCB_font")).getSelectedItem().toString();
        int size = Integer.parseInt(((javax.swing.JComboBox<String>) view.getComponent("jCB_fontSize")).getSelectedItem().toString());

        for (CenterBoxController cbc : model.getCenterBoxes()) {

            View cb = cbc.getView();
            javax.swing.JTextPane text = (javax.swing.JTextPane) cb.getComponent("jTP_text");
            text.setFont(new Font(font, 0, size));
        }

    }

}
