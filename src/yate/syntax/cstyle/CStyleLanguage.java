/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.cstyle;

import java.util.Stack;
import yate.syntax.general.ICloseBracer;
import yate.syntax.general.IOpenBracer;
import yate.syntax.general.Language;
import yate.syntax.general.SyntaxToken;

/**
 *
 * @author Christian
 */
public abstract class CStyleLanguage extends Language {

    /**
    * Stack zur Verwaltung der Klammern
    */
    private final Stack<SyntaxToken> bracesStack;

    
    public CStyleLanguage() {
        bracesStack = new Stack<>();
    }

    @Override
    protected void analysisHandler(SyntaxToken token) {
        if (token == null) throw new IllegalArgumentException("token is null");
        
        //Einrückungsebene für jedes Token setzen
        token.setIndentionLevel(bracesStack.size());
        
        //Öffnende Klammer
        if (token.getTokenType() instanceof IOpenBracer)
        {
            bracesStack.push(token);
            token.setIndentionLevel(bracesStack.size());
        }        
        //Schließende Klammer
        else if (token.getTokenType() instanceof ICloseBracer)
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

}
