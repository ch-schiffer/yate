/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.python;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;

/**
 * Diese Klasse listet die Kommentarformate auf, die von Python unterstützt werden
 * @author Christian
 */
public class PythonComment extends KeyWordCollection {
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    public PythonComment() {
        super(LanguageElementType.COMMENT);
    }
    
    /**
     * Gibt eine Liste der Schlüsselwörter zurück
     * @return Liste der Schlüsselwörter
     */
    @Override
    protected ArrayList<? extends LanguageElement> getKeyWords() {
        return keyWords;
    }
    
    private static final ArrayList<? extends LanguageElement> keyWords = new ArrayList<>(Arrays.asList(
            new PythonSingleLineCommentElement(),
            new PythonMultiLineCommentElement()
    ));
}
