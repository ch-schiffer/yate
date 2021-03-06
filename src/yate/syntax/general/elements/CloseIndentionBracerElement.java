/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.general.elements;

import yate.syntax.general.IIndentionBracer;

/**
 * Diese Klasse stellt Muster für schließende Klammern zur Verfügung, die für 
 * die Einrückung relevant sind
 * @author Christian
 */
public class CloseIndentionBracerElement extends CloseBracerElement implements IIndentionBracer{
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     * @param pattern Muster des Schlüsselworts
     */
    public CloseIndentionBracerElement(String pattern) {
        super(pattern);
    }
    
}
