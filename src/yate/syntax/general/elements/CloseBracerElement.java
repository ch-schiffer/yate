/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general.elements;

/**
 * Diese Klasse stellt Muster für schließende Klammern zur Verfügung
 * @author Christian
 */
public class CloseBracerElement extends LanguageElement {

    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     * @param pattern Muster des Schlüsselworts
     */
    public CloseBracerElement(String pattern) {
        super("\\"+pattern);
    }
    
}
