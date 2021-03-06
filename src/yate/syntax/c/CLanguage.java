/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.c;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import yate.syntax.cstyle.CStyleCloseBracer;
import yate.syntax.cstyle.CStyleCloseIndentionBracer;
import yate.syntax.cstyle.CStyleComment;
import yate.syntax.cstyle.CStyleIdentifier;
import yate.syntax.cstyle.CStyleLanguage;
import yate.syntax.cstyle.CStyleLiteral;
import yate.syntax.cstyle.CStyleOpenBracer;
import yate.syntax.cstyle.CStyleOpenIndentionBracer;
import yate.syntax.cstyle.CStylePreProcessorDirective;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.LanguageElementType;

/**
 * Diese Klasse bietet Funktionen zur Analyse der Sprache C an
 * @author Christian
 */
public class CLanguage extends CStyleLanguage {
    
    private HashMap<String, Color> defaultColors = null;
    
    /**
     * Konstruktor, erzeugt eine Instanz der Klasse
     */
    public CLanguage() {
        super("C");
        languageSuffixList.add(".c");
        
    }
    
    /**
     * Ruft eine Liste der hinterlegten KeyWords ab
     * @return Liste der KeyWords
     */
    @Override
    protected ArrayList<KeyWordCollection> getKeyWords() {
        return keyWords;
    }
    
    /**
     * Geordnete (!!!) Liste der verschiedenen Schlüsselwortarten
     */
    private static final ArrayList<KeyWordCollection> keyWords = new ArrayList<>(Arrays.asList(
            new CStyleLiteral(),
            new CStyleComment(),
            new CStylePreProcessorDirective(),
            new CStyleOpenIndentionBracer(),
            new CStyleCloseIndentionBracer(),
            new CStyleOpenBracer(),
            new CStyleCloseBracer(),
            new CKeyWord(),
            new CDataType(),
            new CStyleIdentifier()
    ));
    
    /**
     * Gibt eine Liste von Standardfarben für die Sprache Assembler ab
     * @return Liste von Standardsprachen
     */
    @Override
    public HashMap<String, Color> getDefaultColors() {
        if (defaultColors != null) return defaultColors;
        defaultColors = new HashMap<>();
        defaultColors.put(getLanguageName()+LanguageElementType.LITERAL.getDisplayName(), Color.RED);
        defaultColors.put(getLanguageName()+LanguageElementType.COMMENT.getDisplayName(), Color.GREEN);
        defaultColors.put(getLanguageName()+LanguageElementType.KEYWORD.getDisplayName(), Color.BLUE);
        defaultColors.put(getLanguageName()+LanguageElementType.DATATYPE.getDisplayName(), Color.ORANGE);
        return defaultColors;
    }
}
