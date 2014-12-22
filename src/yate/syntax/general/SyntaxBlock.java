/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yate.syntax.general;

/**
 * Diese Klasse bildet einen Codeblock ab, der bspw. in C durch geschweifte Klammern
 * begrenzt wird
 * @author Christian
 */
public class SyntaxBlock {
    private final int startIndex;
    private final int endIndex;
    private final int startLine;
    private final int endLine;
    private final String content;
    private String blockHeader;
    private int blockHeaderLine;
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     * @param startIndex Anfangsindex des Blocks
     * @param endIndex Endindex des Blocks
     * @param startLine Zeilennummer (Anfang)
     * @param endLine Zeilennummer (Ende)
     * @param content Inhalt (Text) des Blocks
     */
    public SyntaxBlock(int startIndex, int endIndex, int startLine, int endLine, String content) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.startLine = startLine;
        this.endLine = endLine;
        this.content = content;
    }

    /**
     * Getter Anfangsindex
     * @return Anfangsindex
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Getter Endindex
     * @return Endindex
     */
    public int getEndIndex() {
        return endIndex;
    }

    /**
     * Getter Anfangszeile
     * @return Anfangszeile
     */
    public int getStartLine() {
        return startLine;
    }

    /**
     * Getter Endzeile
     * @return Endzeile
     */
    public int getEndLine() {
        return endLine;
    }

    /**
     * Getter Inhalt
     * @return Inhalt des Blocks
     */
    public String getContent() {
        return content;
    }    
    
    /**
     * Getter für den Header des Blocks
     * @return Header
     */
    public String getBlockHeader() {
        return blockHeader;
    }

    /**
     * Legt den Header des Blocks fest
     * @param blockHeader Header
     */
    public void setBlockHeader(String blockHeader) {
        this.blockHeader = blockHeader.trim();
    }

    /**
     * Getter für die Zeile des Blockheaders
     * @return Zeile des Blockheaders
     */
    public int getBlockHeaderLine() {
        return blockHeaderLine;
    }

    /**
     * Legt die Zeile des Blockheaders fest
     * @param blockHeaderLine Zeile des Blockheaders
     */
    public void setBlockHeaderLine(int blockHeaderLine) {
        this.blockHeaderLine = blockHeaderLine;
    }    
}
