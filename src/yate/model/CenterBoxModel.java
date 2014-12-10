package yate.model;
import javax.swing.text.StyledDocument;
import yate.autocomplete.AutoCompleteManager;
import yate.managers.SearchReplaceManager;
import yate.managers.SyntaxManager;
import yate.project.File;
import yate.syntax.general.*;


/**
 *
 * @author Laurin
 */
public class CenterBoxModel {
    
    private final SyntaxManager syntaxManager;
    private final AutoCompleteManager autoCompleteManager;
    
    public CenterBoxModel(StyledDocument document, File file) {
        autoCompleteManager = new AutoCompleteManager();
        syntaxManager = new SyntaxManager(document,file,autoCompleteManager);      
    }
    
    public void analyseSyntax()
    {
        autoCompleteManager.clearSuggestions();
        syntaxManager.highlightSyntax();
    }
    
    public void highlightBracers(int position) {
        syntaxManager.highlightBracers(position);
    }
    
    public void reHighlightSyntax() {
        syntaxManager.reHighlightSyntax();
    }
    public Language getLanguage() {
        return syntaxManager.getLanguage();
    }

    public void setLanguage(Language language) {
        syntaxManager.setLanguage(language);
        syntaxManager.highlightSyntax();
    }

    public AutoCompleteManager getAutoCompleteManager() {
        return autoCompleteManager;
    }
     
    
}
