/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.asm;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.CaseInsensitiveKeyWordElement;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;

/**
 * Diese Klasse listet die Flags auf, die in der Sprache Assembler verwendet werden
 * @author Christian
 */
public class ASMFlags extends KeyWordCollection{
    
    /**
     * Konstruktor, erzeugt eine Instanz der Klasse
     */
    public ASMFlags() {
        super(LanguageElementType.FLAG);
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
            new CaseInsensitiveKeyWordElement("CF"),
            new CaseInsensitiveKeyWordElement("AF"),
            new CaseInsensitiveKeyWordElement("ZF"),
            new CaseInsensitiveKeyWordElement("SF"),
            new CaseInsensitiveKeyWordElement("PF"),
            new CaseInsensitiveKeyWordElement("OF"),
            new CaseInsensitiveKeyWordElement("TF"),
            new CaseInsensitiveKeyWordElement("IF"),
            new CaseInsensitiveKeyWordElement("DF")
    ));
}
