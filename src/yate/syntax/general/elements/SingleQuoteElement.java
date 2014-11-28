/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general.elements;

import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;

/**
 *
 * @author Christian
 */
public class SingleQuoteElement extends LanguageElement{
    private static final String pattern = "\'.\'";
    public SingleQuoteElement() {
        super(LanguageElementType.LITERAL, pattern);
    }    
}