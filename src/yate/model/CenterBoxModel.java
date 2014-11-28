package yate.model;
import yate.syntax.cstyle.CStyleLanguage;
import java.awt.Color;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import yate.listener.CenterBox.DocumentUpdateAction;
import yate.syntax.c.CLanguage;
import yate.syntax.general.*;
import yate.syntax.general.elements.LanguageElementType;
import yate.syntax.java.JavaLanguage;


/**
 *
 * @author Laurin
 */
public class CenterBoxModel {

    /*
    *-*-*-*-* TEST CHS *-*-*-*-*
    */
    CLanguage language = new CLanguage();
    /*
    *-*-*-*-* TEST CHS *-*-*-*-*
    */

    /**
     * Document der zugehoerigen CenterBoxView;
     */
    private final StyledDocument document;
    
    /**
     * Dient zur intervallbasierten Speicherung der Syntaxtokens.
     * So kann in konstanter Zeit abgefragt werden, welchem Tokentyp ein Element
     * angehört.
     */
    private final NavigableMap<Integer,SyntaxToken> syntaxMap = new TreeMap<>();

    /**
     * Testmap, wird durch den ColorManager ersetzt
     */
    private final HashMap<String,Color> testColorMap = new HashMap<>();
    
    private int currentCaretPosition = 0;
    
    private int bracerIndex = 0;
    
    public CenterBoxModel(StyledDocument document) {
        this.document = document;

        //Test ColorMap anlegen
        testColorMap.put(language.languageName+LanguageElementType.COMMENT, Color.green);
        testColorMap.put(language.languageName+LanguageElementType.DATATYPE, Color.orange);
        testColorMap.put(language.languageName+LanguageElementType.KEYWORD, Color.blue);
        testColorMap.put(language.languageName+LanguageElementType.LITERAL, Color.red);
    }

    public void setForegroundColor(Color c, int start, int length) {
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setForeground(sas, c);
        document.setCharacterAttributes(start, length, sas, false);
    }
    
    public void setBackgroundColor(Color c, int start, int length) {
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setBackground(sas, c);
        document.setCharacterAttributes(start, length, sas, false);
    }
    
    private void clearColors() {
        setForegroundColor(Color.black, 0, document.getLength());
        setBackgroundColor(Color.white, 0, document.getLength());
    }
    
    private final Runnable runHighlightSyntax = new Runnable() {
        @Override
        public void run() {
            //Diser Code wird in einem separaten Thread ausgeführt
            
            //DocumentUpdate abschalten
            DocumentUpdateAction.isEnabled = false;
             
            //Tokens ermitteln und einfärben
            language.analyzeSyntax(getDocumentText(),syntaxMap);
            setSyntaxColors();
            
            //DocumentUpdate wieder einschalten
            DocumentUpdateAction.isEnabled = true;
        }
    };
    
    private String getDocumentText() {
        String text;
            try {
                //Textlänge ermitteln
                text = document.getText(0, document.getLength());
                return text;
            }
            catch(BadLocationException ex) {
                return "";
            }
    }    
    
    private String generateIndention(int n)
    {
        StringBuilder builder = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            builder.append("\t");
        }
        return builder.toString();
    }
    
    private void setSyntaxColors()
    {   
        //Standardfarbe einstellen (Schwarz auf weiß)
        clearColors();
        for (SyntaxToken token : syntaxMap.values()) {
                if (testColorMap.containsKey(language.languageName+token.getTokenType().getType().toString())) {
                    setForegroundColor(testColorMap.get(language.languageName+token.getTokenType().getType().toString()), token.getStart(), token.getLength());
                }
            }
    }
    
    private final Runnable runHighlightBracers = new Runnable() {
        @Override
        public void run() {            
            if (!(language instanceof CStyleLanguage)) return;
            //Diser Code wird in einem separaten Thread ausgeführt
            
            try
            {
                //DocumentUpdate abschalten
                DocumentUpdateAction.isEnabled = false;
                
                //Klammer links vom Cursor?
                SyntaxToken token = syntaxMap.get(bracerIndex-1);
                if (token == null) {
                    //Klammer an Cursorposition?
                    token = syntaxMap.get(bracerIndex);
                }
                
                if (token != null && (token.getTokenType() instanceof ICloseBracer || token.getTokenType() instanceof IOpenBracer)) {
                    SyntaxToken pair = token.getPair();
                    if(pair != null)
                    {
                        //Highlighten
                        setCurrentHighlightedBracer(token);
                        return;
                    }
                }
                //Highlighting aufheben
                setCurrentHighlightedBracer(null);                
            }
            finally //Der Listener muss in JEDEM Fall wieder angemeldet werden
            {
                //DocumentUpdate wieder einschalten
                DocumentUpdateAction.isEnabled = true;
            }
        }
    };    
    
    public void analyseSyntax()
    {
        //Dieser Code muss invoked werden, da er erst nach der Abhandlung von
        //Events ausgeführt werden darf
        SwingUtilities.invokeLater(runHighlightSyntax);        
    }
    
    public void highlightBracers(int position)
    {
        currentCaretPosition = position;
        bracerIndex = position;
        //Klammer links vom Cursor?
        SyntaxToken token = syntaxMap.get(bracerIndex-1);
        if (token == null) {
            //Klammer an Cursorposition?
            token = syntaxMap.get(bracerIndex);
        }
        if (token != null) {
            SwingUtilities.invokeLater(runHighlightBracers); 
        }
    }
    
    private SyntaxToken currentHighlightedBracer = null;
    
    private void setCurrentHighlightedBracer(SyntaxToken token) {
        setBracerColor(currentHighlightedBracer, Color.white);
        currentHighlightedBracer = token; 
        setBracerColor(currentHighlightedBracer, Color.yellow);
    }
    
    private void setBracerColor(SyntaxToken token,Color color) {
        if (token == null || token.getPair() == null) return;
        setBackgroundColor(color, token.getStart(), token.getLength());
        setBackgroundColor(color, token.getPair().getStart(), token.getPair().getLength());
    }
}
