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
public class CStyleMultilineCommentElement extends LanguageElement {
    private static final String pattern = "(?s)\\/\\*((?!(\\/\\*\\*)|(\\*\\/)).)*\\*\\/";
    
    public CStyleMultilineCommentElement() {
        super(LanguageElementType.COMMENT, pattern);
    }
    
}
