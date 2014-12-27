/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.asm;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;
import yate.syntax.general.elements.NumberElement;

/**
 * Diese Klasse stellt eine Nummer dar, die als Token der Sprache Assembler verwendet wird
 * @author Christian
 */
public class ASMNumber extends KeyWordCollection {
    
    /**
     * Konstruktor, erzeugt eine Instanz der Klasse
     */
    public ASMNumber() {
        super(LanguageElementType.NUMBER);
    }
    
    /**
     * Ruft eine Liste der hinterlegten KeyWords ab
     * @return Liste der KeyWords
     */
    @Override
    protected ArrayList<? extends LanguageElement> getKeyWords() {
        return keyWords;
    }
    
    /**
     * Liste der Schlüsselwörter
     */
    private static final ArrayList<? extends LanguageElement> keyWords = new ArrayList<>(Arrays.asList(
            new NumberElement()
    ));
}
