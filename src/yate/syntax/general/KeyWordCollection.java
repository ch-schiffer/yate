/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general;

import yate.syntax.general.elements.LanguageElement;
import java.util.ArrayList;
import yate.syntax.general.elements.LanguageElementType;

/**
 *
 * @author Christian
 * Abstrakte Basisklasse für eine Sammlung von Muster zur Erkennung einer
 * Gruppe von Schlüsselwörtern
 */
public abstract class KeyWordCollection {
    public KeyWordCollection(LanguageElementType type) {   
        this.type = type;
    }

    public LanguageElementType getType() {
        return type;
    }
    
    protected final LanguageElementType type;

    /**
     * Liste der Muster, die zur Erkennung der Schlüsselwörter dienen
     * @return Liste der Muster
     */
    protected abstract ArrayList<? extends LanguageElement> getKeyWords();
    
    /**
     * Singelton Instanz für das Muster der Collection
     */
    private String patternString = null;
    
    @Override
    public String toString() {
        //Pattern wird nur beim ersten Zugriff generiert
        if (patternString == null)
        {
            StringBuilder builder = new StringBuilder();
            //Gruppenname festlegen
            builder.append(String.format("(?<%s>", type));
            for (int i = 0; i < getKeyWords().size(); i++) {
                builder.append(String.format("(%s)", getKeyWords().get(i).getElementPattern()));
                if (i != getKeyWords().size()-1)
                {
                    //Wenn nicht letztes Element, "OR" verknüpfen
                    builder.append("|");
                }
            }
            //Gruppe schließen
            builder.append(")");
            patternString = builder.toString();
        }
        return patternString;
    }
    
    
    
    
}
