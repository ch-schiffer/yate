/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.cstyle;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.elements.CStyleMultilineCommentElement;
import yate.syntax.general.elements.CStyleSingleLineCommentElement;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;

/**
 *
 * @author Christian
 */
public class CStyleComment extends KeyWordCollection {

    @Override
    protected ArrayList<? extends LanguageElement> getKeyWords() {
        return keyWords;
    }

    public CStyleComment() {
        super(LanguageElementType.COMMENT);
    }
    
    private static final ArrayList<? extends LanguageElement> keyWords = new ArrayList<>(Arrays.asList(
            new CStyleSingleLineCommentElement(),
            new CStyleMultilineCommentElement()
            ));    
}


