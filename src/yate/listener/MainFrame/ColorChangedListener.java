package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.controller.ChangeColorController;
import yate.model.ChangeColorModel;
import yate.model.MainFrameModel;
import yate.view.ChangeColorDialog;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class ColorChangedListener extends MainFrameListener implements ActionListener{

    public ColorChangedListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ChangeColorDialog ccd = new ChangeColorDialog(view);
        ChangeColorModel ccm=new ChangeColorModel(); //fehlt noch die übergabe der aktuellen Farben.
        ccd.setDefaultListModel(ccm.getListModel());
        
        ChangeColorController ccc = new ChangeColorController(ccd, ccm);
        
        //Hier evt. neue HashMap abholen
    }
    
}
