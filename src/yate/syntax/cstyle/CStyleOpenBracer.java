/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.cstyle;

import yate.syntax.general.elements.OpenIndentionBracerElement;
import yate.syntax.general.elements.LanguageElement;
import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.IOpenBracer;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.LanguageElementType;
import yate.syntax.general.elements.OpenBracerElement;

/**
 * Diese Klasse listet alle öffnenden Klammern für Sprachen im C-Stil auf
 * @author Christian
 */
public class CStyleOpenBracer extends KeyWordCollection implements IOpenBracer {
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    public CStyleOpenBracer() {
        super(LanguageElementType.OPENBRACER);
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
            new OpenIndentionBracerElement("{"),
            new OpenBracerElement("("),
            new OpenBracerElement("["),
            new OpenBracerElement("{")
    ));
}
