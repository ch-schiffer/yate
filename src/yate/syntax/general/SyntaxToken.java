/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general;

/**
 * Diese Klasse enthält Informationen über ein einzelnes Token einer Sprache
 * @author Christian
 */
public class SyntaxToken {
    //Art des Tokens
    private final KeyWordCollection tokenType;
    //Inhalt (Text) des Tokens
    private final String content;
    //Paar des Tokens (nur Klammern)
    private SyntaxToken pair;
    //Beginn des Tokens im Text
    private final int start;
    //Ende des Tokens im Text
    private final int end;
    //Einrückungsebene des Tokens
    private int indentionLevel;

    /**
     * Konstruktor
     * @param tokenType Art des Tokens
     * @param content Inhalt des Tokens
     * @param start Anfangsindex des Tokens
     * @param end Endindex des Tokens
     */
    public SyntaxToken(KeyWordCollection tokenType, String content, int start, int end)
    {
        this.tokenType = tokenType;
        this.content = content;
        this.start = start;
        this.end = end;
    }

    /**
     * Setter für Pair
     * @param pair Wert
     */
    public void setPair(SyntaxToken pair) {
        this.pair = pair;
    }

    /**
     * Setter für indentionLevel 
     * @param indentionLevel Einrückungsebene
     */
    public void setIndentionLevel(int indentionLevel) {
        this.indentionLevel = indentionLevel;
    }
    
    /**
     * Getter für TokenType
     * @return TokenType
     */
    public KeyWordCollection getTokenType() {
        return tokenType;
    }

    /**
     * Getter für Content
     * @return Content
     */
    public String getContent() {
        return content;
    }
    
    /**
     * Getter für Pair
     * @return Pair
     */
    public SyntaxToken getPair() {
        return pair;
    }

    /**
     * Getter für Start
     * @return Start
     */
    public int getStart() {
        return start;
    }

    /**
     * Getter für End
     * @return End
     */
    public int getEnd() {
        return end;
    }

    /**
     * Getter für IndentionLevel
     * @return IndentionLevel
     */
    public int getIndentionLevel() {
        return indentionLevel;
    }
    
    /**
     * Gibt die Länge an
     * @return Länge
     */
    public int getLength()
    {
        return getEnd()-getStart();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indentionLevel; i++) {
            sb.append("    ");
        }
        sb.append(String.format("TYPE: %s CONTENT: %s", tokenType.getType(),content));
        return sb.toString();
    }
    
    

}
