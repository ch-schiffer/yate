/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Christian
 * Abstrakte Basisklasse für eine Sprache
 */
public abstract class Language implements Iterable<KeyWordCollection> {

    /**
     * Konstruktir
     * @param name Name der Sprache
     */
    public Language(String name) {
        this.name = name;
    }
    
    /**
     * Name der Sprache
     */
    protected String name;
    
    /**
     * Liste der Schlüsselwörter
     * @return Liste der Schlüsselwörter
     */
    protected abstract ArrayList<KeyWordCollection> getKeyWords();
        
    @Override
    public Iterator<KeyWordCollection> iterator() {
        return getKeyWords().iterator();
    }

    private String patternString = null;
    
    @Override
    public String toString() {
        if (patternString == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < getKeyWords().size(); i++) {
                sb.append(getKeyWords().get(i));
                if (i != getKeyWords().size()-1) {
                    sb.append("|");
                }
            }
            patternString = sb.toString();
        }
        return patternString;
    }
    
    /**
     * Analysiert die Syntax eines Textes und gibt eine Liste von atomaren Tokens
     * zurück
     * @param input Eingabetext
     * @return Liste von Tokens
     */
    public ArrayList<SyntaxToken> analyzeSyntax(String input)
    {
        ArrayList<SyntaxToken> tokens = new ArrayList<>();
        String pattern = this.toString();
        Pattern tokenPatterns = Pattern.compile(pattern);
        Matcher matcher = tokenPatterns.matcher(input);
        while(matcher.find())
        {
            for (KeyWordCollection token : getKeyWords()) {
                if(matcher.group(token.qualifiedName) != null) {
                    SyntaxToken newToken = new SyntaxToken(token, matcher.group(token.qualifiedName), matcher.start(), matcher.end());
                    tokens.add(newToken);
                    analysisHandler(newToken);
                    break;
                }
            }
        }
        return tokens;
    }
    
    /**
     * Gibt den erbenden Klassen die Möglichkeit, eigene Logik (wie Klammersetzung)
     * während der Analyse durchzuführen
     * @param token Letztes erzeugtes Token
     */
    protected abstract void analysisHandler(SyntaxToken token);
}
