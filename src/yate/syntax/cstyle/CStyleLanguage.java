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
 * Diese Klasse bietet Funktionen zur Analyse von Sprachen, die in ihrem Stil
 * der Sprache C ähneln (z.B. C++, C# etc.)
 * @author Christian
 */
public abstract class CStyleLanguage extends Language {
    
    /**
     * Stack zur Verwaltung der Klammern
     */
    private final Stack<SyntaxToken> bracesStack;
    
    /**
     * Konstruktor, erzeugt eine Instanz der Klasse
     * @param languageName Name der Sprache
     */
    public CStyleLanguage(String languageName) {
        super(languageName);
        bracesStack = new Stack<>();
    }
    
    
    /**
     * Diese Funktion wird aufgerufen, während die Syntaxanalyse läuft und verwaltet
     * den Stack, mit dem die Klammersetzung gesteuert wird
     * @param token Aktuell behandeltes Token
     */
    @Override
    protected void analysisHandler(SyntaxToken token) {
        if (token == null) throw new IllegalArgumentException("token is null");
        
        //Öffnende Klammer
        if (token.getTokenType() instanceof IOpenBracer)
        {
            bracesStack.push(token);
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
            }
        }
    }
    
    /**
     * Setzt den Klammernstapel zurück
     */
    @Override
    protected void resetLanguage() {
        //Klammernstack leeren
        bracesStack.clear();
    }
    
}
