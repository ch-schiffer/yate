package yate.listener.MainFrame;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import yate.managers.FileManager;
import yate.model.MainFrameModel;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class TabChangedListener extends MainFrameListener implements ChangeListener{

    public TabChangedListener(MainFrameView view, MainFrameModel model) {
        super(view, model);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //Das event wird beim wechseln der Tabs aufgerufen, 
        //aber auch beim hinzufügen eines neuen Tabs.
        //Dies liegt am request Focus in MainFrame addCenterBox()
        //Somit wir beim starten das event aufgerufen, 
        //da immer eine leere Datei geöffnet wird.
        
        //FileManager.getInstance().setCurrentFile(model.getCurrentCenterBox().);
    }
    
}
