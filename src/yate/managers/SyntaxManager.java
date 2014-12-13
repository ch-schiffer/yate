/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.managers;

import java.awt.Color;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import yate.autocomplete.AutoCompleteManager;
import yate.listener.CenterBox.DocumentUpdateAction;
import yate.project.File;
import yate.syntax.cstyle.CStyleLanguage;
import yate.syntax.general.ICloseBracer;
import yate.syntax.general.IIndentionBracer;
import yate.syntax.general.IOpenBracer;
import yate.syntax.general.Language;
import yate.syntax.general.SyntaxToken;
import yate.syntax.general.elements.LanguageElementType;

/**
 *
 * @author Christian
 */
public class SyntaxManager {
    
    /**
     * Document der zugehoerigen CenterBoxView;
     */
    private final StyledDocument document;
    
    private Language language;
    
    /**
     * Dient zur intervallbasierten Speicherung der Syntaxtokens.
     * So kann in konstanter Zeit abgefragt werden, welchem Tokentyp ein Element
     * angehört.
     */
    private final NavigableMap<Integer,SyntaxToken> syntaxMap = new TreeMap<>();    
    private int currentCaretPosition = 0;    
    private SyntaxToken currentHighlightedBracer = null;    
    private final AutoCompleteManager autoCompleteManager;    
    
    private int visibleIndexStart = 0;
    private int visibleIndexEnd = 0;

    public void setVisibleIndexStart(int visibleIndexStart) {
        this.visibleIndexStart = visibleIndexStart;
    }

    public void setVisibleIndexEnd(int visibleIndexEnd) {
        this.visibleIndexEnd = visibleIndexEnd;
    }
    
    public SyntaxManager(StyledDocument document, File file, AutoCompleteManager autoCompleteManager) {
        this.document = document;
        setLanguage(LanguageManager.evaluateLanguage(file));
        this.autoCompleteManager = autoCompleteManager;
    }
    
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
    
    public void highlightSyntax() {
        if (language != null)
            SwingUtilities.invokeLater(runHighlightSyntax);
    }
    
    public void highlightBracers(int position) {
        currentCaretPosition = position;
        if (language != null)
            SwingUtilities.invokeLater(runHighlightBracers);
    }
    
    public void reHighlightSyntax() {
        SwingUtilities.invokeLater(runReHighlightSyntax);
    }
    
    private int indentCounter = 0;
    private
    
    public void indentCode() {
        TreeMap<Integer,Integer> positionLineMap = new TreeMap<>();
        Pattern linePattern = Pattern.compile(".*(\\n|$)");
        Matcher matcher = linePattern.matcher(getDocumentText());
        int currentLine = 0;
        while(matcher.find()) {
            positionLineMap.put(matcher.start(), currentLine);
            positionLineMap.put(matcher.end(), currentLine++);
        }    
    }
    
    private void indentBlock(SyntaxToken openBracerToken) {
        if (!(openBracerToken instanceof IIndentionBracer) || !(openBracerToken instanceof IOpenBracer)) return;
        if (openBracerToken.getPair() == null) return;
        SyntaxToken closeBracerToken = openBracerToken.getPair();
        int startIndex = openBracerToken.getStart();
        int endIndex = closeBracerToken.getStart();
    }
    
    private final Runnable runHighlightSyntax = new Runnable() {
        @Override
        public void run() {
            //Diser Code wird in einem separaten Thread ausgeführt
            
            //DocumentUpdate abschalten
            DocumentUpdateAction.isEnabled = false;
            
            //Tokens ermitteln und einfärben
            language.analyzeSyntax(getDocumentText(),syntaxMap,autoCompleteManager);
            setSyntaxColors();
            
            //DocumentUpdate wieder einschalten
            DocumentUpdateAction.isEnabled = true;
        }
    };
    
    private final Runnable runReHighlightSyntax = new Runnable() {
        
        @Override
        public void run() {
            try {
                //DocumentUpdate abschalten
                DocumentUpdateAction.isEnabled = false;
                setSyntaxColors();
            }
            finally {
                DocumentUpdateAction.isEnabled = true;
            }
        }
    };
    
    private final Runnable runHighlightBracers = new Runnable() {
        @Override
        public void run() {
            if (!(language instanceof CStyleLanguage)) return;
            //Diser Code wird in einem separaten Thread ausgeführt
            
            try
            {
                //DocumentUpdate abschalten
                DocumentUpdateAction.isEnabled = false;
                
                setSyntaxColors();
                //Klammer links vom Cursor?
                SyntaxToken token = syntaxMap.get(currentCaretPosition-1);
                if (token == null) {
                    //Klammer an Cursorposition?
                    token = syntaxMap.get(currentCaretPosition);
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
    
    private void setSyntaxColors() {
        for (SyntaxToken token : syntaxMap.subMap(visibleIndexStart,true, visibleIndexEnd,true).values()) {
            setForegroundColor(ColorManager.getInstance().getColor(language.getLanguageName()+token.getTokenType().getType().toString()), token.getStart(), token.getLength());
        }
        //Um nicht vollständig dargestellte Tokens zu färben (z.B. mehrzeilige Kommentare) werden diese extra behandelt
        Entry<Integer,SyntaxToken> headToken = syntaxMap.floorEntry(visibleIndexStart);
        if (headToken != null) {
            SyntaxToken token = headToken.getValue();
            setForegroundColor(ColorManager.getInstance().getColor(language.getLanguageName()+token.getTokenType().getType().toString()), token.getStart(), token.getLength());
        }
    }
    
    public Language getLanguage() {
        return language;
    }
    
    public void setLanguage(Language language) {
        this.language = language;
        
        //TEST
        ColorManager.getInstance().setColor(language.getLanguageName()+LanguageElementType.COMMENT, Color.green);
        ColorManager.getInstance().setColor(language.getLanguageName()+LanguageElementType.DATATYPE, Color.orange);
        ColorManager.getInstance().setColor(language.getLanguageName()+LanguageElementType.KEYWORD, Color.blue);
        ColorManager.getInstance().setColor(language.getLanguageName()+LanguageElementType.LITERAL, Color.red);
        ColorManager.getInstance().setColor(language.getLanguageName()+LanguageElementType.MNEMONIC, Color.red);
        ColorManager.getInstance().setColor(language.getLanguageName()+LanguageElementType.FLAG, Color.blue);
        ColorManager.getInstance().setColor(language.getLanguageName()+LanguageElementType.REGISTER, Color.orange);
        ColorManager.getInstance().setColor(language.getLanguageName()+LanguageElementType.NUMBER, Color.green);
        ColorManager.getInstance().setColor(language.getLanguageName()+LanguageElementType.PREPROCESSOR, Color.red);
        //TEST
    }
}

