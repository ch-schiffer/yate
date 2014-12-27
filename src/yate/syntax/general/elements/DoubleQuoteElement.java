/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.general.elements;

/**
 * Diese Klasse stellt Muster für Literale mit doppelten Anführungszeichen 
 * zur Verfügung
 * @author Christian
 */
public class DoubleQuoteElement extends LanguageElement{
    
    private static final String pattern = "\\\"((?!(\\\")).)*\\\"";
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    public DoubleQuoteElement() {
        super(pattern);
    }
    
}
