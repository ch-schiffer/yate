/*
* Pour changer cet en-tête de licence, choisissez "en-tête de licence" dans les calibrages du projet
* Pour changer ce fichier de modèle, choisissez "outillages | en-têtes"
* et ouvriez l'en-tête dans l'éditeur
*/
package yate.managers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
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
 * @auctor Carina
 *
 * Locus communis Gryffindorensis illo vespere
 * strepitu resonabat. Harrius et Ronaldus et Hermione
 * iuxta fenestram coniuncti sedebant. Hermione opem ferens
 * Harrio et Ronaldo scrutabatur pensa eorum de Incantationibus
 * scripta. Nunquam eis permisit se imitari ("quomodo enim discetis?"),
 * sed illa roganda ut  pensa sua pelegeret, responsa recta nihilominus
 * adepti sund.
 *
 */
public class SearchReplaceManager {
    private boolean regex;
    private String actualKeyword;
    private int index;
    private final ArrayList<Pair<Integer,Integer>> positions = new ArrayList();
    private final JTextPane textPane;
    private final StyledDocument doc;
    
    public SearchReplaceManager(JTextPane textPane, StyledDocument doc){
        this.textPane = textPane;
        this.doc = doc;
    }
    
    public void setRegex(boolean regex) {
        if (regex != this.regex) {
            this.regex = regex;
            reset();
        }
    }
 
    public void search(String keyword, boolean findNext) {
        try {
            // übergebenes Keyword ist immer noch das gleiche nachdem vorher auch schon gesucht wurde
            // dann ist der Text schon markiert, der Cursor muss einfach aanders gesetzt werden
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
                
                while (matcher.find()) {
                    setBackgroundColor(Color.yellow, matcher.start(), matcher.end());
                    positions.add(new Pair(matcher.start(), matcher.end()));
                }
                if (positions.size() > 0){
                    setBackgroundColor(Color.green, positions.get(index).getFirst(), positions.get(index).getSecond());
                    textPane.setCaretPosition(positions.get(index).getFirst());
                    textPane.moveCaretPosition(positions.get(index).getSecond());
                }
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(SearchReplaceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setBackgroundColor(Color c, int start, int end){
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setBackground(sas, c);
        doc.setCharacterAttributes(start, end-start, sas, false);
    }
    
    public void replace(String keyword, String replaceWith){
        try {
            if (actualKeyword == null) {
                //   search(keyword, text,)
            }
            String toReplace = doc.getText(0, doc.getLength());
            Matcher matcher = Pattern.compile(regex ? keyword : Pattern.quote(keyword)).matcher(toReplace);
            StringBuffer sb = new StringBuffer();
            if (matcher.find()){
                matcher.appendReplacement(sb, replaceWith);
            }
            matcher.appendTail(sb);
            doc.remove(0, doc.getLength());
            doc.insertString(0, sb.toString(), null);
            
        } catch (BadLocationException ex) {
        }
    }
    
    private String escapeRegex(String toReplace, String keyword){
        
        Matcher matcher = Pattern.compile(keyword).matcher(toReplace);
        StringBuffer sb = new StringBuffer();
        if (matcher.find()){
            matcher.appendReplacement(sb, "\\"+keyword);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    
    public void replaceAll(String keyword, String replaceWith){
        
        try {
            String toReplace = doc.getText(0, doc.getLength());
            Matcher matcher = Pattern.compile(regex ? keyword : Pattern.quote(keyword)).matcher(toReplace);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()){
                matcher.appendReplacement(sb, replaceWith);
            }
            matcher.appendTail(sb);   
            doc.remove(0, doc.getLength());
            doc.insertString(0, sb.toString(), null);
        } catch (BadLocationException ex) {
        }
    }
    
    public void reset() {
        for (Pair position : positions) {
            setBackgroundColor(Color.white, 0, doc.getLength());
        }
        actualKeyword=null;
        positions.clear();
    }
}
