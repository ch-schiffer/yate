/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.cstyle;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.ICloseBracer;
import yate.syntax.general.IIndentionBracer;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.CloseIndentionBracerElement;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;

/**
 * Diese Klasse listet alle schließenden Klammern für Sprachen im C-Stil auf, die
 * für die Einrückung relevant sind
 * @author Christian
 */
public class CStyleCloseIndentionBracer extends KeyWordCollection implements ICloseBracer, IIndentionBracer {

    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    public CStyleCloseIndentionBracer() {
        super(LanguageElementType.CLOSEINDBRACER);
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
            new CloseIndentionBracerElement("}")
            ));    
    
}
