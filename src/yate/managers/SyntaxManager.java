/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.managers;

import java.awt.Color;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.SortedMap;
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
import yate.listener.CenterBox.ViewPortChangedListener;
import yate.project.File;
import yate.syntax.cstyle.CStyleLanguage;
import yate.syntax.general.ICloseBracer;
import yate.syntax.general.IIndentionBracer;
import yate.syntax.general.IOpenBracer;
import yate.syntax.general.Language;
import yate.syntax.general.SyntaxToken;

/**
 * Diese Klasse verwaltet alle Funktionen, die das Syntaxhighlighting und
 * die automatische Einrückung von Code betreffen
 * @author Christian
 */
public class SyntaxManager {
    
    /**
     * Document der zugehoerigen CenterBoxView;
     */
    private final StyledDocument document;
    
    /**
     * Eingestellte Sprache
     */
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
    
    //Indizes müssen initialisiert werden, da vor der ersten Änderung durch Scrollen
    //bereits Syntax in dem sichtbaren Bereich eingefärbt werden muss
    private int visibleIndexStart = 0;
    private int visibleIndexEnd = 5000;
    
    /**
     * Legt den Index fest, ab dem der sichtbare Text beginnt
     * @param visibleIndexStart  Anfang des sichtbaren Bereichs
     */
    public void setVisibleIndexStart(int visibleIndexStart) {
        this.visibleIndexStart = visibleIndexStart;
    }
    
    /**
     * Legt den Index fest, an dem der sichtbare Text endet
     * @param visibleIndexEnd  Ende des sichtbaren Bereichs
     */
    public void setVisibleIndexEnd(int visibleIndexEnd) {
        this.visibleIndexEnd = visibleIndexEnd;
    }
    
    /**
     * Legt ein neues Objekt vom Typ SyntaxManager an
     * @param document Dokument, das abgebildet wird
     * @param file Datei, die gebunden ist
     * @param autoCompleteManager AutoCompleteManager, der die CheckBox verwaltet
     */
    public SyntaxManager(StyledDocument document, File file, AutoCompleteManager autoCompleteManager) {
        this.document = document;
        language = LanguageManager.evaluateLanguage(file);
        this.autoCompleteManager = autoCompleteManager;
    }
    
    /**
     * Ruft den Text des Dokuments ab
     * @return Text des Dokuments
     */
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
    
    /**
     * Färbt die Syntax entsprechend der eingestellten Sprache ein
     */
    public void highlightSyntax() {
        if (language != null)
            SwingUtilities.invokeLater(runHighlightSyntax);
    }
    
    /**
     * Färbt Klammern paarweise ein
     * @param position Position der ausgewählten Klammer im Text
     */
    public void highlightBracers(int position) {
        currentCaretPosition = position;
        if (language != null)
            SwingUtilities.invokeLater(runHighlightBracers);
    }
    
    /**
     * Färbt die Syntax neu ein, ohne den Text erneut zu analysieren
     */
    public void reHighlightSyntax() {
        SwingUtilities.invokeLater(runReHighlightSyntax);
    }
    
    private int insertedCount = 0;
    
    /**
     * Rückt den Code ein
     */
    public void indentCode() {
        SwingUtilities.invokeLater(runIndentCode);
    }
    
