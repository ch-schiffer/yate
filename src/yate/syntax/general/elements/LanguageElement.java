/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general.elements;

/**
 *
 * @author Christian
 */
public abstract class LanguageElement {
    private final String elementPattern;
    
    public LanguageElement(String pattern) {
        elementPattern = pattern;
    }


    public String getElementPattern() {
        return elementPattern;
    }
}
