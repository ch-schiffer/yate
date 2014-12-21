/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.c;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.KeyWordElement;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;

/**
 * Diese Klasse listet die Schlüsselwörter auf, die von C unterstützt werden
 * @author Christian
 */
public class CKeyWord extends KeyWordCollection {
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    public CKeyWord() {
        super(LanguageElementType.KEYWORD);
    }
    
    /**
     * Gibt eine Liste der Schlüsselwörter zurück
     * @return Liste der Schlüsselwörter
     */
    @Override
    protected ArrayList<? extends LanguageElement> getKeyWords() {
        return keyWords;
    }
    
    /**
     * Liste der Schlüsselwörter
     */
    private static final ArrayList<? extends LanguageElement> keyWords = new ArrayList<>(Arrays.asList(
            new KeyWordElement("auto"),
            new KeyWordElement("break"),
            new KeyWordElement("case"),
            new KeyWordElement("const"),
            new KeyWordElement("continue"),
            new KeyWordElement("default"),
            new KeyWordElement("do"),
            new KeyWordElement("else"),
            new KeyWordElement("enum"),
            new KeyWordElement("extern"),
            new KeyWordElement("for"),
            new KeyWordElement("goto"),
            new KeyWordElement("if"),
            new KeyWordElement("register"),
            new KeyWordElement("return"),
            new KeyWordElement("sizeof"),
            new KeyWordElement("static"),
            new KeyWordElement("struct"),
            new KeyWordElement("switch"),
            new KeyWordElement("typedef"),
            new KeyWordElement("union"),
            new KeyWordElement("volatile"),
            new KeyWordElement("while")
    ));
}
