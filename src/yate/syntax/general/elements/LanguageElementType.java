/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package yate.syntax.general.elements;

/**
 * Dieses Enum listet alle möglichen Typen auf, die ein SyntaxElement annehmen kann
 * @author Christian
 */
public enum LanguageElementType {
    /**
     * Literal
     */
    LITERAL("Literal"),
    /**
     * Schlüsselwort
     */
    KEYWORD("Schlüsselwort"),
    /**
     * Öffnende Klammer
     */
    OPENBRACER("Klammer"),
    /**
     * Schließende Klammer
     */
    CLOSEBRACER("Klammer"),
    /**
     * Öffnende, für die Einrückung relevante Klammer
     */
    OPENINDBRACER("Klammer"),
    /**
     * Schließende, für die Einrückung relevante Klammer
     */
    CLOSEINDBRACER("Klammer"),
    /**
     * Kommentar
     */
    COMMENT("Kommentar"),
    /**
     * Datentyp
     */
    DATATYPE("Datentyp"),
    /**
     * Bezeichner
     */
    IDENTIFIER("Bezeichner"),
    /**
     * Register (Assembler)
     */
    REGISTER("Register"),
    /**
     * Flag (Assembler)
     */
    FLAG("Flag"),
    /**
     * Mnemonic (Assembler)
     */
    MNEMONIC("Menmonic"),
    /**
     * Zahlenelement (Assembler)
     */
    NUMBER("Zahl"),
    /**
     * Präprozessordirektive
     */
    PREPROCESSOR("Präprozessor");
    
    private final String displayName;
    
    /**
     * Konstruktor, erzeugt eine neue Instanz der Klasse
     */
    private LanguageElementType(final String displayName) {
        this.displayName = displayName;
    }
    
    /**
     * Ruft den Anzeigenamen des Typs ab
     * @return Anzeigename des Typs
     */
    public String getDisplayName() {
        return displayName;
    }
    
    /**
     * Ruft die String-Präsentation des Element-Typs ab
     * @return String-Repräsentation
     */
    @Override
    public String toString() {
        return this.name();
    }    
}
