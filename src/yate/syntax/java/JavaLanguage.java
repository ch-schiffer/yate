/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import yate.syntax.general.IImplementBracerLogic;
import yate.syntax.general.KeyWordCollection;
import yate.syntax.general.Language;
import yate.syntax.general.SyntaxToken;

/**
 *
 * Diese Klasse dient zur Analyse von Java-Syntax
 * @author Christian
 * 
 */
public class JavaLanguage extends Language implements IImplementBracerLogic {
    
    /**
     * Stack zur Verwaltung der Klammern
     */
    private final Stack<SyntaxToken> bracesStack;
    
    /**
     * Konstruktor
     */
    public JavaLanguage() {
        super("Java");
        bracesStack = new Stack<>();
    }

    @Override
    protected ArrayList<KeyWordCollection> getKeyWords() {
        return keyWords;
    }

    @Override
    protected void analysisHandler(SyntaxToken token) {
        if (token == null) throw new IllegalArgumentException("token is null");
        
        //Einrückungsebene für jedes Token setzen
        token.setIndentionLevel(bracesStack.size());
        
        //Öffnende Klammer
        if (token.getTokenType() instanceof JavaOpenBracer)
        {
            bracesStack.push(token);            
            token.setIndentionLevel(bracesStack.size());
        }        
        //Schließende Klammer
        else if (token.getTokenType() instanceof JavaCloseBracer)
        {
            if (bracesStack.size() == 0) return;
            String content = token.getContent();
            String stackTop = bracesStack.peek().getContent();
            //Passen die Klammern?
            if ((stackTop.equals("(") && content.equals(")")) || (stackTop.equals("{") && content.equals("}"))
                    || (stackTop.equals("[") && content.equals("]"))) {
                                       
                        //Klammer entfernen
                        SyntaxToken open = bracesStack.pop();
                        //Paarweise eintragen
                        open.setPair(token);
                        token.setPair(open);
                        //Einrückungslevel setzen
                        token.setIndentionLevel(open.getIndentionLevel()*(-1));
            }            
        }
    }

    @Override
    protected void resetLanguage() {
        //Klammernstack leeren
        bracesStack.clear();
    }   
    
    
    /**
     * Geordnete (!!!) Liste der verschiedenen Schlüsselwortarten
     */
    private static final ArrayList<KeyWordCollection> keyWords = new ArrayList<>(Arrays.asList(
       new JavaLiteral(),
       new JavaComment(),
       new JavaOpenBracer(),
       new JavaCloseBracer(),
       new JavaKeyWord(),
       new JavaDataType(),
       new JavaIdentifier()
    ));
}
