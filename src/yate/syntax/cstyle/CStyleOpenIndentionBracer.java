/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.cstyle;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.IIndentionBracer;
import yate.syntax.general.IOpenBracer;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;
import yate.syntax.general.elements.OpenIndentionBracerElement;

/**
 *
 * @author Christian
 */
public class CStyleOpenIndentionBracer extends KeyWordCollection implements IOpenBracer, IIndentionBracer {
    
    public CStyleOpenIndentionBracer() {
        super(LanguageElementType.OPENINDBRACER);
    }

    @Override
    protected ArrayList<? extends LanguageElement> getKeyWords() {
        return keyWords;
    }
    
    private static final ArrayList<? extends LanguageElement> keyWords = new ArrayList<>(Arrays.asList(
            new OpenIndentionBracerElement("{")
            )); 
}
