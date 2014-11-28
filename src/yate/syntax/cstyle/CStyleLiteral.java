/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.cstyle;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.elements.DoubleQuoteElement;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;
import yate.syntax.general.elements.SingleQuoteElement;

/**
 *
 * @author Christian
 */
public class CStyleLiteral extends KeyWordCollection {

    @Override
    protected ArrayList<? extends LanguageElement> getKeyWords() {
        return keyWords;
    }

    public CStyleLiteral() {
        super(LanguageElementType.LITERAL);
    }
    
    private static final ArrayList<? extends LanguageElement> keyWords = new ArrayList<>(Arrays.asList(
            new DoubleQuoteElement(),
            new SingleQuoteElement()
            ));
    
}
