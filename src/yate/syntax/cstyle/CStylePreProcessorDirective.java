/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.cstyle;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.CStylePreProcessorElement;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;

/**
 * Diese Klasse listet Präprozessordirektiven für Sprachen im C-Stil auf
 * @author Christian
 */
public class CStylePreProcessorDirective extends KeyWordCollection {

    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    public CStylePreProcessorDirective() {
        super(LanguageElementType.PREPROCESSOR);
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
                new CStylePreProcessorElement()
    ));

    
}
