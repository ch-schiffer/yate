/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.general.elements;

/**
 * Diese Klasse ist eine abstrakte Basisklasse für alle SyntaxElemente
 * @author Christian
 */
public abstract class LanguageElement {
    private final String elementPattern;
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     * @param pattern Muster des Schlüsselworts
     */
    public LanguageElement(String pattern) {
        elementPattern = pattern;
    }
    
    /**
     * Ruft das Muster des jeweiligen Elements ab
     * @return Muster
     */
    public String getElementPattern() {
        return elementPattern;
    }
}
