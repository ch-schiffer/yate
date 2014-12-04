package yate.controller;

import yate.listener.MainFrame.FontChangedListener;
import yate.listener.MainFrame.FontSizeChangedListener;
import yate.listener.MainFrame.LanguageChangedListener;
import yate.listener.MainFrame.NewFileListener;
import yate.listener.MainFrame.OpenFileListener;
import yate.listener.MainFrame.SaveAllFilesListener;
import yate.listener.MainFrame.SaveFileListener;
import yate.listener.MainFrame.TabCloseListener;
import yate.listener.MainFrame.regex.FindNextListener;
import yate.listener.MainFrame.regex.FindPreviousListener;
import yate.listener.MainFrame.regex.ReplaceAllListener;
import yate.listener.MainFrame.regex.ReplaceListener;
import yate.model.MainFrameModel;
import yate.project.Project;
import yate.syntax.c.CLanguage;
import yate.syntax.general.Language;
import yate.syntax.java.JavaLanguage;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class MainFrameController {

    private final MainFrameView view;
    private final MainFrameModel model;

    public MainFrameController(MainFrameView view, MainFrameModel model) {
        this.view = view;
        this.model = model;
        
        Project project = new Project();
        project.setName("Test Project");
        
        model.addProjectMenu(project);
        view.addProjectMenuView(model.getProjectMenuController().getView());
        addListener();
        
        //Test
        Language java = new JavaLanguage();
        java.languageName = "java";
        view.addLanguage(java, new LanguageChangedListener(view,model,java));
        
        Language c = new CLanguage();
        c.languageName = "C";
        view.addLanguage(c, new LanguageChangedListener(view,model,c));
        //Test ende

        //17.11.14 CHS
        //Beim Start initial eine neue Datei anzeigen
        CenterBoxController cbc = model.addCenterBox();
        view.addCenterBoxViewToTab(cbc.getView(), "Neue Datei",new TabCloseListener(view, model,cbc));
        cbc.getView().focusElement();
        
        //pack() muss am ende stehen, damit es korrekt funktioniert.
        view.pack();
    }

    public MainFrameView getView() {
        return this.view;
    }

    public MainFrameModel getModel() {
        return this.model;
    }

    private void addListener() {
        view.addFontChangedListener(new FontChangedListener(view, model));
        view.addFontSizeChangedListener(new FontSizeChangedListener(view, model));
        view.addNewFileListener(new NewFileListener(view, model));
        view.addOpenFileListener(new OpenFileListener(view, model));
        view.addSaveAllFileListener(new SaveAllFilesListener(view, model));
        view.addSaveFileListener(new SaveFileListener(view, model));
        //RegexListener
        view.addFindNextListener(new FindNextListener(view, model));
        view.addFindPreviousListener(new FindPreviousListener(view, model));
        view.addReplaceAllListener(new ReplaceAllListener(view, model));
        view.addReplaceListener(new ReplaceListener(view, model));
    }

}
