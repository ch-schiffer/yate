/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Christian
 * Abstrakte Basisklasse für eine Sprache
 */
public abstract class Language implements Iterable<KeyWordCollection> {

    /**
     * Konstruktor
     */
    public Language() {
    }
    
    public static String languageName;
    
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
     * @param syntaxMap Map, in die Tokens gespeichert werden
     * 
     */
    public final void analyzeSyntax(String input, NavigableMap<Integer, SyntaxToken> syntaxMap)
    {        
        syntaxMap.clear();  //Map leeren
        resetLanguage();    //Sprachspezifisch aufräumen
        String pattern = this.toString();
        Pattern tokenPatterns = Pattern.compile(pattern);
        Matcher matcher = tokenPatterns.matcher(input);
        while(matcher.find())
        {
            for (KeyWordCollection token : getKeyWords()) {
                if(matcher.group(token.getType().toString()) != null) {
                    SyntaxToken newToken = new SyntaxToken(token, matcher.group(token.getType().toString()), matcher.start(), matcher.end());
                    syntaxMap.put(newToken.getStart(), newToken);   //In Syntaxmap eintragen
                    analysisHandler(newToken);  //Sprachspezifische Abhandlungen
                    break;
                }
            }
        }
    }
    
    /**
     * Gibt den erbenden Klassen die Möglichkeit, eigene Logik (wie Klammersetzung)
     * während der Analyse durchzuführen
     * @param token Letztes erzeugtes Token
     */
    protected abstract void analysisHandler(SyntaxToken token);
    
    /**
     * Dient dazu, Sprachen mit eigenen Ressourcen eine Möglichkeit zu geben,
     * diese zurückzusetzen, wenn eine neue Analyse beginnt.
     */
    protected void resetLanguage() { }
}
