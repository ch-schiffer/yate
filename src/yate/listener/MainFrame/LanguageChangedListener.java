package yate.listener.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yate.model.MainFrameModel;
import yate.syntax.general.Language;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class LanguageChangedListener extends MainFrameListener implements ActionListener{

    private Language language;
    public LanguageChangedListener(MainFrameView view, MainFrameModel model,Language language) {
        super(view, model);
        this.language = language;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Index des ausgewählten tabs.
        int selectedIndex = view.getSelectedTabIndex();
        //Prüfen on der Index gültig ist.
        if(selectedIndex >=0 && selectedIndex<model.getCenterBoxes().size()) {
            //Die Language in dem Model der CenterBox ändern.
            model.getCenterBoxes().get(selectedIndex).getModel().setLanguage(language);
        }
    }
    
}
