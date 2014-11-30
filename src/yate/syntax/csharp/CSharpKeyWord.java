/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.csharp;

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
public class CSharpKeyWord extends KeyWordCollection {
    
    @Override
    protected ArrayList<? extends LanguageElement> getKeyWords() {
        return keyWords;
    }
    
    public CSharpKeyWord() {
        super(LanguageElementType.KEYWORD);
    }
    
    private static final ArrayList<? extends LanguageElement> keyWords = new ArrayList<>(Arrays.asList(
            new KeyWordElement("abstract"),
            new KeyWordElement("as"),
            new KeyWordElement("base"),
            new KeyWordElement("break"),
            new KeyWordElement("case"),
            new KeyWordElement("catch"),
            new KeyWordElement("checked"),
            new KeyWordElement("class"),
            new KeyWordElement("const"),
            new KeyWordElement("continue"),
            new KeyWordElement("default"),
            new KeyWordElement("delegate"),
            new KeyWordElement("do"),
            new KeyWordElement("else"),
            new KeyWordElement("enum"),
            new KeyWordElement("event"),
            new KeyWordElement("explicit"),
            new KeyWordElement("extern"),
            new KeyWordElement("false"),
            new KeyWordElement("finally"),
            new KeyWordElement("fixed"),
            new KeyWordElement("for"),
            new KeyWordElement("foreach"),
            new KeyWordElement("goto"),
            new KeyWordElement("if"),
            new KeyWordElement("implicit"),
            new KeyWordElement("in"),
            new KeyWordElement("interface"),
            new KeyWordElement("internal"),
            new KeyWordElement("is"),
            new KeyWordElement("lock"),
            new KeyWordElement("namespace"),
            new KeyWordElement("new"),
            new KeyWordElement("null"),
            new KeyWordElement("object"),
            new KeyWordElement("operator"),
            new KeyWordElement("out"),
            new KeyWordElement("override"),
            new KeyWordElement("params"),
            new KeyWordElement("private"),
            new KeyWordElement("protected"),
            new KeyWordElement("public"),
            new KeyWordElement("readonly"),
            new KeyWordElement("ref"),
            new KeyWordElement("return"),
            new KeyWordElement("sealed"),
            new KeyWordElement("sizeof"),
            new KeyWordElement("stackalloc"),
            new KeyWordElement("static"),
            new KeyWordElement("struct"),
            new KeyWordElement("switch"),
            new KeyWordElement("this"),
            new KeyWordElement("throw"),
            new KeyWordElement("typeof"),
            new KeyWordElement("true"),
            new KeyWordElement("try"),
            new KeyWordElement("unchecked"),
            new KeyWordElement("unsafe"),
            new KeyWordElement("using"),
            new KeyWordElement("virtual"),
            new KeyWordElement("volatile"),
            new KeyWordElement("while"),
            new KeyWordElement("unchecked"),
            new KeyWordElement("unsafe"),
            new KeyWordElement("using"),
            new KeyWordElement("virtual"),
            new KeyWordElement("volatile"),
            new KeyWordElement("while")
    ));
}
