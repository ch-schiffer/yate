package yate.listener.MainFrame;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import yate.model.CenterBoxModel;
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
        
        //Sorgt dafür, dass beim Wechseln des Tabs die Sprache entsprechend gesetzt wird
        CenterBoxModel currentCenterBoxModel = model.getCurrentCenterBox();
        if (currentCenterBoxModel != null) {
            view.setSelectedLanguage(currentCenterBoxModel.getLanguage().getLanguageName());
            currentCenterBoxModel.reHighlightSyntax();
        }
    }
    
}
