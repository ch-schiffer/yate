/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general;

import java.util.Objects;

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
     * Gibt die Länge an
     * @return Länge
     */
    public int getLength()
    {
        return getEnd()-getStart();
    }

    /**
     * Gibt eine String-Repräsentation des Syntax-Tokens zurück
     * @return String-Repräsentation des Syntax-Tokens
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        /*for (int i = 0; i < indentionLevel; i++) {
            sb.append("    ");
        }*/
        sb.append(String.format("TYPE: %s CONTENT: %s", tokenType.getType(),content));
        return sb.toString();
    }

    /**
     * Gibt einen Hashcode zurück
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.content);
        hash = 41 * hash + this.start;
        hash = 41 * hash + this.end;
        return hash;
    }

    /**
     * Prüft, ob ein übergebenes Objekt mit dem aktuellen Objekt identisch ist
     * @param obj Anderes Objekt
     * @return True: Identisch
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SyntaxToken other = (SyntaxToken) obj;
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        if (this.start != other.start) {
            return false;
        }
        if (this.end != other.end) {
            return false;
        }
        return true;
    }
}
