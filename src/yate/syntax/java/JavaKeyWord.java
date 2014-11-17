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
 * Diese Klasse enthält Schlüsselwörter für Java
 * @author Christian
 */
public class JavaKeyWord extends KeyWordCollection {

    @Override
    protected ArrayList<String> getKeyWords() {
        return keyWords;
    }

    /**
     * Konstruktor
     */
    public JavaKeyWord() {
        super("JavaKeyWord", "Schlüsselwort");
    }
    
    /**
     * Liste der Schlüsselwörter
     */
    private static final ArrayList<String> keyWords = new ArrayList<>(Arrays.asList(
        "\\babstract\\b", 
        "\\bassert\\b",
        "\\bbreak\\b",
        "\\bcase\\b",
        "\\bcatch\\b",
        "\\bclass\\b",
        "\\bconst\\b",
        "\\bcontinue\\b",
        "\\bdefault\\b",
        "\\bdo\\b",
        "\\belse\\b",
        "\\benum\\b",
        "\\bextends\\b",
        "\\bfinal\\b",
        "\\bfinally\\b",
        "\\bfor\\b",
        "\\bgoto\\b",
        "\\bif\\b",
        "\\bimplements\\b",
        "\\bimport\\b",
        "\\binstanceof\\b",
        "\\binterface\\b",
        "\\bnative\\b",
        "\\bnew\\b",
        "\\bpackage\\b",
        "\\bprivate\\b",
        "\\bprotected\\b",
        "\\bpublic\\b",
        "\\bpublic\\b",
        "\\bstatic\\b",
        "\\bstrictfp\\b",
        "\\bsuper\\b",
        "\\bswitch\\b",
        "\\bsynchronized\\b",
        "\\bthis\\b",
        "\\bthrow\\b",
        "\\bthrows\\b",
        "\\btransient\\b",
        "\\btry\\b",
        "\\bvolatile\\b",
        "\\bwhile\\b",
        "\\b@Override\\b"
        ));
}
