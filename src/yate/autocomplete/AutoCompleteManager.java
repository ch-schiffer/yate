/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.autocomplete;

import java.util.TreeSet;

/**
 *
 * @author Christian
 */
public class AutoCompleteManager {
    private final TreeSet<String> suggestions = new TreeSet<>();
    
    public void insertSuggestion(String suggestion) {
        String[] words = suggestion.split(" ");
        for (String word : words) {
            if (word.length() > 2) {
                suggestions.add(suggestion);
            }
        }
    }

    public TreeSet<String> getSuggestions() {        
        return suggestions;
    }
    
    public void clearSuggestions() {
        suggestions.clear();
    }
    
    
}