    private final Runnable runIndentCode = new Runnable() {
        @Override
        public void run() {
            String text = removeLeadingWhitespace();
            language.analyzeSyntax(text, syntaxMap, autoCompleteManager);
            insertedCount = 0;
            TreeMap<Integer,Integer> tabPositions = new TreeMap<>();
            TreeMap<Integer,Integer> positionLineMap = new TreeMap<>();
            Pattern linePattern = Pattern.compile(".*(\\n|$)");
            Matcher matcher = linePattern.matcher(text);
            int currentLine = 0;
            while(matcher.find()) {
                positionLineMap.put(matcher.start(), currentLine);
                positionLineMap.put(matcher.end(), currentLine++);
            }
            for (SyntaxToken token : syntaxMap.values()) {
                if (token.getTokenType() instanceof IOpenBracer && token.getTokenType() instanceof IIndentionBracer)
                {
                    if (token.getPair() == null) continue;  //Klammer hat keinen Partner -> ignorieren
                    SyntaxToken closeBracerToken = token.getPair();
                    int startIndex = token.getStart();          //Index der öffnenden...
                    int endIndex = closeBracerToken.getStart(); //...und der schließdenden Klammer
                    int startLine = positionLineMap.floorEntry(startIndex).getValue();  //Zeile der öffnenden...
                    int endLine = positionLineMap.floorEntry(endIndex).getValue();      //und der schließdenen Klammer
                    if (startIndex+1 >= endIndex-1) continue;   //Klammern umschließen keinen Block, ignorieren
                    SortedMap<Integer, Integer> block = positionLineMap.subMap(startIndex+1, endIndex-1); //Umschlossenen Block holen
                    for (Integer pos : block.keySet()) {
                        int posLine = positionLineMap.floorEntry(pos).getValue();
                        //Einrückungslevel zählen
                        if (posLine > startLine && posLine <= endLine) {
                            if (tabPositions.containsKey(pos)) {
                                tabPositions.put(pos, tabPositions.get(pos)+1);
                            }
                            else {
                                tabPositions.put(pos, 1);
                            }
                        }
                    }
                }
            }
            StringBuilder builder = new StringBuilder(text);
            for (int pos : tabPositions.keySet()) {
                insertTab(builder, pos, tabPositions.get(pos));
            }
            try {
                document.remove(0, document.getLength());
                document.insertString(0,builder.toString(),null);
            } catch (BadLocationException ex) {
            }
        }
    };
    
    private void insertTab(StringBuilder sb, int position, int count) {
        for (int i=0; i<count; i++) {
            sb.insert(position+insertedCount, "\t");
            insertedCount++;
        }
    }
    
    private String removeLeadingWhitespace() {
        Pattern linePattern = Pattern.compile(".*(\\n|$)");
        Pattern whiteSpacePattern = Pattern.compile("^[ \\t]+");
        Matcher lineMatcher = linePattern.matcher(getDocumentText());
        StringBuffer sb = new StringBuffer();
        //Einzelne Zeilen finden
        while(lineMatcher.find()) {
            Matcher whiteSpaceMatcher = whiteSpacePattern.matcher(lineMatcher.group());
            //In jeder Zeile führende Whitespaces entfernen
            while(whiteSpaceMatcher.find()) {
                whiteSpaceMatcher.appendReplacement(sb, "");
            }
            whiteSpaceMatcher.appendTail(sb);
        }
        return sb.toString();
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
                ViewPortChangedListener.isEnabled = false;
                setSyntaxColors();
            }
            finally {
                ViewPortChangedListener.isEnabled = true;
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
    
    private void setForegroundColor(Color c, int start, int length) {
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setForeground(sas, c);
        document.setCharacterAttributes(start, length, sas, false);
    }
    
    private void setBackgroundColor(Color c, int start, int length) {
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setBackground(sas, c);
        document.setCharacterAttributes(start, length, sas, false);
    }
    
    private void setSyntaxColors() {
        for (SyntaxToken token : syntaxMap.subMap(visibleIndexStart,true, visibleIndexEnd,true).values()) {
            setForegroundColor(ColorManager.getInstance().getColor(language.getLanguageName()+token.getTokenType().getType().getDisplayName()), token.getStart(), token.getLength());
        }
        //Um nicht vollständig dargestellte Tokens zu färben (z.B. mehrzeilige Kommentare) werden diese extra behandelt
        Entry<Integer,SyntaxToken> headToken = syntaxMap.floorEntry(visibleIndexStart);
        if (headToken != null) {
            SyntaxToken token = headToken.getValue();
            setForegroundColor(ColorManager.getInstance().getColor(language.getLanguageName()+token.getTokenType().getType().getDisplayName()), token.getStart(), token.getLength());
        }
    }
    
    /**
     * Ruft die aktuell ausgewählte Sprache ab
     * @return Ausgewählte Sprache
     */
    public Language getLanguage() {
        return language;
    }
    
    /**
     * Legt die Sprache fest
     * @param language Festzulegende Sprache
     */
    public void setLanguage(Language language) {
        this.language = language;
    }
}

