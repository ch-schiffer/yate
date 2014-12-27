/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.python;
import yate.syntax.general.elements.LanguageElement;

/**
 * Diese Klasse beschreibt einen Python-Kommentar über eine Zeile
 * @author Christian
 */
public class PythonSingleLineCommentElement extends LanguageElement {
    private static final String pattern = "#.*";
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    public PythonSingleLineCommentElement() {
        super(pattern);
    }
}
