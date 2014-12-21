/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.cpp;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.elements.KeyWordElement;
import yate.syntax.general.elements.LanguageElement;
import yate.syntax.general.elements.LanguageElementType;

/**
 * Diese Klasse listet die Schlüsselwörter auf, die von C++ unterstützt werden
 * @author Christian
 */
public class CPPKeyWord extends KeyWordCollection {
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    public CPPKeyWord() {
        super(LanguageElementType.KEYWORD);
    }
    
    /**
     * Gibt eine Liste der Schlüsselwörter zurück
     * @return Liste der Schlüsselwörter
     */
    @Override
    protected ArrayList<? extends LanguageElement> getKeyWords() {
        return keyWords;
    }
    
    private static final ArrayList<? extends LanguageElement> keyWords = new ArrayList<>(Arrays.asList(
            new KeyWordElement("alignas"),
            new KeyWordElement("alignof"),
            new KeyWordElement("and"),
            new KeyWordElement("and_eq"),
            new KeyWordElement("asm"),
            new KeyWordElement("auto"),
            new KeyWordElement("bitand"),
            new KeyWordElement("bitor"),
            new KeyWordElement("break"),
            new KeyWordElement("case"),
            new KeyWordElement("catch"),
            new KeyWordElement("class"),
            new KeyWordElement("compl"),
            new KeyWordElement("const"),
            new KeyWordElement("constexpr"),
            new KeyWordElement("const_cast"),
            new KeyWordElement("continue"),
            new KeyWordElement("decltype"),
            new KeyWordElement("default"),
            new KeyWordElement("delete"),
            new KeyWordElement("do"),
            new KeyWordElement("else"),
            new KeyWordElement("enum"),
            new KeyWordElement("explicit"),
            new KeyWordElement("dynamic_cast"),
            new KeyWordElement("extern"),
            new KeyWordElement("false"),
            new KeyWordElement("for"),
            new KeyWordElement("friend"),
            new KeyWordElement("goto"),
            new KeyWordElement("if"),
            new KeyWordElement("inline"),
            new KeyWordElement("mutable"),
            new KeyWordElement("namespace"),
            new KeyWordElement("new"),
            new KeyWordElement("noexcept"),
            new KeyWordElement("not"),
            new KeyWordElement("not_eq"),
            new KeyWordElement("nullptr"),
            new KeyWordElement("operator"),
            new KeyWordElement("or"),
            new KeyWordElement("or_eq"),
            new KeyWordElement("private"),
            new KeyWordElement("protected"),
            new KeyWordElement("public"),
            new KeyWordElement("register"),
            new KeyWordElement("reinterpret_cast"),
            new KeyWordElement("return"),
            new KeyWordElement("sizeof"),
            new KeyWordElement("static"),
            new KeyWordElement("static_assert"),
            new KeyWordElement("static_cast"),
            new KeyWordElement("struct"),
            new KeyWordElement("switch"),
            new KeyWordElement("template"),
            new KeyWordElement("this"),
            new KeyWordElement("thread_local"),
            new KeyWordElement("throw"),
            new KeyWordElement("true"),
            new KeyWordElement("try"),
            new KeyWordElement("typedef"),
            new KeyWordElement("typeid"),
            new KeyWordElement("typename"),
            new KeyWordElement("union"),
            new KeyWordElement("using"),
            new KeyWordElement("virtual"),
            new KeyWordElement("volatile"),
            new KeyWordElement("while"),
            new KeyWordElement("xor"),
            new KeyWordElement("xor_eq"),
            new KeyWordElement("export")
    ));
}
