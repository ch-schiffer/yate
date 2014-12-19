package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import yate.controller.ChangeColorController;
import yate.model.ChangeColorModel;
import yate.model.MainFrameModel;
import yate.syntax.general.Language;
import yate.view.ChangeColorDialog;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class ColorChangedListener extends MainFrameListener implements ActionListener {

    public ColorChangedListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Language currentLanguage = model.getCurrentCenterBox().getLanguage();
        HashMap<String, String> colorKeys = currentLanguage.getLanguageKeys();
        ChangeColorDialog ccd = new ChangeColorDialog(view);
        ChangeColorModel ccm = new ChangeColorModel(colorKeys); //fehlt noch die übergabe der aktuellen Farben.
        ccd.setDefaultListModel(ccm.getListModel());

        ChangeColorController ccc = new ChangeColorController(ccd, ccm);
        //Hier die neue HashMap
        HashMap<String, java.awt.Color> map;
        if (ccc.getModel().isConfirmed()) {
            map = ccc.getModel().getModifyedElements();
        }
    }

}
