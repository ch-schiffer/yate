/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.c;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.cstyle.CStyleCloseBracer;
import yate.syntax.cstyle.CStyleComment;
import yate.syntax.cstyle.CStyleIdentifier;
import yate.syntax.cstyle.CStyleLanguage;
import yate.syntax.cstyle.CStyleLiteral;
import yate.syntax.cstyle.CStyleOpenBracer;
import yate.syntax.general.KeyWordCollection;

/**
 *
 * @author Christian
 */
public class CLanguage extends CStyleLanguage {

    public CLanguage() {
        super();
        languageName = "C";
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
       new CStyleIdentifier()
    ));

    
}