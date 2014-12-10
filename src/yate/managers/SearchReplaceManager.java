/*
* Pour changer cet en-tête de licence, choisissez "en-tête de licence" dans les calibrages du projet
* Pour changer ce fichier de modèle, choisissez "outillages | en-têtes"
* et ouvriez l'en-tête dans l'éditeur
*/
package yate.managers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @auctor Christian
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
    private final ArrayList<Integer> positions = new ArrayList();
    
    //Private Instanz der Klasse selbst
    private static SearchReplaceManager srmanager;
    
    private SearchReplaceManager(){
        
    }
    
    public static SearchReplaceManager getInstance() {
        //Instanziieren, wenn interne Instanz noch NULL ist
        if (srmanager == null){
            srmanager = new SearchReplaceManager();
        }
        return srmanager;
    }
    
    public void search(String keyword, StyledDocument text, JTextPane textPane, boolean findNext) {
        try {
            // übergebenes Keyword ist immer noch das gleiche nachdem vorher auch schon gesucht wurde
            // dann ist der Text schon markiert, der Cursor muss einfach aanders gesetzt werden
            if (keyword.equals(actualKeyword)){                
                // Vorwärtssuche
                setBackgroundColor(Color.yellow, positions.get(index), positions.get(index)+keyword.length(), text);
                if (findNext){             
                    index = (index + 1 < positions.size() ? index + 1 : 0);
                } else {
                    // Rückwärtssuche
                    
                    index = (index - 1 >= 0 ? index - 1 : positions.size()-1);
                }
                setBackgroundColor(Color.green, positions.get(index), positions.get(index)+keyword.length(), text);
                textPane.setCaretPosition(positions.get(index));
                textPane.moveCaretPosition(positions.get(index));
                // nach dem übergebenen Keyword wird zum ersten Mal gesucht
                // Document muss farbig markiert werden, Liste der Keywords muss gesetzt werden
            }else {
                positions.clear();
                index = ( findNext ? 0 : positions.size() - 1);
                actualKeyword = keyword;
                
                String toSearch = text.getText(0, text.getLength());
                Matcher matcher = Pattern.compile(keyword).matcher(toSearch);
                
                while (matcher.find()) {
                    setBackgroundColor(Color.yellow, matcher.start(), matcher.end(), text);
                    positions.add(matcher.start());
                }
                setBackgroundColor(Color.green, positions.get(index), positions.get(index)+keyword.length(), text);
                textPane.setCaretPosition(positions.get(index));
                textPane.moveCaretPosition(positions.get(index));
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(SearchReplaceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setBackgroundColor(Color c, int start, int end, StyledDocument doc){
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setBackground(sas, c);
        doc.setCharacterAttributes(start, end-start, sas, false);
    }
    
    public void replace(String keyword, String replaceWith, Document text){
        try {
            if (actualKeyword == null) {
                search(keyword, text,)
            }
            String toReplace = text.getText(0, text.getLength());
            Matcher matcher = Pattern.compile(keyword).matcher(toReplace);
            StringBuffer sb = new StringBuffer();
            if (matcher.find()){
                matcher.appendReplacement(sb, replaceWith);
            }
            matcher.appendTail(sb);
            System.out.println(sb);
            text.remove(0, text.getLength());
            text.insertString(0, sb.toString(), null);
            
        } catch (BadLocationException ex) {
        }
    }
    
    public void replaceAll(String keyword, String replaceWith, Document text){
        
        try {
            String toReplace = text.getText(0, text.getLength());
            Matcher matcher = Pattern.compile(keyword).matcher(toReplace);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()){
                matcher.appendReplacement(sb, replaceWith);
            }
            matcher.appendTail(sb);
            System.out.println(sb);
            text.remove(0, text.getLength());
            text.insertString(0, sb.toString(), null);
        } catch (BadLocationException ex) {
        }        
    }
    
    public void reset(StyledDocument doc) {
        for (Integer position : positions) {
            setBackgroundColor(Color.white, 0, doc.getLength(), doc);
        }
        actualKeyword=null;
        positions.clear();
    }
}
