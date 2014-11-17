/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Christian
 * Abstrakte Basisklasse für eine Sammlung von Muster zur Erkennung einer
 * Gruppe von Schlüsselwörtern
 */
public abstract class KeyWordCollection implements Iterable<String> {


    /**
     * Konstruktor
     * @param qualifiedName Voll qualifizierter Name der Collection, zur eindeutigen
     * Identifikation der KeyWord-Liste
     * @param displayName Anzeigename der KeyWord-Liste auf der Oberfläche
     */
    public KeyWordCollection(String qualifiedName, String displayName) {   
        this.qualifiedName = qualifiedName;
        this.displayName = displayName;
    }
    
    /**
     * Gibt den voll qualifizierten Namen der Collection
     * an. Beispiel: "JavaComment"
     */
    protected String qualifiedName;
    
    /**
     * Gibt den Namen an, der auf der Oberfläche angezeigt werden
     * kann.
     * Beispiel: "Kommentare"
     */
    protected String displayName;

    /**
     * Getter für QualifiedName
     * @return QualifiedName
     */
    public String getQualifiedName() {
        return qualifiedName;
    }

    /**
     * Getter für DisplayName
     * @return DisplayName
     */
    public String getDisplayName() {
        return displayName;
    }
    
    /**
     * Liste der Muster, die zur Erkennung der Schlüsselwörter dienen
     * @return Liste der Muster
     */
    protected abstract ArrayList<String> getKeyWords();
    
    @Override
    public Iterator<String> iterator() {
        return getKeyWords().iterator();
    }

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
            builder.append(String.format("(?<%s>", qualifiedName));
            for (int i = 0; i < getKeyWords().size(); i++) {
                builder.append(String.format("(%s)", getKeyWords().get(i)));
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
