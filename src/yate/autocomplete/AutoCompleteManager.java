/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.autocomplete;

import java.util.TreeSet;

/**
 * Diese Klasse sammelt Vorschläge zum Vorblenden in der Auto-Vervollständigung
 * @author Christian
 */
public class AutoCompleteManager {
    
    private final TreeSet<String> suggestions = new TreeSet<>();
    
    /**
     * Fügt einen neuen Vorschlag zur Liste der Vorschläge hinzu
     * @param suggestion Hinzuzufügender Vorschlag
     */
    public void insertSuggestion(String suggestion) {
        String[] words = suggestion.split(" ");
        for (String word : words) {
            if (word.length() > 2) {
                suggestions.add(suggestion);
            }
        }
    }

    /**
     * Ruft die bisher gesammelten Vorschläge ab
     * @return Liste der Vorschläge
     */
    public TreeSet<String> getSuggestions() {        
        return suggestions;
    }
    
    /**
     * Löscht alle bisher gesammelten Vorschläge in der Liste
     */
    public void clearSuggestions() {
        suggestions.clear();
    }
    
    
}
