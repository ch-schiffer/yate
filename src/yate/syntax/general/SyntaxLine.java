/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general;

/**
 * Diese Klasse bildet eine Codezeile ab
 * @author Christian
 */
public class SyntaxLine {
    private final int startIndex;
    private final int endIndex;
    private final int lineNumber;
    private final String content;

    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     * @param startIndex Anfangsindex der Zeile
     * @param endIndex Endindex der Zeile
     * @param lineNumber Zeilennummer
     * @param content Inhalt der Zeile
     */
    public SyntaxLine(int startIndex, int endIndex, int lineNumber, String content) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.lineNumber = lineNumber;
        this.content = content;
    }

    /**
     * Getter für den Startindex der Zeile
     * @return Startindex der Zeile
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Getter für den Endindex der Zeile
     * @return Endindex der Zeile
     */
    public int getEndIndex() {
        return endIndex;
    }

    /**
     * Getter für den Inhalt der Zeile
     * @return Inhalt der Zeile
     */
    public String getContent() {
        return content;
    }    

    /**
     * Getter für die Zeilennummer
     * @return Zeilennummer
     */
    public int getLineNumber() {
        return lineNumber;
    }    
}
