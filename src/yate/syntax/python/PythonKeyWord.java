/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.python;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.KeyWordElement;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;

/**
 *
 * @author Christian
 */
public class PythonKeyWord extends KeyWordCollection {

    public PythonKeyWord() {
        super(LanguageElementType.KEYWORD);
    }
    @Override
    protected ArrayList<? extends LanguageElement> getKeyWords() {
        return keyWords;
    }
    
        private static final ArrayList<? extends LanguageElement> keyWords = new ArrayList<>(Arrays.asList(
            new KeyWordElement("del"),
            new KeyWordElement("elif"),
            new KeyWordElement("else"),
            new KeyWordElement("except"),
            new KeyWordElement("exec"),
            new KeyWordElement("finally"),
            new KeyWordElement("for"),
            new KeyWordElement("from"),
            new KeyWordElement("global"),
            new KeyWordElement("if"),
            new KeyWordElement("import"),
            new KeyWordElement("in"),
            new KeyWordElement("is"),
            new KeyWordElement("lambda"),
            new KeyWordElement("and"),
            new KeyWordElement("as"),
            new KeyWordElement("assert"),
            new KeyWordElement("break"),
            new KeyWordElement("class"),
            new KeyWordElement("continue"),
            new KeyWordElement("def"),
            new KeyWordElement("not"),
            new KeyWordElement("or"),
            new KeyWordElement("pass"),
            new KeyWordElement("print"),
            new KeyWordElement("raise"),
            new KeyWordElement("return"),
            new KeyWordElement("try"),
            new KeyWordElement("while"),
            new KeyWordElement("with"),
            new KeyWordElement("yield")
    ));    
}
