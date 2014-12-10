package yate.model;
import javax.swing.text.StyledDocument;
import yate.autocomplete.AutoCompleteManager;
import yate.managers.SearchReplaceManager;
import yate.managers.SyntaxManager;
import yate.project.File;
import yate.syntax.general.*;


/**
 *
 * @author Christian
 * Model für ein CenterBoxElement
 */
public class CenterBoxModel {
    
    private final SyntaxManager syntaxManager;
    private final AutoCompleteManager autoCompleteManager;
    
    /**
     * Konstruktor
     * @param document Dokument des Text-Elements
     * @param file Datei, die dargestellt wird
     */
    public CenterBoxModel(StyledDocument document, File file) {
        autoCompleteManager = new AutoCompleteManager();
        syntaxManager = new SyntaxManager(document,file,autoCompleteManager);
    }
    
    /**
     * Analysiert die Syntax und hebt sie entsprechend den Einstellungen farbig
     * hervor
     */
    public void analyseSyntax()
    {
        autoCompleteManager.clearSuggestions();
        syntaxManager.highlightSyntax();
    }
    
    /**
     * Hebt ein ausgewähltes Klammernpaar farbig hervor
     * @param position
     */
    public void highlightBracers(int position) {
        syntaxManager.highlightBracers(position);
    }
    
    /**
     * Färbt die Syntax neu eun, ohne den Text erneut zu analysieren
     */
    public void reHighlightSyntax() {
        syntaxManager.reHighlightSyntax();
    }
    
    /**
     * Getter für die Sprache
     * @return Sprache
     */
    public Language getLanguage() {
        return syntaxManager.getLanguage();
    }
    
    /**
     * Setter für die Sprache
     * @param language Sprache
     */
    public void setLanguage(Language language) {
        syntaxManager.setLanguage(language);
        syntaxManager.highlightSyntax();
    }
    
    /**
     * Getter AutoCompleteManager
     * @return AutoCompleteManager
     */
    public AutoCompleteManager getAutoCompleteManager() {
        return autoCompleteManager;
    }
    
    
}
