package yate.managers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import yate.misc.Pair;

/**
 *
 * @author Carina
 * Klasse SearchReplaceManager ist für das Suchen und Ersetzen im Dokument zuständig
 *
 */
public class SearchReplaceManager {
    // Angabe, ob reguläre Ausdrücke berücksichtigt werden oder nicht
    private boolean regex;
    // aktuelles Schlüsselwort
    private String actualKeyword;
    // Index des aktuell gehighlighteten Schlüsselworts
    private int index;
    // Liste der Positionen des Schlüsselworts im Text
    private final ArrayList<Pair<Integer,Integer>> positions = new ArrayList();
    //
    private final JTextPane textPane;
    // Dokument, in dem gesucht und ersetzt werden soll
    private final StyledDocument doc;
    
    /**
     * Konstruktor für einen SearchReüplaceManager
     * @param textPane das aktuelle TextPane
     * @param doc das Dokument, in dem gesucht und ersetzt werden soll
     */
    public SearchReplaceManager(JTextPane textPane, StyledDocument doc){
        this.textPane = textPane;
        this.doc = doc;
    }
    
    /**
     * Setter für die Angabe, ob nach regulären Ausdrücken gesucht werden soll
     * @param regex true oder false
     */
    public void setRegex(boolean regex) {
        if (regex != this.regex) {
            this.regex = regex;
            reset();
        }
    }
 
    /**
     * sucht im Text nach dem übergebenen Schlüsselwort
     * @param keyword Schlüsselwort, nach dem gesucht werden soll
     * @param findNext wenn findNext true ist, wird vorwärtsgesucht, ansonsten rückwärts
     */
    public void search(String keyword, boolean findNext) {
        try {
            // übergebenes Keyword ist immer noch das gleiche nach dem vorher auch schon gesucht wurde
            // dann ist der Text schon markiert, der Cursor muss einfach anders gesetzt werden
            if (keyword.equals(actualKeyword)){
                // Vorwärtssuche
                if (positions.size() > 0){
                    setBackgroundColor(Color.yellow, positions.get(index).getFirst(), positions.get(index).getSecond());
                }
                if (findNext){
                    index = (index + 1 < positions.size() ? index + 1 : 0);
                } else {
                    // Rückwärtssuche  
                    index = (index - 1 >= 0 ? index - 1 : positions.size()-1);
                }
                if (positions.size() > 0){
                    setBackgroundColor(Color.green, positions.get(index).getFirst(), positions.get(index).getSecond());
                    textPane.setCaretPosition(positions.get(index).getFirst());
                    textPane.moveCaretPosition(positions.get(index).getFirst());
                }
                // nach dem übergebenen Keyword wird zum ersten Mal gesucht
                // Document muss farbig markiert werden, Liste der Keywords muss gesetzt werden
            }else {
                reset();
                positions.clear();
                index = ( findNext ? 0 : positions.size() - 1);
                actualKeyword = keyword;
                
                String toSearch = doc.getText(0, doc.getLength());
                //Matcher matcher = Pattern.compile(keyword).matcher(toSearch);
                Matcher matcher = Pattern.compile(regex ? keyword : Pattern.quote(keyword)).matcher(toSearch);
                
                // zunächst werden alle Vorkommen des Schlüsselworts gelb markiert und die Positionen in
                // der Liste mit den Positionen gespeichert
                while (matcher.find()) {
                    setBackgroundColor(Color.yellow, matcher.start(), matcher.end());
                    positions.add(new Pair(matcher.start(), matcher.end()));
                }
                if (positions.size() > 0){
                    // Farbe des aktuellen Schlüssleworts wird auf grün gesetzt
                    setBackgroundColor(Color.green, positions.get(index).getFirst(), positions.get(index).getSecond());
                    // Cursor wird an die Stelle ds grün markierten Schlüsselworts gesetzt
                    textPane.setCaretPosition(positions.get(index).getFirst());
                    textPane.moveCaretPosition(positions.get(index).getSecond());
                }
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(SearchReplaceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Setter für die Hintergrundfarbe
     * @param c Farbe
     * @param start Startindex
     * @param end Endindex
     */
    private void setBackgroundColor(Color c, int start, int end){
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setBackground(sas, c);
        doc.setCharacterAttributes(start, end-start, sas, false);
    }
    
    /**
     * ersetzt das zu suchende Wort mit dem zu ersetzenden Wort (einmalig)
     * @param keyword Schlüsselwort
     * @param replaceWith Ersetzung des Schlüsselworts
     */
    public void replace(String keyword, String replaceWith){
        try {
            if (actualKeyword == null) {
                //   search(keyword, text,)
            }
            String toReplace = doc.getText(0, doc.getLength());
            Matcher matcher = Pattern.compile(regex ? keyword : Pattern.quote(keyword)).matcher(toReplace);
            StringBuffer sb = new StringBuffer();
            // sucht einmalig
            if (matcher.find()){
                matcher.appendReplacement(sb, replaceWith);  
                positions.add(new Pair(matcher.start(), matcher.end()));
            }
            matcher.appendTail(sb);
            doc.remove(0, doc.getLength());
            doc.insertString(0, sb.toString(), null);
            
            setBackgroundColor(Color.green, positions.get(0).getFirst(), positions.get(0).getSecond());
        } catch (BadLocationException ex) {
        }
    }
    
    /**
     * verhindert das Finden regulärer Ausdrücke
     * @param toReplace
     * @param keyword
     * @return 
     */
    private String escapeRegex(String toReplace, String keyword){
        
        Matcher matcher = Pattern.compile(keyword).matcher(toReplace);
        StringBuffer sb = new StringBuffer();
        if (matcher.find()){
            matcher.appendReplacement(sb, "\\"+keyword);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    
    /**
     * ersetzt alle Vorkommen eines Schlüsselworts mit der übergebenen Zeichenkette im Text
     * @param keyword Schlüsselwort
     * @param replaceWith Ersetzung
     */
    public void replaceAll(String keyword, String replaceWith){    
        try {
            String toReplace = doc.getText(0, doc.getLength());
            Matcher matcher = Pattern.compile(regex ? keyword : Pattern.quote(keyword)).matcher(toReplace);
            StringBuffer sb = new StringBuffer();
            // sucht weiter, solange noch was gefunden wird
            while (matcher.find()){
                matcher.appendReplacement(sb, replaceWith);
            }
            matcher.appendTail(sb);   
            doc.remove(0, doc.getLength());
            doc.insertString(0, sb.toString(), null);
            // zum Markieren der Änderungen
            search(replaceWith, false);
        } catch (BadLocationException ex) {
        }
    }
    
    /**
     * setzt die Hintergrundfarben der bisher markierten Vorkommen des alten Schlüsselworts
     * auf weiß, das Schlüsselwort auf null und leert die Liste mit den Positionen,
     * sodass der Text wieeder ganz weiß ist un d neu bearbeitet werden kann
     */
    public void reset() {
        setBackgroundColor(Color.white, 0, doc.getLength());
        actualKeyword=null;
        positions.clear();
    }
}
