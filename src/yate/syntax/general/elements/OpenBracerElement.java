/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general.elements;

/**
* Diese Klasse stellt Muster für öffnende Klammern für Sprachen im C-Stil
 * zur Verfügung
  * @author Christian
 */
public class OpenBracerElement extends LanguageElement {

    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     * @param pattern Muster des Schlüsselworts
     */
    public OpenBracerElement(String pattern) {
        super("\\"+pattern);
    }
    
}
