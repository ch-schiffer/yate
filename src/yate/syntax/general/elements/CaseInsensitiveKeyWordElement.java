/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general.elements;

/**
 * Diese Klasse stellt Muster für nicht case-sensitive Schlüsselwörter zur Verfügung
 * @author Christian
 */
public class CaseInsensitiveKeyWordElement extends KeyWordElement {

    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     * @param pattern Muster des Schlüsselworts
     */
    public CaseInsensitiveKeyWordElement(String pattern) {
        super("(?i)"+pattern);
    }
    
}
