/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.cstyle;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.elements.CStyleMultilineCommentElement;
import yate.syntax.general.elements.CStyleSingleLineCommentElement;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;

/**
 * Diese Klasse listet alle Kommentarformate für Sprachen im C-Stil auf
 * @author Christian
 */
public class CStyleComment extends KeyWordCollection {
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    public CStyleComment() {
        super(LanguageElementType.COMMENT);
    }
    
    /**
     * Ruft eine Liste der hinterlegten KeyWords ab
     * @return Liste der KeyWords
     */
    @Override
    protected ArrayList<? extends LanguageElement> getKeyWords() {
        return keyWords;
    }
    
    private static final ArrayList<? extends LanguageElement> keyWords = new ArrayList<>(Arrays.asList(
            new CStyleSingleLineCommentElement(),
            new CStyleMultilineCommentElement()
    ));
}


