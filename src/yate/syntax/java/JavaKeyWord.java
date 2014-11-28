/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.java;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.KeyWordElement;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;

/**
 * Diese Klasse enthält Schlüsselwörter für Java
 * @author Christian
 */
public class JavaKeyWord extends KeyWordCollection {

    @Override
    protected ArrayList<? extends LanguageElement> getKeyWords() {
        return keyWords;
    }

    /**
     * Konstruktor
     */
    public JavaKeyWord() {
        super(LanguageElementType.KEYWORD);
    }
    
    /**
     * Liste der Schlüsselwörter
     */
    private static final ArrayList<? extends LanguageElement> keyWords = new ArrayList<>(Arrays.asList(
            new KeyWordElement("abstract"),
            new KeyWordElement("assert"),
            new KeyWordElement("break"),
            new KeyWordElement("case"),
            new KeyWordElement("catch"),
            new KeyWordElement("class"),
            new KeyWordElement("const"),
            new KeyWordElement("continue"),
            new KeyWordElement("default"),
            new KeyWordElement("do"),
            new KeyWordElement("else"),
            new KeyWordElement("enum"),
            new KeyWordElement("extends"),
            new KeyWordElement("final"),
            new KeyWordElement("for"),
            new KeyWordElement("goto"),
            new KeyWordElement("if"),
            new KeyWordElement("implements"),
            new KeyWordElement("import"),
            new KeyWordElement("instanceof"),
            new KeyWordElement("interface"),
            new KeyWordElement("native"),
            new KeyWordElement("new"),
            new KeyWordElement("package"),
            new KeyWordElement("private"),
            new KeyWordElement("protected"),
            new KeyWordElement("public"),
            new KeyWordElement("static"),
            new KeyWordElement("super"),
            new KeyWordElement("switch"),
            new KeyWordElement("synchronized"),
            new KeyWordElement("this"),
            new KeyWordElement("throws"),
            new KeyWordElement("throw"),
            new KeyWordElement("transient"),
            new KeyWordElement("try"),
            new KeyWordElement("volatile"),
            new KeyWordElement("while"),
            new KeyWordElement("\\@Override")
        ));
}
