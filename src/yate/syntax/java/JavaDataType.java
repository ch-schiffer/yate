/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.java;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.KeyWordElement;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;

/**
 * Diese Klasse listet die Datentypen auf, die von Java unterstützt werden
 * @author Christian
 */
public class JavaDataType extends KeyWordCollection {
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    public JavaDataType() {
        super(LanguageElementType.DATATYPE);
    }
    
    /**
     * Gibt eine Liste der KeyWords zurück
     * @return Liste der KeyWords
     */
    @Override
    protected ArrayList<? extends LanguageElement> getKeyWords() {
        return keyWords;
    }
    
    private static final ArrayList<? extends LanguageElement> keyWords = new ArrayList<>(Arrays.asList(
            new KeyWordElement("boolean"),
            new KeyWordElement("byte"),
            new KeyWordElement("char"),
            new KeyWordElement("double"),
            new KeyWordElement("float"),
            new KeyWordElement("int"),
            new KeyWordElement("long"),
            new KeyWordElement("short"),
            new KeyWordElement("void"),
            new KeyWordElement("true"),
            new KeyWordElement("false"),
            new KeyWordElement("String")   //In Java kein Datentyp, aber wir wollen mal nicht so sein
    ));
    
}
