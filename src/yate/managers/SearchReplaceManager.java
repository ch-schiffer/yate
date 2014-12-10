/*
 * Pour changer cet en-tête de licence, choisissez "en-tête de licence" dans les calibrages du projet  
 * Pour changer ce fichier de modèle, choisissez "outillages | en-têtes"
 * et ouvriez l'en-tête dans l'éditeur
 */
package yate.managers;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

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
    
    public void search(String keyword, Document text) {
    
    }
    
    public void replace(String keyword, String replaceWith, Document text){
    
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
}
