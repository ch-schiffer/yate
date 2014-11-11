package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.controller.CenterBoxController;
import yate.model.MainFrameModel;
import yate.view.CenterBoxView;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class FontSizeChangedListener extends MainFrameListener implements ActionListener {

    public FontSizeChangedListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String font = model.getSelectedFont();
        int size = model.getSelectedFontSize();

        for (CenterBoxController cbc : model.getCenterBoxes()) {

            CenterBoxView cb = cbc.getView();
            cb.setFont(font, size);
        }
    }

}
