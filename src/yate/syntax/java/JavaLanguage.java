/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.java;

import yate.syntax.cstyle.CStyleOpenBracer;
import yate.syntax.cstyle.CStyleIdentifier;
import yate.syntax.cstyle.CStyleComment;
import yate.syntax.cstyle.CStyleCloseBracer;
import yate.syntax.cstyle.CStyleLiteral;
import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.cstyle.CStyleLanguage;
import yate.syntax.general.KeyWordCollection;

/**
 *
 * Diese Klasse dient zur Analyse von Java-Syntax
 * @author Christian
 * 
 */
public class JavaLanguage extends CStyleLanguage {
    
    /**
     * Konstruktor     */     
    public JavaLanguage() {
        super("Java");
        languageSuffixList.add(".java");
    }

    @Override
    protected ArrayList<KeyWordCollection> getKeyWords() {
        return keyWords;
    }

    /**
     * Geordnete (!!!) Liste der verschiedenen Schlüsselwortarten
     */
    private static final ArrayList<KeyWordCollection> keyWords = new ArrayList<>(Arrays.asList(
       new CStyleLiteral(),
       new CStyleComment(),
       new CStyleOpenBracer(),
       new CStyleCloseBracer(),
       new JavaKeyWord(),
       new JavaDataType(),
       new CStyleIdentifier()
    ));
}
