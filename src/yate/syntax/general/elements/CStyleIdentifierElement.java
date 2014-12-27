/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.general.elements;

/**
 * Dieses Element stellt Muster für allgemeine Identifier zur Verfügung (Variablennamen,
 * Funktionsnamen o.ä.)
 * @author Christian
 */
public class CStyleIdentifierElement extends LanguageElement{
    
    private static final String pattern = "\\b[a-zA-Z_]+[a-zA-Z0-9_]*\\b";
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    public CStyleIdentifierElement() {
        super(pattern);
    }
    
}
