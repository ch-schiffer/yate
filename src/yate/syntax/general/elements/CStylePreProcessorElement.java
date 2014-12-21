/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general.elements;

/**
 * Diese Klasse stellt Muster für Präprozessordirektiven für Sprachen im C-Stil 
 * zur Verfügung
 * @author Christian
 */
public class CStylePreProcessorElement extends LanguageElement {
    private static final String pattern = "#.*";
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    public CStylePreProcessorElement() {
        super(pattern);
    }
    
}
