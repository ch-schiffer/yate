/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Liste aus Zeilenelementen
 * @author Christian
 */
public class SyntaxLineList implements Iterable<SyntaxLine> {
    private final TreeMap<Integer,SyntaxLine> lines = new TreeMap<>();
    private int currentLine = 0;

    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    public SyntaxLineList() {
    }     
    
    /**
     * Fügt eine neue Zeile hinzu
     * @param startIndex Startindex der Zeile
     * @param endIndex Endindex der Zeile
     * @param content Inhalt der Zeile
     */
    public void addLine(int startIndex, int endIndex, String content) {
        SyntaxLine newSyntaxLine = new SyntaxLine(startIndex, endIndex, currentLine++, content);
        lines.put(startIndex, newSyntaxLine);
    }
    
    /**
     * Ruft die Zeile mit der übergenenen Nummer ab
     * @param line Zeilennummer
     * @return Zeile mit der übergebenen Nummer, bzw. null, wenn diese nicht existiert
     */
    public SyntaxLine getLine(int line) {
        if (line >= lines.size() || line < 0) return null;
        return new ArrayList<>(lines.values()).get(line);
    }
    
    /**
     * Ruft die Zeile an dem übergebenene Index ab
     * @param index Index
     * @return Zeile am übergebenene Index
     */
    public SyntaxLine getLineAtIndex(int index) {
        return lines.floorEntry(index).getValue();
    }
    
    /**
     * Gibt eine Subliste ab, die alle Zeilen vom Start- bis zum Endindex enthält
     * @param startIndex Startindex
     * @param endIndex Endindex
     * @return Subliste
     */
    public SyntaxLineList subList(int startIndex, int endIndex) {
        SyntaxLineList subList = new SyntaxLineList();
        for (SyntaxLine line : lines.subMap(startIndex, endIndex).values()) {
            subList.addLine(line.getStartIndex(), line.getEndIndex(), line.getContent());
        }
        return subList;
    }
    
    /**
     * Leert die Liste
     */
    public void clear() {
        currentLine = 0;
        lines.clear();
    }

    /**
     * Gibt einen Iterator zurück
     * @return Iterator
     */
    @Override
    public Iterator<SyntaxLine> iterator() {
        return lines.values().iterator();
    }
}
