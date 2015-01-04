package yate.controller;

import yate.listener.MainFrame.ColorChangedListener;
import yate.listener.MainFrame.FontChangedListener;
import yate.listener.MainFrame.FontSizeChangedListener;
import yate.listener.MainFrame.LanguageChangedListener;
import yate.listener.MainFrame.MainFrameWindowListener;
import yate.listener.MainFrame.NewFileListener;
import yate.listener.MainFrame.OpenFileListener;
import yate.listener.MainFrame.SaveAllFilesListener;
import yate.listener.MainFrame.SaveFileListener;
import yate.listener.MainFrame.TabChangedListener;
import yate.listener.MainFrame.TabCloseListener;
import yate.listener.MainFrame.TestButtonListener;
import yate.listener.MainFrame.regex.FindNextListener;
import yate.listener.MainFrame.regex.FindPreviousListener;
import yate.listener.MainFrame.regex.RegexChangedListener;
import yate.listener.MainFrame.regex.ReplaceAllListener;
import yate.listener.MainFrame.regex.ReplaceListener;
import yate.managers.FileManager;
import yate.managers.LanguageManager;
import yate.model.MainFrameModel;
import yate.project.File;
import yate.project.Project;
import yate.syntax.general.Language;
import yate.view.MainFrameView;

/**
 *
 * @author Laurin
 */
public class MainFrameController {

    //Die View des Contollers.
    private final MainFrameView view;
    //Das Model des Contollers.
    private final MainFrameModel model;

    /**
     * Der Konstuktor bekommt seine View und sein Model übergeben. Dann hängt
     * dieser die Listener an die View an. Zudem werden die Komponenten für das
     * Projekt Menu erstellt und geladen. Dann werden die Sprachen geladen und
     * eine neue Leere Datei geöffnet.
     *
     * @param view Die View des Contollers.
     * @param model Das Model des Contollers.
     */
    public MainFrameController(MainFrameView view, MainFrameModel model) {
        this.view = view;
        this.model = model;

        Project project = new Project();
        project.setName("Test Project");

        model.addProjectMenu(project);
        view.addProjectMenuView(model.getProjectMenuController().getView());
        addListener();

        //06.12.14 CHS
        //Finale Version der Sprachen-Liste
        for (Language language : LanguageManager.getLanguageList()) {
            view.addLanguage(language, new LanguageChangedListener(view, model, language));
        }

        //17.11.14 CHS
        //Beim Start initial eine neue Datei anzeigen
        File newFile = FileManager.getInstance().createFile();
        CenterBoxController cbc = model.addCenterBox(newFile);
        view.addCenterBoxViewToTab(cbc.getView(), newFile.toString(), new TabCloseListener(view, model, cbc));
        cbc.getView().focusElement();

        //pack() muss am ende stehen, damit es korrekt funktioniert.
        view.pack();
    }

    /**
     * Getter für die View.
     *
     * @return Das Model des Contollers.
     */
    public MainFrameView getView() {
        return this.view;
    }

    /**
     * Getter für das Model.
     *
     * @return Das Model des Contollers.
     */
    public MainFrameModel getModel() {
        return this.model;
    }

    /**
     * Erstellt die Listener und hängt diese an die View an. Wird im Konstuktor
     * aufgerufen.
     */
    private void addListener() {
        view.addFontChangedListener(new FontChangedListener(view, model));
        view.addFontSizeChangedListener(new FontSizeChangedListener(view, model));
        view.addNewFileListener(new NewFileListener(view, model));
        view.addOpenFileListener(new OpenFileListener(view, model));
        view.addSaveAllFileListener(new SaveAllFilesListener(view, model));
        view.addSaveFileListener(new SaveFileListener(view, model));
        view.addTestButtonListener(new TestButtonListener(view, model));
        view.addTabChangedListener(new TabChangedListener(view, model));
        view.addColorChangedListener(new ColorChangedListener(view, model));
        view.addWindowListener(new MainFrameWindowListener(view, model));
        //RegexListener
        view.addFindNextListener(new FindNextListener(view, model));
        view.addFindPreviousListener(new FindPreviousListener(view, model));
        view.addReplaceAllListener(new ReplaceAllListener(view, model));
        view.addReplaceListener(new ReplaceListener(view, model));
        view.addRegexChangedListener(new RegexChangedListener(view, model));
    }

}
