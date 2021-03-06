package yate.model;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import yate.autocomplete.AutoCompleteManager;
import yate.listener.CenterBox.DocumentUpdateAction;
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
    private final SearchReplaceManager searchReplaceManager;
    private final StyledDocument document;
    private final File file;
    
    /**
     * Konstruktor
     * @param document Dokument des Text-Elements
     * @param file Datei, die dargestellt wird
     * @param textPane Gibt das verknüpfte TextPane an, um auf Caret-Infos zuzugreifen
     */
    public CenterBoxModel(StyledDocument document, File file, JTextPane textPane) {
        autoCompleteManager = new AutoCompleteManager();
        syntaxManager = new SyntaxManager(document,file,autoCompleteManager);
        searchReplaceManager = new SearchReplaceManager(textPane, document);
        this.document = document;
        this.file = file;
    }
   
    /**
     * Analysiert die Syntax und hebt sie entsprechend den Einstellungen farbig
     * hervor
     */
    public void analyseSyntax() {
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
    
    public void indentCode() {
        try {
            DocumentUpdateAction.isEnabled = false;
            syntaxManager.indentCode();
        }
        finally {
            DocumentUpdateAction.isEnabled = true;
        }
    }
    
    /**
     * Getter für die Sprache
     * @return Sprache
     */
    public Language getLanguage() {
        return syntaxManager.getLanguage();
    }

    /**
     * Ruft das File ab, das an die CenterBox geknüpft ist
     * @return File
     */
    public File getFile() {
        return file;
    }    
    
    /**
     * Setter für die Sprache
     * @param language Sprache
     */
    public void setLanguage(Language language) {
        file.setLanguage(language);
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

        /**
     * Legt den Anfang des sichtbaren Bereichs fest, der eingefärbt werden soll
     * @param visibleIndexStart Anfang
     */
    public void setVisibleIndexStart(int visibleIndexStart) {
        syntaxManager.setVisibleIndexStart(visibleIndexStart);
    }
    
    /**
     * Legt das Ende des sichtbaren Bereichs fest, der eingefärbt werden soll
     * @param visibleIndexEnd Ende
     */
    public void setVisibleIndexEnd(int visibleIndexEnd) {
        syntaxManager.setVisibleIndexEnd(visibleIndexEnd);
    }
    
    /**
     * Ruft den zugehörigen SearchReplaceManager ab
     * @return SearchReplaceManager
     */
    public SearchReplaceManager getSearchReplaceManager() {
        return searchReplaceManager;
    }
    
    /**
     * Ruft den Text des Dokuments ab
     * @return Text des angehängten Dokuments
     */
    public String getText(){
        try {
            return document.getText(0, document.getLength());
        } catch (BadLocationException ex) {
            return null;
        }
    }
}
