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
public class NumberElement extends LanguageElement {
    private static final String pattern = "\\b[0-9]+\\b";
            
    public NumberElement() {
        super(pattern);
    }
}
