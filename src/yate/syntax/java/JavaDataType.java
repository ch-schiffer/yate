/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.java;

import java.util.ArrayList;
import java.util.Arrays;
import yate.syntax.general.KeyWordCollection;

/**
 *
 * @author Christian
 */
public class JavaDataType extends KeyWordCollection {

    @Override
    protected ArrayList<String> getKeyWords() {
        return keyWords;
    }

    public JavaDataType() {
        super("JavaDataType", "Datentyp");
    }
    
     private static final ArrayList<String> keyWords = new ArrayList<>(Arrays.asList(
             "\\bboolean\\b",
            "\\bbyte\\b",
            "\\bchar\\b",        
            "\\bdouble\\b",
             "\\bfloat\\b",
             "\\bint\\b",
             "\\blong\\b",
             "\\bshort\\b",
             "\\bvoid\\b",
             "\\btrue\\b",
             "\\bfalse\\b"
            ));
    
}
