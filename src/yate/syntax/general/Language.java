/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.general;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import yate.autocomplete.AutoCompleteManager;
import yate.managers.ColorManager;

/**
 *
 * @author Christian
 * Abstrakte Basisklasse für eine Sprache
 */
public abstract class Language implements Iterable<KeyWordCollection> {
    
    private String patternString = null;
    private final String languageName;
    private HashMap<String,String> languageKeys = null;
    
    /**
     * Konstruktor
     * @param languageName Name der Sprache
     */
    public Language(String languageName) {
        this.languageName = languageName;
        languageSuffixList = new ArrayList<>();
        
        //Sprache trägt sich beim Erzeugen selbst in den ColorManager ein
        for (KeyWordCollection keyword : this) {
            ColorManager.getInstance().setColor(languageName+keyword.getType().toString(), Color.black);
        }
        for (String key : getDefaultColors().keySet()) {
            ColorManager.getInstance().setColor(key, getDefaultColors().get(key));
        }
    }
    
    
    /**
     * Liste der Suffixe, die für die Erkennung der Sprache benötigt werden
     */
    protected final ArrayList<String> languageSuffixList;
    
    /**
     * Getter für den Namen der Sprache
     * @return Name der Sprache
     */
    public String getLanguageName() {
        return languageName;
    }
    
    /**
     * Liste der Schlüsselwörter
     * @return Liste der Schlüsselwörter
     */
    protected abstract ArrayList<KeyWordCollection> getKeyWords();
    
    /**
     * Iterator zum iterieren über die gespeicherten Schlüsselwörter
     * @return Iterator
     */
    @Override
    public Iterator<KeyWordCollection> iterator() {
        return getKeyWords().iterator();
    }
    
    /**
     * Gibt die String-Repräsentation der Sprache zurück
     * @return String-Repräsentation
     */
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
     * @param autoCompleteManager AutoCompleteManager, in den die Vorschläge eingefügt werden sollen
     *
     */
    public final void analyzeSyntax(String input, NavigableMap<Integer, SyntaxToken> syntaxMap, AutoCompleteManager autoCompleteManager) {
        if (autoCompleteManager != null) autoCompleteManager.clearSuggestions();
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
                    if (autoCompleteManager != null) autoCompleteManager.insertSuggestion(newToken.getContent()); //Vorschlag zum AutoCompletManager hinzufügen
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
    
    /**
     * Prüft, ob ein übergebenes Suffix der Sprache entspricht
     * @param suffix Zu prüfendes Suffix
     * @return True: Suffix entspricht der Sprache
     */
    public boolean checkSuffix(String suffix) {
        return languageSuffixList.contains(suffix);
    }
    
    /**
     * Gibt eine Liste der Keys zurück, über die die Schlüsselwörter der Sprache
     * im ColorManager abgerufen werden können
     * @return Liste der Keys
     */
    public HashMap<String,String> getLanguageKeys() {
        if (languageKeys != null) return languageKeys;
        languageKeys = new HashMap<> ();
        for(KeyWordCollection keyWord : getKeyWords()) {
            languageKeys.put(getLanguageName()+keyWord.getType().getDisplayName(),keyWord.getType().getDisplayName());
        }
        return languageKeys;
    }
    
    /**
     * Gibt eine Liste der Standard-Farben für die Sprache zurück
     * @return Liste der Standard-Sprachen
     */
    public abstract HashMap<String, Color> getDefaultColors();
}
