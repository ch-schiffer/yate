/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.general.elements;

import yate.syntax.general.IIndentionBracer;

/**
 * Diese Klasse stellt Muster für öffnende Klammern zur Verfügung, die für die
 * Einrückung relevant sind
 * @author Christian
 */
public class OpenIndentionBracerElement extends OpenBracerElement implements IIndentionBracer{
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     * @param pattern Muster des Schlüsselworts
     */
    public OpenIndentionBracerElement(String pattern) {
        super(pattern);
    }    
}
